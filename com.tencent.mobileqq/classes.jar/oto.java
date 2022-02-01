import android.app.Activity;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.CommentInfo;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils.1;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class oto
{
  public static String a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return "";
    }
    if (((pgb.g(paramArticleInfo)) || (pgb.i(paramArticleInfo))) && (paramArticleInfo.mSocialFeedInfo != null)) {
      return String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer.jdField_a_of_type_Long);
    }
    return paramArticleInfo.mSubscribeID;
  }
  
  public static String a(String paramString)
  {
    return paa.g + bfuc.encodeToString(paramString.getBytes(), 2);
  }
  
  public static String a(String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || ((!TextUtils.isEmpty(paramString)) && (paramString.length() <= paramInt))) {
      return paramString;
    }
    if (!TextUtils.isEmpty(paramString)) {
      return paramString.substring(0, paramInt) + "...";
    }
    return "";
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, CommentInfo paramCommentInfo, int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, String paramString3, boolean paramBoolean2, otp paramotp, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("arg_comment_enable_anonymous", false);
    localIntent.putExtra("arg_comment_placeholder", paramString1);
    localIntent.putExtra("arg_comment_default_txt", paramString2);
    localIntent.putExtra("arg_comment_max_length", -1);
    localIntent.putExtra("arg_comment_open_at", false);
    localIntent.putExtra("arg_comment_gif_switch", false);
    localIntent.putExtra("arg_comment_zhitu_switch", false);
    localIntent.putExtra("arg_comment_transparent_bg", paramBoolean2);
    localIntent.putExtra("comment_native", true);
    localIntent.putExtra("comment_reply_second", paramBoolean1);
    localIntent.putExtra("click_comment_edit_src", paramInt2);
    if (paramCommentInfo != null)
    {
      localIntent.putExtra("comment_id", paramCommentInfo.commentId);
      localIntent.putExtra("first_comment_uin", paramCommentInfo.authorUin);
    }
    localIntent.putExtra("comment_article_info", paramArticleInfo);
    if (paramCommentInfo != null)
    {
      paramString1 = paramCommentInfo.commentContent;
      paramCommentInfo = paramCommentInfo.authorUin;
      localIntent.putExtra("comment_val", paramString1);
      localIntent.putExtra("comment_author_uin", paramCommentInfo);
    }
    localIntent.putExtra("biu_src", paramInt1);
    if (paramArticleInfo != null) {
      localIntent.putExtra("feedsType", paramArticleInfo.mFeedType);
    }
    if (paramBoolean1) {
      localIntent.putExtra("comment_reply_second_uin", paramString3);
    }
    if ((paramArticleInfo instanceof AdvertisementInfo)) {
      localIntent.putExtra("arg_ad_show_biu", false);
    }
    adxr.a(paramActivity, localIntent, PublicTransFragmentActivity.class, ReadInJoyCommentComponentFragment.class, 117);
    if (paramotp != null) {
      paramotp.a();
    }
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, BaseCommentData paramBaseCommentData, int paramInt1, String paramString1, String paramString2, boolean paramBoolean, otp paramotp, int paramInt2)
  {
    a(paramActivity, paramArticleInfo, paramBaseCommentData, paramInt1, paramString1, paramString2, paramBoolean, paramotp, paramInt2, true);
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, BaseCommentData paramBaseCommentData, int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, otp paramotp, int paramInt2, boolean paramBoolean2)
  {
    if (paramActivity == null)
    {
      QLog.d("ReadInJoyCommentUtils", 1, "openCommentComponentNew | activity is null");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("arg_comment_enable_anonymous", false);
    localIntent.putExtra("arg_comment_placeholder", paramString1);
    localIntent.putExtra("arg_comment_default_txt", paramString2);
    localIntent.putExtra("arg_comment_max_length", -1);
    localIntent.putExtra("arg_comment_open_at", false);
    localIntent.putExtra("arg_comment_gif_switch", false);
    localIntent.putExtra("arg_comment_zhitu_switch", false);
    localIntent.putExtra("arg_comment_transparent_bg", paramBoolean1);
    localIntent.putExtra("comment_native", true);
    localIntent.putExtra("comment_reply_second", paramBaseCommentData instanceof SubCommentData);
    localIntent.putExtra("click_comment_edit_src", paramInt2);
    localIntent.putExtra("comment_article_info", paramArticleInfo);
    localIntent.putExtra("biu_src", paramInt1);
    QLog.d("ReadInJoyCommentUtils", 2, "openCommentComponent | comment_placeholder after decode: " + paramString1);
    paramInt2 = 2;
    if (paramBaseCommentData != null)
    {
      localIntent.putExtra("comment_id", paramBaseCommentData.commentId);
      localIntent.putExtra("first_comment_uin", paramBaseCommentData.uin);
      paramString1 = paramBaseCommentData.commentContent;
      paramString2 = paramBaseCommentData.uin;
      localIntent.putExtra("comment_val", paramString1);
      localIntent.putExtra("comment_author_uin", paramString2);
      if ((paramBaseCommentData != null) && (paramBaseCommentData.mediaDataList != null) && (paramBaseCommentData.mediaDataList.size() > 0) && (((oun)paramBaseCommentData.mediaDataList.get(0)).e != 0)) {
        localIntent.putExtra("comment_can_biu", false);
      }
      if ((paramBaseCommentData.commentLinkDataList != null) && (!paramBaseCommentData.commentLinkDataList.isEmpty())) {
        break label413;
      }
    }
    label413:
    for (paramInt2 = 0;; paramInt2 = 1)
    {
      localIntent.putExtra("comment_to_reply_contain_link", paramInt2);
      if (paramArticleInfo != null) {
        localIntent.putExtra("feedsType", paramArticleInfo.mFeedType);
      }
      if ((paramBaseCommentData instanceof SubCommentData)) {
        localIntent.putExtra("comment_reply_second_uin", paramBaseCommentData.uin);
      }
      if (paramInt1 == 2) {
        localIntent.putExtra("comment_is_show_pic", pcj.a());
      }
      localIntent.putExtra("arg_ad_show_biu", paramBoolean2);
      adxr.a(paramActivity, localIntent, PublicTransFragmentActivity.class, ReadInJoyCommentComponentFragment.class, 117);
      if (paramotp == null) {
        break;
      }
      paramotp.a();
      return;
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, CommentInfo paramCommentInfo, boolean paramBoolean)
  {
    if ((paramArticleInfo == null) || (paramCommentInfo == null)) {
      QLog.d("ReadInJoyCommentUtils", 2, "localUpdateCommentData: articleInfo or commentInfo is null");
    }
    do
    {
      return;
      long l = paramArticleInfo.mRecommendSeq;
      paramArticleInfo = pkm.a().a((int)paramArticleInfo.mChannelID, l);
    } while (paramArticleInfo == null);
    if (!paramBoolean)
    {
      paramCommentInfo = paramArticleInfo.mSocialFeedInfo;
      paramCommentInfo.d += 1;
    }
    paramArticleInfo.invalidateProteusTemplateBean();
    ThreadManager.getUIHandler().post(new ReadInJoyCommentUtils.1());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent, int paramInt)
  {
    if (paramIntent == null)
    {
      QQToast.a(BaseApplication.getContext(), 1, BaseApplication.getContext().getString(2131717293), 0).a();
      QLog.d("ReadInJoyCommentUtils", 2, "comment result intent data is null");
    }
    ArticleInfo localArticleInfo;
    boolean bool;
    do
    {
      return;
      paramQQAppInterface = paramIntent.getStringExtra("arg_result_json");
      localArticleInfo = (ArticleInfo)paramIntent.getParcelableExtra("comment_article_info");
      bool = paramIntent.getBooleanExtra("comment_gallery_channel", false);
    } while ((paramInt != -1) && (paramInt != 1699));
    if ((localArticleInfo != null) && (bool))
    {
      ouu.a(localArticleInfo, 0).b(paramQQAppInterface);
      ouu.a(localArticleInfo);
      return;
    }
    pkm.a().a(localArticleInfo, paramQQAppInterface);
  }
  
  public static void a(String paramString, Context paramContext)
  {
    a(paramString, paramContext, null);
  }
  
  public static void a(String paramString, Context paramContext, ArticleInfo paramArticleInfo)
  {
    if (paramContext == null) {
      return;
    }
    paramString = uhv.a(paramArticleInfo, paa.g + bfuc.encodeToString(paramString.getBytes(), 2), uhv.g);
    pay.a(paramContext, paramString);
    QLog.d("ReadInJoyCommentUtils", 1, "personal url =" + paramString);
  }
  
  public static void a(String paramString, ArticleInfo paramArticleInfo, pbg parampbg)
  {
    odq.a(null, a(paramArticleInfo), paramString, paramString, 0, 0, String.valueOf(paramArticleInfo.mArticleID), String.valueOf(paramArticleInfo.mStrategyId), paramArticleInfo.innerUniqueID, parampbg.a(), false);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramContext == null)) {
      return false;
    }
    paramContext = (ClipboardManager)paramContext.getSystemService("clipboard");
    if (paramContext.hasPrimaryClip())
    {
      ClipData localClipData = paramContext.getPrimaryClip();
      if ((localClipData != null) && (localClipData.getItemCount() > 0))
      {
        paramContext = paramContext.getPrimaryClip().getItemAt(0);
        if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.getText())))
        {
          paramContext = String.valueOf(paramContext.getText());
          paramString = new QQText(bblk.b(paramString), 7, 18).toString();
          if (!TextUtils.isEmpty(paramContext)) {
            return paramContext.contains(paramString);
          }
        }
      }
    }
    return false;
  }
  
  public static boolean a(ArticleInfo paramArticleInfo, String paramString)
  {
    if (paramArticleInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentUtils", 2, " marticleinfo=null");
      }
      return false;
    }
    SocializeFeedsInfo localSocializeFeedsInfo = new SocializeFeedsInfo();
    localSocializeFeedsInfo.jdField_a_of_type_Rep = new rep();
    ArrayList localArrayList = new ArrayList();
    int j;
    int k;
    int i;
    try
    {
      paramString = new JSONObject(paramString).getJSONObject("biu_info");
      j = paramString.optInt("biuSrc");
      k = paramString.optInt("feedtype");
      if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep != null))
      {
        localSocializeFeedsInfo.jdField_a_of_type_Rep.b = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.b;
        localSocializeFeedsInfo.jdField_a_of_type_Rep.jdField_a_of_type_JavaLangLong = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.jdField_a_of_type_JavaLangLong;
      }
      paramString = paramString.optJSONArray("biuinfo");
      i = 0;
      if (i < paramString.length())
      {
        paramString.getJSONObject(i);
        localObject = paramString.getJSONObject(i).optString("biu_uin");
        if ((paramString.getJSONObject(i).opt("biu_feedid") instanceof Integer)) {}
        for (long l = ((Integer)paramString.getJSONObject(i).opt("biu_feedid")).intValue();; l = ((Long)paramString.getJSONObject(i).opt("biu_feedid")).longValue())
        {
          localObject = new otw((String)localObject, l, paramString.getJSONObject(i).optString("biu_info_comment"));
          ((otw)localObject).jdField_a_of_type_Int = paramString.getJSONObject(i).optInt("biu_optype");
          ((otw)localObject).jdField_a_of_type_JavaLangCharSequence = paramString.getJSONObject(i).optString("biu_nickname");
          localArrayList.add(localObject);
          i += 1;
          break;
        }
      }
      if (!QLog.isColorLevel()) {
        break label377;
      }
    }
    catch (Exception paramArticleInfo)
    {
      return false;
    }
    paramString = new StringBuilder("onDeliver deliverList:\n");
    Object localObject = localArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString.append(((otw)((Iterator)localObject).next()).toString()).append("\n");
    }
    QLog.d("ReadInJoyCommentUtils", 2, paramString.toString());
    label377:
    if ((paramArticleInfo != null) && (localArrayList.size() > 0))
    {
      i = 1;
      for (;;)
      {
        if (i < localArrayList.size())
        {
          localObject = (otw)localArrayList.get(i);
          SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = new SocializeFeedsInfo.BiuCommentInfo();
          try
          {
            localBiuCommentInfo.jdField_a_of_type_JavaLangLong = Long.valueOf(((otw)localObject).jdField_a_of_type_JavaLangString);
            if (((otw)localObject).b == null)
            {
              paramString = "";
              localBiuCommentInfo.jdField_a_of_type_JavaLangString = paramString;
              localBiuCommentInfo.c = ((otw)localObject).jdField_a_of_type_Int;
              localBiuCommentInfo.b = Long.valueOf(((otw)localObject).jdField_a_of_type_Long);
              localSocializeFeedsInfo.jdField_a_of_type_Rep.jdField_a_of_type_JavaUtilList.add(localBiuCommentInfo);
              i += 1;
            }
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              localBiuCommentInfo.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
              continue;
              paramString = ((otw)localObject).b.toString();
            }
          }
        }
      }
      pkm.a().a(pay.a(), paramArticleInfo.mFeedId, localSocializeFeedsInfo.jdField_a_of_type_Rep, 0L, ((otw)localArrayList.get(0)).b.toString(), paramArticleInfo.mArticleID, paramArticleInfo.mRecommendSeq, j, paramArticleInfo.innerUniqueID, k, paramArticleInfo);
    }
    return true;
  }
  
  public static void b(String paramString, Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      do
      {
        return;
      } while ((!paramString.startsWith("http")) && (!paramString.startsWith("https")));
      pay.a(paramContext, paramString);
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyCommentUtils", 2, "personal url =" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oto
 * JD-Core Version:    0.7.0.1
 */