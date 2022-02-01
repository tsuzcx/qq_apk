import com.tencent.av.business.manager.magicface.MagicfaceDataAudioJason;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class lhq
{
  private awso jdField_a_of_type_Awso;
  String jdField_a_of_type_JavaLangString;
  private lhl jdField_a_of_type_Lhl;
  lhm jdField_a_of_type_Lhm;
  lhn jdField_a_of_type_Lhn;
  lho jdField_a_of_type_Lho;
  String jdField_b_of_type_JavaLangString;
  lhm jdField_b_of_type_Lhm;
  lhm c = new lhr(this);
  
  public lhq()
  {
    a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Lhl == null)
    {
      if (DeviceInfoUtil.isSupportOpenGlES20())
      {
        this.jdField_a_of_type_Lhl = new lhp();
        lbd.h("AVMagicfacePlayer", "initDecoder| use [MagicfaceNormalDecoder]");
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Lhl = new lhp();
    lbd.h("AVMagicfacePlayer", "initDecoder|use [MagicfaceNormalDecoder]");
  }
  
  public void a(long paramLong, String paramString, lho paramlho, lhn paramlhn, lhm paramlhm)
  {
    if (this.jdField_a_of_type_Lhl.a) {
      try
      {
        this.jdField_b_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_Lho = paramlho;
        this.jdField_a_of_type_Lhn = paramlhn;
        this.jdField_a_of_type_Lhm = paramlhm;
        this.jdField_a_of_type_Lhl.b();
        return;
      }
      finally {}
    }
    QLog.w("AVMagicfacePlayer", 1, "playMagicface, srcPath[" + paramString + "], seq[" + paramLong + "]");
    try
    {
      this.jdField_a_of_type_JavaLangString = (paramString + "audio" + File.separator + paramlho.a.src);
      this.jdField_b_of_type_Lhm = paramlhm;
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_a_of_type_Lho = null;
      this.jdField_a_of_type_Lhn = null;
      this.jdField_a_of_type_Lhm = null;
      if ((paramlho.a.src != null) && (!paramlho.a.src.equals("")) && (this.jdField_a_of_type_Awso == null)) {
        this.jdField_a_of_type_Awso = new awso();
      }
      this.jdField_a_of_type_Lhl.a(paramString);
      this.jdField_a_of_type_Lhl.a(paramlho);
      this.jdField_a_of_type_Lhl.a(paramlhn);
      this.jdField_a_of_type_Lhl.a(this.c);
      this.jdField_a_of_type_Lhl.a();
      return;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Awso != null) {
      this.jdField_a_of_type_Awso.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    lbd.f("AVMagicfacePlayer", "playSound soundSrc = " + paramString + ", loop = " + paramInt);
    if (this.jdField_a_of_type_Awso != null) {
      this.jdField_a_of_type_Awso.a(paramString, paramInt, 0);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Lhl.a;
  }
  
  public void b()
  {
    try
    {
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_a_of_type_Lho = null;
      this.jdField_a_of_type_Lhn = null;
      this.jdField_a_of_type_Lhm = null;
      this.jdField_a_of_type_Lhl.b();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lhq
 * JD-Core Version:    0.7.0.1
 */