import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqFeedCommentList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspFeedCommentList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class szn
  extends slz
{
  public static final String a;
  public uiv a;
  
  static
  {
    jdField_a_of_type_JavaLangString = skt.a("StorySvc.feed_comment_list_775");
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public slu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspFeedCommentList localRspFeedCommentList = new qqstory_service.RspFeedCommentList();
    try
    {
      localRspFeedCommentList.mergeFrom(paramArrayOfByte);
      return new szo(localRspFeedCommentList);
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
    qqstory_service.ReqFeedCommentList localReqFeedCommentList = new qqstory_service.ReqFeedCommentList();
    localReqFeedCommentList.feed_id.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Uiv.jdField_a_of_type_JavaLangString));
    if (this.jdField_a_of_type_Uiv.jdField_b_of_type_JavaLangString == null) {
      this.jdField_a_of_type_Uiv.jdField_b_of_type_JavaLangString = "";
    }
    localReqFeedCommentList.cookie.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Uiv.jdField_b_of_type_JavaLangString));
    localReqFeedCommentList.source.set(this.jdField_a_of_type_Uiv.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Uiv.jdField_b_of_type_Int != -1) {
      localReqFeedCommentList.type.set(this.jdField_a_of_type_Uiv.jdField_b_of_type_Int);
    }
    return localReqFeedCommentList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     szn
 * JD-Core Version:    0.7.0.1
 */