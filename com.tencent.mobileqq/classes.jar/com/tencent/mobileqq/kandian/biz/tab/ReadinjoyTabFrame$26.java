package com.tencent.mobileqq.kandian.biz.tab;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJStudyModeUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class ReadinjoyTabFrame$26
  implements View.OnClickListener
{
  ReadinjoyTabFrame$26(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onClick(View paramView)
  {
    paramView = new Bundle();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("selectedGrade", RIJStudyModeUtils.b());
      paramView.putString("param", localJSONObject.toString());
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clickGradeListener error! e= ");
      localStringBuilder.append(localException);
      QLog.d("ReadInJoyTabFrame", 1, localStringBuilder.toString());
    }
    RIJJumpUtils.a(this.a.P(), "https://viola.qq.com/js/grade.js?_rij_violaUrl=1&hideNav=1&v_nav_immer=1&v_tid=6&v_bid=3740&v_bundleName=grade", paramView);
    ReadinjoyTabFrame.a("0X800AF06");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame.26
 * JD-Core Version:    0.7.0.1
 */