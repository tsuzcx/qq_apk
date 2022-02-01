package com.tencent.mobileqq.editor.composite;

import com.tencent.aelight.camera.struct.editor.MusicDownloadListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.dov.story.api.IVSReporter;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.qroute.QRoute;

class VideoCompositeHelper$3
  extends MusicDownloadListener
{
  private long e = 0L;
  
  VideoCompositeHelper$3(VideoCompositeHelper paramVideoCompositeHelper, PublishVideoEntry paramPublishVideoEntry, VideoCompositeHelper.RetCode paramRetCode, String paramString) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString)
  {
    this.b.a(-3);
    this.b.a("task canceled");
    VideoCompositeHelper.a(this.d, "needAndStartDownloadMusic");
  }
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, boolean paramBoolean)
  {
    paramString = VideoCompositeHelper.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fakeId:");
    localStringBuilder.append(this.a.fakeVid);
    localStringBuilder.append(" music onStart download");
    SLog.c(paramString, localStringBuilder.toString());
    this.e = System.currentTimeMillis();
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    Object localObject = VideoCompositeHelper.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fakeId:");
    localStringBuilder.append(this.a.fakeVid);
    localStringBuilder.append(" music onStart download onFinish ");
    SLog.c((String)localObject, localStringBuilder.toString());
    this.a.backgroundMusicPath = paramString;
    long l1 = System.currentTimeMillis();
    long l2 = this.e;
    if (paramInt != -104)
    {
      if (paramInt != 0)
      {
        this.b.a(paramInt);
        this.b.a("unknown error the music download failed");
      }
      else
      {
        this.b.a(0);
        this.b.a("music downloadSuccess");
      }
    }
    else
    {
      this.b.a(-2);
      this.b.a("none network");
    }
    localObject = (IVSReporter)QRoute.api(IVSReporter.class);
    ((IVSReporter)localObject).reportPerfEvent("edit_music_download", ((IVSReporter)localObject).newPerfEntries(this.b.a(), l1 - l2, this.c, FileUtils.a(paramString)));
    VideoCompositeHelper.a(this.d, "needAndStartDownloadMusic");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.editor.composite.VideoCompositeHelper.3
 * JD-Core Version:    0.7.0.1
 */