package com.tencent.mobileqq.forward;

import adws;
import aepi;
import afwu;
import alof;
import alud;
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
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import apkp;
import arso;
import aryl;
import arzt;
import asbf;
import asbg;
import asbi;
import azqs;
import baqn;
import bayu;
import bdeu;
import bdhb;
import bdhd;
import bdjz;
import bdoo;
import bfav;
import bhsb;
import biva;
import bivo;
import bjdt;
import com.dataline.activities.LiteActivity;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.NativeGifImage;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.emotionintegrate.SearchEmoticonFragment;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;
import ndv;
import nrc;
import wxj;
import ztp;
import zxx;
import zxz;

public class ForwardPhotoOption
  extends arzt
{
  adws jdField_a_of_type_Adws;
  private asbi jdField_a_of_type_Asbi;
  private boolean i;
  
  public ForwardPhotoOption(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_i_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 6;
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
        int j = paramUri.getColumnIndexOrThrow("_data");
        paramUri.moveToFirst();
        str = paramUri.getString(j);
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
    Object localObject9 = null;
    Object localObject1 = null;
    int j = 1;
    int m = 0;
    Object localObject10 = this.jdField_a_of_type_AndroidOsBundle.getParcelable("FORWARD_MSG_FOR_PIC");
    MessageForPic localMessageForPic;
    if ((localObject10 instanceof MessageForPic))
    {
      localMessageForPic = (MessageForPic)localObject10;
      if ((localMessageForPic.imageType != 3) && (localMessageForPic.imageType != 2000)) {
        break label1289;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardPhotoOption", 2, "initPreviewImage msgPic gif.");
      }
      localObject1 = bayu.a(localMessageForPic, 1, null);
      localObject9 = localObject1;
      localObject10 = localObject1;
    }
    for (;;)
    {
      try
      {
        localObject3 = baqn.a(((URL)localObject1).toString());
        if (localObject3 == null) {
          continue;
        }
        localObject9 = localObject1;
        localObject10 = localObject1;
        localObject3 = NativeGifImage.getImageSize((File)localObject3, false);
        j = 1;
      }
      catch (Exception localException5)
      {
        k = 0;
        localObject1 = null;
        localObject10 = localObject9;
        localObject9 = localObject1;
        j = k;
        localObject3 = localObject9;
        localObject1 = localObject10;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ForwardOption.ForwardPhotoOption", 2, "initPreviewImageMPic " + localException5.toString());
        j = k;
        localObject3 = localObject9;
        localObject1 = localObject10;
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError6)
      {
        label142:
        label179:
        k = 0;
        localObject9 = null;
      }
      if (j != 0) {
        this.jdField_b_of_type_Int = 5;
      }
      if (!afwu.h)
      {
        j = m;
        if (j == 0)
        {
          b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Bdjz);
          ThreadManager.getSubThreadHandler().postDelayed(new ForwardPhotoOption.PhotoRunnable(this.jdField_a_of_type_AndroidAppActivity), 1000L);
          return;
          localObject9 = localObject1;
          localObject10 = localObject1;
          localObject1 = bayu.a(localMessageForPic, 65537, null);
          localObject9 = localObject1;
          localObject10 = localObject1;
          localObject3 = baqn.a(((URL)localObject1).toString());
          if (localObject3 != null)
          {
            localObject9 = localObject1;
            localObject10 = localObject1;
            localObject3 = NativeGifImage.getImageSize((File)localObject3, false);
          }
        }
        try
        {
          if (!QLog.isColorLevel()) {
            break label1284;
          }
          QLog.d("ForwardOption.ForwardPhotoOption", 2, "getThumbDrawable,using GIF_HOT_PIC,uniseq:" + localMessageForPic.uniseq + " url:" + localObject1);
          j = 1;
        }
        catch (OutOfMemoryError localOutOfMemoryError7)
        {
          for (;;)
          {
            k = 1;
            localObject9 = localOutOfMemoryError5;
            localObject10 = localOutOfMemoryError1;
          }
        }
        catch (Exception localException6)
        {
          int k = 1;
          localObject9 = localOutOfMemoryError5;
          localObject10 = localOutOfMemoryError1;
          continue;
        }
        localObject9 = localObject1;
        localObject10 = localObject1;
        if (QLog.isColorLevel())
        {
          localObject9 = localObject1;
          localObject10 = localObject1;
          QLog.d("ForwardOption.ForwardPhotoOption", 2, "initPreviewImage no gif download " + ((URL)localObject1).toString());
        }
        localObject9 = localObject1;
        localObject10 = localObject1;
        this.jdField_i_of_type_Boolean = false;
        localObject3 = null;
        j = 0;
        continue;
        j = k;
        localObject3 = localObject9;
        localObject1 = localObject10;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ForwardOption.ForwardPhotoOption", 2, "initPreviewImage oom " + localOutOfMemoryError6.toString());
        j = k;
        localObject3 = localObject9;
        localObject1 = localObject10;
        continue;
        if ((localObject10 instanceof AIOImageData))
        {
          localObject1 = (AIOImageData)localObject10;
          if ((((AIOImageData)localObject1).a != 3) && (((AIOImageData)localObject1).a != 2000)) {
            break label1266;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardPhotoOption", 2, "initPreviewImage AIOImageData gif");
          }
        }
      }
      for (;;)
      {
        for (;;)
        {
          for (;;)
          {
            try
            {
              if (((AIOImageData)localObject1).a(2))
              {
                localObject3 = ((AIOImageData)localObject1).a(2);
                if ((localObject3 == null) || (!((File)localObject3).exists())) {
                  break label1266;
                }
                localObject1 = NativeGifImage.getImageSize((File)localObject3, false);
              }
            }
            catch (OutOfMemoryError localOutOfMemoryError2)
            {
              localObject1 = null;
              if (QLog.isColorLevel()) {
                QLog.d("ForwardOption.ForwardPhotoOption", 2, "initPreviewImageAIOImageData oom " + localOutOfMemoryError2.toString());
              }
              j = 0;
              Object localObject4 = localObject9;
              continue;
            }
            catch (Exception localException1)
            {
              localObject1 = null;
            }
            try
            {
              localObject3 = ((File)localObject3).toURI().toURL();
              localObject9 = localObject1;
              localObject1 = localObject3;
              localObject3 = localObject9;
            }
            catch (Exception localException4)
            {
              label683:
              Object localObject5;
              boolean bool;
              label902:
              Object localObject6;
              Object localObject7;
              float f;
              break label683;
            }
            catch (OutOfMemoryError localOutOfMemoryError5) {}
          }
          if (!((AIOImageData)localObject1).a(4)) {
            break label1278;
          }
          localObject3 = ((AIOImageData)localObject1).a(4);
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardPhotoOption", 2, "initPreviewImageAIOImageData exp " + localException1.toString());
          }
          j = 0;
          localObject5 = localObject9;
          continue;
          localObject9 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
          localObject1 = localObject9;
          if (localObject9 == null) {
            localObject1 = this.jdField_b_of_type_JavaLangString;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardPhotoOption", 2, "initPreviewImagePath p: " + (String)localObject1);
          }
          bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean(SearchEmoticonFragment.a, false);
          if ((localObject1 == null) || (((String)localObject1).length() <= 4) || ((!".gif".equals(((String)localObject1).substring(((String)localObject1).length() - 4, ((String)localObject1).length()))) && (!bool))) {
            break label1258;
          }
          localObject9 = new File((String)localObject1);
          if (!((File)localObject9).exists()) {
            break label1258;
          }
          try
          {
            localObject1 = NativeGifImage.getImageSize((File)localObject9, false);
          }
          catch (OutOfMemoryError localOutOfMemoryError3)
          {
            try
            {
              localObject5 = ((File)localObject9).toURI().toURL();
              localObject9 = localObject1;
              j = 1;
              localObject1 = localObject5;
              localObject5 = localObject9;
            }
            catch (Exception localException3)
            {
              break label959;
            }
            catch (OutOfMemoryError localOutOfMemoryError4)
            {
              break label902;
            }
            localOutOfMemoryError3 = localOutOfMemoryError3;
            localObject1 = null;
            if (QLog.isColorLevel()) {
              QLog.d("ForwardOption.ForwardPhotoOption", 2, "initPreviewImagePath oom " + localOutOfMemoryError3.toString());
            }
            localObject9 = null;
            localObject6 = localObject1;
            j = 0;
            localObject1 = localObject9;
          }
          catch (Exception localException2)
          {
            localObject1 = null;
          }
        }
        label959:
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardPhotoOption", 2, "initPreviewImagePath exp " + localException2.toString());
        }
        localObject9 = null;
        localObject7 = localObject1;
        j = 0;
        localObject1 = localObject9;
        break;
        if ((localObject7 != null) && (localObject1 != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardPhotoOption", 2, "initPreviewImagePath load gif start " + ((URL)localObject1).toString());
          }
          k = localObject7.width();
          j = localObject7.height();
          f = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().densityDpi / 160;
          k = (int)(k * f);
          j = (int)(j * f);
          try
          {
            localObject1 = bayu.a((URL)localObject1, k, j, new apkp(k, j), bayu.a(), true);
            this.jdField_a_of_type_Asbi.a((Drawable)localObject1, true, 0, true);
            this.jdField_a_of_type_Asbi.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(new asbg(this));
            return;
          }
          catch (OutOfMemoryError localOutOfMemoryError1) {}
          if (!QLog.isColorLevel()) {
            break label179;
          }
          QLog.d("ForwardOption.ForwardPhotoOption", 2, "initPreviewImage_getDrawable oom " + localOutOfMemoryError1.toString());
          return;
        }
        b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Bdjz);
        return;
        break label142;
        label1258:
        Object localObject2 = null;
        j = 0;
        break;
        label1266:
        localObject2 = null;
        j = 0;
        localObject8 = localObject9;
        continue;
        label1278:
        localObject8 = null;
      }
      label1284:
      j = 1;
      continue;
      label1289:
      Object localObject8 = null;
      j = 0;
    }
  }
  
  public View a()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131558938, null);
    this.jdField_a_of_type_Asbi = new asbi(null);
    this.jdField_a_of_type_Asbi.b = ((TextView)localView.findViewById(2131365504));
    this.jdField_a_of_type_Asbi.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131372246));
    this.jdField_a_of_type_Asbi.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131366819));
    this.jdField_a_of_type_Asbi.jdField_a_of_type_AndroidViewView = localView.findViewById(2131366818);
    this.jdField_a_of_type_Asbi.c = ((TextView)localView.findViewById(2131365219));
    this.jdField_a_of_type_Asbi.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131365263));
    this.jdField_a_of_type_Asbi.jdField_a_of_type_AndroidViewView.setMinimumHeight(bdoo.a(85.0F));
    int j = bdoo.a(15.0F);
    localView.setPadding(0, j, 0, j);
    e();
    ArrayList localArrayList = this.jdField_a_of_type_AndroidOsBundle.getStringArrayList("foward_key_m_p_l");
    if (localArrayList != null)
    {
      TextView localTextView = (TextView)localView.findViewById(2131365233);
      localTextView.setVisibility(0);
      localTextView.setText(alud.a(2131705160) + localArrayList.size() + alud.a(2131705157));
    }
    return localView;
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("forward_source_uin_type", 0) == 9501) {
      return localArrayList;
    }
    int j = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("key_new_img_shareactionsheet", 0);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!bdeu.a(localRecentUser.uin)) && (localRecentUser.getType() != 1003) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1021) && (localRecentUser.getType() != 10004) && ((localRecentUser.getType() != 1) || (!a(localRecentUser.uin))) && ((localRecentUser.getType() != 1006) || (a(aryl.jdField_h_of_type_JavaLangInteger))) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 6004) && (localRecentUser.getType() != 9501) && ((localRecentUser.getType() != 0) || (!ndv.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.getType()))) && (((localRecentUser.getType() != 1004) && (localRecentUser.getType() != 1000)) || (this.jdField_b_of_type_Boolean)))
      {
        localArrayList.add(localRecentUser);
      }
      else if ((localRecentUser != null) && (localRecentUser.uin.equalsIgnoreCase(alof.z)))
      {
        QLog.d("ForwardOption.ForwardPhotoOption", 2, "getForwardRecentList uin = " + localRecentUser.uin + "  | fromNewImgType = " + j);
        if (j == 1) {
          localArrayList.add(localRecentUser);
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (m()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
    if (k()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_d_of_type_JavaLangInteger);
    }
    if (l()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    this.jdField_a_of_type_JavaUtilSet.add(jdField_i_of_type_JavaLangInteger);
    boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_phonecontacts", true);
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() == 10006)) {}
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_dataline", true))
      {
        this.jdField_a_of_type_JavaUtilSet.add(jdField_f_of_type_JavaLangInteger);
        this.jdField_a_of_type_JavaUtilSet.add(k);
      }
      if ((this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_smartdevice", true)) && (o())) {
        this.jdField_a_of_type_JavaUtilSet.add(j);
      }
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_qzone", false)) {
        this.jdField_a_of_type_JavaUtilSet.add(e);
      }
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_qqstory", false)) {
        this.jdField_a_of_type_JavaUtilSet.add(m);
      }
      return;
      if ((j()) && (bool)) {
        this.jdField_a_of_type_JavaUtilSet.add(jdField_h_of_type_JavaLangInteger);
      }
    }
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
        b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Bdjz);
      }
    }
  }
  
  public void a(Intent paramIntent)
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
          int j = 0;
          while (j < localArrayList3.size())
          {
            localObject = (Uri)localArrayList3.get(j);
            localArrayList1.add(a(this.jdField_a_of_type_AndroidAppActivity, (Uri)localObject));
            j += 1;
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
  
  public void a(Drawable paramDrawable, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new ForwardPhotoOption.3(this, paramDrawable, paramBoolean1, paramInt));
  }
  
  public void a(Bundle paramBundle, AIOImageProviderService paramAIOImageProviderService, AIORichMediaData paramAIORichMediaData)
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
      Object localObject = this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
      if ((localObject != null) && ((localObject instanceof ArrayList)))
      {
        localObject = (ArrayList)localObject;
        ArrayList localArrayList = new ArrayList();
        int j = 0;
        while (j < ((ArrayList)localObject).size())
        {
          String str = a((Uri)((ArrayList)localObject).get(j));
          if (!TextUtils.isEmpty(str)) {
            localArrayList.add(str);
          }
          j += 1;
        }
        this.jdField_a_of_type_AndroidOsBundle.putStringArrayList("foward_key_m_p_l", localArrayList);
      }
    }
    return true;
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    ArrayList localArrayList = new ArrayList();
    ztp localztp = (ztp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    int k = paramArrayOfDeviceInfo.length;
    int j = 0;
    while (j < k)
    {
      DeviceInfo localDeviceInfo = paramArrayOfDeviceInfo[j];
      if (localDeviceInfo != null)
      {
        ProductInfo localProductInfo = localztp.a(localDeviceInfo.productId);
        if ((localProductInfo != null) && (localProductInfo.isSupportFuncMsgType(1)) && (a(j))) {
          localArrayList.add(localDeviceInfo);
        }
      }
      j += 1;
    }
    return (DeviceInfo[])localArrayList.toArray(new DeviceInfo[localArrayList.size()]);
  }
  
  public void b()
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_Bdjz.setMessage(null);
    }
  }
  
  public void b(int paramInt)
  {
    Bundle localBundle = new Bundle();
    String str1 = alof.z;
    if (paramInt == k.intValue()) {
      str1 = alof.A;
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
  
  public void b(Intent paramIntent)
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
    paramIntent.putExtra("dataline_forward_path", (String)localObject2);
    bhsb.a(true, (String)localObject2);
  }
  
  public void b(String paramString)
  {
    ArrayList localArrayList = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007815", "0X8007815", 0, 0, "", "", "", "");
      bjdt.a(paramString, localArrayList, "source_from_quick_shoot");
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
  
  public int c()
  {
    return 2;
  }
  
  public boolean c()
  {
    Object localObject2;
    int j;
    boolean bool5;
    if (f())
    {
      localObject3 = b();
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
      localObject1 = Boolean.valueOf(this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendMultiple", false));
      bool4 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false);
      bool1 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isJumpAIO", false);
      bool2 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_shoot_quick", false);
      bool3 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_pre_guide", false);
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "ForwardPhotoOption realForwardTo isSendMultiple=" + localObject1 + "isFromShare=" + bool4);
      }
      if (((Boolean)localObject1).booleanValue())
      {
        if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false)) {
          this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", alud.a(2131705156));
        }
        if (this.jdField_a_of_type_Adws == null) {
          this.jdField_a_of_type_Adws = new adws((BaseActivity)this.jdField_a_of_type_AndroidAppActivity);
        }
        localObject2 = this.jdField_a_of_type_AndroidOsBundle.getStringArrayList("foward_key_m_p_l");
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject4 = this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
          localObject1 = localObject2;
          if (localObject4 != null)
          {
            localObject1 = localObject2;
            if ((localObject4 instanceof ArrayList))
            {
              localObject4 = (ArrayList)localObject4;
              localObject2 = new ArrayList();
              j = 0;
              for (;;)
              {
                localObject1 = localObject2;
                if (j >= ((ArrayList)localObject4).size()) {
                  break;
                }
                localObject1 = a((Uri)((ArrayList)localObject4).get(j));
                if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                  ((ArrayList)localObject2).add(localObject1);
                }
                j += 1;
              }
            }
          }
        }
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0)) {
          localObject2 = ((List)localObject3).iterator();
        }
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ResultRecord)((Iterator)localObject2).next();
          this.jdField_a_of_type_Adws.a(((ResultRecord)localObject3).c, ((ResultRecord)localObject3).a, ((ResultRecord)localObject3).a(), ((ResultRecord)localObject3).jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle, (ArrayList)localObject1);
          if ((QSecFramework.a().a(1003).booleanValue()) && (bool4) && (this.jdField_f_of_type_Boolean))
          {
            j = 0;
            while (j < ((ArrayList)localObject1).size())
            {
              bfav.a().a(3, (String)((ArrayList)localObject1).get(j), ((ResultRecord)localObject3).a(), ((ResultRecord)localObject3).a);
              j += 1;
            }
            bfav.a().a();
            continue;
            QQToast.a(BaseApplication.getContext(), 1, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131719755), 0).a();
          }
        }
        return true;
      }
      localObject1 = aepi.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
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
            this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", alud.a(2131705159));
            ((Intent)localObject1).addFlags(268435456);
            ((Intent)localObject1).addFlags(67108864);
            ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
            bool4 = a((Intent)localObject1);
            bool5 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromFavorites");
            if (QLog.isColorLevel()) {
              QLog.d("forward", 2, "ForwardPhotoOption realForwardTo isFromFav=" + bool5 + "isFromAIOFav=" + bool4);
            }
            if (this.jdField_f_of_type_Boolean)
            {
              ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, null);
              if (QSecFramework.a().a(1003).booleanValue())
              {
                localObject2 = ((List)localObject3).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localObject3 = (ResultRecord)((Iterator)localObject2).next();
                  bfav.a().a(3, this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath"), ((ResultRecord)localObject3).a(), ((ResultRecord)localObject3).a);
                  bfav.a().a();
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
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
    int k = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    Object localObject3 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    Object localObject4 = this.jdField_a_of_type_AndroidOsBundle.getString("uinname");
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
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
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false)) {
        this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", alud.a(2131705163));
      }
      if (this.jdField_a_of_type_Adws == null) {
        this.jdField_a_of_type_Adws = new adws((BaseActivity)this.jdField_a_of_type_AndroidAppActivity);
      }
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getStringArrayList("foward_key_m_p_l");
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        Object localObject5 = this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
        localObject1 = localObject2;
        if (localObject5 != null)
        {
          localObject1 = localObject2;
          if ((localObject5 instanceof ArrayList))
          {
            localObject2 = (ArrayList)localObject5;
            localObject1 = new ArrayList();
            j = 0;
            while (j < ((ArrayList)localObject2).size())
            {
              localObject5 = a((Uri)((ArrayList)localObject2).get(j));
              if (!TextUtils.isEmpty((CharSequence)localObject5)) {
                ((ArrayList)localObject1).add(localObject5);
              }
              j += 1;
            }
          }
        }
      }
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        this.jdField_a_of_type_Adws.a(str, (String)localObject3, k, (String)localObject4, this.jdField_a_of_type_AndroidOsBundle, (ArrayList)localObject1);
        if ((QSecFramework.a().a(1003).booleanValue()) && (bool4) && (this.jdField_f_of_type_Boolean))
        {
          j = 0;
          while (j < ((ArrayList)localObject1).size())
          {
            bfav.a().a(3, (String)((ArrayList)localObject1).get(j), k, (String)localObject3);
            j += 1;
          }
          bfav.a().a();
        }
      }
      for (;;)
      {
        return true;
        QQToast.a(BaseApplication.getContext(), 1, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131719755), 0).a();
      }
    }
    if (k == 1008)
    {
      localObject2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class);
      ((Intent)localObject2).putExtra("chat_subType", nrc.a((String)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      label1564:
      bhsb.a(true, this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath"));
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() != 10011)) {
        break label1673;
      }
      ((Intent)localObject2).putExtras(this.jdField_a_of_type_AndroidOsBundle);
      ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, (Intent)localObject2, null);
    }
    label1673:
    label1835:
    label2005:
    do
    {
      for (;;)
      {
        F();
        this.jdField_a_of_type_AndroidAppActivity.setResult(-1, (Intent)localObject2);
        this.jdField_a_of_type_AndroidAppActivity.finish();
        break;
        localObject2 = aepi.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
        break label1564;
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() == 10012))
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
          if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("key_share_from_screen_shot", false)) {
            break label1835;
          }
          ((Intent)localObject2).putExtras(this.jdField_a_of_type_AndroidOsBundle);
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, (Intent)localObject2, null);
        }
      }
      if (bool4)
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", alud.a(2131705161));
        ((Intent)localObject2).addFlags(268435456);
        ((Intent)localObject2).addFlags(67108864);
        ((Intent)localObject2).putExtras(this.jdField_a_of_type_AndroidOsBundle);
        bool4 = a((Intent)localObject2);
        bool5 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromFavorites");
        if (QLog.isColorLevel()) {
          QLog.d("forward", 2, "ForwardPhotoOption realForwardTo isFromFav=" + bool5 + "isFromAIOFav=" + bool4);
        }
        if (!this.jdField_f_of_type_Boolean) {
          break label2124;
        }
        this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
        if (QSecFramework.a().a(1003).booleanValue())
        {
          bfav.a().a(3, this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath"), k, (String)localObject3);
          bfav.a().a();
        }
      }
      this.jdField_a_of_type_AndroidOsBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("forward_source_uin_type", -1));
      ((Intent)localObject2).putExtras(this.jdField_a_of_type_AndroidOsBundle);
    } while ((!bool2) && (!bool3));
    localObject1 = "";
    if (k == 0) {
      localObject1 = "0X8007812";
    }
    for (;;)
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
      ((Intent)localObject2).removeExtra("forward_filepath");
      ((Intent)localObject2).removeExtra("forward_extra");
      this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
      break;
      label2124:
      if (bool1) {
        break label2005;
      }
      ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, (Intent)localObject2, null);
      break label2005;
      if (k == 1) {
        localObject1 = "0X8007813";
      } else if (k == 3000) {
        localObject1 = "0X8007814";
      }
    }
  }
  
  public int d()
  {
    Object localObject1;
    int j;
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("sendMultiple", false))
    {
      localObject1 = (ArrayList)this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
      QLog.i("Qfav", 1, "shareToQfav sendMultiple . size = " + ((ArrayList)localObject1).size());
      j = 0;
      if (j >= ((ArrayList)localObject1).size()) {
        break label366;
      }
      if (!biva.b(b((Uri)((ArrayList)localObject1).get(j))).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
        j = -1;
      }
    }
    for (;;)
    {
      if (j == 0) {
        bivo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_AddFav", -1, 0, 69, 0, "", "");
      }
      return j;
      j += 1;
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
          if (biva.b((String)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
            j = 0;
          }
        }
        else if (biva.a(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_photo_md5"), -1, this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_download_image_server_path"), this.jdField_a_of_type_AndroidContentIntent.getLongExtra("forward_photo_group_fileid", 0L), this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_extra"), this.jdField_a_of_type_AndroidContentIntent.getLongExtra("forward_file_size", 0L)).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null))
        {
          j = 0;
          continue;
        }
      }
      j = -1;
      continue;
      label366:
      j = 0;
    }
  }
  
  public void d()
  {
    E();
    if (this.jdField_d_of_type_Boolean)
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
      this.jdField_d_of_type_Boolean = false;
    }
    if (f())
    {
      Object localObject1 = b();
      Object localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject2).next();
        super.b(localResultRecord.a, localResultRecord.c, localResultRecord.a());
      }
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_flag_from_plugin", false))
      {
        int k = this.jdField_a_of_type_AndroidOsBundle.getInt("KEY_MSG_FORWARD_ID", 0);
        localObject1 = ((List)localObject1).iterator();
        boolean bool = false;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ResultRecord)((Iterator)localObject1).next();
          bool |= bdhd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, ((ResultRecord)localObject2).a, ((ResultRecord)localObject2).a(), ((ResultRecord)localObject2).c, true, this.jdField_a_of_type_AndroidAppActivity, k);
        }
        if (bool) {
          this.jdField_a_of_type_AndroidAppActivity.setResult(-1);
        }
        return;
      }
      v();
      return;
    }
    super.q();
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_flag_from_plugin", false))
    {
      int j = this.jdField_a_of_type_AndroidOsBundle.getInt("KEY_MSG_FORWARD_ID", 0);
      if (bdhd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle.getString("uin"), this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"), this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin"), true, this.jdField_a_of_type_AndroidAppActivity, j)) {
        this.jdField_a_of_type_AndroidAppActivity.setResult(-1);
      }
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
    }
    v();
  }
  
  public String e()
  {
    if (jdField_h_of_type_JavaLangString == null) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131720045);
    }
    return jdField_h_of_type_JavaLangString;
  }
  
  public void e(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public boolean h()
  {
    return true;
  }
  
  public boolean i()
  {
    return this.jdField_a_of_type_AndroidOsBundle.getBoolean("key_allow_multiple_forward_from_limit", true);
  }
  
  public void j()
  {
    super.j();
    AbstractGifImage.pauseAll();
  }
  
  public void k()
  {
    super.k();
    AbstractGifImage.resumeAll();
  }
  
  public void r()
  {
    super.r();
    int j = a().getInt("key_forward_ability_type");
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardPhotoOption", 2, "-->getCancelListener--onClick--type = " + j);
    }
    if (j == m.intValue()) {
      wxj.a("plus_shoot", "nosend_tip", 0, 0, new String[] { "", "", "", "" });
    }
  }
  
  public void s()
  {
    if (this.jdField_a_of_type_Asbi != null)
    {
      View.OnClickListener localOnClickListener = a(new asbf(this));
      if ((localOnClickListener != null) && (this.jdField_a_of_type_Asbi.jdField_a_of_type_AndroidWidgetImageView != null))
      {
        this.jdField_a_of_type_Asbi.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(localOnClickListener);
        this.jdField_a_of_type_Asbi.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(alud.a(2131705162));
      }
    }
  }
  
  public void w()
  {
    super.w();
    if (this.jdField_a_of_type_Adws != null) {
      this.jdField_a_of_type_Adws.d();
    }
  }
  
  public void y()
  {
    Object localObject1;
    String str;
    Object localObject2;
    label94:
    ArrayList localArrayList;
    ztp localztp;
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_flag_from_plugin", false))
    {
      localObject1 = this.jdField_b_of_type_JavaLangString;
      str = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (!TextUtils.isEmpty(arso.a((String)localObject1))) {
          break label292;
        }
        localObject2 = alof.aX + "photo/" + String.valueOf(System.currentTimeMillis()) + ".jpg";
        bdhb.d((String)localObject1, (String)localObject2);
        localObject1 = localObject2;
        localObject2 = (zxz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
        localArrayList = new ArrayList();
        localArrayList.add(localObject1);
        localztp = (ztp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
        if ((!localztp.c(Long.parseLong(str))) || (!localztp.a(Long.parseLong(str), 17))) {
          break label295;
        }
      }
    }
    label292:
    label295:
    for (boolean bool = true;; bool = false)
    {
      if (Boolean.valueOf(bool).booleanValue()) {
        break label300;
      }
      ((zxz)localObject2).a().a(zxz.d, str, localArrayList);
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
    label300:
    localztp.a(Long.parseLong(str), "", "", "", 0, null);
    super.a((String)localObject1, str, "pic");
  }
  
  public void z()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("forward_to_someplace_from_shoot_quick", 1003);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007816", "0X8007816", 0, 0, "", "", "", "");
    wxj.a("plus_shoot", "send_tip", 0, 0, new String[] { "", "", "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPhotoOption
 * JD-Core Version:    0.7.0.1
 */