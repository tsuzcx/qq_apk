package com.tencent.mobileqq.emoticon.api.impl;

import android.app.Activity;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.emoticon.ISogouEmoji;
import com.tencent.mobileqq.emoticon.SogouEmoji;
import com.tencent.mobileqq.emoticon.api.ISogouEmojiService;

public class SogouEmojiServiceImpl
  implements ISogouEmojiService
{
  public ISogouEmoji createSogouEmoji(BaseAIOContext paramBaseAIOContext, Activity paramActivity, BaseQQAppInterface paramBaseQQAppInterface)
  {
    return new SogouEmoji(paramBaseAIOContext, paramActivity, paramBaseQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.api.impl.SogouEmojiServiceImpl
 * JD-Core Version:    0.7.0.1
 */