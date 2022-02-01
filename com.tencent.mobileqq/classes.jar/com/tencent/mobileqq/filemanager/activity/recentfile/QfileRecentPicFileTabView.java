package com.tencent.mobileqq.filemanager.activity.recentfile;

import aavz;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import anvx;
import ataa;
import atab;
import atak;
import atew;
import atex;
import atey;
import atez;
import atfa;
import atfq;
import athn;
import atlf;
import atlh;
import atpm;
import atyi;
import atyk;
import atyn;
import audr;
import audy;
import audz;
import auea;
import auex;
import aufb;
import aufn;
import augh;
import bdla;
import bhdj;
import bhdx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
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
  private atfq jdField_a_of_type_Atfq;
  private auex jdField_a_of_type_Auex;
  augh jdField_a_of_type_Augh = new atey(this);
  private View.OnClickListener d = new atez(this);
  private View.OnClickListener e = new atfa(this);
  
  public QfileRecentPicFileTabView(Context paramContext)
  {
    super(paramContext);
    if (this.jdField_a_of_type_Atfq == null) {
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
    Object localObject1 = (ataa)paramView.getTag();
    paramView = (FileManagerEntity)((ataa)localObject1).jdField_a_of_type_JavaLangObject;
    localObject1 = ((ataa)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
    if (paramView == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().b();
      if (paramBoolean)
      {
        if (atpm.a(paramView)) {
          atpm.b(paramView);
        }
        for (;;)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f) && (paramView.cloudType == 3) && (!FileUtil.fileExistsAndNotEmpty(paramView.getFilePath())))
          {
            audr.a(auea.d(paramView.fileName) + anvx.a(2131709155));
            atpm.b(paramView);
          }
          w();
          g();
          return;
          atpm.a(paramView);
          if (c(paramView))
          {
            localObject1 = bhdj.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131697909);
            ((QQCustomDialog)localObject1).setPositiveButton(2131719492, new bhdx());
            ((QQCustomDialog)localObject1).show();
            atpm.b(atpm.jdField_a_of_type_Int);
            audy.a("0X800942D");
          }
        }
      }
      if (g()) {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      if (c()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "click too fast , wait a minute.");
    return;
    u();
    Object localObject2 = new audz();
    ((audz)localObject2).jdField_b_of_type_JavaLangString = "file_viewer_in";
    ((audz)localObject2).jdField_a_of_type_Int = 73;
    ((audz)localObject2).c = FileUtil.getExtension(paramView.fileName);
    ((audz)localObject2).jdField_a_of_type_Long = paramView.fileSize;
    audy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (audz)localObject2);
    audy.a("0X8004AE4");
    localObject2 = new atyi(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramView, 10001);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("from_qlink_enter_recent", this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g());
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.trim().length() != 0)) {
      localBundle.putString("c2c_discussion_recentfile", this.jdField_b_of_type_JavaLangString);
    }
    ((atyi)localObject2).a(localBundle);
    localObject2 = new atyk(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (atyn)localObject2);
    ((atyk)localObject2).a(7);
    if (((paramView.nFileType == 0) || (paramView.nFileType == 2)) && (localObject1 != null) && ((((View)localObject1).getId() == 2131366742) || (((View)localObject1).getId() == 2131368501)))
    {
      ((atyk)localObject2).a(aavz.a((View)localObject1));
      ((atyk)localObject2).a(true);
    }
    if (paramView.nFileType == 2)
    {
      if (FileUtil.fileExistsAndNotEmpty(paramView.getFilePath()))
      {
        ((atyk)localObject2).a();
        return;
      }
      if ((paramView.isSend()) && (!FileUtil.fileExistsAndNotEmpty(paramView.getFilePath())) && (paramView.status != 1) && (paramView.status != -1))
      {
        audr.a(anvx.a(2131709152));
        return;
      }
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        audr.a(2131692469);
        return;
      }
      ((atyk)localObject2).a();
      return;
    }
    ((atyk)localObject2).a();
  }
  
  private boolean a(FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    if (paramFileManagerEntity == null) {}
    while ((paramFileManagerEntity.nFileType != 0) || ((g()) && (((atpm.a(paramFileManagerEntity)) && (paramBoolean)) || ((!atpm.a(paramFileManagerEntity)) && (!paramBoolean))))) {
      return false;
    }
    if (g())
    {
      if (!paramBoolean) {
        break label59;
      }
      atpm.a(paramFileManagerEntity);
    }
    for (;;)
    {
      return true;
      label59:
      atpm.b(paramFileManagerEntity);
    }
  }
  
  private boolean c(FileManagerEntity paramFileManagerEntity)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.i()) && (!atpm.a(atpm.jdField_a_of_type_Int)) && (!atpm.b(paramFileManagerEntity));
  }
  
  private void o()
  {
    this.jdField_a_of_type_Atfq = new atew(this);
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().J();
    }
    while (this.jdField_a_of_type_Auex != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this.jdField_a_of_type_Auex);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().O();
    }
    this.jdField_a_of_type_Auex = new atex(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this.jdField_a_of_type_Auex);
  }
  
  protected atab a()
  {
    return new atak(a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.d, this.e, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.c);
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
        if ((!FileUtil.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath())) && (!FileUtil.fileExistsAndNotEmpty(localFileManagerEntity.strThumbPath)))
        {
          if (localFileManagerEntity.getCloudType() != 1) {
            break label194;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(localFileManagerEntity, 7);
        }
        for (;;)
        {
          String str = aufn.a(localFileManagerEntity.srvTime);
          if (!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(str)) {
            this.jdField_a_of_type_JavaUtilLinkedHashMap.put(str, new ArrayList());
          }
          ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str)).add(localFileManagerEntity);
          break;
          label194:
          if (localFileManagerEntity.getCloudType() == 2) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(localFileManagerEntity.WeiYunFileId, localFileManagerEntity.strLargeThumPath, 3, localFileManagerEntity);
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
    Object localObject = aufn.a(paramFileManagerEntity.srvTime);
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_Augh);
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.runOnUiThread(new QfileRecentPicFileTabView.5(this));
  }
  
  public void m()
  {
    super.m();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_Atfq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentPicFileTabView
 * JD-Core Version:    0.7.0.1
 */