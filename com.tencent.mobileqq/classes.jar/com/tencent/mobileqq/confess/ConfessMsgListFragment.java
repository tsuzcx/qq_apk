package com.tencent.mobileqq.confess;

import ajsf;
import aktg;
import amnk;
import amno;
import amnr;
import amns;
import amnt;
import amoa;
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
import awzw;
import axqw;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsg;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
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
  amno jdField_a_of_type_Amno;
  amnt jdField_a_of_type_Amnt = new amnr(this);
  public ImageView a;
  View b;
  public ImageView b;
  View c;
  
  public static void a(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uintype", 1032);
    localIntent.putExtra("uin", ajsf.aM);
    localIntent.addFlags(335544320);
    PublicFragmentActivity.a(paramContext, localIntent, ConfessMsgListFragment.class);
  }
  
  private void d()
  {
    int i = 0;
    String str = null;
    if (this.jdField_b_of_type_AndroidViewView == null) {
      return;
    }
    boolean bool2 = amnk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "redpoint_box_show");
    boolean bool1;
    label40:
    Object localObject1;
    label60:
    label76:
    Object localObject3;
    Object localObject2;
    if (this.jdField_b_of_type_AndroidViewView.findViewById(2131375038).getVisibility() == 0)
    {
      bool1 = true;
      if (bool2 != bool1)
      {
        localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131375038);
        if (!bool2) {
          break label223;
        }
        ((View)localObject1).setVisibility(i);
      }
      if (this.jdField_a_of_type_Amno != null) {
        break label229;
      }
      localObject1 = null;
      if (localObject1 == null) {
        break label254;
      }
      localObject3 = ((amnk)localObject1).i;
      str = ((amnk)localObject1).a();
      localObject2 = ((amnk)localObject1).r;
    }
    for (;;)
    {
      localObject1 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject1 = amnk.jdField_a_of_type_JavaLangString;
      }
      if (TextUtils.isEmpty(str)) {
        str = amnk.b;
      }
      for (;;)
      {
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject2 = amnk.c;
        }
        for (;;)
        {
          localObject3 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364692);
          TextView localTextView = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365018);
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
            label223:
            i = 8;
            break label60;
            label229:
            localObject1 = this.jdField_a_of_type_Amno.b();
            break label76;
            localObject2 = localObject1;
          }
        }
      }
      label254:
      localObject2 = null;
      localObject3 = null;
    }
  }
  
  protected List<RecentBaseData> a(List<MessageRecord> paramList)
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
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessMsgListFragment", 4, String.format(Locale.getDefault(), "onRecentBaseDataClick [type: %s, uin: %s, uinName: %s, needRefresh: %s]", new Object[] { Integer.valueOf(paramRecentBaseData.a()), paramRecentBaseData.a(), paramString, Boolean.valueOf(paramBoolean) }));
    }
    if ((paramRecentBaseData instanceof RecentItemConfessMsg))
    {
      paramView = (RecentItemConfessMsg)paramRecentBaseData;
      if ((paramView.mType != 1033) && (paramView.mType != 1034)) {
        break label272;
      }
      paramString = new Bundle();
      paramString.putInt("key_confessor_sex", paramView.mConfessInfo.confessorSex);
      paramString.putString("key_confessor_nick", paramView.mConfessInfo.confessorNick);
      paramString.putString("key_confess_desc", paramView.mConfessInfo.topic);
      paramString.putLong("key_confess_time", paramView.mConfessInfo.confessTime);
      amns.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView.a(), paramView.mType, paramView.mConfessInfo.topicId, paramView.mTitleName, paramString);
      if (paramView.mType != 1033) {
        break label233;
      }
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008F4D", "0X8008F4D", 2, 0, "", "", "", "");
    }
    label233:
    while ((paramView.mType != 1032) || (!TextUtils.equals(paramView.mUin, ajsf.aN))) {
      for (;;)
      {
        amns.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentItemConfessMsg)paramRecentBaseData, false);
        return;
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008F4E", "0X8008F4E", 2, 0, "", "", "", "");
      }
    }
    label272:
    if (this.jdField_a_of_type_Amno == null)
    {
      paramView = null;
      label304:
      if (paramView != null) {
        break label412;
      }
    }
    label412:
    for (paramView = "https://ti.qq.com/honest-say/friends-received.html?_bid=3104&_wv=9191&_qStyle=1&adtag=message_box";; paramView = paramView.m)
    {
      paramString = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      paramString.putExtra("hide_more_button", true);
      paramString.putExtra("hide_operation_bar", true);
      paramString.putExtra("url", paramView);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramString);
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008F4F", "0X8008F4F", 2, 0, "", "", "", "");
      break;
      paramView = this.jdField_a_of_type_Amno.b();
      break label304;
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
      amns.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentItemConfessMsg)paramRecentBaseData, true);
    }
    b();
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
          if (localRecentItemConfessMsg.mType != 1034)
          {
            if ((((paramInt & 0x1) == 1) || ((paramInt & 0x2) == 2)) && (localRecentItemConfessMsg.mType == 1033) && (TextUtils.equals(localRecentBaseData.a(), paramString))) {
              return true;
            }
            if (((paramInt & 0x2) == 2) && (localRecentItemConfessMsg.mType == 1032) && (localRecentItemConfessMsg.mMsg != null))
            {
              boolean bool = TextUtils.equals(localRecentItemConfessMsg.mMsg.senderuin, paramString);
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
  
  protected void b(List<MessageRecord> paramList)
  {
    int k = 0;
    Object localObject1 = this.jdField_a_of_type_Amno.a();
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
            if ((localObject1 == null) || (((amoa)localObject1).jdField_a_of_type_Long <= ((MessageRecord)localObject2).time)) {
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
        if ((localObject1 != null) && (((amoa)localObject1).a()) && (paramList != null))
        {
          localObject2 = new MessageRecord();
          ((MessageRecord)localObject2).istroop = 1032;
          ((MessageRecord)localObject2).frienduin = ajsf.aN;
          ((MessageRecord)localObject2).time = ((amoa)localObject1).jdField_a_of_type_Long;
          ((MessageRecord)localObject2).senderuin = ((amoa)localObject1).jdField_a_of_type_JavaLangString;
          ((MessageRecord)localObject2).msg = ((amoa)localObject1).c;
          ((MessageRecord)localObject2).msg2 = ((amoa)localObject1).b;
          ((MessageRecord)localObject2).longMsgCount = ((amoa)localObject1).jdField_a_of_type_Int;
          paramList.add(i, localObject2);
        }
        if ((paramList != null) && (!paramList.isEmpty())) {
          break label435;
        }
        j = 1;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        localObject2 = ((aktg)localObject1).b(ajsf.aM, 1032);
        bool = amnk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "redpoint_box_show");
        l1 = amnk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "redpoint_box_show");
        long l2 = amnk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "redpoint_clear_time");
        long l3 = awzw.a();
        if ((j == 0) || (localObject2 == null) || (bool) || (Math.abs(l3 - l2) <= 259200000L)) {
          break label440;
        }
        ((aktg)localObject1).b((RecentUser)localObject2);
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
          ((RecentUser)localObject2).uin = ajsf.aM;
          ((RecentUser)localObject2).setType(1032);
          if (bool) {}
          for (l1 = Math.max(((MessageRecord)paramList.get(0)).time, l1);; l1 = ((MessageRecord)paramList.get(0)).time)
          {
            ((RecentUser)localObject2).lastmsgtime = l1;
            ((aktg)localObject1).a((RecentUser)localObject2);
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
            paramList.uin = ajsf.aM;
            paramList.setType(1032);
            paramList.lastmsgtime = l1;
            ((aktg)localObject1).a(paramList);
            i = 1;
          }
        }
      }
      label590:
      break;
    }
  }
  
  protected void c()
  {
    a();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698699));
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    this.jdField_a_of_type_Amno = ((amno)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269));
    paramBundle = this.jdField_a_of_type_Amno.b();
    if ((paramBundle != null) && (paramBundle.g == 1))
    {
      Drawable localDrawable1 = getResources().getDrawable(2130849302);
      Drawable localDrawable2 = getResources().getDrawable(2130844185);
      if ((this.jdField_b_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable1);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable2);
        this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      }
      if ((paramBundle == null) || ((paramBundle != null) && (paramBundle.h >= 1)) || (amnk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "redpoint_box_show")))
      {
        this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560694, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        if ((LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams() != null) {
          break label368;
        }
        paramBundle = new LinearLayout.LayoutParams(-1, paramViewGroup.getDimensionPixelSize(2131297958));
        paramBundle.topMargin = paramViewGroup.getDimensionPixelSize(2131297959);
        paramBundle.bottomMargin = paramViewGroup.getDimensionPixelOffset(2131297959);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidViewView, paramBundle);
        label261:
        this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
        d();
        this.jdField_c_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560701, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        if ((LinearLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams() != null) {
          break label382;
        }
        paramLayoutInflater = new LinearLayout.LayoutParams(-1, paramViewGroup.getDimensionPixelSize(2131297960));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidViewView, paramLayoutInflater);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amnt, true);
      ThreadManager.post(new ConfessMsgListFragment.1(this), 5, null, true);
      return;
      setRightButton(2131719373, this);
      break;
      label368:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidViewView);
      break label261;
      label382:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidViewView);
    }
  }
  
  public void onClick(View paramView)
  {
    label25:
    Object localObject;
    if (paramView == this.jdField_b_of_type_AndroidViewView) {
      if (this.jdField_a_of_type_Amno == null)
      {
        paramView = null;
        if (paramView != null) {
          break label192;
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
        localObject = this.jdField_b_of_type_AndroidViewView.findViewById(2131375038);
        if (((View)localObject).getVisibility() != 8) {
          ((View)localObject).setVisibility(8);
        }
        amns.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008F4B", "0X8008F4B", 2, 0, "", "", "", "");
        if (QLog.isDevelopLevel()) {
          QLog.i("ConfessMsgListFragment", 4, String.format(Locale.getDefault(), "click entry url: %s", new Object[] { paramView }));
        }
      }
    }
    label192:
    label217:
    label366:
    do
    {
      return;
      paramView = this.jdField_a_of_type_Amno.b();
      break;
      paramView = paramView.k;
      break label25;
      if (paramView == this.rightViewText)
      {
        if (this.jdField_a_of_type_Amno == null)
        {
          paramView = null;
          if (paramView != null) {
            break label341;
          }
        }
        for (paramView = "https://ti.qq.com/honest-say/setting.html?_wv=9191&_wwv=4&_qStyle=1&adtag=message_box";; paramView = paramView.p)
        {
          if (!TextUtils.isEmpty(paramView))
          {
            localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
            ((Intent)localObject).putExtra("url", paramView);
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
          }
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80091A1", "0X80091A1", 0, 0, "", "", "", "");
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.i("ConfessMsgListFragment", 4, String.format(Locale.getDefault(), "click entry url: %s", new Object[] { paramView }));
          return;
          paramView = this.jdField_a_of_type_Amno.b();
          break label217;
        }
      }
      if (paramView == this.jdField_b_of_type_AndroidWidgetImageView)
      {
        if (this.jdField_a_of_type_Amno == null)
        {
          paramView = null;
          if (paramView != null) {
            break label490;
          }
        }
        for (paramView = "https://ti.qq.com/honest-say/rank.html?_wv=9191&_wwv=4&_qStyle=1";; paramView = paramView.q)
        {
          if (!TextUtils.isEmpty(paramView))
          {
            localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
            ((Intent)localObject).putExtra("url", paramView);
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
          }
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800948C", "0X800948C", 0, 0, "", "", "", "");
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.i("ConfessMsgListFragment", 4, String.format(Locale.getDefault(), "click entry url: %s", new Object[] { paramView }));
          return;
          paramView = this.jdField_a_of_type_Amno.b();
          break label366;
        }
      }
    } while (paramView != this.jdField_a_of_type_AndroidWidgetImageView);
    label341:
    label490:
    if (this.jdField_a_of_type_Amno == null)
    {
      paramView = null;
      if (paramView != null) {
        break label639;
      }
    }
    label515:
    label639:
    for (paramView = "https://ti.qq.com/honest-say/setting.html?_wv=9191&_wwv=4&_qStyle=1&adtag=message_box";; paramView = paramView.p)
    {
      if (!TextUtils.isEmpty(paramView))
      {
        localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramView);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
      }
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80091A1", "0X80091A1", 0, 0, "", "", "", "");
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("ConfessMsgListFragment", 4, String.format(Locale.getDefault(), "click entry url: %s", new Object[] { paramView }));
      return;
      paramView = this.jdField_a_of_type_Amno.b();
      break label515;
    }
  }
  
  public View onCreateLeftView()
  {
    View localView = super.onCreateLeftView();
    this.leftView.setText("  ");
    return localView;
  }
  
  public View onCreateRightView()
  {
    this.rightViewText = ((TextView)this.titleRoot.findViewById(2131368457));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.titleRoot.findViewById(2131368441));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.titleRoot.findViewById(2131368442));
    setLayerType(this.jdField_a_of_type_AndroidWidgetImageView);
    setLayerType(this.jdField_b_of_type_AndroidWidgetImageView);
    setLayerType(this.rightViewText);
    return this.rightViewText;
  }
  
  public void onDestroyView()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amnt);
    super.onDestroyView();
  }
  
  public void onResume()
  {
    super.onResume();
    d();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.i("ConfessMsgListFragment", 2, "onWindowFocusChanged " + paramBoolean);
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
      if ((this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramObservable.senderuin))) {
        break label36;
      }
    }
    label36:
    while ((paramObservable.istroop != 1032) && (paramObservable.istroop != 1033) && (paramObservable.istroop != 1034)) {
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessMsgListFragment
 * JD-Core Version:    0.7.0.1
 */