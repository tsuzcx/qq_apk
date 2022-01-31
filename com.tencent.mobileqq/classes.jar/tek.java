import com.tencent.biz.qqstory.network.pb.qqstory_struct.QimVideoInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;

public class tek
{
  public String a;
  public String b;
  public String c;
  
  public tek(qqstory_struct.QimVideoInfo paramQimVideoInfo)
  {
    this.a = paramQimVideoInfo.qim_unionid.get().toStringUtf8();
    this.b = paramQimVideoInfo.qim_feedID.get().toStringUtf8();
    this.c = paramQimVideoInfo.qim_vid.get().toStringUtf8();
  }
  
  public static tek a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    qqstory_struct.QimVideoInfo localQimVideoInfo = new qqstory_struct.QimVideoInfo();
    try
    {
      localQimVideoInfo.mergeFrom(paramArrayOfByte);
      return new tek(localQimVideoInfo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      veg.c("QimVideoInfoItem", "Error: parse db bytes error.", paramArrayOfByte);
    }
    return null;
  }
  
  public byte[] a()
  {
    qqstory_struct.QimVideoInfo localQimVideoInfo = new qqstory_struct.QimVideoInfo();
    localQimVideoInfo.qim_vid.set(ByteStringMicro.copyFromUtf8(this.c));
    localQimVideoInfo.qim_unionid.set(ByteStringMicro.copyFromUtf8(this.a));
    localQimVideoInfo.qim_feedID.set(ByteStringMicro.copyFromUtf8(this.b));
    return localQimVideoInfo.toByteArray();
  }
  
  public String toString()
  {
    return "QimVideoInfoItem{mOwnerUnionId='" + this.a + '\'' + ", mFeedId='" + this.b + '\'' + ", mVid='" + this.c + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tek
 * JD-Core Version:    0.7.0.1
 */