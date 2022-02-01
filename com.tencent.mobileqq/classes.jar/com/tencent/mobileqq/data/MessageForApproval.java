package com.tencent.mobileqq.data;

import anvx;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.trunk.Qworkflow.Qworkflow.Text;
import com.trunk.Qworkflow.Qworkflow.WorkflowChangeNotification;
import com.trunk.Qworkflow.Qworkflow.WorkflowState;

public class MessageForApproval
  extends ChatMessage
{
  public int approvalStatus;
  public long creator;
  public int mainType;
  public int notifyType;
  public int serviceType;
  public int subType;
  public String summary;
  public String title;
  public String workId;
  
  protected void doParse()
  {
    try
    {
      Qworkflow.WorkflowChangeNotification localWorkflowChangeNotification = new Qworkflow.WorkflowChangeNotification();
      localWorkflowChangeNotification.mergeFrom(this.msgData);
      this.workId = localWorkflowChangeNotification.bytes_workflow_id.get().toStringUtf8();
      this.mainType = localWorkflowChangeNotification.uint32_main_type.get();
      this.subType = localWorkflowChangeNotification.uint32_sub_type.get();
      this.creator = localWorkflowChangeNotification.uint64_author_uin.get();
      this.title = localWorkflowChangeNotification.bytes_title.get().toStringUtf8();
      this.summary = localWorkflowChangeNotification.msg_summary.bytes_content.get().toStringUtf8();
      this.notifyType = localWorkflowChangeNotification.enum_change_type.get();
      this.approvalStatus = localWorkflowChangeNotification.msg_current_state.uint32_state_num.get();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MessageForApproval_Approval", 1, localException.toString());
    }
  }
  
  public String getFullTitle()
  {
    if (!this.mIsParsed) {
      parse();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int i;
      Object localObject;
      try
      {
        String[] arrayOfString = this.title.split("\002");
        localStringBuilder.append("申请");
        int j = arrayOfString.length;
        i = 0;
        String str1 = "";
        if (i < j)
        {
          localObject = arrayOfString[i];
          if (((String)localObject).startsWith("000"))
          {
            String str3 = ((String)localObject).substring(3);
            localObject = str3;
            if (anvx.a(2131706082).equalsIgnoreCase(str3)) {
              localObject = anvx.a(2131706041);
            }
            localStringBuilder.append((String)localObject);
          }
          else if (((String)localObject).startsWith("001"))
          {
            localStringBuilder.append(((String)localObject).substring(3));
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isDevelopLevel()) {
          localStringBuilder.append("解析出错了，快查!");
        }
      }
      for (;;)
      {
        return anvx.a(2131706061) + localStringBuilder.toString();
        if (((String)localObject).startsWith("002"))
        {
          localStringBuilder.append(((String)localObject).substring(3));
          break;
        }
        if (!((String)localObject).startsWith("003")) {
          break;
        }
        String str2 = ((String)localObject).substring(3);
        break;
        if ("1".equalsIgnoreCase(str2) == true) {
          localStringBuilder.append("(含周末)");
        }
      }
      i += 1;
    }
  }
  
  public String getSummaryMsg()
  {
    return anvx.a(2131706077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForApproval
 * JD-Core Version:    0.7.0.1
 */