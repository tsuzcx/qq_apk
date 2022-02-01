package com.tencent.mobileqq.guild.mainframe.joinchannel;

import android.content.Context;
import android.content.res.Resources;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.base.BaseGuildViewModel.ToastEvent;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.QLog;

class JoinChannelViewModel$1
  implements IResultWithSecurityCallback
{
  JoinChannelViewModel$1(JoinChannelViewModel paramJoinChannelViewModel, Context paramContext) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    Integer localInteger = Integer.valueOf(2);
    QLog.d("JoinChannelViewModel", 1, new Object[] { "addGuildWithOption, result=", Integer.valueOf(paramInt), ", errMsg=", paramString, ",security:", paramIGProSecurityResult });
    switch (paramInt)
    {
    default: 
      JoinChannelViewModel.a(this.b).setValue(localInteger);
      if (JoinChannelViewModel.b(this.b) != null) {
        break label348;
      }
      if (paramInt != 0) {
        this.b.a.setValue(new BaseGuildViewModel.ToastEvent(paramInt, this.a.getResources().getString(2131890217)));
      }
      break;
    case 22009: 
    case 22010: 
      this.b.a.setValue(new BaseGuildViewModel.ToastEvent(0, this.a.getResources().getString(2131890390)));
      JoinChannelViewModel.a(this.b).setValue(Integer.valueOf(1));
      return;
    case 22008: 
      JoinChannelViewModel.a(this.b).setValue(localInteger);
      this.b.a.setValue(new BaseGuildViewModel.ToastEvent(paramInt, this.a.getResources().getString(2131890389)));
      JoinChannelViewModel.a(this.b, paramInt, paramString, null);
      return;
    case 22007: 
      this.b.a.setValue(new BaseGuildViewModel.ToastEvent(-1, this.a.getResources().getString(2131890391)));
      JoinChannelViewModel.a(this.b).setValue(Integer.valueOf(0));
      return;
    case 22006: 
      JoinChannelViewModel.a(this.b).setValue(localInteger);
      this.b.a.setValue(new BaseGuildViewModel.ToastEvent(paramInt, this.a.getResources().getString(2131890393)));
      JoinChannelViewModel.a(this.b, paramInt, paramString, null);
      return;
    }
    QLog.w("JoinChannelViewModel", 1, "handleResult callback is null");
    return;
    label348:
    JoinChannelViewModel.a(this.b, paramInt, paramString, paramIGProSecurityResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.joinchannel.JoinChannelViewModel.1
 * JD-Core Version:    0.7.0.1
 */