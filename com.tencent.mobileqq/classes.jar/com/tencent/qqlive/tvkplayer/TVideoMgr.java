package com.tencent.qqlive.tvkplayer;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKVcSystemInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlatformInfo;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyFacade;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

public class TVideoMgr
{
  private static Context mAppContext;
  public static Map<String, String> mFreeNetFlowRequestMap;
  public static String mOriginalUpc = "";
  private static int mPlatform;
  private static SparseArray<TVKPlatformInfo> mPlatformMap;
  private static String mStaGuid;
  
  public static Context getApplicationContext()
  {
    return mAppContext;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(TVKVcSystemInfo.getDeviceID(mAppContext));
    ((StringBuilder)localObject).append(TVKVcSystemInfo.getDeviceMacAddr(mAppContext));
    localObject = ((StringBuilder)localObject).toString();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
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
          if (str.length() == 1)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append('0');
            ((StringBuilder)localObject).append(str);
            localObject = ((StringBuilder)localObject).toString();
          }
          localStringBuilder.append(((String)localObject).toUpperCase());
          i += 1;
        }
        mStaGuid = localStringBuilder.toString();
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
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
    return getVinfoSdtfrom(mPlatform);
  }
  
  public static String getVinfoSdtfrom(int paramInt)
  {
    SparseArray localSparseArray = mPlatformMap;
    if ((localSparseArray != null) && (localSparseArray.indexOfKey(paramInt) > 0)) {
      return ((TVKPlatformInfo)mPlatformMap.get(paramInt)).getSdtFrom();
    }
    return null;
  }
  
  public static void init(Context paramContext, int paramInt)
  {
    mAppContext = paramContext.getApplicationContext();
    mPlatform = paramInt;
    CKeyFacade.setInterface("", "", new TVideoMgr.1(), null);
    CKeyFacade.instance().init(mAppContext, null, getStaGuid());
  }
  
  public static boolean registerTVideoPlatformInfo(TVKPlatformInfo paramTVKPlatformInfo)
  {
    if (paramTVKPlatformInfo == null) {
      return false;
    }
    if (mPlatformMap == null) {
      mPlatformMap = new SparseArray();
    }
    if (mPlatformMap.indexOfKey(paramTVKPlatformInfo.getPlatform()) < 0)
    {
      mPlatformMap.put(paramTVKPlatformInfo.getPlatform(), paramTVKPlatformInfo);
      CKeyFacade.instance().addVsAppKey(mAppContext, paramTVKPlatformInfo.getAppKey());
      return true;
    }
    return false;
  }
  
  public static void setOnLogListener(TVideoMgr.OnTVideoLogListener paramOnTVideoLogListener)
  {
    TVKLogUtil.setOnTVideoLogListener(paramOnTVideoLogListener);
  }
  
  public static void setUpc(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      mFreeNetFlowRequestMap = null;
      mOriginalUpc = "";
      return;
    }
    mOriginalUpc = paramString;
    paramString = paramString.split("&");
    if (paramString.length > 0)
    {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.TVideoMgr
 * JD-Core Version:    0.7.0.1
 */