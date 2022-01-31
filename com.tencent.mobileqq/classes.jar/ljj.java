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

public abstract class ljj
{
  private static ljl a;
  protected Typeface a;
  protected VideoAppInterface a;
  protected final List<lji> a;
  protected ljk a;
  protected ljm a;
  protected ljp a;
  
  public ljj(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_Ljp = ((ljp)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0));
    paramVideoAppInterface = d();
    this.jdField_a_of_type_Ljp.a(paramLong, paramVideoAppInterface);
  }
  
  public static PointF a(PointF paramPointF)
  {
    if (jdField_a_of_type_Ljl == null) {
      jdField_a_of_type_Ljl = new ljl();
    }
    a("static getSmallPointInBigScreen: " + paramPointF.x + "|" + paramPointF.y);
    return jdField_a_of_type_Ljl.a(paramPointF);
  }
  
  public static String a()
  {
    if (jdField_a_of_type_Ljl == null) {
      jdField_a_of_type_Ljl = new ljl();
    }
    return jdField_a_of_type_Ljl.a();
  }
  
  public static void a(int paramInt)
  {
    if (jdField_a_of_type_Ljl == null) {
      jdField_a_of_type_Ljl = new ljl();
    }
    a("getSmallScreenPositionType: " + paramInt);
    jdField_a_of_type_Ljl.a(paramInt);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Ljl == null) {
      jdField_a_of_type_Ljl = new ljl();
    }
    a("UpdateSmallScreenPosition: " + paramInt1 + "|" + paramInt2);
    jdField_a_of_type_Ljl.a(paramInt1, paramInt2);
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
    if (jdField_a_of_type_Ljl == null) {
      jdField_a_of_type_Ljl = new ljl();
    }
    jdField_a_of_type_Ljl.a(paramString1, paramString2);
  }
  
  private void a(lhc paramlhc, boolean paramBoolean)
  {
    Object localObject1 = null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    Object localObject3;
    while (localIterator.hasNext())
    {
      localObject3 = (lji)localIterator.next();
      localObject2 = localObject1;
      int j = i;
      if (!((lji)localObject3).a.a())
      {
        localObject2 = localObject1;
        j = i;
        if (((lji)localObject3).a.jdField_a_of_type_JavaLangString.equals(paramlhc.jdField_a_of_type_JavaLangString))
        {
          j = 1;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localObject3;
          }
          ((lji)localObject3).a(paramlhc);
          lcg.c("ARZimuTask", "updateTextInner " + paramlhc.jdField_a_of_type_JavaLangString + " onTextChanged info:" + paramlhc.jdField_a_of_type_JavaLangCharSequence);
        }
      }
      i = j;
      localObject1 = localObject2;
    }
    Object localObject2 = localObject1;
    if (i == 0)
    {
      localObject3 = a(paramlhc, paramBoolean);
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = localObject1;
          if (((List)localObject3).size() > 0) {
            localObject2 = (lji)((List)localObject3).get(0);
          }
        }
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject3);
        lcg.c("ARZimuTask", "updateTextInner " + paramlhc.jdField_a_of_type_JavaLangString + " addinfo:" + paramlhc.jdField_a_of_type_JavaLangCharSequence);
      }
    }
    a((lji)localObject2);
  }
  
  public static void a(boolean paramBoolean)
  {
    if (jdField_a_of_type_Ljl == null) {
      jdField_a_of_type_Ljl = new ljl();
    }
    jdField_a_of_type_Ljl.a(paramBoolean);
  }
  
  public static String b()
  {
    if (jdField_a_of_type_Ljl == null) {
      jdField_a_of_type_Ljl = new ljl();
    }
    return jdField_a_of_type_Ljl.b();
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Ljl == null) {
      jdField_a_of_type_Ljl = new ljl();
    }
    a("setSmallScreenSize: " + paramInt1 + "|" + paramInt2);
    jdField_a_of_type_Ljl.b(paramInt1, paramInt2);
  }
  
  private void b(Observable paramObservable, Object paramObject)
  {
    ((Integer)((Object[])(Object[])paramObject)[0]).intValue();
    a(paramObservable, paramObject);
  }
  
  public static void c(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Ljl == null) {
      jdField_a_of_type_Ljl = new ljl();
    }
    a("setBigScreenSize: " + paramInt1 + "|" + paramInt2);
    jdField_a_of_type_Ljl.c(paramInt1, paramInt2);
  }
  
  public abstract int a();
  
  protected abstract List<lji> a(lhc paramlhc, boolean paramBoolean);
  
  public ljm a()
  {
    return this.jdField_a_of_type_Ljm;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ljk = new ljk(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Ljk);
  }
  
  protected void a(Observable paramObservable, Object paramObject) {}
  
  public void a(lhc paramlhc)
  {
    if ((paramlhc == null) || (TextUtils.isEmpty(paramlhc.jdField_a_of_type_JavaLangCharSequence)) || (TextUtils.isEmpty(paramlhc.jdField_a_of_type_JavaLangString)))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("updateText error:");
      if (paramlhc == null) {}
      for (paramlhc = null;; paramlhc = paramlhc.toString())
      {
        lcg.e("ARZimuTask", paramlhc);
        return;
      }
    }
    lcg.c("ARZimuTask", "updateText :" + paramlhc.toString());
    if (!this.jdField_a_of_type_Ljp.a()) {
      this.jdField_a_of_type_Ljp.b("updateText1", true);
    }
    a(paramlhc, false);
  }
  
  abstract void a(lji paramlji);
  
  public void a(ljm paramljm)
  {
    this.jdField_a_of_type_Ljm = paramljm;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Ljk != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Ljk);
    }
  }
  
  public String c()
  {
    Object localObject = d();
    localObject = (ZimuItem)this.jdField_a_of_type_Ljp.a((String)localObject);
    if (localObject != null) {}
    for (localObject = this.jdField_a_of_type_Ljp.b((lhl)localObject);; localObject = "")
    {
      lcg.c("ARZimuTask", "getGamePlayResoucePath path = " + (String)localObject);
      return localObject;
    }
  }
  
  protected void c()
  {
    String str;
    Object localObject;
    if ((this.jdField_a_of_type_AndroidGraphicsTypeface == null) && (this.jdField_a_of_type_Ljp != null))
    {
      str = d();
      localObject = (ZimuItem)this.jdField_a_of_type_Ljp.a(str);
      if (localObject != null)
      {
        localObject = this.jdField_a_of_type_Ljp.b((lhl)localObject);
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
 * Qualified Name:     ljj
 * JD-Core Version:    0.7.0.1
 */