package com.tencent.tavmovie.utils;

import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavmovie.base.TAVMovieClip;
import com.tencent.tavmovie.base.TAVMovieTimeEffect;
import com.tencent.tavmovie.sticker.TAVMovieSticker;
import com.tencent.tavmovie.sticker.TAVMovieStickerTextItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CloneUtil
{
  public static List<Map<String, Object>> cloneMapDatas(List<Map<String, Object>> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Map localMap = (Map)paramList.next();
      if (localMap != null) {
        localArrayList.add(new HashMap(localMap));
      }
    }
    return localArrayList;
  }
  
  public static List<TAVMovieClip> cloneMovieClips(List<TAVMovieClip> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TAVMovieClip localTAVMovieClip = (TAVMovieClip)paramList.next();
      if (localTAVMovieClip != null) {
        localArrayList.add(localTAVMovieClip.clone());
      }
    }
    return localArrayList;
  }
  
  public static List<TAVMovieStickerTextItem> cloneMovieStickerTextItems(List<TAVMovieStickerTextItem> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TAVMovieStickerTextItem localTAVMovieStickerTextItem = (TAVMovieStickerTextItem)paramList.next();
      if (localTAVMovieStickerTextItem != null) {
        localArrayList.add(localTAVMovieStickerTextItem.clone());
      }
    }
    return localArrayList;
  }
  
  public static List<TAVMovieTimeEffect> cloneMovieTimeEffects(List<TAVMovieTimeEffect> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TAVMovieTimeEffect localTAVMovieTimeEffect = (TAVMovieTimeEffect)paramList.next();
      if (localTAVMovieTimeEffect != null) {
        localArrayList.add(localTAVMovieTimeEffect.clone());
      }
    }
    return localArrayList;
  }
  
  public static List<TAVClip> cloneTAVClips(List<TAVClip> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TAVClip localTAVClip = (TAVClip)paramList.next();
      if (localTAVClip != null) {
        localArrayList.add(localTAVClip.clone());
      }
    }
    return localArrayList;
  }
  
  public static List<TAVMovieSticker> cloneTemplateStickers(List<TAVMovieSticker> paramList)
  {
    if (paramList == null) {
      return null;
    }
    paramList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      TAVMovieSticker localTAVMovieSticker = (TAVMovieSticker)localIterator.next();
      if (localTAVMovieSticker != null) {
        paramList.add(localTAVMovieSticker.clone());
      }
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavmovie.utils.CloneUtil
 * JD-Core Version:    0.7.0.1
 */