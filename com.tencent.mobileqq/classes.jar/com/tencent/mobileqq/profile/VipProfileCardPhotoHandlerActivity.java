package com.tencent.mobileqq.profile;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class VipProfileCardPhotoHandlerActivity
  extends BaseActivity
{
  public static boolean a = false;
  private Uri b;
  private boolean c = false;
  private boolean d = false;
  
  private void a()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    localIntent.putExtra("Business_Origin", 101);
    localIntent.putExtra("PhotoConst.COMPRESS_QUALITY", 80);
    PhotoUtils.startPhotoListEdit(localIntent, this, VipProfileCardPhotoHandlerActivity.class.getName(), ProfileCardUtil.b(this), ProfileCardUtil.a(this), ProfileCardUtil.b(this), ProfileCardUtil.a(this), ProfileCardUtil.b());
  }
  
  private void b()
  {
    if (Build.VERSION.SDK_INT > 23)
    {
      if (checkSelfPermission("android.permission.CAMERA") != 0)
      {
        requestPermissions(new VipProfileCardPhotoHandlerActivity.1(this), 1, new String[] { "android.permission.CAMERA" });
        return;
      }
      this.b = ProfileCardUtils.enterSnapshot(this, 5);
      return;
    }
    this.b = ProfileCardUtils.enterSnapshot(this, 5);
  }
  
  protected void a(Uri paramUri)
  {
    paramUri = ImageUtil.b(this, paramUri);
    Intent localIntent = new Intent();
    localIntent.putExtra("Business_Origin", 101);
    localIntent.putExtra("PhotoConst.COMPRESS_QUALITY", 80);
    PhotoUtils.startPhotoEdit(localIntent, this, VipProfileCardPhotoHandlerActivity.class.getName(), ProfileCardUtil.b(this), ProfileCardUtil.a(this), ProfileCardUtil.b(this), ProfileCardUtil.a(this), paramUri, ProfileCardUtil.b());
  }
  
  protected void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (a)
      {
        localIntent = new Intent(this, VipProfileCardDiyActivity.class);
        localIntent.putExtra("extra_from", 3);
        localIntent.putExtra("extra_card_id", 0L);
        localIntent.putExtra("extra_card_path", paramString);
        startActivity(localIntent);
        return;
      }
      Intent localIntent = new Intent(this, VipProfileCardPreviewActivity.class);
      localIntent.putExtra("custom_card_background", paramString);
      startActivity(localIntent);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 5) && (paramInt2 == -1))
    {
      this.d = true;
      a(this.b);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if ((paramBundle != null) && (!TextUtils.isEmpty(paramBundle.getStringExtra("action")))) {
      if (paramBundle.getStringExtra("action").equals("select_photo")) {
        a();
      } else if (paramBundle.getStringExtra("action").equals("take_photo")) {
        b();
      }
    }
    return true;
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    a(paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH"));
    finish();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.c = true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.c)
    {
      if (!this.d)
      {
        finish();
        return;
      }
      this.d = false;
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.c = true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardPhotoHandlerActivity
 * JD-Core Version:    0.7.0.1
 */