import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.av.ui.QAVPtvTemplateAdapter;

public class jyx
  implements View.OnLayoutChangeListener
{
  public jyx(QAVPtvTemplateAdapter paramQAVPtvTemplateAdapter) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (paramInt4 - paramInt2 != paramInt8 - paramInt6) {
      this.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jyx
 * JD-Core Version:    0.7.0.1
 */