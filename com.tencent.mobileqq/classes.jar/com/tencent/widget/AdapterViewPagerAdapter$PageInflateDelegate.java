package com.tencent.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

public abstract interface AdapterViewPagerAdapter$PageInflateDelegate
{
  public abstract void deflate(ViewGroup paramViewGroup, View paramView, int paramInt);
  
  public abstract View inflate(ViewGroup paramViewGroup, AdapterView paramAdapterView, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.AdapterViewPagerAdapter.PageInflateDelegate
 * JD-Core Version:    0.7.0.1
 */