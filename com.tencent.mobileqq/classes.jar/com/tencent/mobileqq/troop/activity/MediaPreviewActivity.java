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
    Object localObject = this.jdField_a_of_type_ComTencentWidgetGallery;
    if (localObject == null)
    {
      QQToast.a(this, getString(2131693100), 0).a();
      return;
    }
    localObject = ((Gallery)localObject).getSelectedView();
    if (localObject == null)
    {
      QQToast.a(this, getString(2131693100), 0).a();
      return;
    }
    localObject = ((ImageView)((View)localObject).findViewById(2131368461)).getDrawable();
    if ((localObject != null) && ((localObject instanceof URLDrawable)))
    {
      localObject = (URLDrawable)localObject;
      if (((URLDrawable)localObject).getStatus() != 1)
      {
        QQToast.a(this, getString(2131693100), 0).a();
        return;
      }
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
      localActionSheet.addButton(2131693256, 1);
      localActionSheet.addButton(2131693262, 1);
      localActionSheet.addCancelButton(2131690728);
      localActionSheet.setOnButtonClickListener(new MediaPreviewActivity.6(this, localActionSheet, (URLDrawable)localObject));
      localActionSheet.show();
      return;
    }
    QQToast.a(this, getString(2131693100), 0).a();
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
    if (paramURLDrawable.getStatus() != 1) {
      return;
    }
    new File(AppConstants.SDCARD_IMG_SAVE).mkdirs();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_IMG_SAVE);
    ((StringBuilder)localObject).append(Utils.Crc64String(paramURLDrawable.getURL().toString()));
    localObject = ((StringBuilder)localObject).toString();
    File localFile = new File((String)localObject);
    if (!localFile.exists()) {}
    try
    {
      if (!localFile.createNewFile()) {
        break label177;
      }
      b(paramURLDrawable, localFile.getPath());
      return;
    }
    catch (IOException paramURLDrawable)
    {
      label92:
      break label92;
    }
    QQToast.a(this, getString(2131694911), 0).a();
    return;
    DialogUtil.a(this, 230).setTitle(getString(2131718393)).setMessage(getString(2131694907)).setPositiveButton(getString(2131718205), new MediaPreviewActivity.8(this, paramURLDrawable, (String)localObject)).setNegativeButton(getString(2131694460), new MediaPreviewActivity.7(this)).show();
    label177:
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
  
  protected boolean doOnCreate(Bundle arg1)
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
      if ((this.app != null) && (!TextUtils.isEmpty(this.app.getAccount())))
      {
        setContentView(2131559246);
        ??? = getIntent().getExtras();
        this.jdField_a_of_type_Int = ???.getInt("index", -1);
        this.jdField_a_of_type_JavaUtilArrayList = ???.getParcelableArrayList("mediaInfoList");
        ??? = this.jdField_a_of_type_JavaUtilArrayList;
        if (??? != null) {
          this.jdField_b_of_type_Int = ???.size();
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131376811));
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)findViewById(2131367431));
        this.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378460));
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView = findViewById(2131363349);
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaPreviewAdapter = new MediaPreviewAdapter(this, this.jdField_a_of_type_ComTencentWidgetGallery);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaPreviewAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaPreviewAdapter);
        this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131297150));
        this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(new MediaPreviewActivity.1(this));
        this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(new MediaPreviewActivity.2(this));
        this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemLongClickListener(new MediaPreviewActivity.3(this));
        ThreadManager.post(new MediaPreviewActivity.4(this), 8, null, true);
        return true;
      }
      finish();
      return false;
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    Gallery localGallery = this.jdField_a_of_type_ComTencentWidgetGallery;
    if (localGallery != null)
    {
      Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
      if (localRunnable != null) {
        localGallery.removeCallbacks(localRunnable);
      }
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.finish();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 21)) {
      a(paramIntent.getExtras());
    }
  }
  
  public void onBackPressed()
  {
    if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentWidgetGallery.resetScale(false))) {
      a();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    ??? = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaPreviewAdapter;
    if (??? != null) {
      ((MediaPreviewAdapter)???).a();
    }
    QQLiveImage.releaseAll(this);
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_Boolean = false;
      return;
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    SmallScreenUtils.a(this, false);
    AbstractGifImage.pauseAll();
    QQLiveImage.pauseAll(this);
    ApngImage.pauseAll();
  }
  
  protected void onResume()
  {
    super.onResume();
    SmallScreenUtils.a(this, true);
    AbstractGifImage.resumeAll();
    QQLiveImage.resumeAll(this);
    ApngImage.resumeAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.MediaPreviewActivity
 * JD-Core Version:    0.7.0.1
 */