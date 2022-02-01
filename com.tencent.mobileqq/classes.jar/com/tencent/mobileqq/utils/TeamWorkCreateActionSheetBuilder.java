package com.tencent.mobileqq.utils;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class TeamWorkCreateActionSheetBuilder
  implements View.OnClickListener
{
  protected final ActionSheet a;
  protected View b;
  protected Context c;
  protected TeamWorkCreateActionSheetBuilder.OnCreateItemClickListener d;
  
  public TeamWorkCreateActionSheetBuilder(Context paramContext)
  {
    this.c = paramContext;
    this.a = ((ActionSheet)ActionSheetHelper.b(paramContext, null));
  }
  
  public void a(TeamWorkCreateActionSheetBuilder.OnCreateItemClickListener paramOnCreateItemClickListener)
  {
    this.d = paramOnCreateItemClickListener;
  }
  
  public boolean a()
  {
    return this.a.isShowing();
  }
  
  protected View b()
  {
    View localView1 = View.inflate(this.c, 2131627082, null);
    View localView2 = localView1.findViewById(2131431512);
    View localView3 = localView1.findViewById(2131431500);
    View localView4 = localView1.findViewById(2131431498);
    localView2.setOnClickListener(this);
    localView3.setOnClickListener(this);
    localView4.setOnClickListener(this);
    return localView1;
  }
  
  public void c()
  {
    if (this.b == null) {
      this.b = b();
    }
    this.a.setActionContentView(this.b, null);
    try
    {
      if (!a())
      {
        this.a.show();
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("actionSheet.show exception=");
        localStringBuilder.append(localException);
        QLog.d("TeamWorkCreateActionSheetBuilder", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void d()
  {
    if (a()) {
      try
      {
        this.a.dismiss();
        this.b = null;
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        QLog.w("TeamWorkCreateActionSheetBuilder", 2, "Exception while dismiss", localRuntimeException);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    int i = 1;
    if (j != 2131431498)
    {
      if (j == 2131431500) {
        i = 2;
      }
    }
    else {
      i = 3;
    }
    TeamWorkCreateActionSheetBuilder.OnCreateItemClickListener localOnCreateItemClickListener = this.d;
    if (localOnCreateItemClickListener != null) {
      localOnCreateItemClickListener.a(i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.TeamWorkCreateActionSheetBuilder
 * JD-Core Version:    0.7.0.1
 */