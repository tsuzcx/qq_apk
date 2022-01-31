package com.tencent.mobileqq.filemanager.data.search;

import android.os.Bundle;
import android.text.TextUtils;
import aqwl;
import arby;
import arcl;
import ayug;
import ayuh;
import ayuu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ChatFileManagerSearchEngine
  implements ayug<arcl>
{
  private int jdField_a_of_type_Int = 0;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ChatFileManagerSearchEngine.SearchRunnable jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchChatFileManagerSearchEngine$SearchRunnable = new ChatFileManagerSearchEngine.SearchRunnable(this, null);
  private int b = 1;
  
  public ChatFileManagerSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private List<Integer> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 3)
    {
      localArrayList.add(Integer.valueOf(9));
      localArrayList.add(Integer.valueOf(7));
      localArrayList.add(Integer.valueOf(6));
      localArrayList.add(Integer.valueOf(3));
      return localArrayList;
    }
    localArrayList.add(Integer.valueOf(paramInt));
    return localArrayList;
  }
  
  public List<arcl> a(ayuu paramayuu)
  {
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    arcl localarcl;
    if (this.b == 1)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramayuu.jdField_a_of_type_JavaLangString);
      localObject2 = ((Map)localObject1).keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localarcl = new arcl();
        localarcl.jdField_a_of_type_JavaUtilList.addAll((Collection)((Map)localObject1).get(localObject3));
        localarcl.jdField_a_of_type_JavaLangString = paramayuu.jdField_a_of_type_JavaLangString;
        localarcl.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        if (this.jdField_a_of_type_AndroidOsBundle != null) {
          localarcl.b = this.jdField_a_of_type_AndroidOsBundle.getString("qfile_search_param_uin", "");
        }
        localArrayList1.add(localarcl);
      }
    }
    ArrayList localArrayList2;
    if (this.b == 4)
    {
      if (this.jdField_a_of_type_AndroidOsBundle != null)
      {
        int i = this.jdField_a_of_type_AndroidOsBundle.getInt("qfile_search_param_type", -1);
        localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("qfile_search_param_uin", "");
        localObject1 = this.jdField_a_of_type_AndroidOsBundle.getIntegerArrayList("qfile_search_param_others");
        if ((i != -1) && (!TextUtils.isEmpty((CharSequence)localObject2)))
        {
          if (i == 11) {
            if (((List)localObject1).contains(Integer.valueOf(3)))
            {
              ((List)localObject1).add(Integer.valueOf(6));
              ((List)localObject1).add(Integer.valueOf(7));
              ((List)localObject1).add(Integer.valueOf(9));
            }
          }
          for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((List)localObject1, (String)localObject2); localObject1 != null; localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(a(i), (String)localObject2))
          {
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (FileManagerEntity)((Iterator)localObject1).next();
              localarcl = new arcl();
              localArrayList2 = new ArrayList(1);
              localArrayList2.add(localObject3);
              localarcl.jdField_a_of_type_JavaUtilList.addAll(localArrayList2);
              localarcl.jdField_a_of_type_JavaLangString = paramayuu.jdField_a_of_type_JavaLangString;
              localarcl.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
              localarcl.b = ((String)localObject2);
              localArrayList1.add(localarcl);
            }
          }
        }
      }
    }
    else if ((this.b == 3) && (this.jdField_a_of_type_AndroidOsBundle != null))
    {
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("qfile_search_param_uin", "");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramayuu.jdField_a_of_type_JavaLangString, (String)localObject1, false).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (FileManagerEntity)((Iterator)localObject2).next();
          localarcl = new arcl();
          localArrayList2 = new ArrayList(1);
          localArrayList2.add(localObject3);
          localarcl.jdField_a_of_type_JavaUtilList.addAll(localArrayList2);
          localarcl.jdField_a_of_type_JavaLangString = paramayuu.jdField_a_of_type_JavaLangString;
          localarcl.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
          localarcl.b = ((String)localObject1);
          localArrayList1.add(localarcl);
        }
      }
    }
    return localArrayList1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    this.b = paramInt;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(ayuu paramayuu, ayuh<arcl> paramayuh)
  {
    if ((paramayuu == null) || (paramayuu.jdField_a_of_type_JavaLangString == null) || (TextUtils.isEmpty(paramayuu.jdField_a_of_type_JavaLangString.trim()))) {
      return;
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchChatFileManagerSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchChatFileManagerSearchEngine$SearchRunnable.jdField_a_of_type_Ayuu = paramayuu;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchChatFileManagerSearchEngine$SearchRunnable.jdField_a_of_type_Ayuh = paramayuh;
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchChatFileManagerSearchEngine$SearchRunnable, 64);
      ThreadManager.executeOnFileThread(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchChatFileManagerSearchEngine$SearchRunnable);
      return;
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchChatFileManagerSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchChatFileManagerSearchEngine$SearchRunnable.jdField_a_of_type_Ayuu = null;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchChatFileManagerSearchEngine$SearchRunnable.jdField_a_of_type_Ayuh = null;
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchChatFileManagerSearchEngine$SearchRunnable, 64);
      return;
    }
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.ChatFileManagerSearchEngine
 * JD-Core Version:    0.7.0.1
 */