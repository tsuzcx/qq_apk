package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.utils.httputils.HttpMsg;
import java.util.ArrayList;
import java.util.LinkedList;

public class PriorityQueue
{
  public static final int PRIORITY_BASE = 200;
  public static final int PRIORITY_HIGH = 200;
  public static final int PRIORITY_LOW = 202;
  public static final int PRIORITY_NOMRAL = 201;
  public static final int PRIORITY_NUMBER = 3;
  public int mInQueueMsgNums;
  private ArrayList<LinkedList<HttpMsg>> mSendQueues;
  
  public PriorityQueue()
  {
    int i = 0;
    this.mInQueueMsgNums = 0;
    this.mSendQueues = new ArrayList();
    while (i < 3)
    {
      this.mSendQueues.add(new LinkedList());
      i += 1;
    }
  }
  
  public void addMsg(HttpMsg paramHttpMsg)
  {
    if (paramHttpMsg == null) {
      return;
    }
    int i = paramHttpMsg.getPriority() - 200;
    if ((i >= 0) && (i < this.mSendQueues.size()))
    {
      ((LinkedList)this.mSendQueues.get(i)).add(paramHttpMsg);
      this.mInQueueMsgNums += 1;
    }
  }
  
  public void clearMsgs()
  {
    int i = 0;
    while (i < this.mSendQueues.size())
    {
      ((LinkedList)this.mSendQueues.get(i)).clear();
      i += 1;
    }
    this.mInQueueMsgNums = 0;
  }
  
  public String getFullSendQueue()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < this.mSendQueues.size())
    {
      int j = 0;
      while (j < ((LinkedList)this.mSendQueues.get(i)).size())
      {
        localStringBuilder.append(((HttpMsg)((LinkedList)this.mSendQueues.get(i)).get(j)).getRealUrl());
        localStringBuilder.append("\r\n");
        j += 1;
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public HttpMsg getMaxPriortyMsg(boolean paramBoolean)
  {
    int i = 0;
    while (i < this.mSendQueues.size())
    {
      if (((LinkedList)this.mSendQueues.get(i)).size() != 0)
      {
        if (paramBoolean)
        {
          HttpMsg localHttpMsg = (HttpMsg)((LinkedList)this.mSendQueues.get(i)).remove(0);
          this.mInQueueMsgNums -= 1;
          return localHttpMsg;
        }
        return (HttpMsg)((LinkedList)this.mSendQueues.get(i)).get(0);
      }
      i += 1;
    }
    return null;
  }
  
  public int getQueueMsgNums()
  {
    return this.mInQueueMsgNums;
  }
  
  public boolean removeHttpMsg(HttpMsg paramHttpMsg)
  {
    int i = 0;
    while (i < this.mSendQueues.size())
    {
      if (((LinkedList)this.mSendQueues.get(i)).remove(paramHttpMsg))
      {
        this.mInQueueMsgNums -= 1;
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.PriorityQueue
 * JD-Core Version:    0.7.0.1
 */