package com.tencent.mobileqq.filemanager.openbrowser;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewerAdapterBase;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RecentMediaFileBrowseProcessor
  extends MediaFileBrowseProcessorBase
{
  public RecentMediaFileBrowseProcessor(QQAppInterface paramQQAppInterface, String paramString, FileManagerEntity paramFileManagerEntity)
  {
    super(paramQQAppInterface);
    Iterator localIterator = paramQQAppInterface.getFileManagerProxy().b().iterator();
    int j = 0;
    int i = 0;
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (((paramString == null) || (paramString.equals(localFileManagerEntity.peerUin))) && (a(localFileManagerEntity.nFileType, localFileManagerEntity.getCloudType())))
      {
        int k = j;
        if (j == 0)
        {
          k = j;
          if (localFileManagerEntity.nSessionId == paramFileManagerEntity.nSessionId)
          {
            this.jdField_a_of_type_Int = i;
            k = 1;
          }
        }
        if ((localFileManagerEntity.nFileType == 2) && (!FileUtils.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath())))
        {
          if ((localFileManagerEntity.isSend()) && (localFileManagerEntity.status != 1) && (localFileManagerEntity.status != -1))
          {
            j = k;
            continue;
          }
          if ((paramFileManagerEntity.peerType != 0) && (paramFileManagerEntity.peerType != 3000))
          {
            j = k;
            continue;
          }
        }
        this.jdField_a_of_type_JavaUtilList.add(a(i, localFileManagerEntity));
        IFileViewerAdapter localIFileViewerAdapter = FileViewerAdapterBase.a(paramQQAppInterface, localFileManagerEntity);
        this.jdField_a_of_type_JavaUtilMap.put(String.valueOf(localFileManagerEntity.nSessionId), Integer.valueOf(i));
        this.b.add(localIFileViewerAdapter);
        i += 1;
        j = k;
      }
    }
    b();
  }
  
  public RecentMediaFileBrowseProcessor(QQAppInterface paramQQAppInterface, List<WeiYunFileInfo> paramList, WeiYunFileInfo paramWeiYunFileInfo)
  {
    super(paramQQAppInterface);
    paramList = paramList.iterator();
    int i = 0;
    label18:
    int k;
    for (int j = 0; paramList.hasNext(); j = k)
    {
      Object localObject = (WeiYunFileInfo)paramList.next();
      k = FileManagerUtil.a(((WeiYunFileInfo)localObject).c);
      if ((k != 0) && (k != 2) && ((!((WeiYunFileInfo)localObject).jdField_a_of_type_Boolean) || (!((WeiYunFileInfo)localObject).c.toLowerCase().endsWith("heic")))) {
        break label18;
      }
      k = j;
      if (j == 0)
      {
        k = j;
        if (((WeiYunFileInfo)localObject).jdField_a_of_type_JavaLangString != null)
        {
          k = j;
          if (((WeiYunFileInfo)localObject).jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramWeiYunFileInfo.jdField_a_of_type_JavaLangString))
          {
            this.jdField_a_of_type_Int = i;
            k = 1;
          }
        }
      }
      localObject = FileViewerAdapterBase.a(paramQQAppInterface, (WeiYunFileInfo)localObject);
      this.jdField_a_of_type_JavaUtilList.add(a(i, (IFileViewerAdapter)localObject));
      this.jdField_a_of_type_JavaUtilMap.put(String.valueOf(((IFileViewerAdapter)localObject).a()), Integer.valueOf(i));
      this.b.add(localObject);
      i += 1;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.openbrowser.RecentMediaFileBrowseProcessor
 * JD-Core Version:    0.7.0.1
 */