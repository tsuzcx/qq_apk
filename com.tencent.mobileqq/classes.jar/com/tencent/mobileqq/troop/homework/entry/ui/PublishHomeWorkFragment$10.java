package com.tencent.mobileqq.troop.homework.entry.ui;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.util.InputMethodUtil;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import mqq.app.QQPermissionCallback;

class PublishHomeWorkFragment$10
  implements QQPermissionCallback
{
  PublishHomeWorkFragment$10(PublishHomeWorkFragment paramPublishHomeWorkFragment, int paramInt) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.b.getActivity());
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = TroopHWJsPlugin.a(10 - this.a, this.b.getActivity(), this.b.W.getCurrentAccountUin());
    paramArrayOfString.putExtra("HomeWorkConstants:homework_request_code_key", 259);
    this.b.startActivityForResult(paramArrayOfString, 259);
    InputMethodUtil.a(this.b.getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment.10
 * JD-Core Version:    0.7.0.1
 */