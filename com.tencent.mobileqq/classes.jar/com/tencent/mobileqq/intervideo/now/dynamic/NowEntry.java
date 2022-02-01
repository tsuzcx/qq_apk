package com.tencent.mobileqq.intervideo.now.dynamic;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.intervideo.nowproxy.NowLive;
import com.tencent.intervideo.nowproxy.customized_interface.ActionCallback;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.intervideo.now.NowDataReporter;
import com.tencent.mobileqq.intervideo.now.NowProxyParamParser;
import com.tencent.mobileqq.intervideo.yiqikan.OnOpenCloseRoomCallback;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class NowEntry
{
  NowDataReporter a = PluginManagerInterfaceImpl.a().d();
  QQAppInterface b;
  long c = 0L;
  ActionCallback d = new NowEntry.4(this);
  private OnOpenCloseRoomCallback e;
  
  public NowEntry(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
  }
  
  private boolean a(String paramString)
  {
    return (TextUtils.isEmpty(paramString)) || (paramString.startsWith("//"));
  }
  
  private void c(Bundle paramBundle)
  {
    String str = paramBundle.getString("coverurl");
    if (!TextUtils.isEmpty(str))
    {
      localObject2 = AbsDownloader.getFile(str);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append("?busiType=3");
        localObject1 = AbsDownloader.getFile(((StringBuilder)localObject1).toString());
      }
      if (localObject1 != null)
      {
        localObject1 = ((File)localObject1).getAbsolutePath();
        break label73;
      }
    }
    Object localObject1 = "";
    label73:
    paramBundle.putString("cover_file", (String)localObject1);
    paramBundle.putString("appid", "2");
    paramBundle.putString("uid", this.b.getCurrentUin());
    paramBundle.putString("hostVersion", String.valueOf(ApkUtils.a(BaseApplicationImpl.getContext())));
    localObject1 = Uri.parse(paramBundle.getString("mqqScheme", "")).getQuery();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("&action=openroom");
    NowLive.doActionWithExtra(((StringBuilder)localObject2).toString(), paramBundle, this.d);
  }
  
  public void a()
  {
    this.b = null;
  }
  
  public void a(Bundle paramBundle)
  {
    a(paramBundle, null);
  }
  
  public void a(Bundle paramBundle, OnOpenCloseRoomCallback paramOnOpenCloseRoomCallback)
  {
    this.e = paramOnOpenCloseRoomCallback;
    paramOnOpenCloseRoomCallback = paramBundle.getString("mqqUrl", "");
    long l = System.currentTimeMillis();
    if ((l - this.c < 1000L) && (!NowProxyParamParser.h(paramBundle).equals("1")))
    {
      paramBundle = new StringBuilder();
      paramBundle.append("开始处理mqq　scheme,time = ");
      paramBundle.append(System.currentTimeMillis());
      paramBundle.append(" 点太快了");
      QLog.i("DynamicNow | NowEntry", 1, paramBundle.toString());
      QQToast.makeText(BaseApplicationImpl.getContext(), HardCodeUtil.a(2131905483), 0).show();
      return;
    }
    this.c = l;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("开始进入now结合版,time = ");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append(" mqqScheme = ");
    localStringBuilder.append(paramOnOpenCloseRoomCallback);
    QLog.i("DynamicNow | NowEntry", 1, localStringBuilder.toString());
    paramBundle.putInt("action", 1);
    b(paramBundle);
  }
  
  public void b(Bundle paramBundle)
  {
    Object localObject1 = NowProxyParamParser.b(paramBundle);
    Object localObject2 = NowProxyParamParser.f(paramBundle);
    long l = NowProxyParamParser.a(paramBundle);
    this.a.a(false, (String)localObject2, String.valueOf(l), (String)localObject1, false, false, true);
    paramBundle.putLong("entryTime", System.currentTimeMillis());
    localObject1 = paramBundle.getString("coverurl");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("?busiType=3");
    localObject2 = ((StringBuilder)localObject2).toString();
    if ((!a((String)localObject1)) && (AbsDownloader.getFile((String)localObject1) == null) && (AbsDownloader.getFile((String)localObject2) == null))
    {
      localObject2 = new AtomicBoolean(false);
      l = System.currentTimeMillis();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start to download cover pic  url = ");
      localStringBuilder.append((String)localObject1);
      QLog.i("DynamicNow | NowEntry", 1, localStringBuilder.toString());
      localObject1 = URLDrawable.getDrawable((String)localObject1, URLDrawable.URLDrawableOptions.obtain());
      ((URLDrawable)localObject1).setURLDrawableListener(new NowEntry.1(this, l, (AtomicBoolean)localObject2, paramBundle));
      if (((URLDrawable)localObject1).getStatus() != 1)
      {
        ((AtomicBoolean)localObject2).set(false);
        ThreadManagerV2.excute(new NowEntry.2(this, (URLDrawable)localObject1), 128, null, false);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new NowEntry.3(this, (AtomicBoolean)localObject2, paramBundle), 500L);
        return;
      }
      QLog.i("DynamicNow | NowEntry", 1, "exception case!");
      ((AtomicBoolean)localObject2).set(true);
      c(paramBundle);
      return;
    }
    c(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.NowEntry
 * JD-Core Version:    0.7.0.1
 */