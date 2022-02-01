package com.tencent.mobileqq.qqgamepub.view;

import android.view.ViewPropertyAnimator;
import android.widget.LinearLayout;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.utils.StringUtil;

class GamePubNav$2
  implements Runnable
{
  GamePubNav$2(GamePubNav paramGamePubNav, String paramString) {}
  
  public void run()
  {
    GamePubNav.b(this.this$0).setAlpha(0.0F);
    GamePubNav.b(this.this$0).setVisibility(0);
    GamePubNav.b(this.this$0).animate().alpha(1.0F).setDuration(500L).start();
    if (!StringUtil.isEmpty(this.a)) {
      GamePubAccountHelper.d(GamePubAccountHelper.a()).h("770").i(GamePubNav.a(this.this$0)).d("77002").c("209090").a(2, this.a).a(4, "8").a(12, "160").a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.GamePubNav.2
 * JD-Core Version:    0.7.0.1
 */