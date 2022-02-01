package com.tencent.mobileqq.kandian.biz.fastweb;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.ad.RIJCommentAdUtils;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule.FastWebArticleRichReqCallback;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.FastWebShareInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONException;

class FastWebActivity$ArticleRichInfoCallback
  extends FastWebModule.FastWebArticleRichReqCallback
{
  private FastWebActivity$ArticleRichInfoCallback(FastWebActivity paramFastWebActivity) {}
  
  public void a(int paramInt, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.a.g != null) && (paramString.equals(this.a.g.innerUniqueID)) && (FastWebActivity.d(this.a) != null))
    {
      ThreadManager.getUIHandler().post(new FastWebActivity.ArticleRichInfoCallback.4(this, paramInt));
      return;
    }
    QLog.d("FastWebActivity", 2, "handleLikeCntInfoResp fail, msg not match !");
  }
  
  public void a(long paramLong, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.a.g != null) && (paramString.equals(this.a.g.innerUniqueID)) && (FastWebActivity.d(this.a) != null))
    {
      ThreadManager.getUIHandler().post(new FastWebActivity.ArticleRichInfoCallback.3(this, paramLong));
      return;
    }
    QLog.d("FastWebActivity", 2, "handleBiuCntInfoResp fail, msg not match !");
  }
  
  public void a(FastWebArticleInfo paramFastWebArticleInfo, int paramInt, String paramString)
  {
    this.a.g.tags = paramFastWebArticleInfo.t;
    try
    {
      this.a.g.unioChann = RIJCommentAdUtils.a(paramFastWebArticleInfo.v);
    }
    catch (JSONException localJSONException)
    {
      label34:
      break label34;
    }
    this.a.g.unioChann = "";
    this.a.runOnUiThread(new FastWebActivity.ArticleRichInfoCallback.8(this, paramInt, paramFastWebArticleInfo, paramString));
  }
  
  public void a(FastWebArticleInfo paramFastWebArticleInfo, String paramString)
  {
    this.a.runOnUiThread(new FastWebActivity.ArticleRichInfoCallback.9(this, paramString, paramFastWebArticleInfo));
  }
  
  public void a(String paramString)
  {
    FastWebActivity.n(this.a);
  }
  
  public void a(boolean paramBoolean, int paramInt, FastWebShareInfo paramFastWebShareInfo)
  {
    super.a(paramBoolean, paramInt, paramFastWebShareInfo);
    String str;
    if (this.a.g != null) {
      str = this.a.g.mArticleContentUrl;
    } else {
      str = "";
    }
    if ((paramBoolean) && (paramFastWebShareInfo != null) && (!TextUtils.isEmpty(paramFastWebShareInfo.a(paramInt))) && (!TextUtils.isEmpty(str))) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    ThreadManager.getUIHandler().post(new FastWebActivity.ArticleRichInfoCallback.1(this, paramBoolean, paramFastWebShareInfo, paramInt, str));
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.a.g != null) && (paramString.equals(this.a.g.innerUniqueID)) && (FastWebActivity.d(this.a) != null))
    {
      ThreadManager.getUIHandler().post(new FastWebActivity.ArticleRichInfoCallback.6(this, paramBoolean));
      return;
    }
    QLog.d("FastWebActivity", 2, "handleLikeStateResp fail, msg not match !");
  }
  
  public void b(long paramLong, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.a.g != null) && (paramString.equals(this.a.g.innerUniqueID)) && (FastWebActivity.d(this.a) != null))
    {
      ThreadManager.getUIHandler().post(new FastWebActivity.ArticleRichInfoCallback.5(this));
      return;
    }
    QLog.e("FastWebActivity", 1, "handleShareCntInfoResp fail, msg not match !");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.ArticleRichInfoCallback
 * JD-Core Version:    0.7.0.1
 */