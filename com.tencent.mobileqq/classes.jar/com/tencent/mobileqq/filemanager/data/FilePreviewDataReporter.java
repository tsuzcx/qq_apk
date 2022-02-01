package com.tencent.mobileqq.filemanager.data;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class FilePreviewDataReporter
{
  public final String a = "actFilePreview";
  public long b;
  public String c;
  public String d;
  public String e;
  public long f;
  public String g;
  public String h;
  public int i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public long o;
  public long p;
  public boolean q;
  String r = null;
  public long s;
  public long t;
  
  public FilePreviewDataReporter(String paramString)
  {
    this.r = paramString;
  }
  
  private HashMap<String, String> b()
  {
    HashMap localHashMap = new HashMap();
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      this.e = String.valueOf(9004);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.k);
      localStringBuilder.append("_NotNetWork");
      this.k = localStringBuilder.toString();
    }
    localHashMap.put("param_serverip", String.valueOf(this.c));
    localHashMap.put("param_uuid", String.valueOf(this.d));
    localHashMap.put("param_FailCode", String.valueOf(this.e));
    localHashMap.put("param_fsizeo", String.valueOf(this.f));
    localHashMap.put("param_url", String.valueOf(this.g));
    localHashMap.put("param_key", String.valueOf(this.h));
    localHashMap.put("param_retry", String.valueOf(this.i));
    localHashMap.put("param_errMsg", String.valueOf(this.k));
    localHashMap.put("param_fileName", String.valueOf(this.j));
    localHashMap.put("param_fileExt", String.valueOf(this.l));
    localHashMap.put("param_source", String.valueOf(this.m));
    localHashMap.put("param_stage", String.valueOf(this.n));
    localHashMap.put("param_stagetimelen", String.valueOf(this.o));
    localHashMap.put("param_staytimelen", String.valueOf(this.p));
    this.k = "";
    return localHashMap;
  }
  
  public void a()
  {
    HashMap localHashMap = b();
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doReport:bSuccess[");
      ((StringBuilder)localObject).append(this.q);
      ((StringBuilder)localObject).append("],");
      localStringBuilder1.append(((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("strReportUin[");
      ((StringBuilder)localObject).append(this.r);
      ((StringBuilder)localObject).append("],");
      localStringBuilder1.append(((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startTime[");
      ((StringBuilder)localObject).append(this.s);
      ((StringBuilder)localObject).append("],");
      localStringBuilder1.append(((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("endTime[");
      ((StringBuilder)localObject).append(this.t);
      ((StringBuilder)localObject).append("],");
      localStringBuilder1.append(((StringBuilder)localObject).toString());
      localObject = localHashMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(str);
        localStringBuilder2.append("[");
        localStringBuilder2.append((String)localHashMap.get(str));
        localStringBuilder2.append("]");
        localStringBuilder1.append(localStringBuilder2.toString());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doReport:");
      ((StringBuilder)localObject).append(localStringBuilder1.toString());
      QLog.i("FilePreviewDataReporter<FileAssistant>", 4, ((StringBuilder)localObject).toString());
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.r, "actFilePreview", this.q, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FilePreviewDataReporter
 * JD-Core Version:    0.7.0.1
 */