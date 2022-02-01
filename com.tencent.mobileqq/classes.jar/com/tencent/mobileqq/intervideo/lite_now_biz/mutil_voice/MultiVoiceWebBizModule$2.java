package com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice;

import androidx.lifecycle.Observer;
import com.google.gson.JsonObject;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.event.MultiVoicePageEvent;

class MultiVoiceWebBizModule$2
  implements Observer<MultiVoicePageEvent>
{
  MultiVoiceWebBizModule$2(MultiVoiceWebBizModule paramMultiVoiceWebBizModule) {}
  
  public void a(MultiVoicePageEvent paramMultiVoicePageEvent)
  {
    if (paramMultiVoicePageEvent.a == 3)
    {
      MultiVoiceWebBizModule.b(this.a).callJs("_CLICK_FLOATINGWINDOW", new String[] { new JsonObject().toString() });
      return;
    }
    if (paramMultiVoicePageEvent.a == 2) {
      MultiVoiceWebBizModule.c(this.a).callJs("_ONANDROID_BACK", new String[] { new JsonObject().toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.MultiVoiceWebBizModule.2
 * JD-Core Version:    0.7.0.1
 */