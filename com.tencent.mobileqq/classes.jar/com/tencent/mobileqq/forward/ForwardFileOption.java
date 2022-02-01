package com.tencent.mobileqq.forward;

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
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
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
import android.widget.TextView.OnEditorActionListener;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mqp.app.sec.SecShareInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavReport;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public class ForwardFileOption
  extends ForwardFileBaseOption
{
  private static ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage = null;
  private static FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private ForwardNewVersionDialog jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean j;
  protected boolean k;
  boolean l = false;
  boolean m = false;
  boolean n = false;
  private boolean o;
  
  public ForwardFileOption(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_j_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 10;
  }
  
  private void I()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseIntArray != null) {
      return;
    }
    this.jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(1, 2131698237);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(-1, 2131698231);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(-2, 2131698232);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(-3, 2131698229);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(-4, 2131698238);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(-5, 2131698235);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(-6, 2131698233);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(-7, 2131698236);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(-8, 2131698230);
  }
  
  private void J()
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    }
  }
  
  private void K()
  {
    Object localObject1 = a();
    int i;
    if (localObject1 != null)
    {
      i = ((ForwardFileInfo)localObject1).b();
      if (((i == 10000) || (i == 10006)) && (g() == 2)) {
        a(f(), String.valueOf(((ForwardFileInfo)localObject1).a()));
      }
    }
    for (;;)
    {
      return;
      long l1;
      if ((i == 10000) || (i == 10001) || (i == 10002) || (i == 10004) || (i == 10003))
      {
        l1 = ((ForwardFileInfo)localObject1).b();
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(l1);
        if (localObject1 != null) {
          FileModel.a((FileManagerEntity)localObject1).a(this.jdField_a_of_type_AndroidAppActivity, i, 12);
        }
      }
      else if (i == 10006)
      {
        l1 = ((ForwardFileInfo)localObject1).b();
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(l1);
        if (localObject2 != null)
        {
          localObject2 = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject2);
          l1 = ((ForwardFileInfo)localObject1).a();
          long l2 = this.jdField_a_of_type_AndroidContentIntent.getLongExtra("last_time", 0L);
          localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("sender_uin");
          QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, null, null, l1, (TroopFileStatusInfo)localObject2, (String)localObject1, l2, -1, 12, null, false, false);
        }
      }
      else if (i == 10013)
      {
        l1 = this.jdField_a_of_type_AndroidContentIntent.getLongExtra("qfavId", -1L);
        if (l1 != -1L)
        {
          QfavHelper.a(this.jdField_a_of_type_AndroidAppActivity, "", l1);
          return;
          if (FileUtils.b(this.jdField_i_of_type_JavaLangString)) {
            try
            {
              localObject1 = FileManagerUtil.a(new FileInfo(this.jdField_i_of_type_JavaLangString));
              if (localObject1 != null)
              {
                FileModel.a((FileManagerEntity)localObject1).a(this.jdField_a_of_type_AndroidAppActivity, 12);
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
      } while (FileUtil.b(paramFileManagerEntity.getFilePath()));
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
    if (FileUtils.b(str))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.getLoadingDrawable();
      localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.getFailedDrawable();
      return URLDrawable.getFileDrawable(str, localURLDrawableOptions);
    }
    return null;
  }
  
  private TextWatcher a()
  {
    return new ForwardFileOption.12(this);
  }
  
  private View.OnClickListener a()
  {
    return new ForwardFileOption.8(this);
  }
  
  private View.OnLongClickListener a()
  {
    return new ForwardFileOption.13(this);
  }
  
  @NotNull
  private View.OnTouchListener a()
  {
    return new ForwardFileOption.7(this);
  }
  
  private View.OnTouchListener a(View paramView)
  {
    return new ForwardFileOption.9(this, paramView);
  }
  
  private TextView.OnEditorActionListener a()
  {
    return new ForwardFileOption.11(this);
  }
  
  private ForwardFileInfo a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo;
    }
    if ((this.jdField_c_of_type_JavaUtilArrayList != null) && (this.jdField_c_of_type_JavaUtilArrayList.size() == 1)) {
      return (ForwardFileInfo)this.jdField_c_of_type_JavaUtilArrayList.get(0);
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
    String str = AppConstants.SDCARD_PATH + "photo/" + String.valueOf(System.currentTimeMillis()) + ".jpg";
    try
    {
      ImageUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), paramString, str, 600, 800);
      return str;
    }
    catch (Exception paramString) {}
    return str;
  }
  
  private void a(int paramInt1, int paramInt2, RelativeLayout paramRelativeLayout)
  {
    paramRelativeLayout.setPadding(0, paramInt1, 0, paramInt1);
    URLImageView localURLImageView = new URLImageView(this.jdField_a_of_type_AndroidAppActivity);
    localURLImageView.setId(2131367409);
    localURLImageView.setAdjustViewBounds(true);
    localURLImageView.setMaxHeight(ViewUtils.a(140.0F));
    localURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    paramRelativeLayout.addView(localURLImageView, (ViewGroup.LayoutParams)localObject);
    localObject = new View(this.jdField_a_of_type_AndroidAppActivity);
    ((View)localObject).setId(2131367404);
    ((View)localObject).setBackgroundColor(Color.argb(0, 0, 0, 0));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(6, 2131367409);
    localLayoutParams.addRule(8, 2131367409);
    localLayoutParams.addRule(5, 2131367409);
    localLayoutParams.addRule(7, 2131367409);
    paramRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
    ((ImageView)localObject).setId(2131367410);
    localLayoutParams = new RelativeLayout.LayoutParams(paramInt2, paramInt2);
    localLayoutParams.addRule(13);
    paramRelativeLayout.addView((View)localObject, localLayoutParams);
    paramRelativeLayout = a();
    if (paramRelativeLayout != null) {
      localURLImageView.setImageDrawable(paramRelativeLayout);
    }
    ((ImageView)localObject).setImageResource(2130840276);
  }
  
  private void a(int paramInt, RelativeLayout paramRelativeLayout)
  {
    paramRelativeLayout.setPadding(0, paramInt, 0, paramInt);
    URLImageView localURLImageView = new URLImageView(this.jdField_a_of_type_AndroidAppActivity);
    localURLImageView.setId(2131367409);
    localURLImageView.setAdjustViewBounds(true);
    localURLImageView.setMaxHeight(ViewUtils.a(140.0F));
    localURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    paramRelativeLayout.addView(localURLImageView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView = localURLImageView;
    localObject = new View(this.jdField_a_of_type_AndroidAppActivity);
    ((View)localObject).setId(2131367404);
    ((View)localObject).setBackgroundColor(Color.argb(0, 0, 0, 0));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(6, 2131367409);
    localLayoutParams.addRule(8, 2131367409);
    localLayoutParams.addRule(5, 2131367409);
    localLayoutParams.addRule(7, 2131367409);
    paramRelativeLayout.addView((View)localObject, localLayoutParams);
    paramRelativeLayout = a();
    if (paramRelativeLayout != null) {
      localURLImageView.setImageDrawable(paramRelativeLayout);
    }
  }
  
  private void a(int paramInt, RelativeLayout paramRelativeLayout, ImageView paramImageView, AsyncImageView paramAsyncImageView, LinearLayout paramLinearLayout1, TextView paramTextView, LinearLayout paramLinearLayout2)
  {
    ImageButton localImageButton = new ImageButton(this.jdField_a_of_type_AndroidAppActivity);
    localImageButton.setBackgroundColor(Color.parseColor("#FFFFFF"));
    localImageButton.setImageResource(2130844497);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt, paramInt);
    paramLinearLayout1.addView(localImageButton, localLayoutParams);
    paramLinearLayout1.setGravity(16);
    localImageButton.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageButton.setPadding(0, 0, 0, 0);
    localLayoutParams.setMargins(0, 0, 0, 0);
    localImageButton.setBackgroundColor(Color.argb(0, 0, 0, 0));
    paramRelativeLayout.setOnClickListener(null);
    paramRelativeLayout.setOnTouchListener(null);
    paramTextView.setOnClickListener(new ForwardFileOption.3(this));
    paramTextView.setOnTouchListener(new ForwardFileOption.4(this, localImageButton));
    localImageButton.setOnClickListener(new ForwardFileOption.5(this));
    localImageButton.setOnTouchListener(new ForwardFileOption.6(this, localImageButton));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(a());
    paramAsyncImageView.setOnClickListener(a());
    paramImageView.setOnClickListener(a());
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(a(paramLinearLayout2));
    paramAsyncImageView.setOnTouchListener(a(paramLinearLayout2));
    paramImageView.setOnTouchListener(a(paramLinearLayout2));
  }
  
  private void a(View paramView)
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow == null)
    {
      View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131560945, null);
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(localView, -1, -2, true);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView(localView);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setSoftInputMode(16);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)localView.findViewById(2131373359));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131364550));
      this.jdField_a_of_type_AndroidWidgetEditText.setSingleLine(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setMaxLines(2);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(a());
      this.jdField_a_of_type_AndroidWidgetEditText.setOnLongClickListener(a());
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(a());
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(b());
      this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog.findViewById(2131369141));
      if (this.jdField_b_of_type_AndroidWidgetEditText != null) {
        this.jdField_a_of_type_AndroidWidgetPopupWindow.setOnDismissListener(new ForwardFileOption.10(this));
      }
    }
    b(paramView);
  }
  
  private void a(ForwardFileInfo paramForwardFileInfo, int paramInt)
  {
    if ((paramForwardFileInfo != null) && (paramForwardFileInfo.a() != null) && (paramForwardFileInfo.a().length() > 1) && (paramInt != 1) && (paramInt != 0) && (paramInt != 2) && (paramForwardFileInfo.d() < 104857600L)) {
      this.n = true;
    }
    if ((paramForwardFileInfo == null) && (this.jdField_j_of_type_JavaLangString.length() > 1) && (this.jdField_i_of_type_JavaLangString.length() > 1) && (this.jdField_b_of_type_Long < 104857600L)) {
      this.n = true;
    }
  }
  
  private void a(ForwardFileInfo paramForwardFileInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, RelativeLayout paramRelativeLayout)
  {
    paramRelativeLayout.setPadding(0, paramInt5, 0, paramInt5);
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
    localImageView.setId(2131367403);
    localImageView.setImageResource(2130840274);
    Object localObject1 = new RelativeLayout.LayoutParams(paramInt2, paramInt3);
    ((RelativeLayout.LayoutParams)localObject1).addRule(11);
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = paramInt1;
    paramRelativeLayout.addView(localImageView, (ViewGroup.LayoutParams)localObject1);
    AsyncImageView localAsyncImageView = new AsyncImageView(this.jdField_a_of_type_AndroidAppActivity);
    localAsyncImageView.setId(2131367405);
    localObject1 = new RelativeLayout.LayoutParams(paramInt6, paramInt6);
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131367403);
    paramRelativeLayout.addView(localAsyncImageView, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new LinearLayout(this.jdField_a_of_type_AndroidAppActivity);
    ((LinearLayout)localObject1).setId(2131367408);
    ((LinearLayout)localObject1).setOrientation(1);
    ((LinearLayout)localObject1).setBackgroundColor(Color.argb(0, 0, 0, 0));
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(0, 2131367405);
    ((RelativeLayout.LayoutParams)localObject2).addRule(9);
    paramRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_AndroidWidgetTextView = new EllipsizingTextView(this.jdField_a_of_type_AndroidAppActivity, null);
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131367406);
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
    this.jdField_a_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setLineSpacing(0.0F, 1.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
    ((LinearLayout)localObject1).addView(this.jdField_a_of_type_AndroidWidgetTextView);
    localObject2 = new LinearLayout(this.jdField_a_of_type_AndroidAppActivity);
    ((LinearLayout)localObject2).setOrientation(0);
    Object localObject3 = new RelativeLayout.LayoutParams(-2, paramInt4);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, 2131367406);
    ((LinearLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject3 = new TextView(this.jdField_a_of_type_AndroidAppActivity);
    ((TextView)localObject3).setId(2131367407);
    ((TextView)localObject3).setSingleLine();
    ((TextView)localObject3).setGravity(16);
    ((TextView)localObject3).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject3).setTextSize(1, 14.0F);
    ((LinearLayout)localObject2).addView((View)localObject3);
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidAppActivity);
    localLinearLayout.setId(2131367404);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setBackgroundColor(Color.argb(0, 0, 0, 0));
    localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(6, 2131367408);
    ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131367408);
    paramRelativeLayout.addView(localLinearLayout, (ViewGroup.LayoutParams)localObject1);
    if (paramForwardFileInfo != null)
    {
      localObject1 = paramForwardFileInfo.d();
      if (paramForwardFileInfo == null) {
        break label626;
      }
    }
    label626:
    for (long l1 = paramForwardFileInfo.d();; l1 = this.jdField_b_of_type_Long)
    {
      FileManagerUtil.a(localAsyncImageView, (String)localObject1);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      ((TextView)localObject3).setText(FileUtil.a(l1, this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().densityDpi) + " ");
      a(paramForwardFileInfo, FileManagerUtil.a((String)localObject1));
      if (this.n)
      {
        I();
        a(paramInt3, paramRelativeLayout, localImageView, localAsyncImageView, (LinearLayout)localObject2, (TextView)localObject3, localLinearLayout);
      }
      return;
      localObject1 = this.jdField_j_of_type_JavaLangString;
      break;
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
      a(paramString1, new AIOImageProviderService(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramString2, 0, null), localAIOImageData);
      F();
    }
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3) || (paramInt == 0) || (paramInt == 7) || (paramInt == 6) || (paramInt == 10) || (paramInt == 9);
  }
  
  private boolean a(RecentUser paramRecentUser)
  {
    if (paramRecentUser.getType() == 9501) {}
    while (((paramRecentUser.getType() == 1006) && (!a(ForwardAbility.ForwardAbilityType.h))) || (paramRecentUser.getType() == 6004) || (paramRecentUser.getType() == 7000)) {
      return false;
    }
    return true;
  }
  
  /* Error */
  private boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 11
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 8
    //   12: new 818	java/io/File
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 819	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore_1
    //   21: new 818	java/io/File
    //   24: dup
    //   25: aload_2
    //   26: invokespecial 819	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: astore 12
    //   31: new 821	java/io/FileInputStream
    //   34: dup
    //   35: aload_1
    //   36: invokespecial 824	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   39: invokevirtual 828	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   42: astore_1
    //   43: aload_1
    //   44: astore 8
    //   46: aload 8
    //   48: astore_2
    //   49: aload 11
    //   51: astore_1
    //   52: new 830	java/io/FileOutputStream
    //   55: dup
    //   56: aload 12
    //   58: invokespecial 831	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   61: invokevirtual 832	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   64: astore 10
    //   66: aload 8
    //   68: astore_2
    //   69: aload 10
    //   71: astore_1
    //   72: aload 10
    //   74: astore 9
    //   76: aload 8
    //   78: invokevirtual 836	java/nio/channels/FileChannel:size	()J
    //   81: lstore 4
    //   83: iconst_0
    //   84: istore_3
    //   85: lconst_0
    //   86: lload 4
    //   88: lcmp
    //   89: ifge +50 -> 139
    //   92: aload 8
    //   94: astore_2
    //   95: aload 10
    //   97: astore_1
    //   98: aload 10
    //   100: astore 9
    //   102: aload 8
    //   104: iload_3
    //   105: i2l
    //   106: lload 4
    //   108: aload 10
    //   110: invokevirtual 840	java/nio/channels/FileChannel:transferTo	(JJLjava/nio/channels/WritableByteChannel;)J
    //   113: lstore 6
    //   115: lload 6
    //   117: lconst_0
    //   118: lcmp
    //   119: ifle -34 -> 85
    //   122: iload_3
    //   123: i2l
    //   124: lload 6
    //   126: ladd
    //   127: l2i
    //   128: istore_3
    //   129: lload 4
    //   131: lload 6
    //   133: lsub
    //   134: lstore 4
    //   136: goto -51 -> 85
    //   139: aload 8
    //   141: ifnull +8 -> 149
    //   144: aload 8
    //   146: invokevirtual 843	java/nio/channels/FileChannel:close	()V
    //   149: aload 10
    //   151: ifnull +8 -> 159
    //   154: aload 10
    //   156: invokevirtual 843	java/nio/channels/FileChannel:close	()V
    //   159: iconst_1
    //   160: ireturn
    //   161: astore_1
    //   162: aload_1
    //   163: invokevirtual 844	java/io/IOException:printStackTrace	()V
    //   166: goto -17 -> 149
    //   169: astore_1
    //   170: aload_1
    //   171: invokevirtual 844	java/io/IOException:printStackTrace	()V
    //   174: goto -15 -> 159
    //   177: astore 10
    //   179: aconst_null
    //   180: astore_1
    //   181: aload 8
    //   183: astore 9
    //   185: aload_1
    //   186: astore 8
    //   188: aload 8
    //   190: astore_2
    //   191: aload 9
    //   193: astore_1
    //   194: aload 10
    //   196: invokevirtual 844	java/io/IOException:printStackTrace	()V
    //   199: aload 8
    //   201: ifnull +8 -> 209
    //   204: aload 8
    //   206: invokevirtual 843	java/nio/channels/FileChannel:close	()V
    //   209: aload 9
    //   211: ifnull +8 -> 219
    //   214: aload 9
    //   216: invokevirtual 843	java/nio/channels/FileChannel:close	()V
    //   219: iconst_0
    //   220: ireturn
    //   221: astore_1
    //   222: aload_1
    //   223: invokevirtual 844	java/io/IOException:printStackTrace	()V
    //   226: goto -17 -> 209
    //   229: astore_1
    //   230: aload_1
    //   231: invokevirtual 844	java/io/IOException:printStackTrace	()V
    //   234: goto -15 -> 219
    //   237: astore 8
    //   239: aconst_null
    //   240: astore_2
    //   241: aload 10
    //   243: astore_1
    //   244: aload_2
    //   245: ifnull +7 -> 252
    //   248: aload_2
    //   249: invokevirtual 843	java/nio/channels/FileChannel:close	()V
    //   252: aload_1
    //   253: ifnull +7 -> 260
    //   256: aload_1
    //   257: invokevirtual 843	java/nio/channels/FileChannel:close	()V
    //   260: aload 8
    //   262: athrow
    //   263: astore_2
    //   264: aload_2
    //   265: invokevirtual 844	java/io/IOException:printStackTrace	()V
    //   268: goto -16 -> 252
    //   271: astore_1
    //   272: aload_1
    //   273: invokevirtual 844	java/io/IOException:printStackTrace	()V
    //   276: goto -16 -> 260
    //   279: astore 8
    //   281: goto -37 -> 244
    //   284: astore 10
    //   286: goto -98 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	this	ForwardFileOption
    //   0	289	1	paramString1	String
    //   0	289	2	paramString2	String
    //   84	45	3	i	int
    //   81	54	4	l1	long
    //   113	19	6	l2	long
    //   10	195	8	str	String
    //   237	24	8	localObject1	Object
    //   279	1	8	localObject2	Object
    //   7	208	9	localObject3	Object
    //   1	154	10	localFileChannel	java.nio.channels.FileChannel
    //   177	65	10	localIOException1	java.io.IOException
    //   284	1	10	localIOException2	java.io.IOException
    //   4	46	11	localObject4	Object
    //   29	28	12	localFile	File
    // Exception table:
    //   from	to	target	type
    //   144	149	161	java/io/IOException
    //   154	159	169	java/io/IOException
    //   31	43	177	java/io/IOException
    //   204	209	221	java/io/IOException
    //   214	219	229	java/io/IOException
    //   31	43	237	finally
    //   248	252	263	java/io/IOException
    //   256	260	271	java/io/IOException
    //   52	66	279	finally
    //   76	83	279	finally
    //   102	115	279	finally
    //   194	199	279	finally
    //   52	66	284	java/io/IOException
    //   76	83	284	java/io/IOException
    //   102	115	284	java/io/IOException
  }
  
  private int b(int paramInt)
  {
    int i = 1;
    if (this.jdField_a_of_type_AndroidUtilSparseIntArray != null) {}
    for (int i1 = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt, 0);; i1 = 0)
    {
      if (paramInt == 1) {
        i = 2;
      }
      for (;;)
      {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, i, i1, 0).a();
        return i;
        if (paramInt != -1) {
          i = 0;
        }
      }
    }
  }
  
  private View.OnClickListener b()
  {
    Object localObject = a();
    String str1;
    if (localObject != null)
    {
      str1 = ((ForwardFileInfo)localObject).d();
      if (localObject == null) {
        break label67;
      }
      localObject = ((ForwardFileInfo)localObject).a();
      label23:
      if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
        break label75;
      }
    }
    label67:
    label75:
    for (String str2 = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();; str2 = "")
    {
      return new ForwardFileOption.14(this, str1, (String)localObject, b(str2));
      str1 = this.jdField_j_of_type_JavaLangString;
      break;
      localObject = this.jdField_i_of_type_JavaLangString;
      break label23;
    }
  }
  
  private String b(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText == null) {
      return "";
    }
    String str1 = "";
    String str2 = paramString;
    if (paramString.endsWith(".rename") == true)
    {
      str1 = ".rename";
      str2 = paramString.replace(".rename", "");
    }
    int i = str2.lastIndexOf('.');
    paramString = "";
    if ((i > -1) && (i < str2.length()))
    {
      paramString = str2.substring(0, i);
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramString);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramString.length());
      paramString = str2.substring(i, str2.length());
    }
    for (;;)
    {
      return paramString + str1;
      this.jdField_a_of_type_AndroidWidgetEditText.setText(str2);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(str2.length());
    }
  }
  
  private void b(View paramView)
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow == null) {
      return;
    }
    this.m = false;
    if (this.jdField_b_of_type_AndroidWidgetEditText != null) {
      this.jdField_b_of_type_AndroidWidgetEditText.setFocusable(false);
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("input_method");
    localInputMethodManager.toggleSoftInput(1000, 2);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.update();
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new BitmapDrawable());
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(paramView.getRootView(), 80, 0, 0);
    if (d()) {
      localInputMethodManager.toggleSoftInput(0, 2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog.a();
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
  }
  
  private void b(String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText == null) {
      return;
    }
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(str.length());
    if ((str == null) || (str.length() <= 0))
    {
      b(-6);
      return;
    }
    if (!str.matches("[^/\\\\\\\\<>*:?|\\\"]+"))
    {
      b(-7);
      return;
    }
    str = str + paramString3;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {}
    for (paramString3 = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString(); str.equals(paramString3); paramString3 = "")
    {
      ReportController.b(null, "dc00898", "", "", "0X800AEEB", "0X800AEEB", 0, 0, "", "", "", "");
      J();
      return;
    }
    if (!str.equals(paramString1))
    {
      paramString3 = "";
      int i = paramString2.lastIndexOf('/');
      paramString1 = paramString3;
      if (i > -1)
      {
        paramString1 = paramString3;
        if (i < paramString2.length()) {
          paramString1 = paramString2.substring(0, i + 1);
        }
      }
      paramString1 = new File(paramString1).listFiles();
      if ((paramString1 != null) && (paramString1.length > 0))
      {
        int i1 = paramString1.length;
        i = 0;
        if (i < i1)
        {
          paramString2 = paramString1[i];
          if (paramString2.isDirectory()) {}
          while (!paramString2.getName().toLowerCase().equals(str.toLowerCase()))
          {
            i += 1;
            break;
          }
          b(-3);
          return;
        }
      }
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    }
    b(1);
    ReportController.b(null, "dc00898", "", "", "0X800AEEB", "0X800AEEB", 0, 0, "", "", "", "");
    J();
  }
  
  private boolean b(RecentUser paramRecentUser)
  {
    if (((paramRecentUser.getType() == 1) && (!a(paramRecentUser.uin))) || ((paramRecentUser.getType() == 0) && (!CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser.uin, paramRecentUser.getType()))) || (paramRecentUser.getType() == 3000) || (-1L != FileManagerUtil.a(paramRecentUser.getType()))) {}
    while ((paramRecentUser.uin.equalsIgnoreCase(AppConstants.DATALINE_PC_UIN)) && (a(ForwardAbility.ForwardAbilityType.jdField_f_of_type_JavaLangInteger)) && (t())) {
      return true;
    }
    return false;
  }
  
  private boolean c(RecentUser paramRecentUser)
  {
    if (((paramRecentUser.getType() == 0) && (!CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser.uin, paramRecentUser.getType()))) || (paramRecentUser.getType() == 1) || (paramRecentUser.getType() == 3000) || (paramRecentUser.getType() == 1006) || (paramRecentUser.getType() == 1004) || (paramRecentUser.getType() == 1000)) {}
    while ((paramRecentUser.uin.equalsIgnoreCase(AppConstants.DATALINE_PC_UIN)) && (a(ForwardAbility.ForwardAbilityType.jdField_f_of_type_JavaLangInteger)) && (t())) {
      return true;
    }
    return false;
  }
  
  private boolean d()
  {
    int i = this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getHeight();
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    return i * 3 / 4 > localRect.bottom;
  }
  
  private boolean d(RecentUser paramRecentUser)
  {
    return paramRecentUser.getType() == 1;
  }
  
  private void e()
  {
    String str = f();
    if (FileUtils.b(str))
    {
      File localFile = new File(str);
      this.jdField_j_of_type_JavaLangString = localFile.getName();
      this.jdField_i_of_type_JavaLangString = str;
      this.jdField_b_of_type_Long = localFile.length();
    }
  }
  
  private boolean e(RecentUser paramRecentUser)
  {
    if (!Utils.a(paramRecentUser.uin))
    {
      if (((paramRecentUser.getType() != 0) || (CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser.uin, paramRecentUser.getType()))) && ((paramRecentUser.getType() != 1) || (!a(jdField_c_of_type_JavaLangInteger)) || (a(paramRecentUser.uin))) && (paramRecentUser.getType() != 3000) && (FileManagerUtil.a(paramRecentUser.getType()) == -1L)) {}
    }
    else {
      while ((paramRecentUser.uin.equalsIgnoreCase(AppConstants.DATALINE_PC_UIN)) && (a(ForwardAbility.ForwardAbilityType.jdField_f_of_type_JavaLangInteger)) && (t())) {
        return true;
      }
    }
    return false;
  }
  
  private int f()
  {
    int i = -1;
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      return -1;
    }
    ArrayList localArrayList = this.jdField_a_of_type_AndroidOsBundle.getParcelableArrayList("forward_multi_target");
    if (localArrayList != null) {
      if (localArrayList.size() > 1) {
        i = 4;
      }
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", "0X800AEE9", "0X800AEE9", i, 0, "", "", "", "");
      return i;
      switch (this.jdField_a_of_type_AndroidOsBundle.getInt("uintype", 0))
      {
      default: 
        break;
      case -1: 
        i = 3;
        break;
      case 1: 
        i = 1;
        break;
      case 0: 
        i = 2;
      }
    }
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
    int i;
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
      i = FileManagerUtil.a((String)localObject1);
      if (i == -1) {
        break label95;
      }
      localObject2 = localObject1;
    } while (i != 11);
    label95:
    return a((String)localObject1);
  }
  
  private int g()
  {
    Object localObject = a();
    if ((localObject == null) && (TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))) {}
    while ((localObject == null) && (TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))) {
      return -1;
    }
    if (localObject != null) {}
    String str;
    int i;
    for (localObject = ((ForwardFileInfo)localObject).d();; localObject = this.jdField_i_of_type_JavaLangString)
    {
      str = g();
      i = FileManagerUtil.a((String)localObject);
      if ((i != 0) || (!FileUtils.b(str))) {
        break;
      }
      return 2;
    }
    if ((i == 2) && (FileUtils.b(str))) {
      return 3;
    }
    return 1;
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
  
  private boolean u()
  {
    if (!this.n) {
      return true;
    }
    if ((this.jdField_a_of_type_AndroidOsBundle == null) || (this.jdField_a_of_type_AndroidOsBundle.size() < 9)) {
      return true;
    }
    if ((this.jdField_a_of_type_AndroidOsBundle.containsKey("fileinfo_array")) && (this.jdField_a_of_type_AndroidOsBundle.getParcelableArrayList("fileinfo_array").size() > 1)) {
      return true;
    }
    ForwardFileInfo localForwardFileInfo = a();
    String str4 = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
    if (localForwardFileInfo != null) {}
    for (String str1 = localForwardFileInfo.d(); str4.equals(str1); str1 = this.jdField_j_of_type_JavaLangString) {
      return true;
    }
    if (localForwardFileInfo != null) {}
    for (str1 = localForwardFileInfo.a();; str1 = this.jdField_i_of_type_JavaLangString)
    {
      String str3 = "";
      int i = str1.lastIndexOf('/');
      String str2 = str3;
      if (i > -1)
      {
        str2 = str3;
        if (i < str1.length()) {
          str2 = str1.substring(0, i + 1) + str4;
        }
      }
      if (!a(str1, str2)) {
        break;
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
      return true;
    }
    b(-1);
    return false;
  }
  
  protected void A()
  {
    String str1 = f();
    String str2;
    int i;
    Object localObject;
    if (!TextUtils.isEmpty(str1))
    {
      str2 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      i = FileManagerUtil.a(str1);
      if (i != 2) {
        break label93;
      }
      localObject = DeviceMsgHandle.b;
    }
    for (;;)
    {
      DeviceMsgHandle localDeviceMsgHandle = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(str1);
      localDeviceMsgHandle.a().a((String)localObject, str2, localArrayList, null);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
      label93:
      localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
      if ((localObject != null) && (((SmartDeviceProxyMgr)localObject).a(Long.parseLong(this.jdField_a_of_type_AndroidOsBundle.getString("uin")), 17)))
      {
        ((SmartDeviceProxyMgr)localObject).a(Long.parseLong(str2), "", "", "", 0, null);
        if (i == 0)
        {
          super.a(str1, str2, "pic");
          return;
        }
        super.a(str1, str2, "file");
        return;
      }
      if (i == 0) {
        localObject = DeviceMsgHandle.d;
      } else {
        localObject = DeviceMsgHandle.b;
      }
    }
  }
  
  protected View a()
  {
    Object localObject = a();
    int i = AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i1 = AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    AIOUtils.a(14.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i2 = AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i3 = AIOUtils.a(16.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i4 = AIOUtils.a(18.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i5 = AIOUtils.a(20.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i6 = AIOUtils.a(32.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i7 = AIOUtils.a(40.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidAppActivity);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localRelativeLayout.setOnClickListener(new ForwardFileOption.2(this));
    localRelativeLayout.setOnTouchListener(a());
    localRelativeLayout.setLayoutParams(localLayoutParams);
    int i8 = g();
    if (i8 == 2)
    {
      a(i2, localRelativeLayout);
      return localRelativeLayout;
    }
    if (i8 == 3)
    {
      a(i2, i7, localRelativeLayout);
      return localRelativeLayout;
    }
    if (i8 == 1)
    {
      a((ForwardFileInfo)localObject, i, i1, i3, i4, i5, i6, localRelativeLayout);
      return localRelativeLayout;
    }
    localRelativeLayout.setPadding(0, i5, 0, i5);
    localObject = new AnimationTextView(this.jdField_a_of_type_AndroidAppActivity);
    ((AnimationTextView)localObject).setText(a());
    ((AnimationTextView)localObject).setMaxLines(2);
    ((AnimationTextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
    ((AnimationTextView)localObject).setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColorStateList(2131165706));
    ((AnimationTextView)localObject).setTextSize(14.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.bottomMargin = ScreenUtil.dip2px(10.0F);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
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
        if ((this.jdField_k_of_type_Boolean) && (b(localRecentUser))) {
          localArrayList.add(localRecentUser);
        } else if ((this.o) && (c(localRecentUser))) {
          localArrayList.add(localRecentUser);
        } else if ((this.l) && (d(localRecentUser))) {
          localArrayList.add(localRecentUser);
        } else if (e(localRecentUser)) {
          localArrayList.add(localRecentUser);
        }
      }
    }
    return localArrayList;
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
    if ((this.jdField_k_of_type_Boolean) && (!this.jdField_j_of_type_Boolean) && (-1L != FileManagerUtil.a(paramBundle.getInt("uintype"))))
    {
      DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, this.jdField_a_of_type_AndroidAppActivity.getString(2131697664), this.jdField_a_of_type_AndroidAppActivity.getString(2131697617), null, this.jdField_a_of_type_AndroidAppActivity.getString(2131720056), new ForwardFileOption.1(this), null).show();
      return;
    }
    super.a(paramInt, paramBundle);
  }
  
  protected void a(Intent paramIntent)
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
            int i = 0;
            if (i < ((ArrayList)localObject2).size())
            {
              Uri localUri = (Uri)((ArrayList)localObject2).get(i);
              localArrayList2.add(a(this.jdField_a_of_type_AndroidAppActivity, localUri));
              i += 1;
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
        } while (!u());
        localObject2 = a();
        if (localObject2 != null)
        {
          localArrayList2 = new ArrayList();
          localArrayList2.add(((ForwardFileInfo)localObject2).a());
        }
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
    int i;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null)
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.d();
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        i = 1;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() != 10006) {
          break label187;
        }
        bool1 = true;
        label72:
        this.jdField_k_of_type_Boolean = bool1;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() != 10009) {
          break label192;
        }
        bool1 = true;
        label92:
        this.l = bool1;
        if (i1 != 2) {
          break label197;
        }
        bool1 = true;
        label104:
        this.o = bool1;
        bool1 = bool2;
        if (i != 0) {
          if (i1 != 3)
          {
            bool1 = bool2;
            if (!FileUtils.a((String)localObject)) {}
          }
          else
          {
            bool1 = true;
          }
        }
        this.jdField_j_of_type_Boolean = bool1;
        label138:
        break label223;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", this.jdField_a_of_type_AndroidAppActivity.getString(2131719718));
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo == null) && (TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))) {
        e();
      }
      return true;
      i = 0;
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
      if (this.jdField_c_of_type_JavaUtilArrayList != null)
      {
        this.l = true;
        localObject = this.jdField_c_of_type_JavaUtilArrayList.iterator();
        label223:
        if (!((Iterator)localObject).hasNext()) {
          continue;
        }
        ForwardFileInfo localForwardFileInfo = (ForwardFileInfo)((Iterator)localObject).next();
        if ((localForwardFileInfo == null) || (localForwardFileInfo.d() == 6)) {
          break label138;
        }
        this.l = false;
        continue;
      }
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false)) {
        this.jdField_j_of_type_Boolean = true;
      }
    }
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    ArrayList localArrayList = new ArrayList();
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    int i1 = paramArrayOfDeviceInfo.length;
    int i = 0;
    if (i < i1)
    {
      DeviceInfo localDeviceInfo = paramArrayOfDeviceInfo[i];
      ProductInfo localProductInfo;
      if (localDeviceInfo != null)
      {
        int i2 = FileManagerUtil.a(f());
        localProductInfo = localSmartDeviceProxyMgr.a(localDeviceInfo.productId);
        if ((i2 != 2) || (!localSmartDeviceProxyMgr.c(localDeviceInfo.din)) || (!localSmartDeviceProxyMgr.a(localDeviceInfo.din, 17))) {
          break label106;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label106:
        if ((localProductInfo != null) && (localProductInfo.isSupportMainMsgType(8)) && (a(jdField_j_of_type_JavaLangInteger))) {
          localArrayList.add(localDeviceInfo);
        }
      }
    }
    return (DeviceInfo[])localArrayList.toArray(new DeviceInfo[localArrayList.size()]);
  }
  
  protected void b()
  {
    if ((!this.l) && (r()))
    {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
      this.jdField_a_of_type_JavaUtilSet.add(jdField_i_of_type_JavaLangInteger);
    }
    if ((!this.l) && (p())) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() == 10006) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() == 10003) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() == 10002) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() != 10009)) || (q())) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_c_of_type_JavaLangInteger);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null) {
      if (DataLineHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b())))
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
      if ((this.jdField_a_of_type_AndroidContentIntent != null) && (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_smartdevice", true)) && (s()) && (a(FileManagerUtil.a(f())))) {
        this.jdField_a_of_type_JavaUtilSet.add(jdField_j_of_type_JavaLangInteger);
      }
      return;
      if (this.jdField_c_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
        label307:
        if (!localIterator.hasNext()) {
          continue;
        }
        ForwardFileInfo localForwardFileInfo = (ForwardFileInfo)localIterator.next();
        if ((localForwardFileInfo == null) || (!DataLineHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(localForwardFileInfo.b())))) {
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
  
  protected void b(Intent paramIntent)
  {
    if (!u()) {
      return;
    }
    paramIntent.putExtra("dataline_forward_type", 100);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo == null)
    {
      String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_filepath");
      String str1 = str2;
      if (str2 == null) {
        str1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
      }
      paramIntent.putExtra("dataline_forward_path", str1);
      return;
    }
    paramIntent.putExtra("dataline_forward_path", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a());
  }
  
  public boolean b()
  {
    return true;
  }
  
  protected boolean c()
  {
    boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false);
    if (!u()) {
      return true;
    }
    Intent localIntent;
    if (j())
    {
      localObject = b();
      localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "fileoption realForwardTo isfromshare=" + bool);
      }
      if (bool)
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", HardCodeUtil.a(2131704776));
        localIntent.addFlags(268435456);
        localIntent.addFlags(67108864);
        localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
        bool = a(localIntent);
        if (this.jdField_f_of_type_Boolean)
        {
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
          if ((QSecFramework.a().a(1003).booleanValue()) && (this.jdField_j_of_type_Boolean))
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject).next();
              SecShareInfoUtil.a().a(4, f(), localResultRecord.getUinType(), localResultRecord.uin);
              SecShareInfoUtil.a().a();
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
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    if (i == 1008)
    {
      localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class);
      localIntent.putExtra("chat_subType", ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).getPublicAccountAioClass((String)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "fileoption realForwardTo isfromshare=" + bool);
      }
      if (!bool) {
        break label612;
      }
      this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", HardCodeUtil.a(2131704775));
      localIntent.addFlags(268435456);
      localIntent.addFlags(67108864);
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      bool = a(localIntent);
      if (!this.jdField_f_of_type_Boolean) {
        break label587;
      }
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      if ((QSecFramework.a().a(1003).booleanValue()) && (this.jdField_j_of_type_Boolean))
      {
        SecShareInfoUtil.a().a(4, f(), i, (String)localObject);
        SecShareInfoUtil.a().a();
      }
    }
    for (;;)
    {
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return false;
      localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
      break;
      label587:
      if (!bool)
      {
        ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
        continue;
        label612:
        if (!this.e)
        {
          localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
        }
      }
    }
  }
  
  protected int d()
  {
    int i;
    if (jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
    {
      if (!new QfavBuilder(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, jdField_a_of_type_ComTencentMobileqqDataChatMessage, true)) {
        break label129;
      }
      jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_AddFav", -1, 0, 69, 0, "", "");
      }
      return i;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null)
      {
        FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b());
        if ((localFileManagerEntity != null) && (new QfavBuilder(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, null, true)))
        {
          jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
          i = 0;
          continue;
        }
      }
      label129:
      i = -1;
    }
  }
  
  protected String e()
  {
    return this.jdField_a_of_type_AndroidContentContext.getString(2131719295);
  }
  
  protected boolean m()
  {
    return true;
  }
  
  protected void v()
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog = new ForwardNewVersionDialog(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog.a(2131560937);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog;
    if (!i()) {}
    for (boolean bool = true;; bool = false)
    {
      ((ForwardNewVersionDialog)localObject).a(bool);
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog.c(210);
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog.a(a());
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog.a(c(), d(), this.jdField_a_of_type_AndroidAppActivity.getResources().getString(a()), this.jdField_a_of_type_AndroidAppActivity.getResources().getString(b()), a(), b());
      a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog);
      localObject = this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog.getWindow();
      ((Window)localObject).getDecorView().setPadding(0, 0, 0, 0);
      WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      ((Window)localObject).setAttributes(localLayoutParams);
      if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog.show();
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(this);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardFileOption
 * JD-Core Version:    0.7.0.1
 */