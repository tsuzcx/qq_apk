package com.tencent.mobileqq.emoticon;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.qphone.base.util.QLog;

public class SVIPHandlerWrapper
{
  public static Bundle a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = ((SVIPHandler)paramQQAppInterface.a(13)).j();
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonContentProvider", 2, "call, vipType = " + i);
    }
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putInt(paramString, i);
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.SVIPHandlerWrapper
 * JD-Core Version:    0.7.0.1
 */