import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.25.1;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.25.2;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.25.3;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AuthorData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ryq
  extends oxe
{
  public ryq(FastWebActivity paramFastWebActivity) {}
  
  public void a(String paramString)
  {
    int j = 0;
    QLog.d("Q.readinjoy.fast_web", 2, " onWebCallback : " + paramString);
    if (!FastWebActivity.h(this.a)) {
      return;
    }
    int i;
    if ("onPageStarted".equals(paramString)) {
      i = 300;
    }
    for (;;)
    {
      ThreadManager.getUIHandler().postDelayed(new FastWebActivity.25.2(this), i);
      return;
      i = j;
      if ("onConversationJumpRestoreStack".equals(paramString)) {
        i = j;
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (FastWebActivity.a(this.a) == null) {
      return;
    }
    sda.a(FastWebActivity.a(this.a), paramString, paramInt1, paramInt2);
    FastWebActivity.a(this.a).notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      int[] arrayOfInt = new int[2];
      FastWebActivity.a(this.a).postDelayed(new FastWebActivity.25.3(this, arrayOfInt, paramString), 200L);
      return;
    }
    QLog.i(FastWebActivity.a(this.a), 1, " red packet task do not get Tips!");
  }
  
  public void au_()
  {
    super.au_();
    if ((FastWebActivity.f(this.a)) || (FastWebActivity.a(this.a) == null)) {
      return;
    }
    this.a.runOnUiThread(new FastWebActivity.25.1(this));
  }
  
  public void d()
  {
    super.d();
    if ((FastWebActivity.g(this.a)) || (FastWebActivity.a(this.a) == null) || (FastWebActivity.a(this.a) == null) || (FastWebActivity.a(this.a) == null)) {
      return;
    }
    FastWebActivity.a(this.a).a(FastWebActivity.a(this.a).a);
    FastWebActivity.g(this.a);
    FastWebActivity.a(this.a).notifyDataSetChanged();
  }
  
  public void e()
  {
    if (FastWebActivity.a(this.a) == null) {
      return;
    }
    FastWebActivity.g(this.a);
    FastWebActivity.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ryq
 * JD-Core Version:    0.7.0.1
 */