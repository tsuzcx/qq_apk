package com.tencent.mobileqq.troopgift;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class TroopInteractGiftAnimationController$1$1
  implements Runnable
{
  TroopInteractGiftAnimationController$1$1(TroopInteractGiftAnimationController.1 param1, JSONObject paramJSONObject) {}
  
  public void run()
  {
    Object localObject1 = this.a;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("TroopGiftUtil.getInteractConfig = null, packageId: ");
        ((StringBuilder)localObject1).append(this.b.a);
        QLog.e("TroopInteractGiftAnimationController", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    boolean bool;
    if (((JSONObject)localObject1).optInt("type", 2) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    if (this.b.this$0.b == null)
    {
      this.b.this$0.b = new SpriteVideoView(this.b.this$0.a.e, bool);
      this.b.this$0.b.setCenterCrop(true);
      if (this.b.this$0.a.bG == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopInteractGiftAnimationController", 2, "mTroopChatPie.bgAnimationLayout == null");
        }
        return;
      }
      this.b.this$0.a.bG.removeAllViews();
      this.b.this$0.a.bG.addView(this.b.this$0.b, -1, this.b.this$0.a.bI);
      this.b.this$0.f = 0;
      this.b.this$0.g = true;
      if ((this.b.b.interactState != 2) && (this.b.c))
      {
        this.b.this$0.c = new TroopGiftActionButton(this.b.this$0.a.e, this.a, new TroopInteractGiftAnimationController.1.1.1(this));
        this.b.this$0.b.setOnProgressChangedListener(new TroopInteractGiftAnimationController.1.1.2(this));
        localObject1 = new RelativeLayout.LayoutParams(DisplayUtil.a(this.b.this$0.a.e, 175.0F), DisplayUtil.a(this.b.this$0.a.e, 175.0F));
        ((RelativeLayout.LayoutParams)localObject1).topMargin = (this.b.this$0.a.bI - DisplayUtil.a(this.b.this$0.a.e, 85.0F));
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = (-DisplayUtil.a(this.b.this$0.a.e, 25.0F));
        ((RelativeLayout.LayoutParams)localObject1).addRule(11);
        ((RelativeLayout.LayoutParams)localObject1).addRule(10);
        this.b.this$0.d.addView(this.b.this$0.c, (ViewGroup.LayoutParams)localObject1);
      }
      localObject1 = TroopGiftUtil.a(this.b.b);
      Object localObject3 = this.a.optJSONObject("animation1");
      Object localObject2 = this.a.optJSONObject("animation2");
      JSONObject localJSONObject = this.a.optJSONObject("animation3");
      int i = ((JSONObject)localObject3).optInt("duration");
      int j = ((JSONObject)localObject2).optInt("duration");
      int k = localJSONObject.optInt("duration");
      int m = (int)(this.b.b.alreadyPlayMicroseconds / 1000L);
      int n = (int)(this.b.b.playTotalMicroseconds / 1000L);
      StringBuilder localStringBuilder;
      if ((this.b.b.interactState != 2) && (this.b.c))
      {
        if (m < i)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(((JSONObject)localObject3).optString("videoPath", "1.mp4"));
          localObject3 = localStringBuilder.toString();
          this.b.this$0.b.a((String)localObject3, m, new TroopInteractGiftAnimationController.1.1.4(this, i, (String)localObject1, (JSONObject)localObject2, j, localJSONObject));
          this.b.this$0.a(this.b.b, i - m - 300);
        }
        else
        {
          n = i + j;
          if (m < n)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append(((JSONObject)localObject2).optString("videoPath", "2.mp4"));
            localObject2 = ((StringBuilder)localObject3).toString();
            this.b.this$0.b.a((String)localObject2, m - i, new TroopInteractGiftAnimationController.1.1.5(this, i, j, (String)localObject1, localJSONObject));
            this.b.this$0.a(this.b.b, n - m - 300);
          }
          else if (m < n + k)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(localJSONObject.optString("videoPath", "3.mp4"));
            localObject1 = ((StringBuilder)localObject2).toString();
            this.b.this$0.b.a((String)localObject1, m - i - j, new TroopInteractGiftAnimationController.1.1.6(this));
          }
        }
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(((JSONObject)localObject3).optString("videoPath", "1.mp4"));
        localObject3 = localStringBuilder.toString();
        this.b.this$0.b.a((String)localObject3, new TroopInteractGiftAnimationController.1.1.3(this, n, i, (String)localObject1, (JSONObject)localObject2, j, localJSONObject));
      }
      if (this.b.b.interactState == 0) {
        this.b.e.b(this.b.b.frienduin, this.b.b.interactId, this.b.b.animationPackageId, new TroopInteractGiftAnimationController.1.1.7(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.1.1
 * JD-Core Version:    0.7.0.1
 */