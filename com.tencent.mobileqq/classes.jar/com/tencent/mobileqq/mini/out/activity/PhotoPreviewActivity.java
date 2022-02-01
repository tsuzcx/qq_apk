package com.tencent.mobileqq.mini.out.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.ProGallery;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.AlbumUtil;
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
    AlbumUtil.anim(this, true, false);
    super.finish();
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    if (this.gallery.resetScale(false)) {
      return;
    }
    back();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    setContentView(2131628394);
    this.reqWidth = getResources().getDisplayMetrics().widthPixels;
    this.reqHeight = getResources().getDisplayMetrics().heightPixels;
    initData();
    initUI();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    BubblePopupWindow localBubblePopupWindow = this.popup;
    if (localBubblePopupWindow != null) {
      localBubblePopupWindow.dismiss();
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    setIntent(paramIntent);
    initData();
    initUI();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.showBar)
    {
      View localView = this.topBar;
      if (localView != null) {
        localView.setVisibility(0);
      }
    }
  }
  
  public String getURL(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (paramString.startsWith("//"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("file:/");
      ((StringBuilder)localObject).append(paramString);
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = paramString;
    if (paramString.startsWith("/"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("file://");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  void hideMenuBar()
  {
    this.showBar = false;
    this.topBar.setVisibility(4);
    BubblePopupWindow localBubblePopupWindow = this.popup;
    if (localBubblePopupWindow != null) {
      localBubblePopupWindow.dismiss();
    }
  }
  
  void initData()
  {
    Intent localIntent = getIntent();
    this.backBtnText = localIntent.getStringExtra("back_btn_text");
    this.paths = localIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    ArrayList localArrayList = this.paths;
    int i;
    if (localArrayList != null) {
      i = localArrayList.size();
    } else {
      i = 0;
    }
    this.mTotalPicCount = i;
    if (this.mTotalPicCount < 1)
    {
      finish();
      return;
    }
    this.currentSelectedPostion = localIntent.getIntExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
    localIntent.removeExtra("PhotoConst.CURRENT_SELECTED_INDEX");
  }
  
  void initUI()
  {
    this.topBar = findViewById(2131447713);
    this.backBtn = ((TextView)findViewById(2131429224));
    this.backBtn.setOnClickListener(new PhotoPreviewActivity.1(this));
    if (this.showBar) {
      this.topBar.setVisibility(0);
    }
    this.titleView = ((TextView)findViewById(2131447463));
    this.gallery = ((ProGallery)findViewById(2131433934));
    this.adapter = new PhotoPreviewActivity.ImageAdapter(this);
    this.gallery.setAdapter(this.adapter);
    this.gallery.setOnNoBlankListener(this.adapter);
    this.gallery.setSpacing(getResources().getDimensionPixelSize(2131297535));
    this.gallery.setSelection(this.currentSelectedPostion);
    this.gallery.setOnItemClickListener(new PhotoPreviewActivity.2(this));
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  void showMenuBar()
  {
    this.showBar = true;
    this.topBar.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.PhotoPreviewActivity
 * JD-Core Version:    0.7.0.1
 */