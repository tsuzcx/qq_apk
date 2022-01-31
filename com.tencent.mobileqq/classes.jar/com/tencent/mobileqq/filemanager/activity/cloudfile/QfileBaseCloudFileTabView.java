package com.tencent.mobileqq.filemanager.activity.cloudfile;

import acpg;
import acph;
import acpk;
import acpl;
import acpp;
import acpt;
import acpu;
import acpv;
import acpw;
import acpx;
import acpy;
import acpz;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileWeiYunImageExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.ViewerMoreRelativeLayout;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public abstract class QfileBaseCloudFileTabView
  extends QfileBaseTabView
{
  public static String a;
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = -1L;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  public View.OnClickListener a;
  public View.OnLongClickListener a;
  public TextView a;
  public QfileBaseExpandableListAdapter a;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new acpp(this);
  NoFileRelativeLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = null;
  public QfilePinnedHeaderExpandableListView a;
  public ViewerMoreRelativeLayout a;
  ScrollerRunnable jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
  public BubblePopupWindow a;
  public ArrayList a;
  public LinkedHashMap a;
  volatile boolean jdField_a_of_type_Boolean = false;
  public View.OnClickListener b;
  public boolean b;
  public View.OnClickListener c = new acpk(this);
  public View.OnClickListener d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "QfileRecentFileActivity<FileAssistant>";
  }
  
  public QfileBaseCloudFileTabView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new acpy(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new acpz(this);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new acph(this);
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new acpl(this);
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private ArrayList a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    int j = 0;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 250) {
      return this.jdField_a_of_type_JavaUtilArrayList;
    }
    int k = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramWeiYunFileInfo);
    int i = k;
    if (k == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "can not find the clicked weiYunFileInfo. targetInfo fileId[" + paramWeiYunFileInfo.jdField_a_of_type_JavaLangString + "]");
      }
      i = 0;
    }
    if (i < 100)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() - 1 >= i + 100) {
        break label138;
      }
      i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
    }
    for (;;)
    {
      return new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.subList(j, i));
      j = i - 100;
      break;
      label138:
      i += 100;
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView = ((QfilePinnedHeaderExpandableListView)findViewById(2131368810));
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelection(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setFocusable(false);
  }
  
  private void l()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = new NoFileRelativeLayout(a());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.addHeaderView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout = new ViewerMoreRelativeLayout(a());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.findViewById(2131364304));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.addFooterView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout);
      e();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131428142);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.getHeight();
  }
  
  protected abstract QfileBaseExpandableListAdapter a();
  
  protected abstract void a();
  
  public void a(WeiYunFileInfo paramWeiYunFileInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    if (f()) {
      if (FMDataCache.a(paramWeiYunFileInfo))
      {
        FMDataCache.b(paramWeiYunFileInfo);
        v();
        d();
      }
    }
    do
    {
      return;
      FMDataCache.a(paramWeiYunFileInfo);
      break;
      if (b()) {
        break label68;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "click too fast , wait a minute.");
    return;
    label68:
    t();
    FileManagerReporter.a("0X8004AE6");
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramWeiYunFileInfo.jdField_a_of_type_JavaLangString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramWeiYunFileInfo.jdField_a_of_type_JavaLangString);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = FileManagerUtil.a(paramWeiYunFileInfo);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "open a weiyun file with filebrowser, fileSessionId[" + ((FileManagerEntity)localObject1).nSessionId + "] fileName[" + paramWeiYunFileInfo.c + "]fileId[" + paramWeiYunFileInfo.jdField_a_of_type_JavaLangString + "]");
    }
    localObject2 = new ForwardFileInfo();
    ((ForwardFileInfo)localObject2).d(2);
    ((ForwardFileInfo)localObject2).b(10003);
    ((ForwardFileInfo)localObject2).b(((FileManagerEntity)localObject1).nSessionId);
    ((ForwardFileInfo)localObject2).d(paramWeiYunFileInfo.c);
    ((ForwardFileInfo)localObject2).c(paramWeiYunFileInfo.jdField_a_of_type_JavaLangString);
    ((ForwardFileInfo)localObject2).c(paramWeiYunFileInfo.jdField_a_of_type_Int);
    ((ForwardFileInfo)localObject2).d(paramWeiYunFileInfo.jdField_a_of_type_Long);
    localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity, FileBrowserActivity.class);
    ((Intent)localObject1).putExtra("fileinfo", (Parcelable)localObject2);
    if (FileManagerUtil.a(((ForwardFileInfo)localObject2).d()) == 0) {
      ((Intent)localObject1).putParcelableArrayListExtra("local_weiyun_list", a(paramWeiYunFileInfo));
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.startActivityForResult((Intent)localObject1, 102);
  }
  
  protected abstract void a(boolean paramBoolean);
  
  public abstract boolean a();
  
  protected abstract boolean a(WeiYunFileInfo paramWeiYunFileInfo);
  
  public void b()
  {
    a(2130970025);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(a());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter = a();
    k();
    l();
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter instanceof QfileWeiYunImageExpandableListAdapter))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131492924);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setGroupIndicator(a().getResources().getDrawable(2130838660));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(true);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setGridSize(((QfileWeiYunImageExpandableListAdapter)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter).b());
      i = 0;
      while (i < this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount())
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.a(i);
        i += 1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnGroupExpandListener(new acpg(this));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnGroupCollapseListener(new acpv(this));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131492924);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setGroupIndicator(a().getResources().getDrawable(2130838660));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(false);
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount())
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.a(i);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.smoothScrollToPosition(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setStackFromBottom(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter instanceof QfileWeiYunImageExpandableListAdapter))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getViewTreeObserver().addOnGlobalLayoutListener(new acpw(this));
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout == null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout = new ViewerMoreRelativeLayout(getContext());
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.findViewById(2131364304));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getViewTreeObserver().addOnGlobalLayoutListener(new acpx(this));
  }
  
  public void b(boolean paramBoolean) {}
  
  public boolean b(WeiYunFileInfo paramWeiYunFileInfo)
  {
    if (paramWeiYunFileInfo == null) {
      return false;
    }
    return a(paramWeiYunFileInfo);
  }
  
  public void c()
  {
    super.c();
    m();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    u();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onDestroy, del fmObserver");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
  }
  
  public void d()
  {
    if (((this.jdField_a_of_type_JavaUtilLinkedHashMap == null) || (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() == 0)) && (a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131428141);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.notifyDataSetChanged();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setGone();
      }
    }
  }
  
  public void e()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.getWindow().getDecorView().getHeight() / 2;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setLayoutParams(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getWidth(), i);
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838596);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
  }
  
  public void g()
  {
    this.jdField_b_of_type_Boolean = false;
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    }
  }
  
  public void h() {}
  
  public void i()
  {
    a(new acpt(this));
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() > 0) {
      d();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.f());
  }
  
  public void setListFooter()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter instanceof QfileWeiYunImageExpandableListAdapter)) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount() <= 0) || (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount() - 1)) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout == null)) {
      return;
    }
    if (!a())
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setVisible();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
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
    a(new acpu(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView
 * JD-Core Version:    0.7.0.1
 */