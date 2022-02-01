package com.tencent.mobileqq.flashshow.widgets;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.part.extendsblock.SingleViewBlock;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.flashshow.api.bean.FSReportBean;
import com.tencent.qphone.base.util.QLog;

public abstract class FSBaseSingleViewBlock
  extends SingleViewBlock
{
  public FSBaseSingleViewBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private Object b()
  {
    if (!(e() instanceof FSBaseWidgetView)) {
      return null;
    }
    return e().getViewTagData();
  }
  
  public FSReportBean a()
  {
    Object localObject = b();
    if (!(localObject instanceof FSReportBean))
    {
      if (!RFApplication.isDebug())
      {
        QLog.e("FSBaseSingleViewBlock", 1, "getReportBean but FSReportBean is null");
        return new FSReportBean();
      }
      QLog.e("FSBaseSingleViewBlock", 1, "getReportBean but FSReportBean is null , debug");
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
    ((FSBaseWidgetView)paramViewHolder.itemView).setCacheReportBean(a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.FSBaseSingleViewBlock
 * JD-Core Version:    0.7.0.1
 */