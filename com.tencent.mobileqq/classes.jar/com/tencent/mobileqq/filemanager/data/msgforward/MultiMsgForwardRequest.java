package com.tencent.mobileqq.filemanager.data.msgforward;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.multimsg.IMultiMsgRichUploadCallback;
import com.tencent.mobileqq.multimsg.MultiMsgRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MultiMsgForwardRequest
  extends QFileMsgForwardRequest
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IMultiMsgRichUploadCallback jdField_a_of_type_ComTencentMobileqqMultimsgIMultiMsgRichUploadCallback;
  private MultiMsgRequest jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgRequest;
  HashMap<String, ArrayList<MessageRecord>> jdField_a_of_type_JavaUtilHashMap;
  private HashMap<String, ArrayList<MessageRecord>> b;
  
  public MultiMsgForwardRequest(QQAppInterface paramQQAppInterface, MultiMsgRequest paramMultiMsgRequest, HashMap<String, ArrayList<MessageRecord>> paramHashMap, IMultiMsgRichUploadCallback paramIMultiMsgRichUploadCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgRequest = paramMultiMsgRequest;
    this.jdField_a_of_type_ComTencentMobileqqMultimsgIMultiMsgRichUploadCallback = paramIMultiMsgRichUploadCallback;
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgRequest == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgRequest.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
      return -1;
    }
    return this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgRequest.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgRequest == null) {
      return "";
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgRequest.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing == null) {
      return "";
    }
    return String.valueOf(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgRequest.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.uniseq);
  }
  
  public HashMap<String, ArrayList<MessageRecord>> a()
  {
    if (this.b == null)
    {
      this.b = new HashMap();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        ArrayList localArrayList = new ArrayList();
        this.b.put(localObject, localArrayList);
        localObject = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
        int i = 0;
        label86:
        MessageRecord localMessageRecord1;
        if (i < ((ArrayList)localObject).size())
        {
          localMessageRecord1 = (MessageRecord)((ArrayList)localObject).get(i);
          if (!(localMessageRecord1 instanceof MessageForReplyText)) {
            break label175;
          }
          MessageForReplyText localMessageForReplyText = (MessageForReplyText)localMessageRecord1;
          MessageRecord localMessageRecord2 = localMessageForReplyText.getSourceMessage();
          if ((localMessageRecord2 == null) || (!FileManagerUtil.a(localMessageRecord2))) {
            break label165;
          }
          localMessageRecord2.isMultiMsg = localMessageForReplyText.isMultiMsg;
          localArrayList.add(localMessageRecord2);
        }
        for (;;)
        {
          i += 1;
          break label86;
          break;
          label165:
          localArrayList.add(localMessageRecord1);
          continue;
          label175:
          localArrayList.add(localMessageRecord1);
        }
      }
    }
    return this.b;
  }
  
  public void a(int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2)
  {
    a(this.b, this.jdField_a_of_type_JavaUtilHashMap);
    paramList2 = new ArrayList();
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      paramList2.addAll(paramList1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(paramList2, null);
    }
    if (paramInt == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqMultimsgIMultiMsgRichUploadCallback.a(1, 2, this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgRequest);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqMultimsgIMultiMsgRichUploadCallback.a(0, 2, this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgRequest);
  }
  
  public void a(String paramString, List<MessageRecord> paramList, MessageRecord paramMessageRecord, int paramInt)
  {
    if ((paramList == null) || (paramMessageRecord == null)) {}
    do
    {
      return;
      paramList = (List)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      paramString = null;
      if (paramList != null) {
        paramString = (MessageRecord)paramList.get(paramInt);
      }
    } while (paramString == null);
    if ((paramString instanceof MessageForReplyText))
    {
      paramList = HardCodeUtil.a(2131707028) + paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
      paramList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(paramMessageRecord, paramList, true);
      ((MessageForReplyText)paramString).setSourceMessageRecord(paramList);
      return;
    }
    paramString = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFaildReason");
    paramList.set(paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(paramMessageRecord, paramString, true));
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgRequest == null) {
      return "";
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgRequest.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
      return "";
    }
    return String.valueOf(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgRequest.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.msgforward.MultiMsgForwardRequest
 * JD-Core Version:    0.7.0.1
 */