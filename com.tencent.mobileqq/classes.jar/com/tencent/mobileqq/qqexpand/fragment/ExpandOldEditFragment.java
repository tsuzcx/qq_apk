package com.tencent.mobileqq.qqexpand.fragment;

import QC.SuixintieCheckItem;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.etrump.mixlayout.ETTextView;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout.StickyNoteShopSetting;
import com.tencent.mobileqq.profile.view.SoftInputDetectView;
import com.tencent.mobileqq.profile.view.SoftInputDetectView.OnImStateChangedListener;
import com.tencent.mobileqq.qqexpand.bean.profile.ExtendFriendInfo;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.network.IExpandHandler;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.VasResEngine.VasRes;
import com.tencent.mobileqq.vas.VasResEngine.VasResAdapter;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vas.adapter.SignatureAdapter;
import com.tencent.mobileqq.vas.adapter.SignatureFontAdapter;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.network.NetworkState;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.XEditTextEx;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.List;
import mqq.app.AppRuntime;

public class ExpandOldEditFragment
  extends QPublicBaseFragment
  implements View.OnClickListener, View.OnTouchListener, StickyNoteShopLayout.StickyNoteShopSetting, SoftInputDetectView.OnImStateChangedListener
{
  private GestureDetector A;
  private final GestureDetector.OnGestureListener B = new ExpandOldEditFragment.2(this);
  private final TransProcessorHandler C = new ExpandOldEditFragment.3(this);
  public int a = 0;
  public boolean b;
  public AudioInfo c;
  BounceScrollView d;
  TextView e;
  LinearLayout f;
  SoftInputDetectView g;
  ExtendFriendOldProfileEditFragment h;
  ExtendFriendInfo i;
  ExpandObserver j = new ExpandOldEditFragment.1(this);
  private FrameLayout k;
  private StickyNoteShopLayout l;
  private StickyNoteShopLayout m;
  private ImageView n;
  private ImageView o;
  private boolean p = true;
  private int q = 0;
  private final SuixintieCheckItem r = new SuixintieCheckItem();
  private final SuixintieCheckItem s = new SuixintieCheckItem();
  private VasRes t;
  private String u;
  private boolean v = false;
  private QBaseActivity w;
  private QQAppInterface x;
  private FragmentManager y;
  private QQProgressDialog z;
  
  private void a(ExtendFriendInfo paramExtendFriendInfo)
  {
    Object localObject = this.h;
    if (localObject != null) {
      ((ExtendFriendOldProfileEditFragment)localObject).f();
    }
    this.z.show();
    localObject = this.c;
    if ((localObject != null) && (!TextUtils.isEmpty(((AudioInfo)localObject).path)))
    {
      a(this.c.path);
      return;
    }
    b(paramExtendFriendInfo);
  }
  
  private void a(String paramString)
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mIsUp = true;
    localTransferRequest.mLocalPath = paramString;
    localTransferRequest.mUniseq = System.currentTimeMillis();
    localTransferRequest.mFileType = 23;
    ((ITransFileController)this.x.getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
  }
  
  private void b(View paramView)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131436180);
    localTextView.setOnClickListener(this);
    this.e = ((TextView)paramView.findViewById(2131436211));
    if (ThemeUtil.isInNightMode(this.x)) {
      localTextView.setBackgroundDrawable(getResources().getDrawable(2130847291));
    }
    this.z = new QQProgressDialog(getQBaseActivity(), getQBaseActivity().getTitleBarHeight());
    this.z.c(true);
    this.d = ((BounceScrollView)paramView.findViewById(2131431349));
    this.A = new GestureDetector(getQBaseActivity(), this.B);
    this.f = ((LinearLayout)paramView.findViewById(2131437415));
    this.g = ((SoftInputDetectView)paramView.findViewById(2131435828));
    this.g.setExcludeStatusBar(false);
    this.g.setOnImStateChangedListener(this);
    this.k = ((FrameLayout)paramView.findViewById(2131433275));
    this.k.setVisibility(8);
    this.l = ((StickyNoteShopLayout)paramView.findViewById(2131429415));
    this.l.setShopCallback(this);
    this.l.setAppId(9);
    this.l.setUseId(2);
    this.m = ((StickyNoteShopLayout)paramView.findViewById(2131433556));
    this.m.setShopCallback(this);
    this.m.setAppId(5);
    this.m.setUseId(2);
    this.n = ((ImageView)paramView.findViewById(2131436647));
    this.n.setOnTouchListener(UITools.a);
    this.n.setOnClickListener(this);
    this.o = ((ImageView)paramView.findViewById(2131436648));
    this.o.setOnTouchListener(UITools.a);
    this.o.setOnClickListener(this);
    this.d.setOnTouchListener(this);
  }
  
  private void b(ExtendFriendInfo paramExtendFriendInfo)
  {
    IExpandHandler localIExpandHandler = (IExpandHandler)this.x.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
    ExtendFriendOldProfileEditFragment localExtendFriendOldProfileEditFragment = this.h;
    int i1;
    if (localExtendFriendOldProfileEditFragment != null) {
      i1 = localExtendFriendOldProfileEditFragment.j;
    } else {
      i1 = 20;
    }
    if ((!TextUtils.isEmpty(paramExtendFriendInfo.a)) && (paramExtendFriendInfo.a.length() < i1))
    {
      QQToast.makeText(getQBaseActivity(), String.format(HardCodeUtil.a(2131902290), new Object[] { Integer.valueOf(i1) }), 0).show();
      this.z.dismiss();
      return;
    }
    if ((TextUtils.isEmpty(paramExtendFriendInfo.a)) && (!TextUtils.isEmpty(paramExtendFriendInfo.d))) {
      i1 = 2;
    } else if ((!TextUtils.isEmpty(paramExtendFriendInfo.a)) && (TextUtils.isEmpty(paramExtendFriendInfo.d))) {
      i1 = 1;
    } else {
      i1 = 3;
    }
    ReportController.b(this.x, "dc00898", "", "", "0X80092DF", "0X80092DF", i1, 0, "", "", "", "");
    localIExpandHandler.a(this.x.getCurrentAccountUin(), paramExtendFriendInfo.a, paramExtendFriendInfo.d, paramExtendFriendInfo.e, this.s.itemId, this.s.fontType, this.r.itemId);
  }
  
  private void i()
  {
    this.h = new ExtendFriendOldProfileEditFragment();
    this.h.a(this);
    this.y.beginTransaction().add(2131431349, this.h).commit();
    this.i = ((ExtendFriendInfo)this.w.getIntent().getParcelableExtra("key_extend_friend_info"));
    ExtendFriendInfo localExtendFriendInfo = this.i;
    boolean bool2 = false;
    if (localExtendFriendInfo == null)
    {
      ((IExpandHandler)this.x.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(this.x.getCurrentAccountUin(), false);
      this.z.show();
      return;
    }
    ((IExpandHandler)this.x.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(this.x.getCurrentAccountUin(), true);
    if (this.i.a()) {
      this.h.a(this.i);
    }
    if (!NetworkState.isNetworkConnected(this.x.getApp())) {
      QQToast.makeText(this.x.getApp(), 1, 2131892102, 0).show();
    }
    boolean bool1 = bool2;
    if (TextUtils.isEmpty(this.i.a))
    {
      bool1 = bool2;
      if (TextUtils.isEmpty(this.i.d)) {
        bool1 = true;
      }
    }
    this.v = bool1;
  }
  
  public void a()
  {
    if ((!h()) && (!g()))
    {
      b();
      return;
    }
    if ((!h()) && (this.h.g.f == this.s.itemId) && (this.h.g.g == this.r.itemId))
    {
      b();
      return;
    }
    if ((isAdded()) || (this.b))
    {
      this.e.setTextColor(-16777216);
      this.e.setOnClickListener(this);
      this.e.setClickable(true);
    }
  }
  
  public void a(int paramInt)
  {
    ((RelativeLayout.LayoutParams)this.f.getLayoutParams()).bottomMargin = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (getQBaseActivity() == null) {
        return;
      }
      if (paramInt1 > 10000)
      {
        this.h.d.setVisibility(0);
        if ((this.h.d.getBackground() instanceof VasResDrawable))
        {
          ((VasResDrawable)this.h.d.getBackground()).a(paramInt1);
        }
        else
        {
          VasResDrawable localVasResDrawable = new VasResDrawable(this.x, paramInt1);
          SignatureAdapter localSignatureAdapter = new SignatureAdapter(localVasResDrawable, this.x, 2130847784);
          localSignatureAdapter.a(true);
          localVasResDrawable.a(localSignatureAdapter);
          this.h.d.setBackgroundDrawable(localVasResDrawable);
        }
        this.r.itemId = paramInt1;
        this.b = true;
        this.h.b.setBackgroundColor(Color.alpha(0));
        this.h.c.setBackgroundColor(Color.alpha(0));
      }
      else
      {
        this.h.d.setBackgroundColor(Color.alpha(0));
        this.h.b.setBackgroundDrawable(ExtendFriendOldProfileEditFragment.a);
        this.h.c.setBackgroundDrawable(ExtendFriendOldProfileEditFragment.a);
        this.r.itemId = 0;
        this.b = true;
      }
      this.r.appid = 9;
      this.h.c.mMsgId = System.currentTimeMillis();
      if (paramInt2 != 0)
      {
        this.h.c.setTextColor(paramInt2);
        this.h.b.setTextColor(paramInt2);
      }
      a();
    }
  }
  
  public void a(View paramView)
  {
    StickyNoteShopLayout localStickyNoteShopLayout = this.l;
    if (localStickyNoteShopLayout != paramView) {
      localStickyNoteShopLayout.b();
    }
    localStickyNoteShopLayout = this.m;
    if (localStickyNoteShopLayout != paramView) {
      localStickyNoteShopLayout.b();
    }
  }
  
  public void a(StickyNoteShopLayout paramStickyNoteShopLayout)
  {
    if (!SimpleUIUtil.e())
    {
      a(paramStickyNoteShopLayout);
      a(paramStickyNoteShopLayout.a(this.q));
      this.f.setVisibility(0);
      paramStickyNoteShopLayout.b(0);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    FrameLayout localFrameLayout = this.k;
    if (localFrameLayout != null)
    {
      int i1;
      if ((paramBoolean) && (!SimpleUIUtil.e())) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localFrameLayout.setVisibility(i1);
      if (this.k.getVisibility() == 0)
      {
        VasWebviewUtil.a("strangers_makefriend", "icon_show", "", 0, "", "1");
        VasWebviewUtil.a("strangers_makefriend", "icon_show", "", 0, "", "2");
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    ExtendFriendOldProfileEditFragment localExtendFriendOldProfileEditFragment = this.h;
    if ((localExtendFriendOldProfileEditFragment != null) && (localExtendFriendOldProfileEditFragment.g != null))
    {
      if (!this.h.isResumed()) {
        return;
      }
      if (paramBoolean)
      {
        this.p = true;
        this.q = paramInt;
        if (!SimpleUIUtil.e()) {
          this.f.setVisibility(0);
        }
        a(false);
        a(0);
        if (this.h.g.j)
        {
          this.h.g.j = false;
          c();
          this.a = 3;
          b(3);
          return;
        }
        if (this.h.g.k)
        {
          this.h.g.k = false;
          c();
          this.a = 2;
          b(2);
        }
      }
      else
      {
        this.p = false;
        paramInt = this.a;
        if (paramInt == 1)
        {
          a(true);
          return;
        }
        if (paramInt == 0)
        {
          this.f.setVisibility(8);
          a(false);
          return;
        }
        if (paramInt == 2)
        {
          b(2);
          return;
        }
        if (paramInt == 3) {
          b(3);
        }
      }
    }
  }
  
  public void b()
  {
    this.e.setTextColor(-3355444);
    this.e.setOnClickListener(null);
    this.e.setClickable(false);
  }
  
  public void b(int paramInt)
  {
    this.a = paramInt;
    if (paramInt != 0)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        if (this.p)
        {
          InputMethodUtil.b(this.h.b);
        }
        else
        {
          a(true);
          a(this.m);
          this.o.setImageResource(2130852457);
          VasWebviewUtil.a("strangers_makefriend", "item_show", "", 0, "", "2");
        }
        d();
        return;
      }
      if (this.p)
      {
        InputMethodUtil.b(this.h.b);
      }
      else
      {
        a(true);
        a(this.l);
        this.n.setImageResource(2130852454);
        VasWebviewUtil.a("strangers_makefriend", "item_show", "", 0, "", "1");
      }
      d();
      return;
    }
    a(false);
    InputMethodUtil.a(this.h.b);
    c();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return;
    }
    if (getQBaseActivity() == null) {
      return;
    }
    this.b = true;
    Object localObject = this.s;
    ((SuixintieCheckItem)localObject).itemId = paramInt1;
    ((SuixintieCheckItem)localObject).fontType = paramInt2;
    ((SuixintieCheckItem)localObject).appid = 5;
    this.h.c.setVisibility(0);
    this.h.c.setText(new QQText(QzoneEmotionUtils.emCodesToQQcodes(this.h.b.getText().toString()), 3, 24));
    this.h.b.setVisibility(8);
    this.h.c.setFont(0, System.currentTimeMillis());
    this.h.c.mMsgId = System.currentTimeMillis();
    localObject = this.t;
    if (localObject == null)
    {
      localObject = this.x;
      this.t = new VasRes((AppRuntime)localObject, paramInt1);
      localObject = new SignatureFontAdapter(this.t, (AppRuntime)localObject, paramInt2);
      ((SignatureFontAdapter)localObject).a(this.h.c, this.h.c.getTextSize(), true);
      this.t.a((VasResAdapter)localObject);
      ((SignatureFontAdapter)localObject).a(-1);
    }
    else
    {
      ((SignatureFontAdapter)((VasRes)localObject).c()).a(this.h.c, this.h.c.getTextSize(), true);
      ((SignatureFontAdapter)this.t.c()).a(paramInt1, paramInt2);
    }
    a();
  }
  
  public void c()
  {
    this.o.setImageResource(2130852456);
    this.n.setImageResource(2130852453);
  }
  
  public void d()
  {
    String str;
    if (this.h.b.getText() == null) {
      str = "";
    } else {
      str = this.h.b.getText().toString();
    }
    this.h.c.setTextMsg(new QQText(QzoneEmotionUtils.emCodesToQQcodes(str), 3, 24));
    this.h.b.setVisibility(8);
    this.h.c.setVisibility(0);
  }
  
  public StickyNoteShopLayout e()
  {
    return this.m;
  }
  
  public StickyNoteShopLayout f()
  {
    return this.l;
  }
  
  public boolean g()
  {
    ExtendFriendOldProfileEditFragment localExtendFriendOldProfileEditFragment = this.h;
    return (localExtendFriendOldProfileEditFragment != null) && (localExtendFriendOldProfileEditFragment.b != null) && (this.h.b.getText() != null) && (!TextUtils.isEmpty(this.h.b.getText().toString()));
  }
  
  public boolean h()
  {
    Object localObject = this.h;
    if (localObject == null) {
      return false;
    }
    if (((ExtendFriendOldProfileEditFragment)localObject).l) {
      return true;
    }
    if (this.h.b == null) {
      return false;
    }
    localObject = this.h.b.getText();
    String str = "";
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = this.h.b.getText().toString();
    }
    if ((this.h.g != null) && (this.h.g.a != null)) {
      str = this.h.g.a;
    }
    return ((String)localObject).equals(str) ^ true;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = this.l;
    if (localObject != null) {
      ((StickyNoteShopLayout)localObject).a(paramInt1, paramInt2, paramIntent);
    }
    localObject = this.m;
    if (localObject != null) {
      ((StickyNoteShopLayout)localObject).a(paramInt1, paramInt2, paramIntent);
    }
    localObject = this.y.getFragments();
    int i1 = 0;
    while (i1 < ((List)localObject).size())
    {
      ((Fragment)((List)localObject).get(i1)).onActivityResult(paramInt1, paramInt2, paramIntent);
      i1 += 1;
    }
    if (paramInt2 == 0) {
      return;
    }
    if (paramInt1 != 1003) {
      return;
    }
    this.c = ((AudioInfo)paramIntent.getSerializableExtra("audio_info"));
    this.h.a(this.c);
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onActivityResult audio_back path: ");
      paramIntent.append(this.c.path);
      QLog.i("ExtendFriendProfileEdit", 2, paramIntent.toString());
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.w != null)
    {
      Object localObject = this.h;
      if ((localObject != null) && (((ExtendFriendOldProfileEditFragment)localObject).c()))
      {
        localObject = DialogUtil.a(this.w, 0, null, HardCodeUtil.a(2131902267), HardCodeUtil.a(2131902287), HardCodeUtil.a(2131902282), new ExpandOldEditFragment.4(this), new ExpandOldEditFragment.5(this));
        this.h.f();
        ((QQCustomDialog)localObject).show();
        return true;
      }
      return super.onBackEvent();
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131436648: 
      c();
      b(3);
      VasWebviewUtil.a("strangers_makefriend", "icon_click", "", 0, "", "2");
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#edit_data_page#font", true, -1L, -1L, null, true, true);
      return;
    case 2131436647: 
      c();
      b(2);
      VasWebviewUtil.a("strangers_makefriend", "icon_click", "", 0, "", "1");
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#edit_data_page#skin", true, -1L, -1L, null, true, true);
      return;
    case 2131436211: 
      paramView = this.h;
      if (paramView == null) {
        return;
      }
      paramView = paramView.b();
      if ((this.v) && (TextUtils.isEmpty(paramView.a)))
      {
        AudioInfo localAudioInfo = this.c;
        if ((localAudioInfo != null) && (!TextUtils.isEmpty(localAudioInfo.path)))
        {
          QQToast.makeText(this.w, 0, "扩列宣言还没有填写哦", 0).show();
          return;
        }
      }
      if ((TextUtils.isEmpty(paramView.a)) && (!TextUtils.isEmpty(this.h.k)))
      {
        paramView = DialogUtil.a(this.w, 0, null, HardCodeUtil.a(2131902278), HardCodeUtil.a(2131902270), HardCodeUtil.a(2131898212), new ExpandOldEditFragment.8(this), new ExpandOldEditFragment.9(this, paramView));
        this.h.f();
        paramView.show();
        return;
      }
      if (this.h.c.getLineCount() > 30)
      {
        QQToast.makeText(getQBaseActivity(), "输入文字不要超过30行", 0).show();
        return;
      }
      if ((!TextUtils.isEmpty(paramView.a)) && (!this.h.a(paramView.a)))
      {
        paramView = DialogUtil.a(this.w, 0, null, HardCodeUtil.a(2131889078), HardCodeUtil.a(2131889077), HardCodeUtil.a(2131889076), new ExpandOldEditFragment.10(this), new ExpandOldEditFragment.11(this, paramView));
        this.h.f();
        paramView.show();
        return;
      }
      a(paramView);
      return;
    }
    if (this.w != null)
    {
      ReportController.b(this.x, "dc00898", "", "", "0X80092E0", "0X80092E0", 0, 0, "", "", "", "");
      paramView = this.h;
      if ((paramView != null) && (paramView.c()))
      {
        paramView = DialogUtil.a(this.w, 0, null, HardCodeUtil.a(2131902291), HardCodeUtil.a(2131902271), HardCodeUtil.a(2131902305), new ExpandOldEditFragment.6(this), new ExpandOldEditFragment.7(this));
        this.h.f();
        paramView.show();
        return;
      }
      this.w.doOnBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.w = getQBaseActivity();
    this.x = ((QQAppInterface)this.w.getAppRuntime());
    this.y = getChildFragmentManager();
    paramBundle = this.w.getWindow();
    if (paramBundle != null)
    {
      paramBundle.setFormat(-3);
      paramBundle.setBackgroundDrawable(new ColorDrawable(-1));
      paramBundle.setSoftInputMode(16);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131627437, null);
    this.x.addObserver(this.j);
    b(paramLayoutInflater);
    i();
    this.C.addFilter(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
    ((ITransFileController)this.x.getRuntimeService(ITransFileController.class)).addHandle(this.C);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.x.removeObserver(this.j);
    ((ITransFileController)this.x.getRuntimeService(ITransFileController.class)).removeHandle(this.C);
    this.j = null;
    VasRes localVasRes = this.t;
    if (localVasRes != null) {
      localVasRes.a();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView.getId() == 2131432625)
    {
      paramView = this.h;
      if ((paramView != null) && (paramView.e()))
      {
        this.d.requestDisallowInterceptTouchEvent(true);
        if (paramMotionEvent.getAction() == 1) {
          this.d.requestDisallowInterceptTouchEvent(false);
        }
        return false;
      }
    }
    this.A.onTouchEvent(paramMotionEvent);
    return false;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (ThemeUtil.isInNightMode(this.x))
    {
      if ((paramView instanceof RelativeLayout))
      {
        paramView = (RelativeLayout)paramView;
        paramBundle = new View(getQBaseActivity());
        paramBundle.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        paramBundle.setBackgroundColor(1056964608);
        paramView.addView(paramBundle);
        return;
      }
      if (!QLog.isDebugVersion()) {
        return;
      }
      throw new RuntimeException("error root type");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandOldEditFragment
 * JD-Core Version:    0.7.0.1
 */