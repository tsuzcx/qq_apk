package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.HardCodeUtil;
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
    try
    {
      arrayOfString = this.title.split("\002");
      localStringBuilder.append("申请");
      j = arrayOfString.length;
      i = 0;
      localObject1 = "";
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String[] arrayOfString;
        int j;
        int i;
        Object localObject1;
        Object localObject2;
        String str;
        label217:
        continue;
        i += 1;
      }
    }
    if (i < j)
    {
      localObject2 = arrayOfString[i];
      if (((String)localObject2).startsWith("000"))
      {
        str = ((String)localObject2).substring(3);
        localObject2 = str;
        if (HardCodeUtil.a(2131904495).equalsIgnoreCase(str)) {
          localObject2 = HardCodeUtil.a(2131904455);
        }
        localStringBuilder.append((String)localObject2);
      }
      else if (((String)localObject2).startsWith("001"))
      {
        localStringBuilder.append(((String)localObject2).substring(3));
      }
      else if (((String)localObject2).startsWith("002"))
      {
        localStringBuilder.append(((String)localObject2).substring(3));
      }
      else if (((String)localObject2).startsWith("003"))
      {
        localObject1 = ((String)localObject2).substring(3);
      }
    }
    else
    {
      if ("1".equalsIgnoreCase((String)localObject1) == true)
      {
        localStringBuilder.append("(含周末)");
        break label217;
        if (QLog.isDevelopLevel()) {
          localStringBuilder.append("解析出错了，快查!");
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131904474));
      ((StringBuilder)localObject1).append(localStringBuilder.toString());
      return ((StringBuilder)localObject1).toString();
    }
  }
  
  public String getSummaryMsg()
  {
    return HardCodeUtil.a(2131904490);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForApproval
 * JD-Core Version:    0.7.0.1
 */