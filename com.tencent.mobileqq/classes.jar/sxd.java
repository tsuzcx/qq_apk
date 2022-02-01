import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.42.1;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.42.3;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.42.4;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.42.5;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.42.6;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.42.8;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class sxd
  extends pww
{
  public sxd(FastWebActivity paramFastWebActivity) {}
  
  public void a(int paramInt, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.a.a == null) || (!paramString.equals(this.a.a.innerUniqueID)) || (FastWebActivity.a(this.a) == null))
    {
      QLog.d("FastWebActivity", 2, "handleLikeCntInfoResp fail, msg not match !");
      return;
    }
    ThreadManager.getUIHandler().post(new FastWebActivity.42.4(this, paramInt));
  }
  
  public void a(long paramLong, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.a.a == null) || (!paramString.equals(this.a.a.innerUniqueID)) || (FastWebActivity.a(this.a) == null))
    {
      QLog.d("FastWebActivity", 2, "handleBiuCntInfoResp fail, msg not match !");
      return;
    }
    ThreadManager.getUIHandler().post(new FastWebActivity.42.3(this, paramLong));
  }
  
  public void a(FastWebArticleInfo paramFastWebArticleInfo, int paramInt, String paramString)
  {
    this.a.runOnUiThread(new FastWebActivity.42.8(this, paramInt, paramFastWebArticleInfo, paramString));
  }
  
  public void a(String paramString)
  {
    this.a.runOnUiThread(new FastWebActivity.42.6(this, paramString));
  }
  
  public void a(boolean paramBoolean, int paramInt, tbl paramtbl)
  {
    super.a(paramBoolean, paramInt, paramtbl);
    String str;
    if (this.a.a != null)
    {
      str = this.a.a.mArticleContentUrl;
      if ((!paramBoolean) || (paramtbl == null) || (TextUtils.isEmpty(paramtbl.a(paramInt))) || (TextUtils.isEmpty(str))) {
        break label86;
      }
    }
    label86:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ThreadManager.getUIHandler().post(new FastWebActivity.42.1(this, paramBoolean, paramInt, str, paramtbl));
      return;
      str = "";
      break;
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.a.a == null) || (!paramString.equals(this.a.a.innerUniqueID)) || (FastWebActivity.a(this.a) == null))
    {
      QLog.d("FastWebActivity", 2, "handleLikeStateResp fail, msg not match !");
      return;
    }
    ThreadManager.getUIHandler().post(new FastWebActivity.42.5(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sxd
 * JD-Core Version:    0.7.0.1
 */