package com.tencent.mobileqq.filemanager.activity.localfile;

import ajya;
import android.content.Context;
import aoqb;
import aost;
import apvd;
import apvj;
import apxx;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class QfileLocalFileDocTabView
  extends QfileBaseLocalFileTabView
{
  public QfileLocalFileDocTabView(Context paramContext, List<apxx> paramList, boolean paramBoolean)
  {
    super(paramContext, paramList, paramBoolean);
    setEditbarButton(false, false, true, true, true);
  }
  
  private String a(String paramString)
  {
    paramString = apvd.a(paramString);
    if ((paramString == null) || (paramString.length() == 0)) {
      return ajya.a(2131709679);
    }
    paramString = paramString.toLowerCase();
    if (".doc|.docx|.wps|.pages|".indexOf(paramString) >= 0) {
      return "WORD";
    }
    if (".ppt|.pptx.|.dps|.keynote|".indexOf(paramString) >= 0) {
      return "PPT";
    }
    if (".xls|.xlsx|.et|.numbers|".indexOf(paramString) >= 0) {
      return "EXCEL";
    }
    if (".pdf|".indexOf(paramString) >= 0) {
      return "PDF";
    }
    return ajya.a(2131709695);
  }
  
  protected aoqb a()
  {
    return new aost(a(), this.jdField_c_of_type_JavaUtilLinkedHashMap, a(), this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_c_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.d);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this);
    this.jdField_a_of_type_JavaLangRunnable = new QfileLocalFileDocTabView.1(this);
    ThreadManager.executeOnFileThread(this.jdField_a_of_type_JavaLangRunnable);
  }
  
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
    a(new QfileLocalFileDocTabView.2(this, paramFileInfo));
  }
  
  protected boolean b(FileInfo paramFileInfo)
  {
    String str = paramFileInfo.a();
    if (!this.jdField_c_of_type_JavaUtilLinkedHashMap.containsKey(str))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
      return false;
    }
    ((List)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(str)).remove(paramFileInfo);
    i();
    return true;
  }
  
  public void j()
  {
    super.j();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c())
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.k()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().S();
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h(true);
    }
    for (;;)
    {
      setEditbarButton(false, false, true, true, true);
      l();
      return;
      if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.k()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().X();
      }
    }
  }
  
  public void m()
  {
    super.m();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileDocTabView
 * JD-Core Version:    0.7.0.1
 */