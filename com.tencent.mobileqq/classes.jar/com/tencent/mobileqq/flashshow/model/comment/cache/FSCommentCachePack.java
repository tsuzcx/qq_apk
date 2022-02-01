package com.tencent.mobileqq.flashshow.model.comment.cache;

import feedcloud.FeedCloudMeta.StComment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FSCommentCachePack
{
  private Map<String, ArrayList<FeedCloudMeta.StComment>> a = new HashMap();
  private Map<String, Integer> b = new HashMap();
  private Map<String, FSCommentCachePack.FSCommentResponse> c = new HashMap();
  private Map<String, String> d = new HashMap();
  
  public Map<String, ArrayList<FeedCloudMeta.StComment>> a()
  {
    return this.a;
  }
  
  public Map<String, Integer> b()
  {
    return this.b;
  }
  
  public Map<String, FSCommentCachePack.FSCommentResponse> c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.model.comment.cache.FSCommentCachePack
 * JD-Core Version:    0.7.0.1
 */