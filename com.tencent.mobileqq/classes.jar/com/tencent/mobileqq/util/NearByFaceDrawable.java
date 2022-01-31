package com.tencent.mobileqq.util;

import akag;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.FaceHandler;
import com.tencent.mobileqq.app.FaceObserver;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;

public class NearByFaceDrawable
  extends FaceDrawable
{
  public FaceObserver a;
  public NearbyAppInterface a;
  
  public NearByFaceDrawable(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, byte paramByte, int paramInt3, boolean paramBoolean1, Drawable paramDrawable1, Drawable paramDrawable2, FaceDrawable.OnLoadingStateChangeListener paramOnLoadingStateChangeListener, boolean paramBoolean2)
  {
    super(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, 100, paramBoolean1, paramDrawable1, paramDrawable2, paramOnLoadingStateChangeListener, paramBoolean2);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceObserver = null;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = ((NearbyAppInterface)paramAppInterface);
  }
  
  protected Bitmap a(boolean paramBoolean)
  {
    return b();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppFaceObserver != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFaceObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceObserver = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = null;
    super.a();
  }
  
  protected void a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = ((NearbyAppInterface)paramAppInterface);
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearByFaceDrawable", 2, "requestDecode.faceInfo=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo == null) {
      return false;
    }
    FaceDecodeTask.a(FaceDecodeTask.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo, this));
    return true;
  }
  
  public Bitmap b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo == null) {
      return null;
    }
    String str = FaceInfo.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.b, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.c);
    return ((FaceManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(215)).a(str);
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearByFaceDrawable", 2, "onNeedDownload.faceInfo=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo);
    }
    Bitmap localBitmap = b();
    if (localBitmap != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.NearByFaceDrawable", 2, "onNeedDownload.faceInfo=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo + ",bitmap is already in cache...");
      }
      a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo, localBitmap);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceObserver = new akag(this);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFaceObserver);
    }
    ((FaceHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(4)).a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.util.NearByFaceDrawable
 * JD-Core Version:    0.7.0.1
 */