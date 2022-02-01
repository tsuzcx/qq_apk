package com.tencent.mobileqq.search.model;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.haoliyou.orion.XorCipher;
import com.tencent.mobileqq.haoliyou.orion.XorCipherException;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.business.group.model.SearchResultGroupModelImpl;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.searchengine.NetSearchEngine;
import com.tencent.mobileqq.search.util.ReportUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.net.URLEncoder;
import java.util.List;

public class GroupBaseNetSearchModel
  extends SearchResultGroupModelImpl
{
  public long a;
  String a;
  public List<ISearchResultModel> a;
  public boolean a;
  long jdField_b_of_type_Long;
  String jdField_b_of_type_JavaLangString;
  public List<String> b;
  public boolean b;
  String c;
  public boolean c;
  public int d;
  public String d;
  public String e;
  private String f;
  
  public GroupBaseNetSearchModel() {}
  
  public GroupBaseNetSearchModel(String paramString1, long paramLong1, String paramString2, List<ISearchResultModel> paramList, long paramLong2, String paramString3, String paramString4, List<String> paramList1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString5, String paramString6)
  {
    this.f = paramString1;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_b_of_type_JavaLangString = paramString3;
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("GroupBaseNetSearchModel ,moreUrl = ");
      paramString1.append(paramString3);
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModel", 2, paramString1.toString());
    }
    this.jdField_c_of_type_JavaLangString = paramString4;
    this.jdField_b_of_type_JavaUtilList = paramList1;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_c_of_type_Boolean = paramBoolean3;
    this.e = paramString6;
    this.jdField_d_of_type_JavaLangString = paramString5;
  }
  
  public int a()
  {
    return 1;
  }
  
  public String a()
  {
    String str2 = this.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public List<ISearchResultModel> a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getResultList.");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModel", 2, localStringBuilder.toString());
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Long == 1106L)
    {
      MobileReportManager.getInstance().reportAction("more", "4", "platform898", "7", "1", 102, 1, System.currentTimeMillis());
      UniteSearchReportController.a(null, 0, this.jdField_d_of_type_Int, "0X800BAC7", 0, 0, null, null);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void a(View paramView)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMoreAction. searchKey=");
      ((StringBuilder)localObject).append(this.f);
      ((StringBuilder)localObject).append(" groupName=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(" groupMask=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModel", 2, ((StringBuilder)localObject).toString());
    }
    a();
    if (this.jdField_a_of_type_Long == 1002L) {
      ReportUtil.a(this.jdField_a_of_type_JavaUtilList, this.f);
    }
    if (this.jdField_a_of_type_Long == 1701L)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("search_keyword", this.f);
      ((Intent)localObject).putExtra("key_refer", 1005);
      PublicFragmentActivity.a(paramView.getContext(), (Intent)localObject, ((IMiniAppService)QRoute.api(IMiniAppService.class)).getMiniAppSearchFragmentClass());
      return;
    }
    ActiveEntitySearchActivity.jdField_b_of_type_Boolean = true;
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      localObject = JumpParser.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramView.getContext(), this.jdField_b_of_type_JavaLangString);
      if (localObject != null)
      {
        ((JumpAction)localObject).a();
        return;
      }
      if ((this.jdField_b_of_type_JavaLangString.startsWith("http://")) || (this.jdField_b_of_type_JavaLangString.startsWith("https://")))
      {
        long l1 = Double.valueOf(NetSearchEngine.a * 1000000.0D).longValue();
        long l2 = Double.valueOf(NetSearchEngine.b * 1000000.0D).longValue();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject).append("&keyword=");
        ((StringBuilder)localObject).append(URLEncoder.encode(this.f));
        ((StringBuilder)localObject).append("&gpstype=1&lon=");
        ((StringBuilder)localObject).append(Long.valueOf(l2));
        ((StringBuilder)localObject).append("&lat=");
        ((StringBuilder)localObject).append(Long.valueOf(l1));
        localObject = ((StringBuilder)localObject).toString();
        if (QLog.isColorLevel()) {
          try
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("onMoreAction,moreUrl = ");
            localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
            localStringBuilder.append(",dstUrl = ");
            localStringBuilder.append(XorCipher.a((String)localObject));
            QLog.d("Q.uniteSearch.GroupBaseNetSearchModel", 2, localStringBuilder.toString());
          }
          catch (XorCipherException localXorCipherException)
          {
            localXorCipherException.printStackTrace();
          }
        }
        paramView = paramView.getContext();
        Intent localIntent = new Intent(paramView, QQBrowserActivity.class);
        localIntent.putExtra("url", (String)localObject);
        paramView.startActivity(localIntent);
      }
    }
    else
    {
      ActiveEntitySearchActivity.a(paramView.getContext(), this.f, this.jdField_a_of_type_JavaLangString, new long[] { this.jdField_a_of_type_Long });
    }
  }
  
  public void a(List<ISearchResultModel> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int b()
  {
    return (int)this.jdField_a_of_type_Long;
  }
  
  public String b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getKeyword.");
      localStringBuilder.append(this.f);
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModel", 2, localStringBuilder.toString());
    }
    return this.f;
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Long == 1002L) && (!this.jdField_b_of_type_JavaLangString.isEmpty()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      localStringBuilder.append("&sourceext=");
      localStringBuilder.append(paramInt);
      this.jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    }
  }
  
  public String c()
  {
    String str2 = this.jdField_c_of_type_JavaLangString;
    String str1 = str2;
    if (str2 == null) {
      str1 = HardCodeUtil.a(2131705438);
    }
    return str1;
  }
  
  public String d()
  {
    String str2 = this.jdField_b_of_type_JavaLangString;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupBaseNetSearchModel
 * JD-Core Version:    0.7.0.1
 */