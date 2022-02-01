package com.tencent.mobileqq.kandian.biz.comment.msgboard;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/comment/msgboard/RIJMessageBoardNetHandler$sendRequest$1", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "onError", "", "errorCode", "", "errorMsg", "", "bundle", "Landroid/os/Bundle;", "onResult", "", "data", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJMessageBoardNetHandler$sendRequest$1
  extends ProtoUtils.TroopProtocolObserver
{
  RIJMessageBoardNetHandler$sendRequest$1(Function3 paramFunction3) {}
  
  public boolean onError(int paramInt, @Nullable String paramString, @Nullable Bundle paramBundle)
  {
    paramBundle = new StringBuilder();
    paramBundle.append("#onError: errorCode=");
    paramBundle.append(paramInt);
    paramBundle.append(", errorMsg=");
    paramBundle.append(paramString);
    QLog.d("RIJMessageBoardNetHandler", 1, paramBundle.toString());
    paramBundle = this.a;
    if (paramBundle != null) {
      paramString = (Unit)paramBundle.invoke(Integer.valueOf(paramInt), paramString, null);
    }
    return true;
  }
  
  public void onResult(int paramInt, @Nullable byte[] paramArrayOfByte, @Nullable Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      QLog.d("RIJMessageBoardNetHandler", 1, "#onResult: success");
      paramBundle = this.a;
      if (paramBundle != null) {
        paramArrayOfByte = (Unit)paramBundle.invoke(Integer.valueOf(paramInt), null, RIJMessageBoardNetHandler.a(RIJMessageBoardNetHandler.a, paramArrayOfByte));
      }
    }
    else
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("#onResult: fail, errorCode=");
      paramArrayOfByte.append(paramInt);
      QLog.d("RIJMessageBoardNetHandler", 1, paramArrayOfByte.toString());
      paramArrayOfByte = this.a;
      if (paramArrayOfByte != null) {
        paramArrayOfByte = (Unit)paramArrayOfByte.invoke(Integer.valueOf(paramInt), null, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.msgboard.RIJMessageBoardNetHandler.sendRequest.1
 * JD-Core Version:    0.7.0.1
 */