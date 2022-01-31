import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.25.1;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.25.2;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AuthorData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class riv
  extends osm
{
  public riv(FastWebActivity paramFastWebActivity) {}
  
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
    rnb.a(FastWebActivity.a(this.a), paramString, paramInt1, paramInt2);
    FastWebActivity.a(this.a).notifyDataSetChanged();
  }
  
  public void ap_()
  {
    super.ap_();
    if ((FastWebActivity.c(this.a)) || (FastWebActivity.a(this.a) == null)) {
      return;
    }
    this.a.runOnUiThread(new FastWebActivity.25.1(this));
  }
  
  public void b(boolean paramBoolean, long paramLong)
  {
    this.a.a(paramBoolean, paramLong);
  }
  
  public void d()
  {
    super.d();
    if ((FastWebActivity.d(this.a)) || (FastWebActivity.a(this.a) == null) || (FastWebActivity.a(this.a) == null) || (FastWebActivity.a(this.a) == null)) {
      return;
    }
    FastWebActivity.a(this.a).a(FastWebActivity.a(this.a).a);
    FastWebActivity.g(this.a);
    FastWebActivity.a(this.a).notifyDataSetChanged();
  }
  
  public void d(boolean paramBoolean)
  {
    if (FastWebActivity.a(this.a) == null) {
      return;
    }
    rmo.a(FastWebActivity.a(this.a), paramBoolean);
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
  
  public void n()
  {
    FastWebActivity.h(this.a);
  }
  
  public void o()
  {
    FastWebActivity.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     riv
 * JD-Core Version:    0.7.0.1
 */