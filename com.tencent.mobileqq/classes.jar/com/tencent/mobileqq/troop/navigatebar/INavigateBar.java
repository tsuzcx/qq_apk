package com.tencent.mobileqq.troop.navigatebar;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.widget.URLThemeImageView;
import java.util.List;

public abstract interface INavigateBar
{
  @Nullable
  public abstract BaseAioMsgNavigateBarDelegate.Entity a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2);
  
  public abstract void a(int paramInt, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView, String paramString);
  
  public abstract void a(int paramInt1, AioAgent.Message paramMessage, String paramString, int paramInt2, TextView paramTextView1, TextView paramTextView2, long paramLong);
  
  public abstract void a(int paramInt, Object paramObject, String paramString);
  
  public abstract boolean a(int paramInt1, int paramInt2);
  
  public abstract boolean a(int paramInt, URLThemeImageView paramURLThemeImageView, String paramString);
  
  public abstract void b();
  
  public abstract void b(int paramInt, Object paramObject, String paramString);
  
  public abstract boolean b(int paramInt);
  
  public abstract BaseAioMsgNavigateBarDelegate c(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.INavigateBar
 * JD-Core Version:    0.7.0.1
 */