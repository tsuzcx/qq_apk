package com.tencent.mobileqq.facetoface;

import android.os.Message;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class Face2FaceAddFriendActivity$7
  extends LBSObserver
{
  Face2FaceAddFriendActivity$7(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  protected void a(NearbyUser paramNearbyUser, boolean paramBoolean, int paramInt)
  {
    super.a(paramNearbyUser, paramBoolean, paramInt);
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetFaceToFaceNearbyUserPush, pushTime=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("from_type=");
      localStringBuilder.append(this.a.jdField_b_of_type_Int);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (paramNearbyUser == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "onGetFaceToFaceNearbyUserPush, nearbyUser=null!!");
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetFaceToFaceNearbyUserPush, nearbyUser=");
      localStringBuilder.append(paramNearbyUser.e);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if ((this.a.jdField_b_of_type_Int == 0) && (paramNearbyUser != null))
    {
      localObject = this.a;
      if (!((Face2FaceAddFriendActivity)localObject).a(paramNearbyUser, ((Face2FaceAddFriendActivity)localObject).jdField_a_of_type_JavaUtilList))
      {
        this.a.jdField_a_of_type_JavaUtilList.add(paramNearbyUser);
        if (QLog.isColorLevel())
        {
          localObject = Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onGetFaceToFaceNearbyUserPush, mhasShowList=");
          localStringBuilder.append(this.a.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
          localStringBuilder.append("mNeedShowList.size()");
          localStringBuilder.append(this.a.d.size());
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
        if (this.a.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == this.a.d.size())
        {
          Face2FaceAddFriendActivity.a(this.a, paramNearbyUser);
        }
        else
        {
          localObject = Face2FaceAddFriendActivity.a(this.a).obtainMessage();
          ((Message)localObject).what = 10;
          ((Message)localObject).obj = paramNearbyUser;
          Face2FaceAddFriendActivity.a(this.a).sendEmptyMessageDelayed(10, this.a.a());
        }
        paramNearbyUser = this.a;
        paramNearbyUser.j += 1;
      }
    }
  }
  
  protected void a(boolean paramBoolean, List<NearbyUser> paramList, int paramInt1, int paramInt2)
  {
    super.a(paramBoolean, paramList, paramInt1, paramInt2);
    if (paramBoolean) {
      this.a.e = 1;
    } else {
      this.a.e = 2;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetFaceToFaceNearbyUserList heartBeatTime=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("from_type=");
      localStringBuilder.append(this.a.jdField_b_of_type_Int);
      localStringBuilder.append("reqInterval=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("好友列表返回isSuccess=");
      localStringBuilder.append(paramBoolean);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (paramList != null)
    {
      if (QLog.isColorLevel())
      {
        localObject = Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onGetFaceToFaceNearbyUserList size=");
        localStringBuilder.append(paramList.size());
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "onGetFaceToFaceNearbyUserList is null");
    }
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 2;
    }
    long l1 = System.currentTimeMillis() - Face2FaceAddFriendConstants.c;
    if (QLog.isColorLevel())
    {
      localObject = Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetFaceToFaceNearbyUserList interval=");
      localStringBuilder.append(l1);
      localStringBuilder.append("leaveFaceTofaceTime=");
      localStringBuilder.append(Face2FaceAddFriendConstants.c);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    long l2 = i * 1000;
    if ((l1 <= l2) && (Face2FaceAddFriendConstants.c != 0L))
    {
      Face2FaceAddFriendActivity.a(this.a, l2 - l1);
      return;
    }
    if (paramInt2 > 0) {
      Face2FaceAddFriendActivity.h = paramInt2 * 1000;
    }
    if (!this.a.jdField_b_of_type_Boolean) {
      Face2FaceAddFriendActivity.c(this.a);
    }
    Object localObject = this.a;
    ((Face2FaceAddFriendActivity)localObject).jdField_b_of_type_Boolean = true;
    if ((((Face2FaceAddFriendActivity)localObject).jdField_b_of_type_Int == 0) && (paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (Face2FaceUserData)paramList.next();
        if (this.a.jdField_a_of_type_JavaUtilList.contains(localObject)) {
          break;
        }
        this.a.jdField_a_of_type_JavaUtilList.add(localObject);
      }
    }
    Face2FaceAddFriendActivity.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.7
 * JD-Core Version:    0.7.0.1
 */