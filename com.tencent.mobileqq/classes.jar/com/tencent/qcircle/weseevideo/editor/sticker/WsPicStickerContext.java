package com.tencent.qcircle.weseevideo.editor.sticker;

import android.content.Context;
import android.support.annotation.RequiresApi;
import android.view.View;

public class WsPicStickerContext
  extends WsStickerContext
{
  private boolean addingTemplate = false;
  private boolean postRenderResult = true;
  
  public WsPicStickerContext(Context paramContext)
  {
    super(paramContext);
  }
  
  @RequiresApi(api=19)
  public void addView(View paramView, boolean paramBoolean)
  {
    if ((!paramView.isAttachedToWindow()) && (!this.addingTemplate)) {
      super.addView(paramView, true);
    }
  }
  
  public void removeAllViews() {}
  
  protected void renderStickerEditView(long paramLong) {}
  
  public void setAddingTemplate(boolean paramBoolean)
  {
    this.addingTemplate = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.editor.sticker.WsPicStickerContext
 * JD-Core Version:    0.7.0.1
 */