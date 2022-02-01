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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.troop.utils.TroopRobotInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AddedRobotView
  extends LinearLayout
{
  private Context jdField_a_of_type_AndroidContentContext;
  private GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  private RecyclerView.OnScrollListener jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener = new AddedRobotView.2(this);
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener = new AddedRobotView.1(this);
  private AddedRobotView.RobotListAdapter jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView$RobotListAdapter;
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
    setBackgroundResource(2130850857);
    paramContext = paramContext.inflate(2131561689, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131370257));
    this.b = ((TextView)paramContext.findViewById(2131377058));
    addView(paramContext);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = new RecyclerView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(this.jdField_a_of_type_AndroidContentContext, 5);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutParams(paramContext);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOverScrollMode(2);
    addView(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    paramContext = new TextView(this.jdField_a_of_type_AndroidContentContext);
    paramContext.setText(getResources().getString(2131694498));
    paramContext.setTextSize(2, 14.0F);
    paramContext.setTextColor(getResources().getColor(2131167113));
    paramContext.setContentDescription(getResources().getString(2131694498));
    paramContext.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850857);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131298930));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramContext);
    addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    paramContext = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    paramContext.setBackgroundResource(2130838979);
    paramContext.setLayoutParams(new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131298931)));
    addView(paramContext);
    paramContext = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramContext.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this.jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView$RobotListAdapter = new AddedRobotView.RobotListAdapter(this, this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView$RobotListAdapter);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
  }
  
  public void a()
  {
    QLog.i("AddedRobotView", 1, "onDestroy.");
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    }
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void setAddList(ArrayList<TroopRobotInfo> paramArrayList, int paramInt, String paramString)
  {
    if (this.b != null) {
      if (paramArrayList == null) {
        break label216;
      }
    }
    label216:
    for (int i = paramArrayList.size();; i = 0)
    {
      String str = i + "/" + paramInt;
      this.b.setText(str);
      this.b.setVisibility(0);
      this.b.setContentDescription(str);
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getText(2131689667));
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getText(2131689667));
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
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView$RobotListAdapter.a(paramArrayList);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        QLog.d("AddedRobotView", 2, "setAddList " + paramArrayList.size());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AddedRobotView
 * JD-Core Version:    0.7.0.1
 */