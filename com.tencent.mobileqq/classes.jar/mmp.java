import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule.FastWebContentGetCallback;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.TimeUtil;

public class mmp
  implements FastWebModule.FastWebContentGetCallback
{
  public mmp(FastWebActivity paramFastWebActivity) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if ((paramBoolean1) && (!paramBoolean2) && (paramFastWebArticleInfo != null))
    {
      paramBoolean1 = true;
      TimeUtil.b("fast_web_show_light_house_2");
    }
    for (;;)
    {
      this.a.runOnUiThread(new mmq(this, paramBoolean1, paramFastWebArticleInfo));
      return;
      paramBoolean1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mmp
 * JD-Core Version:    0.7.0.1
 */