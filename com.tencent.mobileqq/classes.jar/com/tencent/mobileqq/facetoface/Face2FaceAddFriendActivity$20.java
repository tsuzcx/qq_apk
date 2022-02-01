package com.tencent.mobileqq.facetoface;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.NearFieldTroopHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class Face2FaceAddFriendActivity$20
  implements Face2FaceDetailBaseView.IFace2faceContext
{
  Face2FaceAddFriendActivity$20(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  public QQAppInterface a()
  {
    return this.a.app;
  }
  
  public void a()
  {
    this.a.h();
  }
  
  public void a(Face2FaceGroupProfile paramFace2FaceGroupProfile)
  {
    if (this.a.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == this.a.d.size())
    {
      this.a.a(paramFace2FaceGroupProfile);
      return;
    }
    Face2FaceAddFriendActivity.a(this.a).obtainMessage().obj = paramFace2FaceGroupProfile;
    Face2FaceAddFriendActivity.a(this.a).sendEmptyMessageDelayed(12, 5000L);
  }
  
  public boolean a(Face2FaceGroupProfile paramFace2FaceGroupProfile, int paramInt)
  {
    if (!NetworkUtil.d(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString, 2, "joinTroop, NetworkUtil.isNetSupport==false");
      }
      QQToast.a(this.a.app.getApplication(), 2131694459, 0).b(this.a.getTitleBarHeight());
    }
    do
    {
      NearFieldTroopHandler localNearFieldTroopHandler;
      do
      {
        return false;
        localNearFieldTroopHandler = (NearFieldTroopHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.NEARFIELD_TROOP_HANDLER);
      } while (localNearFieldTroopHandler == null);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.a);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(HardCodeUtil.a(2131704314));
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      try
      {
        long l1 = Long.valueOf(paramFace2FaceGroupProfile.e).longValue();
        long l2 = Long.valueOf(paramFace2FaceGroupProfile.jdField_b_of_type_JavaLangString).longValue();
        if (QLog.isColorLevel()) {
          QLog.d(Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString, 2, "joinTroop, troopCode=" + l1 + ", ownerUin=" + l2 + ", distance=" + paramFace2FaceGroupProfile.d);
        }
        localNearFieldTroopHandler.a(l1, l2, paramFace2FaceGroupProfile.d, paramInt);
        return true;
      }
      catch (Exception paramFace2FaceGroupProfile) {}
    } while (!QLog.isColorLevel());
    QLog.d(Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString, 2, "joinTroop:" + paramFace2FaceGroupProfile.toString());
    return false;
  }
  
  public boolean a(String paramString)
  {
    return this.a.a(paramString);
  }
  
  public void b() {}
  
  public void c()
  {
    if (this.a.jdField_b_of_type_Int == 1) {
      this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.a);
    }
  }
  
  public void d()
  {
    this.a.g();
    if (QLog.isColorLevel()) {
      QLog.d(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "afterDetailViewHide 详情页返回");
    }
    this.a.g = "";
    Face2FaceAddFriendActivity.a(this.a).sendEmptyMessageDelayed(13, this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.20
 * JD-Core Version:    0.7.0.1
 */