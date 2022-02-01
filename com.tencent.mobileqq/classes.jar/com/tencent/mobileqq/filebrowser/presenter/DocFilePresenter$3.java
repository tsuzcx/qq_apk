package com.tencent.mobileqq.filebrowser.presenter;

import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils;
import java.util.List;

class DocFilePresenter$3
  implements Runnable
{
  DocFilePresenter$3(DocFilePresenter paramDocFilePresenter, String paramString, boolean paramBoolean, int paramInt, List paramList) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_JavaLangString.split("\\$");
    if (localObject.length == 2)
    {
      String str1 = this.this$0.a.a();
      String str2 = localObject[0];
      String str3 = localObject[1];
      boolean bool = this.jdField_a_of_type_Boolean;
      if (this.jdField_a_of_type_Int == 0) {
        localObject = this.jdField_a_of_type_JavaUtilList;
      } else {
        localObject = null;
      }
      List localList1;
      if (this.jdField_a_of_type_Int == 1) {
        localList1 = this.jdField_a_of_type_JavaUtilList;
      } else {
        localList1 = null;
      }
      List localList2;
      if (this.jdField_a_of_type_Int == 3000) {
        localList2 = this.jdField_a_of_type_JavaUtilList;
      } else {
        localList2 = null;
      }
      TeamWorkHandlerUtils.a(str1, str2, str3, false, bool, 1, (List)localObject, localList1, localList2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.DocFilePresenter.3
 * JD-Core Version:    0.7.0.1
 */