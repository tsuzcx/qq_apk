package cooperation.qqreader.host.advertisement;

import abkv;
import android.text.TextUtils;

public class ReaderAdWrapper$ImageData
{
  public int height;
  public String url;
  public int width;
  
  ReaderAdWrapper$ImageData(abkv paramabkv)
  {
    this.url = paramabkv.jdField_a_of_type_JavaLangString;
    this.width = paramabkv.jdField_a_of_type_Int;
    this.height = paramabkv.b;
  }
  
  public boolean isValid()
  {
    return (!TextUtils.isEmpty(this.url)) && (this.width >= 0) && (this.height >= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.host.advertisement.ReaderAdWrapper.ImageData
 * JD-Core Version:    0.7.0.1
 */