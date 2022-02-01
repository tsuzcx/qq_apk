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
  private ForwardPhotoOption.ContentViewHolder a;
  List<SendMultiPictureHelper> ak;
  private boolean al = true;
  
  public ForwardPhotoOption(Intent paramIntent)
  {
    super(paramIntent);
    this.E = true;
    this.L = 6;
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
      if (paramParcelable.i != 3)
      {
        localObject1 = localObject2;
        if (paramParcelable.i != 2000) {}
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardPhotoOption", 2, "initPreviewImage AIOImageData gif");
        }
        if (paramParcelable.a(2)) {
          paramParcelable = paramParcelable.c(2);
        } else if (paramParcelable.a(4)) {
          paramParcelable = paramParcelable.c(4);
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
      localObject1 = ax();
    }
    return localObject1;
  }
  
  private void a(String paramString1, String paramString2, int paramInt, String paramString3, boolean paramBoolean)
  {
    Object localObject1 = this.r;
    int j = 0;
    if (((Intent)localObject1).getBooleanExtra("isFromShare", false)) {
      this.t.putString("leftBackText", HardCodeUtil.a(2131902767));
    }
    SendMultiPictureHelper localSendMultiPictureHelper = (SendMultiPictureHelper)f(1).get(0);
    ArrayList localArrayList = this.t.getStringArrayList("foward_key_m_p_l");
    localObject1 = localArrayList;
    int i;
    if (localArrayList == null)
    {
      Object localObject2 = this.t.get("android.intent.extra.STREAM");
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
      localSendMultiPictureHelper.a(paramString1, paramString2, paramInt, paramString3, this.t, (ArrayList)localObject1);
      if ((QSecFramework.c().a(1003).booleanValue()) && (paramBoolean) && (this.K))
      {
        i = j;
        while (i < ((ArrayList)localObject1).size())
        {
          SecShareInfoUtil.a().a(3, (String)((ArrayList)localObject1).get(i), paramInt, paramString2);
          i += 1;
        }
        SecShareInfoUtil.a().c();
      }
    }
    else
    {
      QQToast.makeText(BaseApplication.getContext(), 1, this.s.getResources().getString(2131916242), 0).show();
    }
  }
  
  private void a(List<ResultRecord> paramList, boolean paramBoolean)
  {
    if (this.r.getBooleanExtra("isFromShare", false)) {
      this.t.putString("leftBackText", HardCodeUtil.a(2131902760));
    }
    if (paramList == null) {
      return;
    }
    List localList = f(paramList.size());
    Object localObject2 = this.t.getStringArrayList("foward_key_m_p_l");
    Object localObject1 = localObject2;
    int i;
    if (localObject2 == null)
    {
      Object localObject3 = this.t.get("android.intent.extra.STREAM");
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
      i = 0;
    }
    while (i < paramList.size())
    {
      localObject2 = (ResultRecord)paramList.get(i);
      ((SendMultiPictureHelper)localList.get(i)).a(((ResultRecord)localObject2).groupUin, ((ResultRecord)localObject2).uin, ((ResultRecord)localObject2).getUinType(), ((ResultRecord)localObject2).name, this.t, (ArrayList)localObject1);
      if ((QSecFramework.c().a(1003).booleanValue()) && (paramBoolean) && (this.K))
      {
        int j = 0;
        while (j < ((ArrayList)localObject1).size())
        {
          SecShareInfoUtil.a().a(3, (String)((ArrayList)localObject1).get(j), ((ResultRecord)localObject2).getUinType(), ((ResultRecord)localObject2).uin);
          j += 1;
        }
        SecShareInfoUtil.a().c();
      }
      i += 1;
      continue;
      QQToast.makeText(BaseApplication.getContext(), 1, this.s.getResources().getString(2131916242), 0).show();
    }
  }
  
  private boolean av()
  {
    Object localObject1 = M();
    this.t.putBoolean("isBack2Root", false);
    Object localObject2 = Boolean.valueOf(this.r.getBooleanExtra("sendMultiple", false));
    boolean bool4 = this.r.getBooleanExtra("isFromShare", false);
    boolean bool1 = this.r.getBooleanExtra("isJumpAIO", false);
    boolean bool2 = this.r.getBooleanExtra("forward_source_from_shoot_quick", false);
    boolean bool3 = this.r.getBooleanExtra("forward_source_from_pre_guide", false);
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
    localObject2 = AIOUtils.a(new Intent(this.s, SplashActivity.class), null);
    ((Intent)localObject2).putExtra("KEY_MSG_FORWARD_ID", this.t.getInt("KEY_MSG_FORWARD_ID", 0));
    if ((this.ad != null) && (this.ad.c() == 10011))
    {
      ((Intent)localObject2).putExtras(this.t);
      ForwardUtils.a(this.q, this.s, this.I, (Intent)localObject2, null);
    }
    else if ((this.ad != null) && (this.ad.c() == 10012))
    {
      ((Intent)localObject2).addFlags(268435456);
      ((Intent)localObject2).addFlags(67108864);
      ((Intent)localObject2).putExtras(this.t);
      ForwardUtils.a(this.q, this.s, this.I, (Intent)localObject2, null);
    }
    else if (this.t.getBoolean("key_help_forward_pic", false))
    {
      ((Intent)localObject2).putExtras(this.t);
      ForwardUtils.a(this.q, this.s, this.I, (Intent)localObject2, null);
    }
    else
    {
      if (bool4)
      {
        this.t.putString("leftBackText", HardCodeUtil.a(2131902763));
        ((Intent)localObject2).addFlags(268435456);
        ((Intent)localObject2).addFlags(67108864);
        ((Intent)localObject2).putExtras(this.t);
        bool4 = c((Intent)localObject2);
        boolean bool5 = this.t.getBoolean("isFromFavorites");
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("ForwardPhotoOption realForwardTo isFromFav=");
          ((StringBuilder)localObject3).append(bool5);
          ((StringBuilder)localObject3).append("isFromAIOFav=");
          ((StringBuilder)localObject3).append(bool4);
          QLog.d("forward", 2, ((StringBuilder)localObject3).toString());
        }
        if (this.K)
        {
          ForwardUtils.a(this.q, this.s, this.I, (Intent)localObject2, null);
          if (QSecFramework.c().a(1003).booleanValue())
          {
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (ResultRecord)((Iterator)localObject1).next();
              SecShareInfoUtil.a().a(3, this.t.getString("forward_filepath"), ((ResultRecord)localObject3).getUinType(), ((ResultRecord)localObject3).uin);
              SecShareInfoUtil.a().c();
            }
          }
        }
        else if (!bool1)
        {
          ForwardUtils.a(this.q, this.s, this.I, (Intent)localObject2, null);
        }
      }
      this.t.putInt("forward_source_uin_type", this.s.getIntent().getIntExtra("forward_source_uin_type", -1));
      ((Intent)localObject2).putExtras(this.t);
      if ((bool2) || (bool3))
      {
        ((Intent)localObject2).removeExtra("forward_filepath");
        ((Intent)localObject2).removeExtra("forward_extra");
        this.s.startActivity((Intent)localObject2);
      }
    }
    this.s.setResult(-1, (Intent)localObject2);
    return false;
  }
  
  private void aw()
  {
    Object localObject2 = a(this.t.getParcelable("FORWARD_MSG_FOR_PIC"));
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
      this.L = 5;
    }
    if (!PicItemBuilder.A) {
      i = 0;
    }
    if (i == 0)
    {
      b(this.v, this.A);
      ThreadManager.getSubThreadHandler().postDelayed(new ForwardPhotoOption.PhotoRunnable(this.s), 1000L);
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
      int j = ((Rect)localObject1).width();
      i = ((Rect)localObject1).height();
      float f = this.s.getResources().getDisplayMetrics().densityDpi / 160;
      j = (int)(j * f);
      i = (int)(i * f);
      try
      {
        localObject1 = URLDrawableHelper.getDrawable(localURL2, j, i, new EmptyDrawable(j, i), URLDrawableHelper.getFailedDrawable(), true);
        this.a.a((Drawable)localObject1, true, 0, true);
        this.a.d.setOnTouchListener(new ForwardPhotoOption.2(this));
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
      b(this.v, this.A);
    }
  }
  
  private File ax()
  {
    Object localObject2 = this.t.getString("forward_filepath");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.v;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initPreviewImagePath p: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("ForwardOption.ForwardPhotoOption", 2, ((StringBuilder)localObject2).toString());
    }
    boolean bool = this.t.getBoolean(SearchEmoticonFragment.d, false);
    if ((localObject1 != null) && (((String)localObject1).length() > 4) && ((".gif".equals(((String)localObject1).substring(((String)localObject1).length() - 4, ((String)localObject1).length()))) || (bool)))
    {
      localObject1 = new File((String)localObject1);
      if (((File)localObject1).exists()) {
        return localObject1;
      }
    }
    return null;
  }
  
  private String b(Uri paramUri)
  {
    String str = paramUri.getScheme();
    if ((str != null) && (!str.equals("file")))
    {
      if (str.equals("content")) {
        try
        {
          paramUri = this.s.getContentResolver().query(paramUri, new String[] { "_data" }, null, null, null);
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
  
  protected int F()
  {
    return 2;
  }
  
  protected void W()
  {
    super.W();
    int i = al().getInt("key_forward_ability_type");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("-->getCancelListener--onClick--type = ");
      localStringBuilder.append(i);
      QLog.d("ForwardOption.ForwardPhotoOption", 2, localStringBuilder.toString());
    }
    if (i == n.intValue()) {
      StoryReportor.a("plus_shoot", "nosend_tip", 0, 0, new String[] { "", "", "", "" });
    }
  }
  
  protected void X()
  {
    if (this.a != null)
    {
      View.OnClickListener localOnClickListener = a(new ForwardPhotoOption.1(this));
      if ((localOnClickListener != null) && (this.a.d != null))
      {
        this.a.d.setOnClickListener(localOnClickListener);
        this.a.d.setContentDescription(HardCodeUtil.a(2131902766));
      }
    }
  }
  
  protected View a()
  {
    View localView = LayoutInflater.from(this.s).inflate(2131624607, null);
    this.a = new ForwardPhotoOption.ContentViewHolder(null);
    this.a.b = ((TextView)localView.findViewById(2131432265));
    this.a.a = ((TextView)localView.findViewById(2131440611));
    this.a.d = ((ImageView)localView.findViewById(2131433674));
    this.a.e = localView.findViewById(2131433673);
    this.a.c = ((TextView)localView.findViewById(2131431860));
    this.a.f = ((ProgressBar)localView.findViewById(2131431906));
    this.a.e.setMinimumHeight(ViewUtils.dip2px(85.0F));
    int i = ViewUtils.dip2px(15.0F);
    localView.setPadding(0, i, 0, i);
    aw();
    ArrayList localArrayList = this.t.getStringArrayList("foward_key_m_p_l");
    if (localArrayList != null)
    {
      TextView localTextView = (TextView)localView.findViewById(2131431876);
      localTextView.setVisibility(0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131902764));
      localStringBuilder.append(localArrayList.size());
      localStringBuilder.append(HardCodeUtil.a(2131902761));
      localTextView.setText(localStringBuilder.toString());
    }
    return localView;
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.r.getIntExtra("forward_source_uin_type", 0) == 9501) {
      return localArrayList;
    }
    int i = this.r.getIntExtra("key_new_img_shareactionsheet", 0);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!Utils.b(localRecentUser.uin)) && (localRecentUser.getType() != 1003) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1021) && (localRecentUser.getType() != 10004) && ((localRecentUser.getType() != 1) || (!c(localRecentUser.uin))) && ((localRecentUser.getType() != 1006) || (a(ForwardAbility.ForwardAbilityType.i))) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 6004) && (localRecentUser.getType() != 9501) && ((localRecentUser.getType() != 0) || (!CrmUtils.a(this.q, localRecentUser.uin, localRecentUser.getType()))) && (((localRecentUser.getType() != 1004) && (localRecentUser.getType() != 1000)) || (this.E)))
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
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 19001) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      String str = this.t.getString("forward_filepath");
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
        this.w = false;
        this.t.remove("FORWARD_MSG_FOR_PIC");
        this.t.putString("forward_filepath", paramIntent);
        this.t.putString("forward_extra", paramIntent);
        this.t.putBoolean("extra_is_edited_pic", true);
        f(paramIntent);
        b(this.v, this.A);
      }
    }
  }
  
  protected void a(Intent paramIntent)
  {
    ArrayList localArrayList3 = this.t.getParcelableArrayList("fileinfo_array");
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
    localArrayList3 = (ArrayList)this.t.get("android.intent.extra.STREAM");
    if (localObject == null)
    {
      localArrayList2 = this.t.getStringArrayList("foward_key_m_p_l");
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
          localArrayList2.add(a(this.s, (Uri)localObject));
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
    this.s.runOnUiThread(new ForwardPhotoOption.3(this, paramDrawable, paramBoolean1, paramInt));
  }
  
  protected void a(Bundle paramBundle, AIOImageProviderService paramAIOImageProviderService, AIORichMediaData paramAIORichMediaData)
  {
    if (this.t.getBoolean("key_allow_forward_photo_preview_edit", false)) {
      paramBundle.putBoolean("key_allow_forward_photo_preview_edit", true);
    }
    super.a(paramBundle, paramAIOImageProviderService, paramAIORichMediaData);
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    ArrayList localArrayList = new ArrayList();
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.q.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    int j = paramArrayOfDeviceInfo.length;
    int i = 0;
    while (i < j)
    {
      DeviceInfo localDeviceInfo = paramArrayOfDeviceInfo[i];
      if (localDeviceInfo != null)
      {
        ProductInfo localProductInfo = localSmartDeviceProxyMgr.b(localDeviceInfo.productId);
        if ((localProductInfo != null) && (localProductInfo.isSupportFuncMsgType(1)) && (a(k))) {
          localArrayList.add(localDeviceInfo);
        }
      }
      i += 1;
    }
    return (DeviceInfo[])localArrayList.toArray(new DeviceInfo[localArrayList.size()]);
  }
  
  public boolean ac()
  {
    return this.t.getBoolean("key_allow_multiple_forward_from_limit", true);
  }
  
  public void ad()
  {
    super.ad();
    Object localObject = this.ak;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((SendMultiPictureHelper)((Iterator)localObject).next()).d();
      }
      this.ak.clear();
    }
  }
  
  protected void ak()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("forward_to_someplace_from_shoot_quick", 1003);
    this.s.setResult(-1, localIntent);
    this.s.finish();
    ReportController.b(this.q, "CliOper", "", "", "0X8007816", "0X8007816", 0, 0, "", "", "", "");
    StoryReportor.a("plus_shoot", "send_tip", 0, 0, new String[] { "", "", "", "" });
  }
  
  boolean au()
  {
    this.t.putBoolean("isBack2Root", false);
    int i = this.t.getInt("uintype");
    String str = this.t.getString("uin");
    Object localObject1 = this.t.getString("uinname");
    Object localObject2 = this.t.getString("troop_uin");
    Boolean localBoolean = Boolean.valueOf(this.r.getBooleanExtra("sendMultiple", false));
    boolean bool4 = this.r.getBooleanExtra("isFromShare", false);
    boolean bool1 = this.r.getBooleanExtra("isJumpAIO", false);
    boolean bool2 = this.r.getBooleanExtra("forward_source_from_shoot_quick", false);
    boolean bool3 = this.r.getBooleanExtra("forward_source_from_pre_guide", false);
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
      localObject1 = new Intent(this.s, ChatActivity.class);
      ((Intent)localObject1).putExtra("chat_subType", ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).getPublicAccountAioClass(str, this.q));
    }
    else
    {
      localObject1 = AIOUtils.a(new Intent(this.s, SplashActivity.class), null);
    }
    AutoSaveUtils.a(true, this.t.getString("forward_filepath"));
    if (QFileAssistantUtils.a(str))
    {
      ForwardUtils.a(this.r, this.t, this.q, (String)localObject2, str, i);
      this.t.putInt("forward_source_uin_type", this.s.getIntent().getIntExtra("forward_source_uin_type", -1));
      ((Intent)localObject1).putExtras(this.t);
      ((Intent)localObject1).removeExtra("forward_filepath");
      ((Intent)localObject1).removeExtra("forward_extra");
      ((Intent)localObject1).putExtra("forward_type", 2147483647);
    }
    else if ((this.ad != null) && (this.ad.c() == 10011))
    {
      ((Intent)localObject1).putExtras(this.t);
      ForwardUtils.a(this.q, this.s, this.I, (Intent)localObject1, null);
    }
    else if ((this.ad != null) && (this.ad.c() == 10012))
    {
      ((Intent)localObject1).addFlags(268435456);
      ((Intent)localObject1).addFlags(67108864);
      ((Intent)localObject1).putExtras(this.t);
      ForwardUtils.a(this.q, this.s, this.I, (Intent)localObject1, null);
    }
    else if (this.t.getBoolean("key_help_forward_pic", false))
    {
      ((Intent)localObject1).putExtras(this.t);
      ForwardUtils.a(this.q, this.s, this.I, (Intent)localObject1, null);
    }
    else if (this.t.getBoolean("key_share_from_screen_shot", false))
    {
      ((Intent)localObject1).putExtras(this.t);
      ForwardUtils.a(this.q, this.s, this.I, (Intent)localObject1, null);
    }
    else
    {
      if (bool4)
      {
        this.t.putString("leftBackText", HardCodeUtil.a(2131902765));
        ((Intent)localObject1).addFlags(268435456);
        ((Intent)localObject1).addFlags(67108864);
        ((Intent)localObject1).putExtras(this.t);
        bool4 = c((Intent)localObject1);
        boolean bool5 = this.t.getBoolean("isFromFavorites");
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("ForwardPhotoOption realForwardTo isFromFav=");
          ((StringBuilder)localObject2).append(bool5);
          ((StringBuilder)localObject2).append("isFromAIOFav=");
          ((StringBuilder)localObject2).append(bool4);
          QLog.d("forward", 2, ((StringBuilder)localObject2).toString());
        }
        if (this.K)
        {
          ((Intent)localObject1).putExtra("KEY_JUMP_FORWARD_TIME", System.currentTimeMillis());
          this.s.startActivity((Intent)localObject1);
          if (QSecFramework.c().a(1003).booleanValue())
          {
            SecShareInfoUtil.a().a(3, this.t.getString("forward_filepath"), i, str);
            SecShareInfoUtil.a().c();
          }
        }
        else if (!bool1)
        {
          ForwardUtils.a(this.q, this.s, this.I, (Intent)localObject1, null);
        }
      }
      this.t.putInt("forward_source_uin_type", this.s.getIntent().getIntExtra("forward_source_uin_type", -1));
      ((Intent)localObject1).putExtras(this.t);
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
        ReportController.b(this.q, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
        ((Intent)localObject1).removeExtra("forward_filepath");
        ((Intent)localObject1).removeExtra("forward_extra");
        this.s.startActivity((Intent)localObject1);
      }
    }
    SdkShareReporter.a(this.r);
    this.s.setResult(-1, (Intent)localObject1);
    this.s.finish();
    return false;
  }
  
  protected void b()
  {
    ar();
    boolean bool2 = this.H;
    boolean bool1 = false;
    if (bool2)
    {
      ReportController.b(this.q, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
      this.H = false;
    }
    if (K())
    {
      Object localObject1 = M();
      Object localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject2).next();
        b(localResultRecord.uin, localResultRecord.groupUin, localResultRecord.getUinType());
      }
      if (this.r.getBooleanExtra("key_flag_from_plugin", false))
      {
        int j = this.t.getInt("KEY_MSG_FORWARD_ID", 0);
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ResultRecord)((Iterator)localObject1).next();
          bool1 |= ForwardSendPicUtil.a(this.q, this.v, ((ResultRecord)localObject2).uin, ((ResultRecord)localObject2).getUinType(), ((ResultRecord)localObject2).groupUin, true, this.s, j);
        }
        if (bool1) {
          this.s.setResult(-1);
        }
      }
      else
      {
        ab();
      }
    }
    else
    {
      super.V();
      if (this.r.getBooleanExtra("key_flag_from_plugin", false))
      {
        int i = this.t.getInt("KEY_MSG_FORWARD_ID", 0);
        if (ForwardSendPicUtil.a(this.q, this.v, this.t.getString("uin"), this.t.getInt("uintype"), this.t.getString("troop_uin"), true, this.s, i)) {
          this.s.setResult(-1);
        }
        this.s.finish();
        return;
      }
      ab();
    }
  }
  
  public void b(int paramInt)
  {
    Bundle localBundle = new Bundle();
    String str1 = AppConstants.DATALINE_PC_UIN;
    if (paramInt == l.intValue()) {
      str1 = AppConstants.DATALINE_IPAD_UIN;
    }
    localBundle.putAll(this.t);
    if (this.r.getBooleanExtra("key_flag_from_plugin", false))
    {
      LiteActivity.a(this.q, this.v, this.s);
      String str2 = this.r.getStringExtra("caller_name");
      paramInt = this.r.getIntExtra("forward_type", 2147483647);
      String str3 = this.r.getStringExtra("forward_filepath");
      if ((("QQBrowserActivity".equals(str2)) || ("PublicAccountBrowser".equals(str2))) && (paramInt == 1) && (!TextUtils.isEmpty(str3))) {
        this.s.setResult(-1);
      } else {
        this.s.setResult(-1, this.r);
      }
      a(localBundle, str1, null);
      this.s.finish();
      return;
    }
    super.b(paramInt);
  }
  
  protected void b(Intent paramIntent)
  {
    paramIntent.putExtra("dataline_forward_type", 101);
    Object localObject2 = this.t.getString("forward_extra");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.r.getStringExtra("forward_extra");
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.r.getStringExtra("forward_filepath");
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.t.getString("forward_filepath");
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.t.getString("GALLERY.FORWORD_LOCAL_PATH");
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("sendDatalineSingle filePath: ");
    ((StringBuilder)localObject1).append((String)localObject2);
    QLog.d("ForwardOption.ForwardPhotoOption", 1, ((StringBuilder)localObject1).toString());
    paramIntent.putExtra("filepath_copy", this.r.getBooleanExtra("filepath_copy", false));
    paramIntent.putExtra("dataline_forward_path", (String)localObject2);
    AutoSaveUtils.a(true, (String)localObject2);
  }
  
  protected boolean b(String paramString1, String paramString2, int paramInt)
  {
    boolean bool1 = super.b(paramString1, paramString2, paramInt);
    boolean bool2 = this.r.getBooleanExtra("isFromShare", false);
    boolean bool3 = this.r.getBooleanExtra("sendMultiple", false);
    if ((bool2) && (bool3))
    {
      SessionInfo localSessionInfo = new SessionInfo();
      localSessionInfo.a = paramInt;
      localSessionInfo.b = paramString1;
      localSessionInfo.c = paramString2;
      paramString1 = this.t.getString("share_comment_message");
      if ((paramString1 != null) && (!"".equals(paramString1))) {
        ChatActivityFacade.a(this.q, this.I, localSessionInfo, paramString1, null);
      }
    }
    return bool1;
  }
  
  protected void c()
  {
    if (ai()) {
      this.C.add(c);
    }
    if (ag()) {
      this.C.add(e);
    }
    if (ah()) {
      this.C.add(d);
    }
    this.C.add(j);
    boolean bool1 = this.r.getBooleanExtra("k_phonecontacts", true);
    if (((this.ad == null) || (this.ad.c() != 10006)) && (af()) && (bool1)) {
      this.C.add(i);
    }
    bool1 = this.r.getBooleanExtra("k_dataline", true);
    boolean bool2 = this.r.getBooleanExtra("forward_is_selfie_face", false);
    if ((bool1) && (!bool2))
    {
      this.C.add(g);
      this.C.add(l);
    }
    if ((this.r.getBooleanExtra("k_smartdevice", true)) && (aj())) {
      this.C.add(k);
    }
    if (this.r.getBooleanExtra("k_qzone", false)) {
      this.C.add(f);
    }
    if (this.r.getBooleanExtra("k_qqstory", false)) {
      this.C.add(n);
    }
  }
  
  protected void d()
  {
    if (!TextUtils.isEmpty(this.v)) {
      this.A.setMessage(null);
    }
  }
  
  protected void d(String paramString)
  {
    ArrayList localArrayList = this.r.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      ReportController.b(this.q, "CliOper", "", "", "0X8007815", "0X8007815", 0, 0, "", "", "", "");
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
    paramString = new Intent(this.s, SplashActivity.class);
    paramString.setFlags(67108864);
    paramString.putExtra("main_tab_id", 4);
    paramString.putExtra("fragment_id", 1);
    paramString.putExtra("switch_anim", true);
    paramString.putExtra("forward_to_someplace_from_shoot_quick", 1002);
    this.s.setResult(-1, paramString);
    this.s.finish();
  }
  
  public boolean e()
  {
    super.e();
    if (TextUtils.isEmpty(this.v)) {
      this.v = this.t.getString("forward_filepath");
    }
    Object localObject1 = this.r;
    int i = 0;
    if ((((Intent)localObject1).getBooleanExtra("sendMultiple", false)) && (this.r.getStringArrayListExtra("foward_key_m_p_l") == null))
    {
      localObject1 = this.t.get("android.intent.extra.STREAM");
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
        this.t.putStringArrayList("foward_key_m_p_l", localArrayList);
      }
    }
    return true;
  }
  
  public List<SendMultiPictureHelper> f(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramInt)
    {
      localArrayList.add(new SendMultiPictureHelper((BaseActivity)this.s));
      i += 1;
    }
    if (!localArrayList.isEmpty())
    {
      if (this.ak == null) {
        this.ak = new ArrayList();
      }
      this.ak.addAll(localArrayList);
    }
    return localArrayList;
  }
  
  protected void f(String paramString)
  {
    this.v = paramString;
  }
  
  protected boolean f()
  {
    if (K()) {
      return av();
    }
    return au();
  }
  
  protected void g()
  {
    Object localObject1 = this.r;
    boolean bool2 = false;
    Object localObject2;
    if (((Intent)localObject1).getBooleanExtra("key_flag_from_plugin", false))
    {
      localObject1 = this.v;
    }
    else
    {
      localObject2 = this.t.getString("forward_extra");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.r.getStringExtra("forward_extra");
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.r.getStringExtra("forward_filepath");
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.t.getString("forward_filepath");
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.t.getString("GALLERY.FORWORD_LOCAL_PATH");
      }
      this.t.putString("forward_filepath", (String)localObject2);
      localObject1 = localObject2;
    }
    String str = this.t.getString("uin");
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
      localObject1 = (DeviceMsgHandle)this.q.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localObject2);
      SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.q.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
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
        ((DeviceMsgHandle)localObject1).b().a(DeviceMsgHandle.d, str, localArrayList);
      }
      else
      {
        localSmartDeviceProxyMgr.a(Long.parseLong(str), "", "", "", 0, null);
        super.a((String)localObject2, str, "pic");
        return;
      }
    }
    this.s.finish();
  }
  
  protected int h()
  {
    Object localObject1 = this.t;
    int k = 0;
    if (((Bundle)localObject1).getBoolean("sendMultiple", false))
    {
      localObject1 = (ArrayList)this.t.get("android.intent.extra.STREAM");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("shareToQfav sendMultiple . size = ");
      ((StringBuilder)localObject2).append(((ArrayList)localObject1).size());
      QLog.i("Qfav", 1, ((StringBuilder)localObject2).toString());
      int i = 0;
      for (;;)
      {
        j = k;
        if (i >= ((ArrayList)localObject1).size()) {
          break label377;
        }
        if (!QfavBuilder.b(b((Uri)((ArrayList)localObject1).get(i))).a(this.q).b(this.s, this.q.getAccount(), -1, null)) {
          break;
        }
        i += 1;
      }
    }
    QLog.i("Qfav", 1, "shareToQfav single pic");
    Object localObject2 = this.t.getString("forward_filepath");
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (this.ad != null) {
        localObject1 = this.ad.d();
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = this.t.getString("GALLERY.FORWORD_LOCAL_PATH");
    }
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.v;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      if (new File((String)localObject1).exists())
      {
        if (QfavBuilder.b((String)localObject1).a(this.q).b(this.s, this.q.getAccount(), -1, null))
        {
          j = k;
          break label377;
        }
      }
      else if (QfavBuilder.a(this.r.getStringExtra("forward_photo_md5"), -1, this.r.getStringExtra("forward_download_image_server_path"), this.r.getLongExtra("forward_photo_group_fileid", 0L), this.r.getStringExtra("forward_extra"), this.r.getLongExtra("forward_file_size", 0L)).b(this.s, this.q.getAccount(), -1, null))
      {
        j = k;
        break label377;
      }
    }
    int j = -1;
    label377:
    if (j == 0) {
      QfavReport.a(this.q, "User_AddFav", -1, 0, 69, 0, "", "");
    }
    return j;
  }
  
  public void i()
  {
    super.i();
    AbstractGifImage.resumeAll();
  }
  
  public void j()
  {
    super.j();
    AbstractGifImage.pauseAll();
  }
  
  protected boolean k()
  {
    return true;
  }
  
  public boolean l()
  {
    return true;
  }
  
  protected String o()
  {
    if (af == null) {
      return this.I.getString(2131916558);
    }
    return af;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPhotoOption
 * JD-Core Version:    0.7.0.1
 */