import com.tencent.av.business.manager.magicface.MagicfaceDataAudioJason;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class lhc
{
  private awgk jdField_a_of_type_Awgk;
  String jdField_a_of_type_JavaLangString;
  private lgx jdField_a_of_type_Lgx;
  lgy jdField_a_of_type_Lgy;
  lgz jdField_a_of_type_Lgz;
  lha jdField_a_of_type_Lha;
  String jdField_b_of_type_JavaLangString;
  lgy jdField_b_of_type_Lgy;
  lgy c = new lhd(this);
  
  public lhc()
  {
    a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Lgx == null)
    {
      if (bgln.d())
      {
        this.jdField_a_of_type_Lgx = new lhb();
        lbc.e("AVMagicfacePlayer", "initDecoder| use [MagicfaceNormalDecoder]");
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Lgx = new lhb();
    lbc.e("AVMagicfacePlayer", "initDecoder|use [MagicfaceNormalDecoder]");
  }
  
  public void a(long paramLong, String paramString, lha paramlha, lgz paramlgz, lgy paramlgy)
  {
    if (this.jdField_a_of_type_Lgx.a) {
      try
      {
        this.jdField_b_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_Lha = paramlha;
        this.jdField_a_of_type_Lgz = paramlgz;
        this.jdField_a_of_type_Lgy = paramlgy;
        this.jdField_a_of_type_Lgx.b();
        return;
      }
      finally {}
    }
    QLog.w("AVMagicfacePlayer", 1, "playMagicface, srcPath[" + paramString + "], seq[" + paramLong + "]");
    try
    {
      this.jdField_a_of_type_JavaLangString = (paramString + "audio" + File.separator + paramlha.a.src);
      this.jdField_b_of_type_Lgy = paramlgy;
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_a_of_type_Lha = null;
      this.jdField_a_of_type_Lgz = null;
      this.jdField_a_of_type_Lgy = null;
      if ((paramlha.a.src != null) && (!paramlha.a.src.equals("")) && (this.jdField_a_of_type_Awgk == null)) {
        this.jdField_a_of_type_Awgk = new awgk();
      }
      this.jdField_a_of_type_Lgx.a(paramString);
      this.jdField_a_of_type_Lgx.a(paramlha);
      this.jdField_a_of_type_Lgx.a(paramlgz);
      this.jdField_a_of_type_Lgx.a(this.c);
      this.jdField_a_of_type_Lgx.a();
      return;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Awgk != null) {
      this.jdField_a_of_type_Awgk.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    lbc.c("AVMagicfacePlayer", "playSound soundSrc = " + paramString + ", loop = " + paramInt);
    if (this.jdField_a_of_type_Awgk != null) {
      this.jdField_a_of_type_Awgk.a(paramString, paramInt, 0);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Lgx.a;
  }
  
  public void b()
  {
    try
    {
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_a_of_type_Lha = null;
      this.jdField_a_of_type_Lgz = null;
      this.jdField_a_of_type_Lgy = null;
      this.jdField_a_of_type_Lgx.b();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lhc
 * JD-Core Version:    0.7.0.1
 */