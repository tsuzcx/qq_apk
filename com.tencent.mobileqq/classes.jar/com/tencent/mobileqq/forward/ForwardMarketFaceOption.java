package com.tencent.mobileqq.forward;

import adtc;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

public class ForwardMarketFaceOption
  extends ForwardBaseOption
{
  private boolean g;
  
  public ForwardMarketFaceOption(Intent paramIntent)
  {
    super(paramIntent);
    this.g = paramIntent.getBooleanExtra("direct_send_emoji", false);
  }
  
  protected void a()
  {
    if (h()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (i()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (j()) {
      this.jdField_a_of_type_JavaUtilSet.add(b);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (this.g)
    {
      if (paramInt >= 0) {
        this.jdField_a_of_type_AndroidOsBundle.putInt("key_forward_ability_type", paramInt);
      }
      if (paramBundle != null) {
        this.jdField_a_of_type_AndroidOsBundle.putAll(paramBundle);
      }
      m();
      return;
    }
    super.a(paramInt, paramBundle);
  }
  
  protected void a(QQCustomDialog paramQQCustomDialog)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardMarketFaceOption", 2, "updateImageView:setDialogPreviewImage");
    }
    Object localObject = MarketFaceItemBuilder.a;
    if (localObject == null) {
      return;
    }
    localObject = ((PicEmoticonInfo)localObject).a("fromAIO", false);
    ((URLDrawable)localObject).setBounds(ImageUtil.a((Drawable)localObject, 36, 100, this.jdField_a_of_type_Float));
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new adtc(this, paramQQCustomDialog, (URLDrawable)localObject));
  }
  
  protected boolean c()
  {
    Intent localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), new int[] { 2 });
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardMarketFaceOption
 * JD-Core Version:    0.7.0.1
 */