package com.tencent.mobileqq.search.business.contact.model;

import android.app.Activity;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.selectmember.SelectMemberUtils;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class ContactSearchModelCreateDiscussion
  extends IContactSearchModel
{
  private long jdField_a_of_type_Long = 0L;
  String jdField_a_of_type_JavaLangString;
  List<IContactSearchModel> jdField_a_of_type_JavaUtilList;
  
  public ContactSearchModelCreateDiscussion(AppInterface paramAppInterface, int paramInt, String paramString, List<IContactSearchModel> paramList)
  {
    super(paramAppInterface, paramInt, 0L);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  private CharSequence f()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append("邀请:");
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (i != 0) {
        localSpannableStringBuilder.append("、");
      }
      localSpannableStringBuilder.append(((IContactSearchModel)this.jdField_a_of_type_JavaUtilList.get(i)).e());
      i += 1;
    }
    return localSpannableStringBuilder;
  }
  
  public int a()
  {
    return 9889987;
  }
  
  protected long a(String paramString)
  {
    return 0L;
  }
  
  public CharSequence a()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    int i;
    if (localObject != null) {
      i = ((List)localObject).size();
    } else {
      i = 0;
    }
    localObject = localSpannableStringBuilder.append("已选择");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(i);
    ((SpannableStringBuilder)localObject).append(localStringBuilder.toString()).append("人");
    return localSpannableStringBuilder;
  }
  
  public Object a()
  {
    return Integer.valueOf(9889987);
  }
  
  public String a()
  {
    return String.valueOf(9889987);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 1500L) {
      return;
    }
    Object localObject;
    if (((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(paramView.getContext()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      SearchUtils.a("all_result", "clk_discuss", new String[] { ((StringBuilder)localObject).toString() });
    }
    this.jdField_a_of_type_Long = l;
    Intent localIntent = new Intent();
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1002);
    localIntent.putExtra("param_min", 2);
    localIntent.putExtra("param_max", 99);
    localIntent.putExtra("param_entrance", 28);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      IContactSearchModel localIContactSearchModel = (IContactSearchModel)this.jdField_a_of_type_JavaUtilList.get(i);
      String str1 = localIContactSearchModel.a();
      String str2 = localIContactSearchModel.e().toString();
      boolean bool = localIContactSearchModel instanceof ContactSearchModelDiscussionMember;
      localObject = "-1";
      if (bool) {}
      for (localObject = ((ContactSearchModelDiscussionMember)localIContactSearchModel).e();; localObject = ((ContactSearchModelNewTroopMember)localIContactSearchModel).jdField_a_of_type_JavaLangString)
      {
        j = 2;
        break label285;
        if (!(localIContactSearchModel instanceof ContactSearchModelNewTroopMember)) {
          break;
        }
      }
      bool = localIContactSearchModel instanceof ContactSearchModelFriend;
      int j = 0;
      label285:
      localArrayList.add(SelectMemberUtils.a(str1, str2, j, (String)localObject));
      i += 1;
    }
    localIntent.putExtra("param_done_button_wording", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getString(2131718709));
    localIntent.putExtra("param_done_button_highlight_wording", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getString(2131718710));
    localIntent.putExtra("param_title", HardCodeUtil.a(2131702708));
    localIntent.putExtra("param_selected_records_for_create_discussion", localArrayList);
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult((Activity)paramView.getContext(), localIntent, 1300);
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X800635F", "0X800635F", 0, 0, "", "", "", "");
  }
  
  public boolean a()
  {
    return false;
  }
  
  public CharSequence b()
  {
    return f();
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public CharSequence c()
  {
    return "";
  }
  
  public String c()
  {
    return f().toString();
  }
  
  public int d()
  {
    return 9889987;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.model.ContactSearchModelCreateDiscussion
 * JD-Core Version:    0.7.0.1
 */