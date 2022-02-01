package com.tencent.mobileqq.mixedmsg;

public class MixedMsgInfo$PhotoMsgNode
  extends MixedMsgInfo.MsgNode
{
  public static final String PHOTO_TAG = "[图片]";
  private MixedMsgInfo.PhotoItem photoItem;
  
  public MixedMsgInfo$PhotoMsgNode(MixedMsgInfo.PhotoItem paramPhotoItem)
  {
    this.photoItem = paramPhotoItem;
  }
  
  public MixedMsgInfo.PhotoItem getPhotoItem()
  {
    return this.photoItem;
  }
  
  public String text()
  {
    return "[图片]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mixedmsg.MixedMsgInfo.PhotoMsgNode
 * JD-Core Version:    0.7.0.1
 */