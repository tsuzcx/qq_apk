package com.tencent.mobileqq.mini.entry.search.ui;

import NS_STORE_APP_SEARCH.MiniAppSearch.CouponInfo;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.comm.SearchInfo;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager.SearchResultDataChangedListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ViewUtils;
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
  private static final String[] SYNTAX_SPECIAL_WORD = { "\\", "$", "(", ")", "*", "+", ".", "[", "]", "?", "^", "{", "}", "|" };
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
  
  private static View createCouponView(MiniAppSearch.CouponInfo paramCouponInfo, View paramView)
  {
    Object localObject1 = paramCouponInfo.leastPrice.get();
    Object localObject3 = paramCouponInfo.amt.get();
    Object localObject5 = paramCouponInfo.iconUrl.get();
    paramCouponInfo = (MiniAppSearch.CouponInfo)localObject1;
    Object localObject2;
    try
    {
      localObject1 = String.valueOf(Integer.valueOf((String)localObject1).intValue() / 100);
      paramCouponInfo = (MiniAppSearch.CouponInfo)localObject1;
      localObject4 = String.valueOf(Integer.valueOf((String)localObject3).intValue() / 100);
      paramCouponInfo = (MiniAppSearch.CouponInfo)localObject1;
      localObject1 = localObject4;
    }
    catch (Exception localException)
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("createCouponView, covert exception:");
      ((StringBuilder)localObject4).append(Log.getStackTraceString(localException));
      QLog.e("SearchResultAdapter", 1, ((StringBuilder)localObject4).toString());
      localObject2 = localObject3;
    }
    localObject3 = new LinearLayout(paramView.getContext());
    ((LinearLayout)localObject3).setOrientation(0);
    Object localObject4 = new LinearLayout.LayoutParams(-2, ViewUtils.dpToPx(33.0F));
    ((LinearLayout.LayoutParams)localObject4).rightMargin = ViewUtils.dpToPx(20.0F);
    ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
    TextView localTextView = new TextView(paramView.getContext());
    localObject4 = new LinearLayout.LayoutParams(ViewUtils.dpToPx(39.0F), -1);
    ((LinearLayout.LayoutParams)localObject4).gravity = 17;
    localTextView.setText(localObject2);
    localTextView.setTextColor(-1);
    localTextView.setTextSize(1, 15.0F);
    localTextView.setGravity(17);
    localTextView.setBackgroundDrawable(URLDrawable.getDrawable((String)localObject5, null));
    localTextView.setTypeface(Typeface.create("sans-serif-condensed", 3));
    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
    ((LinearLayout)localObject3).addView(localTextView);
    paramView = new TextView(paramView.getContext());
    localObject5 = new LinearLayout.LayoutParams(-2, -1);
    ((LinearLayout.LayoutParams)localObject4).gravity = 17;
    int i = ViewUtils.dpToPx(7.0F);
    paramView.setPadding(i, 0, i, 0);
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(paramCouponInfo);
    ((StringBuilder)localObject4).append("减");
    ((StringBuilder)localObject4).append(localObject2);
    ((StringBuilder)localObject4).append("券");
    paramView.setText(((StringBuilder)localObject4).toString());
    paramView.setTextColor(-7894119);
    paramView.setTextSize(1, 12.0F);
    paramView.setGravity(17);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject5);
    ((LinearLayout)localObject3).addView(paramView);
    ((LinearLayout)localObject3).setBackgroundResource(2130841844);
    return localObject3;
  }
  
  private static String escapeSyntaxSpecialWord(String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      String[] arrayOfString = SYNTAX_SPECIAL_WORD;
      int j = arrayOfString.length;
      int i = 0;
      for (;;)
      {
        localObject = paramString;
        if (i >= j) {
          break;
        }
        String str = arrayOfString[i];
        localObject = paramString;
        if (paramString.contains(str))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("\\");
          ((StringBuilder)localObject).append(str);
          localObject = paramString.replace(str, ((StringBuilder)localObject).toString());
        }
        i += 1;
        paramString = (String)localObject;
      }
    }
    return localObject;
  }
  
  public static Drawable getAvatarDrawable(Context paramContext, String paramString)
  {
    paramContext = paramContext.getResources().getDrawable(2130841060);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramContext;
    localURLDrawableOptions.mFailedDrawable = paramContext;
    int i = ViewUtils.dip2px(12.0F);
    localURLDrawableOptions.mRequestHeight = i;
    localURLDrawableOptions.mRequestWidth = i;
    paramContext = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramContext.setTag(URLDrawableDecodeHandler.a(ViewUtils.dip2px(12.0F), ViewUtils.dip2px(12.0F)));
    paramContext.setDecodeHandler(URLDrawableDecodeHandler.o);
    return paramContext;
  }
  
  public static SpannableString highLightKeyword(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = new SpannableString(paramString1);
    paramString2 = Pattern.compile(escapeSyntaxSpecialWord(paramString2)).matcher(paramString1);
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
      paramView = LayoutInflater.from(paramViewGroup.getContext().getApplicationContext()).inflate(2131625359, paramViewGroup, false);
      paramViewGroup = new SearchResultAdapter.SearchResultViewHolder();
      paramViewGroup.icon = ((ImageView)paramView.findViewById(2131438569));
      paramViewGroup.name = ((TextView)paramView.findViewById(2131438570));
      paramViewGroup.category = ((TextView)paramView.findViewById(2131438571));
      paramViewGroup.desc = ((TextView)paramView.findViewById(2131438568));
      paramViewGroup.userNumDesc = ((TextView)paramView.findViewById(2131438580));
      paramViewGroup.divider = paramView.findViewById(2131438574);
      paramViewGroup.avatarContainer = ((LinearLayout)paramView.findViewById(2131438572));
      paramViewGroup.payingFriendsDesc = ((TextView)paramView.findViewById(2131438576));
      paramViewGroup.couponTitle = ((TextView)paramView.findViewById(2131438549));
      paramViewGroup.pkRankingContainer = ((RelativeLayout)paramView.findViewById(2131438561));
      paramViewGroup.couponScrollView = ((ViewGroup)paramView.findViewById(2131438548));
      paramViewGroup.couponContainer = ((LinearLayout)paramView.findViewById(2131438547));
      paramViewGroup.mRanking.add(new SearchResultAdapter.Item(paramView.findViewById(2131438446)));
      paramViewGroup.mRanking.add(new SearchResultAdapter.Item(paramView.findViewById(2131438447)));
      paramViewGroup.mRanking.add(new SearchResultAdapter.Item(paramView.findViewById(2131438448)));
      paramViewGroup.mRanking.add(new SearchResultAdapter.Item(paramView.findViewById(2131438449)));
      ((SearchResultAdapter.Item)paramViewGroup.mRanking.get(0)).mCrown.setVisibility(0);
      ((SearchResultAdapter.Item)paramViewGroup.mRanking.get(3)).setOutOfRankStyle();
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (SearchResultAdapter.SearchResultViewHolder)paramView.getTag();
    }
    Object localObject = (SearchInfo)this.appList.get(paramInt);
    try
    {
      paramViewGroup.update(paramViewGroup, paramView, (SearchInfo)localObject, (Activity)this.mActivityReference.get(), this.mKeyword, this.mRefer);
      return paramView;
    }
    catch (Exception paramViewGroup)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getView exception: ");
      ((StringBuilder)localObject).append(Log.getStackTraceString(paramViewGroup));
      QLog.e("SearchResultAdapter", 1, ((StringBuilder)localObject).toString());
    }
    return paramView;
  }
  
  public void onResultDataChanged()
  {
    setData(((MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_SEARCH_MANAGER)).getSearchResultData());
    notifyDataSetChanged();
    SearchResultAdapter.DataChangedListener localDataChangedListener = this.mDataChangedListener;
    if (localDataChangedListener != null) {
      localDataChangedListener.onResultDataChanged(true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */