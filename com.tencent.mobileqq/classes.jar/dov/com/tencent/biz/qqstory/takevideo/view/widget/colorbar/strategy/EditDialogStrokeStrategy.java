package dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.strategy;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke.HorizontalStroke;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke.PureStroke;
import java.util.ArrayList;

public class EditDialogStrokeStrategy
  implements StrokeStrategy
{
  public void a(@NonNull ArrayList paramArrayList, @NonNull Context paramContext)
  {
    int i = 0;
    while (i < PureStroke.a.length)
    {
      paramArrayList.add(new PureStroke(paramContext, i));
      i += 1;
    }
  }
  
  public void b(@NonNull ArrayList paramArrayList, @NonNull Context paramContext)
  {
    int i = 0;
    while (i < HorizontalStroke.a.length)
    {
      paramArrayList.add(new HorizontalStroke(paramContext.getResources().getDrawable(HorizontalStroke.b[i]), 0, HorizontalStroke.a[i]));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.strategy.EditDialogStrokeStrategy
 * JD-Core Version:    0.7.0.1
 */