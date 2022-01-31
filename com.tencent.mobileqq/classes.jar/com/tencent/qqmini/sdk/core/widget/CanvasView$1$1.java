package com.tencent.qqmini.sdk.core.widget;

import android.graphics.Bitmap;
import android.util.Base64;
import android.util.Log;
import bdcy;
import bdii;
import bdnw;
import org.json.JSONObject;

class CanvasView$1$1
  implements Runnable
{
  CanvasView$1$1(CanvasView.1 param1, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$1.jdField_a_of_type_Bdii.a(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$1.jdField_a_of_type_JavaLangString, null, this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$1.jdField_a_of_type_Int);
      return;
    }
    int i = (int)CanvasView.a(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$1.this$0);
    int j = this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$1.jdField_a_of_type_OrgJsonJSONObject.optInt("x");
    int n = (int)CanvasView.a(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$1.this$0);
    int i1 = this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$1.jdField_a_of_type_OrgJsonJSONObject.optInt("y");
    int k = this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$1.jdField_a_of_type_OrgJsonJSONObject.optInt("width");
    int m = this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$1.jdField_a_of_type_OrgJsonJSONObject.optInt("height");
    Object localObject2 = new int[k * m];
    this.jdField_a_of_type_AndroidGraphicsBitmap.getPixels((int[])localObject2, 0, k, i * j, n * i1, k, m);
    short[] arrayOfShort = new short[k * m * 4];
    i = 0;
    for (;;)
    {
      for (;;)
      {
        if (i < m)
        {
          j = 0;
          while (j < k)
          {
            n = localObject2[(k * i + j)];
            arrayOfShort[(k * i + j)] = ((short)((n & 0xFF0000) >> 16));
            arrayOfShort[(k * i + j + 1)] = ((short)((0xFF00 & n) >> 8));
            arrayOfShort[(k * i + j + 2)] = ((short)(n & 0xFF));
            arrayOfShort[(k * i + j + 3)] = ((short)((n & 0xFF0000) >> 24));
            j += 1;
          }
        }
        try
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("width", k);
          ((JSONObject)localObject2).put("height", m);
          ((JSONObject)localObject2).put("data", Base64.encode(CanvasView.a(arrayOfShort), 0));
          this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$1.jdField_a_of_type_Bdcy.a(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$1.jdField_a_of_type_Int, ((JSONObject)localObject2).toString());
          return;
        }
        catch (Exception localException)
        {
          bdnw.d(CanvasView.a(), "getImageData failed: " + Log.getStackTraceString(localException));
          this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$1.jdField_a_of_type_Bdii.a(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$1.jdField_a_of_type_JavaLangString, null, this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$1.jdField_a_of_type_Int);
          return;
        }
        finally
        {
          if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
            this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
          }
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.CanvasView.1.1
 * JD-Core Version:    0.7.0.1
 */