package com.tencent.mobileqq.filemanager.data.msgforward;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.multimsg.IMultiMsgRichUploadCallback;
import com.tencent.mobileqq.multimsg.MultiMsgRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ReplyMsgForwardRequest
  extends QFileMsgForwardRequest
{
  HashMap<String, ArrayList<MessageRecord>> a;
  private QQAppInterface b;
  private MultiMsgRequest c;
  private IMultiMsgRichUploadCallback d;
  private MessageForReplyText e;
  private String f;
  private HashMap<String, ArrayList<MessageRecord>> g;
  
  public ReplyMsgForwardRequest(QQAppInterface paramQQAppInterface, MultiMsgRequest paramMultiMsgRequest, HashMap<String, ArrayList<MessageRecord>> paramHashMap, IMultiMsgRichUploadCallback paramIMultiMsgRichUploadCallback)
  {
    this.b = paramQQAppInterface;
    this.c = paramMultiMsgRequest;
    this.d = paramIMultiMsgRichUploadCallback;
    this.a = paramHashMap;
    paramQQAppInterface = this.a;
    if ((paramQQAppInterface != null) && (!paramQQAppInterface.isEmpty()))
    {
      paramQQAppInterface = this.a.keySet().iterator();
      do
      {
        if (!paramQQAppInterface.hasNext()) {
          break;
        }
        paramMultiMsgRequest = (String)paramQQAppInterface.next();
        paramHashMap = ((ArrayList)this.a.get(paramMultiMsgRequest)).iterator();
        while (paramHashMap.hasNext())
        {
          paramIMultiMsgRichUploadCallback = (MessageRecord)paramHashMap.next();
          if ((paramIMultiMsgRichUploadCallback instanceof MessageForReplyText))
          {
            this.e = ((MessageForReplyText)paramIMultiMsgRichUploadCallback);
            this.f = paramMultiMsgRequest;
          }
        }
      } while (this.e == null);
    }
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
    a(this.g, this.a);
    if (paramInt == 1)
    {
      paramList1 = this.e.getSourceMessage();
      paramList2 = new StringBuilder();
      paramList2.append(HardCodeUtil.a(2131910877));
      paramList2.append(paramList1.getExtInfoFromExtStr("_m_ForwardFileName"));
      paramList2 = paramList2.toString();
      paramList1 = this.b.getProxyManager().b().a(paramList1, paramList2, false);
      this.e.setSourceMessageRecord(paramList1);
      this.d.a(1, 2, this.c);
      return;
    }
    paramList2 = new ArrayList();
    if ((paramList1 != null) && (paramList1.size() > 0)) {
      paramList2.addAll(paramList1);
    }
    this.d.a(0, 2, this.c);
  }
  
  public void a(String paramString, List<MessageRecord> paramList, MessageRecord paramMessageRecord, int paramInt)
  {
    paramString = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFaildReason");
    paramList = new StringBuilder();
    paramList.append(HardCodeUtil.a(2131910876));
    paramList.append(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName"));
    paramList = paramList.toString();
    paramMessageRecord = this.b.getProxyManager().b().a(paramMessageRecord, paramList, false);
    this.e.setSourceMessageRecord(paramMessageRecord);
    paramMessageRecord = new StringBuilder();
    paramMessageRecord.append("replaceDropForwardMsg hint[ + ");
    paramMessageRecord.append(paramList);
    paramMessageRecord.append("reason[");
    paramMessageRecord.append(paramString);
    paramMessageRecord.append("]");
    QLog.i("ReplyMsgForwardRequest<QFile>", 1, paramMessageRecord.toString());
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
    if (this.g == null)
    {
      this.g = new HashMap();
      Object localObject1 = this.e;
      if ((localObject1 != null) && (((MessageForReplyText)localObject1).getSourceMessage() != null) && (!TextUtils.isEmpty(this.f)))
      {
        localObject1 = this.e.getSourceMessage();
        Object localObject2;
        if ((localObject1 instanceof MessageForFile))
        {
          localObject2 = this.b.getFileManagerDataCenter().a(((MessageRecord)localObject1).uniseq, ((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop);
          if ((localObject2 != null) && (((FileManagerEntity)localObject2).getCloudType() == 0))
          {
            QLog.i("ReplyMsgForwardRequest<QFile>", 1, "getForwardMessageList. init UploadSourceMsgList, find online file.");
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(HardCodeUtil.a(2131910878));
            ((StringBuilder)localObject2).append(((MessageRecord)localObject1).getExtInfoFromExtStr("_m_ForwardFileName"));
            localObject2 = ((StringBuilder)localObject2).toString();
            localObject2 = this.b.getProxyManager().b().a((MessageRecord)localObject1, (String)localObject2, true);
            this.e.setSourceMessageRecord((MessageRecord)localObject2);
          }
        }
        if (FileManagerUtil.a((MessageRecord)localObject1))
        {
          int i = c();
          if ((i != 0) && (i != 3000) && (i != 1))
          {
            QLog.i("ReplyMsgForwardRequest<QFile>", 1, "getForwardMessageList. init UploadSourceMsgList, find unsupport chatType file.");
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(HardCodeUtil.a(2131910875));
            ((StringBuilder)localObject2).append(((MessageRecord)localObject1).getExtInfoFromExtStr("_m_ForwardFileName"));
            localObject2 = ((StringBuilder)localObject2).toString();
            localObject1 = this.b.getProxyManager().b().a((MessageRecord)localObject1, (String)localObject2, true);
            this.e.setSourceMessageRecord((MessageRecord)localObject1);
          }
        }
        localObject1 = new ArrayList(1);
        ((ArrayList)localObject1).add(this.e.getSourceMessage());
        this.g.put(this.f, localObject1);
      }
    }
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.msgforward.ReplyMsgForwardRequest
 * JD-Core Version:    0.7.0.1
 */