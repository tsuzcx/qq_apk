import com.tencent.av.business.manager.magicface.MagicfaceDataAudioJason;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class lij
{
  private asdq jdField_a_of_type_Asdq;
  String jdField_a_of_type_JavaLangString;
  private lie jdField_a_of_type_Lie;
  lif jdField_a_of_type_Lif;
  lig jdField_a_of_type_Lig;
  lih jdField_a_of_type_Lih;
  String jdField_b_of_type_JavaLangString;
  lif jdField_b_of_type_Lif;
  lif c = new lik(this);
  
  public lij()
  {
    a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Lie == null)
    {
      if (bbct.d())
      {
        this.jdField_a_of_type_Lie = new lii();
        lcl.e("AVMagicfacePlayer", "initDecoder| use [MagicfaceNormalDecoder]");
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Lie = new lii();
    lcl.e("AVMagicfacePlayer", "initDecoder|use [MagicfaceNormalDecoder]");
  }
  
  public void a(long paramLong, String paramString, lih paramlih, lig paramlig, lif paramlif)
  {
    if (this.jdField_a_of_type_Lie.a) {
      try
      {
        this.jdField_b_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_Lih = paramlih;
        this.jdField_a_of_type_Lig = paramlig;
        this.jdField_a_of_type_Lif = paramlif;
        this.jdField_a_of_type_Lie.b();
        return;
      }
      finally {}
    }
    QLog.w("AVMagicfacePlayer", 1, "playMagicface, srcPath[" + paramString + "], seq[" + paramLong + "]");
    try
    {
      this.jdField_a_of_type_JavaLangString = (paramString + "audio" + File.separator + paramlih.a.src);
      this.jdField_b_of_type_Lif = paramlif;
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_a_of_type_Lih = null;
      this.jdField_a_of_type_Lig = null;
      this.jdField_a_of_type_Lif = null;
      if ((paramlih.a.src != null) && (!paramlih.a.src.equals("")) && (this.jdField_a_of_type_Asdq == null)) {
        this.jdField_a_of_type_Asdq = new asdq();
      }
      this.jdField_a_of_type_Lie.a(paramString);
      this.jdField_a_of_type_Lie.a(paramlih);
      this.jdField_a_of_type_Lie.a(paramlig);
      this.jdField_a_of_type_Lie.a(this.c);
      this.jdField_a_of_type_Lie.a();
      return;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Asdq != null) {
      this.jdField_a_of_type_Asdq.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    lcl.c("AVMagicfacePlayer", "playSound soundSrc = " + paramString + ", loop = " + paramInt);
    if (this.jdField_a_of_type_Asdq != null) {
      this.jdField_a_of_type_Asdq.a(paramString, paramInt, 0);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Lie.a;
  }
  
  public void b()
  {
    try
    {
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_a_of_type_Lih = null;
      this.jdField_a_of_type_Lig = null;
      this.jdField_a_of_type_Lif = null;
      this.jdField_a_of_type_Lie.b();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lij
 * JD-Core Version:    0.7.0.1
 */