import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.Pair;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.VisibleForTesting;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.NativeAd.report.JumpMode;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.click.RIJListViewGroupHandlerClick.1;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentVerticalSmallVideo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

public class ppo
{
  public static ArticleInfo a(ArticleInfo paramArticleInfo)
  {
    ArticleInfo localArticleInfo = new ArticleInfo();
    localArticleInfo.mChannelID = paramArticleInfo.mChannelID;
    rpt localrpt = (rpt)paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
    localArticleInfo.mStrategyId = localrpt.jdField_a_of_type_Int;
    localArticleInfo.mAlgorithmID = localrpt.jdField_b_of_type_Long;
    localArticleInfo.mTitle = localrpt.jdField_a_of_type_JavaLangString;
    localArticleInfo.mFirstPagePicUrl = localrpt.jdField_c_of_type_JavaLangString;
    localArticleInfo.mArticleContentUrl = localrpt.jdField_d_of_type_JavaLangString;
    localArticleInfo.mArticleID = localrpt.jdField_a_of_type_Long;
    localArticleInfo.mSubscribeID = localrpt.jdField_e_of_type_JavaLangString;
    localArticleInfo.mSubscribeName = localrpt.jdField_f_of_type_JavaLangString;
    localArticleInfo.innerUniqueID = localrpt.jdField_g_of_type_JavaLangString;
    localArticleInfo.mNewPolymericInfo = paramArticleInfo.mNewPolymericInfo;
    return localArticleInfo;
  }
  
  public static void a(Context paramContext, BaseAdapter paramBaseAdapter, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(paramContext, paramBaseAdapter, paramArticleInfo, true, paramInt1, paramInt2, paramBoolean, 1);
  }
  
  public static void a(Context paramContext, BaseAdapter paramBaseAdapter, ArticleInfo paramArticleInfo, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, int paramInt3)
  {
    Intent localIntent = new Intent(paramContext, ReadInJoyChannelActivity.class);
    localIntent.putExtra("channel_id", 56);
    localIntent.putExtra("channel_name", anvx.a(2131712527));
    localIntent.putExtra("channel_type", 3);
    localIntent.putExtra("channel_from", paramInt3);
    localIntent.putExtra("is_channel_activity", true);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", paramArticleInfo.mArticleID);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", paramArticleInfo.mRecommendSeq);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", true);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", true);
    boolean bool;
    if (!ppe.q(paramArticleInfo))
    {
      bool = true;
      localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_IS_UGC_VIDEO", bool);
      localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_INFO", paramArticleInfo);
      paramInt3 = ppe.a(paramArticleInfo);
      if ((!paramBoolean1) || ((paramInt3 != 6) && (paramInt3 != 28) && (paramInt3 != 71))) {
        break label243;
      }
      localIntent.putExtra("is_need_show_animation_translate", true);
      localIntent.putExtra("is_need_show_animation_adapter", true);
      if (paramBoolean2)
      {
        localIntent.putExtra("view_translation_animation_top", paramInt1);
        localIntent.putExtra("view_translation_animation_left", paramInt2);
      }
    }
    for (;;)
    {
      paramContext.startActivity(localIntent);
      omx.a.put(ReadInJoyChannelActivity.class, omx.b());
      sqp.a().a(false, "jumpFromKandianFeed", 1);
      return;
      bool = false;
      break;
      label243:
      if (paramBaseAdapter != null) {
        paramBaseAdapter.notifyDataSetChanged();
      }
    }
  }
  
  private void a(View paramView, int paramInt, ArticleInfo paramArticleInfo, ppq paramppq)
  {
    if ((paramView instanceof ProteusItemView)) {
      a((ProteusItemView)paramView, paramppq.a());
    }
    for (;;)
    {
      a(paramArticleInfo, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt, paramppq);
      return;
      if ((paramView instanceof LinearLayout)) {
        a((LinearLayout)paramView, paramppq.a());
      }
    }
  }
  
  private void a(View paramView, int paramInt, ArticleInfo paramArticleInfo, ppq paramppq, Handler paramHandler)
  {
    if (a(paramArticleInfo, paramView))
    {
      pqb.a(paramppq.a(), paramArticleInfo, paramppq.b());
      QLog.d("RIJListViewGroupHandlerClick", 2, "main feeds hit Gallery feeds");
    }
    for (;;)
    {
      pvj.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      if (paramppq.a() != null) {}
      try
      {
        if (!TextUtils.isEmpty(tto.b(paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8())))
        {
          paramView = paramHandler;
          if (paramHandler == null) {
            paramView = new Handler(Looper.getMainLooper());
          }
          paramView.postDelayed(new RIJListViewGroupHandlerClick.1(this, paramppq), 2000L);
          return;
          b(paramArticleInfo, paramInt - 1, paramppq);
        }
        else
        {
          paramppq.a().notifyDataSetChanged();
          return;
        }
      }
      catch (Exception paramView)
      {
        paramppq.a().notifyDataSetChanged();
      }
    }
  }
  
  private void a(View paramView, ArticleInfo paramArticleInfo, ppq paramppq)
  {
    if (six.a(paramArticleInfo, paramppq.a())) {}
    do
    {
      return;
      int i = ppe.a(paramArticleInfo);
      if ((i == 23) || (i == 26) || (i == 56) || (i == 59) || (i == 19) || (i == 17) || (i == 11) || (i == 28))
      {
        a(paramArticleInfo, paramView, paramppq);
        return;
      }
      i = ppe.a(paramArticleInfo);
      if (a(paramArticleInfo, i))
      {
        a(paramArticleInfo, paramppq, i);
        return;
      }
    } while (!a(paramArticleInfo));
    c(paramArticleInfo, paramppq);
  }
  
  private void a(LinearLayout paramLinearLayout, Activity paramActivity)
  {
    paramLinearLayout = (TextView)paramLinearLayout.findViewById(2131365042);
    if (paramLinearLayout != null)
    {
      paramLinearLayout.setTextColor(paramActivity.getResources().getColor(2131166491));
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.videoanimation", 2, " change ui state after readed");
      }
    }
  }
  
  private void a(ProteusItemView paramProteusItemView, Activity paramActivity)
  {
    paramProteusItemView = (TextBase)paramProteusItemView.a().getVirtualView().findViewBaseByName("id_artilce_title");
    if (paramProteusItemView != null)
    {
      paramProteusItemView.setTextColor(paramActivity.getResources().getColor(2131166491));
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.videoanimation", 2, " change ui state after readed");
      }
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, Activity paramActivity, int paramInt)
  {
    String str = paramArticleInfo.mArticleContentUrl;
    if (!TextUtils.isEmpty(str))
    {
      Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      paramActivity.startActivity(localIntent);
    }
    pqb.a(paramActivity, paramArticleInfo, paramInt);
  }
  
  private void a(ArticleInfo paramArticleInfo, Activity paramActivity, int paramInt, szd paramszd)
  {
    if ((!AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) && (paramszd != null) && (!ppe.a(paramArticleInfo))) {
      pqx.a(paramActivity, paramArticleInfo, paramszd, paramInt);
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, View paramView, int paramInt, szd paramszd)
  {
    if ((paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList == null) || (paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.size() <= 0))
    {
      QLog.e("RIJListViewGroupHandlerClick", 1, "handleJumpFullVideoPlayForNewPolymeric, bad data need backend check");
      return;
    }
    a(paramArticleInfo, (rpt)paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0), paramView, paramInt, paramszd);
  }
  
  private void a(ArticleInfo paramArticleInfo, ppq paramppq, int paramInt)
  {
    if (b(paramArticleInfo, paramInt)) {
      a(paramArticleInfo, null, 0, 0, false, 0, paramppq);
    }
    for (;;)
    {
      a(paramppq);
      return;
      if ((paramInt == 95) || (paramInt == 94)) {
        pkh.a(paramppq.a(), paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrp.jdField_a_of_type_JavaLangString);
      } else if (paramArticleInfo.isPGCShortContent()) {
        qsj.a(paramppq.a(), paramArticleInfo);
      } else if (!AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) {
        a(paramArticleInfo, paramppq);
      }
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, rpt paramrpt, View paramView, int paramInt, szd paramszd)
  {
    spk localspk = new spk();
    if (paramrpt.jdField_a_of_type_Rpw == null) {
      QLog.e("handleJumpFullVideoPlayForNewPolymeric", 2, " bad data need backend check");
    }
    do
    {
      return;
      localspk.jdField_c_of_type_Long = paramrpt.jdField_a_of_type_Long;
      localspk.jdField_h_of_type_JavaLangString = (paramrpt.jdField_a_of_type_Rpw.jdField_b_of_type_Long + "");
      localspk.jdField_i_of_type_JavaLangString = paramrpt.jdField_a_of_type_Rpw.jdField_d_of_type_JavaLangString;
      localspk.jdField_k_of_type_JavaLangString = paramrpt.jdField_e_of_type_JavaLangString;
      localspk.jdField_g_of_type_Int = paramrpt.jdField_a_of_type_Int;
      localspk.jdField_g_of_type_Long = paramrpt.jdField_b_of_type_Long;
      Object localObject = new rqa();
      ((rqa)localObject).jdField_a_of_type_JavaLangLong = Long.valueOf(paramrpt.jdField_a_of_type_Long);
      ((rqa)localObject).jdField_a_of_type_JavaLangString = paramrpt.jdField_g_of_type_JavaLangString;
      ((rqa)localObject).jdField_a_of_type_Int = paramrpt.jdField_a_of_type_Rpw.jdField_a_of_type_Int;
      ((rqa)localObject).jdField_b_of_type_JavaLangString = paramrpt.jdField_a_of_type_Rpw.jdField_a_of_type_JavaLangString;
      localspk.a = ((rqa)localObject);
      localspk.jdField_b_of_type_JavaLangString = paramrpt.jdField_c_of_type_JavaLangString;
      localspk.jdField_c_of_type_JavaLangString = paramrpt.jdField_a_of_type_Rpw.jdField_a_of_type_JavaLangString;
      localspk.jdField_f_of_type_Int = paramrpt.jdField_a_of_type_Rpw.jdField_a_of_type_Int;
      localspk.jdField_c_of_type_Int = paramrpt.jdField_a_of_type_Rpw.jdField_b_of_type_Int;
      localspk.jdField_d_of_type_Int = paramrpt.jdField_a_of_type_Rpw.jdField_c_of_type_Int;
      localspk.jdField_b_of_type_Int = paramrpt.jdField_a_of_type_Rpw.jdField_d_of_type_Int;
      localspk.jdField_e_of_type_Long = paramrpt.jdField_a_of_type_Rpw.jdField_a_of_type_Long;
      localspk.jdField_j_of_type_JavaLangString = paramrpt.jdField_g_of_type_JavaLangString;
      localspk.jdField_g_of_type_JavaLangString = paramrpt.jdField_a_of_type_Rpw.jdField_b_of_type_JavaLangString;
      localspk.jdField_d_of_type_JavaLangString = paramrpt.jdField_a_of_type_Rpw.jdField_f_of_type_JavaLangString;
      localspk.jdField_e_of_type_JavaLangString = paramrpt.jdField_a_of_type_Rpw.jdField_e_of_type_JavaLangString;
      localspk.jdField_f_of_type_JavaLangString = paramrpt.jdField_a_of_type_Rpw.jdField_g_of_type_JavaLangString;
      if (paramView != null)
      {
        localObject = new int[2];
        paramView.getLocationOnScreen((int[])localObject);
        localspk.jdField_h_of_type_Int = localObject[0];
        localspk.jdField_i_of_type_Int = localObject[1];
        localspk.jdField_j_of_type_Int = paramView.getWidth();
        localspk.jdField_k_of_type_Int = paramView.getHeight();
        if (((paramView instanceof ComponentContentVerticalSmallVideo)) && (((ComponentContentVerticalSmallVideo)paramView).jdField_a_of_type_Boolean))
        {
          localObject = pjr.a(3, paramInt);
          int i = localspk.jdField_h_of_type_Int;
          localspk.jdField_h_of_type_Int = ((localspk.jdField_j_of_type_Int - ((Integer)((Pair)localObject).first).intValue()) / 2 + i);
          localspk.jdField_j_of_type_Int = ((Integer)((Pair)localObject).first).intValue();
        }
      }
      localObject = new rqg();
      ((rqg)localObject).jdField_a_of_type_Int = 409409;
      paramszd.a(localspk, paramArticleInfo);
      if (paramInt == 0) {
        omx.a(paramrpt.jdField_a_of_type_Long, paramrpt.jdField_g_of_type_JavaLangString, paramInt, (int)paramrpt.jdField_b_of_type_Long, paramrpt.jdField_a_of_type_Int, 24, -1L, (rqg)localObject, -1, paramrpt.jdField_k_of_type_JavaLangString);
      }
      pvj.a().a(paramrpt.jdField_a_of_type_Long, System.currentTimeMillis());
    } while ((paramView instanceof ComponentContentVerticalSmallVideo));
    paramszd.notifyDataSetChanged();
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo, View paramView, ArticleInfo paramArticleInfo, Activity paramActivity)
  {
    if (a(paramArticleInfo, paramView))
    {
      QLog.d("RIJListViewGroupHandlerClick", 2, "main feeds hit ShortContent feeds");
      QLog.d("RIJListViewGroupHandlerClick", 1, "tryJumpToUgUrl: true");
      paramArticleInfo.clickJumpTarget = qsj.a(piv.a(paramArticleInfo), "-1");
    }
    for (;;)
    {
      paramBaseArticleInfo.clickArea = 7;
      pqb.a(paramActivity, paramArticleInfo, (int)paramBaseArticleInfo.mChannelID);
      return;
      QLog.d("RIJListViewGroupHandlerClick", 1, "short content redirectToOtherPage");
      qsj.a(paramActivity, paramArticleInfo);
    }
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo, View paramView, ArticleInfo paramArticleInfo, ppq paramppq)
  {
    if (paramBaseArticleInfo.isAccountShown) {
      paramBaseArticleInfo.clickArea = 7;
    }
    if (a(paramArticleInfo, paramView))
    {
      QLog.d("RIJListViewGroupHandlerClick", 2, "main feeds hit ug normal feeds");
      pvj.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      paramppq.a().notifyDataSetChanged();
      paramBaseArticleInfo.clickJumpTarget = qsj.a(piv.a(paramArticleInfo), "-1");
      pqb.a(paramppq.a(), paramArticleInfo, paramppq.b());
      return;
    }
    if (a(paramArticleInfo, paramView, paramppq))
    {
      QLog.d("RIJListViewGroupHandlerClick", 2, "main feeds hit srt normal feeds");
      paramBaseArticleInfo.clickJumpTarget = qsj.a(pkd.a().a(), "-1");
      return;
    }
    if ((!rnz.c(paramArticleInfo)) && (!pkd.a().a()) && (pqf.a(paramView.getContext(), paramArticleInfo)))
    {
      pqb.a(paramppq.a(), paramArticleInfo, paramppq.b());
      pvj.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      paramppq.a().notifyDataSetChanged();
      paramppq = pqx.b(paramArticleInfo.getInnerUniqueID());
      paramBaseArticleInfo.clickJumpTarget = qsj.a(paramppq, "-1");
      pqx.a(paramView.getContext(), paramArticleInfo, paramppq);
      return;
    }
    if (qct.a(paramView.getContext(), paramArticleInfo.mArticleContentUrl))
    {
      pqb.a(paramppq.a(), paramArticleInfo, paramppq.b());
      pvj.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      paramppq.a().notifyDataSetChanged();
      return;
    }
    paramBaseArticleInfo.clickJumpTarget = qsj.a("", "3");
    b(paramArticleInfo, paramppq);
  }
  
  private boolean a(ArticleInfo paramArticleInfo, View paramView)
  {
    String str = piv.a(paramArticleInfo);
    if (!TextUtils.isEmpty(str))
    {
      if (rnz.a(str)) {
        pqx.a(paramView.getContext(), paramArticleInfo, str);
      }
      for (;;)
      {
        QLog.d("RIJListViewGroupHandlerClick", 1, "UGRuleManager articleInfo hit ug title" + paramArticleInfo.mTitle);
        return true;
        six.a(BaseApplicationImpl.getApplication(), str);
      }
    }
    return false;
  }
  
  private boolean a(ArticleInfo paramArticleInfo, View paramView, ppq paramppq)
  {
    if (rnz.c(paramArticleInfo)) {}
    boolean bool;
    String str;
    do
    {
      return false;
      bool = pkd.a().a(paramArticleInfo, null, null);
      str = pkd.a().a();
    } while ((!bool) || (TextUtils.isEmpty(str)));
    pvj.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    paramppq.a().notifyDataSetChanged();
    pqb.a(paramppq.a(), paramArticleInfo, paramppq.b());
    pqx.a(paramView.getContext(), paramArticleInfo, str);
    return true;
  }
  
  private boolean a(BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, ArticleInfo paramArticleInfo, ppq paramppq)
  {
    if ((paramArticleInfo.isTwoItemVideoFeed()) && (paramArticleInfo.mFeedType != 36))
    {
      QLog.d("Q.readinjoy.video", 2, "JumpAndForceInsert onVideoArticleClick() RETURN article.mArticleID:" + paramArticleInfo.mArticleID + " article.mTitle:" + paramArticleInfo.mTitle);
      return true;
    }
    if (ppe.a(paramArticleInfo) == 6)
    {
      if ((paramView instanceof ProteusItemView)) {
        a((ProteusItemView)paramView, paramppq.a());
      }
    }
    else
    {
      if (!a(paramArticleInfo, paramView)) {
        break label297;
      }
      QLog.d("RIJListViewGroupHandlerClick", 2, "main feeds hit ug video feeds");
      pvj.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      paramppq.a().notifyDataSetChanged();
      pqb.a(paramppq.a(), paramArticleInfo, paramppq.b());
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "JumpAndForceInsert onVideoArticleClick() article.mArticleID:" + paramArticleInfo.mArticleID + " article.mTitle:" + paramArticleInfo.mTitle + " article.mSummary:" + paramArticleInfo.mSummary + "mJsonVideoList:" + paramArticleInfo.mJsonVideoList + " videoJumpChannelID=" + paramArticleInfo.videoJumpChannelID + " videoJumpChannelName=" + paramArticleInfo.videoJumpChannelName + " videoJumpChannelType=" + paramArticleInfo.videoJumpChannelType);
      }
      return false;
      if (!(paramView instanceof LinearLayout)) {
        break;
      }
      a((LinearLayout)paramView, paramppq.a());
      break;
      label297:
      if (a(paramArticleInfo, paramView, paramppq))
      {
        QLog.d("RIJListViewGroupHandlerClick", 2, "main feeds hit srt video feeds");
      }
      else if (paramBaseArticleInfo.isAccountShown)
      {
        paramBaseArticleInfo.clickArea = 7;
        paramBaseArticleInfo.clickJumpTarget = qsj.a("", "3");
        b(paramArticleInfo, paramppq);
      }
      else
      {
        a(paramArticleInfo, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt, paramppq);
      }
    }
  }
  
  private void b(View paramView, ArticleInfo paramArticleInfo, ppq paramppq)
  {
    if (ppe.c(paramArticleInfo))
    {
      a(paramArticleInfo, paramppq);
      return;
    }
    pqx.a(paramppq.a(), paramArticleInfo, 1, false, 4, false);
  }
  
  private void b(ArticleInfo paramArticleInfo, int paramInt, ppq paramppq)
  {
    if ((paramArticleInfo != null) && (!TextUtils.isEmpty(paramArticleInfo.innerUniqueID)))
    {
      pqb.a(paramppq.a(), paramArticleInfo, paramppq.b());
      if (paramppq.a().a(paramppq.b(), paramArticleInfo.mArticleID)) {}
      pqa.a(paramArticleInfo);
      if ((paramArticleInfo.mGalleryFeedsInfo != null) && (paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.has()) && (!TextUtils.isEmpty(paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8())))
      {
        str = paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8();
        localBundle = new Bundle();
        localBundle.putString("big_brother_source_key", pqx.a(0));
        pqx.a(paramppq.a(), str, localBundle);
        pih.a(paramppq.a(), paramArticleInfo, paramppq.a());
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      Bundle localBundle;
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.e("RIJListViewGroupHandlerClick", 2, "jumpToGallery failed: url is null");
      return;
    }
    QLog.e("RIJListViewGroupHandlerClick", 2, "jumpToGallery falied articleInfo is null or rowkey is empty");
  }
  
  private void b(ArticleInfo paramArticleInfo, Activity paramActivity, int paramInt)
  {
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rru != null) && (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rru.jdField_k_of_type_JavaLangString)))
    {
      pqb.a(paramActivity, paramArticleInfo, paramInt);
      pqx.b(paramActivity, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rru.jdField_k_of_type_JavaLangString);
      pvj.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    }
  }
  
  private void b(ArticleInfo paramArticleInfo, Activity paramActivity, int paramInt, szd paramszd)
  {
    pqb.a(paramActivity, paramArticleInfo, paramInt);
    pvj.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    paramszd.notifyDataSetChanged();
    pqx.a(paramActivity, paramArticleInfo);
  }
  
  private void b(ppq paramppq)
  {
    int j = paramppq.a().getCount();
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        Object localObject = paramppq.a().getItem(i);
        if ((localObject instanceof ArticleInfo))
        {
          localObject = (ArticleInfo)localObject;
          ((ArticleInfo)localObject).setSearchWordInfo(null, null, null);
          ((ArticleInfo)localObject).invalidateProteusTemplateBean();
        }
        i += 1;
      }
    }
  }
  
  private boolean b(BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, pko<Integer> parampko, ArticleInfo paramArticleInfo, ppq paramppq, Handler paramHandler)
  {
    boolean bool = false;
    if ((ppe.i(paramArticleInfo)) || (ppe.k(paramArticleInfo)))
    {
      pqx.a(paramppq.a(), paramArticleInfo, 0, false, 1, false);
      pqb.b(paramArticleInfo, paramppq.b());
      paramBaseArticleInfo = "jumpNewSocialSecondPage";
    }
    for (;;)
    {
      QLog.d("RIJListViewGroupHandlerClick", 1, "onItemClickPartTwo, jumpTarget= " + paramBaseArticleInfo);
      return bool;
      if (ppe.h(paramArticleInfo))
      {
        b(paramView, paramArticleInfo, paramppq);
        paramBaseArticleInfo = "onOfficalRecommendClick";
      }
      else
      {
        if (pqw.a(paramArticleInfo))
        {
          if (a(paramBaseArticleInfo, paramView, paramInt, paramArticleInfo, paramppq)) {}
          for (bool = true;; bool = false)
          {
            paramBaseArticleInfo = "onVideoArticleClick";
            break;
            parampko.a(Integer.valueOf(4));
          }
        }
        if (pqw.c(paramArticleInfo))
        {
          a(paramView, paramInt, paramArticleInfo, paramppq, paramHandler);
          paramBaseArticleInfo = "onGalleryClick";
        }
        else if ((pqw.a(paramArticleInfo.mArticleContentUrl, paramArticleInfo.mChannelID, paramArticleInfo)) || (paramArticleInfo.isAccountShown))
        {
          a(paramBaseArticleInfo, paramView, paramArticleInfo, paramppq);
          parampko.a(Integer.valueOf(2));
          paramBaseArticleInfo = "onSupportNativeClick";
        }
        else if (paramArticleInfo.mFeedType == 26)
        {
          b(paramArticleInfo, paramppq.a(), paramppq.b());
          paramBaseArticleInfo = "onQuestionClick";
        }
        else if (paramArticleInfo.mFeedType == 23)
        {
          pqx.a(paramppq.a(), paramArticleInfo, 1, false, 4, false);
          paramBaseArticleInfo = "FeedsType_PGC_Gallery->jumpNewSocialSecondPage";
        }
        else if (paramArticleInfo.mFeedType == 34)
        {
          pqx.a(paramppq.a(), paramArticleInfo.mArticleContentUrl, null);
          pqb.b(paramArticleInfo, paramppq.b());
          paramBaseArticleInfo = "FeedsType_Scrip_Cms";
        }
        else if (paramArticleInfo.mFeedType == 39)
        {
          uks.a(paramArticleInfo, paramppq.a(), paramInt);
          paramBaseArticleInfo = "jumpToMiniGame";
        }
        else
        {
          parampko.a(Integer.valueOf(2));
          a(paramArticleInfo, paramppq.a(), paramppq.b(), paramppq.a());
          paramBaseArticleInfo = "onAdClick";
        }
      }
    }
  }
  
  private void c(ArticleInfo paramArticleInfo, ppq paramppq)
  {
    if (pqw.a(paramArticleInfo)) {
      a(paramArticleInfo, null, 0, 0, false, 0, paramppq);
    }
    do
    {
      return;
      if (paramArticleInfo.isPGCShortContent())
      {
        qsj.a(paramppq.a(), paramArticleInfo);
        return;
      }
    } while (AdvertisementInfo.isAdvertisementInfo(paramArticleInfo));
    a(paramArticleInfo, paramppq);
  }
  
  private void d(ArticleInfo paramArticleInfo, ppq paramppq)
  {
    if (paramArticleInfo.isPGCShortContent())
    {
      qsj.a(paramppq.a(), paramArticleInfo);
      return;
    }
    a(paramArticleInfo, 2, paramppq);
  }
  
  private void e(ArticleInfo paramArticleInfo, ppq paramppq)
  {
    boolean bool = true;
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2;
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject2 = (QQAppInterface)localObject1;
      localObject1 = new avup();
      if (paramppq.b() != 56) {
        break label143;
      }
      ((avup)localObject1).jdField_b_of_type_JavaLangString = "kandian_video";
      ((avup)localObject1).jdField_a_of_type_JavaLangString = "kandian_video";
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      if (paramArticleInfo.mCommentIconType == 1) {
        localBundle.putBoolean("jump_now_switch", bool);
      }
      try
      {
        localObject2 = (avux)((QQAppInterface)localObject2).getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER);
        localBundle.putString("roomid", paramArticleInfo.mArticleContentUrl);
        localBundle.putString("fromid", ((avup)localObject1).jdField_b_of_type_JavaLangString);
        ((avux)localObject2).a(localBundle);
        pqb.a(paramppq.a(), paramArticleInfo, paramppq.b());
        return;
        label143:
        ((avup)localObject1).jdField_b_of_type_JavaLangString = "kandian_shouye";
        ((avup)localObject1).jdField_a_of_type_JavaLangString = "kandian_shouye";
        continue;
        bool = false;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RIJListViewGroupHandlerClick", 2, "subscribeId to roomId error, " + localNumberFormatException.getMessage());
          }
        }
      }
    }
  }
  
  public void a(int paramInt, ArticleInfo paramArticleInfo, HashMap<String, Integer> paramHashMap, ppq paramppq)
  {
    int m = 0;
    AladdinConfig localAladdinConfig;
    int k;
    int j;
    if ((!bdvn.a()) && (!paramArticleInfo.hasSearchWordInfo()) && ((ppe.a(paramArticleInfo) == 3) || (ppe.a(paramArticleInfo) == 1)) && (paramArticleInfo.mIsShowSearchord == 1))
    {
      localAladdinConfig = Aladdin.getConfig(201);
      if (localAladdinConfig == null) {
        break label213;
      }
      k = localAladdinConfig.getIntegerFromString("feeds_searchterm", 0);
      j = localAladdinConfig.getIntegerFromString("feeds_searchterm_max", 1000);
    }
    for (int i = localAladdinConfig.getIntegerFromString("feeds_pos_range_each_max", 3);; i = 3)
    {
      if (!DateUtils.isToday(bhhr.b("search_word_prefix_last_request_time")))
      {
        bhhr.a("search_word_prefix_last_request_time", System.currentTimeMillis());
        bhhr.a("search_word_prefix_show_times", 0L);
      }
      if (paramHashMap.containsKey(paramArticleInfo.mRefreshTime)) {
        m = ((Integer)paramHashMap.get(paramArticleInfo.mRefreshTime)).intValue();
      }
      if ((m < i) && (bhhr.b("search_word_prefix_show_times") < j) && (k == 1)) {
        ((aogi)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.UNITE_SEARCH_HANDLER)).a(ByteStringMicro.copyFromUtf8(paramArticleInfo.innerUniqueID), new ppp(this, paramHashMap, paramArticleInfo, m, paramppq, paramInt));
      }
      return;
      label213:
      j = 1000;
      k = 0;
    }
  }
  
  public void a(int paramInt, ppq paramppq)
  {
    if ((paramppq.a() instanceof ReadInJoyNewFeedsActivity)) {
      ((ReadInJoyNewFeedsActivity)paramppq.a()).g(paramInt);
    }
    for (;;)
    {
      if (plm.c(paramppq.b())) {
        pin.a(paramInt);
      }
      a(paramppq);
      return;
      if ((paramppq.a() instanceof SplashActivity))
      {
        ReadinjoyTabFrame localReadinjoyTabFrame = pqx.a(paramppq.a());
        if (localReadinjoyTabFrame != null) {
          localReadinjoyTabFrame.a(paramInt);
        }
      }
    }
  }
  
  public void a(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof rbp)) {
      ((rbp)paramView).b();
    }
  }
  
  public void a(View paramView, ArticleInfo paramArticleInfo, int paramInt, ppq paramppq)
  {
    if (paramInt == 2) {
      a(paramView, paramArticleInfo, paramppq);
    }
    while (paramInt != 1) {
      return;
    }
    d(paramArticleInfo, paramppq);
  }
  
  public void a(ArticleInfo paramArticleInfo, int paramInt, ppq paramppq)
  {
    if (paramInt == 1) {
      pqx.a(paramppq.a(), paramArticleInfo, false);
    }
    while (paramInt != 2) {
      return;
    }
    if ((ppe.d(paramArticleInfo)) && (ppe.c(paramArticleInfo)))
    {
      a(paramArticleInfo, paramppq);
      return;
    }
    pqx.a(paramppq.a(), paramArticleInfo, 3);
  }
  
  public void a(ArticleInfo paramArticleInfo, View paramView, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, ppq paramppq)
  {
    if (paramArticleInfo.mFeedType == 2) {
      return;
    }
    if (paramppq.b() == 0)
    {
      JumpMode localJumpMode = six.a(paramppq.a(), paramArticleInfo);
      if (localJumpMode != JumpMode.FAIL)
      {
        pqb.a(paramArticleInfo, paramppq.a(), paramppq.b(), localJumpMode);
        return;
      }
    }
    if ((paramppq.b() != 0) || (pqw.i(paramArticleInfo)) || (pqw.m(paramArticleInfo)) || (pqw.n(paramArticleInfo)))
    {
      if (pqw.n(paramArticleInfo)) {
        a(paramArticleInfo, (rpt)paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(paramInt3), paramView, paramppq.b(), paramppq.a());
      }
      for (;;)
      {
        pvj.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
        if (!(paramView instanceof ComponentContentVerticalSmallVideo)) {
          paramppq.a().notifyDataSetChanged();
        }
        if (!pqw.l(paramArticleInfo)) {
          break;
        }
        paramView = uvs.a(paramppq.a(), paramArticleInfo.mVideoAdsSource, paramInt3, paramArticleInfo.getInnerUniqueID(), 54, uvs.a(paramArticleInfo), paramArticleInfo.videoReportInfo);
        olh.a(null, "CliOper", "", String.valueOf(paramArticleInfo.mPolymericInfo.jdField_b_of_type_Long), "0X8008D33", "0X8008D33", 0, 0, Long.toString(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), paramView, false);
        pqb.a(paramArticleInfo, paramInt3);
        return;
        a(paramArticleInfo, paramView, paramppq);
      }
    }
    pvj.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    paramInt3 = -1;
    if (paramArticleInfo.videoJumpChannelID > 0) {
      if (paramArticleInfo.videoJumpChannelID == 56)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.videoanimation", 2, " init translation animation for viewTop:" + paramInt1 + "view left:" + paramInt2 + "isFromItemClick:" + paramBoolean);
        }
        a(paramppq.a(), paramppq.a(), paramArticleInfo, paramInt1, paramInt2, paramBoolean);
        label361:
        paramInt1 = paramArticleInfo.videoJumpChannelID;
        pqb.a(paramArticleInfo, paramppq.a(), paramppq.b());
      }
    }
    for (;;)
    {
      if (paramInt1 != -1)
      {
        paramView = new rqg();
        paramView.jdField_a_of_type_Int = paramInt1;
        omx.a(paramArticleInfo, paramppq.b(), 24, -1L, paramView);
      }
      if ((ppe.a(paramArticleInfo) == 6) || (ppe.a(paramArticleInfo) == 28)) {
        break;
      }
      paramppq.a().notifyDataSetChanged();
      return;
      paramView = new HashMap();
      paramView.put("param_key_insert_article_id", Long.valueOf(paramArticleInfo.mArticleID));
      osg.b(paramppq.a(), paramArticleInfo.videoJumpChannelID, paramArticleInfo.videoJumpChannelName, paramArticleInfo.videoJumpChannelType, 5, paramView);
      break label361;
      if (bmhv.d(BaseApplicationImpl.getApplication().getRuntime()) == 1)
      {
        a(paramppq.a(), paramppq.a(), paramArticleInfo, paramInt1, paramInt2, paramBoolean);
        pqb.a(paramArticleInfo, paramppq.a(), paramppq.b());
        paramInt1 = 56;
      }
      else
      {
        a(paramArticleInfo, paramView, paramppq);
        paramInt1 = paramInt3;
      }
    }
  }
  
  public void a(ArticleInfo paramArticleInfo, View paramView, ppq paramppq)
  {
    if (pqw.g(paramArticleInfo))
    {
      a(paramArticleInfo, paramView, paramppq.b(), paramppq.a());
      return;
    }
    spk localspk = new spk();
    localspk.jdField_c_of_type_Long = paramArticleInfo.mArticleID;
    localspk.jdField_e_of_type_Long = paramArticleInfo.mXGFileSize;
    localspk.jdField_h_of_type_JavaLangString = paramArticleInfo.thirdUin;
    localspk.jdField_i_of_type_JavaLangString = paramArticleInfo.thirdUinName;
    localspk.jdField_k_of_type_JavaLangString = paramArticleInfo.mSubscribeID;
    localspk.jdField_g_of_type_Int = paramArticleInfo.mStrategyId;
    localspk.jdField_g_of_type_Long = paramArticleInfo.mAlgorithmID;
    rqa localrqa = new rqa();
    localrqa.jdField_a_of_type_JavaLangLong = Long.valueOf(paramArticleInfo.mArticleID);
    localrqa.jdField_a_of_type_JavaLangString = paramArticleInfo.innerUniqueID;
    label411:
    Object localObject;
    if (((!ppe.g(paramArticleInfo)) && (!ppe.i(paramArticleInfo)) && (!ppe.j(paramArticleInfo)) && (!ppe.k(paramArticleInfo))) || ((!ppe.q(paramArticleInfo)) || ((pqw.l(paramArticleInfo)) && (!ppe.q(paramArticleInfo)))))
    {
      localspk.jdField_f_of_type_Int = ((rrs)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.b.get(0)).jdField_f_of_type_Int;
      localspk.jdField_c_of_type_Int = ((rrs)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.b.get(0)).jdField_a_of_type_Int;
      localspk.jdField_d_of_type_Int = ((rrs)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.b.get(0)).jdField_b_of_type_Int;
      localrqa.jdField_a_of_type_Int = ((rrs)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.b.get(0)).jdField_f_of_type_Int;
      localspk.jdField_b_of_type_Int = ((int)(((rrs)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.b.get(0)).jdField_a_of_type_Long / 1000L));
      localspk.jdField_b_of_type_JavaLangString = ((rrs)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.b.get(0)).jdField_d_of_type_JavaLangString;
      localspk.jdField_j_of_type_JavaLangString = ((rrs)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.b.get(0)).jdField_g_of_type_JavaLangString;
      localspk.jdField_c_of_type_JavaLangString = ((rrs)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.b.get(0)).jdField_i_of_type_JavaLangString;
      if ((pqw.i(paramArticleInfo)) && (pqw.a(paramArticleInfo)) && (paramArticleInfo.mPolymericSmallVideoCoverUrl != null))
      {
        localspk.jdField_b_of_type_JavaLangString = paramArticleInfo.mPolymericSmallVideoCoverUrl.getFile();
        localrqa.jdField_b_of_type_JavaLangString = paramArticleInfo.mVideoVid;
        localspk.a = localrqa;
        localspk.jdField_d_of_type_JavaLangString = paramArticleInfo.thirdIcon;
        localspk.jdField_e_of_type_JavaLangString = paramArticleInfo.thirdName;
        localspk.jdField_f_of_type_JavaLangString = paramArticleInfo.thirdAction;
        if (paramView != null)
        {
          localObject = new int[2];
          paramView.getLocationOnScreen((int[])localObject);
          localspk.jdField_h_of_type_Int = localObject[0];
          localspk.jdField_i_of_type_Int = localObject[1];
          localspk.jdField_j_of_type_Int = paramView.getWidth();
          localspk.jdField_k_of_type_Int = paramView.getHeight();
          if (((paramView instanceof ComponentContentVerticalSmallVideo)) && (((ComponentContentVerticalSmallVideo)paramView).jdField_a_of_type_Boolean))
          {
            localObject = pjr.a(3, paramppq.b());
            int i = localspk.jdField_h_of_type_Int;
            localspk.jdField_h_of_type_Int = ((localspk.jdField_j_of_type_Int - ((Integer)((Pair)localObject).first).intValue()) / 2 + i);
            localspk.jdField_j_of_type_Int = ((Integer)((Pair)localObject).first).intValue();
          }
          six.a(localspk, paramView);
        }
        localObject = new rqg();
        ((rqg)localObject).jdField_a_of_type_Int = 409409;
        if (paramppq.b() != 56) {
          break label841;
        }
      }
    }
    for (;;)
    {
      if (paramppq.b() == 0) {
        omx.a(paramArticleInfo, paramppq.b(), 24, -1L, (rqg)localObject);
      }
      pvj.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      if ((paramView instanceof ComponentContentVerticalSmallVideo)) {
        break;
      }
      paramppq.a().notifyDataSetChanged();
      return;
      localspk.jdField_b_of_type_JavaLangString = ((rrs)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.b.get(0)).jdField_d_of_type_JavaLangString;
      break label411;
      if ((pqw.i(paramArticleInfo)) && (pqw.a(paramArticleInfo)) && (paramArticleInfo.mPolymericSmallVideoCoverUrl != null))
      {
        localspk.jdField_b_of_type_JavaLangString = paramArticleInfo.mPolymericSmallVideoCoverUrl.getFile();
        localspk.jdField_c_of_type_JavaLangString = paramArticleInfo.mVideoVid;
        localspk.jdField_f_of_type_Int = paramArticleInfo.busiType;
        localspk.jdField_c_of_type_Int = paramArticleInfo.mVideoJsonWidth;
        localspk.jdField_d_of_type_Int = paramArticleInfo.mVideoJsonHeight;
        localrqa.jdField_a_of_type_Int = paramArticleInfo.busiType;
        localspk.jdField_b_of_type_Int = paramArticleInfo.mVideoDuration;
        localspk.jdField_j_of_type_JavaLangString = paramArticleInfo.innerUniqueID;
        localspk.jdField_g_of_type_JavaLangString = paramArticleInfo.mThirdVideoURL;
        localspk.jdField_f_of_type_Long = paramArticleInfo.mThirdVideoURLExpireTime;
        break label411;
      }
      if (paramArticleInfo.mVideoCoverUrl == null) {}
      for (localObject = null;; localObject = paramArticleInfo.mVideoCoverUrl.getFile())
      {
        localspk.jdField_b_of_type_JavaLangString = ((String)localObject);
        break;
      }
      label841:
      paramppq.a().a(localspk, paramArticleInfo);
    }
  }
  
  public void a(ArticleInfo paramArticleInfo, ppq paramppq)
  {
    if (paramArticleInfo == null) {
      return;
    }
    if (pqw.a(paramArticleInfo.mArticleContentUrl, paramArticleInfo.mChannelID, paramArticleInfo)) {
      b(paramArticleInfo, paramppq);
    }
    for (;;)
    {
      uvs.a(paramArticleInfo);
      return;
      pqx.a(paramppq.a(), paramArticleInfo, paramppq.a(), paramppq.b());
    }
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    if (plm.c(paramInt))
    {
      paramBaseArticleInfo.mJumpType = 1;
      bmhv.a(paramBaseArticleInfo);
    }
  }
  
  public void a(ppq paramppq)
  {
    Object localObject = paramppq.a().getItem(0);
    if ((paramppq.b() == 0) && ((localObject instanceof ArticleInfo)))
    {
      localObject = (ArticleInfo)localObject;
      paramppq.a(NetConnInfoCenter.getServerTime());
      paramppq.a((ArticleInfo)localObject);
      localObject = uuc.b((QQAppInterface)pkh.a(), paramppq.a());
      String str = uuc.a(paramppq.a());
      uuc.a(pnn.b(), str, String.valueOf(paramppq.a()), (String)localObject, true);
    }
  }
  
  @VisibleForTesting
  boolean a(ArticleInfo paramArticleInfo)
  {
    return (ppe.a(paramArticleInfo)) || (ppe.h(paramArticleInfo)) || (pqw.c(paramArticleInfo)) || (pqw.d(paramArticleInfo)) || (pqw.f(paramArticleInfo)) || (pqw.g(paramArticleInfo));
  }
  
  @VisibleForTesting
  boolean a(ArticleInfo paramArticleInfo, int paramInt)
  {
    return (rjl.b(paramInt)) || (ppe.i(paramArticleInfo)) || (ppe.g(paramArticleInfo)) || (ppe.j(paramArticleInfo)) || (ppe.k(paramArticleInfo));
  }
  
  public boolean a(BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, pko<Integer> parampko, ArticleInfo paramArticleInfo, ppq paramppq, Handler paramHandler)
  {
    boolean bool;
    if (ppe.a(paramArticleInfo))
    {
      pqx.b(paramppq.a(), paramArticleInfo, 6);
      pqb.a(paramppq.a(), paramArticleInfo, paramppq.b());
      paramBaseArticleInfo = "clickCommentBiuCard";
      bool = false;
    }
    for (;;)
    {
      QLog.d("RIJListViewGroupHandlerClick", 1, "onItemClickPartOwn, jumpTarget= " + paramBaseArticleInfo);
      return bool;
      if (pqw.l(paramArticleInfo))
      {
        a(paramArticleInfo, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt, paramppq);
        parampko.a(Integer.valueOf(4));
        paramBaseArticleInfo = "handleVideoFeedsClickJump";
        bool = false;
      }
      else if (paramArticleInfo.mFeedType == 3)
      {
        e(paramArticleInfo, paramppq);
        paramBaseArticleInfo = "onNowFeedsClick";
        bool = false;
      }
      else if (paramArticleInfo.mFeedType == 13)
      {
        a(paramArticleInfo, paramppq.a(), paramppq.b());
        paramBaseArticleInfo = "onQEGameClick";
        bool = false;
      }
      else if ((paramArticleInfo.mFeedType == 22) || (paramArticleInfo.mFeedType == 21) || (pqw.o(paramArticleInfo)))
      {
        pqx.a(paramppq.a(), paramArticleInfo, 4, false, 3, false);
        paramBaseArticleInfo = "jumpNewSocialSecondPage";
        bool = false;
      }
      else if (ppe.b(paramArticleInfo))
      {
        a(paramBaseArticleInfo, paramView, paramArticleInfo, paramppq.a());
        paramBaseArticleInfo = "onPgcShortContentClick";
        bool = false;
      }
      else if ((ppe.a(paramArticleInfo)) && (ppe.c(paramArticleInfo)))
      {
        a(paramArticleInfo, paramppq);
        paramBaseArticleInfo = "jumpArticleDetail";
        bool = false;
      }
      else if (ppe.a(paramArticleInfo))
      {
        pqx.a(paramppq.a(), paramArticleInfo, 1, false, 4, false);
        paramBaseArticleInfo = "RIJItemViewType -> jumpNewSocialSecondPage";
        bool = false;
      }
      else if (ppe.a(paramArticleInfo) == 71)
      {
        a(paramView, paramInt, paramArticleInfo, paramppq);
        parampko.a(Integer.valueOf(4));
        paramBaseArticleInfo = "onUgcVideoAsPgcClick";
        bool = false;
      }
      else if ((ppe.g(paramArticleInfo)) || (ppe.j(paramArticleInfo)))
      {
        pqx.a(paramppq.a(), paramArticleInfo, 4, false, 3, false);
        pqb.b(paramArticleInfo, paramppq.b());
        paramBaseArticleInfo = "isUGC->jumpNewSocialSecondPage";
        bool = false;
      }
      else if ((pqw.c(paramArticleInfo)) || (pqw.d(paramArticleInfo)))
      {
        pqx.a(paramppq.a(), paramArticleInfo, 1, false, 4, false);
        pqb.b(paramArticleInfo, paramppq.b());
        pqb.c(paramArticleInfo, paramppq.b());
        paramBaseArticleInfo = "isTopicRecommend->jumpNewSocialSecondPage";
        bool = false;
      }
      else if (pqw.a(paramArticleInfo))
      {
        a(paramArticleInfo, 1, paramppq);
        pih.a(paramppq.a(), paramArticleInfo, paramppq.a());
        parampko.a(Integer.valueOf(2));
        paramBaseArticleInfo = "jumpSocialDetailPageWhenClick";
        bool = false;
      }
      else
      {
        bool = b(paramBaseArticleInfo, paramView, paramInt, parampko, paramArticleInfo, paramppq, paramHandler);
        paramBaseArticleInfo = "onItemClickPartTwo";
      }
    }
  }
  
  public void b(ArticleInfo paramArticleInfo, ppq paramppq)
  {
    tko.b("fast_web_show_light_house_1");
    qfg localqfg = pvj.a().a();
    ArticleInfo localArticleInfo = paramArticleInfo;
    if (pqw.g(paramArticleInfo))
    {
      localArticleInfo = paramArticleInfo;
      if (!paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean) {
        localArticleInfo = a(paramArticleInfo);
      }
    }
    if (localqfg != null) {
      paramppq.b(localqfg.a(localArticleInfo.mArticleContentUrl, String.valueOf(localArticleInfo.innerUniqueID), localArticleInfo.mSubscribeID, 1, null));
    }
    b(localArticleInfo, paramppq.a(), paramppq.b(), paramppq.a());
  }
  
  @VisibleForTesting
  boolean b(ArticleInfo paramArticleInfo, int paramInt)
  {
    return (paramInt == 11) || (paramInt == 28) || (ppe.b(paramArticleInfo) == 23) || (ppe.c(paramArticleInfo) == 56);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ppo
 * JD-Core Version:    0.7.0.1
 */