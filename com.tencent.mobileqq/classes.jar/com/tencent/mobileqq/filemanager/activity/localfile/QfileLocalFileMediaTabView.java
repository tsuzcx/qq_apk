package com.tencent.mobileqq.filemanager.activity.localfile;

import achx;
import achy;
import acia;
import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.IReport_Ver51;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileLocalFileMediaTabView
  extends QfileBaseLocalFileTabView
{
  private int b = 3;
  
  public QfileLocalFileMediaTabView(Context paramContext, int paramInt)
  {
    super(paramContext);
    setEditbarButton(false, false, true, true, true);
    this.b = paramInt;
    this.jdField_a_of_type_JavaLangRunnable = new achx(this, paramInt, paramContext);
    ThreadManager.executeOnFileThread(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  protected QfileBaseExpandableListAdapter a()
  {
    return new QfileLocalFileBaseExpandableListAdapter(a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, a(), this.jdField_a_of_type_AndroidViewView$OnClickListener, this.c, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.d);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangRunnable = new achy(this);
    ThreadManager.executeOnFileThread(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  protected void b(FileInfo paramFileInfo)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramFileInfo)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramFileInfo);
    }
    a(new acia(this, paramFileInfo));
  }
  
  protected boolean b(FileInfo paramFileInfo)
  {
    String str = paramFileInfo.a();
    if (!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(str))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
      return false;
    }
    ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str)).remove(paramFileInfo);
    i();
    return true;
  }
  
  public void d(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        b((FileInfo)paramArrayList.next());
      }
    }
  }
  
  public void j()
  {
    super.j();
    setEditbarButton(false, false, true, true, true);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.c()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().T();
    }
    for (;;)
    {
      g();
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().Y();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView
 * JD-Core Version:    0.7.0.1
 */