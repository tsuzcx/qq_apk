import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class sxh
  implements ovc
{
  public sxh(FastWebActivity paramFastWebActivity) {}
  
  public void a(ovf paramovf)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onBiuAndCommentSend fastWeb");
    if (paramovf == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(paramovf.a()))
    {
      QLog.d("FastWebActivity", 1, localObject);
      if ((paramovf == null) || (paramovf.a() != 0)) {
        break;
      }
      if (FastWebActivity.a(this.a) != null)
      {
        localObject = FastWebActivity.a(this.a);
        ((FastWebArticleInfo)localObject).b += 1L;
        FastWebActivity.a(this.a).a(this.a, FastWebActivity.a(this.a), this.a.a);
      }
      ovb.a(paramovf.c(), paramovf.a(), paramovf.c(), paramovf.b(), paramovf.a(), paramovf.d(), paramovf.e(), paramovf.a());
      if ((paramovf.c() == 1) && (!FastWebActivity.j(this.a)))
      {
        FastWebActivity.h(this.a, true);
        tas.a(this.a);
      }
      return;
    }
    QQToast.a(BaseApplication.getContext(), 1, anni.a(2131711658), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sxh
 * JD-Core Version:    0.7.0.1
 */