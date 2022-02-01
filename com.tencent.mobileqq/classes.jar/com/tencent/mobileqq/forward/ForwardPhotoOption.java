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
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
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
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
    Object localObject = str;
    if (str == null) {
      localObject = this.jdField_b_of_type_JavaLangString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardPhotoOption", 2, "initPreviewImagePath p: " + (String)localObject);
    }
    boolean bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean(SearchEmoticonFragment.jdField_a_of_type_JavaLangString, false);
    if ((localObject != null) && (((String)localObject).length() > 4) && ((".gif".equals(((String)localObject).substring(((String)localObject).length() - 4, ((String)localObject).length()))) || (bool)))
    {
      localObject = new File((String)localObject);
      if (((File)localObject).exists()) {
        return localObject;
      }
    }
    return null;
  }
  
  private File a(Parcelable paramParcelable)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((paramParcelable instanceof MessageForPic))
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
        localObject1 = AbsDownloader.getFile(URLDrawableHelper.getURL(paramParcelable, 1, null).toString());
      }
    }
    do
    {
      return localObject1;
      if (!(paramParcelable instanceof AIOImageData)) {
        break label157;
      }
      paramParcelable = (AIOImageData)paramParcelable;
      if (paramParcelable.jdField_a_of_type_Int == 3) {
        break;
      }
      localObject1 = localObject2;
    } while (paramParcelable.jdField_a_of_type_Int != 2000);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardPhotoOption", 2, "initPreviewImage AIOImageData gif");
    }
    if (paramParcelable.a(2)) {
      paramParcelable = paramParcelable.a(2);
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (paramParcelable == null) {
        break;
      }
      localObject1 = localObject2;
      if (!paramParcelable.exists()) {
        break;
      }
      return paramParcelable;
      if (paramParcelable.a(4))
      {
        paramParcelable = paramParcelable.a(4);
        continue;
        label157:
        return a();
      }
      else
      {
        paramParcelable = null;
      }
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt, String paramString3, boolean paramBoolean)
  {
    int k = 0;
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false)) {
      this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", HardCodeUtil.a(2131704795));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper = new SendMultiPictureHelper((BaseActivity)this.jdField_a_of_type_AndroidAppActivity);
    }
    ArrayList localArrayList = this.jdField_a_of_type_AndroidOsBundle.getStringArrayList("foward_key_m_p_l");
    Object localObject1 = localArrayList;
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
      return;
    }
    QQToast.a(BaseApplication.getContext(), 1, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131719023), 0).a();
  }
  
  private void a(List<ResultRecord> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false)) {
      this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", HardCodeUtil.a(2131704788));
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
        QQToast.a(BaseApplication.getContext(), 1, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131719023), 0).a();
      }
    }
  }
  
  private String b(Uri paramUri)
  {
    String str = paramUri.getScheme();
    if ((str == null) || (str.equals("file"))) {
      return new File(paramUri.getPath()).getAbsolutePath();
    }
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
        return null;
      }
    }
    return null;
  }
  
  private void e()
  {
    Object localObject3 = null;
    Object localObject6 = a(this.jdField_a_of_type_AndroidOsBundle.getParcelable("FORWARD_MSG_FOR_PIC"));
    if (localObject6 != null) {}
    for (;;)
    {
      try
      {
        Object localObject1 = NativeGifImage.getImageSize((File)localObject6, false);
        Object localObject4;
        Object localObject5;
        int k;
        float f;
        Object localObject2 = null;
      }
      catch (IOException localIOException1)
      {
        try
        {
          localObject6 = ((File)localObject6).toURI().toURL();
          i = 1;
          localObject3 = localObject1;
          localObject1 = localObject6;
          if (i != 0) {
            this.jdField_b_of_type_Int = 5;
          }
          if (!PicItemBuilder.h) {
            i = 0;
          }
          if (i != 0) {
            continue;
          }
          b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog);
          ThreadManager.getSubThreadHandler().postDelayed(new ForwardPhotoOption.PhotoRunnable(this.jdField_a_of_type_AndroidAppActivity), 1000L);
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError3)
        {
          continue;
        }
        catch (IOException localIOException2)
        {
          continue;
        }
        localIOException1 = localIOException1;
        localObject1 = null;
        localIOException1.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardPhotoOption", 2, "getImageSize " + localIOException1.toString());
        }
        localObject6 = null;
        localObject4 = localObject1;
        i = 0;
        localObject1 = localObject6;
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        localObject1 = null;
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardPhotoOption", 2, "getImageSize oom " + localOutOfMemoryError2.toString());
        }
        localObject6 = null;
        localObject5 = localObject1;
        i = 0;
        localObject1 = localObject6;
        continue;
        if ((localObject5 != null) && (localObject1 != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardPhotoOption", 2, "initPreviewImagePath load gif start " + ((URL)localObject1).toString());
          }
          k = localObject5.width();
          i = localObject5.height();
          f = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().densityDpi / 160;
          k = (int)(k * f);
          i = (int)(i * f);
          try
          {
            localObject1 = URLDrawableHelper.getDrawable((URL)localObject1, k, i, new EmptyDrawable(k, i), URLDrawableHelper.getFailedDrawable(), true);
            this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$ContentViewHolder.a((Drawable)localObject1, true, 0, true);
            this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$ContentViewHolder.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(new ForwardPhotoOption.2(this));
            return;
          }
          catch (OutOfMemoryError localOutOfMemoryError1) {}
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ForwardOption.ForwardPhotoOption", 2, "initPreviewImage_getDrawable oom " + localOutOfMemoryError1.toString());
          return;
        }
        b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog);
        return;
      }
      int i = 0;
    }
  }
  
  private boolean u()
  {
    Object localObject2 = b();
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
    Object localObject1 = Boolean.valueOf(this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendMultiple", false));
    boolean bool4 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false);
    boolean bool1 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isJumpAIO", false);
    boolean bool2 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_shoot_quick", false);
    boolean bool3 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_pre_guide", false);
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "ForwardPhotoOption realForwardTo isSendMultiple=" + localObject1 + "isFromShare=" + bool4);
    }
    if (((Boolean)localObject1).booleanValue())
    {
      a((List)localObject2, bool4);
      return true;
    }
    localObject1 = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
    ((Intent)localObject1).putExtra("KEY_MSG_FORWARD_ID", this.jdField_a_of_type_AndroidOsBundle.getInt("KEY_MSG_FORWARD_ID", 0));
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() == 10011))
    {
      ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
      ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, (Intent)localObject1);
      return false;
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() == 10012))
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
      else
      {
        if (bool4)
        {
          this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", HardCodeUtil.a(2131704791));
          ((Intent)localObject1).addFlags(268435456);
          ((Intent)localObject1).addFlags(67108864);
          ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
          bool4 = a((Intent)localObject1);
          boolean bool5 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromFavorites");
          if (QLog.isColorLevel()) {
            QLog.d("forward", 2, "ForwardPhotoOption realForwardTo isFromFav=" + bool5 + "isFromAIOFav=" + bool4);
          }
          if (this.jdField_f_of_type_Boolean)
          {
            ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, null);
            if (QSecFramework.a().a(1003).booleanValue())
            {
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject2).next();
                SecShareInfoUtil.a().a(3, this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath"), localResultRecord.getUinType(), localResultRecord.uin);
                SecShareInfoUtil.a().a();
              }
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
          ((Intent)localObject1).removeExtra("forward_filepath");
          ((Intent)localObject1).removeExtra("forward_extra");
          this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject1);
        }
      }
    }
  }
  
  protected void A()
  {
    Object localObject1;
    String str;
    Object localObject2;
    label94:
    ArrayList localArrayList;
    SmartDeviceProxyMgr localSmartDeviceProxyMgr;
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_flag_from_plugin", false))
    {
      localObject1 = this.jdField_b_of_type_JavaLangString;
      str = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (!TextUtils.isEmpty(FileUtil.a((String)localObject1))) {
          break label294;
        }
        localObject2 = AppConstants.SDCARD_PATH + "photo/" + String.valueOf(System.currentTimeMillis()) + ".jpg";
        FileUtils.d((String)localObject1, (String)localObject2);
        localObject1 = localObject2;
        localObject2 = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
        localArrayList = new ArrayList();
        localArrayList.add(localObject1);
        localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
        if ((!localSmartDeviceProxyMgr.c(Long.parseLong(str))) || (!localSmartDeviceProxyMgr.a(Long.parseLong(str), 17))) {
          break label297;
        }
      }
    }
    label294:
    label297:
    for (boolean bool = true;; bool = false)
    {
      if (Boolean.valueOf(bool).booleanValue()) {
        break label302;
      }
      ((DeviceMsgHandle)localObject2).a().a(DeviceMsgHandle.d, str, localArrayList);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
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
      break;
      break label94;
    }
    label302:
    localSmartDeviceProxyMgr.a(Long.parseLong(str), "", "", "", 0, null);
    super.a((String)localObject1, str, "pic");
  }
  
  protected void B()
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
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131559080, null);
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$ContentViewHolder = new ForwardPhotoOption.ContentViewHolder(null);
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$ContentViewHolder.b = ((TextView)localView.findViewById(2131366077));
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$ContentViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131373455));
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$ContentViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131367459));
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$ContentViewHolder.jdField_a_of_type_AndroidViewView = localView.findViewById(2131367458);
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$ContentViewHolder.c = ((TextView)localView.findViewById(2131365792));
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$ContentViewHolder.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131365835));
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$ContentViewHolder.jdField_a_of_type_AndroidViewView.setMinimumHeight(ViewUtils.a(85.0F));
    int i = ViewUtils.a(15.0F);
    localView.setPadding(0, i, 0, i);
    e();
    ArrayList localArrayList = this.jdField_a_of_type_AndroidOsBundle.getStringArrayList("foward_key_m_p_l");
    if (localArrayList != null)
    {
      TextView localTextView = (TextView)localView.findViewById(2131365807);
      localTextView.setVisibility(0);
      localTextView.setText(HardCodeUtil.a(2131704792) + localArrayList.size() + HardCodeUtil.a(2131704789));
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
      if ((localRecentUser != null) && (!Utils.a(localRecentUser.uin)) && (localRecentUser.getType() != 1003) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1021) && (localRecentUser.getType() != 10004) && ((localRecentUser.getType() != 1) || (!a(localRecentUser.uin))) && ((localRecentUser.getType() != 1006) || (a(ForwardAbility.ForwardAbilityType.jdField_h_of_type_JavaLangInteger))) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 6004) && (localRecentUser.getType() != 9501) && ((localRecentUser.getType() != 0) || (!CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.getType()))) && (((localRecentUser.getType() != 1004) && (localRecentUser.getType() != 1000)) || (this.jdField_b_of_type_Boolean)))
      {
        localArrayList.add(localRecentUser);
      }
      else if ((localRecentUser != null) && (localRecentUser.uin.equalsIgnoreCase(AppConstants.DATALINE_PC_UIN)))
      {
        QLog.d("ForwardOption.ForwardPhotoOption", 2, "getForwardRecentList uin = " + localRecentUser.uin + "  | fromNewImgType = " + i);
        if (i == 1) {
          localArrayList.add(localRecentUser);
        }
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    G();
    if (this.jdField_d_of_type_Boolean)
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
        boolean bool = false;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ResultRecord)((Iterator)localObject1).next();
          bool |= ForwardSendPicUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, ((ResultRecord)localObject2).uin, ((ResultRecord)localObject2).getUinType(), ((ResultRecord)localObject2).groupUin, true, this.jdField_a_of_type_AndroidAppActivity, k);
        }
        if (bool) {
          this.jdField_a_of_type_AndroidAppActivity.setResult(-1);
        }
        return;
      }
      x();
      return;
    }
    super.r();
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_flag_from_plugin", false))
    {
      int i = this.jdField_a_of_type_AndroidOsBundle.getInt("KEY_MSG_FORWARD_ID", 0);
      if (ForwardSendPicUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle.getString("uin"), this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"), this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin"), true, this.jdField_a_of_type_AndroidAppActivity, i)) {
        this.jdField_a_of_type_AndroidAppActivity.setResult(-1);
      }
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
    }
    x();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 19001) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      String str = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardPhotoOption", 2, "refresh forward preview,editPicPath:" + paramIntent + " :currentFile" + str);
      }
      if (!str.equals(paramIntent))
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidOsBundle.remove("FORWARD_MSG_FOR_PIC");
        this.jdField_a_of_type_AndroidOsBundle.putString("forward_filepath", paramIntent);
        this.jdField_a_of_type_AndroidOsBundle.putString("forward_extra", paramIntent);
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("extra_is_edited_pic", true);
        e(paramIntent);
        b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog);
      }
    }
  }
  
  protected void a(Intent paramIntent)
  {
    ArrayList localArrayList3 = null;
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getParcelableArrayList("fileinfo_array");
    ArrayList localArrayList1 = localArrayList3;
    if (localObject != null) {}
    try
    {
      localArrayList1 = (ArrayList)localObject;
      localArrayList3 = (ArrayList)this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
      if (localArrayList1 == null)
      {
        localArrayList1 = this.jdField_a_of_type_AndroidOsBundle.getStringArrayList("foward_key_m_p_l");
        if ((localArrayList1 == null) || (localArrayList1.isEmpty()))
        {
          localArrayList1 = new ArrayList();
          int i = 0;
          while (i < localArrayList3.size())
          {
            localObject = (Uri)localArrayList3.get(i);
            localArrayList1.add(a(this.jdField_a_of_type_AndroidAppActivity, (Uri)localObject));
            i += 1;
          }
          paramIntent.putStringArrayListExtra("dataline_forward_pathlist", localArrayList1);
        }
      }
      else
      {
        paramIntent.putExtra("dataline_forward_type", 101);
        paramIntent.putExtra("sendMultiple", true);
        return;
      }
    }
    catch (ClassCastException localClassCastException)
    {
      for (;;)
      {
        ArrayList localArrayList2 = localArrayList3;
      }
    }
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
    if ((this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendMultiple", false)) && (this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("foward_key_m_p_l") == null))
    {
      Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
      if ((localObject1 != null) && ((localObject1 instanceof ArrayList)))
      {
        localObject1 = (ArrayList)localObject1;
        ArrayList localArrayList = new ArrayList();
        int i = 0;
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
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() == 10006)) {}
    for (;;)
    {
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
      return;
      if ((o()) && (bool1)) {
        this.jdField_a_of_type_JavaUtilSet.add(jdField_h_of_type_JavaLangInteger);
      }
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
      }
      for (;;)
      {
        a(localBundle, str1, null);
        this.jdField_a_of_type_AndroidAppActivity.finish();
        return;
        this.jdField_a_of_type_AndroidAppActivity.setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
      }
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
    QLog.d("ForwardOption.ForwardPhotoOption", 1, "sendDatalineSingle filePath: " + (String)localObject2);
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
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardPhotoOption", 2, "content:" + paramString + "path:" + localArrayList);
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
    Object localObject1;
    int i;
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("sendMultiple", false))
    {
      localObject1 = (ArrayList)this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
      QLog.i("Qfav", 1, "shareToQfav sendMultiple . size = " + ((ArrayList)localObject1).size());
      i = 0;
      if (i >= ((ArrayList)localObject1).size()) {
        break label365;
      }
      if (!QfavBuilder.b(b((Uri)((ArrayList)localObject1).get(i))).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
        i = -1;
      }
    }
    for (;;)
    {
      if (i == 0) {
        QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_AddFav", -1, 0, 69, 0, "", "");
      }
      return i;
      i += 1;
      break;
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
          if (QfavBuilder.b((String)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
            i = 0;
          }
        }
        else if (QfavBuilder.a(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_photo_md5"), -1, this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_download_image_server_path"), this.jdField_a_of_type_AndroidContentIntent.getLongExtra("forward_photo_group_fileid", 0L), this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_extra"), this.jdField_a_of_type_AndroidContentIntent.getLongExtra("forward_file_size", 0L)).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null))
        {
          i = 0;
          continue;
        }
      }
      i = -1;
      continue;
      label365:
      i = 0;
    }
  }
  
  boolean d()
  {
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("uinname");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
    Boolean localBoolean = Boolean.valueOf(this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendMultiple", false));
    boolean bool4 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false);
    boolean bool1 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isJumpAIO", false);
    boolean bool2 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_shoot_quick", false);
    boolean bool3 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_pre_guide", false);
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "ForwardPhotoOption realForwardTo isSendMultiple=" + localBoolean + "isFromShare=" + bool4);
    }
    if (localBoolean.booleanValue())
    {
      a(str2, str1, i, (String)localObject, bool4);
      return true;
    }
    if (i == 1008)
    {
      localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class);
      ((Intent)localObject).putExtra("chat_subType", ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).getPublicAccountAioClass(str1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      AutoSaveUtils.a(true, this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath"));
      if (!QFileAssistantUtils.a(str1)) {
        break label391;
      }
      ForwardUtils.a(this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, str1, i);
      this.jdField_a_of_type_AndroidOsBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("forward_source_uin_type", -1));
      ((Intent)localObject).putExtras(this.jdField_a_of_type_AndroidOsBundle);
      ((Intent)localObject).removeExtra("forward_filepath");
      ((Intent)localObject).removeExtra("forward_extra");
      ((Intent)localObject).putExtra("forward_type", 2147483647);
    }
    label391:
    label605:
    do
    {
      for (;;)
      {
        H();
        this.jdField_a_of_type_AndroidAppActivity.setResult(-1, (Intent)localObject);
        this.jdField_a_of_type_AndroidAppActivity.finish();
        return false;
        localObject = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
        break;
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() == 10011))
        {
          ((Intent)localObject).putExtras(this.jdField_a_of_type_AndroidOsBundle);
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, null);
        }
        else if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() == 10012))
        {
          ((Intent)localObject).addFlags(268435456);
          ((Intent)localObject).addFlags(67108864);
          ((Intent)localObject).putExtras(this.jdField_a_of_type_AndroidOsBundle);
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, null);
        }
        else if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("key_help_forward_pic", false))
        {
          ((Intent)localObject).putExtras(this.jdField_a_of_type_AndroidOsBundle);
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, null);
        }
        else
        {
          if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("key_share_from_screen_shot", false)) {
            break label605;
          }
          ((Intent)localObject).putExtras(this.jdField_a_of_type_AndroidOsBundle);
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, null);
        }
      }
      if (bool4)
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", HardCodeUtil.a(2131704793));
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).addFlags(67108864);
        ((Intent)localObject).putExtras(this.jdField_a_of_type_AndroidOsBundle);
        bool4 = a((Intent)localObject);
        boolean bool5 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromFavorites");
        if (QLog.isColorLevel()) {
          QLog.d("forward", 2, "ForwardPhotoOption realForwardTo isFromFav=" + bool5 + "isFromAIOFav=" + bool4);
        }
        if (!this.jdField_f_of_type_Boolean) {
          break label892;
        }
        this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
        if (QSecFramework.a().a(1003).booleanValue())
        {
          SecShareInfoUtil.a().a(3, this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath"), i, str1);
          SecShareInfoUtil.a().a();
        }
      }
      this.jdField_a_of_type_AndroidOsBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("forward_source_uin_type", -1));
      ((Intent)localObject).putExtras(this.jdField_a_of_type_AndroidOsBundle);
    } while ((!bool2) && (!bool3));
    label774:
    str1 = "";
    if (i == 0) {
      str1 = "0X8007812";
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", str1, str1, 0, 0, "", "", "", "");
      ((Intent)localObject).removeExtra("forward_filepath");
      ((Intent)localObject).removeExtra("forward_extra");
      this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
      break;
      label892:
      if (bool1) {
        break label774;
      }
      ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, null);
      break label774;
      if (i == 1) {
        str1 = "0X8007813";
      } else if (i == 3000) {
        str1 = "0X8007814";
      }
    }
  }
  
  protected String e()
  {
    if (jdField_h_of_type_JavaLangString == null) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131719304);
    }
    return jdField_h_of_type_JavaLangString;
  }
  
  protected void e(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void k()
  {
    super.k();
    AbstractGifImage.pauseAll();
  }
  
  public void l()
  {
    super.l();
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
  
  protected void s()
  {
    super.s();
    int i = a().getInt("key_forward_ability_type");
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardPhotoOption", 2, "-->getCancelListener--onClick--type = " + i);
    }
    if (i == m.intValue()) {
      StoryReportor.a("plus_shoot", "nosend_tip", 0, 0, new String[] { "", "", "", "" });
    }
  }
  
  protected void t()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$ContentViewHolder != null)
    {
      View.OnClickListener localOnClickListener = a(new ForwardPhotoOption.1(this));
      if ((localOnClickListener != null) && (this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$ContentViewHolder.jdField_a_of_type_AndroidWidgetImageView != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$ContentViewHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(localOnClickListener);
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$ContentViewHolder.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131704794));
      }
    }
  }
  
  public void y()
  {
    super.y();
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPhotoOption
 * JD-Core Version:    0.7.0.1
 */