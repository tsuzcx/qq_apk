package com.tencent.mobileqq.config.business;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.CommentInfoConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDoingSomething;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyRefreshOptimizeUtil;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.SPEventReportSwitch;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.app.AppRuntime;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadinjoyCommonConfProcessor$ReadinjoyManagerPlatformConfig
{
  private void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    QLog.d("KandianConfigServlet", 1, "[all]updateKandianTabConfigSwitch value : " + paramString);
    long l1 = System.currentTimeMillis();
    Boolean localBoolean = (Boolean)ReadInJoyHelper.a("local_kd_tab_has_set");
    boolean bool3 = TextUtils.equals("1", paramString);
    ReadInJoyHelper.a(paramQQAppInterface, "remote_kd_tab_switch", Boolean.valueOf(bool3));
    boolean bool2;
    if ((localBoolean != null) && (!localBoolean.booleanValue()))
    {
      bool2 = ReadInJoyHelper.a(bool3);
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (!ReadInJoyUtils.a())
        {
          bool1 = bool2;
          if (!ReadInJoyUtils.b())
          {
            ReadInJoyHelper.c();
            ReadInJoyLogicEngineEventDispatcher.a().a(0, null);
          }
        }
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      long l2 = System.currentTimeMillis();
      QLog.d("KandianConfigServlet", 1, "[all]updateKandianTabConfigSwitch tabSwitch = " + bool3 + ", write sp cost:" + (l2 - l1) + ", succ : " + bool1);
      return;
      QLog.d("KandianConfigServlet", 1, "[all]updateKandianTabConfigSwitch user has set switch, give up !");
    }
  }
  
  public void a(QConfItem[] paramArrayOfQConfItem)
  {
    QQAppInterface localQQAppInterface;
    Document localDocument;
    Object localObject2;
    label294:
    label357:
    int i;
    int k;
    label532:
    Object localObject3;
    for (;;)
    {
      String str2;
      String str1;
      try
      {
        localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
        if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length <= 0)) {
          break label6363;
        }
        int j = 0;
        if (j < paramArrayOfQConfItem.length)
        {
          if (TextUtils.isEmpty(paramArrayOfQConfItem[j].a))
          {
            QLog.e("ReadinjoyCommonConfProcessor", 1, "receive empty config content, skip ! index : " + j);
            j += 1;
            continue;
          }
          try
          {
            str2 = paramArrayOfQConfItem[j].a.trim();
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "receiveAllConfigs|type: 92,content: " + str2);
            }
            localDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(str2.getBytes("utf-8")));
            Node localNode = localDocument.getElementsByTagName("configs").item(0).getFirstChild();
            if (localNode == null) {
              continue;
            }
            if (localNode.getFirstChild() != null)
            {
              localObject2 = localNode.getNodeName();
              str1 = localNode.getFirstChild().getNodeValue();
              if (!TextUtils.isEmpty(str1)) {}
            }
            else
            {
              localNode = localNode.getNextSibling();
              continue;
            }
            if (!TextUtils.equals((CharSequence)localObject2, "smartcrop_pic")) {
              break label294;
            }
            ReadInJoyHelper.c(localQQAppInterface, str1);
            continue;
            if (!QLog.isColorLevel()) {
              continue;
            }
          }
          catch (Exception localException1) {}
          QLog.d("ReadinjoyCommonConfProcessor", 2, "exception occurs", localException1);
          continue;
        }
        return;
      }
      catch (Exception paramArrayOfQConfItem)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ReadinjoyCommonConfProcessor", 2, "received readinjoy cropandgroup config error,cmd : 92" + paramArrayOfQConfItem.toString());
        }
      }
      if (TextUtils.equals((CharSequence)localObject2, "feeds_group"))
      {
        ReadInJoyHelper.a(localQQAppInterface, str1);
      }
      else if (TextUtils.equals((CharSequence)localObject2, "remind_only_wifi"))
      {
        ReadInJoyHelper.b(localQQAppInterface, str1);
      }
      else if (TextUtils.equals((CharSequence)localObject2, "kandian_individual_time_push"))
      {
        if (!TextUtils.equals(str1, "1")) {
          break label6384;
        }
        bool = true;
        ReadInJoyHelper.a(localQQAppInterface, bool);
      }
      else if (TextUtils.equals((CharSequence)localObject2, "push_switch"))
      {
        ReadInJoyHelper.d(localQQAppInterface, TextUtils.equals(str1, "1"));
      }
      else
      {
        bool = TextUtils.equals((CharSequence)localObject2, "sticky_times");
        if (bool)
        {
          try
          {
            i = Integer.valueOf(str1).intValue();
            k = Integer.valueOf(localDocument.getElementsByTagName("effective_time").item(0).getFirstChild().getNodeValue()).intValue();
            if ((i >= 0) && (k < 86400)) {
              break label532;
            }
            throw new IllegalArgumentException("stickyTime or effectiveTime has error ! " + i + "," + k);
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
            QLog.d("ReadinjoyCommonConfProcessor", 2, "covert stickyTime and effectiveTime has error : " + localException2);
          }
          continue;
          ((KandianMergeManager)localQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(i, k);
        }
        else
        {
          Object localObject1;
          if (TextUtils.equals((CharSequence)localObject2, "socializeWebUrl"))
          {
            localObject1 = localException1.getFirstChild();
            if (localObject1 != null)
            {
              if (((Node)localObject1).getNodeType() == 1)
              {
                localObject2 = ((Node)localObject1).getNodeName();
                localObject3 = ((Node)localObject1).getFirstChild().getNodeValue();
                if (!ReadInJoyHelper.a((String)localObject2)) {
                  break label640;
                }
                ReadInJoyHelper.a(localQQAppInterface, (String)localObject2, (String)localObject3);
              }
              for (;;)
              {
                localObject1 = ((Node)localObject1).getNextSibling();
                break;
                label640:
                QLog.d("ReadinjoyCommonConfProcessor", 1, "find unrecognized key:" + (String)localObject2 + " with value:" + (String)localObject3);
              }
            }
          }
          else if (TextUtils.equals((CharSequence)localObject2, "free_time_refresh_push"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "updateFreeTimeRefreshPush " + TextUtils.equals((CharSequence)localObject1, "1"));
            }
            ReadInJoyHelper.k(localQQAppInterface, TextUtils.equals((CharSequence)localObject1, "1"));
          }
          else if (TextUtils.equals((CharSequence)localObject2, "kandian_my_tab_page"))
          {
            ReadInJoyHelper.c(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "kandian_gallery_channel_bar_hidden"))
          {
            ReadInJoyHelper.x(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "kandian_gallery_channel_waterfall_bar_hidden"))
          {
            ReadInJoyHelper.y(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "tab_click_gap_in_seconds"))
          {
            SPEventReportSwitch.a(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "tab_click_count_limit"))
          {
            SPEventReportSwitch.b(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "tab_click_push_algo_id"))
          {
            SPEventReportSwitch.c(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "tab_click_forbid_report_time_in_seconds"))
          {
            SPEventReportSwitch.d(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "fore_ground_gap_in_seconds"))
          {
            SPEventReportSwitch.e(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "screen_switch_in_seconds"))
          {
            SPEventReportSwitch.f(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "user_idle_repor"))
          {
            SPEventReportSwitch.g(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "kandian_report_tt"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "kandian_report_tt = " + TextUtils.equals((CharSequence)localObject1, "1"));
            }
            if (TextUtils.equals((CharSequence)localObject1, "1")) {
              ReadInJoyHelper.l(localQQAppInterface, true);
            } else {
              ReadInJoyHelper.l(localQQAppInterface, false);
            }
          }
          else if (TextUtils.equals((CharSequence)localObject2, "kandian_report_user_apps_switch"))
          {
            localObject1 = Boolean.valueOf(TextUtils.equals((CharSequence)localObject1, "1"));
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "kandian_report_user_apps_switch: " + localObject1);
            }
            ReadInJoyHelper.a("kandian_report_user_apps_switch", localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "actKandianReportManyApps"))
          {
            ReadInJoyDoingSomething.a(localException1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "kandian_optimize_strategy"))
          {
            ReadInJoyRefreshOptimizeUtil.a((String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "maintab_reddot_times"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "maintab_reddot_times = " + (String)localObject1);
            }
            ReadInJoyHelper.h(localQQAppInterface, Integer.valueOf((String)localObject1).intValue());
          }
          else if (TextUtils.equals((CharSequence)localObject2, "maintab_reddot_feeds"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "maintab_reddot_feeds = " + (String)localObject1);
            }
            ReadInJoyHelper.i(localQQAppInterface, Integer.valueOf((String)localObject1).intValue());
          }
          else if (TextUtils.equals((CharSequence)localObject2, "feedsbackWebUrl"))
          {
            ReadInJoyHelper.b(localQQAppInterface, (String)localObject2, (String)localObject1);
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "feedsbackWebUrl " + TextUtils.equals((CharSequence)localObject1, "1"));
            }
          }
          else if (TextUtils.equals((CharSequence)localObject2, "feedsbackSwitch"))
          {
            ReadInJoyHelper.b(localQQAppInterface, (String)localObject2, (String)localObject1);
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "feedsbackSwitch " + TextUtils.equals((CharSequence)localObject1, "1"));
            }
          }
          else if (TextUtils.equals((CharSequence)localObject2, "feedsbackName"))
          {
            ReadInJoyHelper.b(localQQAppInterface, (String)localObject2, (String)localObject1);
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "feedsbackName " + TextUtils.equals((CharSequence)localObject1, "1"));
            }
          }
          else if (TextUtils.equals((CharSequence)localObject2, "biufeedsSwitch"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "biufeedsSwitch = " + (String)localObject1);
            }
            ReadInJoyHelper.j(localQQAppInterface, Integer.valueOf((String)localObject1).intValue());
          }
          else if (TextUtils.equals((CharSequence)localObject2, "biufeedsName"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "biufeedsName = " + (String)localObject1);
            }
            ReadInJoyHelper.d(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "biufeedsWebUrl"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "biufeedsWebUrl = " + (String)localObject1);
            }
            ReadInJoyHelper.e(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "badgeNumber"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "badgeNumber = " + (String)localObject1);
            }
            ReadInJoyHelper.x(localQQAppInterface, Integer.valueOf((String)localObject1).intValue());
          }
          else if (TextUtils.equals((CharSequence)localObject2, "biu_word_count"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "biu_word_count = " + (String)localObject1);
            }
            ReadInJoyHelper.f(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "new_channel_style"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "new_channel_style = " + (String)localObject1);
            }
            ReadInJoyHelper.k(localQQAppInterface, Integer.valueOf((String)localObject1).intValue());
          }
          else if (TextUtils.equals((CharSequence)localObject2, "local_record_time"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "local_record_time = " + (String)localObject1);
            }
            ReadInJoyHelper.a(localQQAppInterface, Long.valueOf((String)localObject1).longValue());
          }
          else if (TextUtils.equals((CharSequence)localObject2, "local_record_feeds"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "local_record_feeds = " + (String)localObject1);
            }
            ReadInJoyHelper.y(localQQAppInterface, Integer.valueOf((String)localObject1).intValue());
          }
          else if (TextUtils.equals((CharSequence)localObject2, "local_record_time_weishi"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "local_record_time_weishi = " + (String)localObject1);
            }
            ReadInJoyHelper.b(localQQAppInterface, Long.valueOf((String)localObject1).longValue());
          }
          else if (TextUtils.equals((CharSequence)localObject2, "local_record_feeds_weishi"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "local_record_feeds_weishi = " + (String)localObject1);
            }
            ReadInJoyHelper.z(localQQAppInterface, Integer.valueOf((String)localObject1).intValue());
          }
          else if (TextUtils.equals((CharSequence)localObject2, "kandianWebPreLoadData"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "kandianWebPreLoadData = " + (String)localObject1);
            }
            if (TextUtils.equals((CharSequence)localObject1, "1")) {
              ReadInJoyHelper.q(localQQAppInterface, true);
            } else {
              ReadInJoyHelper.q(localQQAppInterface, false);
            }
          }
          else if ((TextUtils.equals((CharSequence)localObject2, "ExitAIO_Android_Uin")) && (localObject1 != null))
          {
            localObject1 = ((String)localObject1).split(":");
            if (localObject1.length >= 2) {
              ReadInJoyHelper.b(Integer.valueOf(localObject1[0]).intValue(), Integer.valueOf(localObject1[1]).intValue());
            }
          }
          else if (TextUtils.equals((CharSequence)localObject2, "kandian_tab_switch"))
          {
            a(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "kandian_tab_type"))
          {
            ReadInJoyHelper.a(localQQAppInterface, "remote_kd_tab_type", localObject1);
            localObject2 = ReadInJoyHelper.a("local_kd_tab_has_set");
            if (!(localObject2 instanceof Boolean)) {
              break label6378;
            }
            bool = ((Boolean)localObject2).booleanValue();
            label2223:
            if (!bool)
            {
              ReadInJoyHelper.a(localQQAppInterface, "local_kd_tab_type", localObject1);
              QLog.d("ReadinjoyCommonConfProcessor", 1, new Object[] { "receiveKDTabTypeRemoteSP, userHasSetKDTab = ", Boolean.valueOf(bool), ", updateLocalTabSwitch tabType = ", localObject1 });
            }
            else
            {
              QLog.d("ReadinjoyCommonConfProcessor", 1, new Object[] { "receiveKDTabTypeRemoteSP, userHasSetKDTab = ", Boolean.valueOf(bool), ", no need to updateTabType." });
            }
          }
          else if (TextUtils.equals((CharSequence)localObject2, "DiaobaodeKandian"))
          {
            ReadInJoyHelper.G(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "topic_card_jump"))
          {
            ReadInJoyHelper.a(localQQAppInterface, "kd_topic_recommend_card_jump_switch", Boolean.valueOf(((String)localObject1).equals("1")));
          }
          else if (TextUtils.equals((CharSequence)localObject2, "topic_card_jump_url"))
          {
            ReadInJoyHelper.a(localQQAppInterface, "kd_topic_recommend_card_jump_url", localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "comment_word_count"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "comment_word_count = " + (String)localObject1);
            }
            ReadInJoyHelper.g(localQQAppInterface, (String)localObject1);
          }
          else if ((TextUtils.equals((CharSequence)localObject2, "KW")) && (!TextUtils.isEmpty((CharSequence)localObject1)))
          {
            localObject2 = new HashMap();
            localObject1 = ((String)localObject1).split(",");
            k = localObject1.length;
            i = 0;
            label2487:
            if (i < k)
            {
              localObject3 = localObject1[i].split(":");
              if (localObject3.length != 2) {
                break label6390;
              }
              ((HashMap)localObject2).put(localObject3[1], localObject3[0]);
              break label6390;
            }
            ReadInJoyUtils.a("kandian_aio_sp_word", localObject2, true);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "comment_gif_switch"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "comment_gif_switch = " + (String)localObject1);
            }
            ReadInJoyHelper.h(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "ugc_gif_switch"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "ugc_gif_switch = " + (String)localObject1);
            }
            ReadInJoyHelper.i(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "biu_at_switch"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "biu_at_switch = " + (String)localObject1);
            }
            ReadInJoyHelper.n(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "UGC_at_switch"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "UGC_at_switch = " + (String)localObject1);
            }
            ReadInJoyHelper.m(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "comment_at_switch"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "comment_at_switch = " + (String)localObject1);
            }
            ReadInJoyHelper.v(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "biu_profile_switch"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "biu_profile_switch = " + (String)localObject1);
            }
            ReadInJoyHelper.o(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "IconMerge_BiuMsg"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "IconMerge_BiuMsg = " + (String)localObject1);
            }
            ReadInJoyHelper.b(TextUtils.equals((CharSequence)localObject1, "1"));
          }
          else if (TextUtils.equals((CharSequence)localObject2, "IconMerge_InteractiveMsg"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "IconMerge_InteractiveMsg = " + (String)localObject1);
            }
            ReadInJoyHelper.c(TextUtils.equals((CharSequence)localObject1, "1"));
          }
          else if (TextUtils.equals((CharSequence)localObject2, "IconMerge_SubscribeMsg"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "IconMerge_InteractiveMsg = " + (String)localObject1);
            }
            ReadInJoyHelper.d((String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "nw_support"))
          {
            ReadInJoyHelper.r(localQQAppInterface, TextUtils.equals((CharSequence)localObject1, "1"));
          }
          else if (TextUtils.equals((CharSequence)localObject2, "nw_preload"))
          {
            ReadInJoyHelper.s(localQQAppInterface, TextUtils.equals((CharSequence)localObject1, "1"));
          }
          else if (TextUtils.equals((CharSequence)localObject2, "arkapp_enable_switch"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, new Object[] { "arkapp_enable_switch, value: ", localObject1 });
            }
            ReadInJoyHelper.b(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "exposure_strengthen"))
          {
            ReadInJoyHelper.t(localQQAppInterface, "1".equals(localObject1));
          }
          else if (TextUtils.equals((CharSequence)localObject2, "native_timeout"))
          {
            ReadInJoyHelper.H(localQQAppInterface, (String)localObject1);
            QLog.d("ReadinjoyCommonConfProcessor", 2, "update native engine timeout config : " + (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "diandian_publish_switch_new"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "dian dian right button new config: " + (String)localObject1);
            }
            ReadInJoyHelper.p(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "kandian_publish_switch_new"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "kan dian right button new config: " + (String)localObject1);
            }
            ReadInJoyHelper.q(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "readinjoy_QA_square_autoTimeval"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "readinjoy_QA_square_autoTimeval: " + (String)localObject1);
            }
            ReadInJoyHelper.r(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "WXShareFromKandian_Switch"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "get wx share from readinjoy :" + (String)localObject1);
            }
            ReadInJoyHelper.s(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "proteus_enable"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "get proteus switch from config: " + (String)localObject1);
            }
            ReadInJoyHelper.d("1".equals(localObject1));
          }
          else if (TextUtils.equals((CharSequence)localObject2, "proteus_bid"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "get proteus offline bid from config: " + (String)localObject1);
            }
          }
          else if (TextUtils.equals((CharSequence)localObject2, "proteus_native_article_bid"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "get proteus_native_article_bid: " + (String)localObject1);
            }
          }
          else if (TextUtils.equals((CharSequence)localObject2, "zhitu"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "comment_zhitu_switch:" + (String)localObject1);
            }
            ReadInJoyHelper.j(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "comment_biu_switch"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "comment biu switch :" + (String)localObject1);
            }
            ReadInJoyHelper.t(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "native_comment_biu"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "native comment biu switch:" + (String)localObject1);
            }
            ReadInJoyHelper.u(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "readinjoy_short_video_width_height_ratio"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "readinjoy_short_video_width_height_ratio :" + (String)localObject1);
            }
            ReadInJoyHelper.b(localQQAppInterface, Float.valueOf((String)localObject1).floatValue());
          }
          else if (TextUtils.equals((CharSequence)localObject2, "readinjoy_short_video_max_duration_limit"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "readinjoy_short_video_max_duration_limit :" + (String)localObject1);
            }
            ReadInJoyHelper.v(localQQAppInterface, Integer.valueOf((String)localObject1).intValue());
          }
          else if (TextUtils.equals((CharSequence)localObject2, "multi_video_ad_config"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "multi_video_ad_config :" + (String)localObject1);
            }
            ReadInJoyHelper.B(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "multi_video_interrupted_ad_config"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "multi_video_interrupted_ad_config: " + (String)localObject1);
            }
            ReadInJoyHelper.D(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "record_duration_count"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "record_duration_count :" + (String)localObject1);
            }
            ReadInJoyHelper.g(localQQAppInterface, Integer.valueOf((String)localObject1).intValue());
          }
          else if (TextUtils.equals((CharSequence)localObject2, "kandiansettings"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "kandiansettings :" + str2);
            }
            ReadInJoyHelper.C(localQQAppInterface, str2);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "ReadInJoy_Tab_Auto_Refresh_Time_Duration"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "ReadInJoy_Tab_Auto_Refresh_Time_Duration :" + (String)localObject1);
            }
            ReadInJoyHelper.I(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "ReadInJoy_Message_Auto_Refresh_Time_Duration"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "ReadInJoy_Message_Auto_Refresh_Time_Duration :" + (String)localObject1);
            }
            ReadInJoyHelper.J(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "is_show_weishi_entrance"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "should show weishi entrance : " + (String)localObject1);
            }
            ReadInJoyHelper.C(localQQAppInterface, Integer.valueOf((String)localObject1).intValue());
          }
          else if (TextUtils.equals((CharSequence)localObject2, "is_jump_to_video_content"))
          {
            QLog.d("ReadinjoyCommonConfProcessor", 2, "is_jump_to_video_content: " + (String)localObject1);
            ReadInJoyHelper.K(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "multi_video_ecommerce_entrance_config"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "multi_video_shunt_bar_config: " + (String)localObject1);
            }
            ReadInJoyHelper.F(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "ReadInJoy_Fast_Web_Biu_Cnt_CLose_Switch"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "ReadInJoy_Fast_Web_Biu_Cnt_CLose_Switch: " + (String)localObject1);
            }
            ReadInJoyHelper.k(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "ReadInJoy_Red_Pnt_Push_Article_Preload_Switch"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "ReadInJoy_Red_Pnt_Push_Article_Preload_Switch: " + (String)localObject1);
            }
            ReadInJoyHelper.l(localQQAppInterface, (String)localObject1);
          }
          else if (TextUtils.equals((CharSequence)localObject2, "video_switch"))
          {
            QLog.d("ReadinjoyCommonConfProcessor", 2, "video_switch: " + (String)localObject1);
            try
            {
              if (Integer.valueOf((String)localObject1).intValue() != 0) {
                break label6397;
              }
              bool = true;
              label4506:
              ReadInJoyHelper.a("sp_key_readinjoy_video_entrance_reddot_button_switch", Boolean.valueOf(bool));
            }
            catch (NumberFormatException localNumberFormatException1)
            {
              QLog.e("ReadinjoyCommonConfProcessor", 2, "handleReadInJoyCommonConfig: video_switch ", localNumberFormatException1);
            }
          }
          else
          {
            bool = TextUtils.equals((CharSequence)localObject2, "video_type_color");
            if (bool)
            {
              try
              {
                ReadInJoyHelper.a("sp_key_readinjoy_video_entrance_reddot_button_color", Integer.valueOf(Color.parseColor(localNumberFormatException1)));
              }
              catch (IllegalArgumentException localIllegalArgumentException)
              {
                QLog.e("ReadinjoyCommonConfProcessor", 2, "handleReadInJoyCommonConfig: video_type_color", localIllegalArgumentException);
              }
            }
            else if (TextUtils.equals((CharSequence)localObject2, "play_time"))
            {
              ReadInJoyHelper.a("sp_key_readinjoy_video_entrance_reddot_expire_time_list", localIllegalArgumentException);
            }
            else if (TextUtils.equals((CharSequence)localObject2, "ReadInJoy_guanzhu_Auto_Refresh_Time_Duration"))
            {
              i = Integer.valueOf(localIllegalArgumentException).intValue();
              ReadInJoyHelper.a("sp_key_kandian_subscribe_auto_refresh_config", Integer.valueOf(i));
              QLog.d("ReadinjoyCommonConfProcessor", 2, "update kandian subscribe auto refresh config : " + i);
            }
            else if (TextUtils.equals((CharSequence)localObject2, "sharp_pic_support_switch"))
            {
              ReadInJoyHelper.a("sp_native_web_sharpp_pic_switch", Boolean.valueOf("1".equals(localIllegalArgumentException)));
            }
            else if (TextUtils.equals((CharSequence)localObject2, "video_feeds_preload_switch"))
            {
              ReadInJoyHelper.n(localQQAppInterface, "1".equals(localIllegalArgumentException));
            }
            else if (TextUtils.equals((CharSequence)localObject2, "enable_preoutput_kandianvideo_first_frame"))
            {
              ReadInJoyHelper.g(localQQAppInterface, "1".equals(localIllegalArgumentException));
            }
            else if (TextUtils.equals((CharSequence)localObject2, "rij_discover_entrance_show"))
            {
              ReadInJoyHelper.A(localQQAppInterface, localIllegalArgumentException);
            }
            else if (TextUtils.equals((CharSequence)localObject2, "readinjoy_small_video_pack_ui_style"))
            {
              ReadInJoyHelper.z(localQQAppInterface, str2);
            }
            else if (TextUtils.equals((CharSequence)localObject2, "hot_comment_number"))
            {
              i = Integer.parseInt(localIllegalArgumentException);
              ReadInJoyHelper.a(CommentInfoConstants.READINJOY_COMMENT_HOT_NUM, Integer.valueOf(i));
            }
            else if (TextUtils.equals((CharSequence)localObject2, "hot_comment_likes_number"))
            {
              i = Integer.parseInt(localIllegalArgumentException);
              ReadInJoyHelper.a(CommentInfoConstants.READINJOY_COMMENT_HOT_COMMENT_LIKE_FILTER, Integer.valueOf(i));
            }
            else if (TextUtils.equals((CharSequence)localObject2, "weishi_with_channel_discovery_switch"))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ReadinjoyCommonConfProcessor", 2, "weishi_with_channel_discovery_switch: " + localIllegalArgumentException);
              }
              ReadInJoyHelper.e(localIllegalArgumentException);
            }
            else if (TextUtils.equals((CharSequence)localObject2, "ugc_upload_lbs_switch"))
            {
              i = Integer.parseInt(localIllegalArgumentException);
              ReadInJoyHelper.a(CommentInfoConstants.READINJOY_UGC_LBS, Integer.valueOf(i));
            }
            else if (TextUtils.equals((CharSequence)localObject2, "local_record_time_weishi_recommend"))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ReadinjoyCommonConfProcessor", 2, "local_record_time_weishi_recommend: " + localIllegalArgumentException);
              }
              ReadInJoyHelper.b(localIllegalArgumentException);
            }
            else if (TextUtils.equals((CharSequence)localObject2, "local_record_feeds_counts_weishi_recommend"))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ReadinjoyCommonConfProcessor", 2, "local_record_feeds_counts_weishi_recommend: " + localIllegalArgumentException);
              }
              ReadInJoyHelper.c(localIllegalArgumentException);
            }
            else
            {
              if (!TextUtils.equals((CharSequence)localObject2, "kandian_aladdin_configuration_switch")) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("ReadinjoyCommonConfProcessor", 2, "kandian_aladdin_configuration_switch: " + localIllegalArgumentException);
              }
              ReadInJoyHelper.a("should_request_aladdin_config", Boolean.valueOf(TextUtils.equals("1", localIllegalArgumentException)));
            }
          }
        }
      }
    }
    boolean bool = TextUtils.equals((CharSequence)localObject2, "publish_topic");
    if (bool) {}
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          for (;;)
          {
            for (;;)
            {
              for (;;)
              {
                for (;;)
                {
                  for (;;)
                  {
                    for (;;)
                    {
                      try
                      {
                        if (Integer.valueOf(localIllegalArgumentException).intValue() != 1) {
                          break label6403;
                        }
                        bool = true;
                        ReadInJoyHelper.a("sp_key_create_topic_switch", Boolean.valueOf(bool));
                      }
                      catch (Exception localException10)
                      {
                        int m;
                        continue;
                      }
                      if (!QLog.isColorLevel()) {
                        break;
                      }
                      QLog.d("ReadinjoyCommonConfProcessor", 2, "publish_topic: " + localIllegalArgumentException);
                      break;
                      if (TextUtils.equals((CharSequence)localObject2, "coin_item_jump_url"))
                      {
                        ReadInJoyHelper.a("readinjoy_coin_item_jump_url", localIllegalArgumentException);
                        if (!QLog.isColorLevel()) {
                          break;
                        }
                        QLog.d("ReadinjoyCommonConfProcessor", 2, "coin_item_jump_url: " + localIllegalArgumentException);
                        break;
                      }
                      if (TextUtils.equals((CharSequence)localObject2, "coin_item_wording"))
                      {
                        ReadInJoyHelper.a("readinjoy_coin_item_title", localIllegalArgumentException);
                        if (!QLog.isColorLevel()) {
                          break;
                        }
                        QLog.d("ReadinjoyCommonConfProcessor", 2, "coin_item_wording: " + localIllegalArgumentException);
                        break;
                      }
                      if (TextUtils.equals((CharSequence)localObject2, "user_behavior_norm_switch"))
                      {
                        PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication()).edit().putString("qq_readinjoy_user_protocol_92_switch_" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), localIllegalArgumentException).apply();
                        if (!QLog.isColorLevel()) {
                          break;
                        }
                        QLog.d("ReadinjoyCommonConfProcessor", 2, "user_behavior_norm_switch: " + localIllegalArgumentException);
                        break;
                      }
                      if (TextUtils.equals((CharSequence)localObject2, "user_behavior_norm_jump_url"))
                      {
                        PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication()).edit().putString("qq_readinjoy_user_protocol_92_jump_url_" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), localIllegalArgumentException).apply();
                        if (!QLog.isColorLevel()) {
                          break;
                        }
                        QLog.d("ReadinjoyCommonConfProcessor", 2, "user_behavior_norm_jump_url: " + localIllegalArgumentException);
                        break;
                      }
                      if (!TextUtils.equals((CharSequence)localObject2, "awake_time")) {
                        continue;
                      }
                      localObject2 = localDocument.getElementsByTagName("awake_position");
                      if ((localObject2 == null) || (((NodeList)localObject2).item(0) == null) || (((NodeList)localObject2).item(0).getFirstChild() == null)) {
                        break;
                      }
                      localObject2 = localDocument.getElementsByTagName("awake_switch");
                      if ((localObject2 == null) || (((NodeList)localObject2).item(0) == null) || (((NodeList)localObject2).item(0).getFirstChild() == null)) {
                        break;
                      }
                      localObject2 = localDocument.getElementsByTagName("awake_position").item(0).getFirstChild().getNodeValue();
                      localObject3 = localDocument.getElementsByTagName("awake_switch").item(0).getFirstChild().getNodeValue();
                      try
                      {
                        i = Integer.parseInt((String)localObject2);
                        k = Integer.parseInt(localIllegalArgumentException);
                        m = Integer.parseInt((String)localObject3);
                        if ((k >= 0) && (k <= 86400) && (i >= 0) && (m >= 0) && (m <= 1)) {
                          continue;
                        }
                        QLog.d("ReadinjoyCommonConfProcessor", 2, "sticky kandian subscribe config value is invalid");
                      }
                      catch (NumberFormatException localNumberFormatException2)
                      {
                        localNumberFormatException2.printStackTrace();
                      }
                    }
                    break;
                    ((KandianSubscribeManager)localQQAppInterface.getManager(QQManagerFactory.KANDIAN_SUBSCRIBE_MANAGER)).a(k, i, m);
                    break;
                    if (TextUtils.equals((CharSequence)localObject2, "kandian_feature_compute"))
                    {
                      ReadInJoyHelper.a("kandianreport_ON", Integer.valueOf(Integer.parseInt(localNumberFormatException2)));
                      break;
                    }
                    if (!TextUtils.equals((CharSequence)localObject2, "kdad_exposure_report_threshold")) {
                      continue;
                    }
                    if (QLog.isColorLevel()) {
                      QLog.d("ReadinjoyCommonConfProcessor", 2, "kdad_exposure_report_threshold = " + localNumberFormatException2);
                    }
                    try
                    {
                      m = Integer.parseInt(localNumberFormatException2);
                      i = ReadInJoyConstants.c;
                      k = i;
                      if (m == 1)
                      {
                        k = i;
                        if (((Element)localException1).hasAttribute("time"))
                        {
                          k = Integer.parseInt(((Element)localException1).getAttribute("time"));
                          if (k <= 0) {
                            break label6415;
                          }
                          i = k;
                          break label6409;
                        }
                      }
                      ReadInJoyHelper.D(localQQAppInterface, k);
                    }
                    catch (Exception localException3)
                    {
                      localException3.printStackTrace();
                    }
                  }
                  break;
                  if (TextUtils.equals((CharSequence)localObject2, "kandian_daily_fast_web_bottom_share"))
                  {
                    ReadInJoyHelper.a("kandian_daily_fast_web_bottom_share", localException3);
                    break;
                  }
                  bool = TextUtils.equals((CharSequence)localObject2, "kandian_comment_limit_number");
                  if (!bool) {
                    continue;
                  }
                  try
                  {
                    ReadInJoyHelper.f(Integer.parseInt(localException3));
                  }
                  catch (Exception localException4)
                  {
                    localException4.printStackTrace();
                  }
                }
                break;
                bool = TextUtils.equals((CharSequence)localObject2, "title_label_number_of_lines");
                if (!bool) {
                  continue;
                }
                try
                {
                  ReadInJoyHelper.g(Integer.parseInt(localException4));
                }
                catch (Exception localException5)
                {
                  localException5.printStackTrace();
                }
              }
              break;
              bool = TextUtils.equals((CharSequence)localObject2, "is_play_comment_button_show");
              if (!bool) {
                continue;
              }
              try
              {
                ReadInJoyHelper.h(Integer.parseInt(localException5));
              }
              catch (Exception localException6)
              {
                localException6.printStackTrace();
              }
            }
            break;
            bool = TextUtils.equals((CharSequence)localObject2, "readinjoy_video_ff_probesize");
            if (!bool) {
              continue;
            }
            try
            {
              if (QLog.isColorLevel()) {
                QLog.d("ReadinjoyCommonConfProcessor", 2, "readinjoy_video_ff_probesize: " + localException6);
              }
              ReadInJoyHelper.a("readinjoy_video_ff_probesize", Long.valueOf(Long.parseLong(localException6)));
            }
            catch (Exception localException7)
            {
              localException7.printStackTrace();
            }
          }
          break;
          bool = TextUtils.equals((CharSequence)localObject2, "readinjoy_video_is_ff_probelist_switch");
          if (!bool) {
            continue;
          }
          try
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyCommonConfProcessor", 2, "readinjoy_video_is_ff_probelist_switch: " + localException7);
            }
            ReadInJoyHelper.a("readinjoy_video_is_ff_probelist_switch", Integer.valueOf(Integer.parseInt(localException7)));
          }
          catch (Exception localException8)
          {
            localException8.printStackTrace();
          }
        }
        break;
        bool = TextUtils.equals((CharSequence)localObject2, "readinjoy_video_is_download_async_io");
        if (!bool) {
          continue;
        }
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReadinjoyCommonConfProcessor", 2, "readinjoy_video_is_download_async_io: " + localException8);
          }
          ReadInJoyHelper.a("readinjoy_video_is_download_async_io", Integer.valueOf(Integer.parseInt(localException8)));
        }
        catch (Exception localException9)
        {
          localException9.printStackTrace();
        }
      }
      break;
      if (TextUtils.equals((CharSequence)localObject2, "kandian_daily_wrapper_alpha"))
      {
        ReadInJoyHelper.a("kandian_daily_wrapper_alpha", localException9);
        break;
      }
      if (TextUtils.equals((CharSequence)localObject2, "kandian_daily_wrapper_default_text"))
      {
        ReadInJoyHelper.a("kandian_daily_wrapper_default_text", localException9);
        break;
      }
      if (TextUtils.equals((CharSequence)localObject2, "kandian_daily_wrapper_drag_text"))
      {
        ReadInJoyHelper.a("kandian_daily_wrapper_drag_text", localException9);
        break;
      }
      if (!TextUtils.equals((CharSequence)localObject2, "video_extract_frame")) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoyCommonConfProcessor", 2, "video_extract_frame = " + localException9);
      }
      ReadInJoyHelper.a("kandian_video_extract_frame", localException9);
      break;
      label6363:
      QLog.d("ReadinjoyCommonConfProcessor", 1, "receiveAllConfigs|type: 92,content_list is empty ");
      return;
      label6378:
      bool = false;
      break label2223;
      label6384:
      bool = false;
      break label357;
      label6390:
      i += 1;
      break label2487;
      label6397:
      bool = false;
      break label4506;
      label6403:
      bool = false;
    }
    label6409:
    label6415:
    for (;;)
    {
      k = i;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.ReadinjoyCommonConfProcessor.ReadinjoyManagerPlatformConfig
 * JD-Core Version:    0.7.0.1
 */