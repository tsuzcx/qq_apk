package com.tencent.qidian.data;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qidian.proto.mobileqq_qidian.CompanyShowCaseInfo;

public class CompanyShowCaseInfo
{
  public String a = "";
  public String b = "";
  public String c = "";
  
  public CompanyShowCaseInfo() {}
  
  public CompanyShowCaseInfo(mobileqq_qidian.CompanyShowCaseInfo paramCompanyShowCaseInfo)
  {
    a(paramCompanyShowCaseInfo);
  }
  
  public mobileqq_qidian.CompanyShowCaseInfo a()
  {
    mobileqq_qidian.CompanyShowCaseInfo localCompanyShowCaseInfo = new mobileqq_qidian.CompanyShowCaseInfo();
    localCompanyShowCaseInfo.string_show_case_title.set(this.a);
    localCompanyShowCaseInfo.string_show_case_link.set(this.b);
    localCompanyShowCaseInfo.string_show_case_image.set(this.c);
    return localCompanyShowCaseInfo;
  }
  
  public void a(mobileqq_qidian.CompanyShowCaseInfo paramCompanyShowCaseInfo)
  {
    if (paramCompanyShowCaseInfo.string_show_case_title.has()) {
      this.a = paramCompanyShowCaseInfo.string_show_case_title.get();
    }
    if (paramCompanyShowCaseInfo.string_show_case_link.has()) {
      this.b = paramCompanyShowCaseInfo.string_show_case_link.get();
    }
    if (paramCompanyShowCaseInfo.string_show_case_image.has()) {
      this.c = paramCompanyShowCaseInfo.string_show_case_image.get();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qidian.data.CompanyShowCaseInfo
 * JD-Core Version:    0.7.0.1
 */