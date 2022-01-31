package com.tencent.mobileqq.teamwork;

import axfo;
import com.tencent.biz.widgets.ElasticHorScrView;

public class TeamWorkShareActionSheetBuilder$4
  implements Runnable
{
  public TeamWorkShareActionSheetBuilder$4(axfo paramaxfo) {}
  
  public void run()
  {
    if (this.this$0.a.getWidth() < axfo.a(this.this$0)) {
      this.this$0.a.setMove(true);
    }
    while (this.this$0.b.getWidth() < axfo.b(this.this$0))
    {
      this.this$0.b.setMove(true);
      return;
      this.this$0.a.setMove(false);
    }
    this.this$0.b.setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkShareActionSheetBuilder.4
 * JD-Core Version:    0.7.0.1
 */