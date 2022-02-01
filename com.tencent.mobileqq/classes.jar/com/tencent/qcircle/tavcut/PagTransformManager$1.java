package com.tencent.qcircle.tavcut;

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
    localObject = this.this$0;
    PagTransformManager.access$102((PagTransformManager)localObject, PAGSurface.FromTexture(PagTransformManager.access$000((PagTransformManager)localObject), this.val$pagFile.width(), this.val$pagFile.height()));
    PagTransformManager.access$202(this.this$0, new PAGPlayer());
    PagTransformManager.access$200(this.this$0).setSurface(PagTransformManager.access$100(this.this$0));
    PagTransformManager.access$200(this.this$0).setComposition(this.val$pagFile);
    PagTransformManager.access$200(this.this$0).setScaleMode(0);
    PagTransformManager.access$200(this.this$0).flush();
    localObject = RendererUtils.saveTexture(PagTransformManager.access$000(this.this$0), this.val$pagFile.width(), this.val$pagFile.height());
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      PagTransformManager.PagTransformListener localPagTransformListener = this.val$pagTransformListener;
      if (localPagTransformListener != null) {
        localPagTransformListener.onBitmapSaveDone((Bitmap)localObject);
      }
    }
    else
    {
      localObject = this.val$pagTransformListener;
      if (localObject != null) {
        ((PagTransformManager.PagTransformListener)localObject).onBitmapSaveDone(null);
      }
    }
    PagTransformManager.access$200(this.this$0).setSurface(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.PagTransformManager.1
 * JD-Core Version:    0.7.0.1
 */