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
  protected WeakReference<TroopAvatarWallPreviewActivity> a;
  protected String b;
  protected boolean c;
  protected URLDrawable d;
  protected String e;
  
  public TroopAvatarWallPreviewActivity$ForwardAsyncTask(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, String paramString1, boolean paramBoolean, URLDrawable paramURLDrawable, String paramString2)
  {
    this.a = new WeakReference(paramTroopAvatarWallPreviewActivity);
    this.b = paramString1;
    this.c = paramBoolean;
    this.d = paramURLDrawable;
    this.e = paramString2;
  }
  
  protected Bundle a(Void... paramVarArgs)
  {
    paramVarArgs = this.a;
    if ((paramVarArgs != null) && (paramVarArgs.get() != null))
    {
      if (this.d == null) {
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
      paramVarArgs.append(this.b);
      paramVarArgs.append(Utils.Crc64String(this.d.getURL().toString()));
      String str = paramVarArgs.toString();
      paramVarArgs = str;
      if (!new File(str).exists()) {
        try
        {
          paramVarArgs = this.d.saveTo(str);
        }
        catch (IOException paramVarArgs)
        {
          QLog.e("foward", 2, "IOException", paramVarArgs);
          return null;
        }
      }
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", this.e);
      localBundle.putString("forward_filepath", paramVarArgs);
      localBundle.putString("forward_urldrawable_big_url", this.d.getURL().toString());
      localBundle.putString("forward_extra", paramVarArgs);
      if (this.c)
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
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return;
      }
      localObject = (TroopAvatarWallPreviewActivity)this.a.get();
      if (paramBundle == null)
      {
        QQToast.makeText((Context)localObject, HardCodeUtil.a(2131912487), 0).show(((TroopAvatarWallPreviewActivity)localObject).getTitleBarHeight());
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtras(paramBundle);
      ForwardBaseOption.a((Activity)localObject, localIntent, 21);
      TroopAvatarWallPreviewActivity.access$1500((TroopAvatarWallPreviewActivity)localObject, "0X8006A81", "0X8006A95");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.ForwardAsyncTask
 * JD-Core Version:    0.7.0.1
 */