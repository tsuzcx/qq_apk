package com.tencent.mobileqq.profile.view;

import atwx;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Card;
import java.util.List;

class ProfileTagView$2
  implements Runnable
{
  ProfileTagView$2(ProfileTagView paramProfileTagView, atwx paramatwx) {}
  
  public void run()
  {
    List localList = this.a.a.getLabelList();
    this.this$0.a.runOnUiThread(new ProfileTagView.2.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileTagView.2
 * JD-Core Version:    0.7.0.1
 */