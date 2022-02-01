package com.tencent.mobileqq.profile.PersonalityLabel;

import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class PersonalityLabelShareActivity$1
  implements QQPermissionCallback
{
  PersonalityLabelShareActivity$1(PersonalityLabelShareActivity paramPersonalityLabelShareActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    PersonalityLabelShareActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelShareActivity.1
 * JD-Core Version:    0.7.0.1
 */