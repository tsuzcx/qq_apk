package com.tencent.mobileqq.facetoface;

import android.content.Context;
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

class Face2FaceAddFriendActivity$21
  implements Face2FaceDetailBaseView.IFace2faceContext
{
  Face2FaceAddFriendActivity$21(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
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
    if (!NetworkUtil.isNetSupport(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString, 2, "joinTroop, NetworkUtil.isNetSupport==false");
      }
      QQToast.a(this.a.app.getApplication(), 2131694424, 0).b(this.a.getTitleBarHeight());
      return false;
    }
    Object localObject1 = (NearFieldTroopHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.NEARFIELD_TROOP_HANDLER);
    if (localObject1 != null)
    {
      Object localObject2 = this.a;
      ((Face2FaceAddFriendActivity)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog((Context)localObject2);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(HardCodeUtil.a(2131704405));
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      try
      {
        long l1 = Long.valueOf(paramFace2FaceGroupProfile.e).longValue();
        long l2 = Long.valueOf(paramFace2FaceGroupProfile.jdField_b_of_type_JavaLangString).longValue();
        if (QLog.isColorLevel())
        {
          localObject2 = Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("joinTroop, troopCode=");
          localStringBuilder.append(l1);
          localStringBuilder.append(", ownerUin=");
          localStringBuilder.append(l2);
          localStringBuilder.append(", distance=");
          localStringBuilder.append(paramFace2FaceGroupProfile.d);
          QLog.d((String)localObject2, 2, localStringBuilder.toString());
        }
        ((NearFieldTroopHandler)localObject1).a(l1, l2, paramFace2FaceGroupProfile.d, paramInt);
        return true;
      }
      catch (Exception paramFace2FaceGroupProfile)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("joinTroop:");
          ((StringBuilder)localObject2).append(paramFace2FaceGroupProfile.toString());
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    return this.a.a(paramString);
  }
  
  public void b() {}
  
  public void c()
  {
    if (this.a.jdField_b_of_type_Int == 1)
    {
      Face2FaceAddFriendActivity localFace2FaceAddFriendActivity = this.a;
      localFace2FaceAddFriendActivity.a(localFace2FaceAddFriendActivity.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.a);
    }
  }
  
  public void d()
  {
    this.a.g();
    if (QLog.isColorLevel()) {
      QLog.d(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "afterDetailViewHide 详情页返回");
    }
    Face2FaceAddFriendActivity localFace2FaceAddFriendActivity = this.a;
    localFace2FaceAddFriendActivity.g = "";
    Face2FaceAddFriendActivity.a(localFace2FaceAddFriendActivity).sendEmptyMessageDelayed(13, this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.21
 * JD-Core Version:    0.7.0.1
 */