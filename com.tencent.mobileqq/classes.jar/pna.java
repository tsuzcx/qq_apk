import android.content.Context;
import android.graphics.Color;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianUrlRoundCornerImageView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;

public class pna
  extends pmz
  implements View.OnClickListener
{
  private KanDianUrlRoundCornerImageView a;
  private View g;
  private TextView j;
  private TextView k;
  private TextView l;
  
  public pna(Context paramContext, pms parampms)
  {
    super(paramContext, parampms);
  }
  
  private int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130846371;
    }
    return 2130842893;
  }
  
  private void a(int paramInt)
  {
    BaseArticleInfo localBaseArticleInfo = pms.a(this.jdField_a_of_type_Pms, this.l);
    if ((localBaseArticleInfo != null) && (localBaseArticleInfo.mVideoColumnInfo != null) && (localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int == paramInt)) {
      rpt.a(this.l, 8, 600);
    }
  }
  
  private void a(View paramView)
  {
    paramView = pms.a(this.jdField_a_of_type_Pms, paramView);
    if ((paramView != null) && (this.jdField_a_of_type_Pms != null) && (paramView.mVideoColumnInfo != null) && (!paramView.mVideoColumnInfo.jdField_a_of_type_Boolean))
    {
      this.l.setSelected(false);
      this.l.setText(anzj.a(2131715056));
      Object localObject = paramView.mVideoColumnInfo;
      ((VideoColumnInfo)localObject).jdField_c_of_type_Int += 1;
      rpt.a(this.k, paramView.mVideoColumnInfo.jdField_c_of_type_Int, anzj.a(2131715062), "0");
      paramView.mVideoColumnInfo.jdField_a_of_type_Boolean = true;
      if ((paramView instanceof ArticleInfo)) {
        pfa.a().b((ArticleInfo)paramView);
      }
      localObject = Message.obtain();
      ((Message)localObject).obj = this;
      ((Message)localObject).arg1 = paramView.mVideoColumnInfo.jdField_a_of_type_Int;
      ((Message)localObject).what = 1;
      pms.a(this.jdField_a_of_type_Pms).sendMessageDelayed((Message)localObject, 3000L);
      rpt.a(this.jdField_a_of_type_Pms.a(), paramView.mVideoColumnInfo.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
      rpt.a(ozs.a(), paramView.mVideoColumnInfo.jdField_a_of_type_Int, true, paramView.mVideoColumnInfo.jdField_c_of_type_JavaLangString);
      ozs.b(paramView, 2);
    }
  }
  
  private void a(boolean paramBoolean, ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(200L);
    localScaleAnimation.setRepeatCount(1);
    localScaleAnimation.setRepeatMode(2);
    localScaleAnimation.setInterpolator(new DecelerateInterpolator());
    localScaleAnimation.setAnimationListener(new pnb(this, paramImageView, paramBoolean));
    paramImageView.startAnimation(localScaleAnimation);
  }
  
  private void b(View paramView)
  {
    if ((paramView == null) || (this.jdField_a_of_type_Pms == null)) {
      return;
    }
    BaseArticleInfo localBaseArticleInfo = pms.a(this.jdField_a_of_type_Pms, paramView);
    if ((localBaseArticleInfo != null) && (this.jdField_a_of_type_Pms != null) && (localBaseArticleInfo.mVideoColumnInfo != null) && (localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) && (localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_Int != 3)) {
      rpt.a(this.jdField_a_of_type_Pms.a(), localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
    }
    for (;;)
    {
      ozs.b(localBaseArticleInfo, 1);
      return;
      paramView = pms.a(paramView);
      if (paramView != null) {
        this.jdField_a_of_type_Pms.a().a(paramView.a(), localBaseArticleInfo, false, false);
      }
    }
  }
  
  private void c(View paramView)
  {
    boolean bool2 = true;
    if (paramView == null) {}
    BaseArticleInfo localBaseArticleInfo;
    do
    {
      return;
      localBaseArticleInfo = pms.a(this.jdField_a_of_type_Pms, paramView);
    } while ((localBaseArticleInfo == null) || (localBaseArticleInfo.mSocialFeedInfo == null));
    int i;
    SocializeFeedsInfo localSocializeFeedsInfo;
    label68:
    int m;
    label101:
    label114:
    long l1;
    if (localBaseArticleInfo.mSocialFeedInfo.jdField_c_of_type_Int == 1)
    {
      i = 1;
      if (i == 0) {
        break label204;
      }
      localSocializeFeedsInfo = localBaseArticleInfo.mSocialFeedInfo;
      localSocializeFeedsInfo.b -= 1;
      rpt.a(this.d, localBaseArticleInfo.mSocialFeedInfo.b, anzj.a(2131715057));
      localSocializeFeedsInfo = localBaseArticleInfo.mSocialFeedInfo;
      if (i == 0) {
        break label226;
      }
      m = 0;
      localSocializeFeedsInfo.jdField_c_of_type_Int = m;
      if (i != 0) {
        break label231;
      }
      bool1 = true;
      a(bool1, (ImageView)paramView);
      paramView = ozs.a();
      if (paramView != null)
      {
        paramView = (ucg)paramView.a(126);
        if (i != 0) {
          break label237;
        }
        bool1 = true;
        label149:
        paramView.a(localBaseArticleInfo, bool1);
      }
      if ((localBaseArticleInfo instanceof ArticleInfo)) {
        pfa.a().b((ArticleInfo)localBaseArticleInfo);
      }
      l1 = localBaseArticleInfo.mAlgorithmID;
      if (i != 0) {
        break label243;
      }
    }
    label204:
    label226:
    label231:
    label237:
    label243:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ozs.a(l1, bool1);
      return;
      i = 0;
      break;
      localSocializeFeedsInfo = localBaseArticleInfo.mSocialFeedInfo;
      localSocializeFeedsInfo.b += 1;
      break label68;
      m = 1;
      break label101;
      bool1 = false;
      break label114;
      bool1 = false;
      break label149;
    }
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = super.a(paramInt, paramViewGroup);
    this.g = ((ViewStub)paramViewGroup.findViewById(2131380777)).inflate();
    this.g.setId(2131380777);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)this.g.findViewById(2131369176));
    this.j = ((TextView)this.g.findViewById(2131379743));
    this.k = ((TextView)this.g.findViewById(2131380108));
    this.l = ((TextView)this.g.findViewById(2131380107));
    paramViewGroup.findViewById(2131380775).setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setCorner(bhtq.b(2.0F));
    this.g.setOnClickListener(this);
    this.l.setOnClickListener(this);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).leftMargin = bhtq.a(0.0F);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setLayoutParams(localLayoutParams);
    }
    this.c.setPadding(bhtq.b(1.0F), this.c.getPaddingTop(), this.c.getPaddingRight(), this.c.getPaddingBottom());
    this.d.setVisibility(0);
    return paramViewGroup;
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool = true;
    int m = 0;
    if (paramBaseArticleInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setVisibility(8);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setTextColor(Color.parseColor("#797E8E"));
    label75:
    int i;
    if (paramBaseArticleInfo.mVideoPlayCount == 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(8);
      if (paramBaseArticleInfo.mSocialFeedInfo == null) {
        break label166;
      }
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_c_of_type_Int != 1) {
        break label160;
      }
      i = a(bool);
      m = paramBaseArticleInfo.mSocialFeedInfo.b;
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(i);
      rpt.a(this.d, m, anzj.a(2131715060));
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(rpt.c(paramBaseArticleInfo.mVideoPlayCount) + anzj.a(2131715058));
      break;
      label160:
      bool = false;
      break label75;
      label166:
      i = 2130842893;
    }
  }
  
  public void a(VideoColumnInfo paramVideoColumnInfo)
  {
    if (paramVideoColumnInfo == null)
    {
      this.g.setVisibility(8);
      return;
    }
    this.g.setVisibility(0);
    try
    {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, new URL(paramVideoColumnInfo.jdField_c_of_type_JavaLangString));
      String str = "";
      if (!TextUtils.isEmpty(paramVideoColumnInfo.b)) {
        str = "#" + paramVideoColumnInfo.b;
      }
      this.j.setText(str);
      rpt.a(this.k, paramVideoColumnInfo.jdField_c_of_type_Int, anzj.a(2131715059), "0");
      if (paramVideoColumnInfo.jdField_a_of_type_Boolean)
      {
        this.l.setVisibility(8);
        return;
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        localMalformedURLException.printStackTrace();
      }
      this.l.setVisibility(0);
      this.l.setSelected(true);
      this.l.setText(anzj.a(2131715061));
    }
  }
  
  public void onClick(View paramView)
  {
    pms.a(paramView);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      c(paramView);
      continue;
      b(paramView);
      continue;
      a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pna
 * JD-Core Version:    0.7.0.1
 */