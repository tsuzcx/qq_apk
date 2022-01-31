package com.tencent.mobileqq.campuscircle;

import abwl;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserGalleryScene.SceneCallback;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserImage;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;

public class CampusCirclePicBrowserActivity
  extends PicBrowserActivity
  implements DialogInterface.OnCancelListener, View.OnClickListener, PicBrowserGalleryScene.SceneCallback
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public CampusCirclePicBrowserGalleryScene a;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public void a(PicBrowserImage paramPicBrowserImage, int paramInt)
  {
    if (paramPicBrowserImage != null) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramPicBrowserImage.a.c);
    }
    if (paramInt < 0) {
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    getWindow().setFlags(1024, 1024);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager = new abwl(this);
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369918));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePicBrowserGalleryScene.a(true);
    this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePicBrowserGalleryScene.a = this;
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePicBrowserGalleryScene.a = null;
  }
  
  protected void doOnPause()
  {
    AbstractGifImage.pauseAll();
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    AbstractGifImage.resumeAll();
    super.doOnResume();
  }
  
  public void finish()
  {
    Intent localIntent = getIntent();
    localIntent.putExtra("delpics", this.jdField_a_of_type_JavaUtilArrayList);
    setResult(-1, localIntent);
    super.finish();
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePicBrowserGalleryScene != null) {
      this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePicBrowserGalleryScene.g();
    }
    ReportController.b(this.app, "dc00898", "", "", "0X80080A3", "0X80080A3", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.campuscircle.CampusCirclePicBrowserActivity
 * JD-Core Version:    0.7.0.1
 */