import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.readinjoy.struct.Kandian210Msg0xeeInfo.NotifyInfo;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public class lpj
  implements Runnable
{
  public lpj(ReadinjoySPEventReport paramReadinjoySPEventReport, Kandian210Msg0xeeInfo.NotifyInfo paramNotifyInfo, int paramInt) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(1);
    ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("FolderStatus");
    ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo$NotifyInfo.folderStatus + "");
    oidb_cmd0x80a.AttributeList localAttributeList1 = new oidb_cmd0x80a.AttributeList();
    localAttributeList1.att_id.set(2);
    localAttributeList1.att_name.set("StrategyID");
    localAttributeList1.att_value.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo$NotifyInfo.strategyID + "");
    oidb_cmd0x80a.AttributeList localAttributeList2 = new oidb_cmd0x80a.AttributeList();
    localAttributeList2.att_id.set(3);
    localAttributeList2.att_name.set("AlgorithmID");
    localAttributeList2.att_value.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo$NotifyInfo.algorithmID + "");
    localArrayList.add(localObject);
    localArrayList.add(localAttributeList1);
    localArrayList.add(localAttributeList2);
    int i;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 2: 
      i = 17;
    }
    for (localObject = "AppInPushClick";; localObject = "AppInPushExposure")
    {
      PublicAccountUtil.a(i, (String)localObject, localArrayList);
      return;
      i = 16;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lpj
 * JD-Core Version:    0.7.0.1
 */