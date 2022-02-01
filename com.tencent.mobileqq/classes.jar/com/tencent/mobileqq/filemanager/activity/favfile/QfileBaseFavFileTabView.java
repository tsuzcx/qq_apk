package com.tencent.mobileqq.filemanager.activity.favfile;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public abstract class QfileBaseFavFileTabView
  extends QfileBaseTabView
{
  static String a = "QfileBaseFavFileTabView<FileAssistant>";
  static String b = "FavFileS ";
  protected int a;
  protected LayoutInflater a;
  protected QfileBaseExpandableListAdapter a;
  protected QfileBaseFavFileTabView.GetMoreRequest a;
  protected QfileBaseFavFileTabView.ITabBarViewProxy a;
  protected QfileFavFileRecordProvider.EventObserver a;
  protected QfileFavFileRecordProvider a;
  protected NoFileRelativeLayout a;
  protected QfilePinnedHeaderExpandableListView a;
  protected LinkedHashMap<String, List<FavFileInfo>> a;
  protected volatile boolean a;
  protected volatile boolean b;
  
  public QfileBaseFavFileTabView(Context paramContext, QfileFavFileRecordProvider paramQfileFavFileRecordProvider, QfileBaseFavFileTabView.ITabBarViewProxy paramITabBarViewProxy)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileBaseFavFileTabView$GetMoreRequest = new QfileBaseFavFileTabView.GetMoreRequest();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider$EventObserver = new QfileBaseFavFileTabView.1(this);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider = paramQfileFavFileRecordProvider;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider.addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider$EventObserver);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileBaseFavFileTabView$ITabBarViewProxy = paramITabBarViewProxy;
  }
  
  private void r()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView = ((QfilePinnedHeaderExpandableListView)findViewById(2131366803));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = new NoFileRelativeLayout(a());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.addHeaderView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
    p();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131692286);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter = a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setFocusable(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167333);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount())
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.expandGroup(i);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.smoothScrollToPosition(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setStackFromBottom(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getViewTreeObserver().addOnGlobalLayoutListener(new QfileBaseFavFileTabView.3(this));
  }
  
  public int a()
  {
    return 0;
  }
  
  protected abstract QfileBaseExpandableListAdapter a();
  
  public ListView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView;
  }
  
  protected abstract String a(FavFileInfo paramFavFileInfo);
  
  protected List<FavFileInfo> a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider.a(b());
  }
  
  protected void a() {}
  
  void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileBaseFavFileTabView$GetMoreRequest.jdField_a_of_type_Boolean) {
      return;
    }
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_b_of_type_JavaLangString);
    localStringBuilder.append("startGetMoreFileRecord. targertCount:");
    localStringBuilder.append(paramInt);
    QLog.i(str, 1, localStringBuilder.toString());
    a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileBaseFavFileTabView$GetMoreRequest.a(this.jdField_a_of_type_Int, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider.a();
  }
  
  protected void a(Bundle paramBundle)
  {
    if (getVisibility() != 0) {
      return;
    }
    i();
  }
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileBaseFavFileTabView$ITabBarViewProxy.setRefreshedFavList(true);
    if (getVisibility() != 0) {
      return;
    }
    Object localObject1 = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject2).append("onFileRecordsRefreshed suc:");
    ((StringBuilder)localObject2).append(paramBoolean);
    ((StringBuilder)localObject2).append(". recordType:");
    ((StringBuilder)localObject2).append(b());
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    localObject1 = a();
    int i = this.jdField_a_of_type_Int;
    int k = ((List)localObject1).size();
    int j = 0;
    StringBuilder localStringBuilder;
    if (i != k)
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_b_of_type_JavaLangString);
      localStringBuilder.append("onFileRecordsRefreshed. updateTabView");
      QLog.d((String)localObject2, 1, localStringBuilder.toString());
      if (this.jdField_a_of_type_Int == 0) {
        i = 0;
      } else {
        i = -1;
      }
      c(i);
    }
    if (paramBundle != null) {
      paramBundle = paramBundle.getString("delete_favids");
    } else {
      paramBundle = "";
    }
    localObject2 = new ArrayList();
    if (!TextUtils.isEmpty(paramBundle))
    {
      try
      {
        paramBundle = paramBundle.split(",");
        k = paramBundle.length;
        i = j;
        while (i < k)
        {
          localStringBuilder = paramBundle[i];
          if (!TextUtils.isEmpty(localStringBuilder)) {
            ((ArrayList)localObject2).add(Long.valueOf(Long.valueOf(localStringBuilder).longValue()));
          }
          i += 1;
        }
        if (((ArrayList)localObject2).size() <= 0) {
          break label323;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
    else
    {
      paramBundle = ((ArrayList)localObject2).iterator();
      while (paramBundle.hasNext()) {
        FMDataCache.b(((Long)paramBundle.next()).longValue());
      }
      w();
    }
    label323:
    if ((((List)localObject1).size() < c()) && (!b())) {
      a(c() - ((List)localObject1).size());
    }
  }
  
  protected boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileBaseFavFileTabView$GetMoreRequest.jdField_a_of_type_Boolean;
  }
  
  public void ak_()
  {
    List localList = a();
    if ((localList != null) && (localList.size() > 0))
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        FavFileInfo localFavFileInfo = (FavFileInfo)localIterator.next();
        String str = a(localFavFileInfo);
        if (!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(str)) {
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(str, new ArrayList());
        }
        ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str)).add(localFavFileInfo);
      }
      this.jdField_a_of_type_Int = localList.size();
      i();
      return;
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    i();
  }
  
  protected abstract int b();
  
  public void b()
  {
    d(2131560796);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(a());
    r();
    o();
    new Handler(Looper.getMainLooper()).post(new QfileBaseFavFileTabView.2(this));
  }
  
  protected void b(int paramInt)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileBaseFavFileTabView$GetMoreRequest.jdField_a_of_type_Boolean) {
      return;
    }
    int j = 0;
    int i = 0;
    if (paramInt != 0)
    {
      h();
      if (getVisibility() == 0)
      {
        localObject1 = a();
        if (this.jdField_a_of_type_Int != ((List)localObject1).size())
        {
          localObject1 = jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(jdField_b_of_type_JavaLangString);
          ((StringBuilder)localObject2).append("onGettedFileRecords err. updateTabView");
          QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
          if (this.jdField_a_of_type_Int == 0) {
            paramInt = i;
          } else {
            paramInt = -1;
          }
          c(paramInt);
        }
      }
      return;
    }
    Object localObject1 = a();
    Object localObject2 = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_b_of_type_JavaLangString);
    localStringBuilder.append("onGettedFileRecords. gettedSize:");
    localStringBuilder.append(((List)localObject1).size());
    localStringBuilder.append(" isEnd:");
    localStringBuilder.append(b());
    localStringBuilder.append(" curShowSize:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileBaseFavFileTabView$GetMoreRequest.a());
    QLog.i((String)localObject2, 1, localStringBuilder.toString());
    if ((!b()) && (((List)localObject1).size() - this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileBaseFavFileTabView$GetMoreRequest.jdField_a_of_type_Int < this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileBaseFavFileTabView$GetMoreRequest.b))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileBaseFavFileTabView$GetMoreRequest.a())
      {
        localObject2 = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(jdField_b_of_type_JavaLangString);
        localStringBuilder.append("onGettedFileRecords. continue get.");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileBaseFavFileTabView$GetMoreRequest.a());
        QLog.i((String)localObject2, 1, localStringBuilder.toString());
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider.a();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileBaseFavFileTabView$GetMoreRequest.a(((List)localObject1).size());
      }
      else
      {
        h();
      }
    }
    else {
      h();
    }
    if ((getVisibility() == 0) && (((this.jdField_a_of_type_Int == 0) && (b())) || (this.jdField_a_of_type_Int != ((List)localObject1).size())))
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("onGettedFileRecords. updateTabView");
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      if (this.jdField_a_of_type_Int == 0) {
        paramInt = j;
      } else {
        paramInt = -1;
      }
      c(paramInt);
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider.a();
  }
  
  protected abstract int c();
  
  public void c()
  {
    super.c();
    m();
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider.deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider$EventObserver);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider = null;
    h();
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected void c(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    List localList = a();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      FavFileInfo localFavFileInfo = (FavFileInfo)localIterator.next();
      String str = a(localFavFileInfo);
      if (!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(str)) {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(str, new ArrayList());
      }
      ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str)).add(localFavFileInfo);
    }
    this.jdField_a_of_type_Int = localList.size();
    i();
    if (paramInt >= 0) {
      setSelect(paramInt);
    }
  }
  
  protected void f() {}
  
  protected void g()
  {
    a(c());
  }
  
  protected void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileBaseFavFileTabView$GetMoreRequest.a();
    f();
  }
  
  public void i()
  {
    a(new QfileBaseFavFileTabView.4(this));
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f());
    setEditbarButton(false, true, false, true, true);
  }
  
  protected void k()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    List localList = a();
    Object localObject1 = localList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FavFileInfo)((Iterator)localObject1).next();
      String str = a((FavFileInfo)localObject2);
      if (!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(str)) {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(str, new ArrayList());
      }
      ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str)).add(localObject2);
    }
    this.jdField_a_of_type_Int = localList.size();
    i();
    setSelect(0);
    localObject1 = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject2).append("-> initGetRecentFileRecords. curSize:");
    ((StringBuilder)localObject2).append(localList.size());
    ((StringBuilder)localObject2).append(" OnceShowSize:");
    ((StringBuilder)localObject2).append(c());
    ((StringBuilder)localObject2).append(" isEnd:");
    ((StringBuilder)localObject2).append(b());
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileBaseFavFileTabView$ITabBarViewProxy.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider.a(null);
      return;
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void m()
  {
    super.m();
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f());
    List localList = a();
    if (this.jdField_a_of_type_Int != localList.size())
    {
      int i;
      if (this.jdField_a_of_type_Int == 0) {
        i = 0;
      } else {
        i = -1;
      }
      c(i);
    }
    if ((this.jdField_b_of_type_Boolean) && (localList.size() < c()) && (!b())) {
      a(c() - localList.size());
    }
  }
  
  protected void o()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(false);
  }
  
  protected void p()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getWindow().getDecorView().getHeight() / 2;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setLayoutParams(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getWidth(), i);
  }
  
  protected void q()
  {
    LinkedHashMap localLinkedHashMap = this.jdField_a_of_type_JavaUtilLinkedHashMap;
    if ((localLinkedHashMap != null) && (localLinkedHashMap.size() != 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setGone();
    }
    else if (b())
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131692294);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible(true);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131692286);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.notifyDataSetChanged();
  }
  
  public void setSelect(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount() <= paramInt)
    {
      if (QLog.isColorLevel())
      {
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setSelect[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("] faild,becouse GroupCount[");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount());
        localStringBuilder.append("]");
        QLog.e(str, 1, localStringBuilder.toString());
      }
      return;
    }
    a(new QfileBaseFavFileTabView.5(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView
 * JD-Core Version:    0.7.0.1
 */