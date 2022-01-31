package com.tencent.mobileqq.teamwork;

import ayft;
import com.tencent.biz.widgets.ElasticHorScrView;

public class TeamWorkShareActionSheetBuilder$4
  implements Runnable
{
  public TeamWorkShareActionSheetBuilder$4(ayft paramayft) {}
  
  public void run()
  {
    if (this.this$0.a.getWidth() < ayft.a(this.this$0)) {
      this.this$0.a.setMove(true);
    }
    while (this.this$0.b.getWidth() < ayft.b(this.this$0))
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