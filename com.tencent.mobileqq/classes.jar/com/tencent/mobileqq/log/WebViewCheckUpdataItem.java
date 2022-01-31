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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebViewCheckUpdataItem
  implements CheckUpdateItemInterface
{
  public static final String a;
  private int jdField_a_of_type_Int;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Set jdField_a_of_type_JavaUtilSet = new HashSet();
  boolean jdField_a_of_type_Boolean = false;
  boolean b;
  
  static
  {
    jdField_a_of_type_JavaLangString = WebViewCheckUpdataItem.class.getSimpleName();
  }
  
  public WebViewCheckUpdataItem(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Object localObject = new File(VipWebViewReportLog.jdField_b_of_type_JavaLangString);
      if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
      {
        if (QLog.isColorLevel()) {
          QLog.e("WebCoreDump", 2, "Can't create dir: " + localObject);
        }
      }
      else
      {
        localJSONObject.put("js_report", this.jdField_a_of_type_Boolean);
        localJSONObject.put("url_check", this.jdField_b_of_type_Boolean);
        if (this.jdField_a_of_type_JavaUtilSet.size() > 0)
        {
          localObject = new JSONArray();
          Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
          while (localIterator.hasNext()) {
            ((JSONArray)localObject).put((String)localIterator.next());
          }
        }
      }
      long l;
      return;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel())
      {
        QLog.w("WebCoreDump", 2, "-->save config failed:" + localJSONException.toString());
        return;
        localJSONException.put("url_list", localObject);
        if (QLog.isColorLevel()) {
          QLog.d("WebCoreDump", 2, "Http capture white list=" + this.jdField_a_of_type_JavaUtilSet);
        }
        if (this.jdField_a_of_type_Int > 0)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
          l = System.currentTimeMillis() + this.jdField_a_of_type_Int * 1000;
          ((SharedPreferences)localObject).edit().putLong("nextCheckWebviewTime", l).commit();
          if (QLog.isColorLevel())
          {
            localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l));
            QLog.d(jdField_a_of_type_JavaLangString, 2, "handleCheckUpdateItemData nextCheckUpdateTime" + (String)localObject);
          }
        }
        localObject = new FileOutputStream(new File(VipWebViewReportLog.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "config.json"));
        ((FileOutputStream)localObject).write(localJSONException.toString().getBytes());
        ((FileOutputStream)localObject).close();
        return;
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      while (QLog.isColorLevel())
      {
        QLog.w("WebCoreDump", 2, "-->save config failed:" + localFileNotFoundException.toString());
        return;
        if (QLog.isColorLevel()) {
          QLog.d("WebCoreDump", 2, "-->url white list is empty!");
        }
      }
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("WebCoreDump", 2, "-->save config failed:" + localIOException.toString());
      }
    }
  }
  
  public int a()
  {
    return 5;
  }
  
  public ReqItem a()
  {
    if (!a()) {
      return null;
    }
    ReqItem localReqItem = new ReqItem();
    localReqItem.eServiceID = 126;
    Object localObject1 = new PreloadInfoCheckUpdate.WebViewConfigReq();
    Object localObject2 = new PreloadInfoCheckUpdate.ControlReqHead();
    ((PreloadInfoCheckUpdate.ControlReqHead)localObject2).protocol_ver.set(1);
    ((PreloadInfoCheckUpdate.ControlReqHead)localObject2).client_plat_id.set(109);
    ((PreloadInfoCheckUpdate.ControlReqHead)localObject2).client_ver.set("7.6.3.3565");
    ((PreloadInfoCheckUpdate.ControlReqHead)localObject2).os_ver.set("351230");
    ((PreloadInfoCheckUpdate.ControlReqHead)localObject2).uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    ((PreloadInfoCheckUpdate.WebViewConfigReq)localObject1).head.set((MessageMicro)localObject2);
    localObject1 = ((PreloadInfoCheckUpdate.WebViewConfigReq)localObject1).toByteArray();
    int i = localObject1.length;
    int j = i + 4;
    localObject2 = new byte[j];
    System.arraycopy(EndianUtil.b(j), 0, localObject2, 0, 4);
    System.arraycopy(localObject1, 0, localObject2, 4, i);
    localReqItem.vecParam = ((byte[])localObject2);
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    if (paramRespItem == null) {}
    while (paramRespItem.eServiceID != 126) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleCheckUpdateItemData respitem.cResult:" + paramRespItem.cResult);
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilSet.clear();
    int i = paramRespItem.cResult;
    Object localObject = paramRespItem.vecUpdate;
    if ((i == 2) && (localObject.length > 4))
    {
      i = (int)PkgTools.a((byte[])localObject, 0);
      paramRespItem = new byte[i - 4];
      PkgTools.a(paramRespItem, 0, (byte[])localObject, 4, i - 4);
    }
    for (;;)
    {
      try
      {
        localObject = new PreloadInfoCheckUpdate.WebViewConfigRsp();
        ((PreloadInfoCheckUpdate.WebViewConfigRsp)localObject).mergeFrom(paramRespItem);
        if (((PreloadInfoCheckUpdate.WebViewConfigRsp)localObject).head.code.get() == 0)
        {
          this.jdField_a_of_type_Boolean = ((PreloadInfoCheckUpdate.WebViewConfigRsp)localObject).js_report.get();
          this.jdField_b_of_type_Boolean = ((PreloadInfoCheckUpdate.WebViewConfigRsp)localObject).url_check.get();
          this.jdField_a_of_type_JavaUtilSet.addAll(((PreloadInfoCheckUpdate.WebViewConfigRsp)localObject).url_list.get());
          this.jdField_a_of_type_Int = ((PreloadInfoCheckUpdate.WebViewConfigRsp)localObject).interval.get();
          if (QLog.isColorLevel()) {
            QLog.d("WebCoreDump", 2, "handleCheckUpdateItemData IsReportLog" + this.jdField_a_of_type_Boolean + ", Url_Check=" + this.jdField_b_of_type_Boolean + ", interval=" + this.jdField_a_of_type_Int);
          }
        }
        a();
        if (VipWebViewReportLog.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {
          break;
        }
        VipWebViewReportLog.jdField_a_of_type_JavaUtilSet = this.jdField_a_of_type_JavaUtilSet;
        VipWebViewReportLog.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
        VipWebViewReportLog.jdField_b_of_type_Boolean = this.jdField_b_of_type_Boolean;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("WebCoreDump", 2, "Update VipWebViewReportLog members");
        return;
      }
      catch (Exception paramRespItem)
      {
        paramRespItem.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("WebCoreDump", 2, "-->exception during handle checkup data:" + paramRespItem.toString());
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("WebCoreDump", 2, "-->checkup error:result=" + i + ",data length:" + localObject.length);
      }
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("nextCheckWebviewTime", 0L);
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          Object localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l1));
          String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l2));
          localObject1 = jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder().append("isSendTemplateCheckUpdate nextCheckUpdateTime=").append((String)localObject2).append(",systemTimestamp=").append(str).append(",isSend=");
          if (l2 <= l1) {
            continue;
          }
          bool1 = true;
          QLog.d((String)localObject1, 2, bool1);
        }
        Object localObject1 = new File(VipWebViewReportLog.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "config.json");
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
      }
      catch (Exception localException)
      {
        boolean bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w(jdField_a_of_type_JavaLangString, 2, "Can't handle JS log and HTTP capture white list config: " + localException);
      }
      return bool1;
      bool1 = false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.log.WebViewCheckUpdataItem
 * JD-Core Version:    0.7.0.1
 */