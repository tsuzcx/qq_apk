import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;
import com.tencent.util.VersionUtils;

public class myd
  implements View.OnSystemUiVisibilityChangeListener
{
  public myd(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if (paramInt == 4102) {}
    while (!VersionUtils.e()) {
      return;
    }
    this.a.getWindow().getDecorView().setSystemUiVisibility(4102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     myd
 * JD-Core Version:    0.7.0.1
 */