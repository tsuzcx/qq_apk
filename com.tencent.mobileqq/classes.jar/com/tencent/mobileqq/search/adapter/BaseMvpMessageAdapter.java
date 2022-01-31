package com.tencent.mobileqq.search.adapter;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.search.model.MessageSearchResultDetailModel;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseMvpMessageAdapter
  extends BaseMvpFaceAdapter
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FullMessageSearchResult.SearchResultItem jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem;
  private String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int c;
  private int d;
  private int e;
  
  public BaseMvpMessageAdapter(ListView paramListView, FaceDecoder paramFaceDecoder, FullMessageSearchResult.SearchResultItem paramSearchResultItem, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramListView, paramFaceDecoder);
    this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem = paramSearchResultItem;
    this.jdField_a_of_type_JavaLangString = paramSearchResultItem.user.uin;
    this.e = paramSearchResultItem.user.type;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.msgtype == -2011)
    {
      AbsStructMsg localAbsStructMsg = StructMsgFactory.a(paramMessageRecord.msgData);
      if ((localAbsStructMsg != null) && ((localAbsStructMsg instanceof AbsShareMsg)))
      {
        paramMessageRecord.msg = ((AbsShareMsg)localAbsStructMsg).mContentTitle;
        if ((TextUtils.isEmpty(paramMessageRecord.msg)) && ((localAbsStructMsg instanceof AbsStructMsg))) {
          paramMessageRecord.msg = ((AbsShareMsg)localAbsStructMsg).mMsgBrief;
        }
      }
    }
  }
  
  private void b()
  {
    if ((this.d - this.c == this.jdField_b_of_type_Int) && (this.jdField_a_of_type_Int == 0)) {
      a();
    }
  }
  
  public void a()
  {
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i;
    if (j + 50 < this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem.secondPageMessageUniseq.size()) {
      i = j + 50;
    }
    while (j < i)
    {
      MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_JavaLangString, this.e, ((Long)this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem.secondPageMessageUniseq.get(j)).longValue());
      if (localMessageRecord != null)
      {
        a(localMessageRecord);
        if (localMessageRecord.msg != null) {
          this.jdField_a_of_type_JavaUtilList.add(new MessageSearchResultDetailModel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem.user, localMessageRecord));
        }
      }
      j += 1;
      continue;
      i = this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem.secondPageMessageUniseq.size();
    }
    super.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    super.a(paramAbsListView, paramInt);
    b();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.d = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.adapter.BaseMvpMessageAdapter
 * JD-Core Version:    0.7.0.1
 */