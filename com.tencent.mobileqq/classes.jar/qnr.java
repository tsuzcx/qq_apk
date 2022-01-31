import com.tencent.qphone.base.util.QLog;

class qnr
  extends osm
{
  private qnr(qnl paramqnl) {}
  
  public void f(boolean paramBoolean)
  {
    qnl.b(this.a, paramBoolean);
    if (paramBoolean) {
      this.a.d();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsFloatWindowManager", 2, "onVideoFeedsFloatingWindowVisibilityChange: " + paramBoolean);
      }
      return;
      this.a.e();
    }
  }
  
  public void i()
  {
    this.a.f();
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsFloatWindowManager", 2, "onVideoFeedsFloatingWindowDismiss");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qnr
 * JD-Core Version:    0.7.0.1
 */