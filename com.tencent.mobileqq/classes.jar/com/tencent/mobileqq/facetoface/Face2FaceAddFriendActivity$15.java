package com.tencent.mobileqq.facetoface;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class Face2FaceAddFriendActivity$15
  implements View.OnClickListener
{
  Face2FaceAddFriendActivity$15(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity, Face2FaceUserData paramFace2FaceUserData) {}
  
  public void onClick(View paramView)
  {
    Face2FaceAddFriendActivity localFace2FaceAddFriendActivity = this.b;
    ProfileCardUtil.a(localFace2FaceAddFriendActivity, localFace2FaceAddFriendActivity.P.getHeadView(), this.a.f, 1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.15
 * JD-Core Version:    0.7.0.1
 */