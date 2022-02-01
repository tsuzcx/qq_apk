package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anvx;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class SmallEmotionDownloadedAdapter
  extends BaseEmotionAdapter
{
  public static final String TAG = "SmallEmotionDownloadedAdapter";
  public static final int TYPE_BTN = 1;
  public static final int TYPE_DATA = 0;
  private int businessType;
  protected EmoticonCallback callback;
  protected int emojiWidth;
  protected EmoticonPackage emotionPkg;
  BaseChatPie mBaseChatPie;
  
  public SmallEmotionDownloadedAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, EmoticonCallback paramEmoticonCallback, BaseChatPie paramBaseChatPie, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    this.businessType = paramInt4;
    this.emotionPkg = paramEmoticonPackage;
    this.callback = paramEmoticonCallback;
    this.mBaseChatPie = paramBaseChatPie;
  }
  
  public int getCount()
  {
    int i = super.getCount();
    if (i > 0)
    {
      if (this.businessType == 1) {
        return i;
      }
      return i + 1;
    }
    return 0;
  }
  
  public EmoticonPackage getEmoticonPackage()
  {
    return this.emotionPkg;
  }
  
  public View getEmotionView(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.emojiWidth = ((this.widthPixels - (int)(18.0F * this.density) * (this.columnNum + 1)) / this.columnNum);
    Object localObject1 = (SmallEmotionDownloadedAdapter.SmallEmotionDownloadedViewHolder)paramViewHolder;
    int i;
    if (getItemViewType(paramInt) == 0)
    {
      if (paramView != null) {
        break label936;
      }
      paramView = EmotionPanelViewPool.getInstance().getView(this.panelType);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SmallEmotionDownloadedAdapter", 2, "getEmotionView position = " + paramInt + ";view from inflater");
        }
        paramView = new EmoticonPanelLinearLayout(this.mContext, this.mBaseChatPie, this.businessType);
        paramView.setPanelType(EmoticonPanelLinearLayout.PANEL_TYPE_SMALL_EMOTION);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        paramView.setOrientation(0);
        paramView.setPadding(0, (int)(18.0F * this.density), 0, 0);
        i = 0;
        for (;;)
        {
          paramViewHolder = paramView;
          if (i >= this.columnNum) {
            break;
          }
          paramViewHolder = new URLImageView(this.mContext);
          paramViewGroup = new LinearLayout.LayoutParams(this.emojiWidth, this.emojiWidth);
          paramViewGroup.leftMargin = ((int)(18.0F * this.density));
          paramViewHolder.setLayoutParams(paramViewGroup);
          paramViewHolder.setVisibility(8);
          paramViewHolder.setScaleType(ImageView.ScaleType.FIT_XY);
          paramViewHolder.setAdjustViewBounds(false);
          paramViewHolder.setFocusable(true);
          paramViewHolder.setFocusableInTouchMode(true);
          paramView.addView(paramViewHolder);
          i += 1;
        }
      }
      paramViewHolder = paramView;
      if (QLog.isColorLevel())
      {
        QLog.d("SmallEmotionDownloadedAdapter", 2, "getEmotionView position = " + paramInt + ";view from cache");
        paramViewHolder = paramView;
      }
      ((EmoticonPanelLinearLayout)paramViewHolder).setCallBack(this.callback);
      recycleView(this.panelType, paramViewHolder);
      paramView = (ViewGroup)paramViewHolder;
      ((SmallEmotionDownloadedAdapter.SmallEmotionDownloadedViewHolder)localObject1).contentViews = new URLImageView[this.columnNum];
      i = 0;
      while (i < this.columnNum)
      {
        ((SmallEmotionDownloadedAdapter.SmallEmotionDownloadedViewHolder)localObject1).contentViews[i] = ((URLImageView)paramView.getChildAt(i));
        i += 1;
      }
      paramViewHolder.setTag(localObject1);
    }
    for (;;)
    {
      i = 0;
      paramView = paramViewHolder;
      int j;
      if (i < this.columnNum)
      {
        j = this.columnNum * paramInt + i;
        if (j > this.data.size() - 1)
        {
          localObject1.contentViews[i].setTag(null);
          localObject1.contentViews[i].setVisibility(8);
        }
      }
      label899:
      label911:
      label922:
      label934:
      for (;;)
      {
        i += 1;
        break;
        paramViewGroup = localObject1.contentViews[i];
        paramView = (EmotionPanelData)this.data.get(j);
        if ((paramView instanceof EmoticonInfo)) {}
        for (paramView = (EmoticonInfo)paramView;; paramView = null)
        {
          if (paramView == null) {
            break label934;
          }
          localObject1.contentViews[i].setTag(paramView);
          paramViewGroup.setImageDrawable(paramView.getDrawable(this.mContext, this.density));
          paramViewGroup.setVisibility(0);
          break;
          if (paramView == null)
          {
            paramViewGroup = new RelativeLayout(this.mContext);
            paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, (int)(57.0F * this.density)));
            LinearLayout localLinearLayout = new LinearLayout(this.mContext);
            paramViewHolder = new RelativeLayout.LayoutParams(-2, -2);
            paramViewHolder.addRule(13, -1);
            localLinearLayout.setLayoutParams(paramViewHolder);
            paramView = EmoticonRecDressup.getEmotionRecommend(this.emotionPkg.epId, true);
            Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
            localLinearLayout.setOrientation(0);
            ((LinearLayout.LayoutParams)localObject2).gravity = 16;
            TextView localTextView = new TextView(this.mContext);
            localTextView.setTextSize(14.0F);
            if (paramView.hasRecommendDressup)
            {
              paramViewHolder = anvx.a(2131713645);
              localTextView.setText(paramViewHolder);
              localTextView.setTextColor(-8947849);
              localLinearLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject2);
              paramViewHolder = new LinearLayout.LayoutParams(-2, -2);
              paramViewHolder.leftMargin = ((int)(5.0F * this.density));
              paramViewHolder.gravity = 16;
              localObject2 = new ImageView(this.mContext);
              ((ImageView)localObject2).setBackgroundDrawable(this.mContext.getResources().getDrawable(2130847123));
              localLinearLayout.addView((View)localObject2, paramViewHolder);
              paramViewGroup.addView(localLinearLayout);
              ((SmallEmotionDownloadedAdapter.SmallEmotionDownloadedViewHolder)localObject1).linearLayout = localLinearLayout;
              ((SmallEmotionDownloadedAdapter.SmallEmotionDownloadedViewHolder)localObject1).linearLayout.setOnClickListener(new SmallEmotionDownloadedAdapter.1(this, paramView));
              if (this.businessType != 2) {
                break label899;
              }
              ((SmallEmotionDownloadedAdapter.SmallEmotionDownloadedViewHolder)localObject1).linearLayout.setVisibility(8);
              label828:
              paramViewGroup.setTag(localObject1);
              if (this.app != null) {
                break label911;
              }
              paramViewHolder = "";
              label846:
              localObject1 = this.emotionPkg.epId;
              if (!paramView.hasRecommendDressup) {
                break label922;
              }
            }
            for (paramView = "1";; paramView = "2")
            {
              VasWebviewUtil.reportCommercialDrainage(paramViewHolder, "ep_mall", "exp_bq_detail", null, 1, 0, 0, null, (String)localObject1, paramView);
              paramView = paramViewGroup;
              return paramView;
              paramViewHolder = anvx.a(2131713644);
              break;
              ((SmallEmotionDownloadedAdapter.SmallEmotionDownloadedViewHolder)localObject1).linearLayout.setVisibility(0);
              break label828;
              paramViewHolder = this.app.getCurrentAccountUin();
              break label846;
            }
          }
          return paramView;
        }
      }
      label936:
      paramViewHolder = paramView;
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.businessType == 1) {}
    while (paramInt != getCount() - 1) {
      return 0;
    }
    return 1;
  }
  
  public int getViewTypeCount()
  {
    if (this.businessType == 1) {
      return 1;
    }
    return 2;
  }
  
  public BaseEmotionAdapter.ViewHolder newHolder()
  {
    return new SmallEmotionDownloadedAdapter.SmallEmotionDownloadedViewHolder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SmallEmotionDownloadedAdapter
 * JD-Core Version:    0.7.0.1
 */