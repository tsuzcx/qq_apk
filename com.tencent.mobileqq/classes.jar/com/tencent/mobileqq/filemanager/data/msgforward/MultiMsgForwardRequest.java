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
  HashMap<String, ArrayList<MessageRecord>> a;
  private QQAppInterface b;
  private MultiMsgRequest c;
  private IMultiMsgRichUploadCallback d;
  private HashMap<String, ArrayList<MessageRecord>> e;
  
  public MultiMsgForwardRequest(QQAppInterface paramQQAppInterface, MultiMsgRequest paramMultiMsgRequest, HashMap<String, ArrayList<MessageRecord>> paramHashMap, IMultiMsgRichUploadCallback paramIMultiMsgRichUploadCallback)
  {
    this.b = paramQQAppInterface;
    this.c = paramMultiMsgRequest;
    this.d = paramIMultiMsgRichUploadCallback;
    this.a = paramHashMap;
  }
  
  public String a()
  {
    MultiMsgRequest localMultiMsgRequest = this.c;
    if (localMultiMsgRequest == null) {
      return "";
    }
    if (localMultiMsgRequest.e == null) {
      return "";
    }
    return String.valueOf(this.c.e.uniseq);
  }
  
  public void a(int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2)
  {
    a(this.e, this.a);
    paramList2 = new ArrayList();
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      paramList2.addAll(paramList1);
      this.b.getProxyManager().b().a(paramList2, null);
    }
    if (paramInt == 1)
    {
      this.d.a(1, 2, this.c);
      return;
    }
    this.d.a(0, 2, this.c);
  }
  
  public void a(String paramString, List<MessageRecord> paramList, MessageRecord paramMessageRecord, int paramInt)
  {
    if (paramList != null)
    {
      if (paramMessageRecord == null) {
        return;
      }
      paramList = (List)this.a.get(paramString);
      paramString = null;
      if (paramList != null) {
        paramString = (MessageRecord)paramList.get(paramInt);
      }
      if (paramString != null)
      {
        if ((paramString instanceof MessageForReplyText))
        {
          paramList = new StringBuilder();
          paramList.append(HardCodeUtil.a(2131904890));
          paramList.append(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName"));
          paramList = paramList.toString();
          paramList = this.b.getProxyManager().b().a(paramMessageRecord, paramList, true);
          ((MessageForReplyText)paramString).setSourceMessageRecord(paramList);
          return;
        }
        paramString = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFaildReason");
        paramList.set(paramInt, this.b.getProxyManager().b().a(paramMessageRecord, paramString, true));
      }
    }
  }
  
  public String b()
  {
    MultiMsgRequest localMultiMsgRequest = this.c;
    if (localMultiMsgRequest == null) {
      return "";
    }
    if (localMultiMsgRequest.a == null) {
      return "";
    }
    return String.valueOf(this.c.a.b);
  }
  
  public int c()
  {
    MultiMsgRequest localMultiMsgRequest = this.c;
    if (localMultiMsgRequest == null) {
      return -1;
    }
    if (localMultiMsgRequest.a == null) {
      return -1;
    }
    return this.c.a.a;
  }
  
  public HashMap<String, ArrayList<MessageRecord>> d()
  {
    if (this.e == null)
    {
      this.e = new HashMap();
      Iterator localIterator = this.a.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        ArrayList localArrayList = new ArrayList();
        this.e.put(localObject, localArrayList);
        localObject = (ArrayList)this.a.get(localObject);
        int i = 0;
        while (i < ((ArrayList)localObject).size())
        {
          MessageRecord localMessageRecord1 = (MessageRecord)((ArrayList)localObject).get(i);
          if ((localMessageRecord1 instanceof MessageForReplyText))
          {
            MessageForReplyText localMessageForReplyText = (MessageForReplyText)localMessageRecord1;
            MessageRecord localMessageRecord2 = localMessageForReplyText.getSourceMessage();
            if ((localMessageRecord2 != null) && (FileManagerUtil.a(localMessageRecord2)))
            {
              localMessageRecord2.isMultiMsg = localMessageForReplyText.isMultiMsg;
              localArrayList.add(localMessageRecord2);
            }
            else
            {
              localArrayList.add(localMessageRecord1);
            }
          }
          else
          {
            localArrayList.add(localMessageRecord1);
          }
          i += 1;
        }
      }
    }
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.msgforward.MultiMsgForwardRequest
 * JD-Core Version:    0.7.0.1
 */