import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class prz
{
  private static int a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (1 == paramBaseArticleInfo.mVideoType) {}
    while (0L == paramBaseArticleInfo.mChannelID) {
      return 1;
    }
    return 9091;
  }
  
  public static Bundle a(spk paramspk, BaseArticleInfo paramBaseArticleInfo, spg paramspg, pne parampne)
  {
    boolean bool2 = true;
    Bundle localBundle = new Bundle();
    label110:
    int i;
    if (paramspk.jdField_f_of_type_Int == 1)
    {
      localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", paramBaseArticleInfo.mSubscribeID);
      localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.mSubscribeName);
      if (paramspk.jdField_f_of_type_Int != 6) {
        break label1321;
      }
      localBundle.putString("VIDEO_H5_URL", ((rrs)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_b_of_type_JavaUtilArrayList.get(0)).h);
      localBundle.putString("VIDEO_CREATE_TIME", pkg.a(((rrs)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_Int, true));
      localBundle.putString("VIDEO_TIME", String.valueOf(paramspk.jdField_b_of_type_Int));
      if (paramBaseArticleInfo.mVideoJsonWidth == 0) {
        break label1350;
      }
      localBundle.putString("VIDEO_WIDTH", String.valueOf(paramBaseArticleInfo.mVideoJsonWidth));
      label145:
      if (paramBaseArticleInfo.mVideoJsonHeight == 0) {
        break label1392;
      }
      localBundle.putString("VIDEO_HEIGHT", String.valueOf(paramBaseArticleInfo.mVideoJsonHeight));
      label166:
      localBundle.putString("VIDEO_VID", paramspk.jdField_c_of_type_JavaLangString);
      localBundle.putString("VIDEO_COVER", paramspk.jdField_b_of_type_JavaLangString);
      localBundle.putLong("VIDEO_XG_FILE_SIZE", paramBaseArticleInfo.mXGFileSize);
      localBundle.putInt("VIDEO_STRATEGY_ID", paramBaseArticleInfo.mStrategyId);
      localBundle.putLong("VIDEO_ALGORITHM_ID", paramBaseArticleInfo.mAlgorithmID);
      localBundle.putString("VIDEO_SECOND_INDEX_INNER_ID", paramspk.n);
      if ((parampne.a().a() == null) || (parampne.a().a().a() == null) || (paramspg == null) || (parampne.a().a().a().jdField_c_of_type_Long != paramspk.jdField_c_of_type_Long)) {
        break label1434;
      }
      localBundle.putLong("VIDEO_PLAY_POSITION", paramspg.a());
      label295:
      if (paramspk.jdField_f_of_type_Int != 6) {
        break label1445;
      }
      localBundle.putString("VIDEO_ARTICLE_ID", ((rrs)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_g_of_type_JavaLangString);
      localBundle.putLong("VIDEO_FEED_ID", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw.a.longValue());
      localBundle.putInt("VIDEO_FEED_TYPE", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw.b.intValue());
      localBundle.putString("VIDEO_TITLE", ((rrs)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_JavaLangString);
      label398:
      localBundle.putBoolean("IS_FROM_READINJOY_VIDEO_CHANNEL", bmhv.a(parampne.a().a()));
      if (paramspk.jdField_f_of_type_Int != 1) {
        break label1470;
      }
      bool1 = true;
      label426:
      localBundle.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool1);
      localBundle.putString("VIDEO_RECOMMEND_REASON", paramBaseArticleInfo.mRecommentdReason);
      localBundle.putBoolean("isFromKandian", true);
      localBundle.putLong("channelID", paramBaseArticleInfo.mChannelID);
      localBundle.putLong("algorithmID", paramBaseArticleInfo.mAlgorithmID);
      localBundle.putString("innderId", paramBaseArticleInfo.innerUniqueID);
      localBundle.putLong("strategyId", paramBaseArticleInfo.mStrategyId);
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleFriendLikeText)) {
        break label1476;
      }
      i = 0;
      label512:
      localBundle.putInt("interactionType", i);
      localBundle.putString("VIDEO_THIRD_ICON", paramspk.jdField_d_of_type_JavaLangString);
      localBundle.putString("VIDEO_THIRD_NAME", paramspk.jdField_e_of_type_JavaLangString);
      localBundle.putString("VIDEO_THIRD_ACTION", paramspk.jdField_f_of_type_JavaLangString);
      localBundle.putString("VIDEO_THIRD_URL", paramspk.jdField_g_of_type_JavaLangString);
      localBundle.putLong("VIDEO_THRID_URL_EXPIRE_TIME", paramspk.jdField_f_of_type_Long);
      localBundle.putInt("VIDEO_ARTICLE_BUSITYPE", paramspk.jdField_f_of_type_Int);
      parampne = new Bundle();
      parampne.putString("VINFO", paramspk.jdField_c_of_type_JavaLangString);
      parampne.putString("TINFO", paramspk.jdField_c_of_type_JavaLangString);
      parampne.putInt("PREVIEW_VIDEO_TIME", paramspk.jdField_b_of_type_Int);
      if (paramspg != null) {
        break label1482;
      }
      i = 0;
      label637:
      parampne.putInt("PREVIEW_START_POSI", spm.a(i, paramspk.jdField_b_of_type_Int));
      parampne.putInt("PREVIEW_VIDEO_WIDTH", paramspk.jdField_c_of_type_Int);
      parampne.putInt("PREVIEW_VIDEO_HEIGHT", paramspk.jdField_d_of_type_Int);
      parampne.putInt("FULL_VIDEO_TIME", paramspk.jdField_b_of_type_Int);
      parampne.putString("source_puin", paramBaseArticleInfo.mSubscribeID);
      if (paramspk.jdField_f_of_type_Int != 1) {
        break label1492;
      }
      parampne.putString("ACCOUNT_UIN", paramBaseArticleInfo.mSubscribeID);
      parampne.putString("ACCOUNT_NAME", paramBaseArticleInfo.mSubscribeName);
      label727:
      if ((paramspk.jdField_f_of_type_Int != 6) || (paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_b_of_type_JavaUtilArrayList == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_b_of_type_JavaUtilArrayList.size() <= 0)) {
        break label1517;
      }
      parampne.putString("compatible_text", ((rrs)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_JavaLangString + ": " + ((rrs)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_b_of_type_JavaUtilArrayList.get(0)).h);
      parampne.putInt("req_type", 125);
      label860:
      parampne.putInt("TYPE", paramspk.jdField_f_of_type_Int);
      parampne.putString("ARTICLE_ID", paramBaseArticleInfo.innerUniqueID);
      parampne.putInt("layout_item", 5);
      parampne.putBoolean("video_url_load", false);
      parampne.putString("image_url_remote", paramspk.jdField_b_of_type_JavaLangString);
      if (paramBaseArticleInfo.aioShareUrl == null) {
        break label1530;
      }
      parampne.putString("detail_url", paramBaseArticleInfo.aioShareUrl);
      label927:
      parampne.putString("video_url", paramspk.jdField_c_of_type_JavaLangString);
      parampne.putString("title", paramBaseArticleInfo.mTitle);
      parampne.putString("req_create_time", pkg.a(paramBaseArticleInfo.mTime));
      parampne.putString("brief_key", paramBaseArticleInfo.mTitle);
      localBundle.putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)bdof.a(parampne)).getBytes());
      localBundle.putString("VIDEO_SUBS_TEXT", paramBaseArticleInfo.mVideoArticleSubsText);
      localBundle.putString("VIDEO_SUBS_COLOR", paramBaseArticleInfo.mVideoArticleSubsColor);
      localBundle.putString("KEY_VIDEO_JSON_LIST", paramBaseArticleInfo.mJsonVideoList);
      localBundle.putInt("VIDEO_PLAY_COUNT", paramBaseArticleInfo.mVideoPlayCount);
      localBundle.putString("VIDEO_ACCOUNT_AVATAR_URL", paramBaseArticleInfo.preloadAvatarUrl);
      localBundle.putBoolean("VIDEO_ACCOUNT_IS_FOLLOWED", six.a(paramBaseArticleInfo.getSubscribeUin()));
      if (paramBaseArticleInfo.mSocialFeedInfo != null) {
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_c_of_type_Int != 1) {
          break label1563;
        }
      }
    }
    label1434:
    label1563:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localBundle.putBoolean("VIDEO_IS_DIANZAN", bool1);
      localBundle.putInt("VIDEO_DIAN_ZAN_COUNT", paramBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int);
      localBundle.putInt("VIDEO_COMMENT_COUNT", paramBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int);
      localBundle.putInt("VIDEO_BIU_COUNT", paramBaseArticleInfo.mSocialFeedInfo.jdField_f_of_type_Int);
      return localBundle;
      if (paramspk.jdField_f_of_type_Int == 6)
      {
        if (ppe.g(paramBaseArticleInfo)) {
          localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy.jdField_a_of_type_Long);
        }
        for (;;)
        {
          localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_b_of_type_JavaLangString);
          if (ppe.q((ArticleInfo)paramBaseArticleInfo)) {
            break;
          }
          localBundle.putString("VIDEO_URL", ((rrs)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString);
          break;
          localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_Long);
        }
      }
      localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", paramBaseArticleInfo.thirdUin);
      localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.thirdUinName);
      break;
      label1321:
      localBundle.putString("VIDEO_H5_URL", paramBaseArticleInfo.mArticleContentUrl);
      localBundle.putString("VIDEO_CREATE_TIME", pkg.a(paramBaseArticleInfo.mTime, true));
      break label110;
      label1350:
      if (paramspk.jdField_f_of_type_Int != 6) {
        break label145;
      }
      localBundle.putString("VIDEO_WIDTH", String.valueOf(((rrs)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int));
      break label145;
      label1392:
      if (paramspk.jdField_f_of_type_Int != 6) {
        break label166;
      }
      localBundle.putString("VIDEO_HEIGHT", String.valueOf(((rrs)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_Int));
      break label166;
      localBundle.putLong("VIDEO_PLAY_POSITION", 0L);
      break label295;
      label1445:
      localBundle.putString("VIDEO_ARTICLE_ID", paramBaseArticleInfo.innerUniqueID);
      localBundle.putString("VIDEO_TITLE", paramBaseArticleInfo.mTitle);
      break label398;
      label1470:
      bool1 = false;
      break label426;
      label1476:
      i = 1;
      break label512;
      label1482:
      i = (int)paramspg.a();
      break label637;
      label1492:
      parampne.putString("ACCOUNT_UIN", paramBaseArticleInfo.thirdUin);
      parampne.putString("ACCOUNT_NAME", paramBaseArticleInfo.thirdUinName);
      break label727;
      label1517:
      parampne.putInt("req_type", 140);
      break label860;
      label1530:
      parampne.putString("detail_url", paramBaseArticleInfo.mArticleContentUrl + "&sourcefrom=0");
      break label927;
    }
  }
  
  private static void a(Bundle paramBundle)
  {
    paramBundle.putInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 6);
    paramBundle.putInt("VIDEO_FROM_TYPE", 9);
    paramBundle.putInt("key_source", 0);
    paramBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 8);
  }
  
  private static void a(Bundle paramBundle, BaseArticleInfo paramBaseArticleInfo)
  {
    if (pqw.g(paramBaseArticleInfo))
    {
      paramBundle.putInt("VIDEO_FROM_TYPE", 14);
      paramBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Long);
      return;
    }
    paramBundle.putInt("VIDEO_FROM_TYPE", 8);
    paramBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 7);
  }
  
  private static void a(Bundle paramBundle, BaseArticleInfo paramBaseArticleInfo, pne parampne)
  {
    if (parampne.a().b() == 0)
    {
      b(paramBundle, paramBaseArticleInfo);
      return;
    }
    if (parampne.a().b() == 56)
    {
      a(parampne, paramBundle, paramBaseArticleInfo);
      return;
    }
    if (parampne.a().b() == 70)
    {
      a(paramBundle, paramBaseArticleInfo);
      return;
    }
    if (parampne.a().b() == 40677)
    {
      a(paramBundle);
      return;
    }
    if (plm.c(parampne.a().b()))
    {
      paramBundle.putInt("VIDEO_FROM_TYPE", 24);
      return;
    }
    a(paramBundle, parampne);
  }
  
  private static void a(Bundle paramBundle, pne parampne)
  {
    if (parampne.a().a() == 3) {
      paramBundle.putInt("VIDEO_FROM_TYPE", 6);
    }
    for (;;)
    {
      paramBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 5);
      return;
      paramBundle.putInt("VIDEO_FROM_TYPE", 7);
    }
  }
  
  private static void a(pne parampne)
  {
    if ((parampne != null) && (parampne.a().a() != null))
    {
      parampne.a().a().d();
      parampne.a().b(true);
    }
  }
  
  private static void a(pne parampne, Intent paramIntent, Bundle paramBundle, int paramInt)
  {
    try
    {
      bool = plw.a(paramBundle.getInt("VIDEO_FROM_TYPE", -1), Integer.valueOf(paramBundle.getString("VIDEO_WIDTH")).intValue(), Integer.valueOf(paramBundle.getString("VIDEO_HEIGHT")).intValue(), Integer.valueOf(paramBundle.getString("VIDEO_TIME")).intValue());
      if (bool)
      {
        ssn.a((Activity)parampne.a().a(), paramIntent, paramInt);
        ((Activity)parampne.a().a()).overridePendingTransition(2130772011, 0);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, new Object[] { "openFullVideoPlayActivity MultiVideoConfigHandler.isEnterMultiMode is error:", paramBundle.getMessage() });
        }
        boolean bool = false;
      }
      ((Activity)parampne.a().a()).startActivityForResult(paramIntent, paramInt);
      ((Activity)parampne.a().a()).overridePendingTransition(2130772070, 2130772071);
    }
  }
  
  private static void a(pne parampne, Bundle paramBundle, BaseArticleInfo paramBaseArticleInfo)
  {
    if (pqw.i(paramBaseArticleInfo))
    {
      paramBundle.putInt("VIDEO_FROM_TYPE", 5);
      paramBundle.putLong("VIDEO_FROM_POLYMERIC_TOPIC_ID", paramBaseArticleInfo.mPolymericInfo.jdField_f_of_type_Long);
      paramBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long);
    }
    for (;;)
    {
      paramBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 4);
      return;
      if (pqw.g(paramBaseArticleInfo))
      {
        paramBundle.putInt("VIDEO_FROM_TYPE", 5);
        paramBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Long);
      }
      else if (parampne.a().a() == 1004L)
      {
        paramBundle.putInt("VIDEO_FROM_TYPE", 25);
      }
      else
      {
        paramBundle.putInt("VIDEO_FROM_TYPE", 2);
      }
    }
  }
  
  public static void a(spk paramspk, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean, pne parampne)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "open full play activity, articleID : " + paramBaseArticleInfo.mArticleID + ", playPosition : " + paramspk.jdField_d_of_type_Long + ",vid : " + paramspk.jdField_c_of_type_JavaLangString + ", showComment : " + paramBoolean);
    }
    if (parampne.a().a() != null) {
      parampne.a().a().b();
    }
    parampne.a().a(true);
    Bundle localBundle;
    if (pqw.g(paramBaseArticleInfo))
    {
      localBundle = b(paramspk, paramBaseArticleInfo, parampne.a().a(), parampne);
      if (parampne.a().a() != null) {
        if (parampne.a().a().b() != paramBaseArticleInfo.mArticleID) {
          break label609;
        }
      }
    }
    label609:
    for (int i = parampne.a().a().a();; i = 1)
    {
      localBundle.putInt("VIDEO_PLAY_STATUS", i);
      if (paramspk.jdField_f_of_type_Int == 2)
      {
        localObject = swx.a(paramspk.jdField_c_of_type_JavaLangString);
        if (localObject != null)
        {
          localBundle.putString("VIDEO_THIRD_VID_URL", ((sxc)localObject).jdField_a_of_type_JavaLangString);
          localBundle.putLong("VIDEO_THIRD_VID_URL_TIME", ((sxc)localObject).jdField_b_of_type_Long);
        }
      }
      localBundle.putBoolean("VIDEO_LIST_SCROLL_EXIT", true);
      localBundle.putInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 3);
      a(localBundle, paramBaseArticleInfo, parampne);
      localBundle.putInt("REPORT_VIDEO_FEEDS_CHANNEL_ID", parampne.a().b());
      localBundle.putParcelable("VIDEO_COLUMN_INFO", paramBaseArticleInfo.mVideoColumnInfo);
      localBundle.putString("KEY_VIDEO_JSON_LIST", paramBaseArticleInfo.mJsonVideoList);
      Object localObject = new Intent(parampne.a().a(), VideoFeedsPlayActivity.class);
      ((Intent)localObject).addFlags(536870912);
      if (BaseApplicationImpl.sProcessId != 1)
      {
        localBundle.putBoolean("param_needSmooth", sqp.a().d());
        sqp.a().d(true);
        localBundle.putBoolean("param_needAlertInXg", sge.d());
      }
      ((Intent)localObject).putExtras(localBundle);
      if ((paramspk.jdField_f_of_type_Int == 6) && (!pqw.g(paramBaseArticleInfo))) {
        ((Intent)localObject).putExtra("VIDEO_ARTICLE_INFO_FOR_BIU", (ArticleInfo)paramBaseArticleInfo);
      }
      i = a(paramBaseArticleInfo);
      ((Intent)localObject).putExtra("VIDEO_FEEDS_INNER_SESSION_ID", paramspk.l);
      ((Intent)localObject).putExtra("VIDEO_CHANNEL_SESSION_ID", paramspk.m);
      ((Intent)localObject).putExtra("item_x", paramspk.h);
      ((Intent)localObject).putExtra("item_y", paramspk.i);
      ((Intent)localObject).putExtra("item_width", paramspk.j);
      ((Intent)localObject).putExtra("item_height", paramspk.k);
      six.a(paramBaseArticleInfo, (Intent)localObject);
      ((Intent)localObject).putExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", pqw.a(paramBaseArticleInfo));
      ((Intent)localObject).putExtra("VIDEO_SHOW_COMMENT", paramBoolean);
      ((Intent)localObject).putExtra("video_player_session_id", parampne.a().a().a());
      a(parampne, (Intent)localObject, localBundle, i);
      sog.a();
      a(parampne);
      if (bmhv.m()) {
        olh.a(null, "", "0X8008B68", "0X8008B68", 0, 0, "", "", "", omx.a(null, null, paramBaseArticleInfo.mVideoVid, paramBaseArticleInfo.innerUniqueID, parampne.a().b(), null), false);
      }
      return;
      localBundle = a(paramspk, paramBaseArticleInfo, parampne.a().a(), parampne);
      break;
    }
  }
  
  private static Bundle b(spk paramspk, BaseArticleInfo paramBaseArticleInfo, spg paramspg, pne parampne)
  {
    Object localObject1 = null;
    Object localObject2;
    if (pqw.n(paramBaseArticleInfo))
    {
      Iterator localIterator = paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (rpt)localIterator.next();
        if ((((rpt)localObject2).jdField_a_of_type_Rpw == null) || (!TextUtils.equals(paramspk.jdField_c_of_type_JavaLangString, ((rpt)localObject2).jdField_a_of_type_Rpw.jdField_a_of_type_JavaLangString))) {
          break label934;
        }
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (rpt)paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
      }
      localObject1 = new Bundle();
      label377:
      boolean bool;
      if (((rpt)localObject2).jdField_a_of_type_Boolean)
      {
        ((Bundle)localObject1).putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy.jdField_a_of_type_Long);
        ((Bundle)localObject1).putString("VIDEO_H5_URL", ((rpt)localObject2).jdField_a_of_type_Rpw.jdField_c_of_type_JavaLangString);
        ((Bundle)localObject1).putLong("VIDEO_FEED_ID", ((rpt)localObject2).jdField_c_of_type_Long);
        ((Bundle)localObject1).putInt("VIDEO_FEED_TYPE", ((rpt)localObject2).jdField_b_of_type_Int);
        if (((rpt)localObject2).jdField_a_of_type_Rpw != null) {}
        ((Bundle)localObject1).putString("VIDEO_TIME", String.valueOf(paramspk.jdField_b_of_type_Int));
        ((Bundle)localObject1).putString("VIDEO_WIDTH", String.valueOf(paramspk.jdField_c_of_type_Int));
        ((Bundle)localObject1).putString("VIDEO_HEIGHT", String.valueOf(paramspk.jdField_d_of_type_Int));
        ((Bundle)localObject1).putString("VIDEO_VID", paramspk.jdField_c_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_COVER", paramspk.jdField_b_of_type_JavaLangString);
        ((Bundle)localObject1).putLong("VIDEO_XG_FILE_SIZE", paramBaseArticleInfo.mXGFileSize);
        ((Bundle)localObject1).putInt("VIDEO_STRATEGY_ID", paramspk.jdField_g_of_type_Int);
        ((Bundle)localObject1).putLong("VIDEO_ALGORITHM_ID", paramspk.jdField_g_of_type_Long);
        ((Bundle)localObject1).putString("VIDEO_SECOND_INDEX_INNER_ID", paramspk.n);
        if ((parampne.a().a() == null) || (parampne.a().a().a() == null) || (paramspg == null) || (parampne.a().a().a().jdField_c_of_type_Long != paramspk.jdField_c_of_type_Long)) {
          break label907;
        }
        ((Bundle)localObject1).putLong("VIDEO_PLAY_POSITION", paramspg.a());
        ((Bundle)localObject1).putString("VIDEO_ARTICLE_ID", ((rpt)localObject2).jdField_g_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_TITLE", ((rpt)localObject2).jdField_a_of_type_JavaLangString);
        ((Bundle)localObject1).putBoolean("IS_FROM_READINJOY_VIDEO_CHANNEL", bmhv.a(parampne.a().a()));
        if (paramspk.jdField_f_of_type_Int != 1) {
          break label918;
        }
        bool = true;
        label429:
        ((Bundle)localObject1).putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
        ((Bundle)localObject1).putBoolean("isFromKandian", true);
        ((Bundle)localObject1).putLong("channelID", paramBaseArticleInfo.mChannelID);
        ((Bundle)localObject1).putLong("algorithmID", ((rpt)localObject2).jdField_b_of_type_Long);
        ((Bundle)localObject1).putString("innderId", ((rpt)localObject2).jdField_g_of_type_JavaLangString);
        ((Bundle)localObject1).putLong("strategyId", ((rpt)localObject2).jdField_a_of_type_Int);
        ((Bundle)localObject1).putString("VIDEO_THIRD_ICON", paramspk.jdField_d_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_THIRD_NAME", paramspk.jdField_e_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_THIRD_ACTION", paramspk.jdField_f_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_THIRD_URL", paramspk.jdField_g_of_type_JavaLangString);
        ((Bundle)localObject1).putLong("VIDEO_THRID_URL_EXPIRE_TIME", paramspk.jdField_f_of_type_Long);
        ((Bundle)localObject1).putInt("VIDEO_ARTICLE_BUSITYPE", paramspk.jdField_f_of_type_Int);
        parampne = new Bundle();
        parampne.putString("VINFO", paramspk.jdField_c_of_type_JavaLangString);
        parampne.putString("TINFO", paramspk.jdField_c_of_type_JavaLangString);
        parampne.putInt("PREVIEW_VIDEO_TIME", paramspk.jdField_b_of_type_Int);
        if (paramspg != null) {
          break label924;
        }
      }
      label907:
      label918:
      label924:
      for (int i = 0;; i = (int)paramspg.a())
      {
        parampne.putInt("PREVIEW_START_POSI", spm.a(i, paramspk.jdField_b_of_type_Int));
        parampne.putInt("PREVIEW_VIDEO_WIDTH", paramspk.jdField_c_of_type_Int);
        parampne.putInt("PREVIEW_VIDEO_HEIGHT", paramspk.jdField_d_of_type_Int);
        parampne.putInt("FULL_VIDEO_TIME", paramspk.jdField_b_of_type_Int);
        parampne.putString("source_puin", ((rpt)localObject2).jdField_e_of_type_JavaLangString);
        parampne.putString("ACCOUNT_UIN", ((rpt)localObject2).jdField_e_of_type_JavaLangString);
        parampne.putString("ACCOUNT_NAME", ((rpt)localObject2).jdField_f_of_type_JavaLangString);
        parampne.putInt("TYPE", paramspk.jdField_f_of_type_Int);
        parampne.putString("ARTICLE_ID", ((rpt)localObject2).jdField_g_of_type_JavaLangString);
        parampne.putInt("layout_item", 5);
        parampne.putBoolean("video_url_load", false);
        parampne.putString("image_url_remote", paramspk.jdField_b_of_type_JavaLangString);
        parampne.putString("detail_url", ((rpt)localObject2).jdField_d_of_type_JavaLangString + "&sourcefrom=0");
        parampne.putString("video_url", paramspk.jdField_c_of_type_JavaLangString);
        parampne.putString("title", ((rpt)localObject2).jdField_a_of_type_JavaLangString);
        parampne.putString("req_create_time", pkg.a(paramBaseArticleInfo.mTime));
        parampne.putString("brief_key", ((rpt)localObject2).jdField_a_of_type_JavaLangString);
        parampne.putInt("req_type", 140);
        ((Bundle)localObject1).putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)bdof.a(parampne)).getBytes());
        ((Bundle)localObject1).putString("KEY_VIDEO_JSON_LIST", paramBaseArticleInfo.mJsonVideoList);
        return localObject1;
        ((Bundle)localObject1).putString("VIDEO_PUB_ACCOUNT_UIN", ((rpt)localObject2).jdField_e_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_PUB_ACCOUNT_NAME", ((rpt)localObject2).jdField_f_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_H5_URL", ((rpt)localObject2).jdField_d_of_type_JavaLangString);
        break;
        ((Bundle)localObject1).putLong("VIDEO_PLAY_POSITION", 0L);
        break label377;
        bool = false;
        break label429;
      }
      label934:
      break;
      localObject1 = null;
    }
  }
  
  private static void b(Bundle paramBundle, BaseArticleInfo paramBaseArticleInfo)
  {
    if (pqw.i(paramBaseArticleInfo))
    {
      paramBundle.putInt("VIDEO_FROM_TYPE", 4);
      paramBundle.putLong("VIDEO_FROM_POLYMERIC_TOPIC_ID", paramBaseArticleInfo.mPolymericInfo.jdField_f_of_type_Long);
      paramBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long);
    }
    for (;;)
    {
      paramBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 3);
      return;
      if (pqw.g(paramBaseArticleInfo))
      {
        paramBundle.putInt("VIDEO_FROM_TYPE", 13);
        paramBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Long);
      }
      else
      {
        paramBundle.putInt("VIDEO_FROM_TYPE", 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     prz
 * JD-Core Version:    0.7.0.1
 */