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

public class pjh
{
  public static spk a(BaseArticleInfo paramBaseArticleInfo)
  {
    spk localspk = new spk();
    localspk.jdField_c_of_type_JavaLangString = paramBaseArticleInfo.mVideoVid;
    localspk.jdField_c_of_type_Long = paramBaseArticleInfo.mArticleID;
    localspk.jdField_b_of_type_Int = paramBaseArticleInfo.mVideoDuration;
    localspk.jdField_c_of_type_Int = paramBaseArticleInfo.mVideoJsonWidth;
    localspk.jdField_d_of_type_Int = paramBaseArticleInfo.mVideoJsonHeight;
    if (paramBaseArticleInfo.mVideoCoverUrl == null) {}
    for (Object localObject = null;; localObject = paramBaseArticleInfo.mVideoCoverUrl.getFile())
    {
      localspk.jdField_b_of_type_JavaLangString = ((String)localObject);
      localspk.k = paramBaseArticleInfo.mSubscribeID;
      localspk.jdField_g_of_type_Int = paramBaseArticleInfo.mStrategyId;
      localspk.jdField_g_of_type_Long = paramBaseArticleInfo.mAlgorithmID;
      localObject = new rqa();
      ((rqa)localObject).jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
      ((rqa)localObject).jdField_a_of_type_JavaLangString = paramBaseArticleInfo.innerUniqueID;
      ((rqa)localObject).jdField_b_of_type_JavaLangString = paramBaseArticleInfo.mVideoVid;
      ((rqa)localObject).jdField_a_of_type_Int = paramBaseArticleInfo.busiType;
      localspk.jdField_a_of_type_Rqa = ((rqa)localObject);
      localspk.jdField_d_of_type_JavaLangString = paramBaseArticleInfo.thirdIcon;
      localspk.e = paramBaseArticleInfo.thirdName;
      localspk.jdField_f_of_type_JavaLangString = paramBaseArticleInfo.thirdAction;
      localspk.jdField_f_of_type_Int = paramBaseArticleInfo.busiType;
      localspk.j = paramBaseArticleInfo.innerUniqueID;
      localspk.jdField_b_of_type_Long = paramBaseArticleInfo.mChannelID;
      return localspk;
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
  
  public static void a(LinearLayout paramLinearLayout, ArticleInfo paramArticleInfo, Activity paramActivity, szc paramszc, int paramInt1, int paramInt2, int paramInt3)
  {
    sxh localsxh = new sxh(paramActivity);
    localsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout = ((RoundAngleFrameLayout)paramLinearLayout.findViewById(2131381023));
    localsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramLinearLayout.findViewById(2131368501));
    localsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramLinearLayout.findViewById(2131368381));
    localsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramLinearLayout.findViewById(2131376165));
    localsxh.b = ((TextView)paramLinearLayout.findViewById(2131365915));
    localsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)paramLinearLayout.findViewById(2131380944));
    localsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup = ((ReadInJoyVideoInfoViewGroup)paramLinearLayout.findViewById(2131369770));
    a(localsxh, paramArticleInfo, paramLinearLayout, paramActivity, paramszc, paramInt1, paramInt2, paramInt3);
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, boolean paramBoolean, Activity paramActivity, ArticleInfo paramArticleInfo)
  {
    rjl.a(paramActivity, paramKandianUrlImageView);
    if (ppe.a(paramArticleInfo) == 71) {
      paramURL = paramArticleInfo.getVideoCoverUrlWithSmartCut(false);
    }
    pjr.a(paramKandianUrlImageView, paramURL, paramActivity, paramBoolean);
  }
  
  public static void a(ReadInJoyHeadImageView paramReadInJoyHeadImageView)
  {
    paramReadInJoyHeadImageView.setImageDrawable(bheg.b());
  }
  
  public static void a(sxh paramsxh, ArticleInfo paramArticleInfo, LinearLayout paramLinearLayout, Activity paramActivity, szc paramszc, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramArticleInfo == null) {
      return;
    }
    a(paramsxh, paramArticleInfo);
    spk localspk = paramsxh.jdField_a_of_type_Spk;
    paramsxh.b.setText(pjr.a(localspk.jdField_b_of_type_Int));
    a(paramsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView);
    paramsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setTag(paramArticleInfo);
    paramsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setContentDescription(paramArticleInfo.mSubscribeName);
    Object localObject = paramArticleInfo.mSubscribeName;
    if (paramArticleInfo.mSubscribeName.length() > 18) {
      localObject = paramArticleInfo.mSubscribeName.substring(0, 17) + "…";
    }
    paramsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(0);
    paramsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText((CharSequence)localObject);
    paramsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setContentDescription(paramArticleInfo.mSubscribeName);
    paramsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getPaint().setFakeBoldText(true);
    localObject = new HashSet();
    paramsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup.setArticleInfo(paramArticleInfo, paramszc, paramInt1, (Set)localObject);
    a(paramsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramArticleInfo.getVideoCoverUrlWithSmartCut(false), false, paramActivity, paramArticleInfo);
    paramsxh.b.setVisibility(0);
    paramsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setCustomSize(1.0F, pjr.a(localspk.jdField_c_of_type_Int, localspk.jdField_d_of_type_Int));
    float f1 = DeviceInfoUtil.getAppDisplayWidth(paramActivity);
    float f2 = f1 * pjr.a(localspk.jdField_c_of_type_Int, localspk.jdField_d_of_type_Int);
    paramArticleInfo = paramsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout.getLayoutParams();
    paramArticleInfo.width = ((int)f1);
    paramArticleInfo.height = ((int)f2);
    paramsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout.setLayoutParams(paramArticleInfo);
    a(paramLinearLayout, (int)f1, (int)f2, paramActivity, paramInt2, paramInt3);
  }
  
  public static void a(sxh paramsxh, BaseArticleInfo paramBaseArticleInfo)
  {
    spk localspk = a(paramBaseArticleInfo);
    localspk.jdField_a_of_type_AndroidViewView = paramsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
    localspk.jdField_a_of_type_Int = paramsxh.jdField_a_of_type_Int;
    localspk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    paramsxh.jdField_a_of_type_Spk = localspk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pjh
 * JD-Core Version:    0.7.0.1
 */