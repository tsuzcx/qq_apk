package com.tencent.mobileqq.microapp.widget.media;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.hardware.Camera;
import awii;
import azvq;
import baip;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview;
import com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.microapp.appbrand.utils.b;
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
    for (;;)
    {
      long l4;
      try
      {
        long l1 = Runtime.getRuntime().totalMemory() / 1024L;
        long l2 = Runtime.getRuntime().maxMemory() / 1024L;
        long l3 = Runtime.getRuntime().freeMemory() / 1024L;
        l4 = l2 - (l1 - l3);
        if (QLog.isColorLevel()) {
          QLog.d("MiniAppCamera", 2, "remain= " + l4 + ",totalMemory=" + l1 + ",maxMemory=" + l2 + ",freeMemory" + l3);
        }
        if (l4 >= 51200L) {
          break label388;
        }
        URLDrawable.clearMemoryCache();
        System.gc();
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject2;
        float f;
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        return;
      }
      localObject1 = azvq.a(this.a, 0, this.a.length);
      localObject2 = new Matrix();
      f = 90.0F;
      if (awii.d(awii.g)) {
        f = 90.0F + 180.0F;
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
      if (baip.a((String)localObject1))
      {
        localObject1 = com.tencent.mobileqq.microapp.b.a.b(this.b.b, null);
        if (localObject1 != null)
        {
          localObject1 = ((JSONObject)localObject1).toString();
          this.b.c.appBrandRuntime.i.evaluateCallbackJs(this.b.d, (String)localObject1);
          return;
        }
        localObject1 = "";
        continue;
      }
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("tempImagePath", b.a().c((String)localObject1));
        this.b.c.appBrandRuntime.i.evaluateCallbackJs(this.b.d, ((JSONObject)localObject2).toString());
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      label388:
      while (l4 >= 81920L)
      {
        i = 0;
        break;
      }
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.media.e
 * JD-Core Version:    0.7.0.1
 */