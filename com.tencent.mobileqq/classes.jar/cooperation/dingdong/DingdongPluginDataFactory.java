package cooperation.dingdong;

import android.text.TextUtils;
import com.tencent.mobileqq.musicpendant.Base64;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.trunk.Qworkflow.Qworkflow.AppID;
import com.trunk.Qworkflow.Qworkflow.ContentElement;
import com.trunk.Qworkflow.Qworkflow.RemindTimer;
import com.trunk.Qworkflow.Qworkflow.Text;
import com.trunk.Qworkflow.Qworkflow.Workflow;
import com.trunk.Qworkflow.Qworkflow.WorkflowContent;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

public class DingdongPluginDataFactory
{
  public static DingdongPluginDataFactory.ScheduleSummaryData a(Qworkflow.Text paramText)
  {
    Qworkflow.Workflow localWorkflow;
    if (paramText.enum_type.get() == 3) {
      localWorkflow = new Qworkflow.Workflow();
    }
    for (;;)
    {
      Object localObject;
      String str;
      try
      {
        localWorkflow.mergeFrom(paramText.bytes_content.get().toByteArray());
        paramText = new DingdongPluginDataFactory.ScheduleSummaryData();
        if (!localWorkflow.msg_workflow_content.rpt_content_list.has()) {
          break;
        }
        Iterator localIterator = localWorkflow.msg_workflow_content.rpt_content_list.get().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Qworkflow.ContentElement)localIterator.next();
        if ((!((Qworkflow.ContentElement)localObject).bytes_userdef.has()) || (!((Qworkflow.ContentElement)localObject).rpt_text_list.has()) || (((Qworkflow.Text)((Qworkflow.ContentElement)localObject).rpt_text_list.get(0)).enum_type.get() != 0)) {
          continue;
        }
        str = ((Qworkflow.Text)((Qworkflow.ContentElement)localObject).rpt_text_list.get(0)).bytes_content.get().toStringUtf8();
        localObject = ((Qworkflow.ContentElement)localObject).bytes_userdef.get().toStringUtf8();
        if ("loc".equals(localObject))
        {
          paramText.location = str;
          continue;
          return null;
        }
      }
      catch (InvalidProtocolBufferMicroException paramText)
      {
        QLog.e("DingdongPluginProtoHelper", 1, "parseScheduleNotificationSummaryMsg error(-1):" + paramText.toString() + ".");
      }
      if ("mark".equals(localObject)) {
        paramText.mark = str;
      } else if ("title".equals(localObject)) {
        paramText.title = str;
      } else if ("url".equals(localObject))
      {
        if (!TextUtils.isEmpty(str)) {
          try
          {
            paramText.url = new String(Base64.a(str), "UTF-8");
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            localUnsupportedEncodingException.printStackTrace();
          }
        }
      }
      else if (("type".equals(localObject)) && ("announce".equals(localUnsupportedEncodingException))) {
        paramText.type = 1;
      }
    }
    if (localWorkflow.msg_remind_timer.has())
    {
      paramText.beginTime = localWorkflow.msg_remind_timer.uint64_start_time.get();
      paramText.endTime = localWorkflow.msg_remind_timer.uint64_end_time.get();
      paramText.offsetTime = localWorkflow.msg_remind_timer.uint32_remind_offset.get();
    }
    if (localWorkflow.related_source_id.has()) {
      paramText.sourceId = localWorkflow.related_source_id.uint64_appid.get();
    }
    return paramText;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.dingdong.DingdongPluginDataFactory
 * JD-Core Version:    0.7.0.1
 */