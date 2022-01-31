import android.content.Context;
import android.content.res.Resources;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyVideoSubChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoBehaviorsReporter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class lhu
  extends ReadInJoyObserver
{
  public lhu(ReadInJoyVideoSubChannelActivity paramReadInJoyVideoSubChannelActivity) {}
  
  public void a(int paramInt, List paramList)
  {
    if ((paramInt != ReadInJoyVideoSubChannelActivity.a(this.a)) || (ReadInJoyVideoSubChannelActivity.a(this.a) == null)) {
      return;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.a.a(paramList, 1);
      Object localObject1 = (Long)paramList.get(0);
      Object localObject2 = ReadInJoyLogicEngine.a().a(ReadInJoyVideoSubChannelActivity.a(this.a), ((Long)localObject1).longValue());
      StringBuilder localStringBuilder = new StringBuilder().append("load history successful ! first article title : ");
      if (localObject2 != null)
      {
        localObject1 = ((ArticleInfo)localObject2).mTitle;
        localObject1 = ReadInJoyUtils.d((String)localObject1);
        localStringBuilder = new StringBuilder().append((String)localObject1).append(" articleID : ");
        if (localObject2 == null) {
          break label252;
        }
      }
      label252:
      for (localObject1 = Long.valueOf(((ArticleInfo)localObject2).mArticleID);; localObject1 = "-1")
      {
        QLog.d("Q.readinjoy.video.SubChannelActivity", 1, localObject1);
        if (!QLog.isColorLevel()) {
          break label270;
        }
        localObject1 = new StringBuilder("onChannelArticleLoaded ");
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject2 = (Long)paramList.next();
          ((StringBuilder)localObject1).append("recommendSeq = " + localObject2 + ",\n ");
        }
        localObject1 = "";
        break;
      }
      QLog.d("Q.readinjoy.video.SubChannelActivity", 1, ((StringBuilder)localObject1).toString());
    }
    label270:
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.b = 0L;
    paramList = this.a;
    if (!ReadInJoyVideoSubChannelActivity.b(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      bool = ReadInJoyVideoSubChannelActivity.b(paramList, bool);
      if (!ReadInJoyVideoSubChannelActivity.b(this.a)) {
        ReadInJoyVideoSubChannelActivity.c(this.a, true);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.readinjoy.video.SubChannelActivity", 2, "onChannelArticleLoaded: hasRefresh" + bool);
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, SparseArray paramSparseArray)
  {
    if (paramInt == 56)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.readinjoy.video.SubChannelActivity", 2, "onGetChannelStatusUpdate(): success == " + paramBoolean);
      }
      if ((paramBoolean) && (paramSparseArray != null) && (paramSparseArray.size() > 0))
      {
        paramSparseArray = (ChannelInfo)paramSparseArray.get(ReadInJoyVideoSubChannelActivity.b(this.a));
        if (paramSparseArray != null) {
          ReadInJoyVideoSubChannelActivity.b(this.a, paramSparseArray, true);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List paramList, boolean paramBoolean2)
  {
    if ((paramInt != ReadInJoyVideoSubChannelActivity.a(this.a)) || (ReadInJoyVideoSubChannelActivity.a(this.a) == null)) {
      return;
    }
    paramInt = ReadInJoyLogicEngine.a().a(Integer.valueOf(paramInt));
    if (paramBoolean1) {
      if ((paramList != null) && (paramInt > 0))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder("onChannelRefreshed ");
          Iterator localIterator = paramList.iterator();
          while (localIterator.hasNext())
          {
            Long localLong = (Long)localIterator.next();
            localStringBuilder.append("recommendSeq = " + localLong + ",\n ");
          }
          QLog.d("Q.readinjoy.video.SubChannelActivity", 1, localStringBuilder.toString());
        }
        VideoBehaviorsReporter.a().c(true);
        this.a.a(paramList, 1);
        ReadInJoyVideoSubChannelActivity.a(this.a).a(0);
      }
    }
    for (;;)
    {
      ReadInJoyVideoSubChannelActivity.a(this.a, paramBoolean1, paramInt);
      this.a.a(paramList);
      return;
      if (ReadInJoyVideoSubChannelActivity.a(this.a).isEmpty())
      {
        ReadInJoyVideoSubChannelActivity.a(this.a, this.a.getResources().getString(2131428447));
        continue;
        if (ReadInJoyVideoSubChannelActivity.a(this.a).isEmpty()) {
          ReadInJoyVideoSubChannelActivity.a(this.a, this.a.getResources().getString(2131428446));
        }
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 97)
    {
      QQToast.a(ReadInJoyVideoSubChannelActivity.a(this.a), "请添加更多频道，再取消", 0).a();
      ReadInJoyVideoSubChannelActivity.a(this.a, true);
    }
    while (paramInt != 98) {
      return;
    }
    QQToast.a(ReadInJoyVideoSubChannelActivity.a(this.a), "添加频道已达上限", 0).a();
    ReadInJoyVideoSubChannelActivity.a(this.a, false);
  }
  
  public void b(int paramInt, List paramList)
  {
    if ((paramInt != ReadInJoyVideoSubChannelActivity.a(this.a)) || (paramList == null) || (ReadInJoyVideoSubChannelActivity.a(this.a) == null)) {
      return;
    }
    ReadInJoyVideoSubChannelActivity.a(this.a).b(ReadInJoyLogicEngine.a().a(Integer.valueOf(ReadInJoyVideoSubChannelActivity.a(this.a)), paramList));
    ReadInJoyVideoSubChannelActivity.a(this.a).notifyDataSetChanged();
  }
  
  public void b(boolean paramBoolean1, int paramInt, List paramList, boolean paramBoolean2)
  {
    paramBoolean2 = true;
    if ((paramInt != ReadInJoyVideoSubChannelActivity.a(this.a)) || (ReadInJoyVideoSubChannelActivity.a(this.a) == null))
    {
      ReadInJoyVideoSubChannelActivity.d(this.a, false);
      return;
    }
    if ((paramBoolean1) && (paramList != null)) {
      this.a.a(paramList, 2);
    }
    if ((paramBoolean1) && (paramList == null))
    {
      paramBoolean1 = true;
      paramList = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
      if (paramBoolean1) {
        break label218;
      }
    }
    for (;;)
    {
      paramList.a(paramBoolean2);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.SubChannelActivity", 2, "autoLoad:" + ReadInJoyVideoSubChannelActivity.c(this.a) + " noMoreData:" + paramBoolean1 + " fore:" + GesturePWDUtils.isAppOnForeground(ReadInJoyVideoSubChannelActivity.a(this.a)));
      }
      if ((!ReadInJoyVideoSubChannelActivity.c(this.a)) && (paramBoolean1) && (GesturePWDUtils.isAppOnForeground(ReadInJoyVideoSubChannelActivity.a(this.a))))
      {
        paramList = this.a.getResources().getString(2131428442);
        QQToast.a(ReadInJoyVideoSubChannelActivity.a(this.a).getApplicationContext(), paramList, 0).a();
      }
      ReadInJoyVideoSubChannelActivity.d(this.a, false);
      return;
      paramBoolean1 = false;
      break;
      label218:
      paramBoolean2 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lhu
 * JD-Core Version:    0.7.0.1
 */