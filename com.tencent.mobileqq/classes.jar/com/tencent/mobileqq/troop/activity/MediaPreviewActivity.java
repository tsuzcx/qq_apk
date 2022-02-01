package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.QQLiveImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.widget.MediaPreviewAdapter;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Gallery;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class MediaPreviewActivity
  extends BaseActivity
{
  static Object jdField_a_of_type_JavaLangObject = new Object();
  static boolean jdField_a_of_type_Boolean = false;
  protected int a;
  protected View a;
  protected FrameLayout a;
  protected TextView a;
  protected MediaPreviewAdapter a;
  protected Gallery a;
  protected Runnable a;
  protected ArrayList<MediaPreviewInfo> a;
  protected int b;
  protected boolean b;
  
  public MediaPreviewActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRunnable = null;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentWidgetGallery == null)
    {
      QQToast.a(this, getString(2131693140), 0).a();
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedView();
    if (localObject == null)
    {
      QQToast.a(this, getString(2131693140), 0).a();
      return;
    }
    localObject = ((ImageView)((View)localObject).findViewById(2131368729)).getDrawable();
    if ((localObject == null) || (!(localObject instanceof URLDrawable)))
    {
      QQToast.a(this, getString(2131693140), 0).a();
      return;
    }
    localObject = (URLDrawable)localObject;
    if (((URLDrawable)localObject).getStatus() != 1)
    {
      QQToast.a(this, getString(2131693140), 0).a();
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.addButton(2131693302, 1);
    localActionSheet.addButton(2131693308, 1);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new MediaPreviewActivity.6(this, localActionSheet, (URLDrawable)localObject));
    localActionSheet.show();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_b_of_type_Boolean = true;
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setInterpolator(new DecelerateInterpolator());
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setFillAfter(true);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.5F, 1.0F, 1.5F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(500L);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new MediaPreviewActivity.10(this));
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new MediaPreviewActivity.11(this);
    }
    this.jdField_a_of_type_ComTencentWidgetGallery.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
    this.jdField_a_of_type_ComTencentWidgetGallery.startAnimation(localAnimationSet);
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
  
  protected void a(Bundle paramBundle)
  {
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramBundle));
    startActivity(localIntent);
    finish();
  }
  
  protected void a(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable.getStatus() != 1) {}
    String str;
    for (;;)
    {
      return;
      new File(AppConstants.SDCARD_IMG_SAVE).mkdirs();
      str = AppConstants.SDCARD_IMG_SAVE + Utils.Crc64String(paramURLDrawable.getURL().toString());
      File localFile = new File(str);
      if (!localFile.exists()) {
        try
        {
          if (localFile.createNewFile())
          {
            b(paramURLDrawable, localFile.getPath());
            return;
          }
        }
        catch (IOException paramURLDrawable)
        {
          QQToast.a(this, getString(2131694921), 0).a();
          return;
        }
      }
    }
    DialogUtil.a(this, 230).setTitle(getString(2131718675)).setMessage(getString(2131694917)).setPositiveButton(getString(2131718540), new MediaPreviewActivity.8(this, paramURLDrawable, str)).setNegativeButton(getString(2131694495), new MediaPreviewActivity.7(this)).show();
  }
  
  void a(URLDrawable paramURLDrawable, String paramString)
  {
    new MediaPreviewActivity.5(this, paramURLDrawable, paramString).execute(new Void[0]);
  }
  
  protected void b(URLDrawable paramURLDrawable, String paramString)
  {
    new MediaPreviewActivity.9(this, paramURLDrawable, paramString).execute(new Void[0]);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle arg1)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(???);
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Boolean)
      {
        super.finish();
        return false;
      }
      jdField_a_of_type_Boolean = true;
      if ((this.app == null) || (TextUtils.isEmpty(this.app.getAccount())))
      {
        finish();
        return false;
      }
    }
    setContentView(2131559371);
    ??? = getIntent().getExtras();
    this.jdField_a_of_type_Int = ???.getInt("index", -1);
    this.jdField_a_of_type_JavaUtilArrayList = ???.getParcelableArrayList("mediaInfoList");
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131377359));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)findViewById(2131367677));
    this.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379091));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131363419);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaPreviewAdapter = new MediaPreviewAdapter(this, this.jdField_a_of_type_ComTencentWidgetGallery);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaPreviewAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaPreviewAdapter);
    this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131297168));
    this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(new MediaPreviewActivity.1(this));
    this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(new MediaPreviewActivity.2(this));
    this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemLongClickListener(new MediaPreviewActivity.3(this));
    ThreadManager.post(new MediaPreviewActivity.4(this), 8, null, true);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.jdField_a_of_type_ComTencentWidgetGallery != null) && (this.jdField_a_of_type_JavaLangRunnable != null)) {
      this.jdField_a_of_type_ComTencentWidgetGallery.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.finish();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 21)) {
      a(paramIntent.getExtras());
    }
  }
  
  public void onBackPressed()
  {
    if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentWidgetGallery.a(false))) {
      a();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaPreviewAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaPreviewAdapter.a();
    }
    QQLiveImage.releaseAll(this);
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_Boolean = false;
      return;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    SmallScreenUtils.a(this, false);
    AbstractGifImage.pauseAll();
    QQLiveImage.pauseAll(this);
    ApngImage.pauseAll();
  }
  
  public void onResume()
  {
    super.onResume();
    SmallScreenUtils.a(this, true);
    AbstractGifImage.resumeAll();
    QQLiveImage.resumeAll(this);
    ApngImage.resumeAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.MediaPreviewActivity
 * JD-Core Version:    0.7.0.1
 */