package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager;
import com.tencent.mobileqq.kandian.base.video.player.videourl.VideoUrlInfo;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.gifvideo.utils.IStrategy;
import com.tencent.mobileqq.kandian.biz.gifvideo.utils.IStrategy.URLCallback;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyEngineModule;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyRefreshOptimizeUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.IPUtils;
import com.tencent.mqpsdk.util.NetUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0xda2.content_vidurl_svr.GetVid2UrlsReq;
import tencent.im.oidb.cmd0xda2.content_vidurl_svr.GetVid2UrlsRsp;
import tencent.im.oidb.cmd0xda2.content_vidurl_svr.UrlInfo;
import tencent.im.oidb.cmd0xda2.oidb_cmd0xda2.ReqBody;
import tencent.im.oidb.cmd0xda2.oidb_cmd0xda2.RspBody;

public class KandianShortContentGifStrategy
  extends ReadInJoyEngineModule
  implements IStrategy
{
  private static KandianShortContentGifStrategy b = new KandianShortContentGifStrategy();
  private final String a = "gifvideo.KandianShortContentGifStrategy";
  private AtomicInteger c = new AtomicInteger(0);
  private ConcurrentHashMap<Integer, Object> d = new ConcurrentHashMap();
  
  public KandianShortContentGifStrategy()
  {
    super(null, null, null, ReadInJoyMSFService.getInstance(), null);
  }
  
  public static KandianShortContentGifStrategy a()
  {
    return b;
  }
  
  private Object a(Integer paramInteger)
  {
    return this.d.remove(paramInteger);
  }
  
  private void a(Integer paramInteger, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    this.d.put(paramInteger, paramObject);
  }
  
  public void a(String paramString, IStrategy.URLCallback paramURLCallback)
  {
    a(new String[] { paramString }, paramURLCallback);
  }
  
  public void a(String[] paramArrayOfString, IStrategy.URLCallback paramURLCallback)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      Object localObject2 = new content_vidurl_svr.GetVid2UrlsReq();
      Object localObject1 = DeviceInfoUtil.e();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((content_vidurl_svr.GetVid2UrlsReq)localObject2).app_version.set((String)localObject1);
      }
      ((content_vidurl_svr.GetVid2UrlsReq)localObject2).appid.set("143193");
      Object localObject3 = ((content_vidurl_svr.GetVid2UrlsReq)localObject2).app_name;
      localObject1 = "";
      ((PBStringField)localObject3).set("");
      localObject3 = IPUtils.a(BaseApplicationImpl.getContext());
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        ((content_vidurl_svr.GetVid2UrlsReq)localObject2).client_ip.set((String)localObject3);
      }
      localObject3 = ReadInJoyUtils.c();
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        ((content_vidurl_svr.GetVid2UrlsReq)localObject2).imei.set((String)localObject3);
      }
      ((content_vidurl_svr.GetVid2UrlsReq)localObject2).net_type.set(NetUtil.a(null));
      ((content_vidurl_svr.GetVid2UrlsReq)localObject2).system.set(1);
      localObject3 = ((content_vidurl_svr.GetVid2UrlsReq)localObject2).timestamp;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(System.currentTimeMillis() / 1000L);
      localStringBuilder.append("");
      ((PBStringField)localObject3).set(localStringBuilder.toString());
      if (ReadInJoyUtils.b() != null) {
        localObject1 = ReadInJoyUtils.b().getAccount();
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((content_vidurl_svr.GetVid2UrlsReq)localObject2).uid.set((String)localObject1);
      }
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        localObject1 = paramArrayOfString[i];
        ((content_vidurl_svr.GetVid2UrlsReq)localObject2).vids.add(localObject1);
        i += 1;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(((content_vidurl_svr.GetVid2UrlsReq)localObject2).appid.get());
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(((content_vidurl_svr.GetVid2UrlsReq)localObject2).timestamp.get());
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(((content_vidurl_svr.GetVid2UrlsReq)localObject2).uid.get());
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(((content_vidurl_svr.GetVid2UrlsReq)localObject2).system.get());
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(((content_vidurl_svr.GetVid2UrlsReq)localObject2).app_name.get());
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(((content_vidurl_svr.GetVid2UrlsReq)localObject2).app_version.get());
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append("MTQzMTkzYWRhZmdkaGg=");
      localObject1 = MD5.toMD5(((StringBuilder)localObject1).toString());
      ((content_vidurl_svr.GetVid2UrlsReq)localObject2).sign.set((String)localObject1);
      localObject1 = new oidb_cmd0xda2.ReqBody();
      ((oidb_cmd0xda2.ReqBody)localObject1).msg_get_vid_to_url_req.set((MessageMicro)localObject2);
      ((oidb_cmd0xda2.ReqBody)localObject1).uint32_req_type.set(1);
      localObject1 = ReadInJoyOidbHelper.a("OidbSvc.0xda2", 3490, 0, ((oidb_cmd0xda2.ReqBody)localObject1).toByteArray());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("request vids ");
      ((StringBuilder)localObject2).append(paramArrayOfString);
      QLog.d("gifvideo.KandianShortContentGifStrategy", 2, ((StringBuilder)localObject2).toString());
      i = this.c.incrementAndGet();
      ((ToServiceMsg)localObject1).addAttribute("vidToUrlSeq", Integer.valueOf(i));
      a(Integer.valueOf(i), paramURLCallback);
      sendPbReq((ToServiceMsg)localObject1);
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = new oidb_cmd0xda2.RspBody();
    Object localObject2 = (Boolean)paramToServiceMsg.getAttribute("compressFlag");
    boolean bool;
    if (localObject2 != null) {
      bool = ((Boolean)localObject2).booleanValue();
    } else {
      bool = false;
    }
    QLog.d("gifvideo.KandianShortContentGifStrategy", 1, new Object[] { "convertVidToUrl resp result code ", Integer.valueOf(ReadInJoyRefreshOptimizeUtil.a(paramToServiceMsg, paramFromServiceMsg, paramObject, (MessageMicro)localObject1, bool)) });
    if ((((oidb_cmd0xda2.RspBody)localObject1).msg_get_vid_to_url_rsp != null) && (((oidb_cmd0xda2.RspBody)localObject1).msg_get_vid_to_url_rsp.ret_code.has()))
    {
      int i = ((oidb_cmd0xda2.RspBody)localObject1).msg_get_vid_to_url_rsp.ret_code.get();
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("ret code is ");
      paramFromServiceMsg.append(i);
      QLog.d("gifvideo.KandianShortContentGifStrategy", 1, paramFromServiceMsg.toString());
    }
    else
    {
      QLog.d("gifvideo.KandianShortContentGifStrategy", 1, "no ret code");
    }
    if ((((oidb_cmd0xda2.RspBody)localObject1).msg_get_vid_to_url_rsp != null) && (((oidb_cmd0xda2.RspBody)localObject1).msg_get_vid_to_url_rsp.ret_msg.has()))
    {
      paramFromServiceMsg = ((oidb_cmd0xda2.RspBody)localObject1).msg_get_vid_to_url_rsp.ret_msg.get();
      paramObject = new StringBuilder();
      paramObject.append("ret msg is ");
      paramObject.append(paramFromServiceMsg);
      QLog.d("gifvideo.KandianShortContentGifStrategy", 1, paramObject.toString());
    }
    else
    {
      QLog.d("gifvideo.KandianShortContentGifStrategy", 1, "no ret msg");
    }
    if ((((oidb_cmd0xda2.RspBody)localObject1).msg_get_vid_to_url_rsp != null) && (((oidb_cmd0xda2.RspBody)localObject1).msg_get_vid_to_url_rsp.urls.has()))
    {
      localObject1 = (ArrayList)((oidb_cmd0xda2.RspBody)localObject1).msg_get_vid_to_url_rsp.urls.get();
      paramObject = new StringBuilder();
      paramObject.append("urls result: ");
      if (localObject1 != null) {
        paramFromServiceMsg = ((ArrayList)localObject1).toString();
      } else {
        paramFromServiceMsg = "null";
      }
      paramObject.append(paramFromServiceMsg);
      QLog.d("gifvideo.KandianShortContentGifStrategy", 1, paramObject.toString());
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        paramFromServiceMsg = new ArrayList();
        paramObject = new ArrayList();
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (content_vidurl_svr.UrlInfo)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            paramFromServiceMsg.add(((content_vidurl_svr.UrlInfo)localObject2).url.get());
            paramObject.add(((content_vidurl_svr.UrlInfo)localObject2).vid.get());
            Object localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("update vid: ");
            ((StringBuilder)localObject3).append(((content_vidurl_svr.UrlInfo)localObject2).vid.get());
            ((StringBuilder)localObject3).append(" url: ");
            ((StringBuilder)localObject3).append(((content_vidurl_svr.UrlInfo)localObject2).url.get());
            QLog.d("gifvideo.KandianShortContentGifStrategy", 2, ((StringBuilder)localObject3).toString());
            localObject3 = new VideoUrlInfo();
            ((VideoUrlInfo)localObject3).b = ((content_vidurl_svr.UrlInfo)localObject2).vid.get();
            ((VideoUrlInfo)localObject3).a = ((content_vidurl_svr.UrlInfo)localObject2).url.get();
            ThirdVideoManager.a((VideoUrlInfo)localObject3);
          }
        }
        paramToServiceMsg = (IStrategy.URLCallback)a(Integer.valueOf(((Integer)paramToServiceMsg.getAttribute("vidToUrlSeq")).intValue()));
        if (paramToServiceMsg != null)
        {
          QLog.d("gifvideo.KandianShortContentGifStrategy", 2, "has callback");
          paramToServiceMsg.a((String[])paramObject.toArray(new String[paramObject.size()]), (String[])paramFromServiceMsg.toArray(new String[paramFromServiceMsg.size()]), null);
          return;
        }
        QLog.d("gifvideo.KandianShortContentGifStrategy", 2, " call back is null");
      }
    }
    else
    {
      QLog.d("gifvideo.KandianShortContentGifStrategy", 1, "no urls");
    }
  }
  
  public void unInitialize()
  {
    this.d.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianShortContentGifStrategy
 * JD-Core Version:    0.7.0.1
 */