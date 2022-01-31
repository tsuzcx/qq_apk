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
import org.json.JSONException;

public class saw
  extends sah
  implements View.OnClickListener
{
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean jdField_a_of_type_Boolean = true;
  
  public saw(sav paramsav, Context paramContext, View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368814));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378813));
    paramsav = (LinearLayout)paramView.findViewById(2131365999);
    int j = paramsav.getChildCount();
    int k = a(j);
    int i = 0;
    while (i < j)
    {
      paramContext = paramsav.getChildAt(i);
      ((LinearLayout.LayoutParams)paramContext.getLayoutParams()).width = k;
      paramContext.setOnClickListener(this);
      i += 1;
    }
  }
  
  private int a(int paramInt)
  {
    return (int)Math.floor(((int)bdcb.a(true) - this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDimensionPixelSize(2131298564) * 2 - (paramInt - 1) * this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDimensionPixelSize(2131298565)) * 1.0D / paramInt);
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
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(new sax(this, paramFastWebArticleInfo));
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
  
  private void a(String paramString)
  {
    int j = 1;
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b;
    if (localArticleInfo == null) {
      return;
    }
    orz localorz = sdn.a(localArticleInfo);
    for (;;)
    {
      try
      {
        localorz.b("source_from", "2");
        localorz.j();
        localorz.k();
        localorz.l();
        localorz.a(localArticleInfo.mAlgorithmID);
        localorz.b(localArticleInfo.mStrategyId);
        AladdinConfig localAladdinConfig = Aladdin.getConfig(151);
        if (localAladdinConfig != null)
        {
          i = localAladdinConfig.getIntegerFromString("readinjoy_bottom_action_bar_business_id", -1);
          localorz.b("interact_style", localAladdinConfig.getIntegerFromString("readinjoy_bottom_action_bar_style", -1));
          localorz.b("businessID", i);
        }
        if (!ors.n()) {
          break label217;
        }
        i = 1;
        localorz.b("artical_interact_area", i);
        localorz.b("artical_interact_type", ors.h());
        if ((paramString.equals("0X80101DC")) || (paramString.equals("0X80100DB")))
        {
          if (!ors.o()) {
            break label222;
          }
          i = j;
          localorz.b("ad_relative_pos", i);
        }
        sdn.a(localArticleInfo, paramString, localorz.a());
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(sav.a(), 2, "parseR5 has error !", paramString);
      return;
      label217:
      int i = 0;
      continue;
      label222:
      i = 0;
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
    }
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    paramBaseData1 = paramBaseData2.a;
    if (paramBaseData1 != null)
    {
      if (ors.h() != 1) {
        break label288;
      }
      this.jdField_a_of_type_AndroidViewView.findViewById(2131369654).setBackgroundColor(0);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131369623).setBackgroundColor(0);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131369697).setBackgroundColor(0);
      paramBaseData2 = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!paramBaseData1.jdField_a_of_type_Boolean) {
        break label280;
      }
    }
    label280:
    for (int i = 2130842476;; i = 2130841342)
    {
      paramBaseData2.setImageResource(i);
      ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369624)).setImageResource(2130841329);
      ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369698)).setImageResource(2130842268);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369625)).setTextColor(Color.parseColor("#737373"));
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369699)).setTextColor(Color.parseColor("#737373"));
      if (!ors.n())
      {
        paramBaseData1 = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365999);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131365999).setPadding(paramBaseData1.getPaddingLeft(), bdkf.b(10.5F), paramBaseData1.getPaddingRight(), paramBaseData1.getPaddingBottom());
      }
      this.jdField_a_of_type_AndroidViewView.findViewById(2131369654).getLayoutParams().height = -2;
      this.jdField_a_of_type_AndroidViewView.findViewById(2131369623).getLayoutParams().height = -2;
      this.jdField_a_of_type_AndroidViewView.findViewById(2131369697).getLayoutParams().height = -2;
      return;
    }
    label288:
    paramBaseData2 = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramBaseData1.jdField_a_of_type_Boolean)
    {
      i = 2130842475;
      paramBaseData2.setImageResource(i);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(bjxj.a(paramBaseData1.jdField_a_of_type_Int, 99990000L, "9999万+", sav.a));
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
    for (paramBaseData1 = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130848823);; paramBaseData1 = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130848822))
    {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131369654).setBackgroundDrawable(paramBaseData1);
      return;
      i = 2130841341;
      break;
      i = -16777216;
      break label350;
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b == null) {}
    do
    {
      return;
      FastWebArticleInfo localFastWebArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.a;
      if (localFastWebArticleInfo == null)
      {
        aekt.a(sav.a(), "", new IllegalArgumentException());
        return;
      }
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131369623: 
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b);
        return;
      case 2131369654: 
        if (localFastWebArticleInfo.jdField_a_of_type_Boolean)
        {
          localFastWebArticleInfo.jdField_a_of_type_Boolean = false;
          localFastWebArticleInfo.jdField_a_of_type_Int -= 1;
          sdn.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b, "0X8009765", "2");
        }
        for (;;)
        {
          a(localFastWebArticleInfo);
          oxb.a().c();
          owy.a().a(ors.a(), localFastWebArticleInfo.jdField_a_of_type_Boolean, localFastWebArticleInfo);
          return;
          localFastWebArticleInfo.jdField_a_of_type_Boolean = true;
          localFastWebArticleInfo.jdField_a_of_type_Int += 1;
          sdn.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b, "0X8009764", "2");
        }
      }
      paramView = this.jdField_a_of_type_AndroidViewView.getContext();
      a("0X8009A5B");
    } while (!(paramView instanceof FastWebActivity));
    ((FastWebActivity)paramView).a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     saw
 * JD-Core Version:    0.7.0.1
 */