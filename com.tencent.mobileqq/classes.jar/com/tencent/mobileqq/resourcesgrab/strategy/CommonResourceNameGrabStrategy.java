package com.tencent.mobileqq.resourcesgrab.strategy;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.resourcesgrab.ResourceGrabSkinData;
import com.tencent.theme.SkinnableColorStateList;
import java.util.ArrayList;
import java.util.List;

public class CommonResourceNameGrabStrategy
  extends ResourceNameGrabStrategy
{
  public List<ResourceGrabSkinData> a(View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramView instanceof ImageView)) {
      a(((ImageView)paramView).getDrawable(), localArrayList, 1);
    }
    do
    {
      do
      {
        return localArrayList;
      } while (!(paramView instanceof TextView));
      localObject = ((TextView)paramView).getCompoundDrawables();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        a(localObject[i], localArrayList, 2);
        i += 1;
      }
      localObject = ((TextView)paramView).getTextColors();
    } while (!(localObject instanceof SkinnableColorStateList));
    paramView = (SkinnableColorStateList)localObject;
    Object localObject = new ResourceGrabSkinData(3, ((SkinnableColorStateList)localObject).skinData);
    ((ResourceGrabSkinData)localObject).jdField_a_of_type_Array2dOfInt = paramView.getStateSpecs();
    ((ResourceGrabSkinData)localObject).jdField_a_of_type_ArrayOfInt = paramView.getColors();
    localArrayList.add(localObject);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.resourcesgrab.strategy.CommonResourceNameGrabStrategy
 * JD-Core Version:    0.7.0.1
 */