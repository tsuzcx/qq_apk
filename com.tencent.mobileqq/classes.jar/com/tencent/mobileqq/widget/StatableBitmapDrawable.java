package com.tencent.mobileqq.widget;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.util.StateSet;
import java.util.ArrayList;

public class StatableBitmapDrawable
  extends BitmapDrawable
{
  private static final int[] a = { 16842919 };
  private static final float[] b = { 0.0F, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F };
  private static final ColorMatrixColorFilter c = new ColorMatrixColorFilter(b);
  private static final float[] d = { 0.3F, 0.59F, 0.11F, 0.0F, 0.0F, 0.3F, 0.59F, 0.11F, 0.0F, 0.0F, 0.3F, 0.59F, 0.11F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  private static final ColorMatrixColorFilter e = new ColorMatrixColorFilter(d);
  private static final float[] f = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.8F, 0.0F };
  private static final ColorMatrixColorFilter i = new ColorMatrixColorFilter(f);
  private float g = 1.0F;
  private float[] h = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, this.g, 0.0F };
  private ArrayList<int[]> j;
  private ArrayList<ColorFilter> k;
  private ColorFilter l;
  
  public StatableBitmapDrawable(Resources paramResources, Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramResources, paramBitmap);
    if (paramBoolean2) {
      a(a, c);
    }
    if (paramBoolean1) {
      a(StateSet.WILD_CARD, e);
    }
  }
  
  private ColorFilter a(int[] paramArrayOfInt)
  {
    ArrayList localArrayList = this.j;
    if (localArrayList == null) {
      return null;
    }
    int n = this.k.size();
    int m = 0;
    while (m < n)
    {
      if (StateSet.stateSetMatches((int[])localArrayList.get(m), paramArrayOfInt)) {
        return (ColorFilter)this.k.get(m);
      }
      m += 1;
    }
    return null;
  }
  
  public int a(int[] paramArrayOfInt, ColorFilter paramColorFilter)
  {
    if (this.j == null)
    {
      this.j = new ArrayList();
      this.k = new ArrayList();
    }
    this.j.add(paramArrayOfInt);
    this.k.add(paramColorFilter);
    return this.k.size();
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    paramArrayOfInt = a(paramArrayOfInt);
    if (this.l != paramArrayOfInt)
    {
      this.l = paramArrayOfInt;
      setColorFilter(this.l);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.StatableBitmapDrawable
 * JD-Core Version:    0.7.0.1
 */