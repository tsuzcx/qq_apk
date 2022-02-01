package com.tencent.mobileqq.teamworkforgroup;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.common.app.AppInterface;

public abstract class CloudFileItemBuilder
{
  protected AppInterface f;
  protected Context g;
  protected BaseAdapter h;
  protected int i;
  
  public CloudFileItemBuilder(AppInterface paramAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    this.f = paramAppInterface;
    this.g = paramContext;
    this.h = paramBaseAdapter;
    this.i = paramInt;
  }
  
  public abstract View a(int paramInt1, ICloudFile paramICloudFile, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.CloudFileItemBuilder
 * JD-Core Version:    0.7.0.1
 */