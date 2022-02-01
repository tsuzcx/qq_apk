package com.tencent.mobileqq.facetoface;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.NearFieldTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class Face2FaceAddFriendActivity$RefreshHandler
  extends Handler
{
  Face2FaceAddFriendActivity$RefreshHandler(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  public void a(long paramLong)
  {
    removeMessages(0);
    sendMessageDelayed(obtainMessage(0), paramLong);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      boolean bool2 = false;
      boolean bool1 = false;
      int j = 2;
      Object localObject1;
      switch (i)
      {
      default: 
        return;
      case 18: 
        QQToast.a(this.a.app.getApplication(), 2131694424, 0).b(this.a.getTitleBarHeight());
        return;
      case 17: 
        long l = this.a.o;
        paramMessage = new StringBuilder();
        paramMessage.append(l + 2396794490L);
        paramMessage.append("");
        paramMessage = paramMessage.toString();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Member ");
        ((StringBuilder)localObject1).append(this.a.o);
        paramMessage = new Face2FaceUserProfile(paramMessage, ((StringBuilder)localObject1).toString(), 1, 1, "");
        localObject1 = this.a;
        ((Face2FaceAddFriendActivity)localObject1).o += 1;
        Face2FaceAddFriendActivity.a(this.a).a(paramMessage);
        Face2FaceAddFriendActivity.a(this.a).sendEmptyMessageDelayed(17, 300L);
        return;
      case 16: 
        if (!(paramMessage.obj instanceof Face2FaceUserProfile)) {
          break;
        }
        Face2FaceAddFriendActivity.a(this.a).a((Face2FaceUserProfile)paramMessage.obj);
        return;
      case 15: 
        if (!(paramMessage.obj instanceof Face2FaceUserProfile)) {
          break;
        }
        this.a.jdField_a_of_type_JavaUtilArrayList.add((Face2FaceUserProfile)paramMessage.obj);
        return;
      case 14: 
        if (!(paramMessage.obj instanceof Face2FaceUserProfile)) {
          break;
        }
        paramMessage = (Face2FaceUserProfile)paramMessage.obj;
        this.a.a(paramMessage);
        return;
      case 13: 
        paramMessage = this.a.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        while (paramMessage.hasNext())
        {
          localObject1 = (Face2FaceUserData)paramMessage.next();
          if ((((Face2FaceUserData)localObject1).a == 1) && (Face2FaceAddFriendActivity.a(this.a, ((Face2FaceUserData)localObject1).e))) {
            Face2FaceAddFriendActivity.a(this.a, ((Face2FaceUserData)localObject1).a);
          } else if ((((Face2FaceUserData)localObject1).a == 2) && (this.a.a(((Face2FaceUserData)localObject1).e))) {
            Face2FaceAddFriendActivity.a(this.a, ((Face2FaceUserData)localObject1).a);
          }
        }
      case 12: 
        this.a.a((Face2FaceGroupProfile)paramMessage.obj);
        return;
      case 11: 
        Face2FaceAddFriendActivity.a(this.a, paramMessage.arg1);
        return;
      case 10: 
        Face2FaceAddFriendActivity.a(this.a, (Face2FaceUserData)paramMessage.obj);
        return;
      case 9: 
        this.a.f();
        return;
      case 8: 
        this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.b();
        return;
      case 7: 
        this.a.a();
        return;
      case 6: 
        if (Face2FaceAddFriendActivity.a(this.a)) {
          break;
        }
        paramMessage = this.a.getResources().getString(2131692140);
        QQToast.a(this.a, 0, paramMessage, 0).b(this.a.getTitleBarHeight());
        return;
      case 5: 
        if (this.a.jdField_a_of_type_ComTencentMobileqqAppLBSHandler == null) {
          break;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a(this.a.app.getCurrentAccountUin(), true);
        sendMessageDelayed(obtainMessage(5), Face2FaceAddFriendActivity.h);
        if (!QLog.isColorLevel()) {
          break;
        }
        paramMessage = Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("FTF_MSG_SEND_HEARTBEAT=");
        ((StringBuilder)localObject1).append(this.a.app.getCurrentAccountUin());
        QLog.d(paramMessage, 2, ((StringBuilder)localObject1).toString());
        return;
      case 4: 
        int m = paramMessage.arg1;
        int n = paramMessage.arg2;
        Object localObject2 = paramMessage.getData();
        localObject1 = Boolean.valueOf(((Bundle)localObject2).getBoolean("key_data _ispush"));
        boolean bool3 = ((Bundle)localObject2).getBoolean("key_data _hasfriend");
        int k = this.a.jdField_d_of_type_JavaUtilList.size();
        i = k;
        if (k >= 10) {
          i = 10;
        }
        if (this.a.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramMessage.obj))
        {
          if (QLog.isColorLevel()) {
            QLog.d(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "push的数据是显示列表中已有数据");
          }
          return;
        }
        if (m >= i) {
          break;
        }
        if (n == 1)
        {
          paramMessage = (NearbyUser)paramMessage.obj;
          if (paramMessage.a) {
            j = 2;
          } else {
            j = 1;
          }
          if (this.a.jdField_c_of_type_Int == i - 1) {
            bool1 = true;
          }
          if (((Boolean)localObject1).booleanValue())
          {
            this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.c();
            bool1 = true;
          }
          if (QLog.isColorLevel())
          {
            localObject2 = Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("show next isPush=");
            localStringBuilder.append(localObject1);
            localStringBuilder.append("isNeedShake=");
            localStringBuilder.append(bool1);
            localStringBuilder.append("currentFriendIndex=");
            localStringBuilder.append(this.a.jdField_c_of_type_Int);
            localStringBuilder.append("count=");
            localStringBuilder.append(i);
            QLog.d((String)localObject2, 2, localStringBuilder.toString());
          }
          this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.a(paramMessage, ((Boolean)localObject1).booleanValue(), j, bool3, bool1);
          if (this.a.jdField_c_of_type_JavaUtilHashMap.containsKey(paramMessage.e))
          {
            this.a.jdField_c_of_type_JavaUtilHashMap.remove(paramMessage.e);
            this.a.jdField_c_of_type_JavaUtilHashMap.put(paramMessage.e, Integer.valueOf(j));
          }
          else
          {
            this.a.jdField_c_of_type_JavaUtilHashMap.put(paramMessage.e, Integer.valueOf(j));
          }
        }
        else if (n == 2)
        {
          paramMessage = (Face2FaceUserData)paramMessage.obj;
          if (this.a.b == 0 ? this.a.a(paramMessage.e) : (this.a.b != 1) || (((TroopManager)this.a.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.a.jdField_d_of_type_JavaLangString, paramMessage.e) == null)) {
            j = 1;
          }
          bool1 = bool2;
          if (this.a.jdField_c_of_type_Int == i - 1) {
            bool1 = true;
          }
          if (((Boolean)localObject1).booleanValue())
          {
            this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.c();
            bool1 = true;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.a(paramMessage, ((Boolean)localObject1).booleanValue(), j, bool3, bool1);
          if (this.a.jdField_c_of_type_JavaUtilHashMap.containsKey(paramMessage.e))
          {
            this.a.jdField_c_of_type_JavaUtilHashMap.remove(paramMessage.e);
            this.a.jdField_c_of_type_JavaUtilHashMap.put(paramMessage.e, Integer.valueOf(j));
          }
          else
          {
            this.a.jdField_c_of_type_JavaUtilHashMap.put(paramMessage.e, Integer.valueOf(j));
          }
        }
        Face2FaceAddFriendActivity.b(this.a);
        return;
      case 3: 
        this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.a(1, false);
        return;
      case 2: 
        Face2FaceAddFriendActivity.a(this.a, (String)paramMessage.obj, paramMessage.arg1);
        return;
      }
    }
    else
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceSnowView.invalidate();
      a(20L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.RefreshHandler
 * JD-Core Version:    0.7.0.1
 */