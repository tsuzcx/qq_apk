import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class qfb
  implements ViewBase.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private swi jdField_a_of_type_Swi;
  private tjz jdField_a_of_type_Tjz;
  private ugz jdField_a_of_type_Ugz;
  
  public qfb(ArticleInfo paramArticleInfo, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static String a(ArticleInfo paramArticleInfo)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      pay.a(localJSONObject, paramArticleInfo);
      localJSONObject.put("feed_type", 1043);
      localJSONObject.put("version", ofe.a);
      localJSONObject.put("os", "1");
      if (paramArticleInfo != null)
      {
        localJSONObject.put("comment_id", paramArticleInfo.commentId);
        localJSONObject.put("entry", paramArticleInfo.commentSrc);
      }
      if ((paramArticleInfo != null) && (paramArticleInfo.mChannelID == 0L)) {
        localJSONObject.put("place", 1);
      }
      for (;;)
      {
        return localJSONObject.toString();
        if ((paramArticleInfo != null) && (paramArticleInfo.mChannelID == 70L)) {
          localJSONObject.put("place", 2);
        }
      }
      return "";
    }
    catch (JSONException paramArticleInfo)
    {
      QLog.d("OnShareClickListener", 2, paramArticleInfo.getMessage());
    }
  }
  
  private List<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(13));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(9));
    localArrayList.add(Integer.valueOf(10));
    return localArrayList;
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    String str = a(paramArticleInfo);
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    odq.a(null, paramArticleInfo.mSubscribeID, "0X800AB52", "0X800AB52", 0, 0, String.valueOf(localSocializeFeedsInfo.a), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, str, false);
  }
  
  private void a(ViewBase paramViewBase)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_Ugz = new ugz((Activity)paramViewBase.getNativeView().getContext(), localQQAppInterface, new qfd(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, new WeakReference((Activity)paramViewBase.getNativeView().getContext())));
    paramViewBase.getNativeView().addOnAttachStateChangeListener(new qfc(this));
    paramViewBase = this.jdField_a_of_type_Ugz.a().getIntent();
    if ((paramViewBase != null) && (TextUtils.isEmpty(paramViewBase.getStringExtra("big_brother_source_key")))) {
      paramViewBase.putExtra("big_brother_source_key", "biz_src_feeds_kandian");
    }
    this.jdField_a_of_type_Ugz.a().setActionSheetTitle(amtj.a(2131712694));
    int i;
    if (pgb.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
      i = 15;
    }
    for (;;)
    {
      this.jdField_a_of_type_Ugz.a(new List[] { a() }, i);
      return;
      if (pgb.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
        i = 16;
      } else if (pgb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
        i = 12;
      } else {
        i = 0;
      }
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    a(paramViewBase);
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qfb
 * JD-Core Version:    0.7.0.1
 */