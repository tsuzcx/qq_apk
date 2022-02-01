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
  
  public void a()
  {
    if (o()) {
      this.a.add(d);
    }
    if (p()) {
      this.a.add(c);
    }
    if (q()) {
      this.a.add(b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardHyperTextOption
 * JD-Core Version:    0.7.0.1
 */