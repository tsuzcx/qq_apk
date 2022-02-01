package com.tencent.mobileqq.filemanageraux.widget;

import com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class DocCooperationBanner$3
  implements Runnable
{
  DocCooperationBanner$3(DocCooperationBanner paramDocCooperationBanner, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void run()
  {
    String str1;
    if (this.a.a == 0)
    {
      str1 = this.a.b;
      localObject = "";
    }
    else
    {
      localObject = this.a.b;
      str1 = "";
    }
    String str2 = this.a.c;
    String str3 = this.b;
    int i;
    if (this.c) {
      i = 2;
    } else {
      i = 1;
    }
    Object localObject = TeamWorkHandlerUtils.a(str2, str3, i, (String)localObject, str1, this.d);
    if (localObject != null) {
      QLog.i("DocCooperationBanner", 2, ((JSONObject)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.widget.DocCooperationBanner.3
 * JD-Core Version:    0.7.0.1
 */