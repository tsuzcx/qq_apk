package com.tencent.mobileqq.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.common.util.GCCommon;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.activity.aio.helper.HiddenChatHelper;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatFragment;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatUtil;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpic.HotPicDownLoader;
import com.tencent.mobileqq.hotpic.HotVideoPreviewDownloader;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.qrscan.utils.QRUtils;
import com.tencent.mobileqq.scribble.ScribbleMsgConstants;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.roamsetting.RoamSettingObserver;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.DeleteRecordDialog;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheetHelper;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class QQSettingChatOperationFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, Observer
{
  QQProgressDialog a;
  RoamSettingObserver b = new QQSettingChatOperationFragment.4(this);
  FriendListObserver c = new QQSettingChatOperationFragment.5(this);
  Handler d = new QQSettingChatOperationFragment.6(this);
  private QQAppInterface e;
  private String f = "";
  private BounceScrollView g;
  private FormSwitchItem h;
  private FormSimpleItem i;
  private TextView j;
  private TextView k;
  private View l;
  private View m;
  private long n = 0L;
  private SVIPObserver o = new QQSettingChatOperationFragment.3(this);
  private QQProgressDialog p;
  
  private static void a(QQAppInterface paramQQAppInterface)
  {
    if (URLDrawableHelper.diskCachePath != null)
    {
      b(URLDrawableHelper.diskCachePath.getAbsolutePath());
      if (((paramQQAppInterface.getApp() instanceof BaseApplicationImpl)) && (GlobalImageCache.a != null)) {
        GlobalImageCache.a.evictAll();
      }
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    int i1 = 0;
    while (i1 < CardHandler.b.size())
    {
      paramString = new StringBuilder();
      paramString.append(CardHandler.a);
      paramString.append(((Integer)CardHandler.b.get(i1)).intValue());
      paramString.append("/");
      b(paramString.toString());
      i1 += 1;
    }
    paramString = new StringBuilder();
    paramString.append(CardHandler.a);
    paramString.append("background");
    paramString.append("/");
    b(paramString.toString());
    paramString = new StringBuilder();
    paramString.append(AppConstants.SDCARD_PATH);
    paramString.append("temp");
    paramString.append("/");
    b(paramString.toString());
    paramString = new StringBuilder();
    paramString.append(CardHandler.a);
    paramString.append("temp");
    paramString.append("/");
    b(paramString.toString());
    paramString = new StringBuilder();
    paramString.append(CardHandler.a);
    paramString.append("HDAvatar");
    paramString.append("/");
    b(paramString.toString());
    b(AppConstants.PATH_CARD_QZONE);
    paramString = new StringBuilder();
    paramString.append(CardHandler.a);
    paramString.append("voice");
    paramString.append("/");
    b(paramString.toString());
    paramString = new StringBuilder();
    paramString.append(GCCommon.a());
    paramString.append("/");
    b(paramString.toString());
    b(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_SCREENSHOTS);
    b(HotPicDownLoader.a);
    b(HotVideoPreviewDownloader.a);
    b(ScribbleMsgConstants.a());
  }
  
  private void a(boolean paramBoolean)
  {
    QQProgressDialog localQQProgressDialog = this.a;
    if (localQQProgressDialog != null)
    {
      if ((paramBoolean) && (!localQQProgressDialog.isShowing()))
      {
        this.a.show();
        return;
      }
      if ((!paramBoolean) && (this.a.isShowing())) {
        this.a.dismiss();
      }
    }
  }
  
  private static void b(String paramString)
  {
    paramString = new File(paramString).listFiles();
    if (paramString != null)
    {
      int i1 = 0;
      while (i1 < paramString.length)
      {
        paramString[i1].delete();
        i1 += 1;
      }
    }
  }
  
  static void d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("photo/");
    b(localStringBuilder.toString());
  }
  
  private void e()
  {
    this.g = ((BounceScrollView)this.mContentView.findViewById(2131445362));
    this.f = this.e.getCurrentAccountUin();
    Object localObject = this.mContentView.findViewById(2131435036);
    this.j = ((TextView)((View)localObject).findViewById(2131449123));
    this.j.setVisibility(8);
    ((View)localObject).setOnClickListener(this);
    this.h = ((FormSwitchItem)this.mContentView.findViewById(2131442490));
    localObject = this.h;
    boolean bool;
    if (this.e.getC2CRoamingSetting() == 1) {
      bool = true;
    } else {
      bool = false;
    }
    ((FormSwitchItem)localObject).setChecked(bool);
    this.h.setOnCheckedChangeListener(this);
    this.i = ((FormSimpleItem)this.mContentView.findViewById(2131438156));
    this.i.setRightTextColor(2);
    this.i.setOnClickListener(this);
    this.k = ((TextView)this.mContentView.findViewById(2131447271));
    this.l = this.mContentView.findViewById(2131431686);
    this.m = this.mContentView.findViewById(2131431683);
    this.l.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.l.setContentDescription(getString(2131888427));
    this.m.setContentDescription(getString(2131888417));
    this.e.addObserver(this.c);
    this.e.addObserver(this.b);
    this.e.addObserver(this.o);
    this.e.getMessageFacade().addObserver(this);
    i();
    if (VersionUtils.c()) {
      this.g.setOverScrollMode(0);
    }
    if (this.a == null)
    {
      this.a = new QQProgressDialog(getBaseActivity(), getBaseActivity().getTitleBarHeight());
      this.a.a(getString(2131887798));
      this.a.setCanceledOnTouchOutside(true);
      this.a.c(true);
      this.a.a(false);
      this.a.b(true);
    }
  }
  
  private void f()
  {
    if (!HiddenChatUtil.a(this.e.getCurrentUin(), getBaseActivity()))
    {
      this.j.setVisibility(8);
      return;
    }
    int i1 = g();
    if (i1 > 99)
    {
      this.j.setText("99+");
      this.j.setVisibility(0);
      return;
    }
    if (i1 > 0)
    {
      TextView localTextView = this.j;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i1);
      localStringBuilder.append("");
      localTextView.setText(localStringBuilder.toString());
      this.j.setVisibility(0);
      return;
    }
    this.j.setVisibility(8);
  }
  
  private int g()
  {
    Object localObject = HiddenChatFragment.a(this.e.getProxyManager().g().c(), TroopAssistantManager.a().o(this.e));
    int i2 = 0;
    int i1 = 0;
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return 0;
      }
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        i2 = i1;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject).next();
        i1 += this.e.getConversationFacade().a(localRecentUser.uin, localRecentUser.getType());
      }
    }
    return i2;
  }
  
  private void h()
  {
    if (getBaseActivity() == null)
    {
      QLog.e("QQSettingChatOperationFragment", 1, "syncMessageRoamFlag: activity is null");
      return;
    }
    Object localObject = this.e.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("message_roam_flag");
    localStringBuilder.append(this.e.getCurrentAccountUin());
    int i1 = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0);
    localObject = null;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4)
          {
            if (i1 == 5) {
              localObject = getResources().getString(2131914223);
            }
          }
          else {
            localObject = getResources().getString(2131914221);
          }
        }
        else {
          localObject = getResources().getString(2131914222);
        }
      }
      else {
        localObject = getResources().getString(2131914224);
      }
    }
    else {
      localObject = getResources().getString(2131914231);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.i.setRightText((CharSequence)localObject);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("messge roam flag is error ,is : ");
      ((StringBuilder)localObject).append(i1);
      QLog.d("QQSettingMsgHistoryActivity", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void i()
  {
    Intent localIntent = getBaseActivity().getIntent();
    int i1;
    if ((localIntent != null) && (localIntent.hasExtra("set_display_type"))) {
      i1 = localIntent.getIntExtra("set_display_type", 0);
    } else {
      i1 = 0;
    }
    if (i1 == 2)
    {
      this.h.setVisibility(8);
      this.i.setVisibility(8);
      this.k.setVisibility(8);
      return;
    }
    this.h.setVisibility(0);
    this.i.setVisibility(0);
    this.k.setVisibility(0);
  }
  
  private void j()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(this.f);
    localStringBuilder.append("/");
    localStringBuilder.append("ptt/");
    b(localStringBuilder.toString());
  }
  
  private void k()
  {
    try
    {
      this.e.getMessageFacade().b();
      this.e.getMessageFacade().v();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    this.e.getMessageFacade().d();
  }
  
  void a()
  {
    try
    {
      if (this.p != null)
      {
        this.p.dismiss();
        this.p.cancel();
        this.p = null;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  void a(String paramString)
  {
    if (this.p == null) {
      this.p = new QQProgressDialog(getBaseActivity(), getBaseActivity().getTitleBarHeight());
    }
    this.p.setCancelable(true);
    this.p.a(paramString);
    this.p.show();
  }
  
  void b()
  {
    this.e.getMessageFacade().v();
    a(this.f, true);
    j();
    d();
    k();
    a(this.e);
    c();
    ((IStickerRecManager)this.e.getRuntimeService(IStickerRecManager.class)).deletePicCache();
    MqqHandler localMqqHandler = this.e.getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(1009);
    }
  }
  
  void c()
  {
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.e.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    localMessageRoamManager.u();
    localMessageRoamManager.i();
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getBaseActivity().getAppRuntime() instanceof QQAppInterface))
    {
      this.e = ((QQAppInterface)getBaseActivity().getAppRuntime());
      if (this.e != null) {
        e();
      }
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131629180;
  }
  
  public boolean onBackEvent()
  {
    boolean bool = super.onBackEvent();
    HiddenChatHelper.b(getBaseActivity(), GeneralSettingActivity.class);
    return bool;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void onClick(View paramView)
  {
    int i2 = paramView.getId();
    int i1 = 0;
    Object localObject2;
    Object localObject1;
    if (i2 == 2131438156)
    {
      localObject2 = new Intent(getBaseActivity(), QQBrowserActivity.class);
      localObject1 = IndividuationUrlHelper.a("vipRoamChatCell");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.e("QQSettingChatOperationFragment", 1, "gotoRoamMessageSettingUrl ! url empty");
      }
      else
      {
        StringBuilder localStringBuilder;
        if (((String)localObject1).contains("?"))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("&ADTAG=msgRoam");
          localObject1 = localStringBuilder.toString();
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("?ADTAG=msgRoam");
          localObject1 = localStringBuilder.toString();
        }
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        startActivity((Intent)localObject2);
        VipUtils.a(this.e, "chat_history", "ChatHistory", "Clk_RoamMsgSetting", 2, 0, new String[] { "0", "0", "msgRoam" });
      }
    }
    else if (paramView.getId() == 2131435036)
    {
      HiddenChatFragment.a(getBaseActivity(), 1, 0, new Intent());
    }
    else
    {
      long l1;
      long l2;
      if (paramView.getId() == 2131431683)
      {
        l1 = System.currentTimeMillis();
        l2 = this.n;
        if ((!getBaseActivity().isFinishing()) && (l1 - l2 >= 500L))
        {
          this.n = l1;
          localObject1 = new DeleteRecordDialog(getBaseActivity(), this.e, false);
          ((DeleteRecordDialog)localObject1).a(new QQSettingChatOperationFragment.1(this));
          ((DeleteRecordDialog)localObject1).a(HardCodeUtil.a(2131908372));
          ((DeleteRecordDialog)localObject1).b(HardCodeUtil.a(2131908361));
          ((DeleteRecordDialog)localObject1).a(4);
        }
      }
      else
      {
        l1 = System.currentTimeMillis();
        l2 = this.n;
        if ((!getBaseActivity().isFinishing()) && (l1 - l2 >= 500L))
        {
          this.n = l1;
          localObject2 = getBaseActivity();
          localObject1 = null;
          localObject2 = (ActionSheet)ActionSheetHelper.b((Context)localObject2, null);
          if (paramView.getId() != 2131431686)
          {
            i2 = 0;
          }
          else
          {
            i1 = 2131888427;
            localObject1 = new QQSettingChatOperationFragment.2(this, (ActionSheet)localObject2);
            i2 = 2131887797;
          }
          ((ActionSheet)localObject2).addButton(i1, 3);
          ((ActionSheet)localObject2).addCancelButton(getString(2131887648));
          ((ActionSheet)localObject2).setOnButtonClickListener((ActionSheet.OnButtonClickListener)localObject1);
          ((ActionSheet)localObject2).setMainTitle(i2);
          ((ActionSheet)localObject2).show();
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getBaseActivity().getString(2131886083));
    return localView;
  }
  
  public void onDestroy()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing())) {
      a(false);
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((QQAppInterface)localObject).removeObserver(this.c);
      this.e.removeObserver(this.b);
      this.e.removeObserver(this.o);
      this.e.getMessageFacade().deleteObserver(this);
    }
    this.d.removeCallbacksAndMessages(null);
    super.onDestroy();
    QQSettingMsgHistoryActivity.a();
    QRUtils.a(getBaseActivity());
  }
  
  public void onResume()
  {
    super.onResume();
    f();
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.e != null)
    {
      h();
      ((IApolloExtensionHandler)this.e.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(new String[] { this.e.getCurrentAccountUin() }, new int[] { 42255 });
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!HiddenChatUtil.a(this.e.getCurrentUin(), getBaseActivity())) {
      return;
    }
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (!HiddenChatHelper.a(paramObservable.frienduin, paramObservable.istroop, this.e)) {
        return;
      }
      this.d.sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingChatOperationFragment
 * JD-Core Version:    0.7.0.1
 */