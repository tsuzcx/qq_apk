package com.tencent.mobileqq.kandian.repo.aladdin;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;

public class RIJKanDianAIOVideoAutoPlayAladdinConfig
{
  public static boolean a()
  {
    return Aladdin.getConfig(375).getIntegerFromString("aio_kandian_video_preview_autoplay_enable", 1) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.RIJKanDianAIOVideoAutoPlayAladdinConfig
 * JD-Core Version:    0.7.0.1
 */