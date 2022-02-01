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

public abstract class lir
{
  private static lit a;
  protected Typeface a;
  protected VideoAppInterface a;
  protected final List<liq> a;
  protected lis a;
  protected liu a;
  protected lix a;
  
  public lir(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_Lix = ((lix)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0));
    paramVideoAppInterface = d();
    this.jdField_a_of_type_Lix.a(paramLong, paramVideoAppInterface);
  }
  
  public static PointF a(PointF paramPointF)
  {
    if (jdField_a_of_type_Lit == null) {
      jdField_a_of_type_Lit = new lit();
    }
    a("static getSmallPointInBigScreen: " + paramPointF.x + "|" + paramPointF.y);
    return jdField_a_of_type_Lit.a(paramPointF);
  }
  
  public static String a()
  {
    if (jdField_a_of_type_Lit == null) {
      jdField_a_of_type_Lit = new lit();
    }
    return jdField_a_of_type_Lit.a();
  }
  
  public static void a(int paramInt)
  {
    if (jdField_a_of_type_Lit == null) {
      jdField_a_of_type_Lit = new lit();
    }
    a("getSmallScreenPositionType: " + paramInt);
    jdField_a_of_type_Lit.a(paramInt);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Lit == null) {
      jdField_a_of_type_Lit = new lit();
    }
    a("UpdateSmallScreenPosition: " + paramInt1 + "|" + paramInt2);
    jdField_a_of_type_Lit.a(paramInt1, paramInt2);
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
    if (jdField_a_of_type_Lit == null) {
      jdField_a_of_type_Lit = new lit();
    }
    jdField_a_of_type_Lit.a(paramString1, paramString2);
  }
  
  private void a(lgi paramlgi, boolean paramBoolean)
  {
    Object localObject1 = null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    Object localObject3;
    while (localIterator.hasNext())
    {
      localObject3 = (liq)localIterator.next();
      localObject2 = localObject1;
      int j = i;
      if (!((liq)localObject3).a.a())
      {
        localObject2 = localObject1;
        j = i;
        if (((liq)localObject3).a.jdField_a_of_type_JavaLangString.equals(paramlgi.jdField_a_of_type_JavaLangString))
        {
          j = 1;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localObject3;
          }
          ((liq)localObject3).a(paramlgi);
          lbj.c("ARZimuTask", "updateTextInner " + paramlgi.jdField_a_of_type_JavaLangString + " onTextChanged info:" + paramlgi.jdField_a_of_type_JavaLangCharSequence);
        }
      }
      i = j;
      localObject1 = localObject2;
    }
    Object localObject2 = localObject1;
    if (i == 0)
    {
      localObject3 = a(paramlgi, paramBoolean);
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = localObject1;
          if (((List)localObject3).size() > 0) {
            localObject2 = (liq)((List)localObject3).get(0);
          }
        }
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject3);
        lbj.c("ARZimuTask", "updateTextInner " + paramlgi.jdField_a_of_type_JavaLangString + " addinfo:" + paramlgi.jdField_a_of_type_JavaLangCharSequence);
      }
    }
    a((liq)localObject2);
  }
  
  public static void a(boolean paramBoolean)
  {
    if (jdField_a_of_type_Lit == null) {
      jdField_a_of_type_Lit = new lit();
    }
    jdField_a_of_type_Lit.a(paramBoolean);
  }
  
  public static String b()
  {
    if (jdField_a_of_type_Lit == null) {
      jdField_a_of_type_Lit = new lit();
    }
    return jdField_a_of_type_Lit.b();
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Lit == null) {
      jdField_a_of_type_Lit = new lit();
    }
    a("setSmallScreenSize: " + paramInt1 + "|" + paramInt2);
    jdField_a_of_type_Lit.b(paramInt1, paramInt2);
  }
  
  private void b(Observable paramObservable, Object paramObject)
  {
    ((Integer)((Object[])(Object[])paramObject)[0]).intValue();
    a(paramObservable, paramObject);
  }
  
  public static void c(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Lit == null) {
      jdField_a_of_type_Lit = new lit();
    }
    a("setBigScreenSize: " + paramInt1 + "|" + paramInt2);
    jdField_a_of_type_Lit.c(paramInt1, paramInt2);
  }
  
  public abstract int a();
  
  protected abstract List<liq> a(lgi paramlgi, boolean paramBoolean);
  
  public liu a()
  {
    return this.jdField_a_of_type_Liu;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Lis = new lis(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lis);
  }
  
  protected void a(Observable paramObservable, Object paramObject) {}
  
  public void a(lgi paramlgi)
  {
    if ((paramlgi == null) || (TextUtils.isEmpty(paramlgi.jdField_a_of_type_JavaLangCharSequence)) || (TextUtils.isEmpty(paramlgi.jdField_a_of_type_JavaLangString)))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("updateText error:");
      if (paramlgi == null) {}
      for (paramlgi = null;; paramlgi = paramlgi.toString())
      {
        lbj.e("ARZimuTask", paramlgi);
        return;
      }
    }
    lbj.c("ARZimuTask", "updateText :" + paramlgi.toString());
    if (!this.jdField_a_of_type_Lix.a()) {
      this.jdField_a_of_type_Lix.b("updateText1", true);
    }
    a(paramlgi, false);
  }
  
  abstract void a(liq paramliq);
  
  public void a(liu paramliu)
  {
    this.jdField_a_of_type_Liu = paramliu;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Lis != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lis);
    }
  }
  
  public String c()
  {
    Object localObject = d();
    localObject = (ZimuItem)this.jdField_a_of_type_Lix.a((String)localObject);
    if (localObject != null) {}
    for (localObject = this.jdField_a_of_type_Lix.b((lgr)localObject);; localObject = "")
    {
      lbj.c("ARZimuTask", "getGamePlayResoucePath path = " + (String)localObject);
      return localObject;
    }
  }
  
  protected void c()
  {
    String str;
    Object localObject;
    if ((this.jdField_a_of_type_AndroidGraphicsTypeface == null) && (this.jdField_a_of_type_Lix != null))
    {
      str = d();
      localObject = (ZimuItem)this.jdField_a_of_type_Lix.a(str);
      if (localObject != null)
      {
        localObject = this.jdField_a_of_type_Lix.b((lgr)localObject);
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
 * Qualified Name:     lir
 * JD-Core Version:    0.7.0.1
 */