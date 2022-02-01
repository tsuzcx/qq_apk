package com.tencent.mobileqq.log;

import KQQ.ReqItem;
import KQQ.RespItem;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.util.EndianUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate.ControlReqHead;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate.ControlRspHead;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate.WebViewConfigReq;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate.WebViewConfigRsp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebViewCheckUpdataItem
  implements CheckUpdateItemInterface
{
  public static final String a = "WebViewCheckUpdataItem";
  Set<String> b = new HashSet();
  boolean c = false;
  boolean d = false;
  QQAppInterface e;
  private int f = 0;
  
  public WebViewCheckUpdataItem(QQAppInterface paramQQAppInterface)
  {
    this.e = paramQQAppInterface;
  }
  
  private void c()
  {
    Object localObject1 = new JSONObject();
    try
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.e.getApplication().getFilesDir());
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append(VipWebViewReportLog.g);
      localObject2 = new File(((StringBuilder)localObject2).toString());
      if ((!((File)localObject2).exists()) && (!((File)localObject2).mkdirs()))
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Can't create dir: ");
        ((StringBuilder)localObject1).append(localObject2);
        QLog.e("WebCoreDump", 2, ((StringBuilder)localObject1).toString());
        return;
      }
      ((JSONObject)localObject1).put("js_report", this.c);
      ((JSONObject)localObject1).put("url_check", this.d);
      Object localObject3;
      if (this.b.size() > 0)
      {
        localObject2 = new JSONArray();
        localObject3 = this.b.iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((JSONArray)localObject2).put((String)((Iterator)localObject3).next());
        }
        ((JSONObject)localObject1).put("url_list", localObject2);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Http capture white list=");
          ((StringBuilder)localObject2).append(this.b);
          QLog.d("WebCoreDump", 2, ((StringBuilder)localObject2).toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("WebCoreDump", 2, "-->url white list is empty!");
      }
      if (this.f > 0)
      {
        localObject2 = this.e.getPreferences();
        long l = System.currentTimeMillis() + this.f * 1000;
        ((SharedPreferences)localObject2).edit().putLong("nextCheckWebviewTime", l).commit();
        if (QLog.isColorLevel())
        {
          localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l));
          localObject3 = a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleCheckUpdateItemData nextCheckUpdateTime");
          localStringBuilder.append((String)localObject2);
          QLog.d((String)localObject3, 2, localStringBuilder.toString());
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.e.getApplication().getFilesDir());
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append(VipWebViewReportLog.g);
      ((StringBuilder)localObject2).append(this.e.getCurrentAccountUin());
      ((StringBuilder)localObject2).append("config.json");
      localObject2 = new FileOutputStream(new File(((StringBuilder)localObject2).toString()));
      ((FileOutputStream)localObject2).write(((JSONObject)localObject1).toString().getBytes());
      ((FileOutputStream)localObject2).close();
      return;
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("-->save config failed:");
        ((StringBuilder)localObject2).append(localIOException.toString());
        QLog.w("WebCoreDump", 2, ((StringBuilder)localObject2).toString());
        return;
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("-->save config failed:");
        ((StringBuilder)localObject2).append(localFileNotFoundException.toString());
        QLog.w("WebCoreDump", 2, ((StringBuilder)localObject2).toString());
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("-->save config failed:");
        ((StringBuilder)localObject2).append(localJSONException.toString());
        QLog.w("WebCoreDump", 2, ((StringBuilder)localObject2).toString());
      }
    }
    return;
  }
  
  public int a()
  {
    return 5;
  }
  
  public ReqItem a(int paramInt)
  {
    if (!b()) {
      return null;
    }
    ReqItem localReqItem = new ReqItem();
    localReqItem.eServiceID = 126;
    Object localObject1 = new PreloadInfoCheckUpdate.WebViewConfigReq();
    Object localObject2 = new PreloadInfoCheckUpdate.ControlReqHead();
    ((PreloadInfoCheckUpdate.ControlReqHead)localObject2).protocol_ver.set(1);
    ((PreloadInfoCheckUpdate.ControlReqHead)localObject2).client_plat_id.set(109);
    ((PreloadInfoCheckUpdate.ControlReqHead)localObject2).client_ver.set("8.8.17.5770");
    ((PreloadInfoCheckUpdate.ControlReqHead)localObject2).os_ver.set("846a9bfd");
    ((PreloadInfoCheckUpdate.ControlReqHead)localObject2).uin.set(Long.parseLong(this.e.getCurrentAccountUin()));
    ((PreloadInfoCheckUpdate.WebViewConfigReq)localObject1).head.set((MessageMicro)localObject2);
    localObject1 = ((PreloadInfoCheckUpdate.WebViewConfigReq)localObject1).toByteArray();
    paramInt = localObject1.length;
    int i = paramInt + 4;
    localObject2 = new byte[i];
    System.arraycopy(EndianUtil.b(i), 0, localObject2, 0, 4);
    System.arraycopy(localObject1, 0, localObject2, 4, paramInt);
    localReqItem.vecParam = ((byte[])localObject2);
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    if (paramRespItem == null) {
      return;
    }
    if (paramRespItem.eServiceID != 126) {
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleCheckUpdateItemData respitem.cResult:");
      localStringBuilder.append(paramRespItem.cResult);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.c = false;
    this.d = false;
    this.b.clear();
    int i = paramRespItem.cResult;
    paramRespItem = paramRespItem.vecUpdate;
    if ((i == 2) && (paramRespItem.length > 4))
    {
      i = (int)PkgTools.getLongData(paramRespItem, 0) - 4;
      localObject = new byte[i];
      PkgTools.copyData((byte[])localObject, 0, paramRespItem, 4, i);
      try
      {
        paramRespItem = new PreloadInfoCheckUpdate.WebViewConfigRsp();
        paramRespItem.mergeFrom((byte[])localObject);
        if (paramRespItem.head.code.get() != 0) {
          break label381;
        }
        this.c = paramRespItem.js_report.get();
        this.d = paramRespItem.url_check.get();
        this.b.addAll(paramRespItem.url_list.get());
        this.f = paramRespItem.interval.get();
        if (!QLog.isColorLevel()) {
          break label381;
        }
        paramRespItem = new StringBuilder();
        paramRespItem.append("handleCheckUpdateItemData IsReportLog");
        paramRespItem.append(this.c);
        paramRespItem.append(", Url_Check=");
        paramRespItem.append(this.d);
        paramRespItem.append(", interval=");
        paramRespItem.append(this.f);
        QLog.d("WebCoreDump", 2, paramRespItem.toString());
      }
      catch (Exception paramRespItem)
      {
        paramRespItem.printStackTrace();
        if (!QLog.isColorLevel()) {
          break label381;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("-->exception during handle checkup data:");
      ((StringBuilder)localObject).append(paramRespItem.toString());
      QLog.d("WebCoreDump", 2, ((StringBuilder)localObject).toString());
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("-->checkup error:result=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(",data length:");
      ((StringBuilder)localObject).append(paramRespItem.length);
      QLog.d("WebCoreDump", 2, ((StringBuilder)localObject).toString());
    }
    label381:
    c();
    if (VipWebViewReportLog.l.get() != 1)
    {
      VipWebViewReportLog.b = this.b;
      VipWebViewReportLog.c = this.c;
      VipWebViewReportLog.d = this.d;
      if (QLog.isColorLevel()) {
        QLog.d("WebCoreDump", 2, "Update VipWebViewReportLog members");
      }
    }
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        long l1 = this.e.getPreferences().getLong("nextCheckWebviewTime", 0L);
        long l2 = System.currentTimeMillis();
        Object localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l1));
          str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l2));
          localObject2 = a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isSendTemplateCheckUpdate nextCheckUpdateTime=");
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(",systemTimestamp=");
          localStringBuilder.append(str);
          localStringBuilder.append(",isSend=");
          if (l2 > l1)
          {
            bool1 = true;
            localStringBuilder.append(bool1);
            QLog.d((String)localObject2, 2, localStringBuilder.toString());
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.e.getApplication().getFilesDir());
          ((StringBuilder)localObject1).append(File.separator);
          ((StringBuilder)localObject1).append(VipWebViewReportLog.g);
          ((StringBuilder)localObject1).append(this.e.getCurrentAccountUin());
          ((StringBuilder)localObject1).append("config.json");
          localObject1 = new File(((StringBuilder)localObject1).toString());
          if (l2 <= l1)
          {
            boolean bool3 = ((File)localObject1).exists();
            bool1 = bool2;
            if (bool3) {}
          }
          else
          {
            bool1 = true;
          }
          return bool1;
        }
      }
      catch (Exception localException)
      {
        String str;
        Object localObject2;
        if (QLog.isColorLevel())
        {
          str = a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Can't handle JS log and HTTP capture white list config: ");
          ((StringBuilder)localObject2).append(localException);
          QLog.w(str, 2, ((StringBuilder)localObject2).toString());
        }
        return false;
      }
      boolean bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.log.WebViewCheckUpdataItem
 * JD-Core Version:    0.7.0.1
 */