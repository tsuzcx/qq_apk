import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.avgame.gamelobby.view.AutoResizeAsyncImageView;
import java.util.List;

public class mza
  extends mzg<myv>
{
  private AutoResizeAsyncImageView a;
  
  public mza(@NonNull View paramView)
  {
    super(paramView);
    this.a = ((AutoResizeAsyncImageView)paramView.findViewById(2131363190));
  }
  
  public void a(mzj parammzj, myv parammyv, int paramInt)
  {
    super.a(parammzj, parammyv, paramInt);
    if (parammyv == null) {}
    do
    {
      return;
      parammzj = parammyv.a();
    } while ((parammzj == null) || (parammzj.size() <= 0));
    this.a.a(((nil)parammzj.get(0)).a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mza
 * JD-Core Version:    0.7.0.1
 */