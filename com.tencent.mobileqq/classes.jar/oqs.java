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

public class oqs
{
  public static rjk a(BaseArticleInfo paramBaseArticleInfo)
  {
    rjk localrjk = new rjk();
    localrjk.jdField_c_of_type_JavaLangString = paramBaseArticleInfo.mVideoVid;
    localrjk.jdField_c_of_type_Long = paramBaseArticleInfo.mArticleID;
    localrjk.jdField_b_of_type_Int = paramBaseArticleInfo.mVideoDuration;
    localrjk.jdField_c_of_type_Int = paramBaseArticleInfo.mVideoJsonWidth;
    localrjk.jdField_d_of_type_Int = paramBaseArticleInfo.mVideoJsonHeight;
    if (paramBaseArticleInfo.mVideoCoverUrl == null) {}
    for (Object localObject = null;; localObject = paramBaseArticleInfo.mVideoCoverUrl.getFile())
    {
      localrjk.jdField_b_of_type_JavaLangString = ((String)localObject);
      localrjk.k = paramBaseArticleInfo.mSubscribeID;
      localrjk.jdField_g_of_type_Int = paramBaseArticleInfo.mStrategyId;
      localrjk.jdField_g_of_type_Long = paramBaseArticleInfo.mAlgorithmID;
      localObject = new qlq();
      ((qlq)localObject).jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
      ((qlq)localObject).jdField_a_of_type_JavaLangString = paramBaseArticleInfo.innerUniqueID;
      ((qlq)localObject).jdField_b_of_type_JavaLangString = paramBaseArticleInfo.mVideoVid;
      ((qlq)localObject).jdField_a_of_type_Int = paramBaseArticleInfo.busiType;
      localrjk.jdField_a_of_type_Qlq = ((qlq)localObject);
      localrjk.jdField_d_of_type_JavaLangString = paramBaseArticleInfo.thirdIcon;
      localrjk.e = paramBaseArticleInfo.thirdName;
      localrjk.jdField_f_of_type_JavaLangString = paramBaseArticleInfo.thirdAction;
      localrjk.jdField_f_of_type_Int = paramBaseArticleInfo.busiType;
      localrjk.j = paramBaseArticleInfo.innerUniqueID;
      localrjk.jdField_b_of_type_Long = paramBaseArticleInfo.mChannelID;
      return localrjk;
    }
  }
  
  public static void a(LinearLayout paramLinearLayout, int paramInt1, int paramInt2, Activity paramActivity, int paramInt3, int paramInt4)
  {
    paramLinearLayout.setVisibility(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramLinearLayout.getLayoutParams();
    localLayoutParams.leftMargin = paramInt3;
    localLayoutParams.topMargin = paramInt4;
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = (aekt.a(42.0F, paramActivity.getResources()) + paramInt2);
    paramLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  public static void a(LinearLayout paramLinearLayout, ArticleInfo paramArticleInfo, Activity paramActivity, rqi paramrqi, int paramInt1, int paramInt2, int paramInt3)
  {
    pdq localpdq = new pdq(paramActivity);
    localpdq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout = ((RoundAngleFrameLayout)paramLinearLayout.findViewById(2131379755));
    localpdq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramLinearLayout.findViewById(2131367910));
    localpdq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramLinearLayout.findViewById(2131367808));
    localpdq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramLinearLayout.findViewById(2131375233));
    localpdq.b = ((TextView)paramLinearLayout.findViewById(2131365504));
    localpdq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)paramLinearLayout.findViewById(2131379680));
    localpdq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup = ((ReadInJoyVideoInfoViewGroup)paramLinearLayout.findViewById(2131369112));
    a(localpdq, paramArticleInfo, paramLinearLayout, paramActivity, paramrqi, paramInt1, paramInt2, paramInt3);
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, boolean paramBoolean, Activity paramActivity, ArticleInfo paramArticleInfo)
  {
    qfg.a(paramActivity, paramKandianUrlImageView);
    if (rqj.c(paramArticleInfo) == 71) {
      paramURL = paramArticleInfo.getVideoCoverUrlWithSmartCut(false);
    }
    orc.a(paramKandianUrlImageView, paramURL, paramActivity, paramBoolean);
  }
  
  public static void a(ReadInJoyHeadImageView paramReadInJoyHeadImageView)
  {
    paramReadInJoyHeadImageView.setImageDrawable(bdda.b());
  }
  
  public static void a(pdq parampdq, ArticleInfo paramArticleInfo, LinearLayout paramLinearLayout, Activity paramActivity, rqi paramrqi, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramArticleInfo == null) {
      return;
    }
    a(parampdq, paramArticleInfo);
    rjk localrjk = parampdq.jdField_a_of_type_Rjk;
    parampdq.b.setText(orc.a(localrjk.jdField_b_of_type_Int));
    a(parampdq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView);
    parampdq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setTag(paramArticleInfo);
    parampdq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setContentDescription(paramArticleInfo.mSubscribeName);
    Object localObject = paramArticleInfo.mSubscribeName;
    if (paramArticleInfo.mSubscribeName.length() > 18) {
      localObject = paramArticleInfo.mSubscribeName.substring(0, 17) + "…";
    }
    parampdq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(0);
    parampdq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText((CharSequence)localObject);
    parampdq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setContentDescription(paramArticleInfo.mSubscribeName);
    parampdq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getPaint().setFakeBoldText(true);
    localObject = new HashSet();
    parampdq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup.setArticleInfo(paramArticleInfo, paramrqi, paramInt1, (Set)localObject);
    a(parampdq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramArticleInfo.getVideoCoverUrlWithSmartCut(false), false, paramActivity, paramArticleInfo);
    parampdq.b.setVisibility(0);
    parampdq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setCustomSize(1.0F, orc.a(localrjk.jdField_c_of_type_Int, localrjk.jdField_d_of_type_Int));
    float f1 = bdcb.b(paramActivity);
    float f2 = f1 * orc.a(localrjk.jdField_c_of_type_Int, localrjk.jdField_d_of_type_Int);
    paramArticleInfo = parampdq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout.getLayoutParams();
    paramArticleInfo.width = ((int)f1);
    paramArticleInfo.height = ((int)f2);
    parampdq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout.setLayoutParams(paramArticleInfo);
    a(paramLinearLayout, (int)f1, (int)f2, paramActivity, paramInt2, paramInt3);
  }
  
  public static void a(pdq parampdq, BaseArticleInfo paramBaseArticleInfo)
  {
    rjk localrjk = a(paramBaseArticleInfo);
    localrjk.jdField_a_of_type_AndroidViewView = parampdq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
    localrjk.jdField_a_of_type_Int = parampdq.jdField_a_of_type_Int;
    localrjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    parampdq.jdField_a_of_type_Rjk = localrjk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oqs
 * JD-Core Version:    0.7.0.1
 */