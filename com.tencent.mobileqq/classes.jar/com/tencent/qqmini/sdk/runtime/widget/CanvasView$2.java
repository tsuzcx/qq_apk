package com.tencent.qqmini.sdk.runtime.widget;

import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.runtime.core.page.NativeViewContainer;
import org.json.JSONObject;

class CanvasView$2
  implements Runnable
{
  CanvasView$2(CanvasView paramCanvasView, boolean paramBoolean, NativeViewContainer paramNativeViewContainer, String paramString1, int paramInt, JSONObject paramJSONObject, String paramString2) {}
  
  public void run()
  {
    Bitmap localBitmap = CanvasView.a(this.this$0, this.this$0, this.jdField_a_of_type_Boolean);
    ThreadManager.a().post(new CanvasView.2.1(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.widget.CanvasView.2
 * JD-Core Version:    0.7.0.1
 */