package com.tencent.mobileqq.writetogetherui;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.writetogetherconfig.WriteTogetherTemplateConfBean.Template;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class HorizontalAdapter
  extends RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder>
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private IEditorView jdField_a_of_type_ComTencentMobileqqWritetogetheruiIEditorView;
  private boolean jdField_a_of_type_Boolean;
  private WriteTogetherTemplateConfBean.Template[] jdField_a_of_type_ArrayOfComTencentMobileqqWritetogetherconfigWriteTogetherTemplateConfBean$Template;
  
  public HorizontalAdapter(Context paramContext, IEditorView paramIEditorView, long paramLong)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiIEditorView = paramIEditorView;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ArrayOfComTencentMobileqqWritetogetherconfigWriteTogetherTemplateConfBean$Template[this.jdField_a_of_type_Int].jdField_a_of_type_Int;
  }
  
  @NonNull
  public HorizontalAdapter.HorizontalViewHolder a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new HorizontalAdapter.HorizontalViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560955, paramViewGroup, false));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(View paramView, int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B358", "0X800B358", 0, 0, "", "", "", "");
    paramView = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(2131720457).setPositiveButton(2131720418, new HorizontalAdapter.3(this, paramInt)).setNegativeButton(2131720417, new HorizontalAdapter.2(this));
    paramView.show();
    ((TextView)paramView.findViewById(2131365644)).setGravity(17);
  }
  
  public void a(@NonNull HorizontalAdapter.HorizontalViewHolder paramHorizontalViewHolder, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqWritetogetherconfigWriteTogetherTemplateConfBean$Template;
    if ((localObject != null) && (localObject.length != 0))
    {
      if (this.jdField_a_of_type_Int == paramInt)
      {
        paramHorizontalViewHolder.a.setSelected(true);
        paramHorizontalViewHolder.a.setTypeface(Typeface.defaultFromStyle(1));
      }
      else
      {
        paramHorizontalViewHolder.a.setSelected(false);
        paramHorizontalViewHolder.a.setTypeface(Typeface.defaultFromStyle(0));
      }
      paramHorizontalViewHolder.a.setText(this.jdField_a_of_type_ArrayOfComTencentMobileqqWritetogetherconfigWriteTogetherTemplateConfBean$Template[paramInt].jdField_a_of_type_JavaLangString);
      paramHorizontalViewHolder.a.setOnClickListener(new HorizontalAdapter.1(this, paramHorizontalViewHolder));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onBindViewHolder() called with: position = [");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("], holder.templateTitle = [");
        ((StringBuilder)localObject).append(paramHorizontalViewHolder.a);
        ((StringBuilder)localObject).append("], mTemplates[position].title = [");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ArrayOfComTencentMobileqqWritetogetherconfigWriteTogetherTemplateConfBean$Template[paramInt].jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append("]");
        QLog.d("HorizontalAdapter", 2, ((StringBuilder)localObject).toString());
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramHorizontalViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(WriteTogetherTemplateConfBean.Template[] paramArrayOfTemplate)
  {
    this.jdField_a_of_type_ArrayOfComTencentMobileqqWritetogetherconfigWriteTogetherTemplateConfBean$Template = paramArrayOfTemplate;
    notifyDataSetChanged();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int getItemCount()
  {
    WriteTogetherTemplateConfBean.Template[] arrayOfTemplate = this.jdField_a_of_type_ArrayOfComTencentMobileqqWritetogetherconfigWriteTogetherTemplateConfBean$Template;
    if (arrayOfTemplate == null) {
      return 0;
    }
    return arrayOfTemplate.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.HorizontalAdapter
 * JD-Core Version:    0.7.0.1
 */