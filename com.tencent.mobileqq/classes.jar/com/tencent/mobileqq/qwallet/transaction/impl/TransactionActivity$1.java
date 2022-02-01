package com.tencent.mobileqq.qwallet.transaction.impl;

import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.utils.StringUtil;
import cooperation.qwallet.QwTextAdapter;
import cooperation.qwallet.QwUtils;

class TransactionActivity$1
  extends QwTextAdapter
{
  TransactionActivity$1(TransactionActivity paramTransactionActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramEditable.toString())) && (QwUtils.a(paramEditable.toString()) > 0.0F)) {
        TransactionActivity.access$000(this.a).setEnabled(true);
      } else {
        TransactionActivity.access$000(this.a).setEnabled(false);
      }
      float f = Float.parseFloat(paramEditable.toString());
      int i = TransactionActivity.access$100(this.a).getText().length();
      paramEditable = TransactionActivity.access$200(this.a, f);
      if (StringUtil.isEmpty(paramEditable))
      {
        TransactionActivity.access$300(this.a).setVisibility(0);
        TransactionActivity.access$400(this.a).setVisibility(8);
        TransactionActivity.access$500(this.a).setVisibility(8);
      }
      else
      {
        TransactionActivity.access$300(this.a).setVisibility(8);
        TransactionActivity.access$400(this.a).setVisibility(0);
        TransactionActivity.access$500(this.a).setVisibility(0);
        TransactionActivity.access$500(this.a).setText(paramEditable);
      }
      if ((i > 0) && (!TransactionActivity.access$100(this.a).getText().toString().startsWith(".")) && (!TransactionActivity.access$100(this.a).getText().toString().endsWith(".")) && (TransactionActivity.access$600(this.a, TransactionActivity.access$100(this.a).getText().toString())))
      {
        if ((TransactionActivity.access$700(this.a) > 0) && (!TextUtils.isEmpty(TransactionActivity.access$800(this.a))) && (f * 100.0F >= TransactionActivity.access$700(this.a)) && (!TextUtils.isEmpty(TransactionActivity.access$800(this.a)))) {
          this.a.showToast(TransactionActivity.access$800(this.a));
        }
        if (!TransactionActivity.access$000(this.a).isEnabled())
        {
          TransactionActivity.access$000(this.a).setEnabled(true);
          this.a.addUploadData(TransactionActivity.access$900(this.a), 128, "transfer.amount.enable", "", "", TransactionActivity.access$1000(this.a), "");
        }
      }
      else if (TransactionActivity.access$000(this.a).isEnabled())
      {
        TransactionActivity.access$000(this.a).setEnabled(false);
        this.a.addUploadData(TransactionActivity.access$900(this.a), 128, "transfer.amount.disable", "", "", TransactionActivity.access$1000(this.a), "");
        return;
      }
    }
    catch (Exception paramEditable)
    {
      paramEditable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.transaction.impl.TransactionActivity.1
 * JD-Core Version:    0.7.0.1
 */