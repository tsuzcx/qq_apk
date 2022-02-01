package com.tencent.mobileqq.vipgift;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.biz.common.util.OfflineSecurity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.servlet.VipGifServlet;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.manager.Manager;

public class VipGiftManager
  implements Manager
{
  public long a = 10000L;
  private final String b = "VipGiftManager";
  private VipGiftDownloadInfo c = new VipGiftDownloadInfo();
  private QQAppInterface d;
  private String e;
  
  public VipGiftManager(QQAppInterface paramQQAppInterface)
  {
    this.d = paramQQAppInterface;
    this.e = a();
    d();
  }
  
  private String f()
  {
    if (this.c != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c.a);
      localStringBuilder.append("|");
      localStringBuilder.append(this.c.b);
      localStringBuilder.append("|");
      localStringBuilder.append(this.c.d);
      localStringBuilder.append("|");
      localStringBuilder.append(this.c.e);
      localStringBuilder.append("|");
      localStringBuilder.append(this.c.f);
      localStringBuilder.append("|");
      localStringBuilder.append(this.c.c);
      localStringBuilder.append("|");
      localStringBuilder.append(this.c.g);
      localStringBuilder.append("|");
      localStringBuilder.append(this.c.h);
      localStringBuilder.append("|");
      localStringBuilder.append(this.c.i);
      localStringBuilder.append("|");
      localStringBuilder.append(this.c.j);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public final String a()
  {
    String str1 = Build.MODEL;
    String str2 = Build.VERSION.RELEASE;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\"model\":\"");
    localStringBuilder.append(str1);
    localStringBuilder.append("\",\"systemName\":\"android\",\"systemVersion\":\"");
    localStringBuilder.append(str2);
    localStringBuilder.append("\"}");
    return localStringBuilder.toString();
  }
  
  public void a(VipGiftDownloadInfo paramVipGiftDownloadInfo, BaseActivity paramBaseActivity)
  {
    a(3L, paramVipGiftDownloadInfo.c);
    try
    {
      Object localObject1 = Uri.parse(paramVipGiftDownloadInfo.g);
      Object localObject2;
      if ((localObject1 != null) && (((Uri)localObject1).isHierarchical()))
      {
        localObject2 = ((Uri)localObject1).getQueryParameter("_bid");
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          if (QLog.isColorLevel()) {
            QLog.d("VipGiftManager", 2, "TextUtils.isEmpty(bid) false");
          }
          a(5L, paramVipGiftDownloadInfo.c);
        }
      }
      else
      {
        localObject1 = null;
      }
      if (b((String)localObject1))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("showGifAnnimate.veryfyBid(");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(") true,url:");
          ((StringBuilder)localObject2).append(paramVipGiftDownloadInfo.g);
          QLog.d("VipGiftManager", 2, ((StringBuilder)localObject2).toString());
        }
        if (((String)localObject1).equalsIgnoreCase("280")) {
          a("https://imgcache.qq.com/club/client/gift/resource/0/index.html?_wv=524289&_bid=280");
        }
        a("0X8004B41", "2", "1", paramVipGiftDownloadInfo.g);
        localObject1 = new Intent(BaseApplication.getContext(), QQTranslucentBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", paramVipGiftDownloadInfo.g);
        ((Intent)localObject1).putExtra("Gif_msg_uniseq_key", paramVipGiftDownloadInfo.c);
        paramBaseActivity.startActivity((Intent)localObject1);
        return;
      }
      if (b("280"))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("showGifAnnimate.veryfyBid(");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(") false,url:");
          ((StringBuilder)localObject2).append(paramVipGiftDownloadInfo.g);
          QLog.d("VipGiftManager", 2, ((StringBuilder)localObject2).toString());
        }
        a("https://imgcache.qq.com/club/client/gift/resource/0/index.html?_wv=524289&_bid=280");
        a("0X8004B41", "2", "1", paramVipGiftDownloadInfo.g);
        localObject1 = new Intent(BaseApplication.getContext(), QQTranslucentBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", paramVipGiftDownloadInfo.g);
        ((Intent)localObject1).putExtra("Gif_msg_uniseq_key", paramVipGiftDownloadInfo.c);
        paramBaseActivity.startActivity((Intent)localObject1);
        return;
      }
      a(5L, paramVipGiftDownloadInfo.c);
      return;
    }
    catch (Exception paramBaseActivity)
    {
      label358:
      break label358;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VipGiftManager", 2, "exception bid");
    }
    a(5L, paramVipGiftDownloadInfo.c);
  }
  
  public void a(String paramString)
  {
    this.c.g = paramString;
    c();
  }
  
  public void a(String paramString, long paramLong)
  {
    NewIntent localNewIntent = new NewIntent(this.d.getApplication(), VipGifServlet.class);
    localNewIntent.setAction("gif_ui_show");
    localNewIntent.putExtra("gif_ui_show_bid", Integer.parseInt(paramString));
    localNewIntent.putExtra("gif_ui_show_seq", paramLong);
    this.d.startServlet(localNewIntent);
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    long l = System.currentTimeMillis();
    HtmlOffline.b(paramString1, this.d, true, new VipGiftManager.3(this, l, paramString1, paramLong, paramString2));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = paramString4;
    if (paramString4 == null) {
      str = this.c.g;
    }
    paramString4 = this.e;
    VipUtils.a(this.d, "Vip_Gift", paramString1, paramString1, 0, 0, new String[] { paramString2, paramString3, str, paramString4 });
  }
  
  public boolean a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Build.VERSION.SDK_INT < 11) {
      return true;
    }
    if (paramBoolean2) {
      return false;
    }
    return paramInt == 2;
  }
  
  public boolean a(long paramLong)
  {
    VipGiftDownloadInfo localVipGiftDownloadInfo = this.c;
    if (localVipGiftDownloadInfo != null)
    {
      localVipGiftDownloadInfo.j = paramLong;
      return c();
    }
    return false;
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    try
    {
      if (paramLong2 == this.c.c)
      {
        if (paramLong1 == 2L)
        {
          paramLong2 = this.c.f;
          if (paramLong2 == 6L) {
            return false;
          }
        }
        this.c.f = paramLong1;
        boolean bool = c();
        return bool;
      }
      return false;
    }
    finally {}
  }
  
  public boolean a(MessageForStructing paramMessageForStructing)
  {
    if (paramMessageForStructing == null) {
      return false;
    }
    if (paramMessageForStructing.structingMsg == null) {
      return false;
    }
    a("0X8004B41", "1", "0", paramMessageForStructing.structingMsg.mResid);
    if (this.c == null) {
      this.c = new VipGiftDownloadInfo();
    }
    label409:
    try
    {
      localUri = Uri.parse(paramMessageForStructing.structingMsg.mResid);
      if ((localUri != null) && (localUri.isHierarchical()))
      {
        boolean bool = TextUtils.isEmpty(localUri.getQueryParameter("_bid"));
        if (bool) {
          return false;
        }
      }
    }
    catch (Exception paramMessageForStructing)
    {
      Uri localUri;
      Object localObject;
      long l;
      label123:
      return false;
    }
    try
    {
      localObject = localUri.getQueryParameter("_gv");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        l = Long.parseLong((String)localObject);
      }
    }
    catch (Exception localException)
    {
      break label123;
    }
    l = 0L;
    if (this.c.j > l)
    {
      a("0X8004B41", "2", "3", paramMessageForStructing.structingMsg.mResid);
      return false;
    }
    if ((this.c != null) && (paramMessageForStructing != null) && (paramMessageForStructing.structingMsg != null))
    {
      if (((this.c.f != 0L) || (paramMessageForStructing.time >= this.c.d)) && (this.c.f != 4L) && (this.c.f != 999L) && (this.c.f != 5L) && (this.c.f != 6L) && (!b()))
      {
        a("0X8004B41", "2", "2", paramMessageForStructing.structingMsg.mResid);
        return false;
      }
      this.c.a = paramMessageForStructing.selfuin;
      this.c.b = paramMessageForStructing.senderuin;
      this.c.d = paramMessageForStructing.time;
      localObject = this.c;
      ((VipGiftDownloadInfo)localObject).e = 0L;
      ((VipGiftDownloadInfo)localObject).f = 0L;
      ((VipGiftDownloadInfo)localObject).c = paramMessageForStructing.uniseq;
      this.c.h = paramMessageForStructing.structingMsg.mResid;
      this.c.g = paramMessageForStructing.structingMsg.mResid;
      this.c.i = 0L;
    }
    try
    {
      l = Long.parseLong(localUri.getQueryParameter("_to").trim());
      if (l > 0L) {
        this.a = l;
      }
    }
    catch (Exception paramMessageForStructing)
    {
      break label409;
    }
    return c();
    return false;
  }
  
  public boolean b()
  {
    if (this.c == null) {
      this.c = new VipGiftDownloadInfo();
    }
    VipGiftDownloadInfo localVipGiftDownloadInfo = this.c;
    if ((localVipGiftDownloadInfo != null) && (localVipGiftDownloadInfo.f == 1L))
    {
      long l = NetConnInfoCenter.getServerTimeMillis() - this.c.i;
      if ((l > this.a) || (l <= 0L)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean b(long paramLong)
  {
    VipGiftDownloadInfo localVipGiftDownloadInfo = this.c;
    if (localVipGiftDownloadInfo == null) {
      return false;
    }
    if (localVipGiftDownloadInfo.f != 999L)
    {
      if (this.c.f == 5L) {
        return false;
      }
      if ((this.c.f < 2L) && (paramLong >= this.c.d)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (HtmlOffline.d(paramString) == null) {
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(OfflineEnvHelper.b(paramString));
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = OfflineSecurity.a((String)localObject, paramString);
    if (!bool) {
      HtmlOffline.d((String)localObject, paramString);
    }
    return bool;
  }
  
  public void c(long paramLong)
  {
    this.c.i = NetConnInfoCenter.getServerTimeMillis();
    a(1L, paramLong);
    try
    {
      Object localObject = Uri.parse(this.c.h);
      if ((localObject != null) && (((Uri)localObject).isHierarchical())) {
        localObject = ((Uri)localObject).getQueryParameter("_bid");
      } else {
        localObject = null;
      }
      if ((localObject != null) && (((String)localObject).length() != 0))
      {
        int i = NetworkUtil.getSystemNetwork(BaseApplicationImpl.getContext());
        long l = System.currentTimeMillis();
        boolean bool1 = b((String)localObject);
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("OfflineSecurity.verify bid:");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(",cost:");
          localStringBuilder.append(System.currentTimeMillis() - l);
          localStringBuilder.append(",bigFlag:");
          localStringBuilder.append(bool1);
          QLog.d("VipGiftManager", 2, localStringBuilder.toString());
        }
        l = System.currentTimeMillis();
        boolean bool2 = b("280");
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("OfflineSecurity.verify smalbid:280,cost:");
          localStringBuilder.append(System.currentTimeMillis() - l);
          localStringBuilder.append(",smallFlag:");
          localStringBuilder.append(bool2);
          QLog.d("VipGiftManager", 2, localStringBuilder.toString());
        }
        if (i == 0)
        {
          if (bool1)
          {
            if (a(2L, paramLong)) {
              a((String)localObject, paramLong);
            }
          }
          else if ((bool2) && (a(2L, paramLong)))
          {
            a("https://imgcache.qq.com/club/client/gift/resource/0/index.html?_wv=524289&_bid=280");
            a("280", paramLong);
          }
          return;
        }
        if (a(i, bool2, bool1))
        {
          if (bool2)
          {
            if (a(2L, paramLong))
            {
              a("https://imgcache.qq.com/club/client/gift/resource/0/index.html?_wv=524289&_bid=280");
              a("280", paramLong);
            }
            HtmlOffline.b("280", this.d, true, new VipGiftManager.1(this));
            return;
          }
          a("280", null, paramLong);
          return;
        }
        if (bool1)
        {
          if (a(2L, paramLong)) {
            a((String)localObject, paramLong);
          }
          HtmlOffline.b((String)localObject, this.d, true, new VipGiftManager.2(this));
          return;
        }
        a((String)localObject, "280", paramLong);
        return;
      }
      a(5L, paramLong);
      return;
    }
    catch (Exception localException)
    {
      label440:
      break label440;
    }
    a(5L, paramLong);
  }
  
  public boolean c()
  {
    SharedPreferences.Editor localEditor = this.d.getPreferences().edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Gif_Download_info_key_");
    localStringBuilder.append(this.d.getCurrentAccountUin());
    localEditor.putString(localStringBuilder.toString(), f());
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("writeToSp:");
      localStringBuilder.append(f());
      QLog.d("VipGiftManager", 2, localStringBuilder.toString());
    }
    return localEditor.commit();
  }
  
  public void d()
  {
    Object localObject1 = this.d.getPreferences();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Gif_Download_info_key_");
    ((StringBuilder)localObject2).append(this.d.getCurrentAccountUin());
    localObject1 = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject2).toString(), null);
    if ((localObject1 != null) && (this.c != null))
    {
      localObject1 = ((String)localObject1).split("\\|");
      if ((localObject1 != null) && (localObject1.length == 10))
      {
        localObject2 = this.c;
        if (localObject2 != null)
        {
          ((VipGiftDownloadInfo)localObject2).a = localObject1[0];
          ((VipGiftDownloadInfo)localObject2).b = localObject1[1];
          ((VipGiftDownloadInfo)localObject2).d = Long.parseLong(localObject1[2]);
          this.c.e = Long.parseLong(localObject1[3]);
          this.c.f = Long.parseLong(localObject1[4]);
          this.c.c = Long.parseLong(localObject1[5]);
          localObject2 = this.c;
          ((VipGiftDownloadInfo)localObject2).g = localObject1[6];
          ((VipGiftDownloadInfo)localObject2).h = localObject1[7];
          ((VipGiftDownloadInfo)localObject2).i = Long.parseLong(localObject1[8]);
          this.c.j = Long.parseLong(localObject1[9]);
        }
      }
    }
  }
  
  public VipGiftDownloadInfo e()
  {
    return this.c;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vipgift.VipGiftManager
 * JD-Core Version:    0.7.0.1
 */