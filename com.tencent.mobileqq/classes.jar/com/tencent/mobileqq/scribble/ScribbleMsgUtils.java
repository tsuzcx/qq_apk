package com.tencent.mobileqq.scribble;

import ahqb;
import ahqc;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForScribble.FileExistInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ScribbleMsgUtils
{
  public static int a;
  public static final String a;
  public static int b = 1;
  public static int c = 2;
  public static int d = 1;
  public static int e = 2;
  public static int f = 3;
  public static int g = 4;
  public static int h = 5;
  public static int i = 6;
  public static int j = 7;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.bM + "ScribbleCache/";
  }
  
  public static int a(MessageForScribble paramMessageForScribble)
  {
    boolean bool1 = paramMessageForScribble.mExistInfo.mDataFileExist;
    if (!paramMessageForScribble.mExistInfo.mInit) {
      bool1 = FileUtil.a(b(paramMessageForScribble));
    }
    boolean bool2 = paramMessageForScribble.mExistInfo.mCombineFileExist;
    if (!paramMessageForScribble.mExistInfo.mInit) {
      bool2 = FileUtil.a(a(paramMessageForScribble));
    }
    if ((bool1) && (bool2)) {
      return c;
    }
    if ((!bool1) && (bool2)) {
      return b;
    }
    return jdField_a_of_type_Int;
  }
  
  public static String a(MessageForScribble paramMessageForScribble)
  {
    if ((paramMessageForScribble != null) && (!TextUtils.isEmpty(paramMessageForScribble.combineFileMd5))) {
      return c(paramMessageForScribble.combineFileMd5);
    }
    return "";
  }
  
  private static void a()
  {
    File localFile = new File(jdField_a_of_type_JavaLangString);
    if (((localFile.exists()) && (!localFile.isDirectory())) || (!localFile.exists())) {
      localFile.mkdirs();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, Bitmap paramBitmap, int paramInt2, ScribbleMsgUtils.CombineCallback paramCombineCallback)
  {
    a();
    new ahqc(paramQQAppInterface, paramString, paramInt1, paramBitmap, paramInt2, paramCombineCallback).execute(new Void[0]);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageForScribble paramMessageForScribble)
  {
    if (paramMessageForScribble == null) {}
    ScribbleBaseOperator localScribbleBaseOperator;
    MessageForScribble localMessageForScribble;
    do
    {
      return false;
      if (paramMessageForScribble.isSendFromLocal()) {
        paramQQAppInterface.a().a(paramQQAppInterface.a().a(paramMessageForScribble.frienduin, paramMessageForScribble.uniseq));
      }
      localScribbleBaseOperator = new ScribbleBaseOperator(paramQQAppInterface);
      localMessageForScribble = localScribbleBaseOperator.a(paramMessageForScribble);
    } while (localMessageForScribble == null);
    ThreadManager.post(new ahqb(paramQQAppInterface, paramMessageForScribble), 5, null, false);
    localScribbleBaseOperator.a(localMessageForScribble);
    return true;
  }
  
  public static int b(MessageForScribble paramMessageForScribble)
  {
    if ((paramMessageForScribble == null) || (paramMessageForScribble.combineFileMd5 == null)) {
      return j;
    }
    String str1 = a(paramMessageForScribble);
    if (!FileUtil.a(str1)) {
      return i;
    }
    long l = FileUtil.a(str1);
    if ((paramMessageForScribble.offSet <= 0) || (paramMessageForScribble.offSet >= (int)l))
    {
      QLog.e("ScribbleMsgUtils", 2, " offSet = " + paramMessageForScribble.offSet + " FileSize : " + l);
      return j;
    }
    String str2 = b(paramMessageForScribble);
    if (FileUtil.a(str2)) {
      FileUtil.c(str2);
    }
    if (ScribbleUtils.a(str1, paramMessageForScribble.offSet, str2)) {
      return d;
    }
    return e;
  }
  
  public static String b(MessageForScribble paramMessageForScribble)
  {
    if ((paramMessageForScribble != null) && (!TextUtils.isEmpty(paramMessageForScribble.combineFileMd5))) {
      return d(paramMessageForScribble.combineFileMd5);
    }
    return "";
  }
  
  private static String c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return jdField_a_of_type_JavaLangString + paramString;
    }
    return "";
  }
  
  private static String d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return jdField_a_of_type_JavaLangString + paramString + "_data";
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleMsgUtils
 * JD-Core Version:    0.7.0.1
 */