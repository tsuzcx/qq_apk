import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqFeedLikeList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspFeedLikeList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class tag
  extends tba
{
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  
  public tag(taf paramtaf, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public String a()
  {
    return taf.jdField_a_of_type_JavaLangString;
  }
  
  public tbb a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspFeedLikeList localRspFeedLikeList = new qqstory_service.RspFeedLikeList();
    try
    {
      localRspFeedLikeList.mergeFrom(paramArrayOfByte);
      return new tah(this.jdField_a_of_type_Taf, localRspFeedLikeList, this.jdField_a_of_type_Boolean);
    }
    catch (Exception paramArrayOfByte)
    {
      ved.d("Q.qqstory:FeedLikeDataProvider", "" + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqFeedLikeList localReqFeedLikeList = new qqstory_service.ReqFeedLikeList();
    localReqFeedLikeList.feed_id.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 2;; i = 1)
    {
      localReqFeedLikeList.source.set(i);
      return localReqFeedLikeList.toByteArray();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tag
 * JD-Core Version:    0.7.0.1
 */