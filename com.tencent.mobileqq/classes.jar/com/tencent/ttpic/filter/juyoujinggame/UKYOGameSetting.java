package com.tencent.ttpic.filter.juyoujinggame;

import com.tencent.ttpic.openapi.model.StickerItem;
import java.util.ArrayList;

public class UKYOGameSetting
{
  public StickerItem appleComboItem;
  public StickerItem appleDisapearItem;
  public StickerItem appleItem;
  public AppleItemSetting appleItemSetting;
  public StickerItem combo1Item;
  public StickerItem combo2Item;
  public StickerItem comboItem;
  public FlashItemSetting flashItemSetting;
  public StickerItem score1Item;
  public StickerItem score2Item;
  public StickerItem scoreEffectItem;
  public ScoreItemSetting scoreSetting;
  public ArrayList<StickerItem> scoreValueItems;
  public StickerItem tachiHitItem;
  public StickerItem tachiItem;
  public TachiSetting tachiSetting;
  
  public ArrayList<StickerItem> createScoreItems(ScoreItemSetting paramScoreItemSetting, StickerItem paramStickerItem)
  {
    ArrayList localArrayList = new ArrayList();
    paramScoreItemSetting = paramScoreItemSetting.scores;
    int j = paramScoreItemSetting.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(createStickerItem(paramScoreItemSetting[i], paramStickerItem.frames, paramStickerItem));
      i += 1;
    }
    return localArrayList;
  }
  
  public StickerItem createStickerItem(String paramString, int paramInt, StickerItem paramStickerItem)
  {
    if (paramStickerItem == null) {
      return null;
    }
    StickerItem localStickerItem = new StickerItem();
    localStickerItem.id = paramString;
    localStickerItem.frames = paramInt;
    localStickerItem.subFolder = localStickerItem.id;
    localStickerItem.frameDuration = paramStickerItem.frameDuration;
    localStickerItem.type = paramStickerItem.type;
    localStickerItem.stickerType = paramStickerItem.stickerType;
    return localStickerItem;
  }
  
  public ArrayList<StickerItem> getItems()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.appleItem);
    localArrayList.add(this.tachiItem);
    localArrayList.add(this.appleDisapearItem);
    localArrayList.add(this.appleComboItem);
    localArrayList.add(this.tachiHitItem);
    localArrayList.add(this.score1Item);
    localArrayList.add(this.score2Item);
    localArrayList.addAll(this.scoreValueItems);
    localArrayList.add(this.comboItem);
    localArrayList.add(this.scoreEffectItem);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.juyoujinggame.UKYOGameSetting
 * JD-Core Version:    0.7.0.1
 */