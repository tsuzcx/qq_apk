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
    this.b.add(a(0, paramFileManagerEntity));
    paramQQAppInterface = FileViewerAdapterBase.a(paramQQAppInterface, paramFileManagerEntity);
    this.e.add(paramQQAppInterface);
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
      if (a(paramList.l(), 3))
      {
        int k = j;
        if (j == 0)
        {
          k = j;
          if (paramList.e().equals(paramFileInfo.e()))
          {
            k = j;
            if (paramList.f() == paramFileInfo.f())
            {
              k = j;
              if (paramList.g() == paramFileInfo.g())
              {
                this.c = i;
                k = 1;
              }
            }
          }
        }
        this.b.add(a(i, paramList));
        paramList = FileViewerAdapterBase.a(paramList);
        this.e.add(paramList);
        i += 1;
        j = k;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.openbrowser.LocalMediaFileBrowseProcessor
 * JD-Core Version:    0.7.0.1
 */