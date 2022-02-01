package com.tencent.mobileqq.troopgift;

import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import org.json.JSONObject;

class TroopInteractGiftAnimationController$1$1$4$1
  implements FrameSprite.OnFrameEndListener
{
  TroopInteractGiftAnimationController$1$1$4$1(TroopInteractGiftAnimationController.1.1.4 param4) {}
  
  public void a()
  {
    if (this.a.f.b.this$0.b == null) {
      return;
    }
    if (this.a.f.b.b.playTotalMicroseconds / 1000L > this.a.a + this.a.d)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.b);
      ((StringBuilder)localObject).append(this.a.e.optString("videoPath", "3.mp4"));
      localObject = ((StringBuilder)localObject).toString();
      this.a.f.b.this$0.b.a((String)localObject, new TroopInteractGiftAnimationController.1.1.4.1.1(this));
      return;
    }
    this.a.f.b.this$0.a();
    if (this.a.f.b.d != null) {
      this.a.f.b.d.a();
    }
    this.a.f.b.this$0.a(this.a.f.b.b, this.a.f.b.b.frienduin, this.a.f.b.b.interactId, this.a.f.b.b.animationPackageId, this.a.f.b.this$0.f, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.1.1.4.1
 * JD-Core Version:    0.7.0.1
 */