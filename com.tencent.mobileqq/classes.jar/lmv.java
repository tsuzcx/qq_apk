import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public class lmv
  implements Runnable
{
  public lmv(ReadinjoySPEventReport paramReadinjoySPEventReport, int paramInt, long paramLong) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    oidb_cmd0x80a.AttributeList localAttributeList1 = new oidb_cmd0x80a.AttributeList();
    localAttributeList1.att_id.set(1);
    localAttributeList1.att_name.set("action");
    localAttributeList1.att_value.set("" + this.jdField_a_of_type_Int);
    oidb_cmd0x80a.AttributeList localAttributeList2 = new oidb_cmd0x80a.AttributeList();
    localAttributeList2.att_id.set(2);
    localAttributeList2.att_name.set("leavetime");
    localAttributeList2.att_value.set(String.valueOf(this.jdField_a_of_type_Long / 1000L));
    localArrayList.add(localAttributeList1);
    localArrayList.add(localAttributeList2);
    PublicAccountUtil.a(20, "AppinpushDisappear", localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lmv
 * JD-Core Version:    0.7.0.1
 */