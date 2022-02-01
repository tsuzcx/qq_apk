package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import java.util.Comparator;

class Mp4FlowReEncoder$1
  implements Comparator<DecodedFrame>
{
  Mp4FlowReEncoder$1(Mp4FlowReEncoder paramMp4FlowReEncoder) {}
  
  public int a(DecodedFrame paramDecodedFrame1, DecodedFrame paramDecodedFrame2)
  {
    if (paramDecodedFrame2.a() > paramDecodedFrame1.a()) {
      return -1;
    }
    if (paramDecodedFrame2.a() == paramDecodedFrame1.a()) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Mp4FlowReEncoder.1
 * JD-Core Version:    0.7.0.1
 */