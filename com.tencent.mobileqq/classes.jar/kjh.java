import android.os.Handler;
import com.tencent.av.utils.SparkDot;

public class kjh
  implements Runnable
{
  public kjh(SparkDot paramSparkDot) {}
  
  public void run()
  {
    this.a.c %= this.a.e;
    this.a.a(this.a.c);
    SparkDot localSparkDot = this.a;
    localSparkDot.c += 1;
    if (SparkDot.a(this.a)) {
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, this.a.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kjh
 * JD-Core Version:    0.7.0.1
 */