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

public abstract class sxl
  implements Handler.Callback, sql
{
  public int a;
  protected Context a;
  protected View.OnClickListener a;
  protected qdc a;
  protected sxm a;
  public View g;
  
  public sxl(Context paramContext, qdc paramqdc)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Qdc = paramqdc;
  }
  
  protected static void a(qdc paramqdc, BaseArticleInfo paramBaseArticleInfo, VideoColumnInfo paramVideoColumnInfo, int paramInt, String paramString)
  {
    int k = paramqdc.a().a();
    String str = pqw.b(paramBaseArticleInfo);
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
      paramqdc = new suu(pqf.a(paramBaseArticleInfo.mAlgorithmID, pqw.a(paramBaseArticleInfo), 0, i, j, NetworkUtil.isWifiConnected(paramqdc.a()), str, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, pqw.d(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
      paramqdc.i(paramBaseArticleInfo.innerUniqueID).a(k).d(paramBaseArticleInfo.mStrategyId).g(omx.a).h(409409).j(paramBaseArticleInfo.mVideoAdsJumpType).k(paramBaseArticleInfo.mVideoAdsSource).a(Boolean.valueOf(pqw.f(paramBaseArticleInfo))).a(paramBaseArticleInfo.videoReportInfo).Q(paramInt).p(paramString).f(paramBaseArticleInfo);
      if (paramVideoColumnInfo != null) {
        paramqdc.X(paramVideoColumnInfo.a);
      }
      olh.a(null, "", "0X8007625", "0X8007625", 0, 0, "2", "", "", paramqdc.a().a(), false);
      return;
      i = 0;
      break;
    }
  }
  
  public abstract View a(int paramInt, ViewGroup paramViewGroup);
  
  protected final BaseArticleInfo a(View paramView)
  {
    return qdc.a(this.jdField_a_of_type_Qdc, paramView);
  }
  
  protected final qdh a(View paramView)
  {
    if ((paramView == null) || (!(paramView.getTag() instanceof qdh))) {
      return null;
    }
    return (qdh)paramView.getTag();
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
    pjr.a(paramKandianUrlImageView, paramURL, this.jdField_a_of_type_AndroidContentContext, paramBoolean);
  }
  
  public void a(spk paramspk, int paramInt1, int paramInt2) {}
  
  public void a(sxm paramsxm)
  {
    this.jdField_a_of_type_Sxm = paramsxm;
    this.jdField_a_of_type_Sxm.a.add(this);
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
 * Qualified Name:     sxl
 * JD-Core Version:    0.7.0.1
 */