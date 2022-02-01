package com.tencent.mobileqq.scribble.impl;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForScribble.FileExistInfo;
import com.tencent.mobileqq.scribble.IScribbleMsgUtils;
import com.tencent.mobileqq.scribble.IScribbleMsgUtils.CombineCallback;
import com.tencent.mobileqq.scribble.ScribbleBaseOperator;
import com.tencent.mobileqq.scribble.ScribbleMsgConstants;
import com.tencent.mobileqq.scribble.ScribbleUtils;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ScribbleMsgUtilsImpl
  implements IScribbleMsgUtils
{
  public static final String TAG = "ScribbleMsgUtilsImpl";
  
  private static String getScribbleCombineFile(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ScribbleMsgConstants.a());
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private static String getScribbleDataFilePath(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ScribbleMsgConstants.a());
      localStringBuilder.append(paramString);
      localStringBuilder.append("_data");
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public boolean ReSendScribbleMsgRecord(AppRuntime paramAppRuntime, MessageForScribble paramMessageForScribble)
  {
    if (paramMessageForScribble == null) {
      return false;
    }
    if (paramMessageForScribble.isSendFromLocal()) {
      ((ITransFileController)paramAppRuntime.getRuntimeService(ITransFileController.class, "")).removeProcessor(BaseTransFileController.makeKey(paramMessageForScribble.frienduin, paramMessageForScribble.uniseq));
    }
    ScribbleBaseOperator localScribbleBaseOperator = new ScribbleBaseOperator(paramAppRuntime);
    MessageForScribble localMessageForScribble = localScribbleBaseOperator.a(paramMessageForScribble);
    if (localMessageForScribble == null) {
      return false;
    }
    ThreadManager.post(new ScribbleMsgUtilsImpl.1(this, paramAppRuntime, paramMessageForScribble), 5, null, false);
    localScribbleBaseOperator.b(localMessageForScribble);
    return true;
  }
  
  protected void ScribbleFileDirUtilsCheck()
  {
    File localFile = new File(ScribbleMsgConstants.a());
    if (((localFile.exists()) && (!localFile.isDirectory())) || (!localFile.exists())) {
      localFile.mkdirs();
    }
  }
  
  public void SendScribbleMsg(AppRuntime paramAppRuntime, String paramString, int paramInt1, Bitmap paramBitmap, int paramInt2, IScribbleMsgUtils.CombineCallback paramCombineCallback)
  {
    ScribbleFileDirUtilsCheck();
    new ScribbleMsgUtilsImpl.SendAfterCombinePicAndDataTask(paramAppRuntime, paramString, paramInt1, paramBitmap, paramInt2, paramCombineCallback).execute(new Void[0]);
  }
  
  public boolean downloadScribble(MessageForScribble paramMessageForScribble)
  {
    return new ScribbleBaseOperator(MobileQQ.sMobileQQ.waitAppRuntime(null)).a(paramMessageForScribble, null);
  }
  
  public String getScribbleCombineFile(MessageForScribble paramMessageForScribble)
  {
    if ((paramMessageForScribble != null) && (!TextUtils.isEmpty(paramMessageForScribble.combineFileMd5))) {
      return getScribbleCombineFile(paramMessageForScribble.combineFileMd5);
    }
    return "";
  }
  
  public byte[] getScribbleDataByte(MessageForScribble paramMessageForScribble)
  {
    return ScribbleUtils.a(getScribbleDataFilePath(paramMessageForScribble));
  }
  
  public String getScribbleDataFilePath(MessageForScribble paramMessageForScribble)
  {
    if ((paramMessageForScribble != null) && (!TextUtils.isEmpty(paramMessageForScribble.combineFileMd5))) {
      return getScribbleDataFilePath(paramMessageForScribble.combineFileMd5);
    }
    return "";
  }
  
  public int getScribbleDataReadyState(MessageForScribble paramMessageForScribble)
  {
    boolean bool1 = paramMessageForScribble.mExistInfo.mDataFileExist;
    if (!paramMessageForScribble.mExistInfo.mInit) {
      bool1 = FileUtils.fileExists(getScribbleDataFilePath(paramMessageForScribble));
    }
    boolean bool2 = paramMessageForScribble.mExistInfo.mCombineFileExist;
    if (!paramMessageForScribble.mExistInfo.mInit) {
      bool2 = FileUtils.fileExists(getScribbleCombineFile(paramMessageForScribble));
    }
    if ((bool1) && (bool2)) {
      return ScribbleMsgConstants.c;
    }
    if ((!bool1) && (bool2)) {
      return ScribbleMsgConstants.b;
    }
    return ScribbleMsgConstants.a;
  }
  
  public int splitPureDataFromCombineFile(MessageForScribble paramMessageForScribble)
  {
    if ((paramMessageForScribble != null) && (paramMessageForScribble.combineFileMd5 != null))
    {
      Object localObject = getScribbleCombineFile(paramMessageForScribble);
      if (!FileUtils.fileExists((String)localObject)) {
        return ScribbleMsgConstants.i;
      }
      long l = FileUtils.getFileSizes((String)localObject);
      if ((paramMessageForScribble.offSet > 0) && (paramMessageForScribble.offSet < (int)l))
      {
        String str = getScribbleDataFilePath(paramMessageForScribble);
        if (FileUtils.fileExists(str)) {
          FileUtils.deleteFile(str);
        }
        if (ScribbleUtils.a((String)localObject, paramMessageForScribble.offSet, str)) {
          return ScribbleMsgConstants.d;
        }
        return ScribbleMsgConstants.e;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" offSet = ");
      ((StringBuilder)localObject).append(paramMessageForScribble.offSet);
      ((StringBuilder)localObject).append(" FileSize : ");
      ((StringBuilder)localObject).append(l);
      QLog.e("ScribbleMsgUtilsImpl", 2, ((StringBuilder)localObject).toString());
      return ScribbleMsgConstants.j;
    }
    return ScribbleMsgConstants.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.impl.ScribbleMsgUtilsImpl
 * JD-Core Version:    0.7.0.1
 */