import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ssb
  implements opa
{
  public ssb(FastWebActivity paramFastWebActivity) {}
  
  public void a(opd paramopd)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onBiuAndCommentSend fastWeb");
    if (paramopd == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(paramopd.a()))
    {
      QLog.d("FastWebActivity", 1, localObject);
      if ((paramopd == null) || (paramopd.a() != 0)) {
        break;
      }
      if (FastWebActivity.a(this.a) != null)
      {
        localObject = FastWebActivity.a(this.a);
        ((FastWebArticleInfo)localObject).b += 1L;
        FastWebActivity.a(this.a).a(this.a, FastWebActivity.a(this.a), this.a.a);
      }
      ooz.a(paramopd.c(), paramopd.a(), paramopd.c(), paramopd.b(), paramopd.a(), paramopd.d(), paramopd.e(), paramopd.a());
      if ((paramopd.c() == 1) && (!FastWebActivity.g(this.a)))
      {
        FastWebActivity.e(this.a, true);
        svm.a(this.a);
      }
      return;
    }
    QQToast.a(BaseApplication.getContext(), 1, amtj.a(2131711999), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ssb
 * JD-Core Version:    0.7.0.1
 */