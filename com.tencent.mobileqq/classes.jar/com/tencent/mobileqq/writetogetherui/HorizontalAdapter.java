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
  private Context a;
  private WriteTogetherTemplateConfBean.Template[] b;
  private IEditorView c;
  private boolean d;
  private long e;
  private int f;
  
  public HorizontalAdapter(Context paramContext, IEditorView paramIEditorView, long paramLong)
  {
    this.a = paramContext;
    this.c = paramIEditorView;
    this.e = paramLong;
  }
  
  @NonNull
  public HorizontalAdapter.HorizontalViewHolder a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new HorizontalAdapter.HorizontalViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131627296, paramViewGroup, false));
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(View paramView, int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B358", "0X800B358", 0, 0, "", "", "", "");
    paramView = DialogUtil.a(this.a, 230).setMessage(2131918133).setPositiveButton(2131918094, new HorizontalAdapter.3(this, paramInt)).setNegativeButton(2131918093, new HorizontalAdapter.2(this));
    paramView.show();
    ((TextView)paramView.findViewById(2131431876)).setGravity(17);
  }
  
  public void a(@NonNull HorizontalAdapter.HorizontalViewHolder paramHorizontalViewHolder, int paramInt)
  {
    Object localObject = this.b;
    if ((localObject != null) && (localObject.length != 0))
    {
      if (this.f == paramInt)
      {
        paramHorizontalViewHolder.a.setSelected(true);
        paramHorizontalViewHolder.a.setTypeface(Typeface.defaultFromStyle(1));
      }
      else
      {
        paramHorizontalViewHolder.a.setSelected(false);
        paramHorizontalViewHolder.a.setTypeface(Typeface.defaultFromStyle(0));
      }
      paramHorizontalViewHolder.a.setText(this.b[paramInt].b);
      paramHorizontalViewHolder.a.setOnClickListener(new HorizontalAdapter.1(this, paramHorizontalViewHolder));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onBindViewHolder() called with: position = [");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("], holder.templateTitle = [");
        ((StringBuilder)localObject).append(paramHorizontalViewHolder.a);
        ((StringBuilder)localObject).append("], mTemplates[position].title = [");
        ((StringBuilder)localObject).append(this.b[paramInt].b);
        ((StringBuilder)localObject).append("]");
        QLog.d("HorizontalAdapter", 2, ((StringBuilder)localObject).toString());
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramHorizontalViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void a(WriteTogetherTemplateConfBean.Template[] paramArrayOfTemplate)
  {
    this.b = paramArrayOfTemplate;
    notifyDataSetChanged();
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public int b()
  {
    return this.b[this.f].a;
  }
  
  public int getItemCount()
  {
    WriteTogetherTemplateConfBean.Template[] arrayOfTemplate = this.b;
    if (arrayOfTemplate == null) {
      return 0;
    }
    return arrayOfTemplate.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.HorizontalAdapter
 * JD-Core Version:    0.7.0.1
 */