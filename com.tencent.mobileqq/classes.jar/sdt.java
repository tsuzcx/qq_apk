import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

public abstract class sdt
{
  private final String jdField_a_of_type_JavaLangString = "FeedExposureHelper";
  private sdu jdField_a_of_type_Sdu;
  
  public int a(int paramInt1, int paramInt2)
  {
    return paramInt1 + paramInt2;
  }
  
  public sdu a(AbsListView paramAbsListView)
  {
    int j = 0;
    sdu localsdu = new sdu();
    localsdu.jdField_a_of_type_Long = System.currentTimeMillis();
    int k = paramAbsListView.getHeight();
    int m = paramAbsListView.getFirstVisiblePosition();
    int n = paramAbsListView.getChildCount();
    int i = j;
    if (n == 0)
    {
      localsdu.jdField_a_of_type_Int = 0;
      localsdu.b = 10;
      i = j;
    }
    if (i < n)
    {
      if (a(paramAbsListView.getChildAt(i), k)) {
        localsdu.jdField_a_of_type_Int = a(m, i);
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
          localsdu.b = a(m, i);
        }
      }
      else
      {
        return localsdu;
        i += 1;
        break;
      }
      i -= 1;
    }
  }
  
  public sdu a(sdu paramsdu1, sdu paramsdu2)
  {
    if ((paramsdu1 == null) || (paramsdu2 == null)) {}
    while ((paramsdu1.b < paramsdu2.jdField_a_of_type_Int) || (paramsdu1.jdField_a_of_type_Int > paramsdu2.b)) {
      return null;
    }
    sdu localsdu = new sdu();
    if (paramsdu1.jdField_a_of_type_Int > paramsdu2.jdField_a_of_type_Int)
    {
      i = paramsdu1.jdField_a_of_type_Int;
      localsdu.jdField_a_of_type_Int = i;
      if (paramsdu1.b >= paramsdu2.b) {
        break label113;
      }
    }
    label113:
    for (int i = paramsdu1.b;; i = paramsdu2.b)
    {
      localsdu.b = i;
      localsdu.jdField_a_of_type_Long = Math.abs(paramsdu1.jdField_a_of_type_Long - paramsdu2.jdField_a_of_type_Long);
      return localsdu;
      i = paramsdu2.jdField_a_of_type_Int;
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
      if (this.jdField_a_of_type_Sdu != null)
      {
        sdu localsdu = a(this.jdField_a_of_type_Sdu, paramAbsListView);
        if ((localsdu != null) && (localsdu.jdField_a_of_type_Long > 1000L))
        {
          QLog.d("FeedExposureHelper", 2, "sameRange: " + localsdu);
          a(localsdu);
        }
      }
      this.jdField_a_of_type_Sdu = paramAbsListView;
    } while (paramInt != 5);
    this.jdField_a_of_type_Sdu = null;
  }
  
  public abstract void a(sdu paramsdu);
  
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
 * Qualified Name:     sdt
 * JD-Core Version:    0.7.0.1
 */