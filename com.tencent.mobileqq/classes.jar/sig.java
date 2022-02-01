import android.view.View.OnSystemUiVisibilityChangeListener;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;

class sig
  implements View.OnSystemUiVisibilityChangeListener
{
  sig(sib paramsib) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    ReadInJoyCommentListFragment localReadInJoyCommentListFragment;
    if (sib.a(this.a) != null)
    {
      localReadInJoyCommentListFragment = sib.a(this.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sig
 * JD-Core Version:    0.7.0.1
 */