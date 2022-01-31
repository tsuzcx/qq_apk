import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqProfileStoryFeedIdList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspProfileStoryFeedIdList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;

public class szx
  extends slz
{
  public String a;
  public String b;
  
  public String a()
  {
    return skt.a("StorySvc.get_profile_feed_id_list");
  }
  
  public slu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspProfileStoryFeedIdList localRspProfileStoryFeedIdList = new qqstory_service.RspProfileStoryFeedIdList();
    try
    {
      localRspProfileStoryFeedIdList.mergeFrom(paramArrayOfByte);
      return new szy(localRspProfileStoryFeedIdList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqProfileStoryFeedIdList localReqProfileStoryFeedIdList = new qqstory_service.ReqProfileStoryFeedIdList();
    localReqProfileStoryFeedIdList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.a));
    localReqProfileStoryFeedIdList.union_id.set(ByteStringMicro.copyFromUtf8(this.b));
    return localReqProfileStoryFeedIdList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     szx
 * JD-Core Version:    0.7.0.1
 */