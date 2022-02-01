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
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.core.SystemEmotionPanelManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.api.IBigEmotionService;
import com.tencent.mobileqq.emoticonview.api.IRecommendEmotionService;
import com.tencent.mobileqq.qroute.QRoute;
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
  
  public SmallEmotionDownloadedAdapter(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, EmoticonCallback paramEmoticonCallback, int paramInt4)
  {
    super(paramIEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    this.businessType = paramInt4;
    this.emotionPkg = paramEmoticonPackage;
    this.callback = paramEmoticonCallback;
  }
  
  private boolean isKanDian()
  {
    return ((IRecommendEmotionService)QRoute.api(IRecommendEmotionService.class)).isKanDianBusiness(this.businessType);
  }
  
  public int getCount()
  {
    int i = super.getCount();
    if (i > 0)
    {
      if (isKanDian()) {
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
        break label980;
      }
      paramView = EmotionPanelViewPool.getInstance().getView(this.panelType);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SmallEmotionDownloadedAdapter", 2, "getEmotionView position = " + paramInt + ";view from inflater");
        }
        paramView = new EmoticonPanelLinearLayout(this.mContext, SystemEmotionPanelManager.a().a(this.mContext, true), this.businessType);
        paramView.setPanelType(2);
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
      label941:
      label953:
      label966:
      label978:
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
            break label978;
          }
          localObject1.contentViews[i].setTag(paramView);
          paramViewGroup.setImageDrawable(paramView.getDrawable(this.mContext, this.density));
          paramViewGroup.setVisibility(0);
          break;
          if (paramView == null)
          {
            paramViewGroup = new RelativeLayout(this.mContext);
            paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, (int)(57.0F * this.density)));
            paramView = new LinearLayout(this.mContext);
            paramViewHolder = new RelativeLayout.LayoutParams(-2, -2);
            paramViewHolder.addRule(13, -1);
            paramView.setLayoutParams(paramViewHolder);
            boolean bool = ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).hasRecommendDressup(this.emotionPkg.epId, true);
            Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
            paramView.setOrientation(0);
            ((LinearLayout.LayoutParams)localObject2).gravity = 16;
            TextView localTextView = new TextView(this.mContext);
            localTextView.setTextSize(14.0F);
            if (bool)
            {
              paramViewHolder = this.mContext.getString(2131699647);
              localTextView.setText(paramViewHolder);
              localTextView.setTextColor(-8947849);
              paramView.addView(localTextView, (ViewGroup.LayoutParams)localObject2);
              paramViewHolder = new LinearLayout.LayoutParams(-2, -2);
              paramViewHolder.leftMargin = ((int)(5.0F * this.density));
              paramViewHolder.gravity = 16;
              localObject2 = new ImageView(this.mContext);
              ((ImageView)localObject2).setBackgroundDrawable(this.mContext.getResources().getDrawable(2130846566));
              paramView.addView((View)localObject2, paramViewHolder);
              paramViewGroup.addView(paramView);
              ((SmallEmotionDownloadedAdapter.SmallEmotionDownloadedViewHolder)localObject1).linearLayout = paramView;
              ((SmallEmotionDownloadedAdapter.SmallEmotionDownloadedViewHolder)localObject1).linearLayout.setOnClickListener(new SmallEmotionDownloadedAdapter.1(this, bool));
              if (!((IRecommendEmotionService)QRoute.api(IRecommendEmotionService.class)).isColorNick(this.businessType)) {
                break label941;
              }
              ((SmallEmotionDownloadedAdapter.SmallEmotionDownloadedViewHolder)localObject1).linearLayout.setVisibility(8);
              label853:
              paramViewGroup.setTag(localObject1);
              localObject1 = (IBigEmotionService)QRoute.api(IBigEmotionService.class);
              if (this.app != null) {
                break label953;
              }
              paramViewHolder = "";
              label882:
              localObject2 = this.emotionPkg.epId;
              if (!bool) {
                break label966;
              }
            }
            for (paramView = "1";; paramView = "2")
            {
              ((IBigEmotionService)localObject1).reportCommercialDrainage(paramViewHolder, "ep_mall", "exp_bq_detail", null, 1, 0, 0, null, (String)localObject2, paramView);
              paramView = paramViewGroup;
              return paramView;
              paramViewHolder = this.mContext.getString(2131699648);
              break;
              ((SmallEmotionDownloadedAdapter.SmallEmotionDownloadedViewHolder)localObject1).linearLayout.setVisibility(0);
              break label853;
              paramViewHolder = this.app.getCurrentAccountUin();
              break label882;
            }
          }
          return paramView;
        }
      }
      label980:
      paramViewHolder = paramView;
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    if (isKanDian()) {}
    while (paramInt != getCount() - 1) {
      return 0;
    }
    return 1;
  }
  
  public int getViewTypeCount()
  {
    if (isKanDian()) {
      return 1;
    }
    return 2;
  }
  
  public BaseEmotionAdapter.ViewHolder newHolder()
  {
    return new SmallEmotionDownloadedAdapter.SmallEmotionDownloadedViewHolder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SmallEmotionDownloadedAdapter
 * JD-Core Version:    0.7.0.1
 */