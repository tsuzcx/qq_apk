import android.media.MediaMetadataRetriever;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;

public class sxh
  implements swy
{
  public sxh(StoryVideoUploadTask paramStoryVideoUploadTask) {}
  
  public void a(swx paramswx)
  {
    swv localswv = (swv)paramswx;
    ((sxe)this.a.a).g = localswv.a.a;
    ((sxe)this.a.a).h = localswv.a.c;
    ((sxe)this.a.a).a = localswv.b;
    localMediaMetadataRetriever = new MediaMetadataRetriever();
    for (;;)
    {
      try
      {
        localMediaMetadataRetriever.setDataSource(localswv.b);
        String str = localMediaMetadataRetriever.extractMetadata(24);
        paramswx = str;
        if (str == null) {
          paramswx = "0";
        }
        int i = Integer.valueOf(paramswx).intValue();
        j = Integer.valueOf(localMediaMetadataRetriever.extractMetadata(18)).intValue();
        k = Integer.valueOf(localMediaMetadataRetriever.extractMetadata(19)).intValue();
        if (i % 180 <= 0) {
          continue;
        }
        ((sxe)this.a.a).d = k;
        ((sxe)this.a.a).e = j;
      }
      catch (Exception paramswx)
      {
        int j;
        int k;
        long l;
        ved.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "format fail", paramswx);
        localMediaMetadataRetriever.release();
        continue;
      }
      finally
      {
        localMediaMetadataRetriever.release();
      }
      l = StoryVideoUploadTask.a(localswv.b);
      if (l > 0L)
      {
        ved.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "video old duration=%d, new duration=%d", Long.valueOf(((sxe)this.a.a).b), Long.valueOf(l));
        ((sxe)this.a.a).b = l;
        ved.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "generate vid=%s, duration=%d mp4=%s", ((sxe)this.a.a).a(), Long.valueOf(((sxe)this.a.a).b), ((sxe)this.a.a).a);
      }
      ((sxe)this.a.a).c = vyf.a(localswv.b);
      this.a.a(1, new ErrorMessage());
      return;
      ((sxe)this.a.a).d = j;
      ((sxe)this.a.a).e = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sxh
 * JD-Core Version:    0.7.0.1
 */