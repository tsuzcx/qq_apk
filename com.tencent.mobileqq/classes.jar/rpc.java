import android.view.View.OnSystemUiVisibilityChangeListener;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;

class rpc
  implements View.OnSystemUiVisibilityChangeListener
{
  rpc(roy paramroy) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    ReadInJoyCommentListFragment localReadInJoyCommentListFragment;
    if (roy.a(this.a) != null)
    {
      localReadInJoyCommentListFragment = roy.a(this.a);
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
 * Qualified Name:     rpc
 * JD-Core Version:    0.7.0.1
 */