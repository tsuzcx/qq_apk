import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.widget.QQToast;

public class skg
  extends BizTroopObserver
{
  public skg(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, Boolean paramBoolean1)
  {
    this.a.i();
    if (paramBoolean)
    {
      if (paramBoolean1.booleanValue()) {
        DiscussionInfoCardActivity.e(this.a);
      }
      return;
    }
    QQToast.a(this.a, paramInt, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     skg
 * JD-Core Version:    0.7.0.1
 */