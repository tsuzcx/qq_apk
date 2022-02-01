package com.tencent.mtt.hippy.dom.node;

import android.text.SpannableStringBuilder;

class TextNode$a
{
  protected int a;
  protected int b;
  protected Object c;
  
  TextNode$a(int paramInt1, int paramInt2, Object paramObject)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramObject;
  }
  
  public void a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    int i = 34;
    if (this.a == 0) {
      i = 18;
    }
    paramSpannableStringBuilder.setSpan(this.c, this.a, this.b, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.node.TextNode.a
 * JD-Core Version:    0.7.0.1
 */