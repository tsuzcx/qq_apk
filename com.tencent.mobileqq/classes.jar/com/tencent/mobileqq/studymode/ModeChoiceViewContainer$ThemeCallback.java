package com.tencent.mobileqq.studymode;

import android.view.View;
import com.tencent.mobileqq.activity.SimpleUIChoiceView;
import com.tencent.mobileqq.vas.theme.ThemeSwitchCallback;
import mqq.util.WeakReference;

class ModeChoiceViewContainer$ThemeCallback
  extends ThemeSwitchCallback
{
  WeakReference<SimpleUIChoiceView> weakColorfulSimple;
  WeakReference<View> weakSimpleUIChoiceView;
  
  ModeChoiceViewContainer$ThemeCallback(SimpleUIChoiceView paramSimpleUIChoiceView, View paramView)
  {
    this.weakColorfulSimple = new WeakReference(paramSimpleUIChoiceView);
    this.weakSimpleUIChoiceView = new WeakReference(paramView);
  }
  
  public boolean postSwitch(int paramInt)
  {
    SimpleUIChoiceView localSimpleUIChoiceView = (SimpleUIChoiceView)this.weakColorfulSimple.get();
    View localView = (View)this.weakSimpleUIChoiceView.get();
    if ((localSimpleUIChoiceView != null) && (localView != null)) {
      localView.post(new ModeChoiceViewContainer.ThemeCallback.1(this, localSimpleUIChoiceView, localView));
    }
    return super.postSwitch(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.ModeChoiceViewContainer.ThemeCallback
 * JD-Core Version:    0.7.0.1
 */