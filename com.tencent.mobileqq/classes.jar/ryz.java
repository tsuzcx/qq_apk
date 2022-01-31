import android.os.Handler;
import android.os.Looper;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class ryz
  implements ryn
{
  private static Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  protected static final ryv a;
  public static boolean a;
  public int a;
  public long a;
  public transient UniAttribute a;
  public Object a;
  public transient String a;
  private WeakReference<Handler> jdField_a_of_type_JavaLangRefWeakReference;
  public HashMap<Object, Object> a;
  public transient ryo a;
  public ryp a;
  public ryw a;
  public int b;
  public int c;
  public int d;
  
  static
  {
    jdField_a_of_type_Ryv = ryv.a();
  }
  
  public ryz()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public ryz(ryw paramryw, Handler paramHandler, ryo paramryo, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Ryw = paramryw;
    this.c = paramInt;
    this.jdField_a_of_type_Ryo = paramryo;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (paramHandler != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramHandler);
    }
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    case 1000005: 
    default: 
      return "";
    case 1000006: 
      QZLog.i("QZLog", 1, "weishi\t 网络无连接");
      return QzoneConfig.getInstance().getConfig("QZoneTextSetting", "NetWorkNotConnect", "网络无连接");
    case 1000004: 
      return "";
    }
    return "";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ryw != null)
    {
      this.jdField_a_of_type_Ryw.a(this.d);
      if (jdField_a_of_type_Boolean)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if (this.jdField_a_of_type_Ryw.a != null) {
          this.jdField_a_of_type_Ryw.a.display(localStringBuilder, 0);
        }
      }
    }
    int i = jdField_a_of_type_Ryv.a(this.jdField_a_of_type_Ryw, this);
    if (i != 0) {
      a(null, i, i, a(i), false, this.jdField_a_of_type_Ryp);
    }
  }
  
  public void a(Object paramObject, int paramInt1, int paramInt2, String paramString, boolean paramBoolean, ryp paramryp)
  {
    if ((paramObject instanceof UniAttribute)) {
      this.jdField_a_of_type_ComQqJceWupUniAttribute = ((UniAttribute)paramObject);
    }
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.b = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Ryp = paramryp;
    if (1000006 == paramInt1) {
      this.jdField_a_of_type_JavaLangString = ajjy.a(2131651127);
    }
    rys.a().b(this);
  }
  
  public boolean a()
  {
    return (this.b == 0) || (this.b == 1000) || ((Math.abs(this.b) <= 19999) && (Math.abs(this.b) >= 19000));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ryz
 * JD-Core Version:    0.7.0.1
 */