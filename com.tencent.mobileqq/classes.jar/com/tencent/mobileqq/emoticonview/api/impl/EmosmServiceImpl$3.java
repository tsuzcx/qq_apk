package com.tencent.mobileqq.emoticonview.api.impl;

import com.tencent.mobileqq.emoticonview.api.IEmosmService.GIFCreatorCallback;
import dov.com.qq.im.ae.current.GIFCreator.Callback;

class EmosmServiceImpl$3
  implements GIFCreator.Callback
{
  EmosmServiceImpl$3(EmosmServiceImpl paramEmosmServiceImpl, IEmosmService.GIFCreatorCallback paramGIFCreatorCallback) {}
  
  public void onGifCreateFail()
  {
    IEmosmService.GIFCreatorCallback localGIFCreatorCallback = this.val$callback;
    if (localGIFCreatorCallback != null) {
      localGIFCreatorCallback.onGifCreateFail();
    }
  }
  
  public void onGifCreateSuccess(String paramString)
  {
    IEmosmService.GIFCreatorCallback localGIFCreatorCallback = this.val$callback;
    if (localGIFCreatorCallback != null) {
      localGIFCreatorCallback.onGifCreateSuccess(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.EmosmServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */