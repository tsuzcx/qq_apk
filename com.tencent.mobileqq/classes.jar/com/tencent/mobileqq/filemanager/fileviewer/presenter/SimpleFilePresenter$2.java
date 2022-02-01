package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils;
import java.util.List;

class SimpleFilePresenter$2
  implements Runnable
{
  SimpleFilePresenter$2(SimpleFilePresenter paramSimpleFilePresenter, String paramString, boolean paramBoolean, int paramInt, List paramList) {}
  
  public void run()
  {
    Object localObject = this.a.split("\\$");
    if (localObject.length == 2)
    {
      String str1 = this.this$0.c.ag();
      String str2 = localObject[0];
      String str3 = localObject[1];
      boolean bool = this.b;
      if (this.c == 0) {
        localObject = this.d;
      } else {
        localObject = null;
      }
      List localList1;
      if (this.c == 1) {
        localList1 = this.d;
      } else {
        localList1 = null;
      }
      List localList2;
      if (this.c == 3000) {
        localList2 = this.d;
      } else {
        localList2 = null;
      }
      TeamWorkHandlerUtils.a(str1, str2, str3, false, bool, 1, (List)localObject, localList1, localList2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.2
 * JD-Core Version:    0.7.0.1
 */