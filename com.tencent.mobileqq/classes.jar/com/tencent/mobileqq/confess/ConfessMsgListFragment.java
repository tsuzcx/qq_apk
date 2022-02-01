package com.tencent.mobileqq.confess;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsg;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Observable;
import mqq.os.MqqHandler;

public class ConfessMsgListFragment
  extends BaseMsgListFragment
  implements View.OnClickListener
{
  public ImageView a;
  ConfessManager jdField_a_of_type_ComTencentMobileqqConfessConfessManager;
  ConfessObserver jdField_a_of_type_ComTencentMobileqqConfessConfessObserver = new ConfessMsgListFragment.3(this);
  View b;
  public ImageView b;
  View c;
  
  public static void a(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uintype", 1032);
    localIntent.putExtra("uin", AppConstants.CONFESS_UIN);
    localIntent.addFlags(335544320);
    PublicFragmentActivity.a(paramContext, localIntent, ConfessMsgListFragment.class);
  }
  
  private void d()
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {
      return;
    }
    boolean bool2 = ConfessConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "redpoint_box_show");
    int j = this.jdField_b_of_type_AndroidViewView.findViewById(2131376328).getVisibility();
    int i = 0;
    boolean bool1;
    if (j == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (bool2 != bool1)
    {
      localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131376328);
      if (!bool2) {
        i = 8;
      }
      ((View)localObject1).setVisibility(i);
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager;
    Object localObject4 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((ConfessManager)localObject1).b();
    }
    if (localObject1 != null)
    {
      localObject4 = ((ConfessConfig)localObject1).i;
      localObject3 = ((ConfessConfig)localObject1).a();
      localObject1 = ((ConfessConfig)localObject1).r;
    }
    else
    {
      localObject1 = null;
      localObject3 = localObject1;
    }
    Object localObject2 = localObject4;
    if (TextUtils.isEmpty((CharSequence)localObject4)) {
      localObject2 = ConfessConfig.jdField_a_of_type_JavaLangString;
    }
    localObject4 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject3)) {
      localObject4 = ConfessConfig.b;
    }
    Object localObject3 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject3 = ConfessConfig.c;
    }
    localObject1 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365169);
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365517);
    if (bool2) {
      localObject2 = localObject3;
    }
    if (!TextUtils.equals((CharSequence)localObject2, ((TextView)localObject1).getText())) {
      ((TextView)localObject1).setText((CharSequence)localObject2);
    }
    if (!TextUtils.equals((CharSequence)localObject4, localTextView.getText())) {
      localTextView.setText((CharSequence)localObject4);
    }
  }
  
  protected List<RecentBaseData> a(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return localArrayList;
      }
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        if (localMessageRecord != null)
        {
          paramList = a();
          if ((paramList instanceof RecentItemConfessMsg)) {
            paramList = (RecentItemConfessMsg)paramList;
          } else {
            paramList = new RecentItemConfessMsg();
          }
          paramList.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, localMessageRecord);
          paramList.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          localArrayList.add(paramList);
        }
      }
    }
    return localArrayList;
  }
  
  protected boolean a(String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          RecentBaseData localRecentBaseData = (RecentBaseData)localIterator.next();
          if ((localRecentBaseData == null) || (!(localRecentBaseData instanceof RecentItemConfessMsg))) {
            continue;
          }
          RecentItemConfessMsg localRecentItemConfessMsg = (RecentItemConfessMsg)localRecentBaseData;
          if (localRecentItemConfessMsg.mType == 1034)
          {
            continue;
            if ((localRecentItemConfessMsg.mType == 1033) && (TextUtils.equals(localRecentBaseData.getRecentUserUin(), paramString))) {
              break;
            }
            if (((paramInt & 0x2) != 2) || (localRecentItemConfessMsg.mType != 1032) || (localRecentItemConfessMsg.mMsg == null)) {
              continue;
            }
            boolean bool = TextUtils.equals(localRecentItemConfessMsg.mMsg.senderuin, paramString);
            if (!bool) {
              continue;
            }
            break;
          }
        }
        else
        {
          return false;
        }
      }
      catch (Throwable paramString)
      {
        return false;
      }
      if ((paramInt & 0x1) != 1) {
        if ((paramInt & 0x2) != 2) {}
      }
    }
    return true;
  }
  
  protected void b(List<MessageRecord> paramList)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager.a();
    int m = 1;
    if ((paramList != null) && (paramList.size() > 0))
    {
      int j = paramList.size();
      i = paramList.size() - 1;
      for (;;)
      {
        k = j;
        if (i < 0) {
          break;
        }
        localObject2 = (MessageRecord)paramList.get(i);
        if (localObject2 == null) {
          paramList.remove(i);
        }
        for (;;)
        {
          k = j - 1;
          break label133;
          if (!TextUtils.isEmpty(((MessageRecord)localObject2).getExtInfoFromExtStr("ext_key_confess_info"))) {
            break;
          }
          paramList.remove(i);
        }
        k = j;
        if (localObject1 != null)
        {
          k = j;
          if (((FrdConfessInfo)localObject1).jdField_a_of_type_Long > ((MessageRecord)localObject2).time) {
            k = i;
          }
        }
        label133:
        i -= 1;
        j = k;
      }
    }
    int k = 0;
    if (k < 0) {}
    while ((paramList != null) && (paramList.isEmpty()))
    {
      i = 0;
      break;
    }
    int i = k;
    if (paramList != null)
    {
      i = k;
      if (k > paramList.size()) {
        i = paramList.size();
      }
    }
    if ((localObject1 != null) && (((FrdConfessInfo)localObject1).a()) && (paramList != null))
    {
      localObject2 = new MessageRecord();
      ((MessageRecord)localObject2).istroop = 1032;
      ((MessageRecord)localObject2).frienduin = AppConstants.CONFESS_FRD_REC_UIN;
      ((MessageRecord)localObject2).time = ((FrdConfessInfo)localObject1).jdField_a_of_type_Long;
      ((MessageRecord)localObject2).senderuin = ((FrdConfessInfo)localObject1).jdField_a_of_type_JavaLangString;
      ((MessageRecord)localObject2).msg = ((FrdConfessInfo)localObject1).c;
      ((MessageRecord)localObject2).msg2 = ((FrdConfessInfo)localObject1).b;
      ((MessageRecord)localObject2).longMsgCount = ((FrdConfessInfo)localObject1).jdField_a_of_type_Int;
      paramList.add(i, localObject2);
    }
    if ((paramList != null) && (!paramList.isEmpty())) {
      i = 0;
    } else {
      i = 1;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    Object localObject2 = ((RecentUserProxy)localObject1).b(AppConstants.CONFESS_UIN, 1032);
    boolean bool = ConfessConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "redpoint_box_show");
    long l1 = ConfessConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "redpoint_box_show");
    long l2 = ConfessConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "redpoint_clear_time");
    long l3 = MessageCache.a();
    if ((i != 0) && (localObject2 != null) && (!bool) && (Math.abs(l3 - l2) > 259200000L))
    {
      ((RecentUserProxy)localObject1).a((RecentUser)localObject2);
    }
    else
    {
      if ((i == 0) && (localObject2 == null))
      {
        localObject2 = new RecentUser();
        ((RecentUser)localObject2).uin = AppConstants.CONFESS_UIN;
        ((RecentUser)localObject2).setType(1032);
        if (bool) {
          l1 = Math.max(((MessageRecord)paramList.get(0)).time, l1);
        } else {
          l1 = ((MessageRecord)paramList.get(0)).time;
        }
        ((RecentUser)localObject2).lastmsgtime = l1;
        ((RecentUserProxy)localObject1).b((RecentUser)localObject2);
        i = m;
        break label583;
      }
      if ((i != 0) && (localObject2 == null))
      {
        paramList = new RecentUser();
        paramList.uin = AppConstants.CONFESS_UIN;
        paramList.setType(1032);
        paramList.lastmsgtime = l1;
        ((RecentUserProxy)localObject1).b(paramList);
        i = m;
        break label583;
      }
    }
    i = 0;
    label583:
    if (i != 0)
    {
      paramList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if (paramList != null) {
        paramList.sendEmptyMessage(1009);
      }
    }
  }
  
  protected void c()
  {
    a();
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698709));
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager = ((ConfessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER));
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager.b();
    if ((paramBundle != null) && (paramBundle.g == 1))
    {
      Drawable localDrawable1 = getResources().getDrawable(2130850783);
      Drawable localDrawable2 = getResources().getDrawable(2130845002);
      ImageView localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
      if ((localImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
      {
        localImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable1);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable2);
        this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getString(2131698707));
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131693877));
      }
    }
    else
    {
      setRightButton(2131718832, this);
    }
    if ((paramBundle == null) || ((paramBundle != null) && (paramBundle.h >= 1)) || (ConfessConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "redpoint_box_show")))
    {
      this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.inflate(2131561015, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
      if ((LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams() == null)
      {
        paramBundle = new LinearLayout.LayoutParams(-1, paramViewGroup.getDimensionPixelSize(2131298215));
        paramBundle.topMargin = paramViewGroup.getDimensionPixelSize(2131298216);
        paramBundle.bottomMargin = paramViewGroup.getDimensionPixelOffset(2131298216);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidViewView, paramBundle);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidViewView);
      }
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      d();
      this.jdField_c_of_type_AndroidViewView = paramLayoutInflater.inflate(2131561022, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
      if ((LinearLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams() == null)
      {
        paramLayoutInflater = new LinearLayout.LayoutParams(-1, paramViewGroup.getDimensionPixelSize(2131298217));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidViewView, paramLayoutInflater);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidViewView);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqConfessConfessObserver, true);
    ThreadManager.post(new ConfessMsgListFragment.1(this), 5, null, true);
  }
  
  public void onClick(View paramView)
  {
    Object localObject4 = this.jdField_b_of_type_AndroidViewView;
    Object localObject2 = null;
    ConfessManager localConfessManager = null;
    Object localObject3 = null;
    Object localObject1 = null;
    if (paramView == localObject4)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager;
      if (localObject2 != null) {
        localObject1 = ((ConfessManager)localObject2).b();
      }
      if (localObject1 == null) {
        localObject1 = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=message_box";
      } else {
        localObject1 = ((ConfessConfig)localObject1).k;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("hide_more_button", true);
        ((Intent)localObject2).putExtra("hide_operation_bar", true);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
      }
      localObject2 = this.jdField_b_of_type_AndroidViewView.findViewById(2131376328);
      if (((View)localObject2).getVisibility() != 8) {
        ((View)localObject2).setVisibility(8);
      }
      ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008F4B", "0X8008F4B", 2, 0, "", "", "", "");
      if (QLog.isDevelopLevel()) {
        QLog.i("ConfessMsgListFragment", 4, String.format(Locale.getDefault(), "click entry url: %s", new Object[] { localObject1 }));
      }
    }
    else
    {
      localObject4 = this.rightViewText;
      localObject1 = "https://ti.qq.com/honest-say/setting.html?_wv=9191&_wwv=4&_qStyle=1&adtag=message_box";
      if (paramView == localObject4)
      {
        localConfessManager = this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager;
        if (localConfessManager != null) {
          localObject2 = localConfessManager.b();
        }
        if (localObject2 != null) {
          localObject1 = ((ConfessConfig)localObject2).p;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", (String)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80091A1", "0X80091A1", 0, 0, "", "", "", "");
        if (QLog.isDevelopLevel()) {
          QLog.i("ConfessMsgListFragment", 4, String.format(Locale.getDefault(), "click entry url: %s", new Object[] { localObject1 }));
        }
      }
      else if (paramView == this.jdField_b_of_type_AndroidWidgetImageView)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager;
        if (localObject1 == null) {
          localObject1 = localConfessManager;
        } else {
          localObject1 = ((ConfessManager)localObject1).b();
        }
        if (localObject1 == null) {
          localObject1 = "https://ti.qq.com/honest-say/rank.html?_wv=9191&_wwv=4&_qStyle=1";
        } else {
          localObject1 = ((ConfessConfig)localObject1).q;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", (String)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800948C", "0X800948C", 0, 0, "", "", "", "");
        if (QLog.isDevelopLevel()) {
          QLog.i("ConfessMsgListFragment", 4, String.format(Locale.getDefault(), "click entry url: %s", new Object[] { localObject1 }));
        }
      }
      else if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager;
        if (localObject2 == null) {
          localObject2 = localObject3;
        } else {
          localObject2 = ((ConfessManager)localObject2).b();
        }
        if (localObject2 != null) {
          localObject1 = ((ConfessConfig)localObject2).p;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", (String)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80091A1", "0X80091A1", 0, 0, "", "", "", "");
        if (QLog.isDevelopLevel()) {
          QLog.i("ConfessMsgListFragment", 4, String.format(Locale.getDefault(), "click entry url: %s", new Object[] { localObject1 }));
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onClick(View paramView, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessMsgListFragment", 4, String.format(Locale.getDefault(), "onClick [view: %s, data: %s]", new Object[] { paramView, paramObject }));
    }
  }
  
  protected View onCreateLeftView()
  {
    View localView = super.onCreateLeftView();
    this.leftView.setText("  ");
    return localView;
  }
  
  protected View onCreateRightView()
  {
    this.rightViewText = ((TextView)this.titleRoot.findViewById(2131369233));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.titleRoot.findViewById(2131369216));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.titleRoot.findViewById(2131369217));
    setLayerType(this.jdField_a_of_type_AndroidWidgetImageView);
    setLayerType(this.jdField_b_of_type_AndroidWidgetImageView);
    setLayerType(this.rightViewText);
    return this.rightViewText;
  }
  
  public void onDestroyView()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqConfessConfessObserver);
    super.onDestroyView();
  }
  
  public void onMenuItemClick(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessMsgListFragment", 4, String.format(Locale.getDefault(), "onMenuItemClick [type: %s, uin: %s, menuItem: %s,  r4: %s]", new Object[] { Integer.valueOf(paramRecentBaseData.getRecentUserType()), paramRecentBaseData.getRecentUserUin(), paramString1, paramString2 }));
    }
  }
  
  public void onRecentBaseDataClick(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessMsgListFragment", 4, String.format(Locale.getDefault(), "onRecentBaseDataClick [type: %s, uin: %s, uinName: %s, needRefresh: %s]", new Object[] { Integer.valueOf(paramRecentBaseData.getRecentUserType()), paramRecentBaseData.getRecentUserUin(), paramString, Boolean.valueOf(paramBoolean) }));
    }
    if ((paramRecentBaseData instanceof RecentItemConfessMsg))
    {
      paramRecentBaseData = (RecentItemConfessMsg)paramRecentBaseData;
      if ((paramRecentBaseData.mType != 1033) && (paramRecentBaseData.mType != 1034))
      {
        if ((paramRecentBaseData.mType == 1032) && (TextUtils.equals(paramRecentBaseData.mUin, AppConstants.CONFESS_FRD_REC_UIN)))
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager;
          if (paramView == null) {
            paramView = null;
          } else {
            paramView = paramView.b();
          }
          if (paramView == null) {
            paramView = "https://ti.qq.com/honest-say/friends-received.html?_bid=3104&_wv=9191&_qStyle=1&adtag=message_box";
          } else {
            paramView = paramView.m;
          }
          paramString = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
          paramString.putExtra("hide_more_button", true);
          paramString.putExtra("hide_operation_bar", true);
          paramString.putExtra("url", paramView);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramString);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008F4F", "0X8008F4F", 2, 0, "", "", "", "");
        }
      }
      else
      {
        paramView = new Bundle();
        paramView.putInt("key_confessor_sex", paramRecentBaseData.mConfessInfo.confessorSex);
        paramView.putString("key_confessor_nick", paramRecentBaseData.mConfessInfo.confessorNick);
        paramView.putString("key_confess_desc", paramRecentBaseData.mConfessInfo.topic);
        paramView.putLong("key_confess_time", paramRecentBaseData.mConfessInfo.confessTime);
        ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.mType, paramRecentBaseData.mConfessInfo.topicId, paramRecentBaseData.mTitleName, paramView);
        if (paramRecentBaseData.mType == 1033) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008F4D", "0X8008F4D", 2, 0, "", "", "", "");
        } else {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008F4E", "0X8008F4E", 2, 0, "", "", "", "");
        }
      }
      ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData, false);
    }
  }
  
  public void onRecentBaseDataDelete(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessMsgListFragment", 4, String.format(Locale.getDefault(), "onRecentBaseDataDelete [type: %s, uin: %s, r4: %s]", new Object[] { Integer.valueOf(paramRecentBaseData.getRecentUserType()), paramRecentBaseData.getRecentUserUin(), paramString }));
    }
    if ((paramRecentBaseData instanceof RecentItemConfessMsg)) {
      ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentItemConfessMsg)paramRecentBaseData, true);
    }
    b();
  }
  
  public void onResume()
  {
    super.onResume();
    d();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onWindowFocusChanged ");
      localStringBuilder.append(paramBoolean);
      QLog.i("ConfessMsgListFragment", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      ThreadManager.getSubThreadHandler().postDelayed(new ConfessMsgListFragment.2(this), 200L);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (this.jdField_a_of_type_Boolean)
      {
        if (TextUtils.isEmpty(paramObservable.senderuin)) {
          return;
        }
        if ((paramObservable.istroop != 1032) && (paramObservable.istroop != 1033) && (paramObservable.istroop != 1034)) {
          return;
        }
        b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessMsgListFragment
 * JD-Core Version:    0.7.0.1
 */