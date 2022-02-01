package com.tencent.mobileqq.hotchat.data;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.hotchat.api.IHotChatApi;
import com.tencent.mobileqq.hotchat.api.IHotChatShare;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.ref.WeakReference;
import mqq.app.AppActivity;

class ShareHotChatGrayTips$HighlightClickableSpan
  extends ClickableSpan
{
  private WeakReference<QQAppInterface> a;
  private WeakReference<Context> b;
  private ShareHotChatGrayTips c;
  private String d;
  private IHotChatShare e;
  
  public ShareHotChatGrayTips$HighlightClickableSpan(QQAppInterface paramQQAppInterface, Context paramContext, ShareHotChatGrayTips paramShareHotChatGrayTips, String paramString)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramContext);
    this.c = paramShareHotChatGrayTips;
    this.d = paramString;
    this.e = ((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatShare((AppActivity)paramContext, paramQQAppInterface, null);
  }
  
  public void onClick(View paramView)
  {
    paramView = (QQAppInterface)this.a.get();
    if (((Context)this.b.get() != null) && (this.c != null))
    {
      paramView = ((HotChatManager)paramView.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).c(this.c.mTroopUin);
      this.e.handleShare(paramView);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.data.ShareHotChatGrayTips.HighlightClickableSpan
 * JD-Core Version:    0.7.0.1
 */