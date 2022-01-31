package com.tencent.mobileqq.gamecenter.fragment;

import actn;
import ahpf;
import ajae;
import ajyc;
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
import aqqa;
import aqsc;
import aqsd;
import aqsf;
import aqsg;
import aqsh;
import aqsi;
import aqsj;
import aqsk;
import aqsl;
import aqsm;
import aqsn;
import aqsp;
import aqss;
import aqst;
import aqsx;
import aqtk;
import axmt;
import bbct;
import bbqp;
import bbqu;
import bcpw;
import bibq;
import biby;
import bibz;
import bicg;
import bich;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.QQMessageFacade;
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
import com.tencent.mobileqq.gamecenter.view.QQGameIndicator;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import com.tencent.mobileqq.gamecenter.view.QQGameStatusView;
import com.tencent.mobileqq.mini.ui.dialog.DisplayHelper;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
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
import yod;

public class QQGamePubAccountFragment
  extends PublicBaseFragment
  implements Handler.Callback, aqtk, bibq, bicg, Observer
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
  private aqqa jdField_a_of_type_Aqqa;
  private aqsp jdField_a_of_type_Aqsp;
  private bbqu jdField_a_of_type_Bbqu = new aqsc(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FeedsItemData.GameInfo jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo;
  QQGameIndicator jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator;
  public QQGamePubViewpager a;
  private QQGameStatusView jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView;
  private ArrayList<MessageRecord> jdField_a_of_type_JavaUtilArrayList;
  public List<aqsx> a;
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
            } while ((paramJSONObject.optInt("result") != 2) || (this.jdField_a_of_type_Aqqa == null));
            if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameAppId)) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameAppId.equals(paramIntent)))
            {
              this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameStatus = 2;
              this.jdField_a_of_type_Aqqa.a(true);
              this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView.b();
              this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameAppId, 4);
              this.jdField_a_of_type_Aqqa.a(paramIntent, paramString, str, (JSONObject)localObject1, a());
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
                aqst.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sp_key_game_center_feeds_info", this.jdField_b_of_type_JavaUtilMap);
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
          aqst.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sp_key_game_center_feeds_topcard_info", this.e);
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
          aqss.a = localJSONObject1.optInt("video_count");
          aqss.b = localJSONObject1.optInt("video_time") * 1000;
          aqss.c = localJSONObject1.optInt("layer_duration") * 1000;
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
          yod.a(ajae.a(), "769", "205353", str, "76901", "1", "160", new String[] { paramString, "", "20" });
          this.jdField_a_of_type_Aqqa.a(false, true);
          return;
        }
        paramString = (List)this.jdField_b_of_type_JavaUtilMap.get(Long.valueOf(l));
        paramString.addAll(paramIntent);
        this.jdField_b_of_type_JavaUtilMap.put(Long.valueOf(l), paramString);
        i = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem();
      } while ((this.jdField_a_of_type_JavaUtilArrayList == null) || (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) || (((MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(i)).uniseq != l));
      this.jdField_a_of_type_Aqqa.c();
      this.jdField_a_of_type_Aqqa.a(paramIntent);
      return;
      this.e.put(Long.valueOf(l), localObject1);
      int i = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem();
      if (paramIntent.size() == 0)
      {
        this.jdField_d_of_type_JavaUtilMap.put(Long.valueOf(l), aqst.b);
        this.jdField_a_of_type_Aqqa.a(false, false);
        yod.a(ajae.a(), "769", "205353", str, "76901", "1", "160", new String[] { paramString, "", "20" });
      }
      for (;;)
      {
        this.jdField_b_of_type_JavaUtilMap.put(Long.valueOf(l), paramIntent);
        if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) || (((MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(i)).uniseq != l)) {
          break;
        }
        this.jdField_a_of_type_Aqqa.a(paramIntent, (FeedsItemData.TopCardInfo)localObject1);
        a((FeedsItemData.TopCardInfo)localObject1);
        return;
        this.jdField_d_of_type_JavaUtilMap.put(Long.valueOf(l), aqst.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Aqqa.a(false, false);
      }
      yod.a(ajae.a(), "769", "205353", str, "76901", "1", "160", new String[] { paramString, "", "20" });
      QLog.e("QQGamePubAccountFragment", 1, "[onGetGameCenterPubAccountFeeds] get feeds fail.");
      i = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem();
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (i < this.jdField_a_of_type_JavaUtilArrayList.size()) && (((MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(i)).uniseq == l))
      {
        this.jdField_a_of_type_Aqqa.a(false, false);
        this.jdField_d_of_type_JavaUtilMap.put(Long.valueOf(l), aqst.b);
      }
    } while (getActivity() == null);
    label961:
    bcpw.a(getActivity(), ajyc.a(2131710296), 0).a();
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
                ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView, "translationY", new float[] { actn.a(70.0F, getResources()), 0.0F }).setDuration(500L).start();
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
    if (DisplayHelper.isPackageExist(this.jdField_a_of_type_AndroidViewView.getContext(), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gamePkgName))
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView.a(paramTopCardInfo.gameAppId, 1);
      return;
    }
    a(new String[] { paramTopCardInfo.gameAppId });
  }
  
  private void g()
  {
    biby.a();
    biby.a(this);
  }
  
  private void h()
  {
    biby.b(this);
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
    View localView = LayoutInflater.from(getActivity()).inflate(2131559084, null, false);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager = ((QQGamePubViewpager)localView.findViewById(2131366190));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator = ((QQGameIndicator)localView.findViewById(2131371225));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131375389));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369220));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369225));
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(aqst.a(null, null, "https://cmshow.gtimg.cn/client/gameCenter/gamecenter_enter_normal@2x.png", "https://cmshow.gtimg.cn/client/gameCenter/gamecenter_enter_click@2x.png"));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new aqsf(this));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setNestedpParent(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setOffscreenPageLimit(1);
    d();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setAdapter(this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator.setViewPager(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator.a();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator.setPageListener(new aqsg(this));
    int j = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    int i = j;
    if (j >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      i = 0;
    }
    if (this.jdField_a_of_type_Aqsp != null) {
      if (i != 0) {
        break label379;
      }
    }
    label379:
    for (this.jdField_a_of_type_Aqsp.jdField_c_of_type_Boolean = true;; this.jdField_a_of_type_Aqsp.jdField_c_of_type_Boolean = false)
    {
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setCurrentItem(i);
      }
      e();
      if (i == 0)
      {
        yod.a(ajae.a(), "769", "205017", a(0), "76901", "1", "160", new String[] { aqst.a((MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(0)), "0", "8" });
        ((bbqp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(2, ((MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(0)).getExtInfoFromExtStr("pa_msgId"), "");
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
        return aqst.a((MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(i));
      }
    }
    return "";
  }
  
  public String a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return aqst.a((MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), 0);
    }
    return null;
  }
  
  public ArrayList<MessageRecord> a()
  {
    Object localObject = ((QQAppInterface)ajae.a()).a().a("2747277822", 1008, 10);
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
      aqst.a((MessageRecord)((Iterator)localObject).next(), 0);
    }
    return localArrayList;
  }
  
  public void a()
  {
    Object localObject = ajae.a();
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
      String str = getString(2131695576);
      ahpf.a(paramActivity, (QQAppInterface)ajae.a(), "2747277822", 1008, str, true, localBundle);
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
    paramView = (NavBarCommon)paramView.findViewById(2131375327);
    paramView.setBackgroundColor(0);
    ImageView localImageView = (ImageView)paramView.findViewById(2131368742);
    paramView.setRightImage(getResources().getDrawable(2130849067));
    localImageView.setImageResource(2130849539);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368472));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695576);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    paramView.setOnItemSelectListener(new aqsj(this));
    b();
  }
  
  public void a(FeedsItemData.GameInfo paramGameInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo = paramGameInfo;
  }
  
  public void a(String paramString)
  {
    bcpw.a(getActivity(), ajyc.a(2131710314), 0).a();
    aqss.a(getActivity(), a());
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView.a(paramString, 5);
    paramString = new HashMap();
    paramString.put(Integer.valueOf(2), a());
    paramString.put(Integer.valueOf(4), "1");
    yod.a(ajae.a(), "769", "205612", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameAppId, "76903", "1", "160", paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = (WadlParams)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
    if (paramString1 != null) {
      aqss.a(paramString1);
    }
    for (;;)
    {
      paramString1 = new HashMap();
      paramString1.put(Integer.valueOf(2), a());
      paramString1.put(Integer.valueOf(4), "2");
      yod.a(ajae.a(), "769", "205611", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameAppId, "76903", "1", "160", paramString1);
      return;
      bcpw.a(getActivity(), ajyc.a(2131710317), 0).a();
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
      biby.a();
      ArrayList localArrayList = new ArrayList();
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(paramVarArgs[i]);
        i += 1;
      }
      biby.a().a(this);
      biby.a().a(localArrayList);
    }
  }
  
  public View b()
  {
    View localView = LayoutInflater.from(getActivity()).inflate(2131559089, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, false);
    ((ImageView)localView.findViewById(2131365658)).setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_no_message@2x.png"));
    return localView;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void b()
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getActivity(), new aqsk(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(new aqsl(this));
  }
  
  public void b(String paramString)
  {
    if (a().gameAppId.equals(paramString))
    {
      aqst.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameAppId, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gamePkgName, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameTicket, getActivity());
      paramString = new HashMap(10);
      paramString.put(Integer.valueOf(2), a());
      paramString.put(Integer.valueOf(6), a().gameAppId);
      paramString.put(Integer.valueOf(4), "20");
      yod.a(ajae.a(), "769", "205613", a().gameAppId, "76903", "1", "160", paramString);
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
        Object localObject1 = (bbqp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
        Object localObject2 = aqst.a((MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(i), 0);
        String str = aqst.a((MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(i), 2);
        ((bbqp)localObject1).a(aqst.a(localMessageRecord), localMessageRecord.uniseq, localMessageRecord.time, localArrayList, paramBoolean, (String)localObject2, str);
      } while (this.jdField_a_of_type_Aqqa == null);
      if (!paramBoolean)
      {
        this.jdField_a_of_type_Aqqa.a(true, false);
        return;
      }
      this.jdField_a_of_type_Aqqa.a(true, false);
      return;
    } while ((this.jdField_a_of_type_Aqqa == null) || (paramBoolean));
    this.jdField_a_of_type_Aqqa.a(false, false);
  }
  
  public void c()
  {
    localLinearLayoutManager = new LinearLayoutManager(getActivity());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setItemAnimator(null);
    localLinearLayoutManager.setOrientation(1);
    this.jdField_a_of_type_JavaUtilArrayList = a();
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      this.jdField_a_of_type_Aqsp = new aqsp(getActivity(), (MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(0));
    }
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_c_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_Boolean = false;
    try
    {
      aqss.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject3 = (Queue)aqst.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sp_key_game_center_feeds_red_dot_status");
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = new ArrayDeque(100);
      }
      aqst.jdField_a_of_type_JavaUtilQueue = (Queue)localObject1;
      localObject1 = (Map)aqst.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sp_key_game_center_feeds_info");
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
        this.jdField_a_of_type_Aqqa = new aqqa(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
        this.jdField_a_of_type_Aqqa.a(a());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bbqu);
        this.jdField_a_of_type_Aqqa.a();
        this.jdField_a_of_type_Aqqa.b();
        Object localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager == null)
        {
          i = 0;
          if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= i)) {
            break label966;
          }
          localObject2 = (MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          localObject3 = (List)this.jdField_b_of_type_JavaUtilMap.get(Long.valueOf(((MessageRecord)localObject2).uniseq));
          localObject4 = (FeedsItemData.TopCardInfo)this.e.get(Long.valueOf(((MessageRecord)localObject2).uniseq));
          this.jdField_a_of_type_Aqqa.a((List)localObject3, (FeedsItemData.TopCardInfo)localObject4);
          a((FeedsItemData.TopCardInfo)localObject4);
          GameCenterVideoViewController.a = 0;
          if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
            break label958;
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
          this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Aqqa);
          this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnScrollListener(new aqsm(this, localLinearLayoutManager));
          return;
          localObject2 = (Map)aqst.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sp_key_game_center_feeds_topcard_info");
          if (localObject2 != null)
          {
            localObject3 = ((Map)localObject2).keySet().iterator();
            for (;;)
            {
              if (!((Iterator)localObject3).hasNext()) {
                break label826;
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
            aqss.a = ((JSONObject)localObject2).optInt("video_count");
            aqss.b = ((JSONObject)localObject2).optInt("video_time") * 1000;
            aqss.c = ((JSONObject)localObject2).optInt("layer_duration") * 1000;
            break;
          }
          QLog.e("QQGamePubAccountFragment", 1, "[initFeeds] condition is null");
          break;
          i = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem();
          break label465;
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
      localObject1 = (Map)aqst.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sp_key_game_center_feeds_position");
      if (localObject1 != null)
      {
        localObject3 = ((Map)localObject1).keySet().iterator();
        for (;;)
        {
          if (!((Iterator)localObject3).hasNext()) {
            break label703;
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
      bich.a().a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameAppId, "10000144");
      paramString = new HashMap();
      yod.a(paramString, a());
      paramString.put(Integer.valueOf(2), a());
      paramString.put(Integer.valueOf(6), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameAppId);
      paramString.put(Integer.valueOf(4), "20");
      paramString.put(Integer.valueOf(18), "GameAIO");
      paramString.put(Integer.valueOf(35), "10000144");
      yod.a(ajae.a(), "769", "205610", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameAppId, "76903", "1", "160", paramString);
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter = new aqsd(this);
  }
  
  public void d(String paramString)
  {
    paramString = "";
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager != null) {
      paramString = a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem());
    }
    Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
    localIntent.putExtra("title", ajyc.a(2131710319));
    localIntent.putExtra("selfSet_leftViewText", getString(2131690572));
    localIntent.putExtra("url", "https://speed.gamecenter.qq.com/pushgame/v1/downloadadmin");
    startActivity(localIntent);
    yod.a(ajae.a(), "769", "205018", paramString, "76902", "1", "160", new String[] { "", "", "" });
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
    int i = (int)((float)(bbct.k() / 2L) - this.jdField_a_of_type_JavaUtilArrayList.size() * 10 * bbct.a / 2.0F - 8.0F * bbct.a);
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
    GameCenterVideoViewController localGameCenterVideoViewController = aqsn.a().a();
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
    aqst.jdField_a_of_type_Boolean = true;
    yod.a(ajae.a(), "769", "205838", "", "76902", "160", "1", null);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559088, paramViewGroup, false);
    paramLayoutInflater = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenterBackground.png");
    paramViewGroup = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362999);
    paramViewGroup.setScaleType(ImageView.ScaleType.FIT_START);
    paramViewGroup.setImageDrawable(paramLayoutInflater);
    if (!axmt.b())
    {
      getActivity().mSystemBarComp = null;
      getActivity().setImmersiveStatus(0);
    }
    a(this.jdField_a_of_type_AndroidViewView);
    a();
    this.jdField_a_of_type_JavaUtilArrayList = a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppInterface());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366191));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370758));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369220));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369225));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView = ((QQGameStatusView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379165));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView.setListener(this);
    g();
    c();
    if (this.jdField_a_of_type_Aqsp != null) {
      this.jdField_a_of_type_Aqsp.a(this.jdField_a_of_type_AndroidViewView);
    }
    bich.a().a(this);
    ((QQAppInterface)ajae.a()).a().addObserver(this);
    ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370757)).setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_newMsg_normal@2x.png"));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new aqsh(this));
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
      localObject1 = new RelativeLayout.LayoutParams(actn.a(220.0F, getResources()), actn.a(220.0F, getResources()));
      ((RelativeLayout.LayoutParams)localObject1).topMargin = actn.a(150.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject1).addRule(14);
      localObject2 = new RelativeLayout.LayoutParams(actn.a(160.0F, getResources()), actn.a(100.0F, getResources()));
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = actn.a(40.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject2).addRule(14);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(paramBundle, (ViewGroup.LayoutParams)localObject1);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(localURLImageView, (ViewGroup.LayoutParams)localObject2);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-1358954496);
      paramBundle = (FrameLayout)getActivity().getWindow().getDecorView();
      paramBundle.addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, new FrameLayout.LayoutParams(-1, -1));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new aqsi(this, paramBundle));
      paramLayoutInflater.edit().putBoolean(paramViewGroup, true).commit();
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 1523	com/tencent/mobileqq/fragment/PublicBaseFragment:onDestroy	()V
    //   4: invokestatic 1288	bich:a	()Lbich;
    //   7: aload_0
    //   8: invokevirtual 1525	bich:b	(Lbicg;)V
    //   11: aload_0
    //   12: getfield 149	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15: ifnull +69 -> 84
    //   18: aload_0
    //   19: getfield 149	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   22: aload_0
    //   23: getfield 88	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_a_of_type_Bbqu	Lbbqu;
    //   26: invokevirtual 1528	com/tencent/mobileqq/app/QQAppInterface:removeObserver	(Lajtg;)V
    //   29: aload_0
    //   30: getfield 149	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   33: ldc_w 1221
    //   36: aload_0
    //   37: getfield 62	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_c_of_type_JavaUtilMap	Ljava/util/Map;
    //   40: invokestatic 298	aqst:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/Object;)V
    //   43: aload_0
    //   44: getfield 149	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   47: ldc_w 303
    //   50: aload_0
    //   51: getfield 66	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:e	Ljava/util/Map;
    //   54: invokestatic 298	aqst:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/Object;)V
    //   57: aload_0
    //   58: getfield 149	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   61: ldc_w 293
    //   64: aload_0
    //   65: getfield 60	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   68: invokestatic 298	aqst:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/Object;)V
    //   71: aload_0
    //   72: getfield 149	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   75: ldc_w 1205
    //   78: getstatic 1216	aqst:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   81: invokestatic 298	aqst:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/Object;)V
    //   84: invokestatic 1390	aqsn:a	()Laqsn;
    //   87: invokevirtual 1529	aqsn:a	()V
    //   90: aload_0
    //   91: getfield 79	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   94: aconst_null
    //   95: invokevirtual 1533	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   98: aload_0
    //   99: getfield 143	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_a_of_type_Aqqa	Laqqa;
    //   102: ifnull +10 -> 112
    //   105: aload_0
    //   106: getfield 143	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_a_of_type_Aqqa	Laqqa;
    //   109: invokevirtual 1534	aqqa:d	()V
    //   112: aload_0
    //   113: getfield 93	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   116: ifnull +107 -> 223
    //   119: iconst_0
    //   120: istore_1
    //   121: iload_1
    //   122: aload_0
    //   123: getfield 93	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   126: invokeinterface 273 1 0
    //   131: if_icmpge +83 -> 214
    //   134: aload_0
    //   135: getfield 93	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   138: iload_1
    //   139: invokeinterface 276 2 0
    //   144: instanceof 1536
    //   147: ifeq +52 -> 199
    //   150: aload_0
    //   151: getfield 93	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   154: iload_1
    //   155: invokeinterface 276 2 0
    //   160: checkcast 1536	com/tencent/mobileqq/gamecenter/view/ArkHeaderView
    //   163: invokevirtual 1537	com/tencent/mobileqq/gamecenter/view/ArkHeaderView:a	()V
    //   166: invokestatic 838	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   169: ifeq +30 -> 199
    //   172: ldc_w 283
    //   175: iconst_2
    //   176: new 110	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   183: ldc_w 1539
    //   186: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: iload_1
    //   190: invokevirtual 1542	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   193: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 842	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: iload_1
    //   200: iconst_1
    //   201: iadd
    //   202: istore_1
    //   203: goto -82 -> 121
    //   206: astore_2
    //   207: aload_2
    //   208: invokevirtual 1543	java/io/IOException:printStackTrace	()V
    //   211: goto -127 -> 84
    //   214: aload_0
    //   215: getfield 93	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   218: invokeinterface 1546 1 0
    //   223: aload_0
    //   224: invokespecial 1548	com/tencent/mobileqq/gamecenter/fragment/QQGamePubAccountFragment:h	()V
    //   227: return
    //   228: astore_2
    //   229: ldc_w 283
    //   232: iconst_1
    //   233: new 110	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   240: ldc_w 1550
    //   243: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload_2
    //   247: invokevirtual 286	java/lang/Throwable:toString	()Ljava/lang/String;
    //   250: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 291	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: goto -36 -> 223
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	this	QQGamePubAccountFragment
    //   120	83	1	i	int
    //   206	2	2	localIOException	java.io.IOException
    //   228	19	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   29	84	206	java/io/IOException
    //   121	199	228	java/lang/Throwable
    //   214	223	228	java/lang/Throwable
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ((QQAppInterface)ajae.a()).a().deleteObserver(this);
  }
  
  public void onPause()
  {
    GameCenterVideoViewController localGameCenterVideoViewController = aqsn.a().a();
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
  }
  
  public void onStart()
  {
    super.onStart();
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_Aqsp != null)) {
      this.jdField_a_of_type_Aqsp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(0), null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment
 * JD-Core Version:    0.7.0.1
 */