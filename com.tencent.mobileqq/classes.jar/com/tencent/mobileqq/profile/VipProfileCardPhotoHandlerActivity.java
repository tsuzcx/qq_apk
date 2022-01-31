package com.tencent.mobileqq.profile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ImageUtil;

public class VipProfileCardPhotoHandlerActivity
  extends BaseActivity
{
  public static boolean a;
  private Uri a;
  private boolean b;
  private boolean c;
  
  private void a()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    localIntent.putExtra("Business_Origin", 101);
    localIntent.putExtra("PhotoConst.COMPRESS_QUALITY", 80);
    PhotoUtils.a(localIntent, this, VipProfileCardPhotoHandlerActivity.class.getName(), ProfileCardUtil.b(this), ProfileCardUtil.a(this), ProfileCardUtil.b(this), ProfileCardUtil.a(this), ProfileCardUtil.c());
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidNetUri = ProfileActivity.a(this, 5);
  }
  
  protected void a(Uri paramUri)
  {
    paramUri = ImageUtil.b(this, paramUri);
    Intent localIntent = new Intent();
    localIntent.putExtra("Business_Origin", 101);
    localIntent.putExtra("PhotoConst.COMPRESS_QUALITY", 80);
    PhotoUtils.a(localIntent, this, VipProfileCardPhotoHandlerActivity.class.getName(), ProfileCardUtil.b(this), ProfileCardUtil.a(this), ProfileCardUtil.b(this), ProfileCardUtil.a(this), paramUri, ProfileCardUtil.c());
  }
  
  protected void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (jdField_a_of_type_Boolean)
      {
        localIntent = new Intent(this, VipProfileCardDiyActivity.class);
        localIntent.putExtra("extra_from", 3);
        localIntent.putExtra("extra_card_id", 0L);
        localIntent.putExtra("extra_card_path", paramString);
        startActivity(localIntent);
      }
    }
    else {
      return;
    }
    Intent localIntent = new Intent(this, VipProfileCardPreviewActivity.class);
    localIntent.putExtra("custom_card_background", paramString);
    startActivity(localIntent);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 5) && (paramInt2 == -1))
    {
      this.c = true;
      a(this.jdField_a_of_type_AndroidNetUri);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if ((paramBundle != null) && (!TextUtils.isEmpty(paramBundle.getStringExtra("action"))))
    {
      if (!paramBundle.getStringExtra("action").equals("select_photo")) {
        break label47;
      }
      a();
    }
    for (;;)
    {
      return true;
      label47:
      if (paramBundle.getStringExtra("action").equals("take_photo")) {
        b();
      }
    }
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
    this.b = true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.b)
    {
      if (!this.c) {
        finish();
      }
    }
    else {
      return;
    }
    this.c = false;
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardPhotoHandlerActivity
 * JD-Core Version:    0.7.0.1
 */