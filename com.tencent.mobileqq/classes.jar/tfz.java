import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class tfz
  extends tfj
{
  private TextView a;
  
  private tfz(ViewGroup paramViewGroup, tby paramtby)
  {
    super(paramViewGroup, paramtby, 2131560226);
  }
  
  public static tfz a(ViewGroup paramViewGroup, tby paramtby)
  {
    return new tfz(paramViewGroup, paramtby);
  }
  
  protected void a()
  {
    this.a = ((TextView)a(1).findViewById(2131379846));
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
      a(2, 2, paramstSimpleMetaFeed);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tfz
 * JD-Core Version:    0.7.0.1
 */