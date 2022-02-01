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
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.feeds.HotWordItem;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class ComponentContentHotSearch$HotWordsAdapter
  extends BaseAdapter
{
  private List<HotWordItem> b;
  
  protected ComponentContentHotSearch$HotWordsAdapter(ComponentContentHotSearch paramComponentContentHotSearch) {}
  
  public HotWordItem a(int paramInt)
  {
    return (HotWordItem)this.b.get(paramInt);
  }
  
  public void a(List<HotWordItem> paramList)
  {
    this.b = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.b;
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
    Object localObject1 = new ComponentContentHotSearch.ViewHolder(this.a);
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131626264, null);
    ((ComponentContentHotSearch.ViewHolder)localObject1).b = ((TextView)paramViewGroup.findViewById(2131435676));
    ((ComponentContentHotSearch.ViewHolder)localObject1).c = ((TextView)paramViewGroup.findViewById(2131447576));
    paramViewGroup.setOnClickListener((View.OnClickListener)localObject1);
    paramViewGroup.setTag(localObject1);
    HotWordItem localHotWordItem = a(paramInt);
    if (!TextUtils.isEmpty(localHotWordItem.a)) {
      ((ComponentContentHotSearch.ViewHolder)localObject1).c.setText(localHotWordItem.a);
    }
    paramView = ((ComponentContentHotSearch.ViewHolder)localObject1).b;
    Object localObject2 = new StringBuilder();
    int i = paramInt + 1;
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append("");
    paramView.setText(((StringBuilder)localObject2).toString());
    localObject2 = ((ComponentContentHotSearch.ViewHolder)localObject1).b;
    if (!TextUtils.isEmpty(localHotWordItem.c)) {
      paramView = localHotWordItem.c;
    } else {
      paramView = "#8C000000";
    }
    ((TextView)localObject2).setTextColor(Color.parseColor(paramView));
    paramView = new GradientDrawable();
    paramInt = 0;
    paramView.setShape(0);
    paramView.setCornerRadius(DisplayUtil.a(this.a.getContext(), 2.0F));
    if (!TextUtils.isEmpty(localHotWordItem.d)) {
      paramInt = Color.parseColor(localHotWordItem.d);
    }
    paramView.setColor(paramInt);
    ((ComponentContentHotSearch.ViewHolder)localObject1).b.setBackgroundDrawable(paramView);
    ((ComponentContentHotSearch.ViewHolder)localObject1).a = localHotWordItem;
    if (!localHotWordItem.e)
    {
      localHotWordItem.e = true;
      paramView = RIJTransMergeKanDianReport.a(localHotWordItem.a, ComponentContentHotSearch.a(this.a).innerUniqueID, i);
      try
      {
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80096DC", "0X80096DC", 0, 0, "", "", "", paramView.toString(), false);
      }
      catch (Exception paramView)
      {
        localObject1 = ComponentContentHotSearch.a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getView, e = ");
        ((StringBuilder)localObject2).append(paramView);
        QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      }
      paramView = new ArrayList();
      localObject1 = new ReportInfo();
      ((ReportInfo)localObject1).mUin = RIJQQAppInterfaceUtil.c();
      ((ReportInfo)localObject1).mOperation = 52;
      ((ReportInfo)localObject1).mInnerId = ComponentContentHotSearch.a(this.a).innerUniqueID;
      ((ReportInfo)localObject1).mHotWord = localHotWordItem.a;
      paramView.add(localObject1);
      ReadInJoyLogicEngine.a().a(paramView);
    }
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentHotSearch.HotWordsAdapter
 * JD-Core Version:    0.7.0.1
 */