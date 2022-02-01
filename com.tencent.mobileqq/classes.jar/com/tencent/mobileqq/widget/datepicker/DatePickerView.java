package com.tencent.mobileqq.widget.datepicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.util.AttributeSet;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class DatePickerView
  extends RecyclerView
{
  protected Context a;
  private TypedArray a;
  protected DatePickerController a;
  protected SimpleMonthAdapter a;
  
  public DatePickerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DatePickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DatePickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (!isInEditMode())
    {
      this.jdField_a_of_type_AndroidContentResTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.DatePickerView);
      setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
      a(paramContext);
    }
  }
  
  public void a(int paramInt1, int paramInt2, ArrayList<MessageRecord> paramArrayList)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerSimpleMonthAdapter;
    if (localObject != null)
    {
      ((SimpleMonthAdapter)localObject).a(paramInt1, paramInt2, paramArrayList);
      this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerSimpleMonthAdapter.notifyDataSetChanged();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramArrayList.next();
        ((StringBuilder)localObject).append("[shmsgseq:");
        ((StringBuilder)localObject).append(localMessageRecord.shmsgseq);
        ((StringBuilder)localObject).append(", time:");
        ((StringBuilder)localObject).append(localMessageRecord.time);
        ((StringBuilder)localObject).append(", senderUin");
        ((StringBuilder)localObject).append(localMessageRecord.senderuin);
        ((StringBuilder)localObject).append("], ");
      }
      paramArrayList = new StringBuilder();
      paramArrayList.append("addOrUpdateMsgData:");
      paramArrayList.append(paramInt1);
      paramArrayList.append("-");
      paramArrayList.append(paramInt2 + 1);
      paramArrayList.append(" | MessageRecordList: ");
      paramArrayList.append(((StringBuilder)localObject).toString());
      QLog.d("DatePickerView", 2, paramArrayList.toString());
    }
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setLayoutManager(new LinearLayoutManager(paramContext));
    setVerticalScrollBarEnabled(false);
    setFadingEdgeLength(0);
  }
  
  public void setController(DatePickerController paramDatePickerController)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerController = paramDatePickerController;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerSimpleMonthAdapter == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerSimpleMonthAdapter = new SimpleMonthAdapter(getContext(), paramDatePickerController, this.jdField_a_of_type_AndroidContentResTypedArray);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerSimpleMonthAdapter.notifyDataSetChanged();
    setAdapter(this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerSimpleMonthAdapter);
    scrollToPosition(this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerSimpleMonthAdapter.getItemCount() - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.datepicker.DatePickerView
 * JD-Core Version:    0.7.0.1
 */