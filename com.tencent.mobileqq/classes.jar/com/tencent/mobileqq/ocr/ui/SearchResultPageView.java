package com.tencent.mobileqq.ocr.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.SougouSearchInfo;
import com.tencent.mobileqq.ocr.TabItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.OCRAccountUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

public class SearchResultPageView
  implements SearchResultAdapter.OnResultItemClickedListener
{
  public BaseOCRTextSearchFragment.SearchActivityInterface a;
  BaseOCRTextSearchFragment b;
  XListView c;
  TextView d;
  LinearLayout e;
  SearchResultAdapter f;
  View g = null;
  boolean h = false;
  boolean i = false;
  Handler j = new Handler(Looper.getMainLooper());
  boolean k = false;
  ProgressBar l;
  boolean m = false;
  int n = 0;
  TabItem o;
  
  public SearchResultPageView(BaseOCRTextSearchFragment.SearchActivityInterface paramSearchActivityInterface, SearchResultFragment paramSearchResultFragment)
  {
    this.a = paramSearchActivityInterface;
    this.b = paramSearchResultFragment;
    this.f = new SearchResultAdapter(paramSearchActivityInterface.a(), this);
  }
  
  private void a(String paramString1, String paramString2)
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.a.a(), "/base/browser");
    localActivityURIRequest.extra().putString("uin", paramString1);
    localActivityURIRequest.extra().putString("url", paramString2);
    localActivityURIRequest.extra().putBoolean("hide_more_button", true);
    QRoute.startUri(localActivityURIRequest, null);
  }
  
  public View a(Context paramContext, TabItem paramTabItem)
  {
    if (this.g == null)
    {
      paramContext = LayoutInflater.from(paramContext).inflate(2131627615, null);
      this.c = ((XListView)paramContext.findViewById(2131445451));
      this.l = ((ProgressBar)paramContext.findViewById(2131446760));
      this.d = ((TextView)paramContext.findViewById(2131439366));
      this.c.setOnTouchListener(this.b.b);
      this.e = ((LinearLayout)paramContext.findViewById(2131437617));
      this.g = paramContext;
      this.c.setAdapter(this.f);
    }
    a(paramTabItem);
    return this.g;
  }
  
  public void a() {}
  
  protected void a(int paramInt)
  {
    if (paramInt != -2)
    {
      if (paramInt != -1)
      {
        if (paramInt != 0)
        {
          if (paramInt == 1)
          {
            this.l.setVisibility(0);
            this.c.setVisibility(8);
            this.d.setVisibility(8);
          }
        }
        else
        {
          this.l.setVisibility(8);
          this.d.setVisibility(8);
          this.c.setVisibility(0);
        }
      }
      else
      {
        this.l.setVisibility(8);
        this.c.setVisibility(8);
        this.d.setVisibility(0);
        this.d.setText(2131893799);
      }
    }
    else
    {
      this.l.setVisibility(8);
      this.c.setVisibility(8);
      this.d.setVisibility(0);
      this.d.setText(2131897093);
    }
    this.a.a(null);
  }
  
  protected void a(TabItem paramTabItem)
  {
    if (this.m) {
      return;
    }
    this.m = true;
    this.o = paramTabItem;
    if ((this.o.d == 0) && (this.o.c != null))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("results: ");
        ((StringBuilder)localObject).append(this.o.c.size());
        QLog.d("Q.ocr.SearchResultFragment", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.o.c;
      if (((List)localObject).size() != 0)
      {
        this.f.a(this.o, (List)localObject, false, false);
      }
      else
      {
        a(-1);
        return;
      }
    }
    b();
    a(paramTabItem.d);
  }
  
  public void a(SearchResultAdapter.ListItem paramListItem)
  {
    if (paramListItem == null) {
      return;
    }
    if ((paramListItem.f == 2049) && (paramListItem.a == 0))
    {
      paramListItem = (OCRTextSearchInfo.SougouSearchInfo)paramListItem.b;
      if ((paramListItem != null) && (!TextUtils.isEmpty(paramListItem.jumpURL))) {
        a(OCRAccountUtil.a(), paramListItem.jumpURL);
      }
    }
    ReportController.b(null, "dc00898", "", "", "0X80082E9", "0X80082E9", 0, 0, "", "", "", "");
  }
  
  public void a(boolean paramBoolean)
  {
    this.m = false;
    this.n = 0;
    this.k = false;
    this.i = false;
    this.h = paramBoolean;
    SearchResultAdapter localSearchResultAdapter = this.f;
    if (localSearchResultAdapter != null) {
      localSearchResultAdapter.a();
    }
  }
  
  public void b()
  {
    this.j.postDelayed(new SearchResultPageView.1(this), 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.SearchResultPageView
 * JD-Core Version:    0.7.0.1
 */