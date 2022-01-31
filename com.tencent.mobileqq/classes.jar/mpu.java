import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class mpu
  extends ReadInJoyObserver
{
  public mpu(FastWebActivity paramFastWebActivity) {}
  
  public void a(String paramString)
  {
    int j = 0;
    QLog.d("Q.readinjoy.fast_web", 2, " onWebCallback : " + paramString);
    if (!FastWebActivity.e(this.a)) {
      return;
    }
    int i;
    if ("onPageStarted".equals(paramString)) {
      i = 300;
    }
    for (;;)
    {
      ThreadManager.getUIHandler().postDelayed(new mpw(this), i);
      return;
      i = j;
      if ("onConversationJumpRestoreStack".equals(paramString)) {
        i = j;
      }
    }
  }
  
  public void ab_()
  {
    super.ab_();
    if ((FastWebActivity.c(this.a)) || (FastWebActivity.a(this.a) == null)) {
      return;
    }
    this.a.runOnUiThread(new mpv(this));
  }
  
  public void c()
  {
    super.c();
    if (FastWebActivity.d(this.a)) {
      return;
    }
    TextView localTextView = (TextView)this.a.findViewById(2131366883);
    if (FastWebActivity.a(this.a).b > 0L) {
      localTextView.setText(FastWebActivity.a(this.a).b + "");
    }
    for (;;)
    {
      FastWebActivity.a(this.a).a = FastWebActivity.a(this.a).a;
      FastWebActivity.a(this.a).notifyDataSetChanged();
      return;
      localTextView.setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mpu
 * JD-Core Version:    0.7.0.1
 */