package com.tencent.plato.network;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import com.tencent.plato.core.IFunction;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;

public class PlatoCookieHandler
  extends CookieHandler
{
  private static final String COOKIE_HEADER = "Cookie";
  private static final boolean USES_LEGACY_STORE;
  private static final String VERSION_ONE_HEADER = "Set-cookie2";
  private static final String VERSION_ZERO_HEADER = "Set-cookie";
  private final Context mContext;
  @Nullable
  private CookieManager mCookieManager;
  private final CookieSaver mCookieSaver;
  
  static
  {
    if (Build.VERSION.SDK_INT < 21) {}
    for (boolean bool = true;; bool = false)
    {
      USES_LEGACY_STORE = bool;
      return;
    }
  }
  
  public PlatoCookieHandler(Context paramContext)
  {
    this.mContext = paramContext;
    this.mCookieSaver = new CookieSaver();
  }
  
  @TargetApi(21)
  private void addCookieAsync(String paramString1, String paramString2)
  {
    getCookieManager().setCookie(paramString1, paramString2, null);
  }
  
  private void addCookies(final String paramString, final List<String> paramList)
  {
    if (USES_LEGACY_STORE)
    {
      runInBackground(new Runnable()
      {
        public void run()
        {
          Iterator localIterator = paramList.iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            PlatoCookieHandler.this.getCookieManager().setCookie(paramString, str);
          }
          PlatoCookieHandler.this.mCookieSaver.onCookiesModified();
        }
      });
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      addCookieAsync(paramString, (String)paramList.next());
    }
    this.mCookieSaver.onCookiesModified();
  }
  
  @RequiresApi(api=21)
  private void clearCookiesAsync(final IFunction paramIFunction)
  {
    getCookieManager().removeAllCookies(new ValueCallback()
    {
      public void onReceiveValue(Boolean paramAnonymousBoolean)
      {
        PlatoCookieHandler.this.mCookieSaver.onCookiesModified();
        paramIFunction.invoke(new Object[] { paramAnonymousBoolean });
      }
    });
  }
  
  private CookieManager getCookieManager()
  {
    if (this.mCookieManager == null)
    {
      possiblyWorkaroundSyncManager(this.mContext);
      this.mCookieManager = CookieManager.getInstance();
      if (USES_LEGACY_STORE) {
        this.mCookieManager.removeExpiredCookie();
      }
    }
    return this.mCookieManager;
  }
  
  private static boolean isCookieHeader(String paramString)
  {
    return (paramString.equalsIgnoreCase("Set-cookie")) || (paramString.equalsIgnoreCase("Set-cookie2"));
  }
  
  private static void possiblyWorkaroundSyncManager(Context paramContext)
  {
    if (USES_LEGACY_STORE) {
      CookieSyncManager.createInstance(paramContext).sync();
    }
  }
  
  private void runInBackground(final Runnable paramRunnable)
  {
    AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable()
    {
      public void run()
      {
        paramRunnable.run();
      }
    });
  }
  
  public void clearCookies(final IFunction paramIFunction)
  {
    if (USES_LEGACY_STORE)
    {
      runInBackground(new Runnable()
      {
        public void run()
        {
          PlatoCookieHandler.this.getCookieManager().removeAllCookie();
          PlatoCookieHandler.this.mCookieSaver.onCookiesModified();
          paramIFunction.invoke(new Object[] { Boolean.valueOf(true) });
        }
      });
      return;
    }
    clearCookiesAsync(paramIFunction);
  }
  
  public void destroy()
  {
    if (USES_LEGACY_STORE)
    {
      getCookieManager().removeExpiredCookie();
      this.mCookieSaver.persistCookies();
    }
  }
  
  public Map<String, List<String>> get(URI paramURI, Map<String, List<String>> paramMap)
    throws IOException
  {
    paramURI = getCookieManager().getCookie(paramURI.toString());
    if (TextUtils.isEmpty(paramURI)) {
      return Collections.emptyMap();
    }
    return Collections.singletonMap("Cookie", Collections.singletonList(paramURI));
  }
  
  public void put(URI paramURI, Map<String, List<String>> paramMap)
    throws IOException
  {
    paramURI = paramURI.toString();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      String str = (String)localEntry.getKey();
      if ((str != null) && (isCookieHeader(str))) {
        addCookies(paramURI, (List)localEntry.getValue());
      }
    }
  }
  
  private class CookieSaver
  {
    private static final int MSG_PERSIST_COOKIES = 1;
    private static final int TIMEOUT = 30000;
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        if (paramAnonymousMessage.what == 1)
        {
          PlatoCookieHandler.CookieSaver.this.persistCookies();
          return true;
        }
        return false;
      }
    });
    
    CookieSaver() {}
    
    @TargetApi(21)
    private void flush()
    {
      PlatoCookieHandler.this.getCookieManager().flush();
    }
    
    void onCookiesModified()
    {
      if (PlatoCookieHandler.USES_LEGACY_STORE) {
        this.mHandler.sendEmptyMessageDelayed(1, 30000L);
      }
    }
    
    void persistCookies()
    {
      this.mHandler.removeMessages(1);
      PlatoCookieHandler.this.runInBackground(new Runnable()
      {
        public void run()
        {
          if (PlatoCookieHandler.USES_LEGACY_STORE)
          {
            CookieSyncManager.getInstance().sync();
            return;
          }
          PlatoCookieHandler.CookieSaver.this.flush();
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.network.PlatoCookieHandler
 * JD-Core Version:    0.7.0.1
 */