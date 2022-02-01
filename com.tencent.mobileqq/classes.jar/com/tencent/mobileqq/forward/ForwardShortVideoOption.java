package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.file.DevLittleVideoSendOperator;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.RegionalThumbDownloader;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AutoSaveUtils;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ForwardShortVideoOption
  extends ForwardBaseOption
{
  private ForwardShortVideoOption.ContentViewHolder a;
  
  public ForwardShortVideoOption(Intent paramIntent)
  {
    super(paramIntent);
    this.E = true;
    this.L = 7;
  }
  
  private void o()
  {
    Intent localIntent = new Intent(this.s, ShortVideoPlayActivity.class);
    Object localObject;
    StringBuilder localStringBuilder;
    if (this.t.getParcelable("key_message_for_shortvideo") != null)
    {
      localObject = (MessageForShortVideo)this.t.getParcelable("key_message_for_shortvideo");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("enterVideoPreview msg ");
        localStringBuilder.append(((MessageForShortVideo)localObject).videoFileName);
        QLog.d("ForwardOption.ForwardShortVideoOption", 2, localStringBuilder.toString());
      }
      localIntent.putExtras(this.t);
      localIntent.putExtra("video_play_caller", 5);
      localIntent.putExtra("message_click_start", System.currentTimeMillis());
    }
    else
    {
      localObject = this.t.getString("file_send_path");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("enterVideoPreview file ");
        localStringBuilder.append((String)localObject);
        QLog.d("ForwardOption.ForwardShortVideoOption", 2, localStringBuilder.toString());
      }
      if (!FileUtils.fileExists((String)localObject)) {
        break label203;
      }
      localIntent.putExtra("file_send_path", (String)localObject);
      localIntent.putExtra("video_play_caller", 6);
      localIntent.putExtra("message_click_start", System.currentTimeMillis());
    }
    this.s.startActivity(localIntent);
    aq();
    return;
    label203:
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardShortVideoOption", 2, "enterVideoPreview file not exit ");
    }
  }
  
  private void p()
  {
    Object localObject1;
    if (this.t.getBoolean("isFromFavorite", false))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(AppConstants.S_DCARD_COLLECTION);
      ((StringBuilder)localObject1).append("pic/");
      ((StringBuilder)localObject1).append(this.r.getStringExtra("thumbfile_md5"));
      ((StringBuilder)localObject1).append("_0");
      localObject1 = ((StringBuilder)localObject1).toString();
      String str = this.v;
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!new File(str).exists()) && (new File((String)localObject1).exists())) {
        FileUtils.copyFile((String)localObject1, str);
      }
    }
    if (!TextUtils.isEmpty(this.v)) {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("initPreviewImage ");
        ((StringBuilder)localObject1).append(this.v);
        QLog.d("ForwardOption.ForwardShortVideoOption", 2, ((StringBuilder)localObject1).toString());
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = RegionalThumbDownloader.generateURLForNew(this.v, ScreenUtil.dip2px(100.0F), ScreenUtil.dip2px(300.0F));
        if (localObject1 == null) {
          break label294;
        }
        localObject1 = ((URL)localObject1).toString();
        localObject1 = URLDrawable.getDrawable((String)localObject1);
        ((URLDrawable)localObject1).setBounds(0, 0, ScreenUtil.dip2px(248.0F), ScreenUtil.dip2px(248.0F));
        this.r.getBooleanExtra("forward_is_long_video", false);
        this.r.getIntExtra("file_send_size", 0);
        this.r.getIntExtra("file_send_duration", 0);
        ThreadManager.excute(new ForwardShortVideoOption.3(this, (URLDrawable)localObject1), 16, null, false);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("ForwardOption.ForwardShortVideoOption", 2, "initPreviewImage omm!", localOutOfMemoryError);
        this.a.a(null);
        return;
      }
      this.a.a(null);
      return;
      label294:
      Object localObject2 = null;
    }
  }
  
  protected int F()
  {
    int i = this.t.getInt("key_forward_ability_type");
    boolean bool = this.r.getBooleanExtra("forward_ability_entrence_show_in_share", false);
    if ((i == f.intValue()) && (bool)) {
      return 2;
    }
    return super.F();
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
      QLog.d("ForwardOption.ForwardShortVideoOption", 2, localStringBuilder.toString());
    }
    if (i == n.intValue()) {
      StoryReportor.a("plus_shoot", "nosend_tip", 0, 0, new String[] { "", "", "", "" });
    }
  }
  
  protected View a()
  {
    View localView = LayoutInflater.from(this.s).inflate(2131624607, null);
    int i = ViewUtils.dip2px(15.0F);
    localView.setPadding(0, i, 0, i);
    this.a = new ForwardShortVideoOption.ContentViewHolder(null);
    this.a.a = ((ImageView)localView.findViewById(2131433674));
    ((ChatThumbView)this.a.a).c = false;
    this.a.b = new ForwardShortVideoOption.PressDarkImageView(this.s);
    this.a.b.setImageDrawable(this.s.getResources().getDrawable(2130840439));
    this.a.b.b = this.a.a;
    RelativeLayout localRelativeLayout = (RelativeLayout)localView.findViewById(2131433673);
    i = ViewUtils.dip2px(40.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams.addRule(13);
    localRelativeLayout.addView(this.a.b, localLayoutParams);
    localView.findViewById(2131433673).setVisibility(0);
    p();
    this.a.b.setContentDescription(HardCodeUtil.a(2131902820));
    this.a.b.setOnClickListener(new ForwardShortVideoOption.2(this));
    return localView;
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    HotChatManager localHotChatManager = (HotChatManager)this.q.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if (localRecentUser != null)
      {
        if ((!Utils.b(localRecentUser.uin)) && (localRecentUser.getType() != 10004) && ((localRecentUser.getType() != 0) || (!CrmUtils.a(this.q, localRecentUser.uin, localRecentUser.getType()))))
        {
          int j = localRecentUser.getType();
          int i = 1;
          if ((j == 0) || (localRecentUser.getType() == 1) || (localRecentUser.getType() == 3000))
          {
            if ((localHotChatManager == null) || (!localHotChatManager.b(localRecentUser.uin))) {
              i = 0;
            }
            if (i != 0) {
              continue;
            }
            localArrayList.add(localRecentUser);
            continue;
          }
        }
        if ((localRecentUser.uin.equalsIgnoreCase(AppConstants.DATALINE_PC_UIN)) && (a(ForwardAbility.ForwardAbilityType.g)) && (as())) {
          localArrayList.add(localRecentUser);
        }
      }
    }
    return localArrayList;
  }
  
  protected boolean a(QQCustomDialog paramQQCustomDialog)
  {
    if (this.t.getBoolean("is_forward_ptv", false))
    {
      if (!TextUtils.isEmpty(this.v)) {
        try
        {
          paramQQCustomDialog.setPreviewImage(ForwardOptionUtils.a(SkinUtils.a(new BitmapDrawable(this.s.getResources(), this.v))), true, 1);
          return false;
        }
        catch (OutOfMemoryError paramQQCustomDialog)
        {
          QLog.e("ForwardOption.ForwardShortVideoOption", 2, "get ptv drawable omm!", paramQQCustomDialog);
        }
      }
      return false;
    }
    Object localObject;
    if (this.t.getBoolean("isFromFavorite", false))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(AppConstants.S_DCARD_COLLECTION);
      ((StringBuilder)localObject).append("pic/");
      ((StringBuilder)localObject).append(this.r.getStringExtra("thumbfile_md5"));
      ((StringBuilder)localObject).append("_0");
      localObject = ((StringBuilder)localObject).toString();
      String str = this.v;
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)) && (!new File(str).exists()) && (new File((String)localObject).exists())) {
        FileUtils.copyFile((String)localObject, str);
      }
    }
    if (!TextUtils.isEmpty(this.v)) {}
    for (;;)
    {
      try
      {
        localObject = RegionalThumbDownloader.generateURLForNew(this.v, ScreenUtil.dip2px(100.0F), ScreenUtil.dip2px(300.0F));
        if (localObject == null) {
          break label290;
        }
        localObject = ((URL)localObject).toString();
        ThreadManager.post(new ForwardShortVideoOption.1(this, URLDrawable.getDrawable((String)localObject), paramQQCustomDialog, this.r.getBooleanExtra("forward_is_long_video", false), this.r.getIntExtra("file_send_size", 0), this.r.getIntExtra("file_send_duration", 0)), 8, null, false);
        return false;
      }
      catch (OutOfMemoryError paramQQCustomDialog)
      {
        QLog.e("ForwardOption.ForwardShortVideoOption", 2, "get shortvideo drawable omm!", paramQQCustomDialog);
      }
      return true;
      label290:
      localObject = null;
    }
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
        if ((localProductInfo != null) && (localProductInfo.isSupportFuncMsgType(2)) && (a(k))) {
          localArrayList.add(localDeviceInfo);
        }
      }
      i += 1;
    }
    return (DeviceInfo[])localArrayList.toArray(new DeviceInfo[localArrayList.size()]);
  }
  
  protected void ak()
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(al());
    localIntent.putExtra("forward_to_someplace_from_shoot_quick", 1003);
    this.s.setResult(-1, localIntent);
    this.s.finish();
    ReportController.b(this.q, "CliOper", "", "", "0X8007810", "0X8007810", 0, 0, "", "", "", "");
    StoryReportor.a("plus_shoot", "send_tip", 0, 0, new String[] { "", "", "", "" });
  }
  
  protected void b()
  {
    super.b();
    if (this.t.getBoolean("NeedReportForwardShortVideo", false))
    {
      int i = ((IPicPreDownload)this.q.getRuntimeService(IPicPreDownload.class, "")).calcUinType(this.q, this.t.getInt("uintype"), this.t.getString("uin"));
      String str;
      if (i == 3) {
        str = "1";
      }
      for (;;)
      {
        break;
        if (i == 2) {
          str = "2";
        } else if (i == 0) {
          str = "3";
        } else {
          str = "4";
        }
      }
      ReportController.b(this.q, "CliOper", "", "", "0X8005622", "0X8005622", 0, 0, str, "", "", "");
    }
  }
  
  protected void b(Intent paramIntent)
  {
    paramIntent.putExtra("dataline_forward_type", 100);
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
    QLog.d("ForwardOption.ForwardShortVideoOption", 1, ((StringBuilder)localObject1).toString());
    paramIntent.putExtra("dataline_forward_path", (String)localObject2);
    AutoSaveUtils.a(true, (String)localObject2);
  }
  
  protected void c()
  {
    if (ag()) {
      this.C.add(e);
    }
    if (ah()) {
      this.C.add(d);
    }
    if (ai()) {
      this.C.add(c);
    }
    boolean bool = this.r.getBooleanExtra("k_smartdevice", true);
    if ((aj()) && (bool)) {
      this.C.add(k);
    }
    if (this.r.getBooleanExtra("k_qzone", false)) {
      this.C.add(f);
    }
    if (this.r.getBooleanExtra("k_qqstory", false)) {
      this.C.add(n);
    }
    if (this.r.getBooleanExtra("k_dataline", false))
    {
      this.C.add(g);
      this.C.add(l);
    }
  }
  
  protected void d(String paramString)
  {
    Intent localIntent = new Intent(this.s, SplashActivity.class);
    localIntent.putExtras(this.t);
    localIntent.putExtra("set_user_callback", "cooperation.qzone.video.VideoComponentCallback");
    localIntent.putExtra("forward_to_qzone_to_enable_edit", true);
    localIntent.putExtra("forward_source_to_qzone", "source_from_quick_shoot");
    localIntent.putExtra("key_content", paramString);
    localIntent.setFlags(67108864);
    localIntent.putExtra("main_tab_id", 4);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("switch_anim", true);
    localIntent.putExtra("forward_to_someplace_from_shoot_quick", 1002);
    ReportController.b(this.q, "CliOper", "", "", "0X800780F", "0X800780F", 0, 0, "", "", "", "");
    this.s.setResult(-1, localIntent);
    this.s.finish();
  }
  
  protected boolean f()
  {
    boolean bool1 = this.t.getBoolean("isFromFavorite", false);
    boolean bool2 = this.t.getBoolean("forward_need_sendmsg", false);
    boolean bool3 = this.r.getBooleanExtra("forward_source_from_shoot_quick", false);
    boolean bool4 = this.r.getBooleanExtra("forward_source_from_pre_guide", false);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("forwardShortvideo realForwardTo isNeedSendMsg=");
      ((StringBuilder)localObject).append(bool2);
      ((StringBuilder)localObject).append("isFromFavorite=");
      ((StringBuilder)localObject).append(bool1);
      QLog.d("forward", 2, ((StringBuilder)localObject).toString());
    }
    Intent localIntent;
    if (K())
    {
      M();
      localObject = new Intent(this.s, SplashActivity.class);
      ((Intent)localObject).putExtras(this.t);
      localIntent = AIOUtils.a((Intent)localObject, null);
      localIntent.putExtra("isBack2Root", true);
      if (bool2)
      {
        ForwardUtils.a(this.q, this.s, this.I, localIntent, null);
      }
      else if ((!bool3) && (!bool4))
      {
        this.s.startActivity(localIntent);
      }
      else
      {
        localObject = new SessionInfo();
        ((SessionInfo)localObject).b = this.t.getString("uin");
        ((SessionInfo)localObject).a = this.t.getInt("uintype");
        ((SessionInfo)localObject).c = this.t.getString("troop_uin");
        localIntent.putExtra("PhotoConst.SEND_SESSION_INFO", (Parcelable)localObject);
        if (((SessionInfo)localObject).a == 0) {
          localObject = "0X800780C";
        } else if (((SessionInfo)localObject).a == 1) {
          localObject = "0X800780D";
        } else if (((SessionInfo)localObject).a == 3000) {
          localObject = "0X800780E";
        } else {
          localObject = "";
        }
        ReportController.b(this.q, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
      }
      this.s.setResult(-1, localIntent);
    }
    for (;;)
    {
      return true;
      localObject = new Intent(this.s, SplashActivity.class);
      ((Intent)localObject).putExtras(this.t);
      localIntent = AIOUtils.a((Intent)localObject, null);
      localIntent.putExtra("isBack2Root", true);
      if (bool2)
      {
        ForwardUtils.a(this.q, this.s, this.I, localIntent, null);
      }
      else if ((bool3) || (bool4))
      {
        localObject = new SessionInfo();
        ((SessionInfo)localObject).b = this.t.getString("uin");
        ((SessionInfo)localObject).a = this.t.getInt("uintype");
        ((SessionInfo)localObject).c = this.t.getString("troop_uin");
        localIntent.putExtra("PhotoConst.SEND_SESSION_INFO", (Parcelable)localObject);
        if (((SessionInfo)localObject).a == 0) {
          localObject = "0X800780C";
        } else if (((SessionInfo)localObject).a == 1) {
          localObject = "0X800780D";
        } else if (((SessionInfo)localObject).a == 3000) {
          localObject = "0X800780E";
        } else {
          localObject = "";
        }
        ReportController.b(this.q, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
      }
      this.s.setResult(-1, localIntent);
      this.s.finish();
    }
  }
  
  protected void g()
  {
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("uin", this.t.getString("uin"));
    ((Intent)localObject2).putExtra("troop_uin", this.t.getString("troop_uin"));
    ((Intent)localObject2).putExtra("uintype", this.t.getInt("uintype", 9501));
    ((Intent)localObject2).putExtra("file_send_size", this.t.getInt("file_send_size", 0));
    ((Intent)localObject2).putExtra("file_send_business_type", this.t.getInt("file_send_business_type", -1));
    ((Intent)localObject2).putExtra("file_send_duration", this.t.getInt("file_send_duration", -1));
    ((Intent)localObject2).putExtra("file_send_path", this.t.getString("file_send_path"));
    ((Intent)localObject2).putExtra("thumbfile_send_path", this.t.getString("thumbfile_send_path"));
    ((Intent)localObject2).putExtra("file_shortvideo_md5", this.t.getString("file_shortvideo_md5"));
    ((Intent)localObject2).putExtra("thumbfile_send_width", this.t.getInt("thumbfile_send_width", 0));
    ((Intent)localObject2).putExtra("thumbfile_send_height", this.t.getInt("thumbfile_send_height", 0));
    ((Intent)localObject2).putExtra("thumbfile_md5", this.t.getString("thumbfile_md5"));
    ((Intent)localObject2).putExtra("file_source", this.t.getString("file_source"));
    ((Intent)localObject2).putExtra("file_video_source_dir", this.t.getString("file_video_source_dir"));
    Object localObject1 = SVBusiUtil.a(0, 4);
    localObject2 = ShortVideoBusiManager.a(localObject2, (ShortVideoReq)localObject1);
    ((ShortVideoReq)localObject1).a((ShortVideoUploadInfo)localObject2);
    DevLittleVideoSendOperator localDevLittleVideoSendOperator = new DevLittleVideoSendOperator(this.q);
    MessageRecord localMessageRecord = localDevLittleVideoSendOperator.a((ShortVideoUploadInfo)localObject2);
    localDevLittleVideoSendOperator.a(localMessageRecord);
    ((ShortVideoUploadInfo)localObject2).s = localMessageRecord;
    ((ShortVideoReq)localObject1).a((ShortVideoUploadInfo)localObject2);
    ShortVideoBusiManager.a((ShortVideoReq)localObject1, this.q);
    localObject1 = new Intent(this.s, SplashActivity.class);
    ((Intent)localObject1).putExtras(this.t);
    localObject1 = AIOUtils.a((Intent)localObject1, null);
    ((Intent)localObject1).putExtra("isBack2Root", true);
    this.s.startActivity((Intent)localObject1);
    this.s.finish();
  }
  
  protected boolean k()
  {
    if (this.t.getBoolean("is_forward_ptv", false))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardShortVideoOption", 2, "isFromPtv use old");
      }
      return false;
    }
    return true;
  }
  
  public boolean l()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShortVideoOption
 * JD-Core Version:    0.7.0.1
 */