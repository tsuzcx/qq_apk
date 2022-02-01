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
  public int a;
  long jdField_a_of_type_Long;
  Bundle jdField_a_of_type_AndroidOsBundle;
  Handler jdField_a_of_type_AndroidOsHandler = new VipFunCallPreviewActivity.1(this, Looper.getMainLooper());
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  MediaPlayerHelper jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper = MediaPlayerHelper.a();
  VipFullScreenVideoView jdField_a_of_type_ComTencentMobileqqVasVipavVipFullScreenVideoView;
  protected VipFunCallObserver a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public String a;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  final String jdField_b_of_type_JavaLangString = "FT";
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  public int d;
  View jdField_d_of_type_AndroidViewView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  View e;
  View f;
  View g;
  
  public VipFunCallPreviewActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqVasVipavVipFunCallObserver = new VipFunCallPreviewActivity.4(this);
  }
  
  private int a(ArrayList<String> paramArrayList, RelativeLayout paramRelativeLayout, int paramInt)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject = (String)paramArrayList.next();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        if (paramInt < 5)
        {
          ImageView localImageView = new ImageView(this);
          localImageView.setTag("FT");
          localImageView.setImageBitmap(a((String)localObject, 1));
          paramRelativeLayout.addView(localImageView);
          localObject = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
          int i = AIOUtils.b(40.0F, getResources());
          ((RelativeLayout.LayoutParams)localObject).height = i;
          ((RelativeLayout.LayoutParams)localObject).width = i;
          ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131372806);
          ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131372806);
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
      this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("key_to_uin");
      this.jdField_a_of_type_Int = paramIntent.getIntExtra("callId", 0);
    }
    if (paramIntent.hasExtra("ringId")) {
      this.jdField_b_of_type_Int = paramIntent.getIntExtra("ringId", 0);
    }
    return paramIntent.getBundleExtra("bundle");
  }
  
  private String a(SharedPreferences paramSharedPreferences, String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = paramString1.split(",");
      int i = 0;
      while (i < paramString1.length)
      {
        if (paramString2.equals(paramString1[i]))
        {
          paramString1 = new StringBuilder();
          paramString1.append("group_");
          paramString1.append(paramString2);
          return paramSharedPreferences.getString(paramString1.toString(), null);
        }
        i += 1;
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
        VipFunCallManager.a(this.app, this.jdField_a_of_type_Int, paramBundle, null, true);
        str = VipFunCallUtil.a(this.app, this.jdField_a_of_type_Int, this.jdField_d_of_type_Int, null);
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
      int i = 12;
      if ((12 != paramInt2) && (11 != paramInt2)) {
        paramInt1 = 0;
      } else {
        paramInt1 = 1;
      }
      if (paramInt1 == 0) {
        i = 3;
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
        VipUtils.a(this, true, i, paramInt1 ^ 0x1, str);
      } else {
        VipUtils.a(this, false, i, paramInt1 ^ 0x1, str);
      }
      if (paramDialogInterface != null) {
        paramDialogInterface.dismiss();
      }
    }
  }
  
  private void a(Bundle paramBundle)
  {
    VipFunCallPreviewActivity.MessageInfo localMessageInfo = new VipFunCallPreviewActivity.MessageInfo(null);
    int j = paramBundle.getInt("result");
    int i = paramBundle.getInt("callId", this.jdField_a_of_type_Int);
    localMessageInfo.jdField_a_of_type_JavaLangString = paramBundle.getString("message");
    localMessageInfo.jdField_b_of_type_JavaLangString = paramBundle.getString("svr_url");
    localMessageInfo.jdField_c_of_type_JavaLangString = paramBundle.getString("svr_actStr");
    localMessageInfo.jdField_a_of_type_Int = j;
    localMessageInfo.d = localMessageInfo.jdField_c_of_type_JavaLangString;
    localMessageInfo.e = null;
    if (j == 9002)
    {
      localMessageInfo.jdField_a_of_type_Int = 11;
      a(localMessageInfo, TextUtils.isEmpty(localMessageInfo.jdField_a_of_type_JavaLangString), 2131716231);
      b(localMessageInfo, 2131716209);
    }
    else if (j == 9003)
    {
      localMessageInfo.jdField_a_of_type_Int = 12;
      a(localMessageInfo, TextUtils.isEmpty(localMessageInfo.jdField_a_of_type_JavaLangString), 2131716212);
      b(localMessageInfo, 2131716224);
    }
    else if ((j != 1005011) && (j != 5002))
    {
      if ((j != 1005012) && (j != 4002))
      {
        if (j == 461001)
        {
          localMessageInfo.jdField_a_of_type_Int = 6;
          localMessageInfo.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131716234);
          b(localMessageInfo, 2131716228);
          localMessageInfo.e = HardCodeUtil.a(2131716217);
          localMessageInfo.jdField_b_of_type_JavaLangString = IndividuationUrlHelper.a("funCallMine");
        }
        else
        {
          localMessageInfo.jdField_a_of_type_Int = 4;
        }
      }
      else
      {
        localMessageInfo.jdField_a_of_type_Int = 1;
        a(localMessageInfo, TextUtils.isEmpty(localMessageInfo.jdField_a_of_type_JavaLangString), 2131716227);
        b(localMessageInfo, 2131716219);
      }
    }
    else
    {
      localMessageInfo.jdField_a_of_type_Int = 2;
      a(localMessageInfo, TextUtils.isEmpty(localMessageInfo.jdField_a_of_type_JavaLangString), 2131716218);
      b(localMessageInfo, 2131716222);
    }
    a(localMessageInfo, j);
    j = localMessageInfo.jdField_a_of_type_Int;
    String str1 = localMessageInfo.jdField_a_of_type_JavaLangString;
    String str2 = localMessageInfo.e;
    if ((!TextUtils.isEmpty(localMessageInfo.jdField_b_of_type_JavaLangString)) && (TextUtils.isEmpty(localMessageInfo.d))) {
      paramBundle = HardCodeUtil.a(2131716229);
    } else {
      paramBundle = localMessageInfo.d;
    }
    a(j, i, null, str1, str2, paramBundle, localMessageInfo.jdField_b_of_type_JavaLangString);
  }
  
  private void a(View paramView)
  {
    if (paramView == this.f)
    {
      Object localObject = VipFunCallUtil.a(this.app, 1, null).getString("group", null);
      paramView = String.valueOf(this.jdField_a_of_type_Int);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramView)))
      {
        localObject = ((String)localObject).split(",");
        if (localObject.length >= 5)
        {
          int k = -1;
          int i = 0;
          int j;
          for (;;)
          {
            j = k;
            if (i >= localObject.length) {
              break;
            }
            if (paramView.equals(localObject[i]))
            {
              j = i;
              break;
            }
            i += 1;
          }
          if (j < 0)
          {
            a(6, this.jdField_a_of_type_Int, null, HardCodeUtil.a(2131716221), null, null, null);
            VasWebviewTempUtil.reportVASTo00145(this.app, String.valueOf(this.jdField_a_of_type_Int), "preview", "ClickGroupList", "1", new String[0]);
            return;
          }
        }
      }
    }
    VasWebviewTempUtil.reportVASTo00145(this.app, String.valueOf(this.jdField_a_of_type_Int), "preview", "ClickGroupList", "0", new String[0]);
    paramView = new Intent(this, ISelectMemberActivityConstants.class);
    paramView.putExtra("param_type", 8998);
    paramView.putExtra("param_entrance", 22);
    paramView.putExtra("param_only_friends", true);
    paramView.putExtra("param_donot_need_contacts", true);
    paramView.putExtra("param_uins_selected_friends", this.jdField_a_of_type_JavaUtilArrayList);
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(this, paramView, 20165);
  }
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    int i = paramRelativeLayout.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = paramRelativeLayout.getChildAt(i);
      if ((localView != null) && ((localView instanceof ImageView)) && ("FT".equals(localView.getTag()))) {
        paramRelativeLayout.removeView(localView);
      }
      i -= 1;
    }
  }
  
  private void a(VipFunCallPreviewActivity.MessageInfo paramMessageInfo, int paramInt)
  {
    if (TextUtils.isEmpty(paramMessageInfo.jdField_a_of_type_JavaLangString)) {
      if ((paramInt != 22001) && (paramInt != 6002))
      {
        if (paramInt == 3002)
        {
          paramMessageInfo.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131716208);
          return;
        }
        if (paramInt == 8002) {
          paramMessageInfo.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131716235);
        }
      }
      else
      {
        paramMessageInfo.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131716225);
      }
    }
  }
  
  private void a(VipFunCallPreviewActivity.MessageInfo paramMessageInfo, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      paramMessageInfo.jdField_a_of_type_JavaLangString = HardCodeUtil.a(paramInt);
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
        int i = 0;
        while (i < paramString.length)
        {
          if ((paramString[i] != null) && (paramString[i].length() > 4)) {
            localArrayList.add(paramString[i]);
          }
          i += 1;
        }
        Collections.sort(localArrayList);
        this.jdField_c_of_type_JavaLangString = localArrayList.toString();
        a(localArrayList, true);
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      onClick(this.jdField_d_of_type_AndroidViewView);
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
    int i = this.jdField_d_of_type_Int;
    if (i == 6) {
      return b(paramBoolean1, paramBoolean2, paramString);
    }
    boolean bool = paramBoolean2;
    if (i == 7) {
      bool = c(paramBoolean1, paramBoolean2, paramString);
    }
    return bool;
  }
  
  private void b()
  {
    View localView;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        localView = this.g;
        if ((localView instanceof Button)) {
          ((Button)localView).setText(HardCodeUtil.a(2131716220));
        }
        this.g.setEnabled(false);
        return;
      }
      this.g.setEnabled(true);
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.g.setVisibility(0);
      this.g.setEnabled(true);
      localView = this.g;
      if ((localView instanceof Button)) {
        ((Button)localView).setText(HardCodeUtil.a(2131716214));
      }
      this.g.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.f.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
  }
  
  private void b(VipFunCallPreviewActivity.MessageInfo paramMessageInfo, int paramInt)
  {
    if (TextUtils.isEmpty(paramMessageInfo.d)) {
      paramMessageInfo.d = HardCodeUtil.a(paramInt);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean b(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (!VipFunCallUtil.a(this, this.jdField_a_of_type_ComTencentMobileqqVasVipavVipFullScreenVideoView, paramString, this.jdField_d_of_type_Int, null, this.jdField_a_of_type_Int, true))
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
      this.jdField_a_of_type_ComTencentMobileqqVasVipavVipFullScreenVideoView.setBackgroundDrawable(paramString);
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
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(Long.valueOf(Long.parseLong((String)localIterator.next())));
    }
    localTSsoCmd0x4Req.rpt_uins.set(localArrayList);
    localTSsoCmd0x4Req.i32_funcall_id.set(this.jdField_a_of_type_Int);
    localTSsoCmd0x4Req.i32_ring_id.set(this.jdField_b_of_type_Int);
    a(true, 2131719616);
    ((VipSetFunCallHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FUN_CALL_HANDLER)).a(4, localTSsoCmd0x4Req);
  }
  
  private void e()
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long > 500L)
    {
      this.jdField_a_of_type_Long = l;
      VipSetFunCallHandler localVipSetFunCallHandler = (VipSetFunCallHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FUN_CALL_HANDLER);
      Bundle localBundle = new Bundle();
      localBundle.putInt("callId", this.jdField_a_of_type_Int);
      localBundle.putInt("ringId", this.jdField_b_of_type_Int);
      localBundle.putInt("from", 1);
      a(true, 2131719616);
      localVipSetFunCallHandler.a(3, localBundle);
    }
  }
  
  private void f()
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    this.e.setVisibility(8);
    if (this.jdField_b_of_type_Boolean)
    {
      MediaPlayerHelper localMediaPlayerHelper = this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper;
      if ((localMediaPlayerHelper != null) && (!localMediaPlayerHelper.d())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.a();
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
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.e.setVisibility(0);
    MediaPlayerHelper localMediaPlayerHelper = this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper;
    if ((localMediaPlayerHelper != null) && (localMediaPlayerHelper.d())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.c();
    }
    VipFunCallUtil.a(this.app, 0, null).edit().putBoolean("key_fun_call_soundon", false).commit();
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasVipavVipFullScreenVideoView.setOnTouchListener(new VipFunCallPreviewActivity.2(this));
  }
  
  private void i()
  {
    SharedPreferences localSharedPreferences = VipFunCallUtil.a(this.app, 1, null);
    if (localSharedPreferences != null) {
      a(a(localSharedPreferences, localSharedPreferences.getString("group", null), String.valueOf(this.jdField_a_of_type_Int), null));
    }
  }
  
  private void j()
  {
    this.g.setVisibility(0);
    View localView = this.g;
    if ((localView instanceof Button)) {
      ((Button)localView).setText(HardCodeUtil.a(2131716216));
    }
    this.g.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.f.setVisibility(8);
  }
  
  Bitmap a(String paramString, int paramInt)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, paramInt, true);
    }
    return ImageUtil.f();
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper != null)
    {
      this.jdField_b_of_type_Boolean = true;
      Object localObject = new File(ColorRingManager.a(this.jdField_b_of_type_Int, 3));
      if (((File)localObject).exists())
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.a(getApplicationContext(), Uri.fromFile((File)localObject));
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper;
        Context localContext = getApplicationContext();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("android.resource://");
        localStringBuilder.append(getPackageName());
        localStringBuilder.append("/");
        localStringBuilder.append(2131230747);
        ((MediaPlayerHelper)localObject).a(localContext, Uri.parse(localStringBuilder.toString()));
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.a(true);
      this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.a();
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
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    Object localObject = (RelativeLayout)super.findViewById(2131380934);
    a((RelativeLayout)localObject);
    int i = a(paramArrayList, (RelativeLayout)localObject, 0);
    localObject = (TextView)super.findViewById(2131379964);
    if (i > 0)
    {
      ((RelativeLayout.LayoutParams)((TextView)localObject).getLayoutParams()).leftMargin = AIOUtils.b((i - 1) * 30 + 40 + 10, getResources());
      if (5 < paramArrayList.size()) {
        ((TextView)localObject).setText(String.format(HardCodeUtil.a(2131716223), new Object[] { Integer.valueOf(paramArrayList.size()) }));
      } else {
        ((TextView)localObject).setText(HardCodeUtil.a(2131716213));
      }
      ((TextView)localObject).setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.g.setVisibility(0);
      this.f.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      if (paramBoolean)
      {
        paramArrayList = this.g;
        if ((paramArrayList instanceof Button)) {
          ((Button)paramArrayList).setText(HardCodeUtil.a(2131716207));
        }
        this.g.setEnabled(false);
        return;
      }
      this.g.setEnabled(true);
      paramArrayList = this.g;
      if ((paramArrayList instanceof Button)) {
        ((Button)paramArrayList).setText(HardCodeUtil.a(2131716210));
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("VipFunCallPreviewActivity", 2, "showFriends set views GONE");
      }
      ((TextView)localObject).setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.g.setVisibility(8);
      this.f.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    }
  }
  
  void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  boolean a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.jdField_a_of_type_AndroidOsBundle.putInt("funcType", paramInt1);
    this.jdField_a_of_type_AndroidOsBundle.putString("url", paramString5);
    this.jdField_a_of_type_AndroidOsBundle.putInt("fcID", paramInt2);
    paramString5 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString5 = HardCodeUtil.a(2131716232);
    }
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = HardCodeUtil.a(2131716211);
    }
    paramString2 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString2 = HardCodeUtil.a(2131716206);
    }
    paramString3 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString3 = HardCodeUtil.a(2131716230);
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
    paramInt1 = this.jdField_a_of_type_Int;
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
    super.setContentView(2131563033);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    paramBundle = getIntent();
    if (paramBundle != null) {
      paramBundle = a(paramBundle);
    } else {
      paramBundle = null;
    }
    if (this.jdField_a_of_type_Int <= 0)
    {
      QLog.e("VipFunCallPreviewActivity", 1, "doOnCreate funcallid Error.");
      super.finish();
      return true;
    }
    if (paramBundle != null) {
      this.jdField_c_of_type_Int = paramBundle.getInt("feeType");
    }
    this.jdField_a_of_type_ComTencentMobileqqVasVipavVipFullScreenVideoView = ((VipFullScreenVideoView)super.findViewById(2131380499));
    boolean bool2 = VipFunCallUtil.a(this.app, 0, null).getBoolean("key_fun_call_soundon", true);
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqVasVipavVipFullScreenVideoView != null)
    {
      this.jdField_d_of_type_Int = VipFunCallUtil.a();
      paramBundle = a(paramBundle, VipFunCallUtil.a(this.app, this.jdField_a_of_type_Int, this.jdField_d_of_type_Int, null));
      if (paramBundle == null)
      {
        QLog.e("VipFunCallPreviewActivity", 1, "doOnCreate resourceFilePath == null Error.");
        a(3, this.jdField_a_of_type_Int, null, HardCodeUtil.a(2131716233), null, null, null);
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131363125));
    paramBundle = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramBundle != null) {
      paramBundle.setBackgroundDrawable(FaceDrawable.getFaceDrawable(this.app, 3, this.jdField_a_of_type_JavaLangString));
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363128));
    paramBundle = this.jdField_a_of_type_AndroidWidgetTextView;
    if (paramBundle != null) {
      paramBundle.setText(ContactUtils.c(this.app, this.jdField_a_of_type_JavaLangString));
    }
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363120));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131366511));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131378786);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369202));
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131372806);
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131379963);
    this.jdField_d_of_type_AndroidViewView = super.findViewById(2131369502);
    this.e = super.findViewById(2131369501);
    this.f = super.findViewById(2131377322);
    this.g = super.findViewById(2131377320);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.e.setOnClickListener(this);
    a(bool2);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131377321));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqVasVipavVipFunCallObserver, false);
    if (VipFunCallUtil.a(this.app, this.app.getAccount(), 6, true, null) == this.jdField_a_of_type_Int) {
      j();
    } else {
      i();
    }
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_JavaUtilArrayList.toString();
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqVasVipavVipFunCallObserver);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper;
    if ((localObject != null) && (!((MediaPlayerHelper)localObject).d())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.a();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVasVipavVipFullScreenVideoView;
    if ((localObject != null) && (((VipFullScreenVideoView)localObject).isPlaying()) && (this.jdField_d_of_type_Int == 6)) {
      this.jdField_a_of_type_ComTencentMobileqqVasVipavVipFullScreenVideoView.pause();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper;
    if ((localObject != null) && (((MediaPlayerHelper)localObject).d())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.c();
    }
  }
  
  @TargetApi(9)
  protected void doOnResume()
  {
    super.doOnResume();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVasVipavVipFullScreenVideoView;
    if ((localObject != null) && (!((VipFullScreenVideoView)localObject).isPlaying()) && (this.jdField_d_of_type_Int == 6)) {
      this.jdField_a_of_type_ComTencentMobileqqVasVipavVipFullScreenVideoView.resume();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper;
    if ((localObject != null) && (!((MediaPlayerHelper)localObject).d())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.a();
    }
  }
  
  protected boolean onBackEvent()
  {
    Collections.sort(this.jdField_a_of_type_JavaUtilArrayList);
    if ((!this.jdField_a_of_type_JavaUtilArrayList.toString().equals(this.jdField_c_of_type_JavaLangString)) && (a(5, this.jdField_a_of_type_Int, null, HardCodeUtil.a(2131716215), null, null, null))) {
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
    Object localObject = this.jdField_a_of_type_AndroidOsBundle;
    if (localObject == null) {
      return;
    }
    int i = ((Bundle)localObject).getInt("funcType", 4);
    localObject = this.jdField_a_of_type_AndroidOsBundle.getString("url");
    int j = this.jdField_a_of_type_AndroidOsBundle.getInt("fcID", this.jdField_a_of_type_Int);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DialogInterface funcType=");
      localStringBuilder.append(i);
      localStringBuilder.append(", url:");
      localStringBuilder.append((String)localObject);
      QLog.d("VipFunCallPreviewActivity", 1, localStringBuilder.toString());
    }
    if (a(i))
    {
      a(paramDialogInterface, paramInt, i, j);
      return;
    }
    if (5 == i)
    {
      if (paramInt == 1) {
        super.finish();
      }
    }
    else if ((6 != i) && (4 != i))
    {
      if (3 == i) {
        super.finish();
      }
    }
    else {
      a(paramInt, (String)localObject);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_d_of_type_AndroidWidgetTextView == paramView) {
      c();
    } else if (paramView == this.jdField_d_of_type_AndroidViewView) {
      g();
    } else if (paramView == this.e) {
      f();
    } else if ((paramView != this.jdField_c_of_type_AndroidViewView) && (paramView != this.f))
    {
      if (paramView == this.jdField_a_of_type_AndroidWidgetButton) {
        e();
      } else if (paramView == this.g) {
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
      int i = ProfileCardUtil.a(getResources());
      localObject = this.jdField_a_of_type_ComTencentMobileqqVasVipavVipFullScreenVideoView;
      if (localObject != null) {
        ((VipFullScreenVideoView)localObject).setVisibility(0);
      }
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject != null)
      {
        localObject = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
        if (ImmersiveUtils.isSupporImmersive() == 1) {
          ((FrameLayout.LayoutParams)localObject).topMargin = i;
        }
        this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject != null)
      {
        localObject = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = (ProfileCardUtil.c(this, 25) + i + (int)getResources().getDimension(2131299168));
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject != null)
      {
        localObject = (RelativeLayout.LayoutParams)((TextView)localObject).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = ProfileCardUtil.c(this, 25);
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localObject = this.jdField_c_of_type_AndroidWidgetTextView;
      if (localObject != null)
      {
        localObject = (RelativeLayout.LayoutParams)((TextView)localObject).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = ProfileCardUtil.c(this, 10);
        this.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localObject = this.jdField_b_of_type_AndroidWidgetTextView;
      if (localObject != null)
      {
        localObject = (RelativeLayout.LayoutParams)((TextView)localObject).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = ProfileCardUtil.c(this, 30);
        this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vipav.VipFunCallPreviewActivity
 * JD-Core Version:    0.7.0.1
 */