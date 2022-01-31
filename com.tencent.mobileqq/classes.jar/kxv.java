import com.tencent.av.business.manager.magicface.MagicfaceDataAudioJason;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class kxv
{
  private arho jdField_a_of_type_Arho;
  String jdField_a_of_type_JavaLangString;
  private kxq jdField_a_of_type_Kxq;
  kxr jdField_a_of_type_Kxr;
  kxs jdField_a_of_type_Kxs;
  kxt jdField_a_of_type_Kxt;
  String jdField_b_of_type_JavaLangString;
  kxr jdField_b_of_type_Kxr;
  kxr c = new kxw(this);
  
  public kxv()
  {
    a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Kxq == null)
    {
      if (babp.d())
      {
        this.jdField_a_of_type_Kxq = new kxu();
        krx.e("AVMagicfacePlayer", "initDecoder| use [MagicfaceNormalDecoder]");
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Kxq = new kxu();
    krx.e("AVMagicfacePlayer", "initDecoder|use [MagicfaceNormalDecoder]");
  }
  
  public void a(long paramLong, String paramString, kxt paramkxt, kxs paramkxs, kxr paramkxr)
  {
    if (this.jdField_a_of_type_Kxq.a) {
      try
      {
        this.jdField_b_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_Kxt = paramkxt;
        this.jdField_a_of_type_Kxs = paramkxs;
        this.jdField_a_of_type_Kxr = paramkxr;
        this.jdField_a_of_type_Kxq.b();
        return;
      }
      finally {}
    }
    QLog.w("AVMagicfacePlayer", 1, "playMagicface, srcPath[" + paramString + "], seq[" + paramLong + "]");
    try
    {
      this.jdField_a_of_type_JavaLangString = (paramString + "audio" + File.separator + paramkxt.a.src);
      this.jdField_b_of_type_Kxr = paramkxr;
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_a_of_type_Kxt = null;
      this.jdField_a_of_type_Kxs = null;
      this.jdField_a_of_type_Kxr = null;
      if ((paramkxt.a.src != null) && (!paramkxt.a.src.equals("")) && (this.jdField_a_of_type_Arho == null)) {
        this.jdField_a_of_type_Arho = new arho();
      }
      this.jdField_a_of_type_Kxq.a(paramString);
      this.jdField_a_of_type_Kxq.a(paramkxt);
      this.jdField_a_of_type_Kxq.a(paramkxs);
      this.jdField_a_of_type_Kxq.a(this.c);
      this.jdField_a_of_type_Kxq.a();
      return;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Arho != null) {
      this.jdField_a_of_type_Arho.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    krx.c("AVMagicfacePlayer", "playSound soundSrc = " + paramString + ", loop = " + paramInt);
    if (this.jdField_a_of_type_Arho != null) {
      this.jdField_a_of_type_Arho.a(paramString, paramInt, 0);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Kxq.a;
  }
  
  public void b()
  {
    try
    {
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_a_of_type_Kxt = null;
      this.jdField_a_of_type_Kxs = null;
      this.jdField_a_of_type_Kxr = null;
      this.jdField_a_of_type_Kxq.b();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kxv
 * JD-Core Version:    0.7.0.1
 */