import android.os.MessageQueue.IdleHandler;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil;

public class mms
  implements MessageQueue.IdleHandler
{
  public mms(FastWebActivity paramFastWebActivity) {}
  
  public boolean queueIdle()
  {
    FastWebRequestUtil.a(FastWebActivity.a(this.a).l, FastWebActivity.a(this.a).j, String.valueOf(FastWebActivity.a(this.a).c), FastWebActivity.a(this.a).k, FastWebActivity.a(this.a).c(), FastWebActivity.a(this.a));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mms
 * JD-Core Version:    0.7.0.1
 */