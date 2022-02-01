package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.scribble.ScribbleUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;

class DrawRedbagMsgUtils$SendAfterCombinePicAndDataTask
  extends AsyncTask<Void, Void, Integer>
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private BaseQQAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
  private DrawRedbagMsgUtils.CombineCallback jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawRedbagMsgUtils$CombineCallback;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  private String e;
  
  int a()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(DrawRedbagMsgUtils.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject1).append("temp/");
    ((StringBuilder)localObject1).append(System.currentTimeMillis());
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(DrawRedbagMsgUtils.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject2).append("temp/");
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    ((StringBuilder)localObject2).append("_data");
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawRedbagMsgUtils$CombineCallback;
    boolean bool;
    if (localObject3 != null) {
      bool = ((DrawRedbagMsgUtils.CombineCallback)localObject3).a((String)localObject2);
    } else {
      bool = false;
    }
    if (!bool) {
      return DrawRedbagMsgUtils.d;
    }
    if (!FileUtil.b((String)localObject2)) {
      return DrawRedbagMsgUtils.e;
    }
    localObject3 = a(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_c_of_type_Int = localObject3.length;
    if (!ScribbleUtils.a((byte[])localObject3, (String)localObject2, (String)localObject1)) {
      return DrawRedbagMsgUtils.jdField_b_of_type_Int;
    }
    localObject3 = ScribbleUtils.a((String)localObject1);
    if (TextUtils.isEmpty((CharSequence)localObject3)) {
      return DrawRedbagMsgUtils.jdField_c_of_type_Int;
    }
    this.jdField_b_of_type_JavaLangString = ((String)localObject3);
    this.jdField_c_of_type_JavaLangString = DrawRedbagMsgUtils.a(this.jdField_b_of_type_JavaLangString);
    this.d = DrawRedbagMsgUtils.b(this.jdField_b_of_type_JavaLangString);
    if (!ScribbleUtils.a((String)localObject1, this.jdField_c_of_type_JavaLangString).booleanValue()) {
      return DrawRedbagMsgUtils.jdField_b_of_type_Int;
    }
    if (!ScribbleUtils.a((String)localObject2, this.d).booleanValue()) {
      return DrawRedbagMsgUtils.jdField_b_of_type_Int;
    }
    FileUtil.c((String)localObject1);
    FileUtil.c((String)localObject2);
    return DrawRedbagMsgUtils.jdField_a_of_type_Int;
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    return Integer.valueOf(a());
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    Object localObject1 = this.e;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("doBeforeSendScribble result = ");
    ((StringBuilder)localObject2).append(paramInteger);
    QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    if (paramInteger.intValue() == DrawRedbagMsgUtils.jdField_a_of_type_Int)
    {
      localObject1 = new ScribbleBaseOperator(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface);
      localObject2 = ((ScribbleBaseOperator)localObject1).a(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      ((MessageForScribble)localObject2).mExistInfo.mCombineFileExist = true;
      ((MessageForScribble)localObject2).mExistInfo.mDataFileExist = true;
      ((MessageForScribble)localObject2).mExistInfo.mLocalPathExist = true;
      ((MessageForScribble)localObject2).mExistInfo.mInit = true;
      ((ScribbleBaseOperator)localObject1).a((MessageForScribble)localObject2);
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawRedbagMsgUtils$CombineCallback;
    if (localObject1 != null) {
      ((DrawRedbagMsgUtils.CombineCallback)localObject1).a(paramInteger.intValue());
    }
  }
  
  public byte[] a(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawRedbagMsgUtils.SendAfterCombinePicAndDataTask
 * JD-Core Version:    0.7.0.1
 */