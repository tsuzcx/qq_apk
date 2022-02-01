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
  static boolean a = false;
  static Object b = new Object();
  protected FrameLayout c;
  protected Gallery d;
  protected MediaPreviewAdapter e;
  protected TextView f;
  protected View g;
  protected ArrayList<MediaPreviewInfo> h = null;
  protected int i;
  protected int j = 0;
  protected boolean k = false;
  protected Runnable l = null;
  
  private void b()
  {
    Object localObject = this.d;
    if (localObject == null)
    {
      QQToast.makeText(this, getString(2131890214), 0).show();
      return;
    }
    localObject = ((Gallery)localObject).getSelectedView();
    if (localObject == null)
    {
      QQToast.makeText(this, getString(2131890214), 0).show();
      return;
    }
    localObject = ((ImageView)((View)localObject).findViewById(2131435357)).getDrawable();
    if ((localObject != null) && ((localObject instanceof URLDrawable)))
    {
      localObject = (URLDrawable)localObject;
      if (((URLDrawable)localObject).getStatus() != 1)
      {
        QQToast.makeText(this, getString(2131890214), 0).show();
        return;
      }
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this, null);
      localActionSheet.addButton(2131890804, 1);
      localActionSheet.addButton(2131890810, 1);
      localActionSheet.addCancelButton(2131887648);
      localActionSheet.setOnButtonClickListener(new MediaPreviewActivity.6(this, localActionSheet, (URLDrawable)localObject));
      localActionSheet.show();
      return;
    }
    QQToast.makeText(this, getString(2131890214), 0).show();
  }
  
  public void a()
  {
    this.f.setVisibility(4);
    this.k = true;
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
    if (this.l == null) {
      this.l = new MediaPreviewActivity.11(this);
    }
    this.d.postDelayed(this.l, 500L);
    this.d.startAnimation(localAnimationSet);
    this.g.startAnimation(localAlphaAnimation);
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
    QQToast.makeText(this, getString(2131892637), 0).show();
    return;
    DialogUtil.a(this, 230).setTitle(getString(2131915885)).setMessage(getString(2131892633)).setPositiveButton(getString(2131915687), new MediaPreviewActivity.8(this, paramURLDrawable, (String)localObject)).setNegativeButton(getString(2131892140), new MediaPreviewActivity.7(this)).show();
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
    synchronized (b)
    {
      if (a)
      {
        super.finish();
        return false;
      }
      a = true;
      if ((this.app != null) && (!TextUtils.isEmpty(this.app.getAccount())))
      {
        setContentView(2131625166);
        ??? = getIntent().getExtras();
        this.i = ???.getInt("index", -1);
        this.h = ???.getParcelableArrayList("mediaInfoList");
        ??? = this.h;
        if (??? != null) {
          this.j = ???.size();
        }
        this.c = ((FrameLayout)findViewById(2131445141));
        this.c.setVisibility(0);
        this.d = ((Gallery)findViewById(2131433934));
        this.d.setVisibility(0);
        this.f = ((TextView)findViewById(2131447062));
        this.f.setVisibility(0);
        this.g = findViewById(2131429234);
        this.g.setBackgroundColor(-16777216);
        this.e = new MediaPreviewAdapter(this, this.d);
        this.e.a(this.h);
        this.d.setAdapter(this.e);
        this.d.setSpacing(getResources().getDimensionPixelSize(2131297535));
        this.d.setSelection(this.i);
        this.d.setOnItemClickListener(new MediaPreviewActivity.1(this));
        this.d.setOnItemSelectedListener(new MediaPreviewActivity.2(this));
        this.d.setOnItemLongClickListener(new MediaPreviewActivity.3(this));
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
    Gallery localGallery = this.d;
    if (localGallery != null)
    {
      Runnable localRunnable = this.l;
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
    if ((!this.k) && (!this.d.resetScale(false))) {
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
    ??? = this.e;
    if (??? != null) {
      ((MediaPreviewAdapter)???).a();
    }
    QQLiveImage.releaseAll(this);
    synchronized (b)
    {
      a = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.MediaPreviewActivity
 * JD-Core Version:    0.7.0.1
 */