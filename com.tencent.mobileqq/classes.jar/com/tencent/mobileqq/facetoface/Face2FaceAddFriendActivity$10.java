package com.tencent.mobileqq.facetoface;

import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.qphone.base.util.QLog;

class Face2FaceAddFriendActivity$10
  extends AvatarObserver
{
  Face2FaceAddFriendActivity$10(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  public void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d(Face2FaceAddFriendActivity.a, 2, "好友onUpdateCustomHead success = " + paramBoolean);
    }
    if (this.a.l) {
      return;
    }
    if (this.a.b == 1) {}
    for (;;)
    {
      Face2FaceFriendBubbleView localFace2FaceFriendBubbleView = Face2FaceAddFriendActivity.a(this.a, paramString, i);
      if (localFace2FaceFriendBubbleView == null) {
        break;
      }
      localFace2FaceFriendBubbleView.a(this.a.app, paramString, 1);
      return;
      i = 1;
    }
  }
  
  public void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(Face2FaceAddFriendActivity.a, 2, "群onUpdateTroopHead success = " + paramBoolean);
    }
    Face2FaceFriendBubbleView localFace2FaceFriendBubbleView = Face2FaceAddFriendActivity.a(this.a, paramString, 2);
    if (localFace2FaceFriendBubbleView != null) {
      localFace2FaceFriendBubbleView.a(this.a.app, paramString, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.10
 * JD-Core Version:    0.7.0.1
 */