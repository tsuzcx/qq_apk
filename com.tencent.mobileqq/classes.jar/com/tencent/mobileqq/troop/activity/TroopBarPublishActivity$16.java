package com.tencent.mobileqq.troop.activity;

import alud;
import android.widget.ImageView;
import android.widget.TextView;
import bbjc;
import bbjd;
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
      this.this$0.g.setText(alud.a(2131715624));
      this.this$0.g.setTextColor(-65536);
      this.this$0.b.setOnClickListener(new bbjc(this));
      return;
    }
    this.this$0.s = false;
    this.this$0.g.setText("");
    this.this$0.g.setCompoundDrawablesWithIntrinsicBounds(2130847829, 0, 0, 0);
    this.this$0.H = this.a;
    this.this$0.a.a = new File(this.a).length();
    this.this$0.b.setOnClickListener(new bbjd(this));
    this.this$0.a(TroopBarPublishActivity.c(this.this$0), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishActivity.16
 * JD-Core Version:    0.7.0.1
 */