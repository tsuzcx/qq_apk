package com.tencent.mobileqq.microapp.widget.media;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.hardware.Camera;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.mobileqq.microapp.appbrand.a;
import com.tencent.mobileqq.microapp.appbrand.b.b;
import com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview;
import com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

final class e
  implements Runnable
{
  e(d paramd, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    long l4;
    int i;
    try
    {
      long l1 = Runtime.getRuntime().totalMemory() / 1024L;
      long l2 = Runtime.getRuntime().maxMemory() / 1024L;
      long l3 = Runtime.getRuntime().freeMemory() / 1024L;
      l4 = l2 - (l1 - l3);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("remain= ");
        ((StringBuilder)localObject1).append(l4);
        ((StringBuilder)localObject1).append(",totalMemory=");
        ((StringBuilder)localObject1).append(l1);
        ((StringBuilder)localObject1).append(",maxMemory=");
        ((StringBuilder)localObject1).append(l2);
        ((StringBuilder)localObject1).append(",freeMemory");
        ((StringBuilder)localObject1).append(l3);
        QLog.d("MiniAppCamera", 2, ((StringBuilder)localObject1).toString());
      }
      if (l4 >= 51200L) {
        break label401;
      }
      URLDrawable.clearMemoryCache();
      System.gc();
    }
    catch (Exception|OutOfMemoryError localException)
    {
      Object localObject1;
      Object localObject2;
      float f;
      return;
    }
    localObject1 = BitmapManager.a(this.a, 0, this.a.length);
    localObject2 = new Matrix();
    f = 90.0F;
    if (CameraCompatibleList.isFoundProduct(CameraCompatibleList.KEY_PREVIEW_ORIENTATION_270_OF_BACK_MODEL)) {
      f = 270.0F;
    }
    ((Matrix)localObject2).postRotate(f);
    localObject1 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), (Matrix)localObject2, false);
    CameraSurfaceView.a.stopPreview();
    if (i != 0) {
      System.gc();
    }
    localObject2 = new File(b.a().a("jpg"));
    ((File)localObject2).getParentFile().mkdirs();
    localObject1 = MiniAppCamera.a((Bitmap)localObject1, (File)localObject2, this.b.a);
    if (StringUtil.a((String)localObject1))
    {
      localObject1 = c.b(this.b.b, null);
      if (localObject1 == null) {
        break label420;
      }
      localObject1 = ((JSONObject)localObject1).toString();
    }
    for (;;)
    {
      this.b.c.appBrandRuntime.i.evaluateCallbackJs(this.b.d, (String)localObject1);
      return;
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("tempImagePath", b.a().b((String)localObject1));
        this.b.c.appBrandRuntime.i.evaluateCallbackJs(this.b.d, ((JSONObject)localObject2).toString());
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      label401:
      if (l4 < 81920L)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      label420:
      String str = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.media.e
 * JD-Core Version:    0.7.0.1
 */