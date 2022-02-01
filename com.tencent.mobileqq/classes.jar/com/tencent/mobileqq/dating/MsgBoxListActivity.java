package com.tencent.mobileqq.dating;

import Override;
import acvy;
import acwf;
import acwh;
import albc;
import aldk;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import anhk;
import anot;
import arkw;
import arlc;
import arld;
import arle;
import arlf;
import arlg;
import arlh;
import arlj;
import arlu;
import axby;
import axdl;
import axdz;
import axei;
import axks;
import aybs;
import bcst;
import bcsy;
import bgjw;
import bgmp;
import bgng;
import bgsg;
import bgsp;
import bkgm;
import bkhw;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentDarenAssistantItem;
import com.tencent.mobileqq.activity.recent.data.RecentInteractAndFollowItem;
import com.tencent.mobileqq.activity.recent.data.RecentItemNearbyLiveTipData;
import com.tencent.mobileqq.activity.recent.data.RecentMsgBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentYanZhiItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForDarenAssistant;
import com.tencent.mobileqq.data.MessageForInteractAndFollow;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageForYanZhi;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.MsgBoxInterFollowManager;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyFakeActivity;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import nmd;
import tencent.nearby.now.nearby_now_anchor.AnchorStatus;

public class MsgBoxListActivity
  extends BaseMsgBoxActivity
  implements View.OnClickListener, bkhw
{
  Handler jdField_a_of_type_AndroidOsHandler = null;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  anot jdField_a_of_type_Anot = new arlc(this);
  protected arlj a;
  public aybs a;
  RecentBaseData jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData;
  public CarrierHelper.EntranceConfig a;
  private CarrierHelper jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper;
  public View d;
  String d;
  private View jdField_e_of_type_AndroidViewView;
  private String jdField_e_of_type_JavaLangString;
  private View f;
  public boolean f;
  protected boolean g;
  boolean h = false;
  
  public MsgBoxListActivity()
  {
    this.jdField_a_of_type_Arlj = new arlf(this);
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    int i1 = ((Integer)axdz.a(paramQQAppInterface.getCurrentAccountUin(), "key_nearby_msg_box_say_hello_msg_type", Integer.valueOf(0))).intValue();
    int i2 = ((Integer)axdz.a(paramQQAppInterface.getCurrentAccountUin(), "key_nearby_msg_box_comment_zan_msg_type", Integer.valueOf(0))).intValue();
    Object localObject1 = paramQQAppInterface.a(1001).a(paramString, 1001);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("getNearbyMsgBoxUnReadNum mainProcess, rawMsgNum=");
      if (localObject1 != null) {
        break label160;
      }
    }
    int m;
    label160:
    for (int i = 0;; i = ((List)localObject1).size())
    {
      QLog.d("nearby.msgbox.tab", 2, i);
      if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("nearby.msgbox.tab", 2, "msgNum=0, cost=" + (System.currentTimeMillis() - l));
      }
      m = 0;
      return m;
    }
    String str1 = "";
    Object localObject2 = ((List)localObject1).iterator();
    label184:
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      paramString = (MessageRecord)((Iterator)localObject2).next();
      if ((TextUtils.isEmpty(paramString.senderuin)) || (paramString.msgtype == -4011))
      {
        ((Iterator)localObject2).remove();
      }
      else
      {
        if ((paramString instanceof MessageForInteractAndFollow))
        {
          localObject3 = (MessageForInteractAndFollow)paramString;
          if ((((MessageForInteractAndFollow)localObject3).type == 1) || (((MessageForInteractAndFollow)localObject3).type == 2))
          {
            ((Iterator)localObject2).remove();
            continue;
          }
        }
        if ((!paramString.senderuin.equals(anhk.aj)) && (!paramString.senderuin.equals(anhk.ak))) {
          break label949;
        }
      }
    }
    label400:
    label794:
    label928:
    label949:
    for (paramString = paramString.senderuin;; paramString = str1)
    {
      str1 = paramString;
      break label184;
      i = ((List)localObject1).size();
      if (QLog.isColorLevel()) {
        QLog.d("nearby.msgbox.tab", 2, "afterFilter msgNum=" + i);
      }
      if (i == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("nearby.msgbox.tab", 2, "msgNum=0, cost=" + (System.currentTimeMillis() - l));
        }
        return 0;
      }
      int k;
      int j;
      label444:
      String str2;
      if (i <= 50)
      {
        paramString = ((List)localObject1).subList(0, i);
        localObject1 = new ArrayList();
        localObject2 = new ConcurrentHashMap();
        localObject3 = paramString.iterator();
        k = 0;
        i = 0;
        j = 0;
        if (!((Iterator)localObject3).hasNext()) {
          break label845;
        }
        paramString = (MessageRecord)((Iterator)localObject3).next();
        str2 = paramString.senderuin + "_" + paramString.msgtype;
        if (!((ConcurrentHashMap)localObject2).containsKey(str2)) {
          break label603;
        }
        paramString = (RecentBaseData)((ConcurrentHashMap)localObject2).get(str2);
        paramString.update(paramQQAppInterface, BaseApplication.getContext());
        ((List)localObject1).add(paramString);
        if ((paramString.mUnreadFlag != 1) && (paramString.mUnreadFlag != 3)) {
          break label928;
        }
        if (!(paramString instanceof RecentSayHelloBoxItem)) {
          break label735;
        }
        if ((!paramBoolean) || (i1 != 1)) {
          break label705;
        }
        m = k;
        k = 1;
        j = i;
        i = m;
      }
      for (;;)
      {
        m = k;
        k = i;
        i = j;
        j = m;
        break label444;
        i = 50;
        break label400;
        label603:
        if (paramString.senderuin.equals(str1)) {
          paramString = new RecentSayHelloBoxItem(paramString);
        }
        for (;;)
        {
          ((ConcurrentHashMap)localObject2).put(str2, paramString);
          break;
          if ((paramString instanceof MessageForNearbyLiveTip)) {
            paramString = new RecentItemNearbyLiveTipData(paramString);
          } else if ((paramString instanceof MessageForInteractAndFollow)) {
            paramString = new RecentInteractAndFollowItem(paramString);
          } else if ((paramString instanceof MessageForDarenAssistant)) {
            paramString = new RecentDarenAssistantItem(paramString);
          } else {
            paramString = new RecentMsgBoxItem(paramString);
          }
        }
        label705:
        int n = k + paramString.mUnreadNum;
        k = i;
        m = j;
        i = n;
        j = k;
        k = m;
        continue;
        label735:
        if ((paramString instanceof RecentInteractAndFollowItem))
        {
          int i3 = ((RecentInteractAndFollowItem)paramString).a();
          n = k;
          m = i;
          if (i3 > 0)
          {
            if ((!paramBoolean) || (i2 != 1)) {
              break label794;
            }
            m = 1;
            n = k;
          }
          for (;;)
          {
            i = n;
            k = j;
            j = m;
            break;
            n = k + i3;
            m = i;
          }
        }
        if (paramString.mUnreadFlag == 1)
        {
          n = k + paramString.mUnreadNum;
          k = i;
          m = j;
          i = n;
          j = k;
          k = m;
          continue;
          label845:
          if (QLog.isColorLevel()) {
            QLog.d("nearby.msgbox.tab", 2, "unReadNum=" + k + ", timeCost=" + (System.currentTimeMillis() - l));
          }
          ((ConcurrentHashMap)localObject2).clear();
          m = k;
          if (!paramBoolean) {
            break;
          }
          m = k;
          if (k != 0) {
            break;
          }
          if (j == 0)
          {
            m = k;
            if (i == 0) {
              break;
            }
          }
          return -1;
        }
        m = i;
        n = j;
        i = k;
        j = m;
        k = n;
      }
    }
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    Intent localIntent = new Intent(paramContext, MsgBoxListActivity.class);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", paramInt);
    paramContext.startActivity(localIntent);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper.a())
    {
      if (this.jdField_e_of_type_AndroidViewView.getVisibility() != 0)
      {
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView(this.jdField_e_of_type_AndroidViewView);
      }
      if (this.f.getVisibility() != 0)
      {
        this.f.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView(this.f);
      }
    }
    do
    {
      return;
      if (this.jdField_e_of_type_AndroidViewView.getVisibility() != 8)
      {
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.removeHeaderView(this.jdField_e_of_type_AndroidViewView);
      }
    } while (this.f.getVisibility() == 8);
    this.f.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.removeHeaderView(this.f);
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Int != 1010) && (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig != null) && (!bgsp.a(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.iconUrl)) && (!bgsp.a(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.wording)) && (!bgsp.a(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.jumpUrl)))
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.iconUrl, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.wording);
    }
  }
  
  public void OnClick(View paramView, int paramInt) {}
  
  protected List<RecentBaseData> a(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    long l1 = System.currentTimeMillis();
    Iterator localIterator = paramList.iterator();
    long l2;
    if (localIterator.hasNext())
    {
      paramList = (MessageRecord)localIterator.next();
      Object localObject = paramList.senderuin + "_" + paramList.msgtype;
      l2 = System.currentTimeMillis();
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(localObject)) {
        localObject = (RecentBaseData)this.jdField_a_of_type_JavaUtilMap.get(localObject);
      }
      label194:
      do
      {
        ((RecentBaseData)localObject).update(this.app, BaseApplication.getContext());
        localArrayList.add(localObject);
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("MsgBoxListActivity", 4, "item update time cost = " + (System.currentTimeMillis() - l2));
        break;
        if (!paramList.senderuin.equals(this.jdField_c_of_type_JavaLangString)) {
          break label244;
        }
        paramList = new RecentSayHelloBoxItem(paramList);
        this.jdField_a_of_type_JavaUtilMap.put(localObject, paramList);
        localObject = paramList;
      } while (!(paramList instanceof RecentMsgBoxItem));
      localObject = (RecentMsgBoxItem)paramList;
      if (this.jdField_d_of_type_Boolean) {}
      for (int i = 1;; i = 0)
      {
        ((RecentMsgBoxItem)localObject).mFromFlag = i;
        localObject = paramList;
        break;
        label244:
        if ((paramList instanceof MessageForNearbyLiveTip))
        {
          paramList = new RecentItemNearbyLiveTipData(paramList);
          break label194;
        }
        if ((paramList instanceof MessageForInteractAndFollow))
        {
          paramList = new RecentInteractAndFollowItem(paramList);
          break label194;
        }
        if ((paramList instanceof MessageForDarenAssistant))
        {
          paramList = new RecentDarenAssistantItem(paramList);
          break label194;
        }
        if ((paramList instanceof MessageForYanZhi))
        {
          paramList = new RecentYanZhiItem(paramList);
          break label194;
        }
        paramList = new RecentMsgBoxItem(paramList);
        break label194;
      }
    }
    if (QLog.isDevelopLevel())
    {
      l2 = System.currentTimeMillis();
      QLog.d("MsgBoxListActivity", 4, "makeRecetBaseData |start cost time:" + (l2 - l1));
    }
    return localArrayList;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramView == null) {
      return;
    }
    ((View)paramView.getParent()).post(new MsgBoxListActivity.4(this, paramView, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if ((paramRecentBaseData instanceof RecentItemNearbyLiveTipData))
    {
      paramView = (RecentItemNearbyLiveTipData)paramRecentBaseData;
      paramString = paramView.nearbyLiveTipMsg;
      if (paramString != null)
      {
        bgmp localbgmp = bgng.a(this.app, this, paramString.jumpingUrl);
        if (localbgmp != null)
        {
          localbgmp.a();
          if (acwh.g(((RecentItemNearbyLiveTipData)paramRecentBaseData).a()))
          {
            this.app.a().c(((RecentItemNearbyLiveTipData)paramRecentBaseData).mData.senderuin, paramRecentBaseData.getRecentUserType());
            if (acwh.g(paramString.senderuin))
            {
              if (paramView.getUnreadNum() >= 1) {
                break label231;
              }
              paramView = "0";
              bcst.b(null, "dc00899", "grp_lbs", "", "msg_box", "assist_click", 0, 0, "", "", "", paramView);
            }
          }
          this.app.a().c(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType());
          this.app.a().c(((RecentItemNearbyLiveTipData)paramRecentBaseData).a(), paramRecentBaseData.getRecentUserType());
        }
        else
        {
          ThreadManagerV2.excute(new MsgBoxListActivity.7(this, paramString, (axby)this.app.getManager(106)), 32, null, false);
        }
      }
      else
      {
        bcst.b(this.app, "dc00899", "grp_lbs", "", "msg_box", "click_live_message", 0, 0, "", "", "", "");
      }
    }
    label231:
    do
    {
      return;
      paramView = "1";
      break;
      if (!(paramRecentBaseData instanceof RecentInteractAndFollowItem)) {
        break label598;
      }
      aldk.b(this.app, paramRecentBaseData.getRecentUserUin(), this.jdField_a_of_type_Int);
      this.app.a().c(paramRecentBaseData.getRecentUserUin(), this.jdField_a_of_type_Int);
      if (acwh.e(paramRecentBaseData.getRecentUserUin()))
      {
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("url", "https://nearby.qq.com/greeting/notification.html?_bid=2623&_wv=1027");
        startActivityForResult(paramView, 1);
        paramView = ((RecentMsgBoxItem)paramRecentBaseData).mFromFlag + "";
        new bcsy(this.app).a("dc00899").b("grp_lbs").c("msg_box").d("clk_update").a(new String[] { "", "", paramView }).a();
        return;
      }
      if (acwh.f(paramRecentBaseData.getRecentUserUin()))
      {
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("url", "https://nearby.qq.com/greeting/topic.html?_bid=2623&_wv=1027 ");
        startActivityForResult(paramView, 2);
        new bcsy(this.app).a("dc00899").b("grp_lbs").c("msg_box").d("clk_focus").a();
        return;
      }
    } while (!acwh.d(paramRecentBaseData.getRecentUserUin()));
    paramView = new Intent(this, QQBrowserActivity.class);
    paramView.putExtra("url", "https://nearby.qq.com/nearby-index/my_msg.html ");
    startActivityForResult(paramView, 3);
    if (this.jdField_d_of_type_Boolean) {}
    for (paramView = "1";; paramView = "0")
    {
      new bcsy(this.app).a("dc00899").b("grp_lbs").c("msg_box").d("clk_notice").a(new String[] { "", "", paramView }).a();
      return;
    }
    label598:
    if ((paramRecentBaseData instanceof RecentDarenAssistantItem))
    {
      this.app.a().c(paramRecentBaseData.getRecentUserUin(), this.jdField_a_of_type_Int);
      if ((((RecentDarenAssistantItem)paramRecentBaseData).mData instanceof MessageForDarenAssistant))
      {
        paramView = ((MessageForDarenAssistant)((RecentDarenAssistantItem)paramRecentBaseData).mData).jumpUrl;
        if (QLog.isColorLevel()) {
          QLog.i("MsgBoxListActivity", 2, "messageForDarenAssistant.jumpUrl=" + paramView);
        }
        paramView = bgng.a(this.app, this, paramView);
        if (paramView != null) {
          paramView.a();
        }
      }
      new bcsy(this.app).a("dc00899").b("grp_lbs").c("vip_tips").d("clk").a();
      return;
    }
    if ((paramRecentBaseData instanceof RecentYanZhiItem))
    {
      this.app.a().c(paramRecentBaseData.getRecentUserUin(), this.jdField_a_of_type_Int);
      paramView = new Intent(this, QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_e_of_type_JavaLangString);
      startActivity(paramView);
      return;
    }
    super.a(paramView, paramRecentBaseData, paramString, paramBoolean);
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    super.a(paramRecentBaseData, paramString);
    if (paramRecentBaseData != null)
    {
      bgsg.b(this.app.getApp(), this.app.getCurrentAccountUin(), paramRecentBaseData.getRecentUserUin(), 1);
      paramString = "0";
      if ((paramRecentBaseData instanceof RecentMsgBoxItem)) {
        paramString = ((RecentMsgBoxItem)paramRecentBaseData).mFromFlag + "";
      }
      if (!acwh.e(paramRecentBaseData.getRecentUserUin())) {
        break label144;
      }
      bcst.b(this.app, "dc00899", "grp_lbs", "", "msg_box", "swipe_update", 0, 0, "", "", paramString, "");
    }
    for (;;)
    {
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_c_of_type_Int = a(this.app, this.jdField_a_of_type_JavaLangString, false);
        NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, this.jdField_c_of_type_Int);
      }
      return;
      label144:
      if (acwh.f(paramRecentBaseData.getRecentUserUin())) {
        bcst.b(this.app, "dc00899", "grp_lbs", "", "msg_box", "swipe_focus", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void a(RecentItemNearbyLiveTipData paramRecentItemNearbyLiveTipData, List<nearby_now_anchor.AnchorStatus> paramList)
  {
    long l1 = Long.parseLong(paramRecentItemNearbyLiveTipData.nearbyLiveTipMsg.senderuin);
    long l2 = anhk.g;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (nearby_now_anchor.AnchorStatus)paramList.next();
      if ((((nearby_now_anchor.AnchorStatus)localObject).uint64_uin.get() == l1 - l2) && (((nearby_now_anchor.AnchorStatus)localObject).enum_stat.get() == 2))
      {
        localObject = paramRecentItemNearbyLiveTipData.nearbyLiveTipMsg;
        ((MessageForNearbyLiveTip)localObject).isLiving = false;
        ((MessageForNearbyLiveTip)localObject).msg = ((MessageForNearbyLiveTip)localObject).c2cMsgWording;
        ((MessageForNearbyLiveTip)localObject).prewrite();
        this.app.a().a(((MessageForNearbyLiveTip)localObject).senderuin, ((MessageForNearbyLiveTip)localObject).istroop, ((MessageForNearbyLiveTip)localObject).uniseq, ((MessageForNearbyLiveTip)localObject).msgData);
        paramRecentItemNearbyLiveTipData.a(this.app, BaseApplication.getContext());
        this.jdField_a_of_type_Albc.a(((MessageForNearbyLiveTip)localObject).senderuin, this.jdField_a_of_type_Int);
      }
    }
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    if (bgjw.a(paramString1, getString(alcd.a[6])))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData = paramRecentBaseData;
      this.jdField_d_of_type_JavaLangString = paramString2;
      if ((paramRecentBaseData instanceof RecentItemNearbyLiveTipData)) {
        break label45;
      }
      QLog.w("MsgBoxListActivity", 1, "data instanceof RecentItemNearbyLiveTipData = [false]");
    }
    label45:
    do
    {
      return;
      new bcsy(this.app).a("dc00899").b("grp_lbs").c("msg_box").d("unfollow").e(((RecentItemNearbyLiveTipData)paramRecentBaseData).a()).a();
      if (!nmd.a(getApplicationContext()))
      {
        QQToast.a(getApplicationContext(), 1, 2131693946, 0).a();
        return;
      }
      paramString1 = (RecentItemNearbyLiveTipData)paramRecentBaseData;
      if (paramString1.nearbyLiveTipMsg != null) {
        break;
      }
      QLog.w("MsgBoxListActivity", 1, "rData.nearbyLiveTipMsg == null");
    } while (paramString1.mData == null);
    paramString1 = paramString1.mData.senderuin;
    try
    {
      for (;;)
      {
        l = Long.valueOf(paramString1).longValue();
        if (l <= anhk.g) {
          break label283;
        }
        l -= anhk.g;
        this.jdField_a_of_type_Albc.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData, this.jdField_d_of_type_JavaLangString);
        if (this.jdField_d_of_type_Boolean)
        {
          if (this.jdField_a_of_type_Albc.getCount() != 0) {
            break;
          }
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        }
        new axks(this.app).a(l, 0L, 0, 16, false, new arle(this));
        return;
        paramString1 = paramString1.nearbyLiveTipMsg.senderuin;
      }
    }
    catch (NumberFormatException paramString1)
    {
      label283:
      for (;;)
      {
        long l = 0L;
        continue;
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    do
    {
      return;
      localArrayList1 = new ArrayList(10);
      localArrayList2 = new ArrayList(10);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (RecentBaseData)localIterator.next();
        if ((localObject instanceof RecentItemNearbyLiveTipData))
        {
          localObject = (RecentItemNearbyLiveTipData)localObject;
          if ((((RecentItemNearbyLiveTipData)localObject).nearbyLiveTipMsg != null) && (!MessageForNearbyLiveTip.isHuayangTip(((RecentItemNearbyLiveTipData)localObject).nearbyLiveTipMsg.jumpingUrl)) && (((RecentItemNearbyLiveTipData)localObject).nearbyLiveTipMsg.isLiving))
          {
            try
            {
              Long localLong = Long.valueOf(Long.valueOf(Long.parseLong(((RecentItemNearbyLiveTipData)localObject).nearbyLiveTipMsg.senderuin)).longValue() - anhk.g);
              if (!localArrayList1.contains(localLong)) {
                localArrayList1.add(localLong);
              }
              localArrayList2.add(localObject);
            }
            catch (Exception localException) {}
            if (QLog.isColorLevel()) {
              QLog.w("MsgBoxListActivity", 2, localException.toString());
            }
          }
        }
      }
    } while (localArrayList1.size() == 0);
    arlh.a(this.app, localArrayList1, null, new arld(this, localArrayList2));
  }
  
  protected void b(List<MessageRecord> paramList)
  {
    if (paramList.size() == 0) {
      return;
    }
    Object localObject = paramList.iterator();
    ArrayList localArrayList3 = new ArrayList(3);
    ArrayList localArrayList2 = null;
    ArrayList localArrayList1 = null;
    MessageRecord localMessageRecord;
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((TextUtils.isEmpty(localMessageRecord.senderuin)) || (localMessageRecord.msgtype == -4011))
        {
          ((Iterator)localObject).remove();
        }
        else
        {
          MessageForInteractAndFollow localMessageForInteractAndFollow;
          if ((this.jdField_d_of_type_Boolean) && ((localMessageRecord instanceof MessageForInteractAndFollow)))
          {
            localMessageForInteractAndFollow = (MessageForInteractAndFollow)localMessageRecord;
            if ((localMessageForInteractAndFollow.type == 1) || (localMessageForInteractAndFollow.type == 2))
            {
              ((Iterator)localObject).remove();
              continue;
            }
          }
          if ((this.jdField_d_of_type_Boolean) && ((localMessageRecord instanceof MessageForInteractAndFollow)))
          {
            localMessageForInteractAndFollow = (MessageForInteractAndFollow)localMessageRecord;
            if ((localMessageForInteractAndFollow.type == 1) || (localMessageForInteractAndFollow.type == 2))
            {
              ((Iterator)localObject).remove();
              continue;
            }
          }
          if (acwh.c(localMessageRecord.senderuin))
          {
            localArrayList3.add(localMessageRecord);
            ((Iterator)localObject).remove();
          }
          if ((localMessageRecord.senderuin.equals(anhk.aj)) || (localMessageRecord.senderuin.equals(anhk.ak)))
          {
            this.jdField_c_of_type_Boolean = true;
            this.jdField_c_of_type_JavaLangString = localMessageRecord.senderuin;
            localArrayList3.add(localMessageRecord);
            ((Iterator)localObject).remove();
          }
          else if (arkw.b(this.app, localMessageRecord.senderuin, localMessageRecord.istroop))
          {
            if (localArrayList1 != null) {
              break label468;
            }
            localArrayList1 = new ArrayList();
          }
        }
      }
    }
    label468:
    for (;;)
    {
      ((Iterator)localObject).remove();
      localArrayList1.add(localMessageRecord);
      break;
      if (!arkw.a(this.app, localMessageRecord.senderuin, localMessageRecord.istroop)) {
        break;
      }
      if (localArrayList2 == null) {
        localArrayList2 = new ArrayList();
      }
      for (;;)
      {
        ((Iterator)localObject).remove();
        localArrayList2.add(localMessageRecord);
        break;
        localObject = new ArrayList();
        ((List)localObject).addAll(localArrayList3);
        if (0 != 0) {
          ((List)localObject).add(null);
        }
        if ((localArrayList2 != null) && (!localArrayList2.isEmpty())) {
          ((List)localObject).addAll(localArrayList2);
        }
        if ((localArrayList1 != null) && (!localArrayList1.isEmpty())) {
          ((List)localObject).addAll(localArrayList1);
        }
        paramList.addAll(0, (Collection)localObject);
        return;
      }
    }
  }
  
  protected void c()
  {
    if (this.jdField_d_of_type_Boolean) {
      break label7;
    }
    label7:
    while ((this.leftView == null) || (this.mLeftBackText == null) || (this.mLeftBackText == null)) {
      return;
    }
    TextView localTextView;
    if (this.g)
    {
      this.leftView.setVisibility(8);
      this.mLeftBackIcon.setVisibility(0);
      this.mLeftBackText.setVisibility(0);
      localTextView = this.mLeftBackText;
      a(localTextView, 0, 0, 0, (int)(30.0F * this.mDensity + 0.5F));
    }
    for (;;)
    {
      Object localObject = this.app.a();
      if (localObject == null) {
        break;
      }
      int i = ((QQMessageFacade)localObject).b();
      localObject = "" + i;
      if (!this.g)
      {
        localObject = getString(2131718387) + "(" + i + ")";
        if (i > 99) {
          localObject = getString(2131718387) + "(99+)";
        }
      }
      if (i < 0) {
        localObject = getString(2131718387);
      }
      if ((this.g) && (i <= 0)) {
        localTextView.setVisibility(4);
      }
      localTextView.setText((CharSequence)localObject);
      return;
      this.leftView.setVisibility(0);
      this.mLeftBackIcon.setVisibility(8);
      this.mLeftBackText.setVisibility(8);
      localTextView = this.leftView;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 2) || (paramInt1 == 1) || (paramInt1 == 3)) {
      arlh.a(this.app, 2, this.jdField_a_of_type_Arlj);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.g = ThemeUtil.isDefaultOrDIYTheme(false);
    if (this.g)
    {
      if (getTitleBarView() != null) {
        getTitleBarView().setBackgroundDrawable(getResources().getDrawable(2130850088));
      }
      if (this.centerView != null) {
        this.centerView.setTextColor(-1);
      }
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_Aybs = new aybs(this);
    this.jdField_e_of_type_JavaLangString = arlu.a(this.app);
    if (this.jdField_a_of_type_Int == 1010)
    {
      setTitle(2131697865);
      this.b.setVisibility(8);
    }
    for (;;)
    {
      if (this.jdField_d_of_type_Boolean) {
        setTitle(2131693911);
      }
      this.b.setOnClickListener(this);
      this.app.addObserver(this.jdField_a_of_type_Anot, true);
      arlh.a(this.app, 1, this.jdField_a_of_type_Arlj);
      if ((this.jdField_a_of_type_Int != 1001) && (this.jdField_a_of_type_Int != 10002)) {
        break;
      }
      return true;
      if ((this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 10002))
      {
        setTitle(2131692865);
        this.b.setVisibility(8);
        QQAppInterface localQQAppInterface = this.app;
        if (this.jdField_a_of_type_Int == 1001) {}
        for (paramBundle = "0";; paramBundle = "1")
        {
          bcst.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "exp_msg_list", 0, 0, paramBundle, "", "", "");
          break;
        }
      }
      if (this.jdField_a_of_type_Int == 1009)
      {
        setTitle(2131717394);
        this.b.setVisibility(8);
      }
    }
    bcst.b(this.app, "dc00899", "grp_lbs", "", "msg_box", "otherType", 0, 0, this.jdField_a_of_type_Int + "", "", "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    removeObserver(this.jdField_a_of_type_Anot);
    if (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper != null) {
      ThreadManager.post(new MsgBoxListActivity.3(this), 5, null, false);
    }
    if (this.jdField_a_of_type_Aybs != null) {
      this.jdField_a_of_type_Aybs.a();
    }
    axdl.c(1);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper.a(1, Boolean.valueOf(false));
      this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper.a();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    AbstractGifImage.resumeAll();
    c();
    if (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper.a(1, Boolean.valueOf(true));
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.h))
    {
      this.h = true;
      if (this.jdField_a_of_type_AndroidOsHandler == null)
      {
        arlg localarlg = new arlg(this.app.getAccount());
        this.jdField_a_of_type_AndroidOsHandler = new bkgm(ThreadManager.getFileThreadLooper(), localarlg);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 2000L);
    }
  }
  
  public void finish()
  {
    if (((this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 10002)) && (!this.jdField_a_of_type_JavaLangString.equals(anhk.I)))
    {
      this.app.getPreferences().edit().putLong("sp_key_nearby_clean_unread_time", NetConnInfoCenter.getServerTime()).commit();
      this.app.getPreferences().edit().putInt("sp_key_sayhello_box_unread_count", 0).commit();
      this.app.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, true);
      this.app.a().clearMsgBoxUnreadCount();
    }
    super.finish();
  }
  
  public boolean onBackEvent()
  {
    Intent localIntent;
    if (this.jdField_d_of_type_Boolean)
    {
      localIntent = new Intent();
      localIntent.putExtra("isNeedFinish", true);
      setResult(-1, localIntent);
      finish();
    }
    for (;;)
    {
      return super.onBackEvent();
      localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.b);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig == null)
      {
        if (QLog.isColorLevel()) {
          axei.a("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        }
        if (this.jdField_a_of_type_Int == 1010)
        {
          label74:
          axdl.b(1);
          label78:
          if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
            break label355;
          }
        }
      }
      label355:
      for (Object localObject = "";; localObject = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString())
      {
        if (this.jdField_a_of_type_Int != 1010) {
          break label371;
        }
        bcst.b(this.app, "CliOper", "", "", "0X8005101", "0X8005101", 0, 0, "", "", (String)localObject, "");
        break;
        if ((this.jdField_a_of_type_Int != 1001) && (this.jdField_a_of_type_Int != 10002)) {
          break label74;
        }
        if (!axdz.f(this.app.getAccount()))
        {
          localObject = new Intent(this, NearbyActivity.class);
          ((Intent)localObject).putExtra("FROM_WHERE", 1003);
          ((Intent)localObject).putExtra("ENTER_TIME", System.currentTimeMillis());
          NearbyFakeActivity.a(this, (Intent)localObject);
          break label74;
        }
        localObject = new Intent(this, NearbyGuideActivity.class);
        ((Intent)localObject).putExtra("FROM_WHERE", 1003);
        ((Intent)localObject).putExtra("ENTER_TIME", System.currentTimeMillis());
        startActivity((Intent)localObject);
        break label74;
        if ((this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.jumpUrl != null) && (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.jumpUrl.startsWith("mqqapi")))
        {
          localObject = new Intent(this, JumpActivity.class);
          ((Intent)localObject).setAction("android.intent.action.VIEW");
          ((Intent)localObject).setData(Uri.parse(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.jumpUrl));
          startActivity((Intent)localObject);
          axdl.b(1);
          break label78;
        }
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.jumpUrl);
        startActivity((Intent)localObject);
        break label78;
      }
      label371:
      if (this.jdField_a_of_type_Int == 1001) {
        bcst.b(this.app, "CliOper", "", "", "0X8005100", "0X8005100", 0, 0, "", "", (String)localObject, "");
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    runOnUiThread(new MsgBoxListActivity.5(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dating.MsgBoxListActivity
 * JD-Core Version:    0.7.0.1
 */