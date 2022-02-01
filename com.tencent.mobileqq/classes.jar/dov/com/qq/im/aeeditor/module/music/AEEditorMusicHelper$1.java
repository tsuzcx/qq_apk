package dov.com.qq.im.aeeditor.module.music;

import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.biz.videostory.video.FrameVideoHelper.GetFrameByteArrayListener;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.ArrayList;

final class AEEditorMusicHelper$1
  implements FrameVideoHelper.GetFrameByteArrayListener
{
  AEEditorMusicHelper$1(FrameVideoHelper paramFrameVideoHelper, FrameVideoHelper.GetFrameByteArrayListener paramGetFrameByteArrayListener) {}
  
  public void a(boolean paramBoolean, ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, long paramLong)
  {
    AEQLog.b("AEEditorMusicHelper", "[extractFrameForSmartMusic], onResult(), isSuccess=" + paramBoolean + ", dataArray=" + paramArrayList + ", frameSize=" + paramLong);
    int i;
    if (this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper != null)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("[extractFrameForSmartMusic], executeTime=").append(this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper.a()).append(", frameCount=");
      if (paramArrayList == null)
      {
        i = 0;
        AEQLog.a("AEEditorMusicHelper", i + ", size=" + this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper.b() + "KB");
      }
    }
    else if (this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper$GetFrameByteArrayListener != null)
    {
      if (paramArrayList != null) {
        break label169;
      }
    }
    label169:
    for (paramArrayList = null;; paramArrayList = new ArrayList(paramArrayList))
    {
      this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper$GetFrameByteArrayListener.a(paramBoolean, paramArrayList, paramLong);
      if (this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper != null) {
        this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper.a();
      }
      return;
      i = paramArrayList.size();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper.1
 * JD-Core Version:    0.7.0.1
 */