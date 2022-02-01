package com.tencent.ttpic.openapi.watermark;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.media.ExifInterface;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.ttpic.audio.LocalAudioDataManager;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.model.Audio2Text;
import com.tencent.ttpic.model.Audio2Text.FIFOList;
import com.tencent.ttpic.model.Audio2Text.LoopRepList;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.model.WMElement;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import com.tencent.ttpic.openapi.util.WMTextDrawer;
import com.tencent.ttpic.voicechanger.common.audio.VoiceTextRecognizer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LogicDataManager
{
  public static final String ALTITUDE = "[altitude]";
  public static final String CHECKIN = "[checkin]";
  public static final String CITY = "[City]";
  public static final String COUNTRY = "[Country]";
  private static final String DATA_DEFAULT_LOCATION = "我在这里";
  private static final String DATA_DEFAULT_NO_NETWORK = "无网络";
  private static final String DATA_DEFAULT_TEMPERATURE = "0";
  private static final String DATA_DEFAULT_WEATHER = "晴";
  private static final String DATA_DEFAULT_WEATHER_TYPE = "";
  public static final String DATE = "[date]";
  public static final String DATE_D = "[date:D]";
  public static final String DATE_EEE = "[date:EEE]";
  public static final String DATE_EEEE = "[date:EEEE]";
  public static final String DATE_H = "[date:H]";
  public static final String DATE_H0 = "[date:H0]";
  public static final String DATE_H1 = "[date:H1]";
  public static final String DATE_HH = "[date:HH]";
  public static final String DATE_M = "[date:M]";
  public static final String DATE_M0 = "[date:M0]";
  public static final String DATE_M1 = "[date:M1]";
  public static final String DATE_MM = "[date:MM]";
  public static final String DATE_MMM = "[date:MMM]";
  public static final String DATE_MMMM = "[date:MMMM]";
  public static final String DATE_W = "[date:W]";
  public static final String DATE_Y0 = "[date:Y0]";
  public static final String DATE_Y1 = "[date:Y1]";
  public static final String DATE_Y2 = "[date:Y2]";
  public static final String DATE_Y3 = "[date:Y3]";
  public static final String DATE_YY = "[date:YY]";
  public static final String DATE_YYYY = "[date:YYYY]";
  public static final String DATE_a = "[date:a]";
  public static final String DATE_cH = "[date:cH]";
  public static final String DATE_cH0 = "[date:cH0]";
  public static final String DATE_cH1 = "[date:cH1]";
  public static final String DATE_cHH = "[date:cHH]";
  public static final String DATE_cm = "[date:cm]";
  public static final String DATE_cm0 = "[date:cm0]";
  public static final String DATE_cm1 = "[date:cm1]";
  public static final String DATE_cmm = "[date:cmm]";
  public static final String DATE_cs = "[date:cs]";
  public static final String DATE_cs0 = "[date:cs0]";
  public static final String DATE_cs1 = "[date:cs1]";
  public static final String DATE_css = "[date:css]";
  public static final String DATE_d = "[date:d]";
  public static final String DATE_d0 = "[date:d0]";
  public static final String DATE_d1 = "[date:d1]";
  public static final String DATE_dd = "[date:dd]";
  public static final String DATE_e = "[date:e]";
  public static final String DATE_h = "[date:h]";
  public static final String DATE_h0 = "[date:h0]";
  public static final String DATE_h1 = "[date:h1]";
  public static final String DATE_hh = "[date:hh]";
  public static final String DATE_m = "[date:m]";
  public static final String DATE_m0 = "[date:m0]";
  public static final String DATE_m1 = "[date:m1]";
  public static final String DATE_mm = "[date:mm]";
  public static final String DATE_s = "[date:s]";
  public static final String DATE_s0 = "[date:s0]";
  public static final String DATE_s1 = "[date:s1]";
  public static final String DATE_ss = "[date:ss]";
  public static final String DATE_w = "[date:w]";
  public static final String DATE_y0 = "[date:y0]";
  public static final String DATE_y1 = "[date:y1]";
  public static final String DATE_y2 = "[date:y2]";
  public static final String DATE_y3 = "[date:y3]";
  public static final String DATE_yy = "[date:yy]";
  public static final String DATE_yyyy = "[date:yyyy]";
  public static final String DB = "[db]";
  public static final String LOCATION = "[location]";
  public static final String NUMBER = "[number]";
  public static final String NUMBER_d0 = "[number:0]";
  public static final String NUMBER_d1 = "[number:1]";
  public static final String NUMBER_d2 = "[number:2]";
  public static final String NUMBER_d3 = "[number:3]";
  public static final String NUMBER_d4 = "[number:4]";
  public static final String NUMBER_d5 = "[number:5]";
  public static final String NUMBER_d6 = "[number:6]";
  public static final String NUMBER_d7 = "[number:7]";
  public static final String NUMBER_d8 = "[number:8]";
  public static final String NUMBER_d9 = "[number:9]";
  public static final Pattern PATTERN_NUMERICAL = Pattern.compile("-?\\d+");
  public static final Pattern PATTERN_SPEECHS;
  public static final Pattern PATTERN_SPEECHW;
  public static final String PIC_DATE_M0 = "[picDate:M0]";
  public static final String PIC_DATE_M1 = "[picDate:M1]";
  public static final String PIC_DATE_d0 = "[picDate:d0]";
  public static final String PIC_DATE_d1 = "[picDate:d1]";
  public static final String PIC_DATE_y0 = "[picDate:y0]";
  public static final String PIC_DATE_y1 = "[picDate:y1]";
  public static final String PIC_DATE_y2 = "[picDate:y2]";
  public static final String PIC_DATE_y3 = "[picDate:y3]";
  public static final String QQ_ONLINE_NUMBER = "[online_user_number]";
  public static final String SPEECHS_ALL = "[speech:all]";
  public static final String SPEED = "[speed]";
  private static final String STRING_EMPTY = "";
  private static final String TAG = LogicDataManager.class.getSimpleName();
  public static final String TEMPERATURE = "[temperature]";
  public static final String TEMPERATURE_0 = "[temperature_0]";
  public static final String TEMPERATURE_1 = "[temperature_1]";
  public static final String TEMPERATURE_s = "[temperature_s]";
  public static final String TEXT = "[text]";
  public static final String WEATHER = "[weather]";
  public static final String WEATHER_TYPE = "[weatherType]";
  public static final String cDAYS = "[cDays]";
  public static final String cDAYS_0 = "[cDays:0]";
  public static final String cDAYS_1 = "[cDays:1]";
  public static final String cDAYS_2 = "[cDays:2]";
  private static LogicDataManager mInstance;
  private String mAltitude = "无网络";
  private List<WMElement> mEditableWMElements = new ArrayList();
  public HashMap<String, String> mFollowData = new HashMap();
  private LogicDataManager.OnGetQQNumberEventListener mGetQQNumberEventListener;
  private String mLocation = "我在这里";
  private int mPeoplenumber = 0;
  private String mPictureDate;
  private Map<String, LogicDataManager.LogicValueProvider> mProviderMap = new HashMap();
  private LogicDataManager.OnSilenceEventListener mSilenceEventListener;
  private String mTemperature = "0";
  private int mVTSegmentCount;
  private int mVTSegmentTime;
  private LogicDataManager.VTSentenceImpl mVTSentenceStrategyImpl;
  private int mVTSilenceTime;
  private List<String> mVoiceTextDup = new CopyOnWriteArrayList();
  private Queue<String> mVoiceTextQueue = new LinkedList();
  private String mWeather = "晴";
  private String mWeatherType = "";
  
  static
  {
    PATTERN_SPEECHS = Pattern.compile("\\[speech:s-?\\d?\\]");
    PATTERN_SPEECHW = Pattern.compile("\\[speech:w-?\\d?\\]");
  }
  
  private void buildDataProviderMap()
  {
    this.mProviderMap.put("[date]", new LogicDataManager.1(this));
    this.mProviderMap.put("[date:yy]", new LogicDataManager.2(this));
    this.mProviderMap.put("[date:yyyy]", new LogicDataManager.3(this));
    this.mProviderMap.put("[date:y0]", new LogicDataManager.4(this));
    this.mProviderMap.put("[date:y1]", new LogicDataManager.5(this));
    this.mProviderMap.put("[date:y2]", new LogicDataManager.6(this));
    this.mProviderMap.put("[date:y3]", new LogicDataManager.7(this));
    this.mProviderMap.put("[date:M]", new LogicDataManager.8(this));
    this.mProviderMap.put("[date:MM]", new LogicDataManager.9(this));
    this.mProviderMap.put("[date:MMM]", new LogicDataManager.10(this));
    this.mProviderMap.put("[date:MMMM]", new LogicDataManager.11(this));
    this.mProviderMap.put("[date:M0]", new LogicDataManager.12(this));
    this.mProviderMap.put("[date:M1]", new LogicDataManager.13(this));
    this.mProviderMap.put("[date:w]", new LogicDataManager.14(this));
    this.mProviderMap.put("[date:W]", new LogicDataManager.15(this));
    this.mProviderMap.put("[date:d]", new LogicDataManager.16(this));
    this.mProviderMap.put("[date:dd]", new LogicDataManager.17(this));
    this.mProviderMap.put("[date:d0]", new LogicDataManager.18(this));
    this.mProviderMap.put("[date:d1]", new LogicDataManager.19(this));
    this.mProviderMap.put("[date:D]", new LogicDataManager.20(this));
    this.mProviderMap.put("[date:e]", new LogicDataManager.21(this));
    this.mProviderMap.put("[date:EEE]", new LogicDataManager.22(this));
    this.mProviderMap.put("[date:EEEE]", new LogicDataManager.23(this));
    this.mProviderMap.put("[date:a]", new LogicDataManager.24(this));
    this.mProviderMap.put("[date:h]", new LogicDataManager.25(this));
    this.mProviderMap.put("[date:hh]", new LogicDataManager.26(this));
    this.mProviderMap.put("[date:h0]", new LogicDataManager.27(this));
    this.mProviderMap.put("[date:h1]", new LogicDataManager.28(this));
    this.mProviderMap.put("[date:H]", new LogicDataManager.29(this));
    this.mProviderMap.put("[date:HH]", new LogicDataManager.30(this));
    this.mProviderMap.put("[date:H0]", new LogicDataManager.31(this));
    this.mProviderMap.put("[date:H1]", new LogicDataManager.32(this));
    this.mProviderMap.put("[date:m]", new LogicDataManager.33(this));
    this.mProviderMap.put("[date:mm]", new LogicDataManager.34(this));
    this.mProviderMap.put("[date:m0]", new LogicDataManager.35(this));
    this.mProviderMap.put("[date:m1]", new LogicDataManager.36(this));
    this.mProviderMap.put("[date:s]", new LogicDataManager.37(this));
    this.mProviderMap.put("[online_user_number]", new LogicDataManager.38(this));
    this.mProviderMap.put("[cDays]", new LogicDataManager.39(this));
    this.mProviderMap.put("[cDays:0]", new LogicDataManager.40(this));
    this.mProviderMap.put("[cDays:1]", new LogicDataManager.41(this));
    this.mProviderMap.put("[cDays:2]", new LogicDataManager.42(this));
    this.mProviderMap.put("[date:cH]", new LogicDataManager.43(this));
    this.mProviderMap.put("[date:cHH]", new LogicDataManager.44(this));
    this.mProviderMap.put("[date:cH0]", new LogicDataManager.45(this));
    this.mProviderMap.put("[date:cH1]", new LogicDataManager.46(this));
    this.mProviderMap.put("[date:cm]", new LogicDataManager.47(this));
    this.mProviderMap.put("[date:cmm]", new LogicDataManager.48(this));
    this.mProviderMap.put("[date:cm0]", new LogicDataManager.49(this));
    this.mProviderMap.put("[date:cm1]", new LogicDataManager.50(this));
    this.mProviderMap.put("[date:cs]", new LogicDataManager.51(this));
    this.mProviderMap.put("[date:css]", new LogicDataManager.52(this));
    this.mProviderMap.put("[date:cs0]", new LogicDataManager.53(this));
    this.mProviderMap.put("[date:cs1]", new LogicDataManager.54(this));
    this.mProviderMap.put("[number]", new LogicDataManager.55(this));
    this.mProviderMap.put("[number:0]", new LogicDataManager.56(this));
    this.mProviderMap.put("[number:1]", new LogicDataManager.57(this));
    this.mProviderMap.put("[number:2]", new LogicDataManager.58(this));
    this.mProviderMap.put("[number:3]", new LogicDataManager.59(this));
    this.mProviderMap.put("[number:4]", new LogicDataManager.60(this));
    this.mProviderMap.put("[number:5]", new LogicDataManager.61(this));
    this.mProviderMap.put("[number:6]", new LogicDataManager.62(this));
    this.mProviderMap.put("[number:7]", new LogicDataManager.63(this));
    this.mProviderMap.put("[number:8]", new LogicDataManager.64(this));
    this.mProviderMap.put("[number:9]", new LogicDataManager.65(this));
    this.mProviderMap.put("[text]", new LogicDataManager.66(this));
    this.mProviderMap.put("[date:ss]", new LogicDataManager.67(this));
    this.mProviderMap.put("[date:s0]", new LogicDataManager.68(this));
    this.mProviderMap.put("[date:s1]", new LogicDataManager.69(this));
    this.mProviderMap.put("[db]", new LogicDataManager.70(this));
    this.mProviderMap.put("[altitude]", new LogicDataManager.71(this));
    this.mProviderMap.put("[location]", new LogicDataManager.72(this));
    if (!this.mProviderMap.containsKey("[Country]")) {
      this.mProviderMap.put("[Country]", new LogicDataManager.73(this));
    }
    if (!this.mProviderMap.containsKey("[City]")) {
      this.mProviderMap.put("[City]", new LogicDataManager.74(this));
    }
    this.mProviderMap.put("[weather]", new LogicDataManager.75(this));
    this.mProviderMap.put("[weatherType]", new LogicDataManager.76(this));
    this.mProviderMap.put("[temperature]", new LogicDataManager.77(this));
    this.mProviderMap.put("[temperature_0]", new LogicDataManager.78(this));
    this.mProviderMap.put("[temperature_1]", new LogicDataManager.79(this));
    this.mProviderMap.put("[temperature_s]", new LogicDataManager.80(this));
    this.mProviderMap.put("[speech:all]", new LogicDataManager.81(this));
    this.mProviderMap.put("[picDate:y0]", new LogicDataManager.82(this));
    this.mProviderMap.put("[picDate:y1]", new LogicDataManager.83(this));
    this.mProviderMap.put("[picDate:y2]", new LogicDataManager.84(this));
    this.mProviderMap.put("[picDate:y3]", new LogicDataManager.85(this));
    this.mProviderMap.put("[picDate:M0]", new LogicDataManager.86(this));
    this.mProviderMap.put("[picDate:M1]", new LogicDataManager.87(this));
    this.mProviderMap.put("[picDate:d0]", new LogicDataManager.88(this));
    this.mProviderMap.put("[picDate:d1]", new LogicDataManager.89(this));
  }
  
  private int fetchNumerical(String paramString)
  {
    paramString = PATTERN_NUMERICAL.matcher(paramString);
    if (paramString.find())
    {
      paramString = paramString.group();
      try
      {
        int i = Integer.parseInt(paramString);
        return i;
      }
      catch (NumberFormatException paramString)
      {
        LogUtils.e(paramString);
      }
    }
    return 0;
  }
  
  private String fetchSpeechSentence(String paramString)
  {
    ArrayList localArrayList = new ArrayList(this.mVoiceTextDup);
    if (localArrayList.isEmpty()) {
      return "";
    }
    int j = fetchNumerical(paramString);
    if (CollectionUtils.indexOutOfBounds(localArrayList, Math.abs(j - 1))) {
      return "";
    }
    int i = j;
    if (j == 0) {
      i = (int)(Math.random() * localArrayList.size()) + 1;
    }
    if (i > 0) {
      i -= 1;
    }
    for (;;)
    {
      return (String)localArrayList.get(i);
      i = localArrayList.size() - Math.abs(i);
    }
  }
  
  private String fetchSpeechWord(String arg1)
  {
    int i = fetchNumerical(???);
    if (i != 0)
    {
      ??? = new ArrayList(this.mVoiceTextDup);
      if ((???.isEmpty()) && ((this.mVTSentenceStrategyImpl == null) || (this.mVTSentenceStrategyImpl.getCurrentPendingText().isEmpty()))) {
        return "";
      }
      if (!???.isEmpty()) {}
      for (??? = (String)???.get(???.size() - 1); ???.length() < Math.abs(i); ??? = this.mVTSentenceStrategyImpl.getCurrentPendingText()) {
        return "";
      }
      if (i > 0) {
        return String.valueOf(???.charAt(i - 1));
      }
      return String.valueOf(???.length() - Math.abs(i));
    }
    synchronized (this.mVoiceTextQueue)
    {
      if (!this.mVoiceTextQueue.isEmpty())
      {
        String str = String.valueOf(this.mVoiceTextQueue.poll());
        return str;
      }
    }
    return "";
  }
  
  private String getAltitude()
  {
    return this.mAltitude;
  }
  
  private String getD()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("D").format(localDate);
  }
  
  private String getEEE()
  {
    int i = 0;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date());
    int j = localCalendar.get(7) - 1;
    if (j < 0) {}
    for (;;)
    {
      return new String[] { "Sun.", "Mon.", "Tues.", "Wed.", "Thur.", "Fri.", "Sat." }[i];
      i = j;
    }
  }
  
  private String getEEEE()
  {
    int i = 0;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date());
    int j = localCalendar.get(7) - 1;
    if (j < 0) {}
    for (;;)
    {
      return new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" }[i];
      i = j;
    }
  }
  
  private String getH()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("H").format(localDate);
  }
  
  private String getH(int paramInt)
  {
    return getHH().substring(paramInt, paramInt + 1);
  }
  
  private String getHH()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("HH").format(localDate);
  }
  
  public static LogicDataManager getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new LogicDataManager();
      }
      LogicDataManager localLogicDataManager = mInstance;
      return localLogicDataManager;
    }
    finally {}
  }
  
  private long getLeftDate(WMElement paramWMElement)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.set(localCalendar1.get(1), localCalendar1.get(2), localCalendar1.get(5), 0, 0, 0);
    if ((paramWMElement != null) && (!paramWMElement.numberSource.equals(""))) {}
    try
    {
      localCalendar2.add(5, Integer.valueOf((String)this.mFollowData.get(paramWMElement.numberSource)).intValue());
      return localCalendar2.getTimeInMillis() - localCalendar1.getTimeInMillis();
    }
    catch (NumberFormatException paramWMElement)
    {
      for (;;)
      {
        LogUtils.e(TAG, "getLeftDate: Integer.valueOf() Error");
      }
    }
  }
  
  private String getM()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("M").format(localDate);
  }
  
  private String getM(int paramInt)
  {
    return getMM().substring(paramInt, paramInt + 1);
  }
  
  private String getMM()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("MM").format(localDate);
  }
  
  private String getMMM()
  {
    String[] arrayOfString = new String[12];
    arrayOfString[0] = "Jan.";
    arrayOfString[1] = "Feb.";
    arrayOfString[2] = "Mar.";
    arrayOfString[3] = "Apr.";
    arrayOfString[4] = "May.";
    arrayOfString[5] = "Jun.";
    arrayOfString[6] = "Jul.";
    arrayOfString[7] = "Aug.";
    arrayOfString[8] = "Sept.";
    arrayOfString[9] = "Oct.";
    arrayOfString[10] = "Nov.";
    arrayOfString[11] = "Dec.";
    int i = Integer.parseInt(getM(0));
    if (i == 0) {}
    for (i = Integer.parseInt(getM(1)); i < arrayOfString.length; i = i * 10 + Integer.parseInt(getM(1)) - 1) {
      return arrayOfString[i];
    }
    return "";
  }
  
  private String getMMMM()
  {
    String[] arrayOfString = new String[12];
    arrayOfString[0] = "January";
    arrayOfString[1] = "February";
    arrayOfString[2] = "March";
    arrayOfString[3] = "April";
    arrayOfString[4] = "May";
    arrayOfString[5] = "June";
    arrayOfString[6] = "July";
    arrayOfString[7] = "August";
    arrayOfString[8] = "September";
    arrayOfString[9] = "October";
    arrayOfString[10] = "November";
    arrayOfString[11] = "December";
    int i = Integer.parseInt(getM(0));
    if (i == 0) {}
    for (i = Integer.parseInt(getM(1)); i < arrayOfString.length; i = i * 10 + Integer.parseInt(getM(1)) - 1) {
      return arrayOfString[i];
    }
    return "";
  }
  
  private String getTemperature()
  {
    return this.mTemperature;
  }
  
  private String getTemperature(int paramInt)
  {
    if (!TextUtils.isEmpty(this.mTemperature)) {
      try
      {
        if (Integer.parseInt(this.mTemperature) >= 0)
        {
          if (paramInt + 1 <= this.mTemperature.length()) {
            return this.mTemperature.substring(paramInt, paramInt + 1);
          }
        }
        else if (paramInt + 2 <= this.mTemperature.length())
        {
          String str = this.mTemperature.substring(paramInt + 1, paramInt + 2);
          return str;
        }
      }
      catch (Exception localException) {}
    }
    return "";
  }
  
  private String getTemperatureSymbol()
  {
    if (!TextUtils.isEmpty(this.mTemperature)) {
      try
      {
        if (Integer.parseInt(this.mTemperature) >= 0) {
          return "+";
        }
        return "-";
      }
      catch (Exception localException) {}
    }
    return "";
  }
  
  private String getTimestamp()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(localDate);
  }
  
  private String getW()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("W").format(localDate);
  }
  
  private String geta()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("a").format(localDate);
  }
  
  private String getcDay(WMElement paramWMElement)
  {
    return String.valueOf((int)(getLeftDate(paramWMElement) / 86400000L));
  }
  
  private String getcDay(WMElement paramWMElement, int paramInt)
  {
    paramWMElement = getcDay(paramWMElement);
    int i = paramWMElement.length();
    if (i >= paramInt + 1) {
      return paramWMElement.substring(i - paramInt - 1, i - paramInt);
    }
    return "-1";
  }
  
  private String getcH(WMElement paramWMElement)
  {
    return String.valueOf((int)(getLeftDate(paramWMElement) % 86400000L / 3600L / 1000L % 24L));
  }
  
  private String getcHH(WMElement paramWMElement)
  {
    return String.format("%02d", new Object[] { Integer.valueOf((int)(getLeftDate(paramWMElement) % 86400000L / 3600L / 1000L % 24L)) });
  }
  
  private String getcHH(WMElement paramWMElement, int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 0)) {
      return getcHH(paramWMElement).substring(paramInt, paramInt + 1);
    }
    return "-1";
  }
  
  private String getcm(WMElement paramWMElement)
  {
    return String.valueOf((int)(getLeftDate(paramWMElement) % 3600000L / 60000L));
  }
  
  private String getcmm(WMElement paramWMElement)
  {
    return String.format("%02d", new Object[] { Integer.valueOf((int)(getLeftDate(paramWMElement) % 3600000L / 60000L)) });
  }
  
  private String getcmm(WMElement paramWMElement, int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 0)) {
      return getcmm(paramWMElement).substring(paramInt, paramInt + 1);
    }
    return "-1";
  }
  
  private String getcs(WMElement paramWMElement)
  {
    return String.valueOf((int)(getLeftDate(paramWMElement) % 60000L / 1000L));
  }
  
  private String getcss(WMElement paramWMElement)
  {
    return String.format("%02d", new Object[] { Integer.valueOf((int)(getLeftDate(paramWMElement) % 60000L / 1000L)) });
  }
  
  private String getcss(WMElement paramWMElement, int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 0)) {
      return getcss(paramWMElement).substring(paramInt, paramInt + 1);
    }
    return "-1";
  }
  
  private String getd()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("d").format(localDate);
  }
  
  private String getd(int paramInt)
  {
    return getdd().substring(paramInt, paramInt + 1);
  }
  
  private String getdd()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("dd").format(localDate);
  }
  
  private String gete()
  {
    int i = 0;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date());
    int j = localCalendar.get(7) - 1;
    if (j < 0) {}
    for (;;)
    {
      return new String[] { "日", "一", "二", "三", "四", "五", "六" }[i];
      i = j;
    }
  }
  
  private String geth()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("h").format(localDate);
  }
  
  private String geth(int paramInt)
  {
    Date localDate = new Date();
    return new SimpleDateFormat("hh").format(localDate).substring(paramInt, paramInt + 1);
  }
  
  private String gethh()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("hh").format(localDate);
  }
  
  private String getm()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("m").format(localDate);
  }
  
  private String getm(int paramInt)
  {
    return getmm().substring(paramInt, paramInt + 1);
  }
  
  private String getmm()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("mm").format(localDate);
  }
  
  private String gets()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("s").format(localDate);
  }
  
  private String gets(int paramInt)
  {
    return getss().substring(paramInt, paramInt + 1);
  }
  
  private String getss()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("ss").format(localDate);
  }
  
  private String getw()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("w").format(localDate);
  }
  
  private String gety(int paramInt)
  {
    Date localDate = new Date();
    return new SimpleDateFormat("yyyy").format(localDate).substring(paramInt, paramInt + 1);
  }
  
  private String getyy()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("yy").format(localDate);
  }
  
  private String getyyyy()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("yyyy").format(localDate);
  }
  
  public void addEditableWMElement(WMElement paramWMElement)
  {
    this.mEditableWMElements.add(paramWMElement);
  }
  
  public void addWatermarkDict(Map<String, String> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if ((!TextUtils.isEmpty((CharSequence)localEntry.getValue())) || (!this.mProviderMap.containsKey("[" + (String)localEntry.getKey() + "]"))) {
        this.mProviderMap.put("[" + (String)localEntry.getKey() + "]", new LogicDataManager.90(this, localEntry));
      }
    }
  }
  
  public void buildVoice2TextParams(VideoMaterial paramVideoMaterial)
  {
    if ((paramVideoMaterial == null) || (paramVideoMaterial.getAudio2Text() == null)) {}
    do
    {
      return;
      this.mVTSilenceTime = ((int)(paramVideoMaterial.getAudio2Text().silenceTime * 1000.0D));
      this.mVTSegmentCount = paramVideoMaterial.getAudio2Text().segmentCount;
      this.mVTSegmentTime = ((int)(paramVideoMaterial.getAudio2Text().segmentTime * 1000.0D));
      clearVoiceTexts();
      VoiceTextRecognizer.getInstance().setVoiceTextListener(null);
    } while (!VideoMaterialUtil.isAudio2textMaterial(paramVideoMaterial));
    this.mVTSentenceStrategyImpl = new LogicDataManager.VTSentenceImpl(this, null);
    VoiceTextRecognizer.getInstance().setVoiceTextListener(this.mVTSentenceStrategyImpl);
    if (paramVideoMaterial.getAudio2Text().sentenceMode == 1)
    {
      this.mVoiceTextDup = new Audio2Text.LoopRepList(paramVideoMaterial.getAudio2Text().sentenceCount);
      return;
    }
    this.mVoiceTextDup = new Audio2Text.FIFOList(paramVideoMaterial.getAudio2Text().sentenceCount);
  }
  
  public void clearVoiceTexts()
  {
    this.mVoiceTextDup.clear();
    this.mVoiceTextQueue.clear();
    if (this.mVTSentenceStrategyImpl != null) {
      this.mVTSentenceStrategyImpl.clearAllTexts();
    }
    LogUtils.d(TAG, "clearVoiceTexts() call");
  }
  
  public List<String> getCurTextList()
  {
    Object localObject1;
    Object localObject2;
    if (!this.mVoiceTextDup.isEmpty())
    {
      localObject1 = new ArrayList(this.mVoiceTextDup);
      if ((this.mVoiceTextDup instanceof Audio2Text.FIFOList))
      {
        localObject2 = (String)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1);
        ((ArrayList)localObject1).clear();
        ((ArrayList)localObject1).add(localObject2);
      }
    }
    do
    {
      return localObject1;
      localObject2 = new ArrayList();
      localObject1 = localObject2;
    } while (this.mVTSentenceStrategyImpl == null);
    ((List)localObject2).add(this.mVTSentenceStrategyImpl.getCurrentPendingText());
    return localObject2;
  }
  
  public String getCurrentText()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("audio2text : ");
    if (this.mVTSentenceStrategyImpl != null) {
      localStringBuffer.append(this.mVTSentenceStrategyImpl.getCurrentText());
    }
    localStringBuffer.append("\n");
    return localStringBuffer.toString();
  }
  
  public List<WMElement> getEditableWMElement()
  {
    return this.mEditableWMElements;
  }
  
  public String getLocation()
  {
    return this.mLocation;
  }
  
  public String getValue(String paramString)
  {
    String str = paramString;
    if (this.mProviderMap.containsKey(paramString)) {
      str = ((LogicDataManager.LogicValueProvider)this.mProviderMap.get(paramString)).getValue();
    }
    return str;
  }
  
  public String getValue(String paramString, WMElement paramWMElement)
  {
    String str = paramString;
    if (this.mProviderMap.containsKey(paramString)) {
      str = ((LogicDataManager.LogicValueProvider)this.mProviderMap.get(paramString)).getValue(paramWMElement);
    }
    return str;
  }
  
  public boolean hasObtainedServerData()
  {
    return (!"我在这里".equals(this.mLocation)) && (!"晴".equals(this.mWeather)) && (!"0".equals(this.mTemperature)) && (!"无网络".equals(this.mAltitude));
  }
  
  public void init(VideoMaterial paramVideoMaterial)
  {
    LocalAudioDataManager.getInstance().reset();
    buildDataProviderMap();
    buildVoice2TextParams(paramVideoMaterial);
  }
  
  public void init4WM260()
  {
    LocalAudioDataManager.getInstance().reset();
    buildDataProviderMap();
  }
  
  public String mapWeatherCode(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return "晴";
    case 1: 
      return "多云";
    case 2: 
      return "阴";
    case 3: 
      return "雨";
    case 4: 
      return "雪";
    case 5: 
      return "雾";
    case 6: 
      return "雨加雪";
    case 7: 
      return "雷阵雨";
    case 8: 
      return "沙尘暴";
    }
    return "大风";
  }
  
  public void putTypeface(@NonNull String paramString, @NonNull Typeface paramTypeface)
  {
    WMTextDrawer.putTypeface(paramString, paramTypeface);
  }
  
  public void recordDate(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1.equals("since")) {
      VideoPrefsUtil.getDefaultPrefs().edit().putString("prefs_key_watermark_since_" + paramString2, paramString3).apply();
    }
    while (!paramString1.equals("countdown")) {
      return;
    }
    VideoPrefsUtil.getDefaultPrefs().edit().putString("prefs_key_watermark_countdown_" + paramString2, paramString3).apply();
  }
  
  public void removeEditableWMElement(WMElement paramWMElement)
  {
    this.mEditableWMElements.remove(paramWMElement);
  }
  
  public void removeOnGetQQNumberEventListener()
  {
    this.mGetQQNumberEventListener = null;
  }
  
  public String replaceWithData(String paramString, Set<String> paramSet, WMElement paramWMElement)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    for (;;)
    {
      try
      {
        Iterator localIterator = new HashSet(paramSet).iterator();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if ((!PATTERN_SPEECHS.matcher(paramString).find()) || (!PATTERN_SPEECHS.matcher(str).find())) {
            break label184;
          }
          paramString = paramString.replace(str, fetchSpeechSentence(str));
          if ((PATTERN_SPEECHW.matcher(paramString).find()) && (PATTERN_SPEECHW.matcher(str).find()))
          {
            paramString = paramString.replace(str, fetchSpeechWord(str));
            if (!this.mProviderMap.containsKey(str)) {
              break label187;
            }
            paramSet = ((LogicDataManager.LogicValueProvider)this.mProviderMap.get(str)).getValue(paramWMElement);
            paramString = paramString.replace(str, paramSet);
          }
        }
        else
        {
          return paramString;
        }
      }
      finally {}
      continue;
      label184:
      continue;
      label187:
      paramSet = "";
    }
  }
  
  public void setAltitude(String paramString)
  {
    this.mAltitude = paramString;
  }
  
  public void setLocation(String paramString)
  {
    this.mLocation = paramString;
  }
  
  public void setOnGetQQNumberEventListener(LogicDataManager.OnGetQQNumberEventListener paramOnGetQQNumberEventListener)
  {
    this.mGetQQNumberEventListener = paramOnGetQQNumberEventListener;
  }
  
  public void setOnSilenceEventListener(LogicDataManager.OnSilenceEventListener paramOnSilenceEventListener)
  {
    this.mSilenceEventListener = paramOnSilenceEventListener;
  }
  
  public void setPictureDate(String paramString)
  {
    try
    {
      this.mPictureDate = new ExifInterface(paramString).getAttribute("DateTime");
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setTemperature(String paramString)
  {
    this.mTemperature = paramString;
  }
  
  public void setWeather(int paramInt)
  {
    this.mWeather = mapWeatherCode(paramInt);
  }
  
  public void setWeatherType(int paramInt)
  {
    this.mWeatherType = String.valueOf(paramInt);
  }
  
  public void test()
  {
    Iterator localIterator = this.mProviderMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      LogUtils.e(TAG, (String)localEntry.getKey() + ": " + ((LogicDataManager.LogicValueProvider)localEntry.getValue()).getValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.watermark.LogicDataManager
 * JD-Core Version:    0.7.0.1
 */