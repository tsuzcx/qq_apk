package com.tencent.qqmini.sdk.core.plugins;

import android.content.Intent;
import bgnk;
import bgnl;
import bgok;
import java.io.File;
import java.util.ArrayList;

class ImageJsPlugin$3
  implements bgnl
{
  ImageJsPlugin$3(ImageJsPlugin paramImageJsPlugin, bgok parambgok, File paramFile) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 4) {
      return false;
    }
    if (paramInt2 != -1)
    {
      if (paramInt2 == 0) {
        this.val$req.c();
      }
      this.val$imageFile.deleteOnExit();
      bgnk.a().b(this);
      return true;
    }
    paramIntent = new ArrayList();
    paramIntent.add(this.val$imageFile.getAbsolutePath());
    ImageJsPlugin.access$100(this.this$0, paramIntent, this.val$req);
    bgnk.a().b(this);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ImageJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */