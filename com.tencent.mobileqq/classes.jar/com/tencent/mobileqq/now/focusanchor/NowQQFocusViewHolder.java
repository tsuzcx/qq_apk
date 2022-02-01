package com.tencent.mobileqq.now.focusanchor;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.now.RecyclerHolder;
import com.tencent.mobileqq.now.focusanchor.commonwidget.RecyclerItemClickListener;
import com.tencent.mobileqq.now.widget.CircleImageView;
import com.tencent.mobileqq.now.widget.SpacesItemDecoration;

public class NowQQFocusViewHolder
  extends RecyclerHolder
{
  private final int jdField_a_of_type_Int = 1000;
  private long jdField_a_of_type_Long;
  public RecyclerView a;
  public View a;
  public TextView a;
  public CircleImageView a;
  public TextView b;
  
  public NowQQFocusViewHolder(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqNowWidgetCircleImageView = ((CircleImageView)paramView.findViewById(2131363215));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380475));
    this.b = ((TextView)paramView.findViewById(2131380363));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131367268));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370561);
    int i = -1;
    if (paramView.getContext() != null) {
      i = paramView.getContext().getResources().getDimensionPixelSize(2131298904);
    }
    if (i > 0) {}
    for (;;)
    {
      SpacesItemDecoration localSpacesItemDecoration = new SpacesItemDecoration(i);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(localSpacesItemDecoration);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new NowQQFocusViewHolder.1(this));
      if ((paramView.getContext() instanceof Activity))
      {
        paramView = (Activity)paramView.getContext();
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(paramView, new NowQQFocusViewHolder.2(this, paramView)));
      }
      return;
      i = 25;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.focusanchor.NowQQFocusViewHolder
 * JD-Core Version:    0.7.0.1
 */