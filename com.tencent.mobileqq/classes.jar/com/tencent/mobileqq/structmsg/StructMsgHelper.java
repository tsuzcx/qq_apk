package com.tencent.mobileqq.structmsg;

import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemProgress;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;

public class StructMsgHelper
{
  public static AbsStructMsg a(ArrayList paramArrayList)
  {
    if (paramArrayList != null) {}
    for (int i = paramArrayList.size(); i <= 0; i = 0) {
      return null;
    }
    StructMsgForGeneralShare localStructMsgForGeneralShare = new StructMsgForGeneralShare();
    localStructMsgForGeneralShare.setFlag(1);
    localStructMsgForGeneralShare.mMsgTemplateID = 1;
    localStructMsgForGeneralShare.mMsgServiceID = 19;
    localStructMsgForGeneralShare.mMsgBrief = "图片上传中";
    localStructMsgForGeneralShare.mMsgAction = "plugin";
    localStructMsgForGeneralShare.mMsgActionData = "mqqapi://qzone/to_publish_queue";
    localStructMsgForGeneralShare.mMsg_A_ActionData = "";
    localStructMsgForGeneralShare.mMsg_I_ActionData = "";
    localStructMsgForGeneralShare.mMsgUrl = "";
    if (i == 1)
    {
      localAbsStructMsgItem1 = StructMsgElementFactory.a(2);
      localAbsStructMsgItem1.a(new StructMsgItemCover((String)paramArrayList.get(0)));
      localAbsStructMsgItem1.a(new StructMsgItemTitle(""));
      localAbsStructMsgItem1.a(new StructMsgItemSummary("上传中"));
      paramArrayList = StructMsgElementFactory.a(0);
      paramArrayList.a(new StructMsgItemProgress(0));
      localStructMsgForGeneralShare.addItem(localAbsStructMsgItem1);
      localStructMsgForGeneralShare.addItem(paramArrayList);
      return localStructMsgForGeneralShare;
    }
    AbsStructMsgItem localAbsStructMsgItem1 = StructMsgElementFactory.a(3);
    if (i == 2)
    {
      localAbsStructMsgItem1.a(new StructMsgItemCover((String)paramArrayList.get(0)));
      localAbsStructMsgItem1.a(new StructMsgItemCover((String)paramArrayList.get(1)));
    }
    for (;;)
    {
      paramArrayList = StructMsgElementFactory.a(0);
      paramArrayList.a(new StructMsgItemProgress(0));
      AbsStructMsgItem localAbsStructMsgItem2 = StructMsgElementFactory.a(0);
      localAbsStructMsgItem2.a(new StructMsgItemSummary("上传中"));
      localStructMsgForGeneralShare.addItem(localAbsStructMsgItem1);
      localStructMsgForGeneralShare.addItem(paramArrayList);
      localStructMsgForGeneralShare.addItem(localAbsStructMsgItem2);
      break;
      localAbsStructMsgItem1.a(new StructMsgItemCover((String)paramArrayList.get(0)));
      localAbsStructMsgItem1.a(new StructMsgItemCover((String)paramArrayList.get(1)));
      localAbsStructMsgItem1.a(new StructMsgItemCover((String)paramArrayList.get(2)));
    }
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (paramMessageRecord.msgtype != -2011)) {}
    do
    {
      return false;
      paramMessageRecord = ((MessageForStructing)paramMessageRecord).structingMsg;
    } while ((paramMessageRecord == null) || (paramMessageRecord.mMsgServiceID != 19));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgHelper
 * JD-Core Version:    0.7.0.1
 */