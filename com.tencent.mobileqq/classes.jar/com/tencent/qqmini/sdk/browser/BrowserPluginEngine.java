package com.tencent.qqmini.sdk.browser;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.webkit.WebView;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BrowserPluginEngine
{
  private static final String TAG = "BrowserPluginEngine";
  public Activity mActivity;
  Fragment mBrowserFragment;
  private volatile WebView mWebview;
  private final ConcurrentHashMap<String, BrowserPlugin> pluginEventHashMap = new ConcurrentHashMap();
  private final ConcurrentHashMap<String, BrowserPlugin> pluginHashMap = new ConcurrentHashMap();
  
  public BrowserPluginEngine(Activity paramActivity, WebView paramWebView)
  {
    this.mActivity = paramActivity;
    this.mWebview = paramWebView;
    preCreatePlugin();
  }
  
  private BrowserPlugin createPlugin(String paramString)
  {
    BrowserPlugin localBrowserPlugin = BrowserPluginFactory.createWebViewPlugin(paramString);
    insertPlugin(paramString, localBrowserPlugin);
    initPlugin(localBrowserPlugin);
    return localBrowserPlugin;
  }
  
  private static boolean handleJsBridgeUrlRequest(BrowserPluginEngine paramBrowserPluginEngine, WebView paramWebView, String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("/#");
    Object localObject3 = ((StringBuilder)localObject1).toString().split("/");
    if (localObject3.length < 5)
    {
      paramBrowserPluginEngine = new StringBuilder();
      paramBrowserPluginEngine.append("illegal jsbridge:");
      paramBrowserPluginEngine.append(paramString);
      QMLog.e("BrowserPluginEngine", paramBrowserPluginEngine.toString());
      return true;
    }
    String str = localObject3[2];
    int j = localObject3.length;
    int i = 0;
    Object localObject2;
    if (j == 5)
    {
      localObject1 = localObject3[3].split("#");
      if (localObject1.length > 1) {
        try
        {
          Integer.parseInt(localObject1[1]);
        }
        catch (NumberFormatException paramBrowserPluginEngine)
        {
          paramWebView = new StringBuilder();
          paramWebView.append("");
          localObject1 = new StringBuilder("illegal jsbridge[");
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append("] error:");
          ((StringBuilder)localObject1).append(paramBrowserPluginEngine.toString());
          paramWebView.append(localObject1);
          QMLog.e("BrowserPluginEngine", paramWebView.toString());
          return true;
        }
      }
      localObject1 = localObject1[0].split("\\?");
      localObject3 = localObject1[0];
      if (localObject1.length > 1)
      {
        String[] arrayOfString = localObject1[1].split("&");
        localObject1 = arrayOfString;
        localObject2 = localObject3;
        if (arrayOfString.length > 0)
        {
          localObject1 = new ArrayList();
          j = arrayOfString.length;
          i = 0;
          while (i < j)
          {
            int k = arrayOfString[i].indexOf('=');
            if (k != -1)
            {
              if (!"mqq_tt".equals(arrayOfString[i].substring(0, k)))
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append(str);
                ((StringBuilder)localObject2).append(".");
                ((StringBuilder)localObject2).append((String)localObject3);
                ((StringBuilder)localObject2).toString();
                ((List)localObject1).add(URLDecoder.decode(arrayOfString[i].substring(k + 1)));
              }
            }
            else {
              ((List)localObject1).add("");
            }
            i += 1;
          }
          localObject1 = (String[])((List)localObject1).toArray(new String[((List)localObject1).size()]);
          localObject2 = localObject3;
        }
      }
      else
      {
        localObject1 = new String[0];
        localObject2 = localObject3;
      }
    }
    else
    {
      localObject2 = localObject3[3];
    }
    try
    {
      Long.parseLong(localObject3[4]);
      j = localObject3.length - 6;
      localObject1 = new String[j];
      System.arraycopy(localObject3, 5, localObject1, 0, j);
      j = localObject1.length;
      while (i < j)
      {
        localObject1[i] = URLDecoder.decode(localObject1[i]);
        i += 1;
      }
      paramWebView.getUrl();
      paramWebView = new StringBuilder();
      paramWebView.append(str);
      paramWebView.append(".");
      paramWebView.append((String)localObject2);
      paramWebView.toString();
      localObject3 = paramBrowserPluginEngine.getPluginByNameSpace(str);
      paramWebView = (WebView)localObject3;
      if (localObject3 == null) {
        paramWebView = paramBrowserPluginEngine.createPlugin(str);
      }
      if (paramWebView != null) {
        handleJsRequest(paramWebView, paramString, str, (String)localObject2, (String[])localObject1);
      }
      return true;
    }
    catch (Exception paramBrowserPluginEngine)
    {
      paramWebView = new StringBuilder();
      paramWebView.append("");
      localObject1 = new StringBuilder("illegal jsbridge[");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("] error:");
      ((StringBuilder)localObject1).append(paramBrowserPluginEngine.toString());
      paramWebView.append(localObject1);
      QMLog.e("BrowserPluginEngine", paramWebView.toString());
    }
    return true;
  }
  
  /* Error */
  private static boolean handleJsRequest(BrowserPlugin paramBrowserPlugin, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: invokestatic 187	java/lang/System:currentTimeMillis	()J
    //   9: lstore 5
    //   11: aload_0
    //   12: aload_1
    //   13: aload_2
    //   14: aload_3
    //   15: aload 4
    //   17: invokevirtual 192	com/tencent/qqmini/sdk/browser/BrowserPlugin:handleJsRequest	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z
    //   20: istore 9
    //   22: iload 9
    //   24: ifeq +129 -> 153
    //   27: invokestatic 187	java/lang/System:currentTimeMillis	()J
    //   30: lstore 7
    //   32: invokestatic 196	com/tencent/qqmini/sdk/launcher/log/QMLog:isColorLevel	()Z
    //   35: ifeq +359 -> 394
    //   38: new 61	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   45: astore_1
    //   46: aload_1
    //   47: ldc 98
    //   49: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: new 61	java/lang/StringBuilder
    //   56: dup
    //   57: ldc 198
    //   59: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   62: astore 4
    //   64: aload 4
    //   66: aload_0
    //   67: invokevirtual 202	java/lang/Object:getClass	()Ljava/lang/Class;
    //   70: invokevirtual 207	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   73: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload 4
    //   79: ldc 209
    //   81: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 4
    //   87: aload_2
    //   88: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload 4
    //   94: ldc 132
    //   96: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 4
    //   102: aload_3
    //   103: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload 4
    //   109: ldc 211
    //   111: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload 4
    //   117: lload 7
    //   119: lload 5
    //   121: lsub
    //   122: invokevirtual 214	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload 4
    //   128: ldc 216
    //   130: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload_1
    //   135: aload 4
    //   137: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: ldc 8
    //   143: aload_1
    //   144: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 219	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: goto +244 -> 394
    //   153: invokestatic 196	com/tencent/qqmini/sdk/launcher/log/QMLog:isColorLevel	()Z
    //   156: ifeq +234 -> 390
    //   159: invokestatic 187	java/lang/System:currentTimeMillis	()J
    //   162: lstore 7
    //   164: new 61	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   171: astore_1
    //   172: aload_1
    //   173: ldc 98
    //   175: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: new 61	java/lang/StringBuilder
    //   182: dup
    //   183: ldc 198
    //   185: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   188: astore 4
    //   190: aload 4
    //   192: aload_0
    //   193: invokevirtual 202	java/lang/Object:getClass	()Ljava/lang/Class;
    //   196: invokevirtual 207	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   199: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload 4
    //   205: ldc 221
    //   207: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload 4
    //   213: aload_2
    //   214: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload 4
    //   220: ldc 132
    //   222: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload 4
    //   228: aload_3
    //   229: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload 4
    //   235: ldc 211
    //   237: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload 4
    //   243: lload 7
    //   245: lload 5
    //   247: lsub
    //   248: invokevirtual 214	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload 4
    //   254: ldc 216
    //   256: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload_1
    //   261: aload 4
    //   263: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: ldc 8
    //   269: aload_1
    //   270: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 219	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: iconst_0
    //   277: ireturn
    //   278: astore_0
    //   279: goto +113 -> 392
    //   282: astore_1
    //   283: new 61	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   290: astore 4
    //   292: aload 4
    //   294: ldc 98
    //   296: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: new 61	java/lang/StringBuilder
    //   303: dup
    //   304: ldc 198
    //   306: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   309: astore 10
    //   311: aload 10
    //   313: aload_0
    //   314: invokevirtual 202	java/lang/Object:getClass	()Ljava/lang/Class;
    //   317: invokevirtual 207	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   320: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: aload 10
    //   326: ldc 209
    //   328: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload 10
    //   334: aload_2
    //   335: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: aload 10
    //   341: ldc 132
    //   343: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload 10
    //   349: aload_3
    //   350: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: aload 10
    //   356: ldc 105
    //   358: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload 10
    //   364: aload_1
    //   365: invokevirtual 183	java/lang/Exception:toString	()Ljava/lang/String;
    //   368: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload 4
    //   374: aload 10
    //   376: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: ldc 8
    //   382: aload 4
    //   384: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: invokestatic 88	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   390: iconst_0
    //   391: ireturn
    //   392: aload_0
    //   393: athrow
    //   394: iconst_1
    //   395: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	396	0	paramBrowserPlugin	BrowserPlugin
    //   0	396	1	paramString1	String
    //   0	396	2	paramString2	String
    //   0	396	3	paramString3	String
    //   0	396	4	paramArrayOfString	String[]
    //   9	237	5	l1	long
    //   30	214	7	l2	long
    //   20	3	9	bool	boolean
    //   309	66	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   6	22	278	finally
    //   27	150	278	finally
    //   153	276	278	finally
    //   283	390	278	finally
    //   6	22	282	java/lang/Exception
    //   27	150	282	java/lang/Exception
    //   153	276	282	java/lang/Exception
  }
  
  private void initPlugin(BrowserPlugin paramBrowserPlugin)
  {
    if (paramBrowserPlugin != null)
    {
      paramBrowserPlugin.initRuntime(this.mActivity);
      paramBrowserPlugin.setFragment(this.mBrowserFragment);
      paramBrowserPlugin.onCreate();
      if (this.mWebview != null) {
        paramBrowserPlugin.onWebViewCreated(this.mWebview);
      }
    }
  }
  
  private void insertPlugin(String paramString, BrowserPlugin paramBrowserPlugin)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramBrowserPlugin == null) {
        return;
      }
      if (this.pluginHashMap.containsKey(paramString))
      {
        paramBrowserPlugin = new StringBuilder();
        paramBrowserPlugin.append("insertPlugin:namespace ");
        paramBrowserPlugin.append(paramString);
        paramBrowserPlugin.append(" already exists!");
        QMLog.e("BrowserPluginEngine", paramBrowserPlugin.toString());
        return;
      }
      if (QMLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("insertPlugin:add pair [");
        localStringBuilder.append(paramString);
        localStringBuilder.append("] -> ");
        localStringBuilder.append(paramBrowserPlugin.getClass().getSimpleName());
        QMLog.i("BrowserPluginEngine", localStringBuilder.toString());
      }
      this.pluginHashMap.put(paramString, paramBrowserPlugin);
    }
  }
  
  private boolean internalShouldOverrideUrlRequest(String paramString)
  {
    String str = BrowserUtils.getSchemeFromUrl(paramString);
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    if ("jsbridge".equals(str)) {
      return handleJsBridgeUrlRequest(this, this.mWebview, paramString);
    }
    return false;
  }
  
  private void preCreatePlugin()
  {
    createPlugin("miniApp");
  }
  
  public void bindFragment(Fragment paramFragment)
  {
    if (paramFragment == null) {
      return;
    }
    this.mBrowserFragment = paramFragment;
    Iterator localIterator = this.pluginHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      BrowserPlugin localBrowserPlugin = (BrowserPlugin)localIterator.next();
      if (localBrowserPlugin != null) {
        localBrowserPlugin.setFragment(paramFragment);
      }
    }
  }
  
  public BrowserPlugin getPluginByNameSpace(String paramString)
  {
    if (this.pluginHashMap.containsKey(paramString)) {
      return (BrowserPlugin)this.pluginHashMap.get(paramString);
    }
    return null;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    Object localObject = this.pluginHashMap.values();
    StringBuilder localStringBuilder;
    if (QMLog.isColorLevel()) {
      localStringBuilder = new StringBuilder(((Collection)localObject).size() * 64);
    } else {
      localStringBuilder = new StringBuilder();
    }
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      BrowserPlugin localBrowserPlugin = (BrowserPlugin)((Iterator)localObject).next();
      if (localBrowserPlugin != null)
      {
        long l = System.currentTimeMillis();
        if (localBrowserPlugin.handleEvent(paramString, paramLong, paramMap))
        {
          if (QMLog.isColorLevel())
          {
            paramLong = System.currentTimeMillis() - l;
            if (paramLong > 50L)
            {
              localStringBuilder.append("plugin[");
              localStringBuilder.append(localBrowserPlugin.getClass().getSimpleName());
              localStringBuilder.append("] handled event[");
              localStringBuilder.append("] success cost ");
              localStringBuilder.append(paramLong);
              localStringBuilder.append(" ms.");
              QMLog.i("BrowserPluginEngine", localStringBuilder.toString());
            }
          }
          return true;
        }
      }
    }
    if ((QMLog.isColorLevel()) && (localStringBuilder.length() > 0))
    {
      localStringBuilder.append("handleEvent error: no plugin can handleEvent(");
      localStringBuilder.append(")");
      QMLog.i("BrowserPluginEngine", localStringBuilder.toString());
    }
    return false;
  }
  
  public void onDestroy()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.pluginHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      BrowserPlugin localBrowserPlugin = (BrowserPlugin)localIterator.next();
      if ((localBrowserPlugin != null) && (!localHashMap.containsKey(localBrowserPlugin)))
      {
        long l = System.currentTimeMillis();
        try
        {
          localBrowserPlugin.onDestroy();
          localHashMap.put(localBrowserPlugin, Boolean.valueOf(true));
        }
        catch (Exception localException)
        {
          if (QMLog.isColorLevel()) {
            QMLog.d("BrowserPluginEngine", "", localException);
          }
        }
        if (QMLog.isColorLevel())
        {
          l = System.currentTimeMillis() - l;
          if (l > 50L)
          {
            StringBuilder localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("");
            StringBuilder localStringBuilder2 = new StringBuilder("plugin[");
            localStringBuilder2.append(localBrowserPlugin.getClass().getSimpleName());
            localStringBuilder2.append("] onDestroy cost ");
            localStringBuilder2.append(l);
            localStringBuilder2.append(" ms.");
            localStringBuilder1.append(localStringBuilder2);
            QMLog.d("BrowserPluginEngine", localStringBuilder1.toString());
          }
        }
      }
    }
    this.pluginHashMap.clear();
    this.mWebview = null;
    this.mActivity = null;
    this.mBrowserFragment = null;
  }
  
  public boolean shouldOverrideUrlRequest(String paramString)
  {
    return internalShouldOverrideUrlRequest(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.browser.BrowserPluginEngine
 * JD-Core Version:    0.7.0.1
 */