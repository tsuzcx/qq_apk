package com.tencent.mobileqq.flashshow.basedata;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FSFeedData
  extends FSBaseBlockData<FeedCloudMeta.StFeed>
{
  public FSFeedData(FeedCloudMeta.StFeed paramStFeed)
  {
    super(paramStFeed);
  }
  
  public static List<FeedCloudMeta.StFeed> a(List<FSFeedData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FSFeedData localFSFeedData = (FSFeedData)paramList.next();
      if (localFSFeedData != null) {
        localArrayList.add(localFSFeedData.b());
      }
    }
    return localArrayList;
  }
  
  public FeedCloudMeta.StFeed b()
  {
    return (FeedCloudMeta.StFeed)super.a();
  }
  
  public FSFeedData c()
  {
    return this;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = ((FSFeedData)paramObject).b();
      if (b() != null)
      {
        if (paramObject == null) {
          return false;
        }
        if (b() == paramObject) {
          return true;
        }
        return TextUtils.equals(b().id.get(), paramObject.id.get());
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.basedata.FSFeedData
 * JD-Core Version:    0.7.0.1
 */