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
import com.tencent.mobileqq.kandian.biz.biu.BiuNicknameSpan;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.publisher.report.PublisherReportUtils;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJDeliverUGCUtils;
import com.tencent.mobileqq.kandian.biz.ugc.camera.api.IReadInJoyCaptureLauncher;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.kandian.glue.text.JumpSpan;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
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
  public static Drawable a;
  private boolean A = false;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  ProtoUtils.TroopProtocolObserver jdField_a_of_type_ComTencentBizProtoUtils$TroopProtocolObserver = new ReadInJoyDeliverUGCActivity.17(this);
  private ReadInJoyNinePicDeliverDynamicGridView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView;
  private ReadInJoyDeliverUGCActivity.ReportInfo jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity$ReportInfo = new ReadInJoyDeliverUGCActivity.ReportInfo(this);
  private ReadInJoyNinePicAdapter jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter;
  private DeliverData jdField_a_of_type_ComTencentMobileqqKandianRepoUgcDeliverData = new DeliverData();
  private CommunityInfo jdField_a_of_type_ComTencentTkdTopicsdkBeanCommunityInfo;
  private String jdField_a_of_type_JavaLangString = "";
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private JSONObject jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
  private long jdField_b_of_type_Long = 0L;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private QQProgressDialog jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private ArrayList<BiuCommentInfo> jdField_b_of_type_JavaUtilArrayList;
  private List<Integer> jdField_b_of_type_JavaUtilList = new ArrayList();
  private float jdField_c_of_type_Float;
  private ActionSheet jdField_c_of_type_ComTencentWidgetActionSheet;
  private List<ReadInJoyDeliverUGCActivity.UGCTransProcessorHandler> jdField_c_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private float jdField_d_of_type_Float;
  private List<TransferRequest> jdField_d_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private List<String> e;
  private String f;
  private String g;
  private String h;
  private int k = 0;
  private int l = 0;
  private int m;
  private int n;
  private int o;
  private int p = 40000;
  private int jdField_q_of_type_Int = 0;
  private boolean jdField_q_of_type_Boolean = false;
  private int jdField_r_of_type_Int;
  private boolean jdField_r_of_type_Boolean = false;
  private int jdField_s_of_type_Int;
  private boolean jdField_s_of_type_Boolean = false;
  private boolean t = false;
  private boolean u = false;
  private boolean v = false;
  private boolean w = false;
  private boolean x;
  private boolean y;
  private boolean z;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(-855310);
  }
  
  public ReadInJoyDeliverUGCActivity()
  {
    this.jdField_e_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_m_of_type_Int = 0;
    this.jdField_o_of_type_Int = 0;
  }
  
  private void A()
  {
    ThreadManager.executeOnFileThread(new ReadInJoyDeliverUGCActivity.12(this));
  }
  
  private void B()
  {
    l();
    a(1, getString(2131717876));
    i();
    QLog.d("ReadInJoyDeliverUGCActivity", 2, "startUploadPic oncommon error!");
  }
  
  private void C()
  {
    this.k = 0;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoUgcDeliverData.a();
  }
  
  private void D()
  {
    C();
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ReadInJoyDeliverUGCActivity.UGCTransProcessorHandler)localIterator.next()).a = false;
    }
    localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      TransferRequest localTransferRequest = (TransferRequest)localIterator.next();
      ((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).stop(localTransferRequest);
    }
    this.jdField_c_of_type_JavaUtilList.clear();
  }
  
  private int a()
  {
    if ((b() == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText()))) {
      return 3;
    }
    if ((b() != 0) && (TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText())))
    {
      if (b()) {
        return 4;
      }
      return 1;
    }
    if ((b() != 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText())))
    {
      if (b()) {
        return 5;
      }
      return 2;
    }
    return 0;
  }
  
  public static URLDrawable a(HotPicData paramHotPicData)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
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
      paramHotPicData = HotVideoPreviewDownloader.a((HotVideoData)paramHotPicData);
    } else {
      paramHotPicData = HotPicDownLoader.a(paramHotPicData.url);
    }
    if (paramHotPicData == null) {
      return null;
    }
    return URLDrawable.getDrawable(paramHotPicData, localURLDrawableOptions);
  }
  
  private String a(int paramInt)
  {
    String str = RIJTransMergeKanDianReport.c();
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
  
  private String a(Object paramObject)
  {
    String str = this.jdField_a_of_type_JavaLangString;
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
          paramObject = HexUtil.bytes2HexStr(FileManagerUtil.d(str));
        }
      }
      return paramObject;
    }
    return str;
  }
  
  @Nullable
  private String a(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof HotPicData))
    {
      a((HotPicData)paramObject, paramInt);
      return null;
    }
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      if (a(paramObject)) {
        return null;
      }
      return paramObject;
    }
    B();
    return null;
  }
  
  private void a(long paramLong1, long paramLong2, String paramString, CompressInfo paramCompressInfo, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      paramString = paramString.substring(paramString.lastIndexOf(".") + 1);
      if (paramLong2 == paramLong1)
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800951E", "0X800951E", 0, 0, String.valueOf(paramCompressInfo.d), String.valueOf(paramCompressInfo.jdField_e_of_type_Int), paramString, RIJTransMergeKanDianReport.a(0), false);
        return;
      }
      if (paramLong2 <= paramLong1) {
        break label147;
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800951E", "0X800951E", 0, 0, String.valueOf(paramCompressInfo.d), String.valueOf(paramCompressInfo.jdField_e_of_type_Int), paramString, RIJTransMergeKanDianReport.a(1), false);
      return;
    }
    catch (Exception paramString)
    {
      label132:
      label147:
      break label132;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "0X800951E reportError");
    }
  }
  
  private void a(long paramLong, String paramString, CompressInfo paramCompressInfo, boolean paramBoolean, int paramInt)
  {
    String str;
    if (TextUtils.isEmpty(paramCompressInfo.jdField_e_of_type_JavaLangString)) {
      str = paramString;
    } else {
      str = paramCompressInfo.jdField_e_of_type_JavaLangString;
    }
    long l1 = new File(str).length();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity$ReportInfo.b(paramInt, l1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("afterCompress picture: w:");
    localStringBuilder.append(paramCompressInfo.d);
    localStringBuilder.append("  h:");
    localStringBuilder.append(paramCompressInfo.jdField_e_of_type_Int);
    localStringBuilder.append(" size:");
    localStringBuilder.append(l1 / 1024L);
    localStringBuilder.append("kb");
    QLog.d("ReadInJoyDeliverUGCActivity", 2, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity$ReportInfo.d(paramInt, NetConnInfoCenter.getServerTimeMillis());
    if (a(str, paramInt)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity$ReportInfo.e(paramInt, NetConnInfoCenter.getServerTimeMillis());
    a(paramLong, l1, paramString, paramCompressInfo, paramBoolean);
  }
  
  private void a(HotPicData paramHotPicData, int paramInt)
  {
    if (paramInt < 9)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoUgcDeliverData.a(paramInt, paramHotPicData.originalUrl);
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoUgcDeliverData.b(paramInt, paramHotPicData.md5);
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoUgcDeliverData.b(paramInt, Integer.valueOf(paramHotPicData.height));
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoUgcDeliverData.a(paramInt, Integer.valueOf(paramHotPicData.width));
      this.k += 1;
    }
    else
    {
      this.u = false;
      l();
    }
    if (this.k == b())
    {
      this.v = true;
      new RIJPublishTrendsHandler().a(c(), this.jdField_b_of_type_JavaUtilArrayList, this.k, this.jdField_a_of_type_ComTencentMobileqqKandianRepoUgcDeliverData, this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI, this.jdField_a_of_type_ComTencentBizProtoUtils$TroopProtocolObserver);
    }
  }
  
  private void a(CommunityInfo paramCommunityInfo)
  {
    String str = getResources().getString(2131717870);
    if (paramCommunityInfo == null)
    {
      a(null, true);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentTkdTopicsdkBeanCommunityInfo != null) && (TextUtils.equals(paramCommunityInfo.getCommunityId(), this.jdField_a_of_type_ComTencentTkdTopicsdkBeanCommunityInfo.getCommunityId())))
    {
      this.jdField_a_of_type_ComTencentTkdTopicsdkBeanCommunityInfo = null;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      a(paramCommunityInfo, true);
    }
    else
    {
      a(this.jdField_a_of_type_ComTencentTkdTopicsdkBeanCommunityInfo, true);
      a(paramCommunityInfo, false);
      this.jdField_a_of_type_ComTencentTkdTopicsdkBeanCommunityInfo = paramCommunityInfo;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramCommunityInfo.getTitle());
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
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800BB31", "0X800BB31", 0, 0, "", "", "", localJSONObject.toString(), false);
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
  
  private void a(Object paramObject)
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter.a();
    if (b() < 9)
    {
      Object localObject = paramObject;
      if ((paramObject instanceof String))
      {
        localObject = paramObject;
        if (localList.contains(paramObject)) {
          localObject = a((String)paramObject);
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
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter.a(localList.size() - 1, paramObject);
      b(paramObject);
      if (localList.size() > 9) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter.d(localList.get(9));
      }
    }
    else
    {
      a(1, getString(2131717877));
    }
    p();
  }
  
  private void a(Object paramObject, int paramInt)
  {
    new Thread(new ReadInJoyDeliverUGCActivity.16(this, paramObject, paramInt)).start();
  }
  
  private void a(String paramString, long paramLong, ReadInJoyDeliverUGCActivity.CompressFile paramCompressFile, int paramInt)
  {
    CompressInfo localCompressInfo = paramCompressFile.a();
    boolean bool = paramCompressFile.b();
    if (a(paramCompressFile.a(), paramInt)) {
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
        a(paramList.next());
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt > 8) {
        return false;
      }
      List localList = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter.a();
      if (!(localList.get(paramInt) instanceof HotPicData))
      {
        if (this.jdField_a_of_type_JavaLangString.equals(localList.get(paramInt))) {
          return true;
        }
        String str = a(localList.get(paramInt));
        int i = 0;
        while (i < paramInt)
        {
          if (str.equals(a(localList.get(i)))) {
            return false;
          }
          i += 1;
        }
      }
      return true;
    }
    return false;
  }
  
  private boolean a(BitmapFactory.Options paramOptions, int paramInt)
  {
    if (this.u)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoUgcDeliverData.a(paramInt, Integer.valueOf(paramOptions.outWidth));
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoUgcDeliverData.b(paramInt, Integer.valueOf(paramOptions.outHeight));
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
    if (!this.u) {
      return true;
    }
    return paramObject.equals(this.jdField_a_of_type_JavaLangString);
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      l();
      a(1, getString(2131717876));
      i();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "startUploadPic empty path!");
      }
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString, int paramInt)
  {
    ITransFileController localITransFileController = (ITransFileController)this.app.getRuntimeService(ITransFileController.class);
    ReadInJoyDeliverUGCActivity.UGCTransProcessorHandler localUGCTransProcessorHandler = new ReadInJoyDeliverUGCActivity.UGCTransProcessorHandler(this, getMainLooper());
    TransferRequest localTransferRequest = new TransferRequest();
    if (this.u)
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
      this.jdField_c_of_type_JavaUtilList.add(localUGCTransProcessorHandler);
      this.jdField_d_of_type_JavaUtilList.add(localTransferRequest);
      return false;
    }
    return true;
  }
  
  private int b()
  {
    ReadInJoyNinePicAdapter localReadInJoyNinePicAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter;
    if (localReadInJoyNinePicAdapter != null)
    {
      int j = localReadInJoyNinePicAdapter.a().size();
      int i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter.a().get(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter.a().size() - 1).equals(this.jdField_a_of_type_JavaLangString)) {
        i = j - 1;
      }
      return i;
    }
    return 0;
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      if ((this.jdField_n_of_type_Boolean) && (paramInt - this.jdField_c_of_type_Int <= 0))
      {
        if (this.jdField_n_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_c_of_type_Int - paramInt));
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
    if (paramInt - this.jdField_c_of_type_Int > 0)
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF4222"));
      }
      this.jdField_d_of_type_Boolean = true;
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#BBBBBB"));
    }
    this.jdField_d_of_type_Boolean = false;
  }
  
  private void b(Object paramObject)
  {
    boolean bool = paramObject instanceof String;
    Integer localInteger = Integer.valueOf(2);
    if (bool)
    {
      if (BaseImageUtil.b((String)paramObject))
      {
        this.jdField_b_of_type_JavaUtilList.add(localInteger);
        return;
      }
      this.jdField_b_of_type_JavaUtilList.add(Integer.valueOf(3));
      return;
    }
    this.jdField_b_of_type_JavaUtilList.add(localInteger);
  }
  
  private void b(Object paramObject, int paramInt)
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter.a();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter.a(paramInt, paramObject);
    c(paramObject, paramInt);
    if (localList.size() > 9) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter.d(localList.get(9));
    }
    p();
  }
  
  private boolean b()
  {
    if (b() != 0)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter.a().size() - 1)
      {
        if (!(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter.a().get(i) instanceof HotPicData)) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  private void c(Object paramObject, int paramInt)
  {
    boolean bool = paramObject instanceof String;
    Integer localInteger = Integer.valueOf(2);
    if (bool)
    {
      if (BaseImageUtil.b((String)paramObject))
      {
        this.jdField_b_of_type_JavaUtilList.add(paramInt, localInteger);
        return;
      }
      this.jdField_b_of_type_JavaUtilList.add(paramInt, Integer.valueOf(3));
      return;
    }
    this.jdField_b_of_type_JavaUtilList.add(paramInt, localInteger);
  }
  
  private void c(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("publisher_type", 1);
      localJSONObject.put("contant", 2);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramString, paramString, 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("ReadInJoyDeliverUGCActivity", 1, paramString, new Object[0]);
    }
  }
  
  private String e()
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        i = a().intValue();
        int j = 1;
        if (i > 0)
        {
          i = 1;
          localJSONObject.put("topic", i);
          String str3 = d();
          String str1 = str3;
          if ("0".equalsIgnoreCase(str3)) {
            str1 = "";
          }
          localJSONObject.put("topicid", str1);
          localJSONObject.put("topic_num", a());
          localJSONObject.put("sticker", RIJDeliverUGCReportUtil.a(c()));
          if (this.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI == null) {
            break label274;
          }
          i = 1;
          localJSONObject.put("location", i);
          if (!c().contains("@")) {
            break label279;
          }
          i = 1;
          localJSONObject.put("at", i);
          if (!b()) {
            break label284;
          }
          i = 1;
          localJSONObject.put("gif", i);
          if (b() <= 0) {
            break label289;
          }
          i = j;
          localJSONObject.put("pic", i);
          if (this.jdField_a_of_type_ComTencentTkdTopicsdkBeanCommunityInfo == null) {
            break label294;
          }
          str1 = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanCommunityInfo.getCommunityId();
          localJSONObject.put("kdcommunity_id", str1);
          localJSONObject.put("from", PublisherReportUtils.a.b(this.jdField_s_of_type_Int));
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
  
  private String f()
  {
    if ((b() == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText()))) {
      return "3";
    }
    if (((b() != 0) || (b())) && (TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText()))) {
      return "1";
    }
    if (((b() != 0) || (b())) && (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText()))) {
      return "2";
    }
    return "0";
  }
  
  private void f(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt > 8) {
        return;
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter.a().get(paramInt);
      if ((localObject instanceof HotPicData))
      {
        localObject = (HotPicData)localObject;
        if (HotPicPageView.a((HotPicData)localObject) == 0)
        {
          HotPicDownLoader.a(((HotPicData)localObject).url).getAbsolutePath();
          g(paramInt);
        }
      }
      else if (((String)this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter.a().get(paramInt)).equals(this.jdField_a_of_type_JavaLangString))
      {
        if (9 - b() > 0)
        {
          n();
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008238", "0X8008238", 0, 0, "", "", "", RIJTransMergeKanDianReport.c(), false);
        }
        else
        {
          a(1, getString(2131717877));
        }
      }
      else
      {
        g(paramInt);
      }
      RIJDeliverUGCReportUtil.b();
    }
  }
  
  private void g(int paramInt)
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this, "/base/album/photopreview");
    this.l = paramInt;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter.a().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!localObject.equals(this.jdField_a_of_type_JavaLangString)) {
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
    localActivityURIRequest.extra().putString("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationReadInJoy.jdField_a_of_type_JavaLangString);
    localActivityURIRequest.extra().putString("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationReadInJoy.jdField_a_of_type_JavaLangString);
    localActivityURIRequest.extra().putInt("extra.busi_type", 8);
    this.jdField_o_of_type_Int = 1002;
    localActivityURIRequest.setRequestCode(this.jdField_o_of_type_Int);
    QRoute.startUri(localActivityURIRequest);
    overridePendingTransition(2130772335, 2130772337);
  }
  
  private void h(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = this.jdField_b_of_type_Long;
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
  
  private void i(int paramInt)
  {
    ReadInJoyNinePicAdapter localReadInJoyNinePicAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter;
    localReadInJoyNinePicAdapter.d(localReadInJoyNinePicAdapter.a().get(paramInt));
    this.jdField_b_of_type_JavaUtilList.remove(paramInt);
    if (b() == 0)
    {
      a(false);
      if (this.jdField_r_of_type_Int == 1)
      {
        a(true);
        this.rightViewText.setTextColor(Color.parseColor("#BBBBBB"));
      }
    }
    p();
    RIJDeliverUGCReportUtil.l();
  }
  
  private void q()
  {
    View localView = findViewById(2131365039);
    AladdinConfig localAladdinConfig = Aladdin.getConfig(354);
    if ((localAladdinConfig != null) && (localAladdinConfig.getIntegerFromString("ugc_publish_show_community", 0) == 1))
    {
      a(false);
      this.w = true;
      localView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377169));
      localView.setOnClickListener(this);
      c("0X800BB2F");
      return;
    }
    localView.setVisibility(8);
  }
  
  private void r()
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      this.jdField_a_of_type_Long = localIntent.getLongExtra("readinjoy_draftbox_id", -1L);
      if (this.jdField_a_of_type_Long != -1L) {
        ThreadManager.getSubThreadHandler().post(new ReadInJoyDeliverUGCActivity.5(this));
      }
    }
  }
  
  private void s()
  {
    ThreadManager.getUIHandler().post(new ReadInJoyDeliverUGCActivity.6(this));
  }
  
  private void t()
  {
    Object localObject = this.jdField_b_of_type_JavaUtilArrayList;
    if ((localObject != null) && (this.w))
    {
      localObject = (BiuCommentInfo)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      if (((BiuCommentInfo)localObject).mOpType == 4)
      {
        this.jdField_a_of_type_ComTencentTkdTopicsdkBeanCommunityInfo = new CommunityInfo();
        this.jdField_a_of_type_ComTencentTkdTopicsdkBeanCommunityInfo.setCommunityId(String.valueOf(((BiuCommentInfo)localObject).jumpInfo.getId()));
        this.jdField_a_of_type_ComTencentTkdTopicsdkBeanCommunityInfo.setTitle(((BiuCommentInfo)localObject).jumpInfo.getWording());
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentTkdTopicsdkBeanCommunityInfo.getTitle());
      }
      this.jdField_b_of_type_JavaUtilArrayList.remove(localObject);
    }
  }
  
  private void u()
  {
    if ((this.jdField_r_of_type_Int == 1) && (b() == 0))
    {
      QQToast.a(this, 1, HardCodeUtil.a(2131712862), 0).a();
      return;
    }
    if ((this.w) && (this.jdField_a_of_type_ComTencentTkdTopicsdkBeanCommunityInfo == null))
    {
      QQToast.a(this, 1, getResources().getString(2131717871), 0).a();
      return;
    }
    a();
  }
  
  private void v()
  {
    SelectKDCommunityView.Companion localCompanion = SelectKDCommunityView.a;
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanCommunityInfo;
    if (localObject != null) {
      localObject = ((CommunityInfo)localObject).getCommunityId();
    } else {
      localObject = "";
    }
    localCompanion.a(this, (String)localObject, new ReadInJoyDeliverUGCActivity.7(this));
    c("0X800BB30");
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_Long != -1L) {
      ThreadManager.getSubThreadHandler().post(new ReadInJoyDeliverUGCActivity.8(this));
    }
  }
  
  private void x()
  {
    if ((Build.VERSION.SDK_INT >= 23) && (checkSelfPermission("android.permission.CAMERA") != 0))
    {
      requestPermissions(new ReadInJoyDeliverUGCActivity.11(this), 2000, new String[] { "android.permission.CAMERA" });
      return;
    }
    o();
  }
  
  private void y()
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this, "/base/album/photolist");
    localActivityURIRequest.extra().putInt("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    localActivityURIRequest.extra().putString("PhotoConst.MY_UIN", this.app.getAccount());
    localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ReadInJoyDeliverUGCActivity.class.getName());
    localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localActivityURIRequest.extra().putInt("extra.busi_type", 8);
    localActivityURIRequest.extra().putBoolean("PhotoConst.HANDLE_DEST_RESULT", false);
    localActivityURIRequest.extra().putInt("PhotoConst.MAXUM_SELECTED_NUM", 9 - b());
    localActivityURIRequest.extra().putInt("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    localActivityURIRequest.extra().putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    if (9 - b() == 1) {
      localActivityURIRequest.extra().putBoolean("from_readinjoy_ugc", true);
    } else {
      localActivityURIRequest.extra().putBoolean("from_readinjoy_ugc_deliver_preview", true);
    }
    localActivityURIRequest.extra().putBoolean("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
    localActivityURIRequest.extra().putBoolean("PhotoConst.original_button", false);
    localActivityURIRequest.extra().putInt("enter_from", 25);
    localActivityURIRequest.extra().putString("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationReadInJoy.jdField_a_of_type_JavaLangString);
    localActivityURIRequest.extra().putString("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationReadInJoy.jdField_a_of_type_JavaLangString);
    this.jdField_o_of_type_Int = 1000;
    localActivityURIRequest.setRequestCode(this.jdField_o_of_type_Int);
    QRoute.startUri(localActivityURIRequest);
    overridePendingTransition(2130771993, 2130771991);
  }
  
  private void z()
  {
    ((IReadInJoyCaptureLauncher)QRoute.api(IReadInJoyCaptureLauncher.class)).launchPhotoCapture(this);
    this.jdField_o_of_type_Int = 1001;
    overridePendingTransition(2130771993, 2130771991);
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
      int i1 = paramList.size();
      i = 0;
      if (i <= i1 - 1)
      {
        localBiuCommentInfo = (BiuCommentInfo)paramList.get(i);
        int i2 = localBiuCommentInfo.mOpType;
        str = "";
        if (i2 != 2) {
          if (i2 != 3) {
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
          localObject2 = ReadInJoyUserInfoModule.a();
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, localNumberFormatException.getMessage());
        break label585;
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
        str = EmotionCodecUtils.b(localBiuCommentInfo.mBiuComment);
      }
      localStringBuilder.append(str);
      localArrayList.add(new PositionalSpanStruct(j, ((String)localObject2).length() + j, new BiuNicknameSpan(localBiuCommentInfo.mUin.toString(), localBiuCommentInfo.mFeedId.longValue(), (CharSequence)localObject2, paramContext, paramEditText.getPaint(), paramInt)));
      break label585;
      Object localObject1;
      if (localBiuCommentInfo.mBiuComment != null) {
        localObject1 = EmotionCodecUtils.b(localBiuCommentInfo.mBiuComment);
      }
      localStringBuilder.append((String)localObject1);
      break label585;
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
        break label585;
        if (localBiuCommentInfo.jumpInfo != null)
        {
          localObject2 = localBiuCommentInfo.jumpInfo.getWording();
          localBiuCommentInfo.jumpInfo.getJumpUrl();
          if (localBiuCommentInfo.mBiuComment != null) {
            localObject1 = localBiuCommentInfo.mBiuComment;
          }
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append((String)localObject1);
          localObject1 = TopicInfo.a().a(Long.valueOf(localBiuCommentInfo.jumpInfo.getId()).longValue()).a((String)localObject2).a();
          localArrayList.add(new PositionalSpanStruct(j, ((String)localObject2).length() + j, new TopicSpan((TopicInfo)localObject1)));
        }
      }
      label585:
      j = localStringBuilder.length();
      i += 1;
      break;
      paramList = new SpannableStringBuilder(new QQText(localStringBuilder, 3, 20));
      paramContext = localArrayList.iterator();
      while (paramContext.hasNext())
      {
        paramEditText = (PositionalSpanStruct)paramContext.next();
        paramList.setSpan(paramEditText.a(), paramEditText.a(), paramEditText.b(), 33);
      }
      return paramList;
      return null;
      if (localObject2 == null) {
        localObject2 = "";
      }
    }
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: aload_1
    //   3: bipush 46
    //   5: invokevirtual 1283	java/lang/String:indexOf	(I)I
    //   8: invokevirtual 1286	java/lang/String:substring	(II)Ljava/lang/String;
    //   11: astore 4
    //   13: aload_1
    //   14: aload_1
    //   15: bipush 46
    //   17: invokevirtual 1283	java/lang/String:indexOf	(I)I
    //   20: invokevirtual 395	java/lang/String:substring	(I)Ljava/lang/String;
    //   23: astore_3
    //   24: new 437	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 438	java/lang/StringBuilder:<init>	()V
    //   31: astore 5
    //   33: aload 5
    //   35: aload 4
    //   37: invokevirtual 444	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 5
    //   43: ldc_w 1288
    //   46: invokevirtual 444	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 5
    //   52: invokevirtual 459	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: astore 4
    //   57: new 437	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 438	java/lang/StringBuilder:<init>	()V
    //   64: astore 5
    //   66: aload 5
    //   68: aload 4
    //   70: invokevirtual 444	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 5
    //   76: aload_3
    //   77: invokevirtual 444	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload 5
    //   83: invokevirtual 459	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: astore 6
    //   88: new 352	java/io/File
    //   91: dup
    //   92: aload 6
    //   94: invokespecial 353	java/io/File:<init>	(Ljava/lang/String;)V
    //   97: invokevirtual 356	java/io/File:exists	()Z
    //   100: ifeq +10 -> 110
    //   103: aload_0
    //   104: aload 6
    //   106: invokevirtual 596	com/tencent/mobileqq/kandian/biz/ugc/ReadInJoyDeliverUGCActivity:a	(Ljava/lang/String;)Ljava/lang/String;
    //   109: areturn
    //   110: aconst_null
    //   111: astore 5
    //   113: new 1290	java/io/FileInputStream
    //   116: dup
    //   117: aload_1
    //   118: invokespecial 1291	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   121: astore 4
    //   123: new 1293	java/io/FileOutputStream
    //   126: dup
    //   127: aload 6
    //   129: invokespecial 1294	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   132: astore_3
    //   133: sipush 1024
    //   136: newarray byte
    //   138: astore_1
    //   139: aload 4
    //   141: aload_1
    //   142: invokevirtual 1300	java/io/InputStream:read	([B)I
    //   145: istore_2
    //   146: iload_2
    //   147: ifle +13 -> 160
    //   150: aload_3
    //   151: aload_1
    //   152: iconst_0
    //   153: iload_2
    //   154: invokevirtual 1306	java/io/OutputStream:write	([BII)V
    //   157: goto -18 -> 139
    //   160: aload_0
    //   161: getfield 72	com/tencent/mobileqq/kandian/biz/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   164: aload 6
    //   166: invokeinterface 768 2 0
    //   171: pop
    //   172: aload 4
    //   174: invokevirtual 1309	java/io/InputStream:close	()V
    //   177: goto +8 -> 185
    //   180: astore_1
    //   181: aload_1
    //   182: invokevirtual 1310	java/io/IOException:printStackTrace	()V
    //   185: aload_3
    //   186: invokevirtual 1311	java/io/OutputStream:close	()V
    //   189: aload 6
    //   191: areturn
    //   192: astore_1
    //   193: aload_1
    //   194: invokevirtual 1310	java/io/IOException:printStackTrace	()V
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
    //   233: getfield 129	com/tencent/mobileqq/kandian/biz/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   236: astore 4
    //   238: aload_1
    //   239: ifnull +15 -> 254
    //   242: aload_1
    //   243: invokevirtual 1309	java/io/InputStream:close	()V
    //   246: goto +8 -> 254
    //   249: astore_1
    //   250: aload_1
    //   251: invokevirtual 1310	java/io/IOException:printStackTrace	()V
    //   254: aload_3
    //   255: ifnull +15 -> 270
    //   258: aload_3
    //   259: invokevirtual 1311	java/io/OutputStream:close	()V
    //   262: aload 4
    //   264: areturn
    //   265: astore_1
    //   266: aload_1
    //   267: invokevirtual 1310	java/io/IOException:printStackTrace	()V
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
    //   288: invokevirtual 1309	java/io/InputStream:close	()V
    //   291: goto +10 -> 301
    //   294: astore 4
    //   296: aload 4
    //   298: invokevirtual 1310	java/io/IOException:printStackTrace	()V
    //   301: aload_3
    //   302: ifnull +15 -> 317
    //   305: aload_3
    //   306: invokevirtual 1311	java/io/OutputStream:close	()V
    //   309: goto +8 -> 317
    //   312: astore_3
    //   313: aload_3
    //   314: invokevirtual 1310	java/io/IOException:printStackTrace	()V
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
  
  protected void a()
  {
    this.jdField_f_of_type_Int = 178;
    super.a();
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView = ((ReadInJoyNinePicDeliverDynamicGridView)findViewById(2131376071));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367678));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379036));
    boolean bool = RIJUgcUtils.d();
    if ((HotPicManager.a(this.app).b()) && (bool)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    } else {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (!RIJUgcUtils.f()) {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    } else {
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    }
    q();
  }
  
  protected void a(int paramInt)
  {
    super.a(paramInt);
    a(false);
  }
  
  protected void a(Editable paramEditable)
  {
    super.a(paramEditable);
    if (b() != 0)
    {
      a(true);
    }
    else if (paramEditable.length() <= 0)
    {
      a(false);
    }
    else if (this.jdField_r_of_type_Int == 1)
    {
      a(true);
      if (b() == 0) {
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
    if (a().intValue() < this.jdField_q_of_type_Int) {
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
      a(paramHotPicData);
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
    this.jdField_q_of_type_Int = a().intValue();
    if (paramInt3 < paramInt2) {
      b(paramCharSequence.length());
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    this.rightViewText.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      if ((this.w) && (this.jdField_a_of_type_ComTencentTkdTopicsdkBeanCommunityInfo == null))
      {
        this.rightViewText.setTextColor(Color.parseColor("#BBBBBB"));
        return;
      }
      if (b() > 0)
      {
        this.rightViewText.setTextColor(Color.parseColor("#262626"));
        return;
      }
      if (this.jdField_r_of_type_Int == 1)
      {
        this.rightViewText.setTextColor(Color.parseColor("#BBBBBB"));
        return;
      }
      if (TextUtils.getTrimmedLength(this.jdField_a_of_type_AndroidWidgetEditText.getText()) <= 0)
      {
        this.rightViewText.setTextColor(Color.parseColor("#BBBBBB"));
        return;
      }
      this.rightViewText.setTextColor(Color.parseColor("#262626"));
      return;
    }
    this.rightViewText.setTextColor(Color.parseColor("#BBBBBB"));
  }
  
  protected boolean a()
  {
    AioPicTransFileController.a(getCurrentAccountUin(), new ReadInJoyDeliverUGCActivity.15(this));
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "onDeliver!");
    }
    RIJDeliverUGCReportUtil.a(f(), b(), e());
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008240", "0X8008240", 0, 0, String.valueOf(a()), Integer.valueOf(b()).toString(), "", b(), false);
    boolean bool = super.a();
    int j = 0;
    if (!bool) {
      return false;
    }
    int i;
    if (b() == 0)
    {
      i = 1;
    }
    else
    {
      if ((!this.jdField_m_of_type_Boolean) && (!NetworkUtil.isWifiConnected(this)))
      {
        k();
        return false;
      }
      i = 2;
    }
    Object localObject2;
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("type", i);
    }
    catch (Exception localException1)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("mResultJson error");
      ((StringBuilder)localObject2).append(localException1.toString());
      QLog.d("ReadInJoyDeliverUGCActivity", 2, ((StringBuilder)localObject2).toString());
    }
    e(2131695224);
    this.u = true;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    Utils.a(this.jdField_a_of_type_AndroidWidgetEditText, this.app.getCurrentAccountUin(), this.jdField_o_of_type_Boolean, this.jdField_b_of_type_JavaUtilArrayList);
    a(this.jdField_b_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentTkdTopicsdkBeanCommunityInfo);
    this.jdField_b_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    if (i == 1) {}
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("picCount", 0);
      label280:
      new RIJPublishTrendsHandler().a(c(), this.jdField_b_of_type_JavaUtilArrayList, this.k, this.jdField_a_of_type_ComTencentMobileqqKandianRepoUgcDeliverData, this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI, this.jdField_a_of_type_ComTencentBizProtoUtils$TroopProtocolObserver);
      this.u = false;
      return true;
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter.a();
      this.v = false;
      localObject1 = ((List)localObject1).iterator();
      i = j;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (!this.u) {
          break;
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("picIsReadToup=position");
          localStringBuilder.append(i);
          QLog.d("ReadInJoyDeliverUGCActivity", 2, localStringBuilder.toString());
        }
        if (a(i)) {
          a(localObject2, i);
        }
        i += 1;
      }
      return true;
    }
    catch (Exception localException2)
    {
      break label280;
    }
  }
  
  protected void b()
  {
    boolean bool = true;
    this.jdField_n_of_type_Boolean = true;
    this.jdField_o_of_type_Boolean = true;
    this.jdField_h_of_type_Boolean = getIntent().getBooleanExtra("support_topic", false);
    this.i = getIntent().getBooleanExtra("support_linkify", true);
    super.b();
    this.jdField_e_of_type_JavaLangString = "0X800865D";
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter = new ReadInJoyNinePicAdapter(getApplicationContext(), 3);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter.a(new ReadInJoyDeliverUGCActivity.1(this));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter.a(new ReadInJoyDeliverUGCActivity.2(this));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView.setOnItemLongClickListener(new ReadInJoyDeliverUGCActivity.3(this));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView.setOnDragListener(new ReadInJoyDeliverUGCActivity.4(this));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter);
    p();
    this.jdField_f_of_type_JavaLangString = getIntent().getStringExtra("arg_topic_id");
    this.jdField_g_of_type_JavaLangString = getIntent().getStringExtra("arg_topic_name");
    this.jdField_n_of_type_Int = getIntent().getIntExtra("arg_ad_tag", 0);
    this.jdField_h_of_type_JavaLangString = getIntent().getStringExtra("arg_ugc_edit_cookie");
    this.x = getIntent().getBooleanExtra("is_from_dian_dian", false);
    this.y = getIntent().getBooleanExtra("is_from_kan_dian", false);
    this.z = getIntent().getBooleanExtra("is_from_poly_topic", false);
    this.jdField_s_of_type_Int = getIntent().getIntExtra("key_from", 0);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initData mTopicId=");
      ((StringBuilder)localObject).append(this.jdField_f_of_type_JavaLangString);
      ((StringBuilder)localObject).append(", mTopicName=");
      ((StringBuilder)localObject).append(this.jdField_g_of_type_JavaLangString);
      ((StringBuilder)localObject).append(", mAdTag=");
      ((StringBuilder)localObject).append(this.jdField_n_of_type_Int);
      QLog.d("ReadInJoyDeliverUGCActivity", 2, ((StringBuilder)localObject).toString());
    }
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
      localObject = "0";
    } else {
      localObject = String.valueOf(this.jdField_f_of_type_JavaLangString);
    }
    String str;
    if (this.x) {
      str = "1";
    } else {
      str = "2";
    }
    localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", "0X8008237", "0X8008237", 0, 0, "", (String)localObject, str, RIJTransMergeKanDianReport.c(), false);
    if (ReadInJoyHelper.j(this.app) != 0) {
      bool = false;
    }
    this.jdField_g_of_type_Boolean = bool;
    if ((!this.jdField_g_of_type_Boolean) && (this.jdField_b_of_type_AndroidWidgetImageView != null)) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    r();
  }
  
  protected void b(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.b(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if (!this.A)
    {
      RIJDeliverUGCReportUtil.a();
      this.A = true;
    }
    if (RIJDeliverUGCReportUtil.a(paramCharSequence.toString()))
    {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "onTextChanged | insert Emoji");
      RIJDeliverUGCReportUtil.f();
    }
  }
  
  protected void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "onEmotionBtn!");
    }
    RIJDeliverUGCReportUtil.e();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800823F", "0X800823F", 0, 0, "", "", "", RIJTransMergeKanDianReport.c(), false);
    super.c();
  }
  
  protected void d()
  {
    super.d();
    RIJDeliverUGCReportUtil.j();
  }
  
  protected void d(int paramInt)
  {
    this.jdField_s_of_type_Int = 1;
    super.d(paramInt);
    RIJDeliverUGCReportUtil.a(String.valueOf(paramInt));
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800957A", "0X800957A", 0, 0, "", "", "", RIJTransMergeKanDianReport.c(), false);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.jdField_c_of_type_Float = paramMotionEvent.getY();
    }
    if (paramMotionEvent.getAction() == 1)
    {
      this.jdField_d_of_type_Float = paramMotionEvent.getY();
      float f1 = this.jdField_c_of_type_Float;
      float f2 = this.jdField_d_of_type_Float;
      if ((f1 - f2 > 50.0F) || (f2 - f1 > 50.0F)) {
        this.jdField_q_of_type_Boolean = false;
      }
      if (this.jdField_q_of_type_Boolean)
      {
        f(this.jdField_m_of_type_Int);
        this.jdField_q_of_type_Boolean = false;
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView.a();
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131560173);
    PtvFilterSoLoad.a(this.app, BaseApplicationImpl.getContext());
    overridePendingTransition(2130771993, 2130771991);
    if (isInMultiWindow())
    {
      QQToast.a(this, HardCodeUtil.a(2131712739), 0).a();
      finish();
      return true;
    }
    this.jdField_r_of_type_Int = getIntent().getIntExtra("ugcPushType", 0);
    a(2131717879);
    a();
    b();
    RIJDtReportHelper.a.a(getActivity());
    return true;
  }
  
  protected void doOnDestroy()
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ReadInJoyDeliverUGCActivity.UGCTransProcessorHandler localUGCTransProcessorHandler = (ReadInJoyDeliverUGCActivity.UGCTransProcessorHandler)localIterator.next();
      ((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).removeHandle(localUGCTransProcessorHandler);
    }
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (this.jdField_o_of_type_Int == 1002)
    {
      String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      this.l = paramIntent.getIntExtra("PhotoConst.readinjoy_delete_pic_position", 0);
      if ((!TextUtils.isEmpty(str)) && (this.l < this.jdField_b_of_type_JavaUtilList.size()))
      {
        this.jdField_b_of_type_JavaUtilList.remove(this.l);
        ReadInJoyNinePicAdapter localReadInJoyNinePicAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter;
        localReadInJoyNinePicAdapter.d(localReadInJoyNinePicAdapter.a().get(this.l));
        b(str, this.l);
        this.jdField_e_of_type_JavaUtilList.add(str);
      }
    }
    int i = this.jdField_o_of_type_Int;
    if (i == 1001)
    {
      paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (!TextUtils.isEmpty(paramIntent)) {
        a(paramIntent);
      }
    }
    else if (i == 1000)
    {
      if (9 - b() == 1) {
        paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      } else {
        paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      }
      if ((paramIntent instanceof String))
      {
        paramIntent = (String)paramIntent;
        if (!TextUtils.isEmpty(paramIntent)) {
          a(paramIntent);
        }
        i = 1;
      }
      else
      {
        if (paramIntent == null) {
          break label284;
        }
        paramIntent = (List)paramIntent;
        i = paramIntent.size();
        a(paramIntent);
      }
      this.jdField_s_of_type_Boolean = true;
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800823A", "0X800823A", 0, 0, String.valueOf(i), "", "", RIJTransMergeKanDianReport.c(), false);
      break label300;
      label284:
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "error  back empty path ");
      }
      return;
    }
    label300:
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("doOnNewIntent mRequestCode=");
      paramIntent.append(this.jdField_o_of_type_Int);
      paramIntent.append(", path=");
      QLog.d("ReadInJoyDeliverUGCActivity", 2, paramIntent.toString());
    }
    a(true);
    this.jdField_o_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
  }
  
  protected void doOnPostResume()
  {
    super.doOnPostResume();
    AbstractGifImage.resumeAll();
    RIJDeliverUGCReportUtil.a(PublisherReportUtils.a.b(this.jdField_s_of_type_Int));
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
  }
  
  protected void e()
  {
    super.e();
  }
  
  protected void e(int paramInt)
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new ReadInJoyDeliverUGCActivity.18(this));
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
    if (!this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  protected void f()
  {
    super.f();
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(a());
    localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", "0X800823E", "0X800823E", 0, 0, localStringBuilder.toString(), "", "", RIJTransMergeKanDianReport.c(), false);
  }
  
  public void finish()
  {
    Object localObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).toString();
      getIntent().putExtra("arg_result_json", (String)localObject);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("finish resultJson=");
        localStringBuilder.append(((IRIJDeliverUGCUtils)QRoute.api(IRIJDeliverUGCUtils.class)).replaceUrlInLog((String)localObject));
        QLog.d("ReadInJoyDeliverUGCActivity", 2, localStringBuilder.toString());
      }
    }
    super.finish();
  }
  
  protected void g()
  {
    super.g();
    RIJDeliverUGCReportUtil.b("1");
  }
  
  protected void i()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800823D", "0X800823D", 0, 0, "", "", "", a(1), false);
    ThreadManager.getSubThreadHandler().post(new ReadInJoyDeliverUGCActivity.14(this));
  }
  
  protected void j()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800823D", "0X800823D", 0, 0, "", "", "", a(2), false);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoUgcReadInJoyDraftboxItem$ReadInJoyDraftboxContent != null) {
      ThreadManager.getSubThreadHandler().post(new ReadInJoyDeliverUGCActivity.13(this));
    } else {
      w();
    }
    A();
    finish();
  }
  
  protected void l()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  protected void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "onGifBtn!");
    }
    if (this.jdField_a_of_type_Int == 3)
    {
      c(1);
    }
    else
    {
      c(3);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008449", "0X8008449", 0, 0, "", "", "", RIJTransMergeKanDianReport.c(), false);
    }
    RIJDeliverUGCReportUtil.h();
  }
  
  protected void n()
  {
    if (this.jdField_c_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_c_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      this.jdField_c_of_type_ComTencentWidgetActionSheet.addButton(2131717872, 5);
      this.jdField_c_of_type_ComTencentWidgetActionSheet.addButton(2131717874, 5);
      this.jdField_c_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690728);
      this.jdField_c_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new ReadInJoyDeliverUGCActivity.9(this));
      this.jdField_c_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new ReadInJoyDeliverUGCActivity.10(this));
    }
    if (!this.jdField_c_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      this.jdField_r_of_type_Boolean = false;
      this.jdField_c_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  public void o()
  {
    z();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800823A", "0X800823A", 0, 0, "", "", "", RIJTransMergeKanDianReport.c(), false);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1002))
    {
      paramInt1 = paramIntent.getIntExtra("PhotoConst.readinjoy_delete_pic_position", -1);
      if (paramInt1 != -1) {
        i(paramInt1);
      }
      this.jdField_b_of_type_Int = 0;
    }
  }
  
  protected boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 3))
    {
      if (((this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString().trim().length() > 0) || (this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter.a().size() > 1)) && (!this.t))
      {
        h();
        return true;
      }
      return super.onBackEvent();
    }
    c(0);
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      super.onClick(paramView);
      return;
    case 2131369233: 
      u();
      return;
    case 2131369204: 
      if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 3)) {
        c(0);
      }
      if (((this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString().trim().length() > 0) || (this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter.a().size() > 1)) && (!this.t))
      {
        h();
        return;
      }
      finish();
      return;
    case 2131367678: 
      m();
      return;
    }
    v();
  }
  
  public void onPause()
  {
    super.onPause();
    AbstractGifImage.pauseAll();
  }
  
  public void p()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter.a();
    if (localList.size() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter.c(this.jdField_a_of_type_JavaLangString);
    } else if ((localList.size() < 9) && (!localList.get(localList.size() - 1).equals(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter.c(this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverUGCActivity
 * JD-Core Version:    0.7.0.1
 */