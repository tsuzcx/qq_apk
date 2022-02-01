package com.tencent.mobileqq.emoticonview.api.impl;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.EmoAddedAuthCallback;
import com.tencent.mobileqq.emoticonview.api.IEmoAddedAuthCallbackService;
import com.tencent.mobileqq.pic.UpCallBack;

public class EmoAddedAuthCallbackServiceImpl
  implements IEmoAddedAuthCallbackService
{
  public UpCallBack createEmoAddedAuthCallback(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, CustomEmotionData paramCustomEmotionData, Object paramObject, int paramInt)
  {
    return new EmoAddedAuthCallback(paramBaseQQAppInterface, paramContext, paramCustomEmotionData, paramObject, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.EmoAddedAuthCallbackServiceImpl
 * JD-Core Version:    0.7.0.1
 */