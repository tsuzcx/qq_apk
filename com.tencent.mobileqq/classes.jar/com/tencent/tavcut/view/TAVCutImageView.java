package com.tencent.tavcut.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;

public class TAVCutImageView
  extends FrameLayout
{
  private Bitmap curBitmap;
  private ImageView imageView;
  
  public TAVCutImageView(@NonNull Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public TAVCutImageView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public TAVCutImageView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void clearAndResetCurBitmap(Bitmap paramBitmap)
  {
    try
    {
      if ((this.curBitmap != null) && (this.curBitmap != paramBitmap)) {
        this.curBitmap.recycle();
      }
      this.curBitmap = paramBitmap;
      return;
    }
    finally {}
  }
  
  private void init(Context paramContext)
  {
    this.imageView = new ImageView(paramContext);
    addView(this.imageView, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.imageView.post(new TAVCutImageView.1(this, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.view.TAVCutImageView
 * JD-Core Version:    0.7.0.1
 */