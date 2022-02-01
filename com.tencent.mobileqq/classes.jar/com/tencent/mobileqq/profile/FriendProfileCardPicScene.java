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
  FriendProfilePicBrowserActivity f;
  
  public FriendProfileCardPicScene(FriendProfilePicBrowserActivity paramFriendProfilePicBrowserActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    super(paramFriendProfilePicBrowserActivity, paramAbstractImageListModel);
    this.f = paramFriendProfilePicBrowserActivity;
  }
  
  public PicInfo F()
  {
    if (this.c.c() != null) {
      return this.c.c().k;
    }
    return null;
  }
  
  public int G()
  {
    if (this.c != null) {
      return this.c.b();
    }
    return -1;
  }
  
  public void H()
  {
    if (this.a != null) {
      this.a.a(null);
    }
    this.f = null;
  }
  
  protected RelativeLayout a()
  {
    return (RelativeLayout)LayoutInflater.from(this.w).inflate(2131627732, null);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    if (this.a != null) {
      this.a.a(this.f);
    }
  }
  
  protected void b(int paramInt)
  {
    FriendProfilePicBrowserActivity localFriendProfilePicBrowserActivity = this.f;
    if (localFriendProfilePicBrowserActivity != null) {
      localFriendProfilePicBrowserActivity.b();
    }
  }
  
  public void i()
  {
    super.i();
    FriendProfilePicBrowserActivity localFriendProfilePicBrowserActivity = this.f;
    if (localFriendProfilePicBrowserActivity != null) {
      localFriendProfilePicBrowserActivity.a();
    }
  }
  
  public boolean o()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.FriendProfileCardPicScene
 * JD-Core Version:    0.7.0.1
 */