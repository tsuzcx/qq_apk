package com.tencent.mobileqq.search.business.contact.model;

import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.IMessageFacadeFetcher;
import com.tencent.mobileqq.search.api.ISearchReportFetcher;
import com.tencent.mobileqq.search.api.ISearchUtilFetcher;
import com.tencent.mobileqq.search.base.util.SearchConfigManager;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.search.model.SearchMatchResult;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public abstract class IContactSearchModel
  extends ISearchResultPositionModel
  implements Cloneable
{
  public static final String l = "IContactSearchModel";
  private long a = -1L;
  private long b;
  private CharSequence c;
  private String d;
  private String e;
  public AppInterface m;
  protected int n;
  protected long o;
  protected String p;
  public SearchMatchResult q;
  public boolean r;
  protected CharSequence s;
  protected String t;
  protected String u;
  public HashMap<String, String> v;
  
  public IContactSearchModel(AppInterface paramAppInterface, int paramInt, long paramLong)
  {
    this.m = paramAppInterface;
    this.n = paramInt;
    this.o = paramLong;
  }
  
  public void a(View paramView)
  {
    ((ISearchReportFetcher)QRoute.api(ISearchReportFetcher.class)).onActionContactSearchModel(this, paramView, g(), this.n, l);
  }
  
  public SearchMatchResult b(String paramString)
  {
    return null;
  }
  
  public abstract String c();
  
  public void c(String paramString)
  {
    this.p = paramString;
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public final long d(String paramString)
  {
    long l2 = n_(paramString);
    long l1 = l2;
    if (l2 != -9223372036854775808L)
    {
      l1 = l2;
      if (p()) {
        l1 = l2 + (this.o << SearchConfigManager.contactSearchRecentBaseBit);
      }
    }
    this.b = l1;
    return l1;
  }
  
  public CharSequence d()
  {
    Object localObject = m();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if ((!((String)localObject).equals(this.e)) || (!TextUtils.equals(this.d, g())))
      {
        this.e = ((String)localObject);
        this.d = g();
        if ((this.r) && (this.q != null)) {
          this.c = ((ISearchUtilFetcher)QRoute.api(ISearchUtilFetcher.class)).getHighLightApproximateMatchedMessageForMainTitle(this.m, (String)localObject, g(), this.q);
        } else {
          this.c = ((ISearchUtilFetcher)QRoute.api(ISearchUtilFetcher.class)).getHighLightMatchedMessageForMainTitle(this.m, (String)localObject, g());
        }
      }
      localObject = this.c;
      if (localObject != null) {
        return localObject;
      }
      return "";
    }
    if (QLog.isColorLevel()) {
      QLog.d(l, 2, "getTitle str is null");
    }
    this.e = null;
    return "";
  }
  
  public long dk_()
  {
    if (this.a == -1L)
    {
      Message localMessage = ((IMessageFacadeFetcher)QRoute.api(IMessageFacadeFetcher.class)).getLastMessage(c(), j());
      if (localMessage != null) {
        this.a = localMessage.time;
      } else {
        this.a = 0L;
      }
    }
    return this.a;
  }
  
  public CharSequence e()
  {
    String str = n();
    if (!TextUtils.isEmpty(str))
    {
      if ((!str.equals(this.u)) || (!TextUtils.equals(this.t, g())))
      {
        this.u = str;
        this.t = g();
        if ((this.r) && (this.q != null)) {
          this.s = ((ISearchUtilFetcher)QRoute.api(ISearchUtilFetcher.class)).getMessageWithParenthese(((ISearchUtilFetcher)QRoute.api(ISearchUtilFetcher.class)).getHighLightApproximateMatchedMessageForMainTitle(this.m, str, g(), this.q));
        } else {
          this.s = ((ISearchUtilFetcher)QRoute.api(ISearchUtilFetcher.class)).getMessageWithParenthese(((ISearchUtilFetcher)QRoute.api(ISearchUtilFetcher.class)).getHighLightMatchedMessage(str, g()));
        }
      }
      return this.s;
    }
    this.u = null;
    return null;
  }
  
  public abstract Object i();
  
  public abstract int j();
  
  public abstract String m();
  
  public abstract String n();
  
  protected abstract long n_(String paramString);
  
  public int o()
  {
    return 0;
  }
  
  protected boolean p()
  {
    return true;
  }
  
  public CharSequence q()
  {
    return d();
  }
  
  public final long u()
  {
    return this.b;
  }
  
  public SearchMatchResult v()
  {
    return this.q;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.model.IContactSearchModel
 * JD-Core Version:    0.7.0.1
 */