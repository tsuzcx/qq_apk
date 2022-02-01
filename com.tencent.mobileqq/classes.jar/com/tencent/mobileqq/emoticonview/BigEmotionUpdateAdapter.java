package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class BigEmotionUpdateAdapter
  extends EmotionDownloadOrUpdateAdapter
{
  public static final String TAG = "BigEmotionUpdateAdapter";
  
  public BigEmotionUpdateAdapter(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, EmoticonCallback paramEmoticonCallback, int paramInt4)
  {
    super(paramIEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramEmoticonCallback, paramInt4);
    this.callback = paramEmoticonCallback;
    this.isUpdatePanel = true;
  }
  
  public View getEmotionView(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (BigEmotionUpdateAdapter.BigEmotionUpdateViewHolder)paramViewHolder;
    this.holder = paramViewGroup;
    int i = getItemViewType(paramInt);
    int j = 0;
    if (i == 0)
    {
      if (paramView == null)
      {
        paramView = EmotionPanelViewPool.getInstance().getView(7);
        AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
        if (paramView == null)
        {
          if (QLog.isColorLevel())
          {
            paramViewHolder = new StringBuilder();
            paramViewHolder.append("getEmotionView position = ");
            paramViewHolder.append(paramInt);
            paramViewHolder.append(";itemtype = ");
            paramViewHolder.append(i);
            paramViewHolder.append(";view from inflater");
            QLog.d("BigEmotionUpdateAdapter", 2, paramViewHolder.toString());
          }
          paramViewHolder = LayoutInflater.from(this.mContext).inflate(2131627952, null);
        }
        else
        {
          paramViewHolder = paramView;
          if (QLog.isColorLevel())
          {
            paramViewHolder = new StringBuilder();
            paramViewHolder.append("getEmotionView position = ");
            paramViewHolder.append(paramInt);
            paramViewHolder.append(";itemtype = ");
            paramViewHolder.append(i);
            paramViewHolder.append(";view from cache");
            QLog.d("BigEmotionUpdateAdapter", 2, paramViewHolder.toString());
            paramViewHolder = paramView;
          }
        }
        paramViewHolder.setLayoutParams(localLayoutParams);
        paramViewHolder.setPadding(0, (int)(this.density * 10.0F), 0, 0);
        recycleView(7, paramViewHolder);
        paramViewGroup.cover = ((URLImageView)paramViewHolder.findViewById(2131431458));
        paramViewGroup.name = ((TextView)paramViewHolder.findViewById(2131431560));
        paramViewGroup.downloadBtn = ((ProgressButton)paramViewHolder.findViewById(2131431558));
        paramViewHolder.setTag(paramViewGroup);
      }
      else
      {
        paramViewHolder = paramView;
      }
      updateDownloadUI(paramViewGroup);
      return paramViewHolder;
    }
    if (paramView == null)
    {
      paramView = EmotionPanelViewPool.getInstance().getView(6);
      if (paramView == null)
      {
        if (QLog.isColorLevel())
        {
          paramViewHolder = new StringBuilder();
          paramViewHolder.append("getEmotionView position = ");
          paramViewHolder.append(paramInt);
          paramViewHolder.append(";itemtype = ");
          paramViewHolder.append(i);
          paramViewHolder.append(";view from inflater");
          QLog.d("BigEmotionUpdateAdapter", 2, paramViewHolder.toString());
        }
        paramViewHolder = new EmoticonPanelLinearLayout(this.mContext, new QQEmoticonPanelLinearLayoutHelper(this.mContext, null));
        paramViewHolder.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        paramViewHolder.setOrientation(0);
        if (paramInt == 1) {
          paramViewHolder.setPadding(0, (int)(this.density * 16.0F), 0, 0);
        } else {
          paramViewHolder.setPadding(0, (int)(this.density * 14.0F), 0, 0);
        }
        i = 0;
        while (i < this.columnNum)
        {
          paramView = super.getBigEmotionContentViewLayout();
          paramView.setVisibility(8);
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
          paramViewHolder.append(";itemtype = ");
          paramViewHolder.append(i);
          paramViewHolder.append(";view from cache");
          QLog.d("BigEmotionUpdateAdapter", 2, paramViewHolder.toString());
          paramViewHolder = paramView;
        }
      }
      ((EmoticonPanelLinearLayout)paramViewHolder).setCallBack(this.callback);
      recycleView(6, paramViewHolder);
      paramView = (ViewGroup)paramViewHolder;
      paramViewGroup.contentViews = new RelativeLayout[this.columnNum];
      i = 0;
      while (i < this.columnNum)
      {
        paramViewGroup.contentViews[i] = ((RelativeLayout)paramView.getChildAt(i));
        i += 1;
      }
      paramViewHolder.setTag(paramViewGroup);
      i = j;
    }
    else
    {
      paramViewHolder = paramView;
      i = j;
    }
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
        super.updateBigEmotionContentViewData(paramViewGroup.contentViews[i], (EmotionPanelData)this.data.get(j));
      }
      i += 1;
    }
    return paramViewHolder;
  }
  
  public BaseEmotionAdapter.ViewHolder newHolder()
  {
    return new BigEmotionUpdateAdapter.BigEmotionUpdateViewHolder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.BigEmotionUpdateAdapter
 * JD-Core Version:    0.7.0.1
 */