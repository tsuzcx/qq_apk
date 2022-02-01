package com.tencent.mobileqq.emoticonview.relateemo;

import aocq;
import aocr;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

public class RelatedEmoticonManager
{
  private QQAppInterface mApp;
  private RelatedEmoticonManager.Callback mCallback;
  private aocq mObserver = new RelatedEmoticonManager.1(this);
  
  public RelatedEmoticonManager(QQAppInterface paramQQAppInterface, RelatedEmoticonManager.Callback paramCallback)
  {
    this.mApp = paramQQAppInterface;
    this.mCallback = paramCallback;
    paramQQAppInterface.addObserver(this.mObserver);
  }
  
  public void onDestroy()
  {
    this.mApp.removeObserver(this.mObserver);
  }
  
  public void searchRelatedEmoticon(ChatMessage paramChatMessage, int paramInt)
  {
    ((aocr)this.mApp.getBusinessHandler(BusinessHandlerFactory.RELATED_EMOTION_HANDLER)).a(paramChatMessage, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoticonManager
 * JD-Core Version:    0.7.0.1
 */