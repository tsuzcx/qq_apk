package com.tencent.viola.ui.component.image;

import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Base64;
import com.tencent.viola.commons.ImageAdapterHolder;
import com.tencent.viola.utils.ViolaLogUtils;

class VImage2$2
  implements Runnable
{
  VImage2$2(VImage2 paramVImage2, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject2 = Base64.decode(this.val$url.split(",")[1], 0);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeByteArray((byte[])localObject2, 0, localObject2.length, localOptions);
    boolean bool = this.val$isNeedRealImageSize;
    Object localObject1 = null;
    Bundle localBundle;
    if (bool)
    {
      localBundle = new Bundle();
      localBundle.putInt(ImageAdapterHolder.BUNDLE_WIDTH, localOptions.outWidth);
      localBundle.putInt(ImageAdapterHolder.BUNDLE_HEIGHT, localOptions.outHeight);
    }
    else
    {
      localBundle = null;
    }
    try
    {
      if (Build.VERSION.SDK_INT > 19) {
        localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
      } else {
        localOptions.inPreferredConfig = Bitmap.Config.ARGB_4444;
      }
      localOptions.inJustDecodeBounds = false;
      localObject2 = BitmapFactory.decodeByteArray((byte[])localObject2, 0, localObject2.length, localOptions);
      localObject1 = localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label144:
      break label144;
    }
    ViolaLogUtils.d("VImage2", "setImage decode base64 error");
    VImage2.access$100(this.this$0, localObject1, this.val$url, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.component.image.VImage2.2
 * JD-Core Version:    0.7.0.1
 */