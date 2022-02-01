package com.tencent.mobileqq.troopgift;

import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import org.json.JSONObject;

class TroopInteractGiftAnimationController$1$1$5
  implements FrameSprite.OnFrameEndListener
{
  TroopInteractGiftAnimationController$1$1$5(TroopInteractGiftAnimationController.1.1 param1, int paramInt1, int paramInt2, String paramString, JSONObject paramJSONObject) {}
  
  public void a()
  {
    if (this.e.b.this$0.b == null) {
      return;
    }
    if (this.e.b.b.playTotalMicroseconds / 1000L > this.a + this.b)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(this.d.optString("videoPath", "3.mp4"));
      localObject = ((StringBuilder)localObject).toString();
      this.e.b.this$0.b.a((String)localObject, new TroopInteractGiftAnimationController.1.1.5.1(this));
      return;
    }
    this.e.b.this$0.a();
    if (this.e.b.d != null) {
      this.e.b.d.a();
    }
    this.e.b.this$0.a(this.e.b.b, this.e.b.b.frienduin, this.e.b.b.interactId, this.e.b.b.animationPackageId, this.e.b.this$0.f, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.1.1.5
 * JD-Core Version:    0.7.0.1
 */