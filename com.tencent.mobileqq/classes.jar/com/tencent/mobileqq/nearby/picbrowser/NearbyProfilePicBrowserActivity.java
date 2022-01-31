package com.tencent.mobileqq.nearby.picbrowser;

import android.content.Intent;
import android.os.Bundle;
import atns;
import atnt;

public class NearbyProfilePicBrowserActivity
  extends PicBrowserActivity
{
  boolean a;
  
  public NearbyProfilePicBrowserActivity()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("intent_param_show_del_pic_and_set_head", false);
    if (this.jdField_a_of_type_Boolean) {}
    for (this.jdField_a_of_type_Xpz = new atnt(this);; this.jdField_a_of_type_Xpz = new atns(this)) {
      return super.doOnCreate(paramBundle);
    }
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.picbrowser.NearbyProfilePicBrowserActivity
 * JD-Core Version:    0.7.0.1
 */