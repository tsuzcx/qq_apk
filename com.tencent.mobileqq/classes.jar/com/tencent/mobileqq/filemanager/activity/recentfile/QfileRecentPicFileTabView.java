package com.tencent.mobileqq.filemanager.activity.recentfile;

import abke;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import anzj;
import atjl;
import atjm;
import atjv;
import atoh;
import atoi;
import atoj;
import atok;
import atol;
import atpa;
import atqx;
import atup;
import atur;
import atyw;
import auhr;
import auht;
import auhw;
import auna;
import aunh;
import auni;
import aunj;
import auog;
import auoi;
import auom;
import auoy;
import aups;
import bdll;
import bhlq;
import bhme;
import bhnv;
import bhpc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileRecentPicFileTabView
  extends QfileBaseRecentFileTabView
{
  private atpa jdField_a_of_type_Atpa;
  private auoi jdField_a_of_type_Auoi;
  aups jdField_a_of_type_Aups = new atoj(this);
  private View.OnClickListener d = new atok(this);
  private View.OnClickListener e = new atol(this);
  
  public QfileRecentPicFileTabView(Context paramContext)
  {
    super(paramContext);
    if (this.jdField_a_of_type_Atpa == null) {
      o();
    }
    f();
    setEditbarButton(true, true, true, true, true);
  }
  
  public QfileRecentPicFileTabView(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    f();
    setEditbarButton(false, true, true, true, true);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    Object localObject1 = (atjl)paramView.getTag();
    paramView = (FileManagerEntity)((atjl)localObject1).jdField_a_of_type_JavaLangObject;
    localObject1 = ((atjl)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
    if (paramView == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
      if (paramBoolean)
      {
        if (atyw.a(paramView)) {
          atyw.b(paramView);
        }
        for (;;)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f) && (paramView.cloudType == 3) && (!auog.b(paramView.getFilePath())))
          {
            auna.a(aunj.d(paramView.fileName) + anzj.a(2131708576));
            atyw.b(paramView);
          }
          w();
          g();
          return;
          atyw.a(paramView);
          if (c(paramView))
          {
            localObject1 = bhlq.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131697483);
            ((bhpc)localObject1).setPositiveButton(2131718838, new bhme());
            ((bhpc)localObject1).show();
            atyw.b(atyw.jdField_a_of_type_Int);
            aunh.a("0X800942D");
          }
        }
      }
      if (g()) {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      if (c()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "click too fast , wait a minute.");
    return;
    u();
    Object localObject2 = new auni();
    ((auni)localObject2).jdField_b_of_type_JavaLangString = "file_viewer_in";
    ((auni)localObject2).jdField_a_of_type_Int = 73;
    ((auni)localObject2).c = auog.a(paramView.fileName);
    ((auni)localObject2).jdField_a_of_type_Long = paramView.fileSize;
    aunh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (auni)localObject2);
    aunh.a("0X8004AE4");
    localObject2 = new auhr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramView, 10001);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("from_qlink_enter_recent", this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g());
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.trim().length() != 0)) {
      localBundle.putString("c2c_discussion_recentfile", this.jdField_b_of_type_JavaLangString);
    }
    ((auhr)localObject2).a(localBundle);
    localObject2 = new auht(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (auhw)localObject2);
    ((auht)localObject2).a(7);
    if (((paramView.nFileType == 0) || (paramView.nFileType == 2)) && (localObject1 != null) && ((((View)localObject1).getId() == 2131366604) || (((View)localObject1).getId() == 2131368320)))
    {
      ((auht)localObject2).a(abke.a((View)localObject1));
      ((auht)localObject2).a(true);
    }
    if (paramView.nFileType == 2)
    {
      if (auog.b(paramView.getFilePath()))
      {
        ((auht)localObject2).a();
        return;
      }
      if ((paramView.isSend()) && (!auog.b(paramView.getFilePath())) && (paramView.status != 1) && (paramView.status != -1))
      {
        auna.a(anzj.a(2131708573));
        return;
      }
      if (!bhnv.d(BaseApplication.getContext()))
      {
        auna.a(2131692319);
        return;
      }
      ((auht)localObject2).a();
      return;
    }
    ((auht)localObject2).a();
  }
  
  private boolean a(FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    if (paramFileManagerEntity == null) {}
    while ((paramFileManagerEntity.nFileType != 0) || ((g()) && (((atyw.a(paramFileManagerEntity)) && (paramBoolean)) || ((!atyw.a(paramFileManagerEntity)) && (!paramBoolean))))) {
      return false;
    }
    if (g())
    {
      if (!paramBoolean) {
        break label59;
      }
      atyw.a(paramFileManagerEntity);
    }
    for (;;)
    {
      return true;
      label59:
      atyw.b(paramFileManagerEntity);
    }
  }
  
  private boolean c(FileManagerEntity paramFileManagerEntity)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.i()) && (!atyw.a(atyw.jdField_a_of_type_Int)) && (!atyw.b(paramFileManagerEntity));
  }
  
  private void o()
  {
    this.jdField_a_of_type_Atpa = new atoh(this);
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().J();
    }
    while (this.jdField_a_of_type_Auoi != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this.jdField_a_of_type_Auoi);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().O();
    }
    this.jdField_a_of_type_Auoi = new atoi(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this.jdField_a_of_type_Auoi);
  }
  
  protected atjm a()
  {
    return new atjv(a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.d, this.e, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.c);
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    if (QLog.isDevelopLevel()) {
      QLog.e("crashBUG", 1, "Thread id: " + Thread.currentThread().getId());
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if ((!localFileManagerEntity.bDelInFM) && (localFileManagerEntity.nFileType == 0))
      {
        if ((!auog.b(localFileManagerEntity.getFilePath())) && (!auog.b(localFileManagerEntity.strThumbPath)))
        {
          if (localFileManagerEntity.getCloudType() != 1) {
            break label194;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 7);
        }
        for (;;)
        {
          String str = auoy.a(localFileManagerEntity.srvTime);
          if (!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(str)) {
            this.jdField_a_of_type_JavaUtilLinkedHashMap.put(str, new ArrayList());
          }
          ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str)).add(localFileManagerEntity);
          break;
          label194:
          if (localFileManagerEntity.getCloudType() == 2) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.WeiYunFileId, localFileManagerEntity.strLargeThumPath, 3, localFileManagerEntity);
          }
        }
      }
    }
    i();
    setSelect(0);
    a(true);
    this.jdField_b_of_type_Boolean = false;
  }
  
  protected void b(FileManagerEntity paramFileManagerEntity)
  {
    if (QLog.isDevelopLevel()) {
      QLog.e("crashBUG", 1, "Thread id: " + Thread.currentThread().getId() + " refreshRecentFileRecords");
    }
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramFileManagerEntity)) {
      if ((this.jdField_b_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString.trim().length() == 0) || (this.jdField_b_of_type_JavaLangString.equals(paramFileManagerEntity.peerUin))) {}
    }
    while (paramFileManagerEntity.nFileType != 0)
    {
      return;
      this.jdField_a_of_type_JavaUtilList.add(paramFileManagerEntity);
      Collections.sort(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilComparator);
    }
    a(new QfileRecentPicFileTabView.3(this, paramFileManagerEntity));
  }
  
  protected boolean b(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject = auoy.a(paramFileManagerEntity.srvTime);
    if (!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localObject))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
      return false;
    }
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      localObject = ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject)).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramFileManagerEntity == (FileManagerEntity)((Iterator)localObject).next()) {
          ((Iterator)localObject).remove();
        }
      }
      i();
      return true;
    }
  }
  
  public void c(ArrayList<FileManagerEntity> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        b((FileManagerEntity)paramArrayList.next());
      }
    }
  }
  
  public void j()
  {
    super.j();
    setEditbarButton(true, true, true, true, true);
    p();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_Aups);
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.runOnUiThread(new QfileRecentPicFileTabView.5(this));
  }
  
  public void m()
  {
    super.m();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Atpa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentPicFileTabView
 * JD-Core Version:    0.7.0.1
 */