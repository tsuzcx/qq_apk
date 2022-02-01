package com.tencent.weseevideo.editor.sticker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class WsPicStickerContentView
  extends WsStickerContentView
{
  private final List<WsStickerEditView> a = new CopyOnWriteArrayList();
  
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
  
  public List<WsStickerEditView> a()
  {
    return this.a;
  }
  
  public void addView(View paramView)
  {
    super.addView(paramView);
    if ((this.curStickerEditView != null) && (!this.a.contains(this.curStickerEditView))) {
      this.a.add(this.curStickerEditView);
    }
  }
  
  protected void initStickerView()
  {
    Iterator localIterator = this.a.iterator();
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
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((WsStickerEditView)localIterator.next()).needInitLocation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.view.WsPicStickerContentView
 * JD-Core Version:    0.7.0.1
 */