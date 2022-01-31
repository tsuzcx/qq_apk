import android.media.MediaMetadataRetriever;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.UploadResult;
import com.tencent.biz.qqstory.base.videoupload.meta.StoryVideoFileObject;
import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject;
import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject.UploadFinishListener;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoTaskInfo;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;

public class mzv
  implements UploadObject.UploadFinishListener
{
  public mzv(StoryVideoUploadTask paramStoryVideoUploadTask) {}
  
  public void a(UploadObject paramUploadObject)
  {
    StoryVideoFileObject localStoryVideoFileObject = (StoryVideoFileObject)paramUploadObject;
    ((StoryVideoTaskInfo)this.a.a).g = localStoryVideoFileObject.a.a;
    ((StoryVideoTaskInfo)this.a.a).h = localStoryVideoFileObject.a.c;
    ((StoryVideoTaskInfo)this.a.a).a = localStoryVideoFileObject.b;
    localMediaMetadataRetriever = new MediaMetadataRetriever();
    for (;;)
    {
      try
      {
        localMediaMetadataRetriever.setDataSource(localStoryVideoFileObject.b);
        String str = localMediaMetadataRetriever.extractMetadata(24);
        paramUploadObject = str;
        if (str == null) {
          paramUploadObject = "0";
        }
        int i = Integer.valueOf(paramUploadObject).intValue();
        j = Integer.valueOf(localMediaMetadataRetriever.extractMetadata(18)).intValue();
        k = Integer.valueOf(localMediaMetadataRetriever.extractMetadata(19)).intValue();
        if (i % 180 <= 0) {
          continue;
        }
        ((StoryVideoTaskInfo)this.a.a).d = k;
        ((StoryVideoTaskInfo)this.a.a).e = j;
      }
      catch (Exception paramUploadObject)
      {
        int j;
        int k;
        long l;
        SLog.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "format fail", paramUploadObject);
        localMediaMetadataRetriever.release();
        continue;
      }
      finally
      {
        localMediaMetadataRetriever.release();
      }
      l = StoryVideoUploadTask.a(localStoryVideoFileObject.b);
      if (l > 0L)
      {
        SLog.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "video old duration=%d, new duration=%d", Long.valueOf(((StoryVideoTaskInfo)this.a.a).b), Long.valueOf(l));
        ((StoryVideoTaskInfo)this.a.a).b = l;
        SLog.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "generate vid=%s, duration=%d mp4=%s", ((StoryVideoTaskInfo)this.a.a).a(), Long.valueOf(((StoryVideoTaskInfo)this.a.a).b), ((StoryVideoTaskInfo)this.a.a).a);
      }
      ((StoryVideoTaskInfo)this.a.a).c = FileUtils.a(localStoryVideoFileObject.b);
      this.a.a(1, new ErrorMessage());
      return;
      ((StoryVideoTaskInfo)this.a.a).d = j;
      ((StoryVideoTaskInfo)this.a.a).e = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mzv
 * JD-Core Version:    0.7.0.1
 */