package com.tencent.mobileqq.confess;

import android.graphics.Rect;
import java.util.ArrayList;

public class TagUtils$Tag
{
  public TagUtils.TagOriginal a = null;
  public int b = -1;
  public Rect c = null;
  public int d = 24;
  public boolean e;
  public int f;
  public int g;
  public ArrayList<TagUtils.Tag.Child> h;
  public int i;
  public boolean j;
  
  public TagUtils$Tag(TagUtils.TagOriginal paramTagOriginal, int paramInt1, Rect paramRect, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    boolean bool = false;
    this.e = false;
    this.f = 0;
    this.g = 0;
    this.h = new ArrayList();
    this.i = 1;
    this.j = false;
    this.a = paramTagOriginal;
    this.b = paramInt1;
    this.d = paramInt2;
    this.e = paramBoolean;
    this.c = paramRect;
    this.i = paramInt3;
    paramBoolean = bool;
    if (paramTagOriginal.b > 0) {
      paramBoolean = true;
    }
    this.j = paramBoolean;
    paramTagOriginal.b += 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("text: ");
    localStringBuilder.append(this.a.a);
    localStringBuilder.append("; size: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("; line_count: ");
    localStringBuilder.append(this.i);
    localStringBuilder.append("; container: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("; algin: ");
    localStringBuilder.append(this.f);
    localStringBuilder.append("; v_algin: ");
    localStringBuilder.append(this.g);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.TagUtils.Tag
 * JD-Core Version:    0.7.0.1
 */