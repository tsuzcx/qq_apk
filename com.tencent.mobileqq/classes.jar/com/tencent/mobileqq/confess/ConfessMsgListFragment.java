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
  View A;
  View B;
  ConfessManager C;
  public ImageView D;
  public ImageView E;
  ConfessObserver F = new ConfessMsgListFragment.3(this);
  
  public static void a(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uintype", 1032);
    localIntent.putExtra("uin", AppConstants.CONFESS_UIN);
    localIntent.addFlags(335544320);
    PublicFragmentActivity.a(paramContext, localIntent, ConfessMsgListFragment.class);
  }
  
  private void f()
  {
    if (this.A == null) {
      return;
    }
    boolean bool2 = ConfessConfig.a(this.b, "redpoint_box_show");
    int j = this.A.findViewById(2131444541).getVisibility();
    int i = 0;
    boolean bool1;
    if (j == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (bool2 != bool1)
    {
      localObject1 = this.A.findViewById(2131444541);
      if (!bool2) {
        i = 8;
      }
      ((View)localObject1).setVisibility(i);
    }
    Object localObject1 = this.C;
    Object localObject4 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((ConfessManager)localObject1).d();
    }
    if (localObject1 != null)
    {
      localObject4 = ((ConfessConfig)localObject1).p;
      localObject3 = ((ConfessConfig)localObject1).b();
      localObject1 = ((ConfessConfig)localObject1).B;
    }
    else
    {
      localObject1 = null;
      localObject3 = localObject1;
    }
    Object localObject2 = localObject4;
    if (TextUtils.isEmpty((CharSequence)localObject4)) {
      localObject2 = ConfessConfig.a;
    }
    localObject4 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject3)) {
      localObject4 = ConfessConfig.b;
    }
    Object localObject3 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject3 = ConfessConfig.c;
    }
    localObject1 = (TextView)this.f.findViewById(2131431322);
    TextView localTextView = (TextView)this.f.findViewById(2131431733);
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
  
  protected boolean a(String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = this.t.iterator();
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
  
  protected List<RecentBaseData> b(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return localArrayList;
      }
      String str = this.b.getAccount();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        if (localMessageRecord != null)
        {
          paramList = c();
          if ((paramList instanceof RecentItemConfessMsg)) {
            paramList = (RecentItemConfessMsg)paramList;
          } else {
            paramList = new RecentItemConfessMsg();
          }
          paramList.a(this.b, str, localMessageRecord);
          paramList.a(this.b, this.c);
          localArrayList.add(paramList);
        }
      }
    }
    return localArrayList;
  }
  
  protected void c(List<MessageRecord> paramList)
  {
    Object localObject1 = this.C.b();
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
          if (((FrdConfessInfo)localObject1).c > ((MessageRecord)localObject2).time) {
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
    if ((localObject1 != null) && (((FrdConfessInfo)localObject1).c()) && (paramList != null))
    {
      localObject2 = new MessageRecord();
      ((MessageRecord)localObject2).istroop = 1032;
      ((MessageRecord)localObject2).frienduin = AppConstants.CONFESS_FRD_REC_UIN;
      ((MessageRecord)localObject2).time = ((FrdConfessInfo)localObject1).c;
      ((MessageRecord)localObject2).senderuin = ((FrdConfessInfo)localObject1).e;
      ((MessageRecord)localObject2).msg = ((FrdConfessInfo)localObject1).g;
      ((MessageRecord)localObject2).msg2 = ((FrdConfessInfo)localObject1).f;
      ((MessageRecord)localObject2).longMsgCount = ((FrdConfessInfo)localObject1).b;
      paramList.add(i, localObject2);
    }
    if ((paramList != null) && (!paramList.isEmpty())) {
      i = 0;
    } else {
      i = 1;
    }
    localObject1 = this.b.getProxyManager().g();
    Object localObject2 = ((RecentUserProxy)localObject1).c(AppConstants.CONFESS_UIN, 1032);
    boolean bool = ConfessConfig.a(this.b, "redpoint_box_show");
    long l1 = ConfessConfig.b(this.b, "redpoint_box_show");
    long l2 = ConfessConfig.b(this.b, "redpoint_clear_time");
    long l3 = MessageCache.c();
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
      paramList = this.b.getHandler(Conversation.class);
      if (paramList != null) {
        paramList.sendEmptyMessage(1009);
      }
    }
  }
  
  protected void d()
  {
    a();
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(this.c.getString(2131896667));
    paramViewGroup = this.c.getResources();
    this.C = ((ConfessManager)this.b.getManager(QQManagerFactory.CONFESS_MANAGER));
    paramBundle = this.C.d();
    if ((paramBundle != null) && (paramBundle.y == 1))
    {
      Drawable localDrawable1 = getResources().getDrawable(2130852605);
      Drawable localDrawable2 = getResources().getDrawable(2130846438);
      ImageView localImageView = this.E;
      if ((localImageView != null) && (this.D != null))
      {
        localImageView.setVisibility(0);
        this.E.setImageDrawable(localDrawable1);
        this.D.setVisibility(0);
        this.D.setImageDrawable(localDrawable2);
        this.E.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.E.setContentDescription(getString(2131896665));
        this.D.setContentDescription(getString(2131891482));
      }
    }
    else
    {
      setRightButton(2131916361, this);
    }
    if ((paramBundle == null) || ((paramBundle != null) && (paramBundle.z >= 1)) || (ConfessConfig.a(this.b, "redpoint_box_show")))
    {
      this.A = paramLayoutInflater.inflate(2131627356, this.f, false);
      if ((LinearLayout.LayoutParams)this.A.getLayoutParams() == null)
      {
        paramBundle = new LinearLayout.LayoutParams(-1, paramViewGroup.getDimensionPixelSize(2131298914));
        paramBundle.topMargin = paramViewGroup.getDimensionPixelSize(2131298915);
        paramBundle.bottomMargin = paramViewGroup.getDimensionPixelOffset(2131298915);
        this.f.addView(this.A, paramBundle);
      }
      else
      {
        this.f.addView(this.A);
      }
      this.A.setOnClickListener(this);
      f();
      this.B = paramLayoutInflater.inflate(2131627363, this.f, false);
      if ((LinearLayout.LayoutParams)this.B.getLayoutParams() == null)
      {
        paramLayoutInflater = new LinearLayout.LayoutParams(-1, paramViewGroup.getDimensionPixelSize(2131298916));
        this.f.addView(this.B, paramLayoutInflater);
      }
      else
      {
        this.f.addView(this.B);
      }
    }
    this.b.addObserver(this.F, true);
    ThreadManager.post(new ConfessMsgListFragment.1(this), 5, null, true);
  }
  
  public void onClick(View paramView)
  {
    Object localObject4 = this.A;
    Object localObject2 = null;
    ConfessManager localConfessManager = null;
    Object localObject3 = null;
    Object localObject1 = null;
    if (paramView == localObject4)
    {
      localObject2 = this.C;
      if (localObject2 != null) {
        localObject1 = ((ConfessManager)localObject2).d();
      }
      if (localObject1 == null) {
        localObject1 = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=message_box";
      } else {
        localObject1 = ((ConfessConfig)localObject1).r;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new Intent(this.c, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("hide_more_button", true);
        ((Intent)localObject2).putExtra("hide_operation_bar", true);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        this.c.startActivity((Intent)localObject2);
      }
      localObject2 = this.A.findViewById(2131444541);
      if (((View)localObject2).getVisibility() != 8) {
        ((View)localObject2).setVisibility(8);
      }
      ConfessMsgUtil.a(this.b, false);
      ReportController.b(this.b, "dc00898", "", "", "0X8008F4B", "0X8008F4B", 2, 0, "", "", "", "");
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
        localConfessManager = this.C;
        if (localConfessManager != null) {
          localObject2 = localConfessManager.d();
        }
        if (localObject2 != null) {
          localObject1 = ((ConfessConfig)localObject2).w;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = new Intent(this.c, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", (String)localObject1);
          this.c.startActivity((Intent)localObject2);
        }
        ReportController.b(this.b, "dc00898", "", "", "0X80091A1", "0X80091A1", 0, 0, "", "", "", "");
        if (QLog.isDevelopLevel()) {
          QLog.i("ConfessMsgListFragment", 4, String.format(Locale.getDefault(), "click entry url: %s", new Object[] { localObject1 }));
        }
      }
      else if (paramView == this.E)
      {
        localObject1 = this.C;
        if (localObject1 == null) {
          localObject1 = localConfessManager;
        } else {
          localObject1 = ((ConfessManager)localObject1).d();
        }
        if (localObject1 == null) {
          localObject1 = "https://ti.qq.com/honest-say/rank.html?_wv=9191&_wwv=4&_qStyle=1";
        } else {
          localObject1 = ((ConfessConfig)localObject1).x;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = new Intent(this.c, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", (String)localObject1);
          this.c.startActivity((Intent)localObject2);
        }
        ReportController.b(this.b, "dc00898", "", "", "0X800948C", "0X800948C", 0, 0, "", "", "", "");
        if (QLog.isDevelopLevel()) {
          QLog.i("ConfessMsgListFragment", 4, String.format(Locale.getDefault(), "click entry url: %s", new Object[] { localObject1 }));
        }
      }
      else if (paramView == this.D)
      {
        localObject2 = this.C;
        if (localObject2 == null) {
          localObject2 = localObject3;
        } else {
          localObject2 = ((ConfessManager)localObject2).d();
        }
        if (localObject2 != null) {
          localObject1 = ((ConfessConfig)localObject2).w;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = new Intent(this.c, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", (String)localObject1);
          this.c.startActivity((Intent)localObject2);
        }
        ReportController.b(this.b, "dc00898", "", "", "0X80091A1", "0X80091A1", 0, 0, "", "", "", "");
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
    this.rightViewText = ((TextView)this.titleRoot.findViewById(2131436211));
    this.D = ((ImageView)this.titleRoot.findViewById(2131436194));
    this.E = ((ImageView)this.titleRoot.findViewById(2131436195));
    setLayerType(this.D);
    setLayerType(this.E);
    setLayerType(this.rightViewText);
    return this.rightViewText;
  }
  
  public void onDestroyView()
  {
    this.b.removeObserver(this.F);
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
          paramView = this.C;
          if (paramView == null) {
            paramView = null;
          } else {
            paramView = paramView.d();
          }
          if (paramView == null) {
            paramView = "https://ti.qq.com/honest-say/friends-received.html?_bid=3104&_wv=9191&_qStyle=1&adtag=message_box";
          } else {
            paramView = paramView.t;
          }
          paramString = new Intent(this.c, QQBrowserActivity.class);
          paramString.putExtra("hide_more_button", true);
          paramString.putExtra("hide_operation_bar", true);
          paramString.putExtra("url", paramView);
          this.c.startActivity(paramString);
          ReportController.b(this.b, "dc00898", "", "", "0X8008F4F", "0X8008F4F", 2, 0, "", "", "", "");
        }
      }
      else
      {
        paramView = new Bundle();
        paramView.putInt("key_confessor_sex", paramRecentBaseData.mConfessInfo.confessorSex);
        paramView.putString("key_confessor_nick", paramRecentBaseData.mConfessInfo.confessorNick);
        paramView.putString("key_confess_desc", paramRecentBaseData.mConfessInfo.topic);
        paramView.putLong("key_confess_time", paramRecentBaseData.mConfessInfo.confessTime);
        ConfessMsgUtil.a(this.c, paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.mType, paramRecentBaseData.mConfessInfo.topicId, paramRecentBaseData.mTitleName, paramView);
        if (paramRecentBaseData.mType == 1033) {
          ReportController.b(this.b, "dc00898", "", "", "0X8008F4D", "0X8008F4D", 2, 0, "", "", "", "");
        } else {
          ReportController.b(this.b, "dc00898", "", "", "0X8008F4E", "0X8008F4E", 2, 0, "", "", "", "");
        }
      }
      ConfessMsgUtil.a(this.b, paramRecentBaseData, false);
    }
  }
  
  public void onRecentBaseDataDelete(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessMsgListFragment", 4, String.format(Locale.getDefault(), "onRecentBaseDataDelete [type: %s, uin: %s, r4: %s]", new Object[] { Integer.valueOf(paramRecentBaseData.getRecentUserType()), paramRecentBaseData.getRecentUserUin(), paramString }));
    }
    if ((paramRecentBaseData instanceof RecentItemConfessMsg)) {
      ConfessMsgUtil.a(this.b, (RecentItemConfessMsg)paramRecentBaseData, true);
    }
    b();
  }
  
  public void onResume()
  {
    super.onResume();
    f();
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
      if (this.m)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessMsgListFragment
 * JD-Core Version:    0.7.0.1
 */