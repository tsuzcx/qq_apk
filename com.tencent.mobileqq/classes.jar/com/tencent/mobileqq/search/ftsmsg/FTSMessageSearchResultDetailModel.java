package com.tencent.mobileqq.search.ftsmsg;

import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.data.fts.FTSMessage;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchResultDetailModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.fts.FTSMessageCodec.TextMsgExts;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import java.util.ArrayList;

public class FTSMessageSearchResultDetailModel
  extends FTSEntitySearchResultDetailModel
{
  private int a;
  private String b;
  private String c;
  
  public FTSMessageSearchResultDetailModel(QQAppInterface paramQQAppInterface, String paramString, ArrayList<String> paramArrayList, FTSEntity paramFTSEntity)
  {
    super(paramQQAppInterface, paramString, paramArrayList, paramFTSEntity);
    paramQQAppInterface = (FTSMessage)this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSEntity;
    this.jdField_b_of_type_JavaLangString = String.valueOf(paramQQAppInterface.uin);
    this.jdField_c_of_type_JavaLangString = paramQQAppInterface.senderuin;
    this.jdField_a_of_type_Int = paramQQAppInterface.istroop;
    a();
  }
  
  public CharSequence a()
  {
    FTSMessage localFTSMessage;
    if (this.jdField_b_of_type_JavaLangCharSequence == null)
    {
      localFTSMessage = (FTSMessage)this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSEntity;
      if (localFTSMessage.matchTitle == null) {
        break label35;
      }
      this.jdField_b_of_type_JavaLangCharSequence = localFTSMessage.matchTitle;
    }
    for (;;)
    {
      return this.jdField_b_of_type_JavaLangCharSequence;
      label35:
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localFTSMessage.senderuin);
      SessionInfo localSessionInfo = new SessionInfo();
      localSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      if ("80000000".equals(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangCharSequence = HardCodeUtil.a(2131704978);
      } else {
        this.jdField_b_of_type_JavaLangCharSequence = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, bool, localFTSMessage.senderuin);
      }
    }
  }
  
  public void a(View paramView)
  {
    RecentUtil.jdField_a_of_type_Boolean = true;
    FTSMessage localFTSMessage = (FTSMessage)this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSEntity;
    if (localFTSMessage.msgExts != null) {
      if ((localFTSMessage.istroop != 1) && (localFTSMessage.istroop != 3000)) {
        break label173;
      }
    }
    label173:
    for (RecentUtil.jdField_a_of_type_Long = ((FTSMessageCodec.TextMsgExts)localFTSMessage.msgExts).shmsgseq;; RecentUtil.jdField_a_of_type_Long = ((FTSMessageCodec.TextMsgExts)localFTSMessage.msgExts).time)
    {
      com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.d = localFTSMessage.searchStrategy;
      com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.f = 1;
      com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.g = this.jdField_a_of_type_Int;
      com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.h = ((FTSMessage)this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSEntity).senderNum;
      com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.i = ((FTSMessage)this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSEntity).friendNum;
      com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.j = ((FTSMessage)this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSEntity).friendIndex;
      SQLiteFTSUtils.a(paramView);
      RecentUtil.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int), false);
      SearchHistoryManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      SearchUtils.a(this.jdField_a_of_type_JavaLangString, 40, paramView, true);
      return;
    }
  }
  
  public String b()
  {
    return String.valueOf(((FTSMessage)this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSEntity).senderuin);
  }
  
  public CharSequence c()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence))
    {
      this.jdField_a_of_type_JavaLangCharSequence = "";
      FTSMessage localFTSMessage = (FTSMessage)this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSEntity;
      if (localFTSMessage.msgExts != null) {
        this.jdField_a_of_type_JavaLangCharSequence = TimeFormatterUtils.a(BaseApplicationImpl.sApplication, 3, ((FTSMessageCodec.TextMsgExts)localFTSMessage.msgExts).time * 1000L);
      }
    }
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public CharSequence e()
  {
    if (this.jdField_c_of_type_JavaLangCharSequence == null)
    {
      FTSMessage localFTSMessage = (FTSMessage)this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSEntity;
      if (localFTSMessage.matchSecondTitle != null) {
        this.jdField_c_of_type_JavaLangCharSequence = localFTSMessage.matchSecondTitle;
      }
    }
    return this.jdField_c_of_type_JavaLangCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchResultDetailModel
 * JD-Core Version:    0.7.0.1
 */