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
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
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
  private IPanelInteractionListener interactionListener;
  
  public SmallEmotionDownloadedAdapter(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, IPanelInteractionListener paramIPanelInteractionListener, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, EmoticonCallback paramEmoticonCallback, int paramInt4)
  {
    super(paramIEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    this.businessType = paramInt4;
    this.emotionPkg = paramEmoticonPackage;
    this.callback = paramEmoticonCallback;
    this.interactionListener = paramIPanelInteractionListener;
  }
  
  private boolean isKanDian()
  {
    return this.businessType == 1;
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
    this.emojiWidth = ((this.widthPixels - (int)(this.density * 18.0F) * (this.columnNum + 1)) / this.columnNum);
    Object localObject1 = (SmallEmotionDownloadedAdapter.SmallEmotionDownloadedViewHolder)paramViewHolder;
    Object localObject2;
    if (getItemViewType(paramInt) == 0)
    {
      paramViewHolder = paramView;
      int j;
      if (paramView == null)
      {
        paramView = EmotionPanelViewPool.getInstance().getView(this.panelType);
        if (paramView == null)
        {
          if (QLog.isColorLevel())
          {
            paramViewHolder = new StringBuilder();
            paramViewHolder.append("getEmotionView position = ");
            paramViewHolder.append(paramInt);
            paramViewHolder.append(";view from inflater");
            QLog.d("SmallEmotionDownloadedAdapter", 2, paramViewHolder.toString());
          }
          paramView = new EmoticonPanelLinearLayout(this.mContext, new QQEmoticonPanelLinearLayoutHelper(this.mContext, this.interactionListener), this.businessType);
          paramView.setPanelType(2);
          paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
          paramView.setOrientation(0);
          paramView.setPadding(0, (int)(this.density * 18.0F), 0, 0);
          i = 0;
          for (;;)
          {
            paramViewHolder = paramView;
            if (i >= this.columnNum) {
              break;
            }
            paramViewHolder = new URLImageView(this.mContext);
            j = this.emojiWidth;
            paramViewGroup = new LinearLayout.LayoutParams(j, j);
            paramViewGroup.leftMargin = ((int)(this.density * 18.0F));
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
          paramViewHolder = new StringBuilder();
          paramViewHolder.append("getEmotionView position = ");
          paramViewHolder.append(paramInt);
          paramViewHolder.append(";view from cache");
          QLog.d("SmallEmotionDownloadedAdapter", 2, paramViewHolder.toString());
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
      int i = 0;
      for (;;)
      {
        paramViewGroup = paramViewHolder;
        if (i >= this.columnNum) {
          break;
        }
        j = this.columnNum * paramInt + i;
        int k = this.data.size();
        paramView = null;
        if (j > k - 1)
        {
          localObject1.contentViews[i].setTag(null);
          localObject1.contentViews[i].setVisibility(8);
        }
        else
        {
          paramViewGroup = localObject1.contentViews[i];
          localObject2 = (EmotionPanelData)this.data.get(j);
          if ((localObject2 instanceof EmoticonInfo)) {
            paramView = (EmoticonInfo)localObject2;
          }
          if (paramView != null)
          {
            localObject1.contentViews[i].setTag(paramView);
            paramViewGroup.setImageDrawable(paramView.getDrawable(this.mContext, this.density));
            paramViewGroup.setVisibility(0);
          }
        }
        i += 1;
      }
    }
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = new RelativeLayout(this.mContext);
      paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, (int)(this.density * 57.0F)));
      paramView = new LinearLayout(this.mContext);
      paramViewHolder = new RelativeLayout.LayoutParams(-2, -2);
      paramViewHolder.addRule(13, -1);
      paramView.setLayoutParams(paramViewHolder);
      boolean bool = hasRecommendDressup(this.emotionPkg.epId, true);
      localObject2 = new LinearLayout.LayoutParams(-2, -2);
      paramView.setOrientation(0);
      ((LinearLayout.LayoutParams)localObject2).gravity = 16;
      TextView localTextView = new TextView(this.mContext);
      localTextView.setTextSize(14.0F);
      if (bool)
      {
        paramViewHolder = this.mContext;
        paramInt = 2131699777;
      }
      else
      {
        paramViewHolder = this.mContext;
        paramInt = 2131699778;
      }
      localTextView.setText(paramViewHolder.getString(paramInt));
      localTextView.setTextColor(-8947849);
      paramView.addView(localTextView, (ViewGroup.LayoutParams)localObject2);
      paramViewHolder = new LinearLayout.LayoutParams(-2, -2);
      paramViewHolder.leftMargin = ((int)(this.density * 5.0F));
      paramViewHolder.gravity = 16;
      localObject2 = new ImageView(this.mContext);
      ((ImageView)localObject2).setBackgroundDrawable(this.mContext.getResources().getDrawable(2130846444));
      paramView.addView((View)localObject2, paramViewHolder);
      paramViewGroup.addView(paramView);
      ((SmallEmotionDownloadedAdapter.SmallEmotionDownloadedViewHolder)localObject1).linearLayout = paramView;
      ((SmallEmotionDownloadedAdapter.SmallEmotionDownloadedViewHolder)localObject1).linearLayout.setOnClickListener(new SmallEmotionDownloadedAdapter.1(this, bool));
      if (this.businessType == 2) {
        ((SmallEmotionDownloadedAdapter.SmallEmotionDownloadedViewHolder)localObject1).linearLayout.setVisibility(8);
      } else {
        ((SmallEmotionDownloadedAdapter.SmallEmotionDownloadedViewHolder)localObject1).linearLayout.setVisibility(0);
      }
      paramViewGroup.setTag(localObject1);
      if (this.app == null) {
        paramViewHolder = "";
      } else {
        paramViewHolder = this.app.getCurrentAccountUin();
      }
      localObject1 = this.emotionPkg.epId;
      if (bool) {
        paramView = "1";
      } else {
        paramView = "2";
      }
      VasWebviewUtil.a(paramViewHolder, "ep_mall", "exp_bq_detail", null, 1, 0, 0, null, (String)localObject1, paramView);
    }
    return paramViewGroup;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (isKanDian()) {
      return 0;
    }
    if (paramInt == getCount() - 1) {
      return 1;
    }
    return 0;
  }
  
  public int getViewTypeCount()
  {
    if (isKanDian()) {
      return 1;
    }
    return 2;
  }
  
  public boolean hasRecommendDressup(String paramString, boolean paramBoolean)
  {
    paramString = EmoticonRecDressup.getEmotionRecommend(paramString, paramBoolean);
    if (paramString == null) {
      return false;
    }
    return paramString.hasRecommendDressup;
  }
  
  public BaseEmotionAdapter.ViewHolder newHolder()
  {
    return new SmallEmotionDownloadedAdapter.SmallEmotionDownloadedViewHolder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SmallEmotionDownloadedAdapter
 * JD-Core Version:    0.7.0.1
 */