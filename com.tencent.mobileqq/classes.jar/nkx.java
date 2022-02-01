import com.tencent.qphone.base.util.QLog;

class nkx
  extends aocj
{
  nkx(nku paramnku) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (105 == paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.i("storyRedDotDebug", 2, "mGetRedPointPushObserver");
      }
      this.a.notifyUI(105, true, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nkx
 * JD-Core Version:    0.7.0.1
 */