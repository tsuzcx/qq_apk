package com.tencent.mobileqq.forward;

import android.content.Intent;
import java.util.Set;

public class ForwardHyperTextOption
  extends ForwardPluginShareStructMsgOption
{
  public ForwardHyperTextOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  protected void a()
  {
    if (h()) {
      this.a.add(d);
    }
    if (i()) {
      this.a.add(c);
    }
    if (j()) {
      this.a.add(b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardHyperTextOption
 * JD-Core Version:    0.7.0.1
 */