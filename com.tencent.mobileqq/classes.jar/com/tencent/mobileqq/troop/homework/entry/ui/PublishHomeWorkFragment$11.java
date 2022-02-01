package com.tencent.mobileqq.troop.homework.entry.ui;

import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.util.InputMethodUtil;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import mqq.app.QQPermissionCallback;

class PublishHomeWorkFragment$11
  implements QQPermissionCallback
{
  PublishHomeWorkFragment$11(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.a.getActivity(), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = this.a;
    paramArrayOfString.U = TroopHWJsPlugin.a(paramArrayOfString.getActivity(), 260);
    InputMethodUtil.a(this.a.getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment.11
 * JD-Core Version:    0.7.0.1
 */