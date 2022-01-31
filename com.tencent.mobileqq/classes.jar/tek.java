import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.data.PublicAccountInfo;

public class tek
  extends PublicAccountObserver
{
  public tek(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public void a(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramInt == 0) {
      this.a.e();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.e();
    }
  }
  
  public void b(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramInt == 0) {
      this.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tek
 * JD-Core Version:    0.7.0.1
 */