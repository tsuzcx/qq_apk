package com.tencent.weseevideo.editor.sticker;

import android.content.Context;
import android.support.annotation.RequiresApi;
import android.view.View;

public class WsPicStickerContext
  extends WsStickerContext
{
  private boolean a = false;
  
  public WsPicStickerContext(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  @RequiresApi(api=19)
  public void addView(View paramView, boolean paramBoolean)
  {
    if ((!paramView.isAttachedToWindow()) && (!this.a)) {
      super.addView(paramView, true);
    }
  }
  
  public void removeAllViews() {}
  
  protected void renderStickerEditView(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.WsPicStickerContext
 * JD-Core Version:    0.7.0.1
 */