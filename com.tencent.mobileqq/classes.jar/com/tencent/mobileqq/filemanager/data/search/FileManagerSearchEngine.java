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
  QQAppInterface a;
  int b = -1;
  private FileManagerSearchEngine.SearchRunnable c = new FileManagerSearchEngine.SearchRunnable(this, null);
  
  public FileManagerSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.a = paramQQAppInterface;
    this.b = paramInt;
  }
  
  public List<FileEntitySearchResultModel> a(SearchRequest paramSearchRequest)
  {
    Map localMap = this.a.getFileManagerDataCenter().e(paramSearchRequest.a);
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
        i = this.b;
        if (i == 1) {
          ReportController.b(this.a, "dc00898", "", "", "0X800A083", "0X800A083", 0, 0, "", "", "", "");
        } else if (i == 8) {
          ReportController.b(this.a, "dc00898", "", "", "0X800A085", "0X800A085", 0, 0, "", "", "", "");
        }
      }
      localFileEntitySearchResultModel.a.addAll((Collection)localObject);
      localFileEntitySearchResultModel.b = paramSearchRequest.a;
      localFileEntitySearchResultModel.e = this.b;
      localArrayList.add(localFileEntitySearchResultModel);
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.a.getFileManagerProxy().init();
  }
  
  public void a(SearchRequest paramSearchRequest, ISearchListener<FileEntitySearchResultModel> paramISearchListener)
  {
    if ((paramSearchRequest != null) && (paramSearchRequest.a != null))
    {
      if (TextUtils.isEmpty(paramSearchRequest.a.trim())) {
        return;
      }
      synchronized (this.c)
      {
        this.c.a = paramSearchRequest;
        this.c.b = paramISearchListener;
        ThreadManager.removeJobFromThreadPool(this.c, 64);
        ThreadManager.executeOnFileThread(this.c);
        return;
      }
    }
  }
  
  public void b()
  {
    synchronized (this.c)
    {
      this.c.a = null;
      this.c.b = null;
      ThreadManager.removeJobFromThreadPool(this.c, 64);
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