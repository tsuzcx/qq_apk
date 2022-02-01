package com.tencent.mobileqq.search.ftsmsg;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.fts.data.msg.FTSMessage;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.fts.v1.utils.TextMsgExts;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchDetailActivity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchResultModel;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.SearchUtils.ObjectItemInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class FTSMessageSearchResultModel
  extends FTSEntitySearchResultModel
{
  protected String n;
  private String o;
  private String p;
  private int q;
  private String r;
  
  public FTSMessageSearchResultModel(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, ArrayList<String> paramArrayList, List<FTSMessage> paramList, String paramString3, CharSequence paramCharSequence)
  {
    super(paramQQAppInterface, paramString1, paramString2, paramArrayList, paramList);
    paramString1 = (FTSMessage)paramList.get(0);
    this.o = String.valueOf(paramString1.uin);
    this.p = paramString1.senderuin;
    this.q = paramString1.istroop;
    this.n = paramString3;
    this.e = paramCharSequence;
    if (this.q == 3000)
    {
      int i = ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).c(this.o);
      if (i <= 0) {
        this.r = "";
      } else {
        this.r = String.valueOf(i);
      }
    }
    f(13);
  }
  
  public CharSequence a()
  {
    if (this.h == null)
    {
      int i = this.m.size();
      if (i == 1)
      {
        this.h = SearchUtils.a(((FTSEntity)this.m.get(0)).mContent, ((FTSEntity)this.m.get(0)).mProximityStart, this.c);
      }
      else
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131902945));
        ((StringBuilder)localObject).append("\"");
        localObject = new SpannableStringBuilder(((StringBuilder)localObject).toString());
        if ((this.n != null) && ((this.c == null) || (this.c.isEmpty())))
        {
          String str = this.n;
          ((SpannableStringBuilder)localObject).append(SearchUtils.a(str, str));
        }
        else
        {
          ((SpannableStringBuilder)localObject).append(SearchUtils.a(this.a, this.a));
        }
        ((SpannableStringBuilder)localObject).append("\"").append("相关记录");
        this.h = ((CharSequence)localObject);
      }
    }
    return this.h;
  }
  
  public void a(View paramView)
  {
    Object localObject3;
    Object localObject4;
    if ((paramView.getContext() instanceof UniteSearchActivity))
    {
      if (SearchUtils.l.containsKey(this))
      {
        localObject2 = (SearchUtils.ObjectItemInfo)SearchUtils.l.get(this);
        localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        localObject3 = new JSONObject();
        try
        {
          ((JSONObject)localObject3).put("project", UniteSearchReportController.a());
          ((JSONObject)localObject3).put("event_src", "client");
          ((JSONObject)localObject3).put("obj_lct", ((SearchUtils.ObjectItemInfo)localObject2).c);
          ((JSONObject)localObject3).put("get_src", "native");
        }
        catch (JSONException localJSONException)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("e = ");
          localStringBuilder.append(localJSONException);
          QLog.e("FTSMessageSearchResultModel", 2, localStringBuilder.toString());
        }
        localObject4 = new ReportModelDC02528().module("all_result").action("clk_item");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((SearchUtils.ObjectItemInfo)localObject2).b);
        localStringBuilder.append("");
        localObject2 = ((ReportModelDC02528)localObject4).obj1(localStringBuilder.toString()).obj2(((SearchUtils.ObjectItemInfo)localObject2).e).ver1(((SearchUtils.ObjectItemInfo)localObject2).a).ver2(UniteSearchReportController.a(UniteSearchActivity.f)).ver7(((JSONObject)localObject3).toString());
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(((QQAppInterface)localObject1).getCurrentAccountUin());
        ((StringBuilder)localObject3).append(SearchUtils.j);
        UniteSearchReportController.a(null, ((ReportModelDC02528)localObject2).session_id(((StringBuilder)localObject3).toString()));
      }
      localObject1 = (InputMethodManager)paramView.getContext().getSystemService("input_method");
      if (localObject1 != null) {
        ((InputMethodManager)localObject1).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      }
      UniteSearchReportController.a(null, this.ah, 0, "0X8009D4D", 0, 0, null, null);
    }
    if (this.e != null) {
      this.e = SQLiteFTSUtils.a(this.d, this.d.getApp(), this.o, this.q, this.p);
    }
    Object localObject1 = (Integer)paramView.getTag(2131449868);
    Object localObject2 = (Integer)paramView.getTag(2131449866);
    if (((paramView.getContext() instanceof UniteSearchActivity)) && (((Integer)localObject1).intValue() >= 0) && (((Integer)localObject2).intValue() >= 0))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(this.a);
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("");
      ((StringBuilder)localObject4).append(localObject2);
      localObject2 = ((StringBuilder)localObject4).toString();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("");
      ((StringBuilder)localObject4).append(((Integer)localObject1).intValue() + 1);
      SearchUtils.a("all_result", "clk_talk", new String[] { localObject3, localObject2, ((StringBuilder)localObject4).toString() });
    }
    else if ((paramView.getContext() instanceof FTSEntitySearchDetailActivity))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(this.a);
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("");
      ((StringBuilder)localObject4).append(localObject2);
      localObject2 = ((StringBuilder)localObject4).toString();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("");
      ((StringBuilder)localObject4).append(((Integer)localObject1).intValue() + 1);
      SearchUtils.a("talk", "clk_talk", new String[] { localObject3, localObject2, ((StringBuilder)localObject4).toString() });
    }
    if (this.m.size() == 1) {
      com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.f = 1;
    } else {
      com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.f = 2;
    }
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.d = this.i;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.g = this.q;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.j = this.j;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.k = this.k;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.l = this.l;
    SQLiteFTSUtils.a(paramView);
    if (this.m.size() == 1)
    {
      RecentUtil.a = true;
      localObject1 = (FTSMessage)this.m.get(0);
      if (((FTSMessage)localObject1).msgExts != null) {
        if ((((FTSMessage)localObject1).istroop != 1) && (((FTSMessage)localObject1).istroop != 3000)) {
          RecentUtil.c = ((TextMsgExts)((FTSMessage)localObject1).msgExts).time;
        } else {
          RecentUtil.c = ((TextMsgExts)((FTSMessage)localObject1).msgExts).shmsgseq;
        }
      }
      SearchHistoryManager.a(this.d, this.a);
      RecentUtil.a(paramView.getContext(), this.d, this.o, this.q, (String)this.e, false);
      SearchUtils.a(this.a, 40, paramView, false);
    }
    else
    {
      FTSEntitySearchDetailActivity.a(paramView.getContext(), g(), this.b, this.e, this.m, 1, this.o, this.q);
    }
    SearchUtils.a(this.a, 40, 0, paramView);
  }
  
  public int b()
  {
    int k = this.q;
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
            localStringBuilder.append(this.q);
            QLog.d("FTSMessageSearchResultModel", 2, localStringBuilder.toString());
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
    return this.o;
  }
  
  public CharSequence d()
  {
    if (this.e == null) {
      this.e = ContactUtils.a(this.d, this.o, this.q);
    }
    return this.e;
  }
  
  public CharSequence e()
  {
    if ((this.q == 3000) && (!TextUtils.isEmpty(this.r))) {
      return SearchUtils.a(this.r);
    }
    return "";
  }
  
  public CharSequence i()
  {
    if ((this.m != null) && (this.m.size() == 1) && (this.f == null) && ((this.m.get(0) instanceof FTSMessage)))
    {
      CharSequence localCharSequence = ((FTSMessage)this.m.get(0)).matchTitle;
      if (localCharSequence != null) {
        this.f = localCharSequence;
      }
    }
    return this.f;
  }
  
  public CharSequence j()
  {
    if ((this.m != null) && (this.m.size() == 1) && (this.g == null) && ((this.m.get(0) instanceof FTSMessage)))
    {
      CharSequence localCharSequence = ((FTSMessage)this.m.get(0)).matchSecondTitle;
      if (localCharSequence != null) {
        this.g = localCharSequence;
      }
    }
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchResultModel
 * JD-Core Version:    0.7.0.1
 */