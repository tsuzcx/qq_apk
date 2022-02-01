package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.core.SystemEmotionPanelManager;
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
    int j = 0;
    paramViewGroup = (BigEmotionUpdateAdapter.BigEmotionUpdateViewHolder)paramViewHolder;
    this.holder = paramViewGroup;
    int i = getItemViewType(paramInt);
    if (i == 0)
    {
      if (paramView != null) {
        break label673;
      }
      paramViewHolder = EmotionPanelViewPool.getInstance().getView(7);
      paramView = new AbsListView.LayoutParams(-1, -2);
      if (paramViewHolder == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BigEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemtype = " + i + ";view from inflater");
        }
        paramViewHolder = LayoutInflater.from(this.mContext).inflate(2131561740, null);
        paramViewHolder.setLayoutParams(paramView);
        paramViewHolder.setPadding(0, (int)(10.0F * this.density), 0, 0);
        recycleView(7, paramViewHolder);
        paramViewGroup.cover = ((URLImageView)paramViewHolder.findViewById(2131365419));
        paramViewGroup.name = ((TextView)paramViewHolder.findViewById(2131365521));
        paramViewGroup.downloadBtn = ((ProgressButton)paramViewHolder.findViewById(2131365519));
        paramViewHolder.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      updateDownloadUI(paramViewGroup);
      paramView = paramViewHolder;
      return paramView;
      if (QLog.isColorLevel()) {
        QLog.d("BigEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemtype = " + i + ";view from cache");
      }
      break;
      if (paramView == null)
      {
        paramView = EmotionPanelViewPool.getInstance().getView(6);
        if (paramView == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("BigEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemtype = " + i + ";view from inflater");
          }
          paramView = new EmoticonPanelLinearLayout(this.mContext, SystemEmotionPanelManager.a().a(this.mContext, false));
          paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
          paramView.setOrientation(0);
          if (paramInt == 1) {
            paramView.setPadding(0, (int)(16.0F * this.density), 0, 0);
          }
          for (;;)
          {
            i = 0;
            for (;;)
            {
              paramViewHolder = paramView;
              if (i >= this.columnNum) {
                break;
              }
              paramViewHolder = super.getBigEmotionContentViewLayout();
              paramViewHolder.setVisibility(8);
              paramView.addView(paramViewHolder);
              i += 1;
            }
            paramView.setPadding(0, (int)(14.0F * this.density), 0, 0);
          }
        }
        paramViewHolder = paramView;
        if (QLog.isColorLevel())
        {
          QLog.d("BigEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemtype = " + i + ";view from cache");
          paramViewHolder = paramView;
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
      for (;;)
      {
        paramView = paramViewHolder;
        if (i >= this.columnNum) {
          break;
        }
        j = this.columnNum * paramInt + i;
        if (j > this.data.size() - 1)
        {
          paramViewGroup.contentViews[i].setTag(null);
          paramViewGroup.contentViews[i].setVisibility(8);
        }
        for (;;)
        {
          i += 1;
          break;
          super.updateBigEmotionContentViewData(paramViewGroup.contentViews[i], (EmotionPanelData)this.data.get(j));
        }
        paramViewHolder = paramView;
        i = j;
      }
      label673:
      paramViewHolder = paramView;
    }
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