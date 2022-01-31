import android.app.Activity;
import android.text.TextPaint;
import android.widget.FrameLayout;
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
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class oaz
{
  public static qht a(BaseArticleInfo paramBaseArticleInfo)
  {
    qht localqht = new qht();
    localqht.jdField_c_of_type_JavaLangString = paramBaseArticleInfo.mVideoVid;
    localqht.jdField_c_of_type_Long = paramBaseArticleInfo.mArticleID;
    localqht.jdField_b_of_type_Int = paramBaseArticleInfo.mVideoDuration;
    localqht.jdField_c_of_type_Int = paramBaseArticleInfo.mVideoJsonWidth;
    localqht.jdField_d_of_type_Int = paramBaseArticleInfo.mVideoJsonHeight;
    if (paramBaseArticleInfo.mVideoCoverUrl == null) {}
    for (Object localObject = null;; localObject = paramBaseArticleInfo.mVideoCoverUrl.getFile())
    {
      localqht.jdField_b_of_type_JavaLangString = ((String)localObject);
      localqht.k = paramBaseArticleInfo.mSubscribeID;
      localqht.jdField_g_of_type_Int = paramBaseArticleInfo.mStrategyId;
      localqht.jdField_g_of_type_Long = paramBaseArticleInfo.mAlgorithmID;
      localObject = new pqb();
      ((pqb)localObject).jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
      ((pqb)localObject).jdField_a_of_type_JavaLangString = paramBaseArticleInfo.innerUniqueID;
      ((pqb)localObject).jdField_b_of_type_JavaLangString = paramBaseArticleInfo.mVideoVid;
      ((pqb)localObject).jdField_a_of_type_Int = paramBaseArticleInfo.busiType;
      localqht.jdField_a_of_type_Pqb = ((pqb)localObject);
      localqht.jdField_d_of_type_JavaLangString = paramBaseArticleInfo.thirdIcon;
      localqht.e = paramBaseArticleInfo.thirdName;
      localqht.jdField_f_of_type_JavaLangString = paramBaseArticleInfo.thirdAction;
      localqht.jdField_f_of_type_Int = paramBaseArticleInfo.busiType;
      localqht.j = paramBaseArticleInfo.innerUniqueID;
      localqht.jdField_b_of_type_Long = paramBaseArticleInfo.mChannelID;
      return localqht;
    }
  }
  
  public static void a(LinearLayout paramLinearLayout, int paramInt1, int paramInt2, Activity paramActivity, int paramInt3, int paramInt4)
  {
    paramLinearLayout.setVisibility(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramLinearLayout.getLayoutParams();
    localLayoutParams.leftMargin = paramInt3;
    localLayoutParams.topMargin = paramInt4;
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = (aciy.a(42.0F, paramActivity.getResources()) + paramInt2);
    paramLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  public static void a(LinearLayout paramLinearLayout, ArticleInfo paramArticleInfo, Activity paramActivity, qod paramqod, int paramInt1, int paramInt2, int paramInt3)
  {
    omz localomz = new omz(paramActivity);
    localomz.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramLinearLayout.findViewById(2131313236));
    localomz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramLinearLayout.findViewById(2131302158));
    localomz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramLinearLayout.findViewById(2131302061));
    localomz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramLinearLayout.findViewById(2131309027));
    localomz.b = ((TextView)paramLinearLayout.findViewById(2131299841));
    localomz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)paramLinearLayout.findViewById(2131313175));
    localomz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup = ((ReadInJoyVideoInfoViewGroup)paramLinearLayout.findViewById(2131303214));
    a(localomz, paramArticleInfo, paramLinearLayout, paramActivity, paramqod, paramInt1, paramInt2, paramInt3);
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, boolean paramBoolean, Activity paramActivity, ArticleInfo paramArticleInfo)
  {
    pmu.a(paramActivity, paramKandianUrlImageView);
    if (qoe.c(paramArticleInfo) == 71) {
      paramURL = paramArticleInfo.getVideoCoverUrlWithSmartCut(false);
    }
    obj.a(paramKandianUrlImageView, paramURL, paramActivity, paramBoolean);
  }
  
  public static void a(ReadInJoyHeadImageView paramReadInJoyHeadImageView)
  {
    paramReadInJoyHeadImageView.setImageDrawable(bacm.b());
  }
  
  public static void a(omz paramomz, ArticleInfo paramArticleInfo, LinearLayout paramLinearLayout, Activity paramActivity, qod paramqod, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramArticleInfo == null) {
      return;
    }
    a(paramomz, paramArticleInfo);
    qht localqht = paramomz.jdField_a_of_type_Qht;
    paramomz.b.setText(obj.a(localqht.jdField_b_of_type_Int));
    a(paramomz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView);
    paramomz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setTag(paramArticleInfo);
    paramomz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setContentDescription(paramArticleInfo.mSubscribeName);
    Object localObject = paramArticleInfo.mSubscribeName;
    if (paramArticleInfo.mSubscribeName.length() > 18) {
      localObject = paramArticleInfo.mSubscribeName.substring(0, 17) + "…";
    }
    paramomz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(0);
    paramomz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText((CharSequence)localObject);
    paramomz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setContentDescription(paramArticleInfo.mSubscribeName);
    paramomz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getPaint().setFakeBoldText(true);
    localObject = new HashSet();
    paramomz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup.setArticleInfo(paramArticleInfo, paramqod, paramInt1, (Set)localObject);
    a(paramomz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramArticleInfo.getVideoCoverUrlWithSmartCut(false), false, paramActivity, paramArticleInfo);
    paramomz.b.setVisibility(0);
    paramomz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setCustomSize(1.0F, obj.a(localqht.jdField_c_of_type_Int, localqht.jdField_d_of_type_Int));
    float f1 = babp.a(paramActivity);
    float f2 = f1 * obj.a(localqht.jdField_c_of_type_Int, localqht.jdField_d_of_type_Int);
    paramArticleInfo = paramomz.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    paramArticleInfo.width = ((int)f1);
    paramArticleInfo.height = ((int)f2);
    paramomz.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(paramArticleInfo);
    a(paramLinearLayout, (int)f1, (int)f2, paramActivity, paramInt2, paramInt3);
  }
  
  public static void a(omz paramomz, BaseArticleInfo paramBaseArticleInfo)
  {
    qht localqht = a(paramBaseArticleInfo);
    localqht.jdField_a_of_type_AndroidViewView = paramomz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
    localqht.jdField_a_of_type_Int = paramomz.jdField_a_of_type_Int;
    localqht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    paramomz.jdField_a_of_type_Qht = localqht;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     oaz
 * JD-Core Version:    0.7.0.1
 */