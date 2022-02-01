package cooperation.qzone;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import ahth;
import aiit;
import aijj;
import aijp;
import aijw;
import amhd;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import anmw;
import aqbt;
import aqqf;
import aqqg;
import arno;
import arnz;
import aroo;
import ayxj;
import bltx;
import blty;
import bltz;
import blua;
import blub;
import bluc;
import blud;
import blue;
import bluf;
import blvu;
import bmjq;
import com.tencent.biz.qqcircle.beans.QCircleFakeFeed;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCircleSelectTabEvent;
import com.tencent.biz.qqcircle.report.QCircleTaskReportInfo;
import com.tencent.biz.qqcircle.requests.QCircleDoFollowRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedDetailRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetRecommendTagRequest;
import com.tencent.biz.qqcircle.requests.QCirclePublishFeedRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.event.PublishBoxStatusEvent;
import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import com.tencent.biz.subscribe.event.SubscribePublishFeedsEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.mini.entry.MiniAppPrePullManager;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.event.ExoticEvent;
import cooperation.qzone.event.ExoticEventPool;
import cooperation.qzone.feed.CertifiedFakeFeed;
import cooperation.qzone.model.QCirclePublishPictureTagInfo;
import eipc.EIPCResult;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StExifInfo;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StGPSV2;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudTagcategorysvr.PicRecomEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import lkw;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tzo;
import uxc;
import vrb;
import vrf;
import vrh;
import vri;
import zwp;

public class QzoneIPCModule
  extends QIPCModule
{
  private static QzoneIPCModule jdField_a_of_type_CooperationQzoneQzoneIPCModule;
  private final AtomicReference<bluf> jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = new AtomicReference();
  
  public QzoneIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static QzoneIPCModule a()
  {
    if (jdField_a_of_type_CooperationQzoneQzoneIPCModule == null) {}
    try
    {
      if (jdField_a_of_type_CooperationQzoneQzoneIPCModule == null) {
        jdField_a_of_type_CooperationQzoneQzoneIPCModule = new QzoneIPCModule("QzoneIPCModule");
      }
      return jdField_a_of_type_CooperationQzoneQzoneIPCModule;
    }
    finally {}
  }
  
  private static List<aijj> a(String paramString1, String paramString2, int paramInt)
  {
    LinkedList localLinkedList = new LinkedList();
    JSONArray localJSONArray;
    int i;
    try
    {
      paramString1 = new JSONObject(paramString1);
      if (paramString1 == null) {
        return localLinkedList;
      }
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        QLog.w("QzoneIPCModule", 2, "parseJson2Sticker: failed to parse json", paramString1);
        paramString1 = null;
      }
      localJSONArray = paramString1.optJSONArray("data");
      if ((localJSONArray == null) || (localJSONArray.length() == 0))
      {
        paramString2 = new StringBuilder().append("parseJson2Sticker: empty data ");
        if (localJSONArray == null) {}
        for (paramString1 = "null";; paramString1 = "0")
        {
          QLog.i("QzoneIPCModule", 2, paramString1);
          return localLinkedList;
        }
      }
      i = 0;
    }
    for (;;)
    {
      if ((i >= localJSONArray.length()) || (i > paramInt)) {
        return localLinkedList;
      }
      paramString1 = localJSONArray.optJSONObject(i);
      String str = paramString1.optString("url");
      paramString1 = paramString1.optString("md5");
      aijj localaijj = new aijj();
      localaijj.b(str);
      localaijj.d(paramString1);
      paramString1 = paramString2;
      if (paramString2 != null)
      {
        paramString1 = paramString2;
        if (paramString2.equals(str))
        {
          localaijj.b(true);
          paramString1 = null;
        }
      }
      localLinkedList.add(localaijj);
      i += 1;
      paramString2 = paramString1;
    }
  }
  
  public static JSONObject a(List<aiit> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      localObject1 = new StringBuilder().append("parseSticker2Json: empty img list ");
      if (paramList == null) {}
      for (paramList = "null";; paramList = Integer.valueOf(paramList.size()))
      {
        QLog.i("QzoneIPCModule", 2, paramList);
        return null;
      }
    }
    Object localObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (aiit)paramList.next();
      if ((localObject2 != null) && ((localObject2 instanceof aijj)))
      {
        localObject2 = (aijj)localObject2;
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("url", ((aijj)localObject2).a()).put("thumbUrl", ((aijj)localObject2).b()).put("md5", ((aijj)localObject2).c());
          localJSONArray.put(localJSONObject);
        }
        catch (JSONException localJSONException)
        {
          QLog.w("QzoneIPCModule", 2, "parseSticker2Json: failed to create data json", localJSONException);
        }
      }
    }
    try
    {
      ((JSONObject)localObject1).put("data", localJSONArray);
      return localObject1;
    }
    catch (JSONException paramList)
    {
      QLog.w("QzoneIPCModule", 2, "parseSticker2Json: failed to put data json", paramList);
    }
    return null;
  }
  
  private void a(Bundle paramBundle, QQAppInterface paramQQAppInterface)
  {
    Object localObject = paramBundle.getStringArrayList("uins");
    if ((localObject == null) || (((ArrayList)localObject).size() == 0)) {}
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
      } while ((paramQQAppInterface == null) || (!(paramQQAppInterface instanceof QQAppInterface)));
      paramBundle = (amhd)paramQQAppInterface.getManager(153);
      paramQQAppInterface = (VasExtensionHandler)paramQQAppInterface.a(71);
      localArrayList = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        ApolloBaseInfo localApolloBaseInfo = paramBundle.b(str);
        if ((localApolloBaseInfo == null) || (localApolloBaseInfo.apolloLocalTS != localApolloBaseInfo.apolloServerTS)) {
          localArrayList.add(str);
        }
      }
    } while (localArrayList.isEmpty());
    QLog.i("QzoneIPCModule", 1, "CmShow preloadCmData but ApolloBaseInfo need update size:" + localArrayList.size());
    paramBundle = new String[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      paramBundle[i] = ((String)localArrayList.get(i));
      i += 1;
    }
    paramQQAppInterface.a(paramBundle);
  }
  
  private void a(blue paramblue)
  {
    QLog.d("[QzoneIPCModule_upload2]QCircle", 1, "processPublishData... notify qzone");
    Bundle localBundle = new Bundle();
    localBundle.putLong("key_return_code", paramblue.jdField_a_of_type_Long);
    localBundle.putString("key_error_msg", paramblue.jdField_a_of_type_JavaLangString);
    localBundle.putString("key_stfeed_id", paramblue.b);
    localBundle.putString("key_trace_id", paramblue.d);
    localBundle.putString("key_clientkey", paramblue.c);
    callbackResult(paramblue.jdField_a_of_type_Int, EIPCResult.createResult(0, localBundle));
  }
  
  private void a(QCircleFakeFeed paramQCircleFakeFeed, int paramInt, blue paramblue)
  {
    VSNetworkHelper.a().a(new QCircleGetFeedDetailRequest(paramQCircleFakeFeed.a(), BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramQCircleFakeFeed.a(), true), new blub(this, paramQCircleFakeFeed, paramblue, paramInt));
  }
  
  private void a(ArrayList<QCircleTaskReportInfo> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      QCircleTaskReportInfo localQCircleTaskReportInfo = (QCircleTaskReportInfo)paramArrayList.next();
      StringBuilder localStringBuilder = new StringBuilder();
      if ((localQCircleTaskReportInfo != null) && (localQCircleTaskReportInfo.is_video == 0))
      {
        localStringBuilder.append("album_id:").append(localQCircleTaskReportInfo.albumId).append(",");
        localStringBuilder.append("photo_id:").append(localQCircleTaskReportInfo.lloc).append(",");
        localStringBuilder.append("trace_id:").append(localQCircleTaskReportInfo.traceId).append(",");
        localStringBuilder.append("orig_pic_width:").append(localQCircleTaskReportInfo.origPicWidth).append(",");
        localStringBuilder.append("orig_pic_height:").append(localQCircleTaskReportInfo.origPicHeight).append(",");
        localStringBuilder.append("orig_pic_size:").append(localQCircleTaskReportInfo.origPicSize).append(",");
        localStringBuilder.append("edited_pic_width:").append(localQCircleTaskReportInfo.edited_pic_width).append(",");
        localStringBuilder.append("edited_pic_height:").append(localQCircleTaskReportInfo.edited_pic_height).append(",");
        localStringBuilder.append("edited_pic_size:").append(localQCircleTaskReportInfo.edited_pic_size).append(",");
        localStringBuilder.append("client_compress_pic_width:").append(localQCircleTaskReportInfo.client_compress_pic_width).append(",");
        localStringBuilder.append("client_compress_pic_height:").append(localQCircleTaskReportInfo.client_compress_pic_height).append(",");
        localStringBuilder.append("client_compress_pic_size:").append(localQCircleTaskReportInfo.client_compress_pic_size).append(",");
        localStringBuilder.append("backend_pic_width:").append(localQCircleTaskReportInfo.backendPicWidth).append(",");
        localStringBuilder.append("backend_pic_height:").append(localQCircleTaskReportInfo.backendPicHeight).append(",");
        localStringBuilder.append("hasCompress:").append(localQCircleTaskReportInfo.hasCompress);
        QLog.i("[QzoneIPCModule_upload2]QCircle", 1, "reportPicQuality pic quality:" + localStringBuilder.toString());
        vrh.a("image_publish_full_link", Arrays.asList(new FeedCloudCommon.Entry[] { vri.a("attach_info", localStringBuilder.toString()) }), false);
      }
    }
  }
  
  private void b(Bundle paramBundle, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    paramBundle.setClassLoader(QCirclePublishPictureTagInfo.class.getClassLoader());
    Object localObject1 = ((ArrayList)paramBundle.getSerializable("key_qcircle_pic_tag")).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (QCirclePublishPictureTagInfo)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        FeedCloudTagcategorysvr.PicRecomEntry localPicRecomEntry = new FeedCloudTagcategorysvr.PicRecomEntry();
        if (!TextUtils.isEmpty(((QCirclePublishPictureTagInfo)localObject2).picId)) {
          localPicRecomEntry.picId.set(((QCirclePublishPictureTagInfo)localObject2).picId);
        }
        localPicRecomEntry.recomTags.set(((QCirclePublishPictureTagInfo)localObject2).picTags);
        if (!TextUtils.isEmpty(((QCirclePublishPictureTagInfo)localObject2).materialId)) {
          localPicRecomEntry.materialId.set(((QCirclePublishPictureTagInfo)localObject2).materialId);
        }
        if (!TextUtils.isEmpty(((QCirclePublishPictureTagInfo)localObject2).filterId)) {
          localPicRecomEntry.filterId.set(((QCirclePublishPictureTagInfo)localObject2).filterId);
        }
        FeedCloudMeta.StExifInfo localStExifInfo = new FeedCloudMeta.StExifInfo();
        if ((((QCirclePublishPictureTagInfo)localObject2).exif != null) && (((QCirclePublishPictureTagInfo)localObject2).exif.size() > 0))
        {
          localObject2 = ((QCirclePublishPictureTagInfo)localObject2).exif.entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
            localStExifInfo.kvs.add(vri.a(localEntry));
            QLog.i("QzoneIPCModule", 2, "getQCircleRecommendTag  exif key:" + (String)localEntry.getKey() + " value:" + (String)localEntry.getValue());
          }
          localPicRecomEntry.exifInfo.set(localStExifInfo);
        }
        localArrayList.add(localPicRecomEntry);
      }
    }
    localObject1 = new FeedCloudMeta.StGPSV2();
    paramBundle = paramBundle.getByteArray("key_qcircle_gps_info");
    if (paramBundle != null) {}
    for (;;)
    {
      try
      {
        paramBundle = (FeedCloudMeta.StGPSV2)((FeedCloudMeta.StGPSV2)localObject1).mergeFrom(paramBundle);
        paramBundle = new QCircleGetRecommendTagRequest(paramBundle, localArrayList);
        VSNetworkHelper.a().a(paramBundle, new bltz(this, paramInt));
        return;
      }
      catch (Exception paramBundle)
      {
        paramBundle = (Bundle)localObject1;
        continue;
      }
      paramBundle = (Bundle)localObject1;
    }
  }
  
  public void a()
  {
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:qzone", "QQCirCleClientIPCModule", "cooperation.qzone.ACTION_QCIRCLE_GET_TASK_LIST", null, new bluc(this));
  }
  
  public void a(Bundle paramBundle, int paramInt)
  {
    String str;
    Object localObject1;
    Object localObject2;
    try
    {
      str = paramBundle.getString("key_clientkey");
      localObject1 = paramBundle.getByteArray("key_stfeed");
      paramBundle = (HashMap)paramBundle.getSerializable("key_common_ext");
      localObject2 = new FeedCloudMeta.StFeed();
      if (localObject1 != null)
      {
        localObject1 = (FeedCloudMeta.StFeed)((FeedCloudMeta.StFeed)localObject2).mergeFrom((byte[])localObject1);
        localObject2 = new FeedCloudCommon.StCommonExt();
        if (paramBundle != null)
        {
          paramBundle = paramBundle.entrySet().iterator();
          while (paramBundle.hasNext()) {
            ((FeedCloudCommon.StCommonExt)localObject2).mapInfo.add(vri.a((Map.Entry)paramBundle.next()));
          }
        }
      }
      else
      {
        return;
      }
    }
    catch (Exception paramBundle)
    {
      QLog.e("[QzoneIPCModule_upload2]QCircle", 1, "ACTION_QCIRCLE_PULISH_FEED error" + paramBundle);
    }
    paramBundle = new QCirclePublishFeedRequest((FeedCloudCommon.StCommonExt)localObject2, (FeedCloudMeta.StFeed)localObject1);
    QLog.d("[QzoneIPCModule_upload2]QCircle", 1, "ACTION_QCIRCLE_PULISH_FEED publishFeed id:" + ((FeedCloudMeta.StFeed)localObject1).id.get());
    VSNetworkHelper.a().a(paramBundle, new blua(this, paramBundle, str, paramInt));
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    bluf localbluf;
    do
    {
      return;
      QLog.i("QzoneIPCModule", 1, "onGetStickerRecResp: " + paramString1 + " " + paramString2);
      localbluf = (bluf)this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get();
    } while ((localbluf == null) || (!paramString1.equals(bluf.b(localbluf))) || (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.compareAndSet(localbluf, null)));
    bluf.a(localbluf, paramString2);
    bluf.b(localbluf, paramString3);
    bluf.a(localbluf).countDown();
  }
  
  public boolean a(QCircleFakeFeed paramQCircleFakeFeed, int paramInt, blue paramblue)
  {
    if (paramInt >= 3)
    {
      QLog.e("[QzoneIPCModule_upload2]QCircle", 1, "retryCount >= QCircleFakeAdapter.MAX_RETYR_COUNT");
      return false;
    }
    paramQCircleFakeFeed = new QzoneIPCModule.RetryRequestFeed(this, paramQCircleFakeFeed, paramInt + 1, paramblue);
    ThreadManager.getSubThreadHandler().postDelayed(paramQCircleFakeFeed, 2000 * paramInt);
    return true;
  }
  
  public void b()
  {
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:qzone", "PubAccountIPCModule", "cooperation.qzone.ACTION_PUBLIC_ACCOUNT_GET_TASK_LIST", null, new blud(this));
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneIPCModule", 2, "action = " + paramString + " callbackId:" + paramInt);
    }
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject1 instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneIPCModule", 2, "onRemoteInvoke cannot get QQAppInterface");
      }
      return null;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)localObject1;
    if ("getHostInfo".equals(paramString)) {
      try
      {
        paramString = ((anmw)localQQAppInterface.getManager(51)).c(localQQAppInterface.getCurrentAccountUin());
        paramBundle = new Bundle();
        paramBundle.putLong("age", paramString.age);
        paramBundle.putLong("gender", paramString.shGender);
        paramBundle.putLong("constellation", paramString.constellation);
        paramBundle.putString("country", paramString.strCountry);
        paramBundle.putString("province", paramString.strProvince);
        paramBundle.putString("city", paramString.strCity);
        paramString = EIPCResult.createResult(0, paramBundle);
        return paramString;
      }
      catch (Exception paramString)
      {
        QLog.e("QzoneIPCModule", 1, paramString, new Object[0]);
      }
    }
    for (;;)
    {
      return null;
      boolean bool1;
      if ("isFriend".equals(paramString))
      {
        long l = 0L;
        if (paramBundle != null) {}
        try
        {
          l = paramBundle.getLong("uin");
          bool1 = ((anmw)localQQAppInterface.getManager(51)).b(String.valueOf(l));
          paramString = new Bundle();
          paramString.putBoolean("isFriend", bool1);
          paramString = EIPCResult.createResult(0, paramString);
          return paramString;
        }
        catch (Exception paramString)
        {
          QLog.e("QzoneIPCModule", 1, paramString, new Object[0]);
        }
      }
      else
      {
        if ("startDownloadVoicechangeSo".equals(paramString)) {
          for (;;)
          {
            try
            {
              paramInt = lkw.f();
              if (paramInt > 2) {
                continue;
              }
            }
            catch (Exception paramString)
            {
              QLog.e("QzoneIPCModule", 1, paramString, new Object[0]);
              continue;
              AVSoUtils.b(BaseApplicationImpl.sApplication, "traeimp-armeabi-v7a", true);
              continue;
            }
            try
            {
              paramString = ((arno)localQQAppInterface.getManager(77)).a(aroo.e());
              if (paramString == null) {
                continue;
              }
              paramString.a(false);
            }
            catch (Exception paramString)
            {
              QLog.e("QzoneIPCModule", 1, "voiceChang checkVcSo Exception:" + paramString.getMessage());
              continue;
            }
            return EIPCResult.createResult(0, new Bundle());
            QLog.e("QzoneIPCModule", 1, "voiceChang checkVcSo null == earlyHandler:");
          }
        }
        if ("action_qzone_pic_pre_send".equals(paramString))
        {
          try
          {
            ayxj.a(localQQAppInterface, paramBundle);
            paramString = new Bundle();
            paramString.putBoolean("qzone_pre_send_result", true);
            paramString = EIPCResult.createResult(0, paramString);
            return paramString;
          }
          catch (Exception paramString)
          {
            QLog.e("QzoneIPCModule", 1, "action QzonePic preSend exception: ", paramString);
          }
        }
        else
        {
          Object localObject2;
          if ("action_qzone_get_sticker_rec_gif".equals(paramString))
          {
            localObject1 = null;
            paramString = null;
            if (paramBundle != null)
            {
              localObject1 = paramBundle.getString("analyze_text");
              paramString = paramBundle.getString("toUin");
            }
            if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(paramString)))
            {
              QLog.w("QzoneIPCModule", 1, "empty text or unit " + (String)localObject1 + " , " + paramString);
              return null;
            }
            localObject2 = aijp.a(localQQAppInterface);
            ((aijp)localObject2).a();
            if (!((aijp)localObject2).b())
            {
              QLog.i("QzoneIPCModule", 1, "emo rec is not open");
              return null;
            }
            paramBundle = new bluf((String)localObject1, null);
            this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.set(paramBundle);
            if (!((aijp)localObject2).a((String)localObject1, 0, paramString))
            {
              this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.compareAndSet(paramBundle, null);
              return null;
            }
            try
            {
              bluf.a(paramBundle).await(2L, TimeUnit.SECONDS);
              if (TextUtils.isEmpty(bluf.a(paramBundle)))
              {
                QLog.i("QzoneIPCModule", 1, "empty sticker rec resp list");
                return EIPCResult.createResult(-102, null);
              }
            }
            catch (InterruptedException paramString)
            {
              for (;;)
              {
                QLog.w("QzoneIPCModule", 1, "waiting req interrupted ", paramString);
              }
              paramString = new Bundle();
              paramString.putString("analyze_text", bluf.b(paramBundle));
              paramString.putString("resp_data", bluf.a(paramBundle));
              paramString.putString("resp_pass", bluf.c(paramBundle));
              return EIPCResult.createSuccessResult(paramString);
            }
          }
          Object localObject3;
          if ("action_qzone_report_sticker_gif".equals(paramString))
          {
            paramString = null;
            String str = null;
            localObject3 = null;
            localObject2 = null;
            localObject1 = null;
            paramInt = 0;
            if (paramBundle != null)
            {
              str = paramBundle.getString("rpt_data");
              localObject3 = paramBundle.getString("rpt_click");
              paramString = paramBundle.getString("toUin");
              localObject2 = paramBundle.getString("rpt_pass");
              localObject1 = paramBundle.getString("analyze_text");
              paramInt = paramBundle.getInt("rpt_expose_cnt", 0);
            }
            if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (paramInt < 1)) {
              return null;
            }
            paramBundle = new aijw();
            paramBundle.jdField_a_of_type_JavaLangString = ((String)localObject1);
            paramBundle.b = ((String)localObject2);
            paramBundle.jdField_a_of_type_JavaUtilList = a(str, (String)localObject3, paramInt);
            localObject1 = aijp.a(localQQAppInterface);
            ((aijp)localObject1).a();
            ((aijp)localObject1).a(Collections.singletonList(paramBundle), true, 11000, paramString);
            return EIPCResult.createSuccessResult(null);
          }
          if ("action_save_customenotion".equals(paramString))
          {
            if (paramBundle != null)
            {
              paramString = paramBundle.getString("pic_path");
              if (!TextUtils.isEmpty(paramString))
              {
                paramInt = ahth.a(localQQAppInterface, paramString);
                paramString = new Bundle();
                paramString.putInt("resultCode", paramInt);
                return EIPCResult.createSuccessResult(paramString);
              }
            }
          }
          else if ("action_pre_pull_mini_app".equals(paramString))
          {
            if (paramBundle != null)
            {
              QLog.d("QzoneIPCModule", 4, "ACTION_PRE_PULL_MINI_APP change to qq_process by QzoneIPCModule");
              paramString = paramBundle.getString("miniapp_preload_link");
              paramInt = paramBundle.getInt("miniapp_preload_link_type");
              bool1 = paramBundle.getBoolean("miniapp_repload_with_package_and_cache_preload", false);
              MiniAppPrePullManager.getInstance().prePullAppinfoByLink(paramString, paramInt, bool1, new bltx(this));
            }
          }
          else if ("cooperation.qzone.ACTION_PUBLIC_ACCOUNT_FAKE_FEED_CREATE".equalsIgnoreCase(paramString))
          {
            QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FAKE_FEED_CREATE to qq_process by QzoneIPCModule");
            paramBundle.setClassLoader(CertifiedFakeFeed.class.getClassLoader());
            paramString = paramBundle.getParcelable("KEY_CERTIFIED_FAKE_FEED");
            if ((paramString instanceof CertifiedFakeFeed))
            {
              paramString = (CertifiedFakeFeed)paramString;
              zwp.a().a(new SubscribeFeedsEvent(paramString, 1));
            }
          }
          else if ("cooperation.qzone.ACTION_PUBLIC_ACCOUNT_FAKE_FEED_UPDATE".equalsIgnoreCase(paramString))
          {
            QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FAKE_FEED_UPDATE to qq_process by QzoneIPCModule");
            paramBundle.setClassLoader(CertifiedFakeFeed.class.getClassLoader());
            paramString = paramBundle.getParcelable("KEY_CERTIFIED_FAKE_FEED");
            if ((paramString instanceof CertifiedFakeFeed))
            {
              paramString = (CertifiedFakeFeed)paramString;
              zwp.a().a(new SubscribeFeedsEvent(paramString, 2));
            }
          }
          else if ("cooperation.qzone.ACTION_PUBLIC_ACCOUNT_FAKE_FEED_DELETE".equalsIgnoreCase(paramString))
          {
            QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FAKE_FEED_DELETE to qq_process by QzoneIPCModule");
            paramBundle.setClassLoader(CertifiedFakeFeed.class.getClassLoader());
            paramString = paramBundle.getParcelable("KEY_CERTIFIED_FAKE_FEED");
            if ((paramString instanceof CertifiedFakeFeed))
            {
              paramString = (CertifiedFakeFeed)paramString;
              zwp.a().a(new SubscribeFeedsEvent(paramString, 3));
            }
          }
          else if ("cooperation.qzone.ACTION_PUBLIC_ACCOUNT_QUEUE_CHANGED".equalsIgnoreCase(paramString))
          {
            QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_QUEUE_CHANGED to qq_process by QzoneIPCModule");
            zwp.a().a(new PublishBoxStatusEvent(paramBundle));
            zwp.a().a(new SubscribeFeedsEvent(4));
          }
          else if ("action_qzone_get_themeid".equalsIgnoreCase(paramString))
          {
            try
            {
              paramString = new Bundle();
              paramString.putString("themeId", ThemeUtil.getCurrentThemeId());
              paramString = EIPCResult.createResult(0, paramString);
              return paramString;
            }
            catch (Exception paramString)
            {
              QLog.e("QzoneIPCModule", 1, "action getThemeId exception: ", paramString);
            }
          }
          else if ("cooperation.qzone.ACTION_PUBLIC_ACCOUNT_UNFOLLOW".equalsIgnoreCase(paramString))
          {
            if (paramBundle != null)
            {
              paramString = paramBundle.getString("uin", null);
              if (paramString != null)
              {
                tzo.a(localQQAppInterface, localQQAppInterface.getApp().getApplicationContext(), paramString, false, null, true);
                bmjq.a(localQQAppInterface.getApp().getApplicationContext(), paramString, 0);
              }
            }
          }
          else if ("action_qzone_main_process_prop_set".equalsIgnoreCase(paramString))
          {
            if (paramBundle != null)
            {
              paramString = paramBundle.getString("key", null);
              if (paramString != null)
              {
                bool1 = paramBundle.getBoolean("value");
                localQQAppInterface.getApp().getSharedPreferences("QZ_main_setting", 0).edit().putBoolean(paramString, bool1).apply();
                return EIPCResult.createSuccessResult(null);
              }
            }
          }
          else if ("action_qzone_main_process_prop_get".equalsIgnoreCase(paramString))
          {
            if (paramBundle != null)
            {
              paramString = paramBundle.getString("key", null);
              if (paramString != null)
              {
                bool1 = localQQAppInterface.getApp().getSharedPreferences("QZ_main_setting", 0).getBoolean(paramString, false);
                paramString = new Bundle();
                paramString.putBoolean("value", bool1);
                return EIPCResult.createSuccessResult(paramString);
              }
            }
          }
          else
          {
            if ("action_qzone_send_event".equalsIgnoreCase(paramString))
            {
              if (blvu.d()) {
                return EIPCResult.createResult(-1, null);
              }
              if (paramBundle != null)
              {
                paramBundle.setClassLoader(ExoticEvent.getLoader());
                paramString = (ExoticEvent)paramBundle.getParcelable("event");
                if (paramString != null)
                {
                  bool1 = ExoticEventPool.getInstance().onEventReceived(paramString);
                  paramString = new Bundle();
                  paramString.putBoolean("re", bool1);
                  return EIPCResult.createSuccessResult(paramString);
                }
              }
              return EIPCResult.createResult(-1, null);
            }
            if ("cooperation.qzone.ACTION_PUBLIC_ACCOUNT_FEED_PUBLISH".equalsIgnoreCase(paramString))
            {
              QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FEED_PUBLISH to qq_process by QzoneIPCModule");
              try
              {
                paramString = paramBundle.getByteArray("bundle_key_feed_byte_array");
                paramBundle = new CertifiedAccountMeta.StFeed();
                if (paramString == null) {
                  continue;
                }
                paramString = (CertifiedAccountMeta.StFeed)paramBundle.mergeFrom(paramString);
                QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FEED_PUBLISH publishFeed" + paramString.id.get());
                zwp.a().a(new SubscribePublishFeedsEvent(paramString, 1));
              }
              catch (Exception paramString)
              {
                paramString.printStackTrace();
                QLog.e("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FEED_PUBLISH error" + paramString);
              }
            }
            else
            {
              if ("action_qzone_show_push_setting_banner".equalsIgnoreCase(paramString))
              {
                paramString = new Bundle();
                paramBundle = aqbt.a(localQQAppInterface);
                if (paramBundle == null)
                {
                  QLog.d("QzoneIPCModule", 1, "ACTION_SHOW_PUSH_SETTING_BANNER null mgr");
                  return EIPCResult.createResult(-102, null);
                }
                bool1 = paramBundle.b();
                paramString.putBoolean("visible", bool1);
                if (bool1)
                {
                  localObject1 = aqqg.a();
                  if (localObject1 == null) {
                    break label1876;
                  }
                  paramBundle = ((aqqf)localObject1).a();
                  localObject1 = ((aqqf)localObject1).b();
                  paramString.putString("msg", paramBundle);
                  paramString.putString("setting", (String)localObject1);
                }
                for (;;)
                {
                  return EIPCResult.createSuccessResult(paramString);
                  label1876:
                  QLog.d("QzoneIPCModule", 1, "ACTION_SHOW_PUSH_SETTING_BANNER null conf bean");
                }
              }
              if ("action_qzone_close_push_setting_banner".equalsIgnoreCase(paramString))
              {
                paramString = aqbt.a(localQQAppInterface);
                if (paramString == null)
                {
                  QLog.d("QzoneIPCModule", 1, "ACTION_CLOSE_PUSH_SETTING_BANNER null mgr");
                  return EIPCResult.createResult(-102, null);
                }
                paramString.a();
                return EIPCResult.createSuccessResult(null);
              }
              if ("cooperation.qzone.ACTION_QCIRCLE_PULISH_FEED".equalsIgnoreCase(paramString))
              {
                QLog.d("[QzoneIPCModule_upload2]QCircle", 4, "ACTION_QCIRCLE_PULISH_FEED to qq_process by QzoneIPCModule");
                a(paramBundle, paramInt);
              }
              else
              {
                if ("cooperation.qzone.ACTION_QCIRCLE_PUBLISH_COMPLETE_REPORT".equalsIgnoreCase(paramString))
                {
                  QLog.d("[QzoneIPCModule_upload2]QCircle", 4, "ACTION_QCIRCLE_PUBLISH_COMPLETE_REPORT to qq_process by QzoneIPCModule");
                  paramString = (ArrayList)paramBundle.getSerializable("key_report_info");
                  if (paramString != null) {}
                  for (paramInt = paramString.size();; paramInt = 0)
                  {
                    QLog.d("[QzoneIPCModule_upload2]QCircle", 4, new Object[] { "ACTION_QCIRCLE_PUBLISH_COMPLETE_REPORT size:", Integer.valueOf(paramInt) });
                    vrb.a(paramString);
                    a(paramString);
                    break;
                  }
                }
                if ("cooperation.qzone.ACTION_QQCIRCLE_FAKE_FEED_CREATE".equalsIgnoreCase(paramString))
                {
                  QLog.d("[QzoneIPCModule_upload2]QCircle", 4, "ACTION_QQCIRCLE_FAKE_FEED_CREATE to qq_process by QzoneIPCModule");
                  paramBundle.setClassLoader(QCircleFakeFeed.class.getClassLoader());
                  paramString = paramBundle.getParcelable("KEY_Q_CIRCLE_FAKE_FEED");
                  if ((paramString instanceof QCircleFakeFeed))
                  {
                    paramString = (QCircleFakeFeed)paramString;
                    zwp.a().a(new QCircleFeedEvent(paramString, 1));
                    zwp.a().a(new QCircleSelectTabEvent(1).needScrollTop());
                  }
                  else
                  {
                    QLog.e("[QzoneIPCModule_upload2]QCircle", 1, "ACTION_QQCIRCLE_FAKE_FEED_CREATE fakeFeed == null");
                  }
                }
                else if ("cooperation.qzone.ACTION_QCIRCLE_QUEUE_CHANGED".equalsIgnoreCase(paramString))
                {
                  QLog.d("[QzoneIPCModule_upload2]QCircle", 4, "ACTION_QCIRCLE_QUEUE_CHANGED to qq_process by QzoneIPCModule");
                  a();
                }
                else if ("cooperation.qzone.ACTION_QCIRCLE_FAKE_FEED_DELETE".equalsIgnoreCase(paramString))
                {
                  QLog.d("[QzoneIPCModule_upload2]QCircle", 4, "ACTION_QCIRCLE_FAKE_FEED_DELETE to qq_process by QzoneIPCModule");
                  paramBundle.setClassLoader(QCircleFakeFeed.class.getClassLoader());
                  paramString = paramBundle.getParcelable("KEY_Q_CIRCLE_FAKE_FEED");
                  if ((paramString instanceof QCircleFakeFeed))
                  {
                    paramString = (QCircleFakeFeed)paramString;
                    zwp.a().a(new QCircleFeedEvent(paramString, 3));
                  }
                }
                else if ("cooperation.qzone.ACTION_QCIRCLE_PUBLISH_FAKE_FEED_COMPOSITE_SUCCESS".equals(paramString))
                {
                  QLog.d("[QzoneIPCModule_upload2]QCircle", 4, "ACTION_QCIRCLE_PUBLISH_FAKE_FEED_COMPOSITE_STATUS to qq_process by QzoneIPCModule");
                  paramBundle.setClassLoader(QCircleFakeFeed.class.getClassLoader());
                  paramString = paramBundle.getParcelable("KEY_Q_CIRCLE_FAKE_FEED");
                  if ((paramString instanceof QCircleFakeFeed))
                  {
                    paramString = (QCircleFakeFeed)paramString;
                    zwp.a().a(new QCircleFeedEvent(paramString.a(), 5));
                  }
                }
                else
                {
                  if ("action_qzone_follow_qq_circle".equalsIgnoreCase(paramString))
                  {
                    paramString = new Bundle();
                    if (paramBundle == null)
                    {
                      QLog.w("QzoneIPCModule", 1, "flow qq circle no param");
                      paramString.putInt("code", -1);
                      return EIPCResult.createResult(-102, paramString);
                    }
                    localObject1 = paramBundle.getString("circle_uin");
                    if (TextUtils.isEmpty((CharSequence)localObject1)) {
                      QLog.w("QzoneIPCModule", 1, "flow qq circle no uin");
                    }
                    bool1 = paramBundle.getBoolean("circle_follow");
                    paramBundle = new FeedCloudMeta.StUser();
                    paramBundle.id.set((String)localObject1);
                    localObject2 = new CountDownLatch(1);
                    localObject1 = new boolean[1];
                    localObject1[0] = 0;
                    localObject3 = VSNetworkHelper.a();
                    if (bool1) {}
                    for (paramInt = 1;; paramInt = 0)
                    {
                      ((VSNetworkHelper)localObject3).a(new QCircleDoFollowRequest(paramBundle, paramInt, null), new blty(this, (boolean[])localObject1, (CountDownLatch)localObject2));
                      bool1 = false;
                      try
                      {
                        boolean bool2 = ((CountDownLatch)localObject2).await(10L, TimeUnit.SECONDS);
                        bool1 = bool2;
                      }
                      catch (InterruptedException paramBundle)
                      {
                        for (;;)
                        {
                          QLog.w("QzoneIPCModule", 1, "flow qq circle is interrupted", paramBundle);
                        }
                        if (!bool1) {
                          break label2546;
                        }
                        QLog.d("QzoneIPCModule", 1, "flow qq circle failed");
                        paramString.putInt("code", -2);
                        return EIPCResult.createResult(-102, paramString);
                        QLog.d("QzoneIPCModule", 1, "flow qq circle over time");
                        paramString.putInt("code", -3);
                        return EIPCResult.createResult(-102, paramString);
                      }
                      if (localObject1[0] == 0) {
                        break;
                      }
                      QLog.d("QzoneIPCModule", 1, "flow qq circle ok");
                      return EIPCResult.createSuccessResult(null);
                    }
                  }
                  label2546:
                  if ("cooperation.qzone.ACTION_QCIRCLE_PUBLISH_GET_RECOMMEND_TAG".equalsIgnoreCase(paramString))
                  {
                    if (QLog.isDevelopLevel()) {
                      QLog.d("[QzoneIPCModule_upload2]QCircle", 4, "ACTION_QCIRCLE_PUBLISH_GET_RECOMMEND_TAG to qq_process by QzoneIPCModule");
                    }
                    b(paramBundle, paramInt);
                  }
                  else if ("action_qzone_preload_cm_data".equalsIgnoreCase(paramString))
                  {
                    a(paramBundle, localQQAppInterface);
                  }
                  else if ("cooperation.qzone.ACTION_QCIRCLE_PUBLISH_GET_BUSI_INFO".equalsIgnoreCase(paramString))
                  {
                    uxc.c();
                  }
                  else if (("cooperation.qzone.ACTION_QCIRCLE_PUBLISH_REPORT".equalsIgnoreCase(paramString)) && (paramBundle != null))
                  {
                    paramInt = paramBundle.getInt("key_qcircle_report_action_type");
                    int i = paramBundle.getInt("key_qcircle_report_sub_action_type");
                    int j = paramBundle.getInt("key_qcircle_report_thr_action_type");
                    paramString = paramBundle.getString("key_qcircle_report_ext1");
                    paramBundle = paramBundle.getString("key_qcircle_report_ext6");
                    vrf.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramInt, i, j, paramString, "", paramBundle, "", "", vri.a().a());
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzoneIPCModule
 * JD-Core Version:    0.7.0.1
 */