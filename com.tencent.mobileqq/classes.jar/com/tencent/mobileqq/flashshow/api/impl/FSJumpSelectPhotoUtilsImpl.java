package com.tencent.mobileqq.flashshow.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.aelight.camera.api.IAEEditorManagerForQzone;
import com.tencent.mobileqq.flashshow.api.IFSJumpSelectPhotoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.api.IPublishLauncher;

public class FSJumpSelectPhotoUtilsImpl
  implements IFSJumpSelectPhotoUtils
{
  private static final String TAG = "FSJumpSelectPhotoUtils";
  
  public void jumpPublishMood(Context paramContext, Intent paramIntent)
  {
    ((IPublishLauncher)QRoute.api(IPublishLauncher.class)).launchPublishPage(paramContext, paramIntent);
  }
  
  public void jumpTakePhoto(Context paramContext, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("BUNDLE_KEY_FS_CAN_ONLY_EDIT_VIDEO", true);
    ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).launchAEMutiCameraFromFS(paramContext, localIntent.getExtras());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.impl.FSJumpSelectPhotoUtilsImpl
 * JD-Core Version:    0.7.0.1
 */