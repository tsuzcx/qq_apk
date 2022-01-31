package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;

public class MessageForTroopTopic
  extends MessageForStructing
{
  @notColumn
  public String author;
  @notColumn
  public long bid;
  @notColumn
  public long commentNum;
  @notColumn
  public AbsStructMsg detailTopicContent;
  @notColumn
  public boolean isExpand;
  @notColumn
  public boolean isFull;
  @notColumn
  public boolean isLike;
  @notColumn
  public boolean isLoading;
  @notColumn
  public boolean isShowExpandButton = true;
  @notColumn
  public long likeNum;
  @notColumn
  public long pVersion;
  @notColumn
  public String pid;
  
  protected void doParse()
  {
    if (!this.bDynicMsg)
    {
      this.structingMsg = StructMsgFactory.a(this.msgData);
      if ((this.structingMsg instanceof StructMsgForGeneralShare))
      {
        StructMsgForGeneralShare localStructMsgForGeneralShare = (StructMsgForGeneralShare)this.structingMsg;
        this.pVersion = localStructMsgForGeneralShare.pVersion;
        this.bid = localStructMsgForGeneralShare.bid;
        this.pid = localStructMsgForGeneralShare.pid;
        this.isFull = localStructMsgForGeneralShare.isFull;
        this.likeNum = localStructMsgForGeneralShare.likeNum;
        this.commentNum = localStructMsgForGeneralShare.commentNum;
        this.isLike = localStructMsgForGeneralShare.isLike;
        this.author = localStructMsgForGeneralShare.author;
        if (this.isFull) {
          break label253;
        }
      }
    }
    label253:
    for (boolean bool = true;; bool = false)
    {
      this.isShowExpandButton = bool;
      this.msg = getSummaryMsg();
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_topic", 2, "MessageForTroopTopic doParse.shmsgseq:" + this.shmsgseq + " pVersion:" + this.pVersion + " bid:" + this.bid + " pid:" + this.pid + " isFull:" + this.isFull + " likeNum:" + this.likeNum + " commentNum:" + this.commentNum + " isLike:" + this.isLike + " author:" + this.author);
      }
      return;
    }
  }
  
  public void prewrite()
  {
    if (this.structingMsg != null) {}
    try
    {
      if (!this.bDynicMsg) {
        this.msgData = this.structingMsg.getBytes();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void syncFieldsToStruct()
  {
    if ((this.structingMsg instanceof StructMsgForGeneralShare))
    {
      StructMsgForGeneralShare localStructMsgForGeneralShare = (StructMsgForGeneralShare)this.structingMsg;
      localStructMsgForGeneralShare.pVersion = this.pVersion;
      localStructMsgForGeneralShare.bid = this.bid;
      localStructMsgForGeneralShare.pid = this.pid;
      localStructMsgForGeneralShare.isFull = this.isFull;
      localStructMsgForGeneralShare.likeNum = this.likeNum;
      localStructMsgForGeneralShare.commentNum = this.commentNum;
      localStructMsgForGeneralShare.isLike = this.isLike;
      localStructMsgForGeneralShare.author = this.author;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForTroopTopic
 * JD-Core Version:    0.7.0.1
 */