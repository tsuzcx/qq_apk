package com.tencent.mobileqq.troop.activity;

import actj;
import ajsd;
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
import azds;
import azdt;
import azdu;
import azdv;
import azdw;
import azdx;
import azdy;
import azdz;
import azea;
import baoh;
import bbdj;
import bbgu;
import bcql;
import bfpc;
import bfpp;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.QQLiveImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.Gallery;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import lze;

public class MediaPreviewActivity
  extends BaseActivity
{
  static Object jdField_a_of_type_JavaLangObject = new Object();
  static boolean jdField_a_of_type_Boolean;
  public int a;
  protected View a;
  protected FrameLayout a;
  public TextView a;
  public baoh a;
  protected Gallery a;
  protected Runnable a;
  protected ArrayList<MediaPreviewInfo> a;
  public int b;
  public boolean b;
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentWidgetGallery == null)
    {
      bcql.a(this, getString(2131693235), 0).a();
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedView();
    if (localObject == null)
    {
      bcql.a(this, getString(2131693235), 0).a();
      return;
    }
    localObject = ((ImageView)((View)localObject).findViewById(2131367776)).getDrawable();
    if ((localObject == null) || (!(localObject instanceof URLDrawable)))
    {
      bcql.a(this, getString(2131693235), 0).a();
      return;
    }
    localObject = (URLDrawable)localObject;
    if (((URLDrawable)localObject).getStatus() != 1)
    {
      bcql.a(this, getString(2131693235), 0).a();
      return;
    }
    bfpc localbfpc = (bfpc)bfpp.a(this, null);
    localbfpc.a(2131693384, 1);
    localbfpc.a(2131693394, 1);
    localbfpc.c(2131690596);
    localbfpc.a(new azdx(this, localbfpc, (URLDrawable)localObject));
    localbfpc.show();
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
    localAnimationSet.setAnimationListener(new azdt(this));
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new MediaPreviewActivity.11(this);
    }
    this.jdField_a_of_type_ComTencentWidgetGallery.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
    this.jdField_a_of_type_ComTencentWidgetGallery.startAnimation(localAnimationSet);
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
  
  protected void a(Bundle paramBundle)
  {
    Intent localIntent = actj.a(new Intent(this, SplashActivity.class), null);
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
      new File(ajsd.bc).mkdirs();
      str = ajsd.bc + Utils.Crc64String(paramURLDrawable.getURL().toString());
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
          bcql.a(this, getString(2131695190), 0).a();
          return;
        }
      }
    }
    bbdj.a(this, 230).setTitle(getString(2131718848)).setMessage(getString(2131695183)).setPositiveButton(getString(2131718724), new azdz(this, paramURLDrawable, str)).setNegativeButton(getString(2131694648), new azdy(this)).show();
  }
  
  public void a(URLDrawable paramURLDrawable, String paramString)
  {
    new azdw(this, paramURLDrawable, paramString).execute(new Void[0]);
  }
  
  public void b(URLDrawable paramURLDrawable, String paramString)
  {
    new azea(this, paramURLDrawable, paramString).execute(new Void[0]);
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
    setContentView(2131559139);
    ??? = getIntent().getExtras();
    this.jdField_a_of_type_Int = ???.getInt("index", -1);
    this.jdField_a_of_type_JavaUtilArrayList = ???.getParcelableArrayList("mediaInfoList");
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131375496));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)findViewById(2131366897));
    this.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377032));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131362998);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
    this.jdField_a_of_type_Baoh = new baoh(this, this.jdField_a_of_type_ComTencentWidgetGallery);
    this.jdField_a_of_type_Baoh.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_Baoh);
    this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131297009));
    this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(new azds(this));
    this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(new azdu(this));
    this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemLongClickListener(new azdv(this));
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
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Baoh != null) {
      this.jdField_a_of_type_Baoh.a();
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
    lze.a(this, false);
    AbstractGifImage.pauseAll();
    QQLiveImage.pauseAll(this);
    ApngImage.pauseAll();
  }
  
  public void onResume()
  {
    super.onResume();
    lze.a(this, true);
    AbstractGifImage.resumeAll();
    QQLiveImage.resumeAll(this);
    ApngImage.resumeAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.MediaPreviewActivity
 * JD-Core Version:    0.7.0.1
 */