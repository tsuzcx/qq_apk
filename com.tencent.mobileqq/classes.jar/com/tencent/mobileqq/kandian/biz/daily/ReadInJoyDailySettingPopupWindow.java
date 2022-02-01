package com.tencent.mobileqq.kandian.biz.daily;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBasePopupWindow;
import java.util.List;

public class ReadInJoyDailySettingPopupWindow
  extends ReadInJoyBasePopupWindow
{
  protected boolean g = false;
  private ReadInJoyDailySettingPopupWindow.Callback h;
  private List<String> i;
  private List<String> j;
  
  public ReadInJoyDailySettingPopupWindow(Activity paramActivity, ReadInJoyDailySettingPopupWindow.Callback paramCallback, List<String> paramList1, List<String> paramList2)
  {
    super(paramActivity);
    this.h = paramCallback;
    this.i = paramList1;
    this.j = paramList2;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = (LinearLayout)paramLayoutInflater.inflate(2131626209, null);
    RecyclerView localRecyclerView = (RecyclerView)paramLayoutInflater.findViewById(2131431213);
    ReadInJoyDailyConfigAdapter localReadInJoyDailyConfigAdapter = new ReadInJoyDailyConfigAdapter(this.a, this.i, this.j, this.h);
    localRecyclerView.setLayoutManager(new LinearLayoutManager(this.a));
    localRecyclerView.setAdapter(localReadInJoyDailyConfigAdapter);
    return paramLayoutInflater;
  }
  
  public void b(View paramView)
  {
    if (!this.g)
    {
      a();
      this.g = true;
    }
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailySettingPopupWindow
 * JD-Core Version:    0.7.0.1
 */