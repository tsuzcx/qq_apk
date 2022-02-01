package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.writetogether.WriteTogetherOidbObserver;
import java.util.Arrays;

class ForwardBaseOption$4
  extends WriteTogetherOidbObserver
{
  ForwardBaseOption$4(ForwardBaseOption paramForwardBaseOption, boolean[] paramArrayOfBoolean, String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt, int paramInt) {}
  
  public void a(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    super.a(paramInt, paramBoolean, paramArrayOfObject);
    ForwardBaseOption.f(this.f);
    if (!paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSentMessage() called with: type = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], result = [");
      localStringBuilder.append(paramArrayOfObject[1]);
      localStringBuilder.append("], isExpiredMessage: ");
      localStringBuilder.append(Arrays.toString(ForwardBaseOption.g(this.f)));
      localStringBuilder.append(" padId: ");
      localStringBuilder.append(Arrays.toString((Object[])paramArrayOfObject[0]));
      Log.d("onSentMessage", localStringBuilder.toString());
      if (((Integer)paramArrayOfObject[1]).intValue() == 505)
      {
        paramArrayOfObject = (String[])paramArrayOfObject[0];
        paramInt = 0;
        while (paramInt < this.a.length)
        {
          if ((this.b[paramInt].equals(paramArrayOfObject[0])) && (this.c[paramInt].equals(paramArrayOfObject[1])) && (this.d[paramInt] == Integer.parseInt(paramArrayOfObject[2]))) {
            ForwardBaseOption.g(this.f)[paramInt] = 1;
          }
          paramInt += 1;
        }
      }
      QQToast.makeText(this.f.s, "发送失败，请稍后重试。", 0).show();
      paramArrayOfObject = this.f;
      paramArrayOfObject.Z = 0;
      paramArrayOfObject.q.removeObserver(this);
      return;
    }
    this.f.s.setResult(15);
    paramArrayOfObject = this.f;
    paramInt = paramArrayOfObject.Z + 1;
    paramArrayOfObject.Z = paramInt;
    if (paramInt == this.e)
    {
      this.f.t.putBooleanArray("forward_write_together_is_expired", ForwardBaseOption.g(this.f));
      this.f.q.removeObserver(this);
      if (this.f.K())
      {
        ForwardBaseOption.b(this.f);
        return;
      }
      this.f.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardBaseOption.4
 * JD-Core Version:    0.7.0.1
 */