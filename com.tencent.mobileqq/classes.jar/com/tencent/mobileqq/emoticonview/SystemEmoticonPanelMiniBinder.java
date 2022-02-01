package com.tencent.mobileqq.emoticonview;

import android.content.Context;

public class SystemEmoticonPanelMiniBinder
  extends SystemEmoticonPanelViewBinder
{
  private static final int NUM_COLUMN = 7;
  private static final int NUM_EMOJI_PAGE = 27;
  private static final int NUM_EMOJI_PAGE_HIGH = 34;
  private static final int NUM_ROW = 4;
  private static final int NUM_ROW_HIGH = 5;
  private int mNumEmojiPage = 27;
  private int mNumRow = 4;
  
  public SystemEmoticonPanelMiniBinder(Context paramContext, EmoticonCallback paramEmoticonCallback, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramEmoticonCallback, paramInt);
    setRowNumAndPageNum(paramBoolean);
  }
  
  private int getPageCount(int[] paramArrayOfInt)
  {
    return (paramArrayOfInt.length + this.mNumEmojiPage - 1) / this.mNumEmojiPage;
  }
  
  private void setRowNumAndPageNum(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mNumRow = 5;
      this.mNumEmojiPage = 34;
      return;
    }
    this.mNumRow = 4;
    this.mNumEmojiPage = 27;
  }
  
  public void destroy()
  {
    super.destroy();
  }
  
  public int getPanelPageCount()
  {
    return getPageCount(this.SYS_EMOTION_ORDER);
  }
  
  protected void setRowColumnNum()
  {
    if (this.adapter != null) {
      this.adapter.setRowColumnNum(this.mNumRow, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemEmoticonPanelMiniBinder
 * JD-Core Version:    0.7.0.1
 */