import android.app.Activity;
import android.text.TextPaint;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyVideoInfoViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.VideoViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.widget.RoundAngleFrameLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class ozy
{
  public static sdg a(BaseArticleInfo paramBaseArticleInfo)
  {
    sdg localsdg = new sdg();
    localsdg.jdField_c_of_type_JavaLangString = paramBaseArticleInfo.mVideoVid;
    localsdg.jdField_c_of_type_Long = paramBaseArticleInfo.mArticleID;
    localsdg.jdField_b_of_type_Int = paramBaseArticleInfo.mVideoDuration;
    localsdg.jdField_c_of_type_Int = paramBaseArticleInfo.mVideoJsonWidth;
    localsdg.jdField_d_of_type_Int = paramBaseArticleInfo.mVideoJsonHeight;
    if (paramBaseArticleInfo.mVideoCoverUrl == null) {}
    for (Object localObject = null;; localObject = paramBaseArticleInfo.mVideoCoverUrl.getFile())
    {
      localsdg.jdField_b_of_type_JavaLangString = ((String)localObject);
      localsdg.k = paramBaseArticleInfo.mSubscribeID;
      localsdg.jdField_g_of_type_Int = paramBaseArticleInfo.mStrategyId;
      localsdg.jdField_g_of_type_Long = paramBaseArticleInfo.mAlgorithmID;
      localObject = new rdt();
      ((rdt)localObject).jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
      ((rdt)localObject).jdField_a_of_type_JavaLangString = paramBaseArticleInfo.innerUniqueID;
      ((rdt)localObject).jdField_b_of_type_JavaLangString = paramBaseArticleInfo.mVideoVid;
      ((rdt)localObject).jdField_a_of_type_Int = paramBaseArticleInfo.busiType;
      localsdg.jdField_a_of_type_Rdt = ((rdt)localObject);
      localsdg.jdField_d_of_type_JavaLangString = paramBaseArticleInfo.thirdIcon;
      localsdg.e = paramBaseArticleInfo.thirdName;
      localsdg.jdField_f_of_type_JavaLangString = paramBaseArticleInfo.thirdAction;
      localsdg.jdField_f_of_type_Int = paramBaseArticleInfo.busiType;
      localsdg.j = paramBaseArticleInfo.innerUniqueID;
      localsdg.jdField_b_of_type_Long = paramBaseArticleInfo.mChannelID;
      return localsdg;
    }
  }
  
  public static void a(LinearLayout paramLinearLayout, int paramInt1, int paramInt2, Activity paramActivity, int paramInt3, int paramInt4)
  {
    paramLinearLayout.setVisibility(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramLinearLayout.getLayoutParams();
    localLayoutParams.leftMargin = paramInt3;
    localLayoutParams.topMargin = paramInt4;
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = (AIOUtils.dp2px(42.0F, paramActivity.getResources()) + paramInt2);
    paramLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  public static void a(LinearLayout paramLinearLayout, ArticleInfo paramArticleInfo, Activity paramActivity, sls paramsls, int paramInt1, int paramInt2, int paramInt3)
  {
    sjy localsjy = new sjy(paramActivity);
    localsjy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout = ((RoundAngleFrameLayout)paramLinearLayout.findViewById(2131380674));
    localsjy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramLinearLayout.findViewById(2131368344));
    localsjy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramLinearLayout.findViewById(2131368236));
    localsjy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramLinearLayout.findViewById(2131375918));
    localsjy.b = ((TextView)paramLinearLayout.findViewById(2131365817));
    localsjy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)paramLinearLayout.findViewById(2131380598));
    localsjy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup = ((ReadInJoyVideoInfoViewGroup)paramLinearLayout.findViewById(2131369601));
    a(localsjy, paramArticleInfo, paramLinearLayout, paramActivity, paramsls, paramInt1, paramInt2, paramInt3);
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, boolean paramBoolean, Activity paramActivity, ArticleInfo paramArticleInfo)
  {
    qxf.a(paramActivity, paramKandianUrlImageView);
    if (pgb.a(paramArticleInfo) == 71) {
      paramURL = paramArticleInfo.getVideoCoverUrlWithSmartCut(false);
    }
    pai.a(paramKandianUrlImageView, paramURL, paramActivity, paramBoolean);
  }
  
  public static void a(ReadInJoyHeadImageView paramReadInJoyHeadImageView)
  {
    paramReadInJoyHeadImageView.setImageDrawable(bfvo.b());
  }
  
  public static void a(sjy paramsjy, ArticleInfo paramArticleInfo, LinearLayout paramLinearLayout, Activity paramActivity, sls paramsls, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramArticleInfo == null) {
      return;
    }
    a(paramsjy, paramArticleInfo);
    sdg localsdg = paramsjy.jdField_a_of_type_Sdg;
    paramsjy.b.setText(pai.a(localsdg.jdField_b_of_type_Int));
    a(paramsjy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView);
    paramsjy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setTag(paramArticleInfo);
    paramsjy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setContentDescription(paramArticleInfo.mSubscribeName);
    Object localObject = paramArticleInfo.mSubscribeName;
    if (paramArticleInfo.mSubscribeName.length() > 18) {
      localObject = paramArticleInfo.mSubscribeName.substring(0, 17) + "…";
    }
    paramsjy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(0);
    paramsjy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText((CharSequence)localObject);
    paramsjy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setContentDescription(paramArticleInfo.mSubscribeName);
    paramsjy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getPaint().setFakeBoldText(true);
    localObject = new HashSet();
    paramsjy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup.setArticleInfo(paramArticleInfo, paramsls, paramInt1, (Set)localObject);
    a(paramsjy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramArticleInfo.getVideoCoverUrlWithSmartCut(false), false, paramActivity, paramArticleInfo);
    paramsjy.b.setVisibility(0);
    paramsjy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setCustomSize(1.0F, pai.a(localsdg.jdField_c_of_type_Int, localsdg.jdField_d_of_type_Int));
    float f1 = DeviceInfoUtil.getAppDisplayWidth(paramActivity);
    float f2 = f1 * pai.a(localsdg.jdField_c_of_type_Int, localsdg.jdField_d_of_type_Int);
    paramArticleInfo = paramsjy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout.getLayoutParams();
    paramArticleInfo.width = ((int)f1);
    paramArticleInfo.height = ((int)f2);
    paramsjy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout.setLayoutParams(paramArticleInfo);
    a(paramLinearLayout, (int)f1, (int)f2, paramActivity, paramInt2, paramInt3);
  }
  
  public static void a(sjy paramsjy, BaseArticleInfo paramBaseArticleInfo)
  {
    sdg localsdg = a(paramBaseArticleInfo);
    localsdg.jdField_a_of_type_AndroidViewView = paramsjy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
    localsdg.jdField_a_of_type_Int = paramsjy.jdField_a_of_type_Int;
    localsdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    paramsjy.jdField_a_of_type_Sdg = localsdg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ozy
 * JD-Core Version:    0.7.0.1
 */