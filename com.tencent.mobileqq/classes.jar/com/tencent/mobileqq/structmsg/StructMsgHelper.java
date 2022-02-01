package com.tencent.mobileqq.structmsg;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemProgress;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;

public class StructMsgHelper
{
  public static AbsStructMsg a(ArrayList<String> paramArrayList)
  {
    int i;
    if (paramArrayList != null) {
      i = paramArrayList.size();
    } else {
      i = 0;
    }
    if (i <= 0) {
      return null;
    }
    StructMsgForGeneralShare localStructMsgForGeneralShare = new StructMsgForGeneralShare();
    localStructMsgForGeneralShare.setFlag(1);
    localStructMsgForGeneralShare.mMsgTemplateID = 1;
    localStructMsgForGeneralShare.mMsgServiceID = 19;
    localStructMsgForGeneralShare.mMsgBrief = HardCodeUtil.a(2131911927);
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
      localAbsStructMsgItem1.a(new StructMsgItemSummary(HardCodeUtil.a(2131911917)));
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
    else
    {
      localAbsStructMsgItem1.a(new StructMsgItemCover((String)paramArrayList.get(0)));
      localAbsStructMsgItem1.a(new StructMsgItemCover((String)paramArrayList.get(1)));
      localAbsStructMsgItem1.a(new StructMsgItemCover((String)paramArrayList.get(2)));
    }
    paramArrayList = StructMsgElementFactory.a(0);
    paramArrayList.a(new StructMsgItemProgress(0));
    AbsStructMsgItem localAbsStructMsgItem2 = StructMsgElementFactory.a(0);
    localAbsStructMsgItem2.a(new StructMsgItemSummary(HardCodeUtil.a(2131911909)));
    localStructMsgForGeneralShare.addItem(localAbsStructMsgItem1);
    localStructMsgForGeneralShare.addItem(paramArrayList);
    localStructMsgForGeneralShare.addItem(localAbsStructMsgItem2);
    return localStructMsgForGeneralShare;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMessageRecord != null)
    {
      if (paramMessageRecord.msgtype != -2011) {
        return false;
      }
      paramMessageRecord = ((MessageForStructing)paramMessageRecord).structingMsg;
      bool1 = bool2;
      if (paramMessageRecord != null)
      {
        bool1 = bool2;
        if (paramMessageRecord.mMsgServiceID == 19) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgHelper
 * JD-Core Version:    0.7.0.1
 */