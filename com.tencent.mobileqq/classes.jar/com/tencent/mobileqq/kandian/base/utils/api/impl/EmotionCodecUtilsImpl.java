package com.tencent.mobileqq.kandian.base.utils.api.impl;

import com.tencent.mobileqq.kandian.base.utils.api.IEmotionCodecUtils;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/utils/api/impl/EmotionCodecUtilsImpl;", "Lcom/tencent/mobileqq/kandian/base/utils/api/IEmotionCodecUtils;", "()V", "decodeQQEmotion", "", "content", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class EmotionCodecUtilsImpl
  implements IEmotionCodecUtils
{
  @Nullable
  public String decodeQQEmotion(@Nullable String paramString)
  {
    return EmotionCodecUtils.b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.api.impl.EmotionCodecUtilsImpl
 * JD-Core Version:    0.7.0.1
 */