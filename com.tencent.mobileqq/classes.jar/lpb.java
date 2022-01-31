import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public final class lpb
  implements Runnable
{
  public lpb(List paramList, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int j = 0;
    long l2;
    ArrayList localArrayList;
    oidb_cmd0x80a.AttributeList localAttributeList;
    PBStringField localPBStringField;
    if (ReadinjoySPEventReport.b(60))
    {
      long l1 = ReadinjoySPEventReport.b();
      l2 = ReadinjoySPEventReport.a(l1 * 1000L) / 1000L;
      int k = this.jdField_a_of_type_JavaUtilList.size() - 1;
      int i = 0;
      if (k >= 0)
      {
        localObject = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(k);
        if (((ChatMessage)localObject).time > l1)
        {
          if (((ChatMessage)localObject).isSendFromLocal())
          {
            i = j;
            j = 1;
          }
          for (;;)
          {
            int m = k - 1;
            k = j;
            j = i;
            i = k;
            k = m;
            break;
            m = 1;
            j = i;
            i = m;
          }
        }
      }
      localArrayList = new ArrayList();
      localObject = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(1);
      ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("aiotype");
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(String.valueOf(ReadinjoySPEventReport.a(this.jdField_a_of_type_Int)));
      localArrayList.add(localObject);
      localObject = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(2);
      ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("unreadmsg");
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set("" + this.b);
      localArrayList.add(localObject);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(3);
      localAttributeList.att_name.set("hassendmsg");
      localPBStringField = localAttributeList.att_value;
      if (i == 0) {
        break label443;
      }
      localObject = "1";
      localPBStringField.set((String)localObject);
      localArrayList.add(localAttributeList);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(4);
      localAttributeList.att_name.set("hasrecvmsg");
      localPBStringField = localAttributeList.att_value;
      if (j == 0) {
        break label450;
      }
    }
    label443:
    label450:
    for (Object localObject = "1";; localObject = "0")
    {
      localPBStringField.set((String)localObject);
      localArrayList.add(localAttributeList);
      localObject = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(5);
      ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("costtime");
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set("" + l2);
      localArrayList.add(localObject);
      PublicAccountUtil.a(60, "ExitChatAIO", localArrayList);
      return;
      localObject = "0";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lpb
 * JD-Core Version:    0.7.0.1
 */