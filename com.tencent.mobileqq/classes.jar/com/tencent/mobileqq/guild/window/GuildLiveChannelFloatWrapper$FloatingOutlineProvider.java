package com.tencent.mobileqq.guild.window;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;

@RequiresApi(api=21)
class GuildLiveChannelFloatWrapper$FloatingOutlineProvider
  extends ViewOutlineProvider
{
  private float b;
  
  public GuildLiveChannelFloatWrapper$FloatingOutlineProvider(GuildLiveChannelFloatWrapper paramGuildLiveChannelFloatWrapper, float paramFloat)
  {
    this.b = paramFloat;
  }
  
  public void getOutline(View paramView, Outline paramOutline)
  {
    Rect localRect = new Rect();
    paramView.getGlobalVisibleRect(localRect);
    int i = Math.max(paramView.getWidth(), localRect.width());
    int j = Math.max(paramView.getHeight(), localRect.height());
    localRect.set(localRect.left, localRect.top, localRect.left + i, localRect.top + j);
    paramOutline.setRoundRect(new Rect(0, 0, localRect.right - localRect.left - 0, localRect.bottom - localRect.top - 0), this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.window.GuildLiveChannelFloatWrapper.FloatingOutlineProvider
 * JD-Core Version:    0.7.0.1
 */