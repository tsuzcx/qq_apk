package com.tencent.mobileqq.service.message;

import com.tencent.imcore.message.core.codec.IPBMsgElemDecoder;
import java.util.Comparator;

final class QMessageProtoCodec$1
  implements Comparator<IPBMsgElemDecoder>
{
  public int a(IPBMsgElemDecoder paramIPBMsgElemDecoder1, IPBMsgElemDecoder paramIPBMsgElemDecoder2)
  {
    return paramIPBMsgElemDecoder2.a() - paramIPBMsgElemDecoder1.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.QMessageProtoCodec.1
 * JD-Core Version:    0.7.0.1
 */