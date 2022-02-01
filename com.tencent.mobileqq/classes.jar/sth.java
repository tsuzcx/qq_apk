import com.tencent.qphone.base.util.QLog;

public class sth
  extends stj
{
  public sth(ssz paramssz)
  {
    super(paramssz);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramObject != null)
    {
      paramObject = ((String)paramObject).split(":", 2);
      if ((paramObject != null) && (paramObject.length == 2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadinjoyPlayerReporter", 2, "PERFORMANCE_REPORT method:" + paramObject[0] + "\ntimeJson:" + paramObject[1]);
        }
        if ("prepare".equals(paramObject[0])) {
          this.a.a.l = paramObject[1];
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sth
 * JD-Core Version:    0.7.0.1
 */