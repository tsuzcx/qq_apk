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
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;

public class sxi
  extends sxh
  implements View.OnClickListener
{
  public KanDianUrlRoundCornerImageView a;
  public View f;
  public TextView j;
  public TextView k;
  public TextView l;
  
  public sxi(Context paramContext, qdc paramqdc)
  {
    super(paramContext, paramqdc);
  }
  
  private int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130846375;
    }
    return 2130842979;
  }
  
  private void a(View paramView)
  {
    paramView = a(paramView);
    if ((paramView != null) && (this.jdField_a_of_type_Qdc != null) && (paramView.mVideoColumnInfo != null) && (!paramView.mVideoColumnInfo.jdField_a_of_type_Boolean))
    {
      this.l.setSelected(false);
      this.l.setText(anvx.a(2131715638));
      Object localObject = paramView.mVideoColumnInfo;
      ((VideoColumnInfo)localObject).jdField_c_of_type_Int += 1;
      six.a(this.k, paramView.mVideoColumnInfo.jdField_c_of_type_Int, anvx.a(2131715644), "0");
      paramView.mVideoColumnInfo.jdField_a_of_type_Boolean = true;
      if ((paramView instanceof ArticleInfo)) {
        pvj.a().b((ArticleInfo)paramView);
      }
      localObject = Message.obtain();
      ((Message)localObject).obj = this;
      ((Message)localObject).arg1 = paramView.mVideoColumnInfo.jdField_a_of_type_Int;
      ((Message)localObject).what = 1;
      this.jdField_a_of_type_Sxm.sendMessageDelayed((Message)localObject, 3000L);
      six.a(this.jdField_a_of_type_Qdc.a(), paramView.mVideoColumnInfo.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
      six.a(pnn.a(), paramView.mVideoColumnInfo.jdField_a_of_type_Int, true, paramView.mVideoColumnInfo.jdField_c_of_type_JavaLangString);
      pqb.b(paramView, 2);
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
    localScaleAnimation.setAnimationListener(new sxk(this, paramImageView, paramBoolean));
    paramImageView.startAnimation(localScaleAnimation);
  }
  
  private void b(View paramView)
  {
    if ((paramView == null) || (this.jdField_a_of_type_Qdc == null)) {
      return;
    }
    BaseArticleInfo localBaseArticleInfo = a(paramView);
    if ((localBaseArticleInfo != null) && (this.jdField_a_of_type_Qdc != null) && (localBaseArticleInfo.mVideoColumnInfo != null) && (localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) && (localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_Int != 3)) {
      six.a(this.jdField_a_of_type_Qdc.a(), localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
    }
    for (;;)
    {
      pqb.b(localBaseArticleInfo, 1);
      return;
      paramView = qdc.a(paramView);
      if (paramView != null) {
        this.jdField_a_of_type_Qdc.a().a(paramView.a(), localBaseArticleInfo, false, false);
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
      localBaseArticleInfo = a(paramView);
    } while ((localBaseArticleInfo == null) || (localBaseArticleInfo.mSocialFeedInfo == null));
    int i;
    SocializeFeedsInfo localSocializeFeedsInfo;
    label65:
    int m;
    label98:
    label111:
    long l1;
    if (localBaseArticleInfo.mSocialFeedInfo.jdField_c_of_type_Int == 1)
    {
      i = 1;
      if (i == 0) {
        break label202;
      }
      localSocializeFeedsInfo = localBaseArticleInfo.mSocialFeedInfo;
      localSocializeFeedsInfo.b -= 1;
      six.a(this.d, localBaseArticleInfo.mSocialFeedInfo.b, anvx.a(2131715639));
      localSocializeFeedsInfo = localBaseArticleInfo.mSocialFeedInfo;
      if (i == 0) {
        break label224;
      }
      m = 0;
      localSocializeFeedsInfo.jdField_c_of_type_Int = m;
      if (i != 0) {
        break label229;
      }
      bool1 = true;
      a(bool1, (ImageView)paramView);
      paramView = pnn.a();
      if (paramView != null)
      {
        paramView = (uwt)paramView.getBusinessHandler(BusinessHandlerFactory.PUBLIC_ACCOUNT_VIDEO_DIANZAN);
        if (i != 0) {
          break label235;
        }
        bool1 = true;
        label147:
        paramView.a(localBaseArticleInfo, bool1);
      }
      if ((localBaseArticleInfo instanceof ArticleInfo)) {
        pvj.a().b((ArticleInfo)localBaseArticleInfo);
      }
      l1 = localBaseArticleInfo.mAlgorithmID;
      if (i != 0) {
        break label241;
      }
    }
    label202:
    label224:
    label229:
    label235:
    label241:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      pqb.a(l1, bool1);
      return;
      i = 0;
      break;
      localSocializeFeedsInfo = localBaseArticleInfo.mSocialFeedInfo;
      localSocializeFeedsInfo.b += 1;
      break label65;
      m = 1;
      break label98;
      bool1 = false;
      break label111;
      bool1 = false;
      break label147;
    }
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = super.a(paramInt, paramViewGroup);
    this.f = ((ViewStub)paramViewGroup.findViewById(2131380843)).inflate();
    this.f.setId(2131380843);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)this.f.findViewById(2131369362));
    this.j = ((TextView)this.f.findViewById(2131379838));
    this.k = ((TextView)this.f.findViewById(2131380181));
    this.l = ((TextView)this.f.findViewById(2131380180));
    paramViewGroup.findViewById(2131380841).setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setCorner(ViewUtils.dpToPx(2.0F));
    this.f.setOnClickListener(this);
    this.l.setOnClickListener(this);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).leftMargin = ViewUtils.dip2px(0.0F);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setLayoutParams(localLayoutParams);
    }
    this.c.setPadding(ViewUtils.dpToPx(1.0F), this.c.getPaddingTop(), this.c.getPaddingRight(), this.c.getPaddingBottom());
    this.d.setVisibility(0);
    return paramViewGroup;
  }
  
  public void a(int paramInt)
  {
    BaseArticleInfo localBaseArticleInfo = a(this.l);
    if ((localBaseArticleInfo != null) && (localBaseArticleInfo.mVideoColumnInfo != null) && (localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int == paramInt)) {
      six.a(this.l, 8, 600);
    }
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
      six.a(this.d, m, anvx.a(2131715642));
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(six.c(paramBaseArticleInfo.mVideoPlayCount) + anvx.a(2131715640));
      break;
      label160:
      bool = false;
      break label75;
      label166:
      i = 2130842979;
    }
  }
  
  public void a(VideoColumnInfo paramVideoColumnInfo)
  {
    if (paramVideoColumnInfo == null)
    {
      this.f.setVisibility(8);
      return;
    }
    this.f.setVisibility(0);
    try
    {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, new URL(paramVideoColumnInfo.jdField_c_of_type_JavaLangString));
      String str = "";
      if (!TextUtils.isEmpty(paramVideoColumnInfo.b)) {
        str = "#" + paramVideoColumnInfo.b;
      }
      this.j.setText(str);
      six.a(this.k, paramVideoColumnInfo.jdField_c_of_type_Int, anvx.a(2131715641), "0");
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
      this.l.setText(anvx.a(2131715643));
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    ((sxi)paramMessage.obj).a(paramMessage.arg1);
    return true;
  }
  
  public void onClick(View paramView)
  {
    qdc.a(paramView);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      qgx.a().a(this.jdField_a_of_type_AndroidContentContext, 3, new sxj(this, paramView));
      continue;
      b(paramView);
      continue;
      a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sxi
 * JD-Core Version:    0.7.0.1
 */