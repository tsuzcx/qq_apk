package com.tencent.mobileqq.search.model;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.activity.PublicAcntSearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class GroupBaseNetSearchModel
  extends SearchResultGroupModelImpl
{
  public long a;
  String a;
  public List a;
  public boolean a;
  long jdField_b_of_type_Long;
  String jdField_b_of_type_JavaLangString;
  private List jdField_b_of_type_JavaUtilList;
  public boolean b;
  String c;
  public boolean c;
  public String d;
  public String e;
  private String f;
  
  public GroupBaseNetSearchModel() {}
  
  public GroupBaseNetSearchModel(String paramString1, long paramLong1, String paramString2, List paramList1, long paramLong2, String paramString3, String paramString4, List paramList2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString5, String paramString6)
  {
    this.f = paramString1;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_JavaUtilList = paramList1;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_b_of_type_JavaLangString = paramString3;
    this.jdField_c_of_type_JavaLangString = paramString4;
    this.jdField_a_of_type_JavaUtilList = paramList2;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_c_of_type_Boolean = paramBoolean3;
    this.e = paramString6;
    this.d = paramString5;
  }
  
  public int a()
  {
    return 1;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {
      return "";
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModel", 2, "getResultList." + this.jdField_b_of_type_JavaUtilList);
    }
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModel", 2, "onMoreAction. searchKey=" + this.f + " groupName=" + this.jdField_a_of_type_JavaLangString + " groupMask=" + this.jdField_a_of_type_Long);
    }
    if (this.jdField_a_of_type_Long == 1003L) {
      PublicAcntSearchActivity.a(paramView.getContext(), this.f, UniteSearchActivity.d);
    }
    do
    {
      return;
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        break;
      }
      localObject = JumpParser.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramView.getContext(), this.jdField_b_of_type_JavaLangString);
      if (localObject != null)
      {
        ((JumpAction)localObject).b();
        return;
      }
    } while ((!this.jdField_b_of_type_JavaLangString.startsWith("http://")) && (!this.jdField_b_of_type_JavaLangString.startsWith("https://")));
    paramView = paramView.getContext();
    Object localObject = new Intent(paramView, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", this.jdField_b_of_type_JavaLangString);
    paramView.startActivity((Intent)localObject);
    return;
    ActiveEntitySearchActivity.a(paramView.getContext(), this.f, this.jdField_a_of_type_JavaLangString, new long[] { this.jdField_a_of_type_Long });
  }
  
  public int b()
  {
    return (int)this.jdField_a_of_type_Long;
  }
  
  public String b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModel", 2, "getKeyword." + this.f);
    }
    return this.f;
  }
  
  public String c()
  {
    if (this.jdField_b_of_type_JavaLangString == null) {
      return "";
    }
    return this.jdField_b_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupBaseNetSearchModel
 * JD-Core Version:    0.7.0.1
 */