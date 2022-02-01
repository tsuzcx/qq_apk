package com.tencent.mobileqq.writetogether.websocket.msg;

import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class WriteTogetherDecodeFactory
{
  private static final String TAG = "WriteTogether.WriteTogetherDecodeFactory";
  
  @Nullable
  public BaseWriteTogetherMsg decode(String paramString1, String paramString2)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = localObject3;
    try
    {
      localType = BaseWriteTogetherMsg.optTypeFromJson(paramString1);
      localObject2 = localObject3;
      if (QLog.isColorLevel())
      {
        localObject2 = localObject3;
        localStringBuilder = new StringBuilder();
        localObject2 = localObject3;
        localStringBuilder.append("decode start, type = ");
        localObject2 = localObject3;
        localStringBuilder.append(localType);
        localObject2 = localObject3;
        QLog.d("WriteTogether.WriteTogetherDecodeFactory", 2, localStringBuilder.toString());
      }
      localObject2 = localObject3;
      switch (WriteTogetherDecodeFactory.1.$SwitchMap$com$tencent$mobileqq$writetogether$websocket$msg$Type[localType.ordinal()])
      {
      case 9: 
        localObject2 = localObject3;
        localObject1 = new CommitErrorMsg();
      }
    }
    catch (RuntimeException paramString1)
    {
      Type localType;
      StringBuilder localStringBuilder;
      QLog.e("WriteTogether.WriteTogetherDecodeFactory", 1, paramString1, new Object[0]);
    }
    localObject2 = localObject3;
    localObject1 = new CursorMessageRspMsg();
    break label363;
    localObject2 = localObject3;
    localObject1 = new UserLeaveMsg();
    break label363;
    localObject2 = localObject3;
    localObject1 = new NewChangesMsg();
    break label363;
    localObject2 = localObject3;
    localObject1 = new AcceptCommitMsg();
    break label363;
    localObject2 = localObject3;
    localObject1 = new UserChangesRespMsg();
    break label363;
    localObject2 = localObject3;
    localObject1 = new LastReversionMsg();
    break label363;
    localObject2 = localObject3;
    localObject1 = new UserNewInfoMsg();
    break label363;
    localObject2 = localObject3;
    localObject1 = new ClientReadyRespMsg();
    break label363;
    localObject2 = localObject3;
    localStringBuilder = new StringBuilder();
    localObject2 = localObject3;
    localStringBuilder.append("decode has no handle, type = ");
    localObject2 = localObject3;
    localStringBuilder.append(localType);
    localObject2 = localObject3;
    QLog.d("WriteTogether.WriteTogetherDecodeFactory", 1, localStringBuilder.toString());
    label363:
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        ((BaseWriteTogetherMsg)localObject1).fromJson(paramString1, paramString2);
        return localObject1;
      }
      return localObject2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.msg.WriteTogetherDecodeFactory
 * JD-Core Version:    0.7.0.1
 */