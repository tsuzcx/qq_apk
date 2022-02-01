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
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

public class pgk
{
  public static ArticleInfo a(ArticleInfo paramArticleInfo)
  {
    ArticleInfo localArticleInfo = new ArticleInfo();
    localArticleInfo.mChannelID = paramArticleInfo.mChannelID;
    rdn localrdn = (rdn)paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
    localArticleInfo.mStrategyId = localrdn.jdField_a_of_type_Int;
    localArticleInfo.mAlgorithmID = localrdn.jdField_b_of_type_Long;
    localArticleInfo.mTitle = localrdn.jdField_a_of_type_JavaLangString;
    localArticleInfo.mFirstPagePicUrl = localrdn.jdField_c_of_type_JavaLangString;
    localArticleInfo.mArticleContentUrl = localrdn.jdField_d_of_type_JavaLangString;
    localArticleInfo.mArticleID = localrdn.jdField_a_of_type_Long;
    localArticleInfo.mSubscribeID = localrdn.jdField_e_of_type_JavaLangString;
    localArticleInfo.mSubscribeName = localrdn.jdField_f_of_type_JavaLangString;
    localArticleInfo.innerUniqueID = localrdn.jdField_g_of_type_JavaLangString;
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
    localIntent.putExtra("channel_name", amtj.a(2131712180));
    localIntent.putExtra("channel_type", 3);
    localIntent.putExtra("channel_from", paramInt3);
    localIntent.putExtra("is_channel_activity", true);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", paramArticleInfo.mArticleID);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", paramArticleInfo.mRecommendSeq);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", true);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", true);
    boolean bool;
    if (!pgb.q(paramArticleInfo))
    {
      bool = true;
      localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_IS_UGC_VIDEO", bool);
      localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_INFO", paramArticleInfo);
      paramInt3 = pgb.a(paramArticleInfo);
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
      ofe.a.put(ReadInJoyChannelActivity.class, ofe.b());
      sek.a().a(false, "jumpFromKandianFeed", 1);
      return;
      bool = false;
      break;
      label243:
      if (paramBaseAdapter != null) {
        paramBaseAdapter.notifyDataSetChanged();
      }
    }
  }
  
  private void a(View paramView, int paramInt, ArticleInfo paramArticleInfo, pgm parampgm)
  {
    if ((paramView instanceof ProteusItemView)) {
      a((ProteusItemView)paramView, parampgm.a());
    }
    for (;;)
    {
      a(paramArticleInfo, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt, parampgm);
      return;
      if ((paramView instanceof LinearLayout)) {
        a((LinearLayout)paramView, parampgm.a());
      }
    }
  }
  
  private void a(View paramView, int paramInt, ArticleInfo paramArticleInfo, pgm parampgm, Handler paramHandler)
  {
    if (a(paramArticleInfo, paramView))
    {
      pay.b(parampgm.a(), paramArticleInfo, parampgm.b());
      QLog.d("RIJListViewGroupHandlerClick", 2, "main feeds hit Gallery feeds");
    }
    for (;;)
    {
      pkm.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      if (parampgm.a() != null) {}
      try
      {
        if (!TextUtils.isEmpty(tgc.b(paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8())))
        {
          paramView = paramHandler;
          if (paramHandler == null) {
            paramView = new Handler(Looper.getMainLooper());
          }
          paramView.postDelayed(new RIJListViewGroupHandlerClick.1(this, parampgm), 2000L);
          return;
          b(paramArticleInfo, paramInt - 1, parampgm);
        }
        else
        {
          parampgm.a().notifyDataSetChanged();
          return;
        }
      }
      catch (Exception paramView)
      {
        parampgm.a().notifyDataSetChanged();
      }
    }
  }
  
  private void a(View paramView, ArticleInfo paramArticleInfo, pgm parampgm)
  {
    if (pgb.c(paramArticleInfo))
    {
      a(paramArticleInfo, parampgm);
      return;
    }
    pay.a(parampgm.a(), paramArticleInfo, 1, false, 4, false);
  }
  
  private void a(LinearLayout paramLinearLayout, Activity paramActivity)
  {
    paramLinearLayout = (TextView)paramLinearLayout.findViewById(2131364958);
    if (paramLinearLayout != null)
    {
      paramLinearLayout.setTextColor(paramActivity.getResources().getColor(2131166477));
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
      paramProteusItemView.setTextColor(paramActivity.getResources().getColor(2131166477));
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
    pay.b(paramActivity, paramArticleInfo, paramInt);
  }
  
  private void a(ArticleInfo paramArticleInfo, Activity paramActivity, int paramInt, slt paramslt)
  {
    if ((!AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) && (paramslt != null) && (!pgb.a(paramArticleInfo))) {
      pay.a(paramActivity, paramArticleInfo, paramslt, paramInt);
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, View paramView, int paramInt, slt paramslt)
  {
    if ((paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList == null) || (paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.size() <= 0))
    {
      QLog.e("RIJListViewGroupHandlerClick", 1, "handleJumpFullVideoPlayForNewPolymeric, bad data need backend check");
      return;
    }
    a(paramArticleInfo, (rdn)paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0), paramView, paramInt, paramslt);
  }
  
  private void a(ArticleInfo paramArticleInfo, rdn paramrdn, View paramView, int paramInt, slt paramslt)
  {
    sdg localsdg = new sdg();
    if (paramrdn.jdField_a_of_type_Rdq == null) {
      QLog.e("handleJumpFullVideoPlayForNewPolymeric", 2, " bad data need backend check");
    }
    do
    {
      return;
      localsdg.jdField_c_of_type_Long = paramrdn.jdField_a_of_type_Long;
      localsdg.jdField_h_of_type_JavaLangString = (paramrdn.jdField_a_of_type_Rdq.jdField_b_of_type_Long + "");
      localsdg.jdField_i_of_type_JavaLangString = paramrdn.jdField_a_of_type_Rdq.jdField_d_of_type_JavaLangString;
      localsdg.jdField_k_of_type_JavaLangString = paramrdn.jdField_e_of_type_JavaLangString;
      localsdg.jdField_g_of_type_Int = paramrdn.jdField_a_of_type_Int;
      localsdg.jdField_g_of_type_Long = paramrdn.jdField_b_of_type_Long;
      Object localObject = new rdt();
      ((rdt)localObject).jdField_a_of_type_JavaLangLong = Long.valueOf(paramrdn.jdField_a_of_type_Long);
      ((rdt)localObject).jdField_a_of_type_JavaLangString = paramrdn.jdField_g_of_type_JavaLangString;
      ((rdt)localObject).jdField_a_of_type_Int = paramrdn.jdField_a_of_type_Rdq.jdField_a_of_type_Int;
      ((rdt)localObject).jdField_b_of_type_JavaLangString = paramrdn.jdField_a_of_type_Rdq.jdField_a_of_type_JavaLangString;
      localsdg.a = ((rdt)localObject);
      localsdg.jdField_b_of_type_JavaLangString = paramrdn.jdField_c_of_type_JavaLangString;
      localsdg.jdField_c_of_type_JavaLangString = paramrdn.jdField_a_of_type_Rdq.jdField_a_of_type_JavaLangString;
      localsdg.jdField_f_of_type_Int = paramrdn.jdField_a_of_type_Rdq.jdField_a_of_type_Int;
      localsdg.jdField_c_of_type_Int = paramrdn.jdField_a_of_type_Rdq.jdField_b_of_type_Int;
      localsdg.jdField_d_of_type_Int = paramrdn.jdField_a_of_type_Rdq.jdField_c_of_type_Int;
      localsdg.jdField_b_of_type_Int = paramrdn.jdField_a_of_type_Rdq.jdField_d_of_type_Int;
      localsdg.jdField_e_of_type_Long = paramrdn.jdField_a_of_type_Rdq.jdField_a_of_type_Long;
      localsdg.jdField_j_of_type_JavaLangString = paramrdn.jdField_g_of_type_JavaLangString;
      localsdg.jdField_g_of_type_JavaLangString = paramrdn.jdField_a_of_type_Rdq.jdField_b_of_type_JavaLangString;
      localsdg.jdField_d_of_type_JavaLangString = paramrdn.jdField_a_of_type_Rdq.jdField_f_of_type_JavaLangString;
      localsdg.jdField_e_of_type_JavaLangString = paramrdn.jdField_a_of_type_Rdq.jdField_e_of_type_JavaLangString;
      localsdg.jdField_f_of_type_JavaLangString = paramrdn.jdField_a_of_type_Rdq.jdField_g_of_type_JavaLangString;
      if (paramView != null)
      {
        localObject = new int[2];
        paramView.getLocationOnScreen((int[])localObject);
        localsdg.jdField_h_of_type_Int = localObject[0];
        localsdg.jdField_i_of_type_Int = localObject[1];
        localsdg.jdField_j_of_type_Int = paramView.getWidth();
        localsdg.jdField_k_of_type_Int = paramView.getHeight();
        if (((paramView instanceof ComponentContentVerticalSmallVideo)) && (((ComponentContentVerticalSmallVideo)paramView).jdField_a_of_type_Boolean))
        {
          localObject = pai.a(3, paramInt);
          int i = localsdg.jdField_h_of_type_Int;
          localsdg.jdField_h_of_type_Int = ((localsdg.jdField_j_of_type_Int - ((Integer)((Pair)localObject).first).intValue()) / 2 + i);
          localsdg.jdField_j_of_type_Int = ((Integer)((Pair)localObject).first).intValue();
        }
      }
      localObject = new rdz();
      ((rdz)localObject).jdField_a_of_type_Int = 409409;
      paramslt.a(localsdg, paramArticleInfo);
      if (paramInt == 0) {
        ofe.a(paramrdn.jdField_a_of_type_Long, paramrdn.jdField_g_of_type_JavaLangString, paramInt, (int)paramrdn.jdField_b_of_type_Long, paramrdn.jdField_a_of_type_Int, 24, -1L, (rdz)localObject, -1, paramrdn.jdField_k_of_type_JavaLangString);
      }
      pkm.a().a(paramrdn.jdField_a_of_type_Long, System.currentTimeMillis());
    } while ((paramView instanceof ComponentContentVerticalSmallVideo));
    paramslt.notifyDataSetChanged();
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo, View paramView, ArticleInfo paramArticleInfo, Activity paramActivity)
  {
    if (a(paramArticleInfo, paramView))
    {
      QLog.d("RIJListViewGroupHandlerClick", 2, "main feeds hit ShortContent feeds");
      QLog.d("RIJListViewGroupHandlerClick", 1, "tryJumpToUgUrl: true");
      paramArticleInfo.clickJumpTarget = qgg.a(ozp.a(paramArticleInfo), "-1");
    }
    for (;;)
    {
      paramBaseArticleInfo.clickArea = 7;
      pay.b(paramActivity, paramArticleInfo, (int)paramBaseArticleInfo.mChannelID);
      return;
      QLog.d("RIJListViewGroupHandlerClick", 1, "short content redirectToOtherPage");
      qgg.a(paramActivity, paramArticleInfo);
    }
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo, View paramView, ArticleInfo paramArticleInfo, pgm parampgm)
  {
    if (paramBaseArticleInfo.isAccountShown) {
      paramBaseArticleInfo.clickArea = 7;
    }
    if (a(paramArticleInfo, paramView))
    {
      QLog.d("RIJListViewGroupHandlerClick", 2, "main feeds hit ug normal feeds");
      pkm.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      parampgm.a().notifyDataSetChanged();
      paramBaseArticleInfo.clickJumpTarget = qgg.a(ozp.a(paramArticleInfo), "-1");
      pay.b(parampgm.a(), paramArticleInfo, parampgm.b());
      return;
    }
    if (a(paramArticleInfo, paramView, parampgm))
    {
      QLog.d("RIJListViewGroupHandlerClick", 2, "main feeds hit srt normal feeds");
      paramBaseArticleInfo.clickJumpTarget = qgg.a(pau.a().a(), "-1");
      return;
    }
    if ((!rbt.c(paramArticleInfo)) && (!pau.a().a()) && (pay.a(paramView.getContext(), paramArticleInfo)))
    {
      pay.b(parampgm.a(), paramArticleInfo, parampgm.b());
      pkm.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      parampgm.a().notifyDataSetChanged();
      parampgm = pay.i(paramArticleInfo.getInnerUniqueID());
      paramBaseArticleInfo.clickJumpTarget = qgg.a(parampgm, "-1");
      pay.a(paramView.getContext(), paramArticleInfo, parampgm);
      return;
    }
    if (prw.a(paramView.getContext(), paramArticleInfo.mArticleContentUrl))
    {
      pay.b(parampgm.a(), paramArticleInfo, parampgm.b());
      pkm.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      parampgm.a().notifyDataSetChanged();
      return;
    }
    paramBaseArticleInfo.clickJumpTarget = qgg.a("", "3");
    b(paramArticleInfo, parampgm);
  }
  
  private boolean a(ArticleInfo paramArticleInfo, View paramView)
  {
    String str = ozp.a(paramArticleInfo);
    if (!TextUtils.isEmpty(str))
    {
      if (rbt.a(str)) {
        pay.a(paramView.getContext(), paramArticleInfo, str);
      }
      for (;;)
      {
        QLog.d("RIJListViewGroupHandlerClick", 1, "UGRuleManager articleInfo hit ug title" + paramArticleInfo.mTitle);
        return true;
        rwv.a(BaseApplicationImpl.getApplication(), str);
      }
    }
    return false;
  }
  
  private boolean a(ArticleInfo paramArticleInfo, View paramView, pgm parampgm)
  {
    if (rbt.c(paramArticleInfo)) {}
    boolean bool;
    String str;
    do
    {
      return false;
      bool = pau.a().a(paramArticleInfo, null, null);
      str = pau.a().a();
    } while ((!bool) || (TextUtils.isEmpty(str)));
    pkm.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    parampgm.a().notifyDataSetChanged();
    pay.b(parampgm.a(), paramArticleInfo, parampgm.b());
    pay.a(paramView.getContext(), paramArticleInfo, str);
    return true;
  }
  
  private boolean a(BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, ArticleInfo paramArticleInfo, pgm parampgm)
  {
    if ((paramArticleInfo.isTwoItemVideoFeed()) && (paramArticleInfo.mFeedType != 36))
    {
      QLog.d("Q.readinjoy.video", 2, "JumpAndForceInsert onVideoArticleClick() RETURN article.mArticleID:" + paramArticleInfo.mArticleID + " article.mTitle:" + paramArticleInfo.mTitle);
      return true;
    }
    if (pgb.a(paramArticleInfo) == 6)
    {
      if ((paramView instanceof ProteusItemView)) {
        a((ProteusItemView)paramView, parampgm.a());
      }
    }
    else
    {
      if (!a(paramArticleInfo, paramView)) {
        break label297;
      }
      QLog.d("RIJListViewGroupHandlerClick", 2, "main feeds hit ug video feeds");
      pkm.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      parampgm.a().notifyDataSetChanged();
      pay.b(parampgm.a(), paramArticleInfo, parampgm.b());
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
      a((LinearLayout)paramView, parampgm.a());
      break;
      label297:
      if (a(paramArticleInfo, paramView, parampgm))
      {
        QLog.d("RIJListViewGroupHandlerClick", 2, "main feeds hit srt video feeds");
      }
      else if (paramBaseArticleInfo.isAccountShown)
      {
        paramBaseArticleInfo.clickArea = 7;
        paramBaseArticleInfo.clickJumpTarget = qgg.a("", "3");
        b(paramArticleInfo, parampgm);
      }
      else
      {
        a(paramArticleInfo, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt, parampgm);
      }
    }
  }
  
  private void b(ArticleInfo paramArticleInfo, int paramInt, pgm parampgm)
  {
    if ((paramArticleInfo != null) && (!TextUtils.isEmpty(paramArticleInfo.innerUniqueID)))
    {
      pay.b(parampgm.a(), paramArticleInfo, parampgm.b());
      if (parampgm.a().a(parampgm.b(), paramArticleInfo.mArticleID)) {}
      pay.b(paramArticleInfo);
      if ((paramArticleInfo.mGalleryFeedsInfo != null) && (paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.has()) && (!TextUtils.isEmpty(paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8())))
      {
        str = paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8();
        localBundle = new Bundle();
        localBundle.putString("big_brother_source_key", pay.f(0));
        pay.a(parampgm.a(), str, localBundle);
        ozb.a(parampgm.a(), paramArticleInfo, parampgm.a());
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
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfn != null) && (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfn.jdField_k_of_type_JavaLangString)))
    {
      pay.b(paramActivity, paramArticleInfo, paramInt);
      pay.c(paramActivity, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfn.jdField_k_of_type_JavaLangString);
      pkm.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    }
  }
  
  private void b(ArticleInfo paramArticleInfo, Activity paramActivity, int paramInt, slt paramslt)
  {
    pay.b(paramActivity, paramArticleInfo, paramInt);
    pkm.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    paramslt.notifyDataSetChanged();
    pay.a(paramActivity, paramArticleInfo);
  }
  
  private void b(pgm parampgm)
  {
    int j = parampgm.a().getCount();
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        Object localObject = parampgm.a().getItem(i);
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
  
  private boolean b(BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, pbn<Integer> parampbn, ArticleInfo paramArticleInfo, pgm parampgm, Handler paramHandler)
  {
    boolean bool = false;
    if ((pgb.i(paramArticleInfo)) || (pgb.k(paramArticleInfo)))
    {
      pay.a(parampgm.a(), paramArticleInfo, 0, false, 1, false);
      pgw.b(paramArticleInfo, parampgm.b());
      paramBaseArticleInfo = "jumpNewSocialSecondPage";
    }
    for (;;)
    {
      QLog.d("RIJListViewGroupHandlerClick", 1, "onItemClickPartTwo, jumpTarget= " + paramBaseArticleInfo);
      return bool;
      if (pgb.h(paramArticleInfo))
      {
        a(paramView, paramArticleInfo, parampgm);
        paramBaseArticleInfo = "onOfficalRecommendClick";
      }
      else
      {
        if (pay.a(paramArticleInfo))
        {
          if (a(paramBaseArticleInfo, paramView, paramInt, paramArticleInfo, parampgm)) {}
          for (bool = true;; bool = false)
          {
            paramBaseArticleInfo = "onVideoArticleClick";
            break;
            parampbn.a(Integer.valueOf(4));
          }
        }
        if (pay.d(paramArticleInfo))
        {
          a(paramView, paramInt, paramArticleInfo, parampgm, paramHandler);
          paramBaseArticleInfo = "onGalleryClick";
        }
        else if ((pay.a(paramArticleInfo.mArticleContentUrl, paramArticleInfo.mChannelID, paramArticleInfo)) || (paramArticleInfo.isAccountShown))
        {
          a(paramBaseArticleInfo, paramView, paramArticleInfo, parampgm);
          parampbn.a(Integer.valueOf(2));
          paramBaseArticleInfo = "onSupportNativeClick";
        }
        else if (paramArticleInfo.mFeedType == 26)
        {
          b(paramArticleInfo, parampgm.a(), parampgm.b());
          paramBaseArticleInfo = "onQuestionClick";
        }
        else if (paramArticleInfo.mFeedType == 23)
        {
          pay.a(parampgm.a(), paramArticleInfo, 1, false, 4, false);
          paramBaseArticleInfo = "FeedsType_PGC_Gallery->jumpNewSocialSecondPage";
        }
        else if (paramArticleInfo.mFeedType == 34)
        {
          pay.a(parampgm.a(), paramArticleInfo.mArticleContentUrl, null);
          pgw.b(paramArticleInfo, parampgm.b());
          paramBaseArticleInfo = "FeedsType_Scrip_Cms";
        }
        else if (paramArticleInfo.mFeedType == 39)
        {
          twr.a(paramArticleInfo, parampgm.a(), paramInt);
          paramBaseArticleInfo = "jumpToMiniGame";
        }
        else
        {
          parampbn.a(Integer.valueOf(2));
          a(paramArticleInfo, parampgm.a(), parampgm.b(), parampgm.a());
          paramBaseArticleInfo = "onAdClick";
        }
      }
    }
  }
  
  private void c(ArticleInfo paramArticleInfo, pgm parampgm)
  {
    boolean bool = true;
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2;
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject2 = (QQAppInterface)localObject1;
      localObject1 = new auou();
      if (parampgm.b() != 56) {
        break label143;
      }
      ((auou)localObject1).jdField_b_of_type_JavaLangString = "kandian_video";
      ((auou)localObject1).jdField_a_of_type_JavaLangString = "kandian_video";
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      if (paramArticleInfo.mCommentIconType == 1) {
        localBundle.putBoolean("jump_now_switch", bool);
      }
      try
      {
        localObject2 = (aupc)((QQAppInterface)localObject2).getManager(306);
        localBundle.putString("roomid", paramArticleInfo.mArticleContentUrl);
        localBundle.putString("fromid", ((auou)localObject1).jdField_b_of_type_JavaLangString);
        ((aupc)localObject2).a(localBundle);
        pay.b(parampgm.a(), paramArticleInfo, parampgm.b());
        return;
        label143:
        ((auou)localObject1).jdField_b_of_type_JavaLangString = "kandian_shouye";
        ((auou)localObject1).jdField_a_of_type_JavaLangString = "kandian_shouye";
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
  
  public void a(int paramInt, ArticleInfo paramArticleInfo, HashMap<String, Integer> paramHashMap, pgm parampgm)
  {
    int m = 0;
    AladdinConfig localAladdinConfig;
    int k;
    int j;
    if ((!bcoo.a()) && (!paramArticleInfo.hasSearchWordInfo()) && ((pgb.a(paramArticleInfo) == 3) || (pgb.a(paramArticleInfo) == 1)) && (paramArticleInfo.mIsShowSearchord == 1))
    {
      localAladdinConfig = Aladdin.getConfig(201);
      if (localAladdinConfig == null) {
        break label212;
      }
      k = localAladdinConfig.getIntegerFromString("feeds_searchterm", 0);
      j = localAladdinConfig.getIntegerFromString("feeds_searchterm_max", 1000);
    }
    for (int i = localAladdinConfig.getIntegerFromString("feeds_pos_range_each_max", 3);; i = 3)
    {
      if (!DateUtils.isToday(bfyz.b("search_word_prefix_last_request_time")))
      {
        bfyz.a("search_word_prefix_last_request_time", System.currentTimeMillis());
        bfyz.a("search_word_prefix_show_times", 0L);
      }
      if (paramHashMap.containsKey(paramArticleInfo.mRefreshTime)) {
        m = ((Integer)paramHashMap.get(paramArticleInfo.mRefreshTime)).intValue();
      }
      if ((m < i) && (bfyz.b("search_word_prefix_show_times") < j) && (k == 1)) {
        ((andr)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(111)).a(ByteStringMicro.copyFromUtf8(paramArticleInfo.innerUniqueID), new pgl(this, paramHashMap, paramArticleInfo, m, parampgm, paramInt));
      }
      return;
      label212:
      j = 1000;
      k = 0;
    }
  }
  
  public void a(int paramInt, pgm parampgm)
  {
    if ((parampgm.a() instanceof ReadInJoyNewFeedsActivity)) {
      ((ReadInJoyNewFeedsActivity)parampgm.a()).g(paramInt);
    }
    for (;;)
    {
      if (pcl.c(parampgm.b())) {
        ozh.a(paramInt);
      }
      a(parampgm);
      return;
      if ((parampgm.a() instanceof SplashActivity))
      {
        ReadinjoyTabFrame localReadinjoyTabFrame = pay.a(parampgm.a());
        if (localReadinjoyTabFrame != null) {
          localReadinjoyTabFrame.a(paramInt);
        }
      }
    }
  }
  
  public void a(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof qpk)) {
      ((qpk)paramView).b();
    }
  }
  
  public void a(View paramView, ArticleInfo paramArticleInfo, int paramInt, pgm parampgm)
  {
    if (paramInt == 2) {
      if (!rwv.a(paramArticleInfo, parampgm.a())) {}
    }
    while (paramInt != 1)
    {
      do
      {
        do
        {
          return;
          paramInt = pgb.a(paramArticleInfo);
          if ((paramInt == 23) || (paramInt == 26) || (paramInt == 56) || (paramInt == 59) || (paramInt == 19) || (paramInt == 17) || (paramInt == 11) || (paramInt == 28))
          {
            a(paramArticleInfo, paramView, parampgm);
            return;
          }
          paramInt = pgb.a(paramArticleInfo);
          if ((qxf.b(paramInt)) || (pgb.i(paramArticleInfo)) || (pgb.g(paramArticleInfo)) || (pgb.j(paramArticleInfo)) || (pgb.k(paramArticleInfo)))
          {
            if ((paramInt == 11) || (paramInt == 28) || (pgb.b(paramArticleInfo) == 23) || (pgb.c(paramArticleInfo) == 56)) {
              a(paramArticleInfo, null, 0, 0, false, 0, parampgm);
            }
            if ((paramInt == 95) || (paramInt == 94)) {
              pay.a(parampgm.a(), paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfi.jdField_a_of_type_JavaLangString);
            }
            for (;;)
            {
              a(parampgm);
              return;
              if (paramArticleInfo.isPGCShortContent()) {
                qgg.a(parampgm.a(), paramArticleInfo);
              } else if (!AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) {
                a(paramArticleInfo, parampgm);
              }
            }
          }
        } while ((!pgb.a(paramArticleInfo)) && (!pgb.h(paramArticleInfo)) && (!pay.c(paramArticleInfo)) && (!pay.d(paramArticleInfo)) && (!pay.f(paramArticleInfo)) && (!pay.g(paramArticleInfo)));
        if (pay.a(paramArticleInfo))
        {
          a(paramArticleInfo, null, 0, 0, false, 0, parampgm);
          return;
        }
        if (paramArticleInfo.isPGCShortContent())
        {
          qgg.a(parampgm.a(), paramArticleInfo);
          return;
        }
      } while (AdvertisementInfo.isAdvertisementInfo(paramArticleInfo));
      a(paramArticleInfo, parampgm);
      return;
    }
    if (paramArticleInfo.isPGCShortContent())
    {
      qgg.a(parampgm.a(), paramArticleInfo);
      return;
    }
    a(paramArticleInfo, 2, parampgm);
  }
  
  public void a(ArticleInfo paramArticleInfo, int paramInt, pgm parampgm)
  {
    if (paramInt == 1) {
      pay.a(parampgm.a(), paramArticleInfo, false);
    }
    while (paramInt != 2) {
      return;
    }
    if ((pgb.d(paramArticleInfo)) && (pgb.c(paramArticleInfo)))
    {
      a(paramArticleInfo, parampgm);
      return;
    }
    pay.a(parampgm.a(), paramArticleInfo, 3);
  }
  
  public void a(ArticleInfo paramArticleInfo, View paramView, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, pgm parampgm)
  {
    if (paramArticleInfo.mFeedType == 2) {
      return;
    }
    if ((parampgm.b() == 0) && (rwv.b(parampgm.a(), paramArticleInfo)))
    {
      pgw.a(paramArticleInfo, parampgm.a(), parampgm.b());
      return;
    }
    if ((parampgm.b() != 0) || (pay.i(paramArticleInfo)) || (pay.m(paramArticleInfo)) || (pay.n(paramArticleInfo)))
    {
      if (pay.n(paramArticleInfo)) {
        a(paramArticleInfo, (rdn)paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(paramInt3), paramView, parampgm.b(), parampgm.a());
      }
      for (;;)
      {
        pkm.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
        if (!(paramView instanceof ComponentContentVerticalSmallVideo)) {
          parampgm.a().notifyDataSetChanged();
        }
        if (!pay.l(paramArticleInfo)) {
          break;
        }
        paramView = uhv.a(parampgm.a(), paramArticleInfo.mVideoAdsSource, paramInt3, paramArticleInfo.getInnerUniqueID(), 54, uhv.a(paramArticleInfo), paramArticleInfo.videoReportInfo);
        odq.a(null, "CliOper", "", String.valueOf(paramArticleInfo.mPolymericInfo.jdField_b_of_type_Long), "0X8008D33", "0X8008D33", 0, 0, Long.toString(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), paramView, false);
        pay.a(paramArticleInfo, paramInt3);
        return;
        a(paramArticleInfo, paramView, parampgm);
      }
    }
    pkm.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    paramInt3 = -1;
    if (paramArticleInfo.videoJumpChannelID > 0) {
      if (paramArticleInfo.videoJumpChannelID == 56)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.videoanimation", 2, " init translation animation for viewTop:" + paramInt1 + "view left:" + paramInt2 + "isFromItemClick:" + paramBoolean);
        }
        a(parampgm.a(), parampgm.a(), paramArticleInfo, paramInt1, paramInt2, paramBoolean);
        label352:
        paramInt1 = paramArticleInfo.videoJumpChannelID;
        pgw.a(paramArticleInfo, parampgm.a(), parampgm.b());
      }
    }
    for (;;)
    {
      if (paramInt1 != -1)
      {
        paramView = new rdz();
        paramView.jdField_a_of_type_Int = paramInt1;
        ofe.a(paramArticleInfo, parampgm.b(), 24, -1L, paramView);
      }
      if ((pgb.a(paramArticleInfo) == 6) || (pgb.a(paramArticleInfo) == 28)) {
        break;
      }
      parampgm.a().notifyDataSetChanged();
      return;
      paramView = new HashMap();
      paramView.put("param_key_insert_article_id", Long.valueOf(paramArticleInfo.mArticleID));
      okj.b(parampgm.a(), paramArticleInfo.videoJumpChannelID, paramArticleInfo.videoJumpChannelName, paramArticleInfo.videoJumpChannelType, 5, paramView);
      break label352;
      if (bkwm.d(BaseApplicationImpl.getApplication().getRuntime()) == 1)
      {
        a(parampgm.a(), parampgm.a(), paramArticleInfo, paramInt1, paramInt2, paramBoolean);
        pgw.a(paramArticleInfo, parampgm.a(), parampgm.b());
        paramInt1 = 56;
      }
      else
      {
        a(paramArticleInfo, paramView, parampgm);
        paramInt1 = paramInt3;
      }
    }
  }
  
  public void a(ArticleInfo paramArticleInfo, View paramView, pgm parampgm)
  {
    if (pay.s(paramArticleInfo))
    {
      a(paramArticleInfo, paramView, parampgm.b(), parampgm.a());
      return;
    }
    sdg localsdg = new sdg();
    localsdg.jdField_c_of_type_Long = paramArticleInfo.mArticleID;
    localsdg.jdField_e_of_type_Long = paramArticleInfo.mXGFileSize;
    localsdg.jdField_h_of_type_JavaLangString = paramArticleInfo.thirdUin;
    localsdg.jdField_i_of_type_JavaLangString = paramArticleInfo.thirdUinName;
    localsdg.jdField_k_of_type_JavaLangString = paramArticleInfo.mSubscribeID;
    localsdg.jdField_g_of_type_Int = paramArticleInfo.mStrategyId;
    localsdg.jdField_g_of_type_Long = paramArticleInfo.mAlgorithmID;
    rdt localrdt = new rdt();
    localrdt.jdField_a_of_type_JavaLangLong = Long.valueOf(paramArticleInfo.mArticleID);
    localrdt.jdField_a_of_type_JavaLangString = paramArticleInfo.innerUniqueID;
    label411:
    Object localObject;
    if (((!pgb.g(paramArticleInfo)) && (!pgb.i(paramArticleInfo)) && (!pgb.j(paramArticleInfo)) && (!pgb.k(paramArticleInfo))) || ((!pgb.q(paramArticleInfo)) || ((pay.l(paramArticleInfo)) && (!pgb.q(paramArticleInfo)))))
    {
      localsdg.jdField_f_of_type_Int = ((rfl)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.b.get(0)).jdField_f_of_type_Int;
      localsdg.jdField_c_of_type_Int = ((rfl)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.b.get(0)).jdField_a_of_type_Int;
      localsdg.jdField_d_of_type_Int = ((rfl)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.b.get(0)).jdField_b_of_type_Int;
      localrdt.jdField_a_of_type_Int = ((rfl)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.b.get(0)).jdField_f_of_type_Int;
      localsdg.jdField_b_of_type_Int = ((int)(((rfl)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.b.get(0)).jdField_a_of_type_Long / 1000L));
      localsdg.jdField_b_of_type_JavaLangString = ((rfl)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.b.get(0)).jdField_d_of_type_JavaLangString;
      localsdg.jdField_j_of_type_JavaLangString = ((rfl)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.b.get(0)).jdField_g_of_type_JavaLangString;
      localsdg.jdField_c_of_type_JavaLangString = ((rfl)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.b.get(0)).jdField_i_of_type_JavaLangString;
      if ((pay.i(paramArticleInfo)) && (pay.a(paramArticleInfo)) && (paramArticleInfo.mPolymericSmallVideoCoverUrl != null))
      {
        localsdg.jdField_b_of_type_JavaLangString = paramArticleInfo.mPolymericSmallVideoCoverUrl.getFile();
        localrdt.jdField_b_of_type_JavaLangString = paramArticleInfo.mVideoVid;
        localsdg.a = localrdt;
        localsdg.jdField_d_of_type_JavaLangString = paramArticleInfo.thirdIcon;
        localsdg.jdField_e_of_type_JavaLangString = paramArticleInfo.thirdName;
        localsdg.jdField_f_of_type_JavaLangString = paramArticleInfo.thirdAction;
        if (paramView != null)
        {
          localObject = new int[2];
          paramView.getLocationOnScreen((int[])localObject);
          localsdg.jdField_h_of_type_Int = localObject[0];
          localsdg.jdField_i_of_type_Int = localObject[1];
          localsdg.jdField_j_of_type_Int = paramView.getWidth();
          localsdg.jdField_k_of_type_Int = paramView.getHeight();
          if (((paramView instanceof ComponentContentVerticalSmallVideo)) && (((ComponentContentVerticalSmallVideo)paramView).jdField_a_of_type_Boolean))
          {
            localObject = pai.a(3, parampgm.b());
            int i = localsdg.jdField_h_of_type_Int;
            localsdg.jdField_h_of_type_Int = ((localsdg.jdField_j_of_type_Int - ((Integer)((Pair)localObject).first).intValue()) / 2 + i);
            localsdg.jdField_j_of_type_Int = ((Integer)((Pair)localObject).first).intValue();
          }
          rwv.a(localsdg, paramView);
        }
        localObject = new rdz();
        ((rdz)localObject).jdField_a_of_type_Int = 409409;
        if (parampgm.b() != 56) {
          break label841;
        }
      }
    }
    for (;;)
    {
      if (parampgm.b() == 0) {
        ofe.a(paramArticleInfo, parampgm.b(), 24, -1L, (rdz)localObject);
      }
      pkm.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      if ((paramView instanceof ComponentContentVerticalSmallVideo)) {
        break;
      }
      parampgm.a().notifyDataSetChanged();
      return;
      localsdg.jdField_b_of_type_JavaLangString = ((rfl)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.b.get(0)).jdField_d_of_type_JavaLangString;
      break label411;
      if ((pay.i(paramArticleInfo)) && (pay.a(paramArticleInfo)) && (paramArticleInfo.mPolymericSmallVideoCoverUrl != null))
      {
        localsdg.jdField_b_of_type_JavaLangString = paramArticleInfo.mPolymericSmallVideoCoverUrl.getFile();
        localsdg.jdField_c_of_type_JavaLangString = paramArticleInfo.mVideoVid;
        localsdg.jdField_f_of_type_Int = paramArticleInfo.busiType;
        localsdg.jdField_c_of_type_Int = paramArticleInfo.mVideoJsonWidth;
        localsdg.jdField_d_of_type_Int = paramArticleInfo.mVideoJsonHeight;
        localrdt.jdField_a_of_type_Int = paramArticleInfo.busiType;
        localsdg.jdField_b_of_type_Int = paramArticleInfo.mVideoDuration;
        localsdg.jdField_j_of_type_JavaLangString = paramArticleInfo.innerUniqueID;
        localsdg.jdField_g_of_type_JavaLangString = paramArticleInfo.mThirdVideoURL;
        localsdg.jdField_f_of_type_Long = paramArticleInfo.mThirdVideoURLExpireTime;
        break label411;
      }
      if (paramArticleInfo.mVideoCoverUrl == null) {}
      for (localObject = null;; localObject = paramArticleInfo.mVideoCoverUrl.getFile())
      {
        localsdg.jdField_b_of_type_JavaLangString = ((String)localObject);
        break;
      }
      label841:
      parampgm.a().a(localsdg, paramArticleInfo);
    }
  }
  
  public void a(ArticleInfo paramArticleInfo, pgm parampgm)
  {
    if (paramArticleInfo == null) {
      return;
    }
    if (pay.a(paramArticleInfo.mArticleContentUrl, paramArticleInfo.mChannelID, paramArticleInfo)) {
      b(paramArticleInfo, parampgm);
    }
    for (;;)
    {
      uhv.a(paramArticleInfo);
      return;
      pay.a(parampgm.a(), paramArticleInfo, parampgm.a(), parampgm.b());
    }
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    if (pcl.c(paramInt))
    {
      paramBaseArticleInfo.mJumpType = 1;
      bkwm.a(paramBaseArticleInfo);
    }
  }
  
  public void a(pgm parampgm)
  {
    Object localObject = parampgm.a().getItem(0);
    if ((parampgm.b() == 0) && ((localObject instanceof ArticleInfo)))
    {
      localObject = (ArticleInfo)localObject;
      parampgm.a(NetConnInfoCenter.getServerTime());
      parampgm.a((ArticleInfo)localObject);
      localObject = ugf.b((QQAppInterface)pay.a(), parampgm.a());
      String str = ugf.a(parampgm.a());
      ugf.a(pem.a(), str, String.valueOf(parampgm.a()), (String)localObject, true);
    }
  }
  
  public boolean a(BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, pbn<Integer> parampbn, ArticleInfo paramArticleInfo, pgm parampgm, Handler paramHandler)
  {
    boolean bool;
    if (pgb.a(paramArticleInfo))
    {
      pay.c(parampgm.a(), paramArticleInfo, 6);
      pay.b(parampgm.a(), paramArticleInfo, parampgm.b());
      paramBaseArticleInfo = "clickCommentBiuCard";
      bool = false;
    }
    for (;;)
    {
      QLog.d("RIJListViewGroupHandlerClick", 1, "onItemClickPartOwn, jumpTarget= " + paramBaseArticleInfo);
      return bool;
      if (pay.l(paramArticleInfo))
      {
        a(paramArticleInfo, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt, parampgm);
        parampbn.a(Integer.valueOf(4));
        paramBaseArticleInfo = "handleVideoFeedsClickJump";
        bool = false;
      }
      else if (paramArticleInfo.mFeedType == 3)
      {
        c(paramArticleInfo, parampgm);
        paramBaseArticleInfo = "onNowFeedsClick";
        bool = false;
      }
      else if (paramArticleInfo.mFeedType == 13)
      {
        a(paramArticleInfo, parampgm.a(), parampgm.b());
        paramBaseArticleInfo = "onQEGameClick";
        bool = false;
      }
      else if ((paramArticleInfo.mFeedType == 22) || (paramArticleInfo.mFeedType == 21) || (pay.o(paramArticleInfo)))
      {
        pay.a(parampgm.a(), paramArticleInfo, 4, false, 3, false);
        paramBaseArticleInfo = "jumpNewSocialSecondPage";
        bool = false;
      }
      else if (pgb.b(paramArticleInfo))
      {
        a(paramBaseArticleInfo, paramView, paramArticleInfo, parampgm.a());
        paramBaseArticleInfo = "onPgcShortContentClick";
        bool = false;
      }
      else if ((pgb.a(paramArticleInfo)) && (pgb.c(paramArticleInfo)))
      {
        a(paramArticleInfo, parampgm);
        paramBaseArticleInfo = "jumpArticleDetail";
        bool = false;
      }
      else if (pgb.a(paramArticleInfo))
      {
        pay.a(parampgm.a(), paramArticleInfo, 1, false, 4, false);
        paramBaseArticleInfo = "RIJItemViewType -> jumpNewSocialSecondPage";
        bool = false;
      }
      else if (pgb.a(paramArticleInfo) == 71)
      {
        a(paramView, paramInt, paramArticleInfo, parampgm);
        parampbn.a(Integer.valueOf(4));
        paramBaseArticleInfo = "onUgcVideoAsPgcClick";
        bool = false;
      }
      else if ((pgb.g(paramArticleInfo)) || (pgb.j(paramArticleInfo)))
      {
        pay.a(parampgm.a(), paramArticleInfo, 4, false, 3, false);
        pgw.b(paramArticleInfo, parampgm.b());
        paramBaseArticleInfo = "isUGC->jumpNewSocialSecondPage";
        bool = false;
      }
      else if ((pay.c(paramArticleInfo)) || (pay.d(paramArticleInfo)))
      {
        pay.a(parampgm.a(), paramArticleInfo, 1, false, 4, false);
        pgw.b(paramArticleInfo, parampgm.b());
        pay.a(paramArticleInfo, parampgm.b());
        paramBaseArticleInfo = "isTopicRecommend->jumpNewSocialSecondPage";
        bool = false;
      }
      else if (pay.a(paramArticleInfo))
      {
        a(paramArticleInfo, 1, parampgm);
        ozb.a(parampgm.a(), paramArticleInfo, parampgm.a());
        parampbn.a(Integer.valueOf(2));
        paramBaseArticleInfo = "jumpSocialDetailPageWhenClick";
        bool = false;
      }
      else
      {
        bool = b(paramBaseArticleInfo, paramView, paramInt, parampbn, paramArticleInfo, parampgm, paramHandler);
        paramBaseArticleInfo = "onItemClickPartTwo";
      }
    }
  }
  
  public void b(ArticleInfo paramArticleInfo, pgm parampgm)
  {
    sxd.b("fast_web_show_light_house_1");
    pum localpum = pkm.a().a();
    ArticleInfo localArticleInfo = paramArticleInfo;
    if (pay.s(paramArticleInfo))
    {
      localArticleInfo = paramArticleInfo;
      if (!paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean) {
        localArticleInfo = a(paramArticleInfo);
      }
    }
    if (localpum != null) {
      parampgm.b(localpum.a(localArticleInfo.mArticleContentUrl, String.valueOf(localArticleInfo.innerUniqueID), localArticleInfo.mSubscribeID, 1, null));
    }
    b(localArticleInfo, parampgm.a(), parampgm.b(), parampgm.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pgk
 * JD-Core Version:    0.7.0.1
 */