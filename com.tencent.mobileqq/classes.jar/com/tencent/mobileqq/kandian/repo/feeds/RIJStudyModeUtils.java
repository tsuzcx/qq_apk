package com.tencent.mobileqq.kandian.repo.feeds;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJStudyModeClassEntryAladdinConfig;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class RIJStudyModeUtils
{
  public static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      RIJSPUtils.a("key_study_mode_grade_choose", paramString);
      ReadInJoyLogicEngineEventDispatcher.a().a(new RIJStudyModeUtils.1(paramString));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateSelectedGrades ! res= ");
    localStringBuilder.append(paramString);
    QLog.d("RIJStudyModeUtils", 1, localStringBuilder.toString());
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    if (!StudyModeManager.h()) {
      return;
    }
    try
    {
      paramJSONObject.put("study_mode_selected_grade", b());
      return;
    }
    catch (Exception paramJSONObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addSelectedGrades error! msg= ");
      localStringBuilder.append(paramJSONObject);
      QLog.d("RIJStudyModeUtils", 1, localStringBuilder.toString());
    }
  }
  
  public static boolean a()
  {
    boolean bool2 = StudyModeManager.h();
    boolean bool1 = false;
    if ((bool2) && (RIJStudyModeClassEntryAladdinConfig.a.a() == 1)) {
      bool1 = true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showStudyGradeEntry ! enable = ");
    localStringBuilder.append(RIJStudyModeClassEntryAladdinConfig.a.a());
    QLog.d("RIJStudyModeUtils", 1, localStringBuilder.toString());
    return bool1;
  }
  
  public static JSONArray b()
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      Object localObject = (String)RIJSPUtils.b("key_study_mode_grade_choose", "");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSelectedGrades error! result= ");
      localStringBuilder.append((String)localObject);
      QLog.d("RIJStudyModeUtils", 1, localStringBuilder.toString());
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new JSONArray((String)localObject);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSelectedGrades error! msg= ");
      localStringBuilder.append(localException);
      QLog.d("RIJStudyModeUtils", 1, localStringBuilder.toString());
    }
    return localJSONArray;
  }
  
  public static String c()
  {
    JSONObject localJSONObject = new JSONObject();
    a(localJSONObject);
    return localJSONObject.toString();
  }
  
  public static int d()
  {
    if (StudyModeManager.h()) {
      return 1;
    }
    if (e()) {
      return 2;
    }
    return 0;
  }
  
  public static boolean e()
  {
    boolean bool = false;
    if (((Integer)RIJSPUtils.b("key_sp_is_readinjoy_youngster", Integer.valueOf(0))).intValue() == 1) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.RIJStudyModeUtils
 * JD-Core Version:    0.7.0.1
 */