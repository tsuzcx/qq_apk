package com.tencent.mobileqq.filemanager.activity.recentfile;

import ajya;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import aoqa;
import aoqb;
import aoqk;
import aotu;
import aotv;
import aotw;
import aotx;
import aoty;
import aoun;
import aouu;
import aoze;
import aozg;
import apel;
import apoi;
import apok;
import apon;
import aptx;
import apue;
import apuf;
import apug;
import apvd;
import apvf;
import apvj;
import apvw;
import apxv;
import axqy;
import bbdj;
import bbdt;
import bbfj;
import bbgu;
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
import xpu;

public class QfileRecentPicFileTabView
  extends QfileBaseRecentFileTabView
{
  private aoun jdField_a_of_type_Aoun;
  private apvf jdField_a_of_type_Apvf;
  apxv jdField_a_of_type_Apxv = new aotw(this);
  private View.OnClickListener d = new aotx(this);
  private View.OnClickListener e = new aoty(this);
  
  public QfileRecentPicFileTabView(Context paramContext)
  {
    super(paramContext);
    if (this.jdField_a_of_type_Aoun == null) {
      l();
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
    Object localObject1 = (aoqa)paramView.getTag();
    paramView = (FileManagerEntity)((aoqa)localObject1).jdField_a_of_type_JavaLangObject;
    localObject1 = ((aoqa)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
    if (paramView == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
      if (paramBoolean)
      {
        if (apel.a(paramView)) {
          apel.b(paramView);
        }
        for (;;)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.d) && (paramView.cloudType == 3) && (!apvd.b(paramView.strFilePath)))
          {
            aptx.a(apug.d(paramView.fileName) + ajya.a(2131709707));
            apel.b(paramView);
          }
          t();
          g();
          return;
          apel.a(paramView);
          if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.i()) && (!apel.a(apel.jdField_a_of_type_Int)) && (!apel.b(paramView)))
          {
            localObject1 = bbdj.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131698204);
            ((bbgu)localObject1).setPositiveButton(2131720422, new bbdt());
            ((bbgu)localObject1).show();
            apel.b(apel.jdField_a_of_type_Int);
            apue.a("0X800942D");
          }
        }
      }
      if (f()) {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      if (b()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "click too fast , wait a minute.");
    return;
    r();
    Object localObject2 = new apuf();
    ((apuf)localObject2).jdField_b_of_type_JavaLangString = "file_viewer_in";
    ((apuf)localObject2).jdField_a_of_type_Int = 73;
    ((apuf)localObject2).c = apvd.a(paramView.fileName);
    ((apuf)localObject2).jdField_a_of_type_Long = paramView.fileSize;
    apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (apuf)localObject2);
    apue.a("0X8004AE4");
    localObject2 = new apoi(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramView, 10001);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("from_qlink_enter_recent", this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g());
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.trim().length() != 0)) {
      localBundle.putString("c2c_discussion_recentfile", this.jdField_b_of_type_JavaLangString);
    }
    ((apoi)localObject2).a(localBundle);
    localObject2 = new apok(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (apon)localObject2);
    ((apok)localObject2).a(7);
    if (((paramView.nFileType == 0) || (paramView.nFileType == 2)) && (localObject1 != null) && ((((View)localObject1).getId() == 2131366211) || (((View)localObject1).getId() == 2131367776)))
    {
      ((apok)localObject2).a(xpu.a((View)localObject1));
      ((apok)localObject2).a(true);
    }
    if (paramView.nFileType == 2)
    {
      if (apvd.b(paramView.getFilePath()))
      {
        ((apok)localObject2).a();
        return;
      }
      if ((paramView.isSend()) && (!apvd.b(paramView.getFilePath())) && (paramView.status != 1) && (paramView.status != -1))
      {
        aptx.a(ajya.a(2131709704));
        return;
      }
      if (!bbfj.d(BaseApplication.getContext()))
      {
        aptx.a(2131692666);
        return;
      }
      ((apok)localObject2).a();
      return;
    }
    ((apok)localObject2).a();
  }
  
  private boolean a(FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    if (paramFileManagerEntity == null) {}
    while ((paramFileManagerEntity.nFileType != 0) || ((f()) && (((apel.a(paramFileManagerEntity)) && (paramBoolean)) || ((!apel.a(paramFileManagerEntity)) && (!paramBoolean))))) {
      return false;
    }
    if (f())
    {
      if (!paramBoolean) {
        break label59;
      }
      apel.a(paramFileManagerEntity);
    }
    for (;;)
    {
      return true;
      label59:
      apel.b(paramFileManagerEntity);
    }
  }
  
  private void l()
  {
    this.jdField_a_of_type_Aoun = new aotu(this);
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().L();
    }
    while (this.jdField_a_of_type_Apvf != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this.jdField_a_of_type_Apvf);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().Q();
    }
    this.jdField_a_of_type_Apvf = new aotv(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this.jdField_a_of_type_Apvf);
  }
  
  protected aoqb a()
  {
    return new aoqk(a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.d, this.e, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.c);
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
        if ((!apvd.b(localFileManagerEntity.getFilePath())) && (!apvd.b(localFileManagerEntity.strThumbPath)))
        {
          if (localFileManagerEntity.getCloudType() != 1) {
            break label194;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 7);
        }
        for (;;)
        {
          String str = apvw.a(localFileManagerEntity.srvTime);
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
    Object localObject = apvw.a(paramFileManagerEntity.srvTime);
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
    o();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_Apxv);
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.runOnUiThread(new QfileRecentPicFileTabView.5(this));
  }
  
  public void m()
  {
    super.m();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aoun);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentPicFileTabView
 * JD-Core Version:    0.7.0.1
 */