import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

public abstract class svj
{
  private final String jdField_a_of_type_JavaLangString = "FeedExposureHelper";
  private svk jdField_a_of_type_Svk;
  
  public int a(int paramInt1, int paramInt2)
  {
    return paramInt1 + paramInt2;
  }
  
  public svk a(AbsListView paramAbsListView)
  {
    int j = 0;
    svk localsvk = new svk();
    localsvk.jdField_a_of_type_Long = System.currentTimeMillis();
    int k = paramAbsListView.getHeight();
    int m = paramAbsListView.getFirstVisiblePosition();
    int n = paramAbsListView.getChildCount();
    int i = j;
    if (n == 0)
    {
      localsvk.jdField_a_of_type_Int = 0;
      localsvk.b = 10;
      i = j;
    }
    if (i < n)
    {
      if (a(paramAbsListView.getChildAt(i), k)) {
        localsvk.jdField_a_of_type_Int = a(m, i);
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
          localsvk.b = a(m, i);
        }
      }
      else
      {
        return localsvk;
        i += 1;
        break;
      }
      i -= 1;
    }
  }
  
  public svk a(svk paramsvk1, svk paramsvk2)
  {
    if ((paramsvk1 == null) || (paramsvk2 == null)) {}
    while ((paramsvk1.b < paramsvk2.jdField_a_of_type_Int) || (paramsvk1.jdField_a_of_type_Int > paramsvk2.b)) {
      return null;
    }
    svk localsvk = new svk();
    if (paramsvk1.jdField_a_of_type_Int > paramsvk2.jdField_a_of_type_Int)
    {
      i = paramsvk1.jdField_a_of_type_Int;
      localsvk.jdField_a_of_type_Int = i;
      if (paramsvk1.b >= paramsvk2.b) {
        break label113;
      }
    }
    label113:
    for (int i = paramsvk1.b;; i = paramsvk2.b)
    {
      localsvk.b = i;
      localsvk.jdField_a_of_type_Long = Math.abs(paramsvk1.jdField_a_of_type_Long - paramsvk2.jdField_a_of_type_Long);
      return localsvk;
      i = paramsvk2.jdField_a_of_type_Int;
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
      if (this.jdField_a_of_type_Svk != null)
      {
        svk localsvk = a(this.jdField_a_of_type_Svk, paramAbsListView);
        if ((localsvk != null) && (localsvk.jdField_a_of_type_Long > 1000L))
        {
          QLog.d("FeedExposureHelper", 2, "sameRange: " + localsvk);
          a(localsvk);
        }
      }
      this.jdField_a_of_type_Svk = paramAbsListView;
    } while (paramInt != 5);
    this.jdField_a_of_type_Svk = null;
  }
  
  public abstract void a(svk paramsvk);
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     svj
 * JD-Core Version:    0.7.0.1
 */