package com.tencent.mobileqq.emoticonview.relateemo;

import ahsl;
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
import bcsa;
import bdla;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.EmotionPanelData;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RelatedEmoticonListAdapter
  extends RecyclerView.Adapter<RelatedEmoticonListAdapter.VH>
  implements View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener
{
  private static final int IMG_HEIGHT_SPACE = 2;
  public static final int ITEM_TYPE_FOOTER = 2;
  public static final int ITEM_TYPE_HEADER = 1;
  public static final int ITEM_TYPE_NORMAL = 3;
  private static final String TAG = "RelatedEmoticonListAdapter";
  protected QQAppInterface mApp;
  protected EmoticonCallback mCallback;
  private int mColumnNum = 4;
  private Context mContext;
  private String mCurFriendUin = "";
  private int mCurType;
  private List<EmotionPanelData> mData = new ArrayList();
  private float mDensity;
  @Nullable
  private View mFooterView;
  @Nullable
  private View mHeaderView;
  private RelatedEmoSearchEmoticonInfo mMenuShowInfo;
  private PopupWindow mTipsPopupWindow;
  private int mWidthPixels;
  
  public RelatedEmoticonListAdapter(QQAppInterface paramQQAppInterface, Context paramContext, EmoticonCallback paramEmoticonCallback)
  {
    this.mContext = paramContext;
    this.mCallback = paramEmoticonCallback;
    this.mApp = paramQQAppInterface;
    this.mWidthPixels = ViewUtils.getScreenWidth();
    this.mDensity = paramContext.getResources().getDisplayMetrics().density;
  }
  
  private void addToCustomEmotionForPic(String paramString)
  {
    File localFile = AbsDownloader.getFile(paramString);
    if ((localFile == null) || (!localFile.exists()))
    {
      QLog.e("RelatedEmoticonListAdapter", 4, " add custom fail file no exist");
      return;
    }
    MessageForPic localMessageForPic = (MessageForPic)bcsa.a(-2000);
    localMessageForPic.path = localFile.getAbsolutePath();
    localMessageForPic.md5 = HexUtil.bytes2HexStr(MD5.getFileMd5(localMessageForPic.path));
    localMessageForPic.thumbMsgUrl = paramString;
    localMessageForPic.bigMsgUrl = paramString;
    localMessageForPic.imageType = 2000;
    paramString = URLDrawableHelper.getDrawable(paramString);
    paramString.setTag(localMessageForPic);
    ahsl.a(this.mContext, this.mApp, paramString, this.mCurFriendUin, this.mContext.getResources().getDimensionPixelSize(2131299080), null, localMessageForPic.picExtraData);
  }
  
  private URLImageView getRelatedSearchEmoView(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RelatedEmoticonListAdapter", 2, "getCameraEmoView");
    }
    int i = (int)(this.mWidthPixels - 2.0F * this.mDensity * (this.mColumnNum - 1));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i / this.mColumnNum, i / this.mColumnNum);
    if (paramInt == 0)
    {
      localLayoutParams.rightMargin = ((int)(this.mDensity * 1.0F));
      localLayoutParams.leftMargin = 0;
    }
    for (;;)
    {
      URLImageView localURLImageView = new URLImageView(this.mContext);
      localURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localURLImageView.setAdjustViewBounds(false);
      localURLImageView.setLayoutParams(localLayoutParams);
      localURLImageView.setContentDescription(this.mContext.getString(2131691219));
      return localURLImageView;
      if (paramInt == this.mColumnNum - 1)
      {
        localLayoutParams.leftMargin = ((int)(this.mDensity * 1.0F));
        localLayoutParams.rightMargin = 0;
        localLayoutParams.width = -1;
      }
      else
      {
        localLayoutParams.rightMargin = ((int)(this.mDensity * 1.0F));
        localLayoutParams.leftMargin = ((int)(this.mDensity * 1.0F));
      }
    }
  }
  
  private void send(EmoticonInfo paramEmoticonInfo)
  {
    if ((this.mCallback != null) && (paramEmoticonInfo != null)) {
      this.mCallback.send(paramEmoticonInfo);
    }
  }
  
  private void updateUI(View paramView, EmotionPanelData paramEmotionPanelData, int paramInt)
  {
    if ((paramView == null) || (!(paramEmotionPanelData instanceof RelatedEmoSearchEmoticonInfo))) {
      QLog.e("RelatedEmoticonListAdapter", 1, "emotionInfo or contentView = null");
    }
    String str1;
    String str2;
    int i;
    do
    {
      URLImageView localURLImageView;
      EmoticonInfo localEmoticonInfo;
      do
      {
        return;
        str1 = ((RelatedEmoSearchEmoticonInfo)paramEmotionPanelData).mResultItem.md5;
        str2 = ((RelatedEmoSearchEmoticonInfo)paramEmotionPanelData).mResultItem.url;
        i = ((RelatedEmoSearchEmoticonInfo)paramEmotionPanelData).mDefaultCount;
        localURLImageView = (URLImageView)paramView;
        localEmoticonInfo = (EmoticonInfo)paramEmotionPanelData;
        paramView.setTag(localEmoticonInfo);
        paramView.setVisibility(0);
        if ((QLog.isColorLevel()) && (!StringUtil.isEmpty(localEmoticonInfo.action))) {
          QLog.d("RelatedEmoticonListAdapter", 2, "updateUI info = " + localEmoticonInfo.action);
        }
      } while (localURLImageView.getTag(2131381183) == paramEmotionPanelData);
      localURLImageView.setOnClickListener(new RelatedEmoticonListAdapter.1(this, localEmoticonInfo));
      localURLImageView.setFocusable(true);
      localURLImageView.setOnLongClickListener(this);
      localURLImageView.setTag(2131381183, paramEmotionPanelData);
      localURLImageView.setVisibility(0);
      localURLImageView.setURLDrawableDownListener(null);
      paramView = localEmoticonInfo.getBigDrawable(this.mContext, this.mDensity);
      if ((paramView instanceof URLDrawable)) {
        localURLImageView.setURLDrawableDownListener(new RelatedEmoticonListAdapter.2(this, localEmoticonInfo));
      }
      localURLImageView.setImageDrawable(paramView);
      bdla.b(this.mApp, "dc00898", "", this.mCurFriendUin, "0X800B116", "0X800B116", EmoticonUtils.getRelatedEmotionReportFromType(this.mCurType), 0, "", paramInt + 1 + "", str1, str2);
    } while (i <= 0);
    bdla.b(this.mApp, "dc00898", "", this.mCurFriendUin, "0X800B11D", "0X800B11D", i, 0, "", paramInt + 1 + "", str1, str2);
  }
  
  public List<EmotionPanelData> getData()
  {
    return this.mData;
  }
  
  public int getItemCount()
  {
    int k = 1;
    int j;
    if (this.mData != null)
    {
      int m = this.mData.size();
      j = m / this.mColumnNum;
      i = j;
      if (m % this.mColumnNum <= 0) {}
    }
    for (int i = j + 1;; i = 0)
    {
      if (this.mHeaderView != null)
      {
        j = 1;
        if (this.mFooterView == null) {
          break label71;
        }
      }
      for (;;)
      {
        return i + j + k;
        j = 0;
        break;
        label71:
        k = 0;
      }
    }
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
    int j = 0;
    if (paramVH.getItemViewType() != 3) {
      j = paramInt;
    }
    int i;
    do
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramVH, j, getItemId(j));
      return;
      i = paramInt;
      if (this.mHeaderView != null) {
        i = paramInt - 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RelatedEmoticonListAdapter", 2, "getEmotionView position = " + i + "; view from inflater");
      }
      LinearLayout localLinearLayout = (LinearLayout)paramVH.itemView;
      localLinearLayout.setFocusable(false);
      localLinearLayout.setClickable(false);
      localLinearLayout.setDescendantFocusability(262144);
      localLinearLayout.setFocusableInTouchMode(false);
      localLinearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
      localLinearLayout.setOrientation(0);
      localLinearLayout.setPadding(0, ViewUtils.dip2px(2.0F), 0, 0);
      paramInt = 0;
      while (paramInt < this.mColumnNum)
      {
        URLImageView localURLImageView = getRelatedSearchEmoView(paramInt);
        localURLImageView.setVisibility(8);
        localURLImageView.setFocusable(true);
        localURLImageView.setFocusableInTouchMode(true);
        localLinearLayout.addView(localURLImageView);
        paramInt += 1;
      }
      paramVH.contentViews = new URLImageView[this.mColumnNum];
      paramInt = 0;
      while (paramInt < this.mColumnNum)
      {
        paramVH.contentViews[paramInt] = ((URLImageView)localLinearLayout.getChildAt(paramInt));
        paramInt += 1;
      }
      localLinearLayout.setTag(paramVH);
      paramInt = j;
      j = i;
    } while (paramInt >= this.mColumnNum);
    j = this.mColumnNum * i + paramInt;
    if (j > this.mData.size() - 1)
    {
      paramVH.contentViews[paramInt].setTag(null);
      paramVH.contentViews[paramInt].setVisibility(8);
    }
    for (;;)
    {
      paramInt += 1;
      break;
      updateUI(paramVH.contentViews[paramInt], (EmotionPanelData)this.mData.get(j), j);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362198)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RelatedEmoticonListAdapter", 4, " add_to_custom_face ");
      }
      if ((this.mTipsPopupWindow != null) && (this.mTipsPopupWindow.isShowing())) {
        break label50;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label50:
      if (this.mMenuShowInfo != null)
      {
        addToCustomEmotionForPic(this.mMenuShowInfo.mResultItem.url);
        bdla.b(this.mApp, "dc00898", "", this.mCurFriendUin, "0X800B119", "0X800B119", 0, 0, "", this.mMenuShowInfo.mReportPosition + 1 + "", this.mMenuShowInfo.mResultItem.md5, this.mMenuShowInfo.mResultItem.url);
        this.mMenuShowInfo = null;
      }
      this.mTipsPopupWindow.dismiss();
    }
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
    if (!(paramView instanceof URLImageView)) {}
    do
    {
      return false;
      showAddCustomFacePop(paramView);
      this.mMenuShowInfo = ((RelatedEmoSearchEmoticonInfo)paramView.getTag(2131381183));
    } while (this.mMenuShowInfo == null);
    bdla.b(this.mApp, "dc00898", "", this.mCurFriendUin, "0X800B118", "0X800B118", 0, 0, "", this.mMenuShowInfo.mReportPosition + 1 + "", this.mMenuShowInfo.mResultItem.md5, this.mMenuShowInfo.mResultItem.url);
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
    ((TextView)localObject).setId(2131362198);
    ((TextView)localObject).setOnClickListener(this);
    ((TextView)localObject).setTextColor(this.mContext.getResources().getColor(2131167363));
    ((TextView)localObject).setTextSize(14.0F);
    ((TextView)localObject).setGravity(17);
    ((TextView)localObject).setText(this.mContext.getResources().getString(2131693145));
    ((TextView)localObject).setBackgroundResource(2130838976);
    localLinearLayout.addView((View)localObject, new LinearLayout.LayoutParams(ViewUtils.dip2px(65.0F), ViewUtils.dip2px(46.0F)));
    localObject = new ImageView(this.mContext);
    ((ImageView)localObject).setImageDrawable(this.mContext.getResources().getDrawable(2130838968));
    localLinearLayout.addView((View)localObject, new LinearLayout.LayoutParams(ViewUtils.dip2px(20.0F), ViewUtils.dip2px(10.0F)));
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
    localLayoutParams.topMargin = (-AIOUtils.dp2px(7.0F, this.mContext.getResources()));
    localLayoutParams.bottomMargin = AIOUtils.dp2px(3.0F, this.mContext.getResources());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoticonListAdapter
 * JD-Core Version:    0.7.0.1
 */