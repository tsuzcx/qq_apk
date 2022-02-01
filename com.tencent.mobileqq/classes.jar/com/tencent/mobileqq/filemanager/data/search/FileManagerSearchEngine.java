package com.tencent.mobileqq.filemanager.data.search;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FileManagerSearchEngine
  implements ISearchEngine<FileEntitySearchResultModel>
{
  int jdField_a_of_type_Int = -1;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FileManagerSearchEngine.SearchRunnable jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable = new FileManagerSearchEngine.SearchRunnable(this, null);
  
  public FileManagerSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public List<FileEntitySearchResultModel> a(SearchRequest paramSearchRequest)
  {
    Map localMap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramSearchRequest.jdField_a_of_type_JavaLangString);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = localMap.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      FileEntitySearchResultModel localFileEntitySearchResultModel = new FileEntitySearchResultModel();
      localObject = (List)localMap.get(localObject);
      int j = 0;
      Iterator localIterator2 = ((List)localObject).iterator();
      do
      {
        i = j;
        if (!localIterator2.hasNext()) {
          break;
        }
      } while (((FileManagerEntity)localIterator2.next()).nFileType != 13);
      int i = 1;
      if (i != 0)
      {
        i = this.jdField_a_of_type_Int;
        if (i == 1) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A083", "0X800A083", 0, 0, "", "", "", "");
        } else if (i == 8) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A085", "0X800A085", 0, 0, "", "", "", "");
        }
      }
      localFileEntitySearchResultModel.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
      localFileEntitySearchResultModel.jdField_a_of_type_JavaLangString = paramSearchRequest.jdField_a_of_type_JavaLangString;
      localFileEntitySearchResultModel.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localArrayList.add(localFileEntitySearchResultModel);
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().init();
  }
  
  public void a(SearchRequest paramSearchRequest, ISearchListener<FileEntitySearchResultModel> paramISearchListener)
  {
    if ((paramSearchRequest != null) && (paramSearchRequest.jdField_a_of_type_JavaLangString != null))
    {
      if (TextUtils.isEmpty(paramSearchRequest.jdField_a_of_type_JavaLangString.trim())) {
        return;
      }
      synchronized (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest = paramSearchRequest;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener = paramISearchListener;
        ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable, 64);
        ThreadManager.executeOnFileThread(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable);
        return;
      }
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest = null;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener = null;
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable, 64);
      return;
    }
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileManagerSearchEngine
 * JD-Core Version:    0.7.0.1
 */