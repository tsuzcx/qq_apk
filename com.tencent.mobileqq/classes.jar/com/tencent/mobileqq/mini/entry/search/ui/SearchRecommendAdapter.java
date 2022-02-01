package com.tencent.mobileqq.mini.entry.search.ui;

import android.app.Activity;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.comm.ItemInfo;
import com.tencent.mobileqq.mini.entry.search.comm.LiveInfo;
import com.tencent.mobileqq.mini.entry.search.comm.SearchInfo;
import com.tencent.mobileqq.mini.entry.search.comm.TitleInfo;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager.HotSearchDataChangedListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

public class SearchRecommendAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements MiniAppSearchDataManager.HotSearchDataChangedListener
{
  private static final int SEPARATOR_COLOR = -1315339;
  private static final String TAG = "SearchRecommendAdapter";
  private List<ItemInfo> appList = new ArrayList();
  private WeakReference<Activity> mActivityReference;
  private int mRefer;
  
  public SearchRecommendAdapter(Activity paramActivity, int paramInt)
  {
    this.mActivityReference = new WeakReference(paramActivity);
    this.mRefer = paramInt;
  }
  
  public int getItemCount()
  {
    return this.appList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.appList.get(paramInt) != null) {
      return ((ItemInfo)this.appList.get(paramInt)).getType();
    }
    return 0;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.appList.size() == 0)
    {
      paramViewHolder = new StringBuilder();
      paramViewHolder.append("onBindViewHolder, size = ");
      paramViewHolder.append(this.appList.size());
      QLog.e("SearchRecommendAdapter", 1, paramViewHolder.toString());
      return;
    }
    int i = getItemViewType(paramInt);
    if (i != 1)
    {
      if (i != 2) {
        if (i != 3)
        {
          if (i == 4) {}
        }
        else
        {
          ((SearchRecommendAdapter.LiveViewHolder)paramViewHolder).update((LiveInfo)this.appList.get(paramInt), this.mRefer);
          return;
        }
      }
      ((SearchRecommendAdapter.PlayingViewHolder)paramViewHolder).update((SearchInfo)this.appList.get(paramInt), (Activity)this.mActivityReference.get(), this.mRefer);
      return;
    }
    ((SearchRecommendAdapter.TitleViewHolder)paramViewHolder).update((TitleInfo)this.appList.get(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return null;
          }
        }
        else {
          return new SearchRecommendAdapter.LiveViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559391, paramViewGroup, false));
        }
      }
      return new SearchRecommendAdapter.PlayingViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559392, paramViewGroup, false));
    }
    return new SearchRecommendAdapter.TitleViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559394, paramViewGroup, false));
  }
  
  public void onHotSearchDataChanged()
  {
    setData(((MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_SEARCH_MANAGER)).getHotSearchData());
    notifyDataSetChanged();
  }
  
  public void setData(List<ItemInfo> paramList)
  {
    this.appList.clear();
    this.appList.addAll(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.SearchRecommendAdapter
 * JD-Core Version:    0.7.0.1
 */