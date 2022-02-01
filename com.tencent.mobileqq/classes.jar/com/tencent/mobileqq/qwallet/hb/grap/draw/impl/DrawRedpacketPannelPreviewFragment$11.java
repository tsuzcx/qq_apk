package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class DrawRedpacketPannelPreviewFragment$11
  implements Runnable
{
  DrawRedpacketPannelPreviewFragment$11(DrawRedpacketPannelPreviewFragment paramDrawRedpacketPannelPreviewFragment, String paramString1, int paramInt1, String paramString2, int paramInt2) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i(DrawRedpacketPannelPreviewFragment.a, 2, "---sendImageToAio---");
      }
      Object localObject1 = DrawRedpacketPannelPreviewFragment.w(this.this$0);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append(System.currentTimeMillis());
      ((StringBuilder)localObject2).append(".png");
      localObject1 = DrawRedpacketPannelPreviewFragment.a((Bitmap)localObject1, ((StringBuilder)localObject2).toString(), DrawRedpacketPannelPreviewFragment.x(this.this$0));
      localObject2 = Message.obtain();
      DrawRedpacketPannelPreviewFragment.SendImageToAIO localSendImageToAIO = new DrawRedpacketPannelPreviewFragment.SendImageToAIO(null);
      localSendImageToAIO.a = this.a;
      localSendImageToAIO.b = this.b;
      localSendImageToAIO.c = this.c;
      localSendImageToAIO.d = this.d;
      localSendImageToAIO.e = ((String)localObject1);
      ((Message)localObject2).obj = localSendImageToAIO;
      ((Message)localObject2).what = 1001;
      DrawRedpacketPannelPreviewFragment.h(this.this$0).sendMessage((Message)localObject2);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawRedpacketPannelPreviewFragment.11
 * JD-Core Version:    0.7.0.1
 */