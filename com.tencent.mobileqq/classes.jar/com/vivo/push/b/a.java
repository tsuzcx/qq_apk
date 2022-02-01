package com.vivo.push.b;

import java.util.ArrayList;

public final class a
  extends c
{
  private ArrayList<String> a;
  
  public a(boolean paramBoolean, String paramString, ArrayList<String> paramArrayList)
  {
    super(i, paramString);
    this.a = paramArrayList;
  }
  
  public final void c(com.vivo.push.a parama)
  {
    super.c(parama);
    parama.a("tags", this.a);
  }
  
  public final void d(com.vivo.push.a parama)
  {
    super.d(parama);
    this.a = parama.c("tags");
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("AliasCommand:");
    localStringBuilder.append(b());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.b.a
 * JD-Core Version:    0.7.0.1
 */