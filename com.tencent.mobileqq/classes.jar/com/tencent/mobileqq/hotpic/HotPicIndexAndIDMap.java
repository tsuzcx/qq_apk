package com.tencent.mobileqq.hotpic;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;

public class HotPicIndexAndIDMap
{
  private SparseArray<HotPicTagInfo> a = new SparseArray();
  private ArrayList<HotPicTagInfo> b = new ArrayList();
  
  public HotPicTagInfo a(int paramInt)
  {
    return (HotPicTagInfo)this.a.get(paramInt);
  }
  
  public List<HotPicTagInfo> a()
  {
    return this.b;
  }
  
  public void a(HotPicTagInfo paramHotPicTagInfo)
  {
    this.b.add(paramHotPicTagInfo);
    this.a.put(paramHotPicTagInfo.tagId, paramHotPicTagInfo);
  }
  
  public HotPicTagInfo b(int paramInt)
  {
    return (HotPicTagInfo)this.b.get(paramInt);
  }
  
  public void b()
  {
    this.b.clear();
    this.a.clear();
  }
  
  public int c()
  {
    return this.b.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicIndexAndIDMap
 * JD-Core Version:    0.7.0.1
 */