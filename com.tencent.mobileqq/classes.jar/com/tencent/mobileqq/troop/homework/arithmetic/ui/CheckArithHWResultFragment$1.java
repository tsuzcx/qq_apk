package com.tencent.mobileqq.troop.homework.arithmetic.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.troop.homework.arithmetic.data.ArithResult;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;

class CheckArithHWResultFragment$1
  implements View.OnClickListener
{
  CheckArithHWResultFragment$1(CheckArithHWResultFragment paramCheckArithHWResultFragment) {}
  
  public void onClick(View paramView)
  {
    try
    {
      CheckArithHWResultFragment.a(this.a, CheckArithHWResultFragment.a(this.a).a(), CheckArithHWResultFragment.a(this.a).a());
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        AssertUtils.a("QQ.Troop.homework.CheckArithHWResultFragment//onClick toJSON error:" + localJSONException, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.arithmetic.ui.CheckArithHWResultFragment.1
 * JD-Core Version:    0.7.0.1
 */