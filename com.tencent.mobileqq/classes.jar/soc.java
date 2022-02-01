import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class soc
  implements onp
{
  public soc(FastWebActivity paramFastWebActivity) {}
  
  public void a(ons paramons)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onBiuAndCommentSend fastWeb");
    if (paramons == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(paramons.a()))
    {
      QLog.d("FastWebActivity", 1, localObject);
      if ((paramons == null) || (paramons.a() != 0)) {
        break;
      }
      if (FastWebActivity.a(this.a) != null)
      {
        localObject = FastWebActivity.a(this.a);
        ((FastWebArticleInfo)localObject).b += 1L;
        FastWebActivity.a(this.a).a(this.a, FastWebActivity.a(this.a), this.a.a);
      }
      ono.a(paramons.c(), paramons.a(), paramons.c(), paramons.b(), paramons.a(), paramons.d(), paramons.e(), paramons.a());
      if ((paramons.c() == 1) && (!FastWebActivity.g(this.a)))
      {
        FastWebActivity.e(this.a, true);
        sro.a(this.a);
      }
      return;
    }
    QQToast.a(BaseApplication.getContext(), 1, anzj.a(2131711767), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     soc
 * JD-Core Version:    0.7.0.1
 */