package com.tencent.mobileqq.kandian.biz.comment.data;

import com.tencent.mobileqq.kandian.biz.comment.entity.CommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData;
import java.util.ArrayList;
import java.util.List;

public class ReadInJoyCommentPBModule$ResponseCommentInfo
{
  public CommentData a;
  public String a;
  public List<CommentData> a = new ArrayList();
  public boolean a;
  public List<SubCommentData> b = new ArrayList();
  
  public boolean a()
  {
    List localList = this.a;
    return (localList != null) && (localList.size() > 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentPBModule.ResponseCommentInfo
 * JD-Core Version:    0.7.0.1
 */