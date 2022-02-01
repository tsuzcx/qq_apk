package com.tencent.ttpic.filter.juyoujinggame;

import com.tencent.ttpic.openapi.model.StickerItem;

public class ScoreItemSetting
{
  public StickerItem audiodefen;
  public String dataPath = "";
  public String[] scores = new String[10];
  
  public ScoreItemSetting()
  {
    int i = 0;
    while (i < 10)
    {
      this.scores[i] = ("score" + i);
      i += 1;
    }
  }
  
  public String getScoreImageID(int paramInt)
  {
    return this.scores[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.juyoujinggame.ScoreItemSetting
 * JD-Core Version:    0.7.0.1
 */