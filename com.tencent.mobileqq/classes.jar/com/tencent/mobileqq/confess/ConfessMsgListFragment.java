package com.tencent.mobileqq.confess;

import abku;
import abkv;
import abkw;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsg;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
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
  ConfessManager jdField_a_of_type_ComTencentMobileqqConfessConfessManager;
  ConfessObserver jdField_a_of_type_ComTencentMobileqqConfessConfessObserver = new abkw(this);
  View b;
  View c;
  
  public static void a(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uintype", 1032);
    localIntent.putExtra("uin", AppConstants.aE);
    localIntent.addFlags(335544320);
    PublicFragmentActivity.a(paramContext, localIntent, ConfessMsgListFragment.class);
  }
  
  private void e()
  {
    int i = 0;
    String str = null;
    if (this.b == null) {
      return;
    }
    boolean bool2 = ConfessConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "redpoint_box_show");
    boolean bool1;
    label40:
    Object localObject1;
    label60:
    label76:
    Object localObject3;
    Object localObject2;
    if (this.b.findViewById(2131363834).getVisibility() == 0)
    {
      bool1 = true;
      if (bool2 != bool1)
      {
        localObject1 = this.b.findViewById(2131363834);
        if (!bool2) {
          break label220;
        }
        ((View)localObject1).setVisibility(i);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager != null) {
        break label226;
      }
      localObject1 = null;
      if (localObject1 == null) {
        break label251;
      }
      localObject3 = ((ConfessConfig)localObject1).jdField_a_of_type_JavaLangString;
      str = ((ConfessConfig)localObject1).a();
      localObject2 = ((ConfessConfig)localObject1).h;
    }
    for (;;)
    {
      localObject1 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject1 = "每一个好友都有闪光点。";
      }
      if (TextUtils.isEmpty(str)) {
        str = "最近真的很流行玩这个，快快加入吧。";
      }
      for (;;)
      {
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject2 = "题库更新啦！快来抢先体验吧！";
        }
        for (;;)
        {
          localObject3 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363039);
          TextView localTextView = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363561);
          if (bool2) {}
          for (;;)
          {
            if (!TextUtils.equals((CharSequence)localObject2, ((TextView)localObject3).getText())) {
              ((TextView)localObject3).setText((CharSequence)localObject2);
            }
            if (TextUtils.equals(str, localTextView.getText())) {
              break;
            }
            localTextView.setText(str);
            return;
            bool1 = false;
            break label40;
            label220:
            i = 8;
            break label60;
            label226:
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager.b();
            break label76;
            localObject2 = localObject1;
          }
        }
      }
      label251:
      localObject2 = null;
      localObject3 = null;
    }
  }
  
  protected List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() == 0)) {
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
        if ((paramList instanceof RecentItemConfessMsg)) {}
        for (paramList = (RecentItemConfessMsg)paramList;; paramList = new RecentItemConfessMsg())
        {
          paramList.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, localMessageRecord);
          paramList.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          localArrayList.add(paramList);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131439151));
    b(2131433253);
    b(2131433498, this);
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager = ((ConfessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(268));
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager.b();
    if ((paramBundle == null) || ((paramBundle != null) && (paramBundle.jdField_g_of_type_Int >= 1)) || (ConfessConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "redpoint_box_show")))
    {
      this.b = paramLayoutInflater.inflate(2130970271, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
      if ((LinearLayout.LayoutParams)this.b.getLayoutParams() != null) {
        break label265;
      }
      paramBundle = new LinearLayout.LayoutParams(-1, paramViewGroup.getDimensionPixelSize(2131559466));
      paramBundle.topMargin = paramViewGroup.getDimensionPixelSize(2131559467);
      paramBundle.bottomMargin = paramViewGroup.getDimensionPixelOffset(2131559467);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.b, paramBundle);
      this.b.setOnClickListener(this);
      e();
      this.jdField_c_of_type_AndroidViewView = paramLayoutInflater.inflate(2130970274, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
      if ((LinearLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams() != null) {
        break label279;
      }
      paramLayoutInflater = new LinearLayout.LayoutParams(-1, paramViewGroup.getDimensionPixelSize(2131559468));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidViewView, paramLayoutInflater);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqConfessConfessObserver, true);
      ThreadManager.post(new abku(this), 5, null, true);
      return;
      label265:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.b);
      break;
      label279:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidViewView);
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessMsgListFragment", 4, String.format(Locale.getDefault(), "onRecentBaseDataClick [type: %s, uin: %s, uinName: %s, needRefresh: %s]", new Object[] { Integer.valueOf(paramRecentBaseData.a()), paramRecentBaseData.a(), paramString, Boolean.valueOf(paramBoolean) }));
    }
    if ((paramRecentBaseData instanceof RecentItemConfessMsg))
    {
      paramView = (RecentItemConfessMsg)paramRecentBaseData;
      if ((paramView.j != 1033) && (paramView.j != 1034)) {
        break label276;
      }
      paramString = new Bundle();
      paramString.putInt("key_confessor_sex", paramView.jdField_a_of_type_ComTencentMobileqqConfessConfessInfo.confessorSex);
      paramString.putString("key_confessor_nick", paramView.jdField_a_of_type_ComTencentMobileqqConfessConfessInfo.confessorNick);
      paramString.putString("key_confess_desc", paramView.jdField_a_of_type_ComTencentMobileqqConfessConfessInfo.topic);
      paramString.putLong("key_confess_time", paramView.jdField_a_of_type_ComTencentMobileqqConfessConfessInfo.confessTime);
      ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView.a(), paramView.j, paramView.jdField_a_of_type_ComTencentMobileqqConfessConfessInfo.topicId, paramView.b, paramString);
      if (paramView.j != 1033) {
        break label237;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008F4D", "0X8008F4D", 2, 0, "", "", "", "");
    }
    label237:
    while ((paramView.j != 1032) || (!TextUtils.equals(paramView.jdField_a_of_type_JavaLangString, AppConstants.aF))) {
      for (;;)
      {
        ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentItemConfessMsg)paramRecentBaseData, false);
        return;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008F4E", "0X8008F4E", 2, 0, "", "", "", "");
      }
    }
    label276:
    if (this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager == null)
    {
      paramView = null;
      label308:
      if (paramView != null) {
        break label416;
      }
    }
    label416:
    for (paramView = "https://ti.qq.com/honest-say/friends-received.html?_bid=3104&_wv=9191&_qStyle=1&adtag=message_box";; paramView = paramView.e)
    {
      paramString = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      paramString.putExtra("hide_more_button", true);
      paramString.putExtra("hide_operation_bar", true);
      paramString.putExtra("url", paramView);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramString);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008F4F", "0X8008F4F", 2, 0, "", "", "", "");
      break;
      paramView = this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager.b();
      break label308;
    }
  }
  
  public void a(View paramView, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessMsgListFragment", 4, String.format(Locale.getDefault(), "onClick [view: %s, data: %s]", new Object[] { paramView, paramObject }));
    }
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessMsgListFragment", 4, String.format(Locale.getDefault(), "onRecentBaseDataDelete [type: %s, uin: %s, r4: %s]", new Object[] { Integer.valueOf(paramRecentBaseData.a()), paramRecentBaseData.a(), paramString }));
    }
    if ((paramRecentBaseData instanceof RecentItemConfessMsg)) {
      ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentItemConfessMsg)paramRecentBaseData, true);
    }
    c();
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessMsgListFragment", 4, String.format(Locale.getDefault(), "onMenuItemClick [type: %s, uin: %s, menuItem: %s,  r4: %s]", new Object[] { Integer.valueOf(paramRecentBaseData.a()), paramRecentBaseData.a(), paramString1, paramString2 }));
    }
  }
  
  protected boolean a(String paramString, int paramInt)
  {
    try
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)localIterator.next();
        if ((localRecentBaseData != null) && ((localRecentBaseData instanceof RecentItemConfessMsg)))
        {
          RecentItemConfessMsg localRecentItemConfessMsg = (RecentItemConfessMsg)localRecentBaseData;
          if (localRecentItemConfessMsg.j != 1034)
          {
            if ((((paramInt & 0x1) == 1) || ((paramInt & 0x2) == 2)) && (localRecentItemConfessMsg.j == 1033) && (TextUtils.equals(localRecentBaseData.a(), paramString))) {
              return true;
            }
            if (((paramInt & 0x2) == 2) && (localRecentItemConfessMsg.j == 1032) && (localRecentItemConfessMsg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null))
            {
              boolean bool = TextUtils.equals(localRecentItemConfessMsg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin, paramString);
              if (bool) {
                return true;
              }
            }
          }
        }
      }
    }
    catch (Throwable paramString)
    {
      return false;
    }
    return false;
  }
  
  protected void b(List paramList)
  {
    int k = 0;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager.a();
    int i;
    Object localObject2;
    if ((paramList != null) && (paramList.size() > 0))
    {
      i = paramList.size();
      j = paramList.size() - 1;
      if (j >= 0)
      {
        localObject2 = (MessageRecord)paramList.get(j);
        if (localObject2 == null)
        {
          paramList.remove(j);
          i -= 1;
        }
        for (;;)
        {
          j -= 1;
          break;
          if (TextUtils.isEmpty(((MessageRecord)localObject2).getExtInfoFromExtStr("ext_key_confess_info")))
          {
            paramList.remove(j);
            i -= 1;
          }
          else
          {
            if ((localObject1 == null) || (((FrdConfessInfo)localObject1).jdField_a_of_type_Long <= ((MessageRecord)localObject2).time)) {
              break label590;
            }
            i = j;
          }
        }
      }
    }
    for (int j = i;; j = 0)
    {
      label258:
      boolean bool;
      long l1;
      if (j < 0)
      {
        i = 0;
        if ((localObject1 != null) && (((FrdConfessInfo)localObject1).a()) && (paramList != null))
        {
          localObject2 = new MessageRecord();
          ((MessageRecord)localObject2).istroop = 1032;
          ((MessageRecord)localObject2).frienduin = AppConstants.aF;
          ((MessageRecord)localObject2).time = ((FrdConfessInfo)localObject1).jdField_a_of_type_Long;
          ((MessageRecord)localObject2).senderuin = ((FrdConfessInfo)localObject1).jdField_a_of_type_JavaLangString;
          ((MessageRecord)localObject2).msg = ((FrdConfessInfo)localObject1).c;
          ((MessageRecord)localObject2).msg2 = ((FrdConfessInfo)localObject1).b;
          ((MessageRecord)localObject2).longMsgCount = ((FrdConfessInfo)localObject1).jdField_a_of_type_Int;
          paramList.add(i, localObject2);
        }
        if ((paramList != null) && (!paramList.isEmpty())) {
          break label435;
        }
        j = 1;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        localObject2 = ((RecentUserProxy)localObject1).b(AppConstants.aE, 1032);
        bool = ConfessConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "redpoint_box_show");
        l1 = ConfessConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "redpoint_box_show");
        long l2 = ConfessConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "redpoint_clear_time");
        long l3 = MessageCache.a();
        if ((j == 0) || (localObject2 == null) || (bool) || (Math.abs(l3 - l2) <= 259200000L)) {
          break label440;
        }
        ((RecentUserProxy)localObject1).b((RecentUser)localObject2);
        i = k;
      }
      for (;;)
      {
        if (i != 0)
        {
          paramList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
          if (paramList != null) {
            paramList.sendEmptyMessage(1009);
          }
        }
        return;
        if ((paramList != null) && (paramList.isEmpty()))
        {
          i = 0;
          break;
        }
        i = j;
        if (paramList == null) {
          break;
        }
        i = j;
        if (j <= paramList.size()) {
          break;
        }
        i = paramList.size();
        break;
        label435:
        j = 0;
        break label258;
        label440:
        if ((j == 0) && (localObject2 == null))
        {
          localObject2 = new RecentUser();
          ((RecentUser)localObject2).uin = AppConstants.aE;
          ((RecentUser)localObject2).type = 1032;
          if (bool) {}
          for (l1 = Math.max(((MessageRecord)paramList.get(0)).time, l1);; l1 = ((MessageRecord)paramList.get(0)).time)
          {
            ((RecentUser)localObject2).lastmsgtime = l1;
            ((RecentUserProxy)localObject1).a((RecentUser)localObject2);
            i = 1;
            break;
          }
        }
        i = k;
        if (j != 0)
        {
          i = k;
          if (localObject2 == null)
          {
            paramList = new RecentUser();
            paramList.uin = AppConstants.aE;
            paramList.type = 1032;
            paramList.lastmsgtime = l1;
            ((RecentUserProxy)localObject1).a(paramList);
            i = 1;
          }
        }
      }
      label590:
      break;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.i("ConfessMsgListFragment", 2, "onWindowFocusChanged " + paramBoolean);
    }
    if (paramBoolean) {
      ThreadManager.getSubThreadHandler().postDelayed(new abkv(this), 200L);
    }
  }
  
  protected void d()
  {
    b();
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (paramView == this.b) {
      if (this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager == null)
      {
        paramView = null;
        if (paramView != null) {
          break label193;
        }
        paramView = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=message_box";
        if (!TextUtils.isEmpty(paramView))
        {
          localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("hide_more_button", true);
          ((Intent)localObject).putExtra("hide_operation_bar", true);
          ((Intent)localObject).putExtra("url", paramView);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
        }
        localObject = this.b.findViewById(2131363834);
        if (((View)localObject).getVisibility() != 8) {
          ((View)localObject).setVisibility(8);
        }
        ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008F4B", "0X8008F4B", 2, 0, "", "", "", "");
        if (QLog.isDevelopLevel()) {
          QLog.i("ConfessMsgListFragment", 4, String.format(Locale.getDefault(), "click entry url: %s", new Object[] { paramView }));
        }
      }
    }
    label193:
    while (paramView != this.e) {
      for (;;)
      {
        return;
        paramView = this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager.b();
        continue;
        paramView = paramView.c;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager == null)
    {
      paramView = null;
      label218:
      if (paramView != null) {
        break label343;
      }
    }
    label343:
    for (paramView = "https://ti.qq.com/honest-say/setting.html?_wv=9191&_wwv=4&_qStyle=1&adtag=message_box";; paramView = paramView.jdField_g_of_type_JavaLangString)
    {
      if (!TextUtils.isEmpty(paramView))
      {
        localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramView);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80091A1", "0X80091A1", 0, 0, "", "", "", "");
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("ConfessMsgListFragment", 4, String.format(Locale.getDefault(), "click entry url: %s", new Object[] { paramView }));
      return;
      paramView = this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager.b();
      break label218;
    }
  }
  
  public void onDestroyView()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqConfessConfessObserver);
    super.onDestroyView();
  }
  
  public void onResume()
  {
    super.onResume();
    e();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramObservable.senderuin))) {
        break label36;
      }
    }
    label36:
    while ((paramObservable.istroop != 1032) && (paramObservable.istroop != 1033) && (paramObservable.istroop != 1034)) {
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessMsgListFragment
 * JD-Core Version:    0.7.0.1
 */