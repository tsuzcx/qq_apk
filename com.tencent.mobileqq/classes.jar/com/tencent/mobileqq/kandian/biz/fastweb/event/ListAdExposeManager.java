package com.tencent.mobileqq.kandian.biz.fastweb.event;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebAdReportService;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListAdapter;
import com.tencent.mobileqq.kandian.biz.fastweb.adapter.FastWebMergeAdapter;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.ReadInJoyCommentListView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.AbsListView;
import com.tencent.widget.HeaderViewListAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ListAdExposeManager
{
  private int a = 1;
  private Context b;
  private Rect c = new Rect();
  private ArrayList<ListAdExposeData> d = new ArrayList();
  private HashSet<ListAdExposeData> e = new HashSet();
  private HashSet<ListAdExposeData> f = new HashSet();
  private HashSet<ListAdExposeData> g = new HashSet();
  private HashSet<ListAdExposeData> h = new HashSet();
  
  public ListAdExposeManager(Context paramContext)
  {
    this.b = paramContext;
  }
  
  private ListAdExposeData a(int paramInt)
  {
    int j = 0;
    try
    {
      int i = this.d.size() - 1;
      ListAdExposeData localListAdExposeData;
      while (j <= i)
      {
        int k = j + i >>> 1;
        localListAdExposeData = (ListAdExposeData)this.d.get(k);
        int m = localListAdExposeData.a;
        m -= paramInt;
        if (m < 0) {
          j = k + 1;
        } else if (m > 0) {
          i = k - 1;
        } else {
          return localListAdExposeData;
        }
      }
      paramInt = -(j + 1);
      if ((paramInt >= 0) && (paramInt < this.d.size()))
      {
        localListAdExposeData = (ListAdExposeData)this.d.get(paramInt);
        return localListAdExposeData;
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  private void a(ListAdExposeData paramListAdExposeData)
  {
    if (this.g.contains(paramListAdExposeData)) {
      return;
    }
    this.g.add(paramListAdExposeData);
    if ((this.h.contains(paramListAdExposeData)) && (!this.e.contains(paramListAdExposeData)))
    {
      this.e.add(paramListAdExposeData);
      d(paramListAdExposeData);
    }
  }
  
  private void a(ListAdExposeData paramListAdExposeData, View paramView)
  {
    paramView.getLocalVisibleRect(this.c);
    int i = this.c.height();
    long l = System.currentTimeMillis();
    if ((paramListAdExposeData.b == 0L) && (i > 0))
    {
      paramListAdExposeData.b = l;
      ThreadManager.getUIHandler().postDelayed(new ListAdExposeManager.1(this, paramListAdExposeData), 1000L);
    }
    else if (l > paramListAdExposeData.b + 1L)
    {
      paramListAdExposeData.c = l;
      b(paramListAdExposeData);
    }
    int j = paramView.getHeight();
    if ((i > 0) && (j > 0))
    {
      paramListAdExposeData.d = (i / j);
      if (paramListAdExposeData.d > 0.5F) {
        a(paramListAdExposeData);
      }
      return;
    }
    paramListAdExposeData.d = 0.0F;
  }
  
  private void b(ListAdExposeData paramListAdExposeData)
  {
    if (this.h.contains(paramListAdExposeData)) {
      return;
    }
    this.h.add(paramListAdExposeData);
    if ((this.g.contains(paramListAdExposeData)) && (!this.e.contains(paramListAdExposeData)))
    {
      this.e.add(paramListAdExposeData);
      d(paramListAdExposeData);
    }
  }
  
  private void b(AbsListView paramAbsListView)
  {
    if (!(paramAbsListView instanceof ReadInJoyCommentListView)) {
      return;
    }
    int k = 0;
    int i = 0;
    paramAbsListView = ((ReadInJoyCommentListView)paramAbsListView).getAdapter();
    int j = k;
    Object localObject;
    if ((paramAbsListView instanceof HeaderViewListAdapter))
    {
      paramAbsListView = ((HeaderViewListAdapter)paramAbsListView).getWrappedAdapter();
      j = k;
      if ((paramAbsListView instanceof FastWebMergeAdapter))
      {
        paramAbsListView = ((FastWebMergeAdapter)paramAbsListView).a().iterator();
        for (;;)
        {
          j = i;
          if (!paramAbsListView.hasNext()) {
            break;
          }
          localObject = (BaseAdapter)paramAbsListView.next();
          if (!(localObject instanceof ReadInJoyCommentListAdapter)) {
            i += ((BaseAdapter)localObject).getCount();
          }
        }
      }
    }
    if (j > 0)
    {
      paramAbsListView = this.d.iterator();
      while (paramAbsListView.hasNext())
      {
        localObject = (ListAdExposeData)paramAbsListView.next();
        if (!((ListAdExposeData)localObject).e)
        {
          ((ListAdExposeData)localObject).a += j;
          ((ListAdExposeData)localObject).e = true;
        }
      }
    }
  }
  
  private void c(ListAdExposeData paramListAdExposeData)
  {
    if (this.f.contains(paramListAdExposeData)) {
      return;
    }
    this.f.add(paramListAdExposeData);
    e(paramListAdExposeData);
  }
  
  private void d(ListAdExposeData paramListAdExposeData)
  {
    float f1 = paramListAdExposeData.d;
    long l = paramListAdExposeData.c;
    paramListAdExposeData = paramListAdExposeData.f;
    if (paramListAdExposeData == null) {
      return;
    }
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject1.put("article_id", String.valueOf(paramListAdExposeData.mArticleID));
      localJSONObject1.put("rowkey", String.valueOf(paramListAdExposeData.mRowKey));
      paramListAdExposeData.mBusiJson = localJSONObject1;
      localJSONObject2.put("exposureArea", f1);
      localJSONObject2.put("exposureTime", l);
      paramListAdExposeData.mReportDataJson = localJSONObject2;
    }
    catch (Exception localException)
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ListAdExposeManager", localException.getMessage());
    }
    paramListAdExposeData.mCommentAdReportType = 1;
    ((IRIJFastWebAdReportService)QRoute.api(IRIJFastWebAdReportService.class)).report(paramListAdExposeData, 38, 2, 2);
  }
  
  private void e(ListAdExposeData paramListAdExposeData)
  {
    paramListAdExposeData = paramListAdExposeData.f;
    if (paramListAdExposeData == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("article_id", String.valueOf(paramListAdExposeData.mArticleID));
      localJSONObject.put("rowkey", String.valueOf(paramListAdExposeData.mRowKey));
      paramListAdExposeData.mBusiJson = localJSONObject;
    }
    catch (Exception localException)
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ListAdExposeManager", localException.getMessage());
    }
    paramListAdExposeData.mCommentAdReportType = 2;
    ((IRIJFastWebAdReportService)QRoute.api(IRIJFastWebAdReportService.class)).report(paramListAdExposeData, 38, 2, 2);
  }
  
  public void a()
  {
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ListAdExposeManager", "clearCache");
    this.d.clear();
    this.e.clear();
    this.f.clear();
    this.g.clear();
    this.h.clear();
  }
  
  public void a(AbsListView paramAbsListView)
  {
    if (paramAbsListView.getVisibility() != 0) {
      return;
    }
    b(paramAbsListView);
    int j = paramAbsListView.getFirstVisiblePosition();
    int k = paramAbsListView.getChildCount();
    if (k <= 0) {
      return;
    }
    int i = 0;
    while (i < k)
    {
      View localView = paramAbsListView.getChildAt(i);
      ListAdExposeData localListAdExposeData = a(j + i);
      if (localListAdExposeData != null)
      {
        c(localListAdExposeData);
        a(localListAdExposeData, localView);
      }
      i += 1;
    }
  }
  
  public void a(ArrayList<ListAdExposeData> paramArrayList)
  {
    try
    {
      this.d.addAll(paramArrayList);
      Collections.sort(this.d);
      return;
    }
    finally
    {
      paramArrayList = finally;
      throw paramArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.event.ListAdExposeManager
 * JD-Core Version:    0.7.0.1
 */