import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.app.DiscussionObserver;
import java.util.ArrayList;

public class rhe
  extends DiscussionObserver
{
  public rhe(AddRequestActivity paramAddRequestActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, ArrayList paramArrayList)
  {
    if ((paramBoolean) && (paramLong == this.a.b) && (this.a.b != 0L)) {
      this.a.runOnUiThread(new rhh(this));
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((this.a.b != 0L) && (paramBoolean) && ((paramObject instanceof ArrayList)) && (((ArrayList)paramObject).contains(Long.valueOf(this.a.b)))) {
      this.a.runOnUiThread(new rhg(this));
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.a.b != 0L) && (String.valueOf(this.a.b).equals(paramString))) {
      this.a.runOnUiThread(new rhf(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rhe
 * JD-Core Version:    0.7.0.1
 */