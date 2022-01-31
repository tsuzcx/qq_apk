package com.tencent.mobileqq.vipav;

import aksx;
import aksy;
import aksz;
import akta;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDrawable;
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
  Bundle jdField_a_of_type_AndroidOsBundle;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  public Button a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  MediaPlayerHelper jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper = MediaPlayerHelper.a();
  public VipFullScreenVideoView a;
  protected VipFunCallObserver a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  final String jdField_a_of_type_JavaLangString = "VipFunCallPreviewActivity";
  public ArrayList a;
  public boolean a;
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  boolean jdField_b_of_type_Boolean;
  final int jdField_c_of_type_Int = 201605;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  final String jdField_c_of_type_JavaLangString = "FT";
  int jdField_d_of_type_Int;
  View jdField_d_of_type_AndroidViewView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  public String d;
  public int e;
  View e;
  public View f;
  public View g;
  
  public VipFunCallPreviewActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new aksx(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallObserver = new akta(this);
  }
  
  Bitmap a(String paramString, int paramInt)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, paramInt, true);
    }
    return ImageUtil.a();
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
  
  void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VipFunCallPreviewActivity", 2, "showFriends uins == null");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    Object localObject1 = (RelativeLayout)super.findViewById(2131375492);
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
    label105:
    if (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (String)((Iterator)localObject2).next();
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        break label520;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject3);
      if (i >= 5) {
        break label520;
      }
      ImageView localImageView = new ImageView(this);
      localImageView.setTag("FT");
      localImageView.setImageBitmap(a((String)localObject3, 1));
      ((RelativeLayout)localObject1).addView(localImageView);
      localObject3 = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
      int j = AIOUtils.a(40.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject3).height = j;
      ((RelativeLayout.LayoutParams)localObject3).width = j;
      ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131375497);
      ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131375497);
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = AIOUtils.a(i * 30, getResources());
      i += 1;
    }
    label520:
    for (;;)
    {
      break label105;
      localObject1 = (TextView)super.findViewById(2131375502);
      if (i > 0)
      {
        ((RelativeLayout.LayoutParams)((TextView)localObject1).getLayoutParams()).leftMargin = AIOUtils.a((i - 1) * 30 + 40 + 10, getResources());
        if (5 < paramArrayList.size()) {
          ((TextView)localObject1).setText(String.format("等%s位好友使用", new Object[] { Integer.valueOf(paramArrayList.size()) }));
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
            ((Button)this.g).setText("已设置");
          }
          this.g.setEnabled(false);
          return;
          ((TextView)localObject1).setText("正在使用");
        }
        this.g.setEnabled(true);
        if (!(this.g instanceof Button)) {
          break;
        }
        ((Button)this.g).setText("完成");
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
  
  public void a(boolean paramBoolean, int paramInt)
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
  
  public boolean a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    boolean bool2 = false;
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.jdField_a_of_type_AndroidOsBundle.putInt("funcType", paramInt1);
    this.jdField_a_of_type_AndroidOsBundle.putString("url", paramString5);
    this.jdField_a_of_type_AndroidOsBundle.putInt("fcID", paramInt2);
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = "温馨提示";
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramString2)) {
        paramString2 = "设置失败，网速不给力哦，请重试";
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramString3)) {
          paramString3 = "取消";
        }
        for (;;)
        {
          if (TextUtils.isEmpty(paramString4)) {
            paramString4 = "确定";
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
        paramIntent.add(((ResultRecord)((Iterator)localObject1).next()).jdField_a_of_type_JavaLangString);
      }
    }
    label187:
    a(paramIntent, false);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    int k = 0;
    Object localObject2 = null;
    super.doOnCreate(paramBundle);
    super.setContentView(2130971746);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.app);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      if ((paramBundle.hasExtra("callId")) && (paramBundle.hasExtra("key_to_uin")))
      {
        this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("key_to_uin");
        this.jdField_a_of_type_Int = paramBundle.getIntExtra("callId", 0);
      }
      if (paramBundle.hasExtra("ringId")) {
        this.jdField_b_of_type_Int = paramBundle.getIntExtra("ringId", 0);
      }
    }
    for (paramBundle = paramBundle.getBundleExtra("bundle");; paramBundle = null)
    {
      if (this.jdField_a_of_type_Int <= 0)
      {
        QLog.e("VipFunCallPreviewActivity", 1, "doOnCreate funcallid Error.");
        super.finish();
        return true;
      }
      if (paramBundle != null) {
        this.jdField_d_of_type_Int = paramBundle.getInt("feeType");
      }
      this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = ((VipFullScreenVideoView)super.findViewById(2131372516));
      boolean bool = VipFunCallManager.a(this.app, 0, null).getBoolean("key_fun_call_soundon", true);
      String str;
      Object localObject1;
      int j;
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView != null)
      {
        this.jdField_e_of_type_Int = VipFunCallManager.a();
        str = VipFunCallManager.a(this.app, this.jdField_a_of_type_Int, this.jdField_e_of_type_Int, null);
        localObject1 = str;
        if (str == null)
        {
          localObject1 = str;
          if (paramBundle != null)
          {
            VipFunCallManager.a(this.app, this.jdField_a_of_type_Int, paramBundle, null, true);
            localObject1 = VipFunCallManager.a(this.app, this.jdField_a_of_type_Int, this.jdField_e_of_type_Int, null);
          }
        }
        if (localObject1 == null)
        {
          QLog.e("VipFunCallPreviewActivity", 1, "doOnCreate resourceFilePath == null Error.");
          a(3, this.jdField_a_of_type_Int, null, "预览参数异常，请稍后尝试", null, null, null);
          return true;
        }
        if (this.jdField_e_of_type_Int == 6) {
          if (VipFunCallManager.a(this, this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView, (String)localObject1, this.jdField_e_of_type_Int, null, this.jdField_a_of_type_Int, true))
          {
            j = 0;
            i = j;
            if (bool)
            {
              a();
              i = j;
            }
            label349:
            this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.setOnTouchListener(new aksy(this));
          }
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          i = 1;
          label370:
          ThreadManager.post(new aksz(this, i), 8, null, true);
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131366304));
          if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
            this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(FaceDrawable.a(this.app, 3, this.jdField_b_of_type_JavaLangString));
          }
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131366305));
          if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
            this.jdField_a_of_type_AndroidWidgetTextView.setText(ContactUtils.k(this.app, this.jdField_b_of_type_JavaLangString));
          }
          this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131375493));
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131375494));
          this.jdField_a_of_type_AndroidViewView = super.findViewById(2131364661);
          this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363262));
          this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
          this.jdField_b_of_type_AndroidViewView = super.findViewById(2131375497);
          this.jdField_c_of_type_AndroidViewView = super.findViewById(2131375503);
          this.jdField_d_of_type_AndroidViewView = super.findViewById(2131375500);
          this.jdField_e_of_type_AndroidViewView = super.findViewById(2131375501);
          this.f = super.findViewById(2131375498);
          this.g = super.findViewById(2131375495);
          this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
          if (!bool) {
            onClick(this.jdField_d_of_type_AndroidViewView);
          }
          this.f.setOnClickListener(this);
          this.g.setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131375499));
          this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
          this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallObserver, false);
          if (VipFunCallManager.a(this.app, this.app.getAccount(), 6, true, null) != this.jdField_a_of_type_Int) {
            break label880;
          }
          this.g.setVisibility(0);
          if ((this.g instanceof Button)) {
            ((Button)this.g).setText("已设置");
          }
          this.g.setEnabled(false);
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          this.f.setVisibility(8);
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
            break label1124;
          }
          this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_JavaUtilArrayList.toString();
          return true;
          QLog.e("VipFunCallPreviewActivity", 1, "doOnCreate VipFunCallManager.play Error.");
          j = 1;
          break;
          if (this.jdField_e_of_type_Int != 7) {
            break label1126;
          }
          paramBundle = BitmapManager.a((String)localObject1);
          if (paramBundle != null)
          {
            paramBundle = new BitmapDrawable(paramBundle);
            label826:
            if (paramBundle == null) {
              break label861;
            }
            this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.setBackgroundDrawable(paramBundle);
          }
          for (j = 0;; j = 1)
          {
            i = j;
            if (!bool) {
              break;
            }
            a();
            i = j;
            break;
            paramBundle = null;
            break label826;
            label861:
            QLog.e("VipFunCallPreviewActivity", 1, "doOnCreate BitmapDrawable == null.");
          }
          i = 0;
          break label370;
          label880:
          localObject1 = VipFunCallManager.a(this.app, 1, null);
          if (localObject1 != null)
          {
            Object localObject3 = ((SharedPreferences)localObject1).getString("group", null);
            str = String.valueOf(this.jdField_a_of_type_Int);
            paramBundle = localObject2;
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              paramBundle = localObject2;
              if (!TextUtils.isEmpty(str))
              {
                localObject3 = ((String)localObject3).split(",");
                i = 0;
              }
            }
            for (;;)
            {
              paramBundle = localObject2;
              if (i < localObject3.length)
              {
                if (str.equals(localObject3[i])) {
                  paramBundle = ((SharedPreferences)localObject1).getString("group_" + str, null);
                }
              }
              else
              {
                if (TextUtils.isEmpty(paramBundle)) {
                  break;
                }
                paramBundle = paramBundle.split(",");
                if ((paramBundle.length < 3) || (paramBundle[2].length() <= 2)) {
                  break;
                }
                paramBundle = paramBundle[2].split("-");
                localObject1 = new ArrayList();
                i = k;
                while (i < paramBundle.length)
                {
                  if ((paramBundle[i] != null) && (paramBundle[i].length() > 4)) {
                    ((ArrayList)localObject1).add(paramBundle[i]);
                  }
                  i += 1;
                }
              }
              i += 1;
            }
            Collections.sort((List)localObject1);
            this.jdField_d_of_type_JavaLangString = ((ArrayList)localObject1).toString();
            a((ArrayList)localObject1, true);
          }
        }
        label1124:
        break;
        label1126:
        i = 0;
        break label349;
        i = 0;
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.d())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.a();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if ((this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView != null) && (this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.isPlaying()) && (this.jdField_e_of_type_Int == 6)) {
      this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.pause();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.d())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.c();
    }
  }
  
  @TargetApi(9)
  protected void doOnResume()
  {
    super.doOnResume();
    if ((this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView != null) && (!this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.isPlaying()) && (this.jdField_e_of_type_Int == 6)) {
      this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.resume();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.d())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.a();
    }
  }
  
  protected boolean onBackEvent()
  {
    Collections.sort(this.jdField_a_of_type_JavaUtilArrayList);
    if ((!this.jdField_a_of_type_JavaUtilArrayList.toString().equals(this.jdField_d_of_type_JavaLangString)) && (a(5, this.jdField_a_of_type_Int, null, "当前设置的来电分组尚未保存，确定要退出吗？", null, null, null))) {
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
    do
    {
      return;
      if (this.jdField_d_of_type_AndroidWidgetTextView != paramView) {
        break;
      }
    } while (onBackEvent());
    super.finish();
    return;
    if (paramView == this.jdField_d_of_type_AndroidViewView)
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.d())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.c();
      }
      VipFunCallManager.a(this.app, 0, null).edit().putBoolean("key_fun_call_soundon", false).commit();
      return;
    }
    if (paramView == this.jdField_e_of_type_AndroidViewView)
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      if (this.jdField_b_of_type_Boolean) {
        if ((this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.d())) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.a();
        }
      }
      for (;;)
      {
        VipFunCallManager.a(this.app, 0, null).edit().putBoolean("key_fun_call_soundon", true).commit();
        return;
        a();
      }
    }
    Object localObject;
    int i;
    if ((paramView == this.jdField_c_of_type_AndroidViewView) || (paramView == this.f)) {
      if (paramView == this.f)
      {
        localObject = VipFunCallManager.a(this.app, 1, null).getString("group", null);
        paramView = String.valueOf(this.jdField_a_of_type_Int);
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramView)))
        {
          localObject = ((String)localObject).split(",");
          if (localObject.length >= 5)
          {
            i = 0;
            label280:
            if (i >= localObject.length) {
              break label657;
            }
            if (!paramView.equals(localObject[i])) {}
          }
        }
      }
    }
    for (;;)
    {
      if (i < 0)
      {
        a(6, this.jdField_a_of_type_Int, null, "指定来电群组已达上限（5个）请在“我的来电”里删除其他来电群组后再添加新的分组。", "确定", "我的来电", IndividuationUrlHelper.a("callDownloadUrl"));
        VasWebviewUtil.reportVASTo00145(this.app, String.valueOf(this.jdField_a_of_type_Int), "preview", "ClickGroupList", "1", new String[0]);
        return;
        i += 1;
        break label280;
      }
      VasWebviewUtil.reportVASTo00145(this.app, String.valueOf(this.jdField_a_of_type_Int), "preview", "ClickGroupList", "0", new String[0]);
      paramView = new Intent(this, SelectMemberActivity.class);
      paramView.putExtra("param_type", 8998);
      paramView.putExtra("param_entrance", 22);
      paramView.putExtra("param_only_friends", true);
      paramView.putExtra("param_donot_need_contacts", true);
      paramView.putExtra("param_uins_selected_friends", this.jdField_a_of_type_JavaUtilArrayList);
      super.startActivityForResult(paramView, 201605);
      return;
      if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
      {
        paramView = (VipSetFunCallHandler)this.app.a(46);
        localObject = new Bundle();
        ((Bundle)localObject).putInt("callId", this.jdField_a_of_type_Int);
        ((Bundle)localObject).putInt("ringId", this.jdField_b_of_type_Int);
        ((Bundle)localObject).putInt("from", 1);
        a(true, 2131434135);
        paramView.a(3, localObject);
        return;
      }
      if (paramView != this.g) {
        break;
      }
      paramView = new VipFunCallAndRing.TSsoCmd0x4Req();
      localObject = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((ArrayList)localObject).add(Long.valueOf(Long.parseLong((String)localIterator.next())));
      }
      paramView.rpt_uins.set((List)localObject);
      paramView.i32_funcall_id.set(this.jdField_a_of_type_Int);
      paramView.i32_ring_id.set(this.jdField_b_of_type_Int);
      a(true, 2131434135);
      ((VipSetFunCallHandler)this.app.a(46)).a(4, paramView);
      return;
      label657:
      i = -1;
    }
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
        ((RelativeLayout.LayoutParams)localObject).topMargin = (i + ProfileCardUtil.c(this, 25) + (int)getResources().getDimension(2131558448));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.vipav.VipFunCallPreviewActivity
 * JD-Core Version:    0.7.0.1
 */