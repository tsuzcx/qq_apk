import com.tencent.biz.pubaccount.readinjoy.video.TopicShareHelper;
import com.tencent.mobileqq.widget.QQProgressDialog;

class mdw
  implements Runnable
{
  mdw(mdv parammdv) {}
  
  public void run()
  {
    if ((TopicShareHelper.a(this.a.a) != null) && (TopicShareHelper.a(this.a.a).isShowing())) {
      TopicShareHelper.a(this.a.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mdw
 * JD-Core Version:    0.7.0.1
 */