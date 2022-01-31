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

public abstract class llm
{
  private static llo a;
  protected Typeface a;
  protected VideoAppInterface a;
  protected final List<lll> a;
  protected lln a;
  protected llp a;
  protected lls a;
  
  public llm(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_Lls = ((lls)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0));
    paramVideoAppInterface = d();
    this.jdField_a_of_type_Lls.a(paramLong, paramVideoAppInterface);
  }
  
  public static PointF a(PointF paramPointF)
  {
    if (jdField_a_of_type_Llo == null) {
      jdField_a_of_type_Llo = new llo();
    }
    a("static getSmallPointInBigScreen: " + paramPointF.x + "|" + paramPointF.y);
    return jdField_a_of_type_Llo.a(paramPointF);
  }
  
  public static String a()
  {
    if (jdField_a_of_type_Llo == null) {
      jdField_a_of_type_Llo = new llo();
    }
    return jdField_a_of_type_Llo.a();
  }
  
  public static void a(int paramInt)
  {
    if (jdField_a_of_type_Llo == null) {
      jdField_a_of_type_Llo = new llo();
    }
    a("getSmallScreenPositionType: " + paramInt);
    jdField_a_of_type_Llo.a(paramInt);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Llo == null) {
      jdField_a_of_type_Llo = new llo();
    }
    a("UpdateSmallScreenPosition: " + paramInt1 + "|" + paramInt2);
    jdField_a_of_type_Llo.a(paramInt1, paramInt2);
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
    if (jdField_a_of_type_Llo == null) {
      jdField_a_of_type_Llo = new llo();
    }
    jdField_a_of_type_Llo.a(paramString1, paramString2);
  }
  
  private void a(ljf paramljf, boolean paramBoolean)
  {
    Object localObject1 = null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    Object localObject3;
    while (localIterator.hasNext())
    {
      localObject3 = (lll)localIterator.next();
      localObject2 = localObject1;
      int j = i;
      if (!((lll)localObject3).a.a())
      {
        localObject2 = localObject1;
        j = i;
        if (((lll)localObject3).a.jdField_a_of_type_JavaLangString.equals(paramljf.jdField_a_of_type_JavaLangString))
        {
          j = 1;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localObject3;
          }
          ((lll)localObject3).a(paramljf);
          lek.c("ARZimuTask", "updateTextInner " + paramljf.jdField_a_of_type_JavaLangString + " onTextChanged info:" + paramljf.jdField_a_of_type_JavaLangCharSequence);
        }
      }
      i = j;
      localObject1 = localObject2;
    }
    Object localObject2 = localObject1;
    if (i == 0)
    {
      localObject3 = a(paramljf, paramBoolean);
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = localObject1;
          if (((List)localObject3).size() > 0) {
            localObject2 = (lll)((List)localObject3).get(0);
          }
        }
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject3);
        lek.c("ARZimuTask", "updateTextInner " + paramljf.jdField_a_of_type_JavaLangString + " addinfo:" + paramljf.jdField_a_of_type_JavaLangCharSequence);
      }
    }
    a((lll)localObject2);
  }
  
  public static void a(boolean paramBoolean)
  {
    if (jdField_a_of_type_Llo == null) {
      jdField_a_of_type_Llo = new llo();
    }
    jdField_a_of_type_Llo.a(paramBoolean);
  }
  
  public static String b()
  {
    if (jdField_a_of_type_Llo == null) {
      jdField_a_of_type_Llo = new llo();
    }
    return jdField_a_of_type_Llo.b();
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Llo == null) {
      jdField_a_of_type_Llo = new llo();
    }
    a("setSmallScreenSize: " + paramInt1 + "|" + paramInt2);
    jdField_a_of_type_Llo.b(paramInt1, paramInt2);
  }
  
  private void b(Observable paramObservable, Object paramObject)
  {
    ((Integer)((Object[])(Object[])paramObject)[0]).intValue();
    a(paramObservable, paramObject);
  }
  
  public static void c(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Llo == null) {
      jdField_a_of_type_Llo = new llo();
    }
    a("setBigScreenSize: " + paramInt1 + "|" + paramInt2);
    jdField_a_of_type_Llo.c(paramInt1, paramInt2);
  }
  
  public abstract int a();
  
  protected abstract List<lll> a(ljf paramljf, boolean paramBoolean);
  
  public llp a()
  {
    return this.jdField_a_of_type_Llp;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Lln = new lln(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lln);
  }
  
  protected void a(Observable paramObservable, Object paramObject) {}
  
  public void a(ljf paramljf)
  {
    if ((paramljf == null) || (TextUtils.isEmpty(paramljf.jdField_a_of_type_JavaLangCharSequence)) || (TextUtils.isEmpty(paramljf.jdField_a_of_type_JavaLangString)))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("updateText error:");
      if (paramljf == null) {}
      for (paramljf = null;; paramljf = paramljf.toString())
      {
        lek.e("ARZimuTask", paramljf);
        return;
      }
    }
    lek.c("ARZimuTask", "updateText :" + paramljf.toString());
    if (!this.jdField_a_of_type_Lls.a()) {
      this.jdField_a_of_type_Lls.b("updateText1", true);
    }
    a(paramljf, false);
  }
  
  abstract void a(lll paramlll);
  
  public void a(llp paramllp)
  {
    this.jdField_a_of_type_Llp = paramllp;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Lln != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lln);
    }
  }
  
  public String c()
  {
    Object localObject = d();
    localObject = (ZimuItem)this.jdField_a_of_type_Lls.a((String)localObject);
    if (localObject != null) {}
    for (localObject = this.jdField_a_of_type_Lls.b((ljo)localObject);; localObject = "")
    {
      lek.c("ARZimuTask", "getGamePlayResoucePath path = " + (String)localObject);
      return localObject;
    }
  }
  
  protected void c()
  {
    String str;
    Object localObject;
    if ((this.jdField_a_of_type_AndroidGraphicsTypeface == null) && (this.jdField_a_of_type_Lls != null))
    {
      str = d();
      localObject = (ZimuItem)this.jdField_a_of_type_Lls.a(str);
      if (localObject != null)
      {
        localObject = this.jdField_a_of_type_Lls.b((ljo)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     llm
 * JD-Core Version:    0.7.0.1
 */