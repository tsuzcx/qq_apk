package com.tencent.mobileqq.search.model;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.PublicAccountSearchRecommendManager;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.common.WeishiReportUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.activity.PublicAcntSearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.util.HighlightModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class PublicAccountSearchResultModel
  extends IContactSearchModel
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public final PublicAccountInfo a;
  private String jdField_a_of_type_JavaLangString;
  private long b;
  private int c = -1;
  
  public PublicAccountSearchResultModel(QQAppInterface paramQQAppInterface, PublicAccountInfo paramPublicAccountInfo, int paramInt)
  {
    super(paramQQAppInterface, paramInt, 0L);
    this.c = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = paramPublicAccountInfo;
    if (paramQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin()))
    {
      this.b = IContactSearchable.O;
      return;
    }
    this.b = IContactSearchable.P;
  }
  
  public int a()
  {
    return 1;
  }
  
  protected long a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = -9223372036854775808L;
    long l2 = SearchUtils.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name, 1073741824L);
    long l1 = l2;
    if (l2 != -9223372036854775808L) {
      l1 = (l2 & 0x0) >> 20 | 0xFFFFFFFF & l2 | (0x0 & l2) >> 26;
    }
    if (l1 > this.jdField_a_of_type_Long) {
      this.jdField_a_of_type_Long = l1;
    }
    for (int i = 1;; i = 0)
    {
      if (this.jdField_a_of_type_Long != -9223372036854775808L)
      {
        if (this.b != IContactSearchable.O) {
          break label232;
        }
        this.jdField_a_of_type_Long |= 0x100000;
        if (!this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.isOffLine)
        {
          this.jdField_a_of_type_Long |= 0x0;
          if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.clickCount >= 3) {
            if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.clickCount >= 128) {
              break label247;
            }
          }
        }
      }
      label232:
      label247:
      for (this.jdField_a_of_type_Long |= (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.clickCount & 0x7F) << 32;; this.jdField_a_of_type_Long |= 0x0)
      {
        if (i != 0) {
          this.jdField_a_of_type_Long |= 0x0;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.certifiedGrade == 1L) {
          this.jdField_a_of_type_Long |= 0x80000000;
        }
        return this.jdField_a_of_type_Long;
        this.jdField_a_of_type_Long |= 0x80000;
        break;
      }
    }
  }
  
  public PublicAccountInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo;
  }
  
  public Object a()
  {
    return Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.uin);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    Object localObject2 = paramView.getContext();
    if (localObject2 == null) {}
    label265:
    label650:
    label655:
    label658:
    for (;;)
    {
      return;
      if ((localObject2 instanceof UniteSearchActivity)) {
        SearchUtils.a("all_result", "clk_public_uin", new String[] { "" + this.jdField_a_of_type_JavaLangString });
      }
      String str = this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin();
      PAStartupTracker.a(null, "pubAcc_aio_open", str);
      Object localObject1 = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
      if (AppConstants.aH.equals(str))
      {
        WeishiReportUtil.a(null, 0);
        ReadInJoyActivityHelper.a((Context)localObject2, 0, null);
        label115:
        SearchUtils.a(this.jdField_a_of_type_JavaLangString, 50, 0, paramView, str, this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.isOffLine, this.c);
        SearchHistoryManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
        SearchUtils.a(this.jdField_a_of_type_JavaLangString, 50, paramView, false);
        if ((!(localObject2 instanceof BaseActivity)) || (this.jdField_a_of_type_Int <= 0)) {
          continue;
        }
        localObject1 = null;
        if (!(localObject2 instanceof UniteSearchActivity)) {
          break label579;
        }
        localObject1 = "0X8006570";
        paramView = "0X8005D1C";
      }
      for (;;)
      {
        label194:
        if (paramView == null) {
          break label658;
        }
        localObject2 = ((BaseActivity)localObject2).app;
        if (this.c == 12)
        {
          ReportController.b((QQAppInterface)localObject2, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 1, 0, this.jdField_a_of_type_Int + "", "", str, this.jdField_a_of_type_JavaLangString);
          paramView = PublicAccountSearchRecommendManager.a();
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name;
          if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.extendType == 2) {
            break label650;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          paramView.a((QQAppInterface)localObject2, str, (String)localObject1, bool);
          return;
          if (((localObject1 != null) && (((PublicAccountDataManager)localObject1).a(Long.valueOf(str)))) || ((localObject1 == null) && (PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str))))
          {
            Intent localIntent = new Intent(paramView.getContext(), ChatActivity.class);
            int i = 1008;
            if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.extendType == 2)
            {
              localIntent.putExtra("chat_subType", 1);
              i = 0;
            }
            if (TextUtils.isEmpty(str))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.w("PublicAccountSearchResultModel", 2, "uin is null");
              return;
            }
            localIntent.putExtra("uin", str);
            localIntent.putExtra("uintype", i);
            localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name);
            localIntent.putExtra("selfSet_leftViewText", ((Context)localObject2).getString(2131433681));
            RecentUtil.a = true;
            RecentUtil.a(localIntent);
            ((Context)localObject2).startActivity(localIntent);
            this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.clickCount += 1;
            if (localObject1 == null) {
              break label115;
            }
            ((PublicAccountDataManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
            break label115;
          }
          if (TextUtils.isEmpty(str))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.w("PublicAccountSearchResultModel", 2, "uin is null");
            return;
          }
          localObject1 = new Intent(paramView.getContext(), AccountDetailActivity.class);
          ((Intent)localObject1).putExtra("uin", str);
          ((Intent)localObject1).putExtra("source", 4);
          ((Context)localObject2).startActivity((Intent)localObject1);
          break label115;
          label579:
          if (!(localObject2 instanceof PublicAcntSearchActivity)) {
            break label655;
          }
          localObject1 = "0X8006588";
          paramView = "0X8005D1E";
          break label194;
          PublicAccountReportUtils.a((QQAppInterface)localObject2, "P_CliOper", "Pb_account_lifeservice", str, paramView, paramView, 0, 0, this.jdField_a_of_type_Int + "", "", this.jdField_a_of_type_JavaLangString, "", false);
          break label265;
        }
        paramView = null;
      }
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return 0;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public CharSequence c()
  {
    SpannableString localSpannableString = new HighlightModel(new ArrayList(), b()).a(SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.summary));
    Object localObject = localSpannableString;
    if (localSpannableString == null) {
      localObject = "";
    }
    return localObject;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.PublicAccountSearchResultModel
 * JD-Core Version:    0.7.0.1
 */