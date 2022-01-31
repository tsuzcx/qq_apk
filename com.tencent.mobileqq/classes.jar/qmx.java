import android.view.View.OnSystemUiVisibilityChangeListener;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;

class qmx
  implements View.OnSystemUiVisibilityChangeListener
{
  qmx(qmu paramqmu) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    ReadInJoyCommentListFragment localReadInJoyCommentListFragment;
    if (qmu.a(this.a) != null)
    {
      localReadInJoyCommentListFragment = qmu.a(this.a);
      if ((paramInt & 0x2) != 0) {
        break label32;
      }
    }
    label32:
    for (boolean bool = true;; bool = false)
    {
      localReadInJoyCommentListFragment.a(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qmx
 * JD-Core Version:    0.7.0.1
 */