package com.tencent.mobileqq.richstatus;

import bbvk;
import com.tencent.mobileqq.richstatus.comment.bean.CommentItem;
import java.io.Serializable;
import java.util.List;

public class HistorySignItem
  implements Serializable
{
  public List<CommentItem> commentItemList;
  public List<bbvk> likeItemList;
  public RichStatus richStatus;
  public long totalLikeNum;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.HistorySignItem
 * JD-Core Version:    0.7.0.1
 */