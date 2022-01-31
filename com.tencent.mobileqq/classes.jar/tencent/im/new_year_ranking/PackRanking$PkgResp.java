package tencent.im.new_year_ranking;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PackRanking$PkgResp
  extends MessageMicro<PkgResp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field cmdtype = PBField.initUInt32(0);
  public PackRanking.QueryRankingResp query_ranking = new PackRanking.QueryRankingResp();
  public final PBBytesField resp_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field retcode = PBField.initUInt32(0);
  public final PBBytesField retmsg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 82 }, new String[] { "cmdtype", "uin", "retcode", "retmsg", "resp_name", "query_ranking" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, null }, PkgResp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.new_year_ranking.PackRanking.PkgResp
 * JD-Core Version:    0.7.0.1
 */