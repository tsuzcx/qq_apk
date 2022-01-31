import UserGrowth.stSimpleMetaFeed;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class slc
  extends skv
{
  private TextView a;
  
  private slc(ViewGroup paramViewGroup, sji paramsji)
  {
    super(paramViewGroup, paramsji, 2131560120);
  }
  
  public static slc a(ViewGroup paramViewGroup, sji paramsji)
  {
    return new slc(paramViewGroup, paramsji);
  }
  
  protected void a()
  {
    this.a = ((TextView)a(1).findViewById(2131379104));
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
 * Qualified Name:     slc
 * JD-Core Version:    0.7.0.1
 */