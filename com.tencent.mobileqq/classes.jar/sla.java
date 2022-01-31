import UserGrowth.stSimpleMetaFeed;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class sla
  extends sks
{
  private TextView a;
  
  private sla(ViewGroup paramViewGroup, sjf paramsjf)
  {
    super(paramViewGroup, paramsjf, 2131560119);
  }
  
  public static sla a(ViewGroup paramViewGroup, sjf paramsjf)
  {
    return new sla(paramViewGroup, paramsjf);
  }
  
  protected void a()
  {
    this.a = ((TextView)a(1).findViewById(2131379109));
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
 * Qualified Name:     sla
 * JD-Core Version:    0.7.0.1
 */