package com.tencent.mobileqq.now.roport;

public class NowQQLiveDataReport
{
  public static void a()
  {
    new ReportTask().a("now_qq_gzh").b("notice_click").a();
  }
  
  public static void a(int paramInt, String paramString1, String paramString2)
  {
    new ReportTask().a("now_qq_gzh").b("msg_exp").a(paramInt).d(paramString1).e(paramString2).a();
  }
  
  public static void a(String paramString)
  {
    new ReportTask().a("now_qq_gzh").b("homepage_view").c(paramString).a();
  }
  
  public static void a(String paramString, int paramInt)
  {
    new ReportTask().a("now_qq_gzh").b("follow_anchor_click").a("anchor", paramString).a(paramInt).a();
  }
  
  public static void b()
  {
    new ReportTask().a("now_qq_gzh").b("notice_page_view").a();
  }
  
  public static void b(int paramInt, String paramString1, String paramString2)
  {
    new ReportTask().a("now_qq_gzh").b("msg_click").a(paramInt).d(paramString1).e(paramString2).a();
  }
  
  public static void b(String paramString)
  {
    new ReportTask().a("now_qq_gzh").b("follow_anchor_exp").a("anchor", paramString).a();
  }
  
  public static void b(String paramString, int paramInt)
  {
    new ReportTask().a("now_qq_gzh").b("rec_anchor_click").a("anchor", paramString).a(paramInt).a();
  }
  
  public static void c(String paramString)
  {
    new ReportTask().a("now_qq_gzh").b("rec_anchor_exp").a("anchor", paramString).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.roport.NowQQLiveDataReport
 * JD-Core Version:    0.7.0.1
 */