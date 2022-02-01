import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class mzt
  extends mxw
{
  private static mzt jdField_a_of_type_Mzt;
  private int jdField_a_of_type_Int = 0;
  private String jdField_a_of_type_JavaLangString;
  private List<String> jdField_a_of_type_JavaUtilList;
  
  private mzt()
  {
    e();
  }
  
  private float a(String paramString)
  {
    paramString = ardc.a().a(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return 0.5F;
    }
    return Float.parseFloat(paramString);
  }
  
  private int a(String paramString)
  {
    if ("succeed".equals(paramString)) {
      return 0;
    }
    if ("failed".equals(paramString)) {
      return 1;
    }
    return -1;
  }
  
  private String a(int paramInt)
  {
    List localList = ardc.a().a(paramInt);
    if ((localList == null) || (localList.size() <= 0)) {
      return "";
    }
    return (String)localList.get(0);
  }
  
  private String a(myp parammyp, String paramString)
  {
    if (("over".equals(paramString)) || (parammyp == null) || (parammyp.b() != 3))
    {
      QLog.d("AvGameMusicPlayer", 1, "isVideoEffectValid() is game over or iTopic is empty ");
      return null;
    }
    int i = a(paramString);
    if (-1 == i)
    {
      QLog.d("AvGameMusicPlayer", 1, String.format("isVideoEffectValid() index is invalid [index] %d ", new Object[] { Integer.valueOf(i) }));
      return null;
    }
    parammyp = ((mzo)parammyp).a(i);
    if (parammyp == null)
    {
      QLog.d("AvGameMusicPlayer", 1, "isVideoEffectValid() res is null ");
      return null;
    }
    parammyp = mzy.a(parammyp.b(), ".mp3");
    if (!bhmi.a(parammyp))
    {
      QLog.d("AvGameMusicPlayer", 1, String.format("isVideoEffectValid() effectFile is not exist [effectFile] %s ", new Object[] { parammyp }));
      return null;
    }
    return parammyp;
  }
  
  public static mzt a()
  {
    if (jdField_a_of_type_Mzt == null) {}
    try
    {
      if (jdField_a_of_type_Mzt == null) {
        jdField_a_of_type_Mzt = new mzt();
      }
      return jdField_a_of_type_Mzt;
    }
    finally {}
  }
  
  private boolean a(int paramInt1, String paramString, int paramInt2, float paramFloat)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    try
    {
      QLog.d("AvGameMusicPlayer", 1, "playInner() mixSrcType = " + paramInt1 + " fileName = " + paramString + " times = " + paramInt2 + " volumeScale =" + paramFloat);
      bool1 = bool3;
      if (Build.VERSION.SDK_INT >= 16)
      {
        bool1 = bool3;
        bool3 = mwx.a().a(paramInt1);
        bool1 = bool3;
        mwx.a().a(paramString, 1, paramFloat, paramInt2);
        bool2 = bool3;
        bool1 = bool3;
        if (!this.jdField_a_of_type_JavaUtilList.contains(paramString))
        {
          bool1 = bool3;
          this.jdField_a_of_type_JavaUtilList.add(paramString);
          bool2 = bool3;
        }
      }
      return bool2;
    }
    catch (Exception paramString)
    {
      QLog.d("AvGameMusicPlayer", 1, "playBgMusic() e = " + paramString);
    }
    return bool1;
  }
  
  public static void b()
  {
    if (jdField_a_of_type_Mzt != null) {
      a().d();
    }
  }
  
  private void e()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      QLog.d("AvGameMusicPlayer", 1, "init() ");
      mwx.a(bkdd.a().a());
    }
    nfm.b().a(this);
    this.jdField_a_of_type_JavaLangString = mzu.b();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public void a(String paramString, boolean paramBoolean, float paramFloat)
  {
    if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      QLog.d("AvGameMusicPlayer", 1, String.format("playBgMusic() filePath or fileName is empty just return [bgMusicFileName,resPath,volumeScale] %s , %s , %f", new Object[] { paramString, this.jdField_a_of_type_JavaLangString, Float.valueOf(paramFloat) }));
      return;
    }
    paramString = this.jdField_a_of_type_JavaLangString + paramString + ".mp3";
    int i;
    if (paramBoolean)
    {
      i = 2147483647;
      label86:
      if (Build.VERSION.SDK_INT < 16) {
        break label160;
      }
      this.jdField_a_of_type_Int = 1;
      paramBoolean = a(3, paramString, i, paramFloat);
      if (!paramBoolean) {
        break label162;
      }
      paramString = "0X800B053";
      label116:
      if (!paramBoolean) {
        break label168;
      }
    }
    label160:
    label162:
    label168:
    for (String str = "0X800B053";; str = "0X800B054")
    {
      bdll.b(null, "dc00898", "", "", paramString, str, myk.a().a().d(), 0, "", "", "", "");
      return;
      i = 1;
      break label86;
      break;
      paramString = "0X800B054";
      break label116;
    }
  }
  
  public void a(myp parammyp, String paramString)
  {
    String str = a(parammyp, paramString);
    parammyp = str;
    if (TextUtils.isEmpty(str)) {
      parammyp = this.jdField_a_of_type_JavaLangString + paramString + ".mp3";
    }
    b(parammyp, false, 0.5F);
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("AvGameMusicPlayer", 1, "onSystemCallStateChanged() isCalling =" + paramBoolean + " playingBgStatus =" + this.jdField_a_of_type_Int);
    if ((Build.VERSION.SDK_INT >= 16) && (this.jdField_a_of_type_Int == 1))
    {
      if (paramBoolean)
      {
        mwx.a().d();
        this.jdField_a_of_type_Int = 2;
      }
    }
    else {
      return;
    }
    mwx.a().e();
    this.jdField_a_of_type_Int = 1;
  }
  
  public void b(String paramString, boolean paramBoolean, float paramFloat)
  {
    int i;
    if (paramBoolean)
    {
      i = 2147483647;
      if (Build.VERSION.SDK_INT >= 16)
      {
        paramBoolean = a(3, paramString, i, paramFloat);
        if (!paramBoolean) {
          break label81;
        }
        paramString = "0X800B055";
        label34:
        if (!paramBoolean) {
          break label88;
        }
      }
    }
    label81:
    label88:
    for (String str = "0X800B055";; str = "0X800B056")
    {
      bdll.b(null, "dc00898", "", "", paramString, str, myk.a().a().d(), 0, "", "", "", "");
      return;
      i = 1;
      break;
      paramString = "0X800B056";
      break label34;
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameMusicPlayer", 2, "stopPlay() ");
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.jdField_a_of_type_Int = 3;
      mwx.a().c();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        mwx.a().a(str);
      }
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Int = 0;
    nfm.b().b(this);
    jdField_a_of_type_Mzt = null;
    if (Build.VERSION.SDK_INT >= 16)
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          mwx.a().a(str);
        }
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList = null;
      }
      QLog.d("AvGameMusicPlayer", 1, "destroy() ");
      mwx.a();
      mwx.a();
    }
  }
  
  public void d(int paramInt)
  {
    String str = a(paramInt);
    float f = a(str);
    if (QLog.isColorLevel()) {
      QLog.d("AvGameMusicPlayer", 2, String.format("playBgMusic() [gameType, gameBgName] %d , %s", new Object[] { Integer.valueOf(paramInt), str }));
    }
    a(str, true, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mzt
 * JD-Core Version:    0.7.0.1
 */