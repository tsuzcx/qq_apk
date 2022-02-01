package com.tencent.mobileqq.guild.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;

@SuppressLint({"AppCompatCustomView"})
public class BlurBGImageView
  extends ImageView
{
  Bitmap a;
  int b = 2;
  int c = 8;
  
  public BlurBGImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public BlurBGImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BlurBGImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private Bitmap a(Context paramContext, Bitmap paramBitmap, float paramFloat)
  {
    paramContext = RenderScript.create(paramContext);
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Allocation localAllocation1 = Allocation.createFromBitmap(paramContext, paramBitmap);
    Allocation localAllocation2 = Allocation.createFromBitmap(paramContext, localBitmap);
    if (Build.VERSION.SDK_INT >= 17)
    {
      ScriptIntrinsicBlur localScriptIntrinsicBlur = ScriptIntrinsicBlur.create(paramContext, Element.U8_4(paramContext));
      localScriptIntrinsicBlur.setRadius(paramFloat);
      localScriptIntrinsicBlur.setInput(localAllocation1);
      localScriptIntrinsicBlur.forEach(localAllocation2);
    }
    localAllocation2.copyTo(localBitmap);
    paramBitmap.recycle();
    paramContext.destroy();
    return localBitmap;
  }
  
  private void a(Bitmap paramBitmap, ImageView paramImageView, float paramFloat)
  {
    Bitmap localBitmap = this.a;
    if (localBitmap != null) {
      localBitmap.recycle();
    }
    this.a = Bitmap.createScaledBitmap(paramBitmap, paramBitmap.getWidth() / this.b, paramBitmap.getHeight() / this.b, false);
    if (this.a.getConfig() != Bitmap.Config.ARGB_8888) {
      this.a = this.a.copy(Bitmap.Config.ARGB_8888, true);
    }
    this.a = a(getContext(), this.a, paramFloat);
    paramImageView.setImageBitmap(this.a);
  }
  
  private Bitmap b(View paramView)
  {
    Bitmap localBitmap = paramView.getDrawingCache();
    Object localObject = localBitmap;
    if (localBitmap != null)
    {
      int i = getWidth();
      int j = getHeight();
      localObject = new int[2];
      getLocationOnScreen((int[])localObject);
      int[] arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      localObject = Bitmap.createBitmap(localBitmap, localObject[0] - arrayOfInt[0], localObject[1] - arrayOfInt[1], i, j);
    }
    return localObject;
  }
  
  public void a(View paramView)
  {
    paramView.setDrawingCacheEnabled(true);
    paramView.buildDrawingCache();
    Bitmap localBitmap2;
    try
    {
      Bitmap localBitmap1 = b(paramView);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localBitmap2 = null;
    }
    if (localBitmap2 != null)
    {
      a(localBitmap2, this, this.c);
      localBitmap2.recycle();
    }
    paramView.setDrawingCacheEnabled(false);
  }
  
  public void setScaleFactor(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.widget.BlurBGImageView
 * JD-Core Version:    0.7.0.1
 */