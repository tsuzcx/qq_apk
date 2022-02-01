package com.tencent.mobileqq.kandian.biz.ugc;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyNinePicDeliverDynamicGridView;
import java.util.List;

class ReadInJoyDeliverUGCActivity$3
  implements AdapterView.OnItemLongClickListener
{
  ReadInJoyDeliverUGCActivity$3(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!ReadInJoyDeliverUGCActivity.b(this.a).b().get(paramInt).equals(ReadInJoyDeliverUGCActivity.a(this.a))) {
      ReadInJoyDeliverUGCActivity.c(this.a).a(paramInt);
    }
    ReadInJoyDeliverUGCActivity.a(this.a, false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverUGCActivity.3
 * JD-Core Version:    0.7.0.1
 */