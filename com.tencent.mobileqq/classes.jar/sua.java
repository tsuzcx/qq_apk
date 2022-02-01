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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;

public class sua
  extends stg
  implements View.OnClickListener
{
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean jdField_a_of_type_Boolean = true;
  
  public sua(stz paramstz, Context paramContext, View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369284));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379697));
    paramstz = (LinearLayout)paramView.findViewById(2131366330);
    int j = paramstz.getChildCount();
    int k = a(j);
    int i = 0;
    while (i < j)
    {
      paramContext = paramstz.getChildAt(i);
      ((LinearLayout.LayoutParams)paramContext.getLayoutParams()).width = k;
      paramContext.setOnClickListener(this);
      i += 1;
    }
  }
  
  private int a(int paramInt)
  {
    return (int)Math.floor(((int)DeviceInfoUtil.getPortraitWidth(true) - this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDimensionPixelSize(2131298724) * 2 - (paramInt - 1) * this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDimensionPixelSize(2131298725)) * 1.0D / paramInt);
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
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(new sub(this, paramFastWebArticleInfo));
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
  
  private void a(String paramString)
  {
    int j = 1;
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b;
    if (localArticleInfo == null) {
      return;
    }
    pbg localpbg = swy.a(localArticleInfo);
    for (;;)
    {
      try
      {
        localpbg.b("source_from", "2");
        localpbg.j();
        localpbg.k();
        localpbg.l();
        localpbg.a(localArticleInfo.mAlgorithmID);
        localpbg.b(localArticleInfo.mStrategyId);
        AladdinConfig localAladdinConfig = Aladdin.getConfig(151);
        if (localAladdinConfig != null)
        {
          i = localAladdinConfig.getIntegerFromString("readinjoy_bottom_action_bar_business_id", -1);
          localpbg.b("interact_style", localAladdinConfig.getIntegerFromString("readinjoy_bottom_action_bar_style", -1));
          localpbg.b("businessID", i);
        }
        if (!pay.p()) {
          break label217;
        }
        i = 1;
        localpbg.b("artical_interact_area", i);
        localpbg.b("artical_interact_type", pay.h());
        if ((paramString.equals("0X80101DC")) || (paramString.equals("0X80100DB")))
        {
          if (!pay.q()) {
            break label222;
          }
          i = j;
          localpbg.b("ad_relative_pos", i);
        }
        swy.a(localArticleInfo, paramString, localpbg.a());
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(stz.a(), 2, "parseR5 has error !", paramString);
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
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    paramBaseData1 = paramBaseData2.a;
    if (paramBaseData1 != null)
    {
      if (pay.h() != 1) {
        break label288;
      }
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370173).setBackgroundColor(0);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370152).setBackgroundColor(0);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370217).setBackgroundColor(0);
      paramBaseData2 = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!paramBaseData1.jdField_a_of_type_Boolean) {
        break label280;
      }
    }
    label280:
    for (int i = 2130842883;; i = 2130841693)
    {
      paramBaseData2.setImageResource(i);
      ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370153)).setImageResource(2130841680);
      ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370218)).setImageResource(2130842649);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370154)).setTextColor(Color.parseColor("#737373"));
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370219)).setTextColor(Color.parseColor("#737373"));
      if (!pay.p())
      {
        paramBaseData1 = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366330);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131366330).setPadding(paramBaseData1.getPaddingLeft(), ViewUtils.dpToPx(10.5F), paramBaseData1.getPaddingRight(), paramBaseData1.getPaddingBottom());
      }
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370173).getLayoutParams().height = -2;
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370152).getLayoutParams().height = -2;
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370217).getLayoutParams().height = -2;
      return;
    }
    label288:
    paramBaseData2 = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramBaseData1.jdField_a_of_type_Boolean)
    {
      i = 2130842882;
      paramBaseData2.setImageResource(i);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(bkwm.a(paramBaseData1.jdField_a_of_type_Int, 99990000L, "9999万+", stz.a));
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
    for (paramBaseData1 = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130849313);; paramBaseData1 = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130849312))
    {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370173).setBackgroundDrawable(paramBaseData1);
      return;
      i = 2130841692;
      break;
      i = -16777216;
      break label350;
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
        AIOUtils.catchedExceptionInReleaseV2(stz.a(), "", new IllegalArgumentException());
      } else {
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131370152: 
          a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b);
          break;
        case 2131370173: 
          if (((FastWebArticleInfo)localObject).jdField_a_of_type_Boolean)
          {
            ((FastWebArticleInfo)localObject).jdField_a_of_type_Boolean = false;
            ((FastWebArticleInfo)localObject).jdField_a_of_type_Int -= 1;
            swy.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b, "0X8009765", "2");
          }
          for (;;)
          {
            a((FastWebArticleInfo)localObject);
            pkp.a().c();
            pkm.a().a(pay.a(), ((FastWebArticleInfo)localObject).jdField_a_of_type_Boolean, (FastWebArticleInfo)localObject);
            break;
            ((FastWebArticleInfo)localObject).jdField_a_of_type_Boolean = true;
            ((FastWebArticleInfo)localObject).jdField_a_of_type_Int += 1;
            swy.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b, "0X8009764", "2");
          }
        case 2131370217: 
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
 * Qualified Name:     sua
 * JD-Core Version:    0.7.0.1
 */