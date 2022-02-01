import com.tencent.av.business.manager.magicface.MagicfaceDataAudioJason;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class lhk
{
  private awzc jdField_a_of_type_Awzc;
  String jdField_a_of_type_JavaLangString;
  private lhf jdField_a_of_type_Lhf;
  lhg jdField_a_of_type_Lhg;
  lhh jdField_a_of_type_Lhh;
  lhi jdField_a_of_type_Lhi;
  String jdField_b_of_type_JavaLangString;
  lhg jdField_b_of_type_Lhg;
  lhg c = new lhl(this);
  
  public lhk()
  {
    a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Lhf == null)
    {
      if (bhlo.d())
      {
        this.jdField_a_of_type_Lhf = new lhj();
        lbj.e("AVMagicfacePlayer", "initDecoder| use [MagicfaceNormalDecoder]");
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Lhf = new lhj();
    lbj.e("AVMagicfacePlayer", "initDecoder|use [MagicfaceNormalDecoder]");
  }
  
  public void a(long paramLong, String paramString, lhi paramlhi, lhh paramlhh, lhg paramlhg)
  {
    if (this.jdField_a_of_type_Lhf.a) {
      try
      {
        this.jdField_b_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_Lhi = paramlhi;
        this.jdField_a_of_type_Lhh = paramlhh;
        this.jdField_a_of_type_Lhg = paramlhg;
        this.jdField_a_of_type_Lhf.b();
        return;
      }
      finally {}
    }
    QLog.w("AVMagicfacePlayer", 1, "playMagicface, srcPath[" + paramString + "], seq[" + paramLong + "]");
    try
    {
      this.jdField_a_of_type_JavaLangString = (paramString + "audio" + File.separator + paramlhi.a.src);
      this.jdField_b_of_type_Lhg = paramlhg;
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_a_of_type_Lhi = null;
      this.jdField_a_of_type_Lhh = null;
      this.jdField_a_of_type_Lhg = null;
      if ((paramlhi.a.src != null) && (!paramlhi.a.src.equals("")) && (this.jdField_a_of_type_Awzc == null)) {
        this.jdField_a_of_type_Awzc = new awzc();
      }
      this.jdField_a_of_type_Lhf.a(paramString);
      this.jdField_a_of_type_Lhf.a(paramlhi);
      this.jdField_a_of_type_Lhf.a(paramlhh);
      this.jdField_a_of_type_Lhf.a(this.c);
      this.jdField_a_of_type_Lhf.a();
      return;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Awzc != null) {
      this.jdField_a_of_type_Awzc.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    lbj.c("AVMagicfacePlayer", "playSound soundSrc = " + paramString + ", loop = " + paramInt);
    if (this.jdField_a_of_type_Awzc != null) {
      this.jdField_a_of_type_Awzc.a(paramString, paramInt, 0);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Lhf.a;
  }
  
  public void b()
  {
    try
    {
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_a_of_type_Lhi = null;
      this.jdField_a_of_type_Lhh = null;
      this.jdField_a_of_type_Lhg = null;
      this.jdField_a_of_type_Lhf.b();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lhk
 * JD-Core Version:    0.7.0.1
 */