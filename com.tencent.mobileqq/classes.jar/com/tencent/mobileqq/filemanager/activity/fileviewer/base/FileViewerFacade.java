package com.tencent.mobileqq.filemanager.activity.fileviewer.base;

import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

public class FileViewerFacade
{
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, FileManagerEntity paramFileManagerEntity, IFileBrowser paramIFileBrowser)
  {
    String str = paramFileManagerEntity.getFilePath();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("open[");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append("]");
      QLog.i("<FileAssistant>FileViewerFacade", 2, ((StringBuilder)localObject1).toString());
    }
    if ((str != null) && (str.lastIndexOf(".rename") > 0))
    {
      Object localObject2 = str.replace(".rename", "");
      localObject1 = ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf("."));
      localObject2 = ((String)localObject2).substring(((String)localObject2).lastIndexOf(".")).replaceAll("[0-9]*", "").replace("(", "").replace(")", "");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append((String)localObject2);
      localObject1 = localStringBuilder.toString();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("file maybe renmaed,realName[");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("]");
        QLog.i("<FileAssistant>FileViewerFacade", 2, ((StringBuilder)localObject2).toString());
      }
      FMDialogUtil.a(paramActivity, paramActivity.getString(2131889816), 2131889803, new FileViewerFacade.1((String)localObject1, str, paramFileManagerEntity, paramQQAppInterface, paramActivity, paramIFileBrowser));
      return;
    }
    if ((paramFileManagerEntity.nFileType == 5) && ((paramFileManagerEntity.isZipInnerFile) || (paramFileManagerEntity.nOpType == 190)))
    {
      FMDialogUtil.a(paramActivity, paramActivity.getString(2131889816), 2131889782, new FileViewerFacade.2(paramActivity, paramFileManagerEntity));
      return;
    }
    FileManagerUtil.b(paramActivity, paramFileManagerEntity.getFilePath());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileviewer.base.FileViewerFacade
 * JD-Core Version:    0.7.0.1
 */