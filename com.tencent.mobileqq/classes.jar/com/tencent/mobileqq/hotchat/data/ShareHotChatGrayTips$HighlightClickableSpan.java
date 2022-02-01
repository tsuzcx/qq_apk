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
  private IHotChatShare jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatShare;
  private ShareHotChatGrayTips jdField_a_of_type_ComTencentMobileqqHotchatDataShareHotChatGrayTips;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<Context> b;
  
  public ShareHotChatGrayTips$HighlightClickableSpan(QQAppInterface paramQQAppInterface, Context paramContext, ShareHotChatGrayTips paramShareHotChatGrayTips, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqHotchatDataShareHotChatGrayTips = paramShareHotChatGrayTips;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatShare = ((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatShare((AppActivity)paramContext, paramQQAppInterface, null);
  }
  
  public void onClick(View paramView)
  {
    paramView = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (((Context)this.b.get() != null) && (this.jdField_a_of_type_ComTencentMobileqqHotchatDataShareHotChatGrayTips != null))
    {
      paramView = ((HotChatManager)paramView.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqHotchatDataShareHotChatGrayTips.mTroopUin);
      this.jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatShare.handleShare(paramView);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.data.ShareHotChatGrayTips.HighlightClickableSpan
 * JD-Core Version:    0.7.0.1
 */