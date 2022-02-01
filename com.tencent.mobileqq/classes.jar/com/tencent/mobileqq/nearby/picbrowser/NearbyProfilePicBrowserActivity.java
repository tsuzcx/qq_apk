package com.tencent.mobileqq.nearby.picbrowser;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.picbrowser.PicBrowserActivity;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;

@RoutePage(desc="附近资料卡头像", path="/nearby/profile/pic/browser")
public class NearbyProfilePicBrowserActivity
  extends PicBrowserActivity
{
  boolean bShowDelPicAndSetHeadView = false;
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.bShowDelPicAndSetHeadView = getIntent().getBooleanExtra("intent_param_show_del_pic_and_set_head", false);
    if (this.bShowDelPicAndSetHeadView) {
      this.mGalleryManager = new NearbyProfilePicBrowserActivity.CustomGalleryManager(this);
    } else {
      this.mGalleryManager = new NearbyProfilePicBrowserActivity.1(this);
    }
    return super.doOnCreate(paramBundle);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.picbrowser.NearbyProfilePicBrowserActivity
 * JD-Core Version:    0.7.0.1
 */