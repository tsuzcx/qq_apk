package com.tencent.qqmini.sdk.plugins;

import android.content.Intent;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import java.io.File;
import java.util.ArrayList;

class ImageJsPlugin$4
  implements IActivityResultListener
{
  ImageJsPlugin$4(ImageJsPlugin paramImageJsPlugin, RequestEvent paramRequestEvent, File paramFile) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 4) {
      return false;
    }
    if (paramInt2 != -1)
    {
      if (paramInt2 == 0) {
        this.val$req.cancel();
      }
      this.val$imageFile.deleteOnExit();
      ActivityResultManager.g().removeActivityResultListener(this);
      return true;
    }
    paramIntent = new ArrayList();
    paramIntent.add(this.val$imageFile.getAbsolutePath());
    ImageJsPlugin.access$100(this.this$0, paramIntent, this.val$req);
    ActivityResultManager.g().removeActivityResultListener(this);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ImageJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */