package com.tencent.mobileqq.tribe.fragment;

import aixw;
import aixx;
import aixy;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.qqstory.takevideo.publish.GenerateVideoManifestSegment;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import java.io.File;
import org.json.JSONObject;

public class TribeTakeVideoHelper
{
  public static String a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("options");
      try
      {
        paramBundle = new JSONObject(paramBundle).optString("from", "barindex");
        return paramBundle;
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.e("tribe_publish_TakeVideoHelper", 2, "getTribeFromTag: " + paramBundle);
        }
      }
    }
    return null;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    if (paramInt == -1)
    {
      if (paramIntent != null)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("result", paramIntent.getStringExtra("result"));
        paramActivity.setResult(-1, localIntent);
      }
    }
    else {
      paramActivity.finish();
    }
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, @NonNull ImageView paramImageView, RMVideoStateMgr paramRMVideoStateMgr)
  {
    QLog.d("tribe_publish_TakeVideoHelper", 4, "preview confirm");
    PublishParam localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.a);
    if (localPublishParam == null) {
      return;
    }
    String str = localPublishParam.c;
    Object localObject3;
    Object localObject1;
    if (paramImageView != null)
    {
      localObject3 = null;
      localObject1 = localObject3;
      if (new File(str).exists())
      {
        localObject1 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject1).inPreferredConfig = Bitmap.Config.RGB_565;
        ((BitmapFactory.Options)localObject1).inSampleSize = 2;
      }
    }
    try
    {
      localObject1 = BitmapFactory.decodeFile(str);
      if (localObject1 != null) {
        paramImageView.setImageBitmap((Bitmap)localObject1);
      }
      for (;;)
      {
        paramImageView.setVisibility(0);
        if (localPublishParam.h != 1) {
          break;
        }
        QLog.d("tribe_publish_TakeVideoHelper", 4, "preview confirm takephoto ");
        b(paramActivity, paramIntent, localPublishParam, str);
        return;
        paramImageView.setImageDrawable(new ColorDrawable(-16777216));
      }
      if (!a(paramRMVideoStateMgr))
      {
        QLog.d("tribe_publish_TakeVideoHelper", 4, "manifest file doesn't exist. generate again before publishing.");
        a(paramRMVideoStateMgr, new aixw(paramActivity, paramIntent, localPublishParam, str));
        return;
      }
      QLog.d("tribe_publish_TakeVideoHelper", 4, "manifest file already exists. start publishing.");
      b(paramActivity, paramIntent, localPublishParam, str);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  private static void a(RMVideoStateMgr paramRMVideoStateMgr, aixy paramaixy)
  {
    Stream.of(paramRMVideoStateMgr).map(new ThreadOffFunction(2)).map(new GenerateVideoManifestSegment()).subscribe(new aixx(paramaixy));
  }
  
  private static boolean a(RMVideoStateMgr paramRMVideoStateMgr)
  {
    if (TextUtils.isEmpty(paramRMVideoStateMgr.a))
    {
      QLog.d("tribe_publish_TakeVideoHelper", 4, "check manifest's existance error. directory is null.");
      return false;
    }
    return FileUtils.a(paramRMVideoStateMgr.a + File.separator + "manifest.ini");
  }
  
  private static void b(Activity paramActivity, Intent paramIntent, PublishParam paramPublishParam, String paramString)
  {
    int i = paramIntent.getIntExtra("theme_id", -1);
    String str = paramIntent.getStringExtra("theme_name");
    paramIntent = new Intent();
    paramIntent.putExtra("thumbPath", paramString);
    paramIntent.putExtra("videoPath", paramPublishParam.j);
    paramIntent.putExtra("fakeVid", paramPublishParam.b);
    paramIntent.putExtra("videoDoodleDescription", paramPublishParam.f);
    paramIntent.putExtra("theme_id", i);
    paramIntent.putExtra("theme_name", str);
    paramPublishParam = paramActivity.getIntent().getExtras().getString("options");
    paramIntent.setClass(paramActivity, TroopBarPublishActivity.class);
    paramIntent.putExtra("options", paramPublishParam);
    paramActivity.startActivityForResult(paramIntent, TribeEffectsCameraCaptureFragment.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeTakeVideoHelper
 * JD-Core Version:    0.7.0.1
 */