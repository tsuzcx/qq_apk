package com.tencent.tavcut;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.view.RendererUtils;
import org.libpag.PAGFile;
import org.libpag.PAGPlayer;
import org.libpag.PAGSurface;

class PagTransformManager$1
  implements Runnable
{
  PagTransformManager$1(PagTransformManager paramPagTransformManager, PAGFile paramPAGFile, PagTransformManager.PagTransformListener paramPagTransformListener) {}
  
  public void run()
  {
    Object localObject = new int[1];
    GLES20.glGenTextures(localObject.length, (int[])localObject, 0);
    PagTransformManager.access$002(this.this$0, localObject[0]);
    PagTransformManager.access$102(this.this$0, PAGSurface.FromTexture(PagTransformManager.access$000(this.this$0), this.val$pagFile.width(), this.val$pagFile.height()));
    PagTransformManager.access$202(this.this$0, new PAGPlayer());
    PagTransformManager.access$200(this.this$0).setSurface(PagTransformManager.access$100(this.this$0));
    PagTransformManager.access$200(this.this$0).setComposition(this.val$pagFile);
    PagTransformManager.access$200(this.this$0).setScaleMode(0);
    PagTransformManager.access$200(this.this$0).flush();
    localObject = RendererUtils.saveTexture(PagTransformManager.access$000(this.this$0), this.val$pagFile.width(), this.val$pagFile.height());
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
      if (this.val$pagTransformListener != null) {
        this.val$pagTransformListener.onBitmapSaveDone((Bitmap)localObject);
      }
    }
    for (;;)
    {
      PagTransformManager.access$200(this.this$0).setSurface(null);
      return;
      if (this.val$pagTransformListener != null) {
        this.val$pagTransformListener.onBitmapSaveDone(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.PagTransformManager.1
 * JD-Core Version:    0.7.0.1
 */