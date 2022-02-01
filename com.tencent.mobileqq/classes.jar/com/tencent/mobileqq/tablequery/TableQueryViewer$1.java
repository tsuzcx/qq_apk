package com.tencent.mobileqq.tablequery;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class TableQueryViewer$1
  implements AdapterView.OnItemLongClickListener
{
  TableQueryViewer$1(TableQueryViewer paramTableQueryViewer, Context paramContext) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((QueryData)TableQueryViewer.a(this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer).get(paramInt)).b;
    paramView = (ClipboardManager)paramView.getContext().getSystemService("clipboard");
    if ((paramView != null) && (!TextUtils.isEmpty(paramAdapterView)))
    {
      paramView.setPrimaryClip(ClipData.newPlainText("bigT", paramAdapterView));
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer.getContext(), this.jdField_a_of_type_AndroidContentContext.getString(2131690709), 0).a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tablequery.TableQueryViewer.1
 * JD-Core Version:    0.7.0.1
 */