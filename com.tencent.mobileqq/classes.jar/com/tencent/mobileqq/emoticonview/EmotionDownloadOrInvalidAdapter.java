package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XPanelContainer;

public class EmotionDownloadOrInvalidAdapter
  extends EmotionDownloadOrUpdateAdapter
  implements View.OnClickListener
{
  public static final String TAG = "EmotionDownloadOrInvalidAdapter";
  protected int contentHight;
  
  public EmotionDownloadOrInvalidAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, EmoticonCallback paramEmoticonCallback, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramEmoticonCallback, paramInt4);
    this.isUpdatePanel = false;
    this.contentHight = (XPanelContainer.a - (int)paramContext.getResources().getDimension(2131296963));
  }
  
  public int getCount()
  {
    return 1;
  }
  
  public EmoticonPackage getEmoticonPackage()
  {
    return this.emotionPkg;
  }
  
  public View getEmotionView(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionDownloadOrInvalidAdapter", 2, "getEmotionView position = " + paramInt);
    }
    this.holder = ((EmotionDownloadOrUpdateAdapter.EmotionDownloadOrUpdateViewHolder)paramViewHolder);
    if (paramView == null)
    {
      paramViewHolder = EmotionPanelViewPool.getInstance().getView(this.panelType);
      paramView = new AbsListView.LayoutParams(-1, this.contentHight);
      if (paramViewHolder == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmotionDownloadOrInvalidAdapter", 2, "getEmotionView position = " + paramInt + ";view form inflater");
        }
        paramViewHolder = LayoutInflater.from(this.mContext).inflate(2131561925, null);
        paramViewHolder.setLayoutParams(paramView);
        this.holder.cover = ((URLImageView)paramViewHolder.findViewById(2131365278));
        this.holder.name = ((TextView)paramViewHolder.findViewById(2131365371));
        this.holder.downloadBtn = ((ProgressButton)paramViewHolder.findViewById(2131365369));
        recycleView(this.panelType, paramViewHolder);
        paramViewHolder.setTag(this.holder);
      }
    }
    for (;;)
    {
      updateDownloadUI(this.holder);
      paramInt = XPanelContainer.a - (int)this.mContext.getResources().getDimension(2131296963);
      if (paramInt != this.contentHight)
      {
        this.contentHight = paramInt;
        paramView = (AbsListView.LayoutParams)paramViewHolder.getLayoutParams();
        if (paramView != null)
        {
          paramView.height = this.contentHight;
          paramViewHolder.setLayoutParams(paramView);
        }
      }
      return paramViewHolder;
      if (QLog.isColorLevel()) {
        QLog.d("EmotionDownloadOrInvalidAdapter", 2, "getEmotionView position = " + paramInt + ";view form cache");
      }
      break;
      paramViewHolder = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionDownloadOrInvalidAdapter
 * JD-Core Version:    0.7.0.1
 */