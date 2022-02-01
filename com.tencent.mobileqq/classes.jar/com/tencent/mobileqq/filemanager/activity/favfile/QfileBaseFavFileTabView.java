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
  static String a;
  static String b;
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
  
  static
  {
    jdField_a_of_type_JavaLangString = "QfileBaseFavFileTabView<FileAssistant>";
    jdField_b_of_type_JavaLangString = "FavFileS ";
  }
  
  public QfileBaseFavFileTabView(Context paramContext, QfileFavFileRecordProvider paramQfileFavFileRecordProvider, QfileBaseFavFileTabView.ITabBarViewProxy paramITabBarViewProxy)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileBaseFavFileTabView$GetMoreRequest = new QfileBaseFavFileTabView.GetMoreRequest(this);
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView = ((QfilePinnedHeaderExpandableListView)findViewById(2131366941));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = new NoFileRelativeLayout(a());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.addHeaderView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
    p();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131692357);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter = a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setFocusable(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167305);
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
    QLog.i(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "startGetMoreFileRecord. targertCount:" + paramInt);
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
    int j = 0;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileBaseFavFileTabView$ITabBarViewProxy.setRefreshedFavList(true);
    if (getVisibility() != 0) {
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "onFileRecordsRefreshed suc:" + paramBoolean + ". recordType:" + b());
    List localList = a();
    if (this.jdField_a_of_type_Int != localList.size())
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "onFileRecordsRefreshed. updateTabView");
      if (this.jdField_a_of_type_Int != 0) {
        break label318;
      }
    }
    label311:
    label318:
    for (int i = 0;; i = -1)
    {
      c(i);
      Object localObject = "";
      if (paramBundle != null) {
        localObject = paramBundle.getString("delete_favids");
      }
      paramBundle = new ArrayList();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      for (;;)
      {
        try
        {
          localObject = ((String)localObject).split(",");
          int k = localObject.length;
          i = j;
          if (i < k)
          {
            CharSequence localCharSequence = localObject[i];
            if (TextUtils.isEmpty(localCharSequence)) {
              break label311;
            }
            paramBundle.add(Long.valueOf(Long.valueOf(localCharSequence).longValue()));
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        if (paramBundle.size() > 0)
        {
          paramBundle = paramBundle.iterator();
          while (paramBundle.hasNext()) {
            FMDataCache.b(((Long)paramBundle.next()).longValue());
          }
          w();
        }
        if ((localList.size() >= c()) || (b())) {
          break;
        }
        a(c() - localList.size());
        return;
        i += 1;
      }
    }
  }
  
  protected boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileBaseFavFileTabView$GetMoreRequest.jdField_a_of_type_Boolean;
  }
  
  public void aq_()
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
    d(2131560922);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(a());
    r();
    o();
    new Handler(Looper.getMainLooper()).post(new QfileBaseFavFileTabView.2(this));
  }
  
  protected void b(int paramInt)
  {
    int j = 0;
    int i = 0;
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileBaseFavFileTabView$GetMoreRequest.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        if (paramInt == 0) {
          break;
        }
        h();
      } while (getVisibility() != 0);
      localList = a();
    } while (this.jdField_a_of_type_Int == localList.size());
    QLog.d(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "onGettedFileRecords err. updateTabView");
    if (this.jdField_a_of_type_Int == 0) {}
    for (paramInt = i;; paramInt = -1)
    {
      c(paramInt);
      return;
    }
    List localList = a();
    QLog.i(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "onGettedFileRecords. gettedSize:" + localList.size() + " isEnd:" + b() + " curShowSize:" + this.jdField_a_of_type_Int + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileBaseFavFileTabView$GetMoreRequest.a());
    if ((b()) || (localList.size() - this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileBaseFavFileTabView$GetMoreRequest.jdField_a_of_type_Int >= this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileBaseFavFileTabView$GetMoreRequest.b))
    {
      h();
      label216:
      if ((getVisibility() != 0) || (((this.jdField_a_of_type_Int != 0) || (!b())) && (this.jdField_a_of_type_Int == localList.size()))) {
        break label373;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "onGettedFileRecords. updateTabView");
      if (this.jdField_a_of_type_Int != 0) {
        break label375;
      }
    }
    label373:
    label375:
    for (paramInt = j;; paramInt = -1)
    {
      c(paramInt);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileBaseFavFileTabView$GetMoreRequest.a())
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "onGettedFileRecords. continue get." + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileBaseFavFileTabView$GetMoreRequest.a());
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider.a();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileBaseFavFileTabView$GetMoreRequest.a(localList.size());
        break label216;
      }
      h();
      break label216;
      break;
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
    setSelect(0);
    QLog.i(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "-> initGetRecentFileRecords. curSize:" + localList.size() + " OnceShowSize:" + c() + " isEnd:" + b());
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
    if (this.jdField_a_of_type_Int != localList.size()) {
      if (this.jdField_a_of_type_Int != 0) {
        break label97;
      }
    }
    label97:
    for (int i = 0;; i = -1)
    {
      c(i);
      if ((!this.jdField_b_of_type_Boolean) || (localList.size() >= c()) || (b())) {
        break;
      }
      a(c() - localList.size());
      return;
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
    if ((this.jdField_a_of_type_JavaUtilLinkedHashMap == null) || (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() == 0)) {
      if (b())
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131692366);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible(true);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131692357);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible(true);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setGone();
    }
  }
  
  public void setSelect(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount() <= paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "setSelect[" + paramInt + "] faild,becouse GroupCount[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount() + "]");
      }
      return;
    }
    a(new QfileBaseFavFileTabView.5(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView
 * JD-Core Version:    0.7.0.1
 */