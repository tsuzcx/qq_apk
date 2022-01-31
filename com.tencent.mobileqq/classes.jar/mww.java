import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;
import com.tencent.util.VersionUtils;

public class mww
  implements View.OnSystemUiVisibilityChangeListener
{
  public mww(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity) {}
  
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
 * Qualified Name:     mww
 * JD-Core Version:    0.7.0.1
 */