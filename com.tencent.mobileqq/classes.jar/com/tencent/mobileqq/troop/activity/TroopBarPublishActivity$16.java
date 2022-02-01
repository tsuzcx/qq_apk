package com.tencent.mobileqq.troop.activity;

import android.widget.ImageView;
import android.widget.TextView;
import anzj;
import bfio;
import bfip;
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
      this.this$0.r = false;
      this.this$0.d.setText(anzj.a(2131714014));
      this.this$0.d.setTextColor(-65536);
      this.this$0.b.setOnClickListener(new bfio(this));
      return;
    }
    this.this$0.r = false;
    this.this$0.d.setText("");
    this.this$0.d.setCompoundDrawablesWithIntrinsicBounds(2130848324, 0, 0, 0);
    this.this$0.y = this.a;
    this.this$0.a.a = new File(this.a).length();
    this.this$0.b.setOnClickListener(new bfip(this));
    this.this$0.a(TroopBarPublishActivity.c(this.this$0), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishActivity.16
 * JD-Core Version:    0.7.0.1
 */