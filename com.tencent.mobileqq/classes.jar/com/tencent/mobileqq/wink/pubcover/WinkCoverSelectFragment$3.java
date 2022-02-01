package com.tencent.mobileqq.wink.pubcover;

import android.graphics.Bitmap;
import android.util.Pair;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.wink.editor.export.WinkExportManager;
import com.tencent.tavcut.TavCut;
import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.render.cover.ICoverProvider;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.session.ICutSession;
import okio.ByteString;

class WinkCoverSelectFragment$3
  implements Runnable
{
  WinkCoverSelectFragment$3(WinkCoverSelectFragment paramWinkCoverSelectFragment) {}
  
  public void run()
  {
    WinkExportManager.a(WinkCoverSelectFragment.a(this.this$0).b(), WinkCoverSelectFragment.a(this.this$0).f(), WinkCoverSelectFragment.c(this.this$0));
    Object localObject1 = WinkCoverSelectFragment.a(this.this$0).b().d();
    if (localObject1 != null)
    {
      Object localObject2 = TavCut.a;
      int i;
      if (WinkCoverSelectFragment.c(this.this$0) != null) {
        i = ((Integer)WinkCoverSelectFragment.c(this.this$0).first).intValue();
      } else {
        i = 720;
      }
      int j;
      if (WinkCoverSelectFragment.c(this.this$0) != null) {
        j = ((Integer)WinkCoverSelectFragment.c(this.this$0).second).intValue();
      } else {
        j = 1280;
      }
      localObject1 = ((TavCut)localObject2).a((RenderModel)localObject1, new Size(Integer.valueOf(i), Integer.valueOf(j), ByteString.EMPTY));
      localObject2 = ((ICoverProvider)localObject1).a(WinkCoverSelectFragment.d(this.this$0) / 1000L);
      try
      {
        WinkCoverSelectFragment.a(this.this$0, (Bitmap)localObject2);
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveVideoProgressCover: Exception = ");
        localStringBuilder.append(localException.toString());
        AEQLog.a("WinkCoverSelectFragment", localStringBuilder.toString());
      }
      ((ICoverProvider)localObject1).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pubcover.WinkCoverSelectFragment.3
 * JD-Core Version:    0.7.0.1
 */