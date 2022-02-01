package com.tencent.mobileqq.tablequery;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class TableQueryViewer$1
  implements AdapterView.OnItemLongClickListener
{
  TableQueryViewer$1(TableQueryViewer paramTableQueryViewer, Context paramContext) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((QueryData)TableQueryViewer.a(this.b).get(paramInt)).b;
    paramView = (ClipboardManager)paramView.getContext().getSystemService("clipboard");
    if ((paramView != null) && (!TextUtils.isEmpty(paramAdapterView)))
    {
      paramAdapterView = ClipData.newPlainText("bigT", paramAdapterView);
      ClipboardMonitor.setPrimaryClip(paramView, paramAdapterView);
      paramView.setPrimaryClip(paramAdapterView);
      QQToast.makeText(this.b.getContext(), this.a.getString(2131887548), 0).show();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.tablequery.TableQueryViewer.1
 * JD-Core Version:    0.7.0.1
 */