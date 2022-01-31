package com.tencent.mobileqq.mini.widget;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import com.tencent.mobileqq.minigame.utils.NativeBuffer;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class CanvasView$1$1
  implements Runnable
{
  CanvasView$1$1(CanvasView.1 param1, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.val$currBitmap == null)
    {
      this.this$1.this$0.callbackJsEventFail(this.this$1.val$event, null, this.this$1.val$callBackId);
      return;
    }
    int n = this.this$1.this$0.mpx2pxInt(this.this$1.val$paramObj.optInt("x"));
    int i1 = this.this$1.this$0.mpx2pxInt(this.this$1.val$paramObj.optInt("y"));
    int i2 = this.this$1.val$paramObj.optInt("width");
    int i3 = this.this$1.val$paramObj.optInt("height");
    int i4 = this.this$1.this$0.mpx2pxInt(i2);
    int i5 = this.this$1.this$0.mpx2pxInt(i3);
    label490:
    label510:
    for (;;)
    {
      try
      {
        Object localObject2 = new int[i4 * i5];
        this.val$currBitmap.getPixels((int[])localObject2, 0, i4, n, i1, i4, i5);
        byte[] arrayOfByte = new byte[i4 * i5 * 4];
        n = 0;
        break label490;
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
          NativeBuffer.packNativeBuffer(arrayOfByte, NativeBuffer.TYPE_BUFFER_BASE64, "data", (JSONObject)localObject2, null);
          this.this$1.this$0.callbackJsEventOK(this.this$1.val$event, (JSONObject)localObject2, this.this$1.val$callBackId);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e(CanvasView.access$100(), 2, "getImageData failed: " + Log.getStackTraceString(localThrowable));
        this.this$1.this$0.callbackJsEventFail(this.this$1.val$event, null, this.this$1.val$callBackId);
        return;
      }
      finally
      {
        if ((this.val$currBitmap != null) && (!this.val$currBitmap.isRecycled())) {
          this.val$currBitmap.recycle();
        }
      }
      for (;;)
      {
        if (n >= i5) {
          break label510;
        }
        i1 = 0;
        break;
        n += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.CanvasView.1.1
 * JD-Core Version:    0.7.0.1
 */