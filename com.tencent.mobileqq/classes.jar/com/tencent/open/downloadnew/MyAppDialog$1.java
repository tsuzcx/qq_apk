package com.tencent.open.downloadnew;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ProgressBar;
import android.widget.TextView;
import bcds;
import bchp;

public class MyAppDialog$1
  implements Runnable
{
  public MyAppDialog$1(bchp parambchp, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int j = 100;
    int i = this.a;
    bcds.c("MyAppApi", "updateView--progress--" + i + " state = " + this.b);
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
      localObject = ((Resources)localObject).getString(2131626074, new Object[] { Integer.valueOf(i) });
      break;
      localObject = ((Resources)localObject).getString(2131626091);
      break;
      localObject = ((Resources)localObject).getString(2131626082, new Object[] { Integer.valueOf(i) });
      break;
      localObject = ((Resources)localObject).getString(2131626071);
      i = 100;
      break;
      localObject = ((Resources)localObject).getString(2131626082);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppDialog.1
 * JD-Core Version:    0.7.0.1
 */