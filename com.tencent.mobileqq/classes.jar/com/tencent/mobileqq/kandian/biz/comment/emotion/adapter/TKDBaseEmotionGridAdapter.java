package com.tencent.mobileqq.kandian.biz.comment.emotion.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter.ViewHolder;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonImageView;
import com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout;
import com.tencent.mobileqq.emoticonview.EmotionPanelData;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.api.IEmoticonInfoService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public abstract class TKDBaseEmotionGridAdapter
  extends BaseEmotionAdapter
{
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public TKDBaseEmotionGridAdapter(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback)
  {
    super(paramIEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
  }
  
  private EmoticonPanelLinearLayout a(View paramView, int paramInt)
  {
    EmoticonPanelLinearLayout localEmoticonPanelLinearLayout = (EmoticonPanelLinearLayout)paramView;
    int j = 0;
    paramView = localEmoticonPanelLinearLayout;
    if (localEmoticonPanelLinearLayout == null)
    {
      paramView = new EmoticonPanelLinearLayout(this.mContext, ((IEmoticonInfoService)QRoute.api(IEmoticonInfoService.class)).createEmoticonPanelLayoutHelper(this.mContext, null), 1);
      paramView.setCallBack(this.callback);
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      paramView.setOrientation(0);
      paramView.setClipToPadding(false);
    }
    int i;
    if (paramInt == 0) {
      i = this.c;
    } else {
      i = this.d;
    }
    if (paramInt == getCount() - 1) {
      j = this.c;
    }
    paramView.setPadding(this.e, i, this.f, j);
    return paramView;
  }
  
  private void a(LinearLayout paramLinearLayout, int paramInt)
  {
    int i = paramLinearLayout.getChildCount() - 1;
    while (i >= 0)
    {
      paramLinearLayout.getChildAt(i).setVisibility(8);
      i -= 1;
    }
    while (paramLinearLayout.getChildCount() < paramInt)
    {
      EmoticonImageView localEmoticonImageView = new EmoticonImageView(this.mContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.a, this.b);
      if (paramLinearLayout.getChildCount() == 0) {
        i = 0;
      } else {
        i = this.g;
      }
      localLayoutParams.leftMargin = i;
      localEmoticonImageView.setLayoutParams(localLayoutParams);
      localEmoticonImageView.setVisibility(8);
      localEmoticonImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localEmoticonImageView.setAdjustViewBounds(false);
      localEmoticonImageView.setFocusable(true);
      localEmoticonImageView.setFocusableInTouchMode(true);
      paramLinearLayout.addView(localEmoticonImageView);
    }
  }
  
  private void a(EmoticonPanelLinearLayout paramEmoticonPanelLinearLayout, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < paramInt1)
    {
      EmoticonImageView localEmoticonImageView = (EmoticonImageView)paramEmoticonPanelLinearLayout.getChildAt(i);
      localEmoticonImageView.setVisibility(0);
      EmotionPanelData localEmotionPanelData = a(paramInt2 + i);
      localEmoticonImageView.setTag(localEmotionPanelData);
      a(localEmoticonImageView, localEmotionPanelData);
      i += 1;
    }
  }
  
  public EmotionPanelData a(int paramInt)
  {
    return (EmotionPanelData)this.data.get(paramInt);
  }
  
  protected abstract void a(EmoticonImageView paramEmoticonImageView, EmotionPanelData paramEmotionPanelData);
  
  protected final void a(RIJCommonEmotionAdapterParams paramRIJCommonEmotionAdapterParams)
  {
    this.a = paramRIJCommonEmotionAdapterParams.e;
    this.b = paramRIJCommonEmotionAdapterParams.d;
    this.c = paramRIJCommonEmotionAdapterParams.f;
    this.d = paramRIJCommonEmotionAdapterParams.g;
    this.e = paramRIJCommonEmotionAdapterParams.h;
    this.f = paramRIJCommonEmotionAdapterParams.i;
    if (this.columnNum > 0)
    {
      int i = ViewUtils.a() - this.e - this.f - this.a * this.columnNum;
      if ((i > 0) && (this.columnNum > 1)) {
        this.g = (i / (this.columnNum - 1));
      }
    }
  }
  
  public View getEmotionView(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewHolder = a(paramView, paramInt);
    int j = paramInt * this.columnNum;
    paramInt = this.data.size();
    int i = this.columnNum + j;
    if (i <= paramInt) {
      paramInt = i;
    }
    paramInt -= j;
    a(paramViewHolder, paramInt);
    a(paramViewHolder, paramInt, j);
    return paramViewHolder;
  }
  
  public BaseEmotionAdapter.ViewHolder newHolder()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.emotion.adapter.TKDBaseEmotionGridAdapter
 * JD-Core Version:    0.7.0.1
 */