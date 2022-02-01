package com.tencent.ttpic.filter;

import com.tencent.ttpic.openapi.filter.StaticStickerFilter;
import com.tencent.ttpic.openapi.model.StickerItem;

public class StaticCountFilter
  extends StaticStickerFilter
{
  private int shooKCount = 0;
  
  public StaticCountFilter(StickerItem paramStickerItem, String paramString)
  {
    super(paramStickerItem, paramString);
  }
  
  public void updateShookCount(int paramInt)
  {
    this.shooKCount = paramInt;
  }
  
  protected void updateTextureParam(int paramInt, long paramLong)
  {
    if (this.item.id.equals("shi")) {
      paramInt = this.shooKCount / 10;
    } else if (this.item.id.equals("ge")) {
      paramInt = this.shooKCount % 10;
    } else {
      paramInt = 0;
    }
    super.updateTextureParam(paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.StaticCountFilter
 * JD-Core Version:    0.7.0.1
 */