package com.tencent.qqmini.sdk.runtime.widget.camera;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Log;
import bgnt;
import bhit;
import bhkh;
import bhkk;
import com.tencent.qqmini.sdk.log.QMLog;
import java.io.File;

public class MiniAppCamera$2$1
  implements Runnable
{
  public MiniAppCamera$2$1(bhkh parambhkh, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    Log.i("MiniAppCamera", "run: onPictureTaken");
    long l4;
    try
    {
      long l1 = Runtime.getRuntime().totalMemory() / 1024L;
      long l2 = Runtime.getRuntime().maxMemory() / 1024L;
      long l3 = Runtime.getRuntime().freeMemory() / 1024L;
      l4 = l2 - (l1 - l3);
      if (QMLog.isColorLevel()) {
        QMLog.d("MiniAppCamera", "remain= " + l4 + ",totalMemory=" + l1 + ",maxMemory=" + l2 + ",freeMemory" + l3);
      }
      if (l4 >= 51200L) {
        break label639;
      }
      System.gc();
    }
    catch (Exception localException)
    {
      Object localObject2;
      int i;
      int j;
      Object localObject3;
      Log.e("MiniAppCamera", "run: nativeTakePhoto ", localException);
      this.jdField_a_of_type_Bhkh.jdField_a_of_type_Bhkk.a(null);
      return;
    }
    localObject2 = BitmapFactory.decodeByteArray(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte.length);
    i = ((Bitmap)localObject2).getWidth();
    j = ((Bitmap)localObject2).getHeight();
    localObject3 = new Matrix();
    float f1;
    float f5;
    float f2;
    float f4;
    if (bhit.a(bhit.g))
    {
      if (!this.jdField_a_of_type_Bhkh.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCameraMiniAppCamera.jdField_a_of_type_Boolean) {
        break label677;
      }
      f1 = 270.0F;
      break label651;
      Log.i("MiniAppCamera", "run: " + this.jdField_a_of_type_Bhkh.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCameraMiniAppCamera.getWidth() + ":" + this.jdField_a_of_type_Bhkh.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCameraMiniAppCamera.getHeight());
      if (!this.jdField_a_of_type_Bhkh.jdField_a_of_type_Boolean) {
        break label694;
      }
      f5 = Math.max(this.jdField_a_of_type_Bhkh.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCameraMiniAppCamera.getHeight() / i, this.jdField_a_of_type_Bhkh.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCameraMiniAppCamera.getWidth() / j);
      f2 = i;
      f1 = j;
      f2 = (this.jdField_a_of_type_Bhkh.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCameraMiniAppCamera.getHeight() - f2 * f5) / f5;
      f4 = (this.jdField_a_of_type_Bhkh.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCameraMiniAppCamera.getWidth() - f1 * f5) / f5;
      f1 = f2;
      if (f2 <= 0.0F) {
        break label656;
      }
      f1 = 0.0F;
      break label656;
    }
    for (;;)
    {
      label355:
      Object localObject1;
      ((Matrix)localObject3).postRotate(localObject1);
      ((Matrix)localObject3).postScale(f2, f2);
      if (!this.jdField_a_of_type_Bhkh.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCameraMiniAppCamera.jdField_a_of_type_Boolean) {
        ((Matrix)localObject3).postScale(-1.0F, 1.0F);
      }
      localObject3 = Bitmap.createBitmap((Bitmap)localObject2, (int)(-f1 / 2.0F), (int)(-f4 / 2.0F), (int)(f1 + ((Bitmap)localObject2).getWidth()), (int)(f4 + ((Bitmap)localObject2).getHeight()), (Matrix)localObject3, true);
      if ("normal".equals(this.jdField_a_of_type_Bhkh.jdField_a_of_type_JavaLangString)) {
        f1 = 0.8F;
      }
      for (;;)
      {
        localObject2 = localObject3;
        if (f1 < 1.0F)
        {
          localObject2 = new Matrix();
          ((Matrix)localObject2).postScale(f1, f1);
          localObject2 = Bitmap.createBitmap((Bitmap)localObject3, 0, 0, ((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight(), (Matrix)localObject2, true);
        }
        localObject3 = new File(bgnt.a().b("jpg"));
        ((File)localObject3).getParentFile().mkdirs();
        localObject2 = MiniAppCamera.a((Bitmap)localObject2, (File)localObject3, this.jdField_a_of_type_Bhkh.jdField_a_of_type_JavaLangString);
        Log.i("MiniAppCamera", "run: return");
        this.jdField_a_of_type_Bhkh.jdField_a_of_type_Bhkk.a((String)localObject2);
        return;
        if (!this.jdField_a_of_type_Bhkh.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCameraMiniAppCamera.jdField_a_of_type_Boolean) {
          break label688;
        }
        f1 = 90.0F;
        break;
        boolean bool = "low".equals(this.jdField_a_of_type_Bhkh.jdField_a_of_type_JavaLangString);
        if (bool) {
          f1 = 0.6F;
        } else {
          f1 = 1.0F;
        }
      }
      label639:
      if (l4 >= 81920L) {
        break;
      }
      break;
      label651:
      float f3;
      for (;;)
      {
        f3 = f1;
        break;
        label656:
        f2 = f4;
        if (f4 > 0.0F) {
          f2 = 0.0F;
        }
        f4 = f2;
        f2 = f5;
        break label355;
        label677:
        f1 = 90.0F;
      }
      for (;;)
      {
        f3 = f1;
        break;
        label688:
        f1 = 270.0F;
      }
      label694:
      f4 = 0.0F;
      f1 = 0.0F;
      f2 = 1.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.widget.camera.MiniAppCamera.2.1
 * JD-Core Version:    0.7.0.1
 */