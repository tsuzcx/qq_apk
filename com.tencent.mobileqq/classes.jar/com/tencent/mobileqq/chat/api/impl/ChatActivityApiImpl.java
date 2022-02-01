package com.tencent.mobileqq.chat.api.impl;

import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.chat.api.IChatActivityApi;

public class ChatActivityApiImpl
  implements IChatActivityApi
{
  public int FORWARD_REQUEST()
  {
    return 21;
  }
  
  public String KEY_AIO_MSG_SOURCE()
  {
    return "aio_msg_source";
  }
  
  public String OPEN_CHAT_FRAGMENT()
  {
    return "open_chatfragment";
  }
  
  public int TYPE_DETAIL_MSG_REMIND()
  {
    return 3;
  }
  
  public Class getChatActivityClass()
  {
    return ChatActivity.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.chat.api.impl.ChatActivityApiImpl
 * JD-Core Version:    0.7.0.1
 */