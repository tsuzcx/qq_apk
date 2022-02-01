package com.tencent.mobileqq.search.model;

import addcontacts.AccountSearchPb.record;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.contact.addcontact.publicaccount.PublicView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;

public class GroupNetSearchModelPublicAcntItem
  extends ISearchResultPositionModel
{
  private AccountSearchPb.record jdField_a_of_type_AddcontactsAccountSearchPb$record;
  public CharSequence a;
  private String jdField_a_of_type_JavaLangString;
  
  public GroupNetSearchModelPublicAcntItem(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_AddcontactsAccountSearchPb$record = paramrecord;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
  }
  
  public int a()
  {
    return 1;
  }
  
  public CharSequence a()
  {
    return HardCodeUtil.a(2131705447);
  }
  
  public String a()
  {
    return String.valueOf(this.jdField_a_of_type_AddcontactsAccountSearchPb$record.uin.get());
  }
  
  public void a(View paramView)
  {
    Context localContext = paramView.getContext();
    if ((localContext != null) && ((localContext instanceof BaseActivity)))
    {
      PublicView.a((QQAppInterface)((BaseActivity)localContext).getAppRuntime(), localContext, this.jdField_a_of_type_AddcontactsAccountSearchPb$record.class_index.get(), String.valueOf(this.jdField_a_of_type_AddcontactsAccountSearchPb$record.uin.get()), String.valueOf(this.jdField_a_of_type_AddcontactsAccountSearchPb$record.uin.get()), this.jdField_a_of_type_AddcontactsAccountSearchPb$record.account_flag.get(), this.jdField_a_of_type_AddcontactsAccountSearchPb$record.name.get(), 4);
      SearchUtils.a(this.jdField_a_of_type_JavaLangString, 70, 0, paramView);
      SearchUtils.a(this.jdField_a_of_type_JavaLangString, 70, paramView, false);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public CharSequence b()
  {
    return SearchUtils.a(this.jdField_a_of_type_AddcontactsAccountSearchPb$record.name.get(), this.jdField_a_of_type_JavaLangString);
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("name = ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangCharSequence);
      localStringBuilder.append(", isCert = ");
      boolean bool;
      if ((this.jdField_a_of_type_AddcontactsAccountSearchPb$record.has()) && (this.jdField_a_of_type_AddcontactsAccountSearchPb$record.flag.get() == 1L)) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d("GroupNetSearchModelPublicAcntItem", 2, localStringBuilder.toString());
    }
    return (this.jdField_a_of_type_AddcontactsAccountSearchPb$record.flag.has()) && (this.jdField_a_of_type_AddcontactsAccountSearchPb$record.flag.get() == 1L);
  }
  
  public CharSequence c()
  {
    return null;
  }
  
  public CharSequence d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupNetSearchModelPublicAcntItem
 * JD-Core Version:    0.7.0.1
 */