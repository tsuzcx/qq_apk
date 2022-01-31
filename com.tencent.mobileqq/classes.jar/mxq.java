import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionCommentActivity;

public class mxq
  implements CompoundButton.OnCheckedChangeListener
{
  public mxq(PublicAccountImageCollectionCommentActivity paramPublicAccountImageCollectionCommentActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    PublicAccountImageCollectionCommentActivity.b(this.a, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mxq
 * JD-Core Version:    0.7.0.1
 */