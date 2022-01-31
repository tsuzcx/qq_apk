package com.tencent.qqlive.tvkplayer;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKVcSystemInfo;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyFacade;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

public class TVideoMgr
{
  private static final String VINFO_SDTFROM = "";
  private static Application mApp;
  public static Map<String, String> mFreeNetFlowRequestMap;
  public static String mOriginalUpc = "";
  private static int mPlatform;
  private static String mStaGuid;
  private static String vskey = "Ql/htTRimt7Wz+A6GPZUxKFiE+c8QCFlaOzbR9F4ajtLHHAKcVI43jHmEs87kZLeW4cgL8Ihy6BDHc89lyxxOj3nD2oamuN/xffuoqSJmVQ9XBWqvzIpIF4AsCA48O/eNBb5trflsLKQgBHCXtfKfBVnimFJt+LG8pekFCjAyV5n3lyJZivJLN2YxnYhKEwRgkqaFh6dcXnVU+wb9GQZS+p9V/v/dJjikoDIpJcW5sOMVDQ41KYOWPGPA/fMmyfw3ScewBbcvBh07vqc9d9557gA0CCSYoc6BJwisQH0b4lARO+JCdq9oxMolRlqQPMLXhVB3Km1APnq+LpSx4XMxZBq98mY4K3x5akBHo2VEmmS+SpHO1qiBjNWX0HrgDdiwzvOqa3k1LIlO75yWJzByBrw9Q7SRmwUGMlrquVAit1AsZGXn5YYtIKme+TQ2TkzvO2W4UOOwv0kIIeN3gXXg6Q6gstEblHXdPzEyvOIxeiiUSEBdXfY5cdQmlkW/EFU";
  
  public static Context getApplicationContext()
  {
    return mApp.getApplicationContext();
  }
  
  public static String getPlayerVersion()
  {
    return "1.0.0";
  }
  
  public static String getStaGuid()
  {
    if (!TextUtils.isEmpty(mStaGuid)) {
      return mStaGuid;
    }
    Object localObject = TVKVcSystemInfo.getDeviceID(mApp.getApplicationContext()) + TVKVcSystemInfo.getDeviceMacAddr(mApp.getApplicationContext());
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      localObject = ((String)localObject).getBytes("UTF-8");
      byte[] arrayOfByte = MessageDigest.getInstance("MD5").digest((byte[])localObject);
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < arrayOfByte.length)
      {
        String str = Integer.toHexString(arrayOfByte[i] & 0xFF);
        localObject = str;
        if (str.length() == 1) {
          localObject = '0' + str;
        }
        localStringBuilder.append(((String)localObject).toUpperCase());
        i += 1;
      }
      mStaGuid = localStringBuilder.toString();
    }
    catch (Throwable localThrowable)
    {
      label155:
      break label155;
    }
    if (TextUtils.isEmpty(mStaGuid)) {
      mStaGuid = "wtfguidisemptyhehehe";
    }
    return mStaGuid;
  }
  
  public static int getVinfoPlatform()
  {
    return mPlatform;
  }
  
  public static String getVinfoSdtfrom()
  {
    return "";
  }
  
  public static void init(Application paramApplication, int paramInt)
  {
    mApp = paramApplication;
    mPlatform = paramInt;
    paramApplication = new TVideoMgr.1();
    CKeyFacade.setInterface("", String.valueOf(getVinfoPlatform()), paramApplication, null);
    CKeyFacade.instance().init(mApp.getApplicationContext(), vskey, getStaGuid());
  }
  
  public static void setOnLogListener(TVideoMgr.OnTVideoLogListener paramOnTVideoLogListener)
  {
    TVKLogUtil.setOnTVideoLogListener(paramOnTVideoLogListener);
  }
  
  public void setUpc(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      mFreeNetFlowRequestMap = null;
      mOriginalUpc = "";
    }
    do
    {
      return;
      mOriginalUpc = paramString;
      paramString = paramString.split("&");
    } while (paramString.length <= 0);
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramString.length)
    {
      String[] arrayOfString = paramString[i].split("=");
      if ((arrayOfString.length == 2) && (!TextUtils.isEmpty(arrayOfString[0])) && (!TextUtils.isEmpty(arrayOfString[1]))) {
        localHashMap.put(arrayOfString[0], arrayOfString[1]);
      }
      i += 1;
    }
    mFreeNetFlowRequestMap = localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.TVideoMgr
 * JD-Core Version:    0.7.0.1
 */