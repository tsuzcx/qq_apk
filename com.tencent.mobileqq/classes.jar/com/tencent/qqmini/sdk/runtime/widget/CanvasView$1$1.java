package com.tencent.qqmini.sdk.runtime.widget;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import bgpi;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

class CanvasView$1$1
  implements Runnable
{
  CanvasView$1$1(CanvasView.1 param1, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$1.this$0.c(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$1.jdField_a_of_type_JavaLangString, null, this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$1.jdField_a_of_type_Int);
      return;
    }
    int n = this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$1.this$0.b(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$1.jdField_a_of_type_OrgJsonJSONObject.optInt("x"));
    int i1 = this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$1.this$0.b(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$1.jdField_a_of_type_OrgJsonJSONObject.optInt("y"));
    int i2 = this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$1.jdField_a_of_type_OrgJsonJSONObject.optInt("width");
    int i3 = this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$1.jdField_a_of_type_OrgJsonJSONObject.optInt("height");
    int i4 = this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$1.this$0.b(i2);
    int i5 = this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$1.this$0.b(i3);
    label488:
    label508:
    for (;;)
    {
      try
      {
        Object localObject2 = new int[i4 * i5];
        this.jdField_a_of_type_AndroidGraphicsBitmap.getPixels((int[])localObject2, 0, i4, n, i1, i4, i5);
        byte[] arrayOfByte = new byte[i4 * i5 * 4];
        n = 0;
        break label488;
        if (i1 < i4)
        {
          int i7 = i4 * n + i1;
          int i6 = i7 * 4;
          i7 = localObject2[i7];
          int i = (byte)Color.alpha(i7);
          int j = (byte)Color.red(i7);
          int k = (byte)Color.green(i7);
          int m = (byte)Color.blue(i7);
          arrayOfByte[i6] = j;
          arrayOfByte[(i6 + 1)] = k;
          arrayOfByte[(i6 + 2)] = m;
          arrayOfByte[(i6 + 3)] = i;
          i1 += 1;
          continue;
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("width", i2);
          ((JSONObject)localObject2).put("height", i3);
          bgpi.a(null, arrayOfByte, bgpi.b, "data", (JSONObject)localObject2);
          this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$1.this$0.b(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$1.jdField_a_of_type_JavaLangString, (JSONObject)localObject2, this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$1.jdField_a_of_type_Int);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("CanvasView", "getImageData failed: " + Log.getStackTraceString(localThrowable));
        this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$1.this$0.c(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$1.jdField_a_of_type_JavaLangString, null, this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$1.jdField_a_of_type_Int);
        return;
      }
      finally
      {
        if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
          this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        }
      }
      for (;;)
      {
        if (n >= i5) {
          break label508;
        }
        i1 = 0;
        break;
        n += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.widget.CanvasView.1.1
 * JD-Core Version:    0.7.0.1
 */