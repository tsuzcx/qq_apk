package com.tencent.mobileqq.widget.datepicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.util.AttributeSet;
import bcsz;
import bcta;
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
  protected bcsz a;
  protected bcta a;
  
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
    if (this.jdField_a_of_type_Bcta != null)
    {
      this.jdField_a_of_type_Bcta.a(paramInt1, paramInt2, paramArrayList);
      this.jdField_a_of_type_Bcta.notifyDataSetChanged();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramArrayList.next();
        localStringBuilder.append("[shmsgseq:").append(localMessageRecord.shmsgseq).append(", time:").append(localMessageRecord.time).append(", senderUin").append(localMessageRecord.senderuin).append("], ");
      }
      QLog.d("DatePickerView", 2, "addOrUpdateMsgData:" + paramInt1 + "-" + (paramInt2 + 1) + " | MessageRecordList: " + localStringBuilder.toString());
    }
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setLayoutManager(new LinearLayoutManager(paramContext));
    setVerticalScrollBarEnabled(false);
    setFadingEdgeLength(0);
  }
  
  public void setController(bcsz parambcsz)
  {
    this.jdField_a_of_type_Bcsz = parambcsz;
    if (this.jdField_a_of_type_Bcta == null) {
      this.jdField_a_of_type_Bcta = new bcta(getContext(), parambcsz, this.jdField_a_of_type_AndroidContentResTypedArray);
    }
    this.jdField_a_of_type_Bcta.notifyDataSetChanged();
    setAdapter(this.jdField_a_of_type_Bcta);
    scrollToPosition(this.jdField_a_of_type_Bcta.getItemCount() - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.datepicker.DatePickerView
 * JD-Core Version:    0.7.0.1
 */