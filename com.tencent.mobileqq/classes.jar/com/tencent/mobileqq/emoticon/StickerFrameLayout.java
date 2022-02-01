package com.tencent.mobileqq.emoticon;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class StickerFrameLayout
  extends RelativeLayout
{
  ImageView stickerImage;
  
  public StickerFrameLayout(Context paramContext)
  {
    super(paramContext);
    super.setWillNotDraw(false);
  }
  
  public ImageView getStickerImage()
  {
    if (this.stickerImage == null) {
      this.stickerImage = ((ImageView)findViewById(2131427953));
    }
    return this.stickerImage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.StickerFrameLayout
 * JD-Core Version:    0.7.0.1
 */