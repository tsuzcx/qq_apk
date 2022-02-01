import android.content.Context;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.net.URL;
import java.util.List;

public abstract class skb
  implements Handler.Callback, seg
{
  public int a;
  protected Context a;
  protected View.OnClickListener a;
  protected psf a;
  protected skc a;
  public View g;
  
  public skb(Context paramContext, psf parampsf)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Psf = parampsf;
  }
  
  protected static void a(psf parampsf, BaseArticleInfo paramBaseArticleInfo, VideoColumnInfo paramVideoColumnInfo, int paramInt, String paramString)
  {
    int k = parampsf.a().a();
    String str = pay.d(paramBaseArticleInfo);
    int i;
    if (((ArticleInfo)paramBaseArticleInfo).hasChannelInfo())
    {
      i = paramBaseArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleFriendLikeText)) {
        break label217;
      }
    }
    label217:
    for (int j = 0;; j = 1)
    {
      parampsf = new sie(pay.a(paramBaseArticleInfo.mAlgorithmID, pay.a(paramBaseArticleInfo), 0, i, j, NetworkUtil.isWifiConnected(parampsf.a()), str, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, pay.f(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
      parampsf.i(paramBaseArticleInfo.innerUniqueID).a(k).d(paramBaseArticleInfo.mStrategyId).g(ofe.a).h(409409).j(paramBaseArticleInfo.mVideoAdsJumpType).k(paramBaseArticleInfo.mVideoAdsSource).a(Boolean.valueOf(pay.w(paramBaseArticleInfo))).a(paramBaseArticleInfo.videoReportInfo).Q(paramInt).p(paramString).f(paramBaseArticleInfo);
      if (paramVideoColumnInfo != null) {
        parampsf.X(paramVideoColumnInfo.a);
      }
      odq.a(null, "", "0X8007625", "0X8007625", 0, 0, "2", "", "", parampsf.a().a(), false);
      return;
      i = 0;
      break;
    }
  }
  
  public abstract View a(int paramInt, ViewGroup paramViewGroup);
  
  protected final BaseArticleInfo a(View paramView)
  {
    return psf.a(this.jdField_a_of_type_Psf, paramView);
  }
  
  protected final psk a(View paramView)
  {
    if ((paramView == null) || (!(paramView.getTag() instanceof psk))) {
      return null;
    }
    return (psk)paramView.getTag();
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  protected void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL)
  {
    a(paramKandianUrlImageView, paramURL, false);
  }
  
  protected void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, boolean paramBoolean)
  {
    pai.a(paramKandianUrlImageView, paramURL, this.jdField_a_of_type_AndroidContentContext, paramBoolean);
  }
  
  public void a(sdg paramsdg, int paramInt1, int paramInt2) {}
  
  public void a(skc paramskc)
  {
    this.jdField_a_of_type_Skc = paramskc;
    this.jdField_a_of_type_Skc.a.add(this);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     skb
 * JD-Core Version:    0.7.0.1
 */