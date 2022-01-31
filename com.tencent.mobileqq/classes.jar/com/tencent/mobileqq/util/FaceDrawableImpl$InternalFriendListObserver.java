package com.tencent.mobileqq.util;

import java.lang.ref.WeakReference;

public class FaceDrawableImpl$InternalFriendListObserver
  implements FaceDrawableImpl.FaceObserver
{
  public String a;
  public WeakReference a;
  
  FaceDrawableImpl$InternalFriendListObserver(FaceDrawableImpl paramFaceDrawableImpl, FaceDrawable paramFaceDrawable)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramFaceDrawable);
    if ((paramFaceDrawable != null) && (paramFaceDrawable.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo != null)) {
      this.jdField_a_of_type_JavaLangString = paramFaceDrawable.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString;
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl.a(paramBoolean, 11, paramString, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl$InternalFriendListObserver);
  }
  
  public void a(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl.a(paramBoolean1, 32, paramString, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl$InternalFriendListObserver);
  }
  
  public void b(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl.a(paramBoolean, 1, paramString, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl$InternalFriendListObserver);
  }
  
  public void b(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo == null) || (paramInt != this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.b)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl.a(paramBoolean1, 16, paramString, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl$InternalFriendListObserver);
  }
  
  public void c(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl.a(paramBoolean, 4, paramString, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl$InternalFriendListObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.util.FaceDrawableImpl.InternalFriendListObserver
 * JD-Core Version:    0.7.0.1
 */