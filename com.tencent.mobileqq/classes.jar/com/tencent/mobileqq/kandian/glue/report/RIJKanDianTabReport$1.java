package com.tencent.mobileqq.kandian.glue.report;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;

final class RIJKanDianTabReport$1
  implements Runnable
{
  RIJKanDianTabReport$1(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject1 = this.a;
    int i;
    if (localObject1 == null) {
      i = 1;
    } else if (((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.get() == 5) {
      i = 3;
    } else {
      i = 2;
    }
    String str2;
    if (i == 3) {
      str2 = this.a.red_content.get();
    } else {
      str2 = "0";
    }
    boolean bool = ReadInJoyHelper.v();
    String str1 = "";
    Object localObject2;
    Object localObject3;
    if (!bool)
    {
      localObject2 = RIJKanDianFolderStatus.getMessageRecordFormLastMsgForMsgTab(this.b);
      if (localObject2 == null) {
        return;
      }
      if (!RIJKanDianFolderStatus.isRedDotMessageRecord((MessageRecord)localObject2)) {
        return;
      }
      if (RIJKanDianFolderStatus.isRedDotMessageRecord((MessageRecord)localObject2))
      {
        localObject1 = RIJKanDianTabReport.a(this.b, (MessageRecord)localObject2);
        str1 = RIJKanDianTabReport.b(this.b, (MessageRecord)localObject2);
        localObject2 = RIJKanDianTabReport.c(this.b, (MessageRecord)localObject2);
        if (RIJKanDianTabReport.b()) {
          return;
        }
      }
      else
      {
        localObject2 = "";
        localObject1 = localObject2;
      }
      localObject3 = localObject1;
    }
    else
    {
      if (i == 1) {
        return;
      }
      str1 = "";
      localObject1 = str1;
      localObject3 = localObject1;
      localObject2 = localObject1;
    }
    RIJKanDianTabReport.a(str1, (String)localObject2, i, str2, localObject3, this.b);
    RIJKanDianTabReport.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.RIJKanDianTabReport.1
 * JD-Core Version:    0.7.0.1
 */