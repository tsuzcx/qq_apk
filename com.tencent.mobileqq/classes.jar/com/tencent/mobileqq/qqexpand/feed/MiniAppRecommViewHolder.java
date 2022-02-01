package com.tencent.mobileqq.qqexpand.feed;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqexpand.bean.feed.MiniAppRecommInfo;
import com.tencent.mobileqq.qqexpand.widget.WrapContentLinearLayoutManager;
import com.tencent.mobileqq.structmsg.RoundedColorDrawable;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import cooperation.vip.tianshu.TianShuManager;
import mqq.app.AppRuntime;

public class MiniAppRecommViewHolder
  extends RecyclerView.ViewHolder
{
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private final RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private final ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private final MiniAppRecommViewHolder.MiniAppAdapter jdField_a_of_type_ComTencentMobileqqQqexpandFeedMiniAppRecommViewHolder$MiniAppAdapter;
  private final ViewGroup b;
  
  public MiniAppRecommViewHolder(View paramView, Activity paramActivity)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131376809));
    this.b = ((ViewGroup)paramView.findViewById(2131365169));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378529));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131371098));
    int i = AIOUtils.b(4.0F, paramActivity.getResources());
    int j = i * 3;
    paramView = new RoundedColorDrawable(-1, j, j, i);
    this.b.setBackgroundDrawable(paramView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setItemAnimator(null);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFeedMiniAppRecommViewHolder$MiniAppAdapter = new MiniAppRecommViewHolder.MiniAppAdapter(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqQqexpandFeedMiniAppRecommViewHolder$MiniAppAdapter);
    paramView = new WrapContentLinearLayoutManager(paramActivity, 0, false);
    paramView.setAutoMeasureEnabled(false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    TianShuReportData localTianShuReportData = new TianShuReportData();
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null) {
      localObject = ((AppRuntime)localObject).getAccount();
    } else {
      localObject = "";
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("_");
    localStringBuilder.append(l);
    localTianShuReportData.b = localStringBuilder.toString();
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
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    localViewGroup.setPadding(localViewGroup.getPaddingLeft(), paramInt, this.jdField_a_of_type_AndroidViewViewGroup.getPaddingRight(), this.jdField_a_of_type_AndroidViewViewGroup.getPaddingBottom());
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMiniAppRecommInfo.headDesc);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFeedMiniAppRecommViewHolder$MiniAppAdapter.a(paramMiniAppRecommInfo.appInfoList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.feed.MiniAppRecommViewHolder
 * JD-Core Version:    0.7.0.1
 */