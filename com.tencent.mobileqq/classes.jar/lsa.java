import android.content.Context;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.util.List;

public class lsa
  extends YUVTexture
{
  private static String jdField_a_of_type_JavaLangString;
  private static String b;
  private static boolean e;
  private static boolean f;
  public static int n = 480;
  private static int o = 1;
  private lru jdField_a_of_type_Lru;
  private meu jdField_a_of_type_Meu;
  
  public lsa(Context paramContext, meu parammeu, String paramString, long paramLong)
  {
    super(paramContext, paramString, paramLong);
    this.jdField_a_of_type_Meu = parammeu;
  }
  
  private static void a(Context paramContext)
  {
    int i = 0;
    if (e) {}
    for (;;)
    {
      return;
      e = true;
      if (jdField_a_of_type_JavaLangString == null) {
        jdField_a_of_type_JavaLangString = DeviceInfoUtil.getQQVersion();
      }
      paramContext = loo.a();
      f = false;
      if ((paramContext == null) || (paramContext.jdField_a_of_type_Int != 1)) {
        continue;
      }
      n = paramContext.b;
      o = paramContext.c;
      jdField_b_of_type_JavaLangString = paramContext.jdField_a_of_type_JavaLangString;
      try
      {
        if ((TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))) {
          continue;
        }
        paramContext = jdField_b_of_type_JavaLangString.split("\\.");
        String[] arrayOfString = jdField_a_of_type_JavaLangString.split("\\.");
        while ((i < 3) && (i < paramContext.length) && (i < arrayOfString.length))
        {
          if (Integer.valueOf(arrayOfString[i]).intValue() > Integer.valueOf(paramContext[i]).intValue())
          {
            f = true;
            return;
          }
          if (Integer.valueOf(arrayOfString[i]).intValue() < Integer.valueOf(paramContext[i]).intValue())
          {
            f = false;
            return;
          }
          if (i == 2) {
            f = true;
          }
          i += 1;
        }
        return;
      }
      catch (Exception paramContext) {}
    }
  }
  
  public lrp[] a(lqo paramlqo)
  {
    if (a() > b())
    {
      i = a();
      a(this.jdField_a_of_type_AndroidContentContext);
      if ((!f) || (getImgWidth() > n) || (i <= ((lqp)paramlqo).c() / 3 * 2) || (getImgWidth() >= i) || (getImgWidth() == 0) || (this.jdField_a_of_type_Meu.a().size() != 0) || (VideoController.a().a().d != 2)) {
        break label211;
      }
    }
    label211:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (this.jdField_a_of_type_Lru == null) {
          this.jdField_a_of_type_Lru = lru.a();
        }
        super.a(paramlqo);
        if (super.a() != null) {
          this.jdField_a_of_type_Lru.a(paramlqo, getImgWidth(), getImgHeight(), ((lqp)paramlqo).c(), ((lqp)paramlqo).d(), a()[0], a()[1], a()[2], this.jdField_b_of_type_ArrayOfFloat, this.k, o);
        }
        return lrn.a(0).a();
        i = b();
        break;
      }
      return super.a(paramlqo);
    }
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Lru != null) {
      this.jdField_a_of_type_Lru.a();
    }
    e = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lsa
 * JD-Core Version:    0.7.0.1
 */