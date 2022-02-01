import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class mtr
{
  private static int jdField_a_of_type_Int = -1;
  private static long jdField_a_of_type_Long = 1000L;
  private static Boolean jdField_a_of_type_JavaLangBoolean;
  private static Integer jdField_a_of_type_JavaLangInteger;
  private static final String jdField_a_of_type_JavaLangString = anvx.a(2131708358);
  private static int jdField_b_of_type_Int = -1;
  private static volatile Boolean jdField_b_of_type_JavaLangBoolean;
  private static String jdField_b_of_type_JavaLangString;
  private static volatile int c = -1;
  private static int d = -1;
  private static int e = -1;
  private static int f = -1;
  private static int g = -1;
  private static int h = -1;
  
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
  
  public static mts a(int paramInt)
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
        mts localmts = new mts();
        localmts.jdField_b_of_type_Int = 2147483647;
        i = 0;
        if (i < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          if ((localJSONObject.getInt("type") == paramInt) && (localJSONObject.getInt("priority") < localmts.jdField_b_of_type_Int))
          {
            localmts.jdField_a_of_type_Int = localJSONObject.getInt("id");
            localmts.jdField_a_of_type_JavaLangString = localJSONObject.getString("url");
            localmts.jdField_b_of_type_Int = localJSONObject.getInt("priority");
            localmts.c = localJSONObject.getInt("type");
          }
        }
        else if (localmts.jdField_b_of_type_Int < 2147483647)
        {
          QLog.i("QAVConfigUtils", 1, "MoreBtnTips. getHighestPriorityMoreBtnTips. highest. id = " + localmts.jdField_a_of_type_Int + ", url = " + localmts.jdField_a_of_type_JavaLangString + ", priority = " + localmts.jdField_b_of_type_Int + ", type = " + localmts.c);
          return localmts;
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
        new mts().jdField_b_of_type_Int = 2147483647;
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
    int i12 = 1;
    long l1 = 1000L;
    boolean bool3 = true;
    boolean bool1 = true;
    int i3 = -1;
    int i4 = 0;
    int i = 0;
    boolean bool4 = false;
    boolean bool2 = false;
    Object localObject1 = jdField_a_of_type_JavaLangString;
    boolean bool9 = false;
    boolean bool5 = false;
    int i1 = 7;
    int i2 = -1;
    int i11 = -1;
    int i6 = -1;
    Object localObject3 = "";
    Object localObject4 = "";
    Object localObject5 = "";
    Object localObject7 = "";
    boolean bool7 = false;
    boolean bool8 = false;
    Object localObject8 = "";
    Object localObject15 = "";
    int i10 = -1;
    int i15 = -1;
    if (QLog.isColorLevel()) {
      QLog.i("QAVConfigUtils", 2, " parseAndSave parse json = " + paramString);
    }
    if (!TextUtils.isEmpty(paramString)) {}
    label3922:
    for (;;)
    {
      try
      {
        localObject16 = new JSONObject(paramString);
        if (((JSONObject)localObject16).has("isBlueToothSwitchForAndroid")) {
          i = ((JSONObject)localObject16).getInt("isBlueToothSwitchForAndroid");
        }
      }
      catch (Exception localException7)
      {
        try
        {
          if (((JSONObject)localObject16).has("bluetoothDelayTime"))
          {
            l2 = ((JSONObject)localObject16).getLong("bluetoothDelayTime");
            l1 = l2;
          }
          int k;
          Object localObject2;
          int m;
          Object localObject6;
          Object localObject10;
          int n;
          Object localObject9;
          i = 1;
        }
        catch (Exception localException7)
        {
          try
          {
            if (((JSONObject)localObject16).has("LowlightAndDenoiseDevice")) {
              bool1 = ((JSONObject)localObject16).getBoolean("LowlightAndDenoiseDevice");
            }
          }
          catch (Exception localException7)
          {
            try
            {
              if (((JSONObject)localObject16).has("multiVideoSupportNumbers")) {
                j = ((JSONObject)localObject16).getInt("multiVideoSupportNumbers");
              }
            }
            catch (Exception localException7)
            {
              try
              {
                if (((JSONObject)localObject16).has("SpeedDialScreenStyle")) {
                  k = ((JSONObject)localObject16).getInt("SpeedDialScreenStyle");
                }
              }
              catch (Exception localException7)
              {
                try
                {
                  if (((JSONObject)localObject16).has("switchMultiForceUseGroup")) {
                    bool2 = ((JSONObject)localObject16).getBoolean("switchMultiForceUseGroup");
                  }
                }
                catch (Exception localException7)
                {
                  try
                  {
                    if (((JSONObject)localObject16).has("switchMultiForceUseGroupAlertTip"))
                    {
                      localObject2 = ((JSONObject)localObject16).getString("switchMultiForceUseGroupAlertTip");
                      localObject1 = localObject2;
                    }
                    bool2 = false;
                  }
                  catch (Exception localException7)
                  {
                    try
                    {
                      if (((JSONObject)localObject16).has("useRGB2I420Shader"))
                      {
                        m = ((JSONObject)localObject16).getInt("useRGB2I420Shader");
                        bool3 = bool5;
                        i9 = i10;
                        localObject14 = localObject15;
                        localObject13 = localObject8;
                        bool6 = bool7;
                        localObject12 = localObject7;
                        localObject11 = localObject5;
                        localObject6 = localObject4;
                        localObject10 = localObject3;
                        i8 = i6;
                        i5 = i11;
                        i4 = i2;
                        i7 = i1;
                        bool5 = bool9;
                        try
                        {
                          if (((JSONObject)localObject16).has("isSharpnessSwitch"))
                          {
                            i9 = i10;
                            localObject14 = localObject15;
                            localObject13 = localObject8;
                            bool6 = bool7;
                            localObject12 = localObject7;
                            localObject11 = localObject5;
                            localObject6 = localObject4;
                            localObject10 = localObject3;
                            i8 = i6;
                            i5 = i11;
                            i4 = i2;
                            i7 = i1;
                            bool5 = bool9;
                            if (((JSONObject)localObject16).getInt("isSharpnessSwitch") == 1)
                            {
                              bool3 = true;
                              break label3922;
                            }
                          }
                          else
                          {
                            n = i1;
                            i9 = i10;
                            localObject14 = localObject15;
                            localObject13 = localObject8;
                            bool6 = bool7;
                            localObject12 = localObject7;
                            localObject11 = localObject5;
                            localObject6 = localObject4;
                            localObject10 = localObject3;
                            i8 = i6;
                            i5 = i11;
                            i4 = i2;
                            i7 = i1;
                            bool5 = bool3;
                            if (((JSONObject)localObject16).has("sharpnessFPSThreshold"))
                            {
                              i9 = i10;
                              localObject14 = localObject15;
                              localObject13 = localObject8;
                              bool6 = bool7;
                              localObject12 = localObject7;
                              localObject11 = localObject5;
                              localObject6 = localObject4;
                              localObject10 = localObject3;
                              i8 = i6;
                              i5 = i11;
                              i4 = i2;
                              i7 = i1;
                              bool5 = bool3;
                              n = ((JSONObject)localObject16).getInt("sharpnessFPSThreshold");
                            }
                            i1 = i2;
                            i9 = i10;
                            localObject14 = localObject15;
                            localObject13 = localObject8;
                            bool6 = bool7;
                            localObject12 = localObject7;
                            localObject11 = localObject5;
                            localObject6 = localObject4;
                            localObject10 = localObject3;
                            i8 = i6;
                            i5 = i11;
                            i4 = i2;
                            i7 = n;
                            bool5 = bool3;
                            if (((JSONObject)localObject16).has("useAADSDeJitterAlgorithmUin"))
                            {
                              i9 = i10;
                              localObject14 = localObject15;
                              localObject13 = localObject8;
                              bool6 = bool7;
                              localObject12 = localObject7;
                              localObject11 = localObject5;
                              localObject6 = localObject4;
                              localObject10 = localObject3;
                              i8 = i6;
                              i5 = i11;
                              i4 = i2;
                              i7 = n;
                              bool5 = bool3;
                              i1 = ((JSONObject)localObject16).getInt("useAADSDeJitterAlgorithmUin");
                              i9 = i10;
                              localObject14 = localObject15;
                              localObject13 = localObject8;
                              bool6 = bool7;
                              localObject12 = localObject7;
                              localObject11 = localObject5;
                              localObject6 = localObject4;
                              localObject10 = localObject3;
                              i8 = i6;
                              i5 = i11;
                              i4 = i1;
                              i7 = n;
                              bool5 = bool3;
                              QLog.i("QAVConfigUtils", 1, "JTest. save useAADSDeJitterAlgorithmUin = " + i1);
                            }
                            i2 = i11;
                            i9 = i10;
                            localObject14 = localObject15;
                            localObject13 = localObject8;
                            bool6 = bool7;
                            localObject12 = localObject7;
                            localObject11 = localObject5;
                            localObject6 = localObject4;
                            localObject10 = localObject3;
                            i8 = i6;
                            i5 = i11;
                            i4 = i1;
                            i7 = n;
                            bool5 = bool3;
                            if (((JSONObject)localObject16).has("enableAADSDeJitterMaxJDelayUin"))
                            {
                              i9 = i10;
                              localObject14 = localObject15;
                              localObject13 = localObject8;
                              bool6 = bool7;
                              localObject12 = localObject7;
                              localObject11 = localObject5;
                              localObject6 = localObject4;
                              localObject10 = localObject3;
                              i8 = i6;
                              i5 = i11;
                              i4 = i1;
                              i7 = n;
                              bool5 = bool3;
                              i2 = ((JSONObject)localObject16).getInt("enableAADSDeJitterMaxJDelayUin");
                              i9 = i10;
                              localObject14 = localObject15;
                              localObject13 = localObject8;
                              bool6 = bool7;
                              localObject12 = localObject7;
                              localObject11 = localObject5;
                              localObject6 = localObject4;
                              localObject10 = localObject3;
                              i8 = i6;
                              i5 = i2;
                              i4 = i1;
                              i7 = n;
                              bool5 = bool3;
                              QLog.i("QAVConfigUtils", 1, "JTest. save enableAADSDeJitterMaxJDelayUin = " + i2);
                            }
                            i3 = i6;
                            i9 = i10;
                            localObject14 = localObject15;
                            localObject13 = localObject8;
                            bool6 = bool7;
                            localObject12 = localObject7;
                            localObject11 = localObject5;
                            localObject6 = localObject4;
                            localObject10 = localObject3;
                            i8 = i6;
                            i5 = i2;
                            i4 = i1;
                            i7 = n;
                            bool5 = bool3;
                            if (((JSONObject)localObject16).has("upLoadWhenGetNewData"))
                            {
                              i9 = i10;
                              localObject14 = localObject15;
                              localObject13 = localObject8;
                              bool6 = bool7;
                              localObject12 = localObject7;
                              localObject11 = localObject5;
                              localObject6 = localObject4;
                              localObject10 = localObject3;
                              i8 = i6;
                              i5 = i2;
                              i4 = i1;
                              i7 = n;
                              bool5 = bool3;
                              i3 = ((JSONObject)localObject16).getInt("upLoadWhenGetNewData");
                            }
                            localObject2 = localObject3;
                            i9 = i10;
                            localObject14 = localObject15;
                            localObject13 = localObject8;
                            bool6 = bool7;
                            localObject12 = localObject7;
                            localObject11 = localObject5;
                            localObject6 = localObject4;
                            localObject10 = localObject3;
                            i8 = i3;
                            i5 = i2;
                            i4 = i1;
                            i7 = n;
                            bool5 = bool3;
                            if (((JSONObject)localObject16).has("ptuNewRenderLimit"))
                            {
                              i9 = i10;
                              localObject14 = localObject15;
                              localObject13 = localObject8;
                              bool6 = bool7;
                              localObject12 = localObject7;
                              localObject11 = localObject5;
                              localObject6 = localObject4;
                              localObject10 = localObject3;
                              i8 = i3;
                              i5 = i2;
                              i4 = i1;
                              i7 = n;
                              bool5 = bool3;
                              localObject2 = ((JSONObject)localObject16).getString("ptuNewRenderLimit");
                            }
                            localObject3 = localObject4;
                            i9 = i10;
                            localObject14 = localObject15;
                            localObject13 = localObject8;
                            bool6 = bool7;
                            localObject12 = localObject7;
                            localObject11 = localObject5;
                            localObject6 = localObject4;
                            localObject10 = localObject2;
                            i8 = i3;
                            i5 = i2;
                            i4 = i1;
                            i7 = n;
                            bool5 = bool3;
                            if (((JSONObject)localObject16).has("moreBtnTips"))
                            {
                              i9 = i10;
                              localObject14 = localObject15;
                              localObject13 = localObject8;
                              bool6 = bool7;
                              localObject12 = localObject7;
                              localObject11 = localObject5;
                              localObject6 = localObject4;
                              localObject10 = localObject2;
                              i8 = i3;
                              i5 = i2;
                              i4 = i1;
                              i7 = n;
                              bool5 = bool3;
                              localObject3 = ((JSONObject)localObject16).getJSONArray("moreBtnTips").toString();
                              i9 = i10;
                              localObject14 = localObject15;
                              localObject13 = localObject8;
                              bool6 = bool7;
                              localObject12 = localObject7;
                              localObject11 = localObject5;
                              localObject6 = localObject3;
                              localObject10 = localObject2;
                              i8 = i3;
                              i5 = i2;
                              i4 = i1;
                              i7 = n;
                              bool5 = bool3;
                              QLog.i("QAVConfigUtils", 1, "MoreBtnTips. downloaded moreBtnTipsJson = " + (String)localObject3);
                            }
                            localObject4 = localObject5;
                            i9 = i10;
                            localObject14 = localObject15;
                            localObject13 = localObject8;
                            bool6 = bool7;
                            localObject12 = localObject7;
                            localObject11 = localObject5;
                            localObject6 = localObject3;
                            localObject10 = localObject2;
                            i8 = i3;
                            i5 = i2;
                            i4 = i1;
                            i7 = n;
                            bool5 = bool3;
                            if (((JSONObject)localObject16).has("ptuAfterTreamentLimit"))
                            {
                              i9 = i10;
                              localObject14 = localObject15;
                              localObject13 = localObject8;
                              bool6 = bool7;
                              localObject12 = localObject7;
                              localObject11 = localObject5;
                              localObject6 = localObject3;
                              localObject10 = localObject2;
                              i8 = i3;
                              i5 = i2;
                              i4 = i1;
                              i7 = n;
                              bool5 = bool3;
                              localObject4 = ((JSONObject)localObject16).getString("ptuAfterTreamentLimit");
                            }
                            localObject5 = localObject7;
                            i9 = i10;
                            localObject14 = localObject15;
                            localObject13 = localObject8;
                            bool6 = bool7;
                            localObject12 = localObject7;
                            localObject11 = localObject4;
                            localObject6 = localObject3;
                            localObject10 = localObject2;
                            i8 = i3;
                            i5 = i2;
                            i4 = i1;
                            i7 = n;
                            bool5 = bool3;
                            if (((JSONObject)localObject16).has("ptuAfterTreamentCanvas"))
                            {
                              i9 = i10;
                              localObject14 = localObject15;
                              localObject13 = localObject8;
                              bool6 = bool7;
                              localObject12 = localObject7;
                              localObject11 = localObject4;
                              localObject6 = localObject3;
                              localObject10 = localObject2;
                              i8 = i3;
                              i5 = i2;
                              i4 = i1;
                              i7 = n;
                              bool5 = bool3;
                              localObject5 = ((JSONObject)localObject16).getString("ptuAfterTreamentCanvas");
                            }
                            bool4 = bool8;
                            i9 = i10;
                            localObject14 = localObject15;
                            localObject13 = localObject8;
                            bool6 = bool7;
                            localObject12 = localObject5;
                            localObject11 = localObject4;
                            localObject6 = localObject3;
                            localObject10 = localObject2;
                            i8 = i3;
                            i5 = i2;
                            i4 = i1;
                            i7 = n;
                            bool5 = bool3;
                            if (((JSONObject)localObject16).has("isAllowedControlMicAfterBeMuted"))
                            {
                              i9 = i10;
                              localObject14 = localObject15;
                              localObject13 = localObject8;
                              bool6 = bool7;
                              localObject12 = localObject5;
                              localObject11 = localObject4;
                              localObject6 = localObject3;
                              localObject10 = localObject2;
                              i8 = i3;
                              i5 = i2;
                              i4 = i1;
                              i7 = n;
                              bool5 = bool3;
                              bool4 = ((JSONObject)localObject16).getBoolean("isAllowedControlMicAfterBeMuted");
                            }
                          }
                        }
                        catch (Exception localException9)
                        {
                          localObject2 = localObject13;
                          localObject3 = localObject12;
                          localObject4 = localObject11;
                          localObject5 = localObject6;
                          localObject6 = localObject10;
                          n = m;
                          i1 = i7;
                          localObject7 = localObject1;
                          bool4 = bool2;
                          i2 = k;
                          i3 = j;
                          bool3 = bool1;
                          i6 = i;
                          i = i9;
                          localObject1 = localObject14;
                          bool1 = bool6;
                          j = i8;
                          k = i5;
                          m = i4;
                          bool2 = bool5;
                          i4 = i2;
                          i2 = i6;
                          continue;
                        }
                        try
                        {
                          QLog.i("QAVConfigUtils", 1, "JTest. save isAllowedControlMicAfterBeMuted = " + bool4);
                          localObject7 = localObject8;
                          i9 = i10;
                          localObject14 = localObject15;
                          localObject13 = localObject8;
                          bool6 = bool4;
                          localObject12 = localObject5;
                          localObject11 = localObject4;
                          localObject6 = localObject3;
                          localObject10 = localObject2;
                          i8 = i3;
                          i5 = i2;
                          i4 = i1;
                          i7 = n;
                          bool5 = bool3;
                          if (((JSONObject)localObject16).has("machineMiddleLine"))
                          {
                            i9 = i10;
                            localObject14 = localObject15;
                            localObject13 = localObject8;
                            bool6 = bool4;
                            localObject12 = localObject5;
                            localObject11 = localObject4;
                            localObject6 = localObject3;
                            localObject10 = localObject2;
                            i8 = i3;
                            i5 = i2;
                            i4 = i1;
                            i7 = n;
                            bool5 = bool3;
                            localObject7 = ((JSONObject)localObject16).getString("machineMiddleLine");
                          }
                          localObject8 = localObject15;
                          i9 = i10;
                          localObject14 = localObject15;
                          localObject13 = localObject7;
                          bool6 = bool4;
                          localObject12 = localObject5;
                          localObject11 = localObject4;
                          localObject6 = localObject3;
                          localObject10 = localObject2;
                          i8 = i3;
                          i5 = i2;
                          i4 = i1;
                          i7 = n;
                          bool5 = bool3;
                          if (((JSONObject)localObject16).has("machineHighLine"))
                          {
                            i9 = i10;
                            localObject14 = localObject15;
                            localObject13 = localObject7;
                            bool6 = bool4;
                            localObject12 = localObject5;
                            localObject11 = localObject4;
                            localObject6 = localObject3;
                            localObject10 = localObject2;
                            i8 = i3;
                            i5 = i2;
                            i4 = i1;
                            i7 = n;
                            bool5 = bool3;
                            localObject8 = ((JSONObject)localObject16).getString("machineHighLine");
                          }
                          i6 = i10;
                          i9 = i10;
                          localObject14 = localObject8;
                          localObject13 = localObject7;
                          bool6 = bool4;
                          localObject12 = localObject5;
                          localObject11 = localObject4;
                          localObject6 = localObject3;
                          localObject10 = localObject2;
                          i8 = i3;
                          i5 = i2;
                          i4 = i1;
                          i7 = n;
                          bool5 = bool3;
                          if (((JSONObject)localObject16).has("allowMicLongPressSpeakInMute"))
                          {
                            i9 = i10;
                            localObject14 = localObject8;
                            localObject13 = localObject7;
                            bool6 = bool4;
                            localObject12 = localObject5;
                            localObject11 = localObject4;
                            localObject6 = localObject3;
                            localObject10 = localObject2;
                            i8 = i3;
                            i5 = i2;
                            i4 = i1;
                            i7 = n;
                            bool5 = bool3;
                            i6 = ((JSONObject)localObject16).getInt("allowMicLongPressSpeakInMute");
                          }
                          i9 = i6;
                          localObject14 = localObject8;
                          localObject13 = localObject7;
                          bool6 = bool4;
                          localObject12 = localObject5;
                          localObject11 = localObject4;
                          localObject6 = localObject3;
                          localObject10 = localObject2;
                          i8 = i3;
                          i5 = i2;
                          i4 = i1;
                          i7 = n;
                          bool5 = bool3;
                          if (!((JSONObject)localObject16).has("qavWatchTogetherSwitch")) {
                            continue;
                          }
                          i9 = i6;
                          localObject14 = localObject8;
                          localObject13 = localObject7;
                          bool6 = bool4;
                          localObject12 = localObject5;
                          localObject11 = localObject4;
                          localObject6 = localObject3;
                          localObject10 = localObject2;
                          i8 = i3;
                          i5 = i2;
                          i4 = i1;
                          i7 = n;
                          bool5 = bool3;
                          i10 = ((JSONObject)localObject16).getInt("qavWatchTogetherSwitch");
                          i4 = i10;
                        }
                        catch (Exception localException10)
                        {
                          i9 = -1;
                          localObject12 = "";
                          localObject11 = "";
                          localObject6 = localObject3;
                          localObject7 = localObject2;
                          i4 = m;
                          i5 = n;
                          localObject9 = localObject1;
                          bool5 = bool2;
                          i6 = k;
                          i7 = j;
                          bool6 = bool1;
                          i8 = i;
                          i = i9;
                          localObject1 = localObject12;
                          localObject2 = localObject11;
                          bool1 = bool4;
                          localObject3 = localObject5;
                          localObject5 = localObject6;
                          localObject6 = localObject7;
                          j = i3;
                          k = i2;
                          m = i1;
                          n = i4;
                          i1 = i5;
                          bool2 = bool3;
                          localObject7 = localObject9;
                          bool4 = bool5;
                          i4 = i6;
                          i3 = i7;
                          bool3 = bool6;
                          i2 = i8;
                          localObject9 = localException10;
                          continue;
                          i4 = -1;
                          continue;
                        }
                        i13 = i6;
                        i12 = i;
                        l2 = l1;
                        bool8 = bool1;
                        i11 = j;
                        i10 = k;
                        bool7 = bool2;
                        localObject16 = localObject1;
                        bool6 = bool3;
                        i9 = n;
                        i8 = m;
                        i7 = i1;
                        i6 = i2;
                        i5 = i3;
                        localObject15 = localObject2;
                        localObject14 = localObject3;
                        localObject13 = localObject4;
                        localObject12 = localObject5;
                        bool5 = bool4;
                        localObject11 = localObject7;
                        localObject10 = localObject8;
                        i14 = i4;
                        localObject1 = EffectConfigBase.a(287, EffectConfigBase.c).edit();
                        ((SharedPreferences.Editor)localObject1).putInt("isBlueToothSwitch", i12);
                        ((SharedPreferences.Editor)localObject1).putLong("bluetoothDelayTime", l2);
                        ((SharedPreferences.Editor)localObject1).putBoolean("LowlightAndDenoiseDevice", bool8);
                        ((SharedPreferences.Editor)localObject1).putInt("multiVideoSupportNumbers", i11);
                        ((SharedPreferences.Editor)localObject1).putInt("SpeedDialScreenStyle", i10);
                        ((SharedPreferences.Editor)localObject1).putBoolean("switchMultiForceUseGroup", bool7);
                        ((SharedPreferences.Editor)localObject1).putString("switchMultiForceUseGroupAlertTip", (String)localObject16);
                        ((SharedPreferences.Editor)localObject1).putInt("useRGB2I420Shader", i8);
                        ((SharedPreferences.Editor)localObject1).putBoolean("isSharpnessSwitch", bool6);
                        ((SharedPreferences.Editor)localObject1).putInt("sharpnessFPSThreshold", i9);
                        ((SharedPreferences.Editor)localObject1).putInt("useAADSDeJitterAlgorithmUin", i7);
                        ((SharedPreferences.Editor)localObject1).putInt("enableAADSDeJitterMaxJDelayUin", i6);
                        ((SharedPreferences.Editor)localObject1).putInt("upLoadWhenGetNewData", i5);
                        ((SharedPreferences.Editor)localObject1).putString("ptuNewRenderLimit", (String)localObject15);
                        ((SharedPreferences.Editor)localObject1).putString("moreBtnTips", (String)localObject14);
                        ((SharedPreferences.Editor)localObject1).putString("ptuAfterTreamentLimit", (String)localObject13);
                        ((SharedPreferences.Editor)localObject1).putString("ptuAfterTreamentCanvas", (String)localObject12);
                        ((SharedPreferences.Editor)localObject1).putBoolean("isAllowedControlMicAfterBeMuted", bool5);
                        ((SharedPreferences.Editor)localObject1).putString("machineMiddleLine", (String)localObject11);
                        ((SharedPreferences.Editor)localObject1).putString("machineHighLine", (String)localObject10);
                        ((SharedPreferences.Editor)localObject1).putInt("allowMicLongPressSpeakInMute", i13);
                        if (i14 != -1) {
                          ((SharedPreferences.Editor)localObject1).putInt("qavWatchTogetherSwitch", i14);
                        }
                        ((SharedPreferences.Editor)localObject1).commit();
                        if (QLog.isColorLevel()) {
                          QLog.i("QAVConfigUtils", 2, "parseAndSave [" + paramString + "]");
                        }
                        return;
                        bool3 = false;
                        break label3922;
                        localException1 = localException1;
                        localObject10 = "";
                        localObject2 = "";
                        bool1 = false;
                        localObject3 = "";
                        localObject4 = "";
                        localObject5 = "";
                        localObject6 = "";
                        i5 = -1;
                        k = -1;
                        m = -1;
                        n = -1;
                        i = -1;
                        bool2 = false;
                        i1 = 7;
                        i2 = j;
                        localObject7 = localObject1;
                        j = i5;
                        localObject1 = localObject10;
                        i13 = i;
                        i14 = i15;
                        localObject10 = localObject1;
                        localObject11 = localObject2;
                        bool5 = bool1;
                        localObject12 = localObject3;
                        localObject13 = localObject4;
                        localObject14 = localObject5;
                        localObject15 = localObject6;
                        i5 = j;
                        i6 = k;
                        i7 = m;
                        i8 = n;
                        i9 = i1;
                        bool6 = bool2;
                        localObject16 = localObject7;
                        bool7 = bool4;
                        i10 = i4;
                        i11 = i3;
                        bool8 = bool3;
                        l2 = l1;
                        i12 = i2;
                        if (!QLog.isColorLevel()) {
                          continue;
                        }
                        QLog.i("handleGetQAVGeneralConfig", 2, " parse json: " + QLog.getStackTraceString(localException1));
                        i13 = i;
                        i14 = i15;
                        localObject10 = localObject1;
                        localObject11 = localObject2;
                        bool5 = bool1;
                        localObject12 = localObject3;
                        localObject13 = localObject4;
                        localObject14 = localObject5;
                        localObject15 = localObject6;
                        i5 = j;
                        i6 = k;
                        i7 = m;
                        i8 = n;
                        i9 = i1;
                        bool6 = bool2;
                        localObject16 = localObject7;
                        bool7 = bool4;
                        i10 = i4;
                        i11 = i3;
                        bool8 = bool3;
                        l2 = l1;
                        i12 = i2;
                        continue;
                        localException2 = localException2;
                        i2 = i;
                        localObject2 = "";
                        bool1 = false;
                        localObject3 = "";
                        localObject4 = "";
                        localObject5 = "";
                        localObject6 = "";
                        j = -1;
                        k = -1;
                        m = -1;
                        n = -1;
                        i = -1;
                        localObject10 = "";
                        localObject7 = localObject1;
                        i1 = 7;
                        bool2 = false;
                        localObject1 = localObject10;
                        continue;
                        localException3 = localException3;
                        i2 = i;
                        bool1 = false;
                        localObject3 = "";
                        localObject4 = "";
                        localObject5 = "";
                        localObject6 = "";
                        j = -1;
                        k = -1;
                        m = -1;
                        n = -1;
                        i = -1;
                        localObject10 = "";
                        localObject2 = "";
                        i1 = 7;
                        bool2 = false;
                        localObject7 = localObject1;
                        localObject1 = localObject10;
                        continue;
                        localException4 = localException4;
                        bool3 = bool1;
                        i2 = i;
                        localObject3 = "";
                        localObject4 = "";
                        localObject5 = "";
                        localObject6 = "";
                        j = -1;
                        k = -1;
                        m = -1;
                        n = -1;
                        i = -1;
                        localObject10 = "";
                        localObject2 = "";
                        bool1 = false;
                        bool2 = false;
                        localObject7 = localObject1;
                        i1 = 7;
                        localObject1 = localObject10;
                        continue;
                        localException5 = localException5;
                        i3 = j;
                        bool3 = bool1;
                        i2 = i;
                        localObject4 = "";
                        localObject5 = "";
                        localObject6 = "";
                        j = -1;
                        k = -1;
                        m = -1;
                        n = -1;
                        i = -1;
                        localObject10 = "";
                        localObject2 = "";
                        bool1 = false;
                        localObject3 = "";
                        localObject7 = localObject1;
                        i1 = 7;
                        bool2 = false;
                        localObject1 = localObject10;
                        continue;
                        localException6 = localException6;
                        i4 = k;
                        i3 = j;
                        bool3 = bool1;
                        i2 = i;
                        localObject5 = "";
                        localObject6 = "";
                        j = -1;
                        k = -1;
                        m = -1;
                        n = -1;
                        i = -1;
                        localObject10 = "";
                        localObject2 = "";
                        bool1 = false;
                        localObject3 = "";
                        localObject4 = "";
                        bool2 = false;
                        localObject7 = localObject1;
                        i1 = 7;
                        localObject1 = localObject10;
                        continue;
                        localException7 = localException7;
                        bool4 = bool2;
                        i4 = k;
                        i3 = j;
                        bool3 = bool1;
                        i2 = i;
                        localObject6 = "";
                        j = -1;
                        k = -1;
                        m = -1;
                        n = -1;
                        i = -1;
                        localObject10 = "";
                        localObject2 = "";
                        bool1 = false;
                        localObject3 = "";
                        localObject4 = "";
                        localObject5 = "";
                        localObject7 = localObject1;
                        i1 = 7;
                        bool2 = false;
                        localObject1 = localObject10;
                        continue;
                      }
                    }
                    catch (Exception localException8)
                    {
                      i1 = 7;
                      bool5 = false;
                      localObject7 = localObject1;
                      bool4 = bool2;
                      i4 = k;
                      i3 = j;
                      bool3 = bool1;
                      i2 = i;
                      m = -1;
                      n = -1;
                      i = -1;
                      localObject1 = "";
                      localObject2 = "";
                      bool1 = false;
                      localObject3 = "";
                      localObject4 = "";
                      localObject5 = "";
                      localObject6 = "";
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
      String str = "";
      Object localObject11 = "";
      bool5 = false;
      Object localObject12 = "";
      Object localObject13 = "";
      Object localObject14 = "";
      localObject15 = "";
      int i5 = -1;
      i6 = -1;
      int i7 = -1;
      int i8 = -1;
      int i13 = -1;
      boolean bool6 = false;
      int i9 = 7;
      int i14 = i15;
      Object localObject16 = localObject1;
      bool7 = bool2;
      i10 = i;
      i11 = i3;
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
    if (f == -1) {
      f = EffectConfigBase.a(287, EffectConfigBase.c).getInt("sharpnessFPSThreshold", 7);
    }
    return f * 10;
  }
  
  public static boolean b()
  {
    if (jdField_b_of_type_Int == -1) {
      if (!EffectConfigBase.a(287, EffectConfigBase.c).getBoolean("LowlightAndDenoiseDevice", true)) {
        break label41;
      }
    }
    label41:
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
    if (e == -1) {
      e = EffectConfigBase.a(287, EffectConfigBase.c).getInt("allowMicLongPressSpeakInMute", 0);
    }
    return e == 1;
  }
  
  public static boolean e()
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
  
  public static boolean f()
  {
    a();
    return jdField_b_of_type_JavaLangBoolean.booleanValue();
  }
  
  public static boolean g()
  {
    if (g == -1) {
      g = EffectConfigBase.a(287, EffectConfigBase.c).getInt("useRGB2I420Shader", 0);
    }
    return g == 1;
  }
  
  public static boolean h()
  {
    if (h == -1) {
      h = EffectConfigBase.a(287, EffectConfigBase.c).getInt("upLoadWhenGetNewData", 0);
    }
    return h == 1;
  }
  
  public static boolean i()
  {
    boolean bool = EffectConfigBase.a(287, EffectConfigBase.c).getBoolean("isAllowedControlMicAfterBeMuted", false);
    QLog.i("QAVConfigUtils", 1, "JTest. read isAllowedControlMicAfterBeMuted = " + bool);
    return bool;
  }
  
  public static boolean j()
  {
    if (nad.a()) {
      if (jdField_a_of_type_JavaLangInteger == null)
      {
        jdField_a_of_type_JavaLangInteger = Integer.valueOf(EffectConfigBase.a(287, EffectConfigBase.c).getInt("qavWatchTogetherSwitch", 1));
        QLog.i("WTogether", 1, "isQavWatchTogetherOpen, switch[" + jdField_a_of_type_JavaLangInteger + "]");
      }
    }
    while (jdField_a_of_type_JavaLangInteger.intValue() != 0)
    {
      return true;
      jdField_a_of_type_JavaLangInteger = Integer.valueOf(0);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mtr
 * JD-Core Version:    0.7.0.1
 */