package com.tencent.mobileqq.kandian.biz.feeds.activity;

import android.content.Context;
import android.content.res.Resources;
import android.util.SparseArray;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.video.VideoBehaviorsReporter;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class ReadInJoyVideoSubChannelActivity$VideoSubChannelObserver
  extends ReadInJoyObserver
{
  private ReadInJoyVideoSubChannelActivity$VideoSubChannelObserver(ReadInJoyVideoSubChannelActivity paramReadInJoyVideoSubChannelActivity) {}
  
  public void a(int paramInt, List<Long> paramList)
  {
    if (paramInt == ReadInJoyVideoSubChannelActivity.c(this.a))
    {
      if (ReadInJoyVideoSubChannelActivity.a(this.a) == null) {
        return;
      }
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        this.a.a(paramList, 1);
        Object localObject1 = (Long)paramList.get(0);
        Object localObject2 = ReadInJoyLogicEngine.a().a(ReadInJoyVideoSubChannelActivity.c(this.a), ((Long)localObject1).longValue());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("load history successful ! first article title : ");
        if (localObject2 != null) {
          localObject1 = ((AbsBaseArticleInfo)localObject2).mTitle;
        } else {
          localObject1 = "";
        }
        localStringBuilder.append(RIJAppSetting.a((String)localObject1));
        localObject1 = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(" articleID : ");
        if (localObject2 != null) {
          localObject1 = Long.valueOf(((AbsBaseArticleInfo)localObject2).mArticleID);
        } else {
          localObject1 = "-1";
        }
        localStringBuilder.append(localObject1);
        QLog.d("Q.readinjoy.video.SubChannelActivity", 1, localStringBuilder.toString());
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder("onChannelArticleLoaded ");
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            localObject2 = (Long)paramList.next();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("recommendSeq = ");
            localStringBuilder.append(localObject2);
            localStringBuilder.append(",\n ");
            ((StringBuilder)localObject1).append(localStringBuilder.toString());
          }
          QLog.d("Q.readinjoy.video.SubChannelActivity", 1, ((StringBuilder)localObject1).toString());
        }
      }
      this.a.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyPageItemCache.b = 0L;
      paramList = this.a;
      boolean bool = ReadInJoyVideoSubChannelActivity.b(paramList, ReadInJoyVideoSubChannelActivity.b(paramList) ^ true);
      if (!ReadInJoyVideoSubChannelActivity.b(this.a)) {
        ReadInJoyVideoSubChannelActivity.c(this.a, true);
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("onChannelArticleLoaded: hasRefresh");
        paramList.append(bool);
        QLog.d("Q.readinjoy.video.SubChannelActivity", 2, paramList.toString());
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, SparseArray<ChannelInfo> paramSparseArray)
  {
    if (paramInt == 56)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onGetChannelStatusUpdate(): success == ");
        localStringBuilder.append(paramBoolean);
        QLog.w("Q.readinjoy.video.SubChannelActivity", 2, localStringBuilder.toString());
      }
      if ((paramBoolean) && (paramSparseArray != null) && (paramSparseArray.size() > 0))
      {
        paramSparseArray = (ChannelInfo)paramSparseArray.get(ReadInJoyVideoSubChannelActivity.a(this.a));
        if (paramSparseArray != null) {
          ReadInJoyVideoSubChannelActivity.b(this.a, paramSparseArray, true);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if (paramInt == ReadInJoyVideoSubChannelActivity.c(this.a))
    {
      if (ReadInJoyVideoSubChannelActivity.a(this.a) == null) {
        return;
      }
      paramInt = ReadInJoyLogicEngine.a().a(Integer.valueOf(paramInt));
      Object localObject;
      if (paramBoolean1)
      {
        if ((paramList != null) && (paramInt > 0))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder("onChannelRefreshed ");
            Iterator localIterator = paramList.iterator();
            while (localIterator.hasNext())
            {
              Long localLong = (Long)localIterator.next();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("recommendSeq = ");
              localStringBuilder.append(localLong);
              localStringBuilder.append(",\n ");
              ((StringBuilder)localObject).append(localStringBuilder.toString());
            }
            QLog.d("Q.readinjoy.video.SubChannelActivity", 1, ((StringBuilder)localObject).toString());
          }
          VideoBehaviorsReporter.a().c(true);
          this.a.a(paramList, 1);
          ReadInJoyVideoSubChannelActivity.a(this.a).b(0);
        }
        else if (ReadInJoyVideoSubChannelActivity.a(this.a).isEmpty())
        {
          localObject = this.a;
          ReadInJoyVideoSubChannelActivity.a((ReadInJoyVideoSubChannelActivity)localObject, ((ReadInJoyVideoSubChannelActivity)localObject).getResources().getString(2131718010));
        }
      }
      else if (ReadInJoyVideoSubChannelActivity.a(this.a).isEmpty())
      {
        localObject = this.a;
        ReadInJoyVideoSubChannelActivity.a((ReadInJoyVideoSubChannelActivity)localObject, ((ReadInJoyVideoSubChannelActivity)localObject).getResources().getString(2131717971));
      }
      ReadInJoyVideoSubChannelActivity.a(this.a, paramBoolean1, paramInt);
      this.a.a(paramList);
    }
  }
  
  public void b(int paramInt, List<Long> paramList)
  {
    if ((paramInt == ReadInJoyVideoSubChannelActivity.c(this.a)) && (paramList != null))
    {
      if (ReadInJoyVideoSubChannelActivity.a(this.a) == null) {
        return;
      }
      ReadInJoyVideoSubChannelActivity.a(this.a).b(ReadInJoyLogicEngine.a().a(Integer.valueOf(ReadInJoyVideoSubChannelActivity.c(this.a)), paramList));
      ReadInJoyVideoSubChannelActivity.a(this.a).notifyDataSetChanged();
    }
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((paramInt == ReadInJoyVideoSubChannelActivity.c(this.a)) && (ReadInJoyVideoSubChannelActivity.a(this.a) != null))
    {
      if ((paramBoolean1) && ((paramList == null) || (paramList.size() == ReadInJoyVideoSubChannelActivity.a(this.a).getCount()))) {
        paramBoolean2 = true;
      } else {
        paramBoolean2 = false;
      }
      if ((paramBoolean1) && (paramList != null)) {
        this.a.a(paramList, 2);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.a(paramBoolean2 ^ true);
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("autoLoad:");
        paramList.append(ReadInJoyVideoSubChannelActivity.c(this.a));
        paramList.append(" noMoreData:");
        paramList.append(paramBoolean2);
        paramList.append(" fore:");
        paramList.append(GesturePWDUtils.isAppOnForeground(ReadInJoyVideoSubChannelActivity.a(this.a)));
        QLog.d("Q.readinjoy.video.SubChannelActivity", 2, paramList.toString());
      }
      if ((!ReadInJoyVideoSubChannelActivity.c(this.a)) && (paramBoolean2) && (GesturePWDUtils.isAppOnForeground(ReadInJoyVideoSubChannelActivity.a(this.a))))
      {
        paramList = this.a.getResources().getString(2131717752);
        QQToast.a(ReadInJoyVideoSubChannelActivity.a(this.a).getApplicationContext(), paramList, 0).a();
      }
      ReadInJoyVideoSubChannelActivity.d(this.a, false);
      return;
    }
    ReadInJoyVideoSubChannelActivity.d(this.a, false);
  }
  
  public void e(int paramInt)
  {
    if (paramInt == 97)
    {
      QQToast.a(ReadInJoyVideoSubChannelActivity.a(this.a), HardCodeUtil.a(2131712715), 0).a();
      ReadInJoyVideoSubChannelActivity.b(this.a, true);
      return;
    }
    if (paramInt == 98)
    {
      QQToast.a(ReadInJoyVideoSubChannelActivity.a(this.a), HardCodeUtil.a(2131712785), 0).a();
      ReadInJoyVideoSubChannelActivity.b(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyVideoSubChannelActivity.VideoSubChannelObserver
 * JD-Core Version:    0.7.0.1
 */