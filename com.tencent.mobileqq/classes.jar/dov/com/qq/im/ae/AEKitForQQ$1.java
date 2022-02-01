package dov.com.qq.im.ae;

import com.tencent.mobileqq.richmedia.mediacodec.AEVDecoder;
import com.tencent.ttpic.video.AECoderFactory.AEDecoderFactory;
import com.tencent.ttpic.video.AEDecoder;

final class AEKitForQQ$1
  implements AECoderFactory.AEDecoderFactory
{
  public AEDecoder createDecoder(String paramString)
  {
    return new AEVDecoder(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEKitForQQ.1
 * JD-Core Version:    0.7.0.1
 */