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

public class oym
  extends oyl
  implements View.OnClickListener
{
  private KanDianUrlRoundCornerImageView a;
  private View g;
  private TextView j;
  private TextView k;
  private TextView l;
  
  public oym(Context paramContext, oye paramoye)
  {
    super(paramContext, paramoye);
  }
  
  private int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130845463;
    }
    return 2130842368;
  }
  
  private void a(int paramInt)
  {
    BaseArticleInfo localBaseArticleInfo = oye.a(this.jdField_a_of_type_Oye, this.l);
    if ((localBaseArticleInfo != null) && (localBaseArticleInfo.mVideoColumnInfo != null) && (localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int == paramInt)) {
      qoi.a(this.l, 8, 600);
    }
  }
  
  private void a(View paramView)
  {
    paramView = oye.a(this.jdField_a_of_type_Oye, paramView);
    if ((paramView != null) && (this.jdField_a_of_type_Oye != null) && (paramView.mVideoColumnInfo != null) && (!paramView.mVideoColumnInfo.jdField_a_of_type_Boolean))
    {
      this.l.setSelected(false);
      this.l.setText(ajya.a(2131716286));
      Object localObject = paramView.mVideoColumnInfo;
      ((VideoColumnInfo)localObject).jdField_c_of_type_Int += 1;
      qoi.a(this.k, paramView.mVideoColumnInfo.jdField_c_of_type_Int, ajya.a(2131716292), "0");
      paramView.mVideoColumnInfo.jdField_a_of_type_Boolean = true;
      if ((paramView instanceof ArticleInfo)) {
        osg.a().a((ArticleInfo)paramView);
      }
      localObject = Message.obtain();
      ((Message)localObject).obj = this;
      ((Message)localObject).arg1 = paramView.mVideoColumnInfo.jdField_a_of_type_Int;
      ((Message)localObject).what = 1;
      oye.a(this.jdField_a_of_type_Oye).sendMessageDelayed((Message)localObject, 3000L);
      qoi.a(this.jdField_a_of_type_Oye.a(), paramView.mVideoColumnInfo.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
      qoi.a(onh.a(), paramView.mVideoColumnInfo.jdField_a_of_type_Int);
      onh.b(paramView, 2);
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
    localScaleAnimation.setAnimationListener(new oyn(this, paramImageView, paramBoolean));
    paramImageView.startAnimation(localScaleAnimation);
  }
  
  private void b(View paramView)
  {
    if ((paramView == null) || (this.jdField_a_of_type_Oye == null)) {
      return;
    }
    BaseArticleInfo localBaseArticleInfo = oye.a(this.jdField_a_of_type_Oye, paramView);
    if ((localBaseArticleInfo != null) && (this.jdField_a_of_type_Oye != null) && (localBaseArticleInfo.mVideoColumnInfo != null) && (localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) && (localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_Int != 3)) {
      qoi.a(this.jdField_a_of_type_Oye.a(), localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
    }
    for (;;)
    {
      onh.b(localBaseArticleInfo, 1);
      return;
      paramView = oye.a(paramView);
      if (paramView != null) {
        this.jdField_a_of_type_Oye.a().a(paramView.a(), localBaseArticleInfo, false, false);
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
      localBaseArticleInfo = oye.a(this.jdField_a_of_type_Oye, paramView);
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
      qoi.a(this.d, localBaseArticleInfo.mSocialFeedInfo.b, ajya.a(2131716287));
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
      paramView = onh.a();
      if (paramView != null)
      {
        paramView = (siu)paramView.a(126);
        if (i != 0) {
          break label237;
        }
        bool1 = true;
        label149:
        paramView.a(localBaseArticleInfo, bool1);
      }
      if ((localBaseArticleInfo instanceof ArticleInfo)) {
        osg.a().a((ArticleInfo)localBaseArticleInfo);
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
      onh.a(l1, bool1);
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
    this.g = ((ViewStub)paramViewGroup.findViewById(2131378940)).inflate();
    this.g.setId(2131378940);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)this.g.findViewById(2131368536));
    this.j = ((TextView)this.g.findViewById(2131378098));
    this.k = ((TextView)this.g.findViewById(2131378363));
    this.l = ((TextView)this.g.findViewById(2131378362));
    paramViewGroup.findViewById(2131378938).setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setCorner(bbll.b(2.0F));
    this.g.setOnClickListener(this);
    this.l.setOnClickListener(this);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).leftMargin = bbll.a(0.0F);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setLayoutParams(localLayoutParams);
    }
    this.c.setPadding(bbll.b(1.0F), this.c.getPaddingTop(), this.c.getPaddingRight(), this.c.getPaddingBottom());
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
      qoi.a(this.d, m, ajya.a(2131716290));
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(qoi.c(paramBaseArticleInfo.mVideoPlayCount) + ajya.a(2131716288));
      break;
      label160:
      bool = false;
      break label75;
      label166:
      i = 2130842368;
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
      qoi.a(this.k, paramVideoColumnInfo.jdField_c_of_type_Int, ajya.a(2131716289), "0");
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
      this.l.setText(ajya.a(2131716291));
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131367899: 
      c(paramView);
      return;
    case 2131378940: 
      b(paramView);
      return;
    }
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oym
 * JD-Core Version:    0.7.0.1
 */