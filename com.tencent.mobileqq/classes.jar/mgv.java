import com.tencent.av.ui.QavListItemBase;
import com.tencent.qphone.base.util.QLog;

class mgv
  implements mhp
{
  mgv(mgr parammgr) {}
  
  public void a(long paramLong, int paramInt, QavListItemBase paramQavListItemBase)
  {
    if ((System.currentTimeMillis() - this.a.a < 500L) && (paramInt > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QAVPtvTemplateAdapter", 1, "onItemClicked begin, position[" + paramInt + "], mCurSelectedPosition[" + this.a.d + "], ignore[" + bool + "], seq[" + paramLong + "]");
      }
      if (!bool) {
        break;
      }
      return;
    }
    QLog.w("QAVPtvTemplateAdapter", 1, "onItemClicked valid, position[" + paramInt + "], mCurSelectedPosition[" + this.a.d + "], seq[" + paramLong + "]");
    this.a.a = System.currentTimeMillis();
    int i = this.a.d;
    this.a.d = paramInt;
    this.a.e = paramInt;
    this.a.a(i, this.a.d);
    this.a.a(this.a.d);
    this.a.a(paramLong, this.a.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mgv
 * JD-Core Version:    0.7.0.1
 */