package com.tencent.mobileqq.wink.editor.view;

import android.graphics.PointF;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;

public abstract interface BorderView$StickerOperationCallBack
{
  public abstract PointF a(View paramView);
  
  public abstract WinkStickerModel a(float paramFloat1, float paramFloat2);
  
  public abstract WinkStickerModel a(PointF paramPointF1, PointF paramPointF2);
  
  public abstract void a(WinkStickerModel paramWinkStickerModel);
  
  public abstract void a(BorderView.Direction paramDirection);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b(WinkStickerModel paramWinkStickerModel);
  
  public abstract void c(@Nullable WinkStickerModel paramWinkStickerModel);
  
  public abstract void d(@Nullable WinkStickerModel paramWinkStickerModel);
  
  public abstract PointF i();
  
  public abstract int k();
  
  public abstract int l();
  
  public abstract int m();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.view.BorderView.StickerOperationCallBack
 * JD-Core Version:    0.7.0.1
 */