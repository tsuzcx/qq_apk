import com.tencent.biz.qqstory.network.pb.qqstory_service.RspCheckBlackList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.List;

public class sqh
  extends syn
{
  public List<qqstory_struct.GpsMsg> a;
  
  public sqh(qqstory_service.RspCheckBlackList paramRspCheckBlackList)
  {
    super(paramRspCheckBlackList.result);
    this.a = paramRspCheckBlackList.black_gps_list.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sqh
 * JD-Core Version:    0.7.0.1
 */