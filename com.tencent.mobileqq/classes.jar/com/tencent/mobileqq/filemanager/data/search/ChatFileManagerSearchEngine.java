package com.tencent.mobileqq.filemanager.data.search;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ChatFileManagerSearchEngine
  implements ISearchEngine<ChatFileEntitySearchResultModel>
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
  
  public List<ChatFileEntitySearchResultModel> a(SearchRequest paramSearchRequest)
  {
    ArrayList localArrayList1 = new ArrayList();
    int i = this.b;
    Object localObject1;
    Object localObject2;
    Object localObject4;
    Object localObject3;
    if (i == 1)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramSearchRequest.jdField_a_of_type_JavaLangString);
      localObject2 = ((Map)localObject1).keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (String)((Iterator)localObject2).next();
        localObject3 = new ChatFileEntitySearchResultModel();
        ((ChatFileEntitySearchResultModel)localObject3).jdField_a_of_type_JavaUtilList.addAll((Collection)((Map)localObject1).get(localObject4));
        ((ChatFileEntitySearchResultModel)localObject3).jdField_a_of_type_JavaLangString = paramSearchRequest.jdField_a_of_type_JavaLangString;
        ((ChatFileEntitySearchResultModel)localObject3).jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        localObject4 = this.jdField_a_of_type_AndroidOsBundle;
        if (localObject4 != null) {
          ((ChatFileEntitySearchResultModel)localObject3).b = ((Bundle)localObject4).getString("qfile_search_param_uin", "");
        }
        localArrayList1.add(localObject3);
      }
    }
    ArrayList localArrayList2;
    if (i == 4)
    {
      localObject1 = this.jdField_a_of_type_AndroidOsBundle;
      if (localObject1 != null)
      {
        i = ((Bundle)localObject1).getInt("qfile_search_param_type", -1);
        localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("qfile_search_param_uin", "");
        localObject1 = this.jdField_a_of_type_AndroidOsBundle.getIntegerArrayList("qfile_search_param_others");
        if ((i != -1) && (!TextUtils.isEmpty((CharSequence)localObject2)))
        {
          if (i == 11)
          {
            if (((List)localObject1).contains(Integer.valueOf(3)))
            {
              ((List)localObject1).add(Integer.valueOf(6));
              ((List)localObject1).add(Integer.valueOf(7));
              ((List)localObject1).add(Integer.valueOf(9));
            }
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().b((List)localObject1, (String)localObject2);
          }
          else
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(a(i), (String)localObject2);
          }
          if (localObject1 != null)
          {
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (FileManagerEntity)((Iterator)localObject1).next();
              localObject4 = new ChatFileEntitySearchResultModel();
              localArrayList2 = new ArrayList(1);
              localArrayList2.add(localObject3);
              ((ChatFileEntitySearchResultModel)localObject4).jdField_a_of_type_JavaUtilList.addAll(localArrayList2);
              ((ChatFileEntitySearchResultModel)localObject4).jdField_a_of_type_JavaLangString = paramSearchRequest.jdField_a_of_type_JavaLangString;
              ((ChatFileEntitySearchResultModel)localObject4).jdField_a_of_type_Int = this.jdField_a_of_type_Int;
              ((ChatFileEntitySearchResultModel)localObject4).b = ((String)localObject2);
              localArrayList1.add(localObject4);
            }
          }
        }
      }
    }
    else if (i == 3)
    {
      localObject1 = this.jdField_a_of_type_AndroidOsBundle;
      if (localObject1 != null)
      {
        localObject1 = ((Bundle)localObject1).getString("qfile_search_param_uin", "");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramSearchRequest.jdField_a_of_type_JavaLangString, (String)localObject1, false).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (FileManagerEntity)((Iterator)localObject2).next();
            localObject4 = new ChatFileEntitySearchResultModel();
            localArrayList2 = new ArrayList(1);
            localArrayList2.add(localObject3);
            ((ChatFileEntitySearchResultModel)localObject4).jdField_a_of_type_JavaUtilList.addAll(localArrayList2);
            ((ChatFileEntitySearchResultModel)localObject4).jdField_a_of_type_JavaLangString = paramSearchRequest.jdField_a_of_type_JavaLangString;
            ((ChatFileEntitySearchResultModel)localObject4).jdField_a_of_type_Int = this.jdField_a_of_type_Int;
            ((ChatFileEntitySearchResultModel)localObject4).b = ((String)localObject1);
            localArrayList1.add(localObject4);
          }
        }
      }
    }
    return localArrayList1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().init();
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    this.b = paramInt;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(SearchRequest paramSearchRequest, ISearchListener<ChatFileEntitySearchResultModel> paramISearchListener)
  {
    if ((paramSearchRequest != null) && (paramSearchRequest.jdField_a_of_type_JavaLangString != null))
    {
      if (TextUtils.isEmpty(paramSearchRequest.jdField_a_of_type_JavaLangString.trim())) {
        return;
      }
      synchronized (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchChatFileManagerSearchEngine$SearchRunnable)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchChatFileManagerSearchEngine$SearchRunnable.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest = paramSearchRequest;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchChatFileManagerSearchEngine$SearchRunnable.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener = paramISearchListener;
        ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchChatFileManagerSearchEngine$SearchRunnable, 64);
        ThreadManager.executeOnFileThread(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchChatFileManagerSearchEngine$SearchRunnable);
        return;
      }
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchChatFileManagerSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchChatFileManagerSearchEngine$SearchRunnable.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest = null;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchChatFileManagerSearchEngine$SearchRunnable.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener = null;
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchChatFileManagerSearchEngine$SearchRunnable, 64);
      return;
    }
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.ChatFileManagerSearchEngine
 * JD-Core Version:    0.7.0.1
 */