package com.tencent.mobileqq.troop.activity;

import aifz;
import aiga;
import aigb;
import aigc;
import aigd;
import aige;
import aigf;
import aigg;
import aigh;
import aigi;
import aigj;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
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
  static boolean jdField_a_of_type_Boolean;
  public int a;
  protected View a;
  protected FrameLayout a;
  public TextView a;
  public MediaPreviewAdapter a;
  protected Gallery a;
  protected Runnable a;
  public ArrayList a;
  public int b;
  public boolean b;
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentWidgetGallery == null)
    {
      QQToast.a(this, getString(2131435531), 0).a();
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedView();
    if (localObject == null)
    {
      QQToast.a(this, getString(2131435531), 0).a();
      return;
    }
    localObject = ((ImageView)((View)localObject).findViewById(2131361846)).getDrawable();
    if ((localObject == null) || (!(localObject instanceof URLDrawable)))
    {
      QQToast.a(this, getString(2131435531), 0).a();
      return;
    }
    localObject = (URLDrawable)localObject;
    if (((URLDrawable)localObject).getStatus() != 1)
    {
      QQToast.a(this, getString(2131435531), 0).a();
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(2131435854, 1);
    localActionSheet.a(2131435860, 1);
    localActionSheet.c(2131432998);
    localActionSheet.a(new aigg(this, localActionSheet, (URLDrawable)localObject));
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
    localAnimationSet.setAnimationListener(new aiga(this));
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new aigb(this);
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
  
  public void a(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable.getStatus() != 1) {}
    String str;
    for (;;)
    {
      return;
      new File(AppConstants.aP).mkdirs();
      str = AppConstants.aP + Utils.Crc64String(paramURLDrawable.getURL().toString());
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
          QQToast.a(this, getString(2131434566), 0).a();
          return;
        }
      }
    }
    DialogUtil.a(this, 230).setTitle(getString(2131434569)).setMessage(getString(2131434571)).setPositiveButton(getString(2131434570), new aigi(this, paramURLDrawable, str)).setNegativeButton(getString(2131432995), new aigh(this)).show();
  }
  
  public void a(URLDrawable paramURLDrawable, String paramString)
  {
    new aigf(this, paramURLDrawable, paramString).execute(new Void[0]);
  }
  
  public void b(URLDrawable paramURLDrawable, String paramString)
  {
    new aigj(this, paramURLDrawable, paramString).execute(new Void[0]);
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
      if ((this.app == null) || (TextUtils.isEmpty(this.app.getAccount())))
      {
        finish();
        return false;
      }
    }
    setContentView(2130969030);
    ??? = getIntent().getExtras();
    this.jdField_a_of_type_Int = ???.getInt("index", -1);
    this.jdField_a_of_type_JavaUtilArrayList = ???.getParcelableArrayList("mediaInfoList");
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131364773));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)findViewById(2131364774));
    this.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363614));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131362727);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaPreviewAdapter = new MediaPreviewAdapter(this, this.jdField_a_of_type_ComTencentWidgetGallery);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaPreviewAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaPreviewAdapter);
    this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131558524));
    this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(new aifz(this));
    this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(new aigc(this));
    this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemLongClickListener(new aigd(this));
    ThreadManager.post(new aige(this), 8, null, true);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.jdField_a_of_type_ComTencentWidgetGallery != null) && (this.jdField_a_of_type_JavaLangRunnable != null)) {
      this.jdField_a_of_type_ComTencentWidgetGallery.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
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
    if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentWidgetGallery.a(false))) {
      a();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaPreviewAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaPreviewAdapter.a();
    }
    QQLiveImage.releaseAll();
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
    QQLiveImage.pauseAll();
    ApngImage.pauseAll();
  }
  
  protected void onResume()
  {
    super.onResume();
    SmallScreenUtils.a(this, true);
    AbstractGifImage.resumeAll();
    QQLiveImage.resumeAll();
    ApngImage.resumeAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.MediaPreviewActivity
 * JD-Core Version:    0.7.0.1
 */