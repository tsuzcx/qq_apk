import com.tencent.biz.qqstory.newshare.job.ShareGroupAvatarJob;
import com.tencent.biz.qqstory.shareGroup.icon.RestrictedBitmap;
import com.tencent.biz.qqstory.shareGroup.icon.ShareGroupIconManager.LoadBitmapCallBack;

public class ner
  extends ShareGroupIconManager.LoadBitmapCallBack
{
  public ner(ShareGroupAvatarJob paramShareGroupAvatarJob) {}
  
  protected void a(RestrictedBitmap paramRestrictedBitmap)
  {
    this.a.a(paramRestrictedBitmap);
  }
  
  protected void a(Error paramError)
  {
    this.a.a(paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ner
 * JD-Core Version:    0.7.0.1
 */