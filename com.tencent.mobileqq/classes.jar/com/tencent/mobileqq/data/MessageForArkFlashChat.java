package com.tencent.mobileqq.data;

import com.tencent.ark.ark;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class MessageForArkFlashChat
  extends ChatMessage
{
  public ArkFlashChatContainerWrapper arkContainer;
  public ArkFlashChatMessage ark_app_message;
  public WeakReference<AutoStartProgressBar> mSendingProgress;
  
  protected void doParse()
  {
    ArkFlashChatMessage localArkFlashChatMessage = new ArkFlashChatMessage();
    if (this.msgData != null) {
      localArkFlashChatMessage.fromBytes(this.msgData);
    }
    this.ark_app_message = localArkFlashChatMessage;
    if (this.msg == null) {
      this.msg = this.ark_app_message.getSummery();
    }
  }
  
  public String getSummery()
  {
    ArkFlashChatMessage localArkFlashChatMessage = this.ark_app_message;
    if (localArkFlashChatMessage != null) {
      return localArkFlashChatMessage.getSummery();
    }
    return HardCodeUtil.a(2131904502);
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public void playAnim()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("testMyStopAnimLogic play ");
        localStringBuilder.append(this.ark_app_message.getMeta(this.uniseq, true));
        QLog.d("FlashChat", 2, localStringBuilder.toString());
      }
      ark.arkNotify(this.ark_app_message.appName, "UpdateAnimContent", this.ark_app_message.getMeta(this.uniseq, true), "json");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label76:
      break label76;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "arkNotify failed, .so not loaded");
    }
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    Object localObject = this.ark_app_message;
    if (localObject != null) {
      localObject = ((ArkFlashChatMessage)localObject).toBytes();
    } else {
      localObject = null;
    }
    this.msg = getSummery();
    this.msgData = ((byte[])localObject);
  }
  
  public void setParsed()
  {
    try
    {
      this.mIsParsed = true;
      return;
    }
    finally {}
  }
  
  public void setupSendLoading(AutoStartProgressBar paramAutoStartProgressBar)
  {
    this.mSendingProgress = new WeakReference(paramAutoStartProgressBar);
    ((AutoStartProgressBar)this.mSendingProgress.get()).setTag(this);
  }
  
  public void stopAnim()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("testMyStopAnimLogic stopAnim");
        localStringBuilder.append(this.ark_app_message.getMeta(this.uniseq, false));
        QLog.d("FlashChat", 2, localStringBuilder.toString());
      }
      ark.arkNotify(this.ark_app_message.appName, "UpdateAnimContent", this.ark_app_message.getMeta(this.uniseq, false), "json");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label76:
      break label76;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "arkNotify failed, .so not loaded");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForArkFlashChat
 * JD-Core Version:    0.7.0.1
 */