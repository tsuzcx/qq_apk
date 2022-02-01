package com.tencent.mobileqq.leba.controller.list;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.leba.LebaConstant;
import com.tencent.mobileqq.leba.entity.LebaExposureInfo;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.entity.UpdateRedTouchParam;
import com.tencent.mobileqq.leba.logic.LebaPluginLogic;
import com.tencent.mobileqq.leba.redtouch.LebaRedTouchBase;
import com.tencent.mobileqq.leba.report.LebaDaTong;
import com.tencent.mobileqq.leba.utils.LebaPluginViewUtil;
import com.tencent.mobileqq.minigame.api.report.IMiniGameReport;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class LebaListViewAdapter
  extends BaseAdapter
{
  AppRuntime a;
  Context b;
  String c = "";
  View.OnClickListener d;
  AbsListView e;
  int f;
  private List<LebaViewItem> g;
  private int h;
  private int i;
  private LayoutInflater j;
  private Drawable k;
  private HashSet<Long> l = new HashSet(30);
  private LebaRedTouchBase m;
  
  public LebaListViewAdapter(Context paramContext, List<LebaViewItem> paramList, int paramInt1, int paramInt2, AppRuntime paramAppRuntime, AbsListView paramAbsListView, View.OnClickListener paramOnClickListener)
  {
    this.b = paramContext;
    this.g = paramList;
    this.a = paramAppRuntime;
    this.h = paramInt1;
    this.i = paramInt2;
    this.d = paramOnClickListener;
    this.e = paramAbsListView;
    this.j = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.k = paramContext.getResources().getDrawable(2130846957);
    this.f = paramContext.getResources().getDisplayMetrics().densityDpi;
  }
  
  private void a(int paramInt, View paramView, LebaViewItem paramLebaViewItem)
  {
    paramView.setVisibility(8);
    if (LebaPluginLogic.a() != 0) {
      return;
    }
    if (paramInt == 0)
    {
      paramView.setVisibility(0);
      return;
    }
    LebaViewItem localLebaViewItem = (LebaViewItem)getItem(paramInt - 1);
    if (localLebaViewItem != null)
    {
      if (localLebaViewItem.b == null) {
        return;
      }
      if (paramLebaViewItem.h == 2)
      {
        if (localLebaViewItem.b.groupId != 3) {
          paramView.setVisibility(0);
        }
        return;
      }
      if (paramLebaViewItem.b.groupId != localLebaViewItem.b.groupId) {
        paramView.setVisibility(0);
      }
    }
  }
  
  private void a(long paramLong)
  {
    Object localObject = this.m;
    if (localObject == null)
    {
      ((IMiniGameReport)QRoute.api(IMiniGameReport.class)).exposeReportMiniGameFromLeba(null);
      return;
    }
    localObject = ((LebaRedTouchBase)localObject).a(this.a, String.valueOf(paramLong));
    if ((localObject != null) && (!TextUtils.isEmpty(((BusinessInfoCheckUpdate.AppInfo)localObject).buffer.get())))
    {
      ((IMiniGameReport)QRoute.api(IMiniGameReport.class)).exposeReportMiniGameFromLeba((BusinessInfoCheckUpdate.AppInfo)localObject);
      return;
    }
    ((IMiniGameReport)QRoute.api(IMiniGameReport.class)).exposeReportMiniGameFromLeba(null);
  }
  
  private void a(LebaListViewAdapter.CornerListItemHolder paramCornerListItemHolder, LebaViewItem paramLebaViewItem)
  {
    paramCornerListItemHolder.g.g();
  }
  
  private void a(RedTouch paramRedTouch, long paramLong, String paramString)
  {
    if (this.m != null)
    {
      UpdateRedTouchParam localUpdateRedTouchParam = new UpdateRedTouchParam();
      localUpdateRedTouchParam.a = this.a;
      localUpdateRedTouchParam.b = this.b;
      localUpdateRedTouchParam.c = paramRedTouch;
      localUpdateRedTouchParam.d = paramLong;
      localUpdateRedTouchParam.e = paramString;
      localUpdateRedTouchParam.g = false;
      this.m.a(localUpdateRedTouchParam);
    }
  }
  
  private void a(Long paramLong, StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    if (paramLong == null) {
      return;
    }
    if (paramLong.longValue() == 10000L)
    {
      paramStringBuilder.append("_");
      paramStringBuilder.append(paramInt1);
      return;
    }
    if (paramLong.longValue() == 10004L)
    {
      paramStringBuilder.append("_");
      paramStringBuilder.append(paramInt2);
      return;
    }
    Object localObject2 = null;
    LebaRedTouchBase localLebaRedTouchBase = this.m;
    Object localObject1 = localObject2;
    if (localLebaRedTouchBase != null)
    {
      localObject1 = localObject2;
      if (localLebaRedTouchBase.c() != null)
      {
        paramLong = (LebaExposureInfo)this.m.c().get(paramLong);
        localObject1 = localObject2;
        if (paramLong != null) {
          localObject1 = Integer.valueOf(paramLong.a);
        }
      }
    }
    paramStringBuilder.append("_");
    if (localObject1 == null) {
      paramInt1 = 0;
    } else {
      paramInt1 = ((Integer)localObject1).intValue();
    }
    paramStringBuilder.append(paramInt1);
  }
  
  private void a(Long paramLong, StringBuilder paramStringBuilder, Map<Long, Integer> paramMap)
  {
    if (paramLong == null) {
      return;
    }
    long l1 = paramLong.longValue();
    int n = 0;
    if (l1 == 10000L)
    {
      paramStringBuilder.append("_");
      paramStringBuilder.append(0);
      return;
    }
    if (paramLong.longValue() == 10004L)
    {
      paramStringBuilder.append("_");
      paramStringBuilder.append(0);
      return;
    }
    Integer localInteger = null;
    if (paramMap != null) {
      localInteger = (Integer)paramMap.get(paramLong);
    }
    paramStringBuilder.append("_");
    if (localInteger != null) {
      n = localInteger.intValue();
    }
    paramStringBuilder.append(n);
  }
  
  private void b(LebaListViewAdapter.CornerListItemHolder paramCornerListItemHolder, LebaViewItem paramLebaViewItem)
  {
    if ((paramLebaViewItem != null) && (paramLebaViewItem.b != null))
    {
      a(paramCornerListItemHolder.g, paramLebaViewItem.b.uiResId, paramLebaViewItem.b.strPkgName);
      if (!this.l.contains(Long.valueOf(paramLebaViewItem.b.uiResId))) {
        this.l.add(Long.valueOf(paramLebaViewItem.b.uiResId));
      }
    }
  }
  
  public void a() {}
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.l.size() > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.l.iterator();
      Map localMap = c();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        if ((localLong.longValue() != 10004L) || (paramBoolean))
        {
          if (localLong.longValue() == 8059L) {
            a(localLong.longValue());
          }
          localStringBuilder.append(localLong);
          a(localLong, localStringBuilder, localMap);
          a(localLong, localStringBuilder, paramInt1, paramInt2);
          if (localIterator.hasNext()) {
            localStringBuilder.append(";");
          }
        }
      }
      ReportController.b(this.a, "CliOper", "", "", "trends_plugin", "old_plugin_exp", 0, 0, "", "", "", localStringBuilder.toString());
      if (QLog.isColorLevel()) {
        QLog.d("LebaListViewAdapter", 2, localStringBuilder.toString());
      }
    }
    this.l.clear();
  }
  
  void a(View paramView, LebaListViewAdapter.CornerListItemHolder paramCornerListItemHolder, int paramInt)
  {
    if (paramView != null)
    {
      if (paramCornerListItemHolder == null) {
        return;
      }
      int n = LebaConstant.b();
      LebaDaTong.a(paramView, paramCornerListItemHolder.c, paramInt + n + 1);
      if (paramCornerListItemHolder.c != null) {
        VideoReport.setElementReuseIdentifier(paramView, String.valueOf(paramCornerListItemHolder.c.hashCode()));
      }
    }
  }
  
  public void a(LebaRedTouchBase paramLebaRedTouchBase)
  {
    this.m = paramLebaRedTouchBase;
  }
  
  public void a(List<LebaViewItem> paramList)
  {
    this.g = paramList;
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.a = paramAppRuntime;
  }
  
  protected boolean a(LebaViewItem paramLebaViewItem)
  {
    return TextUtils.isEmpty(paramLebaViewItem.c) ^ true;
  }
  
  public void b()
  {
    if (this.e != null)
    {
      int n = 0;
      while (n < this.e.getChildCount())
      {
        Object localObject = this.e.getChildAt(n);
        if (localObject != null) {
          if ((((View)localObject).getTag(-1) != null) && ((((View)localObject).getTag(-1) instanceof Integer)))
          {
            if (((Integer)((View)localObject).getTag(-1)).intValue() == 0)
            {
              if (!this.l.contains(Long.valueOf(10000L))) {
                this.l.add(Long.valueOf(10000L));
              }
              if (!this.l.contains(Long.valueOf(10004L))) {
                this.l.add(Long.valueOf(10004L));
              }
            }
            else
            {
              int i1 = ((Integer)((View)localObject).getTag(-1)).intValue();
              if ((i1 == this.g.size() - 1) && (i1 >= 0)) {
                localObject = (LebaViewItem)this.g.get(i1);
              }
            }
          }
          else if ((((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof LebaListViewAdapter.CornerListItemHolder)))
          {
            localObject = (LebaListViewAdapter.CornerListItemHolder)((View)localObject).getTag();
            if ((localObject != null) && (((LebaListViewAdapter.CornerListItemHolder)localObject).c != null) && (((LebaListViewAdapter.CornerListItemHolder)localObject).c.b != null))
            {
              long l1 = ((LebaListViewAdapter.CornerListItemHolder)localObject).c.b.uiResId;
              if (!this.l.contains(Long.valueOf(l1))) {
                this.l.add(Long.valueOf(l1));
              }
            }
          }
        }
        n += 1;
      }
    }
  }
  
  public Map<Long, Integer> c()
  {
    Object localObject = this.g;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = new HashMap();
      Iterator localIterator = this.g.iterator();
      int n = 1;
      while (localIterator.hasNext())
      {
        LebaViewItem localLebaViewItem = (LebaViewItem)localIterator.next();
        if ((localLebaViewItem != null) && (localLebaViewItem.b != null) && (!a(localLebaViewItem)))
        {
          ((Map)localObject).put(Long.valueOf(localLebaViewItem.b.uiResId), Integer.valueOf(n));
          n += 1;
        }
      }
      return localObject;
    }
    return null;
  }
  
  public void d()
  {
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.g;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.g;
    if ((localList != null) && (paramInt < localList.size()) && (paramInt >= 0)) {
      return (LebaViewItem)this.g.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  @TargetApi(16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (getItem(paramInt) == null)
    {
      localView = paramView;
    }
    else
    {
      LebaViewItem localLebaViewItem = (LebaViewItem)getItem(paramInt);
      LebaListViewAdapter.CornerListItemHolder localCornerListItemHolder;
      if (paramView == null)
      {
        localView = this.j.inflate(this.h, null);
        localCornerListItemHolder = new LebaListViewAdapter.CornerListItemHolder(this);
        localCornerListItemHolder.d = ((RelativeLayout)localView.findViewById(2131437058));
        localCornerListItemHolder.a = ((TextView)localView.findViewById(2131437144));
        localCornerListItemHolder.b = ((ImageView)localView.findViewById(2131437143));
        localCornerListItemHolder.e = ((ImageView)localView.findViewById(2131428776));
        localCornerListItemHolder.f = localView.findViewById(2131437057);
        localCornerListItemHolder.g = new RedTouch(this.b, localCornerListItemHolder.d).b(35.0F).a();
        localView.setTag(localCornerListItemHolder);
      }
      else
      {
        localCornerListItemHolder = (LebaListViewAdapter.CornerListItemHolder)paramView.getTag();
        localView = paramView;
      }
      localCornerListItemHolder.a.setTextColor(this.b.getResources().getColor(2131168001));
      if (localLebaViewItem.h == 1) {
        b(localCornerListItemHolder, localLebaViewItem);
      } else if (localLebaViewItem.h == 2) {
        a(localCornerListItemHolder, localLebaViewItem);
      }
      LebaPluginViewUtil.a(localCornerListItemHolder.b, localCornerListItemHolder.a, localCornerListItemHolder.d, localLebaViewItem);
      a(paramInt, localCornerListItemHolder.f, localLebaViewItem);
      localCornerListItemHolder.c = localLebaViewItem;
      if (localView != null)
      {
        localCornerListItemHolder.d.setOnClickListener(this.d);
        localCornerListItemHolder.d.setTag(-1, Integer.valueOf(paramInt));
        localView.setTag(-1, Integer.valueOf(paramInt));
      }
      if (paramInt == 0)
      {
        if (!this.l.contains(Long.valueOf(10000L))) {
          this.l.add(Long.valueOf(10000L));
        }
        if (!this.l.contains(Long.valueOf(10004L))) {
          this.l.add(Long.valueOf(10004L));
        }
      }
      a(localCornerListItemHolder.d, localCornerListItemHolder, paramInt);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.controller.list.LebaListViewAdapter
 * JD-Core Version:    0.7.0.1
 */