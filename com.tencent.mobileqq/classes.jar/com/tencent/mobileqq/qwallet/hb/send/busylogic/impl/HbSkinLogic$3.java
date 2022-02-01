package com.tencent.mobileqq.qwallet.hb.send.busylogic.impl;

import Wallet.PopDialog;
import Wallet.SkinInfo;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView<*>;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.utils.DialogUtil;
import cooperation.qwallet.plugin.QwAdapter;
import java.util.List;

class HbSkinLogic$3
  implements AdapterView.OnItemClickListener
{
  HbSkinLogic$3(HbSkinLogic paramHbSkinLogic) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = HbSkinLogic.a(this.a).getList();
    Object localObject2 = (HbSkinInfo)paramAdapterView.get(paramInt);
    if (0L != ((HbSkinInfo)localObject2).a.skin_permission_state)
    {
      HbSkinInfo.c = ((HbSkinInfo)paramAdapterView.get(paramInt)).a.skin_id;
      HbSkinLogic.a(this.a).notifyDataSetChanged();
      return;
    }
    String str1 = ((HbSkinInfo)localObject2).a.pop_dialog.dialog_title;
    String str2 = ((HbSkinInfo)localObject2).a.pop_dialog.dialog_tips;
    Object localObject1 = ((HbSkinInfo)localObject2).a.pop_dialog.left_tips;
    paramView = ((HbSkinInfo)localObject2).a.pop_dialog.right_tips;
    paramAdapterView = (AdapterView<?>)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramAdapterView = null;
    }
    if (TextUtils.isEmpty(paramView)) {
      paramView = null;
    }
    localObject1 = paramAdapterView;
    if (paramAdapterView == null)
    {
      localObject1 = paramAdapterView;
      if (paramView == null) {
        localObject1 = HardCodeUtil.a(R.string.aR);
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramAdapterView = null;
    } else {
      paramAdapterView = new HbSkinLogic.3.1(this, (HbSkinInfo)localObject2);
    }
    if (TextUtils.isEmpty(paramView)) {
      localObject2 = null;
    } else {
      localObject2 = new HbSkinLogic.3.2(this, (HbSkinInfo)localObject2);
    }
    paramAdapterView = DialogUtil.a(HbSkinLogic.a(this.a), 230, str1, str2, (String)localObject1, paramView, (DialogInterface.OnClickListener)localObject2, paramAdapterView);
    paramAdapterView.setCancelable(false);
    paramAdapterView.setCanceledOnTouchOutside(false);
    paramAdapterView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.HbSkinLogic.3
 * JD-Core Version:    0.7.0.1
 */