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
  private Context jdField_a_of_type_AndroidContentContext;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  protected ContactsSearchResultAdapter a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected HistorySearchEntryModel.OnHistorySearchCountListener a;
  protected MqqWeakReferenceHandler a;
  private AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new HistorySearchEntryModel.5(this);
  protected XListView a;
  public List<IContactSearchable> a;
  protected int b;
  private TextView b;
  protected boolean b;
  private TextView c = null;
  private TextView d = null;
  
  public HistorySearchEntryModel(int paramInt)
  {
    super(paramInt);
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public HistorySearchEntryModel(int paramInt, HistorySearchEntryModel.OnHistorySearchCountListener paramOnHistorySearchCountListener)
  {
    super(paramInt);
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqSearchHistorySearchEntryModel$OnHistorySearchCountListener = paramOnHistorySearchCountListener;
  }
  
  private int a(List<IContactSearchable> paramList, long paramLong)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return -1;
      }
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        if (((SearchHistory)((IContactSearchable)this.jdField_a_of_type_JavaUtilList.get(i)).a()).getId() == paramLong) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  private List<IContactSearchable> a()
  {
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Object localObject = (SearchHistoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SEARCHHISTORY_MANAGER);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((SearchHistoryManager)localObject).a().iterator();
    while (((Iterator)localObject).hasNext())
    {
      SearchHistory localSearchHistory = (SearchHistory)((Iterator)localObject).next();
      localArrayList.add(new ContactSearchableSearchHistory(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSearchHistory));
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
  
  private boolean a(SearchHistory paramSearchHistory)
  {
    SearchHistoryManager localSearchHistoryManager = (SearchHistoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SEARCHHISTORY_MANAGER);
    if ((localSearchHistoryManager != null) && (paramSearchHistory != null)) {
      return localSearchHistoryManager.b(paramSearchHistory);
    }
    return false;
  }
  
  private void e()
  {
    ThreadManager.postImmediately(new HistorySearchEntryModel.4(this), null, true);
  }
  
  public XListView a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131563008, null));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    paramContext = new AbsListView.LayoutParams(-1, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 7.0F));
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramContext);
    paramContext = (LinearLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562778, null);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131363776));
    this.c = ((TextView)paramContext.findViewById(2131363777));
    this.d = ((TextView)paramContext.findViewById(2131363778));
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130850581);
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter = new ContactsSearchResultAdapter(paramQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentWidgetXListView, null, new HistorySearchEntryModel.1(this), new HistorySearchEntryModel.2(this), false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new HistorySearchEntryModel.3(this));
    return this.jdField_a_of_type_ComTencentWidgetXListView;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter);
    e();
  }
  
  public void b()
  {
    super.b();
    ContactsSearchResultAdapter localContactsSearchResultAdapter = this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter;
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
    Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView;
    if (localObject != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter == null) {
        return;
      }
      int k = View.MeasureSpec.makeMeasureSpec(((XListView)localObject).getWidth(), 0);
      localObject = null;
      int j = 0;
      int i = 0;
      while (j < this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.getCount())
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.getView(j, (View)localObject, this.jdField_a_of_type_ComTencentWidgetXListView);
        if (j == 0) {
          ((View)localObject).setLayoutParams(new ViewGroup.LayoutParams(k, -2));
        }
        ((View)localObject).measure(k, 0);
        i += ((View)localObject).getMeasuredHeight();
        j += 1;
      }
      j = i;
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.getCount() > 0) {
        j = i + UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
      }
      localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = (j + this.jdField_a_of_type_ComTencentWidgetXListView.getDividerHeight() * (this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.getCount() - 1));
      this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject;
    int i;
    if (1 == paramMessage.what)
    {
      paramMessage = this.jdField_a_of_type_JavaUtilList;
      if ((paramMessage != null) && (paramMessage.size() > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.a();
        this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.a(this.jdField_a_of_type_JavaUtilList);
        if (this.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          if (!this.jdField_b_of_type_Boolean)
          {
            this.jdField_b_of_type_Boolean = true;
            paramMessage = new StringBuilder();
            paramMessage.append("");
            paramMessage.append(this.jdField_a_of_type_JavaUtilList.size());
            SearchUtils.a("home_page", "exp_history", new String[] { paramMessage.toString() });
            UniteSearchReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, SearchEntryFragment.a(this.jdField_a_of_type_Int), "0X8009D18", 0, 0, null, null);
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        }
      }
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqSearchHistorySearchEntryModel$OnHistorySearchCountListener;
      if (paramMessage != null)
      {
        localObject = this.jdField_a_of_type_JavaUtilList;
        if (localObject == null) {
          i = 0;
        } else {
          i = ((List)localObject).size();
        }
        paramMessage.a(i);
      }
      if (QLog.isColorLevel()) {
        QLog.d("searchUtils", 2, "load history data finish");
      }
      d();
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      return true;
    }
    if (paramMessage.what == 3)
    {
      long l = ((Long)paramMessage.obj).longValue();
      i = a(this.jdField_a_of_type_JavaUtilList, l);
      if (i != -1)
      {
        paramMessage = (SearchHistory)((IContactSearchable)this.jdField_a_of_type_JavaUtilList.remove(i)).a();
        if (this.jdField_a_of_type_JavaUtilList.size() <= 0)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          this.c.setVisibility(8);
          this.d.setVisibility(8);
        }
        if (paramMessage != null)
        {
          if (paramMessage.type == 0)
          {
            i = 1;
            break label371;
          }
          if ((paramMessage.type == 1) || (paramMessage.type == 3000))
          {
            i = 2;
            break label371;
          }
        }
        i = 0;
        label371:
        ReportController.b(null, "CliOper", "", "", "0X8007620", "0X8007620", 0, 0, "", "", "", "");
        this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.a();
        this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.a(this.jdField_a_of_type_JavaUtilList);
        UniteSearchReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, SearchEntryFragment.a(this.jdField_a_of_type_Int), "0X8009D1A", i, 0, null, null);
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
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.HistorySearchEntryModel
 * JD-Core Version:    0.7.0.1
 */