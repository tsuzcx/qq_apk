import android.content.Context;
import android.content.res.Resources;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyVideoSubChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class onj
  extends pkt
{
  public onj(ReadInJoyVideoSubChannelActivity paramReadInJoyVideoSubChannelActivity) {}
  
  public void a(int paramInt, List<Long> paramList)
  {
    if ((paramInt != ReadInJoyVideoSubChannelActivity.c(this.a)) || (ReadInJoyVideoSubChannelActivity.a(this.a) == null)) {
      return;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.a.a(paramList, 1);
      Object localObject1 = (Long)paramList.get(0);
      Object localObject2 = pkm.a().a(ReadInJoyVideoSubChannelActivity.c(this.a), ((Long)localObject1).longValue());
      StringBuilder localStringBuilder = new StringBuilder().append("load history successful ! first article title : ");
      if (localObject2 != null)
      {
        localObject1 = ((ArticleInfo)localObject2).mTitle;
        localObject1 = pay.d((String)localObject1);
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
    this.a.jdField_a_of_type_Pak.b = 0L;
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
  
  public void a(boolean paramBoolean, int paramInt, SparseArray<ChannelInfo> paramSparseArray)
  {
    if (paramInt == 56)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.readinjoy.video.SubChannelActivity", 2, "onGetChannelStatusUpdate(): success == " + paramBoolean);
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
    if ((paramInt != ReadInJoyVideoSubChannelActivity.c(this.a)) || (ReadInJoyVideoSubChannelActivity.a(this.a) == null)) {
      return;
    }
    paramInt = pkm.a().a(Integer.valueOf(paramInt));
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
        rtr.a().c(true);
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
        ReadInJoyVideoSubChannelActivity.a(this.a, this.a.getResources().getString(2131717478));
        continue;
        if (ReadInJoyVideoSubChannelActivity.a(this.a).isEmpty()) {
          ReadInJoyVideoSubChannelActivity.a(this.a, this.a.getResources().getString(2131717437));
        }
      }
    }
  }
  
  public void b(int paramInt, List<Long> paramList)
  {
    if ((paramInt != ReadInJoyVideoSubChannelActivity.c(this.a)) || (paramList == null) || (ReadInJoyVideoSubChannelActivity.a(this.a) == null)) {
      return;
    }
    ReadInJoyVideoSubChannelActivity.a(this.a).b(pkm.a().a(Integer.valueOf(ReadInJoyVideoSubChannelActivity.c(this.a)), paramList));
    ReadInJoyVideoSubChannelActivity.a(this.a).notifyDataSetChanged();
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    boolean bool = true;
    if ((paramInt != ReadInJoyVideoSubChannelActivity.c(this.a)) || (ReadInJoyVideoSubChannelActivity.a(this.a) == null))
    {
      ReadInJoyVideoSubChannelActivity.d(this.a, false);
      return;
    }
    if ((paramBoolean1) && ((paramList == null) || (paramList.size() == ReadInJoyVideoSubChannelActivity.a(this.a).getCount())))
    {
      paramBoolean2 = true;
      if ((paramBoolean1) && (paramList != null)) {
        this.a.a(paramList, 2);
      }
      paramList = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
      if (paramBoolean2) {
        break label243;
      }
    }
    label243:
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      paramList.a(paramBoolean1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.SubChannelActivity", 2, "autoLoad:" + ReadInJoyVideoSubChannelActivity.c(this.a) + " noMoreData:" + paramBoolean2 + " fore:" + GesturePWDUtils.isAppOnForeground(ReadInJoyVideoSubChannelActivity.a(this.a)));
      }
      if ((!ReadInJoyVideoSubChannelActivity.c(this.a)) && (paramBoolean2) && (GesturePWDUtils.isAppOnForeground(ReadInJoyVideoSubChannelActivity.a(this.a))))
      {
        paramList = this.a.getResources().getString(2131717234);
        QQToast.a(ReadInJoyVideoSubChannelActivity.a(this.a).getApplicationContext(), paramList, 0).a();
      }
      ReadInJoyVideoSubChannelActivity.d(this.a, false);
      return;
      paramBoolean2 = false;
      break;
    }
  }
  
  public void d(int paramInt)
  {
    if (paramInt == 97)
    {
      QQToast.a(ReadInJoyVideoSubChannelActivity.a(this.a), amtj.a(2131711881), 0).a();
      ReadInJoyVideoSubChannelActivity.b(this.a, true);
    }
    while (paramInt != 98) {
      return;
    }
    QQToast.a(ReadInJoyVideoSubChannelActivity.a(this.a), amtj.a(2131711951), 0).a();
    ReadInJoyVideoSubChannelActivity.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     onj
 * JD-Core Version:    0.7.0.1
 */