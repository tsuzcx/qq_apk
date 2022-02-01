package com.tencent.mobileqq.emoticonview.relateemo;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;

public abstract interface IRelatedEmotionPanel
{
  public abstract void init(BaseQQAppInterface paramBaseQQAppInterface, EmoticonCallback paramEmoticonCallback, IAIORelatedEmotionExpandHelper paramIAIORelatedEmotionExpandHelper);
  
  public abstract void showEmotionSearchWindow(ChatMessage paramChatMessage, URLDrawable paramURLDrawable, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.relateemo.IRelatedEmotionPanel
 * JD-Core Version:    0.7.0.1
 */