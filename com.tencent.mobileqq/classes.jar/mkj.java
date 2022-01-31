import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule.FastWebArticleRichReqCallback;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebShareInfo;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class mkj
  extends FastWebModule.FastWebArticleRichReqCallback
{
  public mkj(FastWebActivity paramFastWebActivity) {}
  
  public void a(boolean paramBoolean, int paramInt, FastWebShareInfo paramFastWebShareInfo)
  {
    super.a(paramBoolean, paramInt, paramFastWebShareInfo);
    if ((paramBoolean) && (paramFastWebShareInfo != null) && (!TextUtils.isEmpty(paramFastWebShareInfo.a(paramInt)))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ThreadManager.getUIHandler().post(new mkk(this, paramBoolean, paramInt, paramFastWebShareInfo));
      return;
    }
  }
  
  public void a(boolean paramBoolean, String paramString, FastWebArticleInfo paramFastWebArticleInfo)
  {
    super.a(paramBoolean, paramString, paramFastWebArticleInfo);
    this.a.runOnUiThread(new mkl(this, paramFastWebArticleInfo, paramString, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mkj
 * JD-Core Version:    0.7.0.1
 */