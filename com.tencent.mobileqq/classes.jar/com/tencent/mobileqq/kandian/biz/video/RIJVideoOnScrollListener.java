package com.tencent.mobileqq.kandian.biz.video;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class RIJVideoOnScrollListener
  implements AbsListView.OnScrollListener
{
  public static boolean a;
  private static boolean jdField_c_of_type_Boolean;
  double jdField_a_of_type_Double = 0.0D;
  private int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  private View jdField_a_of_type_AndroidViewView;
  private final VideoHandler jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler;
  private AbsListView jdField_a_of_type_ComTencentWidgetAbsListView;
  final double jdField_b_of_type_Double = 200.0D;
  private int jdField_b_of_type_Int;
  long jdField_b_of_type_Long = 0L;
  private View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean;
  long jdField_c_of_type_Long = 0L;
  private boolean d = true;
  
  public RIJVideoOnScrollListener(VideoHandler paramVideoHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler = paramVideoHandler;
    this.jdField_a_of_type_ComTencentWidgetAbsListView = paramVideoHandler.a();
  }
  
  public static boolean a()
  {
    if (!jdField_a_of_type_Boolean)
    {
      Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.KDCfg.name(), null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length >= 2) {
          jdField_c_of_type_Boolean = localObject[1].equals("1");
        }
        jdField_a_of_type_Boolean = true;
      }
    }
    return jdField_c_of_type_Boolean;
  }
  
  private boolean a(AbsListView paramAbsListView)
  {
    double d1 = this.jdField_a_of_type_Double;
    return (d1 > 0.0D) && (d1 < 200.0D) && (!this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a().d()) && (!a()) && (paramAbsListView.getVisibility() == 0);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a();
    if ((paramAbsListView != null) && (paramAbsListView.h())) {
      return;
    }
    paramAbsListView = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(0);
    if (paramAbsListView != null)
    {
      if (this.jdField_a_of_type_Long == 0L)
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        return;
      }
      this.jdField_b_of_type_Long = (paramAbsListView.getHeight() * paramInt1 - paramAbsListView.getTop());
      long l1 = this.jdField_b_of_type_Long;
      long l2 = this.jdField_c_of_type_Long;
      long l3 = System.currentTimeMillis();
      long l4 = this.jdField_a_of_type_Long;
      if (l3 == l4) {
        return;
      }
      this.jdField_a_of_type_Double = ((l1 - l2) * 1000L / (l3 - l4));
      this.jdField_a_of_type_Long = l3;
      this.jdField_c_of_type_Long = this.jdField_b_of_type_Long;
      if (a(this.jdField_a_of_type_ComTencentWidgetAbsListView))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "低速滚动触发自动播放检测");
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.b(this.jdField_a_of_type_ComTencentWidgetAbsListView, ReadInJoyBaseAdapter.jdField_a_of_type_Int);
      }
    }
    else
    {
      this.jdField_a_of_type_Long = 0L;
      this.jdField_b_of_type_Long = 0L;
      this.jdField_c_of_type_Long = 0L;
    }
    paramInt3 = this.jdField_a_of_type_Int;
    if (paramInt1 > paramInt3) {
      this.jdField_b_of_type_Boolean = true;
    } else if (paramInt1 < paramInt3) {
      this.jdField_b_of_type_Boolean = false;
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = (paramInt1 + paramInt2 - 1);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(0);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.k();
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.r();
      return;
    }
    this.d = this.jdField_b_of_type_Boolean;
    paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a(this.jdField_a_of_type_ComTencentWidgetAbsListView);
    if (paramAbsListView == null) {
      paramInt = this.jdField_a_of_type_ComTencentWidgetAbsListView.getFirstVisiblePosition();
    } else {
      paramInt = paramAbsListView.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a(paramInt, this.d);
    if (QLog.isColorLevel())
    {
      paramAbsListView = new StringBuilder();
      paramAbsListView.append("predownload position: ");
      paramAbsListView.append(paramInt);
      paramAbsListView.append(" when scroll state idle");
      QLog.d("ReadInJoyBaseAdapter", 2, paramAbsListView.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.b(this.jdField_a_of_type_ComTencentWidgetAbsListView, ReadInJoyBaseAdapter.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.RIJVideoOnScrollListener
 * JD-Core Version:    0.7.0.1
 */