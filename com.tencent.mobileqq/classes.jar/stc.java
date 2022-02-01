import com.tencent.qphone.base.util.QLog;

public class stc
  extends stj
{
  public stc(ssz paramssz)
  {
    super(paramssz);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyPlayerReporter", 2, "播放状态回调 onInfo() PLAYER_INFO_DECODER_BLOCK");
    }
    paramObject = this.a.a;
    paramObject.o += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     stc
 * JD-Core Version:    0.7.0.1
 */