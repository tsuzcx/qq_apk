package com.tencent.mobileqq.guild.privatechannel.ext;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;

class GuildPrivateAddMemberFragment$2$1
  implements IResultWithSecurityCallback
{
  GuildPrivateAddMemberFragment$2$1(GuildPrivateAddMemberFragment.2 param2, String[] paramArrayOfString) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if ((paramInt != 0) || (!QQGuildUtil.a(paramIGProSecurityResult))) {
      QQGuildUtil.a(this.b.a.getActivity(), paramInt, paramString, paramIGProSecurityResult);
    }
    if ((paramInt == 0) && (QQGuildUtil.a(paramIGProSecurityResult)))
    {
      paramString = new Intent();
      paramString.putExtra("select_member_list", this.a);
      paramString.putExtra("select_member_info_list", this.b.a.p.getSelectedUIDataList());
      this.b.a.getActivity().setResult(-1, paramString);
      this.b.a.getActivity().finish();
      return;
    }
    if (((paramInt == 10006) || (paramInt == 10000)) && (this.b.a.getActivity() != null))
    {
      this.b.a.getActivity().setResult(10006);
      this.b.a.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.ext.GuildPrivateAddMemberFragment.2.1
 * JD-Core Version:    0.7.0.1
 */