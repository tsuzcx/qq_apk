package com.tencent.mobileqq.vip.lianghao.view;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.IDialogView;
import com.tencent.mobileqq.vip.lianghao.data.LiangHaoUinData;

public class LiangHaoDialog
  implements DialogUtil.IDialogView
{
  private Dialog a;
  
  public Dialog a(Context paramContext, LiangHaoUinData paramLiangHaoUinData, View.OnClickListener paramOnClickListener)
  {
    this.a = DialogUtil.a(paramContext, 2131693653, this, paramLiangHaoUinData, 2131690800, 2131693651, new LiangHaoDialog.1(this), paramOnClickListener, false, false);
    return this.a;
  }
  
  public View a(Context paramContext, Object paramObject)
  {
    paramContext = new LiangHaoDialogView(paramContext);
    paramContext.a((LiangHaoUinData)paramObject);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.view.LiangHaoDialog
 * JD-Core Version:    0.7.0.1
 */