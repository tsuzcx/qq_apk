package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class SmallEmotionUpdateAdapter
  extends EmotionDownloadOrUpdateAdapter
{
  public static final String TAG = "SmallEmotionUpdateAdapter";
  protected int emojiWidth = (this.widthPixels - (int)(this.density * 18.0F) * 8) / 7;
  
  public SmallEmotionUpdateAdapter(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, EmoticonCallback paramEmoticonCallback, int paramInt4)
  {
    super(paramIEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramEmoticonCallback, paramInt4);
    this.isUpdatePanel = true;
  }
  
  public View getEmotionView(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (SmallEmotionUpdateAdapter.SmallEmotionUpdateViewHolder)paramViewHolder;
    this.holder = paramViewGroup;
    int i = getItemViewType(paramInt);
    Object localObject;
    if (i == 0)
    {
      if (paramView == null)
      {
        paramView = EmotionPanelViewPool.getInstance().getView(7);
        localObject = new AbsListView.LayoutParams(-1, -2);
        if (paramView == null)
        {
          if (QLog.isColorLevel())
          {
            paramViewHolder = new StringBuilder();
            paramViewHolder.append("getEmotionView position = ");
            paramViewHolder.append(paramInt);
            paramViewHolder.append(";itemType = ");
            paramViewHolder.append(i);
            paramViewHolder.append(";view from infalter");
            QLog.d("SmallEmotionUpdateAdapter", 2, paramViewHolder.toString());
          }
          paramViewHolder = LayoutInflater.from(this.mContext).inflate(2131561589, null);
        }
        else
        {
          paramViewHolder = paramView;
          if (QLog.isColorLevel())
          {
            paramViewHolder = new StringBuilder();
            paramViewHolder.append("getEmotionView position = ");
            paramViewHolder.append(paramInt);
            paramViewHolder.append(";itemType = ");
            paramViewHolder.append(i);
            paramViewHolder.append(";view from cache");
            QLog.d("SmallEmotionUpdateAdapter", 2, paramViewHolder.toString());
            paramViewHolder = paramView;
          }
        }
        paramViewHolder.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramViewHolder.setPadding(0, (int)(this.density * 10.0F), 0, 0);
        recycleView(7, paramViewHolder);
        paramViewGroup.cover = ((URLImageView)paramViewHolder.findViewById(2131365284));
        paramViewGroup.name = ((TextView)paramViewHolder.findViewById(2131365367));
        paramViewGroup.downloadBtn = ((ProgressButton)paramViewHolder.findViewById(2131365365));
        paramViewHolder.setTag(paramViewGroup);
      }
      else
      {
        paramViewHolder = paramView;
      }
      updateDownloadUI(paramViewGroup);
      return paramViewHolder;
    }
    int j;
    if (paramView == null)
    {
      paramView = EmotionPanelViewPool.getInstance().getView(2);
      if (paramView == null)
      {
        if (QLog.isColorLevel())
        {
          paramViewHolder = new StringBuilder();
          paramViewHolder.append("getEmotionView position = ");
          paramViewHolder.append(paramInt);
          paramViewHolder.append(";itemType = ");
          paramViewHolder.append(i);
          paramViewHolder.append(";view from infalter");
          QLog.d("SmallEmotionUpdateAdapter", 2, paramViewHolder.toString());
        }
        paramViewHolder = new EmoticonPanelLinearLayout(this.mContext, new QQEmoticonPanelLinearLayoutHelper(this.mContext, null));
        paramViewHolder.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        paramViewHolder.setOrientation(0);
        paramViewHolder.setPadding(0, (int)(this.density * 18.0F), 0, 0);
        i = 0;
        while (i < this.columnNum)
        {
          paramView = new URLImageView(this.mContext);
          j = this.emojiWidth;
          localObject = new LinearLayout.LayoutParams(j, j);
          ((LinearLayout.LayoutParams)localObject).leftMargin = ((int)(this.density * 18.0F));
          paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          paramView.setVisibility(8);
          paramView.setScaleType(ImageView.ScaleType.FIT_XY);
          paramView.setAdjustViewBounds(false);
          paramViewHolder.addView(paramView);
          i += 1;
        }
      }
      else
      {
        paramViewHolder = paramView;
        if (QLog.isColorLevel())
        {
          paramViewHolder = new StringBuilder();
          paramViewHolder.append("getEmotionView position = ");
          paramViewHolder.append(paramInt);
          paramViewHolder.append(";itemType = ");
          paramViewHolder.append(i);
          paramViewHolder.append(";view from cache");
          QLog.d("SmallEmotionUpdateAdapter", 2, paramViewHolder.toString());
          paramViewHolder = paramView;
        }
      }
      ((EmoticonPanelLinearLayout)paramViewHolder).setCallBack(this.callback);
      recycleView(2, paramViewHolder);
      paramView = (ViewGroup)paramViewHolder;
      paramViewGroup.contentViews = new URLImageView[this.columnNum];
      i = 0;
      while (i < this.columnNum)
      {
        paramViewGroup.contentViews[i] = ((URLImageView)paramView.getChildAt(i));
        i += 1;
      }
      paramViewHolder.setTag(paramViewGroup);
    }
    else
    {
      paramViewHolder = paramView;
    }
    i = 0;
    while (i < this.columnNum)
    {
      j = this.columnNum * paramInt + i;
      if (j > this.data.size() - 1)
      {
        paramViewGroup.contentViews[i].setTag(null);
        paramViewGroup.contentViews[i].setVisibility(8);
      }
      else
      {
        localObject = paramViewGroup.contentViews[i];
        paramView = (EmotionPanelData)this.data.get(j);
        if ((paramView instanceof EmoticonInfo)) {
          paramView = (EmoticonInfo)paramView;
        } else {
          paramView = null;
        }
        if (paramView != null)
        {
          paramViewGroup.contentViews[i].setTag(paramView);
          paramViewGroup.contentViews[i].setOnClickListener(this);
          ((URLImageView)localObject).setImageDrawable(paramView.getDrawable(this.mContext, this.density));
          ((URLImageView)localObject).setVisibility(0);
        }
      }
      i += 1;
    }
    return paramViewHolder;
  }
  
  public BaseEmotionAdapter.ViewHolder newHolder()
  {
    return new SmallEmotionUpdateAdapter.SmallEmotionUpdateViewHolder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SmallEmotionUpdateAdapter
 * JD-Core Version:    0.7.0.1
 */