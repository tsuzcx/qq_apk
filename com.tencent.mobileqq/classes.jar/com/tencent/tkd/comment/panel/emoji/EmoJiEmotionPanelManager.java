package com.tencent.tkd.comment.panel.emoji;

import com.tencent.tkd.comment.panel.bridge.emoji.IEmoJiEmotionBridge;
import com.tencent.tkd.comment.panel.emoji.data.EmoJiEmotionDataSource;
import org.jetbrains.annotations.NotNull;

public class EmoJiEmotionPanelManager
{
  private IEmoJiEmotionBridge jdField_a_of_type_ComTencentTkdCommentPanelBridgeEmojiIEmoJiEmotionBridge;
  @NotNull
  private EmoJiEmotionDataSource jdField_a_of_type_ComTencentTkdCommentPanelEmojiDataEmoJiEmotionDataSource = new EmoJiEmotionDataSource();
  
  public static EmoJiEmotionPanelManager a()
  {
    return EmoJiEmotionPanelManager.InstanceHolder.a();
  }
  
  public IEmoJiEmotionBridge a()
  {
    return this.jdField_a_of_type_ComTencentTkdCommentPanelBridgeEmojiIEmoJiEmotionBridge;
  }
  
  @NotNull
  public EmoJiEmotionDataSource a()
  {
    return this.jdField_a_of_type_ComTencentTkdCommentPanelEmojiDataEmoJiEmotionDataSource;
  }
  
  public void a(@NotNull IEmoJiEmotionBridge paramIEmoJiEmotionBridge)
  {
    this.jdField_a_of_type_ComTencentTkdCommentPanelBridgeEmojiIEmoJiEmotionBridge = paramIEmoJiEmotionBridge;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.comment.panel.emoji.EmoJiEmotionPanelManager
 * JD-Core Version:    0.7.0.1
 */