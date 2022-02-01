package com.tencent.viola.adapter;

import android.text.TextPaint;
import android.view.View;
import com.tencent.viola.commons.ImageAdapterHolder;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.component.image.ImageAction;
import com.tencent.viola.ui.view.VImageView;
import com.tencent.viola.ui.view.VRefreshLayout;

public abstract interface VComponentAdapter
{
  public abstract void initKdRefresh(VRefreshLayout paramVRefreshLayout);
  
  public abstract void onClick(View paramView, Object paramObject);
  
  public abstract void onDoubleClick(View paramView, Object paramObject);
  
  public abstract void onVRParamsChange(View paramView, Object paramObject);
  
  public abstract void requestImage(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, ImageAction paramImageAction, boolean paramBoolean2);
  
  public abstract CharSequence setEmoticonText(CharSequence paramCharSequence, int paramInt1, int paramInt2);
  
  public abstract void setImage(String paramString, VImageView paramVImageView, ImageAdapterHolder paramImageAdapterHolder, ViolaInstance paramViolaInstance, boolean paramBoolean);
  
  public abstract void setImgSpan(String paramString, int paramInt1, int paramInt2, ImageAdapterHolder paramImageAdapterHolder);
  
  public abstract boolean useCustomFont(TextPaint paramTextPaint, String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.adapter.VComponentAdapter
 * JD-Core Version:    0.7.0.1
 */