package cooperation.qqfav.globalsearch;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.FunctionModuleConfigManager;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class FunctionSearchEngine
  implements ISearchEngine<GroupBaseNetSearchModelItem>
{
  public static final String a = "FunctionSearchEngine";
  protected QQAppInterface b;
  protected FunctionSearchEngine.SearchRunnable c = new FunctionSearchEngine.1(this);
  private int d = -1;
  
  public FunctionSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.b = paramQQAppInterface;
    this.d = paramInt;
  }
  
  public List<GroupBaseNetSearchModelItem> a(SearchRequest paramSearchRequest)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramSearchRequest != null)
    {
      localObject1 = localObject2;
      if (paramSearchRequest.a != null)
      {
        if (paramSearchRequest.a.trim().length() == 0) {
          return null;
        }
        localObject1 = this.b;
        if (localObject1 == null)
        {
          QLog.e(a, 1, "search, app is null.");
          return null;
        }
        localObject1 = (FunctionModuleConfigManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.FUNCTION_MODULE_MANAGER);
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(paramSearchRequest.a);
        localObject3 = ((FunctionModuleConfigManager)localObject1).a(((StringBuilder)localObject3).toString(), this.d);
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          if (((List)localObject3).size() == 0) {
            return null;
          }
          paramSearchRequest = new ArrayList(((List)localObject3).size());
          int i = 0;
          for (;;)
          {
            localObject1 = paramSearchRequest;
            if (i >= ((List)localObject3).size()) {
              break;
            }
            paramSearchRequest.add((GroupBaseNetSearchModelItem)((List)localObject3).get(i));
            i += 1;
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a()
  {
    QQAppInterface localQQAppInterface = this.b;
    if (localQQAppInterface != null) {
      FunctionModuleConfigManager.a(localQQAppInterface);
    }
  }
  
  public void a(SearchRequest paramSearchRequest, ISearchListener<GroupBaseNetSearchModelItem> paramISearchListener)
  {
    if ((paramSearchRequest != null) && (paramSearchRequest.a != null))
    {
      if (paramSearchRequest.a.trim().length() == 0) {
        return;
      }
      synchronized (this.c)
      {
        this.c.a = paramSearchRequest;
        this.c.b = paramISearchListener;
        ThreadManager.removeJobFromThreadPool(this.c, 32);
        ThreadManager.excute(this.c, 32, null, false);
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
      ThreadManager.removeJobFromThreadPool(this.c, 32);
      return;
    }
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FunctionSearchEngine
 * JD-Core Version:    0.7.0.1
 */