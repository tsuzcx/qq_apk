package cooperation.qqreader.host.advertisement;

import ackj;
import android.support.annotation.NonNull;
import android.text.TextUtils;

public class ReaderGdtSdk$ImageData
{
  public int height;
  public String url;
  public int width;
  
  public ReaderGdtSdk$ImageData(@NonNull ackj paramackj)
  {
    this.url = paramackj.jdField_a_of_type_JavaLangString;
    this.width = paramackj.jdField_a_of_type_Int;
    this.height = paramackj.b;
  }
  
  public boolean isValid()
  {
    return (!TextUtils.isEmpty(this.url)) && (this.width >= 0) && (this.height >= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.host.advertisement.ReaderGdtSdk.ImageData
 * JD-Core Version:    0.7.0.1
 */