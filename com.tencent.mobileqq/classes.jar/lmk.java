import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public final class lmk
  implements Runnable
{
  public lmk(int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    oidb_cmd0x80a.AttributeList localAttributeList1;
    oidb_cmd0x80a.AttributeList localAttributeList2;
    PBStringField localPBStringField;
    if (ReadinjoySPEventReport.b(7))
    {
      localAttributeList1 = new oidb_cmd0x80a.AttributeList();
      localAttributeList1.att_id.set(1);
      localAttributeList1.att_name.set("tab");
      localAttributeList1.att_value.set(String.valueOf(this.jdField_a_of_type_Int));
      localAttributeList2 = new oidb_cmd0x80a.AttributeList();
      localAttributeList2.att_id.set(4);
      localAttributeList2.att_name.set("redStatus");
      localPBStringField = localAttributeList2.att_value;
      if (!this.jdField_a_of_type_Boolean) {
        break label127;
      }
    }
    label127:
    for (Object localObject = "1";; localObject = "0")
    {
      localPBStringField.set((String)localObject);
      localObject = new ArrayList();
      ((List)localObject).add(localAttributeList1);
      ((List)localObject).add(localAttributeList2);
      PublicAccountUtil.a(7, "ClickTab", (List)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lmk
 * JD-Core Version:    0.7.0.1
 */