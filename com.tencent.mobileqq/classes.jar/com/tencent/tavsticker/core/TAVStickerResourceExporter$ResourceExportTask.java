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
    Object localObject = this.exportResource;
    if ((localObject != null) && (((TAVStickerResource)localObject).getByteBuffer() != null))
    {
      ByteBuffer localByteBuffer = this.exportResource.getByteBuffer();
      int j = localByteBuffer.capacity();
      if (j > 0)
      {
        int i = 0;
        localByteBuffer.position(0);
        while (i < j)
        {
          i = j - i;
          if (i > 8192) {
            localObject = new byte[8192];
          } else {
            localObject = new byte[i];
          }
          localByteBuffer.get((byte[])localObject);
          i = localByteBuffer.position();
          FileIoUtils.writeFileFromBytesByStream(this.exportResource.getFilePath(), (byte[])localObject, true);
          if (this.exportListener != null)
          {
            float f = i * 1.0F / j;
            localObject = TAVStickerResourceExporter.access$200();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("pos : ");
            localStringBuilder.append(i);
            localStringBuilder.append(", size : ");
            localStringBuilder.append(j);
            localStringBuilder.append(", progress : ");
            localStringBuilder.append(f);
            localStringBuilder.append(", ThreadId : ");
            localStringBuilder.append(Thread.currentThread().getId());
            TLog.d((String)localObject, localStringBuilder.toString());
            this.exportListener.exporting(this.exportResource, f);
            if (i == j)
            {
              this.exportListener.succeed(this.exportResource);
              TAVStickerResourceExporter.access$300(this.this$0).remove(this.exportResource.getFilePath());
            }
          }
        }
      }
      localObject = this.exportListener;
      if (localObject != null)
      {
        ((TAVStickerResourceExporter.IStickerResourceExportListener)localObject).failed(this.exportResource.getFilePath(), "没有数据。");
        TAVStickerResourceExporter.access$300(this.this$0).remove(this.exportResource.getFilePath());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVStickerResourceExporter.ResourceExportTask
 * JD-Core Version:    0.7.0.1
 */