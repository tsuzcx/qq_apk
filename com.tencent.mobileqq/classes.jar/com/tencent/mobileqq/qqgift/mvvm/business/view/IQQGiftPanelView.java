package com.tencent.mobileqq.qqgift.mvvm.business.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tencent.mobileqq.qqgift.data.service.GiftListData;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import com.tencent.mobileqq.qqgift.mvvm.business.data.QQGiftDtParams;
import java.util.List;
import java.util.Map;

public abstract interface IQQGiftPanelView
{
  public abstract IQQGiftPanelView.OnPanelEventListener a(IQQGiftPanelView.OnPanelEventListener paramOnPanelEventListener);
  
  public abstract void a();
  
  public abstract void a(View paramView);
  
  public abstract void a(String paramString);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b();
  
  public abstract ViewGroup getContentView();
  
  public abstract LinearLayout getListHeaderView();
  
  public abstract Context getViewContext();
  
  public abstract void setAdapter(RecyclerView.Adapter paramAdapter);
  
  public abstract void setCacheList(List<GiftServiceData> paramList);
  
  public abstract void setDtPageExtra(Map<String, String> paramMap);
  
  public abstract void setDtParams(QQGiftDtParams paramQQGiftDtParams);
  
  public abstract void setPanelEventListener(IQQGiftPanelView.OnPanelEventListener paramOnPanelEventListener);
  
  public abstract void setSceneData(GiftListData paramGiftListData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftPanelView
 * JD-Core Version:    0.7.0.1
 */