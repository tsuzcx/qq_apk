package com.tencent.tavsticker.core;

import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVStickerResource;
import com.tencent.tavsticker.utils.FileIoUtils;
import java.nio.ByteBuffer;
import java.util.List;

class TAVStickerResourceExporter$ResourceExportTask
  implements Runnable
{
  public static final int BUFFER_SIZE = 8192;
  private TAVStickerResourceExporter.IStickerResourceExportListener exportListener = null;
  private TAVStickerResource exportResource = null;
  
  public TAVStickerResourceExporter$ResourceExportTask(TAVStickerResourceExporter paramTAVStickerResourceExporter, TAVStickerResource paramTAVStickerResource, TAVStickerResourceExporter.IStickerResourceExportListener paramIStickerResourceExportListener)
  {
    this.exportResource = paramTAVStickerResource;
    this.exportListener = paramIStickerResourceExportListener;
  }
  
  public void run()
  {
    if ((this.exportResource != null) && (this.exportResource.getByteBuffer() != null))
    {
      ByteBuffer localByteBuffer = this.exportResource.getByteBuffer();
      int j = localByteBuffer.capacity();
      if (j > 0)
      {
        int i = 0;
        localByteBuffer.position(0);
        if (i < j)
        {
          if (j - i > 8192) {}
          for (byte[] arrayOfByte = new byte[8192];; arrayOfByte = new byte[j - i])
          {
            localByteBuffer.get(arrayOfByte);
            i = localByteBuffer.position();
            FileIoUtils.writeFileFromBytesByStream(this.exportResource.getFilePath(), arrayOfByte, true);
            if (this.exportListener != null)
            {
              float f = 1.0F * i / j;
              TLog.d(TAVStickerResourceExporter.access$200(), "pos : " + i + ", size : " + j + ", progress : " + f + ", ThreadId : " + Thread.currentThread().getId());
              this.exportListener.exporting(this.exportResource, f);
              if (i == j)
              {
                this.exportListener.succeed(this.exportResource);
                TAVStickerResourceExporter.access$300(this.this$0).remove(this.exportResource.getFilePath());
              }
            }
            break;
          }
        }
      }
      else if (this.exportListener != null)
      {
        this.exportListener.failed(this.exportResource.getFilePath(), "没有数据。");
        TAVStickerResourceExporter.access$300(this.this$0).remove(this.exportResource.getFilePath());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVStickerResourceExporter.ResourceExportTask
 * JD-Core Version:    0.7.0.1
 */