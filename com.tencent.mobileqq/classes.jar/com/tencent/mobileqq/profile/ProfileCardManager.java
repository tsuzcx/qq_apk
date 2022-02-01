package com.tencent.mobileqq.profile;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.util.ProfileCardTemplateUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.oidb.cmd0x703.cmd0x703.PhotoInfo;
import tencent.im.oidb.cmd0x703.cmd0x703.UinPhotoListInfo;

public class ProfileCardManager
{
  public static Map<Long, Boolean> a = new ConcurrentHashMap();
  public static Map<Long, Boolean> b = new ConcurrentHashMap();
  public static String c = "https://gxh.vip.qq.com/xydata";
  Map<Long, Integer> d = new ConcurrentHashMap();
  Map<String, Boolean> e = new ConcurrentHashMap();
  protected AppInterface f;
  protected Context g;
  public Handler h;
  public Vector<Integer> i = new Vector();
  private Map<Integer, ProfileCardManager.DefaultCardItem> j = new ConcurrentHashMap();
  
  public ProfileCardManager(AppInterface paramAppInterface)
  {
    this.f = paramAppInterface;
    this.g = paramAppInterface.getApp().getApplicationContext();
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    paramContext = new StringBuilder();
    paramContext.append(ProfileCardTemplateUtil.b());
    paramContext.append(paramLong);
    paramContext.append(File.separator);
    return paramContext.toString();
  }
  
  public static String a(Context paramContext, long paramLong1, long paramLong2)
  {
    if (paramLong1 == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_DYNAMIC)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(a(paramContext, paramLong2));
      localStringBuilder.append("wzBgImage.png");
      return localStringBuilder.toString();
    }
    if (paramLong1 == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_STATIC)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(a(paramContext, paramLong2));
      localStringBuilder.append("wzJoinImage.png");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramContext, paramLong2));
    localStringBuilder.append("cardPreview.jpg");
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.PROFILE_CARD_BACKGROUND_DIR);
    localStringBuilder.append("defaultCard");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append(".json");
    return localStringBuilder.toString();
  }
  
  public static boolean a(Context paramContext, long paramLong, String paramString)
  {
    paramContext = new File(a(paramContext, paramLong), paramString);
    boolean bool2 = paramContext.exists();
    boolean bool1 = true;
    if (bool2)
    {
      if (!paramContext.isDirectory()) {
        break label49;
      }
      if (paramContext.list().length > 1) {
        return true;
      }
    }
    bool1 = false;
    label49:
    return bool1;
  }
  
  public static String b(Context paramContext, long paramLong1, long paramLong2)
  {
    if (paramLong1 == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_DYNAMIC)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(a(paramContext, paramLong2));
      localStringBuilder.append("wzDynamicDrawerImage.png");
      return localStringBuilder.toString();
    }
    if (paramLong1 == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_STATIC)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(a(paramContext, paramLong2));
      localStringBuilder.append("wzJoinImage.png");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramContext, paramLong2));
    localStringBuilder.append("cardPreview.jpg");
    return localStringBuilder.toString();
  }
  
  public static boolean b(Context paramContext, long paramLong)
  {
    paramContext = a(paramContext, paramLong);
    if (TextUtils.isEmpty(paramContext)) {
      paramContext = null;
    } else {
      paramContext = new File(paramContext);
    }
    return (paramContext != null) && (paramContext.exists()) && (paramContext.isDirectory()) && (paramContext.list().length > 1);
  }
  
  public static byte[] b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    cmd0x703.UinPhotoListInfo localUinPhotoListInfo = new cmd0x703.UinPhotoListInfo();
    cmd0x703.PhotoInfo localPhotoInfo = new cmd0x703.PhotoInfo();
    localPhotoInfo.str_url.set(paramString);
    localPhotoInfo.uint32_id.set(-1);
    localPhotoInfo.uint32_timestamp.set(0);
    localUinPhotoListInfo.rpt_msg_photo_info.add(localPhotoInfo);
    return localUinPhotoListInfo.toByteArray();
  }
  
  public static String c(Context paramContext, long paramLong)
  {
    paramContext = new StringBuilder();
    paramContext.append(ProfileCardTemplateUtil.b());
    paramContext.append(paramLong);
    paramContext.append(".zip");
    return paramContext.toString();
  }
  
  public int a(long paramLong)
  {
    if (this.d.containsKey(Long.valueOf(paramLong))) {
      return ((Integer)this.d.get(Long.valueOf(paramLong))).intValue();
    }
    return 0;
  }
  
  public ProfileCardManager.DefaultCardItem a(int paramInt, boolean paramBoolean)
  {
    try
    {
      Object localObject3 = (ProfileCardManager.DefaultCardItem)this.j.get(Integer.valueOf(paramInt));
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = new ProfileCardManager.DefaultCardItem(this, paramInt);
        this.j.put(Integer.valueOf(paramInt), localObject1);
      }
      if (!((ProfileCardManager.DefaultCardItem)localObject1).f)
      {
        localObject3 = new File(a(Integer.toString(paramInt)));
        if (((File)localObject3).exists())
        {
          ThreadManager.excute(new ProfileCardManager.1(this, (File)localObject3, paramInt), 64, null, true);
        }
        else if ((paramBoolean) && (this.f != null) && (!this.i.contains(Integer.valueOf(paramInt))))
        {
          localObject3 = (IVasQuickUpdateService)this.f.getRuntimeService(IVasQuickUpdateService.class, "");
          this.i.add(Integer.valueOf(paramInt));
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("profileitem.");
          localStringBuilder.append(paramInt);
          ((IVasQuickUpdateService)localObject3).downloadItem(33L, localStringBuilder.toString(), "ProfileCardRes");
        }
      }
      return localObject1;
    }
    finally {}
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.d.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadProfileCardRes scid=");
      localStringBuilder.append(paramString);
      QLog.d("ProfileCardManager", 2, localStringBuilder.toString());
    }
    if ((this.e.containsKey(paramString)) && (((Boolean)this.e.get(paramString)).booleanValue())) {
      return;
    }
    this.e.put(paramString, Boolean.valueOf(true));
    ((IVasQuickUpdateService)paramQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(15L, paramString, "ProfileCardRes");
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    this.e.put(paramString1, Boolean.valueOf(false));
    if (paramInt == 0)
    {
      long l = Long.parseLong(paramString1.substring(5, paramString1.length()));
      a.put(Long.valueOf(l), Boolean.valueOf(true));
      b.put(Long.valueOf(l), Boolean.valueOf(true));
      paramString1 = a(paramQQAppInterface.getApp(), l);
      paramQQAppInterface = new File(c(paramQQAppInterface.getApp(), l));
      if (!paramQQAppInterface.exists())
      {
        paramString1 = new StringBuilder();
        paramString1.append("unzip file is missing ");
        paramString1.append(paramQQAppInterface.getAbsolutePath());
        QLog.e("ProfileCardManager", 1, paramString1.toString());
        return;
      }
      try
      {
        FileUtils.uncompressZip(paramQQAppInterface.getAbsolutePath(), paramString1, false);
        VasUpdateUtil.a(paramQQAppInterface);
        paramString2 = new File(paramString1, "dynamic.zip");
        if (paramString2.exists())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append(".dynamic");
          localObject = ((StringBuilder)localObject).toString();
          FileUtils.uncompressZip(paramString2.getAbsolutePath(), (String)localObject, false);
          VasUpdateUtil.a(paramString2);
        }
      }
      catch (Throwable paramString2)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("failed to unzip ");
        ((StringBuilder)localObject).append(paramQQAppInterface.getAbsolutePath());
        QLog.e("ProfileCardManager", 1, ((StringBuilder)localObject).toString(), paramString2);
      }
      catch (OutOfMemoryError paramString2)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("failed to unzip ");
        ((StringBuilder)localObject).append(paramQQAppInterface.getAbsolutePath());
        QLog.e("ProfileCardManager", 1, ((StringBuilder)localObject).toString(), paramString2);
      }
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("onDownloadComplete, resDir= ");
        paramQQAppInterface.append(paramString1);
        QLog.d("ProfileCardManager", 2, paramQQAppInterface.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("onDownloadComplete failed, errorCode = ");
      paramQQAppInterface.append(paramInt);
      QLog.d("ProfileCardManager", 2, paramQQAppInterface.toString());
    }
  }
  
  public void b(long paramLong)
  {
    IVasQuickUpdateService localIVasQuickUpdateService = (IVasQuickUpdateService)this.f.getRuntimeService(IVasQuickUpdateService.class, "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("card.");
    localStringBuilder.append(paramLong);
    localIVasQuickUpdateService.cancelDwonloadItem(15L, localStringBuilder.toString());
  }
  
  public boolean d(Context paramContext, long paramLong)
  {
    return VasUpdateUtil.a(new File(a(paramContext, paramLong)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardManager
 * JD-Core Version:    0.7.0.1
 */