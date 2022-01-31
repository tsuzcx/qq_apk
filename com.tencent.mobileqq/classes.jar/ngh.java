import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.newshare.job.UploadImageJob;
import com.tencent.biz.qqstory.newshare.mode.ShareGroupCardShareMode;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager;

public class ngh
  extends UploadImageJob
{
  public ngh(ShareGroupCardShareMode paramShareGroupCardShareMode, String paramString)
  {
    super(paramString);
  }
  
  public boolean b()
  {
    ShareGroupCardShareMode.a(this.a, (String)a("UploadImageJob_out_image_url"));
    ((ShareGroupManager)SuperManager.a(7)).a(this.a.d, ShareGroupCardShareMode.a(this.a));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ngh
 * JD-Core Version:    0.7.0.1
 */