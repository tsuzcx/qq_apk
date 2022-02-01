package com.tencent.mobileqq.richstatus.comment.bean;

import java.io.Serializable;

public class CommentItem
  implements Serializable
{
  public String content;
  public String feedId;
  public long id;
  public long targetId;
  public long timeStamp;
  public User toReplyUser;
  public User user;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.comment.bean.CommentItem
 * JD-Core Version:    0.7.0.1
 */