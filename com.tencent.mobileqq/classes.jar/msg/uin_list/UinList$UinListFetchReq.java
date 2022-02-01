package msg.uin_list;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class UinList$UinListFetchReq
  extends MessageMicro<UinListFetchReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_store_key = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_store_key" }, new Object[] { localByteStringMicro }, UinListFetchReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     msg.uin_list.UinList.UinListFetchReq
 * JD-Core Version:    0.7.0.1
 */