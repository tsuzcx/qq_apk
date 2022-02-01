package com.tencent.mobileqq.mini.entry.search.ui;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppModuleExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.comm.ItemInfo;
import com.tencent.mobileqq.mini.entry.search.comm.SearchInfo;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager.HotSearchDataChangedListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;

public class HotSearchAdapter
  extends BaseAdapter
  implements MiniAppSearchDataManager.HotSearchDataChangedListener
{
  private static final String TAG = "HotSearchAdapter";
  private List<ItemInfo> appList = new ArrayList();
  private WeakReference<Activity> mActivityReference;
  private TextView mHotTitleView;
  private int mRefer;
  
  public HotSearchAdapter(Activity paramActivity, TextView paramTextView, int paramInt)
  {
    this.mActivityReference = new WeakReference(paramActivity);
    this.mHotTitleView = paramTextView;
    this.mRefer = paramInt;
  }
  
  public int getCount()
  {
    return this.appList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.appList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    HotSearchAdapter.HotSearchViewHolder localHotSearchViewHolder;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext().getApplicationContext()).inflate(2131559451, paramViewGroup, false);
      localHotSearchViewHolder = new HotSearchAdapter.HotSearchViewHolder();
      localHotSearchViewHolder.icon = ((ImageView)paramView.findViewById(2131371320));
      localHotSearchViewHolder.ranking = ((ImageView)paramView.findViewById(2131371322));
      localHotSearchViewHolder.name = ((TextView)paramView.findViewById(2131371324));
      localHotSearchViewHolder.category = ((TextView)paramView.findViewById(2131371325));
      paramView.setTag(localHotSearchViewHolder);
    }
    for (;;)
    {
      SearchInfo localSearchInfo = (SearchInfo)this.appList.get(paramInt);
      try
      {
        localHotSearchViewHolder.update(paramView, localSearchInfo, (Activity)this.mActivityReference.get(), paramInt, this.mRefer);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localHotSearchViewHolder = (HotSearchAdapter.HotSearchViewHolder)paramView.getTag();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("HotSearchAdapter", 1, "getView exception: " + Log.getStackTraceString(localException));
        }
      }
    }
  }
  
  public void onHotSearchDataChanged()
  {
    Object localObject = (MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_SEARCH_MANAGER);
    setData(((MiniAppSearchDataManager)localObject).getHotSearchData());
    notifyDataSetChanged();
    if (!TextUtils.isEmpty(((MiniAppSearchDataManager)localObject).getHotSearchTitle())) {
      this.mHotTitleView.setText(((MiniAppSearchDataManager)localObject).getHotSearchTitle());
    }
    localObject = (MiniAppExposureManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER);
    Iterator localIterator = this.appList.iterator();
    while (localIterator.hasNext())
    {
      MiniAppConfig localMiniAppConfig = new MiniAppConfig(((SearchInfo)localIterator.next()).miniAppInfo);
      localMiniAppConfig.launchParam.scene = this.mRefer;
      ((MiniAppExposureManager)localObject).addSearchItemAndCheckReport(new MiniAppExposureManager.MiniAppModuleExposureData(localMiniAppConfig, "page_view", "expo"));
    }
  }
  
  public void setData(List<ItemInfo> paramList)
  {
    this.appList.clear();
    this.appList.addAll(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.HotSearchAdapter
 * JD-Core Version:    0.7.0.1
 */