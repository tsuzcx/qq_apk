package com.tencent.tkd.comment.panel.emoji;

import com.tencent.tkd.comment.panel.bridge.emoji.IEmoJiEmotionBridge;
import com.tencent.tkd.comment.panel.emoji.data.EmoJiEmotionDataSource;
import org.jetbrains.annotations.NotNull;

public class EmoJiEmotionPanelManager
{
  @NotNull
  private EmoJiEmotionDataSource a = new EmoJiEmotionDataSource();
  private IEmoJiEmotionBridge b;
  
  public static EmoJiEmotionPanelManager a()
  {
    return EmoJiEmotionPanelManager.InstanceHolder.a();
  }
  
  public void a(@NotNull IEmoJiEmotionBridge paramIEmoJiEmotionBridge)
  {
    this.b = paramIEmoJiEmotionBridge;
  }
  
  @NotNull
  public EmoJiEmotionDataSource b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.comment.panel.emoji.EmoJiEmotionPanelManager
 * JD-Core Version:    0.7.0.1
 */