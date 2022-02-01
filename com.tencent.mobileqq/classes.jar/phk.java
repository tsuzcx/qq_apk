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

public class phk
{
  public static Bundle a(sdg paramsdg, BaseArticleInfo paramBaseArticleInfo, sdc paramsdc, ped paramped)
  {
    Bundle localBundle = new Bundle();
    label107:
    boolean bool;
    label142:
    label163:
    label292:
    label423:
    int i;
    if (paramsdg.jdField_f_of_type_Int == 1)
    {
      localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", paramBaseArticleInfo.mSubscribeID);
      localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.mSubscribeName);
      if (paramsdg.jdField_f_of_type_Int != 6) {
        break label1212;
      }
      localBundle.putString("VIDEO_H5_URL", ((rfl)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_b_of_type_JavaUtilArrayList.get(0)).h);
      localBundle.putString("VIDEO_CREATE_TIME", pax.a(((rfl)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_Int, true));
      localBundle.putString("VIDEO_TIME", String.valueOf(paramsdg.jdField_b_of_type_Int));
      if (paramBaseArticleInfo.mVideoJsonWidth == 0) {
        break label1241;
      }
      localBundle.putString("VIDEO_WIDTH", String.valueOf(paramBaseArticleInfo.mVideoJsonWidth));
      if (paramBaseArticleInfo.mVideoJsonHeight == 0) {
        break label1283;
      }
      localBundle.putString("VIDEO_HEIGHT", String.valueOf(paramBaseArticleInfo.mVideoJsonHeight));
      localBundle.putString("VIDEO_VID", paramsdg.jdField_c_of_type_JavaLangString);
      localBundle.putString("VIDEO_COVER", paramsdg.jdField_b_of_type_JavaLangString);
      localBundle.putLong("VIDEO_XG_FILE_SIZE", paramBaseArticleInfo.mXGFileSize);
      localBundle.putInt("VIDEO_STRATEGY_ID", paramBaseArticleInfo.mStrategyId);
      localBundle.putLong("VIDEO_ALGORITHM_ID", paramBaseArticleInfo.mAlgorithmID);
      localBundle.putString("VIDEO_SECOND_INDEX_INNER_ID", paramsdg.n);
      if ((paramped.a().a() == null) || (paramped.a().a().a() == null) || (paramsdc == null) || (paramped.a().a().a().jdField_c_of_type_Long != paramsdg.jdField_c_of_type_Long)) {
        break label1325;
      }
      localBundle.putLong("VIDEO_PLAY_POSITION", paramsdc.a());
      if (paramsdg.jdField_f_of_type_Int != 6) {
        break label1336;
      }
      localBundle.putString("VIDEO_ARTICLE_ID", ((rfl)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_g_of_type_JavaLangString);
      localBundle.putLong("VIDEO_FEED_ID", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.a.longValue());
      localBundle.putInt("VIDEO_FEED_TYPE", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.b.intValue());
      localBundle.putString("VIDEO_TITLE", ((rfl)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_JavaLangString);
      label395:
      localBundle.putBoolean("IS_FROM_READINJOY_VIDEO_CHANNEL", bkwm.a(paramped.a().a()));
      if (paramsdg.jdField_f_of_type_Int != 1) {
        break label1361;
      }
      bool = true;
      localBundle.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
      localBundle.putString("VIDEO_RECOMMEND_REASON", paramBaseArticleInfo.mRecommentdReason);
      localBundle.putBoolean("isFromKandian", true);
      localBundle.putLong("channelID", paramBaseArticleInfo.mChannelID);
      localBundle.putLong("algorithmID", paramBaseArticleInfo.mAlgorithmID);
      localBundle.putString("innderId", paramBaseArticleInfo.innerUniqueID);
      localBundle.putLong("strategyId", paramBaseArticleInfo.mStrategyId);
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleFriendLikeText)) {
        break label1367;
      }
      i = 0;
      label509:
      localBundle.putInt("interactionType", i);
      localBundle.putString("VIDEO_THIRD_ICON", paramsdg.jdField_d_of_type_JavaLangString);
      localBundle.putString("VIDEO_THIRD_NAME", paramsdg.jdField_e_of_type_JavaLangString);
      localBundle.putString("VIDEO_THIRD_ACTION", paramsdg.jdField_f_of_type_JavaLangString);
      localBundle.putString("VIDEO_THIRD_URL", paramsdg.jdField_g_of_type_JavaLangString);
      localBundle.putLong("VIDEO_THRID_URL_EXPIRE_TIME", paramsdg.jdField_f_of_type_Long);
      localBundle.putInt("VIDEO_ARTICLE_BUSITYPE", paramsdg.jdField_f_of_type_Int);
      paramped = new Bundle();
      paramped.putString("VINFO", paramsdg.jdField_c_of_type_JavaLangString);
      paramped.putString("TINFO", paramsdg.jdField_c_of_type_JavaLangString);
      paramped.putInt("PREVIEW_VIDEO_TIME", paramsdg.jdField_b_of_type_Int);
      if (paramsdc != null) {
        break label1373;
      }
      i = 0;
      label632:
      paramped.putInt("PREVIEW_START_POSI", sdi.a(i, paramsdg.jdField_b_of_type_Int));
      paramped.putInt("PREVIEW_VIDEO_WIDTH", paramsdg.jdField_c_of_type_Int);
      paramped.putInt("PREVIEW_VIDEO_HEIGHT", paramsdg.jdField_d_of_type_Int);
      paramped.putInt("FULL_VIDEO_TIME", paramsdg.jdField_b_of_type_Int);
      paramped.putString("source_puin", paramBaseArticleInfo.mSubscribeID);
      if (paramsdg.jdField_f_of_type_Int != 1) {
        break label1383;
      }
      paramped.putString("ACCOUNT_UIN", paramBaseArticleInfo.mSubscribeID);
      paramped.putString("ACCOUNT_NAME", paramBaseArticleInfo.mSubscribeName);
      label722:
      if ((paramsdg.jdField_f_of_type_Int != 6) || (paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_b_of_type_JavaUtilArrayList == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_b_of_type_JavaUtilArrayList.size() <= 0)) {
        break label1408;
      }
      paramped.putString("compatible_text", ((rfl)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_JavaLangString + ": " + ((rfl)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_b_of_type_JavaUtilArrayList.get(0)).h);
      paramped.putInt("req_type", 125);
      label855:
      paramped.putInt("TYPE", paramsdg.jdField_f_of_type_Int);
      paramped.putString("ARTICLE_ID", paramBaseArticleInfo.innerUniqueID);
      paramped.putInt("layout_item", 5);
      paramped.putBoolean("video_url_load", false);
      paramped.putString("image_url_remote", paramsdg.jdField_b_of_type_JavaLangString);
      if (paramBaseArticleInfo.aioShareUrl == null) {
        break label1421;
      }
      paramped.putString("detail_url", paramBaseArticleInfo.aioShareUrl);
    }
    for (;;)
    {
      paramped.putString("video_url", paramsdg.jdField_c_of_type_JavaLangString);
      paramped.putString("title", paramBaseArticleInfo.mTitle);
      paramped.putString("req_create_time", pax.a(paramBaseArticleInfo.mTime));
      paramped.putString("brief_key", paramBaseArticleInfo.mTitle);
      localBundle.putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)bchh.a(paramped)).getBytes());
      localBundle.putString("VIDEO_SUBS_TEXT", paramBaseArticleInfo.mVideoArticleSubsText);
      localBundle.putString("VIDEO_SUBS_COLOR", paramBaseArticleInfo.mVideoArticleSubsColor);
      localBundle.putString("KEY_VIDEO_JSON_LIST", paramBaseArticleInfo.mJsonVideoList);
      localBundle.putInt("VIDEO_PLAY_COUNT", paramBaseArticleInfo.mVideoPlayCount);
      return localBundle;
      if (paramsdg.jdField_f_of_type_Int == 6)
      {
        if (pgb.g(paramBaseArticleInfo)) {
          localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer.jdField_a_of_type_Long);
        }
        for (;;)
        {
          localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_b_of_type_JavaLangString);
          if (pgb.q((ArticleInfo)paramBaseArticleInfo)) {
            break;
          }
          localBundle.putString("VIDEO_URL", ((rfl)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString);
          break;
          localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_Long);
        }
      }
      localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", paramBaseArticleInfo.thirdUin);
      localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.thirdUinName);
      break;
      label1212:
      localBundle.putString("VIDEO_H5_URL", paramBaseArticleInfo.mArticleContentUrl);
      localBundle.putString("VIDEO_CREATE_TIME", pax.a(paramBaseArticleInfo.mTime, true));
      break label107;
      label1241:
      if (paramsdg.jdField_f_of_type_Int != 6) {
        break label142;
      }
      localBundle.putString("VIDEO_WIDTH", String.valueOf(((rfl)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int));
      break label142;
      label1283:
      if (paramsdg.jdField_f_of_type_Int != 6) {
        break label163;
      }
      localBundle.putString("VIDEO_HEIGHT", String.valueOf(((rfl)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_Int));
      break label163;
      label1325:
      localBundle.putLong("VIDEO_PLAY_POSITION", 0L);
      break label292;
      label1336:
      localBundle.putString("VIDEO_ARTICLE_ID", paramBaseArticleInfo.innerUniqueID);
      localBundle.putString("VIDEO_TITLE", paramBaseArticleInfo.mTitle);
      break label395;
      label1361:
      bool = false;
      break label423;
      label1367:
      i = 1;
      break label509;
      label1373:
      i = (int)paramsdc.a();
      break label632;
      label1383:
      paramped.putString("ACCOUNT_UIN", paramBaseArticleInfo.thirdUin);
      paramped.putString("ACCOUNT_NAME", paramBaseArticleInfo.thirdUinName);
      break label722;
      label1408:
      paramped.putInt("req_type", 140);
      break label855;
      label1421:
      paramped.putString("detail_url", paramBaseArticleInfo.mArticleContentUrl + "&sourcefrom=0");
    }
  }
  
  public static void a(sdg paramsdg, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean, ped paramped)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "open full play activity, articleID : " + paramBaseArticleInfo.mArticleID + ", playPosition : " + paramsdg.jdField_d_of_type_Long + ",vid : " + paramsdg.jdField_c_of_type_JavaLangString + ", showComment : " + paramBoolean);
    }
    if (paramped.a().a() != null) {
      paramped.a().a().b();
    }
    paramped.a().a(true);
    Bundle localBundle;
    int i;
    label163:
    Object localObject;
    if (pay.s(paramBaseArticleInfo))
    {
      localBundle = b(paramsdg, paramBaseArticleInfo, paramped.a().a(), paramped);
      if (paramped.a().a() != null)
      {
        if (paramped.a().a().b() != paramBaseArticleInfo.mArticleID) {
          break label777;
        }
        i = paramped.a().a().a();
        localBundle.putInt("VIDEO_PLAY_STATUS", i);
      }
      if (paramsdg.jdField_f_of_type_Int == 2)
      {
        localObject = sjo.a(paramsdg.jdField_c_of_type_JavaLangString);
        if (localObject != null)
        {
          localBundle.putString("VIDEO_THIRD_VID_URL", ((sjt)localObject).jdField_a_of_type_JavaLangString);
          localBundle.putLong("VIDEO_THIRD_VID_URL_TIME", ((sjt)localObject).jdField_b_of_type_Long);
        }
      }
      localBundle.putBoolean("VIDEO_LIST_SCROLL_EXIT", true);
      localBundle.putInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 3);
      if (paramped.a().b() != 0) {
        break label830;
      }
      if (!pay.i(paramBaseArticleInfo)) {
        break label783;
      }
      localBundle.putInt("VIDEO_FROM_TYPE", 4);
      localBundle.putLong("VIDEO_FROM_POLYMERIC_TOPIC_ID", paramBaseArticleInfo.mPolymericInfo.jdField_f_of_type_Long);
      localBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long);
      label295:
      localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 3);
      label304:
      localBundle.putInt("REPORT_VIDEO_FEEDS_CHANNEL_ID", paramped.a().b());
      localBundle.putParcelable("VIDEO_COLUMN_INFO", paramBaseArticleInfo.mVideoColumnInfo);
      localBundle.putString("KEY_VIDEO_JSON_LIST", paramBaseArticleInfo.mJsonVideoList);
      localObject = new Intent(paramped.a().a(), VideoFeedsPlayActivity.class);
      ((Intent)localObject).addFlags(536870912);
      if (BaseApplicationImpl.sProcessId != 1)
      {
        localBundle.putBoolean("param_needSmooth", sek.a().d());
        sek.a().d(true);
        localBundle.putBoolean("param_needAlertInXg", rtp.d());
      }
      ((Intent)localObject).putExtras(localBundle);
      if ((paramsdg.jdField_f_of_type_Int == 6) && (!pay.s(paramBaseArticleInfo))) {
        ((Intent)localObject).putExtra("VIDEO_ARTICLE_INFO_FOR_BIU", (ArticleInfo)paramBaseArticleInfo);
      }
      if (1 != paramBaseArticleInfo.mVideoType) {
        break label1170;
      }
      i = 1;
    }
    for (;;)
    {
      for (;;)
      {
        ((Intent)localObject).putExtra("VIDEO_FEEDS_INNER_SESSION_ID", paramsdg.l);
        ((Intent)localObject).putExtra("VIDEO_CHANNEL_SESSION_ID", paramsdg.m);
        ((Intent)localObject).putExtra("item_x", paramsdg.h);
        ((Intent)localObject).putExtra("item_y", paramsdg.i);
        ((Intent)localObject).putExtra("item_width", paramsdg.j);
        ((Intent)localObject).putExtra("item_height", paramsdg.k);
        rwv.a(paramBaseArticleInfo, (Intent)localObject);
        ((Intent)localObject).putExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", pay.a(paramBaseArticleInfo));
        ((Intent)localObject).putExtra("VIDEO_SHOW_COMMENT", paramBoolean);
        ((Intent)localObject).putExtra("video_player_session_id", paramped.a().a().a());
        try
        {
          paramBoolean = pcv.a(localBundle.getInt("VIDEO_FROM_TYPE", -1), Integer.valueOf(localBundle.getString("VIDEO_WIDTH")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_HEIGHT")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_TIME")).intValue());
          if (paramBoolean)
          {
            sgi.a((Activity)paramped.a().a(), (Intent)localObject, i);
            ((Activity)paramped.a().a()).overridePendingTransition(2130772011, 0);
            scc.a();
            if (paramped.a().a() != null)
            {
              paramped.a().a().d();
              paramped.a().b(true);
            }
            if (bkwm.j()) {
              odq.a(null, "", "0X8008B68", "0X8008B68", 0, 0, "", "", "", ofe.a(null, null, paramBaseArticleInfo.mVideoVid, paramBaseArticleInfo.innerUniqueID, paramped.a().b(), null), false);
            }
            return;
            localBundle = a(paramsdg, paramBaseArticleInfo, paramped.a().a(), paramped);
            break;
            label777:
            i = 1;
            break label163;
            label783:
            if (pay.s(paramBaseArticleInfo))
            {
              localBundle.putInt("VIDEO_FROM_TYPE", 13);
              localBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Long);
              break label295;
            }
            localBundle.putInt("VIDEO_FROM_TYPE", 3);
            break label295;
            label830:
            if (paramped.a().b() == 56)
            {
              if (pay.i(paramBaseArticleInfo))
              {
                localBundle.putInt("VIDEO_FROM_TYPE", 5);
                localBundle.putLong("VIDEO_FROM_POLYMERIC_TOPIC_ID", paramBaseArticleInfo.mPolymericInfo.jdField_f_of_type_Long);
                localBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long);
              }
              for (;;)
              {
                localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 4);
                break;
                if (pay.s(paramBaseArticleInfo))
                {
                  localBundle.putInt("VIDEO_FROM_TYPE", 5);
                  localBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Long);
                }
                else if (paramped.a().a() == 1004L)
                {
                  localBundle.putInt("VIDEO_FROM_TYPE", 25);
                }
                else
                {
                  localBundle.putInt("VIDEO_FROM_TYPE", 2);
                }
              }
            }
            if (paramped.a().b() == 70)
            {
              if (pay.s(paramBaseArticleInfo))
              {
                localBundle.putInt("VIDEO_FROM_TYPE", 14);
                localBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Long);
                break label304;
              }
              localBundle.putInt("VIDEO_FROM_TYPE", 8);
              localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 7);
              break label304;
            }
            if (paramped.a().b() == 40677)
            {
              localBundle.putInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 6);
              localBundle.putInt("VIDEO_FROM_TYPE", 9);
              localBundle.putInt("key_source", 0);
              localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 8);
              break label304;
            }
            if (pcl.c(paramped.a().b()))
            {
              localBundle.putInt("VIDEO_FROM_TYPE", 24);
              break label304;
            }
            if (paramped.a().a() == 3) {
              localBundle.putInt("VIDEO_FROM_TYPE", 6);
            }
            for (;;)
            {
              localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 5);
              break;
              localBundle.putInt("VIDEO_FROM_TYPE", 7);
            }
            label1170:
            if (0L != paramBaseArticleInfo.mChannelID) {
              break label1260;
            }
            i = 1;
          }
        }
        catch (Exception paramsdg)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.video", 2, new Object[] { "openFullVideoPlayActivity MultiVideoConfigHandler.isEnterMultiMode is error:", paramsdg.getMessage() });
            }
            paramBoolean = false;
            continue;
            ((Activity)paramped.a().a()).startActivityForResult((Intent)localObject, i);
            ((Activity)paramped.a().a()).overridePendingTransition(2130772070, 2130772071);
          }
          label1260:
          i = 9091;
        }
      }
    }
  }
  
  private static Bundle b(sdg paramsdg, BaseArticleInfo paramBaseArticleInfo, sdc paramsdc, ped paramped)
  {
    Object localObject1 = null;
    Object localObject2;
    if (pay.n(paramBaseArticleInfo))
    {
      Iterator localIterator = paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (rdn)localIterator.next();
        if ((((rdn)localObject2).jdField_a_of_type_Rdq == null) || (!TextUtils.equals(paramsdg.jdField_c_of_type_JavaLangString, ((rdn)localObject2).jdField_a_of_type_Rdq.jdField_a_of_type_JavaLangString))) {
          break label932;
        }
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (rdn)paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
      }
      localObject1 = new Bundle();
      label377:
      boolean bool;
      if (((rdn)localObject2).jdField_a_of_type_Boolean)
      {
        ((Bundle)localObject1).putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer.jdField_a_of_type_Long);
        ((Bundle)localObject1).putString("VIDEO_H5_URL", ((rdn)localObject2).jdField_a_of_type_Rdq.jdField_c_of_type_JavaLangString);
        ((Bundle)localObject1).putLong("VIDEO_FEED_ID", ((rdn)localObject2).jdField_c_of_type_Long);
        ((Bundle)localObject1).putInt("VIDEO_FEED_TYPE", ((rdn)localObject2).jdField_b_of_type_Int);
        if (((rdn)localObject2).jdField_a_of_type_Rdq != null) {}
        ((Bundle)localObject1).putString("VIDEO_TIME", String.valueOf(paramsdg.jdField_b_of_type_Int));
        ((Bundle)localObject1).putString("VIDEO_WIDTH", String.valueOf(paramsdg.jdField_c_of_type_Int));
        ((Bundle)localObject1).putString("VIDEO_HEIGHT", String.valueOf(paramsdg.jdField_d_of_type_Int));
        ((Bundle)localObject1).putString("VIDEO_VID", paramsdg.jdField_c_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_COVER", paramsdg.jdField_b_of_type_JavaLangString);
        ((Bundle)localObject1).putLong("VIDEO_XG_FILE_SIZE", paramBaseArticleInfo.mXGFileSize);
        ((Bundle)localObject1).putInt("VIDEO_STRATEGY_ID", paramsdg.jdField_g_of_type_Int);
        ((Bundle)localObject1).putLong("VIDEO_ALGORITHM_ID", paramsdg.jdField_g_of_type_Long);
        ((Bundle)localObject1).putString("VIDEO_SECOND_INDEX_INNER_ID", paramsdg.n);
        if ((paramped.a().a() == null) || (paramped.a().a().a() == null) || (paramsdc == null) || (paramped.a().a().a().jdField_c_of_type_Long != paramsdg.jdField_c_of_type_Long)) {
          break label905;
        }
        ((Bundle)localObject1).putLong("VIDEO_PLAY_POSITION", paramsdc.a());
        ((Bundle)localObject1).putString("VIDEO_ARTICLE_ID", ((rdn)localObject2).jdField_g_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_TITLE", ((rdn)localObject2).jdField_a_of_type_JavaLangString);
        ((Bundle)localObject1).putBoolean("IS_FROM_READINJOY_VIDEO_CHANNEL", bkwm.a(paramped.a().a()));
        if (paramsdg.jdField_f_of_type_Int != 1) {
          break label916;
        }
        bool = true;
        label429:
        ((Bundle)localObject1).putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
        ((Bundle)localObject1).putBoolean("isFromKandian", true);
        ((Bundle)localObject1).putLong("channelID", paramBaseArticleInfo.mChannelID);
        ((Bundle)localObject1).putLong("algorithmID", ((rdn)localObject2).jdField_b_of_type_Long);
        ((Bundle)localObject1).putString("innderId", ((rdn)localObject2).jdField_g_of_type_JavaLangString);
        ((Bundle)localObject1).putLong("strategyId", ((rdn)localObject2).jdField_a_of_type_Int);
        ((Bundle)localObject1).putString("VIDEO_THIRD_ICON", paramsdg.jdField_d_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_THIRD_NAME", paramsdg.jdField_e_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_THIRD_ACTION", paramsdg.jdField_f_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_THIRD_URL", paramsdg.jdField_g_of_type_JavaLangString);
        ((Bundle)localObject1).putLong("VIDEO_THRID_URL_EXPIRE_TIME", paramsdg.jdField_f_of_type_Long);
        ((Bundle)localObject1).putInt("VIDEO_ARTICLE_BUSITYPE", paramsdg.jdField_f_of_type_Int);
        paramped = new Bundle();
        paramped.putString("VINFO", paramsdg.jdField_c_of_type_JavaLangString);
        paramped.putString("TINFO", paramsdg.jdField_c_of_type_JavaLangString);
        paramped.putInt("PREVIEW_VIDEO_TIME", paramsdg.jdField_b_of_type_Int);
        if (paramsdc != null) {
          break label922;
        }
      }
      label905:
      label916:
      label922:
      for (int i = 0;; i = (int)paramsdc.a())
      {
        paramped.putInt("PREVIEW_START_POSI", sdi.a(i, paramsdg.jdField_b_of_type_Int));
        paramped.putInt("PREVIEW_VIDEO_WIDTH", paramsdg.jdField_c_of_type_Int);
        paramped.putInt("PREVIEW_VIDEO_HEIGHT", paramsdg.jdField_d_of_type_Int);
        paramped.putInt("FULL_VIDEO_TIME", paramsdg.jdField_b_of_type_Int);
        paramped.putString("source_puin", ((rdn)localObject2).jdField_e_of_type_JavaLangString);
        paramped.putString("ACCOUNT_UIN", ((rdn)localObject2).jdField_e_of_type_JavaLangString);
        paramped.putString("ACCOUNT_NAME", ((rdn)localObject2).jdField_f_of_type_JavaLangString);
        paramped.putInt("TYPE", paramsdg.jdField_f_of_type_Int);
        paramped.putString("ARTICLE_ID", ((rdn)localObject2).jdField_g_of_type_JavaLangString);
        paramped.putInt("layout_item", 5);
        paramped.putBoolean("video_url_load", false);
        paramped.putString("image_url_remote", paramsdg.jdField_b_of_type_JavaLangString);
        paramped.putString("detail_url", ((rdn)localObject2).jdField_d_of_type_JavaLangString + "&sourcefrom=0");
        paramped.putString("video_url", paramsdg.jdField_c_of_type_JavaLangString);
        paramped.putString("title", ((rdn)localObject2).jdField_a_of_type_JavaLangString);
        paramped.putString("req_create_time", pax.a(paramBaseArticleInfo.mTime));
        paramped.putString("brief_key", ((rdn)localObject2).jdField_a_of_type_JavaLangString);
        paramped.putInt("req_type", 140);
        ((Bundle)localObject1).putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)bchh.a(paramped)).getBytes());
        ((Bundle)localObject1).putString("KEY_VIDEO_JSON_LIST", paramBaseArticleInfo.mJsonVideoList);
        return localObject1;
        ((Bundle)localObject1).putString("VIDEO_PUB_ACCOUNT_UIN", ((rdn)localObject2).jdField_e_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_PUB_ACCOUNT_NAME", ((rdn)localObject2).jdField_f_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_H5_URL", ((rdn)localObject2).jdField_d_of_type_JavaLangString);
        break;
        ((Bundle)localObject1).putLong("VIDEO_PLAY_POSITION", 0L);
        break label377;
        bool = false;
        break label429;
      }
      label932:
      break;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     phk
 * JD-Core Version:    0.7.0.1
 */