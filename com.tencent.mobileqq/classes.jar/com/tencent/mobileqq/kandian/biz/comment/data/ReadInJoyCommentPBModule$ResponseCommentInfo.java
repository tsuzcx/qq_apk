package com.tencent.mobileqq.kandian.biz.comment.data;

import com.tencent.mobileqq.kandian.biz.comment.entity.CommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData;
import java.util.ArrayList;
import java.util.List;

public class ReadInJoyCommentPBModule$ResponseCommentInfo
{
  public List<CommentData> a = new ArrayList();
  public List<SubCommentData> b = new ArrayList();
  public CommentData c;
  public boolean d;
  public String e;
  
  public boolean a()
  {
    List localList = this.a;
    return (localList != null) && (localList.size() > 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentPBModule.ResponseCommentInfo
 * JD-Core Version:    0.7.0.1
 */