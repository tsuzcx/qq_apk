package com.tencent.mobileqq.colornote.list;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.colornote.anim.FloatingWindowDrawable;
import com.tencent.mobileqq.colornote.anim.MusicDanceDrawable;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ColorNoteListAdapter$ViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public View a;
  public Button a;
  public ImageView a;
  public TextView a;
  ColorNoteListAdapter.DeleteListener jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter$DeleteListener;
  ColorNoteListAdapter jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter;
  public View b;
  public TextView b;
  
  public ColorNoteListAdapter$ViewHolder(ColorNoteListAdapter paramColorNoteListAdapter, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter = paramColorNoteListAdapter;
    Resources localResources = paramView.getContext().getResources();
    paramView.setOnClickListener(this);
    View localView1 = paramView.findViewById(2131371971);
    int j = 0;
    AccessibilityUtil.a(localView1, false);
    localView1.setOnClickListener(this);
    View localView2 = paramView.findViewById(2131371972);
    AccessibilityUtil.a(localView2, false);
    localView2.setOnClickListener(this);
    int i;
    if (ColorNoteListAdapter.a(paramColorNoteListAdapter)) {
      i = 8;
    } else {
      i = 0;
    }
    localView1.setVisibility(i);
    if (ColorNoteListAdapter.a(paramColorNoteListAdapter)) {
      i = j;
    } else {
      i = 8;
    }
    localView2.setVisibility(i);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131371964);
    this.jdField_a_of_type_AndroidViewView.setContentDescription(localResources.getString(2131690907));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131371961);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371965));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371975));
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(Utils.a(3.0F, localResources));
    this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setFocusableInTouchMode(true);
    AccessibilityUtil.a(this.jdField_a_of_type_AndroidWidgetTextView, true);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371973));
    this.jdField_b_of_type_AndroidWidgetTextView.setFocusable(true);
    this.jdField_b_of_type_AndroidWidgetTextView.setFocusableInTouchMode(true);
    AccessibilityUtil.a(this.jdField_b_of_type_AndroidWidgetTextView, true);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131371966));
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter$DeleteListener = new ColorNoteListAdapter.DeleteListener(paramColorNoteListAdapter, this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter$DeleteListener);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new ColorNoteListAdapter.OnItemClickListener(paramColorNoteListAdapter, this));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new MusicDanceDrawable();
    ((FloatingWindowDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).a(paramView.getContext(), Utils.a(15.0F, localResources), Utils.a(9.5F, localResources));
  }
  
  public ColorNote a(int paramInt)
  {
    return (ColorNote)ColorNoteListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter).get(paramInt);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (((i == 2131371971) || (i == 2131371972)) && (ColorNoteListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter) != null))
    {
      ColorNoteListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter).b();
      ReportController.b(null, "dc00898", "", "", "0X800A6CE", "0X800A6CE", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.ColorNoteListAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */