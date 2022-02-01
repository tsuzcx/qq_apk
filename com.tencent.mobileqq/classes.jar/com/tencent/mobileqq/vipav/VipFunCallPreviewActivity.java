package com.tencent.mobileqq.vipav;

import android.annotation.TargetApi;
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
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
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
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x4Req;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

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
  VipFullScreenVideoView jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView;
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
    this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallObserver = new VipFunCallPreviewActivity.4(this);
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
    String str = paramString3;
    int i;
    if (!TextUtils.isEmpty(paramString1))
    {
      str = paramString3;
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = paramString1.split(",");
        i = 0;
      }
    }
    for (;;)
    {
      str = paramString3;
      if (i < paramString1.length)
      {
        if (paramString2.equals(paramString1[i])) {
          str = paramSharedPreferences.getString("group_" + paramString2, null);
        }
      }
      else {
        return str;
      }
      i += 1;
    }
  }
  
  private void a(Bundle paramBundle)
  {
    int j = paramBundle.getInt("result");
    int k = paramBundle.getInt("callId", this.jdField_a_of_type_Int);
    Object localObject1 = paramBundle.getString("message");
    String str = paramBundle.getString("svr_url");
    Object localObject3 = paramBundle.getString("svr_actStr");
    int i;
    Object localObject2;
    if (j == 9002)
    {
      i = 11;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = HardCodeUtil.a(2131716574);
      }
      paramBundle = (Bundle)localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        break label476;
      }
      paramBundle = HardCodeUtil.a(2131716552);
      localObject3 = null;
      i = 11;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
    for (;;)
    {
      localObject3 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        if ((j == 22001) || (j == 6002)) {
          localObject3 = HardCodeUtil.a(2131716568);
        }
      }
      else
      {
        label136:
        if ((TextUtils.isEmpty(str)) || (!TextUtils.isEmpty(paramBundle))) {
          break label467;
        }
        paramBundle = HardCodeUtil.a(2131716572);
        label157:
        a(i, k, null, (String)localObject3, (String)localObject2, paramBundle, str);
        return;
        if (j == 9003)
        {
          i = 12;
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = HardCodeUtil.a(2131716555);
          }
          paramBundle = (Bundle)localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            break label476;
          }
          paramBundle = HardCodeUtil.a(2131716567);
          localObject3 = null;
          i = 12;
          localObject1 = localObject2;
          localObject2 = localObject3;
          continue;
        }
        if ((j == 1005011) || (j == 5002))
        {
          i = 2;
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = HardCodeUtil.a(2131716561);
          }
          paramBundle = (Bundle)localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            break label476;
          }
          paramBundle = HardCodeUtil.a(2131716565);
          localObject3 = null;
          i = 2;
          localObject1 = localObject2;
          localObject2 = localObject3;
          continue;
        }
        if ((j == 1005012) || (j == 4002))
        {
          i = 1;
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = HardCodeUtil.a(2131716570);
          }
          paramBundle = (Bundle)localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            break label476;
          }
          paramBundle = HardCodeUtil.a(2131716562);
          localObject3 = null;
          i = 1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          continue;
        }
        if (j == 461001)
        {
          localObject1 = HardCodeUtil.a(2131716577);
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            break label470;
          }
        }
      }
      label467:
      label470:
      for (paramBundle = HardCodeUtil.a(2131716571);; paramBundle = (Bundle)localObject3)
      {
        localObject2 = HardCodeUtil.a(2131716560);
        str = IndividuationUrlHelper.a("funCallMine");
        i = 6;
        break;
        localObject2 = null;
        i = 4;
        paramBundle = (Bundle)localObject3;
        break;
        if (j == 3002)
        {
          localObject3 = HardCodeUtil.a(2131716551);
          break label136;
        }
        localObject3 = localObject1;
        if (j != 8002) {
          break label136;
        }
        localObject3 = HardCodeUtil.a(2131716578);
        break label136;
        break label157;
      }
      label476:
      localObject2 = null;
      localObject1 = paramBundle;
      paramBundle = (Bundle)localObject3;
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
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (VipFunCallManager.a(this, this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView, paramString, this.jdField_d_of_type_Int, null, this.jdField_a_of_type_Int, true)) {}
    for (;;)
    {
      if (paramBoolean1) {
        a();
      }
      return paramBoolean2;
      QLog.e("VipFunCallPreviewActivity", 1, "doOnCreate VipFunCallManager.play Error.");
      paramBoolean2 = true;
    }
  }
  
  private void b()
  {
    this.g.setVisibility(0);
    if ((this.g instanceof Button)) {
      ((Button)this.g).setText(HardCodeUtil.a(2131716559));
    }
    this.g.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.f.setVisibility(8);
  }
  
  private boolean b(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    paramString = BitmapManager.a(paramString);
    if (paramString != null)
    {
      paramString = new BitmapDrawable(paramString);
      if (paramString == null) {
        break label45;
      }
      this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.setBackgroundDrawable(paramString);
    }
    for (;;)
    {
      if (paramBoolean1) {
        a();
      }
      return paramBoolean2;
      paramString = null;
      break;
      label45:
      QLog.e("VipFunCallPreviewActivity", 1, "doOnCreate BitmapDrawable == null.");
      paramBoolean2 = true;
    }
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
    return ImageUtil.c();
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper != null)
    {
      this.jdField_b_of_type_Boolean = true;
      File localFile = new File(ColorRingManager.a(this.jdField_b_of_type_Int, 3));
      if (!localFile.exists()) {
        break label70;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.a(getApplicationContext(), Uri.fromFile(localFile));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.a(true);
      this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.a();
      return;
      label70:
      this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.a(getApplicationContext(), Uri.parse("android.resource://" + getPackageName() + "/" + 2131230743));
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
    Object localObject1 = (RelativeLayout)super.findViewById(2131381700);
    int i = ((RelativeLayout)localObject1).getChildCount() - 1;
    while (i >= 0)
    {
      localObject2 = ((RelativeLayout)localObject1).getChildAt(i);
      if ((localObject2 != null) && ((localObject2 instanceof ImageView)) && ("FT".equals(((View)localObject2).getTag()))) {
        ((RelativeLayout)localObject1).removeView((View)localObject2);
      }
      i -= 1;
    }
    Object localObject2 = paramArrayList.iterator();
    i = 0;
    label107:
    if (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (String)((Iterator)localObject2).next();
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        break label535;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject3);
      if (i >= 5) {
        break label535;
      }
      ImageView localImageView = new ImageView(this);
      localImageView.setTag("FT");
      localImageView.setImageBitmap(a((String)localObject3, 1));
      ((RelativeLayout)localObject1).addView(localImageView);
      localObject3 = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
      int j = AIOUtils.a(40.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject3).height = j;
      ((RelativeLayout.LayoutParams)localObject3).width = j;
      ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131373228);
      ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131373228);
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = AIOUtils.a(i * 30, getResources());
      i += 1;
    }
    label535:
    for (;;)
    {
      break label107;
      localObject1 = (TextView)super.findViewById(2131380690);
      if (i > 0)
      {
        ((RelativeLayout.LayoutParams)((TextView)localObject1).getLayoutParams()).leftMargin = AIOUtils.a((i - 1) * 30 + 40 + 10, getResources());
        if (5 < paramArrayList.size()) {
          ((TextView)localObject1).setText(String.format(HardCodeUtil.a(2131716566), new Object[] { Integer.valueOf(paramArrayList.size()) }));
        }
        for (;;)
        {
          ((TextView)localObject1).setVisibility(0);
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
          this.g.setVisibility(0);
          this.f.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          if (!paramBoolean) {
            break;
          }
          if ((this.g instanceof Button)) {
            ((Button)this.g).setText(HardCodeUtil.a(2131716550));
          }
          this.g.setEnabled(false);
          return;
          ((TextView)localObject1).setText(HardCodeUtil.a(2131716556));
        }
        this.g.setEnabled(true);
        if (!(this.g instanceof Button)) {
          break;
        }
        ((Button)this.g).setText(HardCodeUtil.a(2131716553));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("VipFunCallPreviewActivity", 2, "showFriends set views GONE");
      }
      ((TextView)localObject1).setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.g.setVisibility(8);
      this.f.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      return;
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
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
  }
  
  boolean a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    boolean bool2 = false;
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.jdField_a_of_type_AndroidOsBundle.putInt("funcType", paramInt1);
    this.jdField_a_of_type_AndroidOsBundle.putString("url", paramString5);
    this.jdField_a_of_type_AndroidOsBundle.putInt("fcID", paramInt2);
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = HardCodeUtil.a(2131716575);
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramString2)) {
        paramString2 = HardCodeUtil.a(2131716554);
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramString3)) {
          paramString3 = HardCodeUtil.a(2131716549);
        }
        for (;;)
        {
          if (TextUtils.isEmpty(paramString4)) {
            paramString4 = HardCodeUtil.a(2131716573);
          }
          for (;;)
          {
            paramString1 = DialogUtil.a(this, 0, paramString1, paramString2, paramString3, paramString4, this, this);
            boolean bool1 = bool2;
            if (paramString1 != null)
            {
              bool1 = bool2;
              if (!super.isFinishing())
              {
                paramString1.show();
                bool1 = true;
              }
            }
            return bool1;
          }
        }
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      QLog.e("VipFunCallPreviewActivity", 1, "doOnActivityResult, requestCode = " + paramInt1 + " resultCode = " + paramInt2);
      return;
    }
    Object localObject2 = this.app;
    paramInt1 = this.jdField_a_of_type_Int;
    if (paramIntent != null) {}
    for (Object localObject1 = "0";; localObject1 = "1")
    {
      VasWebviewUtil.reportVASTo00145((AppInterface)localObject2, String.valueOf(paramInt1), "preview", "ClickFriendsEdit", (String)localObject1, new String[0]);
      if (paramIntent == null) {
        break;
      }
      localObject2 = paramIntent.getParcelableArrayListExtra("result_set");
      localObject1 = null;
      paramIntent = (Intent)localObject1;
      if (localObject2 == null) {
        break label187;
      }
      paramIntent = (Intent)localObject1;
      if (((ArrayList)localObject2).size() <= 0) {
        break label187;
      }
      paramIntent = new ArrayList();
      localObject1 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramIntent.add(((ResultRecord)((Iterator)localObject1).next()).uin);
      }
    }
    label187:
    a(paramIntent, false);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131563209);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    paramBundle = getIntent();
    if (paramBundle != null) {}
    for (paramBundle = a(paramBundle);; paramBundle = null)
    {
      if (this.jdField_a_of_type_Int <= 0)
      {
        QLog.e("VipFunCallPreviewActivity", 1, "doOnCreate funcallid Error.");
        super.finish();
        return true;
      }
      if (paramBundle != null) {
        this.jdField_c_of_type_Int = paramBundle.getInt("feeType");
      }
      this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = ((VipFullScreenVideoView)super.findViewById(2131381245));
      boolean bool2 = VipFunCallManager.a(this.app, 0, null).getBoolean("key_fun_call_soundon", true);
      String str1;
      boolean bool1;
      if (this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView != null)
      {
        this.jdField_d_of_type_Int = VipFunCallManager.a();
        String str2 = VipFunCallManager.a(this.app, this.jdField_a_of_type_Int, this.jdField_d_of_type_Int, null);
        str1 = str2;
        if (str2 == null)
        {
          str1 = str2;
          if (paramBundle != null)
          {
            VipFunCallManager.a(this.app, this.jdField_a_of_type_Int, paramBundle, null, true);
            str1 = VipFunCallManager.a(this.app, this.jdField_a_of_type_Int, this.jdField_d_of_type_Int, null);
          }
        }
        if (str1 == null)
        {
          QLog.e("VipFunCallPreviewActivity", 1, "doOnCreate resourceFilePath == null Error.");
          a(3, this.jdField_a_of_type_Int, null, HardCodeUtil.a(2131716576), null, null, null);
          return true;
        }
        if (this.jdField_d_of_type_Int == 6)
        {
          bool1 = a(bool2, false, str1);
          label264:
          this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.setOnTouchListener(new VipFunCallPreviewActivity.2(this));
        }
      }
      for (;;)
      {
        int i;
        if (bool1)
        {
          i = 1;
          label285:
          ThreadManager.post(new VipFunCallPreviewActivity.3(this, i), 8, null, true);
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131363185));
          if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
            this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(FaceDrawable.getFaceDrawable(this.app, 3, this.jdField_a_of_type_JavaLangString));
          }
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363188));
          if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
            this.jdField_a_of_type_AndroidWidgetTextView.setText(ContactUtils.i(this.app, this.jdField_a_of_type_JavaLangString));
          }
          this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363180));
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131366642));
          this.jdField_a_of_type_AndroidViewView = super.findViewById(2131379434);
          this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369487));
          this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
          this.jdField_b_of_type_AndroidViewView = super.findViewById(2131373228);
          this.jdField_c_of_type_AndroidViewView = super.findViewById(2131380689);
          this.jdField_d_of_type_AndroidViewView = super.findViewById(2131369817);
          this.e = super.findViewById(2131369816);
          this.f = super.findViewById(2131377896);
          this.g = super.findViewById(2131377894);
          this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
          this.e.setOnClickListener(this);
          if (!bool2) {
            onClick(this.jdField_d_of_type_AndroidViewView);
          }
          this.f.setOnClickListener(this);
          this.g.setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131377895));
          this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
          this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallObserver, false);
          if (VipFunCallManager.a(this.app, this.app.getAccount(), 6, true, null) != this.jdField_a_of_type_Int) {
            break label673;
          }
          b();
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
            break label715;
          }
          this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_JavaUtilArrayList.toString();
          return true;
          if (this.jdField_d_of_type_Int != 7) {
            break label717;
          }
          bool1 = b(bool2, false, str1);
          break;
          i = 0;
          break label285;
          label673:
          paramBundle = VipFunCallManager.a(this.app, 1, null);
          if (paramBundle != null) {
            a(a(paramBundle, paramBundle.getString("group", null), String.valueOf(this.jdField_a_of_type_Int), null));
          }
        }
        label715:
        break;
        label717:
        bool1 = false;
        break label264;
        bool1 = false;
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.d())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.a();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if ((this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView != null) && (this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.isPlaying()) && (this.jdField_d_of_type_Int == 6)) {
      this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.pause();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.d())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.c();
    }
  }
  
  @TargetApi(9)
  public void doOnResume()
  {
    super.doOnResume();
    if ((this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView != null) && (!this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.isPlaying()) && (this.jdField_d_of_type_Int == 6)) {
      this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.resume();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.d())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.a();
    }
  }
  
  public boolean onBackEvent()
  {
    Collections.sort(this.jdField_a_of_type_JavaUtilArrayList);
    if ((!this.jdField_a_of_type_JavaUtilArrayList.toString().equals(this.jdField_c_of_type_JavaLangString)) && (a(5, this.jdField_a_of_type_Int, null, HardCodeUtil.a(2131716558), null, null, null))) {
      return true;
    }
    super.onBackEvent();
    return false;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    int i = 12;
    boolean bool = false;
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (this.jdField_a_of_type_AndroidOsBundle == null) {}
    int j;
    label160:
    label178:
    label249:
    do
    {
      String str;
      do
      {
        do
        {
          for (;;)
          {
            return;
            j = this.jdField_a_of_type_AndroidOsBundle.getInt("funcType", 4);
            str = this.jdField_a_of_type_AndroidOsBundle.getString("url");
            int k = this.jdField_a_of_type_AndroidOsBundle.getInt("fcID", this.jdField_a_of_type_Int);
            if (QLog.isColorLevel()) {
              QLog.d("VipFunCallPreviewActivity", 1, "DialogInterface funcType=" + j + ", url:" + str);
            }
            if ((1 != j) && (2 != j) && (12 != j) && (11 != j)) {
              break;
            }
            if (paramInt == 1)
            {
              if ((12 == j) || (11 == j))
              {
                paramInt = 1;
                if (paramInt == 0) {
                  break label275;
                }
                StringBuilder localStringBuilder = new StringBuilder();
                if (paramInt == 0) {
                  break label280;
                }
                str = "mvip.g.a.ld_n_";
                str = str + k;
                if (QLog.isColorLevel()) {
                  QLog.d("VipOpenVipDialog", 2, "onClick:aid=" + str);
                }
                if ((1 != j) && (11 != j)) {
                  break label294;
                }
                if (paramInt != 0) {
                  break label288;
                }
                bool = true;
                VipUtils.a(this, false, i, bool, str);
              }
              for (;;)
              {
                if (paramDialogInterface == null) {
                  break label312;
                }
                paramDialogInterface.dismiss();
                return;
                paramInt = 0;
                break;
                i = 3;
                break label160;
                str = "mvip.g.a.ld_xq_";
                break label178;
                bool = false;
                break label249;
                if (paramInt == 0) {
                  bool = true;
                }
                VipUtils.a(this, true, i, bool, str);
              }
            }
          }
          if (5 != j) {
            break;
          }
        } while (paramInt != 1);
        super.finish();
        return;
        if ((6 != j) && (4 != j)) {
          break;
        }
      } while ((paramInt != 1) || (TextUtils.isEmpty(str)));
      paramDialogInterface = new Intent(this, QQBrowserActivity.class);
      paramDialogInterface.putExtra("url", str);
      paramDialogInterface.putExtra("isShowAd", false);
      super.startActivity(paramDialogInterface);
      return;
    } while (3 != j);
    label275:
    label280:
    label288:
    label294:
    label312:
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_d_of_type_AndroidWidgetTextView == paramView)
      {
        if (!onBackEvent()) {
          super.finish();
        }
      }
      else
      {
        if (paramView != this.jdField_d_of_type_AndroidViewView) {
          break;
        }
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        this.e.setVisibility(0);
        if ((this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.d())) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.c();
        }
        VipFunCallManager.a(this.app, 0, null).edit().putBoolean("key_fun_call_soundon", false).commit();
      }
    }
    if (paramView == this.e)
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      this.e.setVisibility(8);
      if (this.jdField_b_of_type_Boolean) {
        if ((this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.d())) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.a();
        }
      }
      for (;;)
      {
        VipFunCallManager.a(this.app, 0, null).edit().putBoolean("key_fun_call_soundon", true).commit();
        break;
        a();
      }
    }
    Object localObject2;
    Object localObject1;
    int i;
    if ((paramView == this.jdField_c_of_type_AndroidViewView) || (paramView == this.f)) {
      if (paramView == this.f)
      {
        localObject2 = VipFunCallManager.a(this.app, 1, null).getString("group", null);
        localObject1 = String.valueOf(this.jdField_a_of_type_Int);
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
        {
          localObject2 = ((String)localObject2).split(",");
          if (localObject2.length >= 5)
          {
            i = 0;
            label299:
            if (i >= localObject2.length) {
              break label726;
            }
            if (!((String)localObject1).equals(localObject2[i])) {}
          }
        }
      }
    }
    for (;;)
    {
      if (i < 0)
      {
        a(6, this.jdField_a_of_type_Int, null, HardCodeUtil.a(2131716564), null, null, null);
        VasWebviewUtil.reportVASTo00145(this.app, String.valueOf(this.jdField_a_of_type_Int), "preview", "ClickGroupList", "1", new String[0]);
        break;
        i += 1;
        break label299;
      }
      VasWebviewUtil.reportVASTo00145(this.app, String.valueOf(this.jdField_a_of_type_Int), "preview", "ClickGroupList", "0", new String[0]);
      localObject1 = new Intent(this, SelectMemberActivity.class);
      ((Intent)localObject1).putExtra("param_type", 8998);
      ((Intent)localObject1).putExtra("param_entrance", 22);
      ((Intent)localObject1).putExtra("param_only_friends", true);
      ((Intent)localObject1).putExtra("param_donot_need_contacts", true);
      ((Intent)localObject1).putExtra("param_uins_selected_friends", this.jdField_a_of_type_JavaUtilArrayList);
      super.startActivityForResult((Intent)localObject1, 201605);
      break;
      if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
      {
        long l = System.currentTimeMillis();
        if (l - this.jdField_a_of_type_Long <= 500L) {
          break;
        }
        this.jdField_a_of_type_Long = l;
        localObject1 = (VipSetFunCallHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FUN_CALL_HANDLER);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("callId", this.jdField_a_of_type_Int);
        ((Bundle)localObject2).putInt("ringId", this.jdField_b_of_type_Int);
        ((Bundle)localObject2).putInt("from", 1);
        a(true, 2131719884);
        ((VipSetFunCallHandler)localObject1).a(3, localObject2);
        break;
      }
      if (paramView != this.g) {
        break;
      }
      localObject1 = new VipFunCallAndRing.TSsoCmd0x4Req();
      localObject2 = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((ArrayList)localObject2).add(Long.valueOf(Long.parseLong((String)localIterator.next())));
      }
      ((VipFunCallAndRing.TSsoCmd0x4Req)localObject1).rpt_uins.set((List)localObject2);
      ((VipFunCallAndRing.TSsoCmd0x4Req)localObject1).i32_funcall_id.set(this.jdField_a_of_type_Int);
      ((VipFunCallAndRing.TSsoCmd0x4Req)localObject1).i32_ring_id.set(this.jdField_b_of_type_Int);
      a(true, 2131719884);
      ((VipSetFunCallHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FUN_CALL_HANDLER)).a(4, localObject1);
      break;
      label726:
      i = -1;
    }
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
      if (this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView != null) {
        this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        if (ImmersiveUtils.isSupporImmersive() == 1) {
          ((FrameLayout.LayoutParams)localObject).topMargin = i;
        }
        this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = (i + ProfileCardUtil.c(this, 25) + (int)getResources().getDimension(2131299166));
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = ProfileCardUtil.c(this, 25);
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView != null)
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = ProfileCardUtil.c(this, 10);
        this.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = ProfileCardUtil.c(this, 30);
        this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vipav.VipFunCallPreviewActivity
 * JD-Core Version:    0.7.0.1
 */