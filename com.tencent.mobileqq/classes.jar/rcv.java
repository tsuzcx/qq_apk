import com.tencent.qphone.base.util.QLog;

class rcv
  extends oxe
{
  private rcv(rcp paramrcp) {}
  
  public void e(boolean paramBoolean)
  {
    rcp.b(this.a, paramBoolean);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rcv
 * JD-Core Version:    0.7.0.1
 */