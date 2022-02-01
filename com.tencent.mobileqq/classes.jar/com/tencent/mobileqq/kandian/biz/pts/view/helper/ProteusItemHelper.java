package com.tencent.mobileqq.kandian.biz.pts.view.helper;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyOverScrollListener;
import com.tencent.mobileqq.kandian.biz.pts.item.ProteusItemView;
import com.tencent.mobileqq.kandian.biz.pts.item.ProteusItemView.OnItemDrawFinishedListener;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;

public class ProteusItemHelper
  implements ProteusItemView.OnItemDrawFinishedListener
{
  private IReadInJoyModel a;
  private final ProteusItemView b;
  private View c;
  private boolean d = false;
  private View.OnClickListener e = new ProteusItemHelper.1(this);
  
  public ProteusItemHelper(ProteusItemView paramProteusItemView)
  {
    this.b = paramProteusItemView;
    c();
  }
  
  private void c()
  {
    this.b.a(this);
  }
  
  private boolean d()
  {
    return false;
  }
  
  private static float e()
  {
    try
    {
      float f = Float.valueOf((String)RIJSPUtils.b("kandian_daily_wrapper_alpha", "1.0")).floatValue();
      if ((f >= 0.0F) && (f <= 1.0F)) {
        return f;
      }
    }
    catch (Exception localException)
    {
      QLog.d("ProteusItemHelper", 1, localException, new Object[] { "" });
    }
    return 1.0F;
  }
  
  private void f()
  {
    if (this.d) {
      return;
    }
    this.d = true;
    PublicAccountReportUtils.a(null, "", "0X8009882", "0X8009882", 0, 0, "", "", "", RIJTransMergeKanDianReport.g().addStringNotThrow("jump_src", DailyModeConfigHandler.e()).build(), false);
  }
  
  public void a()
  {
    if (d())
    {
      if (this.c == null)
      {
        this.c = LayoutInflater.from(this.b.getContext()).inflate(2131626213, null, false);
        localObject = (TextView)this.c.findViewById(2131447275);
        ((TextView)localObject).setTextSize(0, Utils.dp2px(14.0D));
        ((TextView)localObject).setText(ReadInJoyDailyOverScrollListener.a(((TextView)localObject).getContext()));
        float f = e();
        this.c.setBackgroundResource(2130851370);
        this.c.getBackground().setAlpha((int)(f * 255.0F));
        this.c.setPadding(0, 0, 0, 0);
        localObject = new RelativeLayout.LayoutParams(this.b.getWidth(), this.b.getHeight());
        this.b.addView(this.c, (ViewGroup.LayoutParams)localObject);
        f();
      }
      this.c.setVisibility(0);
      this.c.setOnClickListener(this.e);
      return;
    }
    Object localObject = this.c;
    if (localObject != null)
    {
      ((View)localObject).setVisibility(8);
      this.b.removeView(this.c);
      this.c = null;
    }
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    this.a = paramIReadInJoyModel;
  }
  
  public IReadInJoyModel b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.helper.ProteusItemHelper
 * JD-Core Version:    0.7.0.1
 */