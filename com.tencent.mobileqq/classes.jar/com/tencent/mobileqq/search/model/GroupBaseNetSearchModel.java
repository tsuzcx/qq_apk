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
  String b;
  public List<ISearchResultModel> c;
  long d;
  String e;
  String i;
  public String j;
  public String k;
  public List<String> l;
  public boolean m;
  public boolean n;
  public boolean o;
  public int p;
  private String q;
  
  public GroupBaseNetSearchModel() {}
  
  public GroupBaseNetSearchModel(String paramString1, long paramLong1, String paramString2, List<ISearchResultModel> paramList, long paramLong2, String paramString3, String paramString4, List<String> paramList1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString5, String paramString6)
  {
    this.q = paramString1;
    this.a = paramLong1;
    this.b = paramString2;
    this.c = paramList;
    this.d = paramLong2;
    this.e = paramString3;
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("GroupBaseNetSearchModel ,moreUrl = ");
      paramString1.append(paramString3);
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModel", 2, paramString1.toString());
    }
    this.i = paramString4;
    this.l = paramList1;
    this.m = paramBoolean1;
    this.n = paramBoolean2;
    this.o = paramBoolean3;
    this.k = paramString6;
    this.j = paramString5;
  }
  
  public String a()
  {
    String str2 = this.b;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public void a(long paramLong)
  {
    this.d = paramLong;
  }
  
  public void a(View paramView)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMoreAction. searchKey=");
      ((StringBuilder)localObject).append(this.q);
      ((StringBuilder)localObject).append(" groupName=");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(" groupMask=");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModel", 2, ((StringBuilder)localObject).toString());
    }
    h();
    if (this.a == 1002L) {
      ReportUtil.a(this.c, this.q);
    }
    long l1 = this.a;
    if (l1 == 1701L)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("search_keyword", this.q);
      ((Intent)localObject).putExtra("key_refer", 1005);
      PublicFragmentActivity.a(paramView.getContext(), (Intent)localObject, ((IMiniAppService)QRoute.api(IMiniAppService.class)).getMiniAppSearchFragmentClass());
      UniteSearchReportController.a(null, 0, this.p, "0X8009D47", 0, 0, null, null);
      return;
    }
    if (l1 == 1003L) {
      UniteSearchReportController.a(null, 0, this.p, "0X8009D53", 0, 0, null, null);
    }
    ActiveEntitySearchActivity.s = true;
    if (!TextUtils.isEmpty(this.e))
    {
      localObject = JumpParser.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramView.getContext(), this.e);
      if (localObject != null)
      {
        ((JumpAction)localObject).a();
        return;
      }
      if ((this.e.startsWith("http://")) || (this.e.startsWith("https://")))
      {
        l1 = Double.valueOf(NetSearchEngine.a * 1000000.0D).longValue();
        long l2 = Double.valueOf(NetSearchEngine.b * 1000000.0D).longValue();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append("&keyword=");
        ((StringBuilder)localObject).append(URLEncoder.encode(this.q));
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
            localStringBuilder.append(this.e);
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
      ActiveEntitySearchActivity.a(paramView.getContext(), this.q, this.b, new long[] { this.a });
    }
  }
  
  public void a(List<ISearchResultModel> paramList)
  {
    this.c = paramList;
  }
  
  public List<ISearchResultModel> b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getResultList.");
      localStringBuilder.append(this.c);
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModel", 2, localStringBuilder.toString());
    }
    return this.c;
  }
  
  public void b(int paramInt)
  {
    this.p = paramInt;
  }
  
  public String c()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getKeyword.");
      localStringBuilder.append(this.q);
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModel", 2, localStringBuilder.toString());
    }
    return this.q;
  }
  
  public void c(int paramInt)
  {
    if ((this.a == 1002L) && (!this.e.isEmpty()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.e);
      localStringBuilder.append("&sourceext=");
      localStringBuilder.append(paramInt);
      this.e = localStringBuilder.toString();
    }
  }
  
  public int d()
  {
    return 1;
  }
  
  public int e()
  {
    return (int)this.a;
  }
  
  public String f()
  {
    String str2 = this.i;
    String str1 = str2;
    if (str2 == null) {
      str1 = HardCodeUtil.a(2131903326);
    }
    return str1;
  }
  
  public String g()
  {
    String str2 = this.e;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public void h()
  {
    if (this.a == 1106L)
    {
      MobileReportManager.getInstance().reportAction("more", "4", "platform898", "7", "1", 102, 1, System.currentTimeMillis());
      UniteSearchReportController.a(null, 0, this.p, "0X800BAC7", 0, 0, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupBaseNetSearchModel
 * JD-Core Version:    0.7.0.1
 */