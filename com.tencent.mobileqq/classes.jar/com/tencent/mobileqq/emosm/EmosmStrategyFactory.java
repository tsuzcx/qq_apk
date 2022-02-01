package com.tencent.mobileqq.emosm;

import com.tencent.mobileqq.app.QQAppInterface;

public final class EmosmStrategyFactory
{
  public static BaseEmosmStrategy a(QQAppInterface paramQQAppInterface, FavEmosmViewPage paramFavEmosmViewPage, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new FavRoamingStrategy(paramQQAppInterface, paramFavEmosmViewPage);
    case 0: 
      return new FavRoamingStrategy(paramQQAppInterface, paramFavEmosmViewPage);
    }
    return new CameraRoamingStrategy(paramQQAppInterface, paramFavEmosmViewPage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.EmosmStrategyFactory
 * JD-Core Version:    0.7.0.1
 */