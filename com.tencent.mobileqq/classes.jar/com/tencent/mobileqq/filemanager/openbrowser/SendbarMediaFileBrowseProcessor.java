package com.tencent.mobileqq.filemanager.openbrowser;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewerAdapterBase;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SendbarMediaFileBrowseProcessor
  extends MediaFileBrowseProcessorBase
{
  private final Map<String, Integer> b;
  
  public SendbarMediaFileBrowseProcessor(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    b(0);
    c(this.jdField_a_of_type_JavaUtilList.size());
    d(this.jdField_a_of_type_JavaUtilList.size());
    b();
  }
  
  private void b(int paramInt)
  {
    Iterator localIterator = ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getRecentFiles().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (FileManagerEntity)localIterator.next();
      if (((FileManagerEntity)localObject).nFileType == 0)
      {
        localObject = FileViewerAdapterBase.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
        this.jdField_a_of_type_JavaUtilList.add(a(paramInt, (IFileViewerAdapter)localObject));
        this.jdField_b_of_type_JavaUtilMap.put(String.valueOf(((IFileViewerAdapter)localObject).a()), Integer.valueOf(paramInt));
        this.jdField_b_of_type_JavaUtilList.add(localObject);
        paramInt += 1;
      }
    }
  }
  
  private void c(int paramInt)
  {
    Iterator localIterator = ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getLocalFiles().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (FileInfo)localIterator.next();
      if (((FileInfo)localObject).a() == 0)
      {
        localObject = FileViewerAdapterBase.a((FileInfo)localObject);
        this.jdField_a_of_type_JavaUtilList.add(a(paramInt, (IFileViewerAdapter)localObject));
        this.jdField_b_of_type_JavaUtilList.add(localObject);
        paramInt += 1;
      }
    }
  }
  
  private void d(int paramInt)
  {
    Iterator localIterator = ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getWeiYunFiles().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (WeiYunFileInfo)localIterator.next();
      if (FileManagerUtil.a(((WeiYunFileInfo)localObject).c) == 0)
      {
        localObject = FileViewerAdapterBase.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (WeiYunFileInfo)localObject);
        this.jdField_b_of_type_JavaUtilMap.put(String.valueOf(((IFileViewerAdapter)localObject).a()), Integer.valueOf(paramInt));
        this.jdField_a_of_type_JavaUtilList.add(a(paramInt, (IFileViewerAdapter)localObject));
        this.jdField_b_of_type_JavaUtilList.add(localObject);
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.openbrowser.SendbarMediaFileBrowseProcessor
 * JD-Core Version:    0.7.0.1
 */