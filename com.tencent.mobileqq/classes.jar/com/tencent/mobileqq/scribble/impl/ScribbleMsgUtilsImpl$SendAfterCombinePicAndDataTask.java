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
  private AppRuntime a;
  private IScribbleMsgUtils.CombineCallback b;
  private String c = "";
  private int d = 0;
  private Bitmap e = null;
  private String f = "";
  private String g = "";
  private String h = "";
  private int i = 0;
  private int j = 0;
  private String k = "SendAfterCombinePicAndDataTask";
  
  public ScribbleMsgUtilsImpl$SendAfterCombinePicAndDataTask(AppRuntime paramAppRuntime, String paramString, int paramInt1, Bitmap paramBitmap, int paramInt2, IScribbleMsgUtils.CombineCallback paramCombineCallback)
  {
    this.a = paramAppRuntime;
    this.b = paramCombineCallback;
    this.c = paramString;
    this.d = paramInt1;
    this.e = paramBitmap;
    this.i = paramInt2;
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
    Object localObject3 = this.b;
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
    localObject3 = a(this.e);
    this.j = localObject3.length;
    if (!ScribbleUtils.a((byte[])localObject3, (String)localObject2, (String)localObject1)) {
      return ScribbleMsgConstants.e;
    }
    localObject3 = ScribbleUtils.b((String)localObject1);
    if (TextUtils.isEmpty((CharSequence)localObject3)) {
      return ScribbleMsgConstants.f;
    }
    this.f = ((String)localObject3);
    this.g = ScribbleMsgUtilsImpl.access$000(this.f);
    this.h = ScribbleMsgUtilsImpl.access$100(this.f);
    if (!ScribbleUtils.a((String)localObject1, this.g).booleanValue()) {
      return ScribbleMsgConstants.e;
    }
    if (!ScribbleUtils.a((String)localObject2, this.h).booleanValue()) {
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
    Object localObject1 = this.k;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("doBeforeSendScribble result = ");
    ((StringBuilder)localObject2).append(paramInteger);
    QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    if (paramInteger.intValue() == ScribbleMsgConstants.d)
    {
      localObject1 = new ScribbleBaseOperator(this.a);
      localObject2 = ((ScribbleBaseOperator)localObject1).a(this.g, this.f, this.j, this.c, this.d, this.i);
      ((MessageForScribble)localObject2).mExistInfo.mCombineFileExist = true;
      ((MessageForScribble)localObject2).mExistInfo.mDataFileExist = true;
      ((MessageForScribble)localObject2).mExistInfo.mLocalPathExist = true;
      ((MessageForScribble)localObject2).mExistInfo.mInit = true;
      ((ScribbleBaseOperator)localObject1).b((MessageForScribble)localObject2);
    }
    localObject1 = this.b;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.impl.ScribbleMsgUtilsImpl.SendAfterCombinePicAndDataTask
 * JD-Core Version:    0.7.0.1
 */