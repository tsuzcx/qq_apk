package com.tencent.mobileqq.vipav;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.MediaPlayerHelper;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.vipav.VipFullScreenVideoView;
import com.tencent.mobileqq.vas.vipav.VipFunCallObserver;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewTempUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x4Req;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class VipFunCallPreviewActivity
  extends BaseActivity
  implements DialogInterface.OnClickListener, View.OnClickListener
{
  long A;
  Bundle B;
  boolean C;
  protected VipFunCallObserver D = new VipFunCallPreviewActivity.4(this);
  QQProgressDialog E;
  public int a = 0;
  public String b;
  int c;
  VipFullScreenVideoView d;
  Button e;
  ImageView f;
  TextView g;
  TextView h;
  TextView i;
  TextView j;
  View k;
  final String l = "FT";
  View m;
  View n;
  View o;
  View p;
  View q;
  View r;
  ArrayList<String> s = new ArrayList();
  String t;
  IFaceDecoder u;
  int v;
  MediaPlayerHelper w = MediaPlayerHelper.a();
  public int x = 0;
  boolean y;
  Handler z = new VipFunCallPreviewActivity.1(this, Looper.getMainLooper());
  
  private int a(ArrayList<String> paramArrayList, RelativeLayout paramRelativeLayout, int paramInt)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject = (String)paramArrayList.next();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.s.add(localObject);
        if (paramInt < 5)
        {
          ImageView localImageView = new ImageView(this);
          localImageView.setTag("FT");
          localImageView.setImageBitmap(a((String)localObject, 1));
          paramRelativeLayout.addView(localImageView);
          localObject = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
          int i1 = AIOUtils.b(40.0F, getResources());
          ((RelativeLayout.LayoutParams)localObject).height = i1;
          ((RelativeLayout.LayoutParams)localObject).width = i1;
          ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131440356);
          ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131440356);
          ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(paramInt * 30, getResources());
          paramInt += 1;
        }
      }
    }
    return paramInt;
  }
  
  private Bundle a(Intent paramIntent)
  {
    if ((paramIntent.hasExtra("callId")) && (paramIntent.hasExtra("key_to_uin")))
    {
      this.b = paramIntent.getStringExtra("key_to_uin");
      this.a = paramIntent.getIntExtra("callId", 0);
    }
    if (paramIntent.hasExtra("ringId")) {
      this.c = paramIntent.getIntExtra("ringId", 0);
    }
    return paramIntent.getBundleExtra("bundle");
  }
  
  private String a(SharedPreferences paramSharedPreferences, String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = paramString1.split(",");
      int i1 = 0;
      while (i1 < paramString1.length)
      {
        if (paramString2.equals(paramString1[i1]))
        {
          paramString1 = new StringBuilder();
          paramString1.append("group_");
          paramString1.append(paramString2);
          return paramSharedPreferences.getString(paramString1.toString(), null);
        }
        i1 += 1;
      }
    }
    return paramString3;
  }
  
  private String a(Bundle paramBundle, String paramString)
  {
    String str = paramString;
    if (paramString == null)
    {
      str = paramString;
      if (paramBundle != null)
      {
        VipFunCallManager.a(this.app, this.a, paramBundle, null, true);
        str = VipFunCallUtil.a(this.app, this.a, this.x, null);
      }
    }
    return str;
  }
  
  private void a(int paramInt, String paramString)
  {
    if ((paramInt == 1) && (!TextUtils.isEmpty(paramString)))
    {
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("isShowAd", false);
      super.startActivity(localIntent);
    }
  }
  
  private void a(DialogInterface paramDialogInterface, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 1)
    {
      int i1 = 12;
      if ((12 != paramInt2) && (11 != paramInt2)) {
        paramInt1 = 0;
      } else {
        paramInt1 = 1;
      }
      if (paramInt1 == 0) {
        i1 = 3;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramInt1 != 0) {
        str = "mvip.g.a.ld_n_";
      } else {
        str = "mvip.g.a.ld_xq_";
      }
      localStringBuilder.append(str);
      localStringBuilder.append(paramInt3);
      String str = localStringBuilder.toString();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onClick:aid=");
        localStringBuilder.append(str);
        QLog.d("VipOpenVipDialog", 2, localStringBuilder.toString());
      }
      if ((1 != paramInt2) && (11 != paramInt2)) {
        VipUtils.a(this, true, i1, paramInt1 ^ 0x1, str);
      } else {
        VipUtils.a(this, false, i1, paramInt1 ^ 0x1, str);
      }
      if (paramDialogInterface != null) {
        paramDialogInterface.dismiss();
      }
    }
  }
  
  private void a(Bundle paramBundle)
  {
    VipFunCallPreviewActivity.MessageInfo localMessageInfo = new VipFunCallPreviewActivity.MessageInfo(null);
    int i2 = paramBundle.getInt("result");
    int i1 = paramBundle.getInt("callId", this.a);
    localMessageInfo.b = paramBundle.getString("message");
    localMessageInfo.c = paramBundle.getString("svr_url");
    localMessageInfo.d = paramBundle.getString("svr_actStr");
    localMessageInfo.a = i2;
    localMessageInfo.e = localMessageInfo.d;
    localMessageInfo.f = null;
    if (i2 == 9002)
    {
      localMessageInfo.a = 11;
      a(localMessageInfo, TextUtils.isEmpty(localMessageInfo.b), 2131913676);
      b(localMessageInfo, 2131913656);
    }
    else if (i2 == 9003)
    {
      localMessageInfo.a = 12;
      a(localMessageInfo, TextUtils.isEmpty(localMessageInfo.b), 2131913659);
      b(localMessageInfo, 2131913670);
    }
    else if ((i2 != 1005011) && (i2 != 5002))
    {
      if ((i2 != 1005012) && (i2 != 4002))
      {
        if (i2 == 461001)
        {
          localMessageInfo.a = 6;
          localMessageInfo.b = HardCodeUtil.a(2131913679);
          b(localMessageInfo, 2131913674);
          localMessageInfo.f = HardCodeUtil.a(2131899883);
          localMessageInfo.c = IndividuationUrlHelper.a("funCallMine");
        }
        else
        {
          localMessageInfo.a = 4;
        }
      }
      else
      {
        localMessageInfo.a = 1;
        a(localMessageInfo, TextUtils.isEmpty(localMessageInfo.b), 2131913673);
        b(localMessageInfo, 2131913665);
      }
    }
    else
    {
      localMessageInfo.a = 2;
      a(localMessageInfo, TextUtils.isEmpty(localMessageInfo.b), 2131913664);
      b(localMessageInfo, 2131913668);
    }
    a(localMessageInfo, i2);
    i2 = localMessageInfo.a;
    String str1 = localMessageInfo.b;
    String str2 = localMessageInfo.f;
    if ((!TextUtils.isEmpty(localMessageInfo.c)) && (TextUtils.isEmpty(localMessageInfo.e))) {
      paramBundle = HardCodeUtil.a(2131913675);
    } else {
      paramBundle = localMessageInfo.e;
    }
    a(i2, i1, null, str1, str2, paramBundle, localMessageInfo.c);
  }
  
  private void a(View paramView)
  {
    if (paramView == this.q)
    {
      Object localObject = VipFunCallUtil.a(this.app, 1, null).getString("group", null);
      paramView = String.valueOf(this.a);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramView)))
      {
        localObject = ((String)localObject).split(",");
        if (localObject.length >= 5)
        {
          int i3 = -1;
          int i1 = 0;
          int i2;
          for (;;)
          {
            i2 = i3;
            if (i1 >= localObject.length) {
              break;
            }
            if (paramView.equals(localObject[i1]))
            {
              i2 = i1;
              break;
            }
            i1 += 1;
          }
          if (i2 < 0)
          {
            a(6, this.a, null, HardCodeUtil.a(2131913667), null, null, null);
            VasWebviewTempUtil.reportVASTo00145(this.app, String.valueOf(this.a), "preview", "ClickGroupList", "1", new String[0]);
            return;
          }
        }
      }
    }
    VasWebviewTempUtil.reportVASTo00145(this.app, String.valueOf(this.a), "preview", "ClickGroupList", "0", new String[0]);
    paramView = new Intent(this, ISelectMemberActivityConstants.class);
    paramView.putExtra("param_type", 8998);
    paramView.putExtra("param_entrance", 22);
    paramView.putExtra("param_only_friends", true);
    paramView.putExtra("param_donot_need_contacts", true);
    paramView.putExtra("param_uins_selected_friends", this.s);
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(this, paramView, 20165);
  }
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    int i1 = paramRelativeLayout.getChildCount() - 1;
    while (i1 >= 0)
    {
      View localView = paramRelativeLayout.getChildAt(i1);
      if ((localView != null) && ((localView instanceof ImageView)) && ("FT".equals(localView.getTag()))) {
        paramRelativeLayout.removeView(localView);
      }
      i1 -= 1;
    }
  }
  
  private void a(VipFunCallPreviewActivity.MessageInfo paramMessageInfo, int paramInt)
  {
    if (TextUtils.isEmpty(paramMessageInfo.b)) {
      if ((paramInt != 22001) && (paramInt != 6002))
      {
        if (paramInt == 3002)
        {
          paramMessageInfo.b = HardCodeUtil.a(2131913655);
          return;
        }
        if (paramInt == 8002) {
          paramMessageInfo.b = HardCodeUtil.a(2131913680);
        }
      }
      else
      {
        paramMessageInfo.b = HardCodeUtil.a(2131913671);
      }
    }
  }
  
  private void a(VipFunCallPreviewActivity.MessageInfo paramMessageInfo, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      paramMessageInfo.b = HardCodeUtil.a(paramInt);
    }
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split(",");
      if ((paramString.length >= 3) && (paramString[2].length() > 2))
      {
        paramString = paramString[2].split("-");
        ArrayList localArrayList = new ArrayList();
        int i1 = 0;
        while (i1 < paramString.length)
        {
          if ((paramString[i1] != null) && (paramString[i1].length() > 4)) {
            localArrayList.add(paramString[i1]);
          }
          i1 += 1;
        }
        Collections.sort(localArrayList);
        this.t = localArrayList.toString();
        a(localArrayList, true);
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      onClick(this.o);
    }
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (1 != paramInt)
    {
      bool1 = bool2;
      if (2 != paramInt)
      {
        bool1 = bool2;
        if (12 != paramInt)
        {
          if (11 == paramInt) {
            return true;
          }
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    int i1 = this.x;
    if (i1 == 6) {
      return b(paramBoolean1, paramBoolean2, paramString);
    }
    boolean bool = paramBoolean2;
    if (i1 == 7) {
      bool = c(paramBoolean1, paramBoolean2, paramString);
    }
    return bool;
  }
  
  private void b()
  {
    View localView;
    if (this.s.size() > 0)
    {
      if (this.y)
      {
        localView = this.r;
        if ((localView instanceof Button)) {
          ((Button)localView).setText(HardCodeUtil.a(2131913666));
        }
        this.r.setEnabled(false);
        return;
      }
      this.r.setEnabled(true);
      return;
    }
    if (this.y)
    {
      this.r.setVisibility(0);
      this.r.setEnabled(true);
      localView = this.r;
      if ((localView instanceof Button)) {
        ((Button)localView).setText(HardCodeUtil.a(2131913661));
      }
      this.r.setEnabled(false);
      this.e.setVisibility(8);
      this.q.setVisibility(8);
      return;
    }
    this.e.setEnabled(true);
  }
  
  private void b(VipFunCallPreviewActivity.MessageInfo paramMessageInfo, int paramInt)
  {
    if (TextUtils.isEmpty(paramMessageInfo.e)) {
      paramMessageInfo.e = HardCodeUtil.a(paramInt);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean b(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (!VipFunCallUtil.a(this, this.d, paramString, this.x, null, this.a, true))
    {
      QLog.e("VipFunCallPreviewActivity", 1, "doOnCreate VipFunCallConstants.play Error.");
      paramBoolean2 = true;
    }
    if (paramBoolean1) {
      a();
    }
    return paramBoolean2;
  }
  
  private void c()
  {
    if (!onBackEvent()) {
      super.finish();
    }
  }
  
  private boolean c(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    paramString = BitmapManager.a(paramString);
    if (paramString != null) {
      paramString = new BitmapDrawable(paramString);
    } else {
      paramString = null;
    }
    if (paramString != null)
    {
      this.d.setBackgroundDrawable(paramString);
    }
    else
    {
      QLog.e("VipFunCallPreviewActivity", 1, "doOnCreate BitmapDrawable == null.");
      paramBoolean2 = true;
    }
    if (paramBoolean1) {
      a();
    }
    return paramBoolean2;
  }
  
  private void d()
  {
    VipFunCallAndRing.TSsoCmd0x4Req localTSsoCmd0x4Req = new VipFunCallAndRing.TSsoCmd0x4Req();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.s.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(Long.valueOf(Long.parseLong((String)localIterator.next())));
    }
    localTSsoCmd0x4Req.rpt_uins.set(localArrayList);
    localTSsoCmd0x4Req.i32_funcall_id.set(this.a);
    localTSsoCmd0x4Req.i32_ring_id.set(this.c);
    a(true, 2131917212);
    ((VipSetFunCallHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FUN_CALL_HANDLER)).a(4, localTSsoCmd0x4Req);
  }
  
  private void e()
  {
    long l1 = System.currentTimeMillis();
    if (l1 - this.A > 500L)
    {
      this.A = l1;
      VipSetFunCallHandler localVipSetFunCallHandler = (VipSetFunCallHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FUN_CALL_HANDLER);
      Bundle localBundle = new Bundle();
      localBundle.putInt("callId", this.a);
      localBundle.putInt("ringId", this.c);
      localBundle.putInt("from", 1);
      a(true, 2131917212);
      localVipSetFunCallHandler.a(3, localBundle);
    }
  }
  
  private void f()
  {
    this.o.setVisibility(0);
    this.p.setVisibility(8);
    if (this.C)
    {
      MediaPlayerHelper localMediaPlayerHelper = this.w;
      if ((localMediaPlayerHelper != null) && (!localMediaPlayerHelper.f())) {
        this.w.b();
      }
    }
    else
    {
      a();
    }
    VipFunCallUtil.a(this.app, 0, null).edit().putBoolean("key_fun_call_soundon", true).commit();
  }
  
  private void g()
  {
    this.o.setVisibility(8);
    this.p.setVisibility(0);
    MediaPlayerHelper localMediaPlayerHelper = this.w;
    if ((localMediaPlayerHelper != null) && (localMediaPlayerHelper.f())) {
      this.w.d();
    }
    VipFunCallUtil.a(this.app, 0, null).edit().putBoolean("key_fun_call_soundon", false).commit();
  }
  
  private void h()
  {
    this.d.setOnTouchListener(new VipFunCallPreviewActivity.2(this));
  }
  
  private void i()
  {
    SharedPreferences localSharedPreferences = VipFunCallUtil.a(this.app, 1, null);
    if (localSharedPreferences != null) {
      a(a(localSharedPreferences, localSharedPreferences.getString("group", null), String.valueOf(this.a), null));
    }
  }
  
  private void j()
  {
    this.r.setVisibility(0);
    View localView = this.r;
    if ((localView instanceof Button)) {
      ((Button)localView).setText(HardCodeUtil.a(2131913663));
    }
    this.r.setEnabled(false);
    this.e.setVisibility(8);
    this.q.setVisibility(8);
  }
  
  Bitmap a(String paramString, int paramInt)
  {
    Bitmap localBitmap = this.u.getBitmapFromCache(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.u.isPausing()) {
      this.u.requestDecodeFace(paramString, paramInt, true);
    }
    return ImageUtil.k();
  }
  
  protected void a()
  {
    if (this.w != null)
    {
      this.C = true;
      Object localObject = new File(ColorRingManager.a(this.c, 3));
      if (((File)localObject).exists())
      {
        this.w.a(getApplicationContext(), Uri.fromFile((File)localObject));
      }
      else
      {
        localObject = this.w;
        Context localContext = getApplicationContext();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("android.resource://");
        localStringBuilder.append(getPackageName());
        localStringBuilder.append("/");
        localStringBuilder.append(2131230815);
        ((MediaPlayerHelper)localObject).a(localContext, Uri.parse(localStringBuilder.toString()));
      }
      this.w.a(true);
      this.w.b();
    }
  }
  
  void a(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VipFunCallPreviewActivity", 2, "showFriends uins == null");
      }
      return;
    }
    this.s.clear();
    Object localObject = (RelativeLayout)super.findViewById(2131449924);
    a((RelativeLayout)localObject);
    int i1 = a(paramArrayList, (RelativeLayout)localObject, 0);
    localObject = (TextView)super.findViewById(2131448857);
    if (i1 > 0)
    {
      ((RelativeLayout.LayoutParams)((TextView)localObject).getLayoutParams()).leftMargin = AIOUtils.b((i1 - 1) * 30 + 40 + 10, getResources());
      if (5 < paramArrayList.size()) {
        ((TextView)localObject).setText(String.format(HardCodeUtil.a(2131913669), new Object[] { Integer.valueOf(paramArrayList.size()) }));
      } else {
        ((TextView)localObject).setText(HardCodeUtil.a(2131913660));
      }
      ((TextView)localObject).setVisibility(0);
      this.n.setVisibility(0);
      this.r.setVisibility(0);
      this.q.setVisibility(8);
      this.e.setVisibility(8);
      if (paramBoolean)
      {
        paramArrayList = this.r;
        if ((paramArrayList instanceof Button)) {
          ((Button)paramArrayList).setText(HardCodeUtil.a(2131913654));
        }
        this.r.setEnabled(false);
        return;
      }
      this.r.setEnabled(true);
      paramArrayList = this.r;
      if ((paramArrayList instanceof Button)) {
        ((Button)paramArrayList).setText(HardCodeUtil.a(2131913657));
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("VipFunCallPreviewActivity", 2, "showFriends set views GONE");
      }
      ((TextView)localObject).setVisibility(8);
      this.n.setVisibility(8);
      this.r.setVisibility(8);
      this.q.setVisibility(0);
      this.e.setVisibility(0);
    }
  }
  
  void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      if (this.E == null)
      {
        this.E = new QQProgressDialog(this, getTitleBarHeight());
        this.E.setCancelable(true);
      }
      this.E.c(paramInt);
      this.E.show();
      return;
    }
    QQProgressDialog localQQProgressDialog = this.E;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.E.dismiss();
    }
  }
  
  boolean a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.B = new Bundle();
    this.B.putInt("funcType", paramInt1);
    this.B.putString("url", paramString5);
    this.B.putInt("fcID", paramInt2);
    paramString5 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString5 = HardCodeUtil.a(2131913677);
    }
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = HardCodeUtil.a(2131913658);
    }
    paramString2 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString2 = HardCodeUtil.a(2131898212);
    }
    paramString3 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString3 = HardCodeUtil.a(2131899883);
    }
    paramString1 = DialogUtil.a(this, 0, paramString5, paramString1, paramString2, paramString3, this, this);
    if ((paramString1 != null) && (!super.isFinishing()))
    {
      paramString1.show();
      return true;
    }
    return false;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 20165)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("doOnActivityResult, requestCode = ");
      paramIntent.append(paramInt1);
      paramIntent.append(" resultCode = ");
      paramIntent.append(paramInt2);
      QLog.e("VipFunCallPreviewActivity", 1, paramIntent.toString());
      return;
    }
    Object localObject2 = this.app;
    paramInt1 = this.a;
    if (paramIntent != null) {
      localObject1 = "0";
    } else {
      localObject1 = "1";
    }
    VasWebviewTempUtil.reportVASTo00145((AppInterface)localObject2, String.valueOf(paramInt1), "preview", "ClickFriendsEdit", (String)localObject1, new String[0]);
    if (paramIntent == null) {
      return;
    }
    localObject2 = paramIntent.getParcelableArrayListExtra("result_set");
    Object localObject1 = null;
    paramIntent = (Intent)localObject1;
    if (localObject2 != null)
    {
      paramIntent = (Intent)localObject1;
      if (((ArrayList)localObject2).size() > 0)
      {
        localObject1 = new ArrayList();
        localObject2 = ((ArrayList)localObject2).iterator();
        for (;;)
        {
          paramIntent = (Intent)localObject1;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          ((ArrayList)localObject1).add(((ResultRecord)((Iterator)localObject2).next()).uin);
        }
      }
    }
    a(paramIntent, false);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131629647);
    this.u = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    paramBundle = getIntent();
    if (paramBundle != null) {
      paramBundle = a(paramBundle);
    } else {
      paramBundle = null;
    }
    if (this.a <= 0)
    {
      QLog.e("VipFunCallPreviewActivity", 1, "doOnCreate funcallid Error.");
      super.finish();
      return true;
    }
    if (paramBundle != null) {
      this.v = paramBundle.getInt("feeType");
    }
    this.d = ((VipFullScreenVideoView)super.findViewById(2131449456));
    boolean bool2 = VipFunCallUtil.a(this.app, 0, null).getBoolean("key_fun_call_soundon", true);
    boolean bool1;
    if (this.d != null)
    {
      this.x = VipFunCallUtil.c();
      paramBundle = a(paramBundle, VipFunCallUtil.a(this.app, this.a, this.x, null));
      if (paramBundle == null)
      {
        QLog.e("VipFunCallPreviewActivity", 1, "doOnCreate resourceFilePath == null Error.");
        a(3, this.a, null, HardCodeUtil.a(2131913678), null, null, null);
        return true;
      }
      bool1 = a(bool2, false, paramBundle);
      h();
    }
    else
    {
      bool1 = false;
    }
    b(bool1);
    this.f = ((ImageView)super.findViewById(2131428978));
    paramBundle = this.f;
    if (paramBundle != null) {
      paramBundle.setBackgroundDrawable(FaceDrawable.getFaceDrawable(this.app, 3, this.b));
    }
    this.g = ((TextView)super.findViewById(2131428981));
    paramBundle = this.g;
    if (paramBundle != null) {
      paramBundle.setText(ContactUtils.c(this.app, this.b));
    }
    this.i = ((TextView)super.findViewById(2131428973));
    this.h = ((TextView)super.findViewById(2131432830));
    this.k = super.findViewById(2131447465);
    this.j = ((TextView)super.findViewById(2131436180));
    this.j.setOnClickListener(this);
    this.m = super.findViewById(2131440356);
    this.n = super.findViewById(2131448856);
    this.o = super.findViewById(2131436581);
    this.p = super.findViewById(2131436580);
    this.q = super.findViewById(2131445710);
    this.r = super.findViewById(2131445708);
    this.n.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.p.setOnClickListener(this);
    a(bool2);
    this.q.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.e = ((Button)super.findViewById(2131445709));
    this.e.setOnClickListener(this);
    this.app.addObserver(this.D, false);
    if (VipFunCallUtil.a(this.app, this.app.getAccount(), 6, true, null) == this.a) {
      j();
    } else {
      i();
    }
    if (TextUtils.isEmpty(this.t)) {
      this.t = this.s.toString();
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.D);
    Object localObject = this.u;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    localObject = this.w;
    if ((localObject != null) && (!((MediaPlayerHelper)localObject).f())) {
      this.w.e();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    Object localObject = this.d;
    if ((localObject != null) && (((VipFullScreenVideoView)localObject).isPlaying()) && (this.x == 6)) {
      this.d.pause();
    }
    localObject = this.w;
    if ((localObject != null) && (((MediaPlayerHelper)localObject).f())) {
      this.w.d();
    }
  }
  
  @TargetApi(9)
  protected void doOnResume()
  {
    super.doOnResume();
    Object localObject = this.d;
    if ((localObject != null) && (!((VipFullScreenVideoView)localObject).isPlaying()) && (this.x == 6)) {
      this.d.resume();
    }
    localObject = this.w;
    if ((localObject != null) && (!((MediaPlayerHelper)localObject).f())) {
      this.w.b();
    }
  }
  
  protected boolean onBackEvent()
  {
    Collections.sort(this.s);
    if ((!this.s.toString().equals(this.t)) && (a(5, this.a, null, HardCodeUtil.a(2131913662), null, null, null))) {
      return true;
    }
    super.onBackEvent();
    return false;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    Object localObject = this.B;
    if (localObject == null) {
      return;
    }
    int i1 = ((Bundle)localObject).getInt("funcType", 4);
    localObject = this.B.getString("url");
    int i2 = this.B.getInt("fcID", this.a);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DialogInterface funcType=");
      localStringBuilder.append(i1);
      localStringBuilder.append(", url:");
      localStringBuilder.append((String)localObject);
      QLog.d("VipFunCallPreviewActivity", 1, localStringBuilder.toString());
    }
    if (a(i1))
    {
      a(paramDialogInterface, paramInt, i1, i2);
      return;
    }
    if (5 == i1)
    {
      if (paramInt == 1) {
        super.finish();
      }
    }
    else if ((6 != i1) && (4 != i1))
    {
      if (3 == i1) {
        super.finish();
      }
    }
    else {
      a(paramInt, (String)localObject);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.j == paramView) {
      c();
    } else if (paramView == this.o) {
      g();
    } else if (paramView == this.p) {
      f();
    } else if ((paramView != this.n) && (paramView != this.q))
    {
      if (paramView == this.e) {
        e();
      } else if (paramView == this.r) {
        d();
      }
    }
    else {
      a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      Object localObject = new Rect();
      super.getWindow().findViewById(16908290).getDrawingRect((Rect)localObject);
      ((Rect)localObject).width();
      ((Rect)localObject).height();
      ProfileCardUtil.c(this, 102);
      int i1 = ProfileCardUtil.a(getResources());
      localObject = this.d;
      if (localObject != null) {
        ((VipFullScreenVideoView)localObject).setVisibility(0);
      }
      localObject = this.k;
      if (localObject != null)
      {
        localObject = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
        if (ImmersiveUtils.isSupporImmersive() == 1) {
          ((FrameLayout.LayoutParams)localObject).topMargin = i1;
        }
        this.k.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localObject = this.f;
      if (localObject != null)
      {
        localObject = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = (ProfileCardUtil.c(this, 25) + i1 + (int)getResources().getDimension(2131299920));
        this.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localObject = this.g;
      if (localObject != null)
      {
        localObject = (RelativeLayout.LayoutParams)((TextView)localObject).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = ProfileCardUtil.c(this, 25);
        this.g.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localObject = this.i;
      if (localObject != null)
      {
        localObject = (RelativeLayout.LayoutParams)((TextView)localObject).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = ProfileCardUtil.c(this, 10);
        this.i.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localObject = this.h;
      if (localObject != null)
      {
        localObject = (RelativeLayout.LayoutParams)((TextView)localObject).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = ProfileCardUtil.c(this, 30);
        this.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vipav.VipFunCallPreviewActivity
 * JD-Core Version:    0.7.0.1
 */