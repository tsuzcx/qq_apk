import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.app.DiscussionObserver;
import java.util.ArrayList;

public class rkb
  extends DiscussionObserver
{
  public rkb(AddRequestActivity paramAddRequestActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, ArrayList paramArrayList)
  {
    if ((paramBoolean) && (paramLong == this.a.b) && (this.a.b != 0L)) {
      this.a.runOnUiThread(new rke(this));
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((this.a.b != 0L) && (paramBoolean) && ((paramObject instanceof ArrayList)) && (((ArrayList)paramObject).contains(Long.valueOf(this.a.b)))) {
      this.a.runOnUiThread(new rkd(this));
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.a.b != 0L) && (String.valueOf(this.a.b).equals(paramString))) {
      this.a.runOnUiThread(new rkc(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rkb
 * JD-Core Version:    0.7.0.1
 */