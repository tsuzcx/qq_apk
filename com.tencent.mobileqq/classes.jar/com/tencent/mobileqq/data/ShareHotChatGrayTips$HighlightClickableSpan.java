package com.tencent.mobileqq.data;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatShare;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.lang.ref.WeakReference;

class ShareHotChatGrayTips$HighlightClickableSpan
  extends ClickableSpan
{
  private HotChatShare jdField_a_of_type_ComTencentMobileqqAppHotChatShare;
  private ShareHotChatGrayTips jdField_a_of_type_ComTencentMobileqqDataShareHotChatGrayTips;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<Context> b;
  
  public ShareHotChatGrayTips$HighlightClickableSpan(QQAppInterface paramQQAppInterface, Context paramContext, ShareHotChatGrayTips paramShareHotChatGrayTips, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqDataShareHotChatGrayTips = paramShareHotChatGrayTips;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatShare = new HotChatShare((BaseActivity)paramContext, paramQQAppInterface, null);
  }
  
  public void onClick(View paramView)
  {
    paramView = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (((Context)this.b.get() != null) && (this.jdField_a_of_type_ComTencentMobileqqDataShareHotChatGrayTips != null))
    {
      paramView = ((HotChatManager)paramView.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqDataShareHotChatGrayTips.mTroopUin);
      this.jdField_a_of_type_ComTencentMobileqqAppHotChatShare.a(paramView);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.ShareHotChatGrayTips.HighlightClickableSpan
 * JD-Core Version:    0.7.0.1
 */