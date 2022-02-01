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
  public long a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private VipGiftDownloadInfo jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo = new VipGiftDownloadInfo();
  private final String jdField_a_of_type_JavaLangString = "VipGiftManager";
  private String b;
  
  public VipGiftManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Long = 10000L;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_JavaLangString = a();
    a();
  }
  
  private String b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("|");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.jdField_b_of_type_JavaLangString);
      localStringBuilder.append("|");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.jdField_b_of_type_Long);
      localStringBuilder.append("|");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.jdField_c_of_type_Long);
      localStringBuilder.append("|");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.jdField_d_of_type_Long);
      localStringBuilder.append("|");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.jdField_a_of_type_Long);
      localStringBuilder.append("|");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.jdField_c_of_type_JavaLangString);
      localStringBuilder.append("|");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.jdField_d_of_type_JavaLangString);
      localStringBuilder.append("|");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.e);
      localStringBuilder.append("|");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.f);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public VipGiftDownloadInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo;
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
  
  public void a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Gif_Download_info_key_");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localObject1 = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject2).toString(), null);
    if ((localObject1 != null) && (this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo != null))
    {
      localObject1 = ((String)localObject1).split("\\|");
      if ((localObject1 != null) && (localObject1.length == 10))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo;
        if (localObject2 != null)
        {
          ((VipGiftDownloadInfo)localObject2).jdField_a_of_type_JavaLangString = localObject1[0];
          ((VipGiftDownloadInfo)localObject2).jdField_b_of_type_JavaLangString = localObject1[1];
          ((VipGiftDownloadInfo)localObject2).jdField_b_of_type_Long = Long.parseLong(localObject1[2]);
          this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.jdField_c_of_type_Long = Long.parseLong(localObject1[3]);
          this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.jdField_d_of_type_Long = Long.parseLong(localObject1[4]);
          this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.jdField_a_of_type_Long = Long.parseLong(localObject1[5]);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo;
          ((VipGiftDownloadInfo)localObject2).jdField_c_of_type_JavaLangString = localObject1[6];
          ((VipGiftDownloadInfo)localObject2).jdField_d_of_type_JavaLangString = localObject1[7];
          ((VipGiftDownloadInfo)localObject2).e = Long.parseLong(localObject1[8]);
          this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.f = Long.parseLong(localObject1[9]);
        }
      }
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.e = NetConnInfoCenter.getServerTimeMillis();
    a(1L, paramLong);
    try
    {
      Object localObject = Uri.parse(this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.jdField_d_of_type_JavaLangString);
      if ((localObject != null) && (((Uri)localObject).isHierarchical())) {
        localObject = ((Uri)localObject).getQueryParameter("_bid");
      } else {
        localObject = null;
      }
      if ((localObject != null) && (((String)localObject).length() != 0))
      {
        int i = NetworkUtil.getSystemNetwork(BaseApplicationImpl.getContext());
        long l = System.currentTimeMillis();
        boolean bool1 = a((String)localObject);
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
        boolean bool2 = a("280");
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
            HtmlOffline.b("280", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, new VipGiftManager.1(this));
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
          HtmlOffline.b((String)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, new VipGiftManager.2(this));
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
      label435:
      break label435;
    }
    a(5L, paramLong);
  }
  
  public void a(VipGiftDownloadInfo paramVipGiftDownloadInfo, BaseActivity paramBaseActivity)
  {
    a(3L, paramVipGiftDownloadInfo.jdField_a_of_type_Long);
    try
    {
      Object localObject1 = Uri.parse(paramVipGiftDownloadInfo.jdField_c_of_type_JavaLangString);
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
          a(5L, paramVipGiftDownloadInfo.jdField_a_of_type_Long);
        }
      }
      else
      {
        localObject1 = null;
      }
      if (a((String)localObject1))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("showGifAnnimate.veryfyBid(");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(") true,url:");
          ((StringBuilder)localObject2).append(paramVipGiftDownloadInfo.jdField_c_of_type_JavaLangString);
          QLog.d("VipGiftManager", 2, ((StringBuilder)localObject2).toString());
        }
        if (((String)localObject1).equalsIgnoreCase("280")) {
          a("https://imgcache.qq.com/club/client/gift/resource/0/index.html?_wv=524289&_bid=280");
        }
        a("0X8004B41", "2", "1", paramVipGiftDownloadInfo.jdField_c_of_type_JavaLangString);
        localObject1 = new Intent(BaseApplication.getContext(), QQTranslucentBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", paramVipGiftDownloadInfo.jdField_c_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("Gif_msg_uniseq_key", paramVipGiftDownloadInfo.jdField_a_of_type_Long);
        paramBaseActivity.startActivity((Intent)localObject1);
        return;
      }
      if (a("280"))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("showGifAnnimate.veryfyBid(");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(") false,url:");
          ((StringBuilder)localObject2).append(paramVipGiftDownloadInfo.jdField_c_of_type_JavaLangString);
          QLog.d("VipGiftManager", 2, ((StringBuilder)localObject2).toString());
        }
        a("https://imgcache.qq.com/club/client/gift/resource/0/index.html?_wv=524289&_bid=280");
        a("0X8004B41", "2", "1", paramVipGiftDownloadInfo.jdField_c_of_type_JavaLangString);
        localObject1 = new Intent(BaseApplication.getContext(), QQTranslucentBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", paramVipGiftDownloadInfo.jdField_c_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("Gif_msg_uniseq_key", paramVipGiftDownloadInfo.jdField_a_of_type_Long);
        paramBaseActivity.startActivity((Intent)localObject1);
        return;
      }
      a(5L, paramVipGiftDownloadInfo.jdField_a_of_type_Long);
      return;
    }
    catch (Exception paramBaseActivity)
    {
      label365:
      break label365;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VipGiftManager", 2, "exception bid");
    }
    a(5L, paramVipGiftDownloadInfo.jdField_a_of_type_Long);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.jdField_c_of_type_JavaLangString = paramString;
    b();
  }
  
  public void a(String paramString, long paramLong)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), VipGifServlet.class);
    localNewIntent.setAction("gif_ui_show");
    localNewIntent.putExtra("gif_ui_show_bid", Integer.parseInt(paramString));
    localNewIntent.putExtra("gif_ui_show_seq", paramLong);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    long l = System.currentTimeMillis();
    HtmlOffline.b(paramString1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, new VipGiftManager.3(this, l, paramString1, paramLong, paramString2));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = paramString4;
    if (paramString4 == null) {
      str = this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.jdField_c_of_type_JavaLangString;
    }
    paramString4 = this.jdField_b_of_type_JavaLangString;
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Vip_Gift", paramString1, paramString1, 0, 0, new String[] { paramString2, paramString3, str, paramString4 });
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo == null) {
      this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo = new VipGiftDownloadInfo();
    }
    VipGiftDownloadInfo localVipGiftDownloadInfo = this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo;
    if ((localVipGiftDownloadInfo != null) && (localVipGiftDownloadInfo.jdField_d_of_type_Long == 1L))
    {
      long l = NetConnInfoCenter.getServerTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.e;
      if ((l > this.jdField_a_of_type_Long) || (l <= 0L)) {
        return true;
      }
    }
    return false;
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
    VipGiftDownloadInfo localVipGiftDownloadInfo = this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo;
    if (localVipGiftDownloadInfo != null)
    {
      localVipGiftDownloadInfo.f = paramLong;
      return b();
    }
    return false;
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    try
    {
      if (paramLong2 == this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.jdField_a_of_type_Long)
      {
        if (paramLong1 == 2L)
        {
          paramLong2 = this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.jdField_d_of_type_Long;
          if (paramLong2 == 6L) {
            return false;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.jdField_d_of_type_Long = paramLong1;
        boolean bool = b();
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
    if (this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo == null) {
      this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo = new VipGiftDownloadInfo();
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
    if (this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.f > l)
    {
      a("0X8004B41", "2", "3", paramMessageForStructing.structingMsg.mResid);
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo != null) && (paramMessageForStructing != null) && (paramMessageForStructing.structingMsg != null))
    {
      if (((this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.jdField_d_of_type_Long != 0L) || (paramMessageForStructing.time >= this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.jdField_b_of_type_Long)) && (this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.jdField_d_of_type_Long != 4L) && (this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.jdField_d_of_type_Long != 999L) && (this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.jdField_d_of_type_Long != 5L) && (this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.jdField_d_of_type_Long != 6L) && (!a()))
      {
        a("0X8004B41", "2", "2", paramMessageForStructing.structingMsg.mResid);
        return false;
      }
      this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.jdField_a_of_type_JavaLangString = paramMessageForStructing.selfuin;
      this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.jdField_b_of_type_JavaLangString = paramMessageForStructing.senderuin;
      this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.jdField_b_of_type_Long = paramMessageForStructing.time;
      localObject = this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo;
      ((VipGiftDownloadInfo)localObject).jdField_c_of_type_Long = 0L;
      ((VipGiftDownloadInfo)localObject).jdField_d_of_type_Long = 0L;
      ((VipGiftDownloadInfo)localObject).jdField_a_of_type_Long = paramMessageForStructing.uniseq;
      this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.jdField_d_of_type_JavaLangString = paramMessageForStructing.structingMsg.mResid;
      this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.jdField_c_of_type_JavaLangString = paramMessageForStructing.structingMsg.mResid;
      this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.e = 0L;
    }
    try
    {
      l = Long.parseLong(localUri.getQueryParameter("_to").trim());
      if (l > 0L) {
        this.jdField_a_of_type_Long = l;
      }
    }
    catch (Exception paramMessageForStructing)
    {
      break label409;
    }
    return b();
    return false;
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (HtmlOffline.a(paramString) == null) {
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(OfflineEnvHelper.a(paramString));
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = OfflineSecurity.a((String)localObject, paramString);
    if (!bool) {
      HtmlOffline.a((String)localObject, paramString);
    }
    return bool;
  }
  
  public boolean b()
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Gif_Download_info_key_");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localEditor.putString(localStringBuilder.toString(), b());
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("writeToSp:");
      localStringBuilder.append(b());
      QLog.d("VipGiftManager", 2, localStringBuilder.toString());
    }
    return localEditor.commit();
  }
  
  public boolean b(long paramLong)
  {
    VipGiftDownloadInfo localVipGiftDownloadInfo = this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo;
    if (localVipGiftDownloadInfo == null) {
      return false;
    }
    if (localVipGiftDownloadInfo.jdField_d_of_type_Long != 999L)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.jdField_d_of_type_Long == 5L) {
        return false;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.jdField_d_of_type_Long < 2L) && (paramLong >= this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.jdField_b_of_type_Long)) {
        return true;
      }
    }
    return false;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vipgift.VipGiftManager
 * JD-Core Version:    0.7.0.1
 */