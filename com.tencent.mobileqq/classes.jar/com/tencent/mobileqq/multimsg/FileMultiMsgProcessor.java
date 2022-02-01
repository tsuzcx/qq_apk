package com.tencent.mobileqq.multimsg;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager;
import com.tencent.mobileqq.filemanager.data.msgforward.MultiMsgForwardRequest;
import com.tencent.mobileqq.filemanager.data.msgforward.ReplyMsgForwardRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class FileMultiMsgProcessor
  extends BaseMultiMsgProcessor
{
  public FileMultiMsgProcessor(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(HashMap<String, ArrayList<MessageRecord>> paramHashMap)
  {
    if (paramHashMap != null)
    {
      if (paramHashMap.isEmpty()) {
        return;
      }
      Iterator localIterator = paramHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        ArrayList localArrayList = (ArrayList)paramHashMap.get((String)localIterator.next());
        int i = 0;
        while (i < localArrayList.size())
        {
          MessageRecord localMessageRecord = (MessageRecord)localArrayList.get(i);
          if (((localMessageRecord instanceof MessageForFile)) || ((localMessageRecord instanceof MessageForTroopFile)))
          {
            Object localObject = new StringBuilder();
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131889249));
            ((StringBuilder)localObject).append(localMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName"));
            localObject = ((StringBuilder)localObject).toString();
            localArrayList.set(i, this.a.getProxyManager().b().a(localMessageRecord, (String)localObject, true));
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(MultiMsgRequest paramMultiMsgRequest, HashMap<String, ArrayList<MessageRecord>> paramHashMap, IMultiMsgRichUploadCallback paramIMultiMsgRichUploadCallback)
  {
    if (paramMultiMsgRequest == null) {
      return;
    }
    if ((paramMultiMsgRequest.i != 8) && (paramMultiMsgRequest.i != 9))
    {
      if (paramMultiMsgRequest.i == 2)
      {
        a(paramHashMap);
        paramIMultiMsgRichUploadCallback.a(0, 2, paramMultiMsgRequest);
        return;
      }
      paramMultiMsgRequest = new MultiMsgForwardRequest(this.a, paramMultiMsgRequest, paramHashMap, paramIMultiMsgRichUploadCallback);
    }
    else
    {
      paramMultiMsgRequest = new ReplyMsgForwardRequest(this.a, paramMultiMsgRequest, paramHashMap, paramIMultiMsgRichUploadCallback);
    }
    this.a.getFileManagerEngine().e().a(paramMultiMsgRequest, paramHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.FileMultiMsgProcessor
 * JD-Core Version:    0.7.0.1
 */