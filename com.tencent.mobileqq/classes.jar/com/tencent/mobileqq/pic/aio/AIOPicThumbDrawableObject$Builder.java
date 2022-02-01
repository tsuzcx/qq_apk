package com.tencent.mobileqq.pic.aio;

import com.tencent.mobileqq.activity.aio.item.BasePicItemBuilder.DrawURL;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.data.MessageForPic;

public final class AIOPicThumbDrawableObject$Builder
{
  BasePicItemBuilder.DrawURL jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$DrawURL;
  ChatThumbView jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView;
  MessageForPic jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
  int[] jdField_a_of_type_ArrayOfInt;
  
  public AIOPicThumbDrawableObject$Builder(MessageForPic paramMessageForPic)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramMessageForPic;
  }
  
  public Builder a(BasePicItemBuilder.DrawURL paramDrawURL)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$DrawURL = paramDrawURL;
    return this;
  }
  
  public Builder a(ChatThumbView paramChatThumbView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView = paramChatThumbView;
    return this;
  }
  
  public Builder a(int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    return this;
  }
  
  public AIOPicThumbDrawableObject a()
  {
    return new AIOPicThumbDrawableObject(this, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.aio.AIOPicThumbDrawableObject.Builder
 * JD-Core Version:    0.7.0.1
 */