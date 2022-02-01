package com.tencent.mobileqq.search;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.adapter.ContactsSearchResultAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HistorySearchEntryModel
  extends BaseSearchEntryModel<XListView>
  implements Handler.Callback
{
  protected XListView d;
  public List<IContactSearchable> e;
  protected MqqWeakReferenceHandler f;
  protected int g;
  protected ContactsSearchResultAdapter h;
  protected boolean i = false;
  protected HistorySearchEntryModel.OnHistorySearchCountListener j;
  private TextView k = null;
  private TextView l = null;
  private TextView m = null;
  private TextView n = null;
  private Context o;
  private QQAppInterface p;
  private AdapterView.OnItemClickListener q = new HistorySearchEntryModel.5(this);
  
  public HistorySearchEntryModel(int paramInt)
  {
    super(paramInt);
  }
  
  public HistorySearchEntryModel(int paramInt, HistorySearchEntryModel.OnHistorySearchCountListener paramOnHistorySearchCountListener)
  {
    super(paramInt);
    this.j = paramOnHistorySearchCountListener;
  }
  
  private int a(List<IContactSearchable> paramList, long paramLong)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return -1;
      }
      int i2 = paramList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        if (((SearchHistory)((IContactSearchable)this.e.get(i1)).l()).getId() == paramLong) {
          return i1;
        }
        i1 += 1;
      }
    }
    return -1;
  }
  
  private boolean a(SearchHistory paramSearchHistory)
  {
    SearchHistoryManager localSearchHistoryManager = (SearchHistoryManager)this.p.getManager(QQManagerFactory.SEARCHHISTORY_MANAGER);
    if ((localSearchHistoryManager != null) && (paramSearchHistory != null)) {
      return localSearchHistoryManager.c(paramSearchHistory);
    }
    return false;
  }
  
  private void e()
  {
    ThreadManager.postImmediately(new HistorySearchEntryModel.4(this), null, true);
  }
  
  private List<IContactSearchable> f()
  {
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Object localObject = (SearchHistoryManager)this.p.getManager(QQManagerFactory.SEARCHHISTORY_MANAGER);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((SearchHistoryManager)localObject).a().iterator();
    while (((Iterator)localObject).hasNext())
    {
      SearchHistory localSearchHistory = (SearchHistory)((Iterator)localObject).next();
      localArrayList.add(new ContactSearchableSearchHistory(this.p, localSearchHistory));
    }
    if (QLog.isColorLevel())
    {
      long l2 = System.currentTimeMillis();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initSearchHistoryData() time cost = ");
      ((StringBuilder)localObject).append(l2 - l1);
      ((StringBuilder)localObject).append(" , size = ");
      ((StringBuilder)localObject).append(localArrayList.size());
      QLog.d("searchUtils", 2, ((StringBuilder)localObject).toString());
    }
    return localArrayList;
  }
  
  public void a()
  {
    super.a();
    this.d.setAdapter(this.h);
    e();
  }
  
  public XListView b(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.p = paramQQAppInterface;
    this.o = paramContext;
    this.f = new MqqWeakReferenceHandler(this);
    this.d = ((XListView)LayoutInflater.from(this.o).inflate(2131629616, null));
    this.d.setVisibility(8);
    paramContext = new AbsListView.LayoutParams(-1, DisplayUtil.a(this.o, 7.0F));
    this.k = new TextView(this.o);
    this.k.setLayoutParams(paramContext);
    paramContext = (LinearLayout)LayoutInflater.from(this.o).inflate(2131629223, null);
    this.l = ((TextView)paramContext.findViewById(2131429708));
    this.m = ((TextView)paramContext.findViewById(2131429709));
    this.n = ((TextView)paramContext.findViewById(2131429710));
    this.d.addFooterView(paramContext);
    this.k.setBackgroundResource(2130852377);
    this.h = new ContactsSearchResultAdapter(paramQQAppInterface, this.o, this.d, null, new HistorySearchEntryModel.1(this), new HistorySearchEntryModel.2(this), false);
    this.d.setOnTouchListener(new HistorySearchEntryModel.3(this));
    return this.d;
  }
  
  public void b()
  {
    super.b();
    ContactsSearchResultAdapter localContactsSearchResultAdapter = this.h;
    if (localContactsSearchResultAdapter != null) {
      localContactsSearchResultAdapter.c();
    }
  }
  
  public void c()
  {
    e();
  }
  
  public void d()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      if (this.h == null) {
        return;
      }
      int i3 = View.MeasureSpec.makeMeasureSpec(((XListView)localObject).getWidth(), 0);
      localObject = null;
      int i2 = 0;
      int i1 = 0;
      while (i2 < this.h.getCount())
      {
        localObject = this.h.getView(i2, (View)localObject, this.d);
        if (i2 == 0) {
          ((View)localObject).setLayoutParams(new ViewGroup.LayoutParams(i3, -2));
        }
        ((View)localObject).measure(i3, 0);
        i1 += ((View)localObject).getMeasuredHeight();
        i2 += 1;
      }
      i2 = i1;
      if (this.h.getCount() > 0) {
        i2 = i1 + UIUtils.a(this.o, 20.0F);
      }
      localObject = this.d.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = (i2 + this.d.getDividerHeight() * (this.h.getCount() - 1));
      this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject;
    int i1;
    if (1 == paramMessage.what)
    {
      paramMessage = this.e;
      if ((paramMessage != null) && (paramMessage.size() > 0))
      {
        this.h.a();
        this.h.a(this.e);
        if (this.e.size() > 0)
        {
          if (!this.i)
          {
            this.i = true;
            paramMessage = new StringBuilder();
            paramMessage.append("");
            paramMessage.append(this.e.size());
            SearchUtils.a("home_page", "exp_history", new String[] { paramMessage.toString() });
            UniteSearchReportController.a(this.p, 0, SearchEntryFragment.b(this.a), "0X8009D18", 0, 0, null, null);
          }
          this.k.setVisibility(0);
          this.l.setVisibility(0);
        }
      }
      paramMessage = this.j;
      if (paramMessage != null)
      {
        localObject = this.e;
        if (localObject == null) {
          i1 = 0;
        } else {
          i1 = ((List)localObject).size();
        }
        paramMessage.a(i1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("searchUtils", 2, "load history data finish");
      }
      d();
      this.d.setVisibility(0);
      return true;
    }
    if (paramMessage.what == 3)
    {
      long l1 = ((Long)paramMessage.obj).longValue();
      i1 = a(this.e, l1);
      if (i1 != -1)
      {
        paramMessage = (SearchHistory)((IContactSearchable)this.e.remove(i1)).l();
        if (this.e.size() <= 0)
        {
          this.k.setVisibility(8);
          this.l.setVisibility(8);
          this.m.setVisibility(8);
          this.n.setVisibility(8);
        }
        if (paramMessage != null)
        {
          if (paramMessage.type == 0)
          {
            i1 = 1;
            break label371;
          }
          if ((paramMessage.type == 1) || (paramMessage.type == 3000))
          {
            i1 = 2;
            break label371;
          }
        }
        i1 = 0;
        label371:
        ReportController.b(null, "CliOper", "", "", "0X8007620", "0X8007620", 0, 0, "", "", "", "");
        this.h.a();
        this.h.a(this.e);
        UniteSearchReportController.a(this.p, 0, SearchEntryFragment.b(this.a), "0X8009D1A", i1, 0, null, null);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("delete history data finish : troopUin = ");
          ((StringBuilder)localObject).append(paramMessage.troopUin);
          ((StringBuilder)localObject).append("displayname = ");
          ((StringBuilder)localObject).append(paramMessage.displayName);
          QLog.d("searchUtils", 2, ((StringBuilder)localObject).toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("searchUtils", 2, "delete history data error");
      }
      d();
      this.d.setVisibility(0);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.HistorySearchEntryModel
 * JD-Core Version:    0.7.0.1
 */