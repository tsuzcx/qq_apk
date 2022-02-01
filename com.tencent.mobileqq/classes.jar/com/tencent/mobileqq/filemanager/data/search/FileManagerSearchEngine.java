package com.tencent.mobileqq.filemanager.data.search;

import android.text.TextUtils;
import atlf;
import atpt;
import atqj;
import bclw;
import bclx;
import bcmk;
import bdla;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FileManagerSearchEngine
  implements bclw<atqj>
{
  int jdField_a_of_type_Int = -1;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FileManagerSearchEngine.SearchRunnable jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable = new FileManagerSearchEngine.SearchRunnable(this, null);
  
  public FileManagerSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public List<atqj> a(bcmk parambcmk)
  {
    Map localMap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(parambcmk.jdField_a_of_type_JavaLangString);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = localMap.keySet().iterator();
    Object localObject;
    atqj localatqj;
    if (localIterator1.hasNext())
    {
      localObject = (String)localIterator1.next();
      localatqj = new atqj();
      localObject = (List)localMap.get(localObject);
      Iterator localIterator2 = ((List)localObject).iterator();
      do
      {
        if (!localIterator2.hasNext()) {
          break;
        }
      } while (((FileManagerEntity)localIterator2.next()).nFileType != 13);
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (this.jdField_a_of_type_Int != 1) {
          break label203;
        }
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A083", "0X800A083", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        localatqj.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
        localatqj.jdField_a_of_type_JavaLangString = parambcmk.jdField_a_of_type_JavaLangString;
        localatqj.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        localArrayList.add(localatqj);
        break;
        label203:
        if (this.jdField_a_of_type_Int == 8) {
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A085", "0X800A085", 0, 0, "", "", "", "");
        }
      }
      return localArrayList;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a();
  }
  
  public void a(bcmk parambcmk, bclx<atqj> parambclx)
  {
    if ((parambcmk == null) || (parambcmk.jdField_a_of_type_JavaLangString == null) || (TextUtils.isEmpty(parambcmk.jdField_a_of_type_JavaLangString.trim()))) {
      return;
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable.jdField_a_of_type_Bcmk = parambcmk;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable.jdField_a_of_type_Bclx = parambclx;
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable, 64);
      ThreadManager.executeOnFileThread(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable);
      return;
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable.jdField_a_of_type_Bcmk = null;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable.jdField_a_of_type_Bclx = null;
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable, 64);
      return;
    }
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileManagerSearchEngine
 * JD-Core Version:    0.7.0.1
 */