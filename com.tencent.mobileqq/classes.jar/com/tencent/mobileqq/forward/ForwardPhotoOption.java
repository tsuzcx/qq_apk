package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.NativeGifImage;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.SendMultiPictureHelper;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.emotionintegrate.SearchEmoticonFragment;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ForwardSendPicUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mqp.app.sec.SecShareInfoUtil;
import com.tencent.open.sdk.report.SdkShareReporter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.util.AutoSaveUtils;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

public class ForwardPhotoOption
  extends ForwardFileBaseOption
{
  SendMultiPictureHelper jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper;
  private ForwardPhotoOption.ContentViewHolder jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$ContentViewHolder;
  private boolean j;
  
  public ForwardPhotoOption(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_j_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 6;
  }
  
  private File a()
  {
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.jdField_b_of_type_JavaLangString;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initPreviewImagePath p: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("ForwardOption.ForwardPhotoOption", 2, ((StringBuilder)localObject2).toString());
    }
    boolean bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean(SearchEmoticonFragment.jdField_a_of_type_JavaLangString, false);
    if ((localObject1 != null) && (((String)localObject1).length() > 4) && ((".gif".equals(((String)localObject1).substring(((String)localObject1).length() - 4, ((String)localObject1).length()))) || (bool)))
    {
      localObject1 = new File((String)localObject1);
      if (((File)localObject1).exists()) {
        return localObject1;
      }
    }
    return null;
  }
  
  private File a(Parcelable paramParcelable)
  {
    boolean bool = paramParcelable instanceof MessageForPic;
    Object localObject2 = null;
    Object localObject1;
    if (bool)
    {
      paramParcelable = (MessageForPic)paramParcelable;
      if (paramParcelable.imageType != 3)
      {
        localObject1 = localObject2;
        if (paramParcelable.imageType != 2000) {}
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardPhotoOption", 2, "initPreviewImage msgPic gif.");
        }
        return AbsDownloader.getFile(URLDrawableHelper.getURL(paramParcelable, 1, null).toString());
      }
    }
    else if ((paramParcelable instanceof AIOImageData))
    {
      paramParcelable = (AIOImageData)paramParcelable;
      if (paramParcelable.jdField_a_of_type_Int != 3)
      {
        localObject1 = localObject2;
        if (paramParcelable.jdField_a_of_type_Int != 2000) {}
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardPhotoOption", 2, "initPreviewImage AIOImageData gif");
        }
        if (paramParcelable.a(2)) {
          paramParcelable = paramParcelable.a(2);
        } else if (paramParcelable.a(4)) {
          paramParcelable = paramParcelable.a(4);
        } else {
          paramParcelable = null;
        }
        localObject1 = localObject2;
        if (paramParcelable != null)
        {
          localObject1 = localObject2;
          if (paramParcelable.exists()) {
            return paramParcelable;
          }
        }
      }
    }
    else
    {
      localObject1 = a();
    }
    return localObject1;
  }
  
  private void a(String paramString1, String paramString2, int paramInt, String paramString3, boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentIntent;
    int k = 0;
    if (((Intent)localObject1).getBooleanExtra("isFromShare", false)) {
      this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", HardCodeUtil.a(2131704871));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper = new SendMultiPictureHelper((BaseActivity)this.jdField_a_of_type_AndroidAppActivity);
    }
    ArrayList localArrayList = this.jdField_a_of_type_AndroidOsBundle.getStringArrayList("foward_key_m_p_l");
    localObject1 = localArrayList;
    int i;
    if (localArrayList == null)
    {
      Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
      localObject1 = localArrayList;
      if (localObject2 != null)
      {
        localObject1 = localArrayList;
        if ((localObject2 instanceof ArrayList))
        {
          localObject2 = (ArrayList)localObject2;
          localArrayList = new ArrayList();
          i = 0;
          for (;;)
          {
            localObject1 = localArrayList;
            if (i >= ((ArrayList)localObject2).size()) {
              break;
            }
            localObject1 = a((Uri)((ArrayList)localObject2).get(i));
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              localArrayList.add(localObject1);
            }
            i += 1;
          }
        }
      }
    }
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper.a(paramString1, paramString2, paramInt, paramString3, this.jdField_a_of_type_AndroidOsBundle, (ArrayList)localObject1);
      if ((QSecFramework.a().a(1003).booleanValue()) && (paramBoolean) && (this.jdField_f_of_type_Boolean))
      {
        i = k;
        while (i < ((ArrayList)localObject1).size())
        {
          SecShareInfoUtil.a().a(3, (String)((ArrayList)localObject1).get(i), paramInt, paramString2);
          i += 1;
        }
        SecShareInfoUtil.a().a();
      }
    }
    else
    {
      QQToast.a(BaseApplication.getContext(), 1, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718739), 0).a();
    }
  }
  
  private void a(List<ResultRecord> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false)) {
      this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", HardCodeUtil.a(2131704864));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper = new SendMultiPictureHelper((BaseActivity)this.jdField_a_of_type_AndroidAppActivity);
    }
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getStringArrayList("foward_key_m_p_l");
    Object localObject1 = localObject2;
    int i;
    if (localObject2 == null)
    {
      Object localObject3 = this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if ((localObject3 instanceof ArrayList))
        {
          localObject3 = (ArrayList)localObject3;
          localObject2 = new ArrayList();
          i = 0;
          for (;;)
          {
            localObject1 = localObject2;
            if (i >= ((ArrayList)localObject3).size()) {
              break;
            }
            localObject1 = a((Uri)((ArrayList)localObject3).get(i));
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              ((ArrayList)localObject2).add(localObject1);
            }
            i += 1;
          }
        }
      }
    }
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0)) {
      paramList = paramList.iterator();
    }
    while (paramList.hasNext())
    {
      localObject2 = (ResultRecord)paramList.next();
      this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper.a(((ResultRecord)localObject2).groupUin, ((ResultRecord)localObject2).uin, ((ResultRecord)localObject2).getUinType(), ((ResultRecord)localObject2).name, this.jdField_a_of_type_AndroidOsBundle, (ArrayList)localObject1);
      if ((QSecFramework.a().a(1003).booleanValue()) && (paramBoolean) && (this.jdField_f_of_type_Boolean))
      {
        i = 0;
        while (i < ((ArrayList)localObject1).size())
        {
          SecShareInfoUtil.a().a(3, (String)((ArrayList)localObject1).get(i), ((ResultRecord)localObject2).getUinType(), ((ResultRecord)localObject2).uin);
          i += 1;
        }
        SecShareInfoUtil.a().a();
        continue;
        QQToast.a(BaseApplication.getContext(), 1, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718739), 0).a();
      }
    }
  }
  
  private String b(Uri paramUri)
  {
    String str = paramUri.getScheme();
    if ((str != null) && (!str.equals("file")))
    {
      if (str.equals("content")) {
        try
        {
          paramUri = this.jdField_a_of_type_AndroidAppActivity.getContentResolver().query(paramUri, new String[] { "_data" }, null, null, null);
          int i = paramUri.getColumnIndexOrThrow("_data");
          paramUri.moveToFirst();
          str = paramUri.getString(i);
          paramUri.close();
          return str;
        }
        catch (Exception paramUri)
        {
          paramUri.printStackTrace();
        }
      }
      return null;
    }
    return new File(paramUri.getPath()).getAbsolutePath();
  }
  
  private void e()
  {
    Object localObject2 = a(this.jdField_a_of_type_AndroidOsBundle.getParcelable("FORWARD_MSG_FOR_PIC"));
    if (localObject2 != null) {
      for (;;)
      {
        try
        {
          localObject1 = NativeGifImage.getImageSize((File)localObject2, false);
          try
          {
            URL localURL1 = ((File)localObject2).toURI().toURL();
            i = 1;
          }
          catch (OutOfMemoryError localOutOfMemoryError2) {}catch (IOException localIOException1) {}
          localIOException2.printStackTrace();
        }
        catch (OutOfMemoryError localOutOfMemoryError3)
        {
          localObject1 = null;
          localObject2 = localObject1;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getImageSize oom ");
            ((StringBuilder)localObject2).append(localOutOfMemoryError3.toString());
            QLog.d("ForwardOption.ForwardPhotoOption", 2, ((StringBuilder)localObject2).toString());
            localObject2 = localObject1;
          }
        }
        catch (IOException localIOException2)
        {
          localObject1 = null;
        }
        localObject2 = localObject1;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getImageSize ");
          ((StringBuilder)localObject2).append(localIOException2.toString());
          QLog.d("ForwardOption.ForwardPhotoOption", 2, ((StringBuilder)localObject2).toString());
          localObject2 = localObject1;
        }
      }
    }
    localObject2 = null;
    URL localURL2 = null;
    int i = 0;
    Object localObject1 = localObject2;
    if (i != 0) {
      this.jdField_b_of_type_Int = 5;
    }
    if (!PicItemBuilder.h) {
      i = 0;
    }
    if (i == 0)
    {
      b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog);
      ThreadManager.getSubThreadHandler().postDelayed(new ForwardPhotoOption.PhotoRunnable(this.jdField_a_of_type_AndroidAppActivity), 1000L);
      return;
    }
    if ((localObject1 != null) && (localURL2 != null))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("initPreviewImagePath load gif start ");
        ((StringBuilder)localObject2).append(localURL2.toString());
        QLog.d("ForwardOption.ForwardPhotoOption", 2, ((StringBuilder)localObject2).toString());
      }
      int k = ((Rect)localObject1).width();
      i = ((Rect)localObject1).height();
      float f = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().densityDpi / 160;
      k = (int)(k * f);
      i = (int)(i * f);
      try
      {
        localObject1 = URLDrawableHelper.getDrawable(localURL2, k, i, new EmptyDrawable(k, i), URLDrawableHelper.getFailedDrawable(), true);
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$ContentViewHolder.a((Drawable)localObject1, true, 0, true);
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$ContentViewHolder.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(new ForwardPhotoOption.2(this));
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initPreviewImage_getDrawable oom ");
      ((StringBuilder)localObject2).append(localOutOfMemoryError1.toString());
      QLog.d("ForwardOption.ForwardPhotoOption", 2, ((StringBuilder)localObject2).toString());
    }
    else
    {
      b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog);
    }
  }
  
  private boolean u()
  {
    Object localObject1 = b();
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
    Object localObject2 = Boolean.valueOf(this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendMultiple", false));
    boolean bool4 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false);
    boolean bool1 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isJumpAIO", false);
    boolean bool2 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_shoot_quick", false);
    boolean bool3 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_pre_guide", false);
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("ForwardPhotoOption realForwardTo isSendMultiple=");
      ((StringBuilder)localObject3).append(localObject2);
      ((StringBuilder)localObject3).append("isFromShare=");
      ((StringBuilder)localObject3).append(bool4);
      QLog.d("forward", 2, ((StringBuilder)localObject3).toString());
    }
    if (((Boolean)localObject2).booleanValue())
    {
      a((List)localObject1, bool4);
      return true;
    }
    localObject2 = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
    ((Intent)localObject2).putExtra("KEY_MSG_FORWARD_ID", this.jdField_a_of_type_AndroidOsBundle.getInt("KEY_MSG_FORWARD_ID", 0));
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() == 10011))
    {
      ((Intent)localObject2).putExtras(this.jdField_a_of_type_AndroidOsBundle);
      ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, (Intent)localObject2, null);
    }
    else if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() == 10012))
    {
      ((Intent)localObject2).addFlags(268435456);
      ((Intent)localObject2).addFlags(67108864);
      ((Intent)localObject2).putExtras(this.jdField_a_of_type_AndroidOsBundle);
      ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, (Intent)localObject2, null);
    }
    else if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("key_help_forward_pic", false))
    {
      ((Intent)localObject2).putExtras(this.jdField_a_of_type_AndroidOsBundle);
      ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, (Intent)localObject2, null);
    }
    else
    {
      if (bool4)
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", HardCodeUtil.a(2131704867));
        ((Intent)localObject2).addFlags(268435456);
        ((Intent)localObject2).addFlags(67108864);
        ((Intent)localObject2).putExtras(this.jdField_a_of_type_AndroidOsBundle);
        bool4 = a((Intent)localObject2);
        boolean bool5 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromFavorites");
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("ForwardPhotoOption realForwardTo isFromFav=");
          ((StringBuilder)localObject3).append(bool5);
          ((StringBuilder)localObject3).append("isFromAIOFav=");
          ((StringBuilder)localObject3).append(bool4);
          QLog.d("forward", 2, ((StringBuilder)localObject3).toString());
        }
        if (this.jdField_f_of_type_Boolean)
        {
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, (Intent)localObject2, null);
          if (QSecFramework.a().a(1003).booleanValue())
          {
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (ResultRecord)((Iterator)localObject1).next();
              SecShareInfoUtil.a().a(3, this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath"), ((ResultRecord)localObject3).getUinType(), ((ResultRecord)localObject3).uin);
              SecShareInfoUtil.a().a();
            }
          }
        }
        else if (!bool1)
        {
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, (Intent)localObject2, null);
        }
      }
      this.jdField_a_of_type_AndroidOsBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("forward_source_uin_type", -1));
      ((Intent)localObject2).putExtras(this.jdField_a_of_type_AndroidOsBundle);
      if ((bool2) || (bool3))
      {
        ((Intent)localObject2).removeExtra("forward_filepath");
        ((Intent)localObject2).removeExtra("forward_extra");
        this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
      }
    }
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, (Intent)localObject2);
    return false;
  }
  
  protected void B()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentIntent;
    boolean bool2 = false;
    Object localObject2;
    if (((Intent)localObject1).getBooleanExtra("key_flag_from_plugin", false))
    {
      localObject1 = this.jdField_b_of_type_JavaLangString;
    }
    else
    {
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_extra");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_extra");
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_filepath");
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("GALLERY.FORWORD_LOCAL_PATH");
      }
      this.jdField_a_of_type_AndroidOsBundle.putString("forward_filepath", (String)localObject2);
      localObject1 = localObject2;
    }
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty(FileUtil.a((String)localObject1)))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(AppConstants.SDCARD_PATH);
        ((StringBuilder)localObject2).append("photo/");
        ((StringBuilder)localObject2).append(String.valueOf(System.currentTimeMillis()));
        ((StringBuilder)localObject2).append(".jpg");
        localObject2 = ((StringBuilder)localObject2).toString();
        FileUtils.copyFile((String)localObject1, (String)localObject2);
      }
      localObject1 = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localObject2);
      SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
      boolean bool1 = bool2;
      if (localSmartDeviceProxyMgr.c(Long.parseLong(str)))
      {
        bool1 = bool2;
        if (localSmartDeviceProxyMgr.a(Long.parseLong(str), 17)) {
          bool1 = true;
        }
      }
      if (!Boolean.valueOf(bool1).booleanValue())
      {
        ((DeviceMsgHandle)localObject1).a().a(DeviceMsgHandle.d, str, localArrayList);
      }
      else
      {
        localSmartDeviceProxyMgr.a(Long.parseLong(str), "", "", "", 0, null);
        super.a((String)localObject2, str, "pic");
        return;
      }
    }
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  protected void C()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("forward_to_someplace_from_shoot_quick", 1003);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007816", "0X8007816", 0, 0, "", "", "", "");
    StoryReportor.a("plus_shoot", "send_tip", 0, 0, new String[] { "", "", "", "" });
  }
  
  protected View a()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131558974, null);
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$ContentViewHolder = new ForwardPhotoOption.ContentViewHolder(null);
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$ContentViewHolder.b = ((TextView)localView.findViewById(2131365994));
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$ContentViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131373032));
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$ContentViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131367217));
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$ContentViewHolder.jdField_a_of_type_AndroidViewView = localView.findViewById(2131367216);
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$ContentViewHolder.c = ((TextView)localView.findViewById(2131365629));
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$ContentViewHolder.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131365672));
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$ContentViewHolder.jdField_a_of_type_AndroidViewView.setMinimumHeight(ViewUtils.a(85.0F));
    int i = ViewUtils.a(15.0F);
    localView.setPadding(0, i, 0, i);
    e();
    ArrayList localArrayList = this.jdField_a_of_type_AndroidOsBundle.getStringArrayList("foward_key_m_p_l");
    if (localArrayList != null)
    {
      TextView localTextView = (TextView)localView.findViewById(2131365644);
      localTextView.setVisibility(0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131704868));
      localStringBuilder.append(localArrayList.size());
      localStringBuilder.append(HardCodeUtil.a(2131704865));
      localTextView.setText(localStringBuilder.toString());
    }
    return localView;
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("forward_source_uin_type", 0) == 9501) {
      return localArrayList;
    }
    int i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("key_new_img_shareactionsheet", 0);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!Utils.a(localRecentUser.uin)) && (localRecentUser.getType() != 1003) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1021) && (localRecentUser.getType() != 10004) && ((localRecentUser.getType() != 1) || (!a(localRecentUser.uin))) && ((localRecentUser.getType() != 1006) || (a(ForwardAbility.ForwardAbilityType.jdField_h_of_type_JavaLangInteger))) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 6004) && (localRecentUser.getType() != 9501) && ((localRecentUser.getType() != 0) || (!CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.getType()))) && (((localRecentUser.getType() != 1004) && (localRecentUser.getType() != 1000)) || (this.jdField_b_of_type_Boolean)))
      {
        localArrayList.add(localRecentUser);
      }
      else if ((localRecentUser != null) && (localRecentUser.uin.equalsIgnoreCase(AppConstants.DATALINE_PC_UIN)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getForwardRecentList uin = ");
        localStringBuilder.append(localRecentUser.uin);
        localStringBuilder.append("  | fromNewImgType = ");
        localStringBuilder.append(i);
        QLog.d("ForwardOption.ForwardPhotoOption", 2, localStringBuilder.toString());
        if (i == 1) {
          localArrayList.add(localRecentUser);
        }
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    H();
    boolean bool2 = this.jdField_d_of_type_Boolean;
    boolean bool1 = false;
    if (bool2)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
      this.jdField_d_of_type_Boolean = false;
    }
    if (j())
    {
      Object localObject1 = b();
      Object localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject2).next();
        b(localResultRecord.uin, localResultRecord.groupUin, localResultRecord.getUinType());
      }
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_flag_from_plugin", false))
      {
        int k = this.jdField_a_of_type_AndroidOsBundle.getInt("KEY_MSG_FORWARD_ID", 0);
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ResultRecord)((Iterator)localObject1).next();
          bool1 |= ForwardSendPicUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, ((ResultRecord)localObject2).uin, ((ResultRecord)localObject2).getUinType(), ((ResultRecord)localObject2).groupUin, true, this.jdField_a_of_type_AndroidAppActivity, k);
        }
        if (bool1) {
          this.jdField_a_of_type_AndroidAppActivity.setResult(-1);
        }
      }
      else
      {
        y();
      }
    }
    else
    {
      super.s();
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_flag_from_plugin", false))
      {
        int i = this.jdField_a_of_type_AndroidOsBundle.getInt("KEY_MSG_FORWARD_ID", 0);
        if (ForwardSendPicUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle.getString("uin"), this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"), this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin"), true, this.jdField_a_of_type_AndroidAppActivity, i)) {
          this.jdField_a_of_type_AndroidAppActivity.setResult(-1);
        }
        this.jdField_a_of_type_AndroidAppActivity.finish();
        return;
      }
      y();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 19001) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      String str = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("refresh forward preview,editPicPath:");
        localStringBuilder.append(paramIntent);
        localStringBuilder.append(" :currentFile");
        localStringBuilder.append(str);
        QLog.d("ForwardOption.ForwardPhotoOption", 2, localStringBuilder.toString());
      }
      if (!str.equals(paramIntent))
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidOsBundle.remove("FORWARD_MSG_FOR_PIC");
        this.jdField_a_of_type_AndroidOsBundle.putString("forward_filepath", paramIntent);
        this.jdField_a_of_type_AndroidOsBundle.putString("forward_extra", paramIntent);
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("extra_is_edited_pic", true);
        d(paramIntent);
        b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog);
      }
    }
  }
  
  protected void a(Intent paramIntent)
  {
    ArrayList localArrayList3 = this.jdField_a_of_type_AndroidOsBundle.getParcelableArrayList("fileinfo_array");
    localArrayList2 = null;
    Object localObject = localArrayList2;
    if (localArrayList3 != null) {}
    try
    {
      localObject = (ArrayList)localArrayList3;
    }
    catch (ClassCastException localClassCastException)
    {
      for (;;)
      {
        int i;
        ArrayList localArrayList1 = localArrayList2;
      }
    }
    localArrayList3 = (ArrayList)this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
    if (localObject == null)
    {
      localArrayList2 = this.jdField_a_of_type_AndroidOsBundle.getStringArrayList("foward_key_m_p_l");
      if (localArrayList2 != null)
      {
        localObject = localArrayList2;
        if (!localArrayList2.isEmpty()) {}
      }
      else
      {
        localArrayList2 = new ArrayList();
        i = 0;
        for (;;)
        {
          localObject = localArrayList2;
          if (i >= localArrayList3.size()) {
            break;
          }
          localObject = (Uri)localArrayList3.get(i);
          localArrayList2.add(a(this.jdField_a_of_type_AndroidAppActivity, (Uri)localObject));
          i += 1;
        }
      }
      paramIntent.putStringArrayListExtra("dataline_forward_pathlist", (ArrayList)localObject);
    }
    paramIntent.putExtra("dataline_forward_type", 101);
    paramIntent.putExtra("sendMultiple", true);
  }
  
  protected void a(Drawable paramDrawable, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new ForwardPhotoOption.3(this, paramDrawable, paramBoolean1, paramInt));
  }
  
  protected void a(Bundle paramBundle, AIOImageProviderService paramAIOImageProviderService, AIORichMediaData paramAIORichMediaData)
  {
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("key_allow_forward_photo_preview_edit", false)) {
      paramBundle.putBoolean("key_allow_forward_photo_preview_edit", true);
    }
    super.a(paramBundle, paramAIOImageProviderService, paramAIORichMediaData);
  }
  
  public boolean a()
  {
    super.a();
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
    }
    Object localObject1 = this.jdField_a_of_type_AndroidContentIntent;
    int i = 0;
    if ((((Intent)localObject1).getBooleanExtra("sendMultiple", false)) && (this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("foward_key_m_p_l") == null))
    {
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
      if ((localObject1 != null) && ((localObject1 instanceof ArrayList)))
      {
        localObject1 = (ArrayList)localObject1;
        ArrayList localArrayList = new ArrayList();
        while (i < ((ArrayList)localObject1).size())
        {
          Object localObject2 = (Uri)((ArrayList)localObject1).get(i);
          if (localObject2 != null)
          {
            localObject2 = a((Uri)localObject2);
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              localArrayList.add(localObject2);
            }
          }
          i += 1;
        }
        this.jdField_a_of_type_AndroidOsBundle.putStringArrayList("foward_key_m_p_l", localArrayList);
      }
    }
    return true;
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    ArrayList localArrayList = new ArrayList();
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    int k = paramArrayOfDeviceInfo.length;
    int i = 0;
    while (i < k)
    {
      DeviceInfo localDeviceInfo = paramArrayOfDeviceInfo[i];
      if (localDeviceInfo != null)
      {
        ProductInfo localProductInfo = localSmartDeviceProxyMgr.a(localDeviceInfo.productId);
        if ((localProductInfo != null) && (localProductInfo.isSupportFuncMsgType(1)) && (a(jdField_j_of_type_JavaLangInteger))) {
          localArrayList.add(localDeviceInfo);
        }
      }
      i += 1;
    }
    return (DeviceInfo[])localArrayList.toArray(new DeviceInfo[localArrayList.size()]);
  }
  
  protected void b()
  {
    if (r()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
    if (p()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_d_of_type_JavaLangInteger);
    }
    if (q()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    this.jdField_a_of_type_JavaUtilSet.add(i);
    boolean bool1 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_phonecontacts", true);
    if (((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() != 10006)) && (o()) && (bool1)) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_h_of_type_JavaLangInteger);
    }
    bool1 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_dataline", true);
    boolean bool2 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_is_selfie_face", false);
    if ((bool1) && (!bool2))
    {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_f_of_type_JavaLangInteger);
      this.jdField_a_of_type_JavaUtilSet.add(k);
    }
    if ((this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_smartdevice", true)) && (s())) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_j_of_type_JavaLangInteger);
    }
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_qzone", false)) {
      this.jdField_a_of_type_JavaUtilSet.add(e);
    }
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_qqstory", false)) {
      this.jdField_a_of_type_JavaUtilSet.add(m);
    }
  }
  
  public void b(int paramInt)
  {
    Bundle localBundle = new Bundle();
    String str1 = AppConstants.DATALINE_PC_UIN;
    if (paramInt == k.intValue()) {
      str1 = AppConstants.DATALINE_IPAD_UIN;
    }
    localBundle.putAll(this.jdField_a_of_type_AndroidOsBundle);
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_flag_from_plugin", false))
    {
      LiteActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity);
      String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("caller_name");
      paramInt = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("forward_type", 2147483647);
      String str3 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_filepath");
      if ((("QQBrowserActivity".equals(str2)) || ("PublicAccountBrowser".equals(str2))) && (paramInt == 1) && (!TextUtils.isEmpty(str3))) {
        this.jdField_a_of_type_AndroidAppActivity.setResult(-1);
      } else {
        this.jdField_a_of_type_AndroidAppActivity.setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
      }
      a(localBundle, str1, null);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
    }
    super.b(paramInt);
  }
  
  protected void b(Intent paramIntent)
  {
    paramIntent.putExtra("dataline_forward_type", 101);
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_extra");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_extra");
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_filepath");
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("GALLERY.FORWORD_LOCAL_PATH");
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("sendDatalineSingle filePath: ");
    ((StringBuilder)localObject1).append((String)localObject2);
    QLog.d("ForwardOption.ForwardPhotoOption", 1, ((StringBuilder)localObject1).toString());
    paramIntent.putExtra("filepath_copy", this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("filepath_copy", false));
    paramIntent.putExtra("dataline_forward_path", (String)localObject2);
    AutoSaveUtils.a(true, (String)localObject2);
  }
  
  protected void b(String paramString)
  {
    ArrayList localArrayList = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007815", "0X8007815", 0, 0, "", "", "", "");
      QZoneHelper.publishPictureMoodSilently(paramString, localArrayList, "source_from_quick_shoot");
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("content:");
      localStringBuilder.append(paramString);
      localStringBuilder.append("path:");
      localStringBuilder.append(localArrayList);
      QLog.d("ForwardOption.ForwardPhotoOption", 2, localStringBuilder.toString());
    }
    paramString = new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
    paramString.setFlags(67108864);
    paramString.putExtra("main_tab_id", 4);
    paramString.putExtra("fragment_id", 1);
    paramString.putExtra("switch_anim", true);
    paramString.putExtra("forward_to_someplace_from_shoot_quick", 1002);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, paramString);
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public boolean b()
  {
    return true;
  }
  
  protected boolean b(String paramString1, String paramString2, int paramInt)
  {
    boolean bool1 = super.b(paramString1, paramString2, paramInt);
    boolean bool2 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false);
    boolean bool3 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendMultiple", false);
    if ((bool2) && (bool3))
    {
      SessionInfo localSessionInfo = new SessionInfo();
      localSessionInfo.jdField_a_of_type_Int = paramInt;
      localSessionInfo.jdField_a_of_type_JavaLangString = paramString1;
      localSessionInfo.jdField_b_of_type_JavaLangString = paramString2;
      paramString1 = this.jdField_a_of_type_AndroidOsBundle.getString("share_comment_message");
      if ((paramString1 != null) && (!"".equals(paramString1))) {
        ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localSessionInfo, paramString1, null);
      }
    }
    return bool1;
  }
  
  protected int c()
  {
    return 2;
  }
  
  protected void c()
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(null);
    }
  }
  
  protected boolean c()
  {
    if (j()) {
      return u();
    }
    return d();
  }
  
  protected int d()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidOsBundle;
    int m = 0;
    if (((Bundle)localObject1).getBoolean("sendMultiple", false))
    {
      localObject1 = (ArrayList)this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("shareToQfav sendMultiple . size = ");
      ((StringBuilder)localObject2).append(((ArrayList)localObject1).size());
      QLog.i("Qfav", 1, ((StringBuilder)localObject2).toString());
      int i = 0;
      for (;;)
      {
        k = m;
        if (i >= ((ArrayList)localObject1).size()) {
          break label376;
        }
        if (!QfavBuilder.b(b((Uri)((ArrayList)localObject1).get(i))).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
          break;
        }
        i += 1;
      }
    }
    QLog.i("Qfav", 1, "shareToQfav single pic");
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a();
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("GALLERY.FORWORD_LOCAL_PATH");
    }
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.jdField_b_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      if (new File((String)localObject1).exists())
      {
        if (QfavBuilder.b((String)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null))
        {
          k = m;
          break label376;
        }
      }
      else if (QfavBuilder.a(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_photo_md5"), -1, this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_download_image_server_path"), this.jdField_a_of_type_AndroidContentIntent.getLongExtra("forward_photo_group_fileid", 0L), this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_extra"), this.jdField_a_of_type_AndroidContentIntent.getLongExtra("forward_file_size", 0L)).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null))
      {
        k = m;
        break label376;
      }
    }
    int k = -1;
    label376:
    if (k == 0) {
      QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_AddFav", -1, 0, 69, 0, "", "");
    }
    return k;
  }
  
  protected void d(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  boolean d()
  {
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("uinname");
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
    Boolean localBoolean = Boolean.valueOf(this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendMultiple", false));
    boolean bool4 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false);
    boolean bool1 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isJumpAIO", false);
    boolean bool2 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_shoot_quick", false);
    boolean bool3 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_pre_guide", false);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ForwardPhotoOption realForwardTo isSendMultiple=");
      localStringBuilder.append(localBoolean);
      localStringBuilder.append("isFromShare=");
      localStringBuilder.append(bool4);
      QLog.d("forward", 2, localStringBuilder.toString());
    }
    if (localBoolean.booleanValue())
    {
      a((String)localObject2, str, i, (String)localObject1, bool4);
      return true;
    }
    if (i == 1008)
    {
      localObject1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class);
      ((Intent)localObject1).putExtra("chat_subType", ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).getPublicAccountAioClass(str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    }
    else
    {
      localObject1 = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
    }
    AutoSaveUtils.a(true, this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath"));
    if (QFileAssistantUtils.a(str))
    {
      ForwardUtils.a(this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, str, i);
      this.jdField_a_of_type_AndroidOsBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("forward_source_uin_type", -1));
      ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
      ((Intent)localObject1).removeExtra("forward_filepath");
      ((Intent)localObject1).removeExtra("forward_extra");
      ((Intent)localObject1).putExtra("forward_type", 2147483647);
    }
    else if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() == 10011))
    {
      ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
      ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, null);
    }
    else if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() == 10012))
    {
      ((Intent)localObject1).addFlags(268435456);
      ((Intent)localObject1).addFlags(67108864);
      ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
      ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, null);
    }
    else if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("key_help_forward_pic", false))
    {
      ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
      ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, null);
    }
    else if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("key_share_from_screen_shot", false))
    {
      ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
      ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, null);
    }
    else
    {
      if (bool4)
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", HardCodeUtil.a(2131704869));
        ((Intent)localObject1).addFlags(268435456);
        ((Intent)localObject1).addFlags(67108864);
        ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
        bool4 = a((Intent)localObject1);
        boolean bool5 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromFavorites");
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("ForwardPhotoOption realForwardTo isFromFav=");
          ((StringBuilder)localObject2).append(bool5);
          ((StringBuilder)localObject2).append("isFromAIOFav=");
          ((StringBuilder)localObject2).append(bool4);
          QLog.d("forward", 2, ((StringBuilder)localObject2).toString());
        }
        if (this.jdField_f_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject1);
          if (QSecFramework.a().a(1003).booleanValue())
          {
            SecShareInfoUtil.a().a(3, this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath"), i, str);
            SecShareInfoUtil.a().a();
          }
        }
        else if (!bool1)
        {
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, null);
        }
      }
      this.jdField_a_of_type_AndroidOsBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("forward_source_uin_type", -1));
      ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
      if ((bool2) || (bool3))
      {
        if (i == 0) {
          str = "0X8007812";
        }
        for (;;)
        {
          break;
          if (i == 1) {
            str = "0X8007813";
          } else if (i == 3000) {
            str = "0X8007814";
          } else {
            str = "";
          }
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
        ((Intent)localObject1).removeExtra("forward_filepath");
        ((Intent)localObject1).removeExtra("forward_extra");
        this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject1);
      }
    }
    SdkShareReporter.a(this.jdField_a_of_type_AndroidContentIntent);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, (Intent)localObject1);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    return false;
  }
  
  protected String e()
  {
    if (jdField_h_of_type_JavaLangString == null) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131719022);
    }
    return jdField_h_of_type_JavaLangString;
  }
  
  public void l()
  {
    super.l();
    AbstractGifImage.pauseAll();
  }
  
  public void m()
  {
    super.m();
    AbstractGifImage.resumeAll();
  }
  
  protected boolean m()
  {
    return true;
  }
  
  public boolean n()
  {
    return this.jdField_a_of_type_AndroidOsBundle.getBoolean("key_allow_multiple_forward_from_limit", true);
  }
  
  protected void t()
  {
    super.t();
    int i = a().getInt("key_forward_ability_type");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("-->getCancelListener--onClick--type = ");
      localStringBuilder.append(i);
      QLog.d("ForwardOption.ForwardPhotoOption", 2, localStringBuilder.toString());
    }
    if (i == m.intValue()) {
      StoryReportor.a("plus_shoot", "nosend_tip", 0, 0, new String[] { "", "", "", "" });
    }
  }
  
  protected void u()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$ContentViewHolder != null)
    {
      View.OnClickListener localOnClickListener = a(new ForwardPhotoOption.1(this));
      if ((localOnClickListener != null) && (this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$ContentViewHolder.jdField_a_of_type_AndroidWidgetImageView != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$ContentViewHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(localOnClickListener);
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$ContentViewHolder.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131704870));
      }
    }
  }
  
  public void z()
  {
    super.z();
    SendMultiPictureHelper localSendMultiPictureHelper = this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper;
    if (localSendMultiPictureHelper != null) {
      localSendMultiPictureHelper.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPhotoOption
 * JD-Core Version:    0.7.0.1
 */