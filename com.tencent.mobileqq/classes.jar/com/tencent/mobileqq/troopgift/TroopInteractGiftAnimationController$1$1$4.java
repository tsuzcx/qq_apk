package com.tencent.mobileqq.troopgift;

import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import org.json.JSONObject;

class TroopInteractGiftAnimationController$1$1$4
  implements FrameSprite.OnFrameEndListener
{
  TroopInteractGiftAnimationController$1$1$4(TroopInteractGiftAnimationController.1.1 param1, int paramInt1, String paramString, JSONObject paramJSONObject1, int paramInt2, JSONObject paramJSONObject2) {}
  
  public void a()
  {
    if (this.f.b.this$0.b == null) {
      return;
    }
    if (this.f.b.b.playTotalMicroseconds / 1000L > this.a)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(this.c.optString("videoPath", "2.mp4"));
      localObject = ((StringBuilder)localObject).toString();
      this.f.b.this$0.b.a((String)localObject, new TroopInteractGiftAnimationController.1.1.4.1(this));
      this.f.b.this$0.a(this.f.b.b, this.d - 300);
      return;
    }
    this.f.b.this$0.a();
    if (this.f.b.d != null) {
      this.f.b.d.a();
    }
    this.f.b.this$0.a(this.f.b.b, this.f.b.b.frienduin, this.f.b.b.interactId, this.f.b.b.animationPackageId, this.f.b.this$0.f, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.1.1.4
 * JD-Core Version:    0.7.0.1
 */