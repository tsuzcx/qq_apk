package com.tencent.mobileqq.emoticonview.relateemo;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.RelatedEmoSearchObserver;
import com.tencent.mobileqq.app.RelatedEmoticonSearchHandler;
import com.tencent.mobileqq.data.ChatMessage;

public class RelatedEmoticonManager
{
  private BaseQQAppInterface mApp;
  private RelatedEmoticonManager.Callback mCallback;
  private RelatedEmoSearchObserver mObserver = new RelatedEmoticonManager.1(this);
  
  public RelatedEmoticonManager(BaseQQAppInterface paramBaseQQAppInterface, RelatedEmoticonManager.Callback paramCallback)
  {
    this.mApp = paramBaseQQAppInterface;
    this.mCallback = paramCallback;
    paramBaseQQAppInterface.addObserver(this.mObserver);
  }
  
  public void onDestroy()
  {
    this.mApp.removeObserver(this.mObserver);
  }
  
  public void searchRelatedEmoticon(ChatMessage paramChatMessage, int paramInt)
  {
    ((RelatedEmoticonSearchHandler)this.mApp.getBusinessHandler(RelatedEmoticonSearchHandler.a)).a(paramChatMessage, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoticonManager
 * JD-Core Version:    0.7.0.1
 */