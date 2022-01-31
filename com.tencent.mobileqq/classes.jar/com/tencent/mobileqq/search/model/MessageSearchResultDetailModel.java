package com.tencent.mobileqq.search.model;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import java.text.SimpleDateFormat;

public class MessageSearchResultDetailModel
  extends ISearchResultPositionModel
{
  private static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yy/MM/dd");
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private RecentUser jdField_a_of_type_ComTencentMobileqqDataRecentUser;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private String jdField_a_of_type_JavaLangString;
  private CharSequence b;
  private CharSequence c;
  
  public MessageSearchResultDetailModel(QQAppInterface paramQQAppInterface, String paramString, RecentUser paramRecentUser, MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqDataRecentUser = paramRecentUser;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
  }
  
  public int a()
  {
    return 1;
  }
  
  public CharSequence a()
  {
    if (this.b == null) {
      if (!AnonymousChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
        break label60;
      }
    }
    label60:
    SessionInfo localSessionInfo;
    for (this.b = (BaseApplicationImpl.sApplication.getString(2131430287) + AnonymousChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).b);; this.b = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend(), this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin))
    {
      return this.b;
      localSessionInfo = new SessionInfo();
      localSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type;
      localSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin;
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
  }
  
  public void a(View paramView)
  {
    RecentUtil.jdField_a_of_type_Boolean = true;
    RecentUtil.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    RecentUtil.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type), false);
    SearchHistoryManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
    SearchUtils.a(this.jdField_a_of_type_JavaLangString, 40, paramView, true);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public CharSequence b()
  {
    if (this.c == null) {
      this.c = SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msg, this.jdField_a_of_type_JavaLangString);
    }
    return this.c;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public CharSequence c()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence)) {
      this.jdField_a_of_type_JavaLangCharSequence = TimeFormatterUtils.a(BaseApplicationImpl.sApplication, 3, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time * 1000L);
    }
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public CharSequence d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.MessageSearchResultDetailModel
 * JD-Core Version:    0.7.0.1
 */