package com.tencent.mobileqq.vipav;

import aciy;
import ajjy;
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
import azvq;
import azwg;
import azwp;
import azyk;
import babh;
import babr;
import bacm;
import badj;
import bafb;
import bajr;
import bamr;
import bavz;
import bawg;
import bawh;
import bawi;
import bawj;
import bawk;
import bbms;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
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
  long jdField_a_of_type_Long;
  Bundle jdField_a_of_type_AndroidOsBundle;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  public Button a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  azwg jdField_a_of_type_Azwg;
  badj jdField_a_of_type_Badj = badj.a();
  protected bawg a;
  bbms jdField_a_of_type_Bbms;
  public VipFullScreenVideoView a;
  final String jdField_a_of_type_JavaLangString = "VipFunCallPreviewActivity";
  public ArrayList<String> a;
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
    this.jdField_a_of_type_AndroidOsHandler = new bawh(this, Looper.getMainLooper());
    this.jdField_a_of_type_Bawg = new bawj(this);
  }
  
  Bitmap a(String paramString, int paramInt)
  {
    Bitmap localBitmap = this.jdField_a_of_type_Azwg.a(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_Azwg.a()) {
      this.jdField_a_of_type_Azwg.a(paramString, paramInt, true);
    }
    return bacm.a();
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Badj != null)
    {
      this.jdField_b_of_type_Boolean = true;
      File localFile = new File(bamr.a(this.jdField_b_of_type_Int, 3));
      if (!localFile.exists()) {
        break label70;
      }
      this.jdField_a_of_type_Badj.a(getApplicationContext(), Uri.fromFile(localFile));
    }
    for (;;)
    {
      this.jdField_a_of_type_Badj.a(true);
      this.jdField_a_of_type_Badj.a();
      return;
      label70:
      this.jdField_a_of_type_Badj.a(getApplicationContext(), Uri.parse("android.resource://" + getPackageName() + "/" + 2131230743));
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
    Object localObject1 = (RelativeLayout)super.findViewById(2131313429);
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
        break label532;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject3);
      if (i >= 5) {
        break label532;
      }
      ImageView localImageView = new ImageView(this);
      localImageView.setTag("FT");
      localImageView.setImageBitmap(a((String)localObject3, 1));
      ((RelativeLayout)localObject1).addView(localImageView);
      localObject3 = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
      int j = aciy.a(40.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject3).height = j;
      ((RelativeLayout.LayoutParams)localObject3).width = j;
      ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131306024);
      ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131306024);
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = aciy.a(i * 30, getResources());
      i += 1;
    }
    label532:
    for (;;)
    {
      break label105;
      localObject1 = (TextView)super.findViewById(2131312582);
      if (i > 0)
      {
        ((RelativeLayout.LayoutParams)((TextView)localObject1).getLayoutParams()).leftMargin = aciy.a((i - 1) * 30 + 40 + 10, getResources());
        if (5 < paramArrayList.size()) {
          ((TextView)localObject1).setText(String.format(ajjy.a(2131650946), new Object[] { Integer.valueOf(paramArrayList.size()) }));
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
            ((Button)this.g).setText(ajjy.a(2131650930));
          }
          this.g.setEnabled(false);
          return;
          ((TextView)localObject1).setText(ajjy.a(2131650936));
        }
        this.g.setEnabled(true);
        if (!(this.g instanceof Button)) {
          break;
        }
        ((Button)this.g).setText(ajjy.a(2131650933));
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
      if (this.jdField_a_of_type_Bbms == null)
      {
        this.jdField_a_of_type_Bbms = new bbms(this, getTitleBarHeight());
        this.jdField_a_of_type_Bbms.setCancelable(true);
      }
      this.jdField_a_of_type_Bbms.c(paramInt);
      this.jdField_a_of_type_Bbms.show();
    }
    while ((this.jdField_a_of_type_Bbms == null) || (!this.jdField_a_of_type_Bbms.isShowing())) {
      return;
    }
    this.jdField_a_of_type_Bbms.dismiss();
  }
  
  public boolean a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    boolean bool2 = false;
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.jdField_a_of_type_AndroidOsBundle.putInt("funcType", paramInt1);
    this.jdField_a_of_type_AndroidOsBundle.putString("url", paramString5);
    this.jdField_a_of_type_AndroidOsBundle.putInt("fcID", paramInt2);
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = ajjy.a(2131650955);
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramString2)) {
        paramString2 = ajjy.a(2131650934);
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramString3)) {
          paramString3 = ajjy.a(2131650929);
        }
        for (;;)
        {
          if (TextUtils.isEmpty(paramString4)) {
            paramString4 = ajjy.a(2131650953);
          }
          for (;;)
          {
            paramString1 = babr.a(this, 0, paramString1, paramString2, paramString3, paramString4, this, this);
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
        paramIntent.add(((ResultRecord)((Iterator)localObject1).next()).jdField_a_of_type_JavaLangString);
      }
    }
    label187:
    a(paramIntent, false);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    int k = 0;
    Object localObject2 = null;
    super.doOnCreate(paramBundle);
    super.setContentView(2131497004);
    this.jdField_a_of_type_Azwg = new azwg(this, this.app);
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
      this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = ((VipFullScreenVideoView)super.findViewById(2131313074));
      boolean bool = bavz.a(this.app, 0, null).getBoolean("key_fun_call_soundon", true);
      String str;
      Object localObject1;
      int j;
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView != null)
      {
        this.jdField_e_of_type_Int = bavz.a();
        str = bavz.a(this.app, this.jdField_a_of_type_Int, this.jdField_e_of_type_Int, null);
        localObject1 = str;
        if (str == null)
        {
          localObject1 = str;
          if (paramBundle != null)
          {
            bavz.a(this.app, this.jdField_a_of_type_Int, paramBundle, null, true);
            localObject1 = bavz.a(this.app, this.jdField_a_of_type_Int, this.jdField_e_of_type_Int, null);
          }
        }
        if (localObject1 == null)
        {
          QLog.e("VipFunCallPreviewActivity", 1, "doOnCreate resourceFilePath == null Error.");
          a(3, this.jdField_a_of_type_Int, null, ajjy.a(2131650956), null, null, null);
          return true;
        }
        if (this.jdField_e_of_type_Int == 6) {
          if (bavz.a(this, this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView, (String)localObject1, this.jdField_e_of_type_Int, null, this.jdField_a_of_type_Int, true))
          {
            j = 0;
            i = j;
            if (bool)
            {
              a();
              i = j;
            }
            label352:
            this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.setOnTouchListener(new bawi(this));
          }
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          i = 1;
          label373:
          ThreadManager.post(new VipFunCallPreviewActivity.3(this, i), 8, null, true);
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131297388));
          if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
            this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(azwp.a(this.app, 3, this.jdField_b_of_type_JavaLangString));
          }
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297391));
          if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
            this.jdField_a_of_type_AndroidWidgetTextView.setText(babh.i(this.app, this.jdField_b_of_type_JavaLangString));
          }
          this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297383));
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131300343));
          this.jdField_a_of_type_AndroidViewView = super.findViewById(2131311537);
          this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131302804));
          this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
          this.jdField_b_of_type_AndroidViewView = super.findViewById(2131306024);
          this.jdField_c_of_type_AndroidViewView = super.findViewById(2131312581);
          this.jdField_d_of_type_AndroidViewView = super.findViewById(2131303059);
          this.jdField_e_of_type_AndroidViewView = super.findViewById(2131303058);
          this.f = super.findViewById(2131310190);
          this.g = super.findViewById(2131310188);
          this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
          if (!bool) {
            onClick(this.jdField_d_of_type_AndroidViewView);
          }
          this.f.setOnClickListener(this);
          this.g.setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131310189));
          this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
          this.app.addObserver(this.jdField_a_of_type_Bawg, false);
          if (bavz.a(this.app, this.app.getAccount(), 6, true, null) != this.jdField_a_of_type_Int) {
            break label886;
          }
          this.g.setVisibility(0);
          if ((this.g instanceof Button)) {
            ((Button)this.g).setText(ajjy.a(2131650939));
          }
          this.g.setEnabled(false);
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          this.f.setVisibility(8);
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
            break label1130;
          }
          this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_JavaUtilArrayList.toString();
          return true;
          QLog.e("VipFunCallPreviewActivity", 1, "doOnCreate VipFunCallManager.play Error.");
          j = 1;
          break;
          if (this.jdField_e_of_type_Int != 7) {
            break label1132;
          }
          paramBundle = azvq.a((String)localObject1);
          if (paramBundle != null)
          {
            paramBundle = new BitmapDrawable(paramBundle);
            label832:
            if (paramBundle == null) {
              break label867;
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
            break label832;
            label867:
            QLog.e("VipFunCallPreviewActivity", 1, "doOnCreate BitmapDrawable == null.");
          }
          i = 0;
          break label373;
          label886:
          localObject1 = bavz.a(this.app, 1, null);
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
        label1130:
        break;
        label1132:
        i = 0;
        break label352;
        i = 0;
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_Bawg);
    if (this.jdField_a_of_type_Azwg != null) {
      this.jdField_a_of_type_Azwg.d();
    }
    if ((this.jdField_a_of_type_Badj != null) && (!this.jdField_a_of_type_Badj.d())) {
      this.jdField_a_of_type_Badj.a();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if ((this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView != null) && (this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.isPlaying()) && (this.jdField_e_of_type_Int == 6)) {
      this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.pause();
    }
    if ((this.jdField_a_of_type_Badj != null) && (this.jdField_a_of_type_Badj.d())) {
      this.jdField_a_of_type_Badj.c();
    }
  }
  
  @TargetApi(9)
  public void doOnResume()
  {
    super.doOnResume();
    if ((this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView != null) && (!this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.isPlaying()) && (this.jdField_e_of_type_Int == 6)) {
      this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.resume();
    }
    if ((this.jdField_a_of_type_Badj != null) && (!this.jdField_a_of_type_Badj.d())) {
      this.jdField_a_of_type_Badj.a();
    }
  }
  
  public boolean onBackEvent()
  {
    Collections.sort(this.jdField_a_of_type_JavaUtilArrayList);
    if ((!this.jdField_a_of_type_JavaUtilArrayList.toString().equals(this.jdField_d_of_type_JavaLangString)) && (a(5, this.jdField_a_of_type_Int, null, ajjy.a(2131650938), null, null, null))) {
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
                bajr.a(this, false, i, bool, str);
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
                bajr.a(this, true, i, bool, str);
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
      if ((this.jdField_a_of_type_Badj != null) && (this.jdField_a_of_type_Badj.d())) {
        this.jdField_a_of_type_Badj.c();
      }
      bavz.a(this.app, 0, null).edit().putBoolean("key_fun_call_soundon", false).commit();
      return;
    }
    if (paramView == this.jdField_e_of_type_AndroidViewView)
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      if (this.jdField_b_of_type_Boolean) {
        if ((this.jdField_a_of_type_Badj != null) && (!this.jdField_a_of_type_Badj.d())) {
          this.jdField_a_of_type_Badj.a();
        }
      }
      for (;;)
      {
        bavz.a(this.app, 0, null).edit().putBoolean("key_fun_call_soundon", true).commit();
        return;
        a();
      }
    }
    Object localObject;
    int i;
    if ((paramView == this.jdField_c_of_type_AndroidViewView) || (paramView == this.f)) {
      if (paramView == this.f)
      {
        localObject = bavz.a(this.app, 1, null).getString("group", null);
        paramView = String.valueOf(this.jdField_a_of_type_Int);
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramView)))
        {
          localObject = ((String)localObject).split(",");
          if (localObject.length >= 5)
          {
            i = 0;
            label285:
            if (i >= localObject.length) {
              break label688;
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
        a(6, this.jdField_a_of_type_Int, null, ajjy.a(2131650944), null, null, null);
        VasWebviewUtil.reportVASTo00145(this.app, String.valueOf(this.jdField_a_of_type_Int), "preview", "ClickGroupList", "1", new String[0]);
        return;
        i += 1;
        break label285;
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
        long l = System.currentTimeMillis();
        if (l - this.jdField_a_of_type_Long <= 500L) {
          break;
        }
        this.jdField_a_of_type_Long = l;
        paramView = (bawk)this.app.a(46);
        localObject = new Bundle();
        ((Bundle)localObject).putInt("callId", this.jdField_a_of_type_Int);
        ((Bundle)localObject).putInt("ringId", this.jdField_b_of_type_Int);
        ((Bundle)localObject).putInt("from", 1);
        a(true, 2131654318);
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
      a(true, 2131654318);
      ((bawk)this.app.a(46)).a(4, paramView);
      return;
      label688:
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
      azyk.c(this, 102);
      int i = azyk.a(getResources());
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
        ((RelativeLayout.LayoutParams)localObject).topMargin = (i + azyk.c(this, 25) + (int)getResources().getDimension(2131167766));
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = azyk.c(this, 25);
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView != null)
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = azyk.c(this, 10);
        this.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = azyk.c(this, 30);
        this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.vipav.VipFunCallPreviewActivity
 * JD-Core Version:    0.7.0.1
 */