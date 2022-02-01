import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;

public class paw
  implements pbf
{
  public paw(ReadInJoyCommentListFragment paramReadInJoyCommentListFragment) {}
  
  public void a(boolean paramBoolean)
  {
    QLog.d("ReadInJoyCommentListFragment", 1, "onHippyPageLoaded: " + paramBoolean);
    FragmentActivity localFragmentActivity = this.a.getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()) || (this.a.isDetached()))
    {
      QLog.d("ReadInJoyCommentListFragment", 1, "activity not exists or fragment detached");
      return;
    }
    if (paramBoolean)
    {
      ReadInJoyCommentListFragment.a(this.a, true);
      ReadInJoyCommentListFragment.a(this.a);
    }
    for (;;)
    {
      ReadInJoyCommentListFragment.b(this.a);
      return;
      if (ReadInJoyCommentListFragment.a(this.a) != null)
      {
        if (ReadInJoyCommentListFragment.a(this.a) != null)
        {
          ((FrameLayout)ReadInJoyCommentListFragment.a(this.a).findViewById(2131368214)).setVisibility(8);
          ((RelativeLayout)ReadInJoyCommentListFragment.a(this.a).findViewById(2131376839)).setVisibility(0);
        }
        ReadInJoyCommentListFragment.a(this.a, null);
      }
      if (!ReadInJoyCommentListFragment.a(this.a)) {
        ReadInJoyCommentListFragment.a(this.a, ReadInJoyCommentListFragment.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     paw
 * JD-Core Version:    0.7.0.1
 */