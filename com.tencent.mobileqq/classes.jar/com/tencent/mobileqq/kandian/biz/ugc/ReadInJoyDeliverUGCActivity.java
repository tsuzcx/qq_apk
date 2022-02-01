package com.tencent.mobileqq.kandian.biz.ugc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationReadInJoy;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationReadInJoy;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.HotPicDownLoader;
import com.tencent.mobileqq.hotpic.HotPicManager;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.mobileqq.hotpic.HotVideoPreviewDownloader;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyNinePicDeliverDynamicGridView;
import com.tencent.mobileqq.kandian.base.view.widget.text.PositionalSpanStruct;
import com.tencent.mobileqq.kandian.biz.biu.BiuEditText;
import com.tencent.mobileqq.kandian.biz.biu.BiuNicknameSpan;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.diandian.entryview.RIJEntryViewUtils;
import com.tencent.mobileqq.kandian.biz.flutter.JumpToRIJPublisherSuccessPageUtils;
import com.tencent.mobileqq.kandian.biz.publisher.api.impl.KanDianPublisher;
import com.tencent.mobileqq.kandian.biz.publisher.report.PublisherReportUtils;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.ugc.api.impl.RIJDeliverUGCUtils;
import com.tencent.mobileqq.kandian.biz.ugc.camera.api.impl.ReadInJoyCaptureLauncher;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.kandian.glue.text.JumpSpan;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.kandian.repo.handler.JumpInfo;
import com.tencent.mobileqq.kandian.repo.handler.RIJPublishTrendsHandler;
import com.tencent.mobileqq.kandian.repo.handler.TopicInfo;
import com.tencent.mobileqq.kandian.repo.handler.TopicInfo.Builder;
import com.tencent.mobileqq.kandian.repo.ugc.DeliverData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.aio.AioPicTransFileController;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import com.tencent.tkd.topicsdk.kdcommunity.SelectKDCommunityView;
import com.tencent.tkd.topicsdk.kdcommunity.SelectKDCommunityView.Companion;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyDeliverUGCActivity
  extends ReadInJoyBaseDeliverActivity
{
  public static Drawable a = new ColorDrawable(-855310);
  private int aA = 0;
  private int aB = 0;
  private int aC = 0;
  private int aD = 0;
  private int aE = 40000;
  private int aF = 0;
  private String aG = "";
  private String aH;
  private int aI;
  private JSONObject aJ = new JSONObject();
  private long aK = 0L;
  private boolean aL;
  private boolean aM;
  private boolean aN;
  private Handler aO = new Handler();
  private boolean aP = false;
  private ArrayList<BiuCommentInfo> aQ;
  private List<String> ag = new ArrayList();
  private List<Integer> ah = new ArrayList();
  private List<ReadInJoyDeliverUGCActivity.UGCTransProcessorHandler> ai = Collections.synchronizedList(new ArrayList());
  private List<TransferRequest> aj = Collections.synchronizedList(new ArrayList());
  private List<String> ak = Collections.synchronizedList(new ArrayList());
  private boolean al = false;
  private boolean am = false;
  private boolean an = false;
  private boolean ao = false;
  private boolean ap = false;
  private boolean aq = false;
  private boolean ar = false;
  private ReadInJoyNinePicDeliverDynamicGridView as;
  private ActionSheet at;
  private QQProgressDialog au;
  private TextView av;
  private ReadInJoyNinePicAdapter aw;
  private DeliverData ax = new DeliverData();
  private ReadInJoyDeliverUGCActivity.ReportInfo ay = new ReadInJoyDeliverUGCActivity.ReportInfo(this);
  private CommunityInfo az;
  ProtoUtils.TroopProtocolObserver b = new ReadInJoyDeliverUGCActivity.17(this);
  private float c;
  private float d;
  
  private void A()
  {
    if ((this.aI == 1) && (N() == 0))
    {
      QQToast.makeText(this, 1, HardCodeUtil.a(2131910433), 0).show();
      return;
    }
    if ((this.ar) && (this.az == null))
    {
      QQToast.makeText(this, 1, getResources().getString(2131915344), 0).show();
      return;
    }
    c();
  }
  
  private void B()
  {
    SelectKDCommunityView.Companion localCompanion = SelectKDCommunityView.a;
    Object localObject = this.az;
    if (localObject != null) {
      localObject = ((CommunityInfo)localObject).getCommunityId();
    } else {
      localObject = "";
    }
    localCompanion.a(this, (String)localObject, new ReadInJoyDeliverUGCActivity.7(this));
    d("0X800BB30");
  }
  
  private void C()
  {
    if (this.W != -1L) {
      ThreadManager.getSubThreadHandler().post(new ReadInJoyDeliverUGCActivity.8(this));
    }
  }
  
  private void D()
  {
    if ((Build.VERSION.SDK_INT >= 23) && (checkSelfPermission("android.permission.CAMERA") != 0))
    {
      requestPermissions(new ReadInJoyDeliverUGCActivity.11(this), 2000, new String[] { "android.permission.CAMERA" });
      return;
    }
    u();
  }
  
  private void E()
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this, "/base/album/photolist");
    localActivityURIRequest.extra().putInt("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    localActivityURIRequest.extra().putString("PhotoConst.MY_UIN", this.app.getAccount());
    localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ReadInJoyDeliverUGCActivity.class.getName());
    localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localActivityURIRequest.extra().putInt("extra.busi_type", 8);
    localActivityURIRequest.extra().putBoolean("PhotoConst.HANDLE_DEST_RESULT", false);
    localActivityURIRequest.extra().putInt("PhotoConst.MAXUM_SELECTED_NUM", 9 - N());
    localActivityURIRequest.extra().putInt("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    localActivityURIRequest.extra().putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    if (9 - N() == 1) {
      localActivityURIRequest.extra().putBoolean("from_readinjoy_ugc", true);
    } else {
      localActivityURIRequest.extra().putBoolean("from_readinjoy_ugc_deliver_preview", true);
    }
    localActivityURIRequest.extra().putBoolean("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
    localActivityURIRequest.extra().putBoolean("PhotoConst.original_button", false);
    localActivityURIRequest.extra().putInt("enter_from", 25);
    localActivityURIRequest.extra().putString("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationReadInJoy.a);
    localActivityURIRequest.extra().putString("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationReadInJoy.a);
    this.aD = 1000;
    localActivityURIRequest.setRequestCode(this.aD);
    QRoute.startUri(localActivityURIRequest);
    overridePendingTransition(2130771996, 2130771994);
  }
  
  private void F()
  {
    ReadInJoyCaptureLauncher.getInstance().launchPhotoCapture(this);
    this.aD = 1001;
    overridePendingTransition(2130771996, 2130771994);
  }
  
  private void G()
  {
    ThreadManager.executeOnFileThread(new ReadInJoyDeliverUGCActivity.12(this));
  }
  
  private String H()
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        i = r().intValue();
        int j = 1;
        if (i > 0)
        {
          i = 1;
          localJSONObject.put("topic", i);
          String str3 = q();
          String str1 = str3;
          if ("0".equalsIgnoreCase(str3)) {
            str1 = "";
          }
          localJSONObject.put("topicid", str1);
          localJSONObject.put("topic_num", r());
          localJSONObject.put("sticker", RIJDeliverUGCReportUtil.e(k()));
          if (this.T == null) {
            break label274;
          }
          i = 1;
          localJSONObject.put("location", i);
          if (!k().contains("@")) {
            break label279;
          }
          i = 1;
          localJSONObject.put("at", i);
          if (!K()) {
            break label284;
          }
          i = 1;
          localJSONObject.put("gif", i);
          if (N() <= 0) {
            break label289;
          }
          i = j;
          localJSONObject.put("pic", i);
          if (this.az == null) {
            break label294;
          }
          str1 = this.az.getCommunityId();
          localJSONObject.put("kdcommunity_id", str1);
          localJSONObject.put("from", PublisherReportUtils.a.b(this.ac));
          str1 = localJSONObject.toString();
          return str1;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return "";
      }
      int i = 0;
      continue;
      label274:
      i = 0;
      continue;
      label279:
      i = 0;
      continue;
      label284:
      i = 0;
      continue;
      label289:
      i = 0;
      continue;
      label294:
      String str2 = "";
    }
  }
  
  private void I()
  {
    p();
    a(1, getString(2131915349));
    m();
    QLog.d("ReadInJoyDeliverUGCActivity", 2, "startUploadPic oncommon error!");
  }
  
  private void J()
  {
    if (N() == 0) {
      return;
    }
    int i = this.ac;
    boolean bool2 = true;
    if ((i != 1) && (this.ac != 8) && (this.ac != 9)) {
      return;
    }
    Object localObject = Aladdin.getConfig(494);
    if ((localObject != null) && (((AladdinConfig)localObject).getIntegerFromString("intro_after_publish_trend", 0) == 1))
    {
      JumpToRIJPublisherSuccessPageUtils localJumpToRIJPublisherSuccessPageUtils = new JumpToRIJPublisherSuccessPageUtils();
      localJumpToRIJPublisherSuccessPageUtils.a(((AladdinConfig)localObject).getIntegerFromString("trend_intro_type", 0));
      localJumpToRIJPublisherSuccessPageUtils.a(((AladdinConfig)localObject).getString("trend_intro_title", ""));
      localJumpToRIJPublisherSuccessPageUtils.b(((AladdinConfig)localObject).getString("trend_intro_text", ""));
      localJumpToRIJPublisherSuccessPageUtils.c(((AladdinConfig)localObject).getString("trend_segue_button_left_title", ""));
      localJumpToRIJPublisherSuccessPageUtils.d(((AladdinConfig)localObject).getString("trend_segue_button_left_url", ""));
      localJumpToRIJPublisherSuccessPageUtils.e(((AladdinConfig)localObject).getString("trend_segue_button_right_title", ""));
      localJumpToRIJPublisherSuccessPageUtils.f(((AladdinConfig)localObject).getString("trend_segue_button_right_url", ""));
      localJumpToRIJPublisherSuccessPageUtils.l(((AladdinConfig)localObject).getString("trend_mx_default_url", ""));
      boolean bool1;
      if (((AladdinConfig)localObject).getInteger("trend_mx_default_url_need_copy_params", 0) == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localJumpToRIJPublisherSuccessPageUtils.a(bool1);
      localJumpToRIJPublisherSuccessPageUtils.m(((AladdinConfig)localObject).getString("trend_mx_bid_id", ""));
      localJumpToRIJPublisherSuccessPageUtils.n(((AladdinConfig)localObject).getString("trend_mx_jswidget_name", ""));
      if (((AladdinConfig)localObject).getIntegerFromString("mx_is_dart2js", 0) == 1) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      localJumpToRIJPublisherSuccessPageUtils.b(bool1);
      localObject = this.az;
      if (localObject != null) {
        localJumpToRIJPublisherSuccessPageUtils.j(((CommunityInfo)localObject).getCommunityId());
      }
      localJumpToRIJPublisherSuccessPageUtils.g(this.ax.d()[0]);
      localObject = this.aw.b().get(0);
      if ((localObject instanceof String)) {
        localJumpToRIJPublisherSuccessPageUtils.h((String)localObject);
      }
      localJumpToRIJPublisherSuccessPageUtils.b(this.ax.b()[0]);
      localJumpToRIJPublisherSuccessPageUtils.c(this.ax.c()[0]);
      localJumpToRIJPublisherSuccessPageUtils.i(this.e.getText().toString());
      localJumpToRIJPublisherSuccessPageUtils.k("2");
      localJumpToRIJPublisherSuccessPageUtils.a(this);
    }
  }
  
  private boolean K()
  {
    if (N() != 0)
    {
      int i = 0;
      while (i < this.aw.b().size() - 1)
      {
        if (!(this.aw.b().get(i) instanceof HotPicData)) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  private String L()
  {
    if ((N() == 0) && (!TextUtils.isEmpty(this.e.getText()))) {
      return "3";
    }
    if (((N() != 0) || (K())) && (TextUtils.isEmpty(this.e.getText()))) {
      return "1";
    }
    if (((N() != 0) || (K())) && (!TextUtils.isEmpty(this.e.getText()))) {
      return "2";
    }
    return "0";
  }
  
  private int M()
  {
    if ((N() == 0) && (!TextUtils.isEmpty(this.e.getText()))) {
      return 3;
    }
    if ((N() != 0) && (TextUtils.isEmpty(this.e.getText())))
    {
      if (K()) {
        return 4;
      }
      return 1;
    }
    if ((N() != 0) && (!TextUtils.isEmpty(this.e.getText())))
    {
      if (K()) {
        return 5;
      }
      return 2;
    }
    return 0;
  }
  
  private int N()
  {
    ReadInJoyNinePicAdapter localReadInJoyNinePicAdapter = this.aw;
    if (localReadInJoyNinePicAdapter != null)
    {
      int j = localReadInJoyNinePicAdapter.b().size();
      int i = j;
      if (this.aw.b().get(this.aw.b().size() - 1).equals(this.aG)) {
        i = j - 1;
      }
      return i;
    }
    return 0;
  }
  
  private void O()
  {
    this.aA = 0;
    this.ax.a();
  }
  
  private void P()
  {
    O();
    Iterator localIterator = this.ai.iterator();
    while (localIterator.hasNext()) {
      ((ReadInJoyDeliverUGCActivity.UGCTransProcessorHandler)localIterator.next()).a = false;
    }
    localIterator = this.aj.iterator();
    while (localIterator.hasNext())
    {
      TransferRequest localTransferRequest = (TransferRequest)localIterator.next();
      ((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).stop(localTransferRequest);
    }
    this.ai.clear();
  }
  
  private void a(long paramLong1, long paramLong2, String paramString, CompressInfo paramCompressInfo, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      paramString = paramString.substring(paramString.lastIndexOf(".") + 1);
      if (paramLong2 == paramLong1)
      {
        PublicAccountReportUtils.a(null, "", "0X800951E", "0X800951E", 0, 0, String.valueOf(paramCompressInfo.m), String.valueOf(paramCompressInfo.n), paramString, RIJTransMergeKanDianReport.a(0), false);
        return;
      }
      if (paramLong2 <= paramLong1) {
        break label126;
      }
      PublicAccountReportUtils.a(null, "", "0X800951E", "0X800951E", 0, 0, String.valueOf(paramCompressInfo.m), String.valueOf(paramCompressInfo.n), paramString, RIJTransMergeKanDianReport.a(1), false);
      return;
    }
    catch (Exception paramString)
    {
      label110:
      label126:
      break label110;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "0X800951E reportError");
    }
  }
  
  private void a(long paramLong, String paramString, CompressInfo paramCompressInfo, boolean paramBoolean, int paramInt)
  {
    String str;
    if (TextUtils.isEmpty(paramCompressInfo.l)) {
      str = paramString;
    } else {
      str = paramCompressInfo.l;
    }
    long l = new File(str).length();
    this.ay.b(paramInt, l);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("afterCompress picture: w:");
    localStringBuilder.append(paramCompressInfo.m);
    localStringBuilder.append("  h:");
    localStringBuilder.append(paramCompressInfo.n);
    localStringBuilder.append(" size:");
    localStringBuilder.append(l / 1024L);
    localStringBuilder.append("kb");
    QLog.d("ReadInJoyDeliverUGCActivity", 2, localStringBuilder.toString());
    this.ay.d(paramInt, NetConnInfoCenter.getServerTimeMillis());
    if (a(str, paramInt)) {
      return;
    }
    this.ay.e(paramInt, NetConnInfoCenter.getServerTimeMillis());
    a(paramLong, l, paramString, paramCompressInfo, paramBoolean);
  }
  
  private void a(HotPicData paramHotPicData, int paramInt)
  {
    if (paramInt < 9)
    {
      this.ax.a(paramInt, paramHotPicData.originalUrl);
      this.ax.b(paramInt, paramHotPicData.md5);
      this.ax.b(paramInt, Integer.valueOf(paramHotPicData.height));
      this.ax.a(paramInt, Integer.valueOf(paramHotPicData.width));
      this.aA += 1;
    }
    else
    {
      this.ap = false;
      p();
    }
    if (this.aA == N())
    {
      this.aq = true;
      new RIJPublishTrendsHandler().a(k(), this.aQ, this.aA, this.ax, this.ah, this.T, this.b);
    }
  }
  
  private void a(CommunityInfo paramCommunityInfo)
  {
    String str = getResources().getString(2131915343);
    if (paramCommunityInfo == null)
    {
      a(null, true);
      return;
    }
    if ((this.az != null) && (TextUtils.equals(paramCommunityInfo.getCommunityId(), this.az.getCommunityId())))
    {
      this.az = null;
      this.av.setText(str);
      a(paramCommunityInfo, true);
    }
    else
    {
      a(this.az, true);
      a(paramCommunityInfo, false);
      this.az = paramCommunityInfo;
      this.av.setText(paramCommunityInfo.getTitle());
    }
    a(true);
  }
  
  private void a(CommunityInfo paramCommunityInfo, boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("publisher_type", 1);
        if (paramCommunityInfo == null) {
          paramCommunityInfo = "";
        } else {
          paramCommunityInfo = paramCommunityInfo.getCommunityId();
        }
        localJSONObject.put("kdcommunity_id", paramCommunityInfo);
        if (paramBoolean)
        {
          i = 0;
          localJSONObject.put("choose_type", i);
          localJSONObject.put("contant", 2);
          PublicAccountReportUtils.a(null, "", "0X800BB31", "0X800BB31", 0, 0, "", "", "", localJSONObject.toString(), false);
          return;
        }
      }
      catch (JSONException paramCommunityInfo)
      {
        QLog.e("ReadInJoyDeliverUGCActivity", 1, paramCommunityInfo, new Object[0]);
        return;
      }
      int i = 1;
    }
  }
  
  private void a(Object paramObject, int paramInt)
  {
    new Thread(new ReadInJoyDeliverUGCActivity.16(this, paramObject, paramInt)).start();
  }
  
  private void a(String paramString, long paramLong, ReadInJoyDeliverUGCActivity.CompressFile paramCompressFile, int paramInt)
  {
    CompressInfo localCompressInfo = paramCompressFile.b();
    boolean bool = paramCompressFile.c();
    if (a(paramCompressFile.d(), paramInt)) {
      return;
    }
    a(paramLong, paramString, localCompressInfo, bool, paramInt);
  }
  
  private void a(ArrayList<BiuCommentInfo> paramArrayList, CommunityInfo paramCommunityInfo)
  {
    if ((paramArrayList != null) && (paramCommunityInfo != null))
    {
      BiuCommentInfo localBiuCommentInfo = new BiuCommentInfo();
      localBiuCommentInfo.mUin = Long.valueOf(0L);
      localBiuCommentInfo.mBiuComment = "";
      localBiuCommentInfo.mOpType = 4;
      try
      {
        localBiuCommentInfo.jumpInfo = new JumpInfo(Long.parseLong(paramCommunityInfo.getCommunityId()), paramCommunityInfo.getTitle(), "");
      }
      catch (NumberFormatException paramCommunityInfo)
      {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, paramCommunityInfo, new Object[0]);
      }
      paramArrayList.add(localBiuCommentInfo);
    }
  }
  
  private void a(List<?> paramList)
  {
    if (paramList.size() > 0)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        b(paramList.next());
      }
    }
  }
  
  private boolean a(BitmapFactory.Options paramOptions, int paramInt)
  {
    if (this.ap)
    {
      this.ax.a(paramInt, Integer.valueOf(paramOptions.outWidth));
      this.ax.b(paramInt, Integer.valueOf(paramOptions.outHeight));
      return false;
    }
    return true;
  }
  
  private boolean a(FileMsg paramFileMsg)
  {
    return (paramFileMsg == null) || (paramFileMsg.fileType != 24) || (paramFileMsg.commandId != 10);
  }
  
  private boolean a(Object paramObject)
  {
    if (!this.ap) {
      return true;
    }
    return paramObject.equals(this.aG);
  }
  
  private boolean a(String paramString, int paramInt)
  {
    ITransFileController localITransFileController = (ITransFileController)this.app.getRuntimeService(ITransFileController.class);
    ReadInJoyDeliverUGCActivity.UGCTransProcessorHandler localUGCTransProcessorHandler = new ReadInJoyDeliverUGCActivity.UGCTransProcessorHandler(this, getMainLooper());
    TransferRequest localTransferRequest = new TransferRequest();
    if (this.ap)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doStartUploadPicposition");
        localStringBuilder.append(paramInt);
        QLog.d("ReadInJoyDeliverUGCActivity", 2, localStringBuilder.toString());
      }
      localUGCTransProcessorHandler.addFilter(new Class[] { BDHCommonUploadProcessor.class });
      localITransFileController.addHandle(localUGCTransProcessorHandler);
      localTransferRequest.mIsUp = true;
      localTransferRequest.mCommandId = 10;
      localTransferRequest.mLocalPath = paramString;
      localTransferRequest.mUniseq = paramInt;
      localTransferRequest.mPeerUin = "0";
      localTransferRequest.mFileType = 24;
      localTransferRequest.mRichTag = "KandianUGCPicUpload";
      localITransFileController.transferAsync(localTransferRequest);
      localUGCTransProcessorHandler.a = true;
      this.ai.add(localUGCTransProcessorHandler);
      this.aj.add(localTransferRequest);
      return false;
    }
    return true;
  }
  
  public static URLDrawable b(HotPicData paramHotPicData)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = a;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    boolean bool;
    if (paramHotPicData.getDataType() != 2) {
      bool = true;
    } else {
      bool = false;
    }
    localURLDrawableOptions.mPlayGifImage = bool;
    localURLDrawableOptions.mExtraInfo = paramHotPicData;
    if (paramHotPicData.getDataType() == 2) {
      paramHotPicData = HotVideoPreviewDownloader.b((HotVideoData)paramHotPicData);
    } else {
      paramHotPicData = HotPicDownLoader.b(paramHotPicData.url);
    }
    if (paramHotPicData == null) {
      return null;
    }
    return URLDrawable.getDrawable(paramHotPicData, localURLDrawableOptions);
  }
  
  @Nullable
  private String b(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof HotPicData))
    {
      a((HotPicData)paramObject, paramInt);
      return null;
    }
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      if (e(paramObject)) {
        return null;
      }
      return paramObject;
    }
    I();
    return null;
  }
  
  private void b(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt > 8) {
        return;
      }
      Object localObject = this.aw.b().get(paramInt);
      if ((localObject instanceof HotPicData))
      {
        localObject = (HotPicData)localObject;
        if (HotPicPageView.b((HotPicData)localObject) == 0)
        {
          HotPicDownLoader.a(((HotPicData)localObject).url).getAbsolutePath();
          c(paramInt);
        }
      }
      else if (((String)this.aw.b().get(paramInt)).equals(this.aG))
      {
        if (9 - N() > 0)
        {
          t();
          PublicAccountReportUtils.a(null, "", "0X8008238", "0X8008238", 0, 0, "", "", "", RIJTransMergeKanDianReport.e(), false);
        }
        else
        {
          a(1, getString(2131915350));
        }
      }
      else
      {
        c(paramInt);
      }
      RIJDeliverUGCReportUtil.b();
    }
  }
  
  private void b(Object paramObject)
  {
    List localList = this.aw.b();
    if (N() < 9)
    {
      Object localObject = paramObject;
      if ((paramObject instanceof String))
      {
        localObject = paramObject;
        if (localList.contains(paramObject)) {
          localObject = c((String)paramObject);
        }
      }
      paramObject = localObject;
      if ((localObject instanceof HotPicData))
      {
        paramObject = localObject;
        if (localList.contains(localObject)) {
          try
          {
            paramObject = ((HotPicData)localObject).clone();
          }
          catch (CloneNotSupportedException paramObject)
          {
            paramObject.printStackTrace();
            paramObject = localObject;
          }
        }
      }
      this.aw.a(localList.size() - 1, paramObject);
      c(paramObject);
      if (localList.size() > 9) {
        this.aw.d(localList.get(9));
      }
    }
    else
    {
      a(1, getString(2131915350));
    }
    v();
  }
  
  private void c(int paramInt)
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this, "/base/album/photopreview");
    this.aB = paramInt;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.aw.b().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!localObject.equals(this.aG)) {
        if ((localObject instanceof String)) {
          localArrayList.add((String)localObject);
        } else if ((localObject instanceof HotPicData)) {
          localArrayList.add(HotPicDownLoader.a(((HotPicData)localObject).url).getAbsolutePath());
        }
      }
    }
    localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ReadInJoyDeliverUGCActivity.class.getName());
    localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localActivityURIRequest.extra().putStringArrayList("PhotoConst.PHOTO_PATHS", localArrayList);
    localActivityURIRequest.extra().putBoolean("from_readinjoy_ugc_deliver", true);
    localActivityURIRequest.extra().putBoolean("keep_selected_status_after_finish", true);
    localActivityURIRequest.extra().putInt("PhotoConst.CURRENT_SELECTED_INDEX", paramInt);
    localActivityURIRequest.extra().putBoolean("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
    localActivityURIRequest.extra().putInt("enter_from", 25);
    localActivityURIRequest.extra().putString("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationReadInJoy.a);
    localActivityURIRequest.extra().putString("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationReadInJoy.a);
    localActivityURIRequest.extra().putInt("extra.busi_type", 8);
    this.aD = 1002;
    localActivityURIRequest.setRequestCode(this.aD);
    QRoute.startUri(localActivityURIRequest);
    overridePendingTransition(2130772427, 2130772429);
  }
  
  private void c(Object paramObject)
  {
    boolean bool = paramObject instanceof String;
    Integer localInteger = Integer.valueOf(2);
    if (bool)
    {
      if (BaseImageUtil.c((String)paramObject))
      {
        this.ah.add(localInteger);
        return;
      }
      this.ah.add(Integer.valueOf(3));
      return;
    }
    this.ah.add(localInteger);
  }
  
  private void c(Object paramObject, int paramInt)
  {
    List localList = this.aw.b();
    this.aw.a(paramInt, paramObject);
    d(paramObject, paramInt);
    if (localList.size() > 9) {
      this.aw.d(localList.get(9));
    }
    v();
  }
  
  private String d(Object paramObject)
  {
    String str = this.aG;
    if (!str.equals(paramObject))
    {
      if (!(paramObject instanceof String)) {
        return str;
      }
      str = (String)paramObject;
      paramObject = str;
      if (!TextUtils.isEmpty(str))
      {
        paramObject = str;
        if (new File(str).exists()) {
          paramObject = HexUtil.bytes2HexStr(FileManagerUtil.g(str));
        }
      }
      return paramObject;
    }
    return str;
  }
  
  private void d(Object paramObject, int paramInt)
  {
    boolean bool = paramObject instanceof String;
    Integer localInteger = Integer.valueOf(2);
    if (bool)
    {
      if (BaseImageUtil.c((String)paramObject))
      {
        this.ah.add(paramInt, localInteger);
        return;
      }
      this.ah.add(paramInt, Integer.valueOf(3));
      return;
    }
    this.ah.add(paramInt, localInteger);
  }
  
  private void d(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("publisher_type", 1);
      localJSONObject.put("contant", 2);
      PublicAccountReportUtils.a(null, "", paramString, paramString, 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("ReadInJoyDeliverUGCActivity", 1, paramString, new Object[0]);
    }
  }
  
  private boolean e(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      p();
      a(1, getString(2131915349));
      m();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "startUploadPic empty path!");
      }
      return true;
    }
    return false;
  }
  
  private String g(int paramInt)
  {
    String str = RIJTransMergeKanDianReport.e();
    try
    {
      Object localObject = new JSONObject(str);
      ((JSONObject)localObject).put("save", paramInt);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return str;
  }
  
  private boolean h(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt > 8) {
        return false;
      }
      List localList = this.aw.b();
      if (!(localList.get(paramInt) instanceof HotPicData))
      {
        if (this.aG.equals(localList.get(paramInt))) {
          return true;
        }
        String str = d(localList.get(paramInt));
        int i = 0;
        while (i < paramInt)
        {
          if (str.equals(d(localList.get(i)))) {
            return false;
          }
          i += 1;
        }
      }
      return true;
    }
    return false;
  }
  
  private void i(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = this.aK;
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(this);
    String str = this.app.getCurrentAccountUin();
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localStatisticCollector.collectPerformance(str, "actReadInJoyUGCPicture", bool, l1 - l2, 0L, localHashMap, "");
  }
  
  private void j(int paramInt)
  {
    ReadInJoyNinePicAdapter localReadInJoyNinePicAdapter = this.aw;
    localReadInJoyNinePicAdapter.d(localReadInJoyNinePicAdapter.b().get(paramInt));
    this.ah.remove(paramInt);
    if (N() == 0)
    {
      a(false);
      if (this.aI == 1)
      {
        a(true);
        this.rightViewText.setTextColor(Color.parseColor("#BBBBBB"));
      }
    }
    v();
    RIJDeliverUGCReportUtil.l();
  }
  
  private void w()
  {
    View localView = findViewById(2131431172);
    AladdinConfig localAladdinConfig = Aladdin.getConfig(354);
    if ((localAladdinConfig != null) && (localAladdinConfig.getIntegerFromString("ugc_publish_show_community", 0) == 1))
    {
      a(false);
      this.ar = true;
      localView.setVisibility(0);
      this.av = ((TextView)findViewById(2131445547));
      localView.setOnClickListener(this);
      d("0X800BB2F");
      return;
    }
    localView.setClickable(getIntent().getBooleanExtra("allow_select_community", true));
    localView.setVisibility(8);
  }
  
  private void x()
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      this.W = localIntent.getLongExtra("readinjoy_draftbox_id", -1L);
      if (this.W != -1L) {
        ThreadManager.getSubThreadHandler().post(new ReadInJoyDeliverUGCActivity.5(this));
      }
    }
  }
  
  private void y()
  {
    ThreadManager.getUIHandler().post(new ReadInJoyDeliverUGCActivity.6(this));
  }
  
  private void z()
  {
    Object localObject = this.aQ;
    if ((localObject != null) && (this.ar))
    {
      localObject = (BiuCommentInfo)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      if (((BiuCommentInfo)localObject).mOpType == 4)
      {
        this.az = new CommunityInfo();
        this.az.setCommunityId(String.valueOf(((BiuCommentInfo)localObject).jumpInfo.getId()));
        this.az.setTitle(((BiuCommentInfo)localObject).jumpInfo.getWording());
        this.av.setText(this.az.getTitle());
      }
      this.aQ.remove(localObject);
    }
  }
  
  public SpannableStringBuilder a(List<BiuCommentInfo> paramList, Context paramContext, EditText paramEditText, int paramInt)
  {
    StringBuilder localStringBuilder;
    ArrayList localArrayList;
    int j;
    int i;
    BiuCommentInfo localBiuCommentInfo;
    String str;
    if (paramList != null)
    {
      localStringBuilder = new StringBuilder();
      localArrayList = new ArrayList();
      j = localStringBuilder.length();
      int k = paramList.size();
      i = 0;
      if (i <= k - 1)
      {
        localBiuCommentInfo = (BiuCommentInfo)paramList.get(i);
        int m = localBiuCommentInfo.mOpType;
        str = "";
        if (m != 2) {
          if (m != 3) {
            if (i <= 0) {}
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = ReadInJoyUserInfoModule.a(localBiuCommentInfo.mUin.longValue(), null);
        if (localObject2 != null) {
          localObject2 = ((ReadInJoyUserInfo)localObject2).nick;
        } else {
          localObject2 = ReadInJoyUserInfoModule.d();
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, localNumberFormatException.getMessage());
        break label586;
      }
      Object localObject2 = BiuNicknameSpan.a((CharSequence)localObject2);
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("@");
      ((StringBuilder)localObject3).append((String)localObject2);
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject2 = localObject3;
      if (localBiuCommentInfo.mOpType == 1)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject3);
        ((StringBuilder)localObject2).append(" ");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localStringBuilder.append((String)localObject2);
      if (localBiuCommentInfo.mBiuComment != null) {
        str = EmotionCodecUtils.c(localBiuCommentInfo.mBiuComment);
      }
      localStringBuilder.append(str);
      localArrayList.add(new PositionalSpanStruct(j, ((String)localObject2).length() + j, new BiuNicknameSpan(localBiuCommentInfo.mUin.toString(), localBiuCommentInfo.mFeedId.longValue(), (CharSequence)localObject2, paramContext, paramEditText.getPaint(), paramInt)));
      break label586;
      Object localObject1;
      if (localBiuCommentInfo.mBiuComment != null) {
        localObject1 = EmotionCodecUtils.c(localBiuCommentInfo.mBiuComment);
      }
      localStringBuilder.append((String)localObject1);
      break label586;
      if (localBiuCommentInfo.jumpInfo != null)
      {
        localObject2 = localBiuCommentInfo.jumpInfo.getWording();
        localObject3 = localBiuCommentInfo.jumpInfo.getJumpUrl();
        if (localBiuCommentInfo.mBiuComment != null) {
          localObject1 = localBiuCommentInfo.mBiuComment;
        }
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append((String)localObject1);
        localArrayList.add(new PositionalSpanStruct(j, ((String)localObject2).length() + j, new JumpSpan((String)localObject3, 13421772)));
        break label586;
        if (localBiuCommentInfo.jumpInfo != null)
        {
          localObject2 = localBiuCommentInfo.jumpInfo.getWording();
          localBiuCommentInfo.jumpInfo.getJumpUrl();
          if (localBiuCommentInfo.mBiuComment != null) {
            localObject1 = localBiuCommentInfo.mBiuComment;
          }
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append((String)localObject1);
          localObject1 = TopicInfo.g().a(Long.valueOf(localBiuCommentInfo.jumpInfo.getId()).longValue()).a((String)localObject2).a();
          localArrayList.add(new PositionalSpanStruct(j, ((String)localObject2).length() + j, new TopicSpan((TopicInfo)localObject1)));
        }
      }
      label586:
      j = localStringBuilder.length();
      i += 1;
      break;
      paramList = new SpannableStringBuilder(new QQText(localStringBuilder, 3, 20));
      paramContext = localArrayList.iterator();
      while (paramContext.hasNext())
      {
        paramEditText = (PositionalSpanStruct)paramContext.next();
        paramList.setSpan(paramEditText.c(), paramEditText.a(), paramEditText.b(), 33);
      }
      return paramList;
      return null;
      if (localObject2 == null) {
        localObject2 = "";
      }
    }
  }
  
  protected void a()
  {
    this.E = 178;
    super.a();
    this.au = new QQProgressDialog(this, super.getTitleBarHeight());
    this.as = ((ReadInJoyNinePicDeliverDynamicGridView)findViewById(2131444271));
    this.f = ((ImageView)findViewById(2131434224));
    this.h = ((ImageView)findViewById(2131447759));
    boolean bool = RIJUgcUtils.d();
    if ((HotPicManager.a(this.app).j()) && (bool)) {
      this.f.setOnClickListener(this);
    } else {
      this.f.setVisibility(8);
    }
    if (!RIJUgcUtils.f()) {
      this.h.setVisibility(8);
    } else {
      this.h.setOnClickListener(this);
    }
    KanDianPublisher.INSTANCE.init(BaseApplication.getContext());
    w();
  }
  
  protected void a(int paramInt)
  {
    super.a(paramInt);
    a(false);
  }
  
  protected void a(Editable paramEditable)
  {
    super.a(paramEditable);
    if (N() != 0)
    {
      a(true);
    }
    else if (paramEditable.length() <= 0)
    {
      a(false);
    }
    else if (this.aI == 1)
    {
      a(true);
      if (N() == 0) {
        this.rightViewText.setTextColor(Color.parseColor("#BBBBBB"));
      }
    }
    else
    {
      String str = UUID.randomUUID().toString();
      if (Utils.a(paramEditable.toString(), str).trim().length() <= 0) {
        a(false);
      } else {
        a(true);
      }
    }
    if (r().intValue() < this.aF) {
      RIJDeliverUGCReportUtil.m();
    }
  }
  
  public void a(IPicEmoticonInfo paramIPicEmoticonInfo)
  {
    getActivity().getApplicationContext();
    a(true);
  }
  
  public void a(HotPicData paramHotPicData)
  {
    if ((paramHotPicData != null) && (paramHotPicData.url != null))
    {
      b(paramHotPicData);
      a(true);
      RIJDeliverUGCReportUtil.i();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("url=");
        localStringBuilder.append(paramHotPicData.url);
        QLog.d("ReadInJoyDeliverUGCActivity", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.a(paramCharSequence, paramInt1, paramInt2, paramInt3);
    this.aF = r().intValue();
  }
  
  protected void a(boolean paramBoolean)
  {
    this.rightViewText.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      if ((this.ar) && (this.az == null))
      {
        this.rightViewText.setTextColor(Color.parseColor("#BBBBBB"));
        return;
      }
      if (N() > 0)
      {
        this.rightViewText.setTextColor(Color.parseColor("#262626"));
        return;
      }
      if (this.aI == 1)
      {
        this.rightViewText.setTextColor(Color.parseColor("#BBBBBB"));
        return;
      }
      if (TextUtils.getTrimmedLength(this.e.getText()) <= 0)
      {
        this.rightViewText.setTextColor(Color.parseColor("#BBBBBB"));
        return;
      }
      this.rightViewText.setTextColor(Color.parseColor("#262626"));
      return;
    }
    this.rightViewText.setTextColor(Color.parseColor("#BBBBBB"));
  }
  
  protected void b()
  {
    boolean bool = true;
    this.S = true;
    this.z = getIntent().getBooleanExtra("support_topic", false);
    this.A = getIntent().getBooleanExtra("support_linkify", true);
    this.ab = getIntent().getBooleanExtra("has_default_topic", false);
    Object localObject = new CommunityInfo();
    String str1 = getIntent().getStringExtra("arg_community_id");
    String str2 = getIntent().getStringExtra("arg_community_title");
    this.e.a(getIntent().getBooleanExtra("support_multi_topic", true));
    this.e.b(getIntent().getBooleanExtra("allow_delete_topic", true));
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      ((CommunityInfo)localObject).setCommunityId(str1);
      ((CommunityInfo)localObject).setTitle(str2);
      a((CommunityInfo)localObject);
    }
    super.b();
    this.ad = "0X800865D";
    if (this.ab) {
      this.h.setVisibility(8);
    }
    this.aw = new ReadInJoyNinePicAdapter(getApplicationContext(), 3);
    this.aw.a(new ReadInJoyDeliverUGCActivity.1(this));
    this.aw.a(new ReadInJoyDeliverUGCActivity.2(this));
    this.as.setOnItemLongClickListener(new ReadInJoyDeliverUGCActivity.3(this));
    this.as.setOnDragListener(new ReadInJoyDeliverUGCActivity.4(this));
    this.as.setAdapter(this.aw);
    v();
    this.aL = getIntent().getBooleanExtra("is_from_dian_dian", false);
    this.aM = getIntent().getBooleanExtra("is_from_kan_dian", false);
    this.aN = getIntent().getBooleanExtra("is_from_poly_topic", false);
    this.ac = getIntent().getIntExtra("key_from", 0);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initData mTopicId=");
      ((StringBuilder)localObject).append(this.G);
      ((StringBuilder)localObject).append(", mTopicName=");
      ((StringBuilder)localObject).append(this.H);
      ((StringBuilder)localObject).append(", mAdTag=");
      ((StringBuilder)localObject).append(this.J);
      QLog.d("ReadInJoyDeliverUGCActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(this.G)) {
      localObject = "0";
    } else {
      localObject = String.valueOf(this.G);
    }
    if (this.aL) {
      str1 = "1";
    } else {
      str1 = "2";
    }
    PublicAccountReportUtils.a(null, "", "0X8008237", "0X8008237", 0, 0, "", (String)localObject, str1, RIJTransMergeKanDianReport.e(), false);
    if (ReadInJoyHelper.H(this.app) != 0) {
      bool = false;
    }
    this.y = bool;
    if ((!this.y) && (this.g != null)) {
      this.g.setVisibility(8);
    }
    x();
  }
  
  protected void b(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.b(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if (!this.aP)
    {
      RIJDeliverUGCReportUtil.a();
      this.aP = true;
    }
    if (RIJDeliverUGCReportUtil.e(paramCharSequence.toString()))
    {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "onTextChanged | insert Emoji");
      RIJDeliverUGCReportUtil.f();
    }
  }
  
  /* Error */
  public String c(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: aload_1
    //   3: bipush 46
    //   5: invokevirtual 1636	java/lang/String:indexOf	(I)I
    //   8: invokevirtual 1639	java/lang/String:substring	(II)Ljava/lang/String;
    //   11: astore 4
    //   13: aload_1
    //   14: aload_1
    //   15: bipush 46
    //   17: invokevirtual 1636	java/lang/String:indexOf	(I)I
    //   20: invokevirtual 718	java/lang/String:substring	(I)Ljava/lang/String;
    //   23: astore_3
    //   24: new 758	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 759	java/lang/StringBuilder:<init>	()V
    //   31: astore 5
    //   33: aload 5
    //   35: aload 4
    //   37: invokevirtual 765	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 5
    //   43: ldc_w 1641
    //   46: invokevirtual 765	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 5
    //   52: invokevirtual 780	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: astore 4
    //   57: new 758	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 759	java/lang/StringBuilder:<init>	()V
    //   64: astore 5
    //   66: aload 5
    //   68: aload 4
    //   70: invokevirtual 765	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 5
    //   76: aload_3
    //   77: invokevirtual 765	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload 5
    //   83: invokevirtual 780	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: astore 6
    //   88: new 747	java/io/File
    //   91: dup
    //   92: aload 6
    //   94: invokespecial 749	java/io/File:<init>	(Ljava/lang/String;)V
    //   97: invokevirtual 1149	java/io/File:exists	()Z
    //   100: ifeq +10 -> 110
    //   103: aload_0
    //   104: aload 6
    //   106: invokevirtual 1105	com/tencent/mobileqq/kandian/biz/ugc/ReadInJoyDeliverUGCActivity:c	(Ljava/lang/String;)Ljava/lang/String;
    //   109: areturn
    //   110: aconst_null
    //   111: astore 5
    //   113: new 1643	java/io/FileInputStream
    //   116: dup
    //   117: aload_1
    //   118: invokespecial 1644	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   121: astore 4
    //   123: new 1646	java/io/FileOutputStream
    //   126: dup
    //   127: aload 6
    //   129: invokespecial 1647	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   132: astore_3
    //   133: sipush 1024
    //   136: newarray byte
    //   138: astore_1
    //   139: aload 4
    //   141: aload_1
    //   142: invokevirtual 1653	java/io/InputStream:read	([B)I
    //   145: istore_2
    //   146: iload_2
    //   147: ifle +13 -> 160
    //   150: aload_3
    //   151: aload_1
    //   152: iconst_0
    //   153: iload_2
    //   154: invokevirtual 1659	java/io/OutputStream:write	([BII)V
    //   157: goto -18 -> 139
    //   160: aload_0
    //   161: getfield 88	com/tencent/mobileqq/kandian/biz/ugc/ReadInJoyDeliverUGCActivity:ag	Ljava/util/List;
    //   164: aload 6
    //   166: invokeinterface 1018 2 0
    //   171: pop
    //   172: aload 4
    //   174: invokevirtual 1662	java/io/InputStream:close	()V
    //   177: goto +8 -> 185
    //   180: astore_1
    //   181: aload_1
    //   182: invokevirtual 1663	java/io/IOException:printStackTrace	()V
    //   185: aload_3
    //   186: invokevirtual 1664	java/io/OutputStream:close	()V
    //   189: aload 6
    //   191: areturn
    //   192: astore_1
    //   193: aload_1
    //   194: invokevirtual 1663	java/io/IOException:printStackTrace	()V
    //   197: aload 6
    //   199: areturn
    //   200: astore_1
    //   201: goto +80 -> 281
    //   204: astore_1
    //   205: aconst_null
    //   206: astore_3
    //   207: goto +74 -> 281
    //   210: aconst_null
    //   211: astore_3
    //   212: aload 4
    //   214: astore_1
    //   215: goto +17 -> 232
    //   218: astore_1
    //   219: aconst_null
    //   220: astore_3
    //   221: aload_3
    //   222: astore 4
    //   224: goto +57 -> 281
    //   227: aconst_null
    //   228: astore_3
    //   229: aload 5
    //   231: astore_1
    //   232: aload_0
    //   233: getfield 145	com/tencent/mobileqq/kandian/biz/ugc/ReadInJoyDeliverUGCActivity:aG	Ljava/lang/String;
    //   236: astore 4
    //   238: aload_1
    //   239: ifnull +15 -> 254
    //   242: aload_1
    //   243: invokevirtual 1662	java/io/InputStream:close	()V
    //   246: goto +8 -> 254
    //   249: astore_1
    //   250: aload_1
    //   251: invokevirtual 1663	java/io/IOException:printStackTrace	()V
    //   254: aload_3
    //   255: ifnull +15 -> 270
    //   258: aload_3
    //   259: invokevirtual 1664	java/io/OutputStream:close	()V
    //   262: aload 4
    //   264: areturn
    //   265: astore_1
    //   266: aload_1
    //   267: invokevirtual 1663	java/io/IOException:printStackTrace	()V
    //   270: aload 4
    //   272: areturn
    //   273: astore 5
    //   275: aload_1
    //   276: astore 4
    //   278: aload 5
    //   280: astore_1
    //   281: aload 4
    //   283: ifnull +18 -> 301
    //   286: aload 4
    //   288: invokevirtual 1662	java/io/InputStream:close	()V
    //   291: goto +10 -> 301
    //   294: astore 4
    //   296: aload 4
    //   298: invokevirtual 1663	java/io/IOException:printStackTrace	()V
    //   301: aload_3
    //   302: ifnull +15 -> 317
    //   305: aload_3
    //   306: invokevirtual 1664	java/io/OutputStream:close	()V
    //   309: goto +8 -> 317
    //   312: astore_3
    //   313: aload_3
    //   314: invokevirtual 1663	java/io/IOException:printStackTrace	()V
    //   317: goto +5 -> 322
    //   320: aload_1
    //   321: athrow
    //   322: goto -2 -> 320
    //   325: astore_1
    //   326: goto -99 -> 227
    //   329: astore_1
    //   330: goto -120 -> 210
    //   333: astore_1
    //   334: goto -122 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	337	0	this	ReadInJoyDeliverUGCActivity
    //   0	337	1	paramString	String
    //   145	9	2	i	int
    //   23	283	3	localObject1	Object
    //   312	2	3	localIOException1	java.io.IOException
    //   11	276	4	localObject2	Object
    //   294	3	4	localIOException2	java.io.IOException
    //   31	199	5	localStringBuilder	StringBuilder
    //   273	6	5	localObject3	Object
    //   86	112	6	str	String
    // Exception table:
    //   from	to	target	type
    //   172	177	180	java/io/IOException
    //   185	189	192	java/io/IOException
    //   133	139	200	finally
    //   139	146	200	finally
    //   150	157	200	finally
    //   160	172	200	finally
    //   123	133	204	finally
    //   113	123	218	finally
    //   242	246	249	java/io/IOException
    //   258	262	265	java/io/IOException
    //   232	238	273	finally
    //   286	291	294	java/io/IOException
    //   305	309	312	java/io/IOException
    //   113	123	325	java/lang/Exception
    //   123	133	329	java/lang/Exception
    //   133	139	333	java/lang/Exception
    //   139	146	333	java/lang/Exception
    //   150	157	333	java/lang/Exception
    //   160	172	333	java/lang/Exception
  }
  
  protected boolean c()
  {
    AioPicTransFileController.a(getCurrentAccountUin(), new ReadInJoyDeliverUGCActivity.15(this));
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "onDeliver!");
    }
    RIJDeliverUGCReportUtil.a(L(), N(), H());
    PublicAccountReportUtils.a(null, "", "0X8008240", "0X8008240", 0, 0, String.valueOf(M()), Integer.valueOf(N()).toString(), "", i(), false);
    boolean bool = super.c();
    int j = 0;
    if (!bool) {
      return false;
    }
    int i;
    if (N() == 0)
    {
      i = 1;
    }
    else
    {
      if ((!this.M) && (!NetworkUtil.isWifiConnected(this)))
      {
        o();
        return false;
      }
      i = 2;
    }
    Object localObject2;
    try
    {
      this.aJ.put("type", i);
    }
    catch (Exception localException1)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("mResultJson error");
      ((StringBuilder)localObject2).append(localException1.toString());
      QLog.d("ReadInJoyDeliverUGCActivity", 2, ((StringBuilder)localObject2).toString());
    }
    f(2131892958);
    this.ap = true;
    this.aQ = new ArrayList();
    Utils.a(this.e, this.app.getCurrentAccountUin(), this.S, this.aQ);
    a(this.aQ, this.az);
    this.aK = NetConnInfoCenter.getServerTimeMillis();
    ReadInJoyLogicEngineEventDispatcher.a().a(0, "", this.K, RIJEntryViewUtils.a(0, 2, true, this.aQ, this.aw.b(), this.ax, this.az, this.T, ""));
    if (i == 1) {}
    try
    {
      this.aJ.put("picCount", 0);
      label315:
      new RIJPublishTrendsHandler().a(k(), this.aQ, this.aA, this.ax, this.ah, this.T, this.b);
      this.ap = false;
      return true;
      Object localObject1 = this.aw.b();
      this.aq = false;
      localObject1 = ((List)localObject1).iterator();
      i = j;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (!this.ap) {
          break;
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("picIsReadToup=position");
          localStringBuilder.append(i);
          QLog.d("ReadInJoyDeliverUGCActivity", 2, localStringBuilder.toString());
        }
        if (h(i)) {
          a(localObject2, i);
        }
        i += 1;
      }
      return true;
    }
    catch (Exception localException2)
    {
      break label315;
    }
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "onEmotionBtn!");
    }
    RIJDeliverUGCReportUtil.e();
    PublicAccountReportUtils.a(null, "", "0X800823F", "0X800823F", 0, 0, "", "", "", RIJTransMergeKanDianReport.e(), false);
    super.d();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.c = paramMotionEvent.getY();
    }
    if (paramMotionEvent.getAction() == 1)
    {
      this.d = paramMotionEvent.getY();
      float f1 = this.c;
      float f2 = this.d;
      if ((f1 - f2 > 50.0F) || (f2 - f1 > 50.0F)) {
        this.al = false;
      }
      if (this.al)
      {
        b(this.aC);
        this.al = false;
      }
      else
      {
        this.as.a();
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131626220);
    PtvFilterSoLoad.a(this.app, BaseApplicationImpl.getContext());
    overridePendingTransition(2130771996, 2130771994);
    if (isInMultiWindow())
    {
      QQToast.makeText(this, HardCodeUtil.a(2131910314), 0).show();
      finish();
      return true;
    }
    this.aI = getIntent().getIntExtra("ugcPushType", 0);
    a(2131915352);
    a();
    b();
    RIJDtReportHelper.a.a(getActivity());
    return true;
  }
  
  protected void doOnDestroy()
  {
    Iterator localIterator = this.ai.iterator();
    while (localIterator.hasNext())
    {
      ReadInJoyDeliverUGCActivity.UGCTransProcessorHandler localUGCTransProcessorHandler = (ReadInJoyDeliverUGCActivity.UGCTransProcessorHandler)localIterator.next();
      ((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).removeHandle(localUGCTransProcessorHandler);
    }
    this.ai.clear();
    this.aO.removeCallbacksAndMessages(null);
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (this.aD == 1002)
    {
      String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      this.aB = paramIntent.getIntExtra("PhotoConst.readinjoy_delete_pic_position", 0);
      if ((!TextUtils.isEmpty(str)) && (this.aB < this.ah.size()))
      {
        this.ah.remove(this.aB);
        ReadInJoyNinePicAdapter localReadInJoyNinePicAdapter = this.aw;
        localReadInJoyNinePicAdapter.d(localReadInJoyNinePicAdapter.b().get(this.aB));
        c(str, this.aB);
        this.ak.add(str);
      }
    }
    int i = this.aD;
    if (i == 1001)
    {
      paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (!TextUtils.isEmpty(paramIntent)) {
        b(paramIntent);
      }
    }
    else if (i == 1000)
    {
      if (9 - N() == 1) {
        paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      } else {
        paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      }
      if ((paramIntent instanceof String))
      {
        paramIntent = (String)paramIntent;
        if (!TextUtils.isEmpty(paramIntent)) {
          b(paramIntent);
        }
        i = 1;
      }
      else
      {
        if (paramIntent == null) {
          break label273;
        }
        paramIntent = (List)paramIntent;
        i = paramIntent.size();
        a(paramIntent);
      }
      this.an = true;
      PublicAccountReportUtils.a(null, "", "0X800823A", "0X800823A", 0, 0, String.valueOf(i), "", "", RIJTransMergeKanDianReport.e(), false);
      break label290;
      label273:
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "error  back empty path ");
      }
      return;
    }
    label290:
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("doOnNewIntent mRequestCode=");
      paramIntent.append(this.aD);
      paramIntent.append(", path=");
      QLog.d("ReadInJoyDeliverUGCActivity", 2, paramIntent.toString());
    }
    a(true);
    this.aD = 0;
    this.q = 0;
  }
  
  protected void doOnPostResume()
  {
    super.doOnPostResume();
    AbstractGifImage.resumeAll();
    RIJDeliverUGCReportUtil.a(PublisherReportUtils.a.b(this.ac));
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
  }
  
  protected void e()
  {
    super.e();
    RIJDeliverUGCReportUtil.j();
  }
  
  protected void e(int paramInt)
  {
    this.ac = 1;
    super.e(paramInt);
    RIJDeliverUGCReportUtil.a(String.valueOf(paramInt));
    PublicAccountReportUtils.a(null, "", "0X800957A", "0X800957A", 0, 0, "", "", "", RIJTransMergeKanDianReport.e(), false);
  }
  
  protected void f()
  {
    super.f();
  }
  
  protected void f(int paramInt)
  {
    this.au = new QQProgressDialog(this, super.getTitleBarHeight());
    this.au.setOnDismissListener(new ReadInJoyDeliverUGCActivity.18(this));
    this.au.c(paramInt);
    if (!this.au.isShowing()) {
      this.au.show();
    }
  }
  
  public void finish()
  {
    Object localObject = this.aJ;
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).toString();
      getIntent().putExtra("arg_result_json", (String)localObject);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("finish resultJson=");
        localStringBuilder.append(RIJDeliverUGCUtils.INSTANCE.replaceUrlInLog((String)localObject));
        QLog.d("ReadInJoyDeliverUGCActivity", 2, localStringBuilder.toString());
      }
    }
    super.finish();
  }
  
  protected void g()
  {
    super.g();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(M());
    PublicAccountReportUtils.a(null, "", "0X800823E", "0X800823E", 0, 0, localStringBuilder.toString(), "", "", RIJTransMergeKanDianReport.e(), false);
  }
  
  protected void j()
  {
    super.j();
    RIJDeliverUGCReportUtil.b("1");
  }
  
  protected void m()
  {
    PublicAccountReportUtils.a(null, "", "0X800823D", "0X800823D", 0, 0, "", "", "", g(1), false);
    ThreadManager.getSubThreadHandler().post(new ReadInJoyDeliverUGCActivity.14(this));
  }
  
  protected void n()
  {
    PublicAccountReportUtils.a(null, "", "0X800823D", "0X800823D", 0, 0, "", "", "", g(2), false);
    if (this.X != null) {
      ThreadManager.getSubThreadHandler().post(new ReadInJoyDeliverUGCActivity.13(this));
    } else {
      C();
    }
    G();
    finish();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1002))
    {
      paramInt1 = paramIntent.getIntExtra("PhotoConst.readinjoy_delete_pic_position", -1);
      if (paramInt1 != -1) {
        j(paramInt1);
      }
      this.q = 0;
    }
  }
  
  protected boolean onBackEvent()
  {
    if ((this.p != 2) && (this.p != 3))
    {
      if (((this.e.getEditableText().toString().trim().length() > 0) || (this.aw.b().size() > 1)) && (!this.ao))
      {
        l();
        return true;
      }
      return super.onBackEvent();
    }
    d(0);
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      super.onClick(paramView);
      return;
    case 2131436211: 
      A();
      return;
    case 2131436182: 
      if ((this.p == 2) || (this.p == 3)) {
        d(0);
      }
      if (((this.e.getEditableText().toString().trim().length() > 0) || (this.aw.b().size() > 1)) && (!this.ao))
      {
        l();
        return;
      }
      finish();
      return;
    case 2131434224: 
      s();
      return;
    }
    B();
  }
  
  public void onPause()
  {
    super.onPause();
    AbstractGifImage.pauseAll();
  }
  
  protected void p()
  {
    QQProgressDialog localQQProgressDialog = this.au;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.au.dismiss();
    }
  }
  
  protected void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "onGifBtn!");
    }
    if (this.p == 3)
    {
      d(1);
    }
    else
    {
      d(3);
      PublicAccountReportUtils.a(null, "", "0X8008449", "0X8008449", 0, 0, "", "", "", RIJTransMergeKanDianReport.e(), false);
    }
    RIJDeliverUGCReportUtil.h();
  }
  
  protected void t()
  {
    if (this.at == null)
    {
      this.at = ((ActionSheet)ActionSheetHelper.b(this, null));
      this.at.addButton(2131915345, 5);
      this.at.addButton(2131915347, 5);
      this.at.addCancelButton(2131887648);
      this.at.setOnDismissListener(new ReadInJoyDeliverUGCActivity.9(this));
      this.at.setOnButtonClickListener(new ReadInJoyDeliverUGCActivity.10(this));
    }
    if (!this.at.isShowing())
    {
      this.q = this.p;
      this.am = false;
      this.at.show();
    }
  }
  
  public void u()
  {
    F();
    PublicAccountReportUtils.a(null, "", "0X800823A", "0X800823A", 0, 0, "", "", "", RIJTransMergeKanDianReport.e(), false);
  }
  
  public void v()
  {
    List localList = this.aw.b();
    if (localList.size() == 0) {
      this.aw.c(this.aG);
    } else if ((localList.size() < 9) && (!localList.get(localList.size() - 1).equals(this.aG))) {
      this.aw.c(this.aG);
    }
    this.aw.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverUGCActivity
 * JD-Core Version:    0.7.0.1
 */