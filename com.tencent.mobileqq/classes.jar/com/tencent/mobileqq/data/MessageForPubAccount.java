package com.tencent.mobileqq.data;

import agkq;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;
import txr;
import tyi;

public class MessageForPubAccount
  extends ChatMessage
{
  public static long INVALID_PUB_ACC_NUM;
  public long associatePubAccUin = INVALID_PUB_ACC_NUM;
  public PAMessage mPAMessage;
  
  public static String getMsgSummary(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    Object localObject = agkq.a(paramMessageRecord);
    if ((localObject == null) || (((PAMessage)localObject).items == null) || (((PAMessage)localObject).items.size() == 0))
    {
      if ((localObject != null) && (((PAMessage)localObject).msg != null))
      {
        localObject = ((PAMessage)localObject).msg;
        return localObject;
      }
      return paramQQAppInterface.getApp().getString(2131694184);
    }
    String str1 = ((PAMessage.Item)((PAMessage)localObject).items.get(0)).title;
    String str2 = ((PAMessage.Item)((PAMessage)localObject).items.get(0)).cover;
    if (paramBoolean) {}
    for (paramMessageRecord = String.format(paramQQAppInterface.getApp().getString(2131697005), new Object[] { tyi.a(paramQQAppInterface, BaseApplicationImpl.getContext()) });; paramMessageRecord = "")
    {
      if ((str2 == null) && (((PAMessage.Item)((PAMessage)localObject).items.get(0)).digestList != null)) {}
      for (paramMessageRecord = paramMessageRecord + str1 + "：" + (String)((PAMessage.Item)((PAMessage)localObject).items.get(0)).digestList.get(0);; paramMessageRecord = paramMessageRecord + str1)
      {
        localObject = paramMessageRecord;
        if (!TextUtils.isEmpty(paramMessageRecord)) {
          break;
        }
        return paramQQAppInterface.getApp().getString(2131694184);
      }
    }
  }
  
  protected void doParse()
  {
    try
    {
      this.mPAMessage = txr.a(this.msgData);
      if ((this.mPAMessage != null) && ((this.mPAMessage.items == null) || (this.mPAMessage.items.size() == 0)) && (this.mPAMessage.msg != null)) {
        this.msg = this.mPAMessage.msg;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean isTextMsg()
  {
    return ((this.mPAMessage == null) || (this.mPAMessage.items == null) || (this.mPAMessage.items.size() == 0)) && (this.mPAMessage != null) && (this.mPAMessage.msg != null);
  }
  
  public void prewrite()
  {
    if (this.mPAMessage != null) {}
    try
    {
      this.msgData = txr.a(this.mPAMessage);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForPubAccount
 * JD-Core Version:    0.7.0.1
 */