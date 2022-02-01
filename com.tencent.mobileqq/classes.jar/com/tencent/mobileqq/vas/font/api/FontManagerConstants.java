package com.tencent.mobileqq.vas.font.api;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FontManagerConstants
{
  public static final int ANDROID_PLATFORM = 2;
  public static final float DEFAULT_ENLARGE_EMO_SIZE = 1.5F;
  public static final float DEFAULT_ENLARGE_FONT_SIZE = 1.5F;
  public static final float DEFAULT_ENLARGE_FONT_SIZE_MAX = 1.3F;
  public static final String DIY_FONT_DIR;
  public static final int ENLARGE_EFFECT_CLOSE = 0;
  public static final int ENLARGE_EFFECT_OPEN = 1;
  public static final String FANGZHENG_FILE_DIR;
  public static final String FONTTEST = "fonttest";
  public static final String FONT_DOWN_LOAD_PATH;
  public static final String FONT_EFFECT_CFG;
  public static final int FONT_EFFECT_ENLARGE = 2000;
  public static final int FONT_EFFECT_MAGIC = 1;
  public static final int FONT_EFFECT_NONE = 0;
  public static final String FONT_EFFECT_PATH;
  public static final String FONT_FZ_COMPATIBLE_DIR;
  public static final String FONT_OPEN_SWITCH = "font_open_switch";
  public static final String FONT_SUFF = ".ttf";
  public static final String FONT_TEST_FILE = "font_test_file";
  public static final String FONT_TEST_SWITCH = "font_test_switch";
  public static final String FONT_TEST_TYPE = "font_test_type";
  public static final int FONT_TYPE_DIYFONT_TEST = 99;
  public static final int FONT_TYPE_FANGZHENG = 2;
  public static final int FONT_TYPE_FZCOLOR = 3;
  public static final int FONT_TYPE_FZCOLOR_2 = 4;
  public static final int FONT_TYPE_HANYI = 1;
  public static final String FZCOLOR_2_FILE_DIR;
  public static final String FZ_COLOR_FONT_SO_NAME = "libFounderColorFont_818.so";
  public static final String FZ_COLOR_FONT_SO_ZIP_NAME = "libColorFont.zip";
  public static final String HANYI_FILE_DIR;
  public static final String HY_FONT_SO_NAME = "libvipfont8417.so";
  public static final String HY_FONT_SO_ZIP_NAME = "libvipfont8417.so.zip";
  public static final String ISUSEROPENFONTSWITCH = "isUserOpenFontSwitch_";
  public static final int MAGIC_FONT_DEFAULT_GROUP_SIZE = 4;
  public static final float MAGIC_FONT_DEFAULT_MAX_SIZE1 = 1.3F;
  public static final float MAGIC_FONT_DEFAULT_MAX_SIZE2 = 0.7F;
  public static final float MAGIC_FONT_DEFAULT_NORMAL_SIZE1 = 1.5F;
  public static final float MAGIC_FONT_DEFAULT_NORMAL_SIZE2 = 0.7F;
  public static final float MAGIC_FONT_DEFAULT_SIZE1_NUMBER = 0.3F;
  public static final float MAGIC_FONT_DEFAULT_SIZE2_NUMBER = 0.3F;
  public static final int MAX_ENGINE_CACHE_FONT_NUM = 18;
  public static final String MESSAGE_EXTRA_INFO_KEY_DIY_TIMESTAMP = "diy_timestamp";
  public static final int MSG_DRAW_HIBOOM = 256;
  public static final String TAG = "FontManagerConstants";
  public static final String TEST_DIR = "/FontTest";
  public static final String TEST_DIYFONT_TITLE = "应用DIY字体";
  public static final String TEST_DIYFONT_ZIP_NAME = "androidDIYFont.zip";
  public static boolean isTest = false;
  public static Vector<Integer> mFontBlackList;
  public static AtomicBoolean mFontSwitchFZ;
  public static AtomicBoolean mFontSwitchHanYi;
  public static long mMineLastReportTime;
  public static long mOthersLastReportTime;
  public static AtomicBoolean magicFontConfigInited;
  public static boolean magicFontEnable;
  public static int magicFontGroupSize;
  public static float magicFontMaxSize1;
  public static float magicFontMaxSize2;
  public static float magicFontNormalSize1;
  public static float magicFontNormalSize2;
  public static boolean magicFontOneWordEnable;
  public static float magicFontSize1Number;
  public static float magicFontSize2Number;
  public static volatile boolean sHasChatFont;
  public static Map<Long, Integer> testFontId = new HashMap();
  public static long todayStartTime;
  public AtomicBoolean isTestOn = new AtomicBoolean(false);
  public String mTestFontFile = null;
  public int mTestFontType = -1;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(".font_info");
    FONT_DOWN_LOAD_PATH = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(FONT_DOWN_LOAD_PATH);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("fz2.0/");
    FONT_FZ_COMPATIBLE_DIR = localStringBuilder.toString();
    magicFontConfigInited = new AtomicBoolean(false);
    magicFontEnable = true;
    magicFontOneWordEnable = true;
    magicFontSize1Number = 0.3F;
    magicFontSize2Number = 0.3F;
    magicFontNormalSize1 = 1.5F;
    magicFontNormalSize2 = 0.7F;
    magicFontMaxSize1 = 1.3F;
    magicFontMaxSize2 = 0.7F;
    magicFontGroupSize = 4;
    mMineLastReportTime = 0L;
    mOthersLastReportTime = 0L;
    mFontSwitchHanYi = new AtomicBoolean(true);
    mFontSwitchFZ = new AtomicBoolean(true);
    mFontBlackList = new Vector();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(".font_effect");
    FONT_EFFECT_PATH = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(FONT_EFFECT_PATH);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("magicFontConfig.json");
    FONT_EFFECT_CFG = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory());
    localStringBuilder.append("/FontTest");
    localStringBuilder.append("/hanyifont/");
    HANYI_FILE_DIR = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory());
    localStringBuilder.append("/FontTest");
    localStringBuilder.append("/fangzhengfont/");
    FANGZHENG_FILE_DIR = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory());
    localStringBuilder.append("/FontTest");
    localStringBuilder.append("/fangzhengcolorfont2/");
    FZCOLOR_2_FILE_DIR = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory());
    localStringBuilder.append("/FontTest");
    localStringBuilder.append("/diyfont/");
    DIY_FONT_DIR = localStringBuilder.toString();
    todayStartTime = 0L;
  }
  
  public static boolean checkFontExist(int paramInt1, int paramInt2)
  {
    return new File(getTTFPath(paramInt1, paramInt2)).exists();
  }
  
  public static int generateFontValue(ExtensionInfo paramExtensionInfo)
  {
    int i;
    if (paramExtensionInfo != null) {
      i = (int)(((paramExtensionInfo.uVipFont & 0xFF) << 8) + (0xFF & paramExtensionInfo.uVipFont >> 8)) + (paramExtensionInfo.vipFontType << 16) + (paramExtensionInfo.magicFont << 24);
    } else {
      i = 0;
    }
    if (isTest) {
      testFontId.put(Long.valueOf(i), Integer.valueOf((int)paramExtensionInfo.uVipFont));
    }
    return i;
  }
  
  public static String getSenderUin(MessageRecord paramMessageRecord)
  {
    if (Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(1000), Integer.valueOf(1001), Integer.valueOf(10002), Integer.valueOf(10004), Integer.valueOf(1002), Integer.valueOf(1003), Integer.valueOf(1004), Integer.valueOf(1005), Integer.valueOf(1006), Integer.valueOf(1008), Integer.valueOf(1009), Integer.valueOf(1020), Integer.valueOf(1021), Integer.valueOf(1022), Integer.valueOf(1010), Integer.valueOf(1025), Integer.valueOf(10008), Integer.valueOf(10010) }).contains(Integer.valueOf(paramMessageRecord.istroop))) {
      if (paramMessageRecord.isSend()) {
        paramMessageRecord = paramMessageRecord.selfuin;
      } else {
        paramMessageRecord = paramMessageRecord.frienduin;
      }
    }
    for (;;)
    {
      return paramMessageRecord;
      if (paramMessageRecord.istroop == 1)
      {
        AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if ((localAppRuntime == null) || (((IFontManagerService)localAppRuntime.getRuntimeService(IFontManagerService.class, "")).isAnonymousMsg(paramMessageRecord))) {
          break;
        }
        if (paramMessageRecord.isSend()) {
          paramMessageRecord = paramMessageRecord.selfuin;
        } else {
          paramMessageRecord = paramMessageRecord.senderuin;
        }
      }
      else
      {
        if (paramMessageRecord.istroop != 3000) {
          break;
        }
        if (paramMessageRecord.isSend()) {
          paramMessageRecord = paramMessageRecord.selfuin;
        } else {
          paramMessageRecord = paramMessageRecord.senderuin;
        }
      }
    }
    return null;
  }
  
  public static String getStaticTTFPath(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FONT_DOWN_LOAD_PATH);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(".ttf");
    return localStringBuilder.toString();
  }
  
  public static String getTTFPath(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 3)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(FONT_FZ_COMPATIBLE_DIR);
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(".ttf");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FONT_DOWN_LOAD_PATH);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(".ttf");
    return localStringBuilder.toString();
  }
  
  public static long parseFontId(long paramLong)
  {
    if (isTest) {
      return ((Integer)testFontId.get(Long.valueOf(paramLong))).intValue();
    }
    return ((paramLong & 0xFF) << 8) + (paramLong >> 8 & 0xFF);
  }
  
  public static int parseFontType(long paramLong)
  {
    return (int)(paramLong >> 16 & 0xF);
  }
  
  public static int parseMagicFont(long paramLong)
  {
    return (int)(paramLong >> 24) & 0x1;
  }
  
  public static boolean parseMagicFont(MessageRecord paramMessageRecord)
  {
    boolean bool1 = magicFontEnable;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    bool1 = bool2;
    if (!TextUtils.isEmpty(getSenderUin(paramMessageRecord)))
    {
      paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("vip_font_id");
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramMessageRecord))
      {
        bool1 = bool2;
        if (TextUtils.isDigitsOnly(paramMessageRecord))
        {
          bool1 = bool2;
          if ((Long.parseLong(paramMessageRecord) >> 24 & 1L) == 1L) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static void resetFontSwitch()
  {
    QLog.e("FontManagerConstants", 1, "resetFontSwitch");
    mFontSwitchHanYi.set(true);
    mFontSwitchFZ.set(true);
    mFontBlackList.clear();
  }
  
  public static void updateFontSwitch(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateFontSwitch configContent = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("FontManagerConstants", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    i = 0;
    try
    {
      localObject = new JSONObject(paramString);
      mFontSwitchHanYi.set(((JSONObject)localObject).optBoolean("enableHanyiFont", true));
      mFontSwitchFZ.set(((JSONObject)localObject).optBoolean("enableFounderFont", true));
      paramString = ((JSONObject)localObject).optJSONArray("blackList");
      if ((paramString == null) || (paramString.length() <= 0) || (i >= paramString.length())) {
        break label182;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        int j;
        continue;
        i += 1;
      }
    }
    catch (Exception paramString)
    {
      break label172;
    }
    j = paramString.optInt(i);
    if (!mFontBlackList.contains(Integer.valueOf(j)))
    {
      mFontBlackList.add(Integer.valueOf(j));
      break label187;
      if (QLog.isColorLevel()) {
        QLog.e("FontManagerConstants", 2, new Object[] { "updateFontSwitch configContent not json: ", paramString });
      }
      return;
      label172:
      QLog.e("FontManagerConstants", 1, "updateFontSwitch error: ", paramString);
      label182:
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.font.api.FontManagerConstants
 * JD-Core Version:    0.7.0.1
 */