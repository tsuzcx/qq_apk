package dov.com.tencent.biz.qqstory.takevideo;

import android.annotation.TargetApi;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import axqz;
import bmku;
import bmkv;
import bnjh;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import java.util.List;
import wsv;

public class HWEditLocalVideoPlayer$ConvertIFramesRunnable
  implements Runnable
{
  public int a = 30;
  public int b = 1;
  public int c;
  
  HWEditLocalVideoPlayer$ConvertIFramesRunnable(HWEditLocalVideoPlayer paramHWEditLocalVideoPlayer, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramInt2;
    this.a = paramInt1;
    this.c = paramInt3;
  }
  
  @TargetApi(17)
  public void run()
  {
    wsv.d("Q.qqstory.record.HWEditLocalVideoPlayer", "start convert i frame video. mVideoPath = " + HWEditLocalVideoPlayer.a(this.this$0));
    Object localObject1 = new MediaMetadataRetriever();
    String str2;
    try
    {
      ((MediaMetadataRetriever)localObject1).setDataSource(HWEditLocalVideoPlayer.a(this.this$0));
      String str1 = ((MediaMetadataRetriever)localObject1).extractMetadata(18);
      str2 = ((MediaMetadataRetriever)localObject1).extractMetadata(19);
      localObject2 = ((MediaMetadataRetriever)localObject1).extractMetadata(24);
      ((MediaMetadataRetriever)localObject1).release();
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
        return;
      }
    }
    catch (Exception localException)
    {
      wsv.c("Q.qqstory.record.HWEditLocalVideoPlayer", "setDataSource failed when convert i frame", localException);
      ((MediaMetadataRetriever)localObject1).release();
      return;
    }
    int i = 0;
    try
    {
      int j = Integer.valueOf((String)localObject2).intValue();
      i = j;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        long l1;
        long l2;
        localThrowable.printStackTrace();
      }
    }
    HWEditLocalVideoPlayer.a(this.this$0, new bnjh());
    localObject1 = HWEditLocalVideoPlayer.a(this.this$0) + "_" + this.c + ".IFrames.mp4";
    if (this.b != 0) {
      HWEditLocalVideoPlayer.a(this.this$0).b = (this.b * this.a);
    }
    Object localObject2 = (bmkv)this.this$0.a.get(this.c);
    l1 = bmkv.a((bmkv)localObject2);
    l2 = bmkv.b((bmkv)localObject2);
    HWEditLocalVideoPlayer.a(this.this$0).a(new DecodeConfig(HWEditLocalVideoPlayer.a(this.this$0), 0, false, true, l1, l2), new axqz((String)localObject1, Integer.valueOf(localException).intValue(), Integer.valueOf(str2).intValue(), 12582912, this.b, this.a, 0, false, i, null, null, null, false), new bmku(this, (bmkv)localObject2), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.ConvertIFramesRunnable
 * JD-Core Version:    0.7.0.1
 */