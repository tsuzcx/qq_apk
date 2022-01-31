import UserGrowth.stSimpleMetaFeed;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ryg
  extends rxz
{
  private TextView a;
  
  private ryg(ViewGroup paramViewGroup, rwm paramrwm)
  {
    super(paramViewGroup, paramrwm, 2131494548);
  }
  
  public static ryg a(ViewGroup paramViewGroup, rwm paramrwm)
  {
    return new ryg(paramViewGroup, paramrwm);
  }
  
  protected void a()
  {
    this.a = ((TextView)a(1).findViewById(2131313269));
  }
  
  protected void a(int paramInt)
  {
    super.a(paramInt);
    this.a.setVisibility(paramInt);
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    super.a(paramstSimpleMetaFeed);
    if (paramstSimpleMetaFeed == null) {
      return;
    }
    this.a.setText(paramstSimpleMetaFeed.feed_desc);
    a(1, 1, paramstSimpleMetaFeed);
    a(2, 2, paramstSimpleMetaFeed);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ryg
 * JD-Core Version:    0.7.0.1
 */