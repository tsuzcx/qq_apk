import com.tencent.av.widget.ChildLockCircle;

public class kkd
  extends Thread
{
  public boolean a;
  private boolean b;
  
  public kkd(ChildLockCircle paramChildLockCircle)
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void run()
  {
    this.b = false;
    float f2 = 0.0F;
    if (ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle))
    {
      ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle, 0);
      ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle, ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle));
      ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle, ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.a(0);
      float f1 = f2;
      if (!ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle)) {}
      try
      {
        Thread.sleep(300L);
        f1 = f2;
        label84:
        if (this.jdField_a_of_type_Boolean)
        {
          if (ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle))
          {
            ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle, (int)((float)(ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle) + 100L * 15L / 1000L) + f1));
            if (ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle) >= 100)
            {
              ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle, ChildLockCircle.c(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle));
              ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle, ChildLockCircle.b(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle));
              this.b = true;
            }
            f1 = (float)(f1 + 0.08D);
            this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.postInvalidate();
            if (!this.b) {
              break label372;
            }
            ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle);
          }
        }
        else
        {
          if (!this.b) {
            break label411;
          }
          if (!ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle)) {
            break label385;
          }
        }
      }
      catch (InterruptedException localInterruptedException5)
      {
        try
        {
          label180:
          Thread.sleep(600L);
          for (;;)
          {
            for (;;)
            {
              ChildLockCircle.c(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle);
              return;
              ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle, 100);
              ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle, ChildLockCircle.b(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle));
              ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle, ChildLockCircle.b(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle));
              break;
              ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle, (int)((float)(ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle) - 100L * 15L / 1000L) - f1));
              if (ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle) > 0) {
                break label180;
              }
              ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle, 0);
              ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle, ChildLockCircle.d(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle));
              ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle, ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle));
              this.b = true;
              break label180;
              try
              {
                label372:
                Thread.sleep(15L);
              }
              catch (InterruptedException localInterruptedException1) {}
            }
            break label84;
            try
            {
              label385:
              Thread.sleep(300L);
            }
            catch (InterruptedException localInterruptedException2) {}
          }
          label398:
          this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.postInvalidate();
        }
        catch (InterruptedException localInterruptedException5)
        {
          try
          {
            for (;;)
            {
              Thread.sleep(15L);
              label411:
              if (ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle))
              {
                ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle, (int)(ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle) - 9L * 15L / 5L * 100L / 1000L));
                if (ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle) <= 0) {
                  ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle, 0);
                }
              }
              else
              {
                for (;;)
                {
                  for (;;)
                  {
                    this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.postInvalidate();
                    ChildLockCircle.b(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle);
                    try
                    {
                      Thread.sleep(2L * 15L);
                    }
                    catch (InterruptedException localInterruptedException3) {}
                  }
                  break;
                  ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle, (int)(ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle) + 9L * 15L / 5L * 100L / 1000L));
                  if (ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle) < 100) {
                    break label398;
                  }
                }
                localInterruptedException4 = localInterruptedException4;
                f1 = f2;
              }
            }
            localInterruptedException5 = localInterruptedException5;
          }
          catch (InterruptedException localInterruptedException6)
          {
            break label411;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kkd
 * JD-Core Version:    0.7.0.1
 */