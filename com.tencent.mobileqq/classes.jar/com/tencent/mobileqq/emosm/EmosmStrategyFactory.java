package com.tencent.mobileqq.emosm;

import com.tencent.common.app.business.BaseQQAppInterface;

public final class EmosmStrategyFactory
{
  public static BaseEmosmStrategy a(BaseQQAppInterface paramBaseQQAppInterface, FavEmosmViewPage paramFavEmosmViewPage, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return new FavRoamingStrategy(paramBaseQQAppInterface, paramFavEmosmViewPage);
      }
      return new CameraRoamingStrategy(paramBaseQQAppInterface, paramFavEmosmViewPage);
    }
    return new FavRoamingStrategy(paramBaseQQAppInterface, paramFavEmosmViewPage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.EmosmStrategyFactory
 * JD-Core Version:    0.7.0.1
 */