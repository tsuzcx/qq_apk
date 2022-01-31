import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.VideoLayerUI;
import java.util.List;

public class man
  extends ExploreByTouchHelper
{
  public man(VideoLayerUI paramVideoLayerUI, View paramView)
  {
    super(paramView);
  }
  
  private Rect a(int paramInt)
  {
    Rect localRect = new Rect(0, 0, 1, 1);
    if ((this.a.jdField_a_of_type_ArrayOfLtl != null) && (this.a.jdField_a_of_type_ArrayOfLtl[paramInt].a() == 0)) {
      localRect.set(this.a.jdField_a_of_type_ArrayOfLtl[paramInt].b());
    }
    return localRect;
  }
  
  private String a(int paramInt)
  {
    if ((this.a.jdField_a_of_type_ArrayOfLtl != null) && (paramInt >= 0) && (paramInt < this.a.jdField_a_of_type_ArrayOfLtl.length))
    {
      int i = -1;
      int j = this.a.jdField_a_of_type_ComTencentAvVideoController.a().i;
      if (j == 3000) {
        i = 1004;
      }
      Resources localResources;
      String str2;
      for (;;)
      {
        localResources = this.a.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources();
        String str1 = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
        str2 = this.a.jdField_a_of_type_ArrayOfLtl[paramInt].b();
        if (str2 == null) {
          break label214;
        }
        if (!str2.equals(str1)) {
          break;
        }
        return localResources.getString(2131628854) + localResources.getString(2131630183);
        if (j == 1) {
          i = 1000;
        } else if (j == 0) {
          i = 0;
        }
      }
      return this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, str2, String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().g)) + localResources.getString(2131630183);
    }
    label214:
    return "";
  }
  
  public int getVirtualViewAt(float paramFloat1, float paramFloat2)
  {
    if (this.a.jdField_a_of_type_ArrayOfLtl != null)
    {
      int i = this.a.jdField_a_of_type_ArrayOfLtl.length - 1;
      while (i >= 0)
      {
        if ((this.a.jdField_a_of_type_ArrayOfLtl[i].a() == 0) && (this.a.jdField_a_of_type_ArrayOfLtl[i].b().contains((int)paramFloat1, (int)paramFloat2))) {
          return i;
        }
        i -= 1;
      }
    }
    return 0;
  }
  
  public void getVisibleVirtualViews(List<Integer> paramList)
  {
    if (this.a.jdField_a_of_type_ArrayOfLtl != null)
    {
      int j = this.a.jdField_a_of_type_ArrayOfLtl.length;
      int i = 0;
      while (i < j)
      {
        paramList.add(Integer.valueOf(i));
        i += 1;
      }
    }
  }
  
  public boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return false;
  }
  
  public void onPopulateEventForVirtualView(int paramInt, AccessibilityEvent paramAccessibilityEvent)
  {
    paramAccessibilityEvent.setContentDescription(a(paramInt));
  }
  
  public void onPopulateNodeForVirtualView(int paramInt, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    paramAccessibilityNodeInfoCompat.addAction(16);
    paramAccessibilityNodeInfoCompat.setContentDescription(a(paramInt));
    Rect localRect = a(paramInt);
    if (localRect.isEmpty()) {
      localRect.set(0, 0, 1, 1);
    }
    paramAccessibilityNodeInfoCompat.setBoundsInParent(localRect);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     man
 * JD-Core Version:    0.7.0.1
 */