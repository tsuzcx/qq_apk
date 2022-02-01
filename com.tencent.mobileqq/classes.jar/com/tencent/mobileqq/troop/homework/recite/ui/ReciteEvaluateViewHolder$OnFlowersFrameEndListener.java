package com.tencent.mobileqq.troop.homework.recite.ui;

import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import java.lang.ref.WeakReference;

class ReciteEvaluateViewHolder$OnFlowersFrameEndListener
  implements FrameSprite.OnFrameEndListener
{
  final WeakReference<SpriteVideoView> a;
  
  private ReciteEvaluateViewHolder$OnFlowersFrameEndListener(SpriteVideoView paramSpriteVideoView)
  {
    this.a = new WeakReference(paramSpriteVideoView);
  }
  
  public void a()
  {
    SpriteVideoView localSpriteVideoView = (SpriteVideoView)this.a.get();
    if (localSpriteVideoView != null) {
      localSpriteVideoView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.ReciteEvaluateViewHolder.OnFlowersFrameEndListener
 * JD-Core Version:    0.7.0.1
 */