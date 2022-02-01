package com.tencent.mobileqq.filemanager.activity.cloudfile;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.TextView;
import atjm;
import atjy;
import atkb;
import atkc;
import atkf;
import atkg;
import atkk;
import atkl;
import atkm;
import atkn;
import atko;
import atkp;
import atpa;
import atqx;
import atup;
import atur;
import atyw;
import auht;
import auhy;
import aunh;
import aunj;
import bdll;
import bhlq;
import bhme;
import bhpc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.ViewerMoreRelativeLayout;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public abstract class QfileBaseCloudFileTabView
  extends QfileBaseTabView
{
  public static String b;
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = -1L;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  public View.OnClickListener a;
  public View.OnLongClickListener a;
  public TextView a;
  public atjm a;
  private atpa jdField_a_of_type_Atpa = new atkk(this);
  NoFileRelativeLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = null;
  public QfilePinnedHeaderExpandableListView a;
  public ViewerMoreRelativeLayout a;
  ScrollerRunnable jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
  public BubblePopupWindow a;
  public String a;
  public ArrayList<WeiYunFileInfo> a;
  protected LinkedHashMap<String, List<WeiYunFileInfo>> a;
  volatile boolean jdField_a_of_type_Boolean = false;
  public View.OnClickListener b;
  public boolean b;
  public View.OnClickListener c = new atkf(this);
  public View.OnClickListener d;
  
  static
  {
    jdField_b_of_type_JavaLangString = "QfileRecentFileActivity<FileAssistant>";
  }
  
  public QfileBaseCloudFileTabView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new atko(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new atkp(this);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new atkc(this);
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new atkg(this);
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView = ((QfilePinnedHeaderExpandableListView)findViewById(2131366625));
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelection(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setFocusable(false);
  }
  
  private void o()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = new NoFileRelativeLayout(a());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.addHeaderView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout = new ViewerMoreRelativeLayout(a());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.findViewById(2131381122));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.addFooterView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout);
      ax_();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131692087);
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
  
  protected abstract atjm a();
  
  public ListView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView;
  }
  
  protected ArrayList<WeiYunFileInfo> a(WeiYunFileInfo paramWeiYunFileInfo)
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
        QLog.i(jdField_b_of_type_JavaLangString, 1, "can not find the clicked weiYunFileInfo. targetInfo fileId[" + paramWeiYunFileInfo.jdField_a_of_type_JavaLangString + "]");
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
  
  protected abstract void a();
  
  public void a(WeiYunFileInfo paramWeiYunFileInfo, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    if ((g()) && (!paramBoolean)) {
      if (atyw.a(paramWeiYunFileInfo))
      {
        atyw.b(paramWeiYunFileInfo);
        w();
        aw_();
      }
    }
    for (;;)
    {
      b(g());
      do
      {
        return;
        atyw.a(paramWeiYunFileInfo);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h(true);
        if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.i()) || (atyw.a(atyw.b))) {
          break;
        }
        paramWeiYunFileInfo = bhlq.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131697485);
        paramWeiYunFileInfo.setPositiveButton(2131718838, new bhme());
        paramWeiYunFileInfo.show();
        atyw.b(atyw.b);
        aunh.a("0X800942F");
        break;
        if (c()) {
          break label149;
        }
      } while (!QLog.isColorLevel());
      QLog.i(jdField_b_of_type_JavaLangString, 2, "click too fast , wait a minute.");
      return;
      label149:
      u();
      aunh.a("0X8004AE6");
      auhy localauhy = new auhy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramWeiYunFileInfo);
      if (aunj.a(paramWeiYunFileInfo.c) == 0) {
        localauhy.a(a(paramWeiYunFileInfo));
      }
      paramWeiYunFileInfo = new auht(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, localauhy);
      paramWeiYunFileInfo.a(9);
      paramWeiYunFileInfo.a();
    }
  }
  
  protected abstract void a(boolean paramBoolean);
  
  public abstract boolean a();
  
  protected abstract boolean a(WeiYunFileInfo paramWeiYunFileInfo);
  
  public void aw_()
  {
    if (((this.jdField_a_of_type_JavaUtilLinkedHashMap == null) || (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() == 0)) && (a()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.j()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setTopViewHeight(0.5F);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131692096);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible(true);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
    }
    for (;;)
    {
      this.jdField_a_of_type_Atjm.notifyDataSetChanged();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setGone();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.removeHeaderView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
      }
    }
  }
  
  public void ax_()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getWindow().getDecorView().getHeight() / 2;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setLayoutParams(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getWidth(), i);
  }
  
  public void b()
  {
    d(2131560891);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(a());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Atpa);
    k();
    this.jdField_a_of_type_Atjm = a();
    this.jdField_a_of_type_Atjm.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView);
    o();
    if ((this.jdField_a_of_type_Atjm instanceof atjy))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167247);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_Atjm);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(true);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setGridSize(((atjy)this.jdField_a_of_type_Atjm).b());
      i = 0;
      while (i < this.jdField_a_of_type_Atjm.getGroupCount())
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.a(i);
        i += 1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnGroupExpandListener(new atkb(this));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnGroupCollapseListener(new atkl(this));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167247);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_Atjm);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(false);
    int i = 0;
    while (i < this.jdField_a_of_type_Atjm.getGroupCount())
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.a(i);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.smoothScrollToPosition(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setStackFromBottom(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
    if ((this.jdField_a_of_type_Atjm instanceof atjy))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getViewTreeObserver().addOnGlobalLayoutListener(new atkm(this));
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout == null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout = new ViewerMoreRelativeLayout(getContext());
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.findViewById(2131381122));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getViewTreeObserver().addOnGlobalLayoutListener(new atkn(this));
  }
  
  protected void b(boolean paramBoolean)
  {
    String str = "";
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.j()) && (!paramBoolean))
    {
      str = "0X8009E72";
      if ("document".equals(this.jdField_a_of_type_JavaLangString)) {
        str = "0X8009E6E";
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      }
      return;
      if ("picture".equals(this.jdField_a_of_type_JavaLangString))
      {
        str = "0X8009E6F";
      }
      else if ("video".equals(this.jdField_a_of_type_JavaLangString))
      {
        str = "0X8009E70";
      }
      else if ("music".equals(this.jdField_a_of_type_JavaLangString))
      {
        str = "0X8009E71";
        continue;
        if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.j())
        {
          str = "0X8009E65";
          if ("document".equals(this.jdField_a_of_type_JavaLangString)) {
            str = "0X8009E61";
          } else if ("picture".equals(this.jdField_a_of_type_JavaLangString)) {
            str = "0X8009E62";
          } else if ("video".equals(this.jdField_a_of_type_JavaLangString)) {
            str = "0X8009E63";
          } else if ("music".equals(this.jdField_a_of_type_JavaLangString)) {
            str = "0X8009E64";
          }
        }
      }
    }
  }
  
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.b();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    v();
    if (this.jdField_a_of_type_Atpa != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "onDestroy, del fmObserver");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Atpa);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
  }
  
  public void c(boolean paramBoolean) {}
  
  public void f()
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839410);
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
    a(new QfileBaseCloudFileTabView.14(this));
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() > 0) {
      aw_();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f());
  }
  
  public void setListFooter()
  {
    if ((this.jdField_a_of_type_Atjm instanceof atjy)) {}
    while ((this.jdField_a_of_type_Atjm.getGroupCount() <= 0) || (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.c(this.jdField_a_of_type_Atjm.getGroupCount() - 1)) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout == null)) {
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
    if (this.jdField_a_of_type_Atjm.getGroupCount() <= paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_b_of_type_JavaLangString, 1, "setSelect[" + paramInt + "] faild,becouse GroupCount[" + this.jdField_a_of_type_Atjm.getGroupCount() + "]");
      }
      return;
    }
    a(new QfileBaseCloudFileTabView.15(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView
 * JD-Core Version:    0.7.0.1
 */