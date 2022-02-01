package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.hiboom.HiBoomConstants;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.Set;

public class ForwardHiboomMsgOption
  extends ForwardBaseOption
{
  public ForwardHiboomMsgOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  protected View a()
  {
    int i = this.t.getInt("key_hiboom_id");
    HiBoomTextView localHiBoomTextView = new HiBoomTextView(this.s);
    localHiBoomTextView.setHiBoom(i, 0, HiBoomConstants.e);
    localHiBoomTextView.setText(this.u);
    localHiBoomTextView.setMaxSize(HiBoomConstants.a);
    localHiBoomTextView.setLayoutParams(new RelativeLayout.LayoutParams(500, 500));
    return localHiBoomTextView;
  }
  
  protected void c()
  {
    if (ag()) {
      this.C.add(e);
    }
    if (ah()) {
      this.C.add(d);
    }
    if (ai()) {
      this.C.add(c);
    }
  }
  
  protected void d()
  {
    this.A.setMessage(null);
  }
  
  public boolean e()
  {
    super.e();
    return true;
  }
  
  protected boolean k()
  {
    return true;
  }
  
  public boolean l()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardHiboomMsgOption
 * JD-Core Version:    0.7.0.1
 */