package com.tencent.mobileqq.filemanager.activity.recentfile;

import alpo;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import aqiy;
import aqiz;
import aqji;
import aqms;
import aqmt;
import aqmu;
import aqmv;
import aqmw;
import aqnl;
import aqns;
import aqsc;
import aqse;
import aqxj;
import arhh;
import arhj;
import arhm;
import armz;
import arng;
import arnh;
import arni;
import arof;
import aroh;
import arol;
import aroy;
import arqx;
import azmj;
import bdcd;
import bdco;
import bdee;
import bdfq;
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
import zen;

public class QfileRecentPicFileTabView
  extends QfileBaseRecentFileTabView
{
  private aqnl jdField_a_of_type_Aqnl;
  private aroh jdField_a_of_type_Aroh;
  arqx jdField_a_of_type_Arqx = new aqmu(this);
  private View.OnClickListener d = new aqmv(this);
  private View.OnClickListener e = new aqmw(this);
  
  public QfileRecentPicFileTabView(Context paramContext)
  {
    super(paramContext);
    if (this.jdField_a_of_type_Aqnl == null) {
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
    Object localObject1 = (aqiy)paramView.getTag();
    paramView = (FileManagerEntity)((aqiy)localObject1).jdField_a_of_type_JavaLangObject;
    localObject1 = ((aqiy)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
    if (paramView == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
      if (paramBoolean)
      {
        if (aqxj.a(paramView)) {
          aqxj.b(paramView);
        }
        for (;;)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.d) && (paramView.cloudType == 3) && (!arof.b(paramView.strFilePath)))
          {
            armz.a(arni.d(paramView.fileName) + alpo.a(2131710079));
            aqxj.b(paramView);
          }
          t();
          g();
          return;
          aqxj.a(paramView);
          if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.i()) && (!aqxj.a(aqxj.jdField_a_of_type_Int)) && (!aqxj.b(paramView)))
          {
            localObject1 = bdcd.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131698494);
            ((bdfq)localObject1).setPositiveButton(2131720960, new bdco());
            ((bdfq)localObject1).show();
            aqxj.b(aqxj.jdField_a_of_type_Int);
            arng.a("0X800942D");
          }
        }
      }
      if (f()) {
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      if (b()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "click too fast , wait a minute.");
    return;
    r();
    Object localObject2 = new arnh();
    ((arnh)localObject2).jdField_b_of_type_JavaLangString = "file_viewer_in";
    ((arnh)localObject2).jdField_a_of_type_Int = 73;
    ((arnh)localObject2).c = arof.a(paramView.fileName);
    ((arnh)localObject2).jdField_a_of_type_Long = paramView.fileSize;
    arng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (arnh)localObject2);
    arng.a("0X8004AE4");
    localObject2 = new arhh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramView, 10001);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("from_qlink_enter_recent", this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g());
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.trim().length() != 0)) {
      localBundle.putString("c2c_discussion_recentfile", this.jdField_b_of_type_JavaLangString);
    }
    ((arhh)localObject2).a(localBundle);
    localObject2 = new arhj(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (arhm)localObject2);
    ((arhj)localObject2).a(7);
    if (((paramView.nFileType == 0) || (paramView.nFileType == 2)) && (localObject1 != null) && ((((View)localObject1).getId() == 2131366299) || (((View)localObject1).getId() == 2131367910)))
    {
      ((arhj)localObject2).a(zen.a((View)localObject1));
      ((arhj)localObject2).a(true);
    }
    if (paramView.nFileType == 2)
    {
      if (arof.b(paramView.getFilePath()))
      {
        ((arhj)localObject2).a();
        return;
      }
      if ((paramView.isSend()) && (!arof.b(paramView.getFilePath())) && (paramView.status != 1) && (paramView.status != -1))
      {
        armz.a(alpo.a(2131710076));
        return;
      }
      if (!bdee.d(BaseApplication.getContext()))
      {
        armz.a(2131692745);
        return;
      }
      ((arhj)localObject2).a();
      return;
    }
    ((arhj)localObject2).a();
  }
  
  private boolean a(FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    if (paramFileManagerEntity == null) {}
    while ((paramFileManagerEntity.nFileType != 0) || ((f()) && (((aqxj.a(paramFileManagerEntity)) && (paramBoolean)) || ((!aqxj.a(paramFileManagerEntity)) && (!paramBoolean))))) {
      return false;
    }
    if (f())
    {
      if (!paramBoolean) {
        break label59;
      }
      aqxj.a(paramFileManagerEntity);
    }
    for (;;)
    {
      return true;
      label59:
      aqxj.b(paramFileManagerEntity);
    }
  }
  
  private void l()
  {
    this.jdField_a_of_type_Aqnl = new aqms(this);
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().L();
    }
    while (this.jdField_a_of_type_Aroh != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this.jdField_a_of_type_Aroh);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().Q();
    }
    this.jdField_a_of_type_Aroh = new aqmt(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this.jdField_a_of_type_Aroh);
  }
  
  protected aqiz a()
  {
    return new aqji(a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.d, this.e, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.c);
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
        if ((!arof.b(localFileManagerEntity.getFilePath())) && (!arof.b(localFileManagerEntity.strThumbPath)))
        {
          if (localFileManagerEntity.getCloudType() != 1) {
            break label194;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 7);
        }
        for (;;)
        {
          String str = aroy.a(localFileManagerEntity.srvTime);
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
    Object localObject = aroy.a(paramFileManagerEntity.srvTime);
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_Arqx);
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.runOnUiThread(new QfileRecentPicFileTabView.5(this));
  }
  
  public void m()
  {
    super.m();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aqnl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentPicFileTabView
 * JD-Core Version:    0.7.0.1
 */