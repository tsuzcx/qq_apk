package com.tencent.mobileqq.flashshow.basedata;

import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FSDataTransFromHelper
{
  public static ArrayList<FSFeedData> a(List<FeedCloudMeta.StFeed> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return localArrayList;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(new FSFeedData((FeedCloudMeta.StFeed)paramList.next()).c());
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.basedata.FSDataTransFromHelper
 * JD-Core Version:    0.7.0.1
 */