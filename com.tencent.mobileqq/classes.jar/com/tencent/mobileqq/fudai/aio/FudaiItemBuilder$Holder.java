package com.tencent.mobileqq.fudai.aio;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.data.MessageForFuDai;
import com.tencent.mobileqq.widget.FilterRelativeLayout;

public class FudaiItemBuilder$Holder
  extends BaseBubbleBuilder.ViewHolder
{
  private FilterRelativeLayout a;
  private ImageView b;
  private ImageView c;
  private ImageView d;
  private ImageView e;
  private TextView f;
  private TextView g;
  private int s;
  
  private void a(View paramView)
  {
    this.a = ((FilterRelativeLayout)paramView.findViewById(2131433894));
    this.b = ((ImageView)paramView.findViewById(2131433889));
    this.c = ((ImageView)paramView.findViewById(2131433892));
    this.d = ((ImageView)paramView.findViewById(2131433893));
    this.e = ((ImageView)paramView.findViewById(2131433890));
    this.f = ((TextView)paramView.findViewById(2131433895));
    this.g = ((TextView)paramView.findViewById(2131433896));
  }
  
  private void a(MessageForFuDai paramMessageForFuDai)
  {
    this.s = paramMessageForFuDai.themeId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fudai.aio.FudaiItemBuilder.Holder
 * JD-Core Version:    0.7.0.1
 */