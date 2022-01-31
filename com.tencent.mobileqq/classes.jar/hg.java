import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;

public final class hg
{
  private int jdField_a_of_type_Int = -1;
  private ErrorCorrectionLevel jdField_a_of_type_ComGoogleZxingQrcodeDecoderErrorCorrectionLevel;
  private Mode jdField_a_of_type_ComGoogleZxingQrcodeDecoderMode;
  private gx jdField_a_of_type_Gx;
  private hb jdField_a_of_type_Hb;
  
  public static boolean a(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < 8);
  }
  
  public hb a()
  {
    return this.jdField_a_of_type_Hb;
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
  
  public void a(gx paramgx)
  {
    this.jdField_a_of_type_Gx = paramgx;
  }
  
  public void a(hb paramhb)
  {
    this.jdField_a_of_type_Hb = paramhb;
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
    localStringBuilder.append(this.jdField_a_of_type_Gx);
    localStringBuilder.append("\n maskPattern: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Hb == null) {
      localStringBuilder.append("\n matrix: null\n");
    }
    for (;;)
    {
      localStringBuilder.append(">>\n");
      return localStringBuilder.toString();
      localStringBuilder.append("\n matrix:\n");
      localStringBuilder.append(this.jdField_a_of_type_Hb.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     hg
 * JD-Core Version:    0.7.0.1
 */