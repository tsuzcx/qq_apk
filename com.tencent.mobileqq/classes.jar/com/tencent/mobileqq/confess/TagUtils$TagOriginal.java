package com.tencent.mobileqq.confess;

import android.util.Pair;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TagUtils$TagOriginal
{
  public String a = null;
  public int b;
  public boolean c;
  public ArrayList<Pair<String, Float>> d;
  public float e;
  public int f;
  public int g;
  Set<Integer> h;
  
  public TagUtils$TagOriginal(String paramString)
  {
    int i = 0;
    this.b = 0;
    this.c = false;
    this.d = new ArrayList();
    this.e = 1.0F;
    this.f = 0;
    this.g = 36;
    this.h = new HashSet();
    this.a = paramString;
    this.c = TagUtils.a(paramString, this.d);
    this.e = TagUtils.b(paramString);
    this.f = this.d.size();
    this.g = a(this.f);
    this.h.add(Integer.valueOf(1));
    if (this.c)
    {
      this.h.add(Integer.valueOf(this.f));
      if (this.f % 2 == 0) {
        i = 1;
      }
      if (i != 0)
      {
        this.h.add(Integer.valueOf(2));
        this.h.add(Integer.valueOf(this.f / 2));
      }
    }
  }
  
  private int a(int paramInt)
  {
    if (paramInt <= 2) {
      paramInt = TagUtils.b.nextInt(8) - 4 + 74;
    } else if (paramInt <= 4) {
      paramInt = TagUtils.b.nextInt(8) - 4 + 70;
    } else if (paramInt <= 6) {
      paramInt = TagUtils.b.nextInt(8) - 4 + 66;
    } else if (paramInt <= 8) {
      paramInt = TagUtils.b.nextInt(8) - 4 + 62;
    } else {
      paramInt = TagUtils.b.nextInt(8) - 4 + 60;
    }
    return paramInt / 4 * 4;
  }
  
  public void a()
  {
    if (this.c)
    {
      int i;
      if (this.f % 3 == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        this.h.add(Integer.valueOf(3));
        this.h.add(Integer.valueOf(this.f / 3));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.TagUtils.TagOriginal
 * JD-Core Version:    0.7.0.1
 */