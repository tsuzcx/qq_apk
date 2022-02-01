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

public class pga
{
  public static sey a(BaseArticleInfo paramBaseArticleInfo)
  {
    sey localsey = new sey();
    localsey.jdField_c_of_type_JavaLangString = paramBaseArticleInfo.mVideoVid;
    localsey.jdField_c_of_type_Long = paramBaseArticleInfo.mArticleID;
    localsey.jdField_b_of_type_Int = paramBaseArticleInfo.mVideoDuration;
    localsey.jdField_c_of_type_Int = paramBaseArticleInfo.mVideoJsonWidth;
    localsey.jdField_d_of_type_Int = paramBaseArticleInfo.mVideoJsonHeight;
    if (paramBaseArticleInfo.mVideoCoverUrl == null) {}
    for (Object localObject = null;; localObject = paramBaseArticleInfo.mVideoCoverUrl.getFile())
    {
      localsey.jdField_b_of_type_JavaLangString = ((String)localObject);
      localsey.k = paramBaseArticleInfo.mSubscribeID;
      localsey.jdField_g_of_type_Int = paramBaseArticleInfo.mStrategyId;
      localsey.jdField_g_of_type_Long = paramBaseArticleInfo.mAlgorithmID;
      localObject = new rgc();
      ((rgc)localObject).jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
      ((rgc)localObject).jdField_a_of_type_JavaLangString = paramBaseArticleInfo.innerUniqueID;
      ((rgc)localObject).jdField_b_of_type_JavaLangString = paramBaseArticleInfo.mVideoVid;
      ((rgc)localObject).jdField_a_of_type_Int = paramBaseArticleInfo.busiType;
      localsey.jdField_a_of_type_Rgc = ((rgc)localObject);
      localsey.jdField_d_of_type_JavaLangString = paramBaseArticleInfo.thirdIcon;
      localsey.e = paramBaseArticleInfo.thirdName;
      localsey.jdField_f_of_type_JavaLangString = paramBaseArticleInfo.thirdAction;
      localsey.jdField_f_of_type_Int = paramBaseArticleInfo.busiType;
      localsey.j = paramBaseArticleInfo.innerUniqueID;
      localsey.jdField_b_of_type_Long = paramBaseArticleInfo.mChannelID;
      return localsey;
    }
  }
  
  public static void a(LinearLayout paramLinearLayout, int paramInt1, int paramInt2, Activity paramActivity, int paramInt3, int paramInt4)
  {
    paramLinearLayout.setVisibility(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramLinearLayout.getLayoutParams();
    localLayoutParams.leftMargin = paramInt3;
    localLayoutParams.topMargin = paramInt4;
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = (afur.a(42.0F, paramActivity.getResources()) + paramInt2);
    paramLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  public static void a(LinearLayout paramLinearLayout, ArticleInfo paramArticleInfo, Activity paramActivity, sng paramsng, int paramInt1, int paramInt2, int paramInt3)
  {
    pum localpum = new pum(paramActivity);
    localpum.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout = ((RoundAngleFrameLayout)paramLinearLayout.findViewById(2131380771));
    localpum.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramLinearLayout.findViewById(2131368246));
    localpum.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramLinearLayout.findViewById(2131368138));
    localpum.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramLinearLayout.findViewById(2131376014));
    localpum.b = ((TextView)paramLinearLayout.findViewById(2131365742));
    localpum.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)paramLinearLayout.findViewById(2131380694));
    localpum.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup = ((ReadInJoyVideoInfoViewGroup)paramLinearLayout.findViewById(2131369518));
    a(localpum, paramArticleInfo, paramLinearLayout, paramActivity, paramsng, paramInt1, paramInt2, paramInt3);
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, boolean paramBoolean, Activity paramActivity, ArticleInfo paramArticleInfo)
  {
    qyo.a(paramActivity, paramKandianUrlImageView);
    if (snh.c(paramArticleInfo) == 71) {
      paramURL = paramArticleInfo.getVideoCoverUrlWithSmartCut(false);
    }
    pgk.a(paramKandianUrlImageView, paramURL, paramActivity, paramBoolean);
  }
  
  public static void a(ReadInJoyHeadImageView paramReadInJoyHeadImageView)
  {
    paramReadInJoyHeadImageView.setImageDrawable(bgmo.b());
  }
  
  public static void a(pum parampum, ArticleInfo paramArticleInfo, LinearLayout paramLinearLayout, Activity paramActivity, sng paramsng, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramArticleInfo == null) {
      return;
    }
    a(parampum, paramArticleInfo);
    sey localsey = parampum.jdField_a_of_type_Sey;
    parampum.b.setText(pgk.a(localsey.jdField_b_of_type_Int));
    a(parampum.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView);
    parampum.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setTag(paramArticleInfo);
    parampum.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setContentDescription(paramArticleInfo.mSubscribeName);
    Object localObject = paramArticleInfo.mSubscribeName;
    if (paramArticleInfo.mSubscribeName.length() > 18) {
      localObject = paramArticleInfo.mSubscribeName.substring(0, 17) + "…";
    }
    parampum.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(0);
    parampum.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText((CharSequence)localObject);
    parampum.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setContentDescription(paramArticleInfo.mSubscribeName);
    parampum.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getPaint().setFakeBoldText(true);
    localObject = new HashSet();
    parampum.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup.setArticleInfo(paramArticleInfo, paramsng, paramInt1, (Set)localObject);
    a(parampum.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramArticleInfo.getVideoCoverUrlWithSmartCut(false), false, paramActivity, paramArticleInfo);
    parampum.b.setVisibility(0);
    parampum.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setCustomSize(1.0F, pgk.a(localsey.jdField_c_of_type_Int, localsey.jdField_d_of_type_Int));
    float f1 = bgln.b(paramActivity);
    float f2 = f1 * pgk.a(localsey.jdField_c_of_type_Int, localsey.jdField_d_of_type_Int);
    paramArticleInfo = parampum.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout.getLayoutParams();
    paramArticleInfo.width = ((int)f1);
    paramArticleInfo.height = ((int)f2);
    parampum.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout.setLayoutParams(paramArticleInfo);
    a(paramLinearLayout, (int)f1, (int)f2, paramActivity, paramInt2, paramInt3);
  }
  
  public static void a(pum parampum, BaseArticleInfo paramBaseArticleInfo)
  {
    sey localsey = a(paramBaseArticleInfo);
    localsey.jdField_a_of_type_AndroidViewView = parampum.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
    localsey.jdField_a_of_type_Int = parampum.jdField_a_of_type_Int;
    localsey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    parampum.jdField_a_of_type_Sey = localsey;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pga
 * JD-Core Version:    0.7.0.1
 */