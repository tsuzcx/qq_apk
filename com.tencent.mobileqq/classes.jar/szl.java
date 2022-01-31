import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqDelFeedComment;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspDelFeedComment;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class szl
  extends tbd
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  tbf jdField_a_of_type_Tbf;
  
  public szl(CommentEntry paramCommentEntry, tbf paramtbf)
  {
    this.jdField_a_of_type_JavaLangString = paramCommentEntry.feedId;
    this.jdField_a_of_type_Int = paramCommentEntry.commentId;
    this.jdField_a_of_type_Tbf = paramtbf;
  }
  
  public String a()
  {
    return szh.b;
  }
  
  public tbe a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspDelFeedComment localRspDelFeedComment = new qqstory_service.RspDelFeedComment();
    try
    {
      localRspDelFeedComment.mergeFrom(paramArrayOfByte);
      return new szm(localRspDelFeedComment, this.jdField_a_of_type_Tbf);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      veg.d("Q.qqstory:FeedCommentDataProvider", "" + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqDelFeedComment localReqDelFeedComment = new qqstory_service.ReqDelFeedComment();
    localReqDelFeedComment.feed_id.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    localReqDelFeedComment.comment_id.set(this.jdField_a_of_type_Int);
    return localReqDelFeedComment.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     szl
 * JD-Core Version:    0.7.0.1
 */