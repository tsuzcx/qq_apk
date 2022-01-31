import com.tencent.biz.qqstory.network.pb.qqstory_service.RspCheckBlackList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.List;

public class sdo
  extends slu
{
  public List<qqstory_struct.GpsMsg> a;
  
  public sdo(qqstory_service.RspCheckBlackList paramRspCheckBlackList)
  {
    super(paramRspCheckBlackList.result);
    this.a = paramRspCheckBlackList.black_gps_list.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sdo
 * JD-Core Version:    0.7.0.1
 */