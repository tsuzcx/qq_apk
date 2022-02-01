package com.tencent.mobileqq.flashshow.widgets;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.utils.RFWViewUtils;
import com.tencent.mobileqq.flashshow.api.bean.FSReportBean;
import com.tencent.qphone.base.util.QLog;

public abstract class FSBaseMultiViewBlock<E>
  extends MultiViewBlock<E>
{
  private static final String TAG = "FSBaseMultiViewBlock";
  private RecyclerView mRecyclerView;
  
  public FSBaseMultiViewBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private Object getViewTagData()
  {
    if (this.mRecyclerView == null) {
      return null;
    }
    return RFWViewUtils.a(BasePartFragment.E, this.mRecyclerView);
  }
  
  public String getFromPageId()
  {
    return getReportBean().getFromPageId();
  }
  
  public String getPageId()
  {
    return getReportBean().getPageId();
  }
  
  public FSReportBean getReportBean()
  {
    Object localObject = getViewTagData();
    if (!(localObject instanceof FSReportBean))
    {
      if (!RFApplication.isDebug())
      {
        QLog.e("FSBaseMultiViewBlock", 1, "getReportBean but FSReportBean is null");
        return new FSReportBean();
      }
      QLog.e("FSBaseMultiViewBlock", 1, "getReportBean but FSReportBean is null , debug");
      throw new RuntimeException("getReportBean but FSReportBean is null");
    }
    return (FSReportBean)localObject;
  }
  
  public void onAttachedToRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.mRecyclerView = paramRecyclerView;
  }
  
  public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    if (!(paramViewHolder.itemView instanceof FSBaseWidgetView)) {
      return;
    }
    ((FSBaseWidgetView)paramViewHolder.itemView).setCacheReportBean(getReportBean());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.FSBaseMultiViewBlock
 * JD-Core Version:    0.7.0.1
 */