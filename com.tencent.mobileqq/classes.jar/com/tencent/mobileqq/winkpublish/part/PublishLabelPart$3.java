package com.tencent.mobileqq.winkpublish.part;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

class PublishLabelPart$3
  implements PublishLabelPart.OnMyItemClickListener
{
  PublishLabelPart$3(PublishLabelPart paramPublishLabelPart) {}
  
  public void a(RecyclerView paramRecyclerView, View paramView, int paramInt, String paramString)
  {
    if ((paramView instanceof TextView))
    {
      PublishLabelPart.b(this.a).a(paramInt);
      paramRecyclerView = this.a;
      paramString = new StringBuilder();
      paramString.append("#");
      paramString.append(((TextView)paramView).getText().toString());
      PublishLabelPart.a(paramRecyclerView, paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishLabelPart.3
 * JD-Core Version:    0.7.0.1
 */