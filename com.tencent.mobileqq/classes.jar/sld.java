import UserGrowth.stSimpleMetaFeed;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class sld
  extends skv
{
  private TextView a;
  
  private sld(ViewGroup paramViewGroup, sji paramsji)
  {
    super(paramViewGroup, paramsji, 2131560119);
  }
  
  public static sld a(ViewGroup paramViewGroup, sji paramsji)
  {
    return new sld(paramViewGroup, paramsji);
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
    a(1, paramstSimpleMetaFeed);
    a(2, 2, paramstSimpleMetaFeed);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sld
 * JD-Core Version:    0.7.0.1
 */