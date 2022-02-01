package com.tencent.mqpsdk.secsrv;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ims.intchk.AppInfo;
import com.tencent.ims.intchk.CheckItem;
import com.tencent.ims.intchk.CheckResult;
import com.tencent.ims.intchk.FetchCheckConfigReq;
import com.tencent.ims.intchk.FetchCheckConfigRsp;
import com.tencent.ims.intchk.ReportCheckResultReq;
import com.tencent.ims.intchk.ReportCheckResultRsp;
import com.tencent.ims.intchk.ReportStrikeResultReq;
import com.tencent.ims.intchk.ReqBody;
import com.tencent.ims.intchk.RspBody;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mqp.app.sec.MQPSecUtil;
import com.tencent.mqpsdk.INetTransportProvider;
import com.tencent.mqpsdk.INetTransportProvider.INetTransportCodec;
import com.tencent.mqpsdk.INetTransportProvider.INetTransportEventListener;
import com.tencent.mqpsdk.MQPSecServiceManager;
import com.tencent.mqpsdk.util.NetUtil;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class MQPIntChkService
  implements INetTransportProvider.INetTransportEventListener, IIntChkStrikeResultListener
{
  private static int a = 1;
  private MQPSecServiceManager b = null;
  private String c = null;
  private Map<Integer, MQPIntChkService.IIntChkStrike> d = null;
  private int e = 0;
  private int f = 65535;
  private int g = 0;
  
  public MQPIntChkService(MQPSecServiceManager paramMQPSecServiceManager)
  {
    INetTransportProvider localINetTransportProvider = paramMQPSecServiceManager.b;
    if (localINetTransportProvider != null) {
      localINetTransportProvider.setNetTransportEventListener("intchk", this);
    }
    this.b = paramMQPSecServiceManager;
  }
  
  private intchk.AppInfo a()
  {
    intchk.AppInfo localAppInfo = new intchk.AppInfo();
    localAppInfo.uint32_platform_type.set(1);
    String str = this.b.a.getPackageName();
    localAppInfo.bytes_package_name.set(ByteStringMicro.copyFromUtf8(str));
    if (TextUtils.isEmpty(this.c)) {
      str = "1.0";
    } else {
      str = this.c;
    }
    localAppInfo.bytes_app_version.set(ByteStringMicro.copyFromUtf8(str));
    localAppInfo.uint32_intchk_module_version.set(a);
    int i = NetUtil.a(this.b.a);
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          break label127;
        }
        if (i == 4) {}
      }
      else
      {
        i = 5;
        break label135;
      }
      i = 7;
      break label135;
      label127:
      i = 6;
    }
    else
    {
      i = 3;
    }
    label135:
    str = NetUtil.b(this.b.a);
    int j = i;
    if (str != null)
    {
      j = i;
      if (str.contains("wap")) {
        j = 4;
      }
    }
    localAppInfo.uint32_net_type.set(j);
    return localAppInfo;
  }
  
  private void a(intchk.RspBody paramRspBody)
  {
    if (paramRspBody.uint32_result.has()) {
      i = paramRspBody.uint32_result.get();
    } else {
      i = 2;
    }
    if (i != 1) {
      return;
    }
    if (!paramRspBody.msg_check_config_rsp.has()) {
      return;
    }
    paramRspBody = (intchk.FetchCheckConfigRsp)paramRspBody.msg_check_config_rsp.get();
    if (paramRspBody.uint32_need_intchk.has()) {
      i = paramRspBody.uint32_need_intchk.get();
    } else {
      i = 2;
    }
    if (i != 1) {
      return;
    }
    if (!paramRspBody.rpt_msg_check_item.has()) {
      return;
    }
    if (paramRspBody.uint32_intchk_id.has()) {
      i = paramRspBody.uint32_intchk_id.get();
    } else {
      i = 0;
    }
    Object localObject2 = new intchk.ReportCheckResultReq();
    ((intchk.ReportCheckResultReq)localObject2).uint32_intchk_id.set(i);
    Object localObject3 = paramRspBody.rpt_msg_check_item.get();
    int i = 0;
    while (i < ((List)localObject3).size())
    {
      paramRspBody = (intchk.CheckItem)((List)localObject3).get(i);
      int j;
      if (paramRspBody.uint32_check_item_id.has()) {
        j = paramRspBody.uint32_check_item_id.get();
      } else {
        j = 0;
      }
      int k;
      if (paramRspBody.uint32_check_type.has()) {
        k = paramRspBody.uint32_check_type.get();
      } else {
        k = 1;
      }
      intchk.CheckResult localCheckResult = new intchk.CheckResult();
      localCheckResult.uint32_check_item_id.set(j);
      localCheckResult.uint32_check_type.set(k);
      if (k != 1)
      {
        if (k == 2)
        {
          localObject1 = HexUtil.bytes2HexStr(b(paramRspBody));
          paramRspBody = (intchk.RspBody)localObject1;
          if (localObject1 == null) {
            paramRspBody = "";
          }
          localCheckResult.bytes_memreport_result.set(ByteStringMicro.copyFromUtf8(paramRspBody));
        }
      }
      else
      {
        if (a(paramRspBody)) {
          j = 1;
        } else {
          j = 2;
        }
        localCheckResult.uint32_memchk_result.set(j);
      }
      ((intchk.ReportCheckResultReq)localObject2).rpt_msg_check_result.add(localCheckResult);
      i += 1;
    }
    paramRspBody = new intchk.ReqBody();
    paramRspBody.uint32_subcmd.set(2);
    paramRspBody.msg_app_info.set(a());
    paramRspBody.msg_report_check_result_req.set((MessageMicro)localObject2);
    localObject2 = this.b.b;
    if (localObject2 == null) {
      return;
    }
    Object localObject1 = paramRspBody.toByteArray();
    localObject3 = ((INetTransportProvider)localObject2).getCodec("intchk");
    paramRspBody = (intchk.RspBody)localObject1;
    if (localObject3 != null) {
      paramRspBody = ((INetTransportProvider.INetTransportCodec)localObject3).encode(localObject1);
    }
    ((INetTransportProvider)localObject2).send(paramRspBody);
  }
  
  private boolean a(intchk.CheckItem paramCheckItem)
  {
    int i;
    if (paramCheckItem.uint32_start_offset.has()) {
      i = paramCheckItem.uint32_start_offset.get();
    } else {
      i = 0;
    }
    int j;
    if (paramCheckItem.uint32_end_offset.has()) {
      j = paramCheckItem.uint32_end_offset.get();
    } else {
      j = 0;
    }
    if (j <= i) {
      return false;
    }
    boolean bool = paramCheckItem.bytes_module_name.has();
    String str2 = "";
    String str1;
    if (bool) {
      str1 = paramCheckItem.bytes_module_name.get().toStringUtf8();
    } else {
      str1 = "";
    }
    if (TextUtils.isEmpty(str1.trim())) {
      return false;
    }
    if (paramCheckItem.bytes_match_pattern.has()) {
      str2 = paramCheckItem.bytes_match_pattern.get().toStringUtf8();
    }
    if (TextUtils.isEmpty(str2.trim())) {
      return false;
    }
    try
    {
      bool = MQPSecUtil.memchk(str1, i, j, HexUtil.hexStr2Bytes(str2));
      return bool;
    }
    catch (Throwable paramCheckItem)
    {
      paramCheckItem.printStackTrace();
    }
    return false;
  }
  
  private void b(intchk.RspBody paramRspBody)
  {
    boolean bool = paramRspBody.uint32_result.has();
    int j = 2;
    if (bool) {
      i = paramRspBody.uint32_result.get();
    } else {
      i = 2;
    }
    if (i != 1) {
      return;
    }
    if (!paramRspBody.msg_report_check_result_rsp.has()) {
      return;
    }
    paramRspBody = (intchk.ReportCheckResultRsp)paramRspBody.msg_report_check_result_rsp.get();
    int i = j;
    if (paramRspBody.uint32_need_strike.has()) {
      i = paramRspBody.uint32_need_strike.get();
    }
    if (i != 1) {
      return;
    }
    if (!paramRspBody.bytes_strike_config.has()) {
      return;
    }
    if (paramRspBody.uint32_intchk_id.has()) {
      this.e = paramRspBody.uint32_intchk_id.get();
    }
    c(paramRspBody.bytes_strike_config.get().toStringUtf8());
  }
  
  private byte[] b(intchk.CheckItem paramCheckItem)
  {
    boolean bool = paramCheckItem.uint32_start_offset.has();
    int j = 0;
    int i;
    if (bool) {
      i = paramCheckItem.uint32_start_offset.get();
    } else {
      i = 0;
    }
    if (paramCheckItem.uint32_end_offset.has()) {
      j = paramCheckItem.uint32_end_offset.get();
    }
    if (j <= i) {
      return null;
    }
    if (paramCheckItem.bytes_module_name.has()) {
      paramCheckItem = paramCheckItem.bytes_module_name.get().toStringUtf8();
    } else {
      paramCheckItem = "";
    }
    if (TextUtils.isEmpty(paramCheckItem.trim())) {
      return null;
    }
    try
    {
      paramCheckItem = MQPSecUtil.memreport(paramCheckItem, i, j);
      return paramCheckItem;
    }
    catch (Throwable paramCheckItem)
    {
      paramCheckItem.printStackTrace();
    }
    return null;
  }
  
  private void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString.trim())) {
      return;
    }
    Object localObject1 = DocumentBuilderFactory.newInstance();
    for (;;)
    {
      try
      {
        Object localObject2 = ((DocumentBuilderFactory)localObject1).newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes())).getDocumentElement();
        this.f = 0;
        paramString = ((Element)localObject2).getAttribute("type");
        if (paramString.trim().length() > 0) {
          this.f = Integer.parseInt(paramString);
        }
        int i = this.f;
        localObject1 = null;
        paramString = null;
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3) {
              return;
            }
            if (this.d != null)
            {
              if (this.d.containsKey(Integer.valueOf(3))) {
                paramString = (MQPIntChkService.IIntChkStrike)this.d.get(Integer.valueOf(3));
              }
              if (paramString != null)
              {
                localObject1 = ((Element)localObject2).getElementsByTagName("package");
                if (((NodeList)localObject1).getLength() == 0) {
                  return;
                }
                localObject2 = ((Element)((NodeList)localObject1).item(0)).getAttribute("val");
                localObject1 = new JSONObject();
                try
                {
                  ((JSONObject)localObject1).put("launch_package_name", localObject2);
                }
                catch (Exception localException2)
                {
                  localException2.printStackTrace();
                }
                paramString.exec(((JSONObject)localObject1).toString(), this);
              }
            }
          }
          else if (this.d != null)
          {
            if (!this.d.containsKey(Integer.valueOf(2))) {
              break label423;
            }
            paramString = (MQPIntChkService.IIntChkStrike)this.d.get(Integer.valueOf(2));
            if (paramString != null) {
              paramString.exec(null, this);
            }
          }
        }
        else if (this.d != null)
        {
          paramString = (String)localObject1;
          if (this.d.containsKey(Integer.valueOf(1))) {
            paramString = (MQPIntChkService.IIntChkStrike)this.d.get(Integer.valueOf(1));
          }
          if (paramString != null) {
            try
            {
              Object localObject3 = new DOMSource(localException2);
              localObject1 = new StringWriter();
              StreamResult localStreamResult = new StreamResult((Writer)localObject1);
              TransformerFactory.newInstance().newTransformer().transform((Source)localObject3, localStreamResult);
              localObject3 = new JSONObject();
              try
              {
                ((JSONObject)localObject3).put("toast_config", ((StringWriter)localObject1).toString());
              }
              catch (Exception localException1)
              {
                localException1.printStackTrace();
              }
              paramString.exec(((JSONObject)localObject3).toString(), this);
              return;
            }
            catch (Exception paramString)
            {
              paramString.printStackTrace();
              return;
            }
          }
        }
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      label423:
      paramString = null;
    }
  }
  
  public void a(int paramInt, MQPIntChkService.IIntChkStrike paramIIntChkStrike)
  {
    if (paramIIntChkStrike == null) {
      return;
    }
    if (this.d == null) {
      this.d = new LinkedHashMap();
    }
    this.d.put(Integer.valueOf(paramInt), paramIIntChkStrike);
  }
  
  public void a(Object paramObject1, Object paramObject2)
  {
    paramObject1 = this.b;
    if (paramObject1 != null)
    {
      Object localObject = paramObject1.b;
      if (localObject != null)
      {
        paramObject1 = null;
        localObject = ((INetTransportProvider)localObject).getCodec("intchk");
        if (localObject != null) {
          paramObject1 = (byte[])((INetTransportProvider.INetTransportCodec)localObject).decode(paramObject2);
        }
        if (paramObject1 == null) {
          return;
        }
        paramObject2 = new intchk.RspBody();
      }
    }
    int i;
    label113:
    do
    {
      try
      {
        paramObject2.mergeFrom(paramObject1);
        i = 0;
        if (!paramObject2.uint32_subcmd.has()) {
          break label113;
        }
        i = paramObject2.uint32_subcmd.get();
      }
      catch (InvalidProtocolBufferMicroException paramObject1)
      {
        paramObject1.printStackTrace();
      }
      b(paramObject2);
      return;
      while (i == 1)
      {
        a(paramObject2);
        return;
        return;
      }
    } while (i == 2);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("strike_result"))
      {
        this.g = paramString.getInt("strike_result");
        Object localObject = new intchk.ReportStrikeResultReq();
        ((intchk.ReportStrikeResultReq)localObject).uint32_intchk_id.set(this.e);
        ((intchk.ReportStrikeResultReq)localObject).uint32_strike_type.set(this.f);
        ((intchk.ReportStrikeResultReq)localObject).uint32_strike_result.set(this.g);
        paramString = new intchk.ReqBody();
        paramString.uint32_subcmd.set(3);
        paramString.msg_app_info.set(a());
        paramString.msg_report_strike_result_req.set((MessageMicro)localObject);
        if (this.b == null) {
          return;
        }
        INetTransportProvider localINetTransportProvider = this.b.b;
        if (localINetTransportProvider == null) {
          return;
        }
        localObject = paramString.toByteArray();
        INetTransportProvider.INetTransportCodec localINetTransportCodec = localINetTransportProvider.getCodec("intchk");
        paramString = (String)localObject;
        if (localINetTransportCodec != null) {
          paramString = localINetTransportCodec.encode(localObject);
        }
        localINetTransportProvider.send(paramString);
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
    Object localObject = new intchk.FetchCheckConfigReq();
    ((intchk.FetchCheckConfigReq)localObject).uint32_reserved.set(0);
    paramString = new intchk.ReqBody();
    paramString.uint32_subcmd.set(1);
    paramString.msg_app_info.set(a());
    paramString.msg_check_config_req.set((MessageMicro)localObject);
    INetTransportProvider localINetTransportProvider = this.b.b;
    if (localINetTransportProvider == null) {
      return;
    }
    localObject = paramString.toByteArray();
    INetTransportProvider.INetTransportCodec localINetTransportCodec = localINetTransportProvider.getCodec("intchk");
    paramString = (String)localObject;
    if (localINetTransportCodec != null) {
      paramString = localINetTransportCodec.encode(localObject);
    }
    localINetTransportProvider.send(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mqpsdk.secsrv.MQPIntChkService
 * JD-Core Version:    0.7.0.1
 */