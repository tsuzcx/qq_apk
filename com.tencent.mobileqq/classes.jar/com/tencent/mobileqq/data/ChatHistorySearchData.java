package com.tencent.mobileqq.data;

import java.util.List;

public class ChatHistorySearchData
{
  public List<MessageRecord> mSearchData1;
  public List<Integer> mSearchData2;
  public int offset = 0;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ChatHistorySearchData{mSearchData1=");
    localStringBuilder.append(this.mSearchData1);
    localStringBuilder.append(", mSearchData2=");
    localStringBuilder.append(this.mSearchData2);
    localStringBuilder.append(", offset=");
    localStringBuilder.append(this.offset);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.ChatHistorySearchData
 * JD-Core Version:    0.7.0.1
 */