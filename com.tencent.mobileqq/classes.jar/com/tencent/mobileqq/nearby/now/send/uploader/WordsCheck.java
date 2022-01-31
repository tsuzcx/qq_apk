package com.tencent.mobileqq.nearby.now.send.uploader;

import aejl;
import aejm;
import android.text.TextUtils;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.protocol.CsTask;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.now.WordsSecurity.SecurityReq;
import com.tencent.qphone.base.util.BaseApplication;

public class WordsCheck
{
  public static void a(QQAppInterface paramQQAppInterface, String paramString, WordsCheck.OnResultListener paramOnResultListener)
  {
    WordsSecurity.SecurityReq localSecurityReq = new WordsSecurity.SecurityReq();
    localSecurityReq.check_word.set(ByteStringMicro.copyFromUtf8(paramString));
    localSecurityReq.check_mask.set(3);
    localSecurityReq.svr_type.set(9);
    if (!NetworkUtil.a(BaseApplication.getContext())) {
      if (paramOnResultListener != null) {
        paramOnResultListener.b(1);
      }
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(paramString)) {
        break;
      }
    } while (paramOnResultListener == null);
    paramOnResultListener.a(0);
    return;
    new CsTask(paramQQAppInterface).a(24585).b(2).a(new aejm(paramOnResultListener)).a(new aejl(paramOnResultListener)).a(localSecurityReq.toByteArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.send.uploader.WordsCheck
 * JD-Core Version:    0.7.0.1
 */