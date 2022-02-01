package dov.com.qq.im.ae.play;

import android.text.TextUtils;
import com.tencent.ttpic.videoshelf.model.VideoShelfEngine;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.tencent.biz.qqstory.takevideo.ShortVideoForwardManager;
import java.io.File;
import java.util.Timer;

class AEVideoShelfPreviewFragment$5
  implements Runnable
{
  AEVideoShelfPreviewFragment$5(AEVideoShelfPreviewFragment paramAEVideoShelfPreviewFragment, long paramLong) {}
  
  public void run()
  {
    if (AEVideoShelfPreviewFragment.access$300(this.this$0))
    {
      Object localObject = AEVideoShelfPreviewFragment.access$100(this.this$0).getOutputVideoPath();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        File localFile = new File((String)localObject);
        if (localFile.exists())
        {
          localFile.delete();
          AEQLog.b(AEVideoShelfPreviewFragment.access$200(), "onCompletion---delete temp silent file because user cancel generation: " + (String)localObject);
        }
      }
      if (!TextUtils.isEmpty(AEVideoShelfPreviewFragment.access$500(this.this$0)))
      {
        localObject = new File(AEVideoShelfPreviewFragment.access$500(this.this$0));
        if (((File)localObject).exists())
        {
          ((File)localObject).delete();
          AEQLog.b(AEVideoShelfPreviewFragment.access$200(), "onCompletion---delete final file because user cancel generation: " + AEVideoShelfPreviewFragment.access$500(this.this$0));
        }
      }
      AEVideoShelfPreviewFragment.access$602(this.this$0, false);
      return;
    }
    if ((int)AEVideoShelfPreviewFragment.access$700(this.this$0) < 100)
    {
      AEVideoShelfPreviewFragment.access$800(this.this$0, 100);
      new Timer().schedule(new AEVideoShelfPreviewFragment.5.1(this), 0L);
    }
    for (;;)
    {
      AEVideoShelfPreviewFragment.access$702(this.this$0, 0.0D);
      AEVideoShelfPreviewFragment.access$1002(this.this$0, 0.0D);
      if (AEVideoShelfPreviewFragment.access$1100(this.this$0))
      {
        AEVideoShelfPreviewFragment.access$1102(this.this$0, false);
        AEVideoShelfPreviewFragment.keepScreenOn(this.this$0.getActivity(), false);
      }
      ShortVideoForwardManager.a(this.this$0.getActivity(), AEVideoShelfPreviewFragment.access$500(this.this$0), this.this$0.getThumbPath(), AECameraEntry.b(this.this$0.getActivity()), "caller_aecamera");
      return;
      AEVideoShelfPreviewFragment.access$900(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEVideoShelfPreviewFragment.5
 * JD-Core Version:    0.7.0.1
 */