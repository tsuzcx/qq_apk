package com.tencent.mobileqq.comment;

import android.graphics.Paint;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class DanmuDataHolder
{
  private static DanmuDataHolder jdField_a_of_type_ComTencentMobileqqCommentDanmuDataHolder;
  public int a;
  public Paint a;
  private LruCache<String, DanmuDataHolder.CacheHolder> jdField_a_of_type_AndroidUtilLruCache;
  private DanmuDataServlet jdField_a_of_type_ComTencentMobileqqCommentDanmuDataServlet = null;
  
  private DanmuDataHolder()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = null;
    this.jdField_a_of_type_Int = ViewUtils.a(150.0F);
    if (this.jdField_a_of_type_AndroidUtilLruCache == null) {
      this.jdField_a_of_type_AndroidUtilLruCache = new LruCache(10485760);
    }
    if (MobileQQ.sProcessId == 1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqCommentDanmuDataServlet == null) {
        this.jdField_a_of_type_ComTencentMobileqqCommentDanmuDataServlet = new DanmuDataServlet();
      }
      b();
    }
  }
  
  public static DanmuDataHolder a()
  {
    if (jdField_a_of_type_ComTencentMobileqqCommentDanmuDataHolder == null) {
      jdField_a_of_type_ComTencentMobileqqCommentDanmuDataHolder = new DanmuDataHolder();
    }
    return jdField_a_of_type_ComTencentMobileqqCommentDanmuDataHolder;
  }
  
  public DanmuDataHolder.CacheHolder a(String paramString)
  {
    return (DanmuDataHolder.CacheHolder)this.jdField_a_of_type_AndroidUtilLruCache.get(paramString);
  }
  
  public String a(long paramLong1, long paramLong2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(paramLong1));
    localStringBuilder.append(paramLong2);
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidUtilLruCache.evictAll();
  }
  
  public void a(DanmuDataContext paramDanmuDataContext, DanmuDataIPCClient.DanmuPullCallback paramDanmuPullCallback)
  {
    if ((paramDanmuDataContext.a != 0L) && (paramDanmuDataContext.b != 0L))
    {
      Object localObject = a().a(paramDanmuDataContext.b, paramDanmuDataContext.a);
      DanmuDataHolder.CacheHolder localCacheHolder = a().a((String)localObject);
      localObject = localCacheHolder;
      if (localCacheHolder == null)
      {
        localObject = new DanmuDataHolder.CacheHolder(this).a(paramDanmuDataContext).d(0).e(0).a(paramDanmuPullCallback).a();
        QLog.d("DanmuDataHolder", 2, "request start, reqHolder is null, create it");
      }
      this.jdField_a_of_type_ComTencentMobileqqCommentDanmuDataServlet.a((DanmuDataHolder.CacheHolder)localObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DanmuDataHolder", 2, String.format("request, bad parameter, topicUin:%s, groupUin:%s", new Object[] { Long.valueOf(paramDanmuDataContext.a), Long.valueOf(paramDanmuDataContext.b) }));
    }
  }
  
  public void a(String paramString, DanmuDataHolder.CacheHolder paramCacheHolder)
  {
    this.jdField_a_of_type_AndroidUtilLruCache.put(paramString, paramCacheHolder);
  }
  
  public DanmuDataHolder.CacheHolder b(String paramString)
  {
    DanmuDataHolder.CacheHolder localCacheHolder = new DanmuDataHolder.CacheHolder(this);
    a(paramString, localCacheHolder);
    return localCacheHolder;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsPaint == null) {
      this.jdField_a_of_type_AndroidGraphicsPaint = ((TextView)LayoutInflater.from(MobileQQ.getContext()).inflate(2131562762, null).findViewById(2131364910)).getPaint();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.comment.DanmuDataHolder
 * JD-Core Version:    0.7.0.1
 */