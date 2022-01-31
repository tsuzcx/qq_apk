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

public class omk
{
  public static qty a(BaseArticleInfo paramBaseArticleInfo)
  {
    qty localqty = new qty();
    localqty.jdField_c_of_type_JavaLangString = paramBaseArticleInfo.mVideoVid;
    localqty.jdField_c_of_type_Long = paramBaseArticleInfo.mArticleID;
    localqty.jdField_b_of_type_Int = paramBaseArticleInfo.mVideoDuration;
    localqty.jdField_c_of_type_Int = paramBaseArticleInfo.mVideoJsonWidth;
    localqty.jdField_d_of_type_Int = paramBaseArticleInfo.mVideoJsonHeight;
    if (paramBaseArticleInfo.mVideoCoverUrl == null) {}
    for (Object localObject = null;; localObject = paramBaseArticleInfo.mVideoCoverUrl.getFile())
    {
      localqty.jdField_b_of_type_JavaLangString = ((String)localObject);
      localqty.k = paramBaseArticleInfo.mSubscribeID;
      localqty.jdField_g_of_type_Int = paramBaseArticleInfo.mStrategyId;
      localqty.jdField_g_of_type_Long = paramBaseArticleInfo.mAlgorithmID;
      localObject = new qbx();
      ((qbx)localObject).jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
      ((qbx)localObject).jdField_a_of_type_JavaLangString = paramBaseArticleInfo.innerUniqueID;
      ((qbx)localObject).jdField_b_of_type_JavaLangString = paramBaseArticleInfo.mVideoVid;
      ((qbx)localObject).jdField_a_of_type_Int = paramBaseArticleInfo.busiType;
      localqty.jdField_a_of_type_Qbx = ((qbx)localObject);
      localqty.jdField_d_of_type_JavaLangString = paramBaseArticleInfo.thirdIcon;
      localqty.e = paramBaseArticleInfo.thirdName;
      localqty.jdField_f_of_type_JavaLangString = paramBaseArticleInfo.thirdAction;
      localqty.jdField_f_of_type_Int = paramBaseArticleInfo.busiType;
      localqty.j = paramBaseArticleInfo.innerUniqueID;
      localqty.jdField_b_of_type_Long = paramBaseArticleInfo.mChannelID;
      return localqty;
    }
  }
  
  public static void a(LinearLayout paramLinearLayout, int paramInt1, int paramInt2, Activity paramActivity, int paramInt3, int paramInt4)
  {
    paramLinearLayout.setVisibility(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramLinearLayout.getLayoutParams();
    localLayoutParams.leftMargin = paramInt3;
    localLayoutParams.topMargin = paramInt4;
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = (actn.a(42.0F, paramActivity.getResources()) + paramInt2);
    paramLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  public static void a(LinearLayout paramLinearLayout, ArticleInfo paramArticleInfo, Activity paramActivity, rao paramrao, int paramInt1, int paramInt2, int paramInt3)
  {
    oyo localoyo = new oyo(paramActivity);
    localoyo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout = ((RoundAngleFrameLayout)paramLinearLayout.findViewById(2131379072));
    localoyo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramLinearLayout.findViewById(2131367776));
    localoyo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramLinearLayout.findViewById(2131367679));
    localoyo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramLinearLayout.findViewById(2131374768));
    localoyo.b = ((TextView)paramLinearLayout.findViewById(2131365421));
    localoyo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)paramLinearLayout.findViewById(2131379010));
    localoyo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup = ((ReadInJoyVideoInfoViewGroup)paramLinearLayout.findViewById(2131368880));
    a(localoyo, paramArticleInfo, paramLinearLayout, paramActivity, paramrao, paramInt1, paramInt2, paramInt3);
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, boolean paramBoolean, Activity paramActivity, ArticleInfo paramArticleInfo)
  {
    pyp.a(paramActivity, paramKandianUrlImageView);
    if (rap.c(paramArticleInfo) == 71) {
      paramURL = paramArticleInfo.getVideoCoverUrlWithSmartCut(false);
    }
    omu.a(paramKandianUrlImageView, paramURL, paramActivity, paramBoolean);
  }
  
  public static void a(ReadInJoyHeadImageView paramReadInJoyHeadImageView)
  {
    paramReadInJoyHeadImageView.setImageDrawable(bbdr.b());
  }
  
  public static void a(oyo paramoyo, ArticleInfo paramArticleInfo, LinearLayout paramLinearLayout, Activity paramActivity, rao paramrao, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramArticleInfo == null) {
      return;
    }
    a(paramoyo, paramArticleInfo);
    qty localqty = paramoyo.jdField_a_of_type_Qty;
    paramoyo.b.setText(omu.a(localqty.jdField_b_of_type_Int));
    a(paramoyo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView);
    paramoyo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setTag(paramArticleInfo);
    paramoyo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setContentDescription(paramArticleInfo.mSubscribeName);
    Object localObject = paramArticleInfo.mSubscribeName;
    if (paramArticleInfo.mSubscribeName.length() > 18) {
      localObject = paramArticleInfo.mSubscribeName.substring(0, 17) + "…";
    }
    paramoyo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(0);
    paramoyo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText((CharSequence)localObject);
    paramoyo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setContentDescription(paramArticleInfo.mSubscribeName);
    paramoyo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getPaint().setFakeBoldText(true);
    localObject = new HashSet();
    paramoyo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup.setArticleInfo(paramArticleInfo, paramrao, paramInt1, (Set)localObject);
    a(paramoyo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramArticleInfo.getVideoCoverUrlWithSmartCut(false), false, paramActivity, paramArticleInfo);
    paramoyo.b.setVisibility(0);
    paramoyo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setCustomSize(1.0F, omu.a(localqty.jdField_c_of_type_Int, localqty.jdField_d_of_type_Int));
    float f1 = bbct.a(paramActivity);
    float f2 = f1 * omu.a(localqty.jdField_c_of_type_Int, localqty.jdField_d_of_type_Int);
    paramArticleInfo = paramoyo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout.getLayoutParams();
    paramArticleInfo.width = ((int)f1);
    paramArticleInfo.height = ((int)f2);
    paramoyo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout.setLayoutParams(paramArticleInfo);
    a(paramLinearLayout, (int)f1, (int)f2, paramActivity, paramInt2, paramInt3);
  }
  
  public static void a(oyo paramoyo, BaseArticleInfo paramBaseArticleInfo)
  {
    qty localqty = a(paramBaseArticleInfo);
    localqty.jdField_a_of_type_AndroidViewView = paramoyo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
    localqty.jdField_a_of_type_Int = paramoyo.jdField_a_of_type_Int;
    localqty.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    paramoyo.jdField_a_of_type_Qty = localqty;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     omk
 * JD-Core Version:    0.7.0.1
 */