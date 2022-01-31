package com.tencent.mobileqq.gamecenter.fragment;

import aact;
import aekt;
import ajgm;
import akro;
import alpo;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import asfu;
import ashx;
import ashy;
import asia;
import asib;
import asic;
import asid;
import asie;
import asif;
import asig;
import asih;
import asii;
import asil;
import asiy;
import asjb;
import asjc;
import asjl;
import asjy;
import azib;
import bdcb;
import bdem;
import bdpx;
import bdqc;
import bked;
import bkel;
import bkem;
import bket;
import bkeu;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.FriendInfo;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.LabelInfo;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.RedInfo;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.TopCardInfo;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.gamecenter.view.GameSessionView;
import com.tencent.mobileqq.gamecenter.view.QQGameIndicator;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import com.tencent.mobileqq.gamecenter.view.QQGameStatusView;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Queue;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class QQGamePubAccountFragment
  extends PublicBaseFragment
  implements Handler.Callback, asjy, bked, bket, Observer
{
  public static byte[] a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  PagerAdapter jdField_a_of_type_AndroidSupportV4ViewPagerAdapter;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  public GestureDetector a;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private asfu jdField_a_of_type_Asfu;
  private asiy jdField_a_of_type_Asiy;
  private bdqc jdField_a_of_type_Bdqc = new ashx(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FeedsItemData.GameInfo jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo;
  private GameSessionView jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView;
  QQGameIndicator jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator;
  public QQGamePubViewpager a;
  private QQGameStatusView jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView;
  private ArrayList<MessageRecord> jdField_a_of_type_JavaUtilArrayList;
  public List<asjl> a;
  Map<String, WadlParams> jdField_a_of_type_JavaUtilMap = new HashMap();
  public boolean a;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private Map<Long, List<FeedsItemData>> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private Map<Long, Integer> jdField_c_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_c_of_type_Boolean;
  private Map<Long, String> jdField_d_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_d_of_type_Boolean;
  private Map<Long, FeedsItemData.TopCardInfo> e = new HashMap();
  
  static
  {
    jdField_a_of_type_ArrayOfByte = new byte[0];
  }
  
  public QQGamePubAccountFragment()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private static int a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences("game_center_sp", 0).getInt("msgPos" + paramQQAppInterface.getCurrentAccountUin(), 0);
  }
  
  private void a(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
  {
    if ("12820".equals(paramString)) {
      if ((paramIntent == null) || (paramLong != 0L) || (paramJSONObject == null)) {
        if (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView != null) {
          this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView.b();
        }
      }
    }
    label864:
    label997:
    label1003:
    do
    {
      String str;
      Object localObject1;
      long l;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              paramIntent = paramIntent.getStringExtra("appid");
              paramString = paramJSONObject.optString("jump_text");
              str = paramJSONObject.optString("tribe_url");
              localObject1 = paramJSONObject.optJSONObject("share_ark");
            } while ((paramJSONObject.optInt("result") != 2) || (this.jdField_a_of_type_Asfu == null));
            if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameAppId)) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameAppId.equals(paramIntent)))
            {
              this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameStatus = 2;
              this.jdField_a_of_type_Asfu.a(true);
              this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView.b();
              this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameAppId, 4);
              this.jdField_a_of_type_Asfu.a(paramIntent, paramString, str, (JSONObject)localObject1, a());
            }
            try
            {
              if (this.jdField_b_of_type_JavaUtilMap != null)
              {
                paramString = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
                while (paramString.hasNext())
                {
                  paramLong = ((Long)paramString.next()).longValue();
                  paramJSONObject = (List)this.jdField_b_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
                  if ((paramJSONObject != null) && (paramJSONObject.size() > 0) && (!TextUtils.isEmpty(((FeedsItemData)paramJSONObject.get(0)).gameInfo.gameAppId)) && (((FeedsItemData)paramJSONObject.get(0)).gameInfo.gameAppId.equals(paramIntent))) {
                    ((FeedsItemData)paramJSONObject.get(0)).gameInfo.gameStatus = 2;
                  }
                }
                asjc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sp_key_game_center_feeds_info", this.jdField_b_of_type_JavaUtilMap);
              }
            }
            catch (Throwable paramIntent)
            {
              QLog.e("QQGamePubAccountFragment", 1, "savaFeedsData preloadGame error e=" + paramIntent.toString());
              return;
            }
          } while (this.e == null);
          paramString = this.e.keySet().iterator();
          while (paramString.hasNext())
          {
            paramLong = ((Long)paramString.next()).longValue();
            paramJSONObject = (FeedsItemData.TopCardInfo)this.e.get(Long.valueOf(paramLong));
            if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.gameInfo.gameAppId)) && (paramJSONObject.gameInfo.gameAppId.equals(paramIntent))) {
              paramJSONObject.gameInfo.gameStatus = 2;
            }
          }
          asjc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sp_key_game_center_feeds_topcard_info", this.e);
          return;
        } while ((!"12787".equals(paramString)) || (paramIntent == null));
        l = paramIntent.getLongExtra("msgSeq", 0L);
        paramString = paramIntent.getStringExtra("pa_msgId");
        str = paramIntent.getStringExtra("appId");
        boolean bool2 = paramIntent.getBooleanExtra("fromBottom", true);
        if ((paramLong != 0L) || (paramJSONObject == null)) {
          break label2565;
        }
        paramIntent = new ArrayList();
        localObject1 = new FeedsItemData.TopCardInfo();
        Object localObject2 = paramJSONObject.optJSONArray("feed_list");
        JSONObject localJSONObject1 = paramJSONObject.optJSONObject("layer_condition");
        paramJSONObject = paramJSONObject.optJSONObject("top_card");
        Object localObject3;
        Object localObject4;
        int j;
        if (paramJSONObject != null)
        {
          boolean bool1;
          Object localObject6;
          JSONObject localJSONObject2;
          if (paramJSONObject.optInt("top_card_display_flag", 1) == 0)
          {
            bool1 = false;
            ((FeedsItemData.TopCardInfo)localObject1).showTopCard = bool1;
            ((FeedsItemData.TopCardInfo)localObject1).msgId = paramString;
            localObject3 = paramJSONObject.optJSONObject("game_info");
            ((FeedsItemData.TopCardInfo)localObject1).gameInfo = new FeedsItemData.GameInfo();
            if (localObject3 != null)
            {
              ((FeedsItemData.TopCardInfo)localObject1).gameInfo.gameName = ((JSONObject)localObject3).optString("name");
              ((FeedsItemData.TopCardInfo)localObject1).gameInfo.gameIcon = ((JSONObject)localObject3).optString("icon");
              ((FeedsItemData.TopCardInfo)localObject1).gameInfo.gamePkgName = ((JSONObject)localObject3).optString("pkg_name");
              ((FeedsItemData.TopCardInfo)localObject1).gameInfo.gamePkgSize = ((JSONObject)localObject3).optInt("pkg_size");
              ((FeedsItemData.TopCardInfo)localObject1).gameInfo.gameStatus = ((JSONObject)localObject3).optInt("status");
              ((FeedsItemData.TopCardInfo)localObject1).gameInfo.gameApkUrl = ((JSONObject)localObject3).optString("apk_url");
              ((FeedsItemData.TopCardInfo)localObject1).gameInfo.gameAppId = ((JSONObject)localObject3).optString("appid");
              ((FeedsItemData.TopCardInfo)localObject1).gameInfo.gameVersionCode = ((JSONObject)localObject3).optString("version_code");
              ((FeedsItemData.TopCardInfo)localObject1).gameInfo.gameTicket = ((JSONObject)localObject3).optString("tickets");
            }
            ((FeedsItemData.TopCardInfo)localObject1).actionDesc = paramJSONObject.optString("game_info_text");
            localObject3 = paramJSONObject.optJSONArray("entry_list");
            localObject4 = new FeedsItemData.LabelInfo();
            ((FeedsItemData.TopCardInfo)localObject1).labelInfos = new ArrayList();
            if (paramJSONObject.optInt("friend_display_flag", 1) != 0) {
              break label997;
            }
            bool1 = false;
            ((FeedsItemData.LabelInfo)localObject4).showFriend = bool1;
            if (!((FeedsItemData.LabelInfo)localObject4).showFriend) {
              break label1084;
            }
            ((FeedsItemData.LabelInfo)localObject4).isFriend = true;
            ((FeedsItemData.LabelInfo)localObject4).friendType = paramJSONObject.optInt("friend_type");
            ((FeedsItemData.LabelInfo)localObject4).friendNum = paramJSONObject.optInt("game_friend_total_num");
            ((FeedsItemData.LabelInfo)localObject4).reportId = "10001";
            localObject5 = paramJSONObject.optJSONArray("friend_list");
            localObject6 = new ArrayList();
            if ((localObject5 == null) || (((JSONArray)localObject5).length() <= 0)) {
              break label1071;
            }
            i = 0;
            j = ((JSONArray)localObject5).length();
            if (i >= j) {
              break label1064;
            }
            localJSONObject2 = ((JSONArray)localObject5).optJSONObject(i);
            if (localJSONObject2 != null) {
              break label1003;
            }
          }
          for (;;)
          {
            i += 1;
            break label961;
            bool1 = true;
            break;
            bool1 = true;
            break label864;
            FeedsItemData.FriendInfo localFriendInfo = new FeedsItemData.FriendInfo();
            localFriendInfo.icon = localJSONObject2.optString("icon");
            localFriendInfo.name = localJSONObject2.optString("name");
            localFriendInfo.uin = localJSONObject2.optString("uin");
            ((List)localObject6).add(localFriendInfo);
          }
          ((FeedsItemData.LabelInfo)localObject4).friendList = ((List)localObject6);
          ((FeedsItemData.TopCardInfo)localObject1).labelInfos.add(localObject4);
          Object localObject5 = paramJSONObject.optJSONObject("friend_red_point");
          ((FeedsItemData.LabelInfo)localObject4).redInfo = new FeedsItemData.RedInfo();
          if (localObject5 != null)
          {
            ((FeedsItemData.LabelInfo)localObject4).redInfo.redPointId = ((JSONObject)localObject5).optString("red_point_id");
            ((FeedsItemData.LabelInfo)localObject4).redInfo.redPointStartTime = ((JSONObject)localObject5).optLong("begin_time");
            ((FeedsItemData.LabelInfo)localObject4).redInfo.redPointEndTime = ((JSONObject)localObject5).optLong("end_time");
          }
          if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
          {
            i = 0;
            if (i < ((JSONArray)localObject3).length())
            {
              localObject5 = ((JSONArray)localObject3).optJSONObject(i);
              if (localObject5 == null) {}
              for (;;)
              {
                i += 1;
                break;
                localObject4 = new FeedsItemData.LabelInfo();
                ((FeedsItemData.LabelInfo)localObject4).iconUrl = ((JSONObject)localObject5).optString("entry_icon");
                ((FeedsItemData.LabelInfo)localObject4).name = ((JSONObject)localObject5).optString("entry_name");
                ((FeedsItemData.LabelInfo)localObject4).jumpUrl = ((JSONObject)localObject5).optString("entry_url");
                ((FeedsItemData.LabelInfo)localObject4).desc = ((JSONObject)localObject5).optString("entry_text");
                ((FeedsItemData.LabelInfo)localObject4).reportId = ((JSONObject)localObject5).optString("report_id");
                ((FeedsItemData.LabelInfo)localObject4).msgId = paramString;
                ((FeedsItemData.LabelInfo)localObject4).appId = str;
                localObject6 = ((JSONObject)localObject5).optJSONObject("red_point");
                ((FeedsItemData.LabelInfo)localObject4).redInfo = new FeedsItemData.RedInfo();
                if (localObject6 != null)
                {
                  ((FeedsItemData.LabelInfo)localObject4).redInfo.redPointId = ((JSONObject)localObject6).optString("red_point_id");
                  ((FeedsItemData.LabelInfo)localObject4).redInfo.redPointStartTime = ((JSONObject)localObject6).optLong("begin_time");
                  ((FeedsItemData.LabelInfo)localObject4).redInfo.redPointEndTime = ((JSONObject)localObject6).optLong("end_time");
                }
                localObject5 = ((JSONObject)localObject5).optJSONArray("entry_icon_list");
                ((FeedsItemData.LabelInfo)localObject4).icons = new ArrayList();
                if (localObject5 != null)
                {
                  j = 0;
                  if (j < ((JSONArray)localObject5).length())
                  {
                    localObject6 = ((JSONArray)localObject5).optJSONObject(j);
                    if (localObject6 == null) {}
                    for (;;)
                    {
                      j += 1;
                      break;
                      ((FeedsItemData.LabelInfo)localObject4).icons.add(((JSONObject)localObject6).optString("entry_icon"));
                    }
                  }
                }
                ((FeedsItemData.TopCardInfo)localObject1).labelInfos.add(localObject4);
              }
            }
          }
          paramJSONObject = paramJSONObject.optJSONObject("banner");
          if (paramJSONObject != null)
          {
            ((FeedsItemData.TopCardInfo)localObject1).bannerIconZip = paramJSONObject.optString("banner_icon_zip");
            ((FeedsItemData.TopCardInfo)localObject1).bannerGap = paramJSONObject.optInt("banner_gap", 60);
            ((FeedsItemData.TopCardInfo)localObject1).bannerUrl = paramJSONObject.optString("banner_url");
            ((FeedsItemData.TopCardInfo)localObject1).bannerBeginTime = paramJSONObject.optLong("begin_time", 0L);
            ((FeedsItemData.TopCardInfo)localObject1).bannerEndTime = paramJSONObject.optLong("end_time", 0L);
          }
        }
        if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
        {
          i = 0;
          j = ((JSONArray)localObject2).length();
          while (i < j)
          {
            paramJSONObject = new FeedsItemData();
            localObject3 = ((JSONArray)localObject2).optJSONObject(i);
            if (localObject3 == null)
            {
              i += 1;
            }
            else
            {
              localObject4 = ((JSONObject)localObject3).optJSONObject("feed_info");
              paramJSONObject.msgId = paramString;
              paramJSONObject.authorName = ((JSONObject)localObject4).optString("anchor_name");
              paramJSONObject.authorIcon = ((JSONObject)localObject4).optString("anchor_icon");
              paramJSONObject.type = ((JSONObject)localObject4).optInt("feed_type");
              paramJSONObject.feedId = ((JSONObject)localObject4).optString("feed_id");
              paramJSONObject.coverImgUrl = ((JSONObject)localObject4).optString("cover_url");
              paramJSONObject.commentNum = ((JSONObject)localObject4).optInt("comment_num");
              paramJSONObject.title = ((JSONObject)localObject4).optString("title");
              paramJSONObject.jumpUrl = ((JSONObject)localObject4).optString("jump_url");
              paramJSONObject.algorithmId = ((JSONObject)localObject4).optString("algorithm_id");
              if (paramJSONObject.type == 1)
              {
                paramJSONObject.videoUrl = ((JSONObject)localObject4).optString("live_stream_url");
                paramJSONObject.videoViewers = ((JSONObject)localObject4).optInt("live_online_num");
                paramJSONObject.videoSrcName = ((JSONObject)localObject4).optString("video_source");
                paramJSONObject.videoSrcImg = ((JSONObject)localObject4).optString("video_source_icon");
              }
              for (;;)
              {
                paramJSONObject.viewersNum = ((JSONObject)localObject4).optInt("vv");
                localObject3 = ((JSONObject)localObject3).optJSONObject("game_info");
                paramJSONObject.gameInfo = new FeedsItemData.GameInfo();
                paramJSONObject.gameInfo.gameName = ((JSONObject)localObject3).optString("name");
                paramJSONObject.gameInfo.gameIcon = ((JSONObject)localObject3).optString("icon");
                paramJSONObject.gameInfo.gamePkgName = ((JSONObject)localObject3).optString("pkg_name");
                paramJSONObject.gameInfo.gamePkgSize = ((JSONObject)localObject3).optInt("pkg_size");
                paramJSONObject.gameInfo.gameStatus = ((JSONObject)localObject3).optInt("status");
                paramJSONObject.gameInfo.gameApkUrl = ((JSONObject)localObject3).optString("apk_url");
                paramJSONObject.gameInfo.gameAppId = ((JSONObject)localObject3).optString("appid");
                paramJSONObject.gameInfo.gameVersionCode = ((JSONObject)localObject3).optString("version_code");
                paramJSONObject.gameInfo.gameTicket = ((JSONObject)localObject3).optString("tickets");
                paramIntent.add(paramJSONObject);
                break;
                if (paramJSONObject.type == 2)
                {
                  paramJSONObject.videoUrl = ((JSONObject)localObject4).optString("video_url");
                  paramJSONObject.videoDuration = ((JSONObject)localObject4).optInt("video_duration");
                  paramJSONObject.videoSrcType = ((JSONObject)localObject4).optInt("video_source_type");
                  paramJSONObject.videoVid = ((JSONObject)localObject4).optString("video_vid");
                }
              }
            }
          }
        }
        if (localJSONObject1 != null)
        {
          asjb.a = localJSONObject1.optInt("video_count");
          asjb.b = localJSONObject1.optInt("video_time") * 1000;
          asjb.c = localJSONObject1.optInt("layer_duration") * 1000;
          if (getActivity() != null)
          {
            paramJSONObject = getActivity().getSharedPreferences("game_center_sp", 0);
            localObject2 = "sp_key_game_center_feeds_float_condition" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
            paramJSONObject.edit().putString((String)localObject2, localJSONObject1.toString()).commit();
          }
        }
        if (!bool2) {
          break;
        }
        if (paramIntent.size() == 0)
        {
          aact.a(akro.a(), "769", "205353", str, "76901", "1", "160", new String[] { paramString, "", "20" });
          this.jdField_a_of_type_Asfu.a(false, true);
          return;
        }
        paramString = (List)this.jdField_b_of_type_JavaUtilMap.get(Long.valueOf(l));
        paramString.addAll(paramIntent);
        this.jdField_b_of_type_JavaUtilMap.put(Long.valueOf(l), paramString);
        i = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem();
      } while ((this.jdField_a_of_type_JavaUtilArrayList == null) || (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) || (((MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(i)).uniseq != l));
      this.jdField_a_of_type_Asfu.c();
      this.jdField_a_of_type_Asfu.a(paramIntent);
      return;
      this.e.put(Long.valueOf(l), localObject1);
      int i = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem();
      if (paramIntent.size() == 0)
      {
        this.jdField_d_of_type_JavaUtilMap.put(Long.valueOf(l), asjc.b);
        this.jdField_a_of_type_Asfu.a(false, false);
        aact.a(akro.a(), "769", "205353", str, "76901", "1", "160", new String[] { paramString, "", "20" });
      }
      for (;;)
      {
        this.jdField_b_of_type_JavaUtilMap.put(Long.valueOf(l), paramIntent);
        if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) || (((MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(i)).uniseq != l)) {
          break;
        }
        this.jdField_a_of_type_Asfu.a(paramIntent, (FeedsItemData.TopCardInfo)localObject1);
        a((FeedsItemData.TopCardInfo)localObject1);
        return;
        this.jdField_d_of_type_JavaUtilMap.put(Long.valueOf(l), asjc.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Asfu.a(false, false);
      }
      aact.a(akro.a(), "769", "205353", str, "76901", "1", "160", new String[] { paramString, "", "20" });
      QLog.e("QQGamePubAccountFragment", 1, "[onGetGameCenterPubAccountFeeds] get feeds fail.");
      i = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem();
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (i < this.jdField_a_of_type_JavaUtilArrayList.size()) && (((MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(i)).uniseq == l))
      {
        this.jdField_a_of_type_Asfu.a(false, false);
        this.jdField_d_of_type_JavaUtilMap.put(Long.valueOf(l), asjc.b);
      }
    } while (getActivity() == null);
    label961:
    QQToast.a(getActivity(), alpo.a(2131710679), 0).a();
    label1064:
    label1071:
    label1084:
    return;
  }
  
  private void a(FeedsItemData.TopCardInfo paramTopCardInfo)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView.setVisibility(8);
        if ((paramTopCardInfo == null) || (paramTopCardInfo.gameInfo == null) || (TextUtils.isEmpty(paramTopCardInfo.gameInfo.gameAppId))) {
          break;
        }
        Object localObject = paramTopCardInfo.gameInfo;
        String[] arrayOfString;
        if ((paramTopCardInfo.priorities != null) && (paramTopCardInfo.priorities.size() > 0))
        {
          arrayOfString = new String[paramTopCardInfo.priorities.size()];
          paramTopCardInfo.priorities.toArray(arrayOfString);
          QQGameStatusView localQQGameStatusView = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView;
          String str1 = paramTopCardInfo.gameInfo.gameAppId;
          String str2 = ((FeedsItemData.GameInfo)localObject).gameIcon;
          localObject = ((FeedsItemData.GameInfo)localObject).gameName;
          if (paramTopCardInfo.prioritiesIconFlag == 1)
          {
            localQQGameStatusView.a(str1, str2, (String)localObject, arrayOfString, 100, bool);
            if (isAdded())
            {
              if (getResources() != null) {
                ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView, "translationY", new float[] { aekt.a(70.0F, getResources()), 0.0F }).setDuration(500L).start();
              }
              this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView.setVisibility(0);
            }
            b(paramTopCardInfo);
          }
        }
        else
        {
          arrayOfString = new String[1];
          arrayOfString[0] = paramTopCardInfo.actionDesc;
          continue;
        }
        bool = false;
      }
      catch (Throwable paramTopCardInfo)
      {
        paramTopCardInfo.printStackTrace();
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView.setVisibility(8);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("game_center_sp", 0);
    paramQQAppInterface = "msgPos" + paramQQAppInterface.getCurrentAccountUin();
    localSharedPreferences.edit().putInt(paramQQAppInterface, paramInt).commit();
  }
  
  private void b(FeedsItemData.TopCardInfo paramTopCardInfo)
  {
    paramTopCardInfo = paramTopCardInfo.gameInfo;
    if (!paramTopCardInfo.gameAppId.equals(a().gameAppId)) {
      return;
    }
    if (a().gameStatus == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView.a(paramTopCardInfo.gameAppId, 3);
      return;
    }
    if (a().gameStatus == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView.a(paramTopCardInfo.gameAppId, 4);
      return;
    }
    if (bdem.a(this.jdField_a_of_type_AndroidViewView.getContext(), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gamePkgName))
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView.a(paramTopCardInfo.gameAppId, 1);
      return;
    }
    a(new String[] { paramTopCardInfo.gameAppId });
  }
  
  private void g()
  {
    bkel.a();
    bkel.a(this);
  }
  
  private void h()
  {
    bkel.b(this);
  }
  
  public View a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGamePubAccountFragment", 2, "no msg createEmptyView");
      }
      return b();
    }
    View localView = LayoutInflater.from(getActivity()).inflate(2131559125, null, false);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager = ((QQGamePubViewpager)localView.findViewById(2131366278));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator = ((QQGameIndicator)localView.findViewById(2131371537));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131375876));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369453));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369458));
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(asjc.a(null, null, "https://cmshow.gtimg.cn/client/gameCenter/gamecenter_enter_normal@2x.png", "https://cmshow.gtimg.cn/client/gameCenter/gamecenter_enter_click@2x.png"));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new asia(this));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setNestedpParent(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setOffscreenPageLimit(1);
    d();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setAdapter(this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator.setViewPager(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator.a();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator.setPageListener(new asib(this));
    int j = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    int i = j;
    if (j >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      i = 0;
    }
    if (this.jdField_a_of_type_Asiy != null) {
      if (i != 0) {
        break label379;
      }
    }
    label379:
    for (this.jdField_a_of_type_Asiy.jdField_c_of_type_Boolean = true;; this.jdField_a_of_type_Asiy.jdField_c_of_type_Boolean = false)
    {
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setCurrentItem(i);
      }
      e();
      if (i == 0)
      {
        aact.a(akro.a(), "769", "205017", a(0), "76901", "1", "160", new String[] { asjc.a((MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(0)), "0", "8" });
        ((bdpx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(2, ((MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(0)).getExtInfoFromExtStr("pa_msgId"), "");
      }
      return localView;
    }
  }
  
  public FeedsItemData.GameInfo a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo == null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo = new FeedsItemData.GameInfo();
    }
    return this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo;
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager != null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem();
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size()) {
        return asjc.a((MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(i));
      }
    }
    return "";
  }
  
  public String a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return asjc.a((MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), 0);
    }
    return null;
  }
  
  public ArrayList<MessageRecord> a()
  {
    Object localObject = ((QQAppInterface)akro.a()).a().a("2747277822", 1008, 10);
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      int i = ((List)localObject).size() - 1;
      while (i >= 0)
      {
        MessageRecord localMessageRecord = (MessageRecord)((List)localObject).get(i);
        if ("2747277822".equals(localMessageRecord.frienduin))
        {
          if (((localMessageRecord instanceof MessageForArkApp)) || ((localMessageRecord instanceof MessageForPubAccount)) || ((localMessageRecord instanceof MessageForStructing))) {
            localArrayList.add(localMessageRecord);
          }
          if (localArrayList.size() == 3) {
            return localArrayList;
          }
        }
        i -= 1;
      }
    }
    localObject = localArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      asjc.a((MessageRecord)((Iterator)localObject).next(), 0);
    }
    return localArrayList;
  }
  
  public void a()
  {
    Object localObject = akro.a();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (WebProcessManager)((AppInterface)localObject).getManager(13);
      if (localObject != null) {
        ((WebProcessManager)localObject).e();
      }
      localObject = new Intent(getActivity(), WebProcessReceiver.class);
      ((Intent)localObject).setAction("action_download_tbs");
      getActivity().sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
    }
  }
  
  public void a(Activity paramActivity)
  {
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("qqgame_enter", 1);
      String str = getString(2131695735);
      ajgm.a(paramActivity, (QQAppInterface)akro.a(), "2747277822", 1008, str, true, localBundle);
      return;
    }
    catch (Throwable paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QQGamePubAccountFragment", 1, "enterHistory fail :" + paramActivity.getMessage());
    }
  }
  
  public void a(View paramView)
  {
    paramView = (NavBarCommon)paramView.findViewById(2131375812);
    paramView.setBackgroundColor(0);
    ImageView localImageView = (ImageView)paramView.findViewById(2131368961);
    paramView.setRightImage(getResources().getDrawable(2130849504));
    localImageView.setImageResource(2130849988);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368659));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695735);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    paramView.setOnItemSelectListener(new asie(this));
    b();
  }
  
  public void a(FeedsItemData.GameInfo paramGameInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo = paramGameInfo;
  }
  
  public void a(String paramString)
  {
    QQToast.a(getActivity(), alpo.a(2131710697), 0).a();
    asjb.a(getActivity(), a());
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView.a(paramString, 5);
    paramString = new HashMap();
    paramString.put(Integer.valueOf(2), a());
    paramString.put(Integer.valueOf(4), "1");
    aact.a(akro.a(), "769", "205612", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameAppId, "76903", "1", "160", paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = (WadlParams)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
    if (paramString1 != null) {
      asjb.a(paramString1);
    }
    for (;;)
    {
      paramString1 = new HashMap();
      paramString1.put(Integer.valueOf(2), a());
      paramString1.put(Integer.valueOf(4), "2");
      aact.a(akro.a(), "769", "205611", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameAppId, "76903", "1", "160", paramString1);
      return;
      QQToast.a(getActivity(), alpo.a(2131710700), 0).a();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ThreadManagerV2.getUIHandlerV2().post(new QQGamePubAccountFragment.2(this, paramBoolean));
  }
  
  public void a(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      bkel.a();
      ArrayList localArrayList = new ArrayList();
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(paramVarArgs[i]);
        i += 1;
      }
      bkel.a().a(this);
      bkel.a().a(localArrayList);
    }
  }
  
  public View b()
  {
    View localView = LayoutInflater.from(getActivity()).inflate(2131559130, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, false);
    ((ImageView)localView.findViewById(2131365741)).setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_no_message@2x.png"));
    return localView;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void b()
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getActivity(), new asif(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(new asig(this));
  }
  
  public void b(String paramString)
  {
    if (a().gameAppId.equals(paramString))
    {
      asjc.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameAppId, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gamePkgName, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameTicket, getActivity());
      paramString = new HashMap(10);
      paramString.put(Integer.valueOf(2), a());
      paramString.put(Integer.valueOf(6), a().gameAppId);
      paramString.put(Integer.valueOf(4), "20");
      aact.a(akro.a(), "769", "205613", a().gameAppId, "76903", "1", "160", paramString);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_d_of_type_Boolean)) {
      if (QLog.isColorLevel()) {
        QLog.d("QQGamePubAccountFragment", 1, "isLoadMoreing:" + this.jdField_d_of_type_Boolean);
      }
    }
    label338:
    do
    {
      do
      {
        return;
        if ((paramBoolean) && (QLog.isColorLevel())) {
          QLog.d("QQGamePubAccountFragment", 1, "get more data isLoadMoreing:" + this.jdField_d_of_type_Boolean);
        }
        this.jdField_d_of_type_Boolean = true;
        if (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager == null) {}
        MessageRecord localMessageRecord;
        ArrayList localArrayList;
        for (int i = 0;; i = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem())
        {
          if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= i)) {
            break label338;
          }
          localMessageRecord = (MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          localArrayList = new ArrayList();
          localObject1 = (List)this.jdField_b_of_type_JavaUtilMap.get(Long.valueOf(localMessageRecord.uniseq));
          if (localObject1 == null) {
            break;
          }
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (FeedsItemData)((Iterator)localObject1).next();
            if (((FeedsItemData)localObject2).type != 100) {
              localArrayList.add(((FeedsItemData)localObject2).feedId);
            }
          }
        }
        Object localObject1 = (bdpx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
        Object localObject2 = asjc.a((MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(i), 0);
        String str = asjc.a((MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(i), 2);
        ((bdpx)localObject1).a(asjc.a(localMessageRecord), localMessageRecord.uniseq, localMessageRecord.time, localArrayList, paramBoolean, (String)localObject2, str);
      } while (this.jdField_a_of_type_Asfu == null);
      if (!paramBoolean)
      {
        this.jdField_a_of_type_Asfu.a(true, false);
        return;
      }
      this.jdField_a_of_type_Asfu.a(true, false);
      return;
    } while ((this.jdField_a_of_type_Asfu == null) || (paramBoolean));
    this.jdField_a_of_type_Asfu.a(false, false);
  }
  
  public void c()
  {
    localLinearLayoutManager = new LinearLayoutManager(getActivity());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setItemAnimator(null);
    localLinearLayoutManager.setOrientation(1);
    this.jdField_a_of_type_JavaUtilArrayList = a();
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      this.jdField_a_of_type_Asiy = new asiy(getActivity(), (MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(0));
    }
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_c_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_Boolean = false;
    try
    {
      asjb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject3 = (Queue)asjc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sp_key_game_center_feeds_red_dot_status");
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = new ArrayDeque(100);
      }
      asjc.jdField_a_of_type_JavaUtilQueue = (Queue)localObject1;
      localObject1 = (Map)asjc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sp_key_game_center_feeds_info");
      if (localObject1 == null) {
        break label270;
      }
      i = 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject3;
        Object localObject1;
        int i;
        label270:
        long l;
        Object localObject4;
        localException.printStackTrace();
        this.jdField_a_of_type_Asfu = new asfu(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView = new GameSessionView(getActivity());
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_Asfu.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView);
        this.jdField_a_of_type_Asfu.a(a());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bdqc);
        this.jdField_a_of_type_Asfu.a();
        this.jdField_a_of_type_Asfu.b();
        Object localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager == null)
        {
          i = 0;
          if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= i)) {
            break label1012;
          }
          localObject2 = (MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          localObject3 = (List)this.jdField_b_of_type_JavaUtilMap.get(Long.valueOf(((MessageRecord)localObject2).uniseq));
          localObject4 = (FeedsItemData.TopCardInfo)this.e.get(Long.valueOf(((MessageRecord)localObject2).uniseq));
          this.jdField_a_of_type_Asfu.a((List)localObject3, (FeedsItemData.TopCardInfo)localObject4);
          a((FeedsItemData.TopCardInfo)localObject4);
          GameCenterVideoViewController.a = 0;
          if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
            break label1004;
          }
          if (this.jdField_c_of_type_JavaUtilMap.containsKey(Long.valueOf(((MessageRecord)localObject2).uniseq)))
          {
            localObject3 = (Integer)this.jdField_c_of_type_JavaUtilMap.get(Long.valueOf(((MessageRecord)localObject2).uniseq));
            this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.scrollToPosition(((Integer)this.jdField_c_of_type_JavaUtilMap.get(Long.valueOf(((MessageRecord)localObject2).uniseq))).intValue());
            if (((Integer)localObject3).intValue() == 0) {
              ThreadManagerV2.getUIHandlerV2().postDelayed(new QQGamePubAccountFragment.8(this), 1000L);
            }
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Asfu);
          this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnScrollListener(new asih(this, localLinearLayoutManager));
          return;
          localObject2 = (Map)asjc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sp_key_game_center_feeds_topcard_info");
          if (localObject2 != null)
          {
            localObject3 = ((Map)localObject2).keySet().iterator();
            for (;;)
            {
              if (!((Iterator)localObject3).hasNext()) {
                break label872;
              }
              l = ((Long)((Iterator)localObject3).next()).longValue();
              localObject4 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
              if (((Iterator)localObject4).hasNext())
              {
                if (((MessageRecord)((Iterator)localObject4).next()).uniseq != l) {
                  break;
                }
                this.e.put(Long.valueOf(l), ((Map)localObject2).get(Long.valueOf(l)));
              }
            }
          }
          localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences("game_center_sp", 0).getString("sp_key_game_center_feeds_float_condition" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "");
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject2 = new JSONObject((String)localObject2);
            asjb.a = ((JSONObject)localObject2).optInt("video_count");
            asjb.b = ((JSONObject)localObject2).optInt("video_time") * 1000;
            asjb.c = ((JSONObject)localObject2).optInt("layer_duration") * 1000;
            break;
          }
          QLog.e("QQGamePubAccountFragment", 1, "[initFeeds] condition is null");
          break;
          i = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem();
          break label511;
          b(false);
          continue;
          if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
            a(true);
          } else {
            b(false);
          }
        }
        i += 1;
      }
    }
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject3 = (MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (((Map)localObject1).containsKey(Long.valueOf(((MessageRecord)localObject3).uniseq)))
      {
        this.jdField_b_of_type_JavaUtilMap.put(Long.valueOf(((MessageRecord)localObject3).uniseq), ((Map)localObject1).get(Long.valueOf(((MessageRecord)localObject3).uniseq)));
        if (i == 0) {
          this.jdField_b_of_type_Boolean = true;
        }
      }
    }
    else
    {
      localObject1 = (Map)asjc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sp_key_game_center_feeds_position");
      if (localObject1 != null)
      {
        localObject3 = ((Map)localObject1).keySet().iterator();
        for (;;)
        {
          if (!((Iterator)localObject3).hasNext()) {
            break label749;
          }
          l = ((Long)((Iterator)localObject3).next()).longValue();
          localObject4 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (((Iterator)localObject4).hasNext())
          {
            if (((MessageRecord)((Iterator)localObject4).next()).uniseq != l) {
              break;
            }
            this.jdField_c_of_type_JavaUtilMap.put(Long.valueOf(l), ((Map)localObject1).get(Long.valueOf(l)));
          }
        }
      }
    }
  }
  
  public void c(String paramString)
  {
    if ((a().gameAppId.equals(paramString)) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameStatus == 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView.a();
      bkeu.a().a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameAppId, "10000144");
      paramString = new HashMap();
      aact.a(paramString, a());
      paramString.put(Integer.valueOf(2), a());
      paramString.put(Integer.valueOf(6), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameAppId);
      paramString.put(Integer.valueOf(4), "20");
      paramString.put(Integer.valueOf(18), "GameAIO");
      paramString.put(Integer.valueOf(35), "10000144");
      aact.a(akro.a(), "769", "205610", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameAppId, "76903", "1", "160", paramString);
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter = new ashy(this);
  }
  
  public void d(String paramString)
  {
    paramString = "";
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager != null) {
      paramString = a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem());
    }
    Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
    localIntent.putExtra("title", alpo.a(2131710702));
    localIntent.putExtra("selfSet_leftViewText", getString(2131690623));
    localIntent.putExtra("url", "https://speed.gamecenter.qq.com/pushgame/v1/downloadadmin");
    startActivity(localIntent);
    aact.a(akro.a(), "769", "205018", paramString, "76902", "1", "160", new String[] { "", "", "" });
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView == null) || (this.jdField_b_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    int i = (int)((float)(bdcb.k() / 2L) - this.jdField_a_of_type_JavaUtilArrayList.size() * 10 * bdcb.a / 2.0F - 8.0F * bdcb.a);
    this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width = i;
    this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams().width = i;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollToPosition(0);
    }
  }
  
  public HashSet<String> getFilterCmds()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("12820");
    localHashSet.add("12787");
    return localHashSet;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      ((FrameLayout)getActivity().getWindow().getDecorView()).removeView(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
      return true;
    }
    GameCenterVideoViewController localGameCenterVideoViewController = asii.a().a();
    if ((localGameCenterVideoViewController != null) && (localGameCenterVideoViewController.a()))
    {
      localGameCenterVideoViewController.c();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onCmdRsp(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
  {
    ThreadManagerV2.getUIHandlerV2().post(new QQGamePubAccountFragment.14(this, paramIntent, paramString, paramLong, paramJSONObject));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppInterface());
    ((WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).e();
    ((asil)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(358)).b();
    asjc.jdField_a_of_type_Boolean = true;
    aact.a(akro.a(), "769", "205838", "", "76902", "160", "1", null);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559129, paramViewGroup, false);
    paramLayoutInflater = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenterBackground.png");
    paramViewGroup = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363034);
    paramViewGroup.setScaleType(ImageView.ScaleType.FIT_START);
    paramViewGroup.setImageDrawable(paramLayoutInflater);
    if (!azib.b())
    {
      getActivity().mSystemBarComp = null;
      getActivity().setImmersiveStatus(0);
    }
    a(this.jdField_a_of_type_AndroidViewView);
    a();
    this.jdField_a_of_type_JavaUtilArrayList = a();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366279));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131371069));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369453));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369458));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView = ((QQGameStatusView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379868));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView.setListener(this);
    g();
    c();
    if (this.jdField_a_of_type_Asiy != null) {
      this.jdField_a_of_type_Asiy.a(this.jdField_a_of_type_AndroidViewView);
    }
    bkeu.a().a(this);
    ((QQAppInterface)akro.a()).a().addObserver(this);
    ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371068)).setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_newMsg_normal@2x.png"));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new asic(this));
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("game_center_sp", 0);
    paramViewGroup = "sp_key_game_center_guide_is_show" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (!paramLayoutInflater.getBoolean(paramViewGroup, false))
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(getActivity());
      paramBundle = new URLImageView(getActivity());
      URLImageView localURLImageView = new URLImageView(getActivity());
      Object localObject1 = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_guid_rightscroll.png");
      Object localObject2 = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_guid_upscroll.png");
      paramBundle.setImageDrawable((Drawable)localObject1);
      localURLImageView.setImageDrawable((Drawable)localObject2);
      localObject1 = new RelativeLayout.LayoutParams(aekt.a(220.0F, getResources()), aekt.a(220.0F, getResources()));
      ((RelativeLayout.LayoutParams)localObject1).topMargin = aekt.a(150.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject1).addRule(14);
      localObject2 = new RelativeLayout.LayoutParams(aekt.a(160.0F, getResources()), aekt.a(100.0F, getResources()));
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = aekt.a(40.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject2).addRule(14);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(paramBundle, (ViewGroup.LayoutParams)localObject1);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(localURLImageView, (ViewGroup.LayoutParams)localObject2);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-1358954496);
      paramBundle = (FrameLayout)getActivity().getWindow().getDecorView();
      paramBundle.addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, new FrameLayout.LayoutParams(-1, -1));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new asid(this, paramBundle));
      paramLayoutInflater.edit().putBoolean(paramViewGroup, true).commit();
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: invokespecial 1536	com/tencent/mobileqq/fragment/PublicBaseFragment:onDestroy	()V
    //   6: invokestatic 1297	bkeu:a	()Lbkeu;
    //   9: aload_0
    //   10: invokevirtual 1538	bkeu:b	(Lbket;)V
    //   13: aload_0
    //   14: getfield 150	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   17: ifnull +86 -> 103
    //   20: aload_0
    //   21: getfield 150	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   24: aload_0
    //   25: getfield 89	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_a_of_type_Bdqc	Lbdqc;
    //   28: invokevirtual 1541	com/tencent/mobileqq/app/QQAppInterface:removeObserver	(Lalkr;)V
    //   31: aload_0
    //   32: getfield 150	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   35: ldc_w 1221
    //   38: aload_0
    //   39: getfield 63	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_c_of_type_JavaUtilMap	Ljava/util/Map;
    //   42: invokestatic 299	asjc:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/Object;)V
    //   45: aload_0
    //   46: getfield 150	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   49: ldc_w 304
    //   52: aload_0
    //   53: getfield 67	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:e	Ljava/util/Map;
    //   56: invokestatic 299	asjc:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/Object;)V
    //   59: aload_0
    //   60: getfield 150	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   63: ldc_w 294
    //   66: aload_0
    //   67: getfield 61	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   70: invokestatic 299	asjc:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/Object;)V
    //   73: aload_0
    //   74: getfield 150	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   77: ldc_w 1205
    //   80: getstatic 1216	asjc:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   83: invokestatic 299	asjc:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/Object;)V
    //   86: aload_0
    //   87: getfield 150	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   90: sipush 358
    //   93: invokevirtual 1419	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   96: checkcast 1421	asil
    //   99: iconst_0
    //   100: invokevirtual 1543	asil:a	(I)V
    //   103: aload_0
    //   104: getfield 1230	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView	Lcom/tencent/mobileqq/gamecenter/view/GameSessionView;
    //   107: ifnull +10 -> 117
    //   110: aload_0
    //   111: getfield 1230	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView	Lcom/tencent/mobileqq/gamecenter/view/GameSessionView;
    //   114: invokevirtual 1544	com/tencent/mobileqq/gamecenter/view/GameSessionView:b	()V
    //   117: invokestatic 1399	asii:a	()Lasii;
    //   120: invokevirtual 1545	asii:a	()V
    //   123: aload_0
    //   124: getfield 80	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   127: aconst_null
    //   128: invokevirtual 1549	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   131: aload_0
    //   132: getfield 144	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_a_of_type_Asfu	Lasfu;
    //   135: ifnull +10 -> 145
    //   138: aload_0
    //   139: getfield 144	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_a_of_type_Asfu	Lasfu;
    //   142: invokevirtual 1550	asfu:d	()V
    //   145: aload_0
    //   146: getfield 94	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   149: ifnull +105 -> 254
    //   152: iload_1
    //   153: aload_0
    //   154: getfield 94	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   157: invokeinterface 274 1 0
    //   162: if_icmpge +83 -> 245
    //   165: aload_0
    //   166: getfield 94	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   169: iload_1
    //   170: invokeinterface 277 2 0
    //   175: instanceof 1552
    //   178: ifeq +52 -> 230
    //   181: aload_0
    //   182: getfield 94	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   185: iload_1
    //   186: invokeinterface 277 2 0
    //   191: checkcast 1552	com/tencent/mobileqq/gamecenter/view/ArkHeaderView
    //   194: invokevirtual 1553	com/tencent/mobileqq/gamecenter/view/ArkHeaderView:a	()V
    //   197: invokestatic 838	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   200: ifeq +30 -> 230
    //   203: ldc_w 284
    //   206: iconst_2
    //   207: new 111	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   214: ldc_w 1555
    //   217: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: iload_1
    //   221: invokevirtual 1558	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   224: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 842	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   230: iload_1
    //   231: iconst_1
    //   232: iadd
    //   233: istore_1
    //   234: goto -82 -> 152
    //   237: astore_2
    //   238: aload_2
    //   239: invokevirtual 1559	java/io/IOException:printStackTrace	()V
    //   242: goto -156 -> 86
    //   245: aload_0
    //   246: getfield 94	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   249: invokeinterface 1562 1 0
    //   254: aload_0
    //   255: invokespecial 1564	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:h	()V
    //   258: return
    //   259: astore_2
    //   260: ldc_w 284
    //   263: iconst_1
    //   264: new 111	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   271: ldc_w 1566
    //   274: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload_2
    //   278: invokevirtual 287	java/lang/Throwable:toString	()Ljava/lang/String;
    //   281: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokestatic 292	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   290: goto -36 -> 254
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	this	QQGamePubAccountFragment
    //   1	233	1	i	int
    //   237	2	2	localIOException	java.io.IOException
    //   259	19	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   31	86	237	java/io/IOException
    //   152	230	259	java/lang/Throwable
    //   245	254	259	java/lang/Throwable
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ((QQAppInterface)akro.a()).a().deleteObserver(this);
  }
  
  public void onPause()
  {
    GameCenterVideoViewController localGameCenterVideoViewController = asii.a().a();
    if (localGameCenterVideoViewController != null) {
      localGameCenterVideoViewController.h();
    }
    this.jdField_a_of_type_Boolean = true;
    super.onStop();
  }
  
  public void onQueryCallback(ArrayList<WadlResult> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() < 0)) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new QQGamePubAccountFragment.16(this, paramArrayList));
  }
  
  public void onQueryCallbackVia(ArrayList<WadlResult> paramArrayList) {}
  
  public void onResume()
  {
    super.onResume();
    QLog.e("QQGamePubAccountFragment", 1, "[onResume] show floatButton.");
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.notifyDataSetChanged();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView != null) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager != null))
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem();
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (i < this.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        FeedsItemData.TopCardInfo localTopCardInfo = (FeedsItemData.TopCardInfo)this.e.get(Long.valueOf(((MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(i)).uniseq));
        if (localTopCardInfo != null) {
          a(localTopCardInfo);
        }
      }
    }
    ((asil)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(358)).a(0);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("2747277822", 1008, true, true);
  }
  
  public void onStart()
  {
    super.onStart();
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_Asiy != null)) {
      this.jdField_a_of_type_Asiy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(0), null);
    }
  }
  
  public void onWadlTaskStatusChanged(WadlResult paramWadlResult)
  {
    if ((paramWadlResult == null) || (paramWadlResult.a == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQGamePubAccountFragment", 1, "onWadlTaskStatusChanged taskStatus is :" + paramWadlResult.b);
      }
    } while ((paramWadlResult.b == 9) || (paramWadlResult.b == 10) || (paramWadlResult.b == 11) || (paramWadlResult.b == 2) || (paramWadlResult.b == 3) || (paramWadlResult.b == 13));
    ThreadManagerV2.getUIHandlerV2().post(new QQGamePubAccountFragment.15(this, paramWadlResult));
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!(paramObject instanceof MessageRecord)) {}
    do
    {
      return;
      paramObservable = (MessageRecord)paramObject;
    } while ((!"2747277822".equals(paramObservable.frienduin)) || ((!(paramObservable instanceof MessageForArkApp)) && (!(paramObservable instanceof MessageForPubAccount)) && (!(paramObservable instanceof MessageForStructing))) || (this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() >= 5));
    ThreadManagerV2.getUIHandlerV2().post(new QQGamePubAccountFragment.10(this, paramObservable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment
 * JD-Core Version:    0.7.0.1
 */