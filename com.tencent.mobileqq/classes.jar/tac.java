import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetShareGroupInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetShareGroupInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.Iterator;
import java.util.List;

public class tac
  extends slz<tbs>
{
  private final String a;
  public List<String> a;
  
  public tac()
  {
    this.jdField_a_of_type_JavaLangString = skt.a("StorySvc.get_share_group_info");
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public slu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetShareGroupInfo localRspGetShareGroupInfo = new qqstory_service.RspGetShareGroupInfo();
    try
    {
      localRspGetShareGroupInfo.mergeFrom(paramArrayOfByte);
      return new tbs(localRspGetShareGroupInfo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      urk.b("Q.qqstory.shareGroup:GetShareGroupInfoRequest", a(), paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqGetShareGroupInfo localReqGetShareGroupInfo = new qqstory_service.ReqGetShareGroupInfo();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localReqGetShareGroupInfo.share_group_id_list.add(str);
    }
    return localReqGetShareGroupInfo.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tac
 * JD-Core Version:    0.7.0.1
 */