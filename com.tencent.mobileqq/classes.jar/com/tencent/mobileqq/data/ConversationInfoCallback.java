package com.tencent.mobileqq.data;

public class ConversationInfoCallback
  implements ConversationInfo.Callback
{
  public void a(int paramInt, ConversationInfo paramConversationInfo)
  {
    ConversationInfoErrorReporter.reportTypeError(paramInt, paramConversationInfo.toString());
  }
  
  public void a(int paramInt, ConversationInfo paramConversationInfo, String paramString)
  {
    ConversationInfoErrorReporter.reportUnreadError(paramInt, paramConversationInfo.toString(), paramString);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    return ConversationInfoErrorReporter.reportPublicaccoutTypeError(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.ConversationInfoCallback
 * JD-Core Version:    0.7.0.1
 */