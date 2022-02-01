package com.tencent.mobileqq.data;

import java.util.List;

public class ChatHistorySearchData
{
  public List<MessageRecord> mSearchData1;
  public List<Integer> mSearchData2;
  public int offset = 0;
  
  public String toString()
  {
    return "ChatHistorySearchData{mSearchData1=" + this.mSearchData1 + ", mSearchData2=" + this.mSearchData2 + ", offset=" + this.offset + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.ChatHistorySearchData
 * JD-Core Version:    0.7.0.1
 */