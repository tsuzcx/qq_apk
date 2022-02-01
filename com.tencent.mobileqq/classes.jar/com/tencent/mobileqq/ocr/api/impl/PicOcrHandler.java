package com.tencent.mobileqq.ocr.api.impl;

import android.graphics.Point;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.gallery.picocr.PicOcrObserver;
import com.tencent.mobileqq.gallery.picocr.PicOcrResultBean;
import com.tencent.mobileqq.gallery.picocr.PicOcrRspResult;
import com.tencent.mobileqq.ocr.api.IPicOcrService;
import com.tencent.mobileqq.ocr.req.OCRReqContext;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
import tencent.im.cs.cmd0xe07.cmd0xe07.Coordinate;
import tencent.im.cs.cmd0xe07.cmd0xe07.Language;
import tencent.im.cs.cmd0xe07.cmd0xe07.OCRReqBody;
import tencent.im.cs.cmd0xe07.cmd0xe07.OCRRspBody;
import tencent.im.cs.cmd0xe07.cmd0xe07.Polygon;
import tencent.im.cs.cmd0xe07.cmd0xe07.ReqBody;
import tencent.im.cs.cmd0xe07.cmd0xe07.RspBody;
import tencent.im.cs.cmd0xe07.cmd0xe07.TextDetection;

public class PicOcrHandler
  extends BusinessHandler
{
  public static final String a = "com.tencent.mobileqq.ocr.api.impl.PicOcrHandler";
  public static String b = "OidbSvc.0xe07_0";
  private static Map c = new HashMap();
  
  static
  {
    Map localMap = c;
    Integer localInteger1 = Integer.valueOf(0);
    localMap.put(localInteger1, localInteger1);
    localMap = c;
    Integer localInteger2 = Integer.valueOf(1);
    localMap.put(localInteger2, localInteger2);
    c.put(Integer.valueOf(-1001), localInteger1);
    c.put(Integer.valueOf(-1002), localInteger2);
    c.put(Integer.valueOf(-1003), Integer.valueOf(2));
    c.put(Integer.valueOf(-1004), Integer.valueOf(3));
    c.put(Integer.valueOf(-1005), Integer.valueOf(4));
    c.put(Integer.valueOf(-1006), Integer.valueOf(5));
    c.put(Integer.valueOf(-1007), Integer.valueOf(6));
    c.put(Integer.valueOf(-1008), Integer.valueOf(7));
    c.put(Integer.valueOf(-1009), Integer.valueOf(10));
  }
  
  public PicOcrHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private static int a(int paramInt)
  {
    if (c.containsKey(Integer.valueOf(paramInt))) {
      return ((Integer)c.get(Integer.valueOf(paramInt))).intValue();
    }
    return 2;
  }
  
  public void a(OCRReqContext paramOCRReqContext)
  {
    a(paramOCRReqContext.l, paramOCRReqContext.k, paramOCRReqContext.f, paramOCRReqContext.g, paramOCRReqContext.b, (int)paramOCRReqContext.e, paramOCRReqContext.i, paramOCRReqContext.j, paramOCRReqContext.h, paramOCRReqContext.a);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject2 = Integer.valueOf(0);
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    long l = ((Long)paramToServiceMsg.getAttribute("key_ocr_seq", Long.valueOf(0L))).longValue();
    localObject1 = (String)paramToServiceMsg.getAttribute("key_ocr_md5", "");
    String str1 = (String)paramToServiceMsg.getAttribute("key_ocr_url", "");
    int i4 = ((Integer)paramToServiceMsg.getAttribute("key_ocr_size", localObject2)).intValue();
    j = i4;
    i2 = ((Integer)paramToServiceMsg.getAttribute("key_ocr_width", localObject2)).intValue();
    i = i2;
    int i1 = ((Integer)paramToServiceMsg.getAttribute("key_ocr_height", localObject2)).intValue();
    int k = i1;
    String str2 = (String)paramToServiceMsg.getAttribute("key_ocr_afmd5", "");
    ArrayList localArrayList = new ArrayList();
    localObject2 = new ArrayList();
    paramToServiceMsg = new PicOcrRspResult();
    HashMap localHashMap = new HashMap();
    Iterator localIterator2 = null;
    Iterator localIterator1 = null;
    Object localObject11 = null;
    Object localObject4 = null;
    localObject12 = null;
    int i3 = -1;
    int m;
    Object localObject6;
    Object localObject7;
    int n;
    Object localObject3;
    if (bool1)
    {
      for (;;)
      {
        try
        {
          Object localObject13 = new cmd0xe07.RspBody();
          m = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject13);
          try
          {
            localObject6 = ((cmd0xe07.RspBody)localObject13).errMsg.get();
            try
            {
              localObject7 = ((cmd0xe07.RspBody)localObject13).wording.get();
              if (m == 0) {
                bool1 = true;
              } else {
                bool1 = false;
              }
              if (bool1) {
                try
                {
                  if (((cmd0xe07.RspBody)localObject13).ocrRspBody.has())
                  {
                    localObject13 = (cmd0xe07.OCRRspBody)((cmd0xe07.RspBody)localObject13).ocrRspBody.get();
                    boolean bool2 = ((cmd0xe07.OCRRspBody)localObject13).requestId.has();
                    if (bool2) {
                      try
                      {
                        paramObject = ((cmd0xe07.OCRRspBody)localObject13).requestId.get();
                      }
                      catch (Exception paramFromServiceMsg)
                      {
                        paramObject = null;
                        i = m;
                        continue;
                      }
                    } else {
                      paramObject = "";
                    }
                    localIterator1 = localIterator2;
                    try
                    {
                      bool2 = ((cmd0xe07.OCRRspBody)localObject13).language.has();
                      if (bool2)
                      {
                        localObject4 = localObject12;
                        try
                        {
                          paramFromServiceMsg = ((cmd0xe07.OCRRspBody)localObject13).language.get();
                        }
                        catch (Exception localException7)
                        {
                          n = -1;
                          paramFromServiceMsg = (FromServiceMsg)localObject4;
                          localObject4 = localException7;
                        }
                        k = i2;
                        j = i1;
                        localObject8 = paramToServiceMsg;
                        paramToServiceMsg = (ToServiceMsg)localObject2;
                        i = m;
                        localObject2 = paramFromServiceMsg;
                        paramFromServiceMsg = (FromServiceMsg)localObject8;
                        m = i4;
                        break label1556;
                      }
                      else
                      {
                        paramFromServiceMsg = "";
                      }
                      Object localObject8 = paramFromServiceMsg;
                      bool2 = ((cmd0xe07.OCRRspBody)localObject13).ocrLanguageList.has();
                      if (bool2)
                      {
                        localObject4 = paramFromServiceMsg;
                        ((ArrayList)localObject2).addAll(((cmd0xe07.OCRRspBody)localObject13).ocrLanguageList.get());
                      }
                      localObject8 = paramFromServiceMsg;
                      bool2 = ((cmd0xe07.OCRRspBody)localObject13).afterCompressWeight.has();
                      if (bool2)
                      {
                        localObject4 = paramFromServiceMsg;
                        n = ((cmd0xe07.OCRRspBody)localObject13).afterCompressWeight.get();
                      }
                      else
                      {
                        n = -1;
                      }
                      localObject4 = paramObject;
                      try
                      {
                        bool2 = ((cmd0xe07.OCRRspBody)localObject13).afterCompressHeight.has();
                        int i5;
                        if (bool2) {
                          try
                          {
                            i5 = ((cmd0xe07.OCRRspBody)localObject13).afterCompressHeight.get();
                            i1 = i5;
                          }
                          catch (Exception localException8)
                          {
                            paramObject = localObject4;
                            localObject4 = localException8;
                          }
                        } else {
                          i1 = -1;
                        }
                        try
                        {
                          bool2 = ((cmd0xe07.OCRRspBody)localObject13).languageList.has();
                          Object localObject9 = localObject2;
                          if (bool2)
                          {
                            paramObject = localObject2;
                            try
                            {
                              localObject11 = ((cmd0xe07.OCRRspBody)localObject13).languageList.get();
                              localObject9 = localObject2;
                              if (localObject11 == null) {
                                continue;
                              }
                              paramObject = localObject2;
                              localObject11 = ((List)localObject11).iterator();
                              paramObject = localObject2;
                              localObject9 = localObject2;
                              if (!((Iterator)localObject11).hasNext()) {
                                continue;
                              }
                              paramObject = localObject2;
                              localObject9 = (cmd0xe07.Language)((Iterator)localObject11).next();
                              try
                              {
                                paramObject = ((cmd0xe07.Language)localObject9).language.get();
                                localObject9 = ((cmd0xe07.Language)localObject9).languageDesc.get();
                                if (!TextUtils.isEmpty(paramObject)) {
                                  localHashMap.put(paramObject, localObject9);
                                }
                              }
                              catch (Exception paramObject) {}
                              localObject10 = paramToServiceMsg;
                            }
                            catch (Exception localException9)
                            {
                              localObject2 = paramObject;
                              paramObject = localException9;
                            }
                            localObject11 = localObject1;
                            i2 = j;
                            j = i1;
                            paramToServiceMsg = (ToServiceMsg)localObject2;
                            localObject1 = localObject10;
                            localObject10 = localObject11;
                            i1 = i;
                            continue;
                          }
                          paramObject = localObject10;
                          localObject12 = paramToServiceMsg;
                          int i6 = k;
                          localObject11 = localObject1;
                          i4 = j;
                          i2 = i;
                          localObject10 = paramToServiceMsg;
                          int i7 = k;
                          localObject2 = localObject1;
                          i5 = j;
                          i3 = i;
                          try
                          {
                            if (((cmd0xe07.OCRRspBody)localObject13).textDetections.has())
                            {
                              localObject10 = paramToServiceMsg;
                              i7 = k;
                              localObject2 = localObject1;
                              i5 = j;
                              i3 = i;
                              localIterator2 = ((cmd0xe07.OCRRspBody)localObject13).textDetections.get().iterator();
                              localObject12 = paramToServiceMsg;
                              i6 = k;
                              localObject11 = localObject1;
                              i4 = j;
                              i2 = i;
                              localObject10 = paramToServiceMsg;
                              i7 = k;
                              localObject2 = localObject1;
                              i5 = j;
                              i3 = i;
                              if (localIterator2.hasNext())
                              {
                                localObject10 = paramToServiceMsg;
                                i7 = k;
                                localObject2 = localObject1;
                                i5 = j;
                                i3 = i;
                                localObject13 = (cmd0xe07.TextDetection)localIterator2.next();
                                localObject10 = paramToServiceMsg;
                                i7 = k;
                                localObject2 = localObject1;
                                i5 = j;
                                i3 = i;
                                localObject11 = new PicOcrResultBean();
                                localObject10 = paramToServiceMsg;
                                i7 = k;
                                localObject2 = localObject1;
                                i5 = j;
                                i3 = i;
                                localObject12 = ((cmd0xe07.TextDetection)localObject13).detectedText.get();
                                try
                                {
                                  i4 = ((cmd0xe07.TextDetection)localObject13).confidence.get();
                                  try
                                  {
                                    localObject10 = new ArrayList();
                                    i3 = j;
                                    i2 = i;
                                    try
                                    {
                                      localObject2 = ((cmd0xe07.Polygon)((cmd0xe07.TextDetection)localObject13).polygon.get()).coordinates.get().iterator();
                                      i3 = j;
                                      i2 = i;
                                      if (((Iterator)localObject2).hasNext())
                                      {
                                        i3 = j;
                                        i2 = i;
                                        localCoordinate = (cmd0xe07.Coordinate)((Iterator)localObject2).next();
                                        i2 = i;
                                      }
                                    }
                                    catch (Exception localException2)
                                    {
                                      cmd0xe07.Coordinate localCoordinate;
                                      j = i3;
                                      i = i2;
                                    }
                                  }
                                  catch (Exception localException3) {}
                                }
                                catch (Exception localException4)
                                {
                                  localObject10 = paramToServiceMsg;
                                }
                              }
                            }
                          }
                          catch (Exception paramToServiceMsg)
                          {
                            k = i7;
                            localObject1 = localObject3;
                            j = i5;
                            i = i3;
                          }
                        }
                        catch (Exception localException10)
                        {
                          paramObject = localObject3;
                          localObject10 = paramToServiceMsg;
                          paramToServiceMsg = localException10;
                        }
                      }
                      catch (Exception paramObject)
                      {
                        i2 = j;
                        i1 = i;
                        localObject10 = localObject1;
                        localObject1 = paramToServiceMsg;
                        paramToServiceMsg = (ToServiceMsg)localObject3;
                        j = i3;
                      }
                    }
                    catch (Exception paramFromServiceMsg)
                    {
                      i = m;
                    }
                  }
                }
                catch (Exception paramFromServiceMsg)
                {
                  i = m;
                  paramObject = null;
                }
              }
            }
            catch (Exception paramFromServiceMsg)
            {
              i = m;
              paramObject = null;
              localObject7 = paramObject;
            }
          }
          catch (Exception paramFromServiceMsg)
          {
            i = m;
            paramObject = null;
            localObject6 = paramObject;
            localObject7 = localObject6;
          }
        }
        catch (Exception localException6)
        {
          n = k;
          paramObject = null;
          localObject6 = paramObject;
          localObject7 = localObject6;
          i1 = -1;
          i2 = -1;
          m = j;
          k = i;
          j = n;
          paramFromServiceMsg = paramToServiceMsg;
          paramToServiceMsg = (ToServiceMsg)localObject3;
          localObject3 = localToServiceMsg;
          i = i2;
          n = i1;
        }
        try
        {
          i3 = localCoordinate.X.get();
          i5 = localCoordinate.Y.get();
        }
        catch (Exception localException5)
        {
          Object localObject5;
          localObject12 = paramObject;
          localToServiceMsg = paramToServiceMsg;
          localObject10 = localObject1;
          i = i2;
          i2 = j;
          continue;
          i2 = -1;
          continue;
        }
        try
        {
          ((ArrayList)localObject10).add(new Point(i3, i5));
          i = i2;
        }
        catch (Exception localException1)
        {
          localObject12 = paramObject;
          localObject11 = paramToServiceMsg;
          localObject10 = localObject1;
          i2 = j;
          continue;
        }
        if (!((cmd0xe07.TextDetection)localObject13).advancedInfo.has()) {
          break label2146;
        }
        localObject2 = ((cmd0xe07.TextDetection)localObject13).advancedInfo.get();
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label2146;
        }
        i2 = new JSONObject(new JSONObject((String)localObject2).optString("Parag")).optInt("ParagNo");
        ((PicOcrResultBean)localObject11).a = ((String)localObject12);
        ((PicOcrResultBean)localObject11).b = i4;
        ((PicOcrResultBean)localObject11).c = ((ArrayList)localObject10);
        ((PicOcrResultBean)localObject11).d = i2;
        ((PicOcrResultBean)localObject11).e = n;
        ((PicOcrResultBean)localObject11).f = i1;
        localArrayList.add(localObject11);
        continue;
        j = i6;
        localObject1 = localObject11;
        k = i2;
        i = m;
        paramToServiceMsg = (ToServiceMsg)localObject4;
        localObject3 = paramFromServiceMsg;
        i3 = i1;
        paramFromServiceMsg = (FromServiceMsg)localObject12;
        m = i4;
        break label1678;
        localObject3 = paramToServiceMsg;
        paramToServiceMsg = (ToServiceMsg)localObject10;
        i2 = j;
        localObject10 = localObject1;
        localToServiceMsg = paramToServiceMsg;
        localObject12 = paramObject;
        j = i1;
        paramObject = localObject3;
        paramToServiceMsg = (ToServiceMsg)localObject12;
        localObject1 = localToServiceMsg;
        i1 = i;
        i = m;
        localObject3 = localObject4;
        localObject4 = paramObject;
        paramObject = localObject3;
        localObject3 = paramFromServiceMsg;
        i3 = j;
        paramFromServiceMsg = (FromServiceMsg)localObject1;
        localObject1 = localObject10;
        j = k;
        k = i1;
        m = i2;
        break label1556;
        paramObject = localObject3;
        paramFromServiceMsg = paramToServiceMsg;
        i1 = j;
        i2 = i;
        i = m;
        paramToServiceMsg = null;
        n = -1;
        localObject3 = localObject4;
        j = k;
        k = i2;
        m = i1;
        break label1678;
        m = i4;
        k = i2;
        j = i1;
        localToServiceMsg = paramToServiceMsg;
        paramToServiceMsg = (ToServiceMsg)localObject3;
        n = -1;
        localObject4 = paramFromServiceMsg;
        localObject3 = localObject10;
        paramFromServiceMsg = localToServiceMsg;
        break label1556;
      }
      label1556:
      if (QLog.isColorLevel())
      {
        localObject10 = new StringBuilder();
        ((StringBuilder)localObject10).append("handleRequestPicOcrRsp seq:");
        ((StringBuilder)localObject10).append(l);
        ((StringBuilder)localObject10).append(", exp:");
        QLog.e("PicOcrHandler", 2, ((StringBuilder)localObject10).toString(), localException6);
      }
      i1 = i3;
      localObject5 = localObject7;
      bool1 = false;
      localObject7 = paramObject;
      paramObject = paramToServiceMsg;
    }
    else
    {
      paramObject = localObject3;
      paramFromServiceMsg = paramToServiceMsg;
      n = k;
      paramToServiceMsg = null;
      localObject6 = paramToServiceMsg;
      localObject7 = localObject6;
      i1 = -1;
      i2 = -1;
      m = j;
      k = i;
      j = n;
      localObject3 = localObject5;
      i = i2;
      n = i1;
      label1678:
      i1 = i3;
      localObject5 = localObject7;
      localObject7 = paramToServiceMsg;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleRequestPicOcrRsp seq:");
      paramToServiceMsg.append(l);
      paramToServiceMsg.append(", succ:");
      paramToServiceMsg.append(bool1);
      paramToServiceMsg.append(",result:");
      paramToServiceMsg.append(i);
      paramToServiceMsg.append(", requestId:");
      paramToServiceMsg.append((String)localObject7);
      paramToServiceMsg.append(", errMsg:");
      paramToServiceMsg.append((String)localObject6);
      paramToServiceMsg.append(", wording:");
      paramToServiceMsg.append(localObject5);
      paramToServiceMsg.append(", size:");
      paramToServiceMsg.append(localArrayList.size());
      paramToServiceMsg.append(", lag:");
      paramToServiceMsg.append((String)localObject3);
      paramToServiceMsg.append(", baseW:");
      paramToServiceMsg.append(n);
      paramToServiceMsg.append(", baseH:");
      paramToServiceMsg.append(i1);
      paramToServiceMsg.append(", mapSize:");
      paramToServiceMsg.append(localHashMap.size());
      paramToServiceMsg.append(", length:");
      paramToServiceMsg.append(m);
      paramToServiceMsg.append(", width:");
      paramToServiceMsg.append(k);
      paramToServiceMsg.append(", height");
      paramToServiceMsg.append(j);
      QLog.i("PicOcrHandler", 2, paramToServiceMsg.toString());
    }
    if (bool1)
    {
      paramToServiceMsg = paramFromServiceMsg;
      paramToServiceMsg.a = ((String)localObject1);
      paramToServiceMsg.d = ((String)localObject3);
      paramToServiceMsg.g.addAll(paramObject);
      paramToServiceMsg.b = n;
      paramToServiceMsg.c = i1;
      paramToServiceMsg.f.addAll(localArrayList);
      paramToServiceMsg.e = str1;
      paramToServiceMsg.h = localHashMap;
      paramToServiceMsg.i = m;
      paramToServiceMsg.j = k;
      paramToServiceMsg.k = j;
      paramToServiceMsg.l = str2;
      try
      {
        ((IPicOcrService)this.appRuntime.getRuntimeService(IPicOcrService.class, "")).putOcrResult((String)localObject1, paramToServiceMsg);
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("PicOcrHandler", 2, "handleRequestPicOcrRsp Exception:", paramToServiceMsg);
      }
    }
    notifyUI(100, bool1, paramFromServiceMsg);
    paramFromServiceMsg = new HashMap();
    if (bool1) {
      paramToServiceMsg = "0";
    } else {
      paramToServiceMsg = "1";
    }
    paramFromServiceMsg.put("param_result", paramToServiceMsg);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actPicOcrResult", true, 0L, 0L, paramFromServiceMsg, "");
  }
  
  public void a(String paramString1, long paramLong, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, String paramString4)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestPicOcr seq:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", url:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", orimd5:");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", afMd5:");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append(", size:");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", width:");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(", height:");
      ((StringBuilder)localObject).append(paramInt4);
      ((StringBuilder)localObject).append(", crop");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("， lang：");
      ((StringBuilder)localObject).append(paramString4);
      QLog.i("PicOcrHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new cmd0xe07.OCRReqBody();
    ((cmd0xe07.OCRReqBody)localObject).imageUrl.set(paramString1);
    if (!TextUtils.isEmpty(paramString4)) {
      ((cmd0xe07.OCRReqBody)localObject).languageType.set(paramString4);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      ((cmd0xe07.OCRReqBody)localObject).originMd5.set(paramString2);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      ((cmd0xe07.OCRReqBody)localObject).afterCompressMd5.set(paramString3);
    }
    ((cmd0xe07.OCRReqBody)localObject).afterCompressFileSize.set(paramInt2);
    ((cmd0xe07.OCRReqBody)localObject).afterCompressWeight.set(paramInt3);
    ((cmd0xe07.OCRReqBody)localObject).afterCompressHeight.set(paramInt4);
    ((cmd0xe07.OCRReqBody)localObject).isCut.set(paramBoolean);
    paramString4 = new cmd0xe07.ReqBody();
    paramString4.version.set(1);
    paramString4.client.set(0);
    paramString4.entrance.set(a(paramInt1));
    paramString4.ocrReqBody.set((MessageMicro)localObject);
    paramString4 = makeOIDBPkg(b, 3591, 0, paramString4.toByteArray());
    paramString4.getAttributes().put("key_ocr_seq", Long.valueOf(paramLong));
    paramString4.getAttributes().put("key_ocr_md5", paramString2);
    paramString4.getAttributes().put("key_ocr_url", paramString1);
    paramString4.getAttributes().put("key_ocr_size", Integer.valueOf(paramInt2));
    paramString4.getAttributes().put("key_ocr_width", Integer.valueOf(paramInt3));
    paramString4.getAttributes().put("key_ocr_height", Integer.valueOf(paramInt4));
    paramString4.getAttributes().put("key_ocr_afmd5", paramString3);
    sendPbReq(paramString4);
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add(b);
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return PicOcrObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      String str = paramFromServiceMsg.getServiceCmd();
      if (msgCmdFilter(str))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("onReceive, msgCmdFilter is true,cmd  = ");
          paramToServiceMsg.append(str);
          QLog.d("PicOcrHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if (b.equals(str)) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.api.impl.PicOcrHandler
 * JD-Core Version:    0.7.0.1
 */