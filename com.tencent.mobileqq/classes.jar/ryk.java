import android.content.Intent;
import android.os.MessageQueue.IdleHandler;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;

public class ryk
  implements MessageQueue.IdleHandler
{
  public ryk(FastWebActivity paramFastWebActivity) {}
  
  public boolean queueIdle()
  {
    if (FastWebActivity.a(this.a).c == 0) {}
    for (String str = "";; str = FastWebActivity.a(this.a).p)
    {
      int i = this.a.getIntent().getIntExtra("floating_window_scene", 0);
      scq.a(FastWebActivity.a(this.a).o, FastWebActivity.a(this.a).j, String.valueOf(FastWebActivity.a(this.a).d), FastWebActivity.a(this.a).l, FastWebActivity.a(this.a).c(), str, FastWebActivity.a(this.a).m, FastWebActivity.a(this.a).n, FastWebActivity.a(this.a), FastWebActivity.b(this.a), i, FastWebActivity.a(this.a).mChannelID);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ryk
 * JD-Core Version:    0.7.0.1
 */