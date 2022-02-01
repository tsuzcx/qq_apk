package com.tencent.rfw.barrage.render;

import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;

public class RFWBarrageViewFactory
{
  public static IRFWBarrageView a(View paramView)
  {
    if ((paramView instanceof SurfaceView)) {
      return new RFWSurfaceBarrageView((SurfaceView)paramView);
    }
    if ((paramView instanceof TextureView)) {
      return new RFWTextureBarrageView((TextureView)paramView);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.render.RFWBarrageViewFactory
 * JD-Core Version:    0.7.0.1
 */