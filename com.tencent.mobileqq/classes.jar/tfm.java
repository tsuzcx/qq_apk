import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class tfm
  implements owy
{
  public tfm(FastWebActivity paramFastWebActivity) {}
  
  public void a(oxb paramoxb)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onBiuAndCommentSend fastWeb");
    if (paramoxb == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(paramoxb.a()))
    {
      QLog.d("FastWebActivity", 1, localObject);
      if ((paramoxb == null) || (paramoxb.a() != 0)) {
        break;
      }
      if (FastWebActivity.a(this.a) != null)
      {
        localObject = FastWebActivity.a(this.a);
        ((FastWebArticleInfo)localObject).b += 1L;
        FastWebActivity.a(this.a).a(this.a, FastWebActivity.a(this.a), this.a.a);
      }
      owx.a(paramoxb.c(), paramoxb.a(), paramoxb.c(), paramoxb.b(), paramoxb.a(), paramoxb.d(), paramoxb.e(), paramoxb.a());
      if ((paramoxb.c() == 1) && (!FastWebActivity.g(this.a)))
      {
        FastWebActivity.e(this.a, true);
        tiy.a(this.a);
      }
      return;
    }
    QQToast.a(BaseApplication.getContext(), 1, anvx.a(2131712346), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tfm
 * JD-Core Version:    0.7.0.1
 */