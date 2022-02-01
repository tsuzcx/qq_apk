package com.tencent.mobileqq.webview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.WebCgiWhiteListManager;
import com.tencent.biz.common.util.Util;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import tencent.aio.video.aio_video.ReqGetUinByOpenId;
import tencent.im.PasswdUrlReport.ReqBody;
import tencent.im.PasswdUrlReport.UploadReqItem;
import tencent.im.oidb.oidb_0xbcb.CheckUrlReq;
import tencent.im.oidb.oidb_0xbcb.ReqBody;

public class UrlSecurityCheckManager
  implements Manager
{
  LruCache<String, UrlSecurityCheckManager.CheckResult> a = new LruCache(64);
  ArrayList<String> b = new ArrayList(64);
  Handler c = new Handler(Looper.getMainLooper());
  QQAppInterface d;
  boolean e;
  String f;
  boolean g;
  boolean h;
  int i;
  String j;
  private UrlSecurityCheckManager.OnCheckResult k;
  
  public UrlSecurityCheckManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    this.e = false;
    this.g = false;
    this.h = false;
    this.i = -1;
    this.k = new UrlSecurityCheckManager.1(this);
    this.d = paramQQAppInterface;
    if (WebCgiWhiteListManager.c() != 0) {
      bool = true;
    }
    this.e = bool;
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("aio pre check enable=");
    paramQQAppInterface.append(this.e);
    QLog.i("UrlCheckLog", 1, paramQQAppInterface.toString());
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("apply async check ");
      ((StringBuilder)localObject).append(Util.b(paramString, new String[0]));
      QLog.d("urlSecMgr", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = paramString;
    if (paramString.length() > 10240) {
      localObject = paramString.substring(0, 10240);
    }
    paramString = (UrlSecurityCheckManager.CheckResult)this.a.get(localObject);
    if ((paramString != null) && (paramString.d > NetConnInfoCenter.getServerTimeMillis())) {
      return;
    }
    this.b.add(localObject);
    int m = this.b.size();
    if (m > 40) {
      this.b.subList(0, m - 20).clear();
    }
  }
  
  private void a(Collection<String> paramCollection, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt3, String paramString5, boolean paramBoolean, ArrayList<String> paramArrayList, UrlSecurityCheckManager.OnCheckResult paramOnCheckResult)
  {
    localReqBody = new oidb_0xbcb.ReqBody();
    localReqBody.check_url_req.setHasFlag(true);
    if (paramCollection.size() > 20)
    {
      QLog.e("urlSecMgr", 1, "urls size > 20");
      return;
    }
    paramCollection = paramCollection.iterator();
    int m = 0;
    while (paramCollection.hasNext())
    {
      String str = (String)paramCollection.next();
      m += str.length();
      if (m > 10240)
      {
        QLog.e("urlSecMgr", 1, "url to large");
        return;
      }
      localReqBody.check_url_req.url.add(str);
    }
    if (paramInt1 != -1)
    {
      localReqBody.check_url_req.msg_type.set(paramInt1);
      localReqBody.check_url_req.msg_from.set(paramInt2);
      if (TextUtils.isEmpty(paramString1)) {}
    }
    try
    {
      l = Long.parseLong(paramString1);
      localReqBody.check_url_req.send_uin.set(l);
    }
    catch (NumberFormatException paramCollection)
    {
      try
      {
        long l = Long.parseLong(paramString2);
        localReqBody.check_url_req.msg_chatid.set(l);
        boolean bool = TextUtils.isEmpty(paramString5) ^ true;
        if (!bool) {
          break label226;
        }
        localReqBody.check_url_req.ark_name.set(paramString5);
        if (paramArrayList == null) {
          break label244;
        }
        localReqBody.check_url_req.src_urls.addAll(paramArrayList);
        localReqBody.check_url_req.is_ark.set(bool);
        localReqBody.check_url_req.is_finish.set(paramBoolean);
        localReqBody.check_url_req.src_platform.set(1);
        if (TextUtils.isEmpty(AppSetting.g())) {
          break label305;
        }
        localReqBody.check_url_req.qua.set(AppSetting.g());
        if (!QLog.isColorLevel()) {
          break label422;
        }
        paramCollection = new StringBuilder("send 0xbcb_0 isArkMsg=");
        paramCollection.append(bool);
        paramCollection.append(" isPageFinish=");
        paramCollection.append(paramBoolean);
        paramCollection.append(" arkBusinessName=");
        paramCollection.append(paramString5);
        paramCollection.append(" preJumpUrls=");
        if (paramArrayList == null) {
          break label412;
        }
        paramInt1 = 0;
        while (paramInt1 < paramArrayList.size())
        {
          paramCollection.append((String)paramArrayList.get(paramInt1));
          paramCollection.append("\n");
          paramInt1 += 1;
        }
        QLog.d("urlSecMgr", 2, paramCollection.toString());
        localReqBody.check_url_req.qq_pf_to.set(paramString3);
        paramString1 = localReqBody.check_url_req.req_type;
        if (paramInt3 != 2) {
          break label458;
        }
        paramCollection = "aio";
        break label475;
        if (paramInt3 != 1) {
          break label471;
        }
        paramCollection = "webview";
        break label475;
        paramCollection = "";
        paramString1.set(paramCollection);
        if (TextUtils.isEmpty(paramString4)) {
          break label502;
        }
        localReqBody.check_url_req.original_url.set(paramString4);
        if (!QLog.isColorLevel()) {
          break label552;
        }
        QLog.d("urlSecMgr", 2, new Object[] { "send 0xbcb_0 url count=", String.valueOf(localReqBody.check_url_req.url.size()), " originUrl:", paramString4 });
        ProtoUtils.a(this.d, new UrlSecurityCheckManager.5(this, paramOnCheckResult, paramInt3), localReqBody.toByteArray(), "OidbSvc.0xbcb_0", 3019, 0, null, paramLong);
        return;
        paramCollection = paramCollection;
      }
      catch (NumberFormatException paramCollection)
      {
        break label199;
      }
    }
    if (TextUtils.isEmpty(paramString2)) {}
  }
  
  private boolean a(UrlSecurityCheckManager.CheckResult paramCheckResult, String paramString, boolean paramBoolean)
  {
    if (paramCheckResult == null) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UrlCheckLog", 2, new Object[] { "forceReportArkPageFinish arkBusinessName=", paramString, " isPageFinish : ", Boolean.valueOf(paramBoolean), " entry.isArkPageFinis=", Boolean.valueOf(paramCheckResult.j) });
    }
    if ((paramBoolean) && (!paramCheckResult.j))
    {
      paramCheckResult.j = true;
      return true;
    }
    return false;
  }
  
  private void b()
  {
    if (this.g) {
      return;
    }
    if (this.b.size() > 0)
    {
      this.g = true;
      HashSet localHashSet = new HashSet(20);
      int m = this.b.size() - 1;
      int n = 0;
      while ((m >= 0) && (localHashSet.size() < 20))
      {
        String str = (String)this.b.get(m);
        if (localHashSet.contains(str))
        {
          this.b.remove(m);
        }
        else
        {
          int i1 = n + str.length();
          if (i1 > 10240) {
            break;
          }
          this.b.remove(m);
          localHashSet.add(str);
          n = i1;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("pre check url=");
            localStringBuilder.append(Util.b(str, new String[0]));
            QLog.i("UrlCheckLog", 2, localStringBuilder.toString());
            n = i1;
          }
        }
        m -= 1;
      }
      a(localHashSet, this.i, 0, "", this.j, this.f, "", 0L, 2, null, false, null, this.k);
    }
  }
  
  private void b(ListView paramListView, ChatAdapter1 paramChatAdapter1)
  {
    long l = System.currentTimeMillis();
    this.b.clear();
    int m = paramListView.getFirstVisiblePosition();
    int n = paramListView.getLastVisiblePosition();
    int i1 = paramListView.getHeaderViewsCount();
    m = Math.max(0, m - i1);
    n = Math.min(n - i1, paramChatAdapter1.getCount() - 1);
    while (m <= n)
    {
      paramListView = (ChatMessage)paramChatAdapter1.getItem(m);
      if (!paramListView.isSend()) {
        if ((paramListView instanceof MessageForStructing))
        {
          paramListView = ((MessageForStructing)paramListView).structingMsg;
          if (WebAccelerator.a(paramListView)) {
            a(paramListView.mMsgUrl);
          }
        }
        else if ((paramListView instanceof MessageForText))
        {
          paramListView = (MessageForText)paramListView;
          if (paramListView.msg != null)
          {
            paramListView = WebAccelerator.f(paramListView.msg);
            if (paramListView != null) {
              a(paramListView);
            }
          }
        }
      }
      m += 1;
    }
    b();
    if (QLog.isColorLevel())
    {
      paramListView = new StringBuilder();
      paramListView.append("pre check cost=");
      paramListView.append(System.currentTimeMillis() - l);
      QLog.d("urlSecMgr", 2, paramListView.toString());
    }
  }
  
  public void a()
  {
    if (!this.e) {
      return;
    }
    this.c.removeCallbacksAndMessages(null);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!this.e) {
      return;
    }
    this.c.removeCallbacksAndMessages(null);
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3000)
        {
          this.f = "";
          this.i = -1;
          this.j = "";
          return;
        }
        this.f = "mqq.discussion";
        this.i = 3;
        this.j = paramString;
        return;
      }
      this.f = "mqq.group";
      this.i = 2;
      this.j = paramString;
      return;
    }
    this.f = "mqq.c2c";
    this.i = 0;
    this.j = paramString;
  }
  
  public void a(Bundle paramBundle)
  {
    int m = paramBundle.getInt("uploadType", 1);
    String str1 = paramBundle.getString("originUrl");
    String str2 = paramBundle.getString("url");
    String str3 = paramBundle.getString("screenshot");
    String str4 = paramBundle.getString("title");
    String str5 = paramBundle.getString("uin");
    paramBundle.getString("inputText");
    ArrayList localArrayList1 = paramBundle.getStringArrayList("text_features");
    ArrayList localArrayList2 = paramBundle.getStringArrayList("js_func_features");
    int n = paramBundle.getInt("passwdShow", -1);
    paramBundle.getInt("passwdInput", -1);
    int i1 = paramBundle.getInt("hasVirtualKB", -1);
    paramBundle = new PasswdUrlReport.ReqBody();
    paramBundle.upload_type.set(m);
    PasswdUrlReport.UploadReqItem localUploadReqItem = new PasswdUrlReport.UploadReqItem();
    if (!TextUtils.isEmpty(str1)) {
      localUploadReqItem.origin_url.set(str1);
    }
    if (!TextUtils.isEmpty(str2)) {
      localUploadReqItem.url.set(str2);
    }
    if (!TextUtils.isEmpty(str3)) {
      localUploadReqItem.screenshot.set(str3);
    }
    if (!TextUtils.isEmpty(str4)) {
      localUploadReqItem.title.set(str4);
    }
    if (!TextUtils.isEmpty(str5)) {
      localUploadReqItem.uin.set(ByteStringMicro.copyFromUtf8(str5));
    }
    if ((localArrayList1 != null) && (localArrayList1.size() > 0)) {
      localUploadReqItem.text_features.set(localArrayList1);
    }
    if ((localArrayList2 != null) && (localArrayList2.size() > 0)) {
      localUploadReqItem.js_func_features.set(localArrayList2);
    }
    if (i1 != -1) {
      localUploadReqItem.passwd_input.set(i1);
    }
    if (n != -1) {
      localUploadReqItem.passwd_show.set(n);
    }
    paramBundle.upload_req_item.set(localUploadReqItem);
    if (QLog.isColorLevel()) {
      QLog.d("urlSecMgr", 2, new Object[] { "reportAntiPasswd  originUrl:", str1 });
    }
    ProtoUtils.a(this.d, new UrlSecurityCheckManager.3(this), paramBundle.toByteArray(), "PasswdUrlReport.report", 0, 0, null, 10000L);
  }
  
  public void a(ListView paramListView, ChatAdapter1 paramChatAdapter1)
  {
    if (!this.e) {
      return;
    }
    long l = System.currentTimeMillis();
    this.c.removeCallbacksAndMessages(null);
    this.b.clear();
    paramListView = new WeakReference(paramListView);
    paramChatAdapter1 = new WeakReference(paramChatAdapter1);
    this.c.postDelayed(new UrlSecurityCheckManager.2(this, paramListView, paramChatAdapter1), 500L);
    if (QLog.isColorLevel())
    {
      paramListView = new StringBuilder();
      paramListView.append("new pre check task cost=");
      paramListView.append(System.currentTimeMillis() - l);
      QLog.d("urlSecMgr", 2, paramListView.toString());
    }
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean, ArrayList<String> paramArrayList, UrlSecurityCheckManager.OnCheckResult paramOnCheckResult)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (paramString1.length() > 10240) {
      paramString1 = paramString1.substring(0, 10240);
    }
    UrlSecurityCheckManager.CheckResult localCheckResult = (UrlSecurityCheckManager.CheckResult)this.a.get(paramString1);
    boolean bool = a(localCheckResult, paramString6, paramBoolean);
    if ((localCheckResult != null) && (localCheckResult.d > NetConnInfoCenter.getServerTimeMillis()) && (localCheckResult.a == 0) && (!bool))
    {
      if (QLog.isColorLevel()) {
        QLog.i("UrlCheckLog", 2, "cache hit");
      }
      paramString1 = new Bundle();
      paramString1.putInt("result", localCheckResult.a);
      paramString1.putInt("jumpResult", localCheckResult.b);
      paramString1.putString("jumpUrl", localCheckResult.c);
      paramString1.putInt("level", localCheckResult.e);
      paramString1.putInt("subLevel", localCheckResult.f);
      paramString1.putInt("umrType", localCheckResult.g);
      paramString1.putInt("retFrom", localCheckResult.h);
      paramString1.putLong("operationBit", localCheckResult.i);
      paramOnCheckResult.a(paramString1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("UrlCheckLog", 2, "no cache");
    }
    a(Collections.singletonList(paramString1), paramInt1, paramInt2, paramString2, paramString3, paramString4, paramString5, 10000L, 1, paramString6, paramBoolean, paramArrayList, paramOnCheckResult);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, UrlSecurityCheckManager.OnCheckResult paramOnCheckResult)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    try
    {
      int m = Integer.parseInt(paramString1);
      long l = Long.parseLong(paramString3);
      paramString1 = new aio_video.ReqGetUinByOpenId();
      paramString1.app_id.set(m);
      paramString1.open_id.set(ByteStringMicro.copyFromUtf8(paramString2));
      paramString1.group_id.set(l);
      ProtoUtils.a(this.d, new UrlSecurityCheckManager.4(this, paramOnCheckResult), paramString1.toByteArray(), "QQAIOMediaSvc.get_uin_by_openid", null, false);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("urlSecMgr", 2, paramString1.toString());
    }
  }
  
  public void onDestroy()
  {
    this.h = true;
    this.c.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.UrlSecurityCheckManager
 * JD-Core Version:    0.7.0.1
 */