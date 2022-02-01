package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.o;
import java.util.HashSet;
import java.util.Set;

public class ClientConfigManagerImpl
  implements d
{
  private static final String TAG = "ClientConfigManager";
  private static volatile ClientConfigManagerImpl sClientConfigManagerImpl;
  private a mAppConfigSettings;
  private Context mContext;
  private e mPushConfigSettings;
  
  private ClientConfigManagerImpl(Context paramContext)
  {
    this.mContext = ContextDelegate.getContext(paramContext);
    this.mAppConfigSettings = new a(this.mContext);
    this.mPushConfigSettings = new e(this.mContext);
  }
  
  public static ClientConfigManagerImpl getInstance(Context paramContext)
  {
    try
    {
      if (sClientConfigManagerImpl == null) {
        sClientConfigManagerImpl = new ClientConfigManagerImpl(paramContext);
      }
      paramContext = sClientConfigManagerImpl;
      return paramContext;
    }
    finally {}
  }
  
  private void prepareAppConfig()
  {
    a locala = this.mAppConfigSettings;
    if (locala == null)
    {
      this.mAppConfigSettings = new a(this.mContext);
      return;
    }
    locala.c();
  }
  
  private e preparePushConfigSettings()
  {
    e locale = this.mPushConfigSettings;
    if (locale == null) {
      this.mPushConfigSettings = new e(this.mContext);
    } else {
      locale.c();
    }
    return this.mPushConfigSettings;
  }
  
  public void clearPush()
  {
    this.mAppConfigSettings.d();
  }
  
  public Set<String> getBlackEventList()
  {
    return null;
  }
  
  public int getNotifyStyle()
  {
    Object localObject = preparePushConfigSettings();
    try
    {
      localObject = ((e)localObject).c("DPL");
      boolean bool = TextUtils.isEmpty((CharSequence)localObject);
      if (!bool) {
        try
        {
          int i = Integer.parseInt((String)localObject);
          return i;
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          localNumberFormatException1.printStackTrace();
        }
      }
      return 0;
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      localNumberFormatException2.printStackTrace();
    }
  }
  
  public String getSuitTag()
  {
    return preparePushConfigSettings().c("CSPT");
  }
  
  public String getValueByKey(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    this.mPushConfigSettings.c();
    return this.mPushConfigSettings.c(paramString);
  }
  
  public Set<Long> getWhiteLogList()
  {
    HashSet localHashSet = new HashSet();
    Object localObject = getValueByKey("WLL");
    int j;
    int i;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(",");
      j = localObject.length;
      i = 0;
    }
    for (;;)
    {
      String str;
      if (i < j) {
        str = localObject[i];
      }
      try
      {
        localHashSet.add(Long.valueOf(Long.parseLong(str)));
        label65:
        i += 1;
        continue;
        o.d("ClientConfigManager", " initWhiteLogList ".concat(String.valueOf(localHashSet)));
        return localHashSet;
      }
      catch (Exception localException)
      {
        break label65;
      }
    }
  }
  
  public boolean isCancleBroadcastReceiver()
  {
    String str = preparePushConfigSettings().c("PSM");
    int i;
    if (!TextUtils.isEmpty(str)) {
      try
      {
        i = Integer.parseInt(str);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
      }
    } else {
      i = 0;
    }
    return (i & 0x4) != 0;
  }
  
  public boolean isDebug()
  {
    this.mAppConfigSettings.c();
    return a.a(this.mAppConfigSettings.b());
  }
  
  public boolean isDebug(int paramInt)
  {
    return a.a(paramInt);
  }
  
  public boolean isEnablePush()
  {
    prepareAppConfig();
    com.vivo.push.model.a locala = this.mAppConfigSettings.c(this.mContext.getPackageName());
    if (locala != null) {
      return "1".equals(locala.b());
    }
    return true;
  }
  
  public boolean isInBlackList(long paramLong)
  {
    Object localObject = preparePushConfigSettings().c("BL");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(",");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        CharSequence localCharSequence = localObject[i];
        try
        {
          if (!TextUtils.isEmpty(localCharSequence))
          {
            long l = Long.parseLong(localCharSequence);
            if (l == paramLong) {
              return true;
            }
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localNumberFormatException.printStackTrace();
          i += 1;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.cache.ClientConfigManagerImpl
 * JD-Core Version:    0.7.0.1
 */