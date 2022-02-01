package com.tencent.mobileqq.kandian.biz.comment;

import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.OnDataChangeListener;
import java.util.ArrayList;
import java.util.List;

public class RIJCommentResultDispatcher
{
  private static List<ReadInJoyCommentDataManager.OnDataChangeListener> a;
  
  private RIJCommentResultDispatcher()
  {
    a = new ArrayList();
  }
  
  public static RIJCommentResultDispatcher a()
  {
    return RIJCommentResultDispatcher.CommentControllerHolder.a();
  }
  
  public List<ReadInJoyCommentDataManager.OnDataChangeListener> a()
  {
    List localList2 = a;
    List localList1 = localList2;
    if (localList2 == null) {
      localList1 = null;
    }
    return localList1;
  }
  
  public void a()
  {
    List localList = a;
    if (localList != null) {
      localList.clear();
    }
  }
  
  public void a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    if (paramOnDataChangeListener != null)
    {
      List localList = a;
      if (localList == null) {
        return;
      }
      if (!localList.contains(paramOnDataChangeListener)) {
        a.add(paramOnDataChangeListener);
      }
    }
  }
  
  public void b(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    List localList = a;
    if (localList != null)
    {
      if (localList.size() == 0) {
        return;
      }
      a.remove(paramOnDataChangeListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.RIJCommentResultDispatcher
 * JD-Core Version:    0.7.0.1
 */