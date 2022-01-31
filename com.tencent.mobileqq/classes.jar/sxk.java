import android.media.MediaMetadataRetriever;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;

public class sxk
  implements sxb
{
  public sxk(StoryVideoUploadTask paramStoryVideoUploadTask) {}
  
  public void a(sxa paramsxa)
  {
    swy localswy = (swy)paramsxa;
    ((sxh)this.a.a).g = localswy.a.a;
    ((sxh)this.a.a).h = localswy.a.c;
    ((sxh)this.a.a).a = localswy.b;
    localMediaMetadataRetriever = new MediaMetadataRetriever();
    for (;;)
    {
      try
      {
        localMediaMetadataRetriever.setDataSource(localswy.b);
        String str = localMediaMetadataRetriever.extractMetadata(24);
        paramsxa = str;
        if (str == null) {
          paramsxa = "0";
        }
        int i = Integer.valueOf(paramsxa).intValue();
        j = Integer.valueOf(localMediaMetadataRetriever.extractMetadata(18)).intValue();
        k = Integer.valueOf(localMediaMetadataRetriever.extractMetadata(19)).intValue();
        if (i % 180 <= 0) {
          continue;
        }
        ((sxh)this.a.a).d = k;
        ((sxh)this.a.a).e = j;
      }
      catch (Exception paramsxa)
      {
        int j;
        int k;
        long l;
        veg.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "format fail", paramsxa);
        localMediaMetadataRetriever.release();
        continue;
      }
      finally
      {
        localMediaMetadataRetriever.release();
      }
      l = StoryVideoUploadTask.a(localswy.b);
      if (l > 0L)
      {
        veg.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "video old duration=%d, new duration=%d", Long.valueOf(((sxh)this.a.a).b), Long.valueOf(l));
        ((sxh)this.a.a).b = l;
        veg.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "generate vid=%s, duration=%d mp4=%s", ((sxh)this.a.a).a(), Long.valueOf(((sxh)this.a.a).b), ((sxh)this.a.a).a);
      }
      ((sxh)this.a.a).c = vyi.a(localswy.b);
      this.a.a(1, new ErrorMessage());
      return;
      ((sxh)this.a.a).d = j;
      ((sxh)this.a.a).e = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sxk
 * JD-Core Version:    0.7.0.1
 */