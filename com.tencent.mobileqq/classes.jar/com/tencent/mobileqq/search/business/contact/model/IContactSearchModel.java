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
  public static final String h = "IContactSearchModel";
  private long jdField_a_of_type_Long = -1L;
  public AppInterface a;
  public SearchMatchResult a;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private String jdField_a_of_type_JavaLangString;
  public HashMap<String, String> a;
  protected int b;
  private long jdField_b_of_type_Long;
  protected CharSequence b;
  private String jdField_b_of_type_JavaLangString;
  public boolean b;
  protected long c;
  protected String i;
  protected String j;
  protected String k;
  
  public IContactSearchModel(AppInterface paramAppInterface, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_b_of_type_Int = paramInt;
    this.c = paramLong;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Long == -1L)
    {
      Message localMessage = ((IMessageFacadeFetcher)QRoute.api(IMessageFacadeFetcher.class)).getLastMessage(a(), d());
      if (localMessage != null) {
        this.jdField_a_of_type_Long = localMessage.time;
      } else {
        this.jdField_a_of_type_Long = 0L;
      }
    }
    return this.jdField_a_of_type_Long;
  }
  
  protected abstract long a(String paramString);
  
  public SearchMatchResult a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSearchModelSearchMatchResult;
  }
  
  public SearchMatchResult a(String paramString)
  {
    return null;
  }
  
  public abstract Object a();
  
  public abstract String a();
  
  public void a(View paramView)
  {
    ((ISearchReportFetcher)QRoute.api(ISearchReportFetcher.class)).onActionContactSearchModel(this, paramView, b(), this.jdField_b_of_type_Int, h);
  }
  
  public void a(String paramString)
  {
    this.i = paramString;
  }
  
  public final long b()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public final long b(String paramString)
  {
    long l2 = a(paramString);
    long l1 = l2;
    if (l2 != -9223372036854775808L)
    {
      l1 = l2;
      if (b()) {
        l1 = l2 + (this.c << SearchConfigManager.contactSearchRecentBaseBit);
      }
    }
    this.jdField_b_of_type_Long = l1;
    return l1;
  }
  
  public CharSequence b()
  {
    Object localObject = c();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if ((!((String)localObject).equals(this.jdField_b_of_type_JavaLangString)) || (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, b())))
      {
        this.jdField_b_of_type_JavaLangString = ((String)localObject);
        this.jdField_a_of_type_JavaLangString = b();
        if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqSearchModelSearchMatchResult != null)) {
          this.jdField_a_of_type_JavaLangCharSequence = ((ISearchUtilFetcher)QRoute.api(ISearchUtilFetcher.class)).getHighLightApproximateMatchedMessageForMainTitle(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (String)localObject, b(), this.jdField_a_of_type_ComTencentMobileqqSearchModelSearchMatchResult);
        } else {
          this.jdField_a_of_type_JavaLangCharSequence = ((ISearchUtilFetcher)QRoute.api(ISearchUtilFetcher.class)).getHighLightMatchedMessageForMainTitle(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (String)localObject, b());
        }
      }
      localObject = this.jdField_a_of_type_JavaLangCharSequence;
      if (localObject != null) {
        return localObject;
      }
      return "";
    }
    if (QLog.isColorLevel()) {
      QLog.d(h, 2, "getTitle str is null");
    }
    this.jdField_b_of_type_JavaLangString = null;
    return "";
  }
  
  protected boolean b()
  {
    return true;
  }
  
  public CharSequence c()
  {
    String str = d();
    if (!TextUtils.isEmpty(str))
    {
      if ((!str.equals(this.k)) || (!TextUtils.equals(this.j, b())))
      {
        this.k = str;
        this.j = b();
        if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqSearchModelSearchMatchResult != null)) {
          this.jdField_b_of_type_JavaLangCharSequence = ((ISearchUtilFetcher)QRoute.api(ISearchUtilFetcher.class)).getMessageWithParenthese(((ISearchUtilFetcher)QRoute.api(ISearchUtilFetcher.class)).getHighLightApproximateMatchedMessageForMainTitle(this.jdField_a_of_type_ComTencentCommonAppAppInterface, str, b(), this.jdField_a_of_type_ComTencentMobileqqSearchModelSearchMatchResult));
        } else {
          this.jdField_b_of_type_JavaLangCharSequence = ((ISearchUtilFetcher)QRoute.api(ISearchUtilFetcher.class)).getMessageWithParenthese(((ISearchUtilFetcher)QRoute.api(ISearchUtilFetcher.class)).getHighLightMatchedMessage(str, b()));
        }
      }
      return this.jdField_b_of_type_JavaLangCharSequence;
    }
    this.k = null;
    return null;
  }
  
  public abstract String c();
  
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
  
  public abstract int d();
  
  public abstract String d();
  
  public int e()
  {
    return 0;
  }
  
  public CharSequence e()
  {
    return b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.model.IContactSearchModel
 * JD-Core Version:    0.7.0.1
 */