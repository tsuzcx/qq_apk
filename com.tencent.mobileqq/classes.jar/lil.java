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

public abstract class lil
{
  private static lin a;
  protected Typeface a;
  protected VideoAppInterface a;
  protected final List<lik> a;
  protected lim a;
  protected lio a;
  protected lir a;
  
  public lil(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_Lir = ((lir)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0));
    paramVideoAppInterface = d();
    this.jdField_a_of_type_Lir.a(paramLong, paramVideoAppInterface);
  }
  
  public static PointF a(PointF paramPointF)
  {
    if (jdField_a_of_type_Lin == null) {
      jdField_a_of_type_Lin = new lin();
    }
    a("static getSmallPointInBigScreen: " + paramPointF.x + "|" + paramPointF.y);
    return jdField_a_of_type_Lin.a(paramPointF);
  }
  
  public static String a()
  {
    if (jdField_a_of_type_Lin == null) {
      jdField_a_of_type_Lin = new lin();
    }
    return jdField_a_of_type_Lin.a();
  }
  
  public static void a(int paramInt)
  {
    if (jdField_a_of_type_Lin == null) {
      jdField_a_of_type_Lin = new lin();
    }
    a("getSmallScreenPositionType: " + paramInt);
    jdField_a_of_type_Lin.a(paramInt);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Lin == null) {
      jdField_a_of_type_Lin = new lin();
    }
    a("UpdateSmallScreenPosition: " + paramInt1 + "|" + paramInt2);
    jdField_a_of_type_Lin.a(paramInt1, paramInt2);
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
    if (jdField_a_of_type_Lin == null) {
      jdField_a_of_type_Lin = new lin();
    }
    jdField_a_of_type_Lin.a(paramString1, paramString2);
  }
  
  private void a(lgc paramlgc, boolean paramBoolean)
  {
    Object localObject1 = null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    Object localObject3;
    while (localIterator.hasNext())
    {
      localObject3 = (lik)localIterator.next();
      localObject2 = localObject1;
      int j = i;
      if (!((lik)localObject3).a.a())
      {
        localObject2 = localObject1;
        j = i;
        if (((lik)localObject3).a.jdField_a_of_type_JavaLangString.equals(paramlgc.jdField_a_of_type_JavaLangString))
        {
          j = 1;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localObject3;
          }
          ((lik)localObject3).a(paramlgc);
          lba.f("ARZimuTask", "updateTextInner " + paramlgc.jdField_a_of_type_JavaLangString + " onTextChanged info:" + paramlgc.jdField_a_of_type_JavaLangCharSequence);
        }
      }
      i = j;
      localObject1 = localObject2;
    }
    Object localObject2 = localObject1;
    if (i == 0)
    {
      localObject3 = a(paramlgc, paramBoolean);
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = localObject1;
          if (((List)localObject3).size() > 0) {
            localObject2 = (lik)((List)localObject3).get(0);
          }
        }
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject3);
        lba.f("ARZimuTask", "updateTextInner " + paramlgc.jdField_a_of_type_JavaLangString + " addinfo:" + paramlgc.jdField_a_of_type_JavaLangCharSequence);
      }
    }
    a((lik)localObject2);
  }
  
  public static void a(boolean paramBoolean)
  {
    if (jdField_a_of_type_Lin == null) {
      jdField_a_of_type_Lin = new lin();
    }
    jdField_a_of_type_Lin.a(paramBoolean);
  }
  
  public static String b()
  {
    if (jdField_a_of_type_Lin == null) {
      jdField_a_of_type_Lin = new lin();
    }
    return jdField_a_of_type_Lin.b();
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Lin == null) {
      jdField_a_of_type_Lin = new lin();
    }
    a("setSmallScreenSize: " + paramInt1 + "|" + paramInt2);
    jdField_a_of_type_Lin.b(paramInt1, paramInt2);
  }
  
  private void b(Observable paramObservable, Object paramObject)
  {
    ((Integer)((Object[])(Object[])paramObject)[0]).intValue();
    a(paramObservable, paramObject);
  }
  
  public static void c(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Lin == null) {
      jdField_a_of_type_Lin = new lin();
    }
    a("setBigScreenSize: " + paramInt1 + "|" + paramInt2);
    jdField_a_of_type_Lin.c(paramInt1, paramInt2);
  }
  
  public abstract int a();
  
  protected abstract List<lik> a(lgc paramlgc, boolean paramBoolean);
  
  public lio a()
  {
    return this.jdField_a_of_type_Lio;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Lim = new lim(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lim);
  }
  
  protected void a(Observable paramObservable, Object paramObject) {}
  
  public void a(lgc paramlgc)
  {
    if ((paramlgc == null) || (TextUtils.isEmpty(paramlgc.jdField_a_of_type_JavaLangCharSequence)) || (TextUtils.isEmpty(paramlgc.jdField_a_of_type_JavaLangString)))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("updateText error:");
      if (paramlgc == null) {}
      for (paramlgc = null;; paramlgc = paramlgc.toString())
      {
        lba.h("ARZimuTask", paramlgc);
        return;
      }
    }
    lba.f("ARZimuTask", "updateText :" + paramlgc.toString());
    if (!this.jdField_a_of_type_Lir.a()) {
      this.jdField_a_of_type_Lir.b("updateText1", true);
    }
    a(paramlgc, false);
  }
  
  abstract void a(lik paramlik);
  
  public void a(lio paramlio)
  {
    this.jdField_a_of_type_Lio = paramlio;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Lim != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lim);
    }
  }
  
  public String c()
  {
    Object localObject = d();
    localObject = (ZimuItem)this.jdField_a_of_type_Lir.a((String)localObject);
    if (localObject != null) {}
    for (localObject = this.jdField_a_of_type_Lir.b((lgl)localObject);; localObject = "")
    {
      lba.f("ARZimuTask", "getGamePlayResoucePath path = " + (String)localObject);
      return localObject;
    }
  }
  
  protected void c()
  {
    String str;
    Object localObject;
    if ((this.jdField_a_of_type_AndroidGraphicsTypeface == null) && (this.jdField_a_of_type_Lir != null))
    {
      str = d();
      localObject = (ZimuItem)this.jdField_a_of_type_Lir.a(str);
      if (localObject != null)
      {
        localObject = this.jdField_a_of_type_Lir.b((lgl)localObject);
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
 * Qualified Name:     lil
 * JD-Core Version:    0.7.0.1
 */