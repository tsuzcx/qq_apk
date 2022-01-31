import android.graphics.PointF;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

public abstract class kyy
{
  private static kza a;
  protected Typeface a;
  protected VideoAppInterface a;
  protected final List<kyx> a;
  protected kyz a;
  protected kzb a;
  protected kze a;
  
  public kyy(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_Kze = ((kze)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0));
    paramVideoAppInterface = d();
    this.jdField_a_of_type_Kze.a(paramLong, paramVideoAppInterface);
  }
  
  public static PointF a(PointF paramPointF)
  {
    if (jdField_a_of_type_Kza == null) {
      jdField_a_of_type_Kza = new kza();
    }
    a("static getSmallPointInBigScreen: " + paramPointF.x + "|" + paramPointF.y);
    return jdField_a_of_type_Kza.a(paramPointF);
  }
  
  public static String a()
  {
    if (jdField_a_of_type_Kza == null) {
      jdField_a_of_type_Kza = new kza();
    }
    return jdField_a_of_type_Kza.a();
  }
  
  public static void a(int paramInt)
  {
    if (jdField_a_of_type_Kza == null) {
      jdField_a_of_type_Kza = new kza();
    }
    a("getSmallScreenPositionType: " + paramInt);
    jdField_a_of_type_Kza.a(paramInt);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Kza == null) {
      jdField_a_of_type_Kza = new kza();
    }
    a("UpdateSmallScreenPosition: " + paramInt1 + "|" + paramInt2);
    jdField_a_of_type_Kza.a(paramInt1, paramInt2);
  }
  
  public static void a(String paramString)
  {
    if (paramString == null) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ARZimuTask", 2, paramString);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (jdField_a_of_type_Kza == null) {
      jdField_a_of_type_Kza = new kza();
    }
    jdField_a_of_type_Kza.a(paramString1, paramString2);
  }
  
  private void a(kws paramkws, boolean paramBoolean)
  {
    Object localObject1 = null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    Object localObject3;
    while (localIterator.hasNext())
    {
      localObject3 = (kyx)localIterator.next();
      localObject2 = localObject1;
      int j = i;
      if (!((kyx)localObject3).a.a())
      {
        localObject2 = localObject1;
        j = i;
        if (((kyx)localObject3).a.jdField_a_of_type_JavaLangString.equals(paramkws.jdField_a_of_type_JavaLangString))
        {
          j = 1;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localObject3;
          }
          ((kyx)localObject3).a(paramkws);
          krx.c("ARZimuTask", "updateTextInner " + paramkws.jdField_a_of_type_JavaLangString + " onTextChanged info:" + paramkws.jdField_a_of_type_JavaLangCharSequence);
        }
      }
      i = j;
      localObject1 = localObject2;
    }
    Object localObject2 = localObject1;
    if (i == 0)
    {
      localObject3 = a(paramkws, paramBoolean);
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = localObject1;
          if (((List)localObject3).size() > 0) {
            localObject2 = (kyx)((List)localObject3).get(0);
          }
        }
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject3);
        krx.c("ARZimuTask", "updateTextInner " + paramkws.jdField_a_of_type_JavaLangString + " addinfo:" + paramkws.jdField_a_of_type_JavaLangCharSequence);
      }
    }
    a((kyx)localObject2);
  }
  
  public static void a(boolean paramBoolean)
  {
    if (jdField_a_of_type_Kza == null) {
      jdField_a_of_type_Kza = new kza();
    }
    jdField_a_of_type_Kza.a(paramBoolean);
  }
  
  public static String b()
  {
    if (jdField_a_of_type_Kza == null) {
      jdField_a_of_type_Kza = new kza();
    }
    return jdField_a_of_type_Kza.b();
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Kza == null) {
      jdField_a_of_type_Kza = new kza();
    }
    a("setSmallScreenSize: " + paramInt1 + "|" + paramInt2);
    jdField_a_of_type_Kza.b(paramInt1, paramInt2);
  }
  
  private void b(Observable paramObservable, Object paramObject)
  {
    ((Integer)((Object[])(Object[])paramObject)[0]).intValue();
    a(paramObservable, paramObject);
  }
  
  public static void c(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Kza == null) {
      jdField_a_of_type_Kza = new kza();
    }
    a("setBigScreenSize: " + paramInt1 + "|" + paramInt2);
    jdField_a_of_type_Kza.c(paramInt1, paramInt2);
  }
  
  public abstract int a();
  
  protected abstract List<kyx> a(kws paramkws, boolean paramBoolean);
  
  public kzb a()
  {
    return this.jdField_a_of_type_Kzb;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Kyz = new kyz(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Kyz);
  }
  
  protected void a(Observable paramObservable, Object paramObject) {}
  
  public void a(kws paramkws)
  {
    if ((paramkws == null) || (TextUtils.isEmpty(paramkws.jdField_a_of_type_JavaLangCharSequence)) || (TextUtils.isEmpty(paramkws.jdField_a_of_type_JavaLangString)))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("updateText error:");
      if (paramkws == null) {}
      for (paramkws = null;; paramkws = paramkws.toString())
      {
        krx.e("ARZimuTask", paramkws);
        return;
      }
    }
    krx.c("ARZimuTask", "updateText :" + paramkws.toString());
    if (!this.jdField_a_of_type_Kze.a()) {
      this.jdField_a_of_type_Kze.b("updateText1", true);
    }
    a(paramkws, false);
  }
  
  abstract void a(kyx paramkyx);
  
  public void a(kzb paramkzb)
  {
    this.jdField_a_of_type_Kzb = paramkzb;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Kyz != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Kyz);
    }
  }
  
  public String c()
  {
    Object localObject = d();
    localObject = (ZimuItem)this.jdField_a_of_type_Kze.a((String)localObject);
    if (localObject != null) {}
    for (localObject = this.jdField_a_of_type_Kze.b((kxb)localObject);; localObject = "")
    {
      krx.c("ARZimuTask", "getGamePlayResoucePath path = " + (String)localObject);
      return localObject;
    }
  }
  
  protected void c()
  {
    String str;
    Object localObject;
    if ((this.jdField_a_of_type_AndroidGraphicsTypeface == null) && (this.jdField_a_of_type_Kze != null))
    {
      str = d();
      localObject = (ZimuItem)this.jdField_a_of_type_Kze.a(str);
      if (localObject != null)
      {
        localObject = this.jdField_a_of_type_Kze.b((kxb)localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = new File((String)localObject + "font.ttf");
          if (!((File)localObject).exists()) {
            break label136;
          }
        }
      }
    }
    label136:
    while (!AudioHelper.e()) {
      try
      {
        this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile((File)localObject);
        return;
      }
      catch (Exception localException)
      {
        while (!AudioHelper.e()) {}
        QLog.w("ARZimuTask", 1, "createTypeface, Exception, id[" + str + "]", localException);
        return;
      }
    }
    QLog.w("ARZimuTask", 1, "createTypeface, 不存在, file[" + localException.getAbsolutePath() + "], id[" + str + "]");
  }
  
  public abstract String d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kyy
 * JD-Core Version:    0.7.0.1
 */