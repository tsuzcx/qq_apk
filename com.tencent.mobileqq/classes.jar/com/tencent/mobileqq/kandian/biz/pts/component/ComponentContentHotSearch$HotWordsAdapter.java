package com.tencent.mobileqq.kandian.biz.pts.component;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.feeds.HotWordItem;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class ComponentContentHotSearch$HotWordsAdapter
  extends BaseAdapter
{
  private List<HotWordItem> jdField_a_of_type_JavaUtilList;
  
  protected ComponentContentHotSearch$HotWordsAdapter(ComponentContentHotSearch paramComponentContentHotSearch) {}
  
  public HotWordItem a(int paramInt)
  {
    return (HotWordItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<HotWordItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = new ComponentContentHotSearch.ViewHolder(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentHotSearch);
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560217, null);
    ((ComponentContentHotSearch.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131368759));
    ((ComponentContentHotSearch.ViewHolder)localObject1).b = ((TextView)paramViewGroup.findViewById(2131378876));
    paramViewGroup.setOnClickListener((View.OnClickListener)localObject1);
    paramViewGroup.setTag(localObject1);
    HotWordItem localHotWordItem = a(paramInt);
    if (!TextUtils.isEmpty(localHotWordItem.jdField_a_of_type_JavaLangString)) {
      ((ComponentContentHotSearch.ViewHolder)localObject1).b.setText(localHotWordItem.jdField_a_of_type_JavaLangString);
    }
    paramView = ((ComponentContentHotSearch.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView;
    Object localObject2 = new StringBuilder();
    int i = paramInt + 1;
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append("");
    paramView.setText(((StringBuilder)localObject2).toString());
    localObject2 = ((ComponentContentHotSearch.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView;
    if (!TextUtils.isEmpty(localHotWordItem.c)) {
      paramView = localHotWordItem.c;
    } else {
      paramView = "#8C000000";
    }
    ((TextView)localObject2).setTextColor(Color.parseColor(paramView));
    paramView = new GradientDrawable();
    paramInt = 0;
    paramView.setShape(0);
    paramView.setCornerRadius(DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentHotSearch.getContext(), 2.0F));
    if (!TextUtils.isEmpty(localHotWordItem.d)) {
      paramInt = Color.parseColor(localHotWordItem.d);
    }
    paramView.setColor(paramInt);
    ((ComponentContentHotSearch.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(paramView);
    ((ComponentContentHotSearch.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsHotWordItem = localHotWordItem;
    if (!localHotWordItem.jdField_a_of_type_Boolean)
    {
      localHotWordItem.jdField_a_of_type_Boolean = true;
      paramView = RIJTransMergeKanDianReport.a(localHotWordItem.jdField_a_of_type_JavaLangString, ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentHotSearch).innerUniqueID, i);
      try
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80096DC", "0X80096DC", 0, 0, "", "", "", paramView.toString(), false);
      }
      catch (Exception paramView)
      {
        localObject1 = ComponentContentHotSearch.jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getView, e = ");
        ((StringBuilder)localObject2).append(paramView);
        QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      }
      paramView = new ArrayList();
      localObject1 = new ReportInfo();
      ((ReportInfo)localObject1).mUin = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin();
      ((ReportInfo)localObject1).mOperation = 52;
      ((ReportInfo)localObject1).mInnerId = ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentHotSearch).innerUniqueID;
      ((ReportInfo)localObject1).mHotWord = localHotWordItem.jdField_a_of_type_JavaLangString;
      paramView.add(localObject1);
      ReadInJoyLogicEngine.a().a(paramView);
    }
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentHotSearch.HotWordsAdapter
 * JD-Core Version:    0.7.0.1
 */