import android.media.MediaMetadataRetriever;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;

public class sko
  implements skf
{
  public sko(StoryVideoUploadTask paramStoryVideoUploadTask) {}
  
  public void a(ske paramske)
  {
    skc localskc = (skc)paramske;
    ((skl)this.a.a).g = localskc.a.a;
    ((skl)this.a.a).h = localskc.a.c;
    ((skl)this.a.a).a = localskc.b;
    localMediaMetadataRetriever = new MediaMetadataRetriever();
    for (;;)
    {
      try
      {
        localMediaMetadataRetriever.setDataSource(localskc.b);
        String str = localMediaMetadataRetriever.extractMetadata(24);
        paramske = str;
        if (str == null) {
          paramske = "0";
        }
        int i = Integer.valueOf(paramske).intValue();
        j = Integer.valueOf(localMediaMetadataRetriever.extractMetadata(18)).intValue();
        k = Integer.valueOf(localMediaMetadataRetriever.extractMetadata(19)).intValue();
        if (i % 180 <= 0) {
          continue;
        }
        ((skl)this.a.a).d = k;
        ((skl)this.a.a).e = j;
      }
      catch (Exception paramske)
      {
        int j;
        int k;
        long l;
        urk.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "format fail", paramske);
        localMediaMetadataRetriever.release();
        continue;
      }
      finally
      {
        localMediaMetadataRetriever.release();
      }
      l = StoryVideoUploadTask.a(localskc.b);
      if (l > 0L)
      {
        urk.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "video old duration=%d, new duration=%d", Long.valueOf(((skl)this.a.a).b), Long.valueOf(l));
        ((skl)this.a.a).b = l;
        urk.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "generate vid=%s, duration=%d mp4=%s", ((skl)this.a.a).a(), Long.valueOf(((skl)this.a.a).b), ((skl)this.a.a).a);
      }
      ((skl)this.a.a).c = vlm.a(localskc.b);
      this.a.a(1, new ErrorMessage());
      return;
      ((skl)this.a.a).d = j;
      ((skl)this.a.a).e = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sko
 * JD-Core Version:    0.7.0.1
 */