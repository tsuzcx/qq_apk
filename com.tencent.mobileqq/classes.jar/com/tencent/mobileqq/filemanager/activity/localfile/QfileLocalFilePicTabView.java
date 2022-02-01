package com.tencent.mobileqq.filemanager.activity.localfile;

import abga;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import anni;
import asth;
import asti;
import astm;
import asto;
import asxe;
import asxf;
import asxg;
import atcv;
import athc;
import atpw;
import atpy;
import atqb;
import atut;
import atvf;
import atvg;
import atvm;
import atvn;
import atvo;
import atwl;
import atwr;
import atxx;
import atxz;
import bcst;
import bglp;
import bgmc;
import bgpa;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
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
  astm jdField_a_of_type_Astm = null;
  asto jdField_a_of_type_Asto;
  protected atxx a;
  private View.OnClickListener e = new asxf(this);
  private View.OnClickListener f;
  
  public QfileLocalFilePicTabView(Context paramContext, List<atxz> paramList, boolean paramBoolean)
  {
    super(paramContext, paramList, paramBoolean);
    this.jdField_a_of_type_Atxx = new asxe(this);
    this.jdField_f_of_type_AndroidViewView$OnClickListener = new asxg(this);
    setEditbarButton(true, false, true, true, true);
    this.jdField_a_of_type_JavaLangRunnable = new QfileLocalFilePicTabView.1(this);
  }
  
  private Map<String, List<FileInfo>> a()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put(anni.a(2131708446), new ArrayList());
    localLinkedHashMap.put(anni.a(2131708445), new ArrayList());
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      FileInfo localFileInfo = (FileInfo)localIterator.next();
      Object localObject2 = localFileInfo.a();
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject2).equalsIgnoreCase("QQfile_recv")))
      {
        localObject1 = localObject2;
        if (!((String)localObject2).equalsIgnoreCase("QQ")) {}
      }
      else
      {
        localObject1 = anni.a(2131708437);
      }
      localObject2 = localObject1;
      if (((String)localObject1).equalsIgnoreCase("camera") == true) {
        localObject2 = anni.a(2131708461);
      }
      if (!localLinkedHashMap.containsKey(localObject2)) {
        localLinkedHashMap.put(localObject2, new ArrayList());
      }
      ((List)localLinkedHashMap.get(localObject2)).add(localFileInfo);
    }
    Object localObject1 = localLinkedHashMap.keySet().iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (((List)localLinkedHashMap.get((String)((Iterator)localObject1).next())).size() == 0) {
        ((Iterator)localObject1).remove();
      }
    }
    return localLinkedHashMap;
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    Object localObject2 = (asth)paramView.getTag();
    paramView = (FileInfo)((asth)localObject2).jdField_a_of_type_JavaLangObject;
    Object localObject1 = ((asth)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
    if (paramView == null) {
      return;
    }
    Object localObject3;
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g()) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h()))
    {
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getSharedPreferences("LAST_CHOOSE_", 0).edit();
      ((SharedPreferences.Editor)localObject3).putInt("GROUP", ((asth)localObject2).b);
      ((SharedPreferences.Editor)localObject3).putInt("CHILD", (((asth)localObject2).jdField_a_of_type_Int + 1) / 4);
      ((SharedPreferences.Editor)localObject3).commit();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    if (paramBoolean) {
      if (athc.a(paramView))
      {
        athc.b(paramView);
        b(paramView, false);
        label139:
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h(true);
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.jdField_f_of_type_Boolean) && (!atwl.b(paramView.c())))
        {
          atvf.a(atvo.d(paramView.d()) + anni.a(2131708448));
          athc.b(paramView);
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
      athc.a(paramView);
      b(paramView, true);
      if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.i()) || (athc.a(athc.jdField_a_of_type_Int)) || (athc.b(paramView))) {
        break label139;
      }
      localObject1 = bglp.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131697403);
      ((bgpa)localObject1).setPositiveButton(2131718702, new bgmc());
      ((bgpa)localObject1).show();
      athc.b(athc.jdField_a_of_type_Int);
      atvm.a("0X800942D");
      break label139;
      if (!c())
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 2, "click too fast , wait a minute.");
        return;
      }
      if (g()) {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      u();
      localObject2 = atvo.a(paramView);
      localObject3 = new atpw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (FileManagerEntity)localObject2, 10000);
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
        athc.a((ArrayList)localObject4);
        localObject4 = new Bundle();
        ((Bundle)localObject4).putInt("clicked_file_hashcode", paramView.hashCode());
        ((atpw)localObject3).a((Bundle)localObject4);
      }
      localObject3 = new atpy(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (atqb)localObject3);
      ((atpy)localObject3).a(8);
      if (((((FileManagerEntity)localObject2).nFileType == 0) || (((FileManagerEntity)localObject2).nFileType == 2)) && (localObject1 != null) && ((((View)localObject1).getId() == 2131366555) || (((View)localObject1).getId() == 2131368246))) {
        ((atpy)localObject3).a(abga.a((View)localObject1));
      }
      ((atpy)localObject3).a();
      localObject1 = new atvn();
      ((atvn)localObject1).b = "file_viewer_in";
      ((atvn)localObject1).jdField_a_of_type_Int = 80;
      ((atvn)localObject1).c = atwl.a(paramView.d());
      ((atvn)localObject1).jdField_a_of_type_Long = paramView.a();
      atvm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (atvn)localObject1);
      atvm.a("0X8004AE5");
    }
  }
  
  private boolean a(FileInfo paramFileInfo, boolean paramBoolean)
  {
    if (paramFileInfo == null) {}
    while ((g()) && (((athc.a(paramFileInfo)) && (paramBoolean)) || ((!athc.a(paramFileInfo)) && (!paramBoolean)))) {
      return false;
    }
    if (g())
    {
      if (!paramBoolean) {
        break label70;
      }
      if (this.jdField_a_of_type_Astm != null) {
        this.jdField_a_of_type_Astm.a(paramFileInfo, true);
      }
      athc.a(paramFileInfo);
    }
    for (;;)
    {
      return true;
      label70:
      if (this.jdField_a_of_type_Astm != null) {
        this.jdField_a_of_type_Astm.a(paramFileInfo, false);
      }
      athc.b(paramFileInfo);
    }
  }
  
  private void q()
  {
    if (this.jdField_f_of_type_Boolean) {}
    for (HashMap localHashMap = (HashMap)atvg.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);; localHashMap = null)
    {
      if (localHashMap == null) {
        localHashMap = new HashMap();
      }
      for (;;)
      {
        Object localObject1 = this.jdField_d_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          atvg.a(true, ((atxz)((Iterator)localObject1).next()).a(), ".jpg|.bmp|.jpeg|.gif|.png|.ico|", "", localHashMap, this);
        }
        if (this.jdField_f_of_type_Boolean)
        {
          localObject1 = atut.a().a();
          if (localObject1 != null) {
            atvg.a(true, (String)localObject1, ".jpg|.bmp|.jpeg|.gif|.png|.ico|", "", localHashMap, this);
          }
          if (!d()) {
            break label120;
          }
        }
        for (;;)
        {
          return;
          localObject1 = null;
          break;
          label120:
          atvg.a(localHashMap);
          if (localHashMap != null)
          {
            localObject1 = localHashMap.keySet().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              Object localObject2 = (String)((Iterator)localObject1).next();
              if (!"QQfile_recv".equalsIgnoreCase((String)localObject2))
              {
                localObject2 = (List)localHashMap.get(localObject2);
                this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject2);
              }
            }
          }
        }
      }
    }
  }
  
  protected asti a()
  {
    this.jdField_a_of_type_Asto = new asto(a(), this.c, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_f_of_type_AndroidViewView$OnClickListener, this.e, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_d_of_type_AndroidViewView$OnClickListener);
    return this.jdField_a_of_type_Asto;
  }
  
  protected void a()
  {
    ThreadManagerV2.excute(this.jdField_a_of_type_JavaLangRunnable, 64, null, true);
  }
  
  protected void a(astm paramastm)
  {
    this.jdField_a_of_type_Astm = paramastm;
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
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_Atxx);
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