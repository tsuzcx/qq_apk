package com.tencent.mobileqq.filemanager.widget;

import aczf;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView;
import com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelAppTabView;
import com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelMediaTabView;
import com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelPicTabView;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileDocTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileOtherTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentAllFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentAppFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentDocFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentMediaFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentPicFileTabView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class QfileTabBarView
  extends RelativeLayout
  implements View.OnClickListener
{
  public int a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public BaseFileAssistantActivity a;
  QfileBaseTabView jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView = null;
  private TabBarView.OnTabChangeListener jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener = new aczf(this);
  public TabBarView a;
  String jdField_a_of_type_JavaLangString;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public boolean a;
  private int jdField_b_of_type_Int;
  HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  public HashMap c = new LinkedHashMap();
  
  public QfileTabBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QfileTabBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = null;
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130970014, this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = ((BaseFileAssistantActivity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131364569));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131368749));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener);
  }
  
  public QfileBaseTabView a(int paramInt)
  {
    for (;;)
    {
      try
      {
        QfileBaseTabView localQfileBaseTabView = (QfileBaseTabView)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
        if (localQfileBaseTabView != null) {
          return localQfileBaseTabView;
        }
        QLog.e("QfileTabBarView<FileAssistant>", 1, "tabPos[" + paramInt + "]");
      }
      catch (Exception localException1)
      {
        try
        {
          i = ((Integer)this.c.get(Integer.valueOf(paramInt))).intValue();
          if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString.trim().length() == 0)) {
            break label315;
          }
          j = 1;
          switch (i)
          {
          default: 
            localQfileBaseTabView.setFocusable(false);
            this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localQfileBaseTabView);
            return localQfileBaseTabView;
          }
        }
        catch (Exception localException2)
        {
          int i;
          int j;
          Object localObject;
          break label280;
        }
        localException1 = localException1;
        localObject = null;
      }
      label280:
      i = 3;
      continue;
      label315:
      j = 0;
      continue;
      if (j != 0) {}
      for (localObject = new QfileRecentAllFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, this.jdField_a_of_type_JavaLangString);; localObject = new QfileRecentAllFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity))
      {
        ((QfileBaseTabView)localObject).b();
        break;
      }
      if (j != 0) {}
      for (localObject = new QfileRecentDocFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, this.jdField_a_of_type_JavaLangString);; localObject = new QfileRecentDocFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity))
      {
        ((QfileBaseTabView)localObject).b();
        break;
      }
      if (j != 0) {}
      for (localObject = new QfileRecentPicFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, this.jdField_a_of_type_JavaLangString);; localObject = new QfileRecentPicFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity))
      {
        ((QfileBaseTabView)localObject).b();
        break;
      }
      if (j != 0) {}
      for (localObject = new QfileRecentMediaFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, this.jdField_a_of_type_JavaLangString);; localObject = new QfileRecentMediaFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity))
      {
        ((QfileBaseTabView)localObject).b();
        break;
      }
      if (j != 0) {}
      for (localObject = new QfileRecentAppFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, this.jdField_a_of_type_JavaLangString);; localObject = new QfileRecentAppFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity))
      {
        ((QfileBaseTabView)localObject).b();
        break;
      }
      localObject = new QfileLocalFileAppTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
      ((QfileBaseTabView)localObject).b();
      continue;
      localObject = new QfileLocalFileDelAppTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
      ((QfileBaseTabView)localObject).b();
      continue;
      localObject = new QfileLocalFilePicTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
      ((QfileBaseTabView)localObject).b();
      continue;
      localObject = new QfileLocalFileDelPicTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
      ((QfileBaseTabView)localObject).b();
      continue;
      localObject = new QfileLocalFileDocTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
      ((QfileBaseTabView)localObject).b();
      continue;
      localObject = new QfileLocalFileMediaTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 3);
      ((QfileBaseTabView)localObject).b();
      continue;
      localObject = new QfileLocalFileDelMediaTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 3);
      ((QfileBaseTabView)localObject).b();
      continue;
      localObject = new QfileLocalFileMediaTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 1);
      ((QfileBaseTabView)localObject).b();
      continue;
      localObject = new QfileLocalFileMediaTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2);
      ((QfileBaseTabView)localObject).b();
      continue;
      localObject = new QfileLocalFileOtherTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
      ((QfileBaseTabView)localObject).b();
      continue;
      localObject = new QfileCloudFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, "document", this.jdField_b_of_type_Int);
      ((QfileBaseTabView)localObject).b();
      continue;
      localObject = new QfileCloudFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, "picture", this.jdField_b_of_type_Int);
      ((QfileBaseTabView)localObject).b();
      continue;
      localObject = new QfileCloudFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, "video", this.jdField_b_of_type_Int);
      ((QfileBaseTabView)localObject).b();
      continue;
      localObject = new QfileCloudFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, "music", this.jdField_b_of_type_Int);
      ((QfileBaseTabView)localObject).b();
      continue;
      localObject = new QfileCloudFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, "other", this.jdField_b_of_type_Int);
      ((QfileBaseTabView)localObject).b();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.i();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(this.jdField_a_of_type_Int, paramString);
    this.c.put(Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramInt));
    this.jdField_a_of_type_Int += 1;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.a(paramArrayList);
  }
  
  boolean a()
  {
    return true;
  }
  
  public void b()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.getChildCount();
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0);
      i += 1;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      i = ((Integer)localIterator.next()).intValue();
      QfileBaseTabView localQfileBaseTabView = (QfileBaseTabView)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
      if (localQfileBaseTabView != null) {
        localQfileBaseTabView.c();
      }
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelected(false);
    this.c.clear();
    this.jdField_b_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView);
  }
  
  public void b(int paramInt)
  {
    QfileBaseTabView localQfileBaseTabView = a(paramInt);
    if (localQfileBaseTabView == null) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView == localQfileBaseTabView);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView != null)
      {
        if (a()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.q();
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.m();
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView = localQfileBaseTabView;
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView == null);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.j();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.setExpandGroup(true);
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.n();
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView, -1, -1);
  }
  
  public void b(ArrayList paramArrayList)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      ((QfileBaseTabView)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(i))).c(paramArrayList);
    }
  }
  
  public void c(ArrayList paramArrayList)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      ((QfileBaseTabView)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(i))).d(paramArrayList);
    }
  }
  
  public void d(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.b(paramArrayList);
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
  }
  
  public void setMemory(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setSelectedTab(int paramInt)
  {
    Iterator localIterator = this.c.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      int j = ((Integer)localIterator.next()).intValue();
      if (((Integer)this.c.get(Integer.valueOf(j))).intValue() != paramInt)
      {
        i += 1;
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a();
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(i, true);
      }
    }
  }
  
  public void setTabFrameHeight(int paramInt)
  {
    int i = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f())
    {
      i = paramInt;
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView instanceof QfileBaseCloudFileTabView)) {
        i = paramInt + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.a();
      }
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, i);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.w();
  }
  
  public void setUin(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setWYSubAppId(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QfileTabBarView
 * JD-Core Version:    0.7.0.1
 */