package com.tencent.mobileqq.utils.httputils;

import bfuc;
import java.util.ArrayList;
import java.util.LinkedList;

public class HttpCommunicator$PriorityQueue
{
  public static final int PriorityBase = 200;
  public static final int PriorityHigh = 200;
  public static final int PriorityLow = 202;
  public static final int PriorityNomral = 201;
  public static final int PriorityNumber = 3;
  public int mInQueueMsgNums;
  private ArrayList<LinkedList<HttpMsg>> mSendQueues = new ArrayList();
  
  public HttpCommunicator$PriorityQueue()
  {
    int i = 0;
    while (i < 3)
    {
      this.mSendQueues.add(new LinkedList());
      i += 1;
    }
  }
  
  public void addMsg(HttpMsg paramHttpMsg)
  {
    if (paramHttpMsg == null) {}
    int i;
    do
    {
      return;
      i = paramHttpMsg.getPriority() - 200;
    } while ((i < 0) || (i >= this.mSendQueues.size()));
    ((LinkedList)this.mSendQueues.get(i)).add(paramHttpMsg);
    this.mInQueueMsgNums += 1;
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
        localStringBuilder.append(bfuc.encodeToString(((HttpMsg)((LinkedList)this.mSendQueues.get(i)).get(j)).getRealUrl().getBytes(), 0));
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
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.mSendQueues.size())
      {
        if (((LinkedList)this.mSendQueues.get(i)).remove(paramHttpMsg))
        {
          this.mInQueueMsgNums -= 1;
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.httputils.HttpCommunicator.PriorityQueue
 * JD-Core Version:    0.7.0.1
 */