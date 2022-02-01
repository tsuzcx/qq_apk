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
  private BaseQQAppInterface a;
  private DrawRedbagMsgUtils.CombineCallback b;
  private String c;
  private int d;
  private Bitmap e;
  private String f;
  private String g;
  private String h;
  private int i;
  private int j;
  private String k;
  
  int a()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(DrawRedbagMsgUtils.a);
    ((StringBuilder)localObject1).append("temp/");
    ((StringBuilder)localObject1).append(System.currentTimeMillis());
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(DrawRedbagMsgUtils.a);
    ((StringBuilder)localObject2).append("temp/");
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    ((StringBuilder)localObject2).append("_data");
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = this.b;
    boolean bool;
    if (localObject3 != null) {
      bool = ((DrawRedbagMsgUtils.CombineCallback)localObject3).a((String)localObject2);
    } else {
      bool = false;
    }
    if (!bool) {
      return DrawRedbagMsgUtils.e;
    }
    if (!FileUtil.d((String)localObject2)) {
      return DrawRedbagMsgUtils.f;
    }
    localObject3 = a(this.e);
    this.j = localObject3.length;
    if (!ScribbleUtils.a((byte[])localObject3, (String)localObject2, (String)localObject1)) {
      return DrawRedbagMsgUtils.c;
    }
    localObject3 = ScribbleUtils.b((String)localObject1);
    if (TextUtils.isEmpty((CharSequence)localObject3)) {
      return DrawRedbagMsgUtils.d;
    }
    this.f = ((String)localObject3);
    this.g = DrawRedbagMsgUtils.a(this.f);
    this.h = DrawRedbagMsgUtils.b(this.f);
    if (!ScribbleUtils.a((String)localObject1, this.g).booleanValue()) {
      return DrawRedbagMsgUtils.c;
    }
    if (!ScribbleUtils.a((String)localObject2, this.h).booleanValue()) {
      return DrawRedbagMsgUtils.c;
    }
    FileUtil.e((String)localObject1);
    FileUtil.e((String)localObject2);
    return DrawRedbagMsgUtils.b;
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
    if (paramInteger.intValue() == DrawRedbagMsgUtils.b)
    {
      localObject1 = new ScribbleBaseOperator(this.a);
      localObject2 = ((ScribbleBaseOperator)localObject1).a(this.g, this.f, this.j, this.c, this.d, this.i);
      ((MessageForScribble)localObject2).mExistInfo.mCombineFileExist = true;
      ((MessageForScribble)localObject2).mExistInfo.mDataFileExist = true;
      ((MessageForScribble)localObject2).mExistInfo.mLocalPathExist = true;
      ((MessageForScribble)localObject2).mExistInfo.mInit = true;
      ((ScribbleBaseOperator)localObject1).a((MessageForScribble)localObject2);
    }
    localObject1 = this.b;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawRedbagMsgUtils.SendAfterCombinePicAndDataTask
 * JD-Core Version:    0.7.0.1
 */