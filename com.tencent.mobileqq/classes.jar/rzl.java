import android.view.View;
import android.view.View.OnLayoutChangeListener;

class rzl
  implements View.OnLayoutChangeListener
{
  rzl(rzk paramrzk) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramView.removeOnLayoutChangeListener(this);
    paramView.setTranslationX(rzk.a(this.a)[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rzl
 * JD-Core Version:    0.7.0.1
 */