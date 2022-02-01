package dov.com.qq.im.ae.play;

import android.text.TextUtils;
import born;
import bpam;
import bqip;
import com.tencent.ttpic.videoshelf.model.VideoShelfEngine;
import java.io.File;
import java.util.Timer;

class AEVideoShelfPreviewFragment$5
  implements Runnable
{
  AEVideoShelfPreviewFragment$5(AEVideoShelfPreviewFragment paramAEVideoShelfPreviewFragment, long paramLong) {}
  
  public void run()
  {
    if (AEVideoShelfPreviewFragment.a(this.this$0))
    {
      Object localObject = AEVideoShelfPreviewFragment.a(this.this$0).getOutputVideoPath();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        File localFile = new File((String)localObject);
        if (localFile.exists())
        {
          localFile.delete();
          bpam.b(AEVideoShelfPreviewFragment.b(), "onCompletion---delete temp silent file because user cancel generation: " + (String)localObject);
        }
      }
      if (!TextUtils.isEmpty(AEVideoShelfPreviewFragment.a(this.this$0)))
      {
        localObject = new File(AEVideoShelfPreviewFragment.a(this.this$0));
        if (((File)localObject).exists())
        {
          ((File)localObject).delete();
          bpam.b(AEVideoShelfPreviewFragment.b(), "onCompletion---delete final file because user cancel generation: " + AEVideoShelfPreviewFragment.a(this.this$0));
        }
      }
      AEVideoShelfPreviewFragment.b(this.this$0, false);
      return;
    }
    if ((int)AEVideoShelfPreviewFragment.a(this.this$0) < 100)
    {
      AEVideoShelfPreviewFragment.a(this.this$0, 100);
      new Timer().schedule(new AEVideoShelfPreviewFragment.5.1(this), 0L);
    }
    for (;;)
    {
      AEVideoShelfPreviewFragment.a(this.this$0, 0.0D);
      AEVideoShelfPreviewFragment.b(this.this$0, 0.0D);
      if (AEVideoShelfPreviewFragment.b(this.this$0))
      {
        AEVideoShelfPreviewFragment.c(this.this$0, false);
        AEVideoShelfPreviewFragment.a(this.this$0.getActivity(), false);
      }
      bqip.a(this.this$0.getActivity(), AEVideoShelfPreviewFragment.a(this.this$0), this.this$0.a(), born.b(this.this$0.getActivity()), "caller_aecamera");
      return;
      AEVideoShelfPreviewFragment.b(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEVideoShelfPreviewFragment.5
 * JD-Core Version:    0.7.0.1
 */