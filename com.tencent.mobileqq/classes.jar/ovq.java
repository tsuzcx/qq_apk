import com.tencent.biz.qqstory.view.widget.QQStoryLoadingProgressView;

public class ovq
  extends Thread
{
  private ovq(QQStoryLoadingProgressView paramQQStoryLoadingProgressView) {}
  
  private boolean a()
  {
    boolean bool = false;
    if (this.a.jdField_a_of_type_Boolean) {
      bool = a(QQStoryLoadingProgressView.a(this.a), 400, 0.3300000131130219D, false);
    }
    return bool;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    return a(paramInt1, paramInt2, 1.0D, true);
  }
  
  private boolean a(int paramInt1, int paramInt2, double paramDouble)
  {
    return a(paramInt1, paramInt2, paramDouble, true);
  }
  
  private boolean a(int paramInt1, int paramInt2, double paramDouble, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      bool1 = false;
    }
    do
    {
      return bool1;
      if (QQStoryLoadingProgressView.b(this.a) >= paramInt1) {
        break;
      }
      int i = (paramInt1 - QQStoryLoadingProgressView.b(this.a)) / (paramInt2 / QQStoryLoadingProgressView.jdField_a_of_type_Int);
      paramInt2 = i;
      if (i == 0) {
        paramInt2 = 1;
      }
      bool1 = bool2;
    } while (QQStoryLoadingProgressView.b(this.a) >= paramInt1);
    if ((paramBoolean) && (a())) {
      return false;
    }
    QQStoryLoadingProgressView.a(this.a, QQStoryLoadingProgressView.b(this.a) + paramInt2);
    this.a.postInvalidate();
    for (;;)
    {
      try
      {
        double d2 = QQStoryLoadingProgressView.jdField_a_of_type_Int;
        if (paramDouble >= 0.0D) {
          break label148;
        }
        d1 = QQStoryLoadingProgressView.a(this.a, (int)paramDouble);
        Thread.sleep((d1 * d2));
      }
      catch (InterruptedException localInterruptedException) {}
      break;
      label148:
      double d1 = paramDouble;
    }
    return false;
  }
  
  public void run()
  {
    if (!a((int)(40.0D + Math.random() * 31.0D) * QQStoryLoadingProgressView.a(this.a) / 100, 1500)) {}
    while (!a(QQStoryLoadingProgressView.a(this.a) * 90 / 100, 1500)) {
      return;
    }
    a(QQStoryLoadingProgressView.a(this.a) * 99 / 100, QQStoryLoadingProgressView.jdField_a_of_type_Int * 10, QQStoryLoadingProgressView.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ovq
 * JD-Core Version:    0.7.0.1
 */