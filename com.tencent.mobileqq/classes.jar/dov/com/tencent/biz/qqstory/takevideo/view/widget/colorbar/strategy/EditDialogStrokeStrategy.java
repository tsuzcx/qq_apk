package dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.strategy;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.NonNull;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke.HorizontalStroke;
import java.util.ArrayList;

public class EditDialogStrokeStrategy
  implements StrokeStrategy
{
  public static final int[] a;
  public static final String[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "#000000", "#FFFFFF", "#DF382C", "#F09A37", "#83D754", "#3478F6", "#7ED5F8", "#F7E368", "#E8519C" };
    jdField_a_of_type_ArrayOfInt = new int[] { 2130847132, 2130847130, 2130847133, 2130847131, 2130847136, 2130847135, 2130847139, 2130847134, 2130847137 };
  }
  
  public static int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return Color.parseColor(jdField_a_of_type_ArrayOfJavaLangString[2]);
    }
    return Color.parseColor(jdField_a_of_type_ArrayOfJavaLangString[1]);
  }
  
  public void a(@NonNull ArrayList<HorizontalStroke> paramArrayList, @NonNull Context paramContext)
  {
    int i = 0;
    while (i < jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      paramArrayList.add(new HorizontalStroke(paramContext.getResources().getDrawable(jdField_a_of_type_ArrayOfInt[i]), 0, jdField_a_of_type_ArrayOfJavaLangString[i]));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.strategy.EditDialogStrokeStrategy
 * JD-Core Version:    0.7.0.1
 */