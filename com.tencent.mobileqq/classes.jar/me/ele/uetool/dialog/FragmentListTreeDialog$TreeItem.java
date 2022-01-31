package me.ele.uetool.dialog;

import android.graphics.RectF;
import android.support.v4.app.Fragment;
import android.view.View;

public class FragmentListTreeDialog$TreeItem
{
  public String name;
  public RectF rectF;
  
  public FragmentListTreeDialog$TreeItem(Fragment paramFragment, boolean paramBoolean)
  {
    initName(paramFragment, paramBoolean);
    initRect(paramFragment);
  }
  
  private void initName(Fragment paramFragment, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean) {}
    for (String str = paramFragment.getClass().getName();; str = paramFragment.getClass().getSimpleName())
    {
      localStringBuilder.append(str);
      localStringBuilder.append("[visible=").append(paramFragment.isVisible()).append(", hashCode=").append(paramFragment.hashCode()).append("]");
      this.name = localStringBuilder.toString();
      if (paramFragment.isVisible()) {
        this.name = ("<u>" + this.name + "</u>");
      }
      return;
    }
  }
  
  private void initRect(Fragment paramFragment)
  {
    if (paramFragment.isVisible())
    {
      paramFragment = paramFragment.getView();
      int[] arrayOfInt = new int[2];
      paramFragment.getLocationOnScreen(arrayOfInt);
      float f1 = arrayOfInt[0];
      float f2 = arrayOfInt[1];
      float f3 = arrayOfInt[0] + paramFragment.getWidth();
      int i = arrayOfInt[1];
      this.rectF = new RectF(f1, f2, f3, paramFragment.getHeight() + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.dialog.FragmentListTreeDialog.TreeItem
 * JD-Core Version:    0.7.0.1
 */