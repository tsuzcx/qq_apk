package com.tencent.mobileqq.flashshow.model.barrage.cache;

import feedcloud.FeedCloudMeta.StComment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FSBarrageCachePack
{
  private Map<String, ArrayList<FeedCloudMeta.StComment>> a = new HashMap();
  private Map<String, FSBarrageCachePack.FSBarrageResponse> b = new HashMap();
  private Map<String, Integer> c = new HashMap();
  
  public Map<String, ArrayList<FeedCloudMeta.StComment>> a()
  {
    return this.a;
  }
  
  public Map<String, FSBarrageCachePack.FSBarrageResponse> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.model.barrage.cache.FSBarrageCachePack
 * JD-Core Version:    0.7.0.1
 */