package com.tencent.mobileqq.flashshow.widgets;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.flashshow.api.bean.FSReportBean;
import com.tencent.qphone.base.util.QLog;

public abstract class FSBaseWidgetView<T>
  extends BaseWidgetView<T>
{
  private FSReportBean a;
  
  public FSBaseWidgetView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public FSBaseWidgetView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FSBaseWidgetView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public FSBaseWidgetView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public FSBaseWidgetView(@NonNull Context paramContext, Integer paramInteger)
  {
    super(paramContext, paramInteger);
  }
  
  public FSBaseWidgetView(@NonNull Context paramContext, boolean paramBoolean)
  {
    super(paramContext, paramBoolean);
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
    Object localObject = super.getViewTagData();
    if ((localObject instanceof FSReportBean))
    {
      localObject = (FSReportBean)localObject;
      this.a = ((FSReportBean)localObject);
    }
    else
    {
      localObject = this.a;
      QLog.i("FSBaseWidgetView", 1, "getReportBean used mCacheReportBean");
    }
    if (localObject == null)
    {
      if (!RFApplication.isDebug())
      {
        QLog.e("FSBaseWidgetView", 1, "getReportBean but FSReportBean is null");
        return new FSReportBean();
      }
      QLog.e("FSBaseWidgetView", 1, "getReportBean but FSReportBean is null , debug");
      throw new RuntimeException("getReportBean but FSReportBean is null and mCacheReportBean is null");
    }
    return localObject;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Object localObject = super.getViewTagData();
    if ((localObject instanceof FSReportBean)) {
      this.a = ((FSReportBean)localObject);
    }
  }
  
  public void setCacheReportBean(FSReportBean paramFSReportBean)
  {
    if (paramFSReportBean == null) {
      return;
    }
    this.a = paramFSReportBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.FSBaseWidgetView
 * JD-Core Version:    0.7.0.1
 */