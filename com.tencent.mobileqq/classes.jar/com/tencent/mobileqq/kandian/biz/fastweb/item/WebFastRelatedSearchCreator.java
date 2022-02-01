package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.IStateChangeListener;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.biz.pts.ItemCreator;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

public class WebFastRelatedSearchCreator
  implements IStateChangeListener, ItemCreator
{
  public static boolean a = false;
  
  private static void b(String paramString1, String paramString2)
  {
    QLog.d("WebFastRelatedSearchCreator", 2, new Object[] { "actionName = ", paramString1, "\n", "r5 = ", paramString2 });
    PublicAccountReportUtils.a(null, "", paramString1, paramString1, 0, 0, "", "", "", paramString2, false);
  }
  
  public BaseItemViewHolder a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    return new WebFastRelatedSearchCreator.RelatedSearchViewHolder(LayoutInflater.from(paramContext).inflate(2131626239, paramViewGroup, false), paramBaseData, paramContext, null);
  }
  
  public void a() {}
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public boolean a(BaseData paramBaseData)
  {
    return paramBaseData.aP == 20;
  }
  
  public int b(BaseData paramBaseData)
  {
    return 18;
  }
  
  public void b() {}
  
  public void c()
  {
    a = false;
  }
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebFastRelatedSearchCreator
 * JD-Core Version:    0.7.0.1
 */