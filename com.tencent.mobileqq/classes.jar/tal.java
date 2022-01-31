import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqLikeFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspLikeFeed;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class tal
  extends tbd
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  int b = -1;
  
  public tal(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.b = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  public String a()
  {
    return tai.b;
  }
  
  public tbe a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspLikeFeed localRspLikeFeed = new qqstory_service.RspLikeFeed();
    try
    {
      localRspLikeFeed.mergeFrom(paramArrayOfByte);
      return new tam(localRspLikeFeed);
    }
    catch (Exception paramArrayOfByte)
    {
      veg.d("Q.qqstory:FeedLikeDataProvider", "" + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqLikeFeed localReqLikeFeed = new qqstory_service.ReqLikeFeed();
    localReqLikeFeed.feed_id.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    PBUInt32Field localPBUInt32Field = localReqLikeFeed.operation;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      localPBUInt32Field.set(i);
      localReqLikeFeed.source.set(this.jdField_a_of_type_Int);
      if (this.b != -1) {
        localReqLikeFeed.type.set(this.b);
      }
      return localReqLikeFeed.toByteArray();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tal
 * JD-Core Version:    0.7.0.1
 */