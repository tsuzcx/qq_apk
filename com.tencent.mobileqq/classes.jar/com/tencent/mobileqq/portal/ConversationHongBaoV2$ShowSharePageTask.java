package com.tencent.mobileqq.portal;

import com.tencent.mobileqq.activity.springfestival.HBEntryShareActivity;
import com.tencent.mobileqq.activity.springfestival.entry.model.OnGrabActivityData.Share;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ConversationHongBaoV2$ShowSharePageTask
{
  private int jdField_a_of_type_Int;
  private OnGrabActivityData.Share jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelOnGrabActivityData$Share;
  private String jdField_a_of_type_JavaLangString;
  private List<String> jdField_a_of_type_JavaUtilList;
  private int b;
  private int c;
  private int d;
  
  public ConversationHongBaoV2$ShowSharePageTask(List<String> paramList, OnGrabActivityData.Share paramShare, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_JavaUtilList = paramShare;
    this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelOnGrabActivityData$Share = paramString;
    this.jdField_a_of_type_JavaLangString = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    int i;
    this.b = i;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "ShowSharePageTask invoke");
    }
    HBEntryShareActivity.a((BaseActivity)ConversationHongBaoV2.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.c, this.d, this.b, this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelOnGrabActivityData$Share.logoImgUrl, this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelOnGrabActivityData$Share.nameWording, this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelOnGrabActivityData$Share.greetWording, this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelOnGrabActivityData$Share.bgUrl, this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelOnGrabActivityData$Share.shareBgUrl, this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelOnGrabActivityData$Share.qrImgUrl, this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelOnGrabActivityData$Share.bottomWording, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelOnGrabActivityData$Share.middleBgUrl, this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelOnGrabActivityData$Share.middleShareBgUrl, this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelOnGrabActivityData$Share.btnImgUrl, this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelOnGrabActivityData$Share.btnPressImgUrl, this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelOnGrabActivityData$Share.btnImgApngUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ConversationHongBaoV2.ShowSharePageTask
 * JD-Core Version:    0.7.0.1
 */