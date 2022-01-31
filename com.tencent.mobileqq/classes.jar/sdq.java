import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

public abstract class sdq
{
  private final String jdField_a_of_type_JavaLangString = "FeedExposureHelper";
  private sdr jdField_a_of_type_Sdr;
  
  public int a(int paramInt1, int paramInt2)
  {
    return paramInt1 + paramInt2;
  }
  
  public sdr a(AbsListView paramAbsListView)
  {
    int j = 0;
    sdr localsdr = new sdr();
    localsdr.jdField_a_of_type_Long = System.currentTimeMillis();
    int k = paramAbsListView.getHeight();
    int m = paramAbsListView.getFirstVisiblePosition();
    int n = paramAbsListView.getChildCount();
    int i = j;
    if (n == 0)
    {
      localsdr.jdField_a_of_type_Int = 0;
      localsdr.b = 10;
      i = j;
    }
    if (i < n)
    {
      if (a(paramAbsListView.getChildAt(i), k)) {
        localsdr.jdField_a_of_type_Int = a(m, i);
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
          localsdr.b = a(m, i);
        }
      }
      else
      {
        return localsdr;
        i += 1;
        break;
      }
      i -= 1;
    }
  }
  
  public sdr a(sdr paramsdr1, sdr paramsdr2)
  {
    if ((paramsdr1 == null) || (paramsdr2 == null)) {}
    while ((paramsdr1.b < paramsdr2.jdField_a_of_type_Int) || (paramsdr1.jdField_a_of_type_Int > paramsdr2.b)) {
      return null;
    }
    sdr localsdr = new sdr();
    if (paramsdr1.jdField_a_of_type_Int > paramsdr2.jdField_a_of_type_Int)
    {
      i = paramsdr1.jdField_a_of_type_Int;
      localsdr.jdField_a_of_type_Int = i;
      if (paramsdr1.b >= paramsdr2.b) {
        break label113;
      }
    }
    label113:
    for (int i = paramsdr1.b;; i = paramsdr2.b)
    {
      localsdr.b = i;
      localsdr.jdField_a_of_type_Long = Math.abs(paramsdr1.jdField_a_of_type_Long - paramsdr2.jdField_a_of_type_Long);
      return localsdr;
      i = paramsdr2.jdField_a_of_type_Int;
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
      if (this.jdField_a_of_type_Sdr != null)
      {
        sdr localsdr = a(this.jdField_a_of_type_Sdr, paramAbsListView);
        if ((localsdr != null) && (localsdr.jdField_a_of_type_Long > 1000L))
        {
          QLog.d("FeedExposureHelper", 2, "sameRange: " + localsdr);
          a(localsdr);
        }
      }
      this.jdField_a_of_type_Sdr = paramAbsListView;
    } while (paramInt != 5);
    this.jdField_a_of_type_Sdr = null;
  }
  
  public abstract void a(sdr paramsdr);
  
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
 * Qualified Name:     sdq
 * JD-Core Version:    0.7.0.1
 */