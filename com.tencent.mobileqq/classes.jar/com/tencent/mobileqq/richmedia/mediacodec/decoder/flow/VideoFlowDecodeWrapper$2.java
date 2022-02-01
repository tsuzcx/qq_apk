package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import java.util.Comparator;

class VideoFlowDecodeWrapper$2
  implements Comparator<DecodedFrame>
{
  VideoFlowDecodeWrapper$2(VideoFlowDecodeWrapper paramVideoFlowDecodeWrapper) {}
  
  public int a(DecodedFrame paramDecodedFrame1, DecodedFrame paramDecodedFrame2)
  {
    if (paramDecodedFrame2.b() > paramDecodedFrame1.b()) {}
    do
    {
      return -1;
      if (paramDecodedFrame2.b() < paramDecodedFrame1.b()) {
        return 1;
      }
    } while (paramDecodedFrame2.a() > paramDecodedFrame1.a());
    if (paramDecodedFrame2.a() == paramDecodedFrame1.a()) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.VideoFlowDecodeWrapper.2
 * JD-Core Version:    0.7.0.1
 */