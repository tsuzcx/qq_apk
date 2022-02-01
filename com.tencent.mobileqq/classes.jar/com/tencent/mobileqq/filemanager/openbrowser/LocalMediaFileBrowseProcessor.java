package com.tencent.mobileqq.filemanager.openbrowser;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewerAdapterBase;
import java.util.Iterator;
import java.util.List;

public class LocalMediaFileBrowseProcessor
  extends MediaFileBrowseProcessorBase
{
  public LocalMediaFileBrowseProcessor(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilList.add(a(0, paramFileManagerEntity));
    paramQQAppInterface = FileViewerAdapterBase.a(paramQQAppInterface, paramFileManagerEntity);
    this.b.add(paramQQAppInterface);
  }
  
  public LocalMediaFileBrowseProcessor(QQAppInterface paramQQAppInterface, List<FileInfo> paramList, FileInfo paramFileInfo)
  {
    super(paramQQAppInterface);
    paramQQAppInterface = paramList.iterator();
    int j = 0;
    int i = 0;
    while (paramQQAppInterface.hasNext())
    {
      paramList = (FileInfo)paramQQAppInterface.next();
      if (a(paramList.a(), 3))
      {
        int k = j;
        if (j == 0)
        {
          k = j;
          if (paramList.d().equals(paramFileInfo.d()))
          {
            k = j;
            if (paramList.a() == paramFileInfo.a())
            {
              k = j;
              if (paramList.b() == paramFileInfo.b())
              {
                this.jdField_a_of_type_Int = i;
                k = 1;
              }
            }
          }
        }
        this.jdField_a_of_type_JavaUtilList.add(a(i, paramList));
        paramList = FileViewerAdapterBase.a(paramList);
        this.b.add(paramList);
        i += 1;
        j = k;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.openbrowser.LocalMediaFileBrowseProcessor
 * JD-Core Version:    0.7.0.1
 */