package dov.com.qq.im.aeeditor.module.music;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.biz.videostory.video.FrameVideoHelper.GetFrameByteArrayListener;
import com.tencent.tavcut.session.TAVCutVideoSession;
import dov.com.qq.im.ae.util.AEQLog;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class AEEditorMusicHelper$2
  implements Runnable
{
  AEEditorMusicHelper$2(TAVCutVideoSession paramTAVCutVideoSession, List paramList, long paramLong1, long paramLong2, long paramLong3, FrameVideoHelper.GetFrameByteArrayListener paramGetFrameByteArrayListener) {}
  
  public void run()
  {
    long l2 = 0L;
    ArrayList localArrayList = new ArrayList();
    long l1 = l2;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession == null) {
          return;
        }
        l1 = l2;
        localObject1 = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMultiVideoFrame(this.jdField_a_of_type_JavaUtilList, (int)this.jdField_a_of_type_Long);
        l1 = l2;
        localByteArrayOutputStream = new ByteArrayOutputStream();
        l1 = l2;
        localObject1 = ((List)localObject1).iterator();
        l3 = 0L;
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        ByteArrayOutputStream localByteArrayOutputStream;
        long l3;
        Object localObject2;
        AEQLog.a("AEEditorMusicHelper", "FrameVideoHelper.start(), error=", localThrowable);
        if (this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper$GetFrameByteArrayListener == null) {
          return;
        }
        this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper$GetFrameByteArrayListener.a(false, localArrayList, l1);
        return;
        l1 = l2;
        l2 += localObject2.length;
        l1 = l2;
        localArrayList.add(new FrameVideoHelper.FrameBuffer((byte[])localObject2));
        l1 = l2;
        localThrowable.reset();
        continue;
      }
      l1 = l2;
      if (((Iterator)localObject1).hasNext())
      {
        l1 = l2;
        localObject2 = (Bitmap)((Iterator)localObject1).next();
        if (localObject2 == null) {
          continue;
        }
        l1 = l2;
        ((Bitmap)localObject2).compress(Bitmap.CompressFormat.JPEG, (int)this.b, localByteArrayOutputStream);
        l1 = l2;
        localObject2 = localByteArrayOutputStream.toByteArray();
        l1 = l2;
        l3 = localObject2.length + l3;
        l1 = l2;
        if (l3 >= this.c)
        {
          l1 = l2;
          AEQLog.b("AEEditorMusicHelper", "[extractMultiCutFrameForSmartMusic] out of limit readBytes:" + l3 + ", frameCount:" + localArrayList.size());
        }
      }
      else
      {
        l1 = l2;
        if (this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper$GetFrameByteArrayListener == null) {
          return;
        }
        l1 = l2;
        this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper$GetFrameByteArrayListener.a(true, localArrayList, l2);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper.2
 * JD-Core Version:    0.7.0.1
 */