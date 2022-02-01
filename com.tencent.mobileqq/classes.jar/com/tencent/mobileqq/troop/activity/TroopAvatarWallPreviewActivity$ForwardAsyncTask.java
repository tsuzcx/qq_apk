package com.tencent.mobileqq.troop.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URL;

public class TroopAvatarWallPreviewActivity$ForwardAsyncTask
  extends AsyncTask<Void, Void, Bundle>
{
  protected URLDrawable a;
  protected String a;
  protected WeakReference<TroopAvatarWallPreviewActivity> a;
  protected boolean a;
  protected String b;
  
  public TroopAvatarWallPreviewActivity$ForwardAsyncTask(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, String paramString1, boolean paramBoolean, URLDrawable paramURLDrawable, String paramString2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramTroopAvatarWallPreviewActivity);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentImageURLDrawable = paramURLDrawable;
    this.b = paramString2;
  }
  
  protected Bundle a(Void... paramVarArgs)
  {
    paramVarArgs = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((paramVarArgs != null) && (paramVarArgs.get() != null))
    {
      if (this.jdField_a_of_type_ComTencentImageURLDrawable == null) {
        return null;
      }
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 1);
      paramVarArgs = new File(AppConstants.SDCARD_IMG_FORWARD_URLDRAWABLE);
      if (!paramVarArgs.exists()) {
        paramVarArgs.mkdirs();
      }
      paramVarArgs = new StringBuilder();
      paramVarArgs.append(AppConstants.SDCARD_IMG_FORWARD_URLDRAWABLE);
      paramVarArgs.append(this.jdField_a_of_type_JavaLangString);
      paramVarArgs.append(Utils.Crc64String(this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString()));
      String str = paramVarArgs.toString();
      paramVarArgs = str;
      if (!new File(str).exists()) {
        try
        {
          paramVarArgs = this.jdField_a_of_type_ComTencentImageURLDrawable.saveTo(str);
        }
        catch (IOException paramVarArgs)
        {
          QLog.e("foward", 2, "IOException", paramVarArgs);
          return null;
        }
      }
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", this.b);
      localBundle.putString("forward_filepath", paramVarArgs);
      localBundle.putString("forward_urldrawable_big_url", this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString());
      localBundle.putString("forward_extra", paramVarArgs);
      if (this.jdField_a_of_type_Boolean)
      {
        localBundle.putString("forward_thumb", paramVarArgs);
        localBundle.putBoolean("key_flag_from_plugin", true);
      }
      return localBundle;
    }
    return null;
  }
  
  protected void a(Bundle paramBundle)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return;
      }
      localObject = (TroopAvatarWallPreviewActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramBundle == null)
      {
        QQToast.a((Context)localObject, HardCodeUtil.a(2131714993), 0).b(((TroopAvatarWallPreviewActivity)localObject).getTitleBarHeight());
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtras(paramBundle);
      ForwardBaseOption.a((Activity)localObject, localIntent, 21);
      TroopAvatarWallPreviewActivity.access$1300((TroopAvatarWallPreviewActivity)localObject, "0X8006A81", "0X8006A95");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.ForwardAsyncTask
 * JD-Core Version:    0.7.0.1
 */