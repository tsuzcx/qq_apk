package com.tencent.qcircle.weseevideo.editor.sticker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class WsPicStickerContentView
  extends WsStickerContentView
{
  private final List<WsStickerEditView> stickerEditViews = new CopyOnWriteArrayList();
  
  public WsPicStickerContentView(Context paramContext)
  {
    super(paramContext);
  }
  
  public WsPicStickerContentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WsPicStickerContentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void addView(View paramView)
  {
    super.addView(paramView);
    if ((this.curStickerEditView != null) && (!this.stickerEditViews.contains(this.curStickerEditView))) {
      this.stickerEditViews.add(this.curStickerEditView);
    }
  }
  
  public List<WsStickerEditView> getStickerEditViews()
  {
    return this.stickerEditViews;
  }
  
  protected void initStickerView()
  {
    Iterator localIterator = this.stickerEditViews.iterator();
    while (localIterator.hasNext())
    {
      WsStickerEditView localWsStickerEditView = (WsStickerEditView)localIterator.next();
      if (localWsStickerEditView.isNeedInitLocation()) {
        localWsStickerEditView.initLocation(getMeasuredWidth(), getMeasuredHeight());
      }
    }
  }
  
  protected void setNeedInitLocation()
  {
    Iterator localIterator = this.stickerEditViews.iterator();
    while (localIterator.hasNext()) {
      ((WsStickerEditView)localIterator.next()).needInitLocation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.editor.sticker.view.WsPicStickerContentView
 * JD-Core Version:    0.7.0.1
 */