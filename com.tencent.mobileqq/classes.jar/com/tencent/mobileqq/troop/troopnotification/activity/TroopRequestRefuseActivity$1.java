package com.tencent.mobileqq.troop.troopnotification.activity;

import android.graphics.Color;
import android.text.Editable;
import android.widget.TextView;

class TroopRequestRefuseActivity$1
  implements Runnable
{
  TroopRequestRefuseActivity$1(TroopRequestRefuseActivity paramTroopRequestRefuseActivity, Editable paramEditable) {}
  
  public void run()
  {
    if (this.a.length() > 25)
    {
      this.this$0.a.setTextColor(-65536);
      TroopRequestRefuseActivity.a(this.this$0, false);
    }
    else
    {
      this.this$0.a.setTextColor(Color.rgb(119, 119, 119));
      TroopRequestRefuseActivity.b(this.this$0, true);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(25 - this.a.length());
    String str = ((StringBuilder)localObject).toString();
    localObject = str;
    if (str.length() > 4)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str.substring(0, 2));
      ((StringBuilder)localObject).append("…");
      localObject = ((StringBuilder)localObject).toString();
    }
    this.this$0.a.setText((CharSequence)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestRefuseActivity.1
 * JD-Core Version:    0.7.0.1
 */