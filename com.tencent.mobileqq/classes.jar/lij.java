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

public abstract class lij
{
  private static lil a;
  protected Typeface a;
  protected VideoAppInterface a;
  protected final List<lii> a;
  protected lik a;
  protected lim a;
  protected lip a;
  
  public lij(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_Lip = ((lip)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0));
    paramVideoAppInterface = d();
    this.jdField_a_of_type_Lip.a(paramLong, paramVideoAppInterface);
  }
  
  public static PointF a(PointF paramPointF)
  {
    if (jdField_a_of_type_Lil == null) {
      jdField_a_of_type_Lil = new lil();
    }
    a("static getSmallPointInBigScreen: " + paramPointF.x + "|" + paramPointF.y);
    return jdField_a_of_type_Lil.a(paramPointF);
  }
  
  public static String a()
  {
    if (jdField_a_of_type_Lil == null) {
      jdField_a_of_type_Lil = new lil();
    }
    return jdField_a_of_type_Lil.a();
  }
  
  public static void a(int paramInt)
  {
    if (jdField_a_of_type_Lil == null) {
      jdField_a_of_type_Lil = new lil();
    }
    a("getSmallScreenPositionType: " + paramInt);
    jdField_a_of_type_Lil.a(paramInt);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Lil == null) {
      jdField_a_of_type_Lil = new lil();
    }
    a("UpdateSmallScreenPosition: " + paramInt1 + "|" + paramInt2);
    jdField_a_of_type_Lil.a(paramInt1, paramInt2);
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
    if (jdField_a_of_type_Lil == null) {
      jdField_a_of_type_Lil = new lil();
    }
    jdField_a_of_type_Lil.a(paramString1, paramString2);
  }
  
  private void a(lga paramlga, boolean paramBoolean)
  {
    Object localObject1 = null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    Object localObject3;
    while (localIterator.hasNext())
    {
      localObject3 = (lii)localIterator.next();
      localObject2 = localObject1;
      int j = i;
      if (!((lii)localObject3).a.a())
      {
        localObject2 = localObject1;
        j = i;
        if (((lii)localObject3).a.jdField_a_of_type_JavaLangString.equals(paramlga.jdField_a_of_type_JavaLangString))
        {
          j = 1;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localObject3;
          }
          ((lii)localObject3).a(paramlga);
          lbc.c("ARZimuTask", "updateTextInner " + paramlga.jdField_a_of_type_JavaLangString + " onTextChanged info:" + paramlga.jdField_a_of_type_JavaLangCharSequence);
        }
      }
      i = j;
      localObject1 = localObject2;
    }
    Object localObject2 = localObject1;
    if (i == 0)
    {
      localObject3 = a(paramlga, paramBoolean);
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = localObject1;
          if (((List)localObject3).size() > 0) {
            localObject2 = (lii)((List)localObject3).get(0);
          }
        }
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject3);
        lbc.c("ARZimuTask", "updateTextInner " + paramlga.jdField_a_of_type_JavaLangString + " addinfo:" + paramlga.jdField_a_of_type_JavaLangCharSequence);
      }
    }
    a((lii)localObject2);
  }
  
  public static void a(boolean paramBoolean)
  {
    if (jdField_a_of_type_Lil == null) {
      jdField_a_of_type_Lil = new lil();
    }
    jdField_a_of_type_Lil.a(paramBoolean);
  }
  
  public static String b()
  {
    if (jdField_a_of_type_Lil == null) {
      jdField_a_of_type_Lil = new lil();
    }
    return jdField_a_of_type_Lil.b();
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Lil == null) {
      jdField_a_of_type_Lil = new lil();
    }
    a("setSmallScreenSize: " + paramInt1 + "|" + paramInt2);
    jdField_a_of_type_Lil.b(paramInt1, paramInt2);
  }
  
  private void b(Observable paramObservable, Object paramObject)
  {
    ((Integer)((Object[])(Object[])paramObject)[0]).intValue();
    a(paramObservable, paramObject);
  }
  
  public static void c(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Lil == null) {
      jdField_a_of_type_Lil = new lil();
    }
    a("setBigScreenSize: " + paramInt1 + "|" + paramInt2);
    jdField_a_of_type_Lil.c(paramInt1, paramInt2);
  }
  
  public abstract int a();
  
  protected abstract List<lii> a(lga paramlga, boolean paramBoolean);
  
  public lim a()
  {
    return this.jdField_a_of_type_Lim;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Lik = new lik(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lik);
  }
  
  protected void a(Observable paramObservable, Object paramObject) {}
  
  public void a(lga paramlga)
  {
    if ((paramlga == null) || (TextUtils.isEmpty(paramlga.jdField_a_of_type_JavaLangCharSequence)) || (TextUtils.isEmpty(paramlga.jdField_a_of_type_JavaLangString)))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("updateText error:");
      if (paramlga == null) {}
      for (paramlga = null;; paramlga = paramlga.toString())
      {
        lbc.e("ARZimuTask", paramlga);
        return;
      }
    }
    lbc.c("ARZimuTask", "updateText :" + paramlga.toString());
    if (!this.jdField_a_of_type_Lip.a()) {
      this.jdField_a_of_type_Lip.b("updateText1", true);
    }
    a(paramlga, false);
  }
  
  abstract void a(lii paramlii);
  
  public void a(lim paramlim)
  {
    this.jdField_a_of_type_Lim = paramlim;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Lik != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lik);
    }
  }
  
  public String c()
  {
    Object localObject = d();
    localObject = (ZimuItem)this.jdField_a_of_type_Lip.a((String)localObject);
    if (localObject != null) {}
    for (localObject = this.jdField_a_of_type_Lip.b((lgj)localObject);; localObject = "")
    {
      lbc.c("ARZimuTask", "getGamePlayResoucePath path = " + (String)localObject);
      return localObject;
    }
  }
  
  protected void c()
  {
    String str;
    Object localObject;
    if ((this.jdField_a_of_type_AndroidGraphicsTypeface == null) && (this.jdField_a_of_type_Lip != null))
    {
      str = d();
      localObject = (ZimuItem)this.jdField_a_of_type_Lip.a(str);
      if (localObject != null)
      {
        localObject = this.jdField_a_of_type_Lip.b((lgj)localObject);
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
    while (!AudioHelper.f()) {
      try
      {
        this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile((File)localObject);
        return;
      }
      catch (Exception localException)
      {
        while (!AudioHelper.f()) {}
        QLog.w("ARZimuTask", 1, "createTypeface, Exception, id[" + str + "]", localException);
        return;
      }
    }
    QLog.w("ARZimuTask", 1, "createTypeface, 不存在, file[" + localException.getAbsolutePath() + "], id[" + str + "]");
  }
  
  public abstract String d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lij
 * JD-Core Version:    0.7.0.1
 */