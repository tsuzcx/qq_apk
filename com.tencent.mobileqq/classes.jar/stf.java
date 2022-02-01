import com.tencent.qphone.base.util.QLog;

public class stf
  extends stj
{
  public stf(ssz paramssz)
  {
    super(paramssz);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyPlayerReporter", 2, "播放状态回调 onInfo() PLAYER_INFO_HW_DECODE_FAILED");
    }
    this.a.a.jdField_f_of_type_Boolean = true;
    if ((paramObject instanceof String)) {
      this.a.a.jdField_f_of_type_JavaLangString = ((String)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     stf
 * JD-Core Version:    0.7.0.1
 */