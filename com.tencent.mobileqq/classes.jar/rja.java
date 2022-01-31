import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.32.1;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;

public class rja
  implements pai
{
  public rja(FastWebActivity paramFastWebActivity) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, FastWebArticleInfo paramFastWebArticleInfo)
  {
    QLog.d(FastWebActivity.a(this.a), 2, " isSucc " + paramBoolean1 + "  useWebView :" + paramBoolean2 + "  data : " + paramFastWebArticleInfo);
    if ((paramBoolean1) && (!paramBoolean2) && (paramFastWebArticleInfo != null))
    {
      paramBoolean1 = true;
      rnu.b("fast_web_show_light_house_2");
    }
    for (;;)
    {
      this.a.runOnUiThread(new FastWebActivity.32.1(this, paramBoolean1, paramFastWebArticleInfo));
      return;
      paramBoolean1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rja
 * JD-Core Version:    0.7.0.1
 */