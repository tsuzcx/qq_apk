package com.tencent.mobileqq.guild.chatpie.quickAt.search;

import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.chatpie.quickAt.GuildAtListHelper;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SearchSession
{
  private final QQAppInterface a;
  private final String b;
  private final LruCache<String, SearchContext> c = new LruCache(10);
  private SearchContext d;
  private boolean e;
  private final SearchSession.SearchResultListener f;
  private final List<IGProUserInfo> g = new ArrayList();
  private boolean h;
  
  public SearchSession(QQAppInterface paramQQAppInterface, SearchSession.SearchResultListener paramSearchResultListener)
  {
    this.a = paramQQAppInterface;
    this.f = paramSearchResultListener;
    this.b = ((IGPSService)this.a.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
  }
  
  private void a(SearchContext paramSearchContext)
  {
    String str = paramSearchContext.a();
    SearchContext localSearchContext = (SearchContext)this.c.get(str);
    if ((localSearchContext != null) && (localSearchContext.f()))
    {
      this.d = localSearchContext;
      b(localSearchContext);
      return;
    }
    this.c.put(str, paramSearchContext);
    this.d = paramSearchContext;
    paramSearchContext.a(new -..Lambda.SearchSession.ihRdK2oeaO57FaDESKZFyAz4I3g(this));
  }
  
  private void a(Throwable paramThrowable)
  {
    if (!(paramThrowable instanceof SearchException)) {
      return;
    }
    paramThrowable = (SearchException)paramThrowable;
    SearchContext localSearchContext = paramThrowable.context;
    if (!this.e)
    {
      if (localSearchContext.e()) {
        return;
      }
      Object localObject = this.d;
      if (localObject != null)
      {
        if (localObject != localSearchContext) {
          return;
        }
        localObject = localSearchContext.b();
        String str = paramThrowable.errMsg;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("search ");
        localStringBuilder.append(localSearchContext.a());
        localStringBuilder.append(" error=");
        localStringBuilder.append(paramThrowable.toString());
        QLog.w("SearchSession", 1, localStringBuilder.toString());
        this.f.a((String)localObject, str);
      }
    }
  }
  
  private void a(List<IGProUserInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      IGProUserInfo localIGProUserInfo = (IGProUserInfo)paramList.next();
      if (this.b.equals(localIGProUserInfo.a()))
      {
        int i = localIGProUserInfo.d();
        boolean bool2 = true;
        boolean bool1 = bool2;
        if (i != 1) {
          if (localIGProUserInfo.d() == 2) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
        }
        this.h = bool1;
      }
    }
  }
  
  private static List<IGProUserInfo> b(List<IGProUserInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      IGProUserInfo localIGProUserInfo = (IGProUserInfo)paramList.next();
      if ((localIGProUserInfo.d() == 1) || (localIGProUserInfo.d() == 2)) {
        localArrayList.add(localIGProUserInfo);
      }
    }
    return localArrayList;
  }
  
  private void b(SearchContext paramSearchContext)
  {
    if (!this.e)
    {
      if (paramSearchContext.e()) {
        return;
      }
      a(paramSearchContext.c());
      Object localObject = this.d;
      int i;
      if ((localObject != null) && (!TextUtils.isEmpty(((SearchContext)localObject).b()))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0)
      {
        localObject = paramSearchContext.c();
        if ((paramSearchContext instanceof GuildUserFetcher)) {
          c(b((List)localObject));
        } else {
          c((List)localObject);
        }
        b(paramSearchContext.b(), this.g);
        return;
      }
      if (this.d != paramSearchContext) {
        return;
      }
      b(paramSearchContext.b(), paramSearchContext.c());
    }
  }
  
  private void b(String paramString, List<IGProUserInfo> paramList)
  {
    paramList = new ArrayList(paramList);
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      IGProUserInfo localIGProUserInfo = (IGProUserInfo)localIterator.next();
      if (localHashSet.contains(localIGProUserInfo.a())) {
        localIterator.remove();
      } else {
        localHashSet.add(localIGProUserInfo.a());
      }
    }
    if (this.h) {
      paramList.add(0, GuildAtListHelper.b());
    }
    this.f.a(paramString, paramList);
  }
  
  private void c(List<IGProUserInfo> paramList)
  {
    paramList = new ArrayList(paramList);
    int j = this.g.size();
    int i = 0;
    while (i < j)
    {
      IGProUserInfo localIGProUserInfo1 = (IGProUserInfo)this.g.get(i);
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        IGProUserInfo localIGProUserInfo2 = (IGProUserInfo)localIterator.next();
        if (localIGProUserInfo1.a().equals(localIGProUserInfo2.a()))
        {
          this.g.set(i, localIGProUserInfo2);
          localIterator.remove();
        }
      }
      i += 1;
    }
    this.g.addAll(paramList);
  }
  
  public void a()
  {
    this.e = true;
    this.c.evictAll();
    this.d = null;
  }
  
  public void a(@NonNull String paramString)
  {
    a(new GuildUserFetcher(this.a, paramString));
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2)
  {
    a(new GuildMemberSearch(this.a, paramString1, paramString2));
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3)
  {
    a(new VisibleMemberSearch(this.a, paramString1, paramString2, paramString3));
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2, @NonNull List<String> paramList)
  {
    a(new VisibleMemberFetcher(this.a, paramString1, paramString2, paramList));
  }
  
  public void a(@NonNull String paramString, @NonNull List<String> paramList)
  {
    a(new GuildUserLoader(this.a, paramString, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.quickAt.search.SearchSession
 * JD-Core Version:    0.7.0.1
 */