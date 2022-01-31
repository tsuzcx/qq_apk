package dov.com.qq.im.ae.camera.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import bbef;
import bbll;
import bigx;
import bikt;

public class VideoStoryPiecesPart$9
  implements Runnable
{
  public VideoStoryPiecesPart$9(bikt parambikt) {}
  
  public void run()
  {
    try
    {
      bikt.a(this.this$0, bigx.a(bikt.a(this.this$0), true));
      if ((bikt.a(this.this$0) != null) && (!bikt.a(this.this$0).isRecycled())) {
        bikt.a(this.this$0, bbef.b(bikt.a(this.this$0), bbll.a(3.0F), bikt.a(this.this$0).getWidth(), bikt.a(this.this$0).getHeight()));
      }
      bikt.b(this.this$0).runOnUiThread(new VideoStoryPiecesPart.9.1(this));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.9
 * JD-Core Version:    0.7.0.1
 */