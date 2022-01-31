package com.tencent.ttpic.logic.watermark;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.tencent.ttpic.model.WMElement;
import com.tencent.ttpic.util.VideoPrefsUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LogicDataManager
{
  public static final String ALTITUDE = "[altitude]";
  private static final String DATA_DEFAULT_LOCATION = "中国";
  private static final String DATA_DEFAULT_NO_NETWORK = "无网络";
  private static final String DATA_DEFAULT_TEMPERATURE = "0";
  private static final String DATA_DEFAULT_WEATHER = "晴";
  public static final String DATE = "[date]";
  public static final String DATE_D = "[date:D]";
  public static final String DATE_EEE = "[date:EEE]";
  public static final String DATE_EEEE = "[date:EEEE]";
  public static final String DATE_F = "[date:F]";
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
  public static final String DATE_d = "[date:d]";
  public static final String DATE_d0 = "[date:d0]";
  public static final String DATE_d1 = "[date:d1]";
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
  private static final int DECIBEL_UPDATE_INTERVAL = 500;
  public static final String LOCATION = "[location]";
  public static final String SPEED = "[speed]";
  public static final String TEMPERATURE = "[temperature]";
  public static final String WEATHER = "[weather]";
  private static LogicDataManager mInstance;
  private final String TAG = LogicDataManager.class.getSimpleName();
  private String mAltitude = "无网络";
  private int mDecibel;
  private long mDecibelUpdateTimestamp = 0L;
  private List<WMElement> mEditableWMElements = new ArrayList();
  private String mLocation = "中国";
  private boolean mNeedDecibel = false;
  private Map<String, LogicValueProvider> mProviderMap = new HashMap();
  private String mTemperature = "0";
  private boolean mUseDecibelFromCameraRecorder = false;
  private String mWeather = "晴";
  
  private void buildDataProviderMap()
  {
    this.mProviderMap.put("[date]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.getTimestamp();
      }
    });
    this.mProviderMap.put("[date:yy]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.getyy();
      }
    });
    this.mProviderMap.put("[date:yyyy]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.getyyyy();
      }
    });
    this.mProviderMap.put("[date:y0]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.gety(0);
      }
    });
    this.mProviderMap.put("[date:y1]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.gety(1);
      }
    });
    this.mProviderMap.put("[date:y2]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.gety(2);
      }
    });
    this.mProviderMap.put("[date:y3]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.gety(3);
      }
    });
    this.mProviderMap.put("[date:M]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.getM();
      }
    });
    this.mProviderMap.put("[date:MM]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.getMM();
      }
    });
    this.mProviderMap.put("[date:MMM]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.getMMM();
      }
    });
    this.mProviderMap.put("[date:MMMM]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.getMMMM();
      }
    });
    this.mProviderMap.put("[date:M0]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.getM(0);
      }
    });
    this.mProviderMap.put("[date:M1]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.getM(1);
      }
    });
    this.mProviderMap.put("[date:w]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.getw();
      }
    });
    this.mProviderMap.put("[date:W]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.getW();
      }
    });
    this.mProviderMap.put("[date:d]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.getd();
      }
    });
    this.mProviderMap.put("[date:d0]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.getd(0);
      }
    });
    this.mProviderMap.put("[date:d1]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.getd(1);
      }
    });
    this.mProviderMap.put("[date:D]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.getD();
      }
    });
    this.mProviderMap.put("[date:F]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.getF();
      }
    });
    this.mProviderMap.put("[date:EEE]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.getEEE();
      }
    });
    this.mProviderMap.put("[date:EEEE]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.getEEEE();
      }
    });
    this.mProviderMap.put("[date:a]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.geta();
      }
    });
    this.mProviderMap.put("[date:h]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.geth();
      }
    });
    this.mProviderMap.put("[date:hh]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.gethh();
      }
    });
    this.mProviderMap.put("[date:h0]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.geth(0);
      }
    });
    this.mProviderMap.put("[date:h1]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.geth(1);
      }
    });
    this.mProviderMap.put("[date:H]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.getH();
      }
    });
    this.mProviderMap.put("[date:HH]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.getHH();
      }
    });
    this.mProviderMap.put("[date:H0]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.getH(0);
      }
    });
    this.mProviderMap.put("[date:H1]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.getH(1);
      }
    });
    this.mProviderMap.put("[date:m]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.getm();
      }
    });
    this.mProviderMap.put("[date:mm]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.getmm();
      }
    });
    this.mProviderMap.put("[date:m0]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.getm(0);
      }
    });
    this.mProviderMap.put("[date:m1]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.getm(1);
      }
    });
    this.mProviderMap.put("[date:s]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.gets();
      }
    });
    this.mProviderMap.put("[date:ss]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.getss();
      }
    });
    this.mProviderMap.put("[date:s0]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.gets(0);
      }
    });
    this.mProviderMap.put("[date:s1]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.gets(1);
      }
    });
    this.mProviderMap.put("[db]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.getDB();
      }
    });
    this.mProviderMap.put("[altitude]", new LogicValueProvider()
    {
      public String getValue()
      {
        return String.valueOf(LogicDataManager.this.getAltitude());
      }
    });
    this.mProviderMap.put("[location]", new LogicValueProvider()
    {
      public String getValue()
      {
        if (LogicDataManager.this.mLocation == null) {
          return "这里";
        }
        return LogicDataManager.this.mLocation;
      }
    });
    this.mProviderMap.put("[weather]", new LogicValueProvider()
    {
      public String getValue()
      {
        if (LogicDataManager.this.mWeather == null) {
          return "";
        }
        return LogicDataManager.this.mWeather;
      }
    });
    this.mProviderMap.put("[temperature]", new LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.getTemperature();
      }
    });
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
  
  private String getDB()
  {
    if (!this.mUseDecibelFromCameraRecorder)
    {
      DecibelDetector.getInstance().init();
      int i = DecibelDetector.getInstance().getDecibel();
      if (i != 0) {
        setDecibel(i);
      }
    }
    return String.valueOf(this.mDecibel);
  }
  
  private String getEEE()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date());
    int j = localCalendar.get(7) - 1;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    return new String[] { "Sun.", "Mon.", "Tues.", "Wed.", "Thur.", "Fri.", "Sat." }[i];
  }
  
  private String getEEEE()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date());
    int j = localCalendar.get(7) - 1;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    return new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" }[i];
  }
  
  private String getF()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date());
    int j = localCalendar.get(7) - 1;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    return new String[] { "日", "一", "二", "三", "四", "五", "六" }[i];
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
  
  private String getM()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("M").format(localDate);
  }
  
  private String getM(int paramInt)
  {
    Date localDate = new Date();
    return new SimpleDateFormat("MM").format(localDate).substring(paramInt, paramInt + 1);
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
    int i = Integer.parseInt(getm(0));
    if (i == 0) {}
    for (i = Integer.parseInt(getm(1)); i < arrayOfString.length; i = i * 10 + Integer.parseInt(getm(1))) {
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
    int i = Integer.parseInt(getm(0));
    if (i == 0) {}
    for (i = Integer.parseInt(getm(1)); i < arrayOfString.length; i = i * 10 + Integer.parseInt(getm(1))) {
      return arrayOfString[i];
    }
    return "";
  }
  
  private String getTemperature()
  {
    return this.mTemperature;
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
  
  private String getd()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("d").format(localDate);
  }
  
  private String getd(int paramInt)
  {
    Date localDate = new Date();
    return new SimpleDateFormat("dd").format(localDate).substring(paramInt, paramInt + 1);
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
  
  private void resetParams()
  {
    this.mEditableWMElements.clear();
    this.mNeedDecibel = false;
    this.mUseDecibelFromCameraRecorder = false;
    this.mDecibelUpdateTimestamp = 0L;
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
      final Map.Entry localEntry = (Map.Entry)paramMap.next();
      this.mProviderMap.put("[" + (String)localEntry.getKey() + "]", new LogicValueProvider()
      {
        public String getValue()
        {
          return (String)localEntry.getValue();
        }
      });
    }
  }
  
  public void destroy()
  {
    destroyDecibelDetector();
  }
  
  public void destroyDecibelDetector()
  {
    DecibelDetector.getInstance().destroy();
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
      str = ((LogicValueProvider)this.mProviderMap.get(paramString)).getValue();
    }
    return str;
  }
  
  public String getWeather()
  {
    return this.mWeather;
  }
  
  public boolean hasObtainedServerData()
  {
    return (!"中国".equals(this.mLocation)) && (!"晴".equals(this.mWeather)) && (!"0".equals(this.mTemperature)) && (!"无网络".equals(this.mAltitude));
  }
  
  public void init()
  {
    resetParams();
    buildDataProviderMap();
  }
  
  public boolean needDecibel()
  {
    return this.mNeedDecibel;
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
  
  public String replaceWithData(String paramString, Set<String> paramSet)
  {
    Iterator localIterator = paramSet.iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.mProviderMap.containsKey(str)) {}
      for (paramSet = ((LogicValueProvider)this.mProviderMap.get(str)).getValue();; paramSet = "")
      {
        paramString = paramString.replace(str, paramSet);
        break;
      }
    }
    return paramString;
  }
  
  public void setAltitude(String paramString)
  {
    this.mAltitude = paramString;
  }
  
  public void setDecibel(int paramInt)
  {
    long l = System.currentTimeMillis();
    if (l - this.mDecibelUpdateTimestamp > 500L)
    {
      this.mDecibel = paramInt;
      this.mDecibelUpdateTimestamp = l;
    }
  }
  
  public void setDecibelFromCameraRecorder(boolean paramBoolean)
  {
    this.mUseDecibelFromCameraRecorder = paramBoolean;
  }
  
  public void setLocation(String paramString)
  {
    this.mLocation = paramString;
  }
  
  public void setNeedDB(boolean paramBoolean)
  {
    this.mNeedDecibel = paramBoolean;
  }
  
  public void setTemperature(String paramString)
  {
    this.mTemperature = paramString;
  }
  
  public void setWeather(String paramString)
  {
    this.mWeather = paramString;
  }
  
  public void test()
  {
    Iterator localIterator = this.mProviderMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Log.e(this.TAG, (String)localEntry.getKey() + ": " + ((LogicValueProvider)localEntry.getValue()).getValue());
    }
  }
  
  private static abstract interface LogicValueProvider
  {
    public abstract String getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.logic.watermark.LogicDataManager
 * JD-Core Version:    0.7.0.1
 */