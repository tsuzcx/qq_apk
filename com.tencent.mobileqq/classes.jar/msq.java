import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class msq
{
  private static int jdField_a_of_type_Int = -1;
  private static long jdField_a_of_type_Long = 1000L;
  private static Boolean jdField_a_of_type_JavaLangBoolean;
  private static final String jdField_a_of_type_JavaLangString = ajyc.a(2131708899);
  private static int jdField_b_of_type_Int = -1;
  private static volatile Boolean jdField_b_of_type_JavaLangBoolean;
  private static String jdField_b_of_type_JavaLangString;
  private static volatile int c = -1;
  private static int d = -1;
  private static int e = -1;
  private static int f = -1;
  private static int g = -1;
  
  public static int a()
  {
    if (c == -1)
    {
      c = EffectConfigBase.a(287, EffectConfigBase.c).getInt("multiVideoSupportNumbers", -1);
      if (c == -1) {
        c = 5;
      }
      return c;
    }
    return c;
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
  
  public static String a(@NonNull String paramString)
  {
    return EffectConfigBase.a(287, EffectConfigBase.c).getString(paramString, "");
  }
  
  public static msr a(int paramInt)
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
        msr localmsr = new msr();
        localmsr.jdField_b_of_type_Int = 2147483647;
        i = 0;
        if (i < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          if ((localJSONObject.getInt("type") == paramInt) && (localJSONObject.getInt("priority") < localmsr.jdField_b_of_type_Int))
          {
            localmsr.jdField_a_of_type_Int = localJSONObject.getInt("id");
            localmsr.jdField_a_of_type_JavaLangString = localJSONObject.getString("url");
            localmsr.jdField_b_of_type_Int = localJSONObject.getInt("priority");
            localmsr.c = localJSONObject.getInt("type");
          }
        }
        else if (localmsr.jdField_b_of_type_Int < 2147483647)
        {
          QLog.i("QAVConfigUtils", 1, "MoreBtnTips. getHighestPriorityMoreBtnTips. highest. id = " + localmsr.jdField_a_of_type_Int + ", url = " + localmsr.jdField_a_of_type_JavaLangString + ", priority = " + localmsr.jdField_b_of_type_Int + ", type = " + localmsr.c);
          return localmsr;
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
    Object localObject = EffectConfigBase.a(287, EffectConfigBase.c).getString("moreBtnTips", "");
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
      SharedPreferences localSharedPreferences = EffectConfigBase.a(287, EffectConfigBase.c);
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
        new msr().jdField_b_of_type_Int = 2147483647;
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
          localObject = EffectConfigBase.a(287, EffectConfigBase.c).edit();
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
    boolean bool1 = true;
    int i2 = -1;
    int i4 = 0;
    int i = 0;
    boolean bool4 = false;
    boolean bool2 = false;
    Object localObject1 = jdField_a_of_type_JavaLangString;
    boolean bool9 = false;
    boolean bool5 = false;
    int i1 = 7;
    int i9 = -1;
    int i3 = -1;
    int i8 = -1;
    Object localObject3 = "";
    Object localObject4 = "";
    Object localObject5 = "";
    Object localObject7 = "";
    boolean bool7 = false;
    boolean bool8 = false;
    Object localObject13 = "";
    String str2 = "";
    if (QLog.isColorLevel()) {
      QLog.i("QAVConfigUtils", 2, " parseAndSave parse json = " + paramString);
    }
    if (!TextUtils.isEmpty(paramString)) {}
    label3294:
    for (;;)
    {
      try
      {
        localObject14 = new JSONObject(paramString);
        if (((JSONObject)localObject14).has("isBlueToothSwitchForAndroid")) {
          i = ((JSONObject)localObject14).getInt("isBlueToothSwitchForAndroid");
        }
      }
      catch (Exception localException7)
      {
        try
        {
          if (((JSONObject)localObject14).has("bluetoothDelayTime"))
          {
            l2 = ((JSONObject)localObject14).getLong("bluetoothDelayTime");
            l1 = l2;
          }
          int k;
          Object localObject2;
          int m;
          Object localObject10;
          Object localObject6;
          int n;
          Object localObject8;
          i = 1;
        }
        catch (Exception localException7)
        {
          try
          {
            if (((JSONObject)localObject14).has("LowlightAndDenoiseDevice")) {
              bool1 = ((JSONObject)localObject14).getBoolean("LowlightAndDenoiseDevice");
            }
          }
          catch (Exception localException7)
          {
            try
            {
              if (((JSONObject)localObject14).has("multiVideoSupportNumbers")) {
                j = ((JSONObject)localObject14).getInt("multiVideoSupportNumbers");
              }
            }
            catch (Exception localException7)
            {
              try
              {
                if (((JSONObject)localObject14).has("SpeedDialScreenStyle")) {
                  k = ((JSONObject)localObject14).getInt("SpeedDialScreenStyle");
                }
              }
              catch (Exception localException7)
              {
                try
                {
                  if (((JSONObject)localObject14).has("switchMultiForceUseGroup")) {
                    bool2 = ((JSONObject)localObject14).getBoolean("switchMultiForceUseGroup");
                  }
                }
                catch (Exception localException7)
                {
                  try
                  {
                    if (((JSONObject)localObject14).has("switchMultiForceUseGroupAlertTip"))
                    {
                      localObject2 = ((JSONObject)localObject14).getString("switchMultiForceUseGroupAlertTip");
                      localObject1 = localObject2;
                    }
                    bool2 = false;
                  }
                  catch (Exception localException7)
                  {
                    try
                    {
                      if (((JSONObject)localObject14).has("useRGB2I420Shader"))
                      {
                        m = ((JSONObject)localObject14).getInt("useRGB2I420Shader");
                        bool3 = bool5;
                        localObject12 = localObject13;
                        bool6 = bool7;
                        localObject11 = localObject7;
                        localObject10 = localObject5;
                        localObject6 = localObject4;
                        localObject9 = localObject3;
                        i7 = i8;
                        i5 = i3;
                        i4 = i9;
                        i6 = i1;
                        bool5 = bool9;
                        try
                        {
                          if (((JSONObject)localObject14).has("isSharpnessSwitch"))
                          {
                            localObject12 = localObject13;
                            bool6 = bool7;
                            localObject11 = localObject7;
                            localObject10 = localObject5;
                            localObject6 = localObject4;
                            localObject9 = localObject3;
                            i7 = i8;
                            i5 = i3;
                            i4 = i9;
                            i6 = i1;
                            bool5 = bool9;
                            if (((JSONObject)localObject14).getInt("isSharpnessSwitch") == 1)
                            {
                              bool3 = true;
                              break label3294;
                            }
                          }
                          else
                          {
                            n = i1;
                            localObject12 = localObject13;
                            bool6 = bool7;
                            localObject11 = localObject7;
                            localObject10 = localObject5;
                            localObject6 = localObject4;
                            localObject9 = localObject3;
                            i7 = i8;
                            i5 = i3;
                            i4 = i9;
                            i6 = i1;
                            bool5 = bool3;
                            if (((JSONObject)localObject14).has("sharpnessFPSThreshold"))
                            {
                              localObject12 = localObject13;
                              bool6 = bool7;
                              localObject11 = localObject7;
                              localObject10 = localObject5;
                              localObject6 = localObject4;
                              localObject9 = localObject3;
                              i7 = i8;
                              i5 = i3;
                              i4 = i9;
                              i6 = i1;
                              bool5 = bool3;
                              n = ((JSONObject)localObject14).getInt("sharpnessFPSThreshold");
                            }
                            i1 = i9;
                            localObject12 = localObject13;
                            bool6 = bool7;
                            localObject11 = localObject7;
                            localObject10 = localObject5;
                            localObject6 = localObject4;
                            localObject9 = localObject3;
                            i7 = i8;
                            i5 = i3;
                            i4 = i9;
                            i6 = n;
                            bool5 = bool3;
                            if (((JSONObject)localObject14).has("useAADSDeJitterAlgorithmUin"))
                            {
                              localObject12 = localObject13;
                              bool6 = bool7;
                              localObject11 = localObject7;
                              localObject10 = localObject5;
                              localObject6 = localObject4;
                              localObject9 = localObject3;
                              i7 = i8;
                              i5 = i3;
                              i4 = i9;
                              i6 = n;
                              bool5 = bool3;
                              i1 = ((JSONObject)localObject14).getInt("useAADSDeJitterAlgorithmUin");
                              localObject12 = localObject13;
                              bool6 = bool7;
                              localObject11 = localObject7;
                              localObject10 = localObject5;
                              localObject6 = localObject4;
                              localObject9 = localObject3;
                              i7 = i8;
                              i5 = i3;
                              i4 = i1;
                              i6 = n;
                              bool5 = bool3;
                              QLog.i("QAVConfigUtils", 1, "JTest. save useAADSDeJitterAlgorithmUin = " + i1);
                            }
                            i2 = i3;
                            localObject12 = localObject13;
                            bool6 = bool7;
                            localObject11 = localObject7;
                            localObject10 = localObject5;
                            localObject6 = localObject4;
                            localObject9 = localObject3;
                            i7 = i8;
                            i5 = i3;
                            i4 = i1;
                            i6 = n;
                            bool5 = bool3;
                            if (((JSONObject)localObject14).has("enableAADSDeJitterMaxJDelayUin"))
                            {
                              localObject12 = localObject13;
                              bool6 = bool7;
                              localObject11 = localObject7;
                              localObject10 = localObject5;
                              localObject6 = localObject4;
                              localObject9 = localObject3;
                              i7 = i8;
                              i5 = i3;
                              i4 = i1;
                              i6 = n;
                              bool5 = bool3;
                              i2 = ((JSONObject)localObject14).getInt("enableAADSDeJitterMaxJDelayUin");
                              localObject12 = localObject13;
                              bool6 = bool7;
                              localObject11 = localObject7;
                              localObject10 = localObject5;
                              localObject6 = localObject4;
                              localObject9 = localObject3;
                              i7 = i8;
                              i5 = i2;
                              i4 = i1;
                              i6 = n;
                              bool5 = bool3;
                              QLog.i("QAVConfigUtils", 1, "JTest. save enableAADSDeJitterMaxJDelayUin = " + i2);
                            }
                            i3 = i8;
                            localObject12 = localObject13;
                            bool6 = bool7;
                            localObject11 = localObject7;
                            localObject10 = localObject5;
                            localObject6 = localObject4;
                            localObject9 = localObject3;
                            i7 = i8;
                            i5 = i2;
                            i4 = i1;
                            i6 = n;
                            bool5 = bool3;
                            if (((JSONObject)localObject14).has("upLoadWhenGetNewData"))
                            {
                              localObject12 = localObject13;
                              bool6 = bool7;
                              localObject11 = localObject7;
                              localObject10 = localObject5;
                              localObject6 = localObject4;
                              localObject9 = localObject3;
                              i7 = i8;
                              i5 = i2;
                              i4 = i1;
                              i6 = n;
                              bool5 = bool3;
                              i3 = ((JSONObject)localObject14).getInt("upLoadWhenGetNewData");
                            }
                            localObject2 = localObject3;
                            localObject12 = localObject13;
                            bool6 = bool7;
                            localObject11 = localObject7;
                            localObject10 = localObject5;
                            localObject6 = localObject4;
                            localObject9 = localObject3;
                            i7 = i3;
                            i5 = i2;
                            i4 = i1;
                            i6 = n;
                            bool5 = bool3;
                            if (((JSONObject)localObject14).has("ptuNewRenderLimit"))
                            {
                              localObject12 = localObject13;
                              bool6 = bool7;
                              localObject11 = localObject7;
                              localObject10 = localObject5;
                              localObject6 = localObject4;
                              localObject9 = localObject3;
                              i7 = i3;
                              i5 = i2;
                              i4 = i1;
                              i6 = n;
                              bool5 = bool3;
                              localObject2 = ((JSONObject)localObject14).getString("ptuNewRenderLimit");
                            }
                            localObject3 = localObject4;
                            localObject12 = localObject13;
                            bool6 = bool7;
                            localObject11 = localObject7;
                            localObject10 = localObject5;
                            localObject6 = localObject4;
                            localObject9 = localObject2;
                            i7 = i3;
                            i5 = i2;
                            i4 = i1;
                            i6 = n;
                            bool5 = bool3;
                            if (((JSONObject)localObject14).has("moreBtnTips"))
                            {
                              localObject12 = localObject13;
                              bool6 = bool7;
                              localObject11 = localObject7;
                              localObject10 = localObject5;
                              localObject6 = localObject4;
                              localObject9 = localObject2;
                              i7 = i3;
                              i5 = i2;
                              i4 = i1;
                              i6 = n;
                              bool5 = bool3;
                              localObject3 = ((JSONObject)localObject14).getJSONArray("moreBtnTips").toString();
                              localObject12 = localObject13;
                              bool6 = bool7;
                              localObject11 = localObject7;
                              localObject10 = localObject5;
                              localObject6 = localObject3;
                              localObject9 = localObject2;
                              i7 = i3;
                              i5 = i2;
                              i4 = i1;
                              i6 = n;
                              bool5 = bool3;
                              QLog.i("QAVConfigUtils", 1, "MoreBtnTips. downloaded moreBtnTipsJson = " + (String)localObject3);
                            }
                            localObject4 = localObject5;
                            localObject12 = localObject13;
                            bool6 = bool7;
                            localObject11 = localObject7;
                            localObject10 = localObject5;
                            localObject6 = localObject3;
                            localObject9 = localObject2;
                            i7 = i3;
                            i5 = i2;
                            i4 = i1;
                            i6 = n;
                            bool5 = bool3;
                            if (((JSONObject)localObject14).has("ptuAfterTreamentLimit"))
                            {
                              localObject12 = localObject13;
                              bool6 = bool7;
                              localObject11 = localObject7;
                              localObject10 = localObject5;
                              localObject6 = localObject3;
                              localObject9 = localObject2;
                              i7 = i3;
                              i5 = i2;
                              i4 = i1;
                              i6 = n;
                              bool5 = bool3;
                              localObject4 = ((JSONObject)localObject14).getString("ptuAfterTreamentLimit");
                            }
                            localObject5 = localObject7;
                            localObject12 = localObject13;
                            bool6 = bool7;
                            localObject11 = localObject7;
                            localObject10 = localObject4;
                            localObject6 = localObject3;
                            localObject9 = localObject2;
                            i7 = i3;
                            i5 = i2;
                            i4 = i1;
                            i6 = n;
                            bool5 = bool3;
                            if (((JSONObject)localObject14).has("ptuAfterTreamentCanvas"))
                            {
                              localObject12 = localObject13;
                              bool6 = bool7;
                              localObject11 = localObject7;
                              localObject10 = localObject4;
                              localObject6 = localObject3;
                              localObject9 = localObject2;
                              i7 = i3;
                              i5 = i2;
                              i4 = i1;
                              i6 = n;
                              bool5 = bool3;
                              localObject5 = ((JSONObject)localObject14).getString("ptuAfterTreamentCanvas");
                            }
                            bool4 = bool8;
                            localObject12 = localObject13;
                            bool6 = bool7;
                            localObject11 = localObject5;
                            localObject10 = localObject4;
                            localObject6 = localObject3;
                            localObject9 = localObject2;
                            i7 = i3;
                            i5 = i2;
                            i4 = i1;
                            i6 = n;
                            bool5 = bool3;
                            if (((JSONObject)localObject14).has("isAllowedControlMicAfterBeMuted"))
                            {
                              localObject12 = localObject13;
                              bool6 = bool7;
                              localObject11 = localObject5;
                              localObject10 = localObject4;
                              localObject6 = localObject3;
                              localObject9 = localObject2;
                              i7 = i3;
                              i5 = i2;
                              i4 = i1;
                              i6 = n;
                              bool5 = bool3;
                              bool4 = ((JSONObject)localObject14).getBoolean("isAllowedControlMicAfterBeMuted");
                            }
                          }
                        }
                        catch (Exception localException9)
                        {
                          localObject2 = localObject11;
                          localObject3 = localObject10;
                          localObject4 = localObject6;
                          localObject5 = localObject9;
                          n = i6;
                          localObject6 = localObject1;
                          bool4 = bool2;
                          i3 = k;
                          i2 = j;
                          bool3 = bool1;
                          i1 = i;
                          localObject1 = localObject12;
                          bool1 = bool6;
                          i = i7;
                          j = i5;
                          k = i4;
                          bool2 = bool5;
                          continue;
                        }
                        try
                        {
                          QLog.i("QAVConfigUtils", 1, "JTest. save isAllowedControlMicAfterBeMuted = " + bool4);
                          localObject7 = localObject13;
                          localObject12 = localObject13;
                          bool6 = bool4;
                          localObject11 = localObject5;
                          localObject10 = localObject4;
                          localObject6 = localObject3;
                          localObject9 = localObject2;
                          i7 = i3;
                          i5 = i2;
                          i4 = i1;
                          i6 = n;
                          bool5 = bool3;
                          if (((JSONObject)localObject14).has("machineMiddleLine"))
                          {
                            localObject12 = localObject13;
                            bool6 = bool4;
                            localObject11 = localObject5;
                            localObject10 = localObject4;
                            localObject6 = localObject3;
                            localObject9 = localObject2;
                            i7 = i3;
                            i5 = i2;
                            i4 = i1;
                            i6 = n;
                            bool5 = bool3;
                            localObject7 = ((JSONObject)localObject14).getString("machineMiddleLine");
                          }
                          localObject12 = localObject7;
                          bool6 = bool4;
                          localObject11 = localObject5;
                          localObject10 = localObject4;
                          localObject6 = localObject3;
                          localObject9 = localObject2;
                          i7 = i3;
                          i5 = i2;
                          i4 = i1;
                          i6 = n;
                          bool5 = bool3;
                          if (!((JSONObject)localObject14).has("machineHighLine")) {
                            continue;
                          }
                          localObject12 = localObject7;
                          bool6 = bool4;
                          localObject11 = localObject5;
                          localObject10 = localObject4;
                          localObject6 = localObject3;
                          localObject9 = localObject2;
                          i7 = i3;
                          i5 = i2;
                          i4 = i1;
                          i6 = n;
                          bool5 = bool3;
                          localObject13 = ((JSONObject)localObject14).getString("machineHighLine");
                          localObject6 = localObject13;
                        }
                        catch (Exception localException10)
                        {
                          localObject11 = "";
                          localObject6 = localObject3;
                          localObject8 = localObject2;
                          localObject9 = localObject1;
                          bool5 = bool2;
                          i4 = k;
                          i5 = j;
                          bool6 = bool1;
                          i6 = i;
                          localObject1 = localObject11;
                          bool1 = bool4;
                          localObject2 = localObject5;
                          localObject3 = localObject4;
                          localObject4 = localObject6;
                          localObject5 = localObject8;
                          i = i3;
                          j = i2;
                          k = i1;
                          bool2 = bool3;
                          localObject6 = localObject9;
                          bool4 = bool5;
                          i3 = i4;
                          i2 = i5;
                          bool3 = bool6;
                          i1 = i6;
                          localObject8 = localException10;
                          continue;
                          localObject6 = "";
                          continue;
                        }
                        i11 = i;
                        l2 = l1;
                        bool8 = bool1;
                        i10 = j;
                        i9 = k;
                        bool7 = bool2;
                        localObject13 = localObject1;
                        bool6 = bool3;
                        i8 = n;
                        i7 = m;
                        i6 = i1;
                        i5 = i2;
                        i4 = i3;
                        localObject12 = localObject2;
                        localObject11 = localObject3;
                        localObject10 = localObject4;
                        localObject9 = localObject5;
                        bool5 = bool4;
                        localObject15 = localObject6;
                        localObject14 = localObject7;
                        localObject1 = EffectConfigBase.a(287, EffectConfigBase.c).edit();
                        ((SharedPreferences.Editor)localObject1).putInt("isBlueToothSwitch", i11);
                        ((SharedPreferences.Editor)localObject1).putLong("bluetoothDelayTime", l2);
                        ((SharedPreferences.Editor)localObject1).putBoolean("LowlightAndDenoiseDevice", bool8);
                        ((SharedPreferences.Editor)localObject1).putInt("multiVideoSupportNumbers", i10);
                        ((SharedPreferences.Editor)localObject1).putInt("SpeedDialScreenStyle", i9);
                        ((SharedPreferences.Editor)localObject1).putBoolean("switchMultiForceUseGroup", bool7);
                        ((SharedPreferences.Editor)localObject1).putString("switchMultiForceUseGroupAlertTip", (String)localObject13);
                        ((SharedPreferences.Editor)localObject1).putInt("useRGB2I420Shader", i7);
                        ((SharedPreferences.Editor)localObject1).putBoolean("isSharpnessSwitch", bool6);
                        ((SharedPreferences.Editor)localObject1).putInt("sharpnessFPSThreshold", i8);
                        ((SharedPreferences.Editor)localObject1).putInt("useAADSDeJitterAlgorithmUin", i6);
                        ((SharedPreferences.Editor)localObject1).putInt("enableAADSDeJitterMaxJDelayUin", i5);
                        ((SharedPreferences.Editor)localObject1).putInt("upLoadWhenGetNewData", i4);
                        ((SharedPreferences.Editor)localObject1).putString("ptuNewRenderLimit", (String)localObject12);
                        ((SharedPreferences.Editor)localObject1).putString("moreBtnTips", (String)localObject11);
                        ((SharedPreferences.Editor)localObject1).putString("ptuAfterTreamentLimit", localObject10);
                        ((SharedPreferences.Editor)localObject1).putString("ptuAfterTreamentCanvas", (String)localObject9);
                        ((SharedPreferences.Editor)localObject1).putBoolean("isAllowedControlMicAfterBeMuted", bool5);
                        ((SharedPreferences.Editor)localObject1).putString("machineMiddleLine", (String)localObject14);
                        ((SharedPreferences.Editor)localObject1).putString("machineHighLine", (String)localObject15);
                        ((SharedPreferences.Editor)localObject1).commit();
                        if (QLog.isColorLevel()) {
                          QLog.i("QAVConfigUtils", 2, "parseAndSave [" + paramString + "]");
                        }
                        return;
                        bool3 = false;
                        break label3294;
                        localException1 = localException1;
                        bool1 = false;
                        localObject2 = "";
                        localObject3 = "";
                        localObject4 = "";
                        localObject5 = "";
                        i = -1;
                        i5 = -1;
                        k = -1;
                        m = -1;
                        localObject9 = "";
                        bool2 = false;
                        n = 7;
                        i1 = j;
                        i3 = i4;
                        localObject6 = localObject1;
                        j = i5;
                        localObject1 = localObject9;
                        localObject14 = localObject1;
                        localObject15 = str2;
                        bool5 = bool1;
                        localObject9 = localObject2;
                        localObject10 = localObject3;
                        localObject11 = localObject4;
                        localObject12 = localObject5;
                        i4 = i;
                        i5 = j;
                        i6 = k;
                        i7 = m;
                        i8 = n;
                        bool6 = bool2;
                        localObject13 = localObject6;
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
                        localObject14 = localObject1;
                        localObject15 = str2;
                        bool5 = bool1;
                        localObject9 = localObject2;
                        localObject10 = localObject3;
                        localObject11 = localObject4;
                        localObject12 = localObject5;
                        i4 = i;
                        i5 = j;
                        i6 = k;
                        i7 = m;
                        i8 = n;
                        bool6 = bool2;
                        localObject13 = localObject6;
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
                        localObject5 = "";
                        i = -1;
                        j = -1;
                        k = -1;
                        m = -1;
                        localObject9 = "";
                        bool1 = false;
                        localObject6 = localObject1;
                        n = 7;
                        bool2 = false;
                        localObject1 = localObject9;
                        i3 = i4;
                        continue;
                        localException3 = localException3;
                        i1 = i;
                        localObject3 = "";
                        localObject4 = "";
                        localObject5 = "";
                        i = -1;
                        j = -1;
                        k = -1;
                        m = -1;
                        localObject9 = "";
                        bool1 = false;
                        localObject2 = "";
                        n = 7;
                        bool2 = false;
                        localObject6 = localObject1;
                        localObject1 = localObject9;
                        i3 = i4;
                        continue;
                        localException4 = localException4;
                        bool3 = bool1;
                        i1 = i;
                        localObject4 = "";
                        localObject5 = "";
                        i = -1;
                        j = -1;
                        k = -1;
                        m = -1;
                        localObject9 = "";
                        bool1 = false;
                        localObject2 = "";
                        localObject3 = "";
                        bool2 = false;
                        localObject6 = localObject1;
                        n = 7;
                        localObject1 = localObject9;
                        i3 = i4;
                        continue;
                        localException5 = localException5;
                        i2 = j;
                        bool3 = bool1;
                        i1 = i;
                        localObject5 = "";
                        i = -1;
                        j = -1;
                        k = -1;
                        m = -1;
                        localObject9 = "";
                        bool1 = false;
                        localObject2 = "";
                        localObject3 = "";
                        localObject4 = "";
                        localObject6 = localObject1;
                        n = 7;
                        bool2 = false;
                        localObject1 = localObject9;
                        i3 = i4;
                        continue;
                        localException6 = localException6;
                        i3 = k;
                        i2 = j;
                        bool3 = bool1;
                        i1 = i;
                        i = -1;
                        j = -1;
                        k = -1;
                        m = -1;
                        localObject9 = "";
                        bool1 = false;
                        localObject2 = "";
                        localObject3 = "";
                        localObject4 = "";
                        localObject5 = "";
                        bool2 = false;
                        localObject6 = localObject1;
                        n = 7;
                        localObject1 = localObject9;
                        continue;
                        localException7 = localException7;
                        bool4 = bool2;
                        i3 = k;
                        i2 = j;
                        bool3 = bool1;
                        i1 = i;
                        j = -1;
                        k = -1;
                        m = -1;
                        localObject9 = "";
                        bool1 = false;
                        localObject2 = "";
                        localObject3 = "";
                        localObject4 = "";
                        localObject5 = "";
                        i = -1;
                        localObject6 = localObject1;
                        n = 7;
                        bool2 = false;
                        localObject1 = localObject9;
                        continue;
                      }
                    }
                    catch (Exception localException8)
                    {
                      n = 7;
                      bool5 = false;
                      localObject6 = localObject1;
                      bool4 = bool2;
                      i3 = k;
                      i2 = j;
                      bool3 = bool1;
                      i1 = i;
                      localObject1 = "";
                      bool1 = false;
                      localObject2 = "";
                      localObject3 = "";
                      localObject4 = "";
                      localObject5 = "";
                      i = -1;
                      j = -1;
                      k = -1;
                      m = -1;
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
      bool5 = false;
      Object localObject9 = "";
      String str1 = "";
      Object localObject11 = "";
      Object localObject12 = "";
      i4 = -1;
      int i5 = -1;
      int i6 = -1;
      int i7 = -1;
      Object localObject14 = "";
      boolean bool6 = false;
      i8 = 7;
      Object localObject15 = str2;
      localObject13 = localObject1;
      bool7 = bool2;
      i9 = i;
      int i10 = i2;
      bool8 = bool1;
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
    SharedPreferences localSharedPreferences = EffectConfigBase.a(287, EffectConfigBase.c);
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
    int i = EffectConfigBase.a(287, EffectConfigBase.c).getInt("useAADSDeJitterAlgorithmUin", -1);
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
    if (e == -1) {
      e = EffectConfigBase.a(287, EffectConfigBase.c).getInt("sharpnessFPSThreshold", 7);
    }
    return e * 10;
  }
  
  public static boolean b()
  {
    if (jdField_b_of_type_Int == -1) {
      if (!EffectConfigBase.a(287, EffectConfigBase.c).getBoolean("LowlightAndDenoiseDevice", true)) {
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
    int i = EffectConfigBase.a(287, EffectConfigBase.c).getInt("enableAADSDeJitterMaxJDelayUin", -1);
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
  
  public static boolean c()
  {
    boolean bool = false;
    if (d == -1) {
      d = EffectConfigBase.a(287, EffectConfigBase.c).getInt("SpeedDialScreenStyle", 0);
    }
    if (d == 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean d()
  {
    boolean bool2 = false;
    if (jdField_a_of_type_JavaLangBoolean == null)
    {
      SharedPreferences localSharedPreferences = EffectConfigBase.a(287, EffectConfigBase.c);
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
      f = EffectConfigBase.a(287, EffectConfigBase.c).getInt("useRGB2I420Shader", 0);
    }
    return f == 1;
  }
  
  public static boolean g()
  {
    if (g == -1) {
      g = EffectConfigBase.a(287, EffectConfigBase.c).getInt("upLoadWhenGetNewData", 0);
    }
    return g == 1;
  }
  
  public static boolean h()
  {
    boolean bool = EffectConfigBase.a(287, EffectConfigBase.c).getBoolean("isAllowedControlMicAfterBeMuted", false);
    QLog.i("QAVConfigUtils", 1, "JTest. read isAllowedControlMicAfterBeMuted = " + bool);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     msq
 * JD-Core Version:    0.7.0.1
 */