package com.tencent.mobileqq.flashshow.data;

import com.tencent.mobileqq.flashshow.basedata.FSFeedData;
import com.tencent.richframework.data.base.BaseDataStore;
import com.tencent.richframework.data.idata.IDataCenter;
import java.util.Map;

public class FSFeedDataStore
  extends BaseDataStore<FSFeedData>
{
  private final IDataCenter<FSFeedData> a;
  
  public FSFeedDataStore(IDataCenter<FSFeedData> paramIDataCenter)
  {
    this.a = paramIDataCenter;
  }
  
  protected String a(FSFeedData paramFSFeedData)
  {
    return this.a.a(paramFSFeedData);
  }
  
  public boolean d()
  {
    return (b() != null) && (b().size() >= a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.data.FSFeedDataStore
 * JD-Core Version:    0.7.0.1
 */