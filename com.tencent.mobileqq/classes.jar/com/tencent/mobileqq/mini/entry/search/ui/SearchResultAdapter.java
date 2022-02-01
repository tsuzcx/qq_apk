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
import android.widget.RelativeLayout;
import android.widget.TextView;
import bgxc;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.comm.SearchInfo;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager.SearchResultDataChangedListener;
import com.tencent.mobileqq.utils.ViewUtils;
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
  
  /* Error */
  private static View createCouponView(NS_STORE_APP_SEARCH.MiniAppSearch.CouponInfo paramCouponInfo, View paramView)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 56	NS_STORE_APP_SEARCH/MiniAppSearch$CouponInfo:leastPrice	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4: invokevirtual 62	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   7: astore_3
    //   8: aload_0
    //   9: getfield 65	NS_STORE_APP_SEARCH/MiniAppSearch$CouponInfo:amt	Lcom/tencent/mobileqq/pb/PBStringField;
    //   12: invokevirtual 62	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   15: astore 4
    //   17: aload_0
    //   18: getfield 68	NS_STORE_APP_SEARCH/MiniAppSearch$CouponInfo:iconUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   21: invokevirtual 62	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   24: astore 6
    //   26: aload_3
    //   27: invokestatic 74	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   30: invokevirtual 78	java/lang/Integer:intValue	()I
    //   33: bipush 100
    //   35: idiv
    //   36: istore_2
    //   37: iload_2
    //   38: invokestatic 83	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   41: astore_0
    //   42: aload 4
    //   44: invokestatic 74	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   47: invokevirtual 78	java/lang/Integer:intValue	()I
    //   50: bipush 100
    //   52: idiv
    //   53: istore_2
    //   54: iload_2
    //   55: invokestatic 83	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   58: astore_3
    //   59: new 85	android/widget/LinearLayout
    //   62: dup
    //   63: aload_1
    //   64: invokevirtual 91	android/view/View:getContext	()Landroid/content/Context;
    //   67: invokespecial 94	android/widget/LinearLayout:<init>	(Landroid/content/Context;)V
    //   70: astore 4
    //   72: aload 4
    //   74: iconst_0
    //   75: invokevirtual 98	android/widget/LinearLayout:setOrientation	(I)V
    //   78: new 100	android/widget/LinearLayout$LayoutParams
    //   81: dup
    //   82: bipush 254
    //   84: ldc 101
    //   86: invokestatic 107	com/tencent/mobileqq/utils/ViewUtils:dpToPx	(F)I
    //   89: invokespecial 110	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   92: astore 5
    //   94: aload 5
    //   96: ldc 111
    //   98: invokestatic 107	com/tencent/mobileqq/utils/ViewUtils:dpToPx	(F)I
    //   101: putfield 114	android/widget/LinearLayout$LayoutParams:rightMargin	I
    //   104: aload 4
    //   106: aload 5
    //   108: invokevirtual 118	android/widget/LinearLayout:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   111: new 120	android/widget/TextView
    //   114: dup
    //   115: aload_1
    //   116: invokevirtual 91	android/view/View:getContext	()Landroid/content/Context;
    //   119: invokespecial 121	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   122: astore 7
    //   124: new 100	android/widget/LinearLayout$LayoutParams
    //   127: dup
    //   128: ldc 122
    //   130: invokestatic 107	com/tencent/mobileqq/utils/ViewUtils:dpToPx	(F)I
    //   133: iconst_m1
    //   134: invokespecial 110	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   137: astore 5
    //   139: aload 5
    //   141: bipush 17
    //   143: putfield 125	android/widget/LinearLayout$LayoutParams:gravity	I
    //   146: aload 7
    //   148: aload_3
    //   149: invokevirtual 129	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   152: aload 7
    //   154: iconst_m1
    //   155: invokevirtual 132	android/widget/TextView:setTextColor	(I)V
    //   158: aload 7
    //   160: iconst_1
    //   161: ldc 133
    //   163: invokevirtual 137	android/widget/TextView:setTextSize	(IF)V
    //   166: aload 7
    //   168: bipush 17
    //   170: invokevirtual 140	android/widget/TextView:setGravity	(I)V
    //   173: aload 7
    //   175: aload 6
    //   177: aconst_null
    //   178: invokestatic 146	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   181: invokevirtual 150	android/widget/TextView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   184: aload 7
    //   186: ldc 152
    //   188: iconst_3
    //   189: invokestatic 158	android/graphics/Typeface:create	(Ljava/lang/String;I)Landroid/graphics/Typeface;
    //   192: invokevirtual 162	android/widget/TextView:setTypeface	(Landroid/graphics/Typeface;)V
    //   195: aload 7
    //   197: aload 5
    //   199: invokevirtual 163	android/widget/TextView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   202: aload 4
    //   204: aload 7
    //   206: invokevirtual 167	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   209: new 120	android/widget/TextView
    //   212: dup
    //   213: aload_1
    //   214: invokevirtual 91	android/view/View:getContext	()Landroid/content/Context;
    //   217: invokespecial 121	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   220: astore_1
    //   221: new 100	android/widget/LinearLayout$LayoutParams
    //   224: dup
    //   225: bipush 254
    //   227: iconst_m1
    //   228: invokespecial 110	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   231: astore 6
    //   233: aload 5
    //   235: bipush 17
    //   237: putfield 125	android/widget/LinearLayout$LayoutParams:gravity	I
    //   240: ldc 168
    //   242: invokestatic 107	com/tencent/mobileqq/utils/ViewUtils:dpToPx	(F)I
    //   245: istore_2
    //   246: aload_1
    //   247: iload_2
    //   248: iconst_0
    //   249: iload_2
    //   250: iconst_0
    //   251: invokevirtual 172	android/widget/TextView:setPadding	(IIII)V
    //   254: aload_1
    //   255: new 174	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   262: aload_0
    //   263: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: ldc 181
    //   268: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload_3
    //   272: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: ldc 183
    //   277: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokevirtual 129	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   286: aload_1
    //   287: ldc 187
    //   289: invokevirtual 132	android/widget/TextView:setTextColor	(I)V
    //   292: aload_1
    //   293: iconst_1
    //   294: ldc 188
    //   296: invokevirtual 137	android/widget/TextView:setTextSize	(IF)V
    //   299: aload_1
    //   300: bipush 17
    //   302: invokevirtual 140	android/widget/TextView:setGravity	(I)V
    //   305: aload_1
    //   306: aload 6
    //   308: invokevirtual 163	android/widget/TextView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   311: aload 4
    //   313: aload_1
    //   314: invokevirtual 167	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   317: aload 4
    //   319: ldc 189
    //   321: invokevirtual 192	android/widget/LinearLayout:setBackgroundResource	(I)V
    //   324: aload 4
    //   326: areturn
    //   327: astore 5
    //   329: aload_3
    //   330: astore_0
    //   331: aload 5
    //   333: astore_3
    //   334: ldc 13
    //   336: iconst_1
    //   337: new 174	java/lang/StringBuilder
    //   340: dup
    //   341: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   344: ldc 194
    //   346: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: aload_3
    //   350: invokestatic 200	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   353: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokestatic 206	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   362: aload 4
    //   364: astore_3
    //   365: goto -306 -> 59
    //   368: astore_3
    //   369: goto -35 -> 334
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	372	0	paramCouponInfo	NS_STORE_APP_SEARCH.MiniAppSearch.CouponInfo
    //   0	372	1	paramView	View
    //   36	214	2	i	int
    //   7	358	3	localObject1	Object
    //   368	1	3	localException1	Exception
    //   15	348	4	localObject2	Object
    //   92	142	5	localLayoutParams	android.widget.LinearLayout.LayoutParams
    //   327	5	5	localException2	Exception
    //   24	283	6	localObject3	Object
    //   122	83	7	localTextView	TextView
    // Exception table:
    //   from	to	target	type
    //   26	37	327	java/lang/Exception
    //   42	54	368	java/lang/Exception
  }
  
  public static Drawable getAvatarDrawable(Context paramContext, String paramString)
  {
    paramContext = paramContext.getResources().getDrawable(2130840348);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramContext;
    localURLDrawableOptions.mFailedDrawable = paramContext;
    int i = ViewUtils.dip2px(12.0F);
    localURLDrawableOptions.mRequestHeight = i;
    localURLDrawableOptions.mRequestWidth = i;
    paramContext = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramContext.setTag(bgxc.a(ViewUtils.dip2px(12.0F), ViewUtils.dip2px(12.0F)));
    paramContext.setDecodeHandler(bgxc.p);
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
      paramView = LayoutInflater.from(paramViewGroup.getContext().getApplicationContext()).inflate(2131559452, paramViewGroup, false);
      localSearchResultViewHolder = new SearchResultAdapter.SearchResultViewHolder();
      localSearchResultViewHolder.icon = ((ImageView)paramView.findViewById(2131371327));
      localSearchResultViewHolder.name = ((TextView)paramView.findViewById(2131371328));
      localSearchResultViewHolder.category = ((TextView)paramView.findViewById(2131371329));
      localSearchResultViewHolder.desc = ((TextView)paramView.findViewById(2131371326));
      localSearchResultViewHolder.userNumDesc = ((TextView)paramView.findViewById(2131371338));
      localSearchResultViewHolder.divider = paramView.findViewById(2131371332);
      localSearchResultViewHolder.avatarContainer = ((LinearLayout)paramView.findViewById(2131371330));
      localSearchResultViewHolder.payingFriendsDesc = ((TextView)paramView.findViewById(2131371334));
      localSearchResultViewHolder.couponTitle = ((TextView)paramView.findViewById(2131371307));
      localSearchResultViewHolder.pkRankingContainer = ((RelativeLayout)paramView.findViewById(2131371319));
      localSearchResultViewHolder.couponScrollView = ((ViewGroup)paramView.findViewById(2131371306));
      localSearchResultViewHolder.couponContainer = ((LinearLayout)paramView.findViewById(2131371305));
      localSearchResultViewHolder.mRanking.add(new SearchResultAdapter.Item(paramView.findViewById(2131371206)));
      localSearchResultViewHolder.mRanking.add(new SearchResultAdapter.Item(paramView.findViewById(2131371207)));
      localSearchResultViewHolder.mRanking.add(new SearchResultAdapter.Item(paramView.findViewById(2131371208)));
      localSearchResultViewHolder.mRanking.add(new SearchResultAdapter.Item(paramView.findViewById(2131371209)));
      ((SearchResultAdapter.Item)localSearchResultViewHolder.mRanking.get(0)).mCrown.setVisibility(0);
      ((SearchResultAdapter.Item)localSearchResultViewHolder.mRanking.get(3)).setOutOfRankStyle();
      paramView.setTag(localSearchResultViewHolder);
    }
    for (;;)
    {
      SearchInfo localSearchInfo = (SearchInfo)this.appList.get(paramInt);
      try
      {
        localSearchResultViewHolder.update(localSearchResultViewHolder, paramView, localSearchInfo, (Activity)this.mActivityReference.get(), this.mKeyword, this.mRefer);
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
    setData(((MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_SEARCH_MANAGER)).getSearchResultData());
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