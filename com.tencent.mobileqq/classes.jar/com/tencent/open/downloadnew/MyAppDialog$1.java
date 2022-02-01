package com.tencent.open.downloadnew;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.open.base.LogUtility;

class MyAppDialog$1
  implements Runnable
{
  MyAppDialog$1(MyAppDialog paramMyAppDialog, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int i = this.a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateView--progress--");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" state = ");
    ((StringBuilder)localObject).append(this.b);
    LogUtility.c("MyAppApi", ((StringBuilder)localObject).toString());
    localObject = this.this$0.getContext().getResources();
    int j = this.b;
    if (j != 1) {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 4)
          {
            if (j != 10)
            {
              if (j != 20)
              {
                localObject = null;
                break label176;
              }
            }
            else
            {
              localObject = ((Resources)localObject).getString(2131691620);
              break label176;
            }
          }
          else
          {
            localObject = ((Resources)localObject).getString(2131691605);
            i = 100;
            break label176;
          }
        }
        else
        {
          localObject = ((Resources)localObject).getString(2131691620, new Object[] { Integer.valueOf(i) });
          break label176;
        }
      }
      else
      {
        localObject = ((Resources)localObject).getString(2131691610, new Object[] { Integer.valueOf(i) });
        break label176;
      }
    }
    localObject = ((Resources)localObject).getString(2131691636);
    label176:
    if (i < 0)
    {
      j = 0;
    }
    else
    {
      j = i;
      if (i > 100) {
        j = 100;
      }
    }
    if (this.this$0.a.getVisibility() != 0)
    {
      this.this$0.a.setVisibility(0);
      this.this$0.e.setVisibility(0);
    }
    if (this.b == 3)
    {
      this.this$0.c.setVisibility(0);
      this.this$0.c.setText(null);
    }
    else
    {
      this.this$0.c.setVisibility(4);
    }
    this.this$0.a.setProgress(j);
    this.this$0.e.setText((CharSequence)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppDialog.1
 * JD-Core Version:    0.7.0.1
 */