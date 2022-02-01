import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class prh
{
  public static int a()
  {
    int i = 0;
    if (bdvn.a()) {
      i = 1;
    }
    while (!b()) {
      return i;
    }
    return 2;
  }
  
  public static String a()
  {
    JSONObject localJSONObject = new JSONObject();
    a(localJSONObject);
    return localJSONObject.toString();
  }
  
  public static JSONArray a()
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      Object localObject = (String)bmhv.a("key_study_mode_grade_choose", "");
      QLog.d("RIJStudyModeUtils", 1, "getSelectedGrades error! result= " + (String)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new JSONArray((String)localObject);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      QLog.d("RIJStudyModeUtils", 1, "getSelectedGrades error! msg= " + localException);
    }
    return localJSONArray;
  }
  
  public static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      bmhv.a("key_study_mode_grade_choose", paramString);
      pvm.a().a(new pri(paramString));
    }
    QLog.d("RIJStudyModeUtils", 1, "updateSelectedGrades ! res= " + paramString);
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    while (!bdvn.a()) {
      return;
    }
    try
    {
      paramJSONObject.put("study_mode_selected_grade", a());
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("RIJStudyModeUtils", 1, "addSelectedGrades error! msg= " + paramJSONObject);
    }
  }
  
  public static boolean a()
  {
    boolean bool = false;
    AladdinConfig localAladdinConfig = Aladdin.getConfig(315);
    if (!bdvn.a()) {}
    for (;;)
    {
      QLog.d("RIJStudyModeUtils", 1, "showStudyGradeEntry ! res= " + localAladdinConfig.toString());
      return bool;
      if (localAladdinConfig.getIntegerFromString("study_mode_select_grade_entry_enable", 0) == 1) {
        bool = true;
      }
    }
  }
  
  public static void b(String paramString)
  {
    try
    {
      pqg localpqg = new pqg();
      localpqg.l();
      localpqg.m();
      olh.a(null, "", paramString, paramString, 0, 0, "", "", "", localpqg.a(), false);
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("RIJStudyModeUtils", 1, "gradeEntryReport error! e= " + paramString);
    }
  }
  
  public static boolean b()
  {
    return ((Integer)bmhv.a("key_sp_is_readinjoy_youngster", Integer.valueOf(0))).intValue() == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     prh
 * JD-Core Version:    0.7.0.1
 */