package com.tencent.mobileqq.troopgift;

import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import org.json.JSONObject;

class TroopInteractGiftAnimationController$1$1$3$1
  implements FrameSprite.OnFrameEndListener
{
  TroopInteractGiftAnimationController$1$1$3$1(TroopInteractGiftAnimationController.1.1.3 param3) {}
  
  public void a()
  {
    if (this.a.g.b.this$0.b == null) {
      return;
    }
    if (this.a.a > this.a.b + this.a.e)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.c);
      ((StringBuilder)localObject).append(this.a.f.optString("videoPath", "3.mp4"));
      localObject = ((StringBuilder)localObject).toString();
      this.a.g.b.this$0.b.a((String)localObject, new TroopInteractGiftAnimationController.1.1.3.1.1(this));
      return;
    }
    this.a.g.b.this$0.a();
    if (this.a.g.b.d != null) {
      this.a.g.b.d.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.1.1.3.1
 * JD-Core Version:    0.7.0.1
 */