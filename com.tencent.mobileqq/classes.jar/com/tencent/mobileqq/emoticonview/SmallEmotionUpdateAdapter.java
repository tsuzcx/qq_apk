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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class SmallEmotionUpdateAdapter
  extends EmotionDownloadOrUpdateAdapter
{
  public static final String TAG = "SmallEmotionUpdateAdapter";
  protected int emojiWidth = (this.widthPixels - (int)(18.0F * this.density) * 8) / 7;
  
  public SmallEmotionUpdateAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, EmoticonCallback paramEmoticonCallback, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramEmoticonCallback, paramInt4);
    this.isUpdatePanel = true;
  }
  
  public View getEmotionView(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (SmallEmotionUpdateAdapter.SmallEmotionUpdateViewHolder)paramViewHolder;
    this.holder = paramViewGroup;
    int i = getItemViewType(paramInt);
    if (i == 0)
    {
      if (paramView != null) {
        break label751;
      }
      paramViewHolder = EmotionPanelViewPool.getInstance().getView(7);
      paramView = new AbsListView.LayoutParams(-1, -2);
      if (paramViewHolder == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SmallEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemType = " + i + ";view from infalter");
        }
        paramViewHolder = LayoutInflater.from(this.mContext).inflate(2131561925, null);
        paramViewHolder.setLayoutParams(paramView);
        paramViewHolder.setPadding(0, (int)(10.0F * this.density), 0, 0);
        recycleView(7, paramViewHolder);
        paramViewGroup.cover = ((URLImageView)paramViewHolder.findViewById(2131365278));
        paramViewGroup.name = ((TextView)paramViewHolder.findViewById(2131365371));
        paramViewGroup.downloadBtn = ((ProgressButton)paramViewHolder.findViewById(2131365369));
        paramViewHolder.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      updateDownloadUI(paramViewGroup);
      paramView = paramViewHolder;
      return paramView;
      if (QLog.isColorLevel()) {
        QLog.d("SmallEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemType = " + i + ";view from cache");
      }
      break;
      Object localObject;
      if (paramView == null)
      {
        paramView = EmotionPanelViewPool.getInstance().getView(2);
        if (paramView == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SmallEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemType = " + i + ";view from infalter");
          }
          paramView = new EmoticonPanelLinearLayout(this.mContext);
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
            localObject = new LinearLayout.LayoutParams(this.emojiWidth, this.emojiWidth);
            ((LinearLayout.LayoutParams)localObject).leftMargin = ((int)(this.density * 18.0F));
            paramViewHolder.setLayoutParams((ViewGroup.LayoutParams)localObject);
            paramViewHolder.setVisibility(8);
            paramViewHolder.setScaleType(ImageView.ScaleType.FIT_XY);
            paramViewHolder.setAdjustViewBounds(false);
            paramView.addView(paramViewHolder);
            i += 1;
          }
        }
        paramViewHolder = paramView;
        if (QLog.isColorLevel())
        {
          QLog.d("SmallEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemType = " + i + ";view from cache");
          paramViewHolder = paramView;
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
      for (;;)
      {
        i = 0;
        paramView = paramViewHolder;
        if (i >= this.columnNum) {
          break;
        }
        int j = this.columnNum * paramInt + i;
        if (j > this.data.size() - 1)
        {
          paramViewGroup.contentViews[i].setTag(null);
          paramViewGroup.contentViews[i].setVisibility(8);
        }
        label744:
        for (;;)
        {
          i += 1;
          break;
          localObject = paramViewGroup.contentViews[i];
          paramView = (EmotionPanelData)this.data.get(j);
          if ((paramView instanceof EmoticonInfo)) {}
          for (paramView = (EmoticonInfo)paramView;; paramView = null)
          {
            if (paramView == null) {
              break label744;
            }
            paramViewGroup.contentViews[i].setTag(paramView);
            paramViewGroup.contentViews[i].setOnClickListener(this);
            ((URLImageView)localObject).setImageDrawable(paramView.getDrawable(this.mContext, this.density));
            ((URLImageView)localObject).setVisibility(0);
            break;
          }
        }
        paramViewHolder = paramView;
      }
      label751:
      paramViewHolder = paramView;
    }
  }
  
  public BaseEmotionAdapter.ViewHolder newHolder()
  {
    return new SmallEmotionUpdateAdapter.SmallEmotionUpdateViewHolder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SmallEmotionUpdateAdapter
 * JD-Core Version:    0.7.0.1
 */