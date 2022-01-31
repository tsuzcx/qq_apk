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
import java.net.MalformedURLException;
import java.net.URL;

public class ona
  extends omz
  implements View.OnClickListener
{
  private KanDianUrlRoundCornerImageView a;
  private View g;
  private TextView j;
  private TextView k;
  private TextView l;
  
  public ona(Context paramContext, oms paramoms)
  {
    super(paramContext, paramoms);
  }
  
  private int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130845272;
    }
    return 2130842284;
  }
  
  private void a(int paramInt)
  {
    BaseArticleInfo localBaseArticleInfo = oms.a(this.jdField_a_of_type_Oms, this.l);
    if ((localBaseArticleInfo != null) && (localBaseArticleInfo.mVideoColumnInfo != null) && (localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int == paramInt)) {
      qcn.a(this.l, 8, 600);
    }
  }
  
  private void a(View paramView)
  {
    paramView = oms.a(this.jdField_a_of_type_Oms, paramView);
    if ((paramView != null) && (this.jdField_a_of_type_Oms != null) && (paramView.mVideoColumnInfo != null) && (!paramView.mVideoColumnInfo.jdField_a_of_type_Boolean))
    {
      this.l.setSelected(false);
      this.l.setText(ajjy.a(2131650484));
      Object localObject = paramView.mVideoColumnInfo;
      ((VideoColumnInfo)localObject).jdField_c_of_type_Int += 1;
      qcn.a(this.k, paramView.mVideoColumnInfo.jdField_c_of_type_Int, ajjy.a(2131650490), "0");
      paramView.mVideoColumnInfo.jdField_a_of_type_Boolean = true;
      if ((paramView instanceof ArticleInfo)) {
        ogy.a().a((ArticleInfo)paramView);
      }
      localObject = Message.obtain();
      ((Message)localObject).obj = this;
      ((Message)localObject).arg1 = paramView.mVideoColumnInfo.jdField_a_of_type_Int;
      ((Message)localObject).what = 1;
      oms.a(this.jdField_a_of_type_Oms).sendMessageDelayed((Message)localObject, 3000L);
      qcn.a(this.jdField_a_of_type_Oms.a(), paramView.mVideoColumnInfo.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
      qcn.a(obz.a(), paramView.mVideoColumnInfo.jdField_a_of_type_Int);
      obz.b(paramView, 2);
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
    localScaleAnimation.setAnimationListener(new onb(this, paramImageView, paramBoolean));
    paramImageView.startAnimation(localScaleAnimation);
  }
  
  private void b(View paramView)
  {
    if ((paramView == null) || (this.jdField_a_of_type_Oms == null)) {
      return;
    }
    BaseArticleInfo localBaseArticleInfo = oms.a(this.jdField_a_of_type_Oms, paramView);
    if ((localBaseArticleInfo != null) && (this.jdField_a_of_type_Oms != null) && (localBaseArticleInfo.mVideoColumnInfo != null) && (localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) && (localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_Int != 3)) {
      qcn.a(this.jdField_a_of_type_Oms.a(), localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
    }
    for (;;)
    {
      obz.b(localBaseArticleInfo, 1);
      return;
      paramView = oms.a(paramView);
      if (paramView != null) {
        this.jdField_a_of_type_Oms.a().a(paramView.a(), localBaseArticleInfo, false, false);
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
      localBaseArticleInfo = oms.a(this.jdField_a_of_type_Oms, paramView);
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
      qcn.a(this.d, localBaseArticleInfo.mSocialFeedInfo.b, ajjy.a(2131650485));
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
      paramView = obz.a();
      if (paramView != null)
      {
        paramView = (rwe)paramView.a(126);
        if (i != 0) {
          break label237;
        }
        bool1 = true;
        label149:
        paramView.a(localBaseArticleInfo, bool1);
      }
      if ((localBaseArticleInfo instanceof ArticleInfo)) {
        ogy.a().a((ArticleInfo)localBaseArticleInfo);
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
      obz.a(l1, bool1);
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
    this.g = ((ViewStub)paramViewGroup.findViewById(2131313111)).inflate();
    this.g.setId(2131313111);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)this.g.findViewById(2131302912));
    this.j = ((TextView)this.g.findViewById(2131312275));
    this.k = ((TextView)this.g.findViewById(2131312535));
    this.l = ((TextView)this.g.findViewById(2131312534));
    paramViewGroup.findViewById(2131313109).setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setCorner(bajq.b(2.0F));
    this.g.setOnClickListener(this);
    this.l.setOnClickListener(this);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).leftMargin = bajq.a(0.0F);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setLayoutParams(localLayoutParams);
    }
    this.c.setPadding(bajq.b(1.0F), this.c.getPaddingTop(), this.c.getPaddingRight(), this.c.getPaddingBottom());
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
      qcn.a(this.d, m, ajjy.a(2131650488));
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(qcn.c(paramBaseArticleInfo.mVideoPlayCount) + ajjy.a(2131650486));
      break;
      label160:
      bool = false;
      break label75;
      label166:
      i = 2130842284;
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
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, new URL(paramVideoColumnInfo.b));
      String str = "";
      if (!TextUtils.isEmpty(paramVideoColumnInfo.jdField_a_of_type_JavaLangString)) {
        str = "#" + paramVideoColumnInfo.jdField_a_of_type_JavaLangString;
      }
      this.j.setText(str);
      qcn.a(this.k, paramVideoColumnInfo.jdField_c_of_type_Int, ajjy.a(2131650487), "0");
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
      this.l.setText(ajjy.a(2131650489));
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131302279: 
      c(paramView);
      return;
    case 2131313111: 
      b(paramView);
      return;
    }
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ona
 * JD-Core Version:    0.7.0.1
 */