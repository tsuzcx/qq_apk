package com.tencent.mobileqq.richmediabrowser.api.impl;

import android.content.Context;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richmediabrowser.api.ICommentDanmakuDepend;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;

public class CommentDanmakuDependImpl
  implements ICommentDanmakuDepend
{
  public TextView createETTextView(Context paramContext, String paramString, int paramInt1, int paramInt2, float paramFloat)
  {
    paramContext = new ETTextView(paramContext);
    paramContext.setText(new QQText(paramString, 3, paramInt1));
    paramContext.setTextColor(paramInt2);
    paramContext.setAlpha(paramFloat);
    return paramContext;
  }
  
  public boolean getAioAnonymousStatus(String paramString)
  {
    return AnonymousChatHelper.a().a(paramString);
  }
  
  public int getAnonymousHeadId(String paramString)
  {
    paramString = AnonymousChatHelper.a().a(paramString);
    if (paramString != null) {
      return paramString.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public String getAnonymousHeadUrl(int paramInt)
  {
    return AnonymousChatHelper.a(paramInt);
  }
  
  public String getAnonymousNickName(String paramString)
  {
    paramString = AnonymousChatHelper.a().a(paramString);
    if (paramString != null) {
      return paramString.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public int getChatEmotionSizeWithDP()
  {
    return ChatTextSizeSettingActivity.a();
  }
  
  public String getTroopMemberName(String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    return ContactUtils.b(localQQAppInterface, String.valueOf(paramString), localQQAppInterface.getAccount());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.api.impl.CommentDanmakuDependImpl
 * JD-Core Version:    0.7.0.1
 */