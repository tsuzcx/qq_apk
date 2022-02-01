import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public class ryp
  extends rzu
  implements ryb
{
  private QQAppInterface a;
  
  public ryp(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void a(UgcVideo paramUgcVideo, rya paramrya)
  {
    ((sad)this.a.getManager(QQManagerFactory.RIJ_UGC_VIDEO_PUBLISH_MANAGER)).a(paramUgcVideo, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ryp
 * JD-Core Version:    0.7.0.1
 */