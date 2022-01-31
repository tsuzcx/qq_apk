import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class mhr
{
  private static int jdField_a_of_type_Int = -1;
  private static long jdField_a_of_type_Long = 1000L;
  private static Boolean jdField_a_of_type_JavaLangBoolean;
  private static final String jdField_a_of_type_JavaLangString = ajjy.a(2131643114);
  private static int jdField_b_of_type_Int = -1;
  private static volatile Boolean jdField_b_of_type_JavaLangBoolean;
  private static String jdField_b_of_type_JavaLangString;
  private static volatile int jdField_c_of_type_Int = -1;
  private static String jdField_c_of_type_JavaLangString;
  private static int jdField_d_of_type_Int = -1;
  private static String jdField_d_of_type_JavaLangString;
  private static int jdField_e_of_type_Int = -1;
  private static String jdField_e_of_type_JavaLangString;
  private static int f = -1;
  private static int g = -1;
  
  public static int a()
  {
    if (jdField_c_of_type_Int == -1)
    {
      jdField_c_of_type_Int = EffectConfigBase.a(287, EffectConfigBase.jdField_d_of_type_JavaLangString).getInt("multiVideoSupportNumbers", -1);
      if (jdField_c_of_type_Int == -1) {
        jdField_c_of_type_Int = 5;
      }
      return jdField_c_of_type_Int;
    }
    return jdField_c_of_type_Int;
  }
  
  public static long a()
  {
    return jdField_a_of_type_Long;
  }
  
  public static String a()
  {
    a();
    return jdField_b_of_type_JavaLangString;
  }
  
  public static mhs a(int paramInt)
  {
    JSONArray localJSONArray = a();
    if (localJSONArray == null) {
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        mhs localmhs = new mhs();
        localmhs.jdField_b_of_type_Int = 2147483647;
        i = 0;
        if (i < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          if ((localJSONObject.getInt("type") == paramInt) && (localJSONObject.getInt("priority") < localmhs.jdField_b_of_type_Int))
          {
            localmhs.jdField_a_of_type_Int = localJSONObject.getInt("id");
            localmhs.jdField_a_of_type_JavaLangString = localJSONObject.getString("url");
            localmhs.jdField_b_of_type_Int = localJSONObject.getInt("priority");
            localmhs.jdField_c_of_type_Int = localJSONObject.getInt("type");
          }
        }
        else if (localmhs.jdField_b_of_type_Int < 2147483647)
        {
          QLog.i("QAVConfigUtils", 1, "MoreBtnTips. getHighestPriorityMoreBtnTips. highest. id = " + localmhs.jdField_a_of_type_Int + ", url = " + localmhs.jdField_a_of_type_JavaLangString + ", priority = " + localmhs.jdField_b_of_type_Int + ", type = " + localmhs.jdField_c_of_type_Int);
          return localmhs;
        }
      }
      catch (Exception localException)
      {
        QLog.i("QAVConfigUtils", 1, "MoreBtnTips. getHighestPriorityMoreBtnTips failed. " + QLog.getStackTraceString(localException));
        QLog.i("QAVConfigUtils", 1, "MoreBtnTips. getHighestPriorityMoreBtnTips failed. moreBtnTips = null. sessionType = " + paramInt);
        return null;
      }
      i += 1;
    }
  }
  
  private static JSONArray a()
  {
    Object localObject = EffectConfigBase.a(287, EffectConfigBase.jdField_d_of_type_JavaLangString).getString("moreBtnTips", "");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.i("QAVConfigUtils", 1, "MoreBtnTips. readMoreBtnTipsJsonArray failed. TextUtils.isEmpty(moreBtnTipsJson) = " + TextUtils.isEmpty((CharSequence)localObject));
      return null;
    }
    try
    {
      QLog.i("QAVConfigUtils", 1, "MoreBtnTips. readMoreBtnTipsJsonArray. read moreBtnTipsJson = " + (String)localObject);
      localObject = new JSONArray((String)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      QLog.i("QAVConfigUtils", 1, "MoreBtnTips. readMoreBtnTipsJsonArray failed. " + QLog.getStackTraceString(localException));
    }
    return null;
  }
  
  private static void a()
  {
    if ((jdField_b_of_type_JavaLangBoolean == null) || (TextUtils.isEmpty(jdField_b_of_type_JavaLangString)))
    {
      SharedPreferences localSharedPreferences = EffectConfigBase.a(287, EffectConfigBase.jdField_d_of_type_JavaLangString);
      jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(localSharedPreferences.getBoolean("switchMultiForceUseGroup", false));
      jdField_b_of_type_JavaLangString = localSharedPreferences.getString("switchMultiForceUseGroupAlertTip", jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) {
        jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString;
      }
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "initDouble2GroupConfig [" + jdField_b_of_type_JavaLangBoolean + "," + jdField_b_of_type_JavaLangString + "]");
      }
    }
  }
  
  public static void a(int paramInt)
  {
    JSONArray localJSONArray = a();
    if (localJSONArray == null) {
      return;
    }
    for (;;)
    {
      int i;
      Object localObject;
      try
      {
        new mhs().jdField_b_of_type_Int = 2147483647;
        i = 0;
        if (i >= localJSONArray.length()) {
          break;
        }
        localObject = localJSONArray.getJSONObject(i);
        if (((JSONObject)localObject).getInt("id") != paramInt) {
          break label192;
        }
        QLog.i("QAVConfigUtils", 1, "MoreBtnTips. removeMoreBtnTips. id = " + paramInt);
        if (Build.VERSION.SDK_INT >= 19)
        {
          localJSONArray.remove(i);
          localObject = EffectConfigBase.a(287, EffectConfigBase.jdField_d_of_type_JavaLangString).edit();
          QLog.i("QAVConfigUtils", 1, "MoreBtnTips. removeMoreBtnTips. saved moreBtnTipsJson = " + localJSONArray.toString());
          ((SharedPreferences.Editor)localObject).putString("moreBtnTips", localJSONArray.toString());
          ((SharedPreferences.Editor)localObject).commit();
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.i("QAVConfigUtils", 1, "MoreBtnTips. removeMoreBtnTips failed. " + QLog.getStackTraceString(localException));
        return;
      }
      ((JSONObject)localObject).put("priority", 2147483647);
      continue;
      label192:
      i += 1;
    }
  }
  
  public static void a(String paramString)
  {
    int j = 1;
    int i11 = 1;
    long l1 = 1000L;
    boolean bool3 = true;
    boolean bool8 = true;
    int i2 = -1;
    int i4 = 0;
    int i = 0;
    boolean bool4 = false;
    boolean bool7 = false;
    Object localObject1 = jdField_a_of_type_JavaLangString;
    boolean bool5 = false;
    boolean bool6 = false;
    int i1 = 7;
    int i9 = -1;
    int i3 = -1;
    int i8 = -1;
    Object localObject3 = "";
    Object localObject4 = "";
    Object localObject5 = "";
    Object localObject11 = "";
    if (QLog.isColorLevel()) {
      QLog.i("QAVConfigUtils", 2, " parseAndSave parse json = " + paramString);
    }
    if (!TextUtils.isEmpty(paramString)) {}
    label2754:
    for (;;)
    {
      try
      {
        localObject12 = new JSONObject(paramString);
        if (((JSONObject)localObject12).has("isBlueToothSwitchForAndroid")) {
          i = ((JSONObject)localObject12).getInt("isBlueToothSwitchForAndroid");
        }
      }
      catch (Exception localException7)
      {
        try
        {
          if (((JSONObject)localObject12).has("bluetoothDelayTime"))
          {
            l2 = ((JSONObject)localObject12).getLong("bluetoothDelayTime");
            l1 = l2;
          }
          boolean bool1;
          int k;
          boolean bool2;
          Object localObject2;
          int m;
          Object localObject9;
          Object localObject6;
          int n;
          Object localObject7;
          i = 1;
        }
        catch (Exception localException7)
        {
          try
          {
            if (((JSONObject)localObject12).has("LowlightAndDenoiseDevice")) {
              bool1 = ((JSONObject)localObject12).getBoolean("LowlightAndDenoiseDevice");
            }
          }
          catch (Exception localException7)
          {
            try
            {
              if (((JSONObject)localObject12).has("multiVideoSupportNumbers")) {
                j = ((JSONObject)localObject12).getInt("multiVideoSupportNumbers");
              }
            }
            catch (Exception localException7)
            {
              try
              {
                if (((JSONObject)localObject12).has("SpeedDialScreenStyle")) {
                  k = ((JSONObject)localObject12).getInt("SpeedDialScreenStyle");
                }
              }
              catch (Exception localException7)
              {
                try
                {
                  if (((JSONObject)localObject12).has("switchMultiForceUseGroup")) {
                    bool2 = ((JSONObject)localObject12).getBoolean("switchMultiForceUseGroup");
                  }
                }
                catch (Exception localException7)
                {
                  try
                  {
                    if (((JSONObject)localObject12).has("switchMultiForceUseGroupAlertTip"))
                    {
                      localObject2 = ((JSONObject)localObject12).getString("switchMultiForceUseGroupAlertTip");
                      localObject1 = localObject2;
                    }
                    bool2 = false;
                  }
                  catch (Exception localException7)
                  {
                    try
                    {
                      if (((JSONObject)localObject12).has("useRGB2I420Shader"))
                      {
                        m = ((JSONObject)localObject12).getInt("useRGB2I420Shader");
                        bool3 = bool6;
                        localObject10 = localObject11;
                        localObject9 = localObject5;
                        localObject6 = localObject4;
                        localObject8 = localObject3;
                        i7 = i8;
                        i5 = i3;
                        i4 = i9;
                        i6 = i1;
                        bool4 = bool5;
                        try
                        {
                          if (((JSONObject)localObject12).has("isSharpnessSwitch"))
                          {
                            localObject10 = localObject11;
                            localObject9 = localObject5;
                            localObject6 = localObject4;
                            localObject8 = localObject3;
                            i7 = i8;
                            i5 = i3;
                            i4 = i9;
                            i6 = i1;
                            bool4 = bool5;
                            if (((JSONObject)localObject12).getInt("isSharpnessSwitch") == 1)
                            {
                              bool3 = true;
                              break label2754;
                            }
                          }
                          else
                          {
                            n = i1;
                            localObject10 = localObject11;
                            localObject9 = localObject5;
                            localObject6 = localObject4;
                            localObject8 = localObject3;
                            i7 = i8;
                            i5 = i3;
                            i4 = i9;
                            i6 = i1;
                            bool4 = bool3;
                            if (((JSONObject)localObject12).has("sharpnessFPSThreshold"))
                            {
                              localObject10 = localObject11;
                              localObject9 = localObject5;
                              localObject6 = localObject4;
                              localObject8 = localObject3;
                              i7 = i8;
                              i5 = i3;
                              i4 = i9;
                              i6 = i1;
                              bool4 = bool3;
                              n = ((JSONObject)localObject12).getInt("sharpnessFPSThreshold");
                            }
                            i1 = i9;
                            localObject10 = localObject11;
                            localObject9 = localObject5;
                            localObject6 = localObject4;
                            localObject8 = localObject3;
                            i7 = i8;
                            i5 = i3;
                            i4 = i9;
                            i6 = n;
                            bool4 = bool3;
                            if (((JSONObject)localObject12).has("useAADSDeJitterAlgorithmUin"))
                            {
                              localObject10 = localObject11;
                              localObject9 = localObject5;
                              localObject6 = localObject4;
                              localObject8 = localObject3;
                              i7 = i8;
                              i5 = i3;
                              i4 = i9;
                              i6 = n;
                              bool4 = bool3;
                              i1 = ((JSONObject)localObject12).getInt("useAADSDeJitterAlgorithmUin");
                              localObject10 = localObject11;
                              localObject9 = localObject5;
                              localObject6 = localObject4;
                              localObject8 = localObject3;
                              i7 = i8;
                              i5 = i3;
                              i4 = i1;
                              i6 = n;
                              bool4 = bool3;
                              QLog.i("QAVConfigUtils", 1, "JTest. save useAADSDeJitterAlgorithmUin = " + i1);
                            }
                            i2 = i3;
                            localObject10 = localObject11;
                            localObject9 = localObject5;
                            localObject6 = localObject4;
                            localObject8 = localObject3;
                            i7 = i8;
                            i5 = i3;
                            i4 = i1;
                            i6 = n;
                            bool4 = bool3;
                            if (((JSONObject)localObject12).has("enableAADSDeJitterMaxJDelayUin"))
                            {
                              localObject10 = localObject11;
                              localObject9 = localObject5;
                              localObject6 = localObject4;
                              localObject8 = localObject3;
                              i7 = i8;
                              i5 = i3;
                              i4 = i1;
                              i6 = n;
                              bool4 = bool3;
                              i2 = ((JSONObject)localObject12).getInt("enableAADSDeJitterMaxJDelayUin");
                              localObject10 = localObject11;
                              localObject9 = localObject5;
                              localObject6 = localObject4;
                              localObject8 = localObject3;
                              i7 = i8;
                              i5 = i2;
                              i4 = i1;
                              i6 = n;
                              bool4 = bool3;
                              QLog.i("QAVConfigUtils", 1, "JTest. save enableAADSDeJitterMaxJDelayUin = " + i2);
                            }
                            i3 = i8;
                            localObject10 = localObject11;
                            localObject9 = localObject5;
                            localObject6 = localObject4;
                            localObject8 = localObject3;
                            i7 = i8;
                            i5 = i2;
                            i4 = i1;
                            i6 = n;
                            bool4 = bool3;
                            if (((JSONObject)localObject12).has("upLoadWhenGetNewData"))
                            {
                              localObject10 = localObject11;
                              localObject9 = localObject5;
                              localObject6 = localObject4;
                              localObject8 = localObject3;
                              i7 = i8;
                              i5 = i2;
                              i4 = i1;
                              i6 = n;
                              bool4 = bool3;
                              i3 = ((JSONObject)localObject12).getInt("upLoadWhenGetNewData");
                            }
                            localObject2 = localObject3;
                            localObject10 = localObject11;
                            localObject9 = localObject5;
                            localObject6 = localObject4;
                            localObject8 = localObject3;
                            i7 = i3;
                            i5 = i2;
                            i4 = i1;
                            i6 = n;
                            bool4 = bool3;
                            if (((JSONObject)localObject12).has("ptuNewRenderLimit"))
                            {
                              localObject10 = localObject11;
                              localObject9 = localObject5;
                              localObject6 = localObject4;
                              localObject8 = localObject3;
                              i7 = i3;
                              i5 = i2;
                              i4 = i1;
                              i6 = n;
                              bool4 = bool3;
                              localObject2 = ((JSONObject)localObject12).getString("ptuNewRenderLimit");
                            }
                            localObject3 = localObject4;
                            localObject10 = localObject11;
                            localObject9 = localObject5;
                            localObject6 = localObject4;
                            localObject8 = localObject2;
                            i7 = i3;
                            i5 = i2;
                            i4 = i1;
                            i6 = n;
                            bool4 = bool3;
                            if (((JSONObject)localObject12).has("moreBtnTips"))
                            {
                              localObject10 = localObject11;
                              localObject9 = localObject5;
                              localObject6 = localObject4;
                              localObject8 = localObject2;
                              i7 = i3;
                              i5 = i2;
                              i4 = i1;
                              i6 = n;
                              bool4 = bool3;
                              localObject3 = ((JSONObject)localObject12).getJSONArray("moreBtnTips").toString();
                              localObject10 = localObject11;
                              localObject9 = localObject5;
                              localObject6 = localObject3;
                              localObject8 = localObject2;
                              i7 = i3;
                              i5 = i2;
                              i4 = i1;
                              i6 = n;
                              bool4 = bool3;
                              QLog.i("QAVConfigUtils", 1, "MoreBtnTips. downloaded moreBtnTipsJson = " + (String)localObject3);
                            }
                            localObject4 = localObject5;
                            localObject10 = localObject11;
                            localObject9 = localObject5;
                            localObject6 = localObject3;
                            localObject8 = localObject2;
                            i7 = i3;
                            i5 = i2;
                            i4 = i1;
                            i6 = n;
                            bool4 = bool3;
                            if (((JSONObject)localObject12).has("ptuAfterTreamentLimit"))
                            {
                              localObject10 = localObject11;
                              localObject9 = localObject5;
                              localObject6 = localObject3;
                              localObject8 = localObject2;
                              i7 = i3;
                              i5 = i2;
                              i4 = i1;
                              i6 = n;
                              bool4 = bool3;
                              localObject4 = ((JSONObject)localObject12).getString("ptuAfterTreamentLimit");
                            }
                            localObject5 = localObject11;
                            localObject10 = localObject11;
                            localObject9 = localObject4;
                            localObject6 = localObject3;
                            localObject8 = localObject2;
                            i7 = i3;
                            i5 = i2;
                            i4 = i1;
                            i6 = n;
                            bool4 = bool3;
                            if (((JSONObject)localObject12).has("ptuAfterTreamentCanvas"))
                            {
                              localObject10 = localObject11;
                              localObject9 = localObject4;
                              localObject6 = localObject3;
                              localObject8 = localObject2;
                              i7 = i3;
                              i5 = i2;
                              i4 = i1;
                              i6 = n;
                              bool4 = bool3;
                              localObject5 = ((JSONObject)localObject12).getString("ptuAfterTreamentCanvas");
                            }
                            localObject10 = localObject5;
                            localObject9 = localObject4;
                            localObject6 = localObject3;
                            localObject8 = localObject2;
                            i7 = i3;
                            i5 = i2;
                            i4 = i1;
                            i6 = n;
                            bool4 = bool3;
                            if (!((JSONObject)localObject12).has("isAllowedControlMicAfterBeMuted")) {
                              continue;
                            }
                            localObject10 = localObject5;
                            localObject9 = localObject4;
                            localObject6 = localObject3;
                            localObject8 = localObject2;
                            i7 = i3;
                            i5 = i2;
                            i4 = i1;
                            i6 = n;
                            bool4 = bool3;
                            bool5 = ((JSONObject)localObject12).getBoolean("isAllowedControlMicAfterBeMuted");
                          }
                        }
                        catch (Exception localException10)
                        {
                          bool6 = false;
                          localObject2 = localObject9;
                          localObject3 = localException8;
                          localObject4 = localObject8;
                          n = i6;
                          localObject5 = localObject1;
                          bool3 = bool2;
                          i3 = k;
                          i2 = j;
                          bool5 = bool1;
                          localObject7 = localException10;
                          i1 = i;
                          bool1 = bool6;
                          localObject1 = localObject10;
                          i = i7;
                          j = i5;
                          k = i4;
                          bool2 = bool4;
                          bool4 = bool3;
                          bool3 = bool5;
                          continue;
                          bool5 = false;
                          continue;
                        }
                        try
                        {
                          QLog.i("QAVConfigUtils", 1, "JTest. save isAllowedControlMicAfterBeMuted = " + bool5);
                          i11 = i;
                          l2 = l1;
                          bool8 = bool1;
                          i10 = j;
                          i9 = k;
                          bool7 = bool2;
                          localObject12 = localObject1;
                          bool6 = bool3;
                          i8 = n;
                          i7 = m;
                          i6 = i1;
                          i5 = i2;
                          i4 = i3;
                          localObject11 = localObject2;
                          localObject10 = localObject3;
                          localObject9 = localObject4;
                          localObject8 = localObject5;
                          localObject1 = EffectConfigBase.a(287, EffectConfigBase.jdField_d_of_type_JavaLangString).edit();
                          ((SharedPreferences.Editor)localObject1).putInt("isBlueToothSwitch", i11);
                          ((SharedPreferences.Editor)localObject1).putLong("bluetoothDelayTime", l2);
                          ((SharedPreferences.Editor)localObject1).putBoolean("LowlightAndDenoiseDevice", bool8);
                          ((SharedPreferences.Editor)localObject1).putInt("multiVideoSupportNumbers", i10);
                          ((SharedPreferences.Editor)localObject1).putInt("SpeedDialScreenStyle", i9);
                          ((SharedPreferences.Editor)localObject1).putBoolean("switchMultiForceUseGroup", bool7);
                          ((SharedPreferences.Editor)localObject1).putString("switchMultiForceUseGroupAlertTip", (String)localObject12);
                          ((SharedPreferences.Editor)localObject1).putInt("useRGB2I420Shader", i7);
                          ((SharedPreferences.Editor)localObject1).putBoolean("isSharpnessSwitch", bool6);
                          ((SharedPreferences.Editor)localObject1).putInt("sharpnessFPSThreshold", i8);
                          ((SharedPreferences.Editor)localObject1).putInt("useAADSDeJitterAlgorithmUin", i6);
                          ((SharedPreferences.Editor)localObject1).putInt("enableAADSDeJitterMaxJDelayUin", i5);
                          ((SharedPreferences.Editor)localObject1).putInt("upLoadWhenGetNewData", i4);
                          ((SharedPreferences.Editor)localObject1).putString("ptuNewRenderLimit", (String)localObject11);
                          ((SharedPreferences.Editor)localObject1).putString("moreBtnTips", (String)localObject10);
                          ((SharedPreferences.Editor)localObject1).putString("ptuAfterTreamentLimit", localObject9);
                          ((SharedPreferences.Editor)localObject1).putString("ptuAfterTreamentCanvas", (String)localObject8);
                          ((SharedPreferences.Editor)localObject1).putBoolean("isAllowedControlMicAfterBeMuted", bool5);
                          ((SharedPreferences.Editor)localObject1).commit();
                          if (QLog.isColorLevel()) {
                            QLog.i("QAVConfigUtils", 2, "parseAndSave [" + paramString + "]");
                          }
                          return;
                        }
                        catch (Exception localException9)
                        {
                          localObject7 = localObject2;
                          localObject8 = localObject1;
                          bool4 = bool2;
                          i4 = k;
                          i5 = j;
                          bool6 = bool1;
                          i6 = i;
                          bool1 = bool5;
                          localObject1 = localObject5;
                          localObject2 = localObject4;
                          localObject4 = localObject7;
                          i = i3;
                          j = i2;
                          k = i1;
                          bool2 = bool3;
                          localObject5 = localObject8;
                          i3 = i4;
                          i2 = i5;
                          bool3 = bool6;
                          i1 = i6;
                          localObject7 = localException9;
                          continue;
                        }
                        bool3 = false;
                        break label2754;
                        localException1 = localException1;
                        localObject8 = "";
                        localObject2 = "";
                        localObject3 = "";
                        localObject4 = "";
                        i = -1;
                        i5 = -1;
                        k = -1;
                        m = -1;
                        bool1 = false;
                        bool2 = false;
                        n = 7;
                        i1 = j;
                        i3 = i4;
                        localObject5 = localObject1;
                        j = i5;
                        localObject1 = localObject8;
                        bool5 = bool1;
                        localObject8 = localObject1;
                        localObject9 = localObject2;
                        localObject10 = localObject3;
                        localObject11 = localObject4;
                        i4 = i;
                        i5 = j;
                        i6 = k;
                        i7 = m;
                        i8 = n;
                        bool6 = bool2;
                        localObject12 = localObject5;
                        bool7 = bool4;
                        i9 = i3;
                        i10 = i2;
                        bool8 = bool3;
                        l2 = l1;
                        i11 = i1;
                        if (!QLog.isColorLevel()) {
                          continue;
                        }
                        QLog.i("handleGetQAVGeneralConfig", 2, " parse json: " + QLog.getStackTraceString(localException1));
                        bool5 = bool1;
                        localObject8 = localObject1;
                        localObject9 = localObject2;
                        localObject10 = localObject3;
                        localObject11 = localObject4;
                        i4 = i;
                        i5 = j;
                        i6 = k;
                        i7 = m;
                        i8 = n;
                        bool6 = bool2;
                        localObject12 = localObject5;
                        bool7 = bool4;
                        i9 = i3;
                        i10 = i2;
                        bool8 = bool3;
                        l2 = l1;
                        i11 = i1;
                        continue;
                        localException2 = localException2;
                        i1 = i;
                        localObject2 = "";
                        localObject3 = "";
                        localObject4 = "";
                        i = -1;
                        j = -1;
                        k = -1;
                        m = -1;
                        bool1 = false;
                        localObject8 = "";
                        localObject5 = localObject1;
                        n = 7;
                        bool2 = false;
                        localObject1 = localObject8;
                        i3 = i4;
                        continue;
                        localException3 = localException3;
                        i1 = i;
                        localObject3 = "";
                        localObject4 = "";
                        i = -1;
                        j = -1;
                        k = -1;
                        m = -1;
                        bool1 = false;
                        localObject8 = "";
                        localObject2 = "";
                        n = 7;
                        bool2 = false;
                        localObject5 = localObject1;
                        localObject1 = localObject8;
                        i3 = i4;
                        continue;
                        localException4 = localException4;
                        bool3 = bool1;
                        i1 = i;
                        localObject4 = "";
                        i = -1;
                        j = -1;
                        k = -1;
                        m = -1;
                        bool1 = false;
                        localObject8 = "";
                        localObject2 = "";
                        localObject3 = "";
                        bool2 = false;
                        localObject5 = localObject1;
                        n = 7;
                        localObject1 = localObject8;
                        i3 = i4;
                        continue;
                        localException5 = localException5;
                        i2 = j;
                        bool3 = bool1;
                        i1 = i;
                        i = -1;
                        j = -1;
                        k = -1;
                        m = -1;
                        bool1 = false;
                        localObject8 = "";
                        localObject2 = "";
                        localObject3 = "";
                        localObject4 = "";
                        localObject5 = localObject1;
                        n = 7;
                        bool2 = false;
                        localObject1 = localObject8;
                        i3 = i4;
                        continue;
                        localException6 = localException6;
                        i3 = k;
                        i2 = j;
                        bool3 = bool1;
                        i1 = i;
                        j = -1;
                        k = -1;
                        m = -1;
                        bool1 = false;
                        localObject8 = "";
                        localObject2 = "";
                        localObject3 = "";
                        localObject4 = "";
                        i = -1;
                        bool2 = false;
                        localObject5 = localObject1;
                        n = 7;
                        localObject1 = localObject8;
                        continue;
                        localException7 = localException7;
                        bool4 = bool2;
                        i3 = k;
                        i2 = j;
                        bool3 = bool1;
                        i1 = i;
                        k = -1;
                        m = -1;
                        bool1 = false;
                        localObject8 = "";
                        localObject2 = "";
                        localObject3 = "";
                        localObject4 = "";
                        i = -1;
                        j = -1;
                        localObject5 = localObject1;
                        n = 7;
                        bool2 = false;
                        localObject1 = localObject8;
                        continue;
                      }
                    }
                    catch (Exception localException8)
                    {
                      n = 7;
                      bool5 = false;
                      localObject5 = localObject1;
                      bool4 = bool2;
                      i3 = k;
                      i2 = j;
                      bool3 = bool1;
                      i1 = i;
                      m = -1;
                      bool1 = false;
                      localObject1 = "";
                      localObject2 = "";
                      localObject3 = "";
                      localObject4 = "";
                      i = -1;
                      j = -1;
                      k = -1;
                      bool2 = bool5;
                      continue;
                      m = -1;
                      continue;
                    }
                    continue;
                  }
                  continue;
                }
                k = 0;
                continue;
              }
              j = -1;
              continue;
            }
            bool1 = true;
            continue;
          }
          l1 = 1000L;
          continue;
        }
        continue;
      }
      Object localObject8 = "";
      String str1 = "";
      Object localObject10 = "";
      String str2 = "";
      i4 = -1;
      int i5 = -1;
      int i6 = -1;
      int i7 = -1;
      bool5 = false;
      bool6 = false;
      i8 = 7;
      Object localObject12 = localObject1;
      i9 = i;
      int i10 = i2;
      long l2 = l1;
    }
  }
  
  public static boolean a()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (-1 != jdField_a_of_type_Int) {
      return jdField_a_of_type_Int == 1;
    }
    for (;;)
    {
      try
      {
        if (-1 == jdField_a_of_type_Int) {
          break;
        }
        if (jdField_a_of_type_Int == 1) {
          return bool1;
        }
      }
      finally {}
      bool1 = false;
    }
    SharedPreferences localSharedPreferences = EffectConfigBase.a(287, EffectConfigBase.jdField_d_of_type_JavaLangString);
    jdField_a_of_type_Int = localSharedPreferences.getInt("isBlueToothSwitch", 1);
    jdField_a_of_type_Long = localSharedPreferences.getLong("bluetoothDelayTime", 1000L);
    if (jdField_a_of_type_Int == 1) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public static boolean a(long paramLong)
  {
    boolean bool = false;
    int i = EffectConfigBase.a(287, EffectConfigBase.jdField_d_of_type_JavaLangString).getInt("useAADSDeJitterAlgorithmUin", -1);
    if (i <= -1) {}
    for (;;)
    {
      QLog.i("QAVConfigUtils", 1, "JTest. read useAADSDeJitterAlgorithmUin = " + i + ", useAADSDeJitterAlgorithm = " + bool);
      return bool;
      if (paramLong % 10L <= i) {
        bool = true;
      }
    }
  }
  
  public static int b()
  {
    if (jdField_e_of_type_Int == -1) {
      jdField_e_of_type_Int = EffectConfigBase.a(287, EffectConfigBase.jdField_d_of_type_JavaLangString).getInt("sharpnessFPSThreshold", 7);
    }
    return jdField_e_of_type_Int * 10;
  }
  
  public static String b()
  {
    if (jdField_c_of_type_JavaLangString == null) {
      jdField_c_of_type_JavaLangString = EffectConfigBase.a(287, EffectConfigBase.jdField_d_of_type_JavaLangString).getString("ptuNewRenderLimit", "");
    }
    if (QLog.isColorLevel()) {
      QLog.i("QAVConfigUtils", 2, "getPtuNewRenderLimit, limit[" + jdField_c_of_type_JavaLangString + "]");
    }
    return jdField_c_of_type_JavaLangString;
  }
  
  public static boolean b()
  {
    if (jdField_b_of_type_Int == -1) {
      if (!EffectConfigBase.a(287, EffectConfigBase.jdField_d_of_type_JavaLangString).getBoolean("LowlightAndDenoiseDevice", true)) {
        break label40;
      }
    }
    label40:
    for (jdField_b_of_type_Int = 1; jdField_b_of_type_Int == 1; jdField_b_of_type_Int = 0) {
      return true;
    }
    return false;
  }
  
  public static boolean b(long paramLong)
  {
    boolean bool = false;
    int i = EffectConfigBase.a(287, EffectConfigBase.jdField_d_of_type_JavaLangString).getInt("enableAADSDeJitterMaxJDelayUin", -1);
    if (i <= -1) {}
    for (;;)
    {
      QLog.i("QAVConfigUtils", 1, "JTest. read enableAADSDeJitterMaxJDelayUin = " + i + ", enableAADSDeJitterMaxJDelay = " + bool);
      return bool;
      if (paramLong % 10L <= i) {
        bool = true;
      }
    }
  }
  
  public static String c()
  {
    if (jdField_d_of_type_JavaLangString == null) {
      jdField_d_of_type_JavaLangString = EffectConfigBase.a(287, EffectConfigBase.jdField_d_of_type_JavaLangString).getString("ptuAfterTreamentLimit", "");
    }
    return jdField_d_of_type_JavaLangString;
  }
  
  public static boolean c()
  {
    boolean bool = false;
    if (jdField_d_of_type_Int == -1) {
      jdField_d_of_type_Int = EffectConfigBase.a(287, EffectConfigBase.jdField_d_of_type_JavaLangString).getInt("SpeedDialScreenStyle", 0);
    }
    if (jdField_d_of_type_Int == 0) {
      bool = true;
    }
    return bool;
  }
  
  public static String d()
  {
    if (jdField_e_of_type_JavaLangString == null) {
      jdField_e_of_type_JavaLangString = EffectConfigBase.a(287, EffectConfigBase.jdField_d_of_type_JavaLangString).getString("ptuAfterTreamentCanvas", "");
    }
    return jdField_e_of_type_JavaLangString;
  }
  
  public static boolean d()
  {
    boolean bool2 = false;
    if (jdField_a_of_type_JavaLangBoolean == null)
    {
      SharedPreferences localSharedPreferences = EffectConfigBase.a(287, EffectConfigBase.jdField_d_of_type_JavaLangString);
      boolean bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 19)
      {
        bool1 = bool2;
        if (localSharedPreferences.getBoolean("isSharpnessSwitch", false)) {
          bool1 = true;
        }
      }
      jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool1);
    }
    return jdField_a_of_type_JavaLangBoolean.booleanValue();
  }
  
  public static boolean e()
  {
    a();
    return jdField_b_of_type_JavaLangBoolean.booleanValue();
  }
  
  public static boolean f()
  {
    if (f == -1) {
      f = EffectConfigBase.a(287, EffectConfigBase.jdField_d_of_type_JavaLangString).getInt("useRGB2I420Shader", 0);
    }
    return f == 1;
  }
  
  public static boolean g()
  {
    if (g == -1) {
      g = EffectConfigBase.a(287, EffectConfigBase.jdField_d_of_type_JavaLangString).getInt("upLoadWhenGetNewData", 0);
    }
    return g == 1;
  }
  
  public static boolean h()
  {
    boolean bool = EffectConfigBase.a(287, EffectConfigBase.jdField_d_of_type_JavaLangString).getBoolean("isAllowedControlMicAfterBeMuted", false);
    QLog.i("QAVConfigUtils", 1, "JTest. read isAllowedControlMicAfterBeMuted = " + bool);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mhr
 * JD-Core Version:    0.7.0.1
 */