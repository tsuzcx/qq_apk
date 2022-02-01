package com.tencent.mobileqq.search.model;

import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.SearchUtil.ObjectItemInfo;
import com.tencent.mobileqq.search.activity.ContactSearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.search.util.SearchMatchResult;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class IContactSearchModel
  extends ISearchResultPositionModel
  implements Cloneable
{
  public static final String h = IContactSearchModel.class.getSimpleName();
  private long jdField_a_of_type_Long = -1L;
  public QQAppInterface a;
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
  
  public IContactSearchModel(QQAppInterface paramQQAppInterface, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_Int = paramInt;
    this.c = paramLong;
  }
  
  public long a()
  {
    Message localMessage;
    if (this.jdField_a_of_type_Long == -1L)
    {
      localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(b(), d());
      if (localMessage == null) {
        break label47;
      }
    }
    label47:
    for (this.jdField_a_of_type_Long = localMessage.time;; this.jdField_a_of_type_Long = 0L) {
      return this.jdField_a_of_type_Long;
    }
  }
  
  protected abstract long a(String paramString);
  
  public SearchMatchResult a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSearchUtilSearchMatchResult;
  }
  
  public SearchMatchResult a(String paramString)
  {
    return null;
  }
  
  public CharSequence a()
  {
    String str = c();
    if (!TextUtils.isEmpty(str))
    {
      if ((!str.equals(this.jdField_b_of_type_JavaLangString)) || (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, a())))
      {
        this.jdField_b_of_type_JavaLangString = str;
        this.jdField_a_of_type_JavaLangString = a();
        if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqSearchUtilSearchMatchResult == null)) {
          break label98;
        }
      }
      label98:
      for (this.jdField_a_of_type_JavaLangCharSequence = SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, a(), 6, this.jdField_a_of_type_ComTencentMobileqqSearchUtilSearchMatchResult); this.jdField_a_of_type_JavaLangCharSequence != null; this.jdField_a_of_type_JavaLangCharSequence = SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, a(), 6)) {
        return this.jdField_a_of_type_JavaLangCharSequence;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(h, 2, "getTitle str is null");
    }
    this.jdField_b_of_type_JavaLangString = null;
    return "";
    return "";
  }
  
  public abstract Object a();
  
  public void a(View paramView)
  {
    Integer localInteger1;
    Integer localInteger2;
    SearchUtil.ObjectItemInfo localObjectItemInfo;
    QQAppInterface localQQAppInterface;
    JSONObject localJSONObject;
    if (SearchUtils.a(this.jdField_b_of_type_Int))
    {
      localInteger1 = (Integer)paramView.getTag(2131381652);
      localInteger2 = (Integer)paramView.getTag(2131381650);
      if (QLog.isColorLevel()) {
        QLog.i("Q.uniteSearch..ContectReport", 2, " view.getTag(R.id.view_tag_position) = " + localInteger1);
      }
      if (((paramView.getContext() instanceof UniteSearchActivity)) && (SearchUtil.b.containsKey(this)))
      {
        localObjectItemInfo = (SearchUtil.ObjectItemInfo)SearchUtil.b.get(this);
        localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        localJSONObject = new JSONObject();
      }
    }
    try
    {
      localJSONObject.put("project", UniteSearchReportController.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", localObjectItemInfo.jdField_a_of_type_Int);
      localJSONObject.put("get_src", "native");
      UniteSearchReportController.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(localObjectItemInfo.jdField_a_of_type_Long + "").obj2(localObjectItemInfo.jdField_b_of_type_JavaLangString).ver1(localObjectItemInfo.jdField_a_of_type_JavaLangString).ver2(UniteSearchReportController.a(this.jdField_b_of_type_Int)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + SearchUtil.jdField_a_of_type_Long));
      if (((paramView.getContext() instanceof UniteSearchActivity)) && (!(this instanceof PublicAccountSearchResultModel)) && (localInteger2.intValue() >= 0) && (localInteger1.intValue() >= 0))
      {
        SearchUtils.a("all_result", "clk_contact", new String[] { "" + a(), "" + localInteger2, "" + (localInteger1.intValue() + 1), "" + f() });
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      do
      {
        for (;;)
        {
          QLog.e(h, 2, "e = " + localJSONException);
        }
        if (((paramView.getContext() instanceof ContactSearchActivity)) && (!(this instanceof PublicAccountSearchResultModel)))
        {
          SearchUtils.a("contact", "clk_result", new String[] { "" + a(), "" + localInteger2, "" + (localInteger1.intValue() + 1), "" + f() });
          return;
        }
        if (((paramView.getContext() instanceof UniteSearchActivity)) && ((this instanceof PublicAccountSearchResultModel)))
        {
          SearchUtils.a("all_result", "clk_public_uin", new String[] { "" + a(), "" + localInteger2, "" + (localInteger1.intValue() + 1), "" + f() });
          return;
        }
      } while (((paramView.getContext() instanceof UniteSearchActivity)) || (!(this instanceof PublicAccountSearchResultModel)));
      SearchUtils.a("all_result", "clk_public_uin_page", new String[] { "" + a(), "" + localInteger2, "" + (localInteger1.intValue() + 1), "" + f() });
    }
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
    String str = d();
    if (!TextUtils.isEmpty(str))
    {
      if ((!str.equals(this.k)) || (!TextUtils.equals(this.j, a())))
      {
        this.k = str;
        this.j = a();
        if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqSearchUtilSearchMatchResult == null)) {
          break label94;
        }
      }
      label94:
      for (this.jdField_b_of_type_JavaLangCharSequence = SearchUtils.a(SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, a(), 6, this.jdField_a_of_type_ComTencentMobileqqSearchUtilSearchMatchResult));; this.jdField_b_of_type_JavaLangCharSequence = SearchUtils.a(SearchUtils.a(str, a(), 6))) {
        return this.jdField_b_of_type_JavaLangCharSequence;
      }
    }
    this.k = null;
    return null;
  }
  
  public abstract String b();
  
  protected boolean b()
  {
    return true;
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
    return a();
  }
  
  public String f()
  {
    if (((this instanceof ContactSearchModelDiscussion)) || ((this instanceof ContactSearchModelCreateDiscussion)) || ((this instanceof ContactSearchModelDiscussionMember))) {
      return HardCodeUtil.a(2131705720);
    }
    if (((this instanceof ContactSearchModelGlobalTroop)) || ((this instanceof ContactSearchModelGlobalTroopMember)) || ((this instanceof ContactSearchModelTroop)) || ((this instanceof ContactSearchModelTroopMember)) || ((this instanceof ContactSearchModelNewTroop)) || ((this instanceof ContactSearchModelNewTroopMember))) {
      return HardCodeUtil.a(2131705721);
    }
    return HardCodeUtil.a(2131705722);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.IContactSearchModel
 * JD-Core Version:    0.7.0.1
 */