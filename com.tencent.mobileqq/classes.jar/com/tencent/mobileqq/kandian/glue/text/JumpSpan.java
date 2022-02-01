package com.tencent.mobileqq.kandian.glue.text;

import com.tencent.mobileqq.kandian.base.view.widget.text.PressedSpan;

public class JumpSpan
  extends PressedSpan
{
  private final String a;
  
  public JumpSpan(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    super(paramInt1, paramInt2, paramInt3);
    this.a = paramString;
  }
  
  public JumpSpan(String paramString, int paramInt)
  {
    super(-15504151, paramInt, 860716207);
    this.a = paramString;
    a(new JumpSpan.1(this, paramString));
  }
  
  public String a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.text.JumpSpan
 * JD-Core Version:    0.7.0.1
 */