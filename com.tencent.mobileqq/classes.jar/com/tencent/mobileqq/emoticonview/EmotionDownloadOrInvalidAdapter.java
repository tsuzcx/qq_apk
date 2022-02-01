package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
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
  protected IPanelInteractionListener interactionListener;
  
  public EmotionDownloadOrInvalidAdapter(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, IPanelInteractionListener paramIPanelInteractionListener, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, EmoticonCallback paramEmoticonCallback, int paramInt4)
  {
    super(paramIEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramEmoticonCallback, paramInt4);
    this.isUpdatePanel = false;
    this.interactionListener = paramIPanelInteractionListener;
  }
  
  private void initContentHeight()
  {
    if ((this.contentHight == 0) && (this.interactionListener != null)) {
      if (getCurrentListView() != null)
      {
        this.contentHight = getCurrentListView().getHeight();
        if (this.contentHight == 0) {
          this.contentHight = (XPanelContainer.a - (int)this.mContext.getResources().getDimension(2131297347));
        }
      }
      else
      {
        this.contentHight = (XPanelContainer.a - (int)this.mContext.getResources().getDimension(2131297347));
      }
    }
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
    if (QLog.isColorLevel())
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("getEmotionView position = ");
      paramViewGroup.append(paramInt);
      QLog.d("EmotionDownloadOrInvalidAdapter", 2, paramViewGroup.toString());
    }
    this.holder = ((EmotionDownloadOrUpdateAdapter.EmotionDownloadOrUpdateViewHolder)paramViewHolder);
    if (paramView == null)
    {
      initContentHeight();
      paramView = EmotionPanelViewPool.getInstance().getView(this.panelType);
      paramViewGroup = new AbsListView.LayoutParams(-1, this.contentHight);
      if (paramView == null)
      {
        if (QLog.isColorLevel())
        {
          paramViewHolder = new StringBuilder();
          paramViewHolder.append("getEmotionView position = ");
          paramViewHolder.append(paramInt);
          paramViewHolder.append(";view form inflater");
          QLog.d("EmotionDownloadOrInvalidAdapter", 2, paramViewHolder.toString());
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
          paramViewHolder.append(";view form cache");
          QLog.d("EmotionDownloadOrInvalidAdapter", 2, paramViewHolder.toString());
          paramViewHolder = paramView;
        }
      }
      paramViewHolder.setLayoutParams(paramViewGroup);
      this.holder.cover = ((URLImageView)paramViewHolder.findViewById(2131431458));
      this.holder.name = ((TextView)paramViewHolder.findViewById(2131431560));
      this.holder.downloadBtn = ((ProgressButton)paramViewHolder.findViewById(2131431558));
      recycleView(this.panelType, paramViewHolder);
      paramViewHolder.setTag(this.holder);
    }
    else
    {
      paramViewHolder = paramView;
    }
    updateDownloadUI(this.holder);
    if (this.interactionListener != null)
    {
      paramInt = XPanelContainer.a - (int)this.mContext.getResources().getDimension(2131297347);
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
    }
    return paramViewHolder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionDownloadOrInvalidAdapter
 * JD-Core Version:    0.7.0.1
 */