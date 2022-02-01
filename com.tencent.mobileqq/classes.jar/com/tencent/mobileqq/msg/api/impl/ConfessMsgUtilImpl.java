package com.tencent.mobileqq.msg.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IConfessMsgUtil;

public class ConfessMsgUtilImpl
  implements IConfessMsgUtil
{
  public void bindC2CFirstMsgConfessInfo(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      ConfessMsgUtil.a((QQAppInterface)paramBaseQQAppInterface, paramMessageRecord, paramString);
    }
  }
  
  public void bindConfessInfo(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord, String paramString, int paramInt1, int paramInt2)
  {
    ConfessMsgUtil.a((QQAppInterface)paramBaseQQAppInterface, paramMessageRecord, paramString, paramInt1, paramInt2);
  }
  
  public void bindGroupFirstMsgConfessInfo(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      ConfessMsgUtil.b((QQAppInterface)paramBaseQQAppInterface, paramMessageRecord, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msg.api.impl.ConfessMsgUtilImpl
 * JD-Core Version:    0.7.0.1
 */