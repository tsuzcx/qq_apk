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
  private QQAppInterface a;
  private int b = 0;
  private int c = 1;
  private Bundle d;
  private ChatFileManagerSearchEngine.SearchRunnable e = new ChatFileManagerSearchEngine.SearchRunnable(this, null);
  
  public ChatFileManagerSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.a = paramQQAppInterface;
    this.b = paramInt;
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
    int i = this.c;
    Object localObject1;
    Object localObject2;
    Object localObject4;
    Object localObject3;
    if (i == 1)
    {
      localObject1 = this.a.getFileManagerDataCenter().e(paramSearchRequest.a);
      localObject2 = ((Map)localObject1).keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (String)((Iterator)localObject2).next();
        localObject3 = new ChatFileEntitySearchResultModel();
        ((ChatFileEntitySearchResultModel)localObject3).a.addAll((Collection)((Map)localObject1).get(localObject4));
        ((ChatFileEntitySearchResultModel)localObject3).b = paramSearchRequest.a;
        ((ChatFileEntitySearchResultModel)localObject3).e = this.b;
        localObject4 = this.d;
        if (localObject4 != null) {
          ((ChatFileEntitySearchResultModel)localObject3).f = ((Bundle)localObject4).getString("qfile_search_param_uin", "");
        }
        localArrayList1.add(localObject3);
      }
    }
    ArrayList localArrayList2;
    if (i == 4)
    {
      localObject1 = this.d;
      if (localObject1 != null)
      {
        i = ((Bundle)localObject1).getInt("qfile_search_param_type", -1);
        localObject2 = this.d.getString("qfile_search_param_uin", "");
        localObject1 = this.d.getIntegerArrayList("qfile_search_param_others");
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
            localObject1 = this.a.getFileManagerDataCenter().b((List)localObject1, (String)localObject2);
          }
          else
          {
            localObject1 = this.a.getFileManagerDataCenter().a(a(i), (String)localObject2);
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
              ((ChatFileEntitySearchResultModel)localObject4).a.addAll(localArrayList2);
              ((ChatFileEntitySearchResultModel)localObject4).b = paramSearchRequest.a;
              ((ChatFileEntitySearchResultModel)localObject4).e = this.b;
              ((ChatFileEntitySearchResultModel)localObject4).f = ((String)localObject2);
              localArrayList1.add(localObject4);
            }
          }
        }
      }
    }
    else if (i == 3)
    {
      localObject1 = this.d;
      if (localObject1 != null)
      {
        localObject1 = ((Bundle)localObject1).getString("qfile_search_param_uin", "");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = this.a.getFileManagerDataCenter().a(paramSearchRequest.a, (String)localObject1, false).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (FileManagerEntity)((Iterator)localObject2).next();
            localObject4 = new ChatFileEntitySearchResultModel();
            localArrayList2 = new ArrayList(1);
            localArrayList2.add(localObject3);
            ((ChatFileEntitySearchResultModel)localObject4).a.addAll(localArrayList2);
            ((ChatFileEntitySearchResultModel)localObject4).b = paramSearchRequest.a;
            ((ChatFileEntitySearchResultModel)localObject4).e = this.b;
            ((ChatFileEntitySearchResultModel)localObject4).f = ((String)localObject1);
            localArrayList1.add(localObject4);
          }
        }
      }
    }
    return localArrayList1;
  }
  
  public void a()
  {
    this.a.getFileManagerProxy().init();
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    this.c = paramInt;
    this.d = paramBundle;
  }
  
  public void a(SearchRequest paramSearchRequest, ISearchListener<ChatFileEntitySearchResultModel> paramISearchListener)
  {
    if ((paramSearchRequest != null) && (paramSearchRequest.a != null))
    {
      if (TextUtils.isEmpty(paramSearchRequest.a.trim())) {
        return;
      }
      synchronized (this.e)
      {
        this.e.a = paramSearchRequest;
        this.e.b = paramISearchListener;
        ThreadManager.removeJobFromThreadPool(this.e, 64);
        ThreadManager.executeOnFileThread(this.e);
        return;
      }
    }
  }
  
  public void b()
  {
    synchronized (this.e)
    {
      this.e.a = null;
      this.e.b = null;
      ThreadManager.removeJobFromThreadPool(this.e, 64);
      return;
    }
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.ChatFileManagerSearchEngine
 * JD-Core Version:    0.7.0.1
 */