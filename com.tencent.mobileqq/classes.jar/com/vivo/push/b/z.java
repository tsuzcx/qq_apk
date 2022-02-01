package com.vivo.push.b;

import com.vivo.push.a;
import java.util.ArrayList;

public final class z
  extends c
{
  private ArrayList<String> a;
  
  public z(boolean paramBoolean, String paramString, ArrayList<String> paramArrayList)
  {
    super(i, paramString);
    this.a = paramArrayList;
  }
  
  protected final void c(a parama)
  {
    super.c(parama);
    parama.a("tags", this.a);
  }
  
  protected final void d(a parama)
  {
    super.d(parama);
    this.a = parama.c("tags");
  }
  
  public final String toString()
  {
    return "TagCommand";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.b.z
 * JD-Core Version:    0.7.0.1
 */