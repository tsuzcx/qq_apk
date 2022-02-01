package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.cgi;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.DataObserver;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.ProteusSupportUtilBase;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.ReadInJoyDynamicChannelBaseFragment;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data.DataEventDispatcher;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data.DynamicChannelDataModule;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data.DynamicChannelHeaderModule;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data.HeaderDataModel;
import com.tencent.mobileqq.kandian.biz.pts.data.DynamicChannelDataModel;
import com.tencent.mobileqq.kandian.biz.pts.item.ProteusItemView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ReadInJoyCGIDynamicChannelFragment
  extends ReadInJoyDynamicChannelBaseFragment
{
  private ReadInJoyCGIDynamicChannelAdapter s;
  private DataObserver t = new ReadInJoyCGIDynamicChannelFragment.1(this);
  private XRecyclerView.RefreshCallback u = new ReadInJoyCGIDynamicChannelFragment.2(this);
  
  public static ReadInJoyCGIDynamicChannelFragment a(int paramInt1, int paramInt2, String paramString)
  {
    ReadInJoyCGIDynamicChannelFragment localReadInJoyCGIDynamicChannelFragment = new ReadInJoyCGIDynamicChannelFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("channel_id", paramInt1);
    localBundle.putInt("channel_type", paramInt2);
    localBundle.putString("channel_name", paramString);
    localReadInJoyCGIDynamicChannelFragment.setArguments(localBundle);
    return localReadInJoyCGIDynamicChannelFragment;
  }
  
  private void a(int paramInt, List<HeaderDataModel> paramList)
  {
    if (paramInt != this.d) {
      return;
    }
    x();
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        HeaderDataModel localHeaderDataModel = (HeaderDataModel)paramList.next();
        QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "channelID = ", Integer.valueOf(paramInt), ", styleID = ", localHeaderDataModel.a, ", proteusData = ", localHeaderDataModel.b });
        if ((!TextUtils.isEmpty(localHeaderDataModel.a)) && (!TextUtils.isEmpty(localHeaderDataModel.b)))
        {
          ProteusItemView localProteusItemView = ProteusSupportUtilBase.a(this.s.a(), w(), ProteusSupportUtilBase.a(localHeaderDataModel.b));
          ProteusSupportUtilBase.a(localProteusItemView, this.s.a(), w(), localHeaderDataModel.b);
          a(localProteusItemView);
        }
      }
    }
  }
  
  private void a(ConcurrentHashMap<String, DynamicChannelDataModel> paramConcurrentHashMap)
  {
    ThreadManager.executeOnSubThread(new ReadInJoyCGIDynamicChannelFragment.3(this, paramConcurrentHashMap));
  }
  
  public void a()
  {
    if (!this.o)
    {
      this.o = true;
      Object localObject = DynamicChannelDataModule.a();
      if (localObject != null) {
        ((DynamicChannelDataModule)localObject).a(this.d, 10);
      }
      localObject = DynamicChannelHeaderModule.a();
      if (localObject != null)
      {
        ((DynamicChannelHeaderModule)localObject).a(this.d);
        a(this.d, ((DynamicChannelHeaderModule)localObject).c(this.d));
        ((DynamicChannelHeaderModule)localObject).b(this.d);
      }
    }
    else
    {
      QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "has loaded data, mChannelID = ", Integer.valueOf(this.d) });
    }
  }
  
  public void cX_()
  {
    this.s = new ReadInJoyCGIDynamicChannelAdapter(v(), this.c.getRecyclerView(), this.d);
    this.c.getRecyclerView().setAdapter(this.s);
  }
  
  public void cY_()
  {
    this.c.setRefreshCallback(this.u);
  }
  
  public void cZ_()
  {
    this.s.notifyDataSetChanged();
  }
  
  public void n()
  {
    super.n();
    if (this.s != null)
    {
      QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "reportExposureAndClear, mChannelID = ", Integer.valueOf(this.d) });
      a(this.s.d());
      this.s.c();
      return;
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "mAdapter is null.");
  }
  
  public void onBindHeader(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject = DynamicChannelHeaderModule.a();
    if (localObject != null)
    {
      localObject = ((DynamicChannelHeaderModule)localObject).c(this.d);
      if ((paramInt >= 0) && (paramInt < ((List)localObject).size()))
      {
        localObject = (HeaderDataModel)((List)localObject).get(paramInt);
        paramViewHolder = (ProteusItemView)paramViewHolder.itemView;
        if ((localObject != null) && (paramViewHolder != null)) {
          ProteusSupportUtilBase.a(paramViewHolder, this.s.a(), w(), ((HeaderDataModel)localObject).b);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    DataEventDispatcher.a().a(this.t);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    DataEventDispatcher.a().b(this.t);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.cgi.ReadInJoyCGIDynamicChannelFragment
 * JD-Core Version:    0.7.0.1
 */