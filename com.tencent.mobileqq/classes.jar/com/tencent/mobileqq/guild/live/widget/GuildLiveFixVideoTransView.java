package com.tencent.mobileqq.guild.live.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GuildLiveFixVideoTransView
  extends SurfaceView
{
  public GuildLiveFixVideoTransView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GuildLiveFixVideoTransView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GuildLiveFixVideoTransView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    getHolder().addCallback(new GuildLiveFixVideoTransView.1(this));
  }
  
  private void a(SurfaceHolder paramSurfaceHolder)
  {
    try
    {
      Canvas localCanvas = paramSurfaceHolder.lockCanvas();
      if (localCanvas != null)
      {
        localCanvas.drawColor(-16777216);
        paramSurfaceHolder.unlockCanvasAndPost(localCanvas);
      }
      return;
    }
    catch (Exception paramSurfaceHolder) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.widget.GuildLiveFixVideoTransView
 * JD-Core Version:    0.7.0.1
 */