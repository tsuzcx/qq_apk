package com.tencent.mobileqq.forward;

import abqn;
import abuv;
import abux;
import afur;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anhk;
import anjx;
import anni;
import atcv;
import atul;
import atvo;
import atwl;
import atwt;
import aufw;
import augx;
import augy;
import augz;
import auha;
import auhb;
import auhc;
import auhd;
import auhe;
import auhf;
import auhg;
import auhh;
import auhi;
import auhj;
import auhv;
import bclx;
import bcst;
import bdzx;
import bety;
import bfsj;
import bgjw;
import bglp;
import bgmg;
import bgmo;
import bgpa;
import bgtn;
import bihw;
import bljl;
import bljn;
import bljv;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import nmp;
import nzz;

public class ForwardFileOption
  extends ForwardFileBaseOption
{
  private static ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  private static FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private auhv jdField_a_of_type_Auhv;
  boolean i;
  protected boolean j;
  boolean k;
  public boolean l = false;
  boolean m = false;
  private boolean n;
  
  public ForwardFileOption(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_i_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 10;
  }
  
  private void H()
  {
    ArrayList localArrayList = this.jdField_a_of_type_AndroidOsBundle.getParcelableArrayList("forward_multi_target");
    int i1 = -1;
    if (localArrayList != null) {
      if (localArrayList.size() > 1) {
        i1 = 4;
      }
    }
    for (;;)
    {
      bcst.b(null, "dc00898", "", "", "0X800AEE9", "0X800AEE9", i1, 0, "", "", "", "");
      return;
      switch (this.jdField_a_of_type_AndroidOsBundle.getInt("uintype", 0))
      {
      default: 
        break;
      case -1: 
        i1 = 3;
        break;
      case 1: 
        i1 = 1;
        break;
      case 0: 
        i1 = 2;
      }
    }
  }
  
  private void I()
  {
    Object localObject1 = a();
    int i1;
    if (localObject1 != null)
    {
      i1 = ((ForwardFileInfo)localObject1).b();
      if (((i1 == 10000) || (i1 == 10006)) && (f() == 2)) {
        a(f(), String.valueOf(((ForwardFileInfo)localObject1).a()));
      }
    }
    for (;;)
    {
      return;
      long l1;
      if ((i1 == 10000) || (i1 == 10001) || (i1 == 10002) || (i1 == 10004) || (i1 == 10003))
      {
        l1 = ((ForwardFileInfo)localObject1).b();
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l1);
        if (localObject1 != null) {
          atul.a((FileManagerEntity)localObject1).a(this.jdField_a_of_type_AndroidAppActivity, i1, 12);
        }
      }
      else if (i1 == 10006)
      {
        l1 = ((ForwardFileInfo)localObject1).b();
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l1);
        if (localObject2 != null)
        {
          localObject2 = bfsj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject2);
          l1 = ((ForwardFileInfo)localObject1).a();
          long l2 = this.jdField_a_of_type_AndroidContentIntent.getLongExtra("last_time", 0L);
          localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("sender_uin");
          atwt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, null, null, l1, (bety)localObject2, (String)localObject1, l2, -1, 12, null, false, false);
        }
      }
      else if (i1 == 10013)
      {
        l1 = this.jdField_a_of_type_AndroidContentIntent.getLongExtra("qfavId", -1L);
        if (l1 != -1L)
        {
          bljn.a(this.jdField_a_of_type_AndroidAppActivity, "", l1);
          return;
          if (bgmg.b(this.jdField_i_of_type_JavaLangString)) {
            try
            {
              localObject1 = atvo.a(new FileInfo(this.jdField_i_of_type_JavaLangString));
              if (localObject1 != null)
              {
                atul.a((FileManagerEntity)localObject1).a(this.jdField_a_of_type_AndroidAppActivity, 12);
                return;
              }
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        }
      }
    }
  }
  
  public static int a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity != null) {}
    switch (paramFileManagerEntity.getCloudType())
    {
    case 4: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("dataline", 2, "FileManagerEntity->cloudType 转 ForwardFileInfo->type， 未识别的cloudType[" + paramFileManagerEntity.getCloudType());
      }
    case 3: 
    case 5: 
    case 6: 
    case 7: 
      do
      {
        return 10000;
      } while (atwl.b(paramFileManagerEntity.getFilePath()));
      return 10009;
    case 1: 
      return 10002;
    case 2: 
      return 10003;
    }
    return 10011;
  }
  
  private Drawable a()
  {
    String str = g();
    if (bgmg.b(str))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = bdzx.b();
      localURLDrawableOptions.mFailedDrawable = bdzx.a();
      return URLDrawable.getFileDrawable(str, localURLDrawableOptions);
    }
    return null;
  }
  
  private View.OnClickListener a()
  {
    return new auhi(this);
  }
  
  private View.OnTouchListener a(View paramView)
  {
    return new auhj(this, paramView);
  }
  
  private ForwardFileInfo a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo;
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() == 1)) {
      return (ForwardFileInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    }
    return null;
  }
  
  public static ForwardFileInfo a(FileManagerEntity paramFileManagerEntity)
  {
    return a(paramFileManagerEntity, null);
  }
  
  public static ForwardFileInfo a(FileManagerEntity paramFileManagerEntity, ChatMessage paramChatMessage)
  {
    jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    paramChatMessage = new ForwardFileInfo();
    paramChatMessage.b(a(paramFileManagerEntity));
    paramChatMessage.d(paramFileManagerEntity.getCloudType());
    paramChatMessage.b(paramFileManagerEntity.nSessionId);
    paramChatMessage.c(paramFileManagerEntity.uniseq);
    paramChatMessage.d(paramFileManagerEntity.fileName);
    paramChatMessage.d(paramFileManagerEntity.fileSize);
    paramChatMessage.a(paramFileManagerEntity.getFilePath());
    paramChatMessage.c(paramFileManagerEntity.WeiYunFileId);
    if (!TextUtils.isEmpty(paramFileManagerEntity.strLargeThumPath)) {
      paramChatMessage.f(paramFileManagerEntity.strLargeThumPath);
    }
    for (;;)
    {
      if (paramFileManagerEntity.Uuid != null) {
        paramChatMessage.b(paramFileManagerEntity.Uuid);
      }
      if (paramFileManagerEntity.TroopUin != 0L) {
        paramChatMessage.a(paramFileManagerEntity.TroopUin);
      }
      if (paramFileManagerEntity.strTroopFileID != null) {
        paramChatMessage.e(paramFileManagerEntity.strTroopFileID);
      }
      return paramChatMessage;
      if (!TextUtils.isEmpty(paramFileManagerEntity.strMiddleThumPath)) {
        paramChatMessage.f(paramFileManagerEntity.strMiddleThumPath);
      } else {
        paramChatMessage.f(paramFileManagerEntity.strThumbPath);
      }
    }
  }
  
  private String a(String paramString)
  {
    String str = anhk.ba + "photo/" + String.valueOf(System.currentTimeMillis()) + ".jpg";
    try
    {
      bgmo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), paramString, str, 600, 800);
      return str;
    }
    catch (Exception paramString) {}
    return str;
  }
  
  private void a(View paramView)
  {
    ForwardFileInfo localForwardFileInfo = a();
    String str1;
    String str3;
    View localView;
    InputMethodManager localInputMethodManager;
    EditText localEditText;
    String str2;
    if (localForwardFileInfo != null)
    {
      str1 = localForwardFileInfo.d();
      str3 = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131560882, null);
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(localView, -1, -2, true);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView(localView);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setSoftInputMode(16);
      localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("input_method");
      localInputMethodManager.toggleSoftInput(0, 2);
      localEditText = (EditText)localView.findViewById(2131372759);
      localEditText.setSingleLine(false);
      localEditText.setMaxLines(2);
      int i1 = str3.lastIndexOf('.');
      str2 = "";
      if ((i1 <= -1) || (i1 >= str3.length())) {
        break label366;
      }
      str2 = str3.substring(0, i1);
      localEditText.setText(str2);
      localEditText.setSelection(str2.length());
      str2 = str3.substring(i1, str3.length());
    }
    for (;;)
    {
      localEditText.setOnEditorActionListener(new augy(this));
      localEditText.addTextChangedListener(new augz(this, localEditText));
      localEditText.setOnLongClickListener(new auha(this));
      ((TextView)localView.findViewById(2131364299)).setOnClickListener(new auhb(this, localEditText, str2, str3, str1, localForwardFileInfo));
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.update();
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new BitmapDrawable());
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(paramView.getRootView(), 80, 0, 0);
      localEditText.setFocusable(true);
      localEditText.setFocusableInTouchMode(true);
      localEditText.requestFocus();
      if (r()) {
        localInputMethodManager.toggleSoftInput(0, 2);
      }
      this.jdField_a_of_type_Auhv.a();
      return;
      str1 = this.jdField_j_of_type_JavaLangString;
      break;
      label366:
      localEditText.setText(str3);
      localEditText.setSelection(str3.length());
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardFileOption", 2, "startToGalleryWithPath: path=" + paramString1);
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      AIOImageData localAIOImageData = new AIOImageData();
      localAIOImageData.a = paramString1;
      localAIOImageData.b = paramString1;
      localAIOImageData.c = paramString1;
      localAIOImageData.e = false;
      paramString1 = new Bundle();
      paramString1.putBoolean("extra.EXTRA_NOT_CLEAR_TOP", true);
      paramString1.putBoolean("key_allow_forward_photo_preview_edit", true);
      a(paramString1, new AIOImageProviderService(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramString2, 0, null), localAIOImageData);
      E();
    }
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3) || (paramInt == 0) || (paramInt == 7) || (paramInt == 6) || (paramInt == 10) || (paramInt == 9);
  }
  
  private boolean a(RecentUser paramRecentUser)
  {
    if (paramRecentUser.getType() == 9501) {}
    while (((paramRecentUser.getType() == 1006) && (!a(aufw.h))) || (paramRecentUser.getType() == 6004) || (paramRecentUser.getType() == 7000)) {
      return false;
    }
    return true;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    paramString2 = new File(paramString2);
    paramString1 = new FileInputStream(paramString1).getChannel();
    paramString2 = new FileOutputStream(paramString2).getChannel();
    try
    {
      long l1 = paramString1.size();
      int i1 = 0;
      while (0L < l1)
      {
        long l2 = paramString1.transferTo(i1, l1, paramString2);
        if (l2 > 0L)
        {
          i1 = (int)(i1 + l2);
          l1 -= l2;
        }
      }
      paramString1.close();
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return false;
    }
    paramString2.close();
    return true;
  }
  
  private boolean b(RecentUser paramRecentUser)
  {
    if (((paramRecentUser.getType() == 1) && (!a(paramRecentUser.uin))) || ((paramRecentUser.getType() == 0) && (!nmp.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser.uin, paramRecentUser.getType()))) || (paramRecentUser.getType() == 3000) || (-1L != atvo.a(paramRecentUser.getType()))) {}
    while ((paramRecentUser.uin.equalsIgnoreCase(anhk.z)) && (a(aufw.jdField_f_of_type_JavaLangInteger)) && (q())) {
      return true;
    }
    return false;
  }
  
  private boolean c(RecentUser paramRecentUser)
  {
    if (((paramRecentUser.getType() == 0) && (!nmp.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser.uin, paramRecentUser.getType()))) || (paramRecentUser.getType() == 1) || (paramRecentUser.getType() == 3000) || (paramRecentUser.getType() == 1006) || (paramRecentUser.getType() == 1004) || (paramRecentUser.getType() == 1000)) {}
    while ((paramRecentUser.uin.equalsIgnoreCase(anhk.z)) && (a(aufw.jdField_f_of_type_JavaLangInteger)) && (q())) {
      return true;
    }
    return false;
  }
  
  private boolean d(RecentUser paramRecentUser)
  {
    return paramRecentUser.getType() == 1;
  }
  
  private void e()
  {
    String str = f();
    if (bgmg.b(str))
    {
      File localFile = new File(str);
      this.jdField_j_of_type_JavaLangString = localFile.getName();
      this.jdField_i_of_type_JavaLangString = str;
      this.jdField_b_of_type_Long = localFile.length();
    }
  }
  
  private void e(int paramInt)
  {
    int i1;
    switch (paramInt)
    {
    case 0: 
    default: 
      paramInt = 0;
      i1 = 0;
    }
    for (;;)
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, paramInt, i1, 0).a();
      return;
      i1 = 2131697453;
      paramInt = 2;
      continue;
      i1 = 2131697447;
      paramInt = 1;
      continue;
      i1 = 2131697448;
      paramInt = 0;
      continue;
      i1 = 2131697446;
      paramInt = 0;
      continue;
      i1 = 2131697454;
      paramInt = 0;
      continue;
      i1 = 2131697451;
      paramInt = 0;
      continue;
      i1 = 2131697449;
      paramInt = 0;
      continue;
      i1 = 2131697452;
      paramInt = 0;
    }
  }
  
  private boolean e(RecentUser paramRecentUser)
  {
    if (!bgjw.a(paramRecentUser.uin))
    {
      if (((paramRecentUser.getType() != 0) || (nmp.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser.uin, paramRecentUser.getType()))) && ((paramRecentUser.getType() != 1) || (!a(c)) || (a(paramRecentUser.uin))) && (paramRecentUser.getType() != 3000) && (atvo.a(paramRecentUser.getType()) == -1L)) {}
    }
    else {
      while ((paramRecentUser.uin.equalsIgnoreCase(anhk.z)) && (a(aufw.jdField_f_of_type_JavaLangInteger)) && (q())) {
        return true;
      }
    }
    return false;
  }
  
  private int f()
  {
    Object localObject = a();
    if ((localObject == null) && (TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))) {}
    while ((localObject == null) && (TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))) {
      return -1;
    }
    if (localObject != null) {}
    String str;
    int i1;
    for (localObject = ((ForwardFileInfo)localObject).d();; localObject = this.jdField_i_of_type_JavaLangString)
    {
      str = g();
      i1 = atvo.a((String)localObject);
      if ((i1 != 0) || (!bgmg.b(str))) {
        break;
      }
      return 2;
    }
    if ((i1 == 2) && (bgmg.b(str))) {
      return 3;
    }
    return 1;
  }
  
  private String f()
  {
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo == null)
    {
      localObject2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_filepath");
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label77;
      }
      localObject2 = null;
    }
    label77:
    int i1;
    do
    {
      return localObject2;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a();
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.f();
      break;
      i1 = atvo.a((String)localObject1);
      if (i1 == -1) {
        break label95;
      }
      localObject2 = localObject1;
    } while (i1 != 11);
    label95:
    return a((String)localObject1);
  }
  
  private String g()
  {
    Object localObject = a();
    if (localObject != null) {
      localObject = ((ForwardFileInfo)localObject).f();
    }
    String str;
    do
    {
      return localObject;
      str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_thumb");
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    return this.jdField_a_of_type_AndroidOsBundle.getString("forward_thumb");
  }
  
  private boolean r()
  {
    int i1 = this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getHeight();
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    return i1 * 2 / 3 > localRect.bottom;
  }
  
  public View a()
  {
    Object localObject3 = a();
    int i2 = afur.a(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i3 = afur.a(12.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    afur.a(14.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i4 = afur.a(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i1 = afur.a(16.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i5 = afur.a(18.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i6 = afur.a(20.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i7 = afur.a(32.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i8 = afur.a(40.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidAppActivity);
    Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    localRelativeLayout.setOnClickListener(new auhc(this));
    localRelativeLayout.setOnTouchListener(new auhd(this));
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    int i9 = f();
    if (i9 == 2)
    {
      localRelativeLayout.setPadding(0, i4, 0, i4);
      localObject1 = new URLImageView(this.jdField_a_of_type_AndroidAppActivity);
      ((URLImageView)localObject1).setId(2131367038);
      ((URLImageView)localObject1).setAdjustViewBounds(true);
      ((URLImageView)localObject1).setMaxHeight(bgtn.a(140.0F));
      ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject1);
      localObject2 = new View(this.jdField_a_of_type_AndroidAppActivity);
      ((View)localObject2).setId(2131367033);
      ((View)localObject2).setBackgroundColor(Color.argb(0, 0, 0, 0));
      localObject3 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131367038);
      ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131367038);
      ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131367038);
      ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131367038);
      localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = a();
      if (localObject2 != null) {
        ((URLImageView)localObject1).setImageDrawable((Drawable)localObject2);
      }
      return localRelativeLayout;
    }
    if (i9 == 3)
    {
      localRelativeLayout.setPadding(0, i4, 0, i4);
      localObject1 = new URLImageView(this.jdField_a_of_type_AndroidAppActivity);
      ((URLImageView)localObject1).setId(2131367038);
      ((URLImageView)localObject1).setAdjustViewBounds(true);
      ((URLImageView)localObject1).setMaxHeight(bgtn.a(140.0F));
      ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new View(this.jdField_a_of_type_AndroidAppActivity);
      ((View)localObject2).setId(2131367033);
      ((View)localObject2).setBackgroundColor(Color.argb(0, 0, 0, 0));
      localObject3 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131367038);
      ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131367038);
      ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131367038);
      ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131367038);
      localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
      ((ImageView)localObject2).setId(2131367039);
      localObject3 = new RelativeLayout.LayoutParams(i8, i8);
      ((RelativeLayout.LayoutParams)localObject3).addRule(13);
      localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = a();
      if (localObject3 != null) {
        ((URLImageView)localObject1).setImageDrawable((Drawable)localObject3);
      }
      ((ImageView)localObject2).setImageResource(2130840117);
      return localRelativeLayout;
    }
    if (i9 == 1)
    {
      localRelativeLayout.setPadding(0, i6, 0, i6);
      localObject2 = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
      ((ImageView)localObject2).setId(2131367032);
      ((ImageView)localObject2).setImageResource(2130840115);
      localObject1 = new RelativeLayout.LayoutParams(i3, i1);
      ((RelativeLayout.LayoutParams)localObject1).addRule(11);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = i2;
      localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      AsyncImageView localAsyncImageView = new AsyncImageView(this.jdField_a_of_type_AndroidAppActivity);
      localAsyncImageView.setId(2131367034);
      localObject1 = new RelativeLayout.LayoutParams(i7, i7);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131367032);
      localRelativeLayout.addView(localAsyncImageView, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new LinearLayout(this.jdField_a_of_type_AndroidAppActivity);
      ((LinearLayout)localObject1).setId(2131367037);
      ((LinearLayout)localObject1).setOrientation(1);
      ((LinearLayout)localObject1).setBackgroundColor(Color.argb(0, 0, 0, 0));
      Object localObject4 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(0, 2131367034);
      ((RelativeLayout.LayoutParams)localObject4).addRule(9);
      localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject4);
      this.jdField_a_of_type_AndroidWidgetTextView = new EllipsizingTextView(this.jdField_a_of_type_AndroidAppActivity, null);
      this.jdField_a_of_type_AndroidWidgetTextView.setId(2131367035);
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
      this.jdField_a_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setLineSpacing(0.0F, 1.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
      ((LinearLayout)localObject1).addView(this.jdField_a_of_type_AndroidWidgetTextView);
      localObject4 = new LinearLayout(this.jdField_a_of_type_AndroidAppActivity);
      ((LinearLayout)localObject4).setOrientation(0);
      Object localObject5 = new RelativeLayout.LayoutParams(-2, i5);
      ((RelativeLayout.LayoutParams)localObject5).addRule(3, 2131367035);
      ((LinearLayout)localObject1).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new TextView(this.jdField_a_of_type_AndroidAppActivity);
      ((TextView)localObject5).setId(2131367036);
      ((TextView)localObject5).setSingleLine();
      ((TextView)localObject5).setGravity(16);
      ((TextView)localObject5).setTextColor(Color.parseColor("#777777"));
      ((TextView)localObject5).setTextSize(1, 14.0F);
      ((LinearLayout)localObject4).addView((View)localObject5);
      LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidAppActivity);
      localLinearLayout.setId(2131367033);
      localLinearLayout.setOrientation(1);
      localLinearLayout.setBackgroundColor(Color.argb(0, 0, 0, 0));
      localObject1 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject1).addRule(6, 2131367037);
      ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131367037);
      localRelativeLayout.addView(localLinearLayout, (ViewGroup.LayoutParams)localObject1);
      if (localObject3 != null)
      {
        localObject1 = ((ForwardFileInfo)localObject3).d();
        label1192:
        if (localObject3 == null) {
          break label1629;
        }
      }
      label1629:
      for (long l1 = ((ForwardFileInfo)localObject3).d();; l1 = this.jdField_b_of_type_Long)
      {
        atvo.a(localAsyncImageView, (String)localObject1);
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        ((TextView)localObject5).setText(atwl.a(l1, this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().densityDpi) + " ");
        i2 = atvo.a((String)localObject1);
        if ((localObject3 != null) && (((ForwardFileInfo)localObject3).a() != null) && (((ForwardFileInfo)localObject3).a().length() > 1) && (i2 != 1) && (i2 != 0) && (i2 != 2) && (((ForwardFileInfo)localObject3).d() < 104857600L)) {
          this.m = true;
        }
        if ((localObject3 == null) && (this.jdField_j_of_type_JavaLangString.length() > 1) && (this.jdField_i_of_type_JavaLangString.length() > 1) && (i2 != 1) && (i2 != 0) && (i2 != 2) && (this.jdField_b_of_type_Long < 104857600L)) {
          this.m = true;
        }
        if (!this.m) {
          break;
        }
        localObject1 = new ImageButton(this.jdField_a_of_type_AndroidAppActivity);
        ((ImageButton)localObject1).setBackgroundColor(Color.parseColor("#FFFFFF"));
        ((ImageButton)localObject1).setImageResource(2130844341);
        localObject3 = new RelativeLayout.LayoutParams(i1, i1);
        ((LinearLayout)localObject4).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
        ((LinearLayout)localObject4).setGravity(16);
        ((ImageButton)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
        ((ImageButton)localObject1).setPadding(0, 0, 0, 0);
        ((RelativeLayout.LayoutParams)localObject3).setMargins(0, 0, 0, 0);
        ((ImageButton)localObject1).setBackgroundColor(Color.argb(0, 0, 0, 0));
        localRelativeLayout.setOnClickListener(null);
        localRelativeLayout.setOnTouchListener(null);
        ((TextView)localObject5).setOnClickListener(new auhe(this));
        ((TextView)localObject5).setOnTouchListener(new auhf(this, (ImageButton)localObject1));
        ((ImageButton)localObject1).setOnClickListener(new auhg(this));
        ((ImageButton)localObject1).setOnTouchListener(new auhh(this, (ImageButton)localObject1));
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(a());
        localAsyncImageView.setOnClickListener(a());
        ((ImageView)localObject2).setOnClickListener(a());
        this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(a(localLinearLayout));
        localAsyncImageView.setOnTouchListener(a(localLinearLayout));
        ((ImageView)localObject2).setOnTouchListener(a(localLinearLayout));
        return localRelativeLayout;
        localObject1 = this.jdField_j_of_type_JavaLangString;
        break label1192;
      }
    }
    localRelativeLayout.setPadding(0, i6, 0, i6);
    localObject1 = new AnimationTextView(this.jdField_a_of_type_AndroidAppActivity);
    ((AnimationTextView)localObject1).setText(a());
    ((AnimationTextView)localObject1).setMaxLines(3);
    ((AnimationTextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
    ((AnimationTextView)localObject1).setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColorStateList(2131165687));
    ((AnimationTextView)localObject1).setTextSize(14.0F);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = bclx.a(10.0F);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localRelativeLayout.setOnClickListener(null);
    return localRelativeLayout;
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("forward_source_uin_type", 0) == 9501) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (a(localRecentUser))) {
        if ((this.jdField_j_of_type_Boolean) && (b(localRecentUser))) {
          localArrayList.add(localRecentUser);
        } else if ((this.n) && (c(localRecentUser))) {
          localArrayList.add(localRecentUser);
        } else if ((this.jdField_k_of_type_Boolean) && (d(localRecentUser))) {
          localArrayList.add(localRecentUser);
        } else if (e(localRecentUser)) {
          localArrayList.add(localRecentUser);
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    if ((!this.jdField_k_of_type_Boolean) && (n()))
    {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
      this.jdField_a_of_type_JavaUtilSet.add(jdField_i_of_type_JavaLangInteger);
    }
    if ((!this.jdField_k_of_type_Boolean) && (l())) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() == 10006) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() == 10003) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() == 10002) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() != 10009)) || (m())) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null) {
      if (anjx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b())))
      {
        this.jdField_a_of_type_JavaUtilSet.add(jdField_f_of_type_JavaLangInteger);
        this.jdField_a_of_type_JavaUtilSet.add(jdField_k_of_type_JavaLangInteger);
        break label307;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_AndroidContentIntent != null) && (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromFavorites", false))) {
        this.jdField_a_of_type_JavaUtilSet.add(jdField_f_of_type_JavaLangInteger);
      }
      if ((this.jdField_a_of_type_AndroidContentIntent != null) && (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_smartdevice", true)) && (p()) && (a(atvo.a(f())))) {
        this.jdField_a_of_type_JavaUtilSet.add(jdField_j_of_type_JavaLangInteger);
      }
      return;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        label307:
        if (!localIterator.hasNext()) {
          continue;
        }
        ForwardFileInfo localForwardFileInfo = (ForwardFileInfo)localIterator.next();
        if ((localForwardFileInfo == null) || (!anjx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localForwardFileInfo.b())))) {
          break;
        }
        this.jdField_a_of_type_JavaUtilSet.add(jdField_f_of_type_JavaLangInteger);
        this.jdField_a_of_type_JavaUtilSet.add(jdField_k_of_type_JavaLangInteger);
        continue;
      }
      this.jdField_a_of_type_JavaUtilSet.add(jdField_f_of_type_JavaLangInteger);
      this.jdField_a_of_type_JavaUtilSet.add(jdField_k_of_type_JavaLangInteger);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 19001) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      Object localObject = f();
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardFileOption", 2, "refresh forward preview,editPicPath:" + paramIntent + " :currentFile" + (String)localObject);
      }
      if (!((String)localObject).equals(paramIntent))
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidOsBundle.remove("FORWARD_MSG_FOR_PIC");
        this.jdField_a_of_type_AndroidOsBundle.putString("forward_filepath", paramIntent);
        this.jdField_a_of_type_AndroidOsBundle.putString("forward_extra", paramIntent);
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("extra_is_edited_pic", true);
        localObject = a();
        if (localObject != null)
        {
          ((ForwardFileInfo)localObject).a(paramIntent);
          ((ForwardFileInfo)localObject).f(paramIntent);
        }
        paramIntent = a();
        if (paramIntent != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramIntent);
        }
      }
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if ((this.jdField_j_of_type_Boolean) && (!this.jdField_i_of_type_Boolean) && (-1L != atvo.a(paramBundle.getInt("uintype"))))
    {
      bglp.a(this.jdField_a_of_type_AndroidAppActivity, 230, this.jdField_a_of_type_AndroidAppActivity.getString(2131696942), this.jdField_a_of_type_AndroidAppActivity.getString(2131696895), null, this.jdField_a_of_type_AndroidAppActivity.getString(2131718702), new augx(this), null).show();
      return;
    }
    super.a(paramInt, paramBundle);
  }
  
  public void a(Intent paramIntent)
  {
    ArrayList localArrayList2 = null;
    ArrayList localArrayList1 = this.jdField_a_of_type_AndroidOsBundle.getParcelableArrayList("fileinfo_array");
    if (localArrayList1 != null) {}
    for (;;)
    {
      Object localObject2;
      try
      {
        localArrayList1 = (ArrayList)localArrayList1;
        localObject2 = (ArrayList)this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
        if (((ArrayList)localObject2).size() > 1) {
          if (localArrayList1 == null)
          {
            localArrayList2 = new ArrayList();
            int i1 = 0;
            if (i1 < ((ArrayList)localObject2).size())
            {
              Uri localUri = (Uri)((ArrayList)localObject2).get(i1);
              localArrayList2.add(a(this.jdField_a_of_type_AndroidAppActivity, localUri));
              i1 += 1;
              continue;
            }
          }
        }
      }
      catch (ClassCastException localClassCastException)
      {
        localObject1 = null;
        continue;
      }
      for (;;)
      {
        paramIntent.putExtra("dataline_forward_type", 100);
        paramIntent.putExtra("sendMultiple", true);
        if (localObject1 == null) {
          paramIntent.putStringArrayListExtra("dataline_forward_pathlist", localArrayList2);
        }
        do
        {
          return;
        } while (!d());
        localObject2 = a();
        localArrayList2 = new ArrayList();
        localArrayList2.add(((ForwardFileInfo)localObject2).a());
      }
      Object localObject1 = null;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    super.a();
    this.e = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward _key_nojump", false);
    Object localObject;
    int i1;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null)
    {
      int i2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.d();
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        i1 = 1;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() != 10006) {
          break label187;
        }
        bool1 = true;
        label72:
        this.jdField_j_of_type_Boolean = bool1;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() != 10009) {
          break label192;
        }
        bool1 = true;
        label92:
        this.jdField_k_of_type_Boolean = bool1;
        if (i2 != 2) {
          break label197;
        }
        bool1 = true;
        label104:
        this.n = bool1;
        bool1 = bool2;
        if (i1 != 0) {
          if (i2 != 3)
          {
            bool1 = bool2;
            if (!bgmg.a((String)localObject)) {}
          }
          else
          {
            bool1 = true;
          }
        }
        this.jdField_i_of_type_Boolean = bool1;
        label138:
        break label223;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", this.jdField_a_of_type_AndroidAppActivity.getString(2131718387));
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo == null) && (TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))) {
        e();
      }
      return true;
      i1 = 0;
      break;
      label187:
      bool1 = false;
      break label72;
      label192:
      bool1 = false;
      break label92;
      label197:
      bool1 = false;
      break label104;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        this.jdField_k_of_type_Boolean = true;
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        label223:
        if (!((Iterator)localObject).hasNext()) {
          continue;
        }
        ForwardFileInfo localForwardFileInfo = (ForwardFileInfo)((Iterator)localObject).next();
        if ((localForwardFileInfo == null) || (localForwardFileInfo.d() == 6)) {
          break label138;
        }
        this.jdField_k_of_type_Boolean = false;
        continue;
      }
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false)) {
        this.jdField_i_of_type_Boolean = true;
      }
    }
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    ArrayList localArrayList = new ArrayList();
    abqn localabqn = (abqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    int i2 = paramArrayOfDeviceInfo.length;
    int i1 = 0;
    if (i1 < i2)
    {
      DeviceInfo localDeviceInfo = paramArrayOfDeviceInfo[i1];
      ProductInfo localProductInfo;
      if (localDeviceInfo != null)
      {
        int i3 = atvo.a(f());
        localProductInfo = localabqn.a(localDeviceInfo.productId);
        if ((i3 != 2) || (!localabqn.c(localDeviceInfo.din)) || (!localabqn.a(localDeviceInfo.din, 17))) {
          break label105;
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        label105:
        if ((localProductInfo != null) && (localProductInfo.isSupportMainMsgType(8)) && (a(jdField_j_of_type_JavaLangInteger))) {
          localArrayList.add(localDeviceInfo);
        }
      }
    }
    return (DeviceInfo[])localArrayList.toArray(new DeviceInfo[localArrayList.size()]);
  }
  
  public void b(Intent paramIntent)
  {
    if (!d()) {}
    for (;;)
    {
      return;
      paramIntent.putExtra("dataline_forward_type", 100);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo == null)
      {
        String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_filepath");
        String str1 = str2;
        if (str2 == null) {
          str1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
        }
        paramIntent.putExtra("dataline_forward_path", str1);
      }
      while ((this.jdField_a_of_type_AndroidContentIntent != null) && (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromFavorites", false)) && (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isJumpAIO", false)))
      {
        this.jdField_a_of_type_AndroidContentIntent.putExtra("hasJumpAIO", true);
        return;
        paramIntent.putExtra("dataline_forward_path", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a());
      }
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean c()
  {
    boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false);
    if (!d()) {
      return true;
    }
    Intent localIntent;
    if (g())
    {
      localObject = b();
      localIntent = afur.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "fileoption realForwardTo isfromshare=" + bool);
      }
      if (bool)
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", anni.a(2131703540));
        localIntent.addFlags(268435456);
        localIntent.addFlags(67108864);
        localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
        bool = a(localIntent);
        if (this.jdField_f_of_type_Boolean)
        {
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
          if ((QSecFramework.a().a(1003).booleanValue()) && (this.jdField_i_of_type_Boolean))
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject).next();
              bihw.a().a(4, f(), localResultRecord.a(), localResultRecord.a);
              bihw.a().a();
            }
          }
        }
        else if (!bool)
        {
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
        }
      }
      for (;;)
      {
        localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
        this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
        return false;
        if (!this.e)
        {
          localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
        }
      }
    }
    int i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    if (i1 == 1008)
    {
      localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class);
      localIntent.putExtra("chat_subType", nzz.a((String)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "fileoption realForwardTo isfromshare=" + bool);
      }
      if (!bool) {
        break label600;
      }
      this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", anni.a(2131703539));
      localIntent.addFlags(268435456);
      localIntent.addFlags(67108864);
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      bool = a(localIntent);
      if (!this.jdField_f_of_type_Boolean) {
        break label575;
      }
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      if ((QSecFramework.a().a(1003).booleanValue()) && (this.jdField_i_of_type_Boolean))
      {
        bihw.a().a(4, f(), i1, (String)localObject);
        bihw.a().a();
      }
    }
    for (;;)
    {
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return false;
      localIntent = afur.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
      break;
      label575:
      if (!bool)
      {
        ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
        continue;
        label600:
        if (!this.e)
        {
          localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
        }
      }
    }
  }
  
  public int d()
  {
    int i1;
    if (jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
    {
      if (!new bljl(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, jdField_a_of_type_ComTencentMobileqqDataChatMessage, true)) {
        break label129;
      }
      jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
      i1 = 0;
    }
    for (;;)
    {
      if (i1 == 0) {
        bljv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_AddFav", -1, 0, 69, 0, "", "");
      }
      return i1;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null)
      {
        FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b());
        if ((localFileManagerEntity != null) && (new bljl(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, null, true)))
        {
          jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
          i1 = 0;
          continue;
        }
      }
      label129:
      i1 = -1;
    }
  }
  
  protected boolean d()
  {
    if (!this.m) {
      return true;
    }
    int i1 = this.jdField_a_of_type_AndroidOsBundle.keySet().toArray().length;
    if ((this.jdField_a_of_type_AndroidOsBundle == null) || (i1 < 9)) {
      return true;
    }
    if ((i1 >= 10) && (this.jdField_a_of_type_AndroidOsBundle.keySet().toArray()[9].toString().equals("fileinfo_array")) && (this.jdField_a_of_type_AndroidOsBundle.getParcelableArrayList("fileinfo_array").size() > 1)) {
      return true;
    }
    ForwardFileInfo localForwardFileInfo = a();
    String str4 = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
    if (localForwardFileInfo != null)
    {
      str1 = localForwardFileInfo.d();
      if (!str4.equals(str1)) {
        if (localForwardFileInfo == null) {
          break label277;
        }
      }
    }
    label277:
    for (String str1 = localForwardFileInfo.a();; str1 = this.jdField_i_of_type_JavaLangString)
    {
      String str3 = "";
      i1 = str1.lastIndexOf('/');
      String str2 = str3;
      if (i1 > -1)
      {
        str2 = str3;
        if (i1 < str1.length()) {
          str2 = str1.substring(0, i1 + 1) + str4;
        }
      }
      try
      {
        if (!a(str1, str2)) {
          break label285;
        }
        if (localForwardFileInfo != null)
        {
          localForwardFileInfo.d(str4);
          localForwardFileInfo.a(str2);
          localForwardFileInfo.b(10000);
          this.jdField_a_of_type_AndroidOsBundle.putParcelable("fileinfo", localForwardFileInfo);
        }
        this.jdField_a_of_type_AndroidOsBundle.putString("forward_filepath", str2);
        this.jdField_a_of_type_AndroidContentIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
        }
      }
      return true;
      str1 = this.jdField_j_of_type_JavaLangString;
      break;
    }
    label285:
    e(-1);
    return false;
  }
  
  protected String e()
  {
    return this.jdField_a_of_type_AndroidContentContext.getString(2131718011);
  }
  
  public boolean i()
  {
    return true;
  }
  
  public void u()
  {
    this.jdField_a_of_type_Auhv = new auhv(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Auhv.a(2131560874);
    this.jdField_a_of_type_Bgpa = this.jdField_a_of_type_Auhv;
    Object localObject = this.jdField_a_of_type_Auhv;
    if (!f()) {}
    for (boolean bool = true;; bool = false)
    {
      ((auhv)localObject).a(bool);
      this.jdField_a_of_type_Auhv.c(210);
      this.jdField_a_of_type_Auhv.a(a());
      this.jdField_a_of_type_Auhv.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_Auhv.a(c(), d(), this.jdField_a_of_type_AndroidAppActivity.getResources().getString(a()), this.jdField_a_of_type_AndroidAppActivity.getResources().getString(b()), a(), b());
      a(this.jdField_a_of_type_Auhv);
      localObject = this.jdField_a_of_type_Auhv.getWindow();
      ((Window)localObject).getDecorView().setPadding(0, 0, 0, 0);
      WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      ((Window)localObject).setAttributes(localLayoutParams);
      if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
        this.jdField_a_of_type_Auhv.show();
      }
      this.jdField_a_of_type_Bgpa.setOnDismissListener(this);
      return;
    }
  }
  
  public void z()
  {
    String str1 = f();
    String str2;
    int i1;
    Object localObject;
    if (!TextUtils.isEmpty(str1))
    {
      str2 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      i1 = atvo.a(str1);
      if (i1 != 2) {
        break label92;
      }
      localObject = abux.b;
    }
    for (;;)
    {
      abux localabux = (abux)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(str1);
      localabux.a().a((String)localObject, str2, localArrayList, null);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
      label92:
      localObject = (abqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
      if ((localObject != null) && (((abqn)localObject).a(Long.parseLong(this.jdField_a_of_type_AndroidOsBundle.getString("uin")), 17)))
      {
        ((abqn)localObject).a(Long.parseLong(str2), "", "", "", 0, null);
        if (i1 == 0)
        {
          super.a(str1, str2, "pic");
          return;
        }
        super.a(str1, str2, "file");
        return;
      }
      if (i1 == 0) {
        localObject = abux.d;
      } else {
        localObject = abux.b;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardFileOption
 * JD-Core Version:    0.7.0.1
 */