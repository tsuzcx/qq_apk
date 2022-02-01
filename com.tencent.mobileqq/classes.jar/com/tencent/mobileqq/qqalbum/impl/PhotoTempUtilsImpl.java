package com.tencent.mobileqq.qqalbum.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.qqalbum.IPhotoTempUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.util.ProfileCardUtil;
import java.util.ArrayList;

public class PhotoTempUtilsImpl
  implements IPhotoTempUtils
{
  public void sendPhoto(Activity paramActivity, Intent paramIntent, ArrayList<String> paramArrayList, int paramInt, boolean paramBoolean)
  {
    PhotoUtils.sendPhoto(paramActivity, paramIntent, paramArrayList, paramInt, paramBoolean);
  }
  
  public Intent toCropActivity(Activity paramActivity, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    int i = localIntent.getIntExtra("Business_Origin", 0);
    if ((100 != i) && (102 != i) && (103 != i))
    {
      localIntent.setClass(paramActivity, PhotoCropActivity.class);
      return localIntent;
    }
    if (100 == i)
    {
      int j = ProfileCardUtil.b(paramActivity);
      localIntent.putExtra("PhotoConst.CLIP_WIDTH", j);
      localIntent.putExtra("PhotoConst.CLIP_HEIGHT", j);
    }
    else
    {
      localIntent.putExtra("PhotoConst.IS_WITH_PENDANT", false);
    }
    localIntent.setClass(paramActivity, PhotoCropForPortraitActivity.class);
    localIntent.putExtra("PhotoConst.IS_WITH_PENDANT", false);
    localIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getShapeOfBusi(i));
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
    return localIntent;
  }
  
  public Intent toEditPicActivityIntent(Activity paramActivity, Intent paramIntent, String paramString, int paramInt, Bundle paramBundle)
  {
    paramActivity.getIntent().removeExtra("param_initTime");
    ReportController.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
    if (paramIntent == null) {
      paramIntent = ((IAELaunchEditPic)QRoute.api(IAELaunchEditPic.class)).startEditPic(paramActivity, paramString, true, true, true, true, true, paramInt, 142, 5, paramBundle);
    }
    paramIntent.putExtra("key_enable_edit_title_bar", true);
    return paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqalbum.impl.PhotoTempUtilsImpl
 * JD-Core Version:    0.7.0.1
 */