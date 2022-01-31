package com.tencent.mobileqq.data;

import com.tencent.ark.ark;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper;
import com.tencent.qphone.base.util.QLog;

public class MessageForArkFlashChat
  extends ChatMessage
{
  public ArkFlashChatContainerWrapper arkContainer;
  public ArkFlashChatMessage ark_app_message;
  
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
    if (this.ark_app_message != null) {
      return this.ark_app_message.getSummery();
    }
    return "[轻应用]";
  }
  
  public void playAnim()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("FlashChat", 2, "testMyStopAnimLogic play " + this.ark_app_message.getMeta(this.uniseq, true));
      }
      ark.arkNotify(this.ark_app_message.appName, "UpdateAnimContent", this.ark_app_message.getMeta(this.uniseq, true), "json");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FlashChat", 2, "arkNotify failed, .so not loaded");
    }
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    byte[] arrayOfByte = null;
    if (this.ark_app_message != null) {
      arrayOfByte = this.ark_app_message.toBytes();
    }
    this.msg = getSummery();
    this.msgData = arrayOfByte;
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
  
  public void stopAnim()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("FlashChat", 2, "testMyStopAnimLogic stopAnim" + this.ark_app_message.getMeta(this.uniseq, false));
      }
      ark.arkNotify(this.ark_app_message.appName, "UpdateAnimContent", this.ark_app_message.getMeta(this.uniseq, false), "json");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FlashChat", 2, "arkNotify failed, .so not loaded");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForArkFlashChat
 * JD-Core Version:    0.7.0.1
 */