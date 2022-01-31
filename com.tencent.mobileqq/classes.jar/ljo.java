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

public abstract class ljo
{
  private static ljq a;
  protected Typeface a;
  protected VideoAppInterface a;
  protected final List<ljn> a;
  protected ljp a;
  protected ljr a;
  protected lju a;
  
  public ljo(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_Lju = ((lju)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0));
    paramVideoAppInterface = d();
    this.jdField_a_of_type_Lju.a(paramLong, paramVideoAppInterface);
  }
  
  public static PointF a(PointF paramPointF)
  {
    if (jdField_a_of_type_Ljq == null) {
      jdField_a_of_type_Ljq = new ljq();
    }
    a("static getSmallPointInBigScreen: " + paramPointF.x + "|" + paramPointF.y);
    return jdField_a_of_type_Ljq.a(paramPointF);
  }
  
  public static String a()
  {
    if (jdField_a_of_type_Ljq == null) {
      jdField_a_of_type_Ljq = new ljq();
    }
    return jdField_a_of_type_Ljq.a();
  }
  
  public static void a(int paramInt)
  {
    if (jdField_a_of_type_Ljq == null) {
      jdField_a_of_type_Ljq = new ljq();
    }
    a("getSmallScreenPositionType: " + paramInt);
    jdField_a_of_type_Ljq.a(paramInt);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Ljq == null) {
      jdField_a_of_type_Ljq = new ljq();
    }
    a("UpdateSmallScreenPosition: " + paramInt1 + "|" + paramInt2);
    jdField_a_of_type_Ljq.a(paramInt1, paramInt2);
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
    if (jdField_a_of_type_Ljq == null) {
      jdField_a_of_type_Ljq = new ljq();
    }
    jdField_a_of_type_Ljq.a(paramString1, paramString2);
  }
  
  private void a(lhh paramlhh, boolean paramBoolean)
  {
    Object localObject1 = null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    Object localObject3;
    while (localIterator.hasNext())
    {
      localObject3 = (ljn)localIterator.next();
      localObject2 = localObject1;
      int j = i;
      if (!((ljn)localObject3).a.a())
      {
        localObject2 = localObject1;
        j = i;
        if (((ljn)localObject3).a.jdField_a_of_type_JavaLangString.equals(paramlhh.jdField_a_of_type_JavaLangString))
        {
          j = 1;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localObject3;
          }
          ((ljn)localObject3).a(paramlhh);
          lcl.c("ARZimuTask", "updateTextInner " + paramlhh.jdField_a_of_type_JavaLangString + " onTextChanged info:" + paramlhh.jdField_a_of_type_JavaLangCharSequence);
        }
      }
      i = j;
      localObject1 = localObject2;
    }
    Object localObject2 = localObject1;
    if (i == 0)
    {
      localObject3 = a(paramlhh, paramBoolean);
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = localObject1;
          if (((List)localObject3).size() > 0) {
            localObject2 = (ljn)((List)localObject3).get(0);
          }
        }
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject3);
        lcl.c("ARZimuTask", "updateTextInner " + paramlhh.jdField_a_of_type_JavaLangString + " addinfo:" + paramlhh.jdField_a_of_type_JavaLangCharSequence);
      }
    }
    a((ljn)localObject2);
  }
  
  public static void a(boolean paramBoolean)
  {
    if (jdField_a_of_type_Ljq == null) {
      jdField_a_of_type_Ljq = new ljq();
    }
    jdField_a_of_type_Ljq.a(paramBoolean);
  }
  
  public static String b()
  {
    if (jdField_a_of_type_Ljq == null) {
      jdField_a_of_type_Ljq = new ljq();
    }
    return jdField_a_of_type_Ljq.b();
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Ljq == null) {
      jdField_a_of_type_Ljq = new ljq();
    }
    a("setSmallScreenSize: " + paramInt1 + "|" + paramInt2);
    jdField_a_of_type_Ljq.b(paramInt1, paramInt2);
  }
  
  private void b(Observable paramObservable, Object paramObject)
  {
    ((Integer)((Object[])(Object[])paramObject)[0]).intValue();
    a(paramObservable, paramObject);
  }
  
  public static void c(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Ljq == null) {
      jdField_a_of_type_Ljq = new ljq();
    }
    a("setBigScreenSize: " + paramInt1 + "|" + paramInt2);
    jdField_a_of_type_Ljq.c(paramInt1, paramInt2);
  }
  
  public abstract int a();
  
  protected abstract List<ljn> a(lhh paramlhh, boolean paramBoolean);
  
  public ljr a()
  {
    return this.jdField_a_of_type_Ljr;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ljp = new ljp(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Ljp);
  }
  
  protected void a(Observable paramObservable, Object paramObject) {}
  
  public void a(lhh paramlhh)
  {
    if ((paramlhh == null) || (TextUtils.isEmpty(paramlhh.jdField_a_of_type_JavaLangCharSequence)) || (TextUtils.isEmpty(paramlhh.jdField_a_of_type_JavaLangString)))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("updateText error:");
      if (paramlhh == null) {}
      for (paramlhh = null;; paramlhh = paramlhh.toString())
      {
        lcl.e("ARZimuTask", paramlhh);
        return;
      }
    }
    lcl.c("ARZimuTask", "updateText :" + paramlhh.toString());
    if (!this.jdField_a_of_type_Lju.a()) {
      this.jdField_a_of_type_Lju.b("updateText1", true);
    }
    a(paramlhh, false);
  }
  
  abstract void a(ljn paramljn);
  
  public void a(ljr paramljr)
  {
    this.jdField_a_of_type_Ljr = paramljr;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Ljp != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Ljp);
    }
  }
  
  public String c()
  {
    Object localObject = d();
    localObject = (ZimuItem)this.jdField_a_of_type_Lju.a((String)localObject);
    if (localObject != null) {}
    for (localObject = this.jdField_a_of_type_Lju.b((lhq)localObject);; localObject = "")
    {
      lcl.c("ARZimuTask", "getGamePlayResoucePath path = " + (String)localObject);
      return localObject;
    }
  }
  
  protected void c()
  {
    String str;
    Object localObject;
    if ((this.jdField_a_of_type_AndroidGraphicsTypeface == null) && (this.jdField_a_of_type_Lju != null))
    {
      str = d();
      localObject = (ZimuItem)this.jdField_a_of_type_Lju.a(str);
      if (localObject != null)
      {
        localObject = this.jdField_a_of_type_Lju.b((lhq)localObject);
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
 * Qualified Name:     ljo
 * JD-Core Version:    0.7.0.1
 */