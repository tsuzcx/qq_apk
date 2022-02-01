package com.tencent.mobileqq.filemanager.activity.localfile;

import abke;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import antf;
import anzj;
import atjl;
import atjm;
import atjq;
import atjs;
import atni;
import atnj;
import atnk;
import atup;
import atyw;
import auhr;
import auht;
import auhw;
import aumo;
import auna;
import aunb;
import aunh;
import auni;
import aunj;
import auog;
import auom;
import aups;
import aupu;
import bdll;
import bhlq;
import bhme;
import bhpc;
import bigv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
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
  atjq jdField_a_of_type_Atjq = null;
  atjs jdField_a_of_type_Atjs;
  protected aups a;
  private View.OnClickListener e = new atnj(this);
  private View.OnClickListener f;
  
  public QfileLocalFilePicTabView(Context paramContext, List<aupu> paramList, boolean paramBoolean)
  {
    super(paramContext, paramList, paramBoolean);
    this.jdField_a_of_type_Aups = new atni(this);
    this.jdField_f_of_type_AndroidViewView$OnClickListener = new atnk(this);
    setEditbarButton(true, false, true, true, true);
    this.jdField_a_of_type_JavaLangRunnable = new QfileLocalFilePicTabView.1(this);
  }
  
  private Map<String, List<FileInfo>> a()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put(anzj.a(2131708555), new ArrayList());
    localLinkedHashMap.put(anzj.a(2131708554), new ArrayList());
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    Object localObject3;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject3 = (FileInfo)localIterator.next();
      localObject2 = ((FileInfo)localObject3).a();
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject2).equalsIgnoreCase("QQfile_recv")))
      {
        localObject1 = localObject2;
        if (!((String)localObject2).equalsIgnoreCase("QQ")) {}
      }
      else
      {
        localObject1 = anzj.a(2131708546);
      }
      localObject2 = localObject1;
      if (((String)localObject1).equalsIgnoreCase("camera") == true) {
        localObject2 = anzj.a(2131708570);
      }
      if (!localLinkedHashMap.containsKey(localObject2)) {
        localLinkedHashMap.put(localObject2, new ArrayList());
      }
      ((List)localLinkedHashMap.get(localObject2)).add(localObject3);
    }
    if (((FMActivity)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity).h() == 1)
    {
      localObject1 = anzj.a(2131697491);
      localLinkedHashMap.put(localObject1, new ArrayList());
      localObject2 = new HashMap();
      aunb.a(true, bigv.a(antf.ba) + "/chatpic/chatimg/", "", "", (HashMap)localObject2, null);
      localIterator = ((HashMap)localObject2).keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject3 = (List)((HashMap)localObject2).get((String)localIterator.next());
        ((List)localLinkedHashMap.get(localObject1)).addAll((Collection)localObject3);
      }
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
    Object localObject2 = (atjl)paramView.getTag();
    paramView = (FileInfo)((atjl)localObject2).jdField_a_of_type_JavaLangObject;
    Object localObject1 = ((atjl)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
    if (paramView == null) {
      return;
    }
    Object localObject3;
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g()) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h()))
    {
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getSharedPreferences("LAST_CHOOSE_", 0).edit();
      ((SharedPreferences.Editor)localObject3).putInt("GROUP", ((atjl)localObject2).b);
      ((SharedPreferences.Editor)localObject3).putInt("CHILD", (((atjl)localObject2).jdField_a_of_type_Int + 1) / 4);
      ((SharedPreferences.Editor)localObject3).commit();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    if (paramBoolean) {
      if (atyw.a(paramView))
      {
        atyw.b(paramView);
        b(paramView, false);
        label139:
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h(true);
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.jdField_f_of_type_Boolean) && (!auog.b(paramView.c())))
        {
          auna.a(aunj.d(paramView.d()) + anzj.a(2131708557));
          atyw.b(paramView);
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
      atyw.a(paramView);
      b(paramView, true);
      if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.i()) || (atyw.a(atyw.jdField_a_of_type_Int)) || (atyw.b(paramView))) {
        break label139;
      }
      localObject1 = bhlq.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131697483);
      ((bhpc)localObject1).setPositiveButton(2131718838, new bhme());
      ((bhpc)localObject1).show();
      atyw.b(atyw.jdField_a_of_type_Int);
      aunh.a("0X800942D");
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
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      u();
      localObject2 = aunj.a(paramView);
      localObject3 = new auhr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (FileManagerEntity)localObject2, 10000);
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
        atyw.a((ArrayList)localObject4);
        localObject4 = new Bundle();
        ((Bundle)localObject4).putInt("clicked_file_hashcode", paramView.hashCode());
        ((auhr)localObject3).a((Bundle)localObject4);
      }
      localObject3 = new auht(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (auhw)localObject3);
      ((auht)localObject3).a(8);
      if (((((FileManagerEntity)localObject2).nFileType == 0) || (((FileManagerEntity)localObject2).nFileType == 2)) && (localObject1 != null) && ((((View)localObject1).getId() == 2131366604) || (((View)localObject1).getId() == 2131368320))) {
        ((auht)localObject3).a(abke.a((View)localObject1));
      }
      ((auht)localObject3).a();
      localObject1 = new auni();
      ((auni)localObject1).b = "file_viewer_in";
      ((auni)localObject1).jdField_a_of_type_Int = 80;
      ((auni)localObject1).c = auog.a(paramView.d());
      ((auni)localObject1).jdField_a_of_type_Long = paramView.a();
      aunh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (auni)localObject1);
      aunh.a("0X8004AE5");
    }
  }
  
  private boolean a(FileInfo paramFileInfo, boolean paramBoolean)
  {
    if (paramFileInfo == null) {}
    while ((g()) && (((atyw.a(paramFileInfo)) && (paramBoolean)) || ((!atyw.a(paramFileInfo)) && (!paramBoolean)))) {
      return false;
    }
    if (g())
    {
      if (!paramBoolean) {
        break label70;
      }
      if (this.jdField_a_of_type_Atjq != null) {
        this.jdField_a_of_type_Atjq.a(paramFileInfo, true);
      }
      atyw.a(paramFileInfo);
    }
    for (;;)
    {
      return true;
      label70:
      if (this.jdField_a_of_type_Atjq != null) {
        this.jdField_a_of_type_Atjq.a(paramFileInfo, false);
      }
      atyw.b(paramFileInfo);
    }
  }
  
  private void q()
  {
    if (this.jdField_f_of_type_Boolean) {}
    for (HashMap localHashMap = (HashMap)aunb.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);; localHashMap = null)
    {
      if (localHashMap == null) {
        localHashMap = new HashMap();
      }
      for (;;)
      {
        Object localObject1 = this.jdField_d_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          aunb.a(true, ((aupu)((Iterator)localObject1).next()).a(), ".jpg|.bmp|.jpeg|.gif|.png|.ico|", "", localHashMap, this);
        }
        if (this.jdField_f_of_type_Boolean)
        {
          localObject1 = aumo.a().a();
          if (localObject1 != null) {
            aunb.a(true, (String)localObject1, ".jpg|.bmp|.jpeg|.gif|.png|.ico|", "", localHashMap, this);
          }
          if (!d()) {
            break label118;
          }
        }
        for (;;)
        {
          return;
          localObject1 = null;
          break;
          label118:
          aunb.a(localHashMap);
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
  
  protected atjm a()
  {
    this.jdField_a_of_type_Atjs = new atjs(a(), this.c, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_f_of_type_AndroidViewView$OnClickListener, this.e, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_d_of_type_AndroidViewView$OnClickListener);
    return this.jdField_a_of_type_Atjs;
  }
  
  protected void a()
  {
    ThreadManagerV2.excute(this.jdField_a_of_type_JavaLangRunnable, 64, null, true);
  }
  
  protected void a(atjq paramatjq)
  {
    this.jdField_a_of_type_Atjq = paramatjq;
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
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_Aups);
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