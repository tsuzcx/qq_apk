package com.tencent.mobileqq.theme.diy;

class ThemeDIYActivity$DataLoading
{
  int count;
  
  ThemeDIYActivity$DataLoading(ThemeDIYActivity paramThemeDIYActivity) {}
  
  public void bindScrollViewGroup(ScrollLayout paramScrollLayout)
  {
    this.count = paramScrollLayout.getChildCount();
    paramScrollLayout.setOnScreenChangeListenerDataLoad(new ThemeDIYActivity.DataLoading.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity.DataLoading
 * JD-Core Version:    0.7.0.1
 */