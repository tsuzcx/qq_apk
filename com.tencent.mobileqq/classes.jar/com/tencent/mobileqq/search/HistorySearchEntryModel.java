package com.tencent.mobileqq.search;

import ahqw;
import ahqx;
import ahqz;
import ahra;
import ahrb;
import android.content.Context;
import android.graphics.Color;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.adapter.ContactsSearchResultAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
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
  extends BaseSearchEntryModel
  implements Handler.Callback
{
  private Context jdField_a_of_type_AndroidContentContext;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public ContactsSearchResultAdapter a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected HistorySearchEntryModel.OnHistorySearchCountListener a;
  public MqqWeakReferenceHandler a;
  private AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new ahrb(this);
  public XListView a;
  public List a;
  protected boolean a;
  public int b;
  private TextView b;
  private TextView c;
  private TextView d;
  
  public HistorySearchEntryModel(int paramInt)
  {
    super(paramInt);
  }
  
  public HistorySearchEntryModel(int paramInt, HistorySearchEntryModel.OnHistorySearchCountListener paramOnHistorySearchCountListener)
  {
    super(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqSearchHistorySearchEntryModel$OnHistorySearchCountListener = paramOnHistorySearchCountListener;
  }
  
  private int a(List paramList, long paramLong)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
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
    return -1;
  }
  
  private List a()
  {
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Object localObject = (SearchHistoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(54);
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
      QLog.d("searchUtils", 2, "initSearchHistoryData() time cost = " + (l2 - l1) + " , size = " + localArrayList.size());
    }
    return localArrayList;
  }
  
  private boolean a(SearchHistory paramSearchHistory)
  {
    SearchHistoryManager localSearchHistoryManager = (SearchHistoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(54);
    if ((localSearchHistoryManager == null) || (paramSearchHistory == null)) {
      return false;
    }
    return localSearchHistoryManager.a(paramSearchHistory);
  }
  
  private void e()
  {
    ThreadManager.postImmediately(new ahra(this), null, true);
  }
  
  public XListView a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130971699, null));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    paramContext = new AbsListView.LayoutParams(-1, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 7.0F));
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramContext);
    paramContext = (LinearLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130971523, null);
    this.b = ((TextView)paramContext.findViewById(2131375011));
    this.c = ((TextView)paramContext.findViewById(2131375012));
    this.d = ((TextView)paramContext.findViewById(2131375013));
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(paramContext);
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838580);
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundColor(Color.parseColor("#0b1d35"));
      this.b.setBackgroundColor(Color.parseColor("#0b1d35"));
      this.c.setBackgroundColor(Color.parseColor("#040E1C"));
      this.d.setBackgroundColor(Color.parseColor("#0b1d35"));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter = new ContactsSearchResultAdapter(paramQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentWidgetXListView, null, new ahqw(this), new ahqx(this), false);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new ahqz(this));
      return this.jdField_a_of_type_ComTencentWidgetXListView;
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundColor(Color.parseColor("#ffffff"));
      this.b.setBackgroundColor(Color.parseColor("#ffffff"));
      this.c.setBackgroundColor(Color.parseColor("#F7F7F8"));
      this.d.setBackgroundColor(Color.parseColor("#ffffff"));
      this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838579);
    }
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
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.c();
    }
  }
  
  public void c()
  {
    e();
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView == null) || (this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter == null)) {
      return;
    }
    int k = View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_ComTencentWidgetXListView.getWidth(), 0);
    Object localObject = null;
    int i = 0;
    int j = 0;
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
      j = i + UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 28.0F);
    }
    localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = (this.jdField_a_of_type_ComTencentWidgetXListView.getDividerHeight() * (this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.getCount() - 1) + j);
    this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (1 == paramMessage.what)
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.a();
        this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.a(this.jdField_a_of_type_JavaUtilList);
        if (this.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          if (!this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Boolean = true;
            SearchUtils.a("home_page", "exp_history", new String[] { "" + this.jdField_a_of_type_JavaUtilList.size() });
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.b.setVisibility(0);
          this.c.setVisibility(0);
          this.d.setVisibility(0);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSearchHistorySearchEntryModel$OnHistorySearchCountListener != null)
      {
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqSearchHistorySearchEntryModel$OnHistorySearchCountListener;
        if (this.jdField_a_of_type_JavaUtilList == null)
        {
          i = 0;
          paramMessage.a(i);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("searchUtils", 2, "load history data finish");
        }
        d();
        this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      }
    }
    while (paramMessage.what != 3) {
      for (;;)
      {
        return true;
        i = this.jdField_a_of_type_JavaUtilList.size();
      }
    }
    long l = ((Long)paramMessage.obj).longValue();
    int i = a(this.jdField_a_of_type_JavaUtilList, l);
    if (i != -1)
    {
      paramMessage = (SearchHistory)((IContactSearchable)this.jdField_a_of_type_JavaUtilList.remove(i)).a();
      if (this.jdField_a_of_type_JavaUtilList.size() <= 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        this.d.setVisibility(8);
      }
      ReportController.b(null, "CliOper", "", "", "0X8007620", "0X8007620", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.a(this.jdField_a_of_type_JavaUtilList);
      if (QLog.isColorLevel()) {
        QLog.d("searchUtils", 2, "delete history data finish : troopUin = " + paramMessage.troopUin + "displayname = " + paramMessage.displayName);
      }
    }
    for (;;)
    {
      d();
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      break;
      if (QLog.isColorLevel()) {
        QLog.d("searchUtils", 2, "delete history data error");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.HistorySearchEntryModel
 * JD-Core Version:    0.7.0.1
 */