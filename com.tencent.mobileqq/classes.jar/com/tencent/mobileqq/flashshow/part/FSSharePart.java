package com.tencent.mobileqq.flashshow.part;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.QCircleHostClassHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.AppConstants.Key;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.ForwardType;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._BigBrotherSource;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._ChatActivityConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._ForwardRecentActivity;
import com.tencent.biz.qcircleshadow.lib.variation.HostAppSettingUtil;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostForwardUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.flashshow.api.bean.FSReportBean;
import com.tencent.mobileqq.flashshow.application.FSApplication;
import com.tencent.mobileqq.flashshow.bean.FSEvilReportInfo.Builder;
import com.tencent.mobileqq.flashshow.bean.FSEvilReportInfo.ContentIdBuilder;
import com.tencent.mobileqq.flashshow.bean.FSShareInfo;
import com.tencent.mobileqq.flashshow.events.FSFeedEvent;
import com.tencent.mobileqq.flashshow.events.FSOpenH5Event;
import com.tencent.mobileqq.flashshow.lib.listener.FSWXShareListener;
import com.tencent.mobileqq.flashshow.manager.FSRichMediaDownLoadManager;
import com.tencent.mobileqq.flashshow.manager.FSRichMediaDownLoadManager.DownLoadParams;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11002;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11002.DataBuilder;
import com.tencent.mobileqq.flashshow.request.FSGetHeadUrlRequest;
import com.tencent.mobileqq.flashshow.thread.FSThreadUtils;
import com.tencent.mobileqq.flashshow.utils.FSEvilReportUtils;
import com.tencent.mobileqq.flashshow.utils.FSHardCodeUtil;
import com.tencent.mobileqq.flashshow.utils.FSShareUtils;
import com.tencent.mobileqq.flashshow.utils.FSToastUtil;
import com.tencent.mobileqq.flashshow.utils.FSTransUtils;
import com.tencent.mobileqq.flashshow.widgets.common.FSCustomDialog;
import com.tencent.mobileqq.flashshow.widgets.share.FSProgressDialog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.share.api.ShareConfig;
import com.tencent.mobileqq.wxapi.api.IWXShareHelper;
import com.tencent.qcircle.cooperation.config.SharePreferenceUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneShareApi;
import com.tencent.richframework.text.rich.parser.RichTextAtParser;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StShare;
import feedcloud.FeedCloudMeta.StShareQzoneInfo;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import feedcloud.FeedCloudMeta.StVideoUrl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class FSSharePart
  extends FSBasePart
{
  private FSShareUtils a;
  private HostForwardUtils b;
  private FSShareInfo c;
  private FSWXShareListener d;
  private FeedCloudMeta.StFeed e;
  private String f;
  private byte[] g = null;
  private String h;
  private FSProgressDialog i;
  private boolean j = true;
  private boolean k = false;
  private Handler l = FSThreadUtils.a();
  private Activity m;
  private FSRichMediaDownLoadManager.DownLoadParams n;
  private long o = 0L;
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    if ((paramString.length() <= 30) && (paramString.getBytes().length <= 100)) {
      return paramString;
    }
    Object localObject = paramString;
    if (paramString.length() > 30) {
      localObject = paramString.substring(0, 30);
    }
    paramString = (String)localObject;
    if (Math.min(((String)localObject).getBytes().length, 100) == 100)
    {
      int i1 = ((String)localObject).length() / 2;
      paramString = new StringBuilder(((String)localObject).substring(0, i1));
      while (paramString.toString().getBytes().length < 100)
      {
        paramString.append(((String)localObject).charAt(i1));
        i1 += 1;
      }
      paramString = paramString.toString();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("...");
    return ((StringBuilder)localObject).toString();
  }
  
  private void a(Activity paramActivity)
  {
    if (this.i == null) {
      this.i = new FSProgressDialog(paramActivity);
    }
  }
  
  private void a(Context paramContext)
  {
    this.a = new FSShareUtils(paramContext);
    this.a.a(new FSSharePart.1(this));
    this.a.a(new FSSharePart.2(this));
  }
  
  private void a(@NonNull Intent paramIntent)
  {
    a(paramIntent, HostForwardUtils.HOST_FORWARD_RECENTLY_CHAT_FLAG());
    if (this.b == null)
    {
      QLog.w("FSSharePart", 1, "[openHostEnvironment] host forward api should be not null.");
      return;
    }
    HostUIHelper.openHostEnvironment(new FSSharePart.7(this, paramIntent));
  }
  
  private void a(Intent paramIntent, String paramString)
  {
    if (this.b == null) {
      this.b = new HostForwardUtils();
    }
    if (this.c == null)
    {
      QLog.d("FSSharePart", 1, "[createHostForwardApi] share info should not be null.");
      return;
    }
    this.b.registerForwardReportParam(paramIntent, 0, 0, null);
    this.b.registerForwardResultReceiver(paramIntent);
    this.b.addForwardType(paramIntent, paramString);
  }
  
  private void a(String paramString, int paramInt)
  {
    Intent localIntent = r();
    if (localIntent == null)
    {
      QLog.d("FSSharePart", 1, "[shareToSpecifiedFriend] intent == null, not handler.");
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(QCircleHostConstants._ForwardRecentActivity.KEY_REQ(), QCircleHostConstants._ForwardRecentActivity.REQ_DIRECT_SHOW_DIALOG());
    localBundle.putInt(QCircleHostConstants._ForwardRecentActivity.KEY_DIRECT_SHOW_UIN_TYPE(), paramInt);
    localBundle.putString(QCircleHostConstants._ForwardRecentActivity.KEY_DIRECT_SHOW_UIN(), paramString);
    localIntent.putExtras(localBundle);
    a(localIntent);
    QLog.d("FSSharePart", 1, "[shareToSpecifiedFriend] handler success.");
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    FSShareUtils localFSShareUtils = this.a;
    if (localFSShareUtils != null) {
      localFSShareUtils.a();
    }
    if (!paramBoolean1) {
      d();
    }
  }
  
  private void b(Context paramContext)
  {
    if ((c() != null) && (c().getBaseContext() != null) && (this.c != null))
    {
      long l1 = System.currentTimeMillis();
      if (l1 - this.o > 800L)
      {
        this.o = l1;
        FSShareUtils localFSShareUtils = this.a;
        if ((localFSShareUtils != null) && (localFSShareUtils.b()))
        {
          QLog.e("FSSharePart", 1, "[showActionSheet] current is showing state, not repeat show.");
          return;
        }
        QLog.d("FSSharePart", 1, "showActionSheet");
        a(paramContext);
        if (this.a == null) {
          return;
        }
        paramContext = r();
        this.a.a(paramContext);
        this.a.a(0, 0, 0);
        this.a.a(m());
        this.a.a(new FSSharePart.5(this));
        this.a.a(true);
        paramContext = new StringBuilder();
        paramContext.append("showActionSheet  feedId : ");
        paramContext.append(this.c.a.id.get());
        paramContext.append(" , userId : ");
        paramContext.append(this.c.a.poster.id.get());
        QLog.d("FSSharePart", 1, paramContext.toString());
      }
      return;
    }
    FSToastUtil.a(FSHardCodeUtil.a(2131911962), 0);
  }
  
  private void b(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject1 = this.c;
    if ((localObject1 != null) && (((FSShareInfo)localObject1).a != null) && (this.c.a.share != null))
    {
      if (c() == null) {
        return;
      }
      Object localObject2 = g();
      if (paramBoolean) {
        localObject1 = "share_type_wechat";
      } else {
        localObject1 = "share_type_temp_circle";
      }
      SharePreferenceUtils.a((Context)localObject2, "share_lately_type_key", (String)localObject1);
      localObject1 = new FSLpReportDc11002.DataBuilder(this.c.a, l());
      int i1;
      if (paramBoolean) {
        i1 = 27;
      } else {
        i1 = 28;
      }
      FSLpReportDc11002.a(((FSLpReportDc11002.DataBuilder)localObject1).a(i1).b(2).a(this.c.a.poster.id.get()));
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.c.a.share.url.get());
      ((StringBuilder)localObject1).append("&sharecategory=1");
      localObject2 = ((StringBuilder)localObject1).toString();
      String str1 = a(this.c.a.share.title.get());
      String str2 = a(this.c.a.share.desc.get());
      localObject1 = new HashMap(1);
      if ((localObject2 != null) && (!((String)localObject2).isEmpty()))
      {
        if (!((IWXShareHelper)QRoute.api(IWXShareHelper.class)).isWXInstalled())
        {
          FSToastUtil.a(FSToastUtil.b, FSTransUtils.f().getResources().getString(2131918154), 0);
          return;
        }
        if (!((IWXShareHelper)QRoute.api(IWXShareHelper.class)).isWXsupportApi())
        {
          FSToastUtil.a(FSToastUtil.b, FSTransUtils.f().getResources().getString(2131918155), 0);
          return;
        }
        t();
        localObject2 = new FSSharePart.9(this, (Map)localObject1, paramBoolean, str1, str2, (String)localObject2);
        if ((TextUtils.isEmpty(this.c.a.poster.id.get())) && (TextUtils.isEmpty(this.c.a.share.cover.picUrl.get())))
        {
          QLog.d("FSSharePart", 1, "shareToWeChat no picture");
          ((Runnable)localObject2).run();
          return;
        }
        a(c());
        this.i.a(2131891516);
        if ((c() != null) && (!c().isFinishing())) {
          this.i.show();
        }
        RFThreadManager.execute(new FSSharePart.10(this, (Map)localObject1, (Runnable)localObject2));
        return;
      }
      FSToastUtil.a(FSToastUtil.c, FSHardCodeUtil.a(2131911948), 0);
    }
  }
  
  private void d()
  {
    FSShareUtils localFSShareUtils = this.a;
    if ((localFSShareUtils != null) && (localFSShareUtils.b()))
    {
      this.a.a();
      QLog.d("FSSharePart", 1, "safeCloseSheet  dismiss");
      if (this.l == null) {
        this.l = new Handler(Looper.getMainLooper());
      }
    }
    e();
  }
  
  private void e()
  {
    Handler localHandler = this.l;
    if (localHandler == null)
    {
      QLog.e("FSSharePart", 1, "mUIHandler == null");
      return;
    }
    localHandler.postDelayed(new FSSharePart.3(this), 200L);
  }
  
  private void f()
  {
    c("SHOW_DEBUG_INFO", this.c);
  }
  
  private ShareConfig m()
  {
    ShareConfig localShareConfig = new ShareConfig();
    localShareConfig.isShowShareToFriend = true;
    localShareConfig.isForceNightTheme = true;
    localShareConfig.isShowShareToQZone = true;
    localShareConfig.isShowShareToWechat = true;
    localShareConfig.isShowShareToWechatCircle = true;
    localShareConfig.isShowReport = true;
    localShareConfig.isShowFeedback = true;
    Object localObject = this.c;
    if (localObject == null) {
      return localShareConfig;
    }
    if (((FSShareInfo)localObject).h) {
      localShareConfig.isShowDelete = true;
    }
    boolean bool1 = o();
    boolean bool2 = this.c.j;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append(" | ");
    ((StringBuilder)localObject).append(n());
    QLog.d("FSSharePart", 1, new Object[] { "[Share-getShareConfig] isShowDownLoad: ", Boolean.valueOf(bool2), " | hasMarkUrl: ", ((StringBuilder)localObject).toString() });
    if ((this.c.j) && (bool1)) {
      localShareConfig.isShowSave = true;
    }
    if (this.c.i) {
      localShareConfig.isShowDisLike = true;
    }
    if (!HostAppSettingUtil.isPublicVersion()) {
      localShareConfig.isShowDebug = true;
    }
    return localShareConfig;
  }
  
  private String n()
  {
    if (this.e == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    List localList = this.e.opMask2.get();
    localStringBuilder.append("feedId: ");
    localStringBuilder.append(this.e.id.get());
    localStringBuilder.append(" | ");
    localStringBuilder.append("opMask2: ");
    int i2 = 0;
    int i1;
    if (localList == null) {
      i1 = 0;
    } else {
      i1 = localList.size();
    }
    while (i2 < i1)
    {
      Object localObject = localList.get(i2);
      if (localObject != null)
      {
        localStringBuilder.append(localObject);
        if (i2 < i1 - 1) {
          localStringBuilder.append("|");
        }
      }
      i2 += 1;
    }
    return localStringBuilder.toString();
  }
  
  private boolean o()
  {
    Object localObject = this.c;
    if ((localObject != null) && (((FSShareInfo)localObject).a != null) && (this.c.a.type.get() == 3))
    {
      localObject = this.c.a.video.vecVideoUrl.get();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        int i1 = 0;
        while (i1 < ((List)localObject).size())
        {
          if (((FeedCloudMeta.StVideoUrl)((List)localObject).get(i1)).levelType.get() == 20) {
            return true;
          }
          i1 += 1;
        }
      }
    }
    return true;
  }
  
  private void p()
  {
    Object localObject = this.c;
    if ((localObject != null) && (((FSShareInfo)localObject).a != null))
    {
      if (c() == null) {
        return;
      }
      if (!HostNetworkUtils.isNetworkAvailable())
      {
        FSToastUtil.a(FSHardCodeUtil.a(2131889526), 0);
        QLog.d("FSSharePart", 4, "network not available");
        return;
      }
      localObject = "";
      this.n = new FSRichMediaDownLoadManager.DownLoadParams();
      if (TextUtils.isEmpty(""))
      {
        localObject = this.c.a.video.playUrl.get();
        QLog.d("FSSharePart", 1, "get origin video downLoad url success");
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("final download url = ");
      localStringBuilder.append((String)localObject);
      QLog.d("FSSharePart", 1, localStringBuilder.toString());
      this.n.a((String)localObject, 0, this.c.a.id.get());
      this.n.a(new FSSharePart.6(this));
      if (E() != null) {
        c("rich_media_download_show", null);
      }
      FSRichMediaDownLoadManager.a().a(this.n);
    }
  }
  
  private void q()
  {
    Intent localIntent = r();
    if ((localIntent == null) && (c() != null))
    {
      FSToastUtil.a(FSHardCodeUtil.a(2131911951), 0);
      return;
    }
    if (c() != null)
    {
      this.k = true;
      FeedCloudMeta.StFeed localStFeed = this.c.a;
      a(localIntent, HostForwardUtils.HOST_FORWARD_RECENTLY_CHAT_FLAG());
      c().startActivityForResult(localIntent, QCircleHostConstants._ChatActivityConstants.FORWARD_REQUEST());
      QLog.d("FSSharePart", 1, "shareToQQ  success");
    }
    FSLpReportDc11002.a(new FSLpReportDc11002.DataBuilder(this.c.a, l()).a(25).b(2).a(this.c.a.poster.id.get()));
    SharePreferenceUtils.a(g(), "share_lately_type_key", "share_type_qq");
  }
  
  private Intent r()
  {
    Object localObject1 = this.c;
    if ((localObject1 != null) && (((FSShareInfo)localObject1).a != null) && (this.c.a.share != null) && (c() != null))
    {
      Intent localIntent = new Intent(c().getApplicationContext(), QCircleHostClassHelper.getForwardRecentActivityClass());
      try
      {
        localObject1 = new JSONObject(RichTextAtParser.a(this.c.a.share.shareCardInfo.get()));
        String str1 = ((JSONObject)localObject1).optString("app");
        String str2 = ((JSONObject)localObject1).optString("ver");
        String str3 = ((JSONObject)localObject1).optString("view");
        localObject2 = ((JSONObject)localObject1).optString("meta");
        localObject1 = ((JSONObject)localObject1).optString("prompt");
        localIntent.putExtra(QCircleHostConstants.AppConstants.Key.FORWARD_TYPE(), QCircleHostConstants.ForwardType.SEND_ARK_MSG());
        localIntent.putExtra(QCircleHostConstants.AppConstants.Key.FORWARD_DISPLAY_ARK(), true);
        localIntent.putExtra(QCircleHostConstants.AppConstants.Key.FORWARD_ARK_APP_NAME(), str1);
        localIntent.putExtra(QCircleHostConstants.AppConstants.Key.FORWARD_ARK_APP_VIEW(), str3);
        localIntent.putExtra(QCircleHostConstants.AppConstants.Key.FORWARD_ARK_APP_VER(), str2);
        localIntent.putExtra(QCircleHostConstants.AppConstants.Key.FORWARD_ARK_APP_PROMPT(), (String)localObject1);
        localIntent.putExtra(QCircleHostConstants.AppConstants.Key.FORWARD_ARK_APP_META(), (String)localObject2);
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject2;
          if (((String)localObject2).contains("\"isAIO\":1")) {
            localObject1 = ((String)localObject2).replace("\"isAIO\":1", "\"isAIO\":0");
          }
        }
        localIntent.putExtras(HostDataTransUtils.getArkDialogZipArgs(str1, str3, str2, (String)localObject1));
        return localIntent;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getShareArkIntent  exception message: ");
        ((StringBuilder)localObject2).append(localJSONException.getMessage());
        QLog.d("FSSharePart", 1, ((StringBuilder)localObject2).toString());
        return localIntent;
      }
    }
    return null;
  }
  
  private void s()
  {
    Object localObject1 = this.c;
    if ((localObject1 != null) && (((FSShareInfo)localObject1).a != null) && (this.c.a.share != null))
    {
      if (c() == null) {
        return;
      }
      Bundle localBundle = new Bundle();
      localObject1 = this.c.a.share.shareQzoneInfo.entrys.get();
      HashMap localHashMap = new HashMap();
      String str = null;
      Object localObject2;
      Object localObject4;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (FeedCloudCommon.Entry)((Iterator)localObject1).next();
          localHashMap.put(((FeedCloudCommon.Entry)localObject2).key.get(), ((FeedCloudCommon.Entry)localObject2).value.get());
        }
        localObject1 = (String)localHashMap.get("COVERURL");
        localObject2 = (String)localHashMap.get("title");
        str = (String)localHashMap.get("summary");
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append((String)localHashMap.get("actionurl"));
        ((StringBuilder)localObject4).append("&from=7");
        localObject4 = ((StringBuilder)localObject4).toString();
      }
      else
      {
        localObject2 = null;
        localObject1 = localObject2;
        localObject4 = localObject1;
      }
      localBundle.putSerializable(QCircleHostConstants.AppConstants.Key.SHARE_REQ_SHARE_QZONE_INFO(), HostDataTransUtils.wrapSerializableMap(localHashMap));
      localBundle.putString(QCircleHostConstants.AppConstants.Key.SHARE_REQ_TITLE(), (String)localObject2);
      localBundle.putString(QCircleHostConstants.AppConstants.Key.SHARE_REQ_DESC(), str);
      localBundle.putString(QCircleHostConstants.AppConstants.Key.SHARE_REQ_DETAIL_URL(), (String)localObject4);
      localBundle.putLong(QCircleHostConstants.AppConstants.Key.SHARE_REQ_ID(), 0L);
      FSLpReportDc11002.a(new FSLpReportDc11002.DataBuilder(this.c.a, l()).a(26).b(2).a(this.c.a.poster.id.get()));
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (((String)localObject1).startsWith("avatar://"))
        {
          long l1;
          try
          {
            l1 = Long.parseLong(((String)localObject1).substring(9));
          }
          catch (Exception localException)
          {
            QLog.e("FSSharePart", 1, "shareToQZone() parse uin error!", localException);
            l1 = 0L;
          }
          if (l1 > 0L)
          {
            localObject3 = new FSGetHeadUrlRequest(Long.parseLong(FSTransUtils.a()), l1);
            VSNetworkHelper.getInstance().sendRequest(g(), (BaseRequest)localObject3, new FSSharePart.8(this, (String)localObject1, localBundle));
            return;
          }
        }
        Object localObject3 = new ArrayList(1);
        ((ArrayList)localObject3).add(localObject1);
        localBundle.putStringArrayList(QCircleHostConstants.AppConstants.Key.SHARE_REQ_IMAGE_URL(), (ArrayList)localObject3);
      }
      this.k = true;
      localBundle.putSerializable(QCircleHostConstants.AppConstants.Key.SHARE_REQ_SHARE_QZONE_INFO(), HostDataTransUtils.wrapSerializableMap(localHashMap));
      ((IQzoneShareApi)QRoute.api(IQzoneShareApi.class)).jumpToQzoneShare(FSTransUtils.a(), c(), localBundle, null, -1);
      if (QLog.isColorLevel()) {
        QLog.d("FSSharePart", 1, "shareToQZone  success");
      }
      SharePreferenceUtils.a(g(), "share_lately_type_key", "share_type_qzone");
    }
  }
  
  private void t()
  {
    if (this.d != null) {
      return;
    }
    this.d = new FSSharePart.11(this);
    ((IWXShareHelper)QRoute.api(IWXShareHelper.class)).addObserver(this.d);
  }
  
  private void u()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      if (((FSShareInfo)localObject).a == null) {
        return;
      }
      localObject = new FSFeedEvent(1).setFeedId(this.c.a.id.get());
      SimpleEventBus.getInstance().dispatchEvent((SimpleBaseEvent)localObject);
      FSToastUtil.a(g().getString(2131889512), 0);
      FSLpReportDc11002.a(new FSLpReportDc11002.DataBuilder(this.c.a, l()).a(130).b(2).a(this.c.a.poster.id.get()));
    }
  }
  
  private void v()
  {
    Object localObject = this.c;
    if ((localObject != null) && (((FSShareInfo)localObject).a != null))
    {
      if (c() == null) {
        return;
      }
      localObject = new FSSharePart.12(this);
      localObject = FSCustomDialog.a(g(), null, FSHardCodeUtil.a(2131889517), 2131887648, 2131887629, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
      if ((c() != null) && (!c().isFinishing())) {
        ((FSCustomDialog)localObject).show();
      }
    }
  }
  
  private void w()
  {
    Object localObject = this.c;
    if ((localObject != null) && (((FSShareInfo)localObject).a != null))
    {
      if (g() == null) {
        return;
      }
      SimpleEventBus.getInstance().dispatchEvent(new FSOpenH5Event(true));
      localObject = new FSEvilReportInfo.Builder();
      String str = new FSEvilReportInfo.ContentIdBuilder().b(this.c.a.id.get()).d(String.valueOf(this.c.a.createTime.get())).a();
      ((FSEvilReportInfo.Builder)localObject).c(this.c.a.poster.id.get()).b("25088").a("ks_video").d(str);
      FSEvilReportUtils.a(((FSEvilReportInfo.Builder)localObject).a());
      FSLpReportDc11002.a(new FSLpReportDc11002.DataBuilder(this.c.a, l()).a(142).b(2).q(this.c.a.id.get()).a(this.c.a.poster.id.get()));
    }
  }
  
  private void x()
  {
    Object localObject1 = this.c;
    if ((localObject1 != null) && (((FSShareInfo)localObject1).a != null))
    {
      if (g() == null) {
        return;
      }
      Object localObject2 = this.c.a.feedbackUrl.get();
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return;
      }
      localObject1 = new Intent();
      SimpleEventBus.getInstance().dispatchEvent(new FSOpenH5Event(true));
      ((Intent)localObject1).setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserDelegationActivity");
      ((Intent)localObject1).putExtra("url", (String)localObject2);
      localObject2 = FSApplication.APP;
      if (!(localObject2 instanceof Activity)) {
        ((Intent)localObject1).addFlags(268435456);
      }
      ((Context)localObject2).startActivity((Intent)localObject1);
      FSLpReportDc11002.a(new FSLpReportDc11002.DataBuilder(this.c.a, l()).a(141).b(2).a(this.c.a.poster.id.get()));
    }
  }
  
  public String a()
  {
    return "FSSharePart";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onActivityResult:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",");
    localStringBuilder.append(paramInt2);
    QLog.d("FSSharePart", 4, localStringBuilder.toString());
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (TextUtils.equals(paramString, "share_action_show_share_sheet"))
    {
      if (FastClickUtils.a("FSShareParthandleBroadcastMessage", 500L)) {
        return;
      }
      if ((paramObject instanceof FSShareInfo))
      {
        this.c = ((FSShareInfo)paramObject);
        if (this.c.b != null) {
          this.c.b.mFeed = this.c.a;
        }
        this.e = this.c.a;
        paramString = this.e;
        if (paramString != null)
        {
          this.f = paramString.id.get();
          if (this.e.busiReport.has()) {
            this.g = this.e.busiReport.get().toByteArray();
          }
        }
      }
      paramString = new Intent();
      paramString.putExtra(QCircleHostConstants._BigBrotherSource.KEY(), QCircleHostConstants._BigBrotherSource.SRC_JC_WEZONE());
      HostUIHelper.openHostEnvironment(new FSSharePart.4(this), paramString);
    }
  }
  
  public Activity c()
  {
    Activity localActivity2 = this.m;
    Activity localActivity1 = localActivity2;
    if (localActivity2 == null) {
      localActivity1 = super.c();
    }
    return localActivity1;
  }
  
  public Context g()
  {
    return c();
  }
  
  public FSReportBean l()
  {
    FSShareInfo localFSShareInfo = this.c;
    if ((localFSShareInfo != null) && (localFSShareInfo.c != null)) {
      return this.c.c;
    }
    return super.l();
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    if (this.l != null) {
      this.l = null;
    }
    if (this.d != null) {
      ((IWXShareHelper)QRoute.api(IWXShareHelper.class)).removeObserver(this.d);
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    if ((this.k) && (g() != null)) {
      FSToastUtil.a(FSToastUtil.d, g().getString(2131895928), 0);
    }
    this.k = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSSharePart
 * JD-Core Version:    0.7.0.1
 */