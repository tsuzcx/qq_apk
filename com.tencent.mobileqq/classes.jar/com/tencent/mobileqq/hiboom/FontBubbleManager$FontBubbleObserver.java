package com.tencent.mobileqq.hiboom;

import QC.SetFontBubbleRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.SVIPObserver;
import java.lang.ref.WeakReference;

public class FontBubbleManager$FontBubbleObserver
  extends SVIPObserver
{
  private WeakReference<BaseChatPie> a;
  
  public FontBubbleManager$FontBubbleObserver(BaseChatPie paramBaseChatPie)
  {
    this.a = new WeakReference(paramBaseChatPie);
  }
  
  public void onFontBubblePaySuccess(Bundle paramBundle)
  {
    BaseChatPie localBaseChatPie = (BaseChatPie)this.a.get();
    if (localBaseChatPie != null) {
      FontBubbleManager.a(localBaseChatPie.a).a(localBaseChatPie, paramBundle);
    }
  }
  
  public void onSetFontBubble(boolean paramBoolean, SetFontBubbleRsp paramSetFontBubbleRsp, int paramInt)
  {
    BaseChatPie localBaseChatPie = (BaseChatPie)this.a.get();
    if (localBaseChatPie != null) {
      FontBubbleManager.a(localBaseChatPie.a).a(localBaseChatPie, paramBoolean, paramSetFontBubbleRsp, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontBubbleManager.FontBubbleObserver
 * JD-Core Version:    0.7.0.1
 */