package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountMessageUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class MessageForPubAccount
  extends ChatMessage
{
  public static long INVALID_PUB_ACC_NUM;
  public long associatePubAccUin = INVALID_PUB_ACC_NUM;
  public PAMessage mPAMessage = null;
  
  public static String getMsgSummary(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    Object localObject2 = XMLMessageUtils.a(paramMessageRecord);
    Object localObject1;
    if ((localObject2 != null) && (((PAMessage)localObject2).items != null) && (((PAMessage)localObject2).items.size() != 0))
    {
      localObject1 = ((PAMessage.Item)((PAMessage)localObject2).items.get(0)).title;
      Object localObject3 = ((PAMessage.Item)((PAMessage)localObject2).items.get(0)).cover;
      if (paramBoolean) {
        paramMessageRecord = String.format(paramQQAppInterface.getApp().getString(2131697684), new Object[] { ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(paramQQAppInterface, BaseApplicationImpl.getContext()) });
      } else {
        paramMessageRecord = "";
      }
      if ((localObject3 == null) && (((PAMessage.Item)((PAMessage)localObject2).items.get(0)).digestList != null))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramMessageRecord);
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append("：");
        ((StringBuilder)localObject3).append((String)((PAMessage.Item)((PAMessage)localObject2).items.get(0)).digestList.get(0));
        paramMessageRecord = ((StringBuilder)localObject3).toString();
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramMessageRecord);
        ((StringBuilder)localObject2).append((String)localObject1);
        paramMessageRecord = ((StringBuilder)localObject2).toString();
      }
      localObject1 = paramMessageRecord;
      if (TextUtils.isEmpty(paramMessageRecord)) {
        return paramQQAppInterface.getApp().getString(2131694677);
      }
    }
    else
    {
      if ((localObject2 != null) && (((PAMessage)localObject2).msg != null)) {
        return ((PAMessage)localObject2).msg;
      }
      localObject1 = paramQQAppInterface.getApp().getString(2131694677);
    }
    return localObject1;
  }
  
  protected void doParse()
  {
    try
    {
      this.mPAMessage = ((PAMessage)((IPublicAccountMessageUtil)QRoute.api(IPublicAccountMessageUtil.class)).fromByteArray(this.msgData));
      if ((this.mPAMessage != null) && ((this.mPAMessage.items == null) || (this.mPAMessage.items.size() == 0)) && (this.mPAMessage.msg != null))
      {
        this.msg = this.mPAMessage.msg;
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean isTextMsg()
  {
    PAMessage localPAMessage = this.mPAMessage;
    if ((localPAMessage == null) || (localPAMessage.items == null) || (this.mPAMessage.items.size() == 0))
    {
      localPAMessage = this.mPAMessage;
      if ((localPAMessage != null) && (localPAMessage.msg != null)) {
        return true;
      }
    }
    return false;
  }
  
  protected void prewrite()
  {
    if (this.mPAMessage != null) {
      try
      {
        this.msgData = ((IPublicAccountMessageUtil)QRoute.api(IPublicAccountMessageUtil.class)).toByteArray(this.mPAMessage);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForPubAccount
 * JD-Core Version:    0.7.0.1
 */