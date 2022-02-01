package com.tencent.mobileqq.facetoface;

import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.qphone.base.util.QLog;

class Face2FaceAddFriendActivity$11
  extends AvatarObserver
{
  Face2FaceAddFriendActivity$11(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool)
    {
      localObject = Face2FaceAddFriendActivity.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("好友onUpdateCustomHead success = ");
      localStringBuilder.append(paramBoolean);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.a.l) {
      return;
    }
    if (this.a.b != 1) {
      i = 1;
    }
    Object localObject = Face2FaceAddFriendActivity.a(this.a, paramString, i);
    if (localObject != null) {
      ((Face2FaceFriendBubbleView)localObject).a(this.a.app, paramString, 1);
    }
  }
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = Face2FaceAddFriendActivity.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("群onUpdateTroopHead success = ");
      localStringBuilder.append(paramBoolean);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = Face2FaceAddFriendActivity.a(this.a, paramString, 2);
    if (localObject != null) {
      ((Face2FaceFriendBubbleView)localObject).a(this.a.app, paramString, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.11
 * JD-Core Version:    0.7.0.1
 */