import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;

public final class ix
{
  private int jdField_a_of_type_Int = -1;
  private ErrorCorrectionLevel jdField_a_of_type_ComGoogleZxingQrcodeDecoderErrorCorrectionLevel;
  private Mode jdField_a_of_type_ComGoogleZxingQrcodeDecoderMode;
  private io jdField_a_of_type_Io;
  private is jdField_a_of_type_Is;
  
  public static boolean a(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < 8);
  }
  
  public is a()
  {
    return this.jdField_a_of_type_Is;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(ErrorCorrectionLevel paramErrorCorrectionLevel)
  {
    this.jdField_a_of_type_ComGoogleZxingQrcodeDecoderErrorCorrectionLevel = paramErrorCorrectionLevel;
  }
  
  public void a(Mode paramMode)
  {
    this.jdField_a_of_type_ComGoogleZxingQrcodeDecoderMode = paramMode;
  }
  
  public void a(io paramio)
  {
    this.jdField_a_of_type_Io = paramio;
  }
  
  public void a(is paramis)
  {
    this.jdField_a_of_type_Is = paramis;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(200);
    localStringBuilder.append("<<\n");
    localStringBuilder.append(" mode: ");
    localStringBuilder.append(this.jdField_a_of_type_ComGoogleZxingQrcodeDecoderMode);
    localStringBuilder.append("\n ecLevel: ");
    localStringBuilder.append(this.jdField_a_of_type_ComGoogleZxingQrcodeDecoderErrorCorrectionLevel);
    localStringBuilder.append("\n version: ");
    localStringBuilder.append(this.jdField_a_of_type_Io);
    localStringBuilder.append("\n maskPattern: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Is == null) {
      localStringBuilder.append("\n matrix: null\n");
    }
    for (;;)
    {
      localStringBuilder.append(">>\n");
      return localStringBuilder.toString();
      localStringBuilder.append("\n matrix:\n");
      localStringBuilder.append(this.jdField_a_of_type_Is.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ix
 * JD-Core Version:    0.7.0.1
 */