package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import aovk;
import aoxw;
import axfb;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import java.util.List;

public class SimpleFilePresenter$3
  implements Runnable
{
  public SimpleFilePresenter$3(aoxw paramaoxw, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, boolean paramBoolean, int paramInt, List paramList) {}
  
  public void run()
  {
    List localList2 = null;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.m.split("\\$");
    String str1;
    String str2;
    String str3;
    boolean bool;
    if (localObject.length == 2)
    {
      str1 = this.this$0.a.h();
      str2 = localObject[0];
      str3 = localObject[1];
      bool = this.jdField_a_of_type_Boolean;
      if (this.jdField_a_of_type_Int != 0) {
        break label108;
      }
      localObject = this.jdField_a_of_type_JavaUtilList;
      if (this.jdField_a_of_type_Int != 1) {
        break label113;
      }
    }
    label108:
    label113:
    for (List localList1 = this.jdField_a_of_type_JavaUtilList;; localList1 = null)
    {
      if (this.jdField_a_of_type_Int == 3000) {
        localList2 = this.jdField_a_of_type_JavaUtilList;
      }
      axfb.a(str1, str2, str3, false, bool, 1, (List)localObject, localList1, localList2);
      return;
      localObject = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.3
 * JD-Core Version:    0.7.0.1
 */