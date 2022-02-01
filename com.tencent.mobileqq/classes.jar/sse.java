import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.qphone.base.util.QLog;

public class sse
  implements apom
{
  public sse(FastWebActivity paramFastWebActivity) {}
  
  public void onColorNoteAnimFinish()
  {
    FastWebActivity.a(this.a, true);
    FastWebActivity.b(this.a);
    if ((FastWebActivity.a(this.a) != null) && (FastWebActivity.a(this.a).c())) {
      this.a.overridePendingTransition(0, 0);
    }
    QLog.d("FastWebActivity", 2, "mColorNoteController ：onColorNoteAnimFinish");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sse
 * JD-Core Version:    0.7.0.1
 */