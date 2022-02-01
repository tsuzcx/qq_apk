package com.vivo.push.b;

import com.vivo.push.a;
import java.util.ArrayList;
import java.util.List;

public final class t
  extends s
{
  private ArrayList<String> a = null;
  private ArrayList<String> b = null;
  
  public t(int paramInt)
  {
    super(paramInt);
  }
  
  protected final void c(a parama)
  {
    super.c(parama);
    parama.a("content", this.a);
    parama.a("error_msg", this.b);
  }
  
  public final ArrayList<String> d()
  {
    return this.a;
  }
  
  protected final void d(a parama)
  {
    super.d(parama);
    this.a = parama.c("content");
    this.b = parama.c("error_msg");
  }
  
  public final List<String> e()
  {
    return this.b;
  }
  
  public final String toString()
  {
    return "OnSetTagsCommand";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.b.t
 * JD-Core Version:    0.7.0.1
 */