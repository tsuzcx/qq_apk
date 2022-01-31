import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqMsgTabNodeWatched;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeWatched;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class sto
  extends slz<stp>
{
  static final String a = skt.a("StorySvc.msgtab_node_click");
  public long b;
  public String b;
  public int c;
  
  public String a()
  {
    return a;
  }
  
  public slu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspMsgTabNodeWatched localRspMsgTabNodeWatched = new qqstory_service.RspMsgTabNodeWatched();
    try
    {
      localRspMsgTabNodeWatched.mergeFrom(paramArrayOfByte);
      return new stp(localRspMsgTabNodeWatched);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      urk.d("Q.qqstory.msgTab:ReqMsgTabNodeClick", "" + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqMsgTabNodeWatched localReqMsgTabNodeWatched = new qqstory_service.ReqMsgTabNodeWatched();
    localReqMsgTabNodeWatched.unionID.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_JavaLangString));
    localReqMsgTabNodeWatched.node_type.set(this.c);
    localReqMsgTabNodeWatched.operation.set(3);
    localReqMsgTabNodeWatched.recommend_id.set(this.jdField_b_of_type_Long);
    return localReqMsgTabNodeWatched.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sto
 * JD-Core Version:    0.7.0.1
 */