package com.tencent.mobileqq.settings.message;

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
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
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
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.hotpic.HotPicDownLoader;
import com.tencent.mobileqq.hotpic.HotVideoPreviewDownloader;
import com.tencent.mobileqq.qrscan.utils.QRUtils;
import com.tencent.mobileqq.scribble.ScribbleMsgConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.roamsetting.RoamSettingObserver;
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
import java.util.Vector;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class ChatHistorySettingFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  protected FormSimpleItem a;
  protected FormSimpleItem b;
  QQProgressDialog c;
  RoamSettingObserver d = new ChatHistorySettingFragment.6(this);
  FriendListObserver e = new ChatHistorySettingFragment.7(this);
  Handler f = new ChatHistorySettingFragment.8(this);
  private QQAppInterface g;
  private String h = "";
  private BounceScrollView i;
  private FormSwitchItem j;
  private FormSimpleItem k;
  private TextView l;
  private View m;
  private View n;
  private long o = 0L;
  private SVIPObserver p = new ChatHistorySettingFragment.5(this);
  private QQProgressDialog q;
  
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
    QQProgressDialog localQQProgressDialog = this.c;
    if (localQQProgressDialog != null)
    {
      if ((paramBoolean) && (!localQQProgressDialog.isShowing()))
      {
        this.c.show();
        return;
      }
      if ((!paramBoolean) && (this.c.isShowing())) {
        this.c.dismiss();
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
    this.i = ((BounceScrollView)this.mContentView.findViewById(2131445362));
    this.h = this.g.getCurrentAccountUin();
    this.j = ((FormSwitchItem)this.mContentView.findViewById(2131442490));
    FormSwitchItem localFormSwitchItem = this.j;
    boolean bool;
    if (this.g.getC2CRoamingSetting() == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localFormSwitchItem.setChecked(bool);
    this.j.setOnCheckedChangeListener(this);
    this.k = ((FormSimpleItem)this.mContentView.findViewById(2131438156));
    this.k.setRightTextColor(2);
    this.k.setOnClickListener(this);
    this.l = ((TextView)this.mContentView.findViewById(2131447271));
    this.m = this.mContentView.findViewById(2131431686);
    this.n = this.mContentView.findViewById(2131431683);
    this.m.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.m.setContentDescription(getString(2131888427));
    this.n.setContentDescription(getString(2131888417));
    h();
    g();
    this.g.addObserver(this.d);
    this.g.addObserver(this.e);
    this.g.addObserver(this.p);
    j();
    if (VersionUtils.c()) {
      this.i.setOverScrollMode(0);
    }
    if (this.c == null)
    {
      this.c = new QQProgressDialog(getBaseActivity(), getBaseActivity().getTitleBarHeight());
      this.c.a(getString(2131887798));
      this.c.setCanceledOnTouchOutside(true);
      this.c.c(true);
      this.c.a(false);
      this.c.b(true);
    }
    f();
  }
  
  private void f()
  {
    ReportController.a(this.g, "0X800B813");
    ReportController.a(this.g, "0X800B815");
    ReportController.a(this.g, "0X800B816");
  }
  
  private void g()
  {
    this.b = ((FormSimpleItem)this.mContentView.findViewById(2131444484));
    this.b.setContentDescription(getString(2131887461));
    this.b.setOnClickListener(new ChatHistorySettingFragment.1(this));
    ReportController.a(this.g, "0X800B812");
  }
  
  private void h()
  {
    this.a = ((FormSimpleItem)this.mContentView.findViewById(2131444488));
    this.a.setOnClickListener(new ChatHistorySettingFragment.2(this));
    this.a.setContentDescription(getString(2131887460));
    ReportController.a(this.g, "0X800B811");
  }
  
  private void i()
  {
    if (getBaseActivity() == null)
    {
      QLog.e("ChatHistorySettingFragment", 1, "syncMessageRoamFlag: activity is null");
      return;
    }
    Object localObject = this.g.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("message_roam_flag");
    localStringBuilder.append(this.g.getCurrentAccountUin());
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
      this.k.setRightText((CharSequence)localObject);
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
  
  private void j()
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
      this.j.setVisibility(8);
      this.k.setVisibility(8);
      this.l.setVisibility(8);
      return;
    }
    this.j.setVisibility(0);
    this.k.setVisibility(0);
    ReportController.a(this.g, "0X800B814");
    this.l.setVisibility(0);
  }
  
  private void k()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(this.h);
    localStringBuilder.append("/");
    localStringBuilder.append("ptt/");
    b(localStringBuilder.toString());
  }
  
  private void l()
  {
    try
    {
      this.g.getMessageFacade().b();
      this.g.getMessageFacade().v();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    this.g.getMessageFacade().d();
  }
  
  void a()
  {
    try
    {
      if (this.q != null)
      {
        this.q.dismiss();
        this.q.cancel();
        this.q = null;
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
    if (this.q == null) {
      this.q = new QQProgressDialog(getBaseActivity(), getBaseActivity().getTitleBarHeight());
    }
    this.q.setCancelable(true);
    this.q.a(paramString);
    this.q.show();
  }
  
  void b()
  {
    this.g.getMessageFacade().v();
    a(this.h, true);
    k();
    d();
    l();
    a(this.g);
    c();
    ((IStickerRecManager)this.g.getRuntimeService(IStickerRecManager.class)).deletePicCache();
    MqqHandler localMqqHandler = this.g.getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(1009);
    }
  }
  
  void c()
  {
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.g.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    localMessageRoamManager.u();
    localMessageRoamManager.i();
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getBaseActivity().getAppRuntime() instanceof QQAppInterface))
    {
      this.g = ((QQAppInterface)getBaseActivity().getAppRuntime());
      if (this.g != null) {
        e();
      }
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131627795;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((1000 == paramInt1) && (paramInt2 == 1001))
    {
      if (getBaseActivity() != null) {
        getBaseActivity().setResult(1001);
      }
      onBackEvent();
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void onClick(View paramView)
  {
    Object localObject2;
    Object localObject1;
    if (paramView.getId() == 2131438156)
    {
      localObject2 = new Intent(getBaseActivity(), QQBrowserActivity.class);
      localObject1 = IndividuationUrlHelper.a("vipRoamChatCell");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.e("ChatHistorySettingFragment", 1, "gotoRoamMessageSettingUrl ! url empty");
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
        ReportController.a(this.g, "0X800B878");
      }
    }
    else
    {
      int i1 = paramView.getId();
      int i2 = 0;
      long l1;
      long l2;
      if (i1 == 2131431683)
      {
        l1 = System.currentTimeMillis();
        l2 = this.o;
        if ((!getBaseActivity().isFinishing()) && (l1 - l2 >= 500L))
        {
          this.o = l1;
          localObject1 = new DeleteRecordDialog(getBaseActivity(), this.g, false);
          ((DeleteRecordDialog)localObject1).a(new ChatHistorySettingFragment.3(this));
          ((DeleteRecordDialog)localObject1).a(HardCodeUtil.a(2131908372));
          ((DeleteRecordDialog)localObject1).b(HardCodeUtil.a(2131908361));
          ((DeleteRecordDialog)localObject1).a(4);
        }
      }
      else
      {
        l1 = System.currentTimeMillis();
        l2 = this.o;
        if ((!getBaseActivity().isFinishing()) && (l1 - l2 >= 500L))
        {
          this.o = l1;
          localObject2 = getBaseActivity();
          localObject1 = null;
          localObject2 = (ActionSheet)ActionSheetHelper.b((Context)localObject2, null);
          if (paramView.getId() != 2131431686)
          {
            i1 = 0;
          }
          else
          {
            i2 = 2131888427;
            localObject1 = new ChatHistorySettingFragment.4(this, (ActionSheet)localObject2);
            i1 = 2131887797;
          }
          ((ActionSheet)localObject2).addButton(i2, 3);
          ((ActionSheet)localObject2).addCancelButton(getString(2131887648));
          ((ActionSheet)localObject2).setOnButtonClickListener((ActionSheet.OnButtonClickListener)localObject1);
          ((ActionSheet)localObject2).setMainTitle(i1);
          ((ActionSheet)localObject2).show();
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getBaseActivity().getString(2131887736));
    return localView;
  }
  
  public void onDestroy()
  {
    Object localObject = this.c;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing())) {
      a(false);
    }
    localObject = this.g;
    if (localObject != null)
    {
      ((QQAppInterface)localObject).removeObserver(this.d);
      this.g.removeObserver(this.e);
      this.g.removeObserver(this.p);
    }
    this.f.removeCallbacksAndMessages(null);
    super.onDestroy();
    QQSettingMsgHistoryActivity.a();
    QRUtils.a(getBaseActivity());
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.g != null)
    {
      i();
      ((IApolloExtensionHandler)this.g.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(new String[] { this.g.getCurrentAccountUin() }, new int[] { 42255 });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.ChatHistorySettingFragment
 * JD-Core Version:    0.7.0.1
 */