package com.tencent.mobileqq.pic.aio;

import com.tencent.mobileqq.activity.aio.item.BasePicItemBuilder.DrawURL;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.data.MessageForPic;

public final class AIOPicThumbDrawableObject$Builder
{
  MessageForPic a;
  ChatThumbView b;
  int[] c;
  BasePicItemBuilder.DrawURL d;
  
  public AIOPicThumbDrawableObject$Builder(MessageForPic paramMessageForPic)
  {
    this.a = paramMessageForPic;
  }
  
  public Builder a(BasePicItemBuilder.DrawURL paramDrawURL)
  {
    this.d = paramDrawURL;
    return this;
  }
  
  public Builder a(ChatThumbView paramChatThumbView)
  {
    this.b = paramChatThumbView;
    return this;
  }
  
  public Builder a(int[] paramArrayOfInt)
  {
    this.c = paramArrayOfInt;
    return this;
  }
  
  public AIOPicThumbDrawableObject a()
  {
    return new AIOPicThumbDrawableObject(this, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.aio.AIOPicThumbDrawableObject.Builder
 * JD-Core Version:    0.7.0.1
 */