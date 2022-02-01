package com.tencent.mobileqq.search.model;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.search.activity.MessageSearchDetailActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.SearchUtils.ObjectItemInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageSearchResultModel
  extends ISearchResultPositionModel
{
  private String a;
  private FullMessageSearchResult.SearchResultItem b;
  private QQAppInterface c;
  private CharSequence d;
  private CharSequence e;
  private String f;
  
  public MessageSearchResultModel(QQAppInterface paramQQAppInterface, String paramString, FullMessageSearchResult.SearchResultItem paramSearchResultItem)
  {
    this.c = paramQQAppInterface;
    this.a = paramString;
    this.b = paramSearchResultItem;
    if (paramSearchResultItem.user.getType() == 3000)
    {
      int i = ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).c(paramSearchResultItem.user.uin);
      if (i <= 0)
      {
        this.f = "";
        return;
      }
      this.f = String.valueOf(i);
    }
  }
  
  public CharSequence a()
  {
    if (this.e == null)
    {
      int i = this.b.secondPageMessageUniseq.size();
      if (i == 1)
      {
        this.e = SearchUtils.a(((MessageRecord)this.b.secondPageList.get(0)).msg, this.a);
      }
      else
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131904549));
        ((StringBuilder)localObject).append("\"");
        localObject = new SpannableStringBuilder(((StringBuilder)localObject).toString());
        String str = this.a;
        ((SpannableStringBuilder)localObject).append(SearchUtils.a(str, str));
        ((SpannableStringBuilder)localObject).append("\"").append("相关记录");
        this.e = ((CharSequence)localObject);
      }
    }
    return this.e;
  }
  
  public void a(View paramView)
  {
    if (((paramView.getContext() instanceof UniteSearchActivity)) && (SearchUtils.l.containsKey(this)))
    {
      Object localObject1 = (SearchUtils.ObjectItemInfo)SearchUtils.l.get(this);
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Object localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("project", UniteSearchReportController.a());
        ((JSONObject)localObject2).put("event_src", "client");
        ((JSONObject)localObject2).put("obj_lct", ((SearchUtils.ObjectItemInfo)localObject1).c);
        ((JSONObject)localObject2).put("get_src", "native");
      }
      catch (JSONException localJSONException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("e = ");
        localStringBuilder.append(localJSONException);
        QLog.e("MessageSearchResultModel", 2, localStringBuilder.toString());
      }
      ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("all_result").action("clk_item");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((SearchUtils.ObjectItemInfo)localObject1).b);
      localStringBuilder.append("");
      localObject1 = localReportModelDC02528.obj1(localStringBuilder.toString()).obj2(((SearchUtils.ObjectItemInfo)localObject1).e).ver1(((SearchUtils.ObjectItemInfo)localObject1).a).ver2(UniteSearchReportController.a(UniteSearchActivity.f)).ver7(((JSONObject)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localQQAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject2).append(SearchUtils.j);
      UniteSearchReportController.a(null, ((ReportModelDC02528)localObject1).session_id(((StringBuilder)localObject2).toString()));
    }
    if (this.b.secondPageMessageUniseq.size() == 1)
    {
      RecentUtil.a = true;
      RecentUtil.b = (MessageRecord)this.b.secondPageList.get(0);
      RecentUtil.a(paramView.getContext(), this.c, this.b.user.uin, this.b.user.getType(), ContactUtils.a(this.c, this.b.user.uin, this.b.user.getType()), false);
      SearchHistoryManager.a(this.c, this.a);
      SearchUtils.a(this.a, 40, paramView, false);
    }
    else
    {
      MessageSearchDetailActivity.a(paramView.getContext(), g(), this.b);
    }
    SearchUtils.a(this.a, 40, 0, paramView);
  }
  
  public int b()
  {
    int k = this.b.user.getType();
    int j = 1;
    int i = j;
    if (k != 0) {
      if (k != 1)
      {
        if (k != 3000)
        {
          i = j;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Face type is illegal. type = ");
            localStringBuilder.append(this.b.user.getType());
            QLog.d("MessageSearchResultModel", 2, localStringBuilder.toString());
            return 1;
          }
        }
        else
        {
          return 101;
        }
      }
      else {
        i = 4;
      }
    }
    return i;
  }
  
  public String c()
  {
    return this.b.user.uin;
  }
  
  public CharSequence d()
  {
    if (this.d == null) {
      this.d = ContactUtils.a(this.c, this.b.user.uin, this.b.user.getType());
    }
    return this.d;
  }
  
  public CharSequence e()
  {
    if ((this.b.user.getType() == 3000) && (!TextUtils.isEmpty(this.f))) {
      return SearchUtils.a(this.f);
    }
    return "";
  }
  
  public CharSequence f()
  {
    return null;
  }
  
  public String g()
  {
    return this.a;
  }
  
  public boolean h()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.MessageSearchResultModel
 * JD-Core Version:    0.7.0.1
 */