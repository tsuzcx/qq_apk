import com.tencent.av.business.manager.magicface.MagicfaceDataAudioJason;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class lkh
{
  private atus jdField_a_of_type_Atus;
  String jdField_a_of_type_JavaLangString;
  private lkc jdField_a_of_type_Lkc;
  lkd jdField_a_of_type_Lkd;
  lke jdField_a_of_type_Lke;
  lkf jdField_a_of_type_Lkf;
  String jdField_b_of_type_JavaLangString;
  lkd jdField_b_of_type_Lkd;
  lkd c = new lki(this);
  
  public lkh()
  {
    a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Lkc == null)
    {
      if (bdcb.d())
      {
        this.jdField_a_of_type_Lkc = new lkg();
        lek.e("AVMagicfacePlayer", "initDecoder| use [MagicfaceNormalDecoder]");
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Lkc = new lkg();
    lek.e("AVMagicfacePlayer", "initDecoder|use [MagicfaceNormalDecoder]");
  }
  
  public void a(long paramLong, String paramString, lkf paramlkf, lke paramlke, lkd paramlkd)
  {
    if (this.jdField_a_of_type_Lkc.a) {
      try
      {
        this.jdField_b_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_Lkf = paramlkf;
        this.jdField_a_of_type_Lke = paramlke;
        this.jdField_a_of_type_Lkd = paramlkd;
        this.jdField_a_of_type_Lkc.b();
        return;
      }
      finally {}
    }
    QLog.w("AVMagicfacePlayer", 1, "playMagicface, srcPath[" + paramString + "], seq[" + paramLong + "]");
    try
    {
      this.jdField_a_of_type_JavaLangString = (paramString + "audio" + File.separator + paramlkf.a.src);
      this.jdField_b_of_type_Lkd = paramlkd;
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_a_of_type_Lkf = null;
      this.jdField_a_of_type_Lke = null;
      this.jdField_a_of_type_Lkd = null;
      if ((paramlkf.a.src != null) && (!paramlkf.a.src.equals("")) && (this.jdField_a_of_type_Atus == null)) {
        this.jdField_a_of_type_Atus = new atus();
      }
      this.jdField_a_of_type_Lkc.a(paramString);
      this.jdField_a_of_type_Lkc.a(paramlkf);
      this.jdField_a_of_type_Lkc.a(paramlke);
      this.jdField_a_of_type_Lkc.a(this.c);
      this.jdField_a_of_type_Lkc.a();
      return;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Atus != null) {
      this.jdField_a_of_type_Atus.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    lek.c("AVMagicfacePlayer", "playSound soundSrc = " + paramString + ", loop = " + paramInt);
    if (this.jdField_a_of_type_Atus != null) {
      this.jdField_a_of_type_Atus.a(paramString, paramInt, 0);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Lkc.a;
  }
  
  public void b()
  {
    try
    {
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_a_of_type_Lkf = null;
      this.jdField_a_of_type_Lke = null;
      this.jdField_a_of_type_Lkd = null;
      this.jdField_a_of_type_Lkc.b();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lkh
 * JD-Core Version:    0.7.0.1
 */