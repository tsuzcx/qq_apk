package com.tencent.mobileqq.filemanager.activity.localfile;

import aagn;
import amtj;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import arvu;
import arvv;
import arvz;
import arwb;
import arzr;
import arzs;
import arzt;
import asgz;
import aslg;
import asub;
import asud;
import asug;
import asyy;
import aszk;
import aszl;
import aszr;
import aszs;
import aszt;
import atau;
import atca;
import atcc;
import bcef;
import bfur;
import bfvf;
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
  arvz jdField_a_of_type_Arvz = null;
  arwb jdField_a_of_type_Arwb;
  protected atca a;
  private View.OnClickListener e = new arzs(this);
  private View.OnClickListener f;
  
  public QfileLocalFilePicTabView(Context paramContext, List<atcc> paramList, boolean paramBoolean)
  {
    super(paramContext, paramList, paramBoolean);
    this.jdField_a_of_type_Atca = new arzr(this);
    this.jdField_f_of_type_AndroidViewView$OnClickListener = new arzt(this);
    setEditbarButton(true, false, true, true, true);
    this.jdField_a_of_type_JavaLangRunnable = new QfileLocalFilePicTabView.1(this);
  }
  
  private Map<String, List<FileInfo>> a()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put(amtj.a(2131708787), new ArrayList());
    localLinkedHashMap.put(amtj.a(2131708786), new ArrayList());
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
        localObject1 = amtj.a(2131708778);
      }
      localObject2 = localObject1;
      if (((String)localObject1).equalsIgnoreCase("camera") == true) {
        localObject2 = amtj.a(2131708802);
      }
      if (!localLinkedHashMap.containsKey(localObject2)) {
        localLinkedHashMap.put(localObject2, new ArrayList());
      }
      ((List)localLinkedHashMap.get(localObject2)).add(localObject3);
    }
    if (((FMActivity)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity).h() == 1)
    {
      localObject1 = amtj.a(2131697637);
      localLinkedHashMap.put(localObject1, new ArrayList());
      localObject2 = new HashMap();
      aszl.a(true, VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH) + "/chatpic/chatimg/", "", "", (HashMap)localObject2, null);
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
    Object localObject2 = (arvu)paramView.getTag();
    paramView = (FileInfo)((arvu)localObject2).jdField_a_of_type_JavaLangObject;
    Object localObject1 = ((arvu)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
    if (paramView == null) {
      return;
    }
    Object localObject3;
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g()) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h()))
    {
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getSharedPreferences("LAST_CHOOSE_", 0).edit();
      ((SharedPreferences.Editor)localObject3).putInt("GROUP", ((arvu)localObject2).b);
      ((SharedPreferences.Editor)localObject3).putInt("CHILD", (((arvu)localObject2).jdField_a_of_type_Int + 1) / 4);
      ((SharedPreferences.Editor)localObject3).commit();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().b();
    if (paramBoolean) {
      if (aslg.a(paramView))
      {
        aslg.b(paramView);
        b(paramView, false);
        label139:
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h(true);
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.jdField_f_of_type_Boolean) && (!FileUtil.fileExistsAndNotEmpty(paramView.c())))
        {
          aszk.a(aszt.d(paramView.d()) + amtj.a(2131708789));
          aslg.b(paramView);
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
      aslg.a(paramView);
      b(paramView, true);
      if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.i()) || (aslg.a(aslg.jdField_a_of_type_Int)) || (aslg.b(paramView))) {
        break label139;
      }
      localObject1 = bfur.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131697629);
      ((QQCustomDialog)localObject1).setPositiveButton(2131719087, new bfvf());
      ((QQCustomDialog)localObject1).show();
      aslg.b(aslg.jdField_a_of_type_Int);
      aszr.a("0X800942D");
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
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      u();
      localObject2 = aszt.a(paramView);
      localObject3 = new asub(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (FileManagerEntity)localObject2, 10000);
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
        aslg.a((ArrayList)localObject4);
        localObject4 = new Bundle();
        ((Bundle)localObject4).putInt("clicked_file_hashcode", paramView.hashCode());
        ((asub)localObject3).a((Bundle)localObject4);
      }
      localObject3 = new asud(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (asug)localObject3);
      ((asud)localObject3).a(8);
      if (((((FileManagerEntity)localObject2).nFileType == 0) || (((FileManagerEntity)localObject2).nFileType == 2)) && (localObject1 != null) && ((((View)localObject1).getId() == 2131366631) || (((View)localObject1).getId() == 2131368344))) {
        ((asud)localObject3).a(aagn.a((View)localObject1));
      }
      ((asud)localObject3).a();
      localObject1 = new aszs();
      ((aszs)localObject1).b = "file_viewer_in";
      ((aszs)localObject1).jdField_a_of_type_Int = 80;
      ((aszs)localObject1).c = FileUtil.getExtension(paramView.d());
      ((aszs)localObject1).jdField_a_of_type_Long = paramView.a();
      aszr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (aszs)localObject1);
      aszr.a("0X8004AE5");
    }
  }
  
  private boolean a(FileInfo paramFileInfo, boolean paramBoolean)
  {
    if (paramFileInfo == null) {}
    while ((g()) && (((aslg.a(paramFileInfo)) && (paramBoolean)) || ((!aslg.a(paramFileInfo)) && (!paramBoolean)))) {
      return false;
    }
    if (g())
    {
      if (!paramBoolean) {
        break label70;
      }
      if (this.jdField_a_of_type_Arvz != null) {
        this.jdField_a_of_type_Arvz.a(paramFileInfo, true);
      }
      aslg.a(paramFileInfo);
    }
    for (;;)
    {
      return true;
      label70:
      if (this.jdField_a_of_type_Arvz != null) {
        this.jdField_a_of_type_Arvz.a(paramFileInfo, false);
      }
      aslg.b(paramFileInfo);
    }
  }
  
  private void q()
  {
    if (this.jdField_f_of_type_Boolean) {}
    for (HashMap localHashMap = (HashMap)aszl.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);; localHashMap = null)
    {
      if (localHashMap == null) {
        localHashMap = new HashMap();
      }
      for (;;)
      {
        Object localObject1 = this.jdField_d_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          aszl.a(true, ((atcc)((Iterator)localObject1).next()).a(), ".jpg|.bmp|.jpeg|.gif|.png|.ico|", "", localHashMap, this);
        }
        if (this.jdField_f_of_type_Boolean)
        {
          localObject1 = asyy.a().a();
          if (localObject1 != null) {
            aszl.a(true, (String)localObject1, ".jpg|.bmp|.jpeg|.gif|.png|.ico|", "", localHashMap, this);
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
          aszl.a(localHashMap);
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
  
  protected arvv a()
  {
    this.jdField_a_of_type_Arwb = new arwb(a(), this.c, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_f_of_type_AndroidViewView$OnClickListener, this.e, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_d_of_type_AndroidViewView$OnClickListener);
    return this.jdField_a_of_type_Arwb;
  }
  
  protected void a()
  {
    ThreadManagerV2.excute(this.jdField_a_of_type_JavaLangRunnable, 64, null, true);
  }
  
  protected void a(arvz paramarvz)
  {
    this.jdField_a_of_type_Arvz = paramarvz;
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
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_Atca);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView
 * JD-Core Version:    0.7.0.1
 */