package com.tencent.mobileqq.trooponline;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

class TroopOnlineMemberBar$1
  implements Runnable
{
  TroopOnlineMemberBar$1(TroopOnlineMemberBar paramTroopOnlineMemberBar) {}
  
  public void run()
  {
    if (TroopOnlineMemberBar.a(this.this$0) != 0)
    {
      this.this$0.q.setVisibility(0);
      if ((TroopOnlineMemberBar.a(this.this$0) != 2) && (NetworkUtil.isNetworkAvailable(this.this$0.c)))
      {
        if (TroopOnlineMemberBar.a(this.this$0) != 1) {
          return;
        }
        try
        {
          if (this.this$0.p == null) {
            this.this$0.p = ((Animatable)this.this$0.c.getResources().getDrawable(2130839585));
          }
          this.this$0.q.setText(null);
          this.this$0.q.setCompoundDrawablesWithIntrinsicBounds((Drawable)this.this$0.p, null, null, null);
          this.this$0.p.start();
          return;
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("show exception, msg = ");
          localStringBuilder.append(localException.getMessage());
          QLog.e("TroopOnlineMemberBar", 4, localStringBuilder.toString());
          return;
        }
      }
      if (this.this$0.n == 1) {
        this.this$0.q.setText(2131892291);
      } else if (this.this$0.n == 3) {
        this.this$0.q.setText(2131889904);
      } else {
        this.this$0.q.setText(2131916756);
      }
      this.this$0.q.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      if ((this.this$0.p != null) && (this.this$0.p.isRunning())) {
        this.this$0.p.stop();
      }
      TroopOnlineMemberBar.a(this.this$0, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.trooponline.TroopOnlineMemberBar.1
 * JD-Core Version:    0.7.0.1
 */