import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
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
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastLikeDislikeCreator.ViewHolder.1;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;

public class szd
  extends syj
  implements View.OnClickListener
{
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean jdField_a_of_type_Boolean = true;
  
  public szd(szc paramszc, Context paramContext, View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369178));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379750));
    paramszc = (LinearLayout)paramView.findViewById(2131366254);
    int j = paramszc.getChildCount();
    int k = a(j);
    int i = 0;
    while (i < j)
    {
      paramContext = paramszc.getChildAt(i);
      ((LinearLayout.LayoutParams)paramContext.getLayoutParams()).width = k;
      paramContext.setOnClickListener(this);
      i += 1;
    }
  }
  
  private int a(int paramInt)
  {
    return (int)Math.floor(((int)bgln.a(true) - this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDimensionPixelSize(2131298646) * 2 - (paramInt - 1) * this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDimensionPixelSize(2131298647)) * 1.0D / paramInt);
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    ThreadManager.executeOnSubThread(new WebFastLikeDislikeCreator.ViewHolder.1(this, paramArticleInfo));
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
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(new sze(this, paramFastWebArticleInfo));
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
  
  private void a(String paramString)
  {
    int j = 1;
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b;
    if (localArticleInfo == null) {
      return;
    }
    phi localphi = tcc.a(localArticleInfo);
    for (;;)
    {
      try
      {
        localphi.b("source_from", "2");
        localphi.j();
        localphi.k();
        localphi.l();
        localphi.a(localArticleInfo.mAlgorithmID);
        localphi.b(localArticleInfo.mStrategyId);
        AladdinConfig localAladdinConfig = Aladdin.getConfig(151);
        if (localAladdinConfig != null)
        {
          i = localAladdinConfig.getIntegerFromString("readinjoy_bottom_action_bar_business_id", -1);
          localphi.b("interact_style", localAladdinConfig.getIntegerFromString("readinjoy_bottom_action_bar_style", -1));
          localphi.b("businessID", i);
        }
        if (!pha.p()) {
          break label217;
        }
        i = 1;
        localphi.b("artical_interact_area", i);
        localphi.b("artical_interact_type", pha.h());
        if ((paramString.equals("0X80101DC")) || (paramString.equals("0X80100DB")))
        {
          if (!pha.q()) {
            break label222;
          }
          i = j;
          localphi.b("ad_relative_pos", i);
        }
        tcc.a(localArticleInfo, paramString, localphi.a());
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(szc.a(), 2, "parseR5 has error !", paramString);
      return;
      label217:
      int i = 0;
      continue;
      label222:
      i = 0;
    }
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    paramBaseData1 = paramBaseData2.a;
    if (paramBaseData1 != null)
    {
      if (pha.h() != 1) {
        break label288;
      }
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370093).setBackgroundColor(0);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370058).setBackgroundColor(0);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370145).setBackgroundColor(0);
      paramBaseData2 = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!paramBaseData1.jdField_a_of_type_Boolean) {
        break label280;
      }
    }
    label280:
    for (int i = 2130842814;; i = 2130841647)
    {
      paramBaseData2.setImageResource(i);
      ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370059)).setImageResource(2130841634);
      ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370146)).setImageResource(2130842591);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370060)).setTextColor(Color.parseColor("#737373"));
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370147)).setTextColor(Color.parseColor("#737373"));
      if (!pha.p())
      {
        paramBaseData1 = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366254);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131366254).setPadding(paramBaseData1.getPaddingLeft(), bgtn.b(10.5F), paramBaseData1.getPaddingRight(), paramBaseData1.getPaddingBottom());
      }
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370093).getLayoutParams().height = -2;
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370058).getLayoutParams().height = -2;
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370145).getLayoutParams().height = -2;
      return;
    }
    label288:
    paramBaseData2 = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramBaseData1.jdField_a_of_type_Boolean)
    {
      i = 2130842813;
      paramBaseData2.setImageResource(i);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(bmqa.a(paramBaseData1.jdField_a_of_type_Int, 99990000L, "9999万+", szc.a));
      if (!paramBaseData1.jdField_a_of_type_Boolean) {
        break label403;
      }
      i = Color.parseColor("#F64B31");
      label350:
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
      if (!paramBaseData1.jdField_a_of_type_Boolean) {
        break label411;
      }
    }
    label403:
    label411:
    for (paramBaseData1 = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130849382);; paramBaseData1 = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130849381))
    {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370093).setBackgroundDrawable(paramBaseData1);
      return;
      i = 2130841646;
      break;
      i = -16777216;
      break label350;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      a("0X80099DA");
      a("0X80100DB");
      a("0X8009A5A");
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.a;
      if (localObject == null) {
        afur.a(szc.a(), "", new IllegalArgumentException());
      } else {
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131370058: 
          a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b);
          break;
        case 2131370093: 
          if (((FastWebArticleInfo)localObject).jdField_a_of_type_Boolean)
          {
            ((FastWebArticleInfo)localObject).jdField_a_of_type_Boolean = false;
            ((FastWebArticleInfo)localObject).jdField_a_of_type_Int -= 1;
            tcc.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b, "0X8009765", "2");
          }
          for (;;)
          {
            a((FastWebArticleInfo)localObject);
            pmk.a().c();
            pmh.a().a(pha.a(), ((FastWebArticleInfo)localObject).jdField_a_of_type_Boolean, (FastWebArticleInfo)localObject);
            break;
            ((FastWebArticleInfo)localObject).jdField_a_of_type_Boolean = true;
            ((FastWebArticleInfo)localObject).jdField_a_of_type_Int += 1;
            tcc.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b, "0X8009764", "2");
          }
        case 2131370145: 
          localObject = this.jdField_a_of_type_AndroidViewView.getContext();
          a("0X8009A5B");
          if ((localObject instanceof FastWebActivity)) {
            ((FastWebActivity)localObject).a(false);
          }
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     szd
 * JD-Core Version:    0.7.0.1
 */