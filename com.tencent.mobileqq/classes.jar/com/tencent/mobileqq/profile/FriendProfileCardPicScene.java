package com.tencent.mobileqq.profile;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.mobileqq.activity.FriendProfilePicBrowserActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserGalleryAdapter;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserGalleryScene;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserImage;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserModel;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;

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
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel != null) {
      return this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.b();
    }
    return -1;
  }
  
  protected RelativeLayout a()
  {
    return (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130970527, null);
  }
  
  public PicInfo a()
  {
    PicInfo localPicInfo = null;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.a() != null) {
      localPicInfo = this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.a().a;
    }
    return localPicInfo;
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserGalleryAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserGalleryAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity.b();
    }
  }
  
  protected void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity.c();
    }
  }
  
  public void s()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserGalleryAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserGalleryAdapter.a(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.FriendProfileCardPicScene
 * JD-Core Version:    0.7.0.1
 */