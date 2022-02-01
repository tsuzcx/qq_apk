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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardHyperTextOption
 * JD-Core Version:    0.7.0.1
 */