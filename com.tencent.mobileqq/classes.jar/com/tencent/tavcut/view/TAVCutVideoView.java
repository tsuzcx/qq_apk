package com.tencent.tavcut.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.tavcut.bean.Size;

public class TAVCutVideoView
  extends RelativeLayout
{
  private FrameLayout stickerContainer;
  
  public TAVCutVideoView(@NonNull Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public TAVCutVideoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public TAVCutVideoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.stickerContainer = new FrameLayout(paramContext);
  }
  
  public void adjustStickerContainer(Size paramSize)
  {
    post(new TAVCutVideoView.1(this, paramSize));
  }
  
  public ViewGroup getStickerContainer()
  {
    return this.stickerContainer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.view.TAVCutVideoView
 * JD-Core Version:    0.7.0.1
 */