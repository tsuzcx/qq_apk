package com.tencent.mobileqq.troop.enterEffect;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectData;
import com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;

class TroopEnterEffectController$2
  implements View.OnTouchListener
{
  TroopEnterEffectController$2(TroopEnterEffectController paramTroopEnterEffectController, QQAppInterface paramQQAppInterface, String paramString, TroopEnterEffectData paramTroopEnterEffectData) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      paramView = new Intent(this.d.e.getContext(), QQBrowserActivity.class);
      paramMotionEvent = IndividuationUrlHelper.a("troopEnterEffect");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMotionEvent);
      localStringBuilder.append("&gc=");
      localStringBuilder.append(this.d.j);
      paramView.putExtra("url", localStringBuilder.toString());
      this.d.e.getContext().startActivity(paramView);
      ((ITroopEnterEffectService)this.a.getRuntimeService(ITroopEnterEffectService.class, "all")).report("Grp_AIO", "action_clk", new String[] { this.d.j });
      VasWebviewUtil.a(this.b, "style", "0X8008E63", "", 1, 0, 0, "", Integer.toString(this.c.a), "");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.2
 * JD-Core Version:    0.7.0.1
 */