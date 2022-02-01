package com.tencent.mobileqq.search.fragment;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.base.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.base.util.SearchViewUtils;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBaseItem;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModel;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.PublicAccountSearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.im.oidb.search.DynamicTabSearch.SubHotWord;

class PublicAcntSearchFragment$2
  extends UniteSearchObserver
{
  PublicAcntSearchFragment$2(PublicAcntSearchFragment paramPublicAcntSearchFragment) {}
  
  public void handleTabSearchError(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3, long[] paramArrayOfLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PublicAcntSearchFragment", 2, "handleTabSearchError!!!");
    }
    paramString1 = this.a;
    paramString1.jdField_a_of_type_Boolean = false;
    PublicAcntSearchFragment.a(paramString1).sendEmptyMessage(3);
  }
  
  public void handleTabSearchResult(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<ISearchResultGroupModel> paramList, long[] paramArrayOfLong, String paramString3, List<DynamicTabSearch.SubHotWord> paramList1, boolean paramBoolean3, String paramString4, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramString3 = new StringBuilder();
      paramString3.append("handleTabSearchResult， keyword=");
      paramString3.append(this.a.jdField_c_of_type_JavaLangString);
      paramString3.append(", isFirstReq=");
      paramString3.append(paramBoolean1);
      paramString3.append(" ,cookie = ");
      paramString3.append(paramArrayOfByte);
      paramString3.append(",result=");
      paramString3.append(paramList.size());
      QLog.i("PublicAcntSearchFragment", 2, paramString3.toString());
    }
    ThreadManager.getUIHandler().post(new PublicAcntSearchFragment.2.1(this, paramBoolean2));
    if (!TextUtils.equals(paramString2, this.a.jdField_a_of_type_JavaLangString))
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("handleTabSearchResult. reqKeyword=");
      paramArrayOfByte.append(paramString1);
      paramArrayOfByte.append(" keyword=");
      paramArrayOfByte.append(this.a.jdField_c_of_type_JavaLangString);
      paramArrayOfByte.append(" reqTime=");
      paramArrayOfByte.append(paramString2);
      paramArrayOfByte.append(" lastReqTime=");
      paramArrayOfByte.append(this.a.jdField_a_of_type_JavaLangString);
      paramArrayOfByte.append(" isEnd1=");
      paramArrayOfByte.append(paramBoolean2);
      QLog.d("PublicAcntSearchFragment", 2, paramArrayOfByte.toString());
      return;
    }
    if (!TextUtils.equals(paramString1, this.a.jdField_c_of_type_JavaLangString))
    {
      paramString2 = new StringBuilder();
      paramString2.append("handleTabSearchResult. masks=");
      paramString2.append(paramArrayOfLong[0]);
      paramString2.append(" reqKeyword=");
      paramString2.append(paramString1);
      paramString2.append(" keyword=");
      paramString2.append(this.a.jdField_c_of_type_JavaLangString);
      paramString2.append(" isEnd1=");
      paramString2.append(paramBoolean2);
      QLog.d("PublicAcntSearchFragment", 2, paramString2.toString());
      return;
    }
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PublicAcntSearchFragment", 2, "handleTabSearchResult result is null");
      }
      handleTabSearchError(paramString1, paramBoolean1, paramString2, -1, "result = null", paramArrayOfLong);
      return;
    }
    paramString1 = paramList.iterator();
    long l1 = -1L;
    long l2 = l1;
    paramInt = 0;
    int i;
    while (paramString1.hasNext())
    {
      paramString2 = (ISearchResultGroupModel)paramString1.next();
      i = paramInt;
      long l3 = l1;
      long l4 = l2;
      if (paramString2.a() != null)
      {
        l3 = l1;
        if ((paramString2 instanceof GroupBaseNetSearchModel))
        {
          paramString3 = (GroupBaseNetSearchModel)paramString2;
          l3 = l1;
          if (l1 == -1L) {
            l3 = paramString3.a;
          }
          l2 = paramString3.a;
        }
        i = paramInt + paramString2.a().size();
        l4 = l2;
      }
      paramInt = i;
      l1 = l3;
      l2 = l4;
    }
    if (!paramBoolean1) {
      SearchUtils.a("sub_result", "load_result", new String[] { this.a.jdField_c_of_type_JavaLangString, SearchUtils.a(paramArrayOfLong), "", SearchUtils.a("dynamic_tab_search.1", paramArrayOfLong) });
    }
    if (paramInt == 0) {
      SearchUtils.a("sub_result", "no_result", new String[] { this.a.jdField_c_of_type_JavaLangString, SearchUtils.a(paramArrayOfLong), "", SearchUtils.a("dynamic_tab_search.1", paramArrayOfLong) });
    } else if (paramBoolean1) {
      SearchUtils.a("sub_result", "exp_result", new String[] { this.a.jdField_c_of_type_JavaLangString, SearchUtils.a(paramArrayOfLong), "", SearchUtils.a("dynamic_tab_search.1", paramArrayOfLong) });
    }
    paramString1 = this.a;
    paramString1.g = paramBoolean2;
    paramString1.jdField_a_of_type_Boolean = false;
    paramString1.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    if ((paramString1.jdField_c_of_type_JavaUtilList != null) && (!this.a.jdField_c_of_type_JavaUtilList.isEmpty()))
    {
      paramString1 = SearchUtil.a(paramList, paramBoolean1);
      if ((!paramBoolean1) && (l1 == PublicAcntSearchFragment.a(this.a)) && (paramString1 != null) && (paramString1.size() > 0) && (!paramBoolean3))
      {
        paramString2 = (IModel)this.a.jdField_c_of_type_JavaUtilList.get(this.a.jdField_c_of_type_JavaUtilList.size() - 1);
        if ((this.a.jdField_c_of_type_JavaUtilList.get(this.a.jdField_c_of_type_JavaUtilList.size() - 1) instanceof PublicAccountSearchResultModel)) {
          if ((paramString1.get(0) instanceof GroupSearchModeTitle)) {
            break label825;
          }
        }
        paramString1.remove(0);
        label825:
        paramInt = 0;
        for (i = 0; i < paramString1.size(); i = j)
        {
          if (((IModel)paramString1.get(i) instanceof GroupSearchModeTitle)) {
            break label883;
          }
          j = i + 1;
          paramInt = i;
        }
        i = paramInt;
        label883:
        if ((paramString2 instanceof ISearchResultModel))
        {
          paramString2 = (ISearchResultModel)paramString2;
          paramInt = paramString2.b();
          SearchViewUtils.a(paramString2, paramInt + i, paramInt - 1);
        }
        else
        {
          paramInt = 0;
        }
        int j = 0;
        while (j < i)
        {
          paramString2 = (IModel)paramString1.get(j);
          if ((paramString2 instanceof ISearchResultModel)) {
            SearchViewUtils.a((ISearchResultModel)paramString2, paramInt + i, paramInt + j);
          }
          j += 1;
        }
      }
      this.a.jdField_c_of_type_JavaUtilList.addAll(paramString1);
    }
    else
    {
      paramString1 = SearchUtil.a(paramList, paramBoolean1);
      this.a.jdField_c_of_type_JavaUtilList = paramString1;
    }
    paramInt = 0;
    while (paramInt < this.a.jdField_c_of_type_JavaUtilList.size())
    {
      if ((this.a.jdField_c_of_type_JavaUtilList.get(paramInt) instanceof NetSearchTemplateBaseItem)) {
        ((NetSearchTemplateBaseItem)this.a.jdField_c_of_type_JavaUtilList.get(paramInt)).u = 0;
      }
      paramInt += 1;
    }
    PublicAcntSearchFragment.a(this.a).a(this.a.jdField_c_of_type_JavaUtilList);
    PublicAcntSearchFragment.a(this.a, l2);
    if ((this.a.jdField_c_of_type_JavaUtilList.size() == 0) && (!TextUtils.isEmpty(this.a.jdField_c_of_type_JavaLangString)) && (paramBoolean2)) {
      ThreadManager.getUIHandler().post(new PublicAcntSearchFragment.2.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.PublicAcntSearchFragment.2
 * JD-Core Version:    0.7.0.1
 */