import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.ForeBackGround;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public final class lpe
  implements Runnable
{
  public lpe(boolean paramBoolean) {}
  
  public void run()
  {
    int i = 1;
    if (this.a) {
      ReadinjoySPEventReport.c(System.currentTimeMillis());
    }
    Object localObject;
    if (ReadinjoySPEventReport.b(9))
    {
      ArrayList localArrayList = new ArrayList();
      oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(1);
      localAttributeList.att_name.set("isOn");
      PBStringField localPBStringField = localAttributeList.att_value;
      if (!this.a) {
        break label272;
      }
      localObject = String.valueOf(1);
      localPBStringField.set((String)localObject);
      localArrayList.add(localAttributeList);
      if (!this.a)
      {
        long l = ReadinjoySPEventReport.d();
        if (ReadinjoySPEventReport.d() == 0L)
        {
          l = ReadinjoySPEventReport.e();
          i = 0;
        }
        l = (System.currentTimeMillis() - l) / 1000L;
        localObject = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(2);
        ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("time");
        ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(String.valueOf(l));
        localArrayList.add(localObject);
        localAttributeList = new oidb_cmd0x80a.AttributeList();
        localAttributeList.att_id.set(3);
        localAttributeList.att_name.set("isScreenTime");
        localPBStringField = localAttributeList.att_value;
        if (i == 0) {
          break label281;
        }
        localObject = "1";
        label226:
        localPBStringField.set((String)localObject);
        localArrayList.add(localAttributeList);
      }
      PublicAccountUtil.a(9, "ScreenSwitch", localArrayList);
      if (!this.a) {
        break label288;
      }
      ReadinjoySPEventReport.d(System.currentTimeMillis());
      ReadinjoySPEventReport.c(0);
    }
    label272:
    label281:
    label288:
    do
    {
      return;
      localObject = String.valueOf(0);
      break;
      localObject = "0";
      break label226;
      ReadinjoySPEventReport.a();
    } while (ReadinjoySPEventReport.ForeBackGround.a == 2);
    ReadinjoySPEventReport.d(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lpe
 * JD-Core Version:    0.7.0.1
 */