package cooperation.qqreader.host.advertisement;

import android.text.TextUtils;
import yst;

public class ReaderAdWrapper$ImageData
{
  public int height;
  public String url;
  public int width;
  
  ReaderAdWrapper$ImageData(yst paramyst)
  {
    this.url = paramyst.jdField_a_of_type_JavaLangString;
    this.width = paramyst.jdField_a_of_type_Int;
    this.height = paramyst.b;
  }
  
  public boolean isValid()
  {
    return (!TextUtils.isEmpty(this.url)) && (this.width >= 0) && (this.height >= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.host.advertisement.ReaderAdWrapper.ImageData
 * JD-Core Version:    0.7.0.1
 */