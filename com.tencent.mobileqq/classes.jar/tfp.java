import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.qphone.base.util.QLog;

public class tfp
  implements aqrq
{
  public tfp(FastWebActivity paramFastWebActivity) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tfp
 * JD-Core Version:    0.7.0.1
 */