package com.tencent.mobileqq.mini.out.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import baaf;
import com.tencent.mobileqq.activity.photo.ProGallery;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.widget.BubblePopupWindow;
import java.util.ArrayList;

public class PhotoPreviewActivity
  extends BaseActivity
{
  public static final String BACK_BTN_TEXT = "back_btn_text";
  public static final String TAG = "PhotoPreviewActivity";
  PhotoPreviewActivity.ImageAdapter adapter;
  TextView backBtn;
  String backBtnText;
  int currentSelectedPostion;
  ProGallery gallery;
  int mTotalPicCount = 0;
  ArrayList<String> paths;
  BubblePopupWindow popup;
  int reqHeight;
  int reqWidth;
  boolean showBar = true;
  TextView titleView;
  View topBar;
  
  void back()
  {
    baaf.a(this, true, false);
    super.finish();
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    if (this.gallery.a(false)) {
      return;
    }
    back();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    setContentView(2131495973);
    this.reqWidth = getResources().getDisplayMetrics().widthPixels;
    this.reqHeight = getResources().getDisplayMetrics().heightPixels;
    initData();
    initUI();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.popup != null) {
      this.popup.b();
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    setIntent(paramIntent);
    initData();
    initUI();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if ((this.showBar) && (this.topBar != null)) {
      this.topBar.setVisibility(0);
    }
  }
  
  public String getURL(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    do
    {
      return str;
      if (paramString.startsWith("//")) {
        return "file:/" + paramString;
      }
      str = paramString;
    } while (!paramString.startsWith("/"));
    return "file://" + paramString;
  }
  
  void hideMenuBar()
  {
    this.showBar = false;
    this.topBar.setVisibility(4);
    if (this.popup != null) {
      this.popup.b();
    }
  }
  
  void initData()
  {
    Intent localIntent = getIntent();
    this.backBtnText = localIntent.getStringExtra("back_btn_text");
    this.paths = localIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if (this.paths != null) {}
    for (int i = this.paths.size();; i = 0)
    {
      this.mTotalPicCount = i;
      if (this.mTotalPicCount >= 1) {
        break;
      }
      finish();
      return;
    }
    this.currentSelectedPostion = localIntent.getIntExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
    localIntent.removeExtra("PhotoConst.CURRENT_SELECTED_INDEX");
  }
  
  void initUI()
  {
    this.topBar = findViewById(2131311739);
    this.backBtn = ((TextView)findViewById(2131297456));
    this.backBtn.setOnClickListener(new PhotoPreviewActivity.1(this));
    if (this.showBar) {
      this.topBar.setVisibility(0);
    }
    this.titleView = ((TextView)findViewById(2131311534));
    this.gallery = ((ProGallery)findViewById(2131301286));
    this.adapter = new PhotoPreviewActivity.ImageAdapter(this);
    this.gallery.setAdapter(this.adapter);
    this.gallery.setOnNoBlankListener(this.adapter);
    this.gallery.setSpacing(getResources().getDimensionPixelSize(2131165934));
    this.gallery.setSelection(this.currentSelectedPostion);
    this.gallery.setOnItemClickListener(new PhotoPreviewActivity.2(this));
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  void showMenuBar()
  {
    this.showBar = true;
    this.topBar.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.PhotoPreviewActivity
 * JD-Core Version:    0.7.0.1
 */