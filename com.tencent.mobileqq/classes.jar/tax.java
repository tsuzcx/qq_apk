import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqWatchVideoBatch;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspWatchVideoBatch;
import com.tencent.biz.qqstory.network.pb.qqstory_service.VideoItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;

public class tax
  extends slz<tcg>
{
  public static final String a;
  public ArrayList<spx> a;
  public int c;
  
  static
  {
    jdField_a_of_type_JavaLangString = skt.a("StorySvc.video_watch_batch");
  }
  
  public tax()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public slu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspWatchVideoBatch localRspWatchVideoBatch = new qqstory_service.RspWatchVideoBatch();
    try
    {
      localRspWatchVideoBatch.mergeFrom(paramArrayOfByte);
      return new tcg(localRspWatchVideoBatch);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        urk.d("Q.qqstory:WatchVideoBatchRequest", paramArrayOfByte.toString());
      }
    }
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqWatchVideoBatch localReqWatchVideoBatch = new qqstory_service.ReqWatchVideoBatch();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    if (localIterator.hasNext())
    {
      spx localspx = (spx)localIterator.next();
      qqstory_service.VideoItem localVideoItem = new qqstory_service.VideoItem();
      localVideoItem.vid.set(ByteStringMicro.copyFromUtf8(localspx.jdField_a_of_type_JavaLangString));
      Object localObject = a(localspx.b);
      localVideoItem.to_union_id.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localObject = localVideoItem.is_live_video;
      if (localspx.jdField_a_of_type_Boolean) {}
      for (int i = 1;; i = 0)
      {
        ((PBUInt32Field)localObject).set(i);
        localVideoItem.create_time.set(localspx.jdField_a_of_type_Long / 1000L);
        localVideoItem.source.set(localspx.jdField_a_of_type_Int);
        localReqWatchVideoBatch.video_list.add(localVideoItem);
        break;
      }
    }
    return localReqWatchVideoBatch.toByteArray();
  }
  
  public String toString()
  {
    return "WatchVideoBatchRequest{seq=" + this.c + "mVideoList=" + this.jdField_a_of_type_JavaUtilArrayList + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tax
 * JD-Core Version:    0.7.0.1
 */