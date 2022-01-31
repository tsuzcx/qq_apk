package com.tencent.mobileqq.dating;

import acex;
import acfb;
import acff;
import acfg;
import acfh;
import acfi;
import acfj;
import acfl;
import acfm;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.data.RecentInteractAndFollowItem;
import com.tencent.mobileqq.activity.recent.data.RecentItemNearbyLiveTipData;
import com.tencent.mobileqq.activity.recent.data.RecentMsgBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloBoxItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForInteractAndFollow;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.MsgBoxInterFollowManager;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyFakeActivity;
import com.tencent.mobileqq.nearby.NearbyProcessMonitor;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.mobileqq.nearby.now.protocol.NowShortVideoProtoManager;
import com.tencent.mobileqq.nearpeople.NearbyRecommender.ChatPushCarrierHelper;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import tencent.nearby.now.nearby_now_anchor.AnchorStatus;

public class MsgBoxListActivity
  extends BaseMsgBoxActivity
  implements View.OnClickListener, ActionSheet.OnButtonClickListener
{
  Handler jdField_a_of_type_AndroidOsHandler = null;
  public LinearLayout a;
  RecentBaseData jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData;
  LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new acex(this);
  public CarrierHelper.EntranceConfig a;
  private CarrierHelper jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper;
  protected MsgBoxProtocol.LastFeedObserver a;
  public ChatPushCarrierHelper a;
  public View c;
  public View d;
  String d;
  public boolean d;
  private View e;
  protected boolean e;
  private View jdField_f_of_type_AndroidViewView;
  boolean jdField_f_of_type_Boolean = false;
  
  public MsgBoxListActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqDatingMsgBoxProtocol$LastFeedObserver = new acfl(this);
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
    Object localObject;
    if ((this.jdField_a_of_type_Int == 1010) || (this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 10002))
    {
      localObject = this.app;
      if (this.jdField_a_of_type_Int != 1010) {
        break label242;
      }
    }
    label242:
    for (int i = 2;; i = 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper = new CarrierHelper((QQAppInterface)localObject, null, i);
      this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper.a(this);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper.a(this);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidViewView);
      if (this.jdField_e_of_type_AndroidViewView == null)
      {
        this.jdField_e_of_type_AndroidViewView = new View(this);
        localObject = new AbsListView.LayoutParams(-1, DisplayUtil.a(this, 20.0F));
        this.jdField_e_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_e_of_type_AndroidViewView.setBackgroundColor(0);
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      }
      if (this.jdField_f_of_type_AndroidViewView == null)
      {
        this.jdField_f_of_type_AndroidViewView = new View(this);
        localObject = new AbsListView.LayoutParams(-1, 1);
        this.jdField_f_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130846093);
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      }
      ThreadManager.post(new acfb(this), 10, null, false);
      return;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper.a())
    {
      if (this.jdField_e_of_type_AndroidViewView.getVisibility() != 0)
      {
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView(this.jdField_e_of_type_AndroidViewView);
      }
      if (this.jdField_f_of_type_AndroidViewView.getVisibility() != 0)
      {
        this.jdField_f_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView(this.jdField_f_of_type_AndroidViewView);
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
    } while (this.jdField_f_of_type_AndroidViewView.getVisibility() == 8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.removeHeaderView(this.jdField_f_of_type_AndroidViewView);
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_Int != 1010) && (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig != null) && (!StringUtil.a(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.iconUrl)) && (!StringUtil.a(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.wording)) && (!StringUtil.a(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.jumpUrl)))
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.iconUrl, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.wording);
    }
  }
  
  public void OnClick(View paramView, int paramInt) {}
  
  protected List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    long l1 = System.currentTimeMillis();
    Iterator localIterator = paramList.iterator();
    long l2;
    while (localIterator.hasNext())
    {
      paramList = (MessageRecord)localIterator.next();
      String str = paramList.senderuin + "_" + paramList.msgtype;
      l2 = System.currentTimeMillis();
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(str))
      {
        paramList = (RecentBaseData)this.jdField_a_of_type_JavaUtilMap.get(str);
        paramList.a(this.app, BaseApplication.getContext());
        localArrayList.add(paramList);
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.msg_box", 4, "item update time cost = " + (System.currentTimeMillis() - l2));
        }
      }
      else
      {
        if (paramList.senderuin.equals(this.jdField_c_of_type_JavaLangString)) {
          paramList = new RecentSayHelloBoxItem(paramList);
        }
        for (;;)
        {
          this.jdField_a_of_type_JavaUtilMap.put(str, paramList);
          break;
          if ((paramList instanceof MessageForNearbyLiveTip)) {
            paramList = new RecentItemNearbyLiveTipData(paramList);
          } else if ((paramList instanceof MessageForInteractAndFollow)) {
            paramList = new RecentInteractAndFollowItem(paramList);
          } else {
            paramList = new RecentMsgBoxItem(paramList);
          }
        }
      }
    }
    if (QLog.isDevelopLevel())
    {
      l2 = System.currentTimeMillis();
      QLog.d("Q.msg_box", 4, "makeRecetBaseData |start cost time:" + (l2 - l1));
    }
    return localArrayList;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramView == null) {
      return;
    }
    ((View)paramView.getParent()).post(new acfh(this, paramView, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if ((paramRecentBaseData instanceof RecentItemNearbyLiveTipData))
    {
      paramView = ((RecentItemNearbyLiveTipData)paramRecentBaseData).jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip;
      if (paramView != null)
      {
        paramView = JumpParser.a(this.app, this, paramView.jumpingUrl);
        if (paramView != null)
        {
          paramView.b();
          this.app.a().c(paramRecentBaseData.a(), paramRecentBaseData.a());
        }
      }
      ReportController.b(this.app, "dc00899", "grp_lbs", "", "msg_box", "click_live_message", 0, 0, "", "", "", "");
    }
    do
    {
      return;
      if (!(paramRecentBaseData instanceof RecentInteractAndFollowItem)) {
        break;
      }
      RecentUtil.b(this.app, paramRecentBaseData.a(), this.jdField_a_of_type_Int);
      this.app.a().c(paramRecentBaseData.a(), this.jdField_a_of_type_Int);
      if (MsgProxyUtils.f(paramRecentBaseData.a()))
      {
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("url", "https://nearby.qq.com/greeting/notification.html?_bid=2623&_wv=1027");
        startActivityForResult(paramView, 1);
        new ReportTask(this.app).a("dc00899").b("grp_lbs").c("msg_box").d("clk_update").a();
        return;
      }
      if (MsgProxyUtils.g(paramRecentBaseData.a()))
      {
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("url", "https://nearby.qq.com/greeting/topic.html?_bid=2623&_wv=1027 ");
        startActivityForResult(paramView, 2);
        new ReportTask(this.app).a("dc00899").b("grp_lbs").c("msg_box").d("clk_focus").a();
        return;
      }
    } while (!MsgProxyUtils.e(paramRecentBaseData.a()));
    paramView = new Intent(this, QQBrowserActivity.class);
    paramView.putExtra("url", "https://nearby.qq.com/nearby-index/my_msg.html ");
    startActivityForResult(paramView, 3);
    return;
    super.a(paramView, paramRecentBaseData, paramString, paramBoolean);
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    super.a(paramRecentBaseData, paramString);
    if (paramRecentBaseData != null)
    {
      SharedPreUtils.b(this.app.getApp(), this.app.getCurrentAccountUin(), paramRecentBaseData.a(), 1);
      if (!MsgProxyUtils.f(paramRecentBaseData.a())) {
        break label79;
      }
      ReportController.b(this.app, "dc00899", "grp_lbs", "", "msg_box", "swipe_update", 0, 0, "", "", "", "");
    }
    label79:
    while (!MsgProxyUtils.g(paramRecentBaseData.a())) {
      return;
    }
    ReportController.b(this.app, "dc00899", "grp_lbs", "", "msg_box", "swipe_focus", 0, 0, "", "", "", "");
  }
  
  public void a(RecentItemNearbyLiveTipData paramRecentItemNearbyLiveTipData, List paramList)
  {
    long l1 = Long.parseLong(paramRecentItemNearbyLiveTipData.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.senderuin);
    long l2 = AppConstants.l;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (nearby_now_anchor.AnchorStatus)paramList.next();
      if ((((nearby_now_anchor.AnchorStatus)localObject).uint64_uin.get() == l1 - l2) && (((nearby_now_anchor.AnchorStatus)localObject).enum_stat.get() == 2))
      {
        localObject = paramRecentItemNearbyLiveTipData.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip;
        ((MessageForNearbyLiveTip)localObject).isLiving = false;
        ((MessageForNearbyLiveTip)localObject).msg = ((MessageForNearbyLiveTip)localObject).c2cMsgWording;
        ((MessageForNearbyLiveTip)localObject).prewrite();
        this.app.a().a(((MessageForNearbyLiveTip)localObject).senderuin, ((MessageForNearbyLiveTip)localObject).istroop, ((MessageForNearbyLiveTip)localObject).uniseq, ((MessageForNearbyLiveTip)localObject).msgData);
        paramRecentItemNearbyLiveTipData.a(this.app, BaseApplication.getContext());
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(((MessageForNearbyLiveTip)localObject).senderuin, this.jdField_a_of_type_Int);
      }
    }
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    if (Utils.a(paramString1, getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[6])))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData = paramRecentBaseData;
      this.d = paramString2;
      if ((paramRecentBaseData instanceof RecentItemNearbyLiveTipData)) {
        break label45;
      }
      QLog.w("Q.msg_box", 1, "data instanceof RecentItemNearbyLiveTipData = [false]");
    }
    label45:
    do
    {
      return;
      if (!NetworkUtil.a(getApplicationContext()))
      {
        QQToast.a(getApplicationContext(), 1, 2131433227, 0).a();
        return;
      }
      paramString1 = (RecentItemNearbyLiveTipData)paramRecentBaseData;
      if (paramString1.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip != null) {
        break;
      }
      QLog.w("Q.msg_box", 1, "rData.nearbyLiveTipMsg == null");
    } while (paramString1.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null);
    paramString1 = paramString1.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
    try
    {
      for (;;)
      {
        l = Long.valueOf(paramString1).longValue();
        if (l <= AppConstants.l) {
          break;
        }
        l -= AppConstants.l;
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData, this.d);
        new NowShortVideoProtoManager(this.app).a(l, 16, false, new acfj(this));
        return;
        paramString1 = paramString1.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.senderuin;
      }
    }
    catch (NumberFormatException paramString1)
    {
      for (;;)
      {
        long l = 0L;
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
          if ((((RecentItemNearbyLiveTipData)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip != null) && (!MessageForNearbyLiveTip.isHuayangTip(((RecentItemNearbyLiveTipData)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.jumpingUrl)) && (((RecentItemNearbyLiveTipData)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.isLiving))
          {
            try
            {
              Long localLong = Long.valueOf(Long.valueOf(Long.parseLong(((RecentItemNearbyLiveTipData)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.senderuin)).longValue() - AppConstants.l);
              if (!localArrayList1.contains(localLong)) {
                localArrayList1.add(localLong);
              }
              localArrayList2.add(localObject);
            }
            catch (Exception localException) {}
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg_box", 2, localException.toString());
            }
          }
        }
      }
    } while (localArrayList1.size() == 0);
    MsgBoxProtocol.a(this.app, localArrayList1, null, new acff(this, localArrayList2));
  }
  
  protected void b(List paramList)
  {
    if (paramList.size() == 0) {
      return;
    }
    Iterator localIterator = paramList.iterator();
    ArrayList localArrayList = new ArrayList(3);
    Object localObject2 = null;
    Object localObject1 = null;
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if ((TextUtils.isEmpty(localMessageRecord.senderuin)) || (localMessageRecord.msgtype == -4011))
      {
        localIterator.remove();
      }
      else
      {
        if (MsgProxyUtils.d(localMessageRecord.senderuin))
        {
          localArrayList.add(localMessageRecord);
          localIterator.remove();
        }
        if ((localMessageRecord.senderuin.equals(AppConstants.ae)) || (localMessageRecord.senderuin.equals(AppConstants.af)))
        {
          this.jdField_c_of_type_Boolean = true;
          this.jdField_c_of_type_JavaLangString = localMessageRecord.senderuin;
          localArrayList.add(localMessageRecord);
          localIterator.remove();
        }
        else if (DatingUtil.b(this.app, localMessageRecord.senderuin, localMessageRecord.istroop))
        {
          localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = new ArrayList();
          }
          localIterator.remove();
          ((List)localObject3).add(localMessageRecord);
          localObject1 = localObject3;
        }
        else if (DatingUtil.a(this.app, localMessageRecord.senderuin, localMessageRecord.istroop))
        {
          localObject3 = localObject2;
          if (localObject2 == null) {
            localObject3 = new ArrayList();
          }
          localIterator.remove();
          ((List)localObject3).add(localMessageRecord);
          localObject2 = localObject3;
        }
      }
    }
    Object localObject3 = new ArrayList();
    ((List)localObject3).addAll(localArrayList);
    if (0 != 0) {
      ((List)localObject3).add(null);
    }
    if ((localObject2 != null) && (!localObject2.isEmpty())) {
      ((List)localObject3).addAll(localObject2);
    }
    if ((localObject1 != null) && (!localObject1.isEmpty())) {
      ((List)localObject3).addAll(localObject1);
    }
    paramList.addAll(0, (Collection)localObject3);
  }
  
  public void c()
  {
    if ((this.leftView == null) || (this.mLeftBackText == null) || (this.mLeftBackText == null)) {
      return;
    }
    TextView localTextView;
    if (this.jdField_e_of_type_Boolean)
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
      if (!this.jdField_e_of_type_Boolean)
      {
        localObject = getString(2131433311) + "(" + i + ")";
        if (i > 99) {
          localObject = getString(2131433311) + "(99+)";
        }
      }
      if (i < 0) {
        localObject = getString(2131433311);
      }
      if ((this.jdField_e_of_type_Boolean) && (i <= 0)) {
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 2) || (paramInt1 == 1) || (paramInt1 == 3)) {
      MsgBoxProtocol.a(this.app, 2, this.jdField_a_of_type_ComTencentMobileqqDatingMsgBoxProtocol$LastFeedObserver);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_e_of_type_Boolean = ThemeUtil.isDefaultOrDIYTheme(false);
    if (this.jdField_e_of_type_Boolean)
    {
      if (getTitleBarView() != null) {
        getTitleBarView().setBackgroundDrawable(getResources().getDrawable(2130845952));
      }
      if (this.centerView != null) {
        this.centerView.setTextColor(-1);
      }
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_ComTencentMobileqqNearpeopleNearbyRecommenderChatPushCarrierHelper = new ChatPushCarrierHelper(this);
    if (this.jdField_a_of_type_Int == 1010)
    {
      setTitle(2131437614);
      this.b.setVisibility(8);
    }
    for (;;)
    {
      this.b.setOnClickListener(this);
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver, true);
      MsgBoxProtocol.a(this.app, 1, this.jdField_a_of_type_ComTencentMobileqqDatingMsgBoxProtocol$LastFeedObserver);
      if ((this.jdField_a_of_type_Int != 1001) && (this.jdField_a_of_type_Int != 10002)) {
        break;
      }
      return true;
      if ((this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 10002))
      {
        setTitle(2131434042);
        this.b.setVisibility(8);
        QQAppInterface localQQAppInterface = this.app;
        if (this.jdField_a_of_type_Int == 1001) {}
        for (paramBundle = "0";; paramBundle = "1")
        {
          ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "exp_msg_list", 0, 0, paramBundle, "", "", "");
          break;
        }
      }
      if (this.jdField_a_of_type_Int == 1009)
      {
        setTitle(2131434050);
        this.b.setVisibility(8);
      }
    }
    d();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper != null) {
      ThreadManager.post(new acfg(this), 5, null, false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearpeopleNearbyRecommenderChatPushCarrierHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearpeopleNearbyRecommenderChatPushCarrierHelper.a();
    }
    NearbyProcessMonitor.c(1);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper.a(1, Boolean.valueOf(false));
      this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper.a();
    }
  }
  
  protected void doOnResume()
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
    if ((paramBoolean) && (!this.jdField_f_of_type_Boolean))
    {
      this.jdField_f_of_type_Boolean = true;
      if (this.jdField_a_of_type_AndroidOsHandler == null)
      {
        acfm localacfm = new acfm(this.app.getAccount());
        this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(ThreadManager.getFileThreadLooper(), localacfm);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 2000L);
    }
  }
  
  public void finish()
  {
    if ((this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 10002))
    {
      this.app.getPreferences().edit().putLong("sp_key_nearby_clean_unread_time", NetConnInfoCenter.getServerTime()).commit();
      this.app.getPreferences().edit().putInt("sp_key_sayhello_box_unread_count", 0).commit();
      this.app.a().a(AppConstants.G, this.jdField_a_of_type_Int, true);
      this.app.a().clearMsgBoxUnreadCount();
    }
    super.finish();
  }
  
  protected boolean onBackEvent()
  {
    Intent localIntent = new Intent(this, SplashActivity.class);
    localIntent.putExtra("tab_index", MainFragment.jdField_a_of_type_Int);
    localIntent.setFlags(67108864);
    startActivity(localIntent);
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    label71:
    label352:
    label368:
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig == null)
      {
        if (QLog.isColorLevel()) {
          NearbyUtils.a("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        }
        if (this.jdField_a_of_type_Int == 1010)
        {
          NearbyProcessMonitor.b(1);
          if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
            break label352;
          }
        }
      }
      for (paramView = "";; paramView = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString())
      {
        if (this.jdField_a_of_type_Int != 1010) {
          break label368;
        }
        ReportController.b(this.app, "CliOper", "", "", "0X8005101", "0X8005101", 0, 0, "", "", paramView, "");
        return;
        if ((this.jdField_a_of_type_Int != 1001) && (this.jdField_a_of_type_Int != 10002)) {
          break;
        }
        if (!NearbySPUtil.f(this.app.getAccount()))
        {
          paramView = new Intent(this, NearbyActivity.class);
          paramView.putExtra("FROM_WHERE", 1003);
          paramView.putExtra("ENTER_TIME", System.currentTimeMillis());
          NearbyFakeActivity.a(this, paramView);
          break;
        }
        paramView = new Intent(this, NearbyGuideActivity.class);
        paramView.putExtra("FROM_WHERE", 1003);
        paramView.putExtra("ENTER_TIME", System.currentTimeMillis());
        startActivity(paramView);
        break;
        if ((this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.jumpUrl != null) && (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.jumpUrl.startsWith("mqqapi")))
        {
          paramView = new Intent(this, JumpActivity.class);
          paramView.setAction("android.intent.action.VIEW");
          paramView.setData(Uri.parse(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.jumpUrl));
          startActivity(paramView);
          NearbyProcessMonitor.b(1);
          break label71;
        }
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.jumpUrl);
        startActivity(paramView);
        break label71;
      }
    } while (this.jdField_a_of_type_Int != 1001);
    ReportController.b(this.app, "CliOper", "", "", "0X8005100", "0X8005100", 0, 0, "", "", paramView, "");
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    runOnUiThread(new acfi(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.dating.MsgBoxListActivity
 * JD-Core Version:    0.7.0.1
 */