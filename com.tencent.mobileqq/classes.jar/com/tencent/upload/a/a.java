package com.tencent.upload.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.upload.d.e;
import com.tencent.upload.uinterface.IUploadConfig;

public class a
{
  public static String a(String paramString, int paramInt)
  {
    return paramString + Math.abs(paramInt);
  }
  
  public static void a(e parame)
  {
    String str = parame.getFilePath();
    long l = com.tencent.upload.common.a.b().getCurrentUin();
    Object localObject = com.tencent.upload.common.a.a();
    if ((localObject == null) || (l == 0L) || (TextUtils.isEmpty(str))) {}
    do
    {
      return;
      str = a(str, parame.flowId);
      localObject = new b((Context)localObject).a(l, str);
    } while (TextUtils.isEmpty((CharSequence)localObject));
    parame.setSessionId((String)localObject);
  }
  
  public static void a(e parame, String paramString)
  {
    long l = com.tencent.upload.common.a.b().getCurrentUin();
    Context localContext = com.tencent.upload.common.a.a();
    String str = parame.getFilePath();
    if ((localContext == null) || (l == 0L) || (TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    parame = a(str, parame.flowId);
    new b(localContext).a(l, parame, paramString);
  }
  
  public static void b(e parame, String paramString)
  {
    long l = com.tencent.upload.common.a.b().getCurrentUin();
    Context localContext = com.tencent.upload.common.a.a();
    String str = parame.getFilePath();
    if ((localContext == null) || (l == 0L) || (TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    parame = a(str, parame.flowId);
    new b(localContext).b(l, parame, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.a.a
 * JD-Core Version:    0.7.0.1
 */