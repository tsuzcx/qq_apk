package com.tencent.mobileqq.filemanager.activity.localfile;

import aavz;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import anvx;
import ataa;
import atab;
import ataf;
import atah;
import atdx;
import atdy;
import atdz;
import atlf;
import atpm;
import atyi;
import atyk;
import atyn;
import audf;
import audr;
import auds;
import audy;
import audz;
import auea;
import aufb;
import augh;
import augj;
import bdla;
import bhdj;
import bhdx;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.filemanager.data.FileInfo;>;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class QfileLocalFilePicTabView
  extends QfileBaseLocalFileTabView
{
  ataf jdField_a_of_type_Ataf = null;
  atah jdField_a_of_type_Atah;
  protected augh a;
  private View.OnClickListener e = new atdy(this);
  private View.OnClickListener f;
  
  public QfileLocalFilePicTabView(Context paramContext, List<augj> paramList, boolean paramBoolean)
  {
    super(paramContext, paramList, paramBoolean);
    this.jdField_a_of_type_Augh = new atdx(this);
    this.jdField_f_of_type_AndroidViewView$OnClickListener = new atdz(this);
    setEditbarButton(true, false, true, true, true);
    this.jdField_a_of_type_JavaLangRunnable = new QfileLocalFilePicTabView.1(this);
  }
  
  private ArrayList<FileInfo> a()
  {
    if (this.jdField_f_of_type_Boolean) {}
    for (HashMap localHashMap = (HashMap)auds.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);; localHashMap = null)
    {
      if (localHashMap == null) {
        localHashMap = new HashMap();
      }
      for (;;)
      {
        Object localObject = this.jdField_d_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          auds.a(true, ((augj)((Iterator)localObject).next()).a(), ".jpg|.bmp|.jpeg|.gif|.png|.ico|", "", localHashMap, this);
        }
        if (this.jdField_f_of_type_Boolean) {}
        for (localObject = audf.a().a();; localObject = null)
        {
          if (localObject != null) {
            auds.a(true, (String)localObject, ".jpg|.bmp|.jpeg|.gif|.png|.ico|", "", localHashMap, this);
          }
          localObject = new ArrayList();
          ((ArrayList)localObject).addAll(this.jdField_a_of_type_JavaUtilArrayList);
          if (!d()) {
            break;
          }
          return localObject;
        }
        auds.a(localHashMap);
        if (localHashMap != null)
        {
          Iterator localIterator = localHashMap.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (!"QQfile_recv".equalsIgnoreCase(str)) {
              ((ArrayList)localObject).addAll((List)localHashMap.get(str));
            }
          }
        }
        return localObject;
      }
    }
  }
  
  private Map<String, List<FileInfo>> a(ArrayList<FileInfo> paramArrayList)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put(anvx.a(2131709134), new ArrayList());
    localLinkedHashMap.put(anvx.a(2131709133), new ArrayList());
    Iterator localIterator = paramArrayList.iterator();
    Object localObject2;
    Object localObject1;
    while (localIterator.hasNext())
    {
      localObject2 = (FileInfo)localIterator.next();
      localObject1 = ((FileInfo)localObject2).a();
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equalsIgnoreCase("QQfile_recv")))
      {
        paramArrayList = (ArrayList<FileInfo>)localObject1;
        if (!((String)localObject1).equalsIgnoreCase("QQ")) {}
      }
      else
      {
        paramArrayList = anvx.a(2131709125);
      }
      localObject1 = paramArrayList;
      if (paramArrayList.equalsIgnoreCase("camera") == true) {
        localObject1 = anvx.a(2131709149);
      }
      if (!localLinkedHashMap.containsKey(localObject1)) {
        localLinkedHashMap.put(localObject1, new ArrayList());
      }
      ((List)localLinkedHashMap.get(localObject1)).add(localObject2);
    }
    if (((FMActivity)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity).h() == 1)
    {
      paramArrayList = anvx.a(2131697917);
      localLinkedHashMap.put(paramArrayList, new ArrayList());
      localObject1 = new HashMap();
      auds.a(true, VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH) + "/chatpic/chatimg/", "", "", (HashMap)localObject1, null);
      localIterator = ((HashMap)localObject1).keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (List)((HashMap)localObject1).get((String)localIterator.next());
        ((List)localLinkedHashMap.get(paramArrayList)).addAll((Collection)localObject2);
      }
    }
    paramArrayList = localLinkedHashMap.keySet().iterator();
    while (paramArrayList.hasNext()) {
      if (((List)localLinkedHashMap.get((String)paramArrayList.next())).size() == 0) {
        paramArrayList.remove();
      }
    }
    return localLinkedHashMap;
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    Object localObject2 = (ataa)paramView.getTag();
    paramView = (FileInfo)((ataa)localObject2).jdField_a_of_type_JavaLangObject;
    Object localObject1 = ((ataa)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
    if (paramView == null) {
      return;
    }
    Object localObject3;
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g()) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h()))
    {
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getSharedPreferences("LAST_CHOOSE_", 0).edit();
      ((SharedPreferences.Editor)localObject3).putInt("GROUP", ((ataa)localObject2).b);
      ((SharedPreferences.Editor)localObject3).putInt("CHILD", (((ataa)localObject2).jdField_a_of_type_Int + 1) / 4);
      ((SharedPreferences.Editor)localObject3).commit();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().b();
    if (paramBoolean) {
      if (atpm.a(paramView))
      {
        atpm.b(paramView);
        b(paramView, false);
        label141:
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h(true);
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.jdField_f_of_type_Boolean) && (!FileUtil.fileExistsAndNotEmpty(paramView.c())))
        {
          audr.a(auea.d(paramView.d()) + anvx.a(2131709136));
          atpm.b(paramView);
        }
        f();
        w();
        k();
      }
    }
    for (;;)
    {
      a(g());
      return;
      atpm.a(paramView);
      b(paramView, true);
      if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.i()) || (atpm.a(atpm.jdField_a_of_type_Int)) || (atpm.b(paramView))) {
        break label141;
      }
      localObject1 = bhdj.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131697909);
      ((QQCustomDialog)localObject1).setPositiveButton(2131719492, new bhdx());
      ((QQCustomDialog)localObject1).show();
      atpm.b(atpm.jdField_a_of_type_Int);
      audy.a("0X800942D");
      break label141;
      if (!c())
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 2, "click too fast , wait a minute.");
        return;
      }
      if (g()) {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      u();
      localObject2 = auea.a(paramView);
      localObject3 = new atyi(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (FileManagerEntity)localObject2, 10000);
      if (((FileManagerEntity)localObject2).nFileType == 0)
      {
        Object localObject4 = new ArrayList();
        if (this.c != null)
        {
          Iterator localIterator = this.c.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            ((ArrayList)localObject4).addAll((Collection)this.c.get(str));
          }
        }
        atpm.a((ArrayList)localObject4);
        localObject4 = new Bundle();
        ((Bundle)localObject4).putInt("clicked_file_hashcode", paramView.hashCode());
        ((atyi)localObject3).a((Bundle)localObject4);
      }
      localObject3 = new atyk(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (atyn)localObject3);
      ((atyk)localObject3).a(8);
      if (((((FileManagerEntity)localObject2).nFileType == 0) || (((FileManagerEntity)localObject2).nFileType == 2)) && (localObject1 != null) && ((((View)localObject1).getId() == 2131366742) || (((View)localObject1).getId() == 2131368501))) {
        ((atyk)localObject3).a(aavz.a((View)localObject1));
      }
      ((atyk)localObject3).a();
      localObject1 = new audz();
      ((audz)localObject1).b = "file_viewer_in";
      ((audz)localObject1).jdField_a_of_type_Int = 80;
      ((audz)localObject1).c = FileUtil.getExtension(paramView.d());
      ((audz)localObject1).jdField_a_of_type_Long = paramView.a();
      audy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (audz)localObject1);
      audy.a("0X8004AE5");
    }
  }
  
  private boolean a(FileInfo paramFileInfo, boolean paramBoolean)
  {
    if (paramFileInfo == null) {}
    while ((g()) && (((atpm.a(paramFileInfo)) && (paramBoolean)) || ((!atpm.a(paramFileInfo)) && (!paramBoolean)))) {
      return false;
    }
    if (g())
    {
      if (!paramBoolean) {
        break label70;
      }
      if (this.jdField_a_of_type_Ataf != null) {
        this.jdField_a_of_type_Ataf.a(paramFileInfo, true);
      }
      atpm.a(paramFileInfo);
    }
    for (;;)
    {
      return true;
      label70:
      if (this.jdField_a_of_type_Ataf != null) {
        this.jdField_a_of_type_Ataf.a(paramFileInfo, false);
      }
      atpm.b(paramFileInfo);
    }
  }
  
  protected atab a()
  {
    this.jdField_a_of_type_Atah = new atah(a(), this.c, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_f_of_type_AndroidViewView$OnClickListener, this.e, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_d_of_type_AndroidViewView$OnClickListener);
    return this.jdField_a_of_type_Atah;
  }
  
  protected void a()
  {
    ThreadManagerV2.excute(this.jdField_a_of_type_JavaLangRunnable, 64, null, true);
  }
  
  protected void a(ataf paramataf)
  {
    this.jdField_a_of_type_Ataf = paramataf;
  }
  
  public void a(FileInfo paramFileInfo) {}
  
  public void a(Set<FileInfo> paramSet)
  {
    if ((paramSet == null) || (paramSet.size() == 0)) {}
    for (;;)
    {
      return;
      paramSet = paramSet.iterator();
      while (paramSet.hasNext()) {
        b((FileInfo)paramSet.next());
      }
    }
  }
  
  protected void b(FileInfo paramFileInfo)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramFileInfo)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramFileInfo);
    }
    a(new QfileLocalFilePicTabView.2(this, paramFileInfo));
  }
  
  protected boolean b(FileInfo paramFileInfo)
  {
    String str = paramFileInfo.a();
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramFileInfo);
    if (!this.c.containsKey(str))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
      return false;
    }
    ((List)this.c.get(str)).remove(paramFileInfo);
    i();
    return true;
  }
  
  public void j()
  {
    super.j();
    setEditbarButton(true, false, true, true, true);
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.k())
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c()) {
        break label61;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().T();
    }
    for (;;)
    {
      o();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_Augh);
      return;
      label61:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().Y();
    }
  }
  
  public void p()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.runOnUiThread(new QfileLocalFilePicTabView.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView
 * JD-Core Version:    0.7.0.1
 */