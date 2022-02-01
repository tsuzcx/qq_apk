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
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.IFileBrowserParam;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.openbrowser.FileBrowserParam;
import com.tencent.mobileqq.filemanager.openbrowser.FileModelAdapter;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.filemanager.recreate.IFModel;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
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
  private static ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  private static FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
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
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(1, 2131698302);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(-1, 2131698296);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(-2, 2131698297);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(-3, 2131698294);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(-4, 2131698303);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(-5, 2131698300);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(-6, 2131698298);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(-7, 2131698301);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(-8, 2131698295);
  }
  
  private void J()
  {
    PopupWindow localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null) {
      localPopupWindow.dismiss();
    }
  }
  
  private void K()
  {
    Object localObject1 = a();
    if (localObject1 != null)
    {
      int i = ((ForwardFileInfo)localObject1).b();
      if (((i == 10000) || (i == 10006)) && (g() == 2))
      {
        a(f(), String.valueOf(((ForwardFileInfo)localObject1).a()));
        return;
      }
      long l1;
      Object localObject2;
      if ((i != 10000) && (i != 10001) && (i != 10002) && (i != 10004) && (i != 10003))
      {
        if (i == 10006)
        {
          l1 = ((ForwardFileInfo)localObject1).b();
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(l1);
          if (localObject2 != null)
          {
            localObject2 = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject2);
            l1 = this.jdField_a_of_type_AndroidContentIntent.getLongExtra("last_time", 0L);
            String str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("sender_uin");
            i = FileManagerUtil.a(((TroopFileStatusInfo)localObject2).g);
            if ((i != 0) && (i != 2))
            {
              QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, null, (TroopFileStatusInfo)localObject2, str, l1, 12, false);
              return;
            }
            long l2 = ((ForwardFileInfo)localObject1).a();
            QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, null, null, l2, (TroopFileStatusInfo)localObject2, str, l1, -1, 12, null, false, false);
          }
        }
        else if (i == 10013)
        {
          l1 = this.jdField_a_of_type_AndroidContentIntent.getLongExtra("qfavId", -1L);
          if (l1 != -1L) {
            QfavHelper.a(this.jdField_a_of_type_AndroidAppActivity, "", l1);
          }
        }
      }
      else
      {
        l1 = ((ForwardFileInfo)localObject1).b();
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(l1);
        if (localObject1 != null)
        {
          if ((((FileManagerEntity)localObject1).nFileType != 0) && (((FileManagerEntity)localObject1).nFileType != 2))
          {
            localObject1 = new FileModelAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject1);
            localObject2 = new FileBrowserParam().a(12);
            ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).browserFile(this.jdField_a_of_type_AndroidAppActivity, (IFileBrowserModel)localObject1, (IFileBrowserParam)localObject2);
            return;
          }
          FileModel.a((FileManagerEntity)localObject1).a(this.jdField_a_of_type_AndroidAppActivity, i, 12);
        }
      }
    }
    else if (FileUtils.fileExistsAndNotEmpty(this.jdField_i_of_type_JavaLangString))
    {
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
  
  public static int a(FileManagerEntity paramFileManagerEntity)
  {
    int i1 = 10000;
    int i = i1;
    if (paramFileManagerEntity != null)
    {
      i = i1;
      switch (paramFileManagerEntity.getCloudType())
      {
      case 4: 
      default: 
        i = i1;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("FileManagerEntity->cloudType 转 ForwardFileInfo->type， 未识别的cloudType[");
          localStringBuilder.append(paramFileManagerEntity.getCloudType());
          QLog.e("dataline", 2, localStringBuilder.toString());
          return 10000;
        }
        break;
      case 8: 
        return 10011;
      case 6: 
      case 7: 
        if (FileUtil.a(paramFileManagerEntity.getFilePath())) {
          return 10000;
        }
        return 10009;
      case 2: 
        return 10003;
      case 1: 
        i = 10002;
      }
    }
    return i;
  }
  
  private Drawable a()
  {
    String str = g();
    if (FileUtils.fileExistsAndNotEmpty(str))
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
    } else if (!TextUtils.isEmpty(paramFileManagerEntity.strMiddleThumPath)) {
      paramChatMessage.f(paramFileManagerEntity.strMiddleThumPath);
    } else {
      paramChatMessage.f(paramFileManagerEntity.strThumbPath);
    }
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
  }
  
  private String a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject).append("photo/");
    ((StringBuilder)localObject).append(String.valueOf(System.currentTimeMillis()));
    ((StringBuilder)localObject).append(".jpg");
    localObject = ((StringBuilder)localObject).toString();
    try
    {
      ImageUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), paramString, (String)localObject, 600, 800);
      return localObject;
    }
    catch (Exception paramString) {}
    return localObject;
  }
  
  private void a(int paramInt1, int paramInt2, RelativeLayout paramRelativeLayout)
  {
    paramRelativeLayout.setPadding(0, paramInt1, 0, paramInt1);
    URLImageView localURLImageView = new URLImageView(this.jdField_a_of_type_AndroidAppActivity);
    localURLImageView.setId(2131367191);
    localURLImageView.setAdjustViewBounds(true);
    localURLImageView.setMaxHeight(ViewUtils.a(140.0F));
    localURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    paramRelativeLayout.addView(localURLImageView, (ViewGroup.LayoutParams)localObject);
    localObject = new View(this.jdField_a_of_type_AndroidAppActivity);
    ((View)localObject).setId(2131367186);
    ((View)localObject).setBackgroundColor(Color.argb(0, 0, 0, 0));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(6, 2131367191);
    localLayoutParams.addRule(8, 2131367191);
    localLayoutParams.addRule(5, 2131367191);
    localLayoutParams.addRule(7, 2131367191);
    paramRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
    ((ImageView)localObject).setId(2131367192);
    localLayoutParams = new RelativeLayout.LayoutParams(paramInt2, paramInt2);
    localLayoutParams.addRule(13);
    paramRelativeLayout.addView((View)localObject, localLayoutParams);
    paramRelativeLayout = a();
    if (paramRelativeLayout != null) {
      localURLImageView.setImageDrawable(paramRelativeLayout);
    }
    ((ImageView)localObject).setImageResource(2130840135);
  }
  
  private void a(int paramInt, RelativeLayout paramRelativeLayout)
  {
    paramRelativeLayout.setPadding(0, paramInt, 0, paramInt);
    URLImageView localURLImageView = new URLImageView(this.jdField_a_of_type_AndroidAppActivity);
    localURLImageView.setId(2131367191);
    localURLImageView.setAdjustViewBounds(true);
    localURLImageView.setMaxHeight(ViewUtils.a(140.0F));
    localURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    paramRelativeLayout.addView(localURLImageView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView = localURLImageView;
    localObject = new View(this.jdField_a_of_type_AndroidAppActivity);
    ((View)localObject).setId(2131367186);
    ((View)localObject).setBackgroundColor(Color.argb(0, 0, 0, 0));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(6, 2131367191);
    localLayoutParams.addRule(8, 2131367191);
    localLayoutParams.addRule(5, 2131367191);
    localLayoutParams.addRule(7, 2131367191);
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
    localImageButton.setImageResource(2130844403);
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
      View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131560820, null);
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(localView, -1, -2, true);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView(localView);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setSoftInputMode(16);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)localView.findViewById(2131372936));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131364437));
      this.jdField_a_of_type_AndroidWidgetEditText.setSingleLine(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setMaxLines(2);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(a());
      this.jdField_a_of_type_AndroidWidgetEditText.setOnLongClickListener(a());
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(a());
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(b());
      this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog.findViewById(2131368874));
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
    localImageView.setId(2131367185);
    localImageView.setImageResource(2130840133);
    Object localObject1 = new RelativeLayout.LayoutParams(paramInt2, paramInt3);
    ((RelativeLayout.LayoutParams)localObject1).addRule(11);
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = paramInt1;
    paramRelativeLayout.addView(localImageView, (ViewGroup.LayoutParams)localObject1);
    AsyncImageView localAsyncImageView = new AsyncImageView(this.jdField_a_of_type_AndroidAppActivity);
    localAsyncImageView.setId(2131367187);
    localObject1 = new RelativeLayout.LayoutParams(paramInt6, paramInt6);
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131367185);
    paramRelativeLayout.addView(localAsyncImageView, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new LinearLayout(this.jdField_a_of_type_AndroidAppActivity);
    ((LinearLayout)localObject1).setId(2131367190);
    ((LinearLayout)localObject1).setOrientation(1);
    ((LinearLayout)localObject1).setBackgroundColor(Color.argb(0, 0, 0, 0));
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(0, 2131367187);
    ((RelativeLayout.LayoutParams)localObject2).addRule(9);
    paramRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_AndroidWidgetTextView = new EllipsizingTextView(this.jdField_a_of_type_AndroidAppActivity, null);
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131367188);
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
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, 2131367188);
    ((LinearLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject3 = new TextView(this.jdField_a_of_type_AndroidAppActivity);
    ((TextView)localObject3).setId(2131367189);
    ((TextView)localObject3).setSingleLine();
    ((TextView)localObject3).setGravity(16);
    ((TextView)localObject3).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject3).setTextSize(1, 14.0F);
    ((LinearLayout)localObject2).addView((View)localObject3);
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidAppActivity);
    localLinearLayout.setId(2131367186);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setBackgroundColor(Color.argb(0, 0, 0, 0));
    localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(6, 2131367190);
    ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131367190);
    paramRelativeLayout.addView(localLinearLayout, (ViewGroup.LayoutParams)localObject1);
    if (paramForwardFileInfo != null) {
      localObject1 = paramForwardFileInfo.d();
    } else {
      localObject1 = this.jdField_j_of_type_JavaLangString;
    }
    long l1;
    if (paramForwardFileInfo != null) {
      l1 = paramForwardFileInfo.d();
    } else {
      l1 = this.jdField_b_of_type_Long;
    }
    FileManagerUtil.a(localAsyncImageView, (String)localObject1);
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FileUtil.a(l1, this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().densityDpi));
    localStringBuilder.append(" ");
    ((TextView)localObject3).setText(localStringBuilder.toString());
    a(paramForwardFileInfo, FileManagerUtil.a((String)localObject1));
    if (this.n)
    {
      I();
      a(paramInt3, paramRelativeLayout, localImageView, localAsyncImageView, (LinearLayout)localObject2, (TextView)localObject3, localLinearLayout);
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startToGalleryWithPath: path=");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("ForwardOption.ForwardFileOption", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      localObject = new AIOImageData();
      ((AIOImageData)localObject).a = paramString1;
      ((AIOImageData)localObject).b = paramString1;
      ((AIOImageData)localObject).c = paramString1;
      ((AIOImageData)localObject).e = false;
      paramString1 = new Bundle();
      paramString1.putBoolean("extra.EXTRA_NOT_CLEAR_TOP", true);
      paramString1.putBoolean("key_allow_forward_photo_preview_edit", true);
      a(paramString1, new AIOImageProviderService(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramString2, 0, null), (AIORichMediaData)localObject);
      G();
    }
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3) || (paramInt == 0) || (paramInt == 7) || (paramInt == 6) || (paramInt == 10) || (paramInt == 9);
  }
  
  private boolean a(RecentUser paramRecentUser)
  {
    if (paramRecentUser.getType() == 9501) {
      return false;
    }
    if ((paramRecentUser.getType() == 1006) && (!a(ForwardAbility.ForwardAbilityType.h))) {
      return false;
    }
    if (paramRecentUser.getType() == 6004) {
      return false;
    }
    return paramRecentUser.getType() != 7000;
  }
  
  /* Error */
  private boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 855	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 856	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: new 855	java/io/File
    //   12: dup
    //   13: aload_2
    //   14: invokespecial 856	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 11
    //   19: aconst_null
    //   20: astore 12
    //   22: aconst_null
    //   23: astore 10
    //   25: aconst_null
    //   26: astore_2
    //   27: new 858	java/io/FileInputStream
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 861	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   35: invokevirtual 865	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   38: astore_1
    //   39: new 867	java/io/FileOutputStream
    //   42: dup
    //   43: aload 11
    //   45: invokespecial 868	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   48: invokevirtual 869	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   51: astore 11
    //   53: aload_1
    //   54: invokevirtual 873	java/nio/channels/FileChannel:size	()J
    //   57: lstore 4
    //   59: iconst_0
    //   60: istore_3
    //   61: lconst_0
    //   62: lload 4
    //   64: lcmp
    //   65: ifge +43 -> 108
    //   68: iload_3
    //   69: i2l
    //   70: lstore 6
    //   72: aload_1
    //   73: lload 6
    //   75: lload 4
    //   77: aload 11
    //   79: invokevirtual 877	java/nio/channels/FileChannel:transferTo	(JJLjava/nio/channels/WritableByteChannel;)J
    //   82: lstore 8
    //   84: lload 8
    //   86: lconst_0
    //   87: lcmp
    //   88: ifle -27 -> 61
    //   91: lload 6
    //   93: lload 8
    //   95: ladd
    //   96: l2i
    //   97: istore_3
    //   98: lload 4
    //   100: lload 8
    //   102: lsub
    //   103: lstore 4
    //   105: goto -44 -> 61
    //   108: aload_1
    //   109: ifnull +15 -> 124
    //   112: aload_1
    //   113: invokevirtual 880	java/nio/channels/FileChannel:close	()V
    //   116: goto +8 -> 124
    //   119: astore_1
    //   120: aload_1
    //   121: invokevirtual 881	java/io/IOException:printStackTrace	()V
    //   124: aload 11
    //   126: ifnull +16 -> 142
    //   129: aload 11
    //   131: invokevirtual 880	java/nio/channels/FileChannel:close	()V
    //   134: goto +8 -> 142
    //   137: astore_1
    //   138: aload_1
    //   139: invokevirtual 881	java/io/IOException:printStackTrace	()V
    //   142: iconst_1
    //   143: ireturn
    //   144: astore_2
    //   145: aload_1
    //   146: astore 10
    //   148: goto +94 -> 242
    //   151: astore 10
    //   153: aload 11
    //   155: astore_2
    //   156: goto +15 -> 171
    //   159: astore_2
    //   160: aload 12
    //   162: astore 10
    //   164: goto +85 -> 249
    //   167: astore 10
    //   169: aconst_null
    //   170: astore_2
    //   171: aload_1
    //   172: astore 11
    //   174: aload_2
    //   175: astore_1
    //   176: aload 11
    //   178: astore_2
    //   179: goto +14 -> 193
    //   182: astore_1
    //   183: aconst_null
    //   184: astore 11
    //   186: goto +68 -> 254
    //   189: astore 10
    //   191: aconst_null
    //   192: astore_1
    //   193: aload 10
    //   195: invokevirtual 881	java/io/IOException:printStackTrace	()V
    //   198: aload_2
    //   199: ifnull +15 -> 214
    //   202: aload_2
    //   203: invokevirtual 880	java/nio/channels/FileChannel:close	()V
    //   206: goto +8 -> 214
    //   209: astore_2
    //   210: aload_2
    //   211: invokevirtual 881	java/io/IOException:printStackTrace	()V
    //   214: aload_1
    //   215: ifnull +14 -> 229
    //   218: aload_1
    //   219: invokevirtual 880	java/nio/channels/FileChannel:close	()V
    //   222: iconst_0
    //   223: ireturn
    //   224: astore_1
    //   225: aload_1
    //   226: invokevirtual 881	java/io/IOException:printStackTrace	()V
    //   229: iconst_0
    //   230: ireturn
    //   231: astore 12
    //   233: aload_2
    //   234: astore 10
    //   236: aload_1
    //   237: astore 11
    //   239: aload 12
    //   241: astore_2
    //   242: aload 10
    //   244: astore_1
    //   245: aload 11
    //   247: astore 10
    //   249: aload_1
    //   250: astore 11
    //   252: aload_2
    //   253: astore_1
    //   254: aload 11
    //   256: ifnull +16 -> 272
    //   259: aload 11
    //   261: invokevirtual 880	java/nio/channels/FileChannel:close	()V
    //   264: goto +8 -> 272
    //   267: astore_2
    //   268: aload_2
    //   269: invokevirtual 881	java/io/IOException:printStackTrace	()V
    //   272: aload 10
    //   274: ifnull +16 -> 290
    //   277: aload 10
    //   279: invokevirtual 880	java/nio/channels/FileChannel:close	()V
    //   282: goto +8 -> 290
    //   285: astore_2
    //   286: aload_2
    //   287: invokevirtual 881	java/io/IOException:printStackTrace	()V
    //   290: goto +5 -> 295
    //   293: aload_1
    //   294: athrow
    //   295: goto -2 -> 293
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	this	ForwardFileOption
    //   0	298	1	paramString1	String
    //   0	298	2	paramString2	String
    //   60	38	3	i	int
    //   57	47	4	l1	long
    //   70	22	6	l2	long
    //   82	19	8	l3	long
    //   23	124	10	str	String
    //   151	1	10	localIOException1	java.io.IOException
    //   162	1	10	localObject1	Object
    //   167	1	10	localIOException2	java.io.IOException
    //   189	5	10	localIOException3	java.io.IOException
    //   234	44	10	localObject2	Object
    //   17	243	11	localObject3	Object
    //   20	141	12	localObject4	Object
    //   231	9	12	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   112	116	119	java/io/IOException
    //   129	134	137	java/io/IOException
    //   53	59	144	finally
    //   72	84	144	finally
    //   53	59	151	java/io/IOException
    //   72	84	151	java/io/IOException
    //   39	53	159	finally
    //   39	53	167	java/io/IOException
    //   27	39	182	finally
    //   27	39	189	java/io/IOException
    //   202	206	209	java/io/IOException
    //   218	222	224	java/io/IOException
    //   193	198	231	finally
    //   259	264	267	java/io/IOException
    //   277	282	285	java/io/IOException
  }
  
  private int b(int paramInt)
  {
    SparseIntArray localSparseIntArray = this.jdField_a_of_type_AndroidUtilSparseIntArray;
    int i;
    if (localSparseIntArray != null) {
      i = localSparseIntArray.get(paramInt, 0);
    } else {
      i = 0;
    }
    if (paramInt == 1) {
      paramInt = 2;
    } else if (paramInt == -1) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, paramInt, i, 0).a();
    return paramInt;
  }
  
  private View.OnClickListener b()
  {
    Object localObject1 = a();
    String str;
    if (localObject1 != null) {
      str = ((ForwardFileInfo)localObject1).d();
    } else {
      str = this.jdField_j_of_type_JavaLangString;
    }
    if (localObject1 != null) {
      localObject1 = ((ForwardFileInfo)localObject1).a();
    } else {
      localObject1 = this.jdField_i_of_type_JavaLangString;
    }
    Object localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject2 != null) {
      localObject2 = ((TextView)localObject2).getText().toString();
    } else {
      localObject2 = "";
    }
    return new ForwardFileOption.14(this, str, (String)localObject1, b((String)localObject2));
  }
  
  private String b(String paramString)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetEditText;
    Object localObject2 = "";
    if (localObject1 == null) {
      return "";
    }
    localObject1 = ".rename";
    String str;
    if (paramString.endsWith(".rename") == true)
    {
      str = paramString.replace(".rename", "");
      paramString = (String)localObject1;
      localObject1 = str;
    }
    else
    {
      str = "";
      localObject1 = paramString;
      paramString = str;
    }
    int i = ((String)localObject1).lastIndexOf('.');
    if ((i > -1) && (i < ((String)localObject1).length()))
    {
      localObject2 = ((String)localObject1).substring(0, i);
      this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject2);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(((String)localObject2).length());
      localObject1 = ((String)localObject1).substring(i, ((String)localObject1).length());
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject1);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(((String)localObject1).length());
      localObject1 = localObject2;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(paramString);
    return ((StringBuilder)localObject2).toString();
  }
  
  private void b(View paramView)
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow == null) {
      return;
    }
    this.m = false;
    Object localObject = this.jdField_b_of_type_AndroidWidgetEditText;
    if (localObject != null) {
      ((EditText)localObject).setFocusable(false);
    }
    localObject = (InputMethodManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("input_method");
    ((InputMethodManager)localObject).toggleSoftInput(1000, 2);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.update();
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new BitmapDrawable());
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(paramView.getRootView(), 80, 0, 0);
    if (d()) {
      ((InputMethodManager)localObject).toggleSoftInput(0, 2);
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog;
    if (paramView != null) {
      paramView.a();
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
  }
  
  private void b(String paramString1, String paramString2, String paramString3)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetEditText;
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((EditText)localObject1).getText().toString();
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(((String)localObject1).length());
    if ((localObject1 != null) && (((String)localObject1).length() > 0))
    {
      if (!((String)localObject1).matches("[^/\\\\\\\\<>*:?|\\\"]+"))
      {
        b(-7);
        return;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(paramString3);
      localObject2 = ((StringBuilder)localObject2).toString();
      paramString3 = this.jdField_a_of_type_AndroidWidgetTextView;
      localObject1 = "";
      if (paramString3 != null) {
        paramString3 = paramString3.getText().toString();
      } else {
        paramString3 = "";
      }
      if (((String)localObject2).equals(paramString3))
      {
        ReportController.b(null, "dc00898", "", "", "0X800AEEB", "0X800AEEB", 0, 0, "", "", "", "");
        J();
        return;
      }
      if (!((String)localObject2).equals(paramString1))
      {
        int i1 = paramString2.lastIndexOf('/');
        int i = 0;
        paramString1 = (String)localObject1;
        if (i1 > -1)
        {
          paramString1 = (String)localObject1;
          if (i1 < paramString2.length()) {
            paramString1 = paramString2.substring(0, i1 + 1);
          }
        }
        paramString1 = new File(paramString1).listFiles();
        if ((paramString1 != null) && (paramString1.length > 0))
        {
          i1 = paramString1.length;
          while (i < i1)
          {
            paramString2 = paramString1[i];
            if ((!paramString2.isDirectory()) && (paramString2.getName().toLowerCase().equals(((String)localObject2).toLowerCase())))
            {
              b(-3);
              return;
            }
            i += 1;
          }
        }
      }
      paramString1 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (paramString1 != null) {
        paramString1.setText((CharSequence)localObject2);
      }
      b(1);
      ReportController.b(null, "dc00898", "", "", "0X800AEEB", "0X800AEEB", 0, 0, "", "", "", "");
      J();
      return;
    }
    b(-6);
  }
  
  private boolean b(RecentUser paramRecentUser)
  {
    if (((paramRecentUser.getType() != 1) || (a(paramRecentUser.uin))) && ((paramRecentUser.getType() != 0) || (CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser.uin, paramRecentUser.getType()))) && (paramRecentUser.getType() != 3000))
    {
      if (-1L != FileManagerUtil.a(paramRecentUser.getType())) {
        return true;
      }
      return (paramRecentUser.uin.equalsIgnoreCase(AppConstants.DATALINE_PC_UIN)) && (a(ForwardAbility.ForwardAbilityType.jdField_f_of_type_JavaLangInteger)) && (t());
    }
    return true;
  }
  
  private boolean c(RecentUser paramRecentUser)
  {
    if (((paramRecentUser.getType() != 0) || (CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser.uin, paramRecentUser.getType()))) && (paramRecentUser.getType() != 1) && (paramRecentUser.getType() != 3000) && (paramRecentUser.getType() != 1006) && (paramRecentUser.getType() != 1004))
    {
      if (paramRecentUser.getType() == 1000) {
        return true;
      }
      return (paramRecentUser.uin.equalsIgnoreCase(AppConstants.DATALINE_PC_UIN)) && (a(ForwardAbility.ForwardAbilityType.jdField_f_of_type_JavaLangInteger)) && (t());
    }
    return true;
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
    if (FileUtils.fileExistsAndNotEmpty(str))
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
      if (((paramRecentUser.getType() == 0) && (!CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser.uin, paramRecentUser.getType()))) || ((paramRecentUser.getType() == 1) && (a(jdField_c_of_type_JavaLangInteger)) && (!a(paramRecentUser.uin))) || (paramRecentUser.getType() == 3000) || (FileManagerUtil.a(paramRecentUser.getType()) != -1L)) {
        return true;
      }
    }
    else if ((paramRecentUser.uin.equalsIgnoreCase(AppConstants.DATALINE_PC_UIN)) && (a(ForwardAbility.ForwardAbilityType.jdField_f_of_type_JavaLangInteger)) && (t())) {
      return true;
    }
    return false;
  }
  
  private int f()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsBundle;
    int i = -1;
    if (localObject == null) {
      return -1;
    }
    localObject = this.jdField_a_of_type_AndroidOsBundle.getParcelableArrayList("forward_multi_target");
    if (localObject != null)
    {
      if (((List)localObject).size() > 1) {
        i = 4;
      }
    }
    else
    {
      int i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype", 0);
      if (i1 != -1)
      {
        if (i1 != 0)
        {
          if (i1 == 1) {
            i = 1;
          }
        }
        else {
          i = 2;
        }
      }
      else {
        i = 3;
      }
    }
    ReportController.b(null, "dc00898", "", "", "0X800AEE9", "0X800AEE9", i, 0, "", "", "", "");
    return i;
  }
  
  private String f()
  {
    String str2;
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo == null)
    {
      str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_filepath");
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
      }
    }
    else
    {
      str2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a();
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.f();
      }
    }
    if (TextUtils.isEmpty(str1)) {
      return null;
    }
    int i = FileManagerUtil.a(str1);
    if ((i != -1) && (i != 11)) {
      return str1;
    }
    return a(str1);
  }
  
  private int g()
  {
    Object localObject = a();
    int i = -1;
    if ((localObject == null) && (TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))) {
      return -1;
    }
    if ((localObject != null) || (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)))
    {
      if (localObject != null) {
        localObject = ((ForwardFileInfo)localObject).d();
      } else {
        localObject = this.jdField_i_of_type_JavaLangString;
      }
      String str = g();
      i = FileManagerUtil.a((String)localObject);
      if ((i == 0) && (FileUtils.fileExistsAndNotEmpty(str))) {
        return 2;
      }
      if ((i == 2) && (FileUtils.fileExistsAndNotEmpty(str))) {
        return 3;
      }
      i = 1;
    }
    return i;
  }
  
  private String g()
  {
    Object localObject = a();
    if (localObject != null) {
      return ((ForwardFileInfo)localObject).f();
    }
    String str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_thumb");
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.jdField_a_of_type_AndroidOsBundle.getString("forward_thumb");
    }
    return localObject;
  }
  
  private boolean u()
  {
    if (!this.n) {
      return true;
    }
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      if (this.jdField_a_of_type_AndroidOsBundle.size() < 9) {
        return true;
      }
      if ((this.jdField_a_of_type_AndroidOsBundle.containsKey("fileinfo_array")) && (this.jdField_a_of_type_AndroidOsBundle.getParcelableArrayList("fileinfo_array").size() > 1)) {
        return true;
      }
      ForwardFileInfo localForwardFileInfo = a();
      String str2 = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
      String str1;
      if (localForwardFileInfo != null) {
        str1 = localForwardFileInfo.d();
      } else {
        str1 = this.jdField_j_of_type_JavaLangString;
      }
      if (str2.equals(str1)) {
        return true;
      }
      if (localForwardFileInfo != null) {
        str1 = localForwardFileInfo.a();
      } else {
        str1 = this.jdField_i_of_type_JavaLangString;
      }
      int i = str1.lastIndexOf('/');
      Object localObject;
      if ((i > -1) && (i < str1.length()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str1.substring(0, i + 1));
        ((StringBuilder)localObject).append(str2);
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = "";
      }
      if (a(str1, (String)localObject))
      {
        if (localForwardFileInfo != null)
        {
          localForwardFileInfo.d(str2);
          localForwardFileInfo.a((String)localObject);
          localForwardFileInfo.b(10000);
          this.jdField_a_of_type_AndroidOsBundle.putParcelable("fileinfo", localForwardFileInfo);
        }
        this.jdField_a_of_type_AndroidOsBundle.putString("forward_filepath", (String)localObject);
        this.jdField_a_of_type_AndroidContentIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
        return true;
      }
      b(-1);
      return false;
    }
    return true;
  }
  
  protected void B()
  {
    String str1 = f();
    if (!TextUtils.isEmpty(str1))
    {
      String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      int i = FileManagerUtil.a(str1);
      Object localObject;
      if (i == 2)
      {
        localObject = DeviceMsgHandle.b;
      }
      else
      {
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
      DeviceMsgHandle localDeviceMsgHandle = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(str1);
      localDeviceMsgHandle.a().a((String)localObject, str2, localArrayList, null);
    }
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  protected View a()
  {
    Object localObject = a();
    int i = AIOUtils.b(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i1 = AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    AIOUtils.b(14.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i2 = AIOUtils.b(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i3 = AIOUtils.b(16.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i4 = AIOUtils.b(18.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i5 = AIOUtils.b(20.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i6 = AIOUtils.b(32.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i7 = AIOUtils.b(40.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
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
    ((AnimationTextView)localObject).setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColorStateList(2131165694));
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("refresh forward preview,editPicPath:");
        localStringBuilder.append(paramIntent);
        localStringBuilder.append(" :currentFile");
        localStringBuilder.append((String)localObject);
        QLog.d("ForwardOption.ForwardFileOption", 2, localStringBuilder.toString());
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
      DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, this.jdField_a_of_type_AndroidAppActivity.getString(2131697670), this.jdField_a_of_type_AndroidAppActivity.getString(2131697623), null, this.jdField_a_of_type_AndroidAppActivity.getString(2131719788), new ForwardFileOption.1(this), null).show();
      return;
    }
    super.a(paramInt, paramBundle);
  }
  
  protected void a(Intent paramIntent)
  {
    ArrayList localArrayList1 = this.jdField_a_of_type_AndroidOsBundle.getParcelableArrayList("fileinfo_array");
    Object localObject1 = null;
    if (localArrayList1 != null) {}
    try
    {
      localArrayList1 = (ArrayList)localArrayList1;
    }
    catch (ClassCastException localClassCastException)
    {
      label29:
      ArrayList localArrayList2;
      Object localObject2;
      int i;
      break label29;
    }
    localArrayList1 = null;
    localArrayList2 = (ArrayList)this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
    if (localArrayList2.size() > 1)
    {
      if (localArrayList1 == null)
      {
        localObject2 = new ArrayList();
        i = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (i >= localArrayList2.size()) {
            break;
          }
          localObject1 = (Uri)localArrayList2.get(i);
          ((ArrayList)localObject2).add(a(this.jdField_a_of_type_AndroidAppActivity, (Uri)localObject1));
          i += 1;
        }
      }
    }
    else
    {
      if (!u()) {
        return;
      }
      localObject2 = a();
      if (localObject2 != null)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).add(((ForwardFileInfo)localObject2).a());
      }
    }
    paramIntent.putExtra("dataline_forward_type", 100);
    paramIntent.putExtra("sendMultiple", true);
    if (localArrayList1 == null) {
      paramIntent.putStringArrayListExtra("dataline_forward_pathlist", (ArrayList)localObject1);
    }
  }
  
  public boolean a()
  {
    super.a();
    Object localObject = this.jdField_a_of_type_AndroidContentIntent;
    boolean bool2 = false;
    this.e = ((Intent)localObject).getBooleanExtra("forward _key_nojump", false);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.d();
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a();
      boolean bool3 = TextUtils.isEmpty((CharSequence)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() == 10006) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.jdField_k_of_type_Boolean = bool1;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() == 10009) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.l = bool1;
      if (i == 2) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.o = bool1;
      boolean bool1 = bool2;
      if ((bool3 ^ true)) {
        if (i != 3)
        {
          bool1 = bool2;
          if (!FileUtils.fileExists((String)localObject)) {}
        }
        else
        {
          bool1 = true;
        }
      }
      this.jdField_j_of_type_Boolean = bool1;
    }
    else if (this.jdField_c_of_type_JavaUtilArrayList != null)
    {
      this.l = true;
      localObject = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      ForwardFileInfo localForwardFileInfo;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localForwardFileInfo = (ForwardFileInfo)((Iterator)localObject).next();
      } while ((localForwardFileInfo == null) || (localForwardFileInfo.d() == 6));
      this.l = false;
    }
    else if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false))
    {
      this.jdField_j_of_type_Boolean = true;
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", this.jdField_a_of_type_AndroidAppActivity.getString(2131719442));
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo == null) && (TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))) {
      e();
    }
    return true;
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    ArrayList localArrayList = new ArrayList();
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    int i1 = paramArrayOfDeviceInfo.length;
    int i = 0;
    while (i < i1)
    {
      DeviceInfo localDeviceInfo = paramArrayOfDeviceInfo[i];
      if (localDeviceInfo != null)
      {
        int i2 = FileManagerUtil.a(f());
        ProductInfo localProductInfo = localSmartDeviceProxyMgr.a(localDeviceInfo.productId);
        if (((i2 != 2) || (!localSmartDeviceProxyMgr.c(localDeviceInfo.din)) || (!localSmartDeviceProxyMgr.a(localDeviceInfo.din, 17))) && (localProductInfo != null) && (localProductInfo.isSupportMainMsgType(8)) && (a(jdField_j_of_type_JavaLangInteger))) {
          localArrayList.add(localDeviceInfo);
        }
      }
      i += 1;
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
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() != 10006) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() != 10003) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() != 10002)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b();
    }
    if (q()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_c_of_type_JavaLangInteger);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null)
    {
      if (DataLineHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b())))
      {
        this.jdField_a_of_type_JavaUtilSet.add(jdField_f_of_type_JavaLangInteger);
        this.jdField_a_of_type_JavaUtilSet.add(jdField_k_of_type_JavaLangInteger);
      }
    }
    else if (this.jdField_c_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      ForwardFileInfo localForwardFileInfo;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localForwardFileInfo = (ForwardFileInfo)localIterator.next();
      } while ((localForwardFileInfo == null) || (!DataLineHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(localForwardFileInfo.b()))));
      this.jdField_a_of_type_JavaUtilSet.add(jdField_f_of_type_JavaLangInteger);
      this.jdField_a_of_type_JavaUtilSet.add(jdField_k_of_type_JavaLangInteger);
    }
    else
    {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_f_of_type_JavaLangInteger);
      this.jdField_a_of_type_JavaUtilSet.add(jdField_k_of_type_JavaLangInteger);
    }
    if ((this.jdField_a_of_type_AndroidContentIntent != null) && (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromFavorites", false))) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_f_of_type_JavaLangInteger);
    }
    if ((this.jdField_a_of_type_AndroidContentIntent != null) && (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_smartdevice", true)) && (s()) && (a(FileManagerUtil.a(f())))) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_j_of_type_JavaLangInteger);
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
    Object localObject1;
    Intent localIntent;
    Object localObject2;
    if (j())
    {
      localObject1 = b();
      localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("fileoption realForwardTo isfromshare=");
        ((StringBuilder)localObject2).append(bool);
        QLog.d("forward", 2, ((StringBuilder)localObject2).toString());
      }
      if (bool)
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", HardCodeUtil.a(2131704852));
        localIntent.addFlags(268435456);
        localIntent.addFlags(67108864);
        localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
        bool = a(localIntent);
        if (this.jdField_f_of_type_Boolean)
        {
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
          if ((QSecFramework.a().a(1003).booleanValue()) && (this.jdField_j_of_type_Boolean))
          {
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (ResultRecord)((Iterator)localObject1).next();
              SecShareInfoUtil.a().a(4, f(), ((ResultRecord)localObject2).getUinType(), ((ResultRecord)localObject2).uin);
              SecShareInfoUtil.a().a();
            }
          }
        }
        else if (!bool)
        {
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
        }
      }
      else if (!this.e)
      {
        localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
        ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
      }
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    }
    for (;;)
    {
      return false;
      int i = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      if (i == 1008)
      {
        localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class);
        localIntent.putExtra("chat_subType", ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).getPublicAccountAioClass((String)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      }
      else
      {
        localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("fileoption realForwardTo isfromshare=");
        ((StringBuilder)localObject2).append(bool);
        QLog.d("forward", 2, ((StringBuilder)localObject2).toString());
      }
      if (bool)
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", HardCodeUtil.a(2131704851));
        localIntent.addFlags(268435456);
        localIntent.addFlags(67108864);
        localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
        bool = a(localIntent);
        if (this.jdField_f_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
          if ((QSecFramework.a().a(1003).booleanValue()) && (this.jdField_j_of_type_Boolean))
          {
            SecShareInfoUtil.a().a(4, f(), i, (String)localObject1);
            SecShareInfoUtil.a().a();
          }
        }
        else if (!bool)
        {
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
        }
      }
      else if (!this.e)
      {
        localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
        ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
      }
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
  }
  
  protected int d()
  {
    FileManagerEntity localFileManagerEntity = jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    int i = 0;
    if (localFileManagerEntity != null)
    {
      if (new QfavBuilder(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, jdField_a_of_type_ComTencentMobileqqDataChatMessage, true))
      {
        jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
        break label109;
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null)
    {
      localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b());
      if ((localFileManagerEntity != null) && (new QfavBuilder(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, null, true)))
      {
        jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
        break label109;
      }
    }
    i = -1;
    label109:
    if (i == 0) {
      QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_AddFav", -1, 0, 69, 0, "", "");
    }
    return i;
  }
  
  protected String e()
  {
    return this.jdField_a_of_type_AndroidContentContext.getString(2131719013);
  }
  
  protected boolean m()
  {
    return true;
  }
  
  protected void w()
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog = new ForwardNewVersionDialog(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog.a(2131560812);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = ((QQCustomDialog)localObject);
    ((ForwardNewVersionDialog)localObject).a(i() ^ true);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardFileOption
 * JD-Core Version:    0.7.0.1
 */