package com.tencent.mobileqq.leba.qcircle.mainbiz;

import android.text.TextUtils;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.LebaQZoneFacePlayHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import java.util.ArrayList;
import java.util.List;

class LebaQCirclePart$2
  implements Runnable
{
  LebaQCirclePart$2(LebaQCirclePart paramLebaQCirclePart, boolean paramBoolean1, int paramInt, QBaseActivity paramQBaseActivity, boolean paramBoolean2, String paramString, List paramList, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5) {}
  
  public void run()
  {
    if (this.a)
    {
      if (this.this$0.k != null) {
        this.this$0.k.setVisibility(0);
      }
      CustomWidgetUtil.a(this.this$0.k, 2, 0, 0);
      if (this.this$0.j != null) {
        this.this$0.j.setVisibility(8);
      }
      if (this.this$0.h != null) {
        this.this$0.h.setVisibility(8);
      }
      if (this.this$0.g != null) {
        this.this$0.g.setVisibility(8);
      }
      this.this$0.x();
      return;
    }
    if (this.this$0.k != null) {
      this.this$0.k.setVisibility(8);
    }
    if (this.b > 0)
    {
      if (this.this$0.j != null) {
        this.this$0.j.setVisibility(0);
      }
      CustomWidgetUtil.a(this.this$0.j, 9, this.b, 0);
      CustomWidgetUtil.a(this.c, this.this$0.j, 9, this.this$0.k());
    }
    else if (this.this$0.j != null)
    {
      this.this$0.j.setVisibility(8);
    }
    if (this.this$0.h != null) {
      this.this$0.h.setVisibility(8);
    }
    try
    {
      ((RelativeLayout.LayoutParams)this.this$0.g.getLayoutParams()).rightMargin = 0;
      if (QCircleHostGlobalInfo.needShowEntranceGuideTips())
      {
        this.this$0.a(QCircleHostGlobalInfo.getEntranceGuideTips(), this.c, null);
        return;
      }
      if (this.d)
      {
        if (this.this$0.g != null)
        {
          CustomWidgetUtil.a(this.this$0.g, 8, 0, 0);
          CustomWidgetUtil.a(this.c, this.this$0.g, 8, this.this$0.k());
          if (!TextUtils.isEmpty(this.e)) {
            this.this$0.a(this.e, this.c, this.f);
          }
          this.this$0.g.setVisibility(0);
        }
      }
      else if (this.g)
      {
        if (this.this$0.g != null)
        {
          this.this$0.g.setVisibility(0);
          CustomWidgetUtil.a(this.this$0.g, 8, this.b, 0);
          CustomWidgetUtil.a(this.c, this.this$0.g, 10, this.this$0.k());
        }
      }
      else if (this.h) {
        this.this$0.a(this.e, this.c, this.f);
      } else if (this.i) {
        this.this$0.a(this.e, this.c, this.f);
      } else if (this.this$0.g != null) {
        this.this$0.g.setVisibility(8);
      }
      ArrayList localArrayList = new ArrayList();
      if (this.f != null) {
        localArrayList.addAll(this.f);
      }
      if ((this.this$0.o != null) && (this.this$0.x != null)) {
        this.this$0.x.a(localArrayList);
      }
      this.this$0.x();
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateQQCircleRedFlag");
      localStringBuilder.append(localException);
      QLog.e("QCircleEeveeRedPoint_LebaQCirclePartImpl", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.qcircle.mainbiz.LebaQCirclePart.2
 * JD-Core Version:    0.7.0.1
 */