package com.tencent.mobileqq.filemanager.data.search;

import android.text.TextUtils;
import aqwl;
import arby;
import arcp;
import ayug;
import ayuh;
import ayuu;
import azqs;
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
  implements ayug<arcp>
{
  int jdField_a_of_type_Int = -1;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FileManagerSearchEngine.SearchRunnable jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable = new FileManagerSearchEngine.SearchRunnable(this, null);
  
  public FileManagerSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public List<arcp> a(ayuu paramayuu)
  {
    Map localMap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramayuu.jdField_a_of_type_JavaLangString);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = localMap.keySet().iterator();
    Object localObject;
    arcp localarcp;
    if (localIterator1.hasNext())
    {
      localObject = (String)localIterator1.next();
      localarcp = new arcp();
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
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A083", "0X800A083", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        localarcp.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
        localarcp.jdField_a_of_type_JavaLangString = paramayuu.jdField_a_of_type_JavaLangString;
        localarcp.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        localArrayList.add(localarcp);
        break;
        label203:
        if (this.jdField_a_of_type_Int == 8) {
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A085", "0X800A085", 0, 0, "", "", "", "");
        }
      }
      return localArrayList;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
  }
  
  public void a(ayuu paramayuu, ayuh<arcp> paramayuh)
  {
    if ((paramayuu == null) || (paramayuu.jdField_a_of_type_JavaLangString == null) || (TextUtils.isEmpty(paramayuu.jdField_a_of_type_JavaLangString.trim()))) {
      return;
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable.jdField_a_of_type_Ayuu = paramayuu;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable.jdField_a_of_type_Ayuh = paramayuh;
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable, 64);
      ThreadManager.executeOnFileThread(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable);
      return;
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable.jdField_a_of_type_Ayuu = null;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable.jdField_a_of_type_Ayuh = null;
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine$SearchRunnable, 64);
      return;
    }
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileManagerSearchEngine
 * JD-Core Version:    0.7.0.1
 */