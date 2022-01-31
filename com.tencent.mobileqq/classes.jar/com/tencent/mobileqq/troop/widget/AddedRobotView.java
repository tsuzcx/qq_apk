package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import azkr;
import azls;
import azlt;
import azlu;
import azwg;
import azwh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AddedRobotView
  extends LinearLayout
{
  private Context jdField_a_of_type_AndroidContentContext;
  private GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  private RecyclerView.OnScrollListener jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener = new azlt(this);
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private azlu jdField_a_of_type_Azlu;
  private azwg jdField_a_of_type_Azwg;
  private azwh jdField_a_of_type_Azwh = new azls(this);
  private String jdField_a_of_type_JavaLangString;
  private TextView b;
  
  public AddedRobotView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AddedRobotView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AddedRobotView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setOrientation(1);
    paramContext = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    setBackgroundResource(2130849077);
    paramContext = paramContext.inflate(2131495562, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131303424));
    this.b = ((TextView)paramContext.findViewById(2131309499));
    addView(paramContext);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = new RecyclerView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(this.jdField_a_of_type_AndroidContentContext, 5);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutParams(paramContext);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOverScrollMode(2);
    addView(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    paramContext = new TextView(this.jdField_a_of_type_AndroidContentContext);
    paramContext.setText(getResources().getString(2131628986));
    paramContext.setTextSize(2, 14.0F);
    paramContext.setTextColor(getResources().getColor(2131101333));
    paramContext.setContentDescription(getResources().getString(2131628986));
    paramContext.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130849077);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131167557));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramContext);
    addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    paramContext = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    paramContext.setBackgroundResource(2130838503);
    paramContext.setLayoutParams(new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131167558)));
    addView(paramContext);
    this.jdField_a_of_type_Azwg = new azwg((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_Azwg.a(this.jdField_a_of_type_Azwh);
    this.jdField_a_of_type_Azlu = new azlu(this, this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Azlu);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
  }
  
  public void a()
  {
    QLog.i("AddedRobotView", 1, "onDestroy.");
    if (this.jdField_a_of_type_Azwg != null) {
      this.jdField_a_of_type_Azwg.d();
    }
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void setAddList(ArrayList<azkr> paramArrayList, int paramInt, String paramString)
  {
    if (this.b != null) {
      if (paramArrayList == null) {
        break label214;
      }
    }
    label214:
    for (int i = paramArrayList.size();; i = 0)
    {
      String str = i + "/" + paramInt;
      this.b.setText(str);
      this.b.setVisibility(0);
      this.b.setContentDescription(str);
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getText(2131624231));
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getText(2131624231));
      }
      if ((paramArrayList == null) || (paramArrayList.size() == 0))
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
        QLog.d("AddedRobotView", 2, "setAddList 0");
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaLangString = paramString;
        return;
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
        this.jdField_a_of_type_Azlu.a(paramArrayList);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        QLog.d("AddedRobotView", 2, "setAddList " + paramArrayList.size());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AddedRobotView
 * JD-Core Version:    0.7.0.1
 */