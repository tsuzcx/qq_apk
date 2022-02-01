package com.tencent.mobileqq.openapi;

import android.view.View;
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.transfile.FileMsg;

class OpenApiManager$4
  implements Callback
{
  OpenApiManager$4(OpenApiManager paramOpenApiManager) {}
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    this.a.onFileTransStatusChanged(paramFileMsg, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.openapi.OpenApiManager.4
 * JD-Core Version:    0.7.0.1
 */