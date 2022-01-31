package cooperation.qqreader.host.advertisement;

import aamz;
import android.support.annotation.NonNull;
import android.text.TextUtils;

public class ReaderGdtSdk$ImageData
{
  public int height;
  public String url;
  public int width;
  
  public ReaderGdtSdk$ImageData(@NonNull aamz paramaamz)
  {
    this.url = paramaamz.jdField_a_of_type_JavaLangString;
    this.width = paramaamz.jdField_a_of_type_Int;
    this.height = paramaamz.b;
  }
  
  public boolean isValid()
  {
    return (!TextUtils.isEmpty(this.url)) && (this.width >= 0) && (this.height >= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqreader.host.advertisement.ReaderGdtSdk.ImageData
 * JD-Core Version:    0.7.0.1
 */