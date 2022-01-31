import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;
import com.tencent.widget.ActionSheet;

public class mwp
  implements View.OnClickListener
{
  public mwp(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.isShowing()) {
      this.a.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mwp
 * JD-Core Version:    0.7.0.1
 */