package com.tencent.mobileqq.scribble.impl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.scribble.IScribbleMsgUtils.CombineCallback;
import com.tencent.mobileqq.scribble.ScribbleBaseOperator;
import com.tencent.mobileqq.scribble.ScribbleMsgConstants;
import com.tencent.mobileqq.scribble.ScribbleUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import mqq.app.AppRuntime;

class ScribbleMsgUtilsImpl$SendAfterCombinePicAndDataTask
  extends AsyncTask<Void, Void, Integer>
{
  private int jdField_a_of_type_Int = 0;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  private IScribbleMsgUtils.CombineCallback jdField_a_of_type_ComTencentMobileqqScribbleIScribbleMsgUtils$CombineCallback;
  private String jdField_a_of_type_JavaLangString = "";
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString = "";
  private int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString = "";
  private String d = "";
  private String e = "SendAfterCombinePicAndDataTask";
  
  public ScribbleMsgUtilsImpl$SendAfterCombinePicAndDataTask(AppRuntime paramAppRuntime, String paramString, int paramInt1, Bitmap paramBitmap, int paramInt2, IScribbleMsgUtils.CombineCallback paramCombineCallback)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentMobileqqScribbleIScribbleMsgUtils$CombineCallback = paramCombineCallback;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  int a()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(ScribbleMsgConstants.a());
    ((StringBuilder)localObject1).append("temp/");
    ((StringBuilder)localObject1).append(System.currentTimeMillis());
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(ScribbleMsgConstants.a());
    ((StringBuilder)localObject2).append("temp/");
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    ((StringBuilder)localObject2).append("_data");
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqScribbleIScribbleMsgUtils$CombineCallback;
    boolean bool;
    if (localObject3 != null) {
      bool = ((IScribbleMsgUtils.CombineCallback)localObject3).a((String)localObject2);
    } else {
      bool = false;
    }
    if (!bool) {
      return ScribbleMsgConstants.g;
    }
    if (!FileUtils.fileExists((String)localObject2)) {
      return ScribbleMsgConstants.h;
    }
    localObject3 = a(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_c_of_type_Int = localObject3.length;
    if (!ScribbleUtils.a((byte[])localObject3, (String)localObject2, (String)localObject1)) {
      return ScribbleMsgConstants.e;
    }
    localObject3 = ScribbleUtils.a((String)localObject1);
    if (TextUtils.isEmpty((CharSequence)localObject3)) {
      return ScribbleMsgConstants.f;
    }
    this.jdField_b_of_type_JavaLangString = ((String)localObject3);
    this.jdField_c_of_type_JavaLangString = ScribbleMsgUtilsImpl.access$000(this.jdField_b_of_type_JavaLangString);
    this.d = ScribbleMsgUtilsImpl.access$100(this.jdField_b_of_type_JavaLangString);
    if (!ScribbleUtils.a((String)localObject1, this.jdField_c_of_type_JavaLangString).booleanValue()) {
      return ScribbleMsgConstants.e;
    }
    if (!ScribbleUtils.a((String)localObject2, this.d).booleanValue()) {
      return ScribbleMsgConstants.e;
    }
    FileUtils.deleteFile((String)localObject1);
    FileUtils.deleteFile((String)localObject2);
    return ScribbleMsgConstants.d;
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
    if (paramInteger.intValue() == ScribbleMsgConstants.d)
    {
      localObject1 = new ScribbleBaseOperator(this.jdField_a_of_type_MqqAppAppRuntime);
      localObject2 = ((ScribbleBaseOperator)localObject1).a(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      ((MessageForScribble)localObject2).mExistInfo.mCombineFileExist = true;
      ((MessageForScribble)localObject2).mExistInfo.mDataFileExist = true;
      ((MessageForScribble)localObject2).mExistInfo.mLocalPathExist = true;
      ((MessageForScribble)localObject2).mExistInfo.mInit = true;
      ((ScribbleBaseOperator)localObject1).a((MessageForScribble)localObject2);
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqScribbleIScribbleMsgUtils$CombineCallback;
    if (localObject1 != null) {
      ((IScribbleMsgUtils.CombineCallback)localObject1).a(paramInteger.intValue());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.impl.ScribbleMsgUtilsImpl.SendAfterCombinePicAndDataTask
 * JD-Core Version:    0.7.0.1
 */