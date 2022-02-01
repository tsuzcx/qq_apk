package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.datareport;

import android.text.TextUtils;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.datareport.QualityReportTask;
import java.util.HashMap;
import java.util.Map;

public class QualityReportTaskImpl
  implements QualityReportTask
{
  Map<String, String> a = new HashMap();
  CustomDataReportService b;
  String c;
  private int d = 1;
  private boolean e = false;
  
  public QualityReportTask addKeyValue(String paramString, double paramDouble)
  {
    this.a.put(paramString, String.valueOf(paramDouble));
    return this;
  }
  
  public QualityReportTask addKeyValue(String paramString, int paramInt)
  {
    this.a.put(paramString, String.valueOf(paramInt));
    return this;
  }
  
  public QualityReportTask addKeyValue(String paramString, long paramLong)
  {
    this.a.put(paramString, String.valueOf(paramLong));
    return this;
  }
  
  public QualityReportTask addKeyValue(String paramString1, String paramString2)
  {
    this.a.put(paramString1, paramString2);
    return this;
  }
  
  public void send()
  {
    if (!TextUtils.isEmpty(this.c))
    {
      int i = this.d;
      if (i == 2)
      {
        this.b.b(this.c, this.a, this.e);
        return;
      }
      if (i == 1)
      {
        this.b.a(this.c, this.a, this.e);
        return;
      }
      if (i == 3) {
        this.b.a(this.a, this.e);
      }
      return;
    }
    throw new NullPointerException("缺少上报基础字段，请检查 actType以及他们的描述");
  }
  
  public QualityReportTask setActType(String paramString)
  {
    this.c = paramString;
    this.a.put("act_type", paramString);
    return this;
  }
  
  public QualityReportTask setActTypeDesc(String paramString)
  {
    this.a.put("act_type_desc", paramString);
    return this;
  }
  
  public void setDataReportService(DataReportInterface paramDataReportInterface)
  {
    this.b = ((CustomDataReportService)paramDataReportInterface);
  }
  
  public QualityReportTask setModule(String paramString)
  {
    this.a.put("page_module", paramString);
    return this;
  }
  
  public QualityReportTask setModuleDes(String paramString)
  {
    this.a.put("page_module_desc", paramString);
    return this;
  }
  
  public QualityReportTask setPage(String paramString)
  {
    this.a.put("page", paramString);
    return this;
  }
  
  public QualityReportTask setPageDes(String paramString)
  {
    this.a.put("page_desc", paramString);
    return this;
  }
  
  public void setQualityType(int paramInt)
  {
    this.d = paramInt;
  }
  
  public QualityReportTask setRealTimeUpload(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.datareport.QualityReportTaskImpl
 * JD-Core Version:    0.7.0.1
 */