package com.tencent.mobileqq.facetoface;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class Face2FaceAddFriendActivity$10
  extends FriendListObserver
{
  Face2FaceAddFriendActivity$10(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  protected void onAddFriend(String paramString)
  {
    super.onAddFriend(paramString);
    if (QLog.isColorLevel())
    {
      localObject1 = Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onAddFriend 进入好友列表");
      ((StringBuilder)localObject2).append(paramString);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = Face2FaceAddFriendActivity.a(this.a).obtainMessage();
    ((Message)localObject1).what = 2;
    ((Message)localObject1).arg1 = 2;
    ((Message)localObject1).obj = paramString;
    Face2FaceAddFriendActivity.a(this.a).sendMessage((Message)localObject1);
    Face2FaceAddFriendActivity.a(this.a, 2, paramString);
    localObject1 = Face2FaceAddFriendActivity.a(this.a, paramString, 1);
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = ((Face2FaceFriendBubbleView)localObject1).a();
    if ((localObject2 != null) && (this.a.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)))
    {
      String str = (String)this.a.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if ((!TextUtils.isEmpty(str)) && (localObject2 != null) && (((Face2FaceUserData)localObject2).a == 1))
      {
        ((NearbyUser)localObject2).jdField_a_of_type_JavaLangString = str;
        ((Face2FaceFriendBubbleView)localObject1).a(str);
      }
    }
    if (this.a.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(localObject2))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.a(paramString);
      paramString = Face2FaceAddFriendActivity.a(this.a).obtainMessage();
      paramString.what = 11;
      paramString.arg1 = 1;
      Face2FaceAddFriendActivity.a(this.a).sendMessageDelayed(paramString, this.a.a());
    }
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    super.onUpdateDelFriend(paramBoolean, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "onUpdateDelFriend 删除好友");
    }
    if (this.a.e.contains(String.valueOf(paramObject))) {
      this.a.e.remove(String.valueOf(paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.10
 * JD-Core Version:    0.7.0.1
 */