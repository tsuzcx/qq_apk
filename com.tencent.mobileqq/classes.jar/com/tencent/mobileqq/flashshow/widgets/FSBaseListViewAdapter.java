package com.tencent.mobileqq.flashshow.widgets;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.biz.richframework.part.utils.RFWViewUtils;
import com.tencent.mobileqq.flashshow.api.bean.FSReportBean;
import com.tencent.qphone.base.util.QLog;

public abstract class FSBaseListViewAdapter<E>
  extends BaseListViewAdapter<E>
{
  private Object a()
  {
    if (this.mRecyclerView == null) {
      return null;
    }
    return RFWViewUtils.a(BasePartFragment.E, this.mRecyclerView);
  }
  
  public FSReportBean d()
  {
    Object localObject = a();
    if (!(localObject instanceof FSReportBean))
    {
      if (!RFApplication.isDebug())
      {
        QLog.e("FSBaseListViewAdapter", 1, "getReportBean but FSReportBean is null");
        return new FSReportBean();
      }
      QLog.e("FSBaseListViewAdapter", 1, "getReportBean but FSReportBean is null , debug");
      throw new RuntimeException("getReportBean but FSReportBean is null");
    }
    return (FSReportBean)localObject;
  }
  
  public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    if (!(paramViewHolder.itemView instanceof FSBaseWidgetView)) {
      return;
    }
    ((FSBaseWidgetView)paramViewHolder.itemView).setCacheReportBean(d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.FSBaseListViewAdapter
 * JD-Core Version:    0.7.0.1
 */