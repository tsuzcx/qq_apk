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
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppModuleExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.comm.SearchInfo;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager.HotSearchDataChangedListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;

public class HotSearchAdapter
  extends BaseAdapter
  implements MiniAppSearchDataManager.HotSearchDataChangedListener
{
  private static final String TAG = "HotSearchAdapter";
  private List<SearchInfo> appList = new ArrayList();
  private WeakReference<Activity> mActivityReference;
  private TextView mHotTitleView;
  
  public HotSearchAdapter(Activity paramActivity, TextView paramTextView)
  {
    this.mActivityReference = new WeakReference(paramActivity);
    this.mHotTitleView = paramTextView;
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
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext().getApplicationContext()).inflate(2131559316, paramViewGroup, false);
      paramViewGroup = new HotSearchAdapter.HotSearchViewHolder();
      paramViewGroup.icon = ((ImageView)paramView.findViewById(2131370546));
      paramViewGroup.ranking = ((ImageView)paramView.findViewById(2131370548));
      paramViewGroup.name = ((TextView)paramView.findViewById(2131370550));
      paramViewGroup.category = ((TextView)paramView.findViewById(2131370551));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      SearchInfo localSearchInfo = (SearchInfo)this.appList.get(paramInt);
      try
      {
        paramViewGroup.update(paramView, localSearchInfo, (Activity)this.mActivityReference.get(), paramInt);
        return paramView;
      }
      catch (Exception paramViewGroup)
      {
        QLog.e("HotSearchAdapter", 1, "getView exception: " + Log.getStackTraceString(paramViewGroup));
      }
      paramViewGroup = (HotSearchAdapter.HotSearchViewHolder)paramView.getTag();
    }
    return paramView;
  }
  
  public void onHotSearchDataChanged()
  {
    Object localObject = (MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(360);
    setData(((MiniAppSearchDataManager)localObject).getHotSearchData());
    notifyDataSetChanged();
    if (!TextUtils.isEmpty(((MiniAppSearchDataManager)localObject).getHotSearchTitle())) {
      this.mHotTitleView.setText(((MiniAppSearchDataManager)localObject).getHotSearchTitle());
    }
    localObject = (MiniAppExposureManager)MiniAppUtils.getAppInterface().getManager(322);
    Iterator localIterator = this.appList.iterator();
    while (localIterator.hasNext())
    {
      MiniAppConfig localMiniAppConfig = new MiniAppConfig(((SearchInfo)localIterator.next()).miniAppInfo);
      localMiniAppConfig.launchParam.scene = 2077;
      ((MiniAppExposureManager)localObject).addSearchItemAndCheckReport(new MiniAppExposureManager.MiniAppModuleExposureData(localMiniAppConfig, "page_view", "expo"));
    }
  }
  
  public void setData(List<SearchInfo> paramList)
  {
    this.appList.clear();
    this.appList.addAll(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.HotSearchAdapter
 * JD-Core Version:    0.7.0.1
 */