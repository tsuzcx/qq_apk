package com.tencent.mobileqq.emoticonview.relateemo;

import anab;
import anac;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

public class RelatedEmoticonManager
{
  private QQAppInterface mApp;
  private RelatedEmoticonManager.Callback mCallback;
  private anab mObserver = new RelatedEmoticonManager.1(this);
  
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
    ((anac)this.mApp.getBusinessHandler(180)).a(paramChatMessage, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoticonManager
 * JD-Core Version:    0.7.0.1
 */