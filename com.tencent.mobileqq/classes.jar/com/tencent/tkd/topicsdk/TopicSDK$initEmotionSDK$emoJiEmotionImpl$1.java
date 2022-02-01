package com.tencent.tkd.topicsdk;

import android.graphics.drawable.Drawable;
import com.tencent.tkd.comment.panel.bridge.emoji.IQbEmoJiEmotion;
import com.tencent.tkd.topicsdk.interfaces.IEmoJiEmotion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/TopicSDK$initEmotionSDK$emoJiEmotionImpl$1", "Lcom/tencent/tkd/comment/panel/bridge/emoji/IQbEmoJiEmotion;", "getEmoJiDrawable", "Landroid/graphics/drawable/Drawable;", "resourceId", "", "getEmoJiResourceArray", "", "getEmoJiShowNameArray", "", "", "()[Ljava/lang/String;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class TopicSDK$initEmotionSDK$emoJiEmotionImpl$1
  implements IQbEmoJiEmotion
{
  TopicSDK$initEmotionSDK$emoJiEmotionImpl$1(TopicSDKConfig paramTopicSDKConfig) {}
  
  @Nullable
  public Drawable getEmoJiDrawable(int paramInt)
  {
    return this.a.r().a(paramInt);
  }
  
  @NotNull
  public int[] getEmoJiResourceArray()
  {
    int[] arrayOfInt = this.a.r().b();
    Intrinsics.checkExpressionValueIsNotNull(arrayOfInt, "topicSDKConfig.emoJiEmotion.emoJiResourceArray");
    return arrayOfInt;
  }
  
  @NotNull
  public String[] getEmoJiShowNameArray()
  {
    String[] arrayOfString = this.a.r().a();
    Intrinsics.checkExpressionValueIsNotNull(arrayOfString, "topicSDKConfig.emoJiEmotion.emoJiShowNameArray");
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.TopicSDK.initEmotionSDK.emoJiEmotionImpl.1
 * JD-Core Version:    0.7.0.1
 */