import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class slc
  extends sks
{
  private TextView a;
  
  private slc(ViewGroup paramViewGroup, sjf paramsjf)
  {
    super(paramViewGroup, paramsjf, 2131560119);
  }
  
  public static slc a(ViewGroup paramViewGroup, sjf paramsjf)
  {
    return new slc(paramViewGroup, paramsjf);
  }
  
  protected void a()
  {
    this.a = ((TextView)a(2).findViewById(2131379110));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     slc
 * JD-Core Version:    0.7.0.1
 */