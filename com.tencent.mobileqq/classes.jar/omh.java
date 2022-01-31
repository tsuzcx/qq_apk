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

public class omh
{
  public static qtv a(BaseArticleInfo paramBaseArticleInfo)
  {
    qtv localqtv = new qtv();
    localqtv.jdField_c_of_type_JavaLangString = paramBaseArticleInfo.mVideoVid;
    localqtv.jdField_c_of_type_Long = paramBaseArticleInfo.mArticleID;
    localqtv.jdField_b_of_type_Int = paramBaseArticleInfo.mVideoDuration;
    localqtv.jdField_c_of_type_Int = paramBaseArticleInfo.mVideoJsonWidth;
    localqtv.jdField_d_of_type_Int = paramBaseArticleInfo.mVideoJsonHeight;
    if (paramBaseArticleInfo.mVideoCoverUrl == null) {}
    for (Object localObject = null;; localObject = paramBaseArticleInfo.mVideoCoverUrl.getFile())
    {
      localqtv.jdField_b_of_type_JavaLangString = ((String)localObject);
      localqtv.k = paramBaseArticleInfo.mSubscribeID;
      localqtv.jdField_g_of_type_Int = paramBaseArticleInfo.mStrategyId;
      localqtv.jdField_g_of_type_Long = paramBaseArticleInfo.mAlgorithmID;
      localObject = new qbu();
      ((qbu)localObject).jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
      ((qbu)localObject).jdField_a_of_type_JavaLangString = paramBaseArticleInfo.innerUniqueID;
      ((qbu)localObject).jdField_b_of_type_JavaLangString = paramBaseArticleInfo.mVideoVid;
      ((qbu)localObject).jdField_a_of_type_Int = paramBaseArticleInfo.busiType;
      localqtv.jdField_a_of_type_Qbu = ((qbu)localObject);
      localqtv.jdField_d_of_type_JavaLangString = paramBaseArticleInfo.thirdIcon;
      localqtv.e = paramBaseArticleInfo.thirdName;
      localqtv.jdField_f_of_type_JavaLangString = paramBaseArticleInfo.thirdAction;
      localqtv.jdField_f_of_type_Int = paramBaseArticleInfo.busiType;
      localqtv.j = paramBaseArticleInfo.innerUniqueID;
      localqtv.jdField_b_of_type_Long = paramBaseArticleInfo.mChannelID;
      return localqtv;
    }
  }
  
  public static void a(LinearLayout paramLinearLayout, int paramInt1, int paramInt2, Activity paramActivity, int paramInt3, int paramInt4)
  {
    paramLinearLayout.setVisibility(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramLinearLayout.getLayoutParams();
    localLayoutParams.leftMargin = paramInt3;
    localLayoutParams.topMargin = paramInt4;
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = (actj.a(42.0F, paramActivity.getResources()) + paramInt2);
    paramLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  public static void a(LinearLayout paramLinearLayout, ArticleInfo paramArticleInfo, Activity paramActivity, ral paramral, int paramInt1, int paramInt2, int paramInt3)
  {
    oyl localoyl = new oyl(paramActivity);
    localoyl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout = ((RoundAngleFrameLayout)paramLinearLayout.findViewById(2131379077));
    localoyl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramLinearLayout.findViewById(2131367776));
    localoyl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramLinearLayout.findViewById(2131367679));
    localoyl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramLinearLayout.findViewById(2131374770));
    localoyl.b = ((TextView)paramLinearLayout.findViewById(2131365420));
    localoyl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)paramLinearLayout.findViewById(2131379015));
    localoyl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup = ((ReadInJoyVideoInfoViewGroup)paramLinearLayout.findViewById(2131368880));
    a(localoyl, paramArticleInfo, paramLinearLayout, paramActivity, paramral, paramInt1, paramInt2, paramInt3);
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, boolean paramBoolean, Activity paramActivity, ArticleInfo paramArticleInfo)
  {
    pym.a(paramActivity, paramKandianUrlImageView);
    if (ram.c(paramArticleInfo) == 71) {
      paramURL = paramArticleInfo.getVideoCoverUrlWithSmartCut(false);
    }
    omr.a(paramKandianUrlImageView, paramURL, paramActivity, paramBoolean);
  }
  
  public static void a(ReadInJoyHeadImageView paramReadInJoyHeadImageView)
  {
    paramReadInJoyHeadImageView.setImageDrawable(bbef.b());
  }
  
  public static void a(oyl paramoyl, ArticleInfo paramArticleInfo, LinearLayout paramLinearLayout, Activity paramActivity, ral paramral, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramArticleInfo == null) {
      return;
    }
    a(paramoyl, paramArticleInfo);
    qtv localqtv = paramoyl.jdField_a_of_type_Qtv;
    paramoyl.b.setText(omr.a(localqtv.jdField_b_of_type_Int));
    a(paramoyl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView);
    paramoyl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setTag(paramArticleInfo);
    paramoyl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setContentDescription(paramArticleInfo.mSubscribeName);
    Object localObject = paramArticleInfo.mSubscribeName;
    if (paramArticleInfo.mSubscribeName.length() > 18) {
      localObject = paramArticleInfo.mSubscribeName.substring(0, 17) + "…";
    }
    paramoyl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(0);
    paramoyl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText((CharSequence)localObject);
    paramoyl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setContentDescription(paramArticleInfo.mSubscribeName);
    paramoyl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getPaint().setFakeBoldText(true);
    localObject = new HashSet();
    paramoyl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup.setArticleInfo(paramArticleInfo, paramral, paramInt1, (Set)localObject);
    a(paramoyl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramArticleInfo.getVideoCoverUrlWithSmartCut(false), false, paramActivity, paramArticleInfo);
    paramoyl.b.setVisibility(0);
    paramoyl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setCustomSize(1.0F, omr.a(localqtv.jdField_c_of_type_Int, localqtv.jdField_d_of_type_Int));
    float f1 = bbdh.a(paramActivity);
    float f2 = f1 * omr.a(localqtv.jdField_c_of_type_Int, localqtv.jdField_d_of_type_Int);
    paramArticleInfo = paramoyl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout.getLayoutParams();
    paramArticleInfo.width = ((int)f1);
    paramArticleInfo.height = ((int)f2);
    paramoyl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout.setLayoutParams(paramArticleInfo);
    a(paramLinearLayout, (int)f1, (int)f2, paramActivity, paramInt2, paramInt3);
  }
  
  public static void a(oyl paramoyl, BaseArticleInfo paramBaseArticleInfo)
  {
    qtv localqtv = a(paramBaseArticleInfo);
    localqtv.jdField_a_of_type_AndroidViewView = paramoyl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
    localqtv.jdField_a_of_type_Int = paramoyl.jdField_a_of_type_Int;
    localqtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    paramoyl.jdField_a_of_type_Qtv = localqtv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     omh
 * JD-Core Version:    0.7.0.1
 */