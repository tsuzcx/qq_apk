package com.tencent.mobileqq.qqparticiple.impl;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qqparticiple.IParticipleAction;
import com.tencent.mobileqq.textpreview.ParticipleHandler;

public class ParticipleActionImpl
  implements IParticipleAction
{
  public void participleTheContent(String paramString)
  {
    QQAppInterface localQQAppInterface = AssistantUtils.a();
    if (localQQAppInterface != null) {
      ((ParticipleHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.PARTICIPLE_HANDLER)).a(localQQAppInterface, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqparticiple.impl.ParticipleActionImpl
 * JD-Core Version:    0.7.0.1
 */