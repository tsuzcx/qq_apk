package com.tencent.mobileqq.mini.entry.search.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bhez;
import bhtq;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.comm.SearchInfo;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager.SearchResultDataChangedListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.util.WeakReference;

public class SearchResultAdapter
  extends BaseAdapter
  implements MiniAppSearchDataManager.SearchResultDataChangedListener
{
  private static final int HIGH_LIGHT_COLOR = -14763268;
  private static final String TAG = "SearchResultAdapter";
  private List<SearchInfo> appList = new ArrayList();
  private WeakReference<Activity> mActivityReference;
  private SearchResultAdapter.DataChangedListener mDataChangedListener;
  private String mKeyword;
  private int mRefer;
  
  public SearchResultAdapter(Activity paramActivity, int paramInt)
  {
    this.mActivityReference = new WeakReference(paramActivity);
    this.mRefer = paramInt;
  }
  
  public static Drawable getAvatarDrawable(Context paramContext, String paramString)
  {
    paramContext = paramContext.getResources().getDrawable(2130840274);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramContext;
    localURLDrawableOptions.mFailedDrawable = paramContext;
    int i = bhtq.a(12.0F);
    localURLDrawableOptions.mRequestHeight = i;
    localURLDrawableOptions.mRequestWidth = i;
    paramContext = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramContext.setTag(bhez.a(bhtq.a(12.0F), bhtq.a(12.0F)));
    paramContext.setDecodeHandler(bhez.p);
    return paramContext;
  }
  
  public static SpannableString highLightKeyword(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = new SpannableString(paramString1);
    paramString2 = Pattern.compile(paramString2).matcher(paramString1);
    while (paramString2.find())
    {
      int i = paramString2.start();
      int j = paramString2.end();
      paramString1.setSpan(new ForegroundColorSpan(paramInt), i, j, 33);
    }
    return paramString1;
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
    SearchResultAdapter.SearchResultViewHolder localSearchResultViewHolder;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext().getApplicationContext()).inflate(2131559412, paramViewGroup, false);
      localSearchResultViewHolder = new SearchResultAdapter.SearchResultViewHolder();
      localSearchResultViewHolder.icon = ((ImageView)paramView.findViewById(2131371161));
      localSearchResultViewHolder.name = ((TextView)paramView.findViewById(2131371162));
      localSearchResultViewHolder.category = ((TextView)paramView.findViewById(2131371163));
      localSearchResultViewHolder.desc = ((TextView)paramView.findViewById(2131371160));
      localSearchResultViewHolder.userNumDesc = ((TextView)paramView.findViewById(2131371173));
      localSearchResultViewHolder.divider = paramView.findViewById(2131371166);
      localSearchResultViewHolder.avatarContainer = ((LinearLayout)paramView.findViewById(2131371164));
      localSearchResultViewHolder.payingFriendsDesc = ((TextView)paramView.findViewById(2131371169));
      paramView.setTag(localSearchResultViewHolder);
    }
    for (;;)
    {
      SearchInfo localSearchInfo = (SearchInfo)this.appList.get(paramInt);
      try
      {
        localSearchResultViewHolder.update(paramView, localSearchInfo, (Activity)this.mActivityReference.get(), this.mKeyword, this.mRefer);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localSearchResultViewHolder = (SearchResultAdapter.SearchResultViewHolder)paramView.getTag();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("SearchResultAdapter", 1, "getView exception: " + Log.getStackTraceString(localException));
        }
      }
    }
  }
  
  public void onResultDataChanged()
  {
    setData(((MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(360)).getSearchResultData());
    notifyDataSetChanged();
    if (this.mDataChangedListener != null) {
      this.mDataChangedListener.onResultDataChanged(true);
    }
  }
  
  public void setData(List<SearchInfo> paramList)
  {
    this.appList.clear();
    this.appList.addAll(paramList);
  }
  
  public void setDataChangedListener(SearchResultAdapter.DataChangedListener paramDataChangedListener)
  {
    this.mDataChangedListener = paramDataChangedListener;
  }
  
  public void setKeyword(String paramString)
  {
    this.mKeyword = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */