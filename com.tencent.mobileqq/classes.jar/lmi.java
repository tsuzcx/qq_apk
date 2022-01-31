import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public final class lmi
  implements Runnable
{
  public lmi(long paramLong) {}
  
  public void run()
  {
    if (ReadinjoySPEventReport.b(23))
    {
      oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(1);
      localAttributeList.att_name.set("time");
      localAttributeList.att_value.set(String.valueOf(this.a / 1000L));
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localAttributeList);
      PublicAccountUtil.a(23, "LeaveQQ", localArrayList);
    }
    ThreadManager.executeOnSubThread(new lmj(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lmi
 * JD-Core Version:    0.7.0.1
 */