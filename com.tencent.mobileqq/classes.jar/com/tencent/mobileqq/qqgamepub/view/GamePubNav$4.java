package com.tencent.mobileqq.qqgamepub.view;

import android.view.ViewPropertyAnimator;
import android.widget.LinearLayout;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;

class GamePubNav$4
  implements Runnable
{
  GamePubNav$4(GamePubNav paramGamePubNav, String paramString) {}
  
  public void run()
  {
    GamePubNav.a(this.this$0).setAlpha(0.0F);
    GamePubNav.a(this.this$0).setVisibility(0);
    GamePubNav.a(this.this$0).animate().alpha(1.0F).setDuration(500L).start();
    GamePubAccountHelper.b(GamePubAccountHelper.a()).h("770").e("1").f("160").d("77002").c("208126").a(2, this.a).a(4, "8").i(GamePubNav.c(this.this$0)).b(GamePubNav.b(this.this$0)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.GamePubNav.4
 * JD-Core Version:    0.7.0.1
 */