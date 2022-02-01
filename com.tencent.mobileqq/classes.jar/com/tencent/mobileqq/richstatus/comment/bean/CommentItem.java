package com.tencent.mobileqq.richstatus.comment.bean;

import bapg;
import java.io.Serializable;

public class CommentItem
  implements Serializable
{
  public String content;
  public String feedId;
  public long id;
  public long targetId;
  public long timeStamp;
  public bapg toReplyUser;
  public bapg user;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.comment.bean.CommentItem
 * JD-Core Version:    0.7.0.1
 */