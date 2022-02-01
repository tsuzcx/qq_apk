import android.widget.TextView;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "updateProgress"}, k=3, mv={1, 1, 16})
final class qxr
  implements qzg
{
  qxr(TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4, TextView paramTextView5) {}
  
  public final void a(int paramInt)
  {
    TextView localTextView = this.a;
    if (localTextView != null) {
      localTextView.setText((CharSequence)("完成任务需要的时间：" + qxs.a() / 1000 + " 秒"));
    }
    localTextView = this.b;
    if (localTextView != null) {
      localTextView.setText((CharSequence)("文章最大贡献时长：" + qxs.c() / 1000 + " 秒"));
    }
    localTextView = this.c;
    if (localTextView != null) {
      localTextView.setText((CharSequence)("文章静止时最大贡献时长：" + qxs.d() / 1000 + " 秒"));
    }
    localTextView = this.d;
    if (localTextView != null) {
      localTextView.setText((CharSequence)("已完成任务数：" + qxt.a.a().a() + '/' + qxs.b()));
    }
    localTextView = this.e;
    if (localTextView != null) {
      localTextView.setText((CharSequence)("累积时间：" + paramInt / 1000 + " 秒"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qxr
 * JD-Core Version:    0.7.0.1
 */