package com.tencent.mobileqq.profile;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.mobileqq.activity.FriendProfilePicBrowserActivity;
import com.tencent.mobileqq.picbrowser.PicBrowserGalleryAdapter;
import com.tencent.mobileqq.picbrowser.PicBrowserGalleryScene;
import com.tencent.mobileqq.picbrowser.PicBrowserImage;
import com.tencent.mobileqq.picbrowser.PicBrowserModel;
import com.tencent.mobileqq.picbrowser.PicInfo;

public class FriendProfileCardPicScene
  extends PicBrowserGalleryScene
{
  FriendProfilePicBrowserActivity a;
  
  public FriendProfileCardPicScene(FriendProfilePicBrowserActivity paramFriendProfilePicBrowserActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    super(paramFriendProfilePicBrowserActivity, paramAbstractImageListModel);
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity = paramFriendProfilePicBrowserActivity;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserModel != null) {
      return this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserModel.b();
    }
    return -1;
  }
  
  protected RelativeLayout a()
  {
    return (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561376, null);
  }
  
  public PicInfo a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserModel.a() != null) {
      return this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserModel.a().a;
    }
    return null;
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    if (this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserGalleryAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserGalleryAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected void b(int paramInt)
  {
    FriendProfilePicBrowserActivity localFriendProfilePicBrowserActivity = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity;
    if (localFriendProfilePicBrowserActivity != null) {
      localFriendProfilePicBrowserActivity.b();
    }
  }
  
  public void h()
  {
    super.h();
    FriendProfilePicBrowserActivity localFriendProfilePicBrowserActivity = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity;
    if (localFriendProfilePicBrowserActivity != null) {
      localFriendProfilePicBrowserActivity.a();
    }
  }
  
  public void u()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserGalleryAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserGalleryAdapter.a(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.FriendProfileCardPicScene
 * JD-Core Version:    0.7.0.1
 */