package com.tencent.mobileqq.multimsg;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiMsgRequest
{
  public SessionInfo a;
  public List<ChatMessage> b;
  public Map<String, String> c;
  public AbsStructMsg d;
  public MessageForStructing e;
  public HashMap<String, ArrayList<MessageRecord>> f;
  public List<MessageForStructing> g;
  public int h;
  public int i;
  public int j;
  public int k;
  public int l;
  public int m;
  public int n;
  public boolean o;
  private int p;
  private Object q = new Object();
  private int r;
  
  public String a()
  {
    return String.valueOf(hashCode());
  }
  
  public void a(int paramInt)
  {
    synchronized (this.q)
    {
      this.p = (paramInt ^ this.p);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    synchronized (this.q)
    {
      int i1 = this.r;
      if (paramInt1 == 0) {
        paramInt2 = 0;
      }
      this.r = (i1 + paramInt2);
      return;
    }
  }
  
  public int b()
  {
    synchronized (this.q)
    {
      int i1 = this.p;
      return i1;
    }
  }
  
  public int c()
  {
    synchronized (this.q)
    {
      int i1 = this.r;
      return i1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.MultiMsgRequest
 * JD-Core Version:    0.7.0.1
 */