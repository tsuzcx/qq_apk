package com.tencent.mobileqq.troop.activity;

import ajjy;
import android.widget.ImageView;
import android.widget.TextView;
import ayfx;
import ayfy;
import java.io.File;

public class TroopBarPublishActivity$16
  implements Runnable
{
  TroopBarPublishActivity$16(TroopBarPublishActivity paramTroopBarPublishActivity, String paramString) {}
  
  public void run()
  {
    if (this.a == null)
    {
      this.this$0.t();
      this.this$0.s = false;
      this.this$0.g.setText(ajjy.a(2131649439));
      this.this$0.g.setTextColor(-65536);
      this.this$0.b.setOnClickListener(new ayfx(this));
      return;
    }
    this.this$0.s = false;
    this.this$0.g.setText("");
    this.this$0.g.setCompoundDrawablesWithIntrinsicBounds(2130847159, 0, 0, 0);
    this.this$0.H = this.a;
    this.this$0.a.a = new File(this.a).length();
    this.this$0.b.setOnClickListener(new ayfy(this));
    this.this$0.a(TroopBarPublishActivity.c(this.this$0), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishActivity.16
 * JD-Core Version:    0.7.0.1
 */