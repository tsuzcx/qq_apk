package com.tencent.mobileqq.comment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DanmuDataHolder$CacheHolder
{
  int jdField_a_of_type_Int = 0;
  public DanmuDataContext a;
  DanmuDataIPCClient.DanmuPullCallback jdField_a_of_type_ComTencentMobileqqCommentDanmuDataIPCClient$DanmuPullCallback;
  List<Long> jdField_a_of_type_JavaUtilList;
  public boolean a;
  int jdField_b_of_type_Int = 30;
  List<Long> jdField_b_of_type_JavaUtilList = new ArrayList();
  int jdField_c_of_type_Int = 0;
  List<DanmuItemBean> jdField_c_of_type_JavaUtilList;
  int jdField_d_of_type_Int = 0;
  List<DanmuItemBean> jdField_d_of_type_JavaUtilList = new ArrayList();
  int e = 0;
  int f = 60;
  
  public DanmuDataHolder$CacheHolder(DanmuDataHolder paramDanmuDataHolder)
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public CacheHolder a()
  {
    DanmuDataHolder.a().a(DanmuDataHolder.a().a(this.jdField_a_of_type_ComTencentMobileqqCommentDanmuDataContext.b, this.jdField_a_of_type_ComTencentMobileqqCommentDanmuDataContext.jdField_a_of_type_Long), this);
    return this;
  }
  
  public CacheHolder a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public CacheHolder a(DanmuDataContext paramDanmuDataContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqCommentDanmuDataContext = paramDanmuDataContext;
    return this;
  }
  
  public CacheHolder a(DanmuDataIPCClient.DanmuPullCallback paramDanmuPullCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqCommentDanmuDataIPCClient$DanmuPullCallback = paramDanmuPullCallback;
    return this;
  }
  
  public CacheHolder a(List<DanmuItemBean> paramList)
  {
    this.jdField_c_of_type_JavaUtilList = paramList;
    return this;
  }
  
  public CacheHolder a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public String a()
  {
    return String.format("CacheHolder - topicUin:%s, groupUin:%s, msgType:%s, peakCached:%s, videoStartTime:%s, videoEndTime:%s, nextStartIdx:%s, count:%s", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqCommentDanmuDataContext.jdField_a_of_type_Long), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqCommentDanmuDataContext.b), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqCommentDanmuDataContext.jdField_a_of_type_Int), Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqCommentDanmuDataContext.jdField_a_of_type_Boolean), Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(this.jdField_d_of_type_Int), Integer.valueOf(this.e), Integer.valueOf(this.f) });
  }
  
  public void a()
  {
    Object localObject = this.jdField_d_of_type_JavaUtilList.iterator();
    DanmuItemBean localDanmuItemBean;
    while (((Iterator)localObject).hasNext())
    {
      localDanmuItemBean = (DanmuItemBean)((Iterator)localObject).next();
      if (this.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(localDanmuItemBean.b))) {
        ((Iterator)localObject).remove();
      }
    }
    localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        long l = ((Long)((Iterator)localObject).next()).longValue();
        if (!this.jdField_b_of_type_JavaUtilList.contains(Long.valueOf(l))) {
          this.jdField_b_of_type_JavaUtilList.add(Long.valueOf(l));
        }
      }
    }
    localObject = this.jdField_c_of_type_JavaUtilList;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = this.jdField_c_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localDanmuItemBean = (DanmuItemBean)((Iterator)localObject).next();
        if (!a(localDanmuItemBean.jdField_a_of_type_Long, localDanmuItemBean.b)) {
          this.jdField_d_of_type_JavaUtilList.add(localDanmuItemBean);
        }
      }
    }
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    Iterator localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      DanmuItemBean localDanmuItemBean = (DanmuItemBean)localIterator.next();
      if ((localDanmuItemBean.jdField_a_of_type_Long == paramLong1) && (localDanmuItemBean.b == paramLong2)) {
        return true;
      }
    }
    return false;
  }
  
  public CacheHolder b(int paramInt)
  {
    if (paramInt > 0) {
      this.jdField_b_of_type_Int = paramInt;
    }
    return this;
  }
  
  public CacheHolder b(List<Long> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    return this;
  }
  
  public CacheHolder c(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public CacheHolder d(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    return this;
  }
  
  public CacheHolder e(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.comment.DanmuDataHolder.CacheHolder
 * JD-Core Version:    0.7.0.1
 */