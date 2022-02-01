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
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class oys
{
  public static rwc a(BaseArticleInfo paramBaseArticleInfo)
  {
    rwc localrwc = new rwc();
    localrwc.jdField_c_of_type_JavaLangString = paramBaseArticleInfo.mVideoVid;
    localrwc.jdField_c_of_type_Long = paramBaseArticleInfo.mArticleID;
    localrwc.jdField_b_of_type_Int = paramBaseArticleInfo.mVideoDuration;
    localrwc.jdField_c_of_type_Int = paramBaseArticleInfo.mVideoJsonWidth;
    localrwc.jdField_d_of_type_Int = paramBaseArticleInfo.mVideoJsonHeight;
    if (paramBaseArticleInfo.mVideoCoverUrl == null) {}
    for (Object localObject = null;; localObject = paramBaseArticleInfo.mVideoCoverUrl.getFile())
    {
      localrwc.jdField_b_of_type_JavaLangString = ((String)localObject);
      localrwc.k = paramBaseArticleInfo.mSubscribeID;
      localrwc.jdField_g_of_type_Int = paramBaseArticleInfo.mStrategyId;
      localrwc.jdField_g_of_type_Long = paramBaseArticleInfo.mAlgorithmID;
      localObject = new qwv();
      ((qwv)localObject).jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
      ((qwv)localObject).jdField_a_of_type_JavaLangString = paramBaseArticleInfo.innerUniqueID;
      ((qwv)localObject).jdField_b_of_type_JavaLangString = paramBaseArticleInfo.mVideoVid;
      ((qwv)localObject).jdField_a_of_type_Int = paramBaseArticleInfo.busiType;
      localrwc.jdField_a_of_type_Qwv = ((qwv)localObject);
      localrwc.jdField_d_of_type_JavaLangString = paramBaseArticleInfo.thirdIcon;
      localrwc.e = paramBaseArticleInfo.thirdName;
      localrwc.jdField_f_of_type_JavaLangString = paramBaseArticleInfo.thirdAction;
      localrwc.jdField_f_of_type_Int = paramBaseArticleInfo.busiType;
      localrwc.j = paramBaseArticleInfo.innerUniqueID;
      localrwc.jdField_b_of_type_Long = paramBaseArticleInfo.mChannelID;
      return localrwc;
    }
  }
  
  public static void a(LinearLayout paramLinearLayout, int paramInt1, int paramInt2, Activity paramActivity, int paramInt3, int paramInt4)
  {
    paramLinearLayout.setVisibility(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramLinearLayout.getLayoutParams();
    localLayoutParams.leftMargin = paramInt3;
    localLayoutParams.topMargin = paramInt4;
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = (agej.a(42.0F, paramActivity.getResources()) + paramInt2);
    paramLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  public static void a(LinearLayout paramLinearLayout, ArticleInfo paramArticleInfo, Activity paramActivity, sek paramsek, int paramInt1, int paramInt2, int paramInt3)
  {
    pmz localpmz = new pmz(paramActivity);
    localpmz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout = ((RoundAngleFrameLayout)paramLinearLayout.findViewById(2131380948));
    localpmz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramLinearLayout.findViewById(2131368320));
    localpmz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramLinearLayout.findViewById(2131368212));
    localpmz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramLinearLayout.findViewById(2131376154));
    localpmz.b = ((TextView)paramLinearLayout.findViewById(2131365785));
    localpmz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)paramLinearLayout.findViewById(2131380872));
    localpmz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup = ((ReadInJoyVideoInfoViewGroup)paramLinearLayout.findViewById(2131369611));
    a(localpmz, paramArticleInfo, paramLinearLayout, paramActivity, paramsek, paramInt1, paramInt2, paramInt3);
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, boolean paramBoolean, Activity paramActivity, ArticleInfo paramArticleInfo)
  {
    qrc.a(paramActivity, paramKandianUrlImageView);
    if (sel.c(paramArticleInfo) == 71) {
      paramURL = paramArticleInfo.getVideoCoverUrlWithSmartCut(false);
    }
    ozc.a(paramKandianUrlImageView, paramURL, paramActivity, paramBoolean);
  }
  
  public static void a(ReadInJoyHeadImageView paramReadInJoyHeadImageView)
  {
    paramReadInJoyHeadImageView.setImageDrawable(bhmq.b());
  }
  
  public static void a(pmz parampmz, ArticleInfo paramArticleInfo, LinearLayout paramLinearLayout, Activity paramActivity, sek paramsek, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramArticleInfo == null) {
      return;
    }
    a(parampmz, paramArticleInfo);
    rwc localrwc = parampmz.jdField_a_of_type_Rwc;
    parampmz.b.setText(ozc.a(localrwc.jdField_b_of_type_Int));
    a(parampmz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView);
    parampmz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setTag(paramArticleInfo);
    parampmz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setContentDescription(paramArticleInfo.mSubscribeName);
    Object localObject = paramArticleInfo.mSubscribeName;
    if (paramArticleInfo.mSubscribeName.length() > 18) {
      localObject = paramArticleInfo.mSubscribeName.substring(0, 17) + "…";
    }
    parampmz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(0);
    parampmz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText((CharSequence)localObject);
    parampmz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setContentDescription(paramArticleInfo.mSubscribeName);
    parampmz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getPaint().setFakeBoldText(true);
    localObject = new HashSet();
    parampmz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup.setArticleInfo(paramArticleInfo, paramsek, paramInt1, (Set)localObject);
    a(parampmz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramArticleInfo.getVideoCoverUrlWithSmartCut(false), false, paramActivity, paramArticleInfo);
    parampmz.b.setVisibility(0);
    parampmz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setCustomSize(1.0F, ozc.a(localrwc.jdField_c_of_type_Int, localrwc.jdField_d_of_type_Int));
    float f1 = bhlo.b(paramActivity);
    float f2 = f1 * ozc.a(localrwc.jdField_c_of_type_Int, localrwc.jdField_d_of_type_Int);
    paramArticleInfo = parampmz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout.getLayoutParams();
    paramArticleInfo.width = ((int)f1);
    paramArticleInfo.height = ((int)f2);
    parampmz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout.setLayoutParams(paramArticleInfo);
    a(paramLinearLayout, (int)f1, (int)f2, paramActivity, paramInt2, paramInt3);
  }
  
  public static void a(pmz parampmz, BaseArticleInfo paramBaseArticleInfo)
  {
    rwc localrwc = a(paramBaseArticleInfo);
    localrwc.jdField_a_of_type_AndroidViewView = parampmz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
    localrwc.jdField_a_of_type_Int = parampmz.jdField_a_of_type_Int;
    localrwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    parampmz.jdField_a_of_type_Rwc = localrwc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oys
 * JD-Core Version:    0.7.0.1
 */