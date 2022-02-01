import com.tencent.av.business.manager.magicface.MagicfaceDataAudioJason;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class lhe
{
  private avmj jdField_a_of_type_Avmj;
  String jdField_a_of_type_JavaLangString;
  private lgz jdField_a_of_type_Lgz;
  lha jdField_a_of_type_Lha;
  lhb jdField_a_of_type_Lhb;
  lhc jdField_a_of_type_Lhc;
  String jdField_b_of_type_JavaLangString;
  lha jdField_b_of_type_Lha;
  lha c = new lhf(this);
  
  public lhe()
  {
    a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Lgz == null)
    {
      if (DeviceInfoUtil.isSupportOpenGlES20())
      {
        this.jdField_a_of_type_Lgz = new lhd();
        lba.h("AVMagicfacePlayer", "initDecoder| use [MagicfaceNormalDecoder]");
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Lgz = new lhd();
    lba.h("AVMagicfacePlayer", "initDecoder|use [MagicfaceNormalDecoder]");
  }
  
  public void a(long paramLong, String paramString, lhc paramlhc, lhb paramlhb, lha paramlha)
  {
    if (this.jdField_a_of_type_Lgz.a) {
      try
      {
        this.jdField_b_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_Lhc = paramlhc;
        this.jdField_a_of_type_Lhb = paramlhb;
        this.jdField_a_of_type_Lha = paramlha;
        this.jdField_a_of_type_Lgz.b();
        return;
      }
      finally {}
    }
    QLog.w("AVMagicfacePlayer", 1, "playMagicface, srcPath[" + paramString + "], seq[" + paramLong + "]");
    try
    {
      this.jdField_a_of_type_JavaLangString = (paramString + "audio" + File.separator + paramlhc.a.src);
      this.jdField_b_of_type_Lha = paramlha;
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_a_of_type_Lhc = null;
      this.jdField_a_of_type_Lhb = null;
      this.jdField_a_of_type_Lha = null;
      if ((paramlhc.a.src != null) && (!paramlhc.a.src.equals("")) && (this.jdField_a_of_type_Avmj == null)) {
        this.jdField_a_of_type_Avmj = new avmj();
      }
      this.jdField_a_of_type_Lgz.a(paramString);
      this.jdField_a_of_type_Lgz.a(paramlhc);
      this.jdField_a_of_type_Lgz.a(paramlhb);
      this.jdField_a_of_type_Lgz.a(this.c);
      this.jdField_a_of_type_Lgz.a();
      return;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Avmj != null) {
      this.jdField_a_of_type_Avmj.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    lba.f("AVMagicfacePlayer", "playSound soundSrc = " + paramString + ", loop = " + paramInt);
    if (this.jdField_a_of_type_Avmj != null) {
      this.jdField_a_of_type_Avmj.a(paramString, paramInt, 0);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Lgz.a;
  }
  
  public void b()
  {
    try
    {
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_a_of_type_Lhc = null;
      this.jdField_a_of_type_Lhb = null;
      this.jdField_a_of_type_Lha = null;
      this.jdField_a_of_type_Lgz.b();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lhe
 * JD-Core Version:    0.7.0.1
 */