import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

public abstract class rrb
{
  private final String jdField_a_of_type_JavaLangString = "FeedExposureHelper";
  private rrc jdField_a_of_type_Rrc;
  
  public int a(int paramInt1, int paramInt2)
  {
    return paramInt1 + paramInt2;
  }
  
  public rrc a(AbsListView paramAbsListView)
  {
    int j = 0;
    rrc localrrc = new rrc();
    localrrc.jdField_a_of_type_Long = System.currentTimeMillis();
    int k = paramAbsListView.getHeight();
    int m = paramAbsListView.getFirstVisiblePosition();
    int n = paramAbsListView.getChildCount();
    int i = j;
    if (n == 0)
    {
      localrrc.jdField_a_of_type_Int = 0;
      localrrc.b = 10;
      i = j;
    }
    if (i < n)
    {
      if (a(paramAbsListView.getChildAt(i), k)) {
        localrrc.jdField_a_of_type_Int = a(m, i);
      }
    }
    else {
      i = paramAbsListView.getLastVisiblePosition() - m;
    }
    for (;;)
    {
      if (i >= 0)
      {
        if (a(paramAbsListView.getChildAt(i), k)) {
          localrrc.b = a(m, i);
        }
      }
      else
      {
        return localrrc;
        i += 1;
        break;
      }
      i -= 1;
    }
  }
  
  public rrc a(rrc paramrrc1, rrc paramrrc2)
  {
    if ((paramrrc1 == null) || (paramrrc2 == null)) {}
    while ((paramrrc1.b < paramrrc2.jdField_a_of_type_Int) || (paramrrc1.jdField_a_of_type_Int > paramrrc2.b)) {
      return null;
    }
    rrc localrrc = new rrc();
    if (paramrrc1.jdField_a_of_type_Int > paramrrc2.jdField_a_of_type_Int)
    {
      i = paramrrc1.jdField_a_of_type_Int;
      localrrc.jdField_a_of_type_Int = i;
      if (paramrrc1.b >= paramrrc2.b) {
        break label113;
      }
    }
    label113:
    for (int i = paramrrc1.b;; i = paramrrc2.b)
    {
      localrrc.b = i;
      localrrc.jdField_a_of_type_Long = Math.abs(paramrrc1.jdField_a_of_type_Long - paramrrc2.jdField_a_of_type_Long);
      return localrrc;
      i = paramrrc2.jdField_a_of_type_Int;
      break;
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      paramAbsListView = a(paramAbsListView);
      QLog.d("FeedExposureHelper", 2, "thisRange: " + paramAbsListView);
      if (this.jdField_a_of_type_Rrc != null)
      {
        rrc localrrc = a(this.jdField_a_of_type_Rrc, paramAbsListView);
        if ((localrrc != null) && (localrrc.jdField_a_of_type_Long > 1000L))
        {
          QLog.d("FeedExposureHelper", 2, "sameRange: " + localrrc);
          a(localrrc);
        }
      }
      this.jdField_a_of_type_Rrc = paramAbsListView;
    } while (paramInt != 5);
    this.jdField_a_of_type_Rrc = null;
  }
  
  public abstract void a(rrc paramrrc);
  
  public boolean a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return false;
    }
    if (paramView.getBottom() > paramInt) {}
    for (;;)
    {
      int i = paramInt;
      if (paramView.getTop() > 0) {
        i = paramInt - paramView.getTop();
      }
      if (i <= paramView.getHeight() * 0.5F) {
        break;
      }
      return true;
      paramInt = paramView.getBottom();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rrb
 * JD-Core Version:    0.7.0.1
 */