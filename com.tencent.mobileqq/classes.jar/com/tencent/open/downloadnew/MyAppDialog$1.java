package com.tencent.open.downloadnew;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ProgressBar;
import android.widget.TextView;
import bhzm;
import bicz;

public class MyAppDialog$1
  implements Runnable
{
  public MyAppDialog$1(bicz parambicz, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int j = 100;
    int i = this.a;
    bhzm.c("MyAppApi", "updateView--progress--" + i + " state = " + this.b);
    Object localObject = this.this$0.getContext().getResources();
    switch (this.b)
    {
    default: 
      localObject = null;
      if (i < 0)
      {
        j = 0;
        label124:
        if (this.this$0.a.getVisibility() != 0)
        {
          this.this$0.a.setVisibility(0);
          this.this$0.e.setVisibility(0);
        }
        if (this.b != 3) {
          break label298;
        }
        this.this$0.c.setVisibility(0);
        this.this$0.c.setText(null);
      }
      break;
    }
    for (;;)
    {
      this.this$0.a.setProgress(j);
      this.this$0.e.setText((CharSequence)localObject);
      return;
      localObject = ((Resources)localObject).getString(2131691487, new Object[] { Integer.valueOf(i) });
      break;
      localObject = ((Resources)localObject).getString(2131691513);
      break;
      localObject = ((Resources)localObject).getString(2131691497, new Object[] { Integer.valueOf(i) });
      break;
      localObject = ((Resources)localObject).getString(2131691482);
      i = 100;
      break;
      localObject = ((Resources)localObject).getString(2131691497);
      break;
      if (i > 100) {
        break label124;
      }
      j = i;
      break label124;
      label298:
      this.this$0.c.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppDialog.1
 * JD-Core Version:    0.7.0.1
 */