package com.tencent.mobileqq.troop.activity;

import android.widget.ImageView;
import android.widget.TextView;
import anvx;
import beyi;
import beyj;
import java.io.File;

public class TroopBarPublishActivity$16
  implements Runnable
{
  TroopBarPublishActivity$16(TroopBarPublishActivity paramTroopBarPublishActivity, String paramString) {}
  
  public void run()
  {
    if (this.a == null)
    {
      this.this$0.q();
      this.this$0.r = false;
      this.this$0.d.setText(anvx.a(2131714593));
      this.this$0.d.setTextColor(-65536);
      this.this$0.b.setOnClickListener(new beyi(this));
      return;
    }
    this.this$0.r = false;
    this.this$0.d.setText("");
    this.this$0.d.setCompoundDrawablesWithIntrinsicBounds(2130848326, 0, 0, 0);
    this.this$0.y = this.a;
    this.this$0.a.a = new File(this.a).length();
    this.this$0.b.setOnClickListener(new beyj(this));
    this.this$0.a(TroopBarPublishActivity.c(this.this$0), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishActivity.16
 * JD-Core Version:    0.7.0.1
 */