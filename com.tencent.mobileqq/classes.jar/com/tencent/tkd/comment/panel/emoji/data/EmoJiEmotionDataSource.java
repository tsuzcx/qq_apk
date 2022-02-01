package com.tencent.tkd.comment.panel.emoji.data;

import android.graphics.drawable.Drawable;
import com.tencent.tkd.comment.panel.base.data.IEmotionDataSource;
import com.tencent.tkd.comment.panel.bridge.emoji.IEmoJiEmotionBridge;
import com.tencent.tkd.comment.panel.bridge.emoji.IQbEmoJiEmotion;
import com.tencent.tkd.comment.panel.emoji.EmoJiEmotionPanelManager;
import com.tencent.tkd.comment.panel.model.EmoJiEmotion;
import com.tencent.tkd.comment.panel.model.Emotion;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.Nullable;

public class EmoJiEmotionDataSource
  implements IEmotionDataSource
{
  private IQbEmoJiEmotion jdField_a_of_type_ComTencentTkdCommentPanelBridgeEmojiIQbEmoJiEmotion;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private Emotion[] jdField_a_of_type_ArrayOfComTencentTkdCommentPanelModelEmotion;
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentTkdCommentPanelBridgeEmojiIQbEmoJiEmotion != null)
    {
      int[] arrayOfInt = this.jdField_a_of_type_ComTencentTkdCommentPanelBridgeEmojiIQbEmoJiEmotion.getEmoJiResourceArray();
      String[] arrayOfString = this.jdField_a_of_type_ComTencentTkdCommentPanelBridgeEmojiIQbEmoJiEmotion.getEmoJiShowNameArray();
      int j = Math.min(arrayOfInt.length, arrayOfString.length);
      if (j > 0)
      {
        this.jdField_a_of_type_ArrayOfComTencentTkdCommentPanelModelEmotion = new Emotion[j];
        int i = 0;
        while (i < j)
        {
          Emotion localEmotion = new Emotion(0, new EmoJiEmotion(arrayOfString[i], arrayOfInt[i]));
          this.jdField_a_of_type_ArrayOfComTencentTkdCommentPanelModelEmotion[i] = localEmotion;
          i += 1;
        }
      }
    }
  }
  
  @Nullable
  public Drawable a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentTkdCommentPanelBridgeEmojiIQbEmoJiEmotion != null) {
      return this.jdField_a_of_type_ComTencentTkdCommentPanelBridgeEmojiIQbEmoJiEmotion.getEmoJiDrawable(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      this.jdField_a_of_type_ComTencentTkdCommentPanelBridgeEmojiIQbEmoJiEmotion = EmoJiEmotionPanelManager.a().a().getQbEmoJiEmotionImpl();
      b();
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
  }
  
  @Nullable
  public Emotion[] a()
  {
    a();
    return this.jdField_a_of_type_ArrayOfComTencentTkdCommentPanelModelEmotion;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.comment.panel.emoji.data.EmoJiEmotionDataSource
 * JD-Core Version:    0.7.0.1
 */