package com.tencent.sc.qzonepush.QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class SvcMsgPush
  extends JceStruct
{
  static ArrayList<SvcMsgInfo> cache_vecMsgInfos;
  public byte cMore = 0;
  public int iUnread = 0;
  public ArrayList<SvcMsgInfo> vecMsgInfos = null;
  
  public SvcMsgPush() {}
  
  public SvcMsgPush(byte paramByte, int paramInt, ArrayList<SvcMsgInfo> paramArrayList)
  {
    this.cMore = paramByte;
    this.iUnread = paramInt;
    this.vecMsgInfos = paramArrayList;
  }
  
  public String className()
  {
    return "com.tencent.sc.qzonepush.QQService.SvcMsgPush";
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    return null;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.cMore, "cMore");
    paramStringBuilder.display(this.iUnread, "iUnread");
    paramStringBuilder.display(this.vecMsgInfos, "vecMsgInfos");
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (SvcMsgPush)paramObject;
    return (JceUtil.equals(this.cMore, paramObject.cMore)) && (JceUtil.equals(this.iUnread, paramObject.iUnread)) && (JceUtil.equals(this.vecMsgInfos, paramObject.vecMsgInfos));
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cMore = paramJceInputStream.read(this.cMore, 0, true);
    this.iUnread = paramJceInputStream.read(this.iUnread, 1, true);
    if (cache_vecMsgInfos == null)
    {
      cache_vecMsgInfos = new ArrayList();
      SvcMsgInfo localSvcMsgInfo = new SvcMsgInfo();
      cache_vecMsgInfos.add(localSvcMsgInfo);
    }
    this.vecMsgInfos = ((ArrayList)paramJceInputStream.read(cache_vecMsgInfos, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cMore, 0);
    paramJceOutputStream.write(this.iUnread, 1);
    paramJceOutputStream.write(this.vecMsgInfos, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.sc.qzonepush.QQService.SvcMsgPush
 * JD-Core Version:    0.7.0.1
 */