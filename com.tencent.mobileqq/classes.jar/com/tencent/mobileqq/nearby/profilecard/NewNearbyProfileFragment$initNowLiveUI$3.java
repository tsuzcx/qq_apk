package com.tencent.mobileqq.nearby.profilecard;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class NewNearbyProfileFragment$initNowLiveUI$3
  implements View.OnClickListener
{
  NewNearbyProfileFragment$initNowLiveUI$3(NewNearbyProfileFragment paramNewNearbyProfileFragment, String paramString) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.b;
    Intrinsics.checkExpressionValueIsNotNull(paramView, "jumpUrl");
    if (StringsKt.startsWith$default(paramView, "mqqapi:", false, 2, null))
    {
      paramView = JumpParser.a((BaseQQAppInterface)this.a.c.app, this.a.getContext(), this.b);
      if (paramView == null)
      {
        paramView = new StringBuilder();
        paramView.append("null jumpAction, url=");
        paramView.append(this.b);
        QLog.e("NewNearbyProfileFragmen", 1, paramView.toString());
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("jumpAction, url=");
      localStringBuilder.append(this.b);
      QLog.i("NewNearbyProfileFragmen", 1, localStringBuilder.toString());
      paramView.a();
      return;
    }
    paramView = new StringBuilder();
    paramView.append("go to QQBrowserActivity, url=");
    paramView.append(this.b);
    QLog.i("NewNearbyProfileFragmen", 1, paramView.toString());
    paramView = new Intent(this.a.getContext(), QQBrowserActivity.class);
    paramView.putExtra("url", this.b);
    this.a.c.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NewNearbyProfileFragment.initNowLiveUI.3
 * JD-Core Version:    0.7.0.1
 */