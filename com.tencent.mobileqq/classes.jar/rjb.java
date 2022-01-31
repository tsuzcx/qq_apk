import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FusionBiuInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.33.1;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.33.3;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.33.4;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.33.5;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.33.6;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.33.7;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.33.8;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class rjb
  extends pah
{
  public rjb(FastWebActivity paramFastWebActivity) {}
  
  public void a(int paramInt, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (FastWebActivity.a(this.a) == null) || (!paramString.equals(FastWebActivity.a(this.a).innerUniqueID)) || (FastWebActivity.a(this.a) == null))
    {
      QLog.d(FastWebActivity.a(this.a), 2, "handleLikeCntInfoResp fail, msg not match !");
      return;
    }
    ThreadManager.getUIHandler().post(new FastWebActivity.33.4(this, paramInt));
  }
  
  public void a(long paramLong, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (FastWebActivity.a(this.a) == null) || (!paramString.equals(FastWebActivity.a(this.a).innerUniqueID)) || (FastWebActivity.a(this.a) == null))
    {
      QLog.d(FastWebActivity.a(this.a), 2, "handleBiuCntInfoResp fail, msg not match !");
      return;
    }
    ThreadManager.getUIHandler().post(new FastWebActivity.33.3(this, paramLong));
  }
  
  public void a(FusionBiuInfo paramFusionBiuInfo)
  {
    FastWebActivity.a(this.a).a = paramFusionBiuInfo;
    FastWebActivity.a(this.a).fusionBiuInfo = paramFusionBiuInfo;
  }
  
  public void a(FastWebArticleInfo paramFastWebArticleInfo, int paramInt, String paramString)
  {
    this.a.runOnUiThread(new FastWebActivity.33.8(this, paramInt, paramFastWebArticleInfo, paramString));
  }
  
  public void a(FastWebArticleInfo paramFastWebArticleInfo, String paramString)
  {
    this.a.runOnUiThread(new FastWebActivity.33.7(this, paramString));
  }
  
  public void a(String paramString)
  {
    this.a.runOnUiThread(new FastWebActivity.33.6(this, paramString));
  }
  
  public void a(boolean paramBoolean, int paramInt, rmx paramrmx)
  {
    super.a(paramBoolean, paramInt, paramrmx);
    String str;
    if (FastWebActivity.a(this.a) != null)
    {
      str = FastWebActivity.a(this.a).mArticleContentUrl;
      if ((!paramBoolean) || (paramrmx == null) || (TextUtils.isEmpty(paramrmx.a(paramInt))) || (TextUtils.isEmpty(str))) {
        break label86;
      }
    }
    label86:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ThreadManager.getUIHandler().post(new FastWebActivity.33.1(this, paramBoolean, paramInt, str, paramrmx));
      return;
      str = "";
      break;
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (FastWebActivity.a(this.a) == null) || (!paramString.equals(FastWebActivity.a(this.a).innerUniqueID)) || (FastWebActivity.a(this.a) == null))
    {
      QLog.d(FastWebActivity.a(this.a), 2, "handleLikeStateResp fail, msg not match !");
      return;
    }
    ThreadManager.getUIHandler().post(new FastWebActivity.33.5(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rjb
 * JD-Core Version:    0.7.0.1
 */