package com.tencent.mobileqq.emoticon;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class EmojiStickerManager$StickerFrameLayout
  extends RelativeLayout
{
  ImageView a;
  
  public EmojiStickerManager$StickerFrameLayout(Context paramContext)
  {
    super(paramContext);
    super.setWillNotDraw(false);
  }
  
  public ImageView a()
  {
    if ((this.a == null) && (getChildCount() >= 1))
    {
      View localView = getChildAt(0);
      if ((localView instanceof ImageView))
      {
        this.a = ((ImageView)localView);
        return this.a;
      }
    }
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerFrameLayout
 * JD-Core Version:    0.7.0.1
 */