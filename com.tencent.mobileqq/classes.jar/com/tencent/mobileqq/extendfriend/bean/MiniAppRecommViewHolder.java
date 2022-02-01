package com.tencent.mobileqq.extendfriend.bean;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.extendfriend.wiget.WrapContentLinearLayoutManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.RoundedColorDrawable;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import cooperation.vip.tianshu.TianShuManager;
import mqq.app.AppRuntime;

public class MiniAppRecommViewHolder
  extends RecyclerView.ViewHolder
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private MiniAppRecommViewHolder.MiniAppAdapter jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommViewHolder$MiniAppAdapter;
  private ViewGroup b;
  
  public MiniAppRecommViewHolder(View paramView, Activity paramActivity)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131377356));
    this.b = ((ViewGroup)paramView.findViewById(2131365294));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379166));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131371478));
    int i = AIOUtils.a(4.0F, paramActivity.getResources());
    paramView = new RoundedColorDrawable(-1, i * 3, i * 3, i);
    this.b.setBackgroundDrawable(paramView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setItemAnimator(null);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommViewHolder$MiniAppAdapter = new MiniAppRecommViewHolder.MiniAppAdapter(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommViewHolder$MiniAppAdapter);
    paramView = new WrapContentLinearLayoutManager(paramActivity, 0, false);
    paramView.setAutoMeasureEnabled(false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    TianShuReportData localTianShuReportData = new TianShuReportData();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str = "";
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    localTianShuReportData.b = (str + "_" + l);
    localTianShuReportData.jdField_a_of_type_Int = 1;
    localTianShuReportData.jdField_e_of_type_JavaLangString = "tianshu.78";
    localTianShuReportData.jdField_f_of_type_JavaLangString = "tianshu.78";
    localTianShuReportData.g = Integer.toString(paramInt3);
    localTianShuReportData.h = "";
    localTianShuReportData.jdField_a_of_type_Long = l;
    localTianShuReportData.d = paramInt1;
    localTianShuReportData.k = Integer.toString(paramInt2);
    localTianShuReportData.jdField_e_of_type_Int = 1;
    localTianShuReportData.jdField_f_of_type_Int = 1;
    TianShuManager.getInstance().report(localTianShuReportData);
  }
  
  public void a(MiniAppRecommInfo paramMiniAppRecommInfo, int paramInt)
  {
    if (paramMiniAppRecommInfo == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setPadding(this.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), paramInt, this.jdField_a_of_type_AndroidViewViewGroup.getPaddingRight(), this.jdField_a_of_type_AndroidViewViewGroup.getPaddingBottom());
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMiniAppRecommInfo.headDesc);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommViewHolder$MiniAppAdapter.a(paramMiniAppRecommInfo.appInfoList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.bean.MiniAppRecommViewHolder
 * JD-Core Version:    0.7.0.1
 */