import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FusionBiuInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastLikeDislikeCreator.ViewHolder.3;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastLikeDislikeCreator.ViewHolder.4;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastLikeDislikeCreator.ViewHolder.6;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;

public class rky
  extends rkj
  implements View.OnClickListener
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private osp jdField_a_of_type_Osp;
  private boolean jdField_a_of_type_Boolean = true;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private int e;
  
  public rky(rkx paramrkx, Context paramContext, View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368615));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363278));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363290));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378241));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363281));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131365912));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363288));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    a(paramContext);
    paramContext = (LinearLayout)paramView.findViewById(2131365911);
    int j = paramContext.getChildCount();
    int k = a(j);
    int i = 0;
    while (i < j)
    {
      paramBaseData = paramContext.getChildAt(i);
      ((LinearLayout.LayoutParams)paramBaseData.getLayoutParams()).width = k;
      paramBaseData.setOnClickListener(this);
      i += 1;
    }
    this.jdField_a_of_type_Osp = new rkz(this, paramrkx);
    paramView.addOnAttachStateChangeListener(new rla(this, paramrkx));
  }
  
  private int a(int paramInt)
  {
    return (int)Math.floor(((int)bbct.a(true) - this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDimensionPixelSize(2131298538) * 2 - (paramInt - 1) * this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDimensionPixelSize(2131298539)) * 1.0D / paramInt);
  }
  
  private void a(Context paramContext)
  {
    if (rmc.a().b())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramContext = rmc.a().a(paramContext);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramContext);
      this.e = vpp.b(BaseApplicationImpl.getApplication().getBaseContext(), 71.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams().height = 0;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = oqe.a("https://pub.idqqimg.com/pc/misc/files/20191128/2058eba02bfd4a65b05383b47e7f5e62.zip");
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(rkx.a(), 1, paramContext.toString());
        }
      }
    }
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    ThreadManager.executeOnSubThread(new WebFastLikeDislikeCreator.ViewHolder.4(this, paramArticleInfo));
    a("0X80101DC");
  }
  
  private void a(FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (paramFastWebArticleInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
    {
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(200L);
      localScaleAnimation.setRepeatCount(1);
      localScaleAnimation.setRepeatMode(2);
      localScaleAnimation.setInterpolator(new DecelerateInterpolator());
      this.jdField_a_of_type_AndroidViewAnimationAnimation = localScaleAnimation;
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(new rlc(this, paramFastWebArticleInfo));
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
  
  private void a(String paramString)
  {
    int j = 1;
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b;
    if (localArticleInfo == null) {
      return;
    }
    onr localonr = rnr.a(localArticleInfo);
    for (;;)
    {
      try
      {
        localonr.b("source_from", "2");
        localonr.j();
        localonr.k();
        localonr.l();
        localonr.a(localArticleInfo.mAlgorithmID);
        localonr.b(localArticleInfo.mStrategyId);
        AladdinConfig localAladdinConfig = Aladdin.getConfig(151);
        if (localAladdinConfig != null)
        {
          i = localAladdinConfig.getIntegerFromString("readinjoy_bottom_action_bar_business_id", -1);
          localonr.b("interact_style", localAladdinConfig.getIntegerFromString("readinjoy_bottom_action_bar_style", -1));
          localonr.b("businessID", i);
        }
        if (!onk.n()) {
          break label226;
        }
        i = 1;
        localonr.b("artical_interact_area", i);
        localonr.b("artical_interact_type", onk.h());
        if ((paramString.equals("0X80101DC")) || (paramString.equals("0X80100DB")))
        {
          if (!onk.o()) {
            break label231;
          }
          i = j;
          localonr.b("ad_relative_pos", i);
        }
        rnr.a(localArticleInfo, paramString, localonr.a());
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(rkx.a(), 2, "parseR5 has error !", paramString);
      return;
      label226:
      int i = 0;
      continue;
      label231:
      i = 0;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight(), this.e });; localValueAnimator = ValueAnimator.ofInt(new int[] { this.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight(), 0 }))
    {
      localValueAnimator.addUpdateListener(new rlb(this));
      localValueAnimator.setDuration(350L);
      localValueAnimator.start();
      return;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt, String paramString)
  {
    if ((rmc.a().b()) && (paramBoolean))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.post(new WebFastLikeDislikeCreator.ViewHolder.3(this));
    }
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructFusionBiuInfo.a = 0L;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructFusionBiuInfo.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b.fusionBiuInfo.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b.fusionBiuInfo.a = 0L;
      return;
    }
    catch (NullPointerException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void a(boolean paramBoolean, long paramLong, int paramInt, String paramString)
  {
    if (rmc.a().b()) {
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        if (paramInt == 1) {
          b();
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841217);
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructFusionBiuInfo.a = paramLong;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructFusionBiuInfo.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b.fusionBiuInfo.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b.fusionBiuInfo.a = paramLong;
      return;
    }
    catch (NullPointerException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void b()
  {
    if ((rmc.a().b()) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
      this.jdField_c_of_type_AndroidWidgetImageView.invalidate();
      this.jdField_c_of_type_AndroidWidgetImageView.setScaleX(1.7F);
      this.jdField_c_of_type_AndroidWidgetImageView.setScaleY(1.7F);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setRepeatCount(0);
      this.jdField_b_of_type_Boolean = true;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.getComposition();
      long l = 1249L;
      if (localObject != null) {
        l = ((LottieComposition)localObject).getDuration();
      }
      localObject = new WebFastLikeDislikeCreator.ViewHolder.6(this);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed((Runnable)localObject, l);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      a("0X80099DA");
      a("0X80100DB");
      a("0X8009A5A");
      if ((!rmc.a().b()) || (!(this.jdField_a_of_type_AndroidViewView.getContext() instanceof FastWebActivity)) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b.fusionBiuInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b.fusionBiuInfo.jdField_b_of_type_Boolean) || (!rmc.a().a())) {}
    }
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    if ((rmc.a().b()) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    paramBaseData1 = paramBaseData2.a;
    if (paramBaseData1 != null)
    {
      int j = onk.h();
      if (paramBaseData1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructFusionBiuInfo != null)
      {
        paramBaseData2 = this.jdField_b_of_type_AndroidWidgetImageView;
        if (!paramBaseData1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructFusionBiuInfo.jdField_b_of_type_Boolean) {
          break label350;
        }
        i = 2130841217;
        paramBaseData2.setImageResource(i);
      }
      if (j != 1) {
        break label366;
      }
      this.jdField_a_of_type_AndroidViewView.findViewById(2131369406).setBackgroundColor(0);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131369379).setBackgroundColor(0);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131369442).setBackgroundColor(0);
      paramBaseData2 = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!paramBaseData1.jdField_a_of_type_Boolean) {
        break label358;
      }
    }
    label350:
    label358:
    for (int i = 2130842306;; i = 2130841225)
    {
      paramBaseData2.setImageResource(i);
      ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369380)).setImageResource(2130841212);
      ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369443)).setImageResource(2130842114);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369381)).setTextColor(Color.parseColor("#737373"));
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369444)).setTextColor(Color.parseColor("#737373"));
      if (!onk.n())
      {
        paramBaseData1 = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365911);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131365911).setPadding(paramBaseData1.getPaddingLeft(), bbkx.b(10.5F), paramBaseData1.getPaddingRight(), paramBaseData1.getPaddingBottom());
      }
      this.jdField_a_of_type_AndroidViewView.findViewById(2131369406).getLayoutParams().height = -2;
      this.jdField_a_of_type_AndroidViewView.findViewById(2131369379).getLayoutParams().height = -2;
      this.jdField_a_of_type_AndroidViewView.findViewById(2131369442).getLayoutParams().height = -2;
      return;
      i = 2130841207;
      break;
    }
    label366:
    paramBaseData2 = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramBaseData1.jdField_a_of_type_Boolean)
    {
      i = 2130842305;
      paramBaseData2.setImageResource(i);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(bhvh.a(paramBaseData1.jdField_a_of_type_Int, 99990000L, "9999万+", rkx.b()));
      if (!paramBaseData1.jdField_a_of_type_Boolean) {
        break label481;
      }
      i = Color.parseColor("#F64B31");
      label428:
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
      if (!paramBaseData1.jdField_a_of_type_Boolean) {
        break label489;
      }
    }
    label481:
    label489:
    for (paramBaseData1 = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130848404);; paramBaseData1 = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130848403))
    {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131369406).setBackgroundDrawable(paramBaseData1);
      return;
      i = 2130841224;
      break;
      i = -16777216;
      break label428;
    }
  }
  
  public void onClick(View paramView)
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b;
    if (localArticleInfo == null) {}
    label247:
    do
    {
      FastWebArticleInfo localFastWebArticleInfo;
      do
      {
        do
        {
          do
          {
            return;
            localFastWebArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.a;
            if (localFastWebArticleInfo == null)
            {
              actn.a(rkx.a(), "", new IllegalArgumentException());
              return;
            }
            switch (paramView.getId())
            {
            default: 
              return;
            }
          } while (!(this.jdField_a_of_type_AndroidViewView.getContext() instanceof FastWebActivity));
          rmc.a().a((FastWebActivity)this.jdField_a_of_type_AndroidViewView.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b.fusionBiuInfo.a, 1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b.innerUniqueID);
          return;
          if (!rmc.a().b()) {
            break label247;
          }
          if ((localFastWebArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructFusionBiuInfo == null) || (localFastWebArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructFusionBiuInfo.jdField_b_of_type_Boolean)) {
            break;
          }
        } while (!(this.jdField_a_of_type_AndroidViewView.getContext() instanceof FastWebActivity));
        rmc.a().a(this.jdField_a_of_type_AndroidViewView.getContext(), onk.a(), 1, 4, localArticleInfo, 1, localArticleInfo.innerUniqueID);
        return;
      } while (localArticleInfo.fusionBiuInfo == null);
      rmc.a().a(this.jdField_a_of_type_AndroidViewView.getContext(), localArticleInfo.fusionBiuInfo.a, onk.a(), localArticleInfo.mFeedType, 1, localArticleInfo.innerUniqueID);
      return;
      if (localFastWebArticleInfo.jdField_a_of_type_Boolean)
      {
        localFastWebArticleInfo.jdField_a_of_type_Boolean = false;
        localFastWebArticleInfo.jdField_a_of_type_Int -= 1;
        rnr.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b, "0X8009765", "2");
      }
      for (;;)
      {
        a(localFastWebArticleInfo);
        osm.a().c();
        osj.a().a(onk.a(), localFastWebArticleInfo.jdField_a_of_type_Boolean, localFastWebArticleInfo);
        return;
        localFastWebArticleInfo.jdField_a_of_type_Boolean = true;
        localFastWebArticleInfo.jdField_a_of_type_Int += 1;
        rnr.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b, "0X8009764", "2");
      }
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b);
      return;
      paramView = this.jdField_a_of_type_AndroidViewView.getContext();
      a("0X8009A5B");
    } while (!(paramView instanceof FastWebActivity));
    ((FastWebActivity)paramView).a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rky
 * JD-Core Version:    0.7.0.1
 */