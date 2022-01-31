import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ryk
  extends rxz
{
  private TextView a;
  
  private ryk(ViewGroup paramViewGroup, rwm paramrwm)
  {
    super(paramViewGroup, paramrwm, 2131494547);
  }
  
  public static ryk a(ViewGroup paramViewGroup, rwm paramrwm)
  {
    return new ryk(paramViewGroup, paramrwm);
  }
  
  protected void a()
  {
    this.a = ((TextView)a(2).findViewById(2131313270));
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
    TextView localTextView = this.a;
    if (TextUtils.isEmpty(paramstSimpleMetaFeed.feed_desc)) {}
    for (int i = 8;; i = 0)
    {
      localTextView.setVisibility(i);
      this.a.setText(paramstSimpleMetaFeed.feed_desc);
      a(1, paramstSimpleMetaFeed);
      a(2, 1, paramstSimpleMetaFeed);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ryk
 * JD-Core Version:    0.7.0.1
 */