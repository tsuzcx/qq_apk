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

public abstract class lix
{
  private static liz a;
  protected Typeface a;
  protected VideoAppInterface a;
  protected final List<liw> a;
  protected liy a;
  protected lja a;
  protected ljd a;
  
  public lix(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_Ljd = ((ljd)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0));
    paramVideoAppInterface = d();
    this.jdField_a_of_type_Ljd.a(paramLong, paramVideoAppInterface);
  }
  
  public static PointF a(PointF paramPointF)
  {
    if (jdField_a_of_type_Liz == null) {
      jdField_a_of_type_Liz = new liz();
    }
    a("static getSmallPointInBigScreen: " + paramPointF.x + "|" + paramPointF.y);
    return jdField_a_of_type_Liz.a(paramPointF);
  }
  
  public static String a()
  {
    if (jdField_a_of_type_Liz == null) {
      jdField_a_of_type_Liz = new liz();
    }
    return jdField_a_of_type_Liz.a();
  }
  
  public static void a(int paramInt)
  {
    if (jdField_a_of_type_Liz == null) {
      jdField_a_of_type_Liz = new liz();
    }
    a("getSmallScreenPositionType: " + paramInt);
    jdField_a_of_type_Liz.a(paramInt);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Liz == null) {
      jdField_a_of_type_Liz = new liz();
    }
    a("UpdateSmallScreenPosition: " + paramInt1 + "|" + paramInt2);
    jdField_a_of_type_Liz.a(paramInt1, paramInt2);
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
    if (jdField_a_of_type_Liz == null) {
      jdField_a_of_type_Liz = new liz();
    }
    jdField_a_of_type_Liz.a(paramString1, paramString2);
  }
  
  private void a(lgo paramlgo, boolean paramBoolean)
  {
    Object localObject1 = null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    Object localObject3;
    while (localIterator.hasNext())
    {
      localObject3 = (liw)localIterator.next();
      localObject2 = localObject1;
      int j = i;
      if (!((liw)localObject3).a.a())
      {
        localObject2 = localObject1;
        j = i;
        if (((liw)localObject3).a.jdField_a_of_type_JavaLangString.equals(paramlgo.jdField_a_of_type_JavaLangString))
        {
          j = 1;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localObject3;
          }
          ((liw)localObject3).a(paramlgo);
          lbd.f("ARZimuTask", "updateTextInner " + paramlgo.jdField_a_of_type_JavaLangString + " onTextChanged info:" + paramlgo.jdField_a_of_type_JavaLangCharSequence);
        }
      }
      i = j;
      localObject1 = localObject2;
    }
    Object localObject2 = localObject1;
    if (i == 0)
    {
      localObject3 = a(paramlgo, paramBoolean);
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = localObject1;
          if (((List)localObject3).size() > 0) {
            localObject2 = (liw)((List)localObject3).get(0);
          }
        }
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject3);
        lbd.f("ARZimuTask", "updateTextInner " + paramlgo.jdField_a_of_type_JavaLangString + " addinfo:" + paramlgo.jdField_a_of_type_JavaLangCharSequence);
      }
    }
    a((liw)localObject2);
  }
  
  public static void a(boolean paramBoolean)
  {
    if (jdField_a_of_type_Liz == null) {
      jdField_a_of_type_Liz = new liz();
    }
    jdField_a_of_type_Liz.a(paramBoolean);
  }
  
  public static String b()
  {
    if (jdField_a_of_type_Liz == null) {
      jdField_a_of_type_Liz = new liz();
    }
    return jdField_a_of_type_Liz.b();
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Liz == null) {
      jdField_a_of_type_Liz = new liz();
    }
    a("setSmallScreenSize: " + paramInt1 + "|" + paramInt2);
    jdField_a_of_type_Liz.b(paramInt1, paramInt2);
  }
  
  private void b(Observable paramObservable, Object paramObject)
  {
    ((Integer)((Object[])(Object[])paramObject)[0]).intValue();
    a(paramObservable, paramObject);
  }
  
  public static void c(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Liz == null) {
      jdField_a_of_type_Liz = new liz();
    }
    a("setBigScreenSize: " + paramInt1 + "|" + paramInt2);
    jdField_a_of_type_Liz.c(paramInt1, paramInt2);
  }
  
  public abstract int a();
  
  protected abstract List<liw> a(lgo paramlgo, boolean paramBoolean);
  
  public lja a()
  {
    return this.jdField_a_of_type_Lja;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Liy = new liy(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Liy);
  }
  
  protected void a(Observable paramObservable, Object paramObject) {}
  
  public void a(lgo paramlgo)
  {
    if ((paramlgo == null) || (TextUtils.isEmpty(paramlgo.jdField_a_of_type_JavaLangCharSequence)) || (TextUtils.isEmpty(paramlgo.jdField_a_of_type_JavaLangString)))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("updateText error:");
      if (paramlgo == null) {}
      for (paramlgo = null;; paramlgo = paramlgo.toString())
      {
        lbd.h("ARZimuTask", paramlgo);
        return;
      }
    }
    lbd.f("ARZimuTask", "updateText :" + paramlgo.toString());
    if (!this.jdField_a_of_type_Ljd.a()) {
      this.jdField_a_of_type_Ljd.b("updateText1", true);
    }
    a(paramlgo, false);
  }
  
  abstract void a(liw paramliw);
  
  public void a(lja paramlja)
  {
    this.jdField_a_of_type_Lja = paramlja;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Liy != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Liy);
    }
  }
  
  public String c()
  {
    Object localObject = d();
    localObject = (ZimuItem)this.jdField_a_of_type_Ljd.a((String)localObject);
    if (localObject != null) {}
    for (localObject = this.jdField_a_of_type_Ljd.b((lgx)localObject);; localObject = "")
    {
      lbd.f("ARZimuTask", "getGamePlayResoucePath path = " + (String)localObject);
      return localObject;
    }
  }
  
  protected void c()
  {
    String str;
    Object localObject;
    if ((this.jdField_a_of_type_AndroidGraphicsTypeface == null) && (this.jdField_a_of_type_Ljd != null))
    {
      str = d();
      localObject = (ZimuItem)this.jdField_a_of_type_Ljd.a(str);
      if (localObject != null)
      {
        localObject = this.jdField_a_of_type_Ljd.b((lgx)localObject);
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
 * Qualified Name:     lix
 * JD-Core Version:    0.7.0.1
 */