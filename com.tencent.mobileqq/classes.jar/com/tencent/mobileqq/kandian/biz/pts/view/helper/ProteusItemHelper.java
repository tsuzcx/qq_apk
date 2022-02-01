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
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyOverScrollListener;
import com.tencent.mobileqq.kandian.biz.pts.item.ProteusItemView;
import com.tencent.mobileqq.kandian.biz.pts.item.ProteusItemView.OnItemDrawFinishedListener;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class ProteusItemHelper
  implements ProteusItemView.OnItemDrawFinishedListener
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ProteusItemHelper.1(this);
  private View jdField_a_of_type_AndroidViewView;
  private final ProteusItemView jdField_a_of_type_ComTencentMobileqqKandianBizPtsItemProteusItemView;
  private IReadInJoyModel jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel;
  private boolean jdField_a_of_type_Boolean = false;
  
  public ProteusItemHelper(ProteusItemView paramProteusItemView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsItemProteusItemView = paramProteusItemView;
    b();
  }
  
  private static float a()
  {
    try
    {
      float f = Float.valueOf((String)RIJSPUtils.a("kandian_daily_wrapper_alpha", "1.0")).floatValue();
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
  
  private boolean a()
  {
    return false;
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsItemProteusItemView.a(this);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009882", "0X8009882", 0, 0, "", "", "", RIJTransMergeKanDianReport.a().addStringNotThrow("jump_src", DailyModeConfigHandler.b()).build(), false);
  }
  
  public IReadInJoyModel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel;
  }
  
  public void a()
  {
    if (a())
    {
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsItemProteusItemView.getContext()).inflate(2131560166, null, false);
        localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378636);
        ((TextView)localObject).setTextSize(0, Utils.dp2px(14.0D));
        ((TextView)localObject).setText(ReadInJoyDailyOverScrollListener.a(((TextView)localObject).getContext()));
        float f = a();
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849665);
        this.jdField_a_of_type_AndroidViewView.getBackground().setAlpha((int)(f * 255.0F));
        this.jdField_a_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
        localObject = new RelativeLayout.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsItemProteusItemView.getWidth(), this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsItemProteusItemView.getHeight());
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsItemProteusItemView.addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
        c();
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null)
    {
      ((View)localObject).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsItemProteusItemView.removeView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewView = null;
    }
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel = paramIReadInJoyModel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.helper.ProteusItemHelper
 * JD-Core Version:    0.7.0.1
 */