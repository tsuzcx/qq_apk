package com.tencent.mobileqq.mixedmsg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MixedMsgInfo
{
  private List<MixedMsgInfo.MsgNode> a = new ArrayList(41);
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < this.a.size())
    {
      localStringBuilder.append(((MixedMsgInfo.MsgNode)this.a.get(i)).text());
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public List<MixedMsgInfo.MsgNode> a()
  {
    return this.a;
  }
  
  public void a(MixedMsgInfo.MsgNode paramMsgNode)
  {
    if (paramMsgNode != null) {
      this.a.add(paramMsgNode);
    }
  }
  
  public boolean a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      if (((MixedMsgInfo.MsgNode)localIterator.next() instanceof MixedMsgInfo.PhotoMsgNode)) {
        return true;
      }
    }
    return false;
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      MixedMsgInfo.MsgNode localMsgNode = (MixedMsgInfo.MsgNode)localIterator.next();
      if ((localMsgNode instanceof MixedMsgInfo.TextMsgNode)) {
        localStringBuilder.append(localMsgNode.text());
      }
    }
    return localStringBuilder.toString();
  }
  
  public List<String> b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      MixedMsgInfo.MsgNode localMsgNode = (MixedMsgInfo.MsgNode)localIterator.next();
      if ((localMsgNode instanceof MixedMsgInfo.PhotoMsgNode)) {
        localArrayList.add(((MixedMsgInfo.PhotoMsgNode)localMsgNode).getPhotoItem().path);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mixedmsg.MixedMsgInfo
 * JD-Core Version:    0.7.0.1
 */