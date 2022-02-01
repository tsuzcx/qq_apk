package com.tencent.mobileqq.filemanager.data.search;

import android.text.TextUtils;
import atup;
import atzd;
import atzt;
import bcmc;
import bcmd;
import bcmq;
import bdll;
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
  implements bcmc<atzt>
{
  int jdField_a_of_type_Int = -1;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FileManagerSearchEngine.SearchRunnable jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable = new FileManagerSearchEngine.SearchRunnable(this, null);
  
  public FileManagerSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public List<atzt> a(bcmq parambcmq)
  {
    Map localMap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(parambcmq.jdField_a_of_type_JavaLangString);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = localMap.keySet().iterator();
    Object localObject;
    atzt localatzt;
    if (localIterator1.hasNext())
    {
      localObject = (String)localIterator1.next();
      localatzt = new atzt();
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
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A083", "0X800A083", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        localatzt.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
        localatzt.jdField_a_of_type_JavaLangString = parambcmq.jdField_a_of_type_JavaLangString;
        localatzt.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        localArrayList.add(localatzt);
        break;
        label203:
        if (this.jdField_a_of_type_Int == 8) {
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A085", "0X800A085", 0, 0, "", "", "", "");
        }
      }
      return localArrayList;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
  }
  
  public void a(bcmq parambcmq, bcmd<atzt> parambcmd)
  {
    if ((parambcmq == null) || (parambcmq.jdField_a_of_type_JavaLangString == null) || (TextUtils.isEmpty(parambcmq.jdField_a_of_type_JavaLangString.trim()))) {
      return;
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable.jdField_a_of_type_Bcmq = parambcmq;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable.jdField_a_of_type_Bcmd = parambcmd;
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable, 64);
      ThreadManager.executeOnFileThread(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable);
      return;
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable.jdField_a_of_type_Bcmq = null;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable.jdField_a_of_type_Bcmd = null;
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