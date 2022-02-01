package com.tencent.qqlive.tvkplayer.vinfo.ckey;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsAppKeyVerify;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsGuidUtil;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsLog;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsReporter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONObject;

public class CKeyFacade
{
  private static final String TAG = "CKeyFacade|ckeygeneratorV2.so";
  static boolean bLoadSucc = false;
  private static CKeyBeaconReport cKeyBeaconReport = null;
  private static int flag_11;
  private static int flag_22;
  private static int flag_33;
  private static int flag_44;
  private static String mAppKey;
  private static String mBeaconID;
  private static String mBsGuid;
  private static Context mContext;
  private static String mExtInfo;
  private static String mGuid;
  private static volatile CKeyFacade mInstance;
  private static String mJarVersion = "V2.0.000";
  private static String mOmgID;
  private static String mOpenID;
  private static String mPkgName;
  private static String mPlatform;
  private static String mSdtfrom;
  private static String mSoVersion;
  private static String mUin;
  private static String mVsKey;
  private static String mVuid;
  private static ModuleUpdateInterface moduleUpdateInterface;
  private boolean isInit = false;
  private boolean isMutiInit = false;
  
  static
  {
    if (moduleUpdateInterface != null) {
      bLoadSucc = moduleUpdateInterface.loadLibrary("ckeygeneratorV2");
    }
    flag_11 = 1;
    flag_22 = 2;
    flag_33 = 4;
    flag_44 = 8;
    mInstance = null;
    mUin = "";
    mOpenID = "";
    mVuid = "";
    mOmgID = "";
    mBsGuid = "";
    mBeaconID = "";
    mGuid = "";
    mContext = null;
    mVsKey = "";
    mPlatform = "";
    mSdtfrom = "";
    mAppKey = "";
    mPkgName = "";
    mExtInfo = "";
    mSoVersion = "";
  }
  
  private native void CkeyMoudleInit(String paramString1, String paramString2, String paramString3, Context paramContext);
  
  private static native byte[] GenCKey(long paramLong, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int[] paramArrayOfInt, int paramInt2, String paramString7, String paramString8);
  
  private static Boolean ParseJson2IntA(String paramString, int[] paramArrayOfInt)
  {
    Boolean localBoolean = Boolean.valueOf(false);
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (localJSONObject.has("extern1"))
        {
          paramArrayOfInt[0] = localJSONObject.optInt("extern1", 0);
          j = 0x0 | flag_11;
          paramString = Boolean.valueOf(true);
          int i = j;
          if (localJSONObject.has("extern2"))
          {
            paramArrayOfInt[1] = localJSONObject.optInt("extern2", 0);
            i = j | flag_22;
            paramString = Boolean.valueOf(true);
          }
          j = i;
          if (localJSONObject.has("extern3"))
          {
            paramArrayOfInt[2] = localJSONObject.optInt("extern3", 0);
            j = i | flag_33;
            paramString = Boolean.valueOf(true);
          }
          i = j;
          if (localJSONObject.has("extern4"))
          {
            paramArrayOfInt[3] = localJSONObject.optInt("extern4", 0);
            i = j | flag_44;
            paramString = Boolean.valueOf(true);
          }
          paramArrayOfInt[9] = i;
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        return Boolean.valueOf(false);
      }
      int j = 0;
      paramString = localBoolean;
    }
  }
  
  private static String byteArrayToString(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = "";
      }
    }
  }
  
  public static String ckBuildSignStr(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = new TreeMap(paramMap).entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (localStringBuilder.length() != 0) {
        localStringBuilder.append("&");
      }
      localStringBuilder.append((String)localEntry.getKey()).append("=").append((String)localEntry.getValue());
    }
    return localStringBuilder.toString();
  }
  
  public static String ckSign(int paramInt)
  {
    VsReporter.reportSign(mContext, mPlatform, mSdtfrom, mGuid, mBsGuid, mBeaconID, paramInt);
    return getencSS(paramInt);
  }
  
  public static String ckSignature(String paramString, long paramLong)
  {
    paramString = paramString.split("&");
    HashMap localHashMap = new HashMap();
    int i = 0;
    if (i < paramString.length)
    {
      String[] arrayOfString = paramString[i].split("=");
      if (arrayOfString.length != 2) {
        if (arrayOfString[0].length() > 0) {
          localHashMap.put(arrayOfString[0], "");
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localHashMap.put(arrayOfString[0], arrayOfString[1]);
      }
    }
    return ckSignature_map(localHashMap, paramLong);
  }
  
  public static String ckSignature_map(Map<String, String> paramMap, long paramLong)
  {
    try
    {
      paramMap = new String(getSignature(ckBuildSignStr(paramMap), paramLong));
      return paramMap;
    }
    catch (Throwable paramMap) {}
    return "exception";
  }
  
  public static String ckTaskEncrypt(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString5)
  {
    VsReporter.reportTaskEncrypt(mContext, mPlatform, mSdtfrom, mGuid, mBsGuid, mBeaconID, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    return taskEncrypt(paramString1, paramString2, paramString3, paramString4, paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramString5);
  }
  
  public static String getCKey(int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6)
  {
    paramArrayOfByte1 = byteArrayToString(paramArrayOfByte1);
    paramArrayOfByte2 = byteArrayToString(paramArrayOfByte2);
    paramArrayOfByte3 = byteArrayToString(paramArrayOfByte3);
    paramArrayOfByte4 = byteArrayToString(paramArrayOfByte4);
    paramArrayOfByte6 = byteArrayToString(paramArrayOfByte6);
    return getCKey(byteArrayToString(paramArrayOfByte5), paramLong, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte6, "");
  }
  
  public static String getCKey(String paramString1, long paramLong, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    for (;;)
    {
      int j;
      int[] arrayOfInt;
      int i;
      try
      {
        paramString6 = paramString6.split(",");
        j = paramString6.length;
        arrayOfInt = new int[j];
        i = 0;
        if (i < j) {
          if (paramString6[i].length() == 0) {
            arrayOfInt[i] = -1;
          } else {
            arrayOfInt[i] = Integer.parseInt(paramString6[i]);
          }
        }
      }
      catch (Throwable paramString1)
      {
        return "";
      }
      paramString1 = getCKey(paramString1, paramLong, paramString2, paramString3, paramString4, paramString5, arrayOfInt, j, paramString7);
      return paramString1;
      i += 1;
    }
  }
  
  public static String getCKey(String paramString1, long paramLong, String paramString2, String paramString3, String paramString4, String paramString5, int[] paramArrayOfInt, int paramInt, String paramString6)
  {
    localObject1 = "";
    String str3 = "";
    str1 = str3;
    try
    {
      str2 = new Exception().getStackTrace()[1].getClassName();
      str1 = str3;
      localObject1 = str2;
      str3 = new Exception().getStackTrace()[1].getMethodName();
      str1 = str3;
      localObject1 = str2;
      VsLog.info(str2 + "  " + str3, new Object[0]);
      localObject1 = str3;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        String str2;
        label465:
        Object localObject2 = localObject1;
        localObject1 = str1;
      }
    }
    if (paramString4 != null) {}
    for (;;)
    {
      try
      {
        if (!paramString4.trim().equals("")) {
          break label465;
        }
        str1 = mPlatform;
        if ((paramString5 == null) || (paramString5.trim().equals("")))
        {
          paramString4 = mSdtfrom;
          paramString5 = mVsKey;
          Object localObject4 = (Map)VsAppKeyVerify.getInstance().getAppKeyMap().get(str1);
          String str4 = paramString5;
          Object localObject3 = str1;
          str3 = paramString4;
          if (localObject4 != null)
          {
            str3 = (String)((Map)localObject4).get("vskey");
            if (str3 != null) {
              paramString5 = str3;
            }
            str3 = (String)((Map)localObject4).get("sdtfrom");
            if (str3 != null) {
              paramString4 = str3;
            }
            localObject4 = (String)((Map)localObject4).get("platform");
            str4 = paramString5;
            localObject3 = str1;
            str3 = paramString4;
            if (localObject4 != null)
            {
              localObject3 = localObject4;
              str3 = paramString4;
              str4 = paramString5;
            }
          }
          if ((TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str4))) {
            break;
          }
          mBsGuid = paramString1;
          CKeyGuard.instance();
          paramString4 = CKeyGuard.genGuard(mContext);
          if (mGuid.trim().equals("")) {
            mGuid = VsGuidUtil.getInstance(mContext).loadVsGuid();
          }
          paramString3 = new String(GenCKey(paramLong, Integer.parseInt((String)localObject3), paramString3, paramString2, getfd(str3), str4, paramString1, mGuid, paramArrayOfInt, paramInt, paramString6, paramString4));
          VsReporter.reportCKey(mContext, cKeyBeaconReport, (String)localObject3, str3, str4, mGuid, paramString1, mBeaconID, 0, mPkgName, (String)localObject3, str3, paramString2, paramLong, paramString3, str2 + "|" + (String)localObject1, mExtInfo, paramString4);
          return paramString3;
        }
      }
      catch (Throwable paramString1)
      {
        return "";
      }
      paramString4 = paramString5;
      continue;
      str1 = paramString4;
    }
    return "";
  }
  
  private static native String getCKeyVersion();
  
  public static String getJarVersion()
  {
    return mJarVersion;
  }
  
  private static native byte[] getSignature(String paramString, long paramLong);
  
  public static String getSoVersion()
  {
    return getVersion();
  }
  
  public static String getVersion()
  {
    try
    {
      String str = getCKeyVersion();
      VsLog.info("CKeyFacade|ckeygeneratorV2.so", new Object[] { "ver succ" });
      return str;
    }
    catch (Throwable localThrowable)
    {
      VsLog.info("CKeyFacade|ckeygeneratorV2.so", new Object[] { "ver error" });
    }
    return "";
  }
  
  private static native String getencSS(int paramInt);
  
  public static String getfd(String paramString)
  {
    try
    {
      if (paramString.length() <= 2) {
        return "null";
      }
      char[] arrayOfChar = paramString.substring(1).toCharArray();
      int i = 0;
      while (i < paramString.length() - 1)
      {
        arrayOfChar[i] = ((char)(arrayOfChar[i] + '1' + i + i));
        i += 1;
      }
      paramString = String.valueOf(arrayOfChar);
      return paramString;
    }
    catch (Throwable paramString) {}
    return "null";
  }
  
  public static String getfd(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = byteArrayToString(paramArrayOfByte);
      StringBuilder localStringBuilder = new StringBuilder("");
      if (paramArrayOfByte.length() <= 2) {
        return "ffff";
      }
      char[] arrayOfChar = paramArrayOfByte.substring(1).toCharArray();
      int i = 0;
      while (i < paramArrayOfByte.length() - 1)
      {
        localStringBuilder.append((char)(arrayOfChar[i] + '1' + i + i));
        i += 1;
      }
      paramArrayOfByte = localStringBuilder.toString();
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte) {}
    return "ffff";
  }
  
  public static String getmPlatform()
  {
    return mPlatform;
  }
  
  public static String getmSdtfrom()
  {
    return mSdtfrom;
  }
  
  public static CKeyFacade instance()
  {
    try
    {
      if (mInstance == null)
      {
        mInstance = new CKeyFacade();
        if (!bLoadSucc) {
          bLoadSucc = loadso();
        }
      }
      CKeyFacade localCKeyFacade = mInstance;
      return localCKeyFacade;
    }
    finally {}
  }
  
  private static boolean loadso()
  {
    if (moduleUpdateInterface == null) {
      moduleUpdateInterface = new ModuleUpdateDefault();
    }
    return moduleUpdateInterface.loadLibrary("ckeygeneratorV2");
  }
  
  public static void setInterface(String paramString1, String paramString2, BeaconInterface paramBeaconInterface, ModuleUpdateInterface paramModuleUpdateInterface)
  {
    moduleUpdateInterface = paramModuleUpdateInterface;
    cKeyBeaconReport = new CKeyBeaconReport(paramString1, paramString2, paramBeaconInterface);
  }
  
  private static native String taskEncrypt(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString5);
  
  public void addVsAppKey(Context paramContext, String paramString)
  {
    if (!VsAppKeyVerify.getInstance().addVsAppKey(paramContext, paramString)) {
      Log.e("CKeyFacade|ckeygeneratorV2.so", "add vsAppKey verify error!!!");
    }
  }
  
  public String getmExtInfo()
  {
    return mExtInfo;
  }
  
  public String getmOpenID()
  {
    return mOpenID;
  }
  
  public String getmUin()
  {
    return mUin;
  }
  
  public String getmVuid()
  {
    return mVuid;
  }
  
  public void init(Context paramContext, String paramString1, String paramString2)
  {
    VsLog.info("CKeyFacade|ckeygeneratorV2.so", new Object[] { "load ckeygeneratorV2.so init" });
    if (paramContext == null) {}
    do
    {
      return;
      mContext = paramContext.getApplicationContext();
      if (VsAppKeyVerify.getInstance().verifyVsAppKey(mContext, paramString1))
      {
        mPlatform = VsAppKeyVerify.getInstance().getmPlatform();
        mPkgName = VsAppKeyVerify.getInstance().getmPkgName();
        mSdtfrom = VsAppKeyVerify.getInstance().getmSdtfrom();
        mVsKey = VsAppKeyVerify.getInstance().getmVsKey();
      }
    } while ((this.isInit) || (this.isMutiInit));
    CKeyGuard.setModuleUpdateInterface(moduleUpdateInterface);
    CKeyGuard.instance();
    CKeyGuard.guardInit(mContext);
    mSoVersion = getVersion();
    mBsGuid = paramString2;
    paramContext = new Thread(new CKeyFacade.1(this));
    paramContext.setName("TVK_ckeythread");
    paramContext.start();
    paramContext = new Thread(new CKeyFacade.2(this));
    paramContext.setName("TVK_guidthread");
    paramContext.start();
    VsReporter.reportInit(mContext, cKeyBeaconReport, mPlatform, mSdtfrom, mVsKey, mGuid, paramString2, mBeaconID, 0, mPkgName);
    this.isInit = true;
  }
  
  public void setInfo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    mUin = paramString1;
    mOpenID = paramString2;
    mVuid = paramString3;
    mExtInfo = paramString4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyFacade
 * JD-Core Version:    0.7.0.1
 */