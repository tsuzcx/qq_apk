import com.tencent.av.business.manager.magicface.MagicfaceDataAudioJason;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class lie
{
  private asds jdField_a_of_type_Asds;
  String jdField_a_of_type_JavaLangString;
  private lhz jdField_a_of_type_Lhz;
  lia jdField_a_of_type_Lia;
  lib jdField_a_of_type_Lib;
  lic jdField_a_of_type_Lic;
  String jdField_b_of_type_JavaLangString;
  lia jdField_b_of_type_Lia;
  lia c = new lif(this);
  
  public lie()
  {
    a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Lhz == null)
    {
      if (bbdh.d())
      {
        this.jdField_a_of_type_Lhz = new lid();
        lcg.e("AVMagicfacePlayer", "initDecoder| use [MagicfaceNormalDecoder]");
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Lhz = new lid();
    lcg.e("AVMagicfacePlayer", "initDecoder|use [MagicfaceNormalDecoder]");
  }
  
  public void a(long paramLong, String paramString, lic paramlic, lib paramlib, lia paramlia)
  {
    if (this.jdField_a_of_type_Lhz.a) {
      try
      {
        this.jdField_b_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_Lic = paramlic;
        this.jdField_a_of_type_Lib = paramlib;
        this.jdField_a_of_type_Lia = paramlia;
        this.jdField_a_of_type_Lhz.b();
        return;
      }
      finally {}
    }
    QLog.w("AVMagicfacePlayer", 1, "playMagicface, srcPath[" + paramString + "], seq[" + paramLong + "]");
    try
    {
      this.jdField_a_of_type_JavaLangString = (paramString + "audio" + File.separator + paramlic.a.src);
      this.jdField_b_of_type_Lia = paramlia;
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_a_of_type_Lic = null;
      this.jdField_a_of_type_Lib = null;
      this.jdField_a_of_type_Lia = null;
      if ((paramlic.a.src != null) && (!paramlic.a.src.equals("")) && (this.jdField_a_of_type_Asds == null)) {
        this.jdField_a_of_type_Asds = new asds();
      }
      this.jdField_a_of_type_Lhz.a(paramString);
      this.jdField_a_of_type_Lhz.a(paramlic);
      this.jdField_a_of_type_Lhz.a(paramlib);
      this.jdField_a_of_type_Lhz.a(this.c);
      this.jdField_a_of_type_Lhz.a();
      return;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Asds != null) {
      this.jdField_a_of_type_Asds.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    lcg.c("AVMagicfacePlayer", "playSound soundSrc = " + paramString + ", loop = " + paramInt);
    if (this.jdField_a_of_type_Asds != null) {
      this.jdField_a_of_type_Asds.a(paramString, paramInt, 0);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Lhz.a;
  }
  
  public void b()
  {
    try
    {
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_a_of_type_Lic = null;
      this.jdField_a_of_type_Lib = null;
      this.jdField_a_of_type_Lia = null;
      this.jdField_a_of_type_Lhz.b();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lie
 * JD-Core Version:    0.7.0.1
 */