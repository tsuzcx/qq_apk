package cooperation.qzone;

import java.util.concurrent.CountDownLatch;

class QzoneIPCModule$StickerRecReq
{
  private volatile String data;
  private final CountDownLatch latch;
  private volatile String pass;
  private final String text;
  
  private QzoneIPCModule$StickerRecReq(String paramString)
  {
    this.text = paramString;
    this.latch = new CountDownLatch(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzoneIPCModule.StickerRecReq
 * JD-Core Version:    0.7.0.1
 */