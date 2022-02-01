package com.tencent.ttpic.filament;

import android.graphics.SurfaceTexture;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.ttpic.util.FrameUtil;

class FilamentFilter$2$1
  implements Runnable
{
  FilamentFilter$2$1(FilamentFilter.2 param2) {}
  
  public void run()
  {
    FilamentFilter.access$000(this.this$1.this$0).updateTexImage();
    FilamentFilter.access$300(this.this$1.this$0).setRotationAndFlip(-FilamentFilter.access$200(this.this$1.this$0), 0, 0);
    FrameUtil.clearFrame(FilamentFilter.access$400(this.this$1.this$0), 0.0F, 1.0F, 0.0F, 1.0F, FilamentFilter.access$500(this.this$1.this$0), FilamentFilter.access$600(this.this$1.this$0));
    FilamentFilter.access$300(this.this$1.this$0).RenderProcess(FilamentFilter.access$100(this.this$1.this$0)[0], FilamentFilter.access$500(this.this$1.this$0), FilamentFilter.access$600(this.this$1.this$0), -1, 0.0D, FilamentFilter.access$400(this.this$1.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filament.FilamentFilter.2.1
 * JD-Core Version:    0.7.0.1
 */