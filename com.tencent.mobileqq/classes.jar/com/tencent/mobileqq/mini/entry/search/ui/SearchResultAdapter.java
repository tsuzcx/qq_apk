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
import bcyz;
import bdoo;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.comm.SearchInfo;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager.SearchResultDataChangedListener;
import com.tencent.qphone.base.util.QLog;
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
  
  public SearchResultAdapter(Activity paramActivity)
  {
    this.mActivityReference = new WeakReference(paramActivity);
  }
  
  public static Drawable getAvatarDrawable(Context paramContext, String paramString)
  {
    paramContext = paramContext.getResources().getDrawable(2130840085);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramContext;
    localURLDrawableOptions.mFailedDrawable = paramContext;
    int i = bdoo.a(12.0F);
    localURLDrawableOptions.mRequestHeight = i;
    localURLDrawableOptions.mRequestWidth = i;
    paramContext = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramContext.setTag(bcyz.a(bdoo.a(12.0F), bdoo.a(12.0F)));
    paramContext.setDecodeHandler(bcyz.o);
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
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext().getApplicationContext()).inflate(2131559317, paramViewGroup, false);
      paramViewGroup = new SearchResultAdapter.SearchResultViewHolder();
      paramViewGroup.icon = ((ImageView)paramView.findViewById(2131370553));
      paramViewGroup.name = ((TextView)paramView.findViewById(2131370554));
      paramViewGroup.category = ((TextView)paramView.findViewById(2131370555));
      paramViewGroup.desc = ((TextView)paramView.findViewById(2131370552));
      paramViewGroup.userNumDesc = ((TextView)paramView.findViewById(2131370565));
      paramViewGroup.divider = paramView.findViewById(2131370558);
      paramViewGroup.avatarContainer = ((LinearLayout)paramView.findViewById(2131370556));
      paramViewGroup.payingFriendsDesc = ((TextView)paramView.findViewById(2131370561));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      SearchInfo localSearchInfo = (SearchInfo)this.appList.get(paramInt);
      try
      {
        paramViewGroup.update(paramView, localSearchInfo, (Activity)this.mActivityReference.get(), this.mKeyword);
        return paramView;
      }
      catch (Exception paramViewGroup)
      {
        QLog.e("SearchResultAdapter", 1, "getView exception: " + Log.getStackTraceString(paramViewGroup));
      }
      paramViewGroup = (SearchResultAdapter.SearchResultViewHolder)paramView.getTag();
    }
    return paramView;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */