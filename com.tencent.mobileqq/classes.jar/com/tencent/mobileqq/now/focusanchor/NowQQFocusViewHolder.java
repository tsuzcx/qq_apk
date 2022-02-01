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
    this.jdField_a_of_type_ComTencentMobileqqNowWidgetCircleImageView = ((CircleImageView)paramView.findViewById(2131363154));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379778));
    this.b = ((TextView)paramView.findViewById(2131379683));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131367051));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370219);
    int i;
    if (paramView.getContext() != null) {
      i = paramView.getContext().getResources().getDimensionPixelSize(2131298908);
    } else {
      i = -1;
    }
    if (i <= 0) {
      i = 25;
    }
    SpacesItemDecoration localSpacesItemDecoration = new SpacesItemDecoration(i);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(localSpacesItemDecoration);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new NowQQFocusViewHolder.1(this));
    if ((paramView.getContext() instanceof Activity))
    {
      paramView = (Activity)paramView.getContext();
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(paramView, new NowQQFocusViewHolder.2(this, paramView)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.focusanchor.NowQQFocusViewHolder
 * JD-Core Version:    0.7.0.1
 */