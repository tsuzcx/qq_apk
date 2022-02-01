package com.tencent.mobileqq.jsp;

import java.lang.ref.WeakReference;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginListener;
import oicq.wlogin_sdk.tools.ErrMsg;

class DataApiPlugin$GetKeyListener
  extends WtloginListener
{
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<DataApiPlugin> jdField_a_of_type_JavaLangRefWeakReference;
  private String b;
  private String c;
  private String d;
  
  public DataApiPlugin$GetKeyListener(DataApiPlugin paramDataApiPlugin, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramDataApiPlugin);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
  }
  
  public void OnGetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    if (paramInt2 == 0)
    {
      paramString = this.jdField_a_of_type_JavaLangRefWeakReference;
      if ((paramString != null) && (paramString.get() != null)) {
        ((DataApiPlugin)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_JavaLangString, paramWUserSigInfo, this.b, paramInt1, this.c, this.d);
      }
    }
    else
    {
      paramString = this.jdField_a_of_type_JavaLangRefWeakReference;
      if ((paramString != null) && (paramString.get() != null))
      {
        paramString = (DataApiPlugin)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        paramWUserSigInfo = this.b;
        paramErrMsg = new StringBuilder();
        paramErrMsg.append("getTicket fail code = ");
        paramErrMsg.append(paramInt2);
        paramString.b(paramWUserSigInfo, paramErrMsg.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.DataApiPlugin.GetKeyListener
 * JD-Core Version:    0.7.0.1
 */