package com.tencent.mobileqq.troop.homework.entry.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import org.json.JSONException;

class PublishHomeWorkFragment$6
  implements View.OnClickListener
{
  PublishHomeWorkFragment$6(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void onClick(View paramView)
  {
    InputMethodUtil.b(paramView);
    try
    {
      this.a.j();
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PublishHomeWorkFragment", 2, "on publish homework error, parse json error", localJSONException);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment.6
 * JD-Core Version:    0.7.0.1
 */