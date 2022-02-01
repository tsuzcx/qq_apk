package com.tencent.mobileqq.education.api.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.aelight.camera.education.api.IEducationEditPic;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.education.answersearch.AnswerSearchResultFragment;
import com.tencent.mobileqq.education.api.IAnswerSearchApi;
import com.tencent.mobileqq.education.report.StudyReporter;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;
import java.util.Map;

public class AnswerSearchApiImpl
  implements IAnswerSearchApi
{
  public void reportEvent(String paramString, Map<String, String> paramMap)
  {
    if (paramMap == null)
    {
      StudyReporter.a(paramString, new HashMap());
      return;
    }
    StudyReporter.a(paramString, paramMap);
  }
  
  public void showAnswerSearchResultByBase64(Activity paramActivity, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("isTransparentTitle", true);
    localIntent.putExtra("url", "https://interactive-live.cdn-go.cn/cdn-go-static/latest/souti-answer.html");
    localIntent.putExtra("fragmentClass", AnswerSearchResultFragment.class);
    localIntent.putExtra("answer_search_result_params_key_pic_type", 2);
    localIntent.addFlags(268435456);
    paramActivity.startActivity(localIntent);
  }
  
  public void showAnswerSearchResultByFile(Activity paramActivity, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("isTransparentTitle", true);
    localIntent.putExtra("url", "https://interactive-live.cdn-go.cn/cdn-go-static/latest/souti-answer.html");
    localIntent.putExtra("fragmentClass", AnswerSearchResultFragment.class);
    localIntent.putExtra("answer_search_result_params_key_pic_type", 1);
    localIntent.putExtra("answer_search_result_params_key_pic_data", paramString);
    localIntent.addFlags(268435456);
    paramActivity.startActivity(localIntent);
  }
  
  public void startAnswerSearchPicEditActivity(Activity paramActivity, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("isTransparentTitle", true);
    localIntent.putExtra("url", "https://interactive-live.cdn-go.cn/cdn-go-static/latest/souti-answer.html");
    localIntent.putExtra("fragmentClass", AnswerSearchResultFragment.class);
    localIntent.putExtra("imageData", paramString);
    localIntent.addFlags(268435456);
    paramActivity.startActivity(localIntent);
  }
  
  public void startAnswerSearchPicEditActivity(Activity paramActivity, String paramString, int paramInt, boolean paramBoolean)
  {
    ((IEducationEditPic)QRoute.api(IEducationEditPic.class)).startAnswerSearchPicEditActivity(paramActivity, paramString, paramInt, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.education.api.impl.AnswerSearchApiImpl
 * JD-Core Version:    0.7.0.1
 */