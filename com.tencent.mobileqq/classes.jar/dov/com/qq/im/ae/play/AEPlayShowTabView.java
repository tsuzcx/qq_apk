package dov.com.qq.im.ae.play;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import bour;
import dov.com.qq.im.capture.view.QIMSlidingTabView;
import java.util.ArrayList;
import java.util.List;

public class AEPlayShowTabView
  extends QIMSlidingTabView
{
  private int jdField_a_of_type_Int;
  private ArrayList<bour> jdField_a_of_type_JavaUtilArrayList;
  
  public AEPlayShowTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public ArrayList<bour> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.jdField_a_of_type_Int = paramInt;
    ArrayList localArrayList = b();
    if (localArrayList == null) {
      return;
    }
    int i = 0;
    label22:
    View localView;
    if (i < localArrayList.size())
    {
      localView = (View)localArrayList.get(i);
      if (i != paramInt) {
        break label70;
      }
      localView.setScaleX(1.143F);
      localView.setScaleY(1.143F);
    }
    for (;;)
    {
      i += 1;
      break label22;
      break;
      label70:
      localView.setScaleX(1.0F);
      localView.setScaleY(1.0F);
    }
  }
  
  public void a(ArrayList<bour> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    super.a(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowTabView
 * JD-Core Version:    0.7.0.1
 */