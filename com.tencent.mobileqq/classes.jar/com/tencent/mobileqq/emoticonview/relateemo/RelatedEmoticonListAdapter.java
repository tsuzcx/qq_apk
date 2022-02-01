package com.tencent.mobileqq.emoticonview.relateemo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.EmotionUtils;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmotionPanelData;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class RelatedEmoticonListAdapter
  extends RecyclerView.Adapter<RelatedEmoticonListAdapter.VH>
  implements View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener
{
  private static final int IMG_HEIGHT_SPACE = 2;
  public static final int ITEM_TYPE_FOOTER = 2;
  public static final int ITEM_TYPE_HEADER = 1;
  public static final int ITEM_TYPE_NORMAL = 3;
  private static final String TAG = "RelatedEmoticonListAdapter";
  protected BaseQQAppInterface mApp;
  protected EmoticonCallback mCallback;
  private int mColumnNum = 4;
  private Context mContext;
  private String mCurFriendUin = "";
  private int mCurType = 0;
  private List<EmotionPanelData> mData = new ArrayList();
  private float mDensity;
  @Nullable
  private View mFooterView;
  @Nullable
  private View mHeaderView;
  private RelatedEmoSearchEmoticonInfo mMenuShowInfo;
  private PopupWindow mTipsPopupWindow;
  private int mWidthPixels = 0;
  
  public RelatedEmoticonListAdapter(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, EmoticonCallback paramEmoticonCallback)
  {
    this.mContext = paramContext;
    this.mCallback = paramEmoticonCallback;
    this.mApp = paramBaseQQAppInterface;
    this.mWidthPixels = ViewUtils.a();
    this.mDensity = paramContext.getResources().getDisplayMetrics().density;
  }
  
  private void addToCustomEmotionForPic(String paramString)
  {
    ((IEmosmService)QRoute.api(IEmosmService.class)).addToCustomEmotionForPic(this.mContext, paramString, false);
  }
  
  private URLImageView getRelatedSearchEmoView(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RelatedEmoticonListAdapter", 2, "getCameraEmoView");
    }
    float f1 = this.mWidthPixels;
    float f2 = this.mDensity;
    int i = this.mColumnNum;
    int j = (int)(f1 - f2 * 2.0F * (i - 1));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(j / i, j / i);
    if (paramInt == 0)
    {
      localLayoutParams.rightMargin = ((int)(this.mDensity * 1.0F));
      localLayoutParams.leftMargin = 0;
    }
    else if (paramInt == this.mColumnNum - 1)
    {
      localLayoutParams.leftMargin = ((int)(this.mDensity * 1.0F));
      localLayoutParams.rightMargin = 0;
      localLayoutParams.width = -1;
    }
    else
    {
      f1 = this.mDensity;
      localLayoutParams.rightMargin = ((int)(f1 * 1.0F));
      localLayoutParams.leftMargin = ((int)(f1 * 1.0F));
    }
    URLImageView localURLImageView = new URLImageView(this.mContext);
    localURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localURLImageView.setAdjustViewBounds(false);
    localURLImageView.setLayoutParams(localLayoutParams);
    localURLImageView.setContentDescription(this.mContext.getString(2131691247));
    return localURLImageView;
  }
  
  private void send(EmoticonInfo paramEmoticonInfo)
  {
    EmoticonCallback localEmoticonCallback = this.mCallback;
    if ((localEmoticonCallback != null) && (paramEmoticonInfo != null)) {
      localEmoticonCallback.send(paramEmoticonInfo);
    }
  }
  
  private void updateUI(View paramView, EmotionPanelData paramEmotionPanelData, int paramInt)
  {
    if ((paramView != null) && ((paramEmotionPanelData instanceof RelatedEmoSearchEmoticonInfo)))
    {
      Object localObject = (RelatedEmoSearchEmoticonInfo)paramEmotionPanelData;
      String str1 = ((RelatedEmoSearchEmoticonInfo)localObject).mResultItem.md5;
      String str2 = ((RelatedEmoSearchEmoticonInfo)localObject).mResultItem.url;
      int i = ((RelatedEmoSearchEmoticonInfo)localObject).mDefaultCount;
      localObject = (URLImageView)paramView;
      EmoticonInfo localEmoticonInfo = (EmoticonInfo)paramEmotionPanelData;
      paramView.setTag(localEmoticonInfo);
      paramView.setVisibility(0);
      if ((QLog.isColorLevel()) && (!StringUtil.a(localEmoticonInfo.action)))
      {
        paramView = new StringBuilder();
        paramView.append("updateUI info = ");
        paramView.append(localEmoticonInfo.action);
        QLog.d("RelatedEmoticonListAdapter", 2, paramView.toString());
      }
      if (((URLImageView)localObject).getTag(2131380884) == paramEmotionPanelData) {
        return;
      }
      ((URLImageView)localObject).setOnClickListener(new RelatedEmoticonListAdapter.1(this, localEmoticonInfo));
      ((URLImageView)localObject).setFocusable(true);
      ((URLImageView)localObject).setOnLongClickListener(this);
      ((URLImageView)localObject).setTag(2131380884, paramEmotionPanelData);
      ((URLImageView)localObject).setVisibility(0);
      ((URLImageView)localObject).setURLDrawableDownListener(null);
      paramView = localEmoticonInfo.getBigDrawable(this.mContext, this.mDensity);
      if ((paramView instanceof URLDrawable)) {
        ((URLImageView)localObject).setURLDrawableDownListener(new RelatedEmoticonListAdapter.2(this, localEmoticonInfo));
      }
      ((URLImageView)localObject).setImageDrawable(paramView);
      paramView = this.mApp;
      paramEmotionPanelData = this.mCurFriendUin;
      int j = EmoticonPanelUtils.a(this.mCurType);
      localObject = new StringBuilder();
      paramInt += 1;
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("");
      ReportController.b(paramView, "dc00898", "", paramEmotionPanelData, "0X800B116", "0X800B116", j, 0, "", ((StringBuilder)localObject).toString(), str1, str2);
      if (i > 0)
      {
        paramView = this.mApp;
        paramEmotionPanelData = this.mCurFriendUin;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("");
        ReportController.b(paramView, "dc00898", "", paramEmotionPanelData, "0X800B11D", "0X800B11D", i, 0, "", ((StringBuilder)localObject).toString(), str1, str2);
      }
      return;
    }
    QLog.e("RelatedEmoticonListAdapter", 1, "emotionInfo or contentView = null");
  }
  
  public List<EmotionPanelData> getData()
  {
    return this.mData;
  }
  
  public int getItemCount()
  {
    List localList = this.mData;
    int k = 0;
    int j;
    int i;
    if (localList != null)
    {
      j = localList.size();
      int m = this.mColumnNum;
      i = j / m;
      if (j % m > 0) {
        i += 1;
      }
    }
    else
    {
      i = 0;
    }
    if (this.mHeaderView != null) {
      j = 1;
    } else {
      j = 0;
    }
    if (this.mFooterView != null) {
      k = 1;
    }
    return i + j + k;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.mHeaderView != null) && (paramInt == 0)) {
      return 1;
    }
    if ((paramInt == getItemCount() - 1) && (this.mFooterView != null)) {
      return 2;
    }
    return 3;
  }
  
  public void onBindViewHolder(@NonNull RelatedEmoticonListAdapter.VH paramVH, int paramInt)
  {
    int j;
    if (paramVH.getItemViewType() != 3)
    {
      j = paramInt;
    }
    else
    {
      int i = paramInt;
      if (this.mHeaderView != null) {
        i = paramInt - 1;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getEmotionView position = ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("; view from inflater");
        QLog.d("RelatedEmoticonListAdapter", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = (LinearLayout)paramVH.itemView;
      j = 0;
      ((LinearLayout)localObject).setFocusable(false);
      ((LinearLayout)localObject).setClickable(false);
      ((LinearLayout)localObject).setDescendantFocusability(262144);
      ((LinearLayout)localObject).setFocusableInTouchMode(false);
      ((LinearLayout)localObject).setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
      ((LinearLayout)localObject).setOrientation(0);
      ((LinearLayout)localObject).setPadding(0, ViewUtils.a(2.0F), 0, 0);
      paramInt = 0;
      int k;
      for (;;)
      {
        k = this.mColumnNum;
        if (paramInt >= k) {
          break;
        }
        URLImageView localURLImageView = getRelatedSearchEmoView(paramInt);
        localURLImageView.setVisibility(8);
        localURLImageView.setFocusable(true);
        localURLImageView.setFocusableInTouchMode(true);
        ((LinearLayout)localObject).addView(localURLImageView);
        paramInt += 1;
      }
      paramVH.contentViews = new URLImageView[k];
      paramInt = 0;
      while (paramInt < this.mColumnNum)
      {
        paramVH.contentViews[paramInt] = ((URLImageView)((LinearLayout)localObject).getChildAt(paramInt));
        paramInt += 1;
      }
      ((LinearLayout)localObject).setTag(paramVH);
      paramInt = j;
      for (;;)
      {
        k = this.mColumnNum;
        j = i;
        if (paramInt >= k) {
          break;
        }
        j = k * i + paramInt;
        if (j > this.mData.size() - 1)
        {
          paramVH.contentViews[paramInt].setTag(null);
          paramVH.contentViews[paramInt].setVisibility(8);
        }
        else
        {
          updateUI(paramVH.contentViews[paramInt], (EmotionPanelData)this.mData.get(j), j);
        }
        paramInt += 1;
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramVH, j, getItemId(j));
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362241)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RelatedEmoticonListAdapter", 4, " add_to_custom_face ");
      }
      Object localObject = this.mTipsPopupWindow;
      if ((localObject != null) && (((PopupWindow)localObject).isShowing()))
      {
        localObject = this.mMenuShowInfo;
        if (localObject != null)
        {
          addToCustomEmotionForPic(((RelatedEmoSearchEmoticonInfo)localObject).mResultItem.url);
          localObject = this.mApp;
          String str = this.mCurFriendUin;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.mMenuShowInfo.mReportPosition + 1);
          localStringBuilder.append("");
          ReportController.b((AppRuntime)localObject, "dc00898", "", str, "0X800B119", "0X800B119", 0, 0, "", localStringBuilder.toString(), this.mMenuShowInfo.mResultItem.md5, this.mMenuShowInfo.mResultItem.url);
          this.mMenuShowInfo = null;
        }
        this.mTipsPopupWindow.dismiss();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @NonNull
  public RelatedEmoticonListAdapter.VH onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1) {
      return new RelatedEmoticonListAdapter.VH(this.mHeaderView);
    }
    if (paramInt == 2) {
      return new RelatedEmoticonListAdapter.VH(this.mFooterView);
    }
    return new RelatedEmoticonListAdapter.VH(new RelatedEmoLinearLayout(paramViewGroup.getContext()));
  }
  
  public void onDismiss()
  {
    this.mTipsPopupWindow = null;
    this.mMenuShowInfo = null;
  }
  
  public boolean onLongClick(View paramView)
  {
    if (!(paramView instanceof URLImageView)) {
      return false;
    }
    showAddCustomFacePop(paramView);
    this.mMenuShowInfo = ((RelatedEmoSearchEmoticonInfo)paramView.getTag(2131380884));
    if (this.mMenuShowInfo != null)
    {
      paramView = this.mApp;
      String str = this.mCurFriendUin;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mMenuShowInfo.mReportPosition + 1);
      localStringBuilder.append("");
      ReportController.b(paramView, "dc00898", "", str, "0X800B118", "0X800B118", 0, 0, "", localStringBuilder.toString(), this.mMenuShowInfo.mResultItem.md5, this.mMenuShowInfo.mResultItem.url);
    }
    return false;
  }
  
  public void setData(@Nullable View paramView1, @Nullable View paramView2, List<EmotionPanelData> paramList)
  {
    this.mHeaderView = paramView1;
    this.mFooterView = paramView2;
    this.mData.clear();
    if (paramList != null) {
      this.mData.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public void setData(List<EmotionPanelData> paramList)
  {
    setData(this.mHeaderView, this.mFooterView, paramList);
  }
  
  public void setReportMessage(String paramString, int paramInt)
  {
    this.mCurFriendUin = paramString;
    this.mCurType = paramInt;
  }
  
  public void showAddCustomFacePop(View paramView)
  {
    LinearLayout localLinearLayout = new LinearLayout(this.mContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setGravity(1);
    Object localObject = new TextView(this.mContext);
    ((TextView)localObject).setId(2131362241);
    ((TextView)localObject).setOnClickListener(this);
    ((TextView)localObject).setTextColor(this.mContext.getResources().getColor(2131167394));
    ((TextView)localObject).setTextSize(14.0F);
    ((TextView)localObject).setGravity(17);
    ((TextView)localObject).setText(this.mContext.getResources().getString(2131699745));
    ((TextView)localObject).setBackgroundResource(2130838897);
    localLinearLayout.addView((View)localObject, new LinearLayout.LayoutParams(ViewUtils.a(65.0F), ViewUtils.a(46.0F)));
    localObject = new ImageView(this.mContext);
    ((ImageView)localObject).setImageDrawable(this.mContext.getResources().getDrawable(2130838864));
    localLinearLayout.addView((View)localObject, new LinearLayout.LayoutParams(ViewUtils.a(20.0F), ViewUtils.a(10.0F)));
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
    localLayoutParams.topMargin = (-EmotionUtils.a(7.0F, this.mContext.getResources()));
    localLayoutParams.bottomMargin = EmotionUtils.a(3.0F, this.mContext.getResources());
    ((ImageView)localObject).setLayoutParams(localLayoutParams);
    this.mTipsPopupWindow = new PopupWindow(localLinearLayout, -2, -2);
    this.mTipsPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
    this.mTipsPopupWindow.setOutsideTouchable(true);
    this.mTipsPopupWindow.setFocusable(true);
    this.mTipsPopupWindow.setOnDismissListener(this);
    localLinearLayout.measure(0, 0);
    paramView.post(new RelatedEmoticonListAdapter.3(this, paramView, localLinearLayout));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoticonListAdapter
 * JD-Core Version:    0.7.0.1
 */