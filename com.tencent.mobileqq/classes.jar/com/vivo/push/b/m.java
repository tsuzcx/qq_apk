package com.vivo.push.b;

import com.vivo.push.a;
import java.util.ArrayList;

public final class m
  extends s
{
  private ArrayList<String> a;
  
  public m()
  {
    super(8);
  }
  
  protected final void c(a parama)
  {
    super.c(parama);
    parama.a("tags_list", this.a);
  }
  
  public final ArrayList<String> d()
  {
    return this.a;
  }
  
  protected final void d(a parama)
  {
    super.d(parama);
    this.a = parama.c("tags_list");
  }
  
  public final String toString()
  {
    return "OnListTagCommand";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.b.m
 * JD-Core Version:    0.7.0.1
 */