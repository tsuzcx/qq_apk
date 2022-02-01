package com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport;

import android.text.TextUtils;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.datareport.ReportTask;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class RealDataReportTask
  implements ReportTask
{
  Map<String, String> a = new HashMap();
  DataReportInterface b;
  String c;
  String d;
  String e;
  
  public ReportTask addKeyValue(String paramString, double paramDouble)
  {
    this.a.put(paramString, String.valueOf(paramDouble));
    return this;
  }
  
  public ReportTask addKeyValue(String paramString, int paramInt)
  {
    this.a.put(paramString, String.valueOf(paramInt));
    return this;
  }
  
  public ReportTask addKeyValue(String paramString, long paramLong)
  {
    this.a.put(paramString, String.valueOf(paramLong));
    return this;
  }
  
  public ReportTask addKeyValue(String paramString1, String paramString2)
  {
    this.a.put(paramString1, paramString2);
    return this;
  }
  
  public void send()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.e);
    ((StringBuilder)localObject).append("#");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("#");
    ((StringBuilder)localObject).append(this.d);
    localObject = ((StringBuilder)localObject).toString();
    if ((!TextUtils.isEmpty(this.e)) && (!TextUtils.isEmpty(this.c)) && (!TextUtils.isEmpty(this.d)) && (!TextUtils.isEmpty((CharSequence)this.a.get("page_desc"))) && (!TextUtils.isEmpty((CharSequence)this.a.get("page_module_desc"))) && (!TextUtils.isEmpty((CharSequence)this.a.get("act_type_desc"))))
    {
      this.b.reportEvent((String)localObject, true, -1L, -1L, this.a, true, true);
      return;
    }
    QLog.e("RealDataReportTask", 1, "缺少上报基础字段，请检查 page,module,actType以及他们的描述");
  }
  
  public ReportTask setActType(String paramString)
  {
    this.e = paramString;
    this.a.put("act_type", paramString);
    return this;
  }
  
  public ReportTask setActTypeDesc(String paramString)
  {
    this.a.put("act_type_desc", paramString);
    return this;
  }
  
  public ReportTask setCommonet(String paramString)
  {
    this.a.put("report_commoent", paramString);
    return this;
  }
  
  public void setDataReportService(DataReportInterface paramDataReportInterface)
  {
    this.b = paramDataReportInterface;
  }
  
  public ReportTask setModule(String paramString)
  {
    this.d = paramString;
    this.a.put("page_module", paramString);
    return this;
  }
  
  public ReportTask setModuleDesc(String paramString)
  {
    this.a.put("page_module_desc", paramString);
    return this;
  }
  
  public ReportTask setPage(String paramString)
  {
    this.c = paramString;
    this.a.put("page", paramString);
    return this;
  }
  
  public ReportTask setPageDesc(String paramString)
  {
    this.a.put("page_desc", paramString);
    return this;
  }
  
  public ReportTask setRealTimeUpload(boolean paramBoolean)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport.RealDataReportTask
 * JD-Core Version:    0.7.0.1
 */